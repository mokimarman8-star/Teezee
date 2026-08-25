package com.google.common.util.concurrent;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class y extends AbstractFuture$h {
    private y() {
    }

    public static y s() {
        return new y();
    }

    public boolean set(Object obj) {
        return super.set(obj);
    }

    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    public boolean setFuture(r rVar) {
        return super.setFuture(rVar);
    }
}
