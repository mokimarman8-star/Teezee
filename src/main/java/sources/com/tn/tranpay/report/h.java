package com.tn.tranpay.report;

import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.util.HashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class h {
    public static final h a = new h();

    private h() {
    }

    public static /* synthetic */ void f(h hVar, int i, Boolean bool, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bool = null;
        }
        hVar.e(i, bool);
    }

    public final void a(String str, boolean z, boolean z2, boolean z3) {
        Intrinsics.h(str, "paymentMethod");
        HashMap hashMap = new HashMap();
        hashMap.put("payment_method", str);
        hashMap.put("need_phone", String.valueOf(z));
        hashMap.put("need_cnic", String.valueOf(z2));
        hashMap.put("auto", String.valueOf(z3));
        e.a.e("cashier_page", "choose_payment_method", hashMap);
    }

    public final void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", "true");
        if (str == null) {
            str = "";
        }
        hashMap.put("region", str);
        e.a.e("pay_sdk", OfflineConstantsKt.TRIGGER_INIT, hashMap);
    }

    public final void c(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", String.valueOf(z));
        e.a.e("pay_sdk", "load_config", hashMap);
    }

    public final void d(int i, String str, String str2, String str3, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", String.valueOf(i));
        if (str == null) {
            str = "";
        }
        hashMap.put("webUrl", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("rnUrl", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("packageName", str3);
        hashMap.put("auto", String.valueOf(z));
        e.a.e("cashier_page", "open_link", hashMap);
    }

    public final void e(int i, Boolean bool) {
        HashMap hashMap = new HashMap();
        hashMap.put("resultType", String.valueOf(i));
        if (bool != null) {
            hashMap.put("reason", bool.booleanValue() ? "cancel" : OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER);
        }
        e.a.e("cashier_page", "pay", hashMap);
    }

    public final void g() {
        e.a.e("retention_dialog", "click_cancel", MapsKt.h());
    }

    public final void h() {
        e.a.e("retention_dialog", "pt", MapsKt.h());
    }

    public final void i() {
        e.a.e("retention_dialog", "click_query", MapsKt.h());
    }

    public final void j(boolean z, String str, boolean z2, String str2) {
        Intrinsics.h(str, "orderDesc");
        Intrinsics.h(str2, "txnId");
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", String.valueOf(z));
        hashMap.put("order_desc", str);
        hashMap.put("pay_by_local_currency", String.valueOf(z2));
        hashMap.put("txn_id", str2);
        e.a.e("pay_sdk", "start_pay", hashMap);
    }

    public final void k(boolean z, String str, String str2, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_success", String.valueOf(z));
        if (str != null) {
            hashMap.put("phone", str);
        }
        if (str2 != null) {
            hashMap.put("cnic", str2);
        }
        hashMap.put("auto", String.valueOf(z2));
        e.a.e("cashier_page", "submit", hashMap);
    }

    public final void l(String str) {
        Intrinsics.h(str, "pageName");
        e.a.e(str, "pt", MapsKt.h());
    }
}
