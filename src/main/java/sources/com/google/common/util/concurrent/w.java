package com.google.common.util.concurrent;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class w {
    static boolean a(Throwable th, Class cls) {
        return cls.isInstance(th);
    }

    static void b(Throwable th) {
        com.google.common.base.m.o(th);
        if (th instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
