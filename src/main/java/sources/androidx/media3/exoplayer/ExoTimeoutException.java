package androidx.media3.exoplayer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ExoTimeoutException extends RuntimeException {
    public static final int TIMEOUT_OPERATION_DETACH_SURFACE = 3;
    public static final int TIMEOUT_OPERATION_RELEASE = 1;
    public static final int TIMEOUT_OPERATION_SET_FOREGROUND_MODE = 2;
    public static final int TIMEOUT_OPERATION_UNDEFINED = 0;
    public final int timeoutOperation;

    public ExoTimeoutException(int i5) {
        super(getErrorMessage(i5));
        this.timeoutOperation = i5;
    }

    private static String getErrorMessage(int i5) {
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? "Undefined timeout." : "Detaching surface timed out." : "Setting foreground mode timed out." : "Player release timed out.";
    }
}
