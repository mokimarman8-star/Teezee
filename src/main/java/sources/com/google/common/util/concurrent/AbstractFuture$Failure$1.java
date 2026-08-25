package com.google.common.util.concurrent;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class AbstractFuture$Failure$1 extends Throwable {
    AbstractFuture$Failure$1(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
