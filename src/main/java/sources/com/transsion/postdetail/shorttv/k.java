package com.transsion.postdetail.shorttv;

import com.transsion.gslb.BuildConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k {
    public static final k a = new k();

    private k() {
    }

    public static /* synthetic */ void b(k kVar, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 16) != 0) {
            str5 = "minitv_play";
        }
        kVar.a(str, str2, str3, str4, str5);
    }

    public static /* synthetic */ void d(k kVar, String str, String str2, String str3, boolean z, String str4, String str5, int i, Object obj) {
        if ((i & 16) != 0) {
            str4 = "minitv_play";
        }
        String str6 = str4;
        if ((i & 32) != 0) {
            str5 = null;
        }
        kVar.c(str, str2, str3, z, str6, str5);
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.h(str3, "optType");
        Intrinsics.h(str4, "position");
        Intrinsics.h(str5, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "watch_ad");
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", str2);
        hashMap.put("opt_type", str3);
        hashMap.put("position", str4);
        qi.h.a.o(str5, hashMap);
    }

    public final void c(String str, String str2, String str3, boolean z, String str4, String str5) {
        Intrinsics.h(str3, "optType");
        Intrinsics.h(str4, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "favorite");
        if (str != null && str.length() != 0) {
            hashMap.put("subject_id", str);
        }
        if (str2 != null && str2.length() != 0) {
            hashMap.put("ops", str2);
        }
        hashMap.put("opt_type", str3);
        hashMap.put("favorite", String.valueOf(!z));
        if (str5 != null && str5.length() != 0) {
            hashMap.put("page_from", str5);
        }
        qi.h.a.o(str4, hashMap);
    }
}
