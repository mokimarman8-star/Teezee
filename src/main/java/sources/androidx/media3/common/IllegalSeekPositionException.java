package androidx.media3.common;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final e0 timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(e0 e0Var, int i5, long j5) {
        this.timeline = e0Var;
        this.windowIndex = i5;
        this.positionMs = j5;
    }
}
