package org.chromium.net;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class QuicException extends NetworkException {
    protected QuicException(String str, Throwable th) {
        super(str, th);
    }

    public abstract int getQuicDetailedErrorCode();
}
