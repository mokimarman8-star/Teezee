package com.transsion.home.view;

import com.transsion.push.PushConstants;
import java.util.HashMap;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    private static boolean b;
    public static final g a = new g();
    public static final int c = 8;

    private g() {
    }

    private final void c() {
        HashMap hashMap = new HashMap();
        hashMap.put(PushConstants.PUSH_SERVICE_TYPE_CLICK, "search");
        h.a.o("guide", hashMap);
    }

    public final boolean a() {
        return b;
    }

    public final void b(boolean z) {
        com.transsion.baselib.report.launch.b.a.b().putBoolean("search_guide", true);
        if (z) {
            c();
        }
    }

    public final void d() {
        b = false;
    }

    public final void e(boolean z) {
        b = z;
    }
}
