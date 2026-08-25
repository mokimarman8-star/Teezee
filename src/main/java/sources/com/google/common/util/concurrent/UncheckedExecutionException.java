package com.google.common.util.concurrent;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    @Deprecated
    protected UncheckedExecutionException() {
    }

    @Deprecated
    protected UncheckedExecutionException(String str) {
        super(str);
    }

    public UncheckedExecutionException(String str, Throwable th) {
        super(str, th);
    }

    public UncheckedExecutionException(Throwable th) {
        super(th);
    }
}
