package androidx.core.os;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String str) {
        super(androidx.core.util.d.e(str, "The operation has been canceled."));
    }
}
