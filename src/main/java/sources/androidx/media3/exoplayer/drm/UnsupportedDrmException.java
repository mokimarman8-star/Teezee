package androidx.media3.exoplayer.drm;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class UnsupportedDrmException extends Exception {
    public static final int REASON_INSTANTIATION_ERROR = 2;
    public static final int REASON_UNSUPPORTED_SCHEME = 1;
    public final int reason;

    public UnsupportedDrmException(int i5) {
        this.reason = i5;
    }

    public UnsupportedDrmException(int i5, Exception exc) {
        super(exc);
        this.reason = i5;
    }
}
