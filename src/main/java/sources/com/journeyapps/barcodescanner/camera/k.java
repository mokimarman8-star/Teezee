package com.journeyapps.barcodescanner.camera;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class k {
    private static k e;
    private Handler a;
    private HandlerThread b;
    private int c = 0;
    private final Object d = new Object();

    private k() {
    }

    private void a() {
        synchronized (this.d) {
            try {
                if (this.a == null) {
                    if (this.c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.b = handlerThread;
                    handlerThread.start();
                    this.a = new Handler(this.b.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static k d() {
        if (e == null) {
            e = new k();
        }
        return e;
    }

    private void f() {
        synchronized (this.d) {
            this.b.quit();
            this.b = null;
            this.a = null;
        }
    }

    protected void b() {
        synchronized (this.d) {
            try {
                int i = this.c - 1;
                this.c = i;
                if (i == 0) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void c(Runnable runnable) {
        synchronized (this.d) {
            a();
            this.a.post(runnable);
        }
    }

    protected void e(Runnable runnable) {
        synchronized (this.d) {
            this.c++;
            c(runnable);
        }
    }
}
