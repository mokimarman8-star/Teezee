package com.transsion.player.mediasession;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i {
    public static final i a = new i();

    private i() {
    }

    public final void a(String str) {
        Intrinsics.h(str, "msg");
    }

    public final void b(String str) {
        Intrinsics.h(str, "msg");
        Log.e("m_log", str);
    }
}
