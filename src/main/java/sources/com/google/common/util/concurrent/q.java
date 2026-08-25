package com.google.common.util.concurrent;

import java.util.logging.Logger;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class q {
    private final Object a = new Object();
    private final String b;
    private volatile Logger c;

    q(Class cls) {
        this.b = cls.getName();
    }

    Logger a() {
        Logger logger = this.c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.a) {
            try {
                Logger logger2 = this.c;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.b);
                this.c = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
