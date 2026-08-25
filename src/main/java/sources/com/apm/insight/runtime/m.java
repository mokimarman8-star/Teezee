package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class m {
    private static volatile p a;
    private static volatile Handler b;

    public static p a() {
        if (a == null) {
            b();
        }
        return a;
    }

    private static HandlerThread b() {
        if (a == null) {
            synchronized (m.class) {
                try {
                    if (a == null) {
                        p pVar = new p("default_npth_thread");
                        a = pVar;
                        pVar.b();
                    }
                } finally {
                }
            }
        }
        return a.c();
    }
}
