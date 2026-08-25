package com.mbridge.msdk.dycreator.utils;

import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g {
    public static boolean a;

    public static void a(String str) {
        if (a) {
            new SecurityManager();
            Log.e(new Throwable().getStackTrace()[1].getFileName(), str);
        }
    }
}
