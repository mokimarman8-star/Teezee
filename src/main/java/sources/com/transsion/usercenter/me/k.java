package com.transsion.usercenter.me;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k {
    public static final k a = new k();
    private static String b;

    private k() {
    }

    public final void a(String moduleName) {
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        String str = b;
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("user_id", str);
        hashMap.put("user_status", "me");
        hashMap.put("module_name", moduleName);
        qi.h.a.z("profiledetail", hashMap);
    }

    public final void b(String moduleName) {
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        String str = b;
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("user_id", str);
        hashMap.put("user_status", "me");
        hashMap.put("module_name", moduleName);
        qi.h.a.o("profiledetail", hashMap);
    }

    public final void c(String moduleName, int i) {
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        String str = b;
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("user_id", str);
        hashMap.put("user_status", "me");
        hashMap.put("module_name", moduleName);
        hashMap.put("position", String.valueOf(i));
        qi.h.a.o("profiledetail", hashMap);
    }

    public final void d(String str) {
        b = str;
    }
}
