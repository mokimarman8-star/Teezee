#!/usr/bin/env python3
import subprocess
import re
import sys

def get_latest_tag():
    try:
        # Fetch tags from remote
        subprocess.run(["git", "fetch", "--tags", "--force"], check=False, capture_output=True)
        result = subprocess.run(["git", "tag", "-l", "v*"], check=True, capture_output=True, text=True)
        tags = [t.strip() for t in result.stdout.strip().splitlines() if t.strip()]
        
        valid_tags = []
        for t in tags:
            match = re.match(r"^v?(\d+)\.(\d+)\.(\d+)$", t)
            if match:
                major, minor, patch = map(int, match.groups())
                valid_tags.append((major, minor, patch, t))
                
        if not valid_tags:
            return None
            
        valid_tags.sort(key=lambda x: (x[0], x[1], x[2]))
        return valid_tags[-1]
    except Exception as e:
        print(f"[-] Error getting tags: {e}", file=sys.stderr)
        return None

def next_version(bump_type="patch"):
    latest = get_latest_tag()
    if latest is None:
        return "1.0.2"
    
    major, minor, patch, raw = latest
    if bump_type == "major":
        return f"{major + 1}.0.0"
    elif bump_type == "minor":
        return f"{major}.{minor + 1}.0"
    else:
        return f"{major}.{minor}.{patch + 1}"

if __name__ == "__main__":
    bump = sys.argv[1] if len(sys.argv) > 1 else "patch"
    print(next_version(bump))
