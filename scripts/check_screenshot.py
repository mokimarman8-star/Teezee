#!/usr/bin/env python3
import sys
from pathlib import Path
from PIL import Image, ImageStat

if len(sys.argv) != 2:
    raise SystemExit("usage: check_screenshot.py SCREENSHOT")
path = Path(sys.argv[1])
if not path.exists() or path.stat().st_size < 100:
    print("NO_SCREENSHOT")
    raise SystemExit(0)
try:
    image = Image.open(path).convert("RGB")
except Exception:
    print("INVALID_SCREENSHOT")
    raise SystemExit(0)
stat = ImageStat.Stat(image)
mean = sum(stat.mean) / 3
nonblack = sum(1 for px in image.resize((64, 64)).getdata() if max(px) > 12)
ratio = nonblack / 4096
print(f"mean_luma={mean:.2f} nonblack_ratio={ratio:.4f}")
print("BLACK_SCREEN" if mean < 2.0 and ratio < 0.01 else "VISIBLE_PIXELS")
