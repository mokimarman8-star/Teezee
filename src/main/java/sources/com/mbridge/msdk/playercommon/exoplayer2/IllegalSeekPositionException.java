package com.mbridge.msdk.playercommon.exoplayer2;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final Timeline timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(Timeline timeline, int i, long j) {
        this.timeline = timeline;
        this.windowIndex = i;
        this.positionMs = j;
    }
}
