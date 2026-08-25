package com.transsion.baselib.helper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();
    private static final ConcurrentHashMap b = new ConcurrentHashMap();

    private a() {
    }

    public final void a(String str, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(map, "map");
        qi.h.a.z(str, map);
    }

    public final void b(String str, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(map, "map");
        qi.h.a.o(str, map);
    }

    public final void c(String str, String str2) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "dialogName");
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", str2);
        qi.h.a.p(str, hashMap);
    }

    public final void d(Map map) {
        Intrinsics.h(map, "map");
        qi.h.a.r("download_app", map);
    }

    public final void e(String str, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(map, "map");
        qi.h.a.z(str, map);
    }

    public final void f(String str, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(map, "map");
        qi.h.a.o(str, map);
    }

    public final void g(String str, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(map, "map");
        qi.h.a.o(str, map);
    }

    public final void h(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str2);
        if (str3 != null) {
            hashMap.put("group_id", str3);
        }
        if (str4 != null) {
            hashMap.put("subject_id", str4);
        }
        if (str5 != null) {
            hashMap.put("post_id", str5);
        }
        if (str6 != null) {
            hashMap.put("ops", str6);
        }
        qi.h.a.o(str, hashMap);
    }

    public final void i(String str, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(map, "map");
        qi.h.a.o(str, map);
    }

    public final void k(String str, String str2, String str3) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "pageFrom");
        Intrinsics.h(str3, "duration");
        HashMap hashMap = new HashMap();
        hashMap.put("page_from", str2);
        hashMap.put("duration", str3);
        qi.h.a.q(str, "pt", hashMap);
    }

    public final void l(String str, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(map, "map");
        qi.h.a.o(str, map);
    }

    public final void m(String str, List list, boolean z) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(list, "pageTabNameList");
        if (z) {
            b.clear();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            ConcurrentHashMap concurrentHashMap = b;
            if (!concurrentHashMap.containsKey(str2)) {
                concurrentHashMap.put(str2, Boolean.TRUE);
                HashMap hashMap = new HashMap();
                hashMap.put("page_tab_name", str2);
                qi.h.a.z(str, hashMap);
            }
        }
    }

    public final void n(String str, String str2) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "pageTabName");
        HashMap hashMap = new HashMap();
        hashMap.put("page_tab_name", str2);
        qi.h.a.o(str, hashMap);
    }
}
