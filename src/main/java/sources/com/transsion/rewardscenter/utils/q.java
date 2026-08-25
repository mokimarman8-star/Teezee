package com.transsion.rewardscenter.utils;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class q {
    public static final void a(String str, Map map) {
        Intrinsics.h(str, "module");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        qi.h.a.o("rewards_center", hashMap);
    }

    public static final void b(String str) {
        Intrinsics.h(str, "module");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str);
        qi.h.a.z("rewards_center", hashMap);
    }
}
