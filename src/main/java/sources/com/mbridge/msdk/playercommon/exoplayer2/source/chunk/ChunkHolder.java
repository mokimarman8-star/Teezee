package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ChunkHolder {
    public Chunk chunk;
    public boolean endOfStream;

    public void clear() {
        this.chunk = null;
        this.endOfStream = false;
    }
}
