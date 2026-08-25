package com.transsion.commercialization.pslink;

import java.util.LinkedHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f {
    public static final f a = new f();

    private f() {
    }

    public final void a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_dialog_click_member_guide");
        com.transsion.baselib.helper.a.a.b("download_intercept", linkedHashMap);
    }

    public final void b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_dialog_click_rewarded");
        com.transsion.baselib.helper.a.a.b("download_intercept", linkedHashMap);
    }

    public final void c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_dialog_click_try_another");
        com.transsion.baselib.helper.a.a.b("download_intercept", linkedHashMap);
    }

    public final void d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_intercept_dialog_change_click");
        com.transsion.baselib.helper.a.a.b("download_intercept", linkedHashMap);
    }

    public final void e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_intercept_dialog_member_click");
        com.transsion.baselib.helper.a.a.b("download_intercept", linkedHashMap);
    }

    public final void f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_intercept_dialog_show");
        com.transsion.baselib.helper.a.a.a("download_intercept", linkedHashMap);
    }

    public final void g() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_dialog_show");
        com.transsion.baselib.helper.a.a.a("download_intercept", linkedHashMap);
    }

    public final void h(String str, int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("packageName", String.valueOf(str));
        linkedHashMap.put("status", String.valueOf(i));
        com.transsion.baselib.helper.a.a.d(linkedHashMap);
    }
}
