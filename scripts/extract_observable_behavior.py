#!/usr/bin/env python3
"""Extract static, non-authenticated behavior evidence from the Teezee package.

This does not contact any endpoint and does not execute APK code. It only reads
tracked text/assets and printable strings from packaged files.
"""
from __future__ import annotations

import json
import re
from collections import Counter
from pathlib import Path
from urllib.parse import urlsplit

ROOT = Path(__file__).resolve().parents[1]
APP = ROOT / "app_source"
OUT = ROOT / "fresh-project" / "docs" / "observable-behavior.md"

url_re = re.compile(r"https?://[A-Za-z0-9][A-Za-z0-9._:/?#@!$&'()*+,;=%-]*")
feature_re = re.compile(r"(?i)(audio|video|player|subtitle|download|favorite|like|follow|language|locale|room|movie|short_tv|trending|search|profile)")
ignored_hosts = {"schemas.android.com", "www.w3.org", "www.apache.org", "developer.android.com"}

files = [p for p in APP.rglob("*") if p.is_file()]
urls: Counter[str] = Counter()
hosts: Counter[str] = Counter()

for path in files:
    try:
        data = path.read_bytes()
    except OSError:
        continue
    if path.suffix.lower() not in {".java", ".smali", ".xml", ".json", ".txt", ".properties", ".gradle", ".kt"}:
        continue
    text = data.decode("utf-8", errors="ignore")
    for line in text.splitlines():
        line = "".join(ch for ch in line if 32 <= ord(ch) < 127)
        for url in url_re.findall(line):
            clean_url = url.rstrip(".,;)]}")
            parsed_host = urlsplit(clean_url).hostname
            if parsed_host and "." in parsed_host and parsed_host.lower() not in ignored_hosts:
                urls[clean_url] += 1
                hosts[parsed_host.lower()] += 1

json_evidence = []
for path in sorted((APP / "assets").glob("*.json")):
    try:
        obj = json.loads(path.read_text(errors="replace"))
    except Exception:
        continue
    keys = sorted(str(k) for k in obj.keys()) if isinstance(obj, dict) else []
    json_evidence.append((str(path.relative_to(ROOT)), keys[:40]))

layout_files = sorted(str(p.relative_to(ROOT)) for p in (APP / "res").glob("layout*/**/*.xml"))
layout_feature_counts = Counter()
for item in layout_files:
    lower = item.lower()
    for token in ("movie", "player", "audio", "video", "subtitle", "download", "like", "follow", "room", "profile", "language", "search", "home"):
        if token in lower:
            layout_feature_counts[token] += 1

lines = [
    "# Teezee observable behavior evidence",
    "",
    "This report is generated from the exact Teezee `app_source/` package inputs in this repository. The extractor is passive: it reads files and printable strings only, makes no network requests, and does not execute APK code.",
    "",
    "## Content-source boundary",
    "",
    "> The APK contains client code, configuration and resource names, but static inspection does not prove that an endpoint is currently live or that it returns any particular movie, episode, recommendation, like or follow result.",
    "",
    "Bundled content includes layouts, icons, animation JSON, JavaScript bridge assets, locale/config JSON and native player/downloader libraries. Network-fetched content is represented only by discovered static URL/host strings and packaged client classes; live catalog content, authenticated data and user state remain runtime-dependent.",
    "",
    "## Static URL and host evidence",
    "",
    "| Evidence | Occurrences | Notes |",
    "|---|---:|---|",
]
for value, count in urls.most_common(80):
    lines.append(f"| `{value}` | {count} | Static packaged string; not contacted or validated by this report. |")
if not urls:
    lines.append("| No URL literals extracted | 0 | URL values may be assembled, encrypted, or stored in binary/config formats. |")
lines += ["", "### Hosts parsed from URL literals", ""]
for value, count in hosts.most_common(80):
    lines.append(f"- `{value}` ({count} occurrence(s))")
if not hosts:
    lines.append("- No host-like strings extracted.")

lines += ["", "## Feature/resource evidence", "", "| Feature token | Matching layout files |", "|---|---:|"]
for token, count in sorted(layout_feature_counts.items()):
    lines.append(f"| `{token}` | {count} |")

lines += ["", "## Configuration and animation assets", "", "| Asset | Top-level JSON keys |", "|---|---|"]
for name, keys in json_evidence:
    key_text = ", ".join(f"`{k}`" for k in keys) if keys else "(array/scalar or no top-level keys)"
    lines.append(f"| `{name}` | {key_text} |")

lines += ["", "## Interpretation", "", "- **UI/UX:** layout filenames and resources show families for home, movie/short-TV, player, subtitle/audio, search, rooms/community, profiles and downloads.", "- **Media:** the package includes player views, Exo/Media3 resources and native codecs/downloader libraries; playback URLs and authorization are runtime-dependent.", "- **Likes/follows/downloads:** matching screens and client code are packaged, but server-side mutation success cannot be established without a real account/session.", "- **Languages:** locale/resource variants and language-related client code are packaged; the complete live language catalog may be fetched.", ""]
OUT.write_text("\n".join(lines))
print(OUT)
