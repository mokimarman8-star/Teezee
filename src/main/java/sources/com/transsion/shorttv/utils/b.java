package com.transsion.shorttv.utils;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static /* synthetic */ void b(b bVar, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "minitv_download";
        }
        bVar.a(str, str2, str3);
    }

    public static /* synthetic */ void e(b bVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "minitv_download";
        }
        bVar.d(str, str2);
    }

    public final void a(String str, String dialogName, String pageName) {
        Intrinsics.h(dialogName, "dialogName");
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("subject_id", str);
        hashMap.put("dialog_name", dialogName);
        qi.h.a.q(pageName, "dialog_show", hashMap);
    }

    public final void c(String str, String optType, boolean z, String pageName) {
        Intrinsics.h(optType, "optType");
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "favorite");
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("subject_id", str);
        hashMap.put("opt_type", optType);
        hashMap.put("favorite", String.valueOf(!z));
        qi.h.a.o(pageName, hashMap);
    }

    public final void d(String str, String pageName) {
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "share");
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put("subject_id", str);
        qi.h.a.o(pageName, hashMap);
    }
}
