package com.facebook.biddingkit.logging;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class h {
    private static boolean a;

    public static void a(Context context, String str, String str2, String str3) {
        try {
            a.b(context, str, str2);
            EventLogDispatcher.j(new i(str3));
            f.f(context);
            c.b();
        } catch (Exception e) {
            b.d("Logging", "Failed to initialize", e);
        }
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (h.class) {
            z = a;
        }
        return z;
    }
}
