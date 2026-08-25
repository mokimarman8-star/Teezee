package com.google.common.base;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(String str) {
        super(str);
    }

    public VerifyException(String str, Throwable th) {
        super(str, th);
    }

    public VerifyException(Throwable th) {
        super(th);
    }
}
