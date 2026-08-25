package com.amazonaws;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AbortedException extends AmazonClientException {
    private static final long serialVersionUID = 1;

    public AbortedException() {
        super("");
    }

    public AbortedException(String str) {
        super(str);
    }

    public AbortedException(String str, Throwable th) {
        super(str, th);
    }

    public AbortedException(Throwable th) {
        super("", th);
    }

    @Override // com.amazonaws.AmazonClientException
    public boolean isRetryable() {
        return false;
    }
}
