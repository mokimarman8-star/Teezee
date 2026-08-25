package com.blankj.utilcode.util;

import android.os.Vibrator;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class f0 {
    private static Vibrator a;

    private static Vibrator a() {
        if (a == null) {
            a = (Vibrator) Utils.a().getSystemService("vibrator");
        }
        return a;
    }

    public static void b(long j) {
        Vibrator a2 = a();
        if (a2 == null) {
            return;
        }
        a2.vibrate(j);
    }
}
