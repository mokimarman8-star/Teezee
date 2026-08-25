package com.facebook.biddingkit.logging;

import android.os.Process;
import android.text.TextUtils;
import java.lang.Thread;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class c implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler a;

    public c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    private void a(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            c();
        }
    }

    static void b() {
        Thread.setDefaultUncaughtExceptionHandler(new c(Thread.getDefaultUncaughtExceptionHandler()));
    }

    private static void c() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
        try {
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a = g.a(th);
            if (!TextUtils.isEmpty(a) && a.contains("com.facebook.biddingkit")) {
                b.c("CrashReportHandler", a);
            }
        } catch (Exception unused) {
        }
        a(thread, th);
    }
}
