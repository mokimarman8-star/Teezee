#!/usr/bin/env bash
set -Eeuo pipefail

# The authoritative reproducible Teezee build is the root packaging script.
# This wrapper intentionally stays inside the same repository and does not
# create or require a second project, local decoded input tree, or private key.
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"

VERSION="${1:-}"
if [[ -n "$VERSION" ]]; then
  exec "$ROOT_DIR/scripts/build.sh" "$VERSION"
fi
exec "$ROOT_DIR/scripts/build.sh"
