package com.mbridge.msdk.playercommon.exoplayer2.decoder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class OutputBuffer extends Buffer {
    public int skippedOutputBufferCount;
    public long timeUs;

    public abstract void release();
}
