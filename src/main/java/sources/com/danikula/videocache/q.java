package com.danikula.videocache;

import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class q {
    private static boolean a;

    public static void a(String str) {
    }

    public static void b(String str) {
        if (a) {
            Log.e("Download_VideoCache", str);
        }
    }

    public static void c(String str) {
    }

    public static void d(boolean z) {
        a = z;
    }

    public static void e(String str) {
        if (a) {
            Log.v("Download_VideoCache", str);
        }
    }

    public static void f(String str) {
        if (a) {
            Log.w("Download_VideoCache", str);
        }
    }
}
