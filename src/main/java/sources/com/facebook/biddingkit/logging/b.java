package com.facebook.biddingkit.logging;

import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class b {
    public static void a(String str, String str2) {
    }

    public static void b(String str, String str2, Throwable th) {
        h.b();
    }

    public static void c(String str, String str2) {
        e eVar = new e();
        eVar.e(str + ": " + str2);
        eVar.n();
        if (h.b()) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        e eVar = new e();
        eVar.e(str + ": " + str2 + g.a(th));
        eVar.n();
        if (h.b()) {
            Log.e(str, str2, th);
        }
    }
}
