package com.transsion.startup.pref.anr;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final void a(String msg) {
        Intrinsics.h(msg, "msg");
        Log.w("zxb_log_consume", msg);
    }
}
