package com.google.firebase.crashlytics.internal.common;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class b0 implements Thread.UncaughtExceptionHandler {
    private final a a;
    private final yb.b b;
    private final Thread.UncaughtExceptionHandler c;
    private final qb.a d;
    private final AtomicBoolean e = new AtomicBoolean(false);

    interface a {
        void a(yb.b bVar, Thread thread, Throwable th);
    }

    public b0(a aVar, yb.b bVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, qb.a aVar2) {
        this.a = aVar;
        this.b = bVar;
        this.c = uncaughtExceptionHandler;
        this.d = aVar2;
    }

    private boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            qb.g.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th == null) {
            qb.g.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.d.b()) {
            return true;
        }
        qb.g.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
        return false;
    }

    boolean a() {
        return this.e.get();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
    
        r7.e.set(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0055, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        qb.g.f().b("Completed exception processing, but no default exception handler.");
        java.lang.System.exit(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (r7.c == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7.c != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
    
        qb.g.f().b("Completed exception processing. Invoking default exception handler.");
        r7.c.uncaughtException(r8, r9);
     */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        this.e.set(true);
        try {
            try {
                if (b(thread, th)) {
                    this.a.a(this.b, thread, th);
                } else {
                    qb.g.f().b("Uncaught exception will not be recorded by Crashlytics.");
                }
            } catch (Exception e) {
                qb.g.f().e("An error occurred in the uncaught exception handler", e);
            }
        } catch (Throwable th2) {
            if (this.c != null) {
                qb.g.f().b("Completed exception processing. Invoking default exception handler.");
                this.c.uncaughtException(thread, th);
            } else {
                qb.g.f().b("Completed exception processing, but no default exception handler.");
                System.exit(1);
            }
            this.e.set(false);
            throw th2;
        }
    }
}
