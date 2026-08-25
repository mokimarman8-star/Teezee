package com.transsion.version.update;

import com.transsion.web.api.WebConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    public static /* synthetic */ void d(e eVar, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        eVar.c(str, z, str2, str3);
    }

    public final void a(String fromPage, boolean z, String dialogType) {
        Intrinsics.h(fromPage, "fromPage");
        Intrinsics.h(dialogType, "dialogType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_upgrade", String.valueOf(z));
        linkedHashMap.put("dialog_type", dialogType);
        linkedHashMap.put("action", "click");
        linkedHashMap.put(WebConstants.PAGE_FROM, fromPage);
        qi.h.a.A("update_page", "update", linkedHashMap);
        if (z) {
            d dVar = d.a;
            dVar.b().putString("key_user_clicked_dialog_type", dialogType);
            dVar.b().putInt("key_last_installed_version_v2", com.blankj.utilcode.util.c.f());
        }
    }

    public final void b(Map map) {
        Intrinsics.h(map, "map");
        qi.h.a.A("update_page", "update", map);
    }

    public final void c(String fromPage, boolean z, String dialogType, String str) {
        Intrinsics.h(fromPage, "fromPage");
        Intrinsics.h(dialogType, "dialogType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("show diffUpdateDialog from page:");
        sb.append(fromPage);
        sb.append(", ");
        sb.append(linkedHashMap);
        linkedHashMap.put("action", "show_dialog");
        linkedHashMap.put(WebConstants.PAGE_FROM, fromPage);
        linkedHashMap.put("manual", String.valueOf(z));
        linkedHashMap.put("dialog_type", dialogType);
        linkedHashMap.put("ps_error_msg", String.valueOf(str));
        qi.h.a.A("update_page", "update", linkedHashMap);
    }
}
