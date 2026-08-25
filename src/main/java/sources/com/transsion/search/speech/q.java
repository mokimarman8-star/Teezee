package com.transsion.search.speech;

import java.util.LinkedHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q {
    public static final q a = new q();
    private static String b;

    private q() {
    }

    public final void a() {
        com.transsion.baselib.helper.a.a.b("sr_dialog_cancel_btn", MapsKt.h());
    }

    public final void b() {
        com.transsion.baselib.helper.a.a.b("sr_mic_btn", MapsKt.h());
    }

    public final void c(String str, int i) {
        Intrinsics.h(str, "msg");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "fail");
        linkedHashMap.put("msg", str);
        linkedHashMap.put("code", String.valueOf(i));
        linkedHashMap.put("trigger_id", String.valueOf(b));
        com.transsion.baselib.helper.a.a.a("sr_dialog_sr", linkedHashMap);
        b = null;
    }

    public final void d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "trigger");
        String a2 = d.a.a(10);
        b = a2;
        linkedHashMap.put("trigger_id", String.valueOf(a2));
        com.transsion.baselib.helper.a.a.a("sr_dialog_sr", linkedHashMap);
    }

    public final void e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "success");
        linkedHashMap.put("trigger_id", String.valueOf(b));
        com.transsion.baselib.helper.a.a.a("sr_dialog_sr", linkedHashMap);
        b = null;
    }

    public final void f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "strategy");
        linkedHashMap.put("value", "two");
        linkedHashMap.put("model", com.blankj.utilcode.util.k.b());
        com.transsion.baselib.helper.a.a.b("sr_dialog_sr", MapsKt.h());
    }
}
