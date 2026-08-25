package com.mbridge.msdk.thrid.okhttp.internal;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class b implements Runnable {
    protected final String a;

    public b(String str, Object... objArr) {
        this.a = c.a(str, objArr);
    }

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.a);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
