package com.transsion.mbwidget.utils;

import android.content.Intent;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.data.WidgetDataManager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.PushConstants;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public static /* synthetic */ void e(a aVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        aVar.d(str, str2);
    }

    public static /* synthetic */ void j(a aVar, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        aVar.i(str, str2, str3);
    }

    public static /* synthetic */ void l(a aVar, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.k(str, z, str2);
    }

    public final void a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "exposure");
        h.a.z("add_widget_dialog", linkedHashMap);
    }

    public final void b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", PushConstants.PUSH_SERVICE_TYPE_CLICK);
        h.a.o("add_widget_dialog", linkedHashMap);
    }

    public final void c(Intent intent) {
        Intrinsics.h(intent, "intent");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String stringExtra = intent.getStringExtra("key_subject_id_widget");
        String stringExtra2 = intent.getStringExtra("key_module_name");
        linkedHashMap.put("widget_name", "history_desk_widget");
        if (stringExtra2 == null) {
            stringExtra2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("module_name", stringExtra2);
        if (stringExtra == null) {
            stringExtra = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", stringExtra);
        linkedHashMap.put("action", PushConstants.PUSH_SERVICE_TYPE_CLICK);
        h.a.q("history_desk_widget", "desk_widget", linkedHashMap);
    }

    public final void d(String str, String str2) {
        Intrinsics.h(str, "moduleName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("widget_name", "history_desk_widget");
        linkedHashMap.put("module_name", str);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", str2);
        linkedHashMap.put("action", "exposure");
        h.a.q("history_desk_widget", "desk_widget", linkedHashMap);
    }

    public final void f(Intent intent) {
        Intrinsics.h(intent, "intent");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("widget_name", "sport_desk_widget");
        String stringExtra = intent.getStringExtra("key_module_name");
        String str = BuildConfig.FLAVOR;
        if (stringExtra == null) {
            stringExtra = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("module_name", stringExtra);
        String stringExtra2 = intent.getStringExtra("key_match_id_widget");
        if (stringExtra2 == null) {
            stringExtra2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("id", stringExtra2);
        String stringExtra3 = intent.getStringExtra("key_deeplink_widget");
        if (stringExtra3 != null) {
            str = stringExtra3;
        }
        linkedHashMap.put("deeplink", str);
        linkedHashMap.put("action", PushConstants.PUSH_SERVICE_TYPE_CLICK);
        h.a.q("sport_desk_widget", "desk_widget", linkedHashMap);
    }

    public final void g(String str, String str2, String str3) {
        Intrinsics.h(str, "moduleName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("widget_name", "sport_desk_widget");
        linkedHashMap.put("module_name", str);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("id", str2);
        if (str3 == null) {
            str3 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("deeplink", str3);
        linkedHashMap.put("action", "exposure");
        h.a.q("sport_desk_widget", "desk_widget", linkedHashMap);
    }

    public final void h(Intent intent) {
        String ops;
        Intrinsics.h(intent, "intent");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String stringExtra = intent.getStringExtra("key_subject_id_widget");
        String stringExtra2 = intent.getStringExtra("key_module_name");
        Subject h = WidgetDataManager.a.h(stringExtra);
        linkedHashMap.put("widget_name", "hot_desk_widget");
        String str = BuildConfig.FLAVOR;
        if (stringExtra2 == null) {
            stringExtra2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("module_name", stringExtra2);
        if (stringExtra == null) {
            stringExtra = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", stringExtra);
        if (h != null && (ops = h.getOps()) != null) {
            str = ops;
        }
        linkedHashMap.put("ops", str);
        linkedHashMap.put("action", PushConstants.PUSH_SERVICE_TYPE_CLICK);
        h.a.q("hot_desk_widget", "desk_widget", linkedHashMap);
    }

    public final void i(String str, String str2, String str3) {
        Intrinsics.h(str, "moduleName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("widget_name", "hot_desk_widget");
        linkedHashMap.put("module_name", str);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", str2);
        if (str3 == null) {
            str3 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("ops", str3);
        linkedHashMap.put("action", "exposure");
        h.a.q("hot_desk_widget", "desk_widget", linkedHashMap);
    }

    public final void k(String str, boolean z, String str2) {
        Intrinsics.h(str, "widgetName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("widget_name", str);
        if (str2 == null) {
            str2 = z ? "add" : "remove";
        }
        linkedHashMap.put("action", str2);
        h.a.q(str, "desk_widget", linkedHashMap);
    }
}
