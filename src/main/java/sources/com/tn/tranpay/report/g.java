package com.tn.tranpay.report;

import android.app.Application;
import android.os.Bundle;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.TranPayConfiguration;
import com.tn.tranpay.device.TNDeviceHelper;
import java.util.HashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class g implements f {
    private HashSet a;

    public g() {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add("app_start");
        this.a.add("app_stop");
    }

    private final void c(Bundle bundle) {
        bundle.putString("device_id", TNDeviceHelper.a.c());
        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.a;
        bundle.putString("app_id", tranPayConfiguration.h());
        bundle.putString("channel", tranPayConfiguration.j());
        bundle.putString("app_version", d());
        bundle.putString("sdk_version", TranPay.a.e());
        String l = tranPayConfiguration.l();
        if (l == null) {
            l = "";
        }
        bundle.putString("m_id", l);
        String s = tranPayConfiguration.s();
        if (s == null) {
            s = "";
        }
        bundle.putString("pay_order_id", s);
        String t = tranPayConfiguration.t();
        if (t == null) {
            t = "";
        }
        bundle.putString("txn_id", t);
        String k = tranPayConfiguration.k();
        if (k == null) {
            k = "";
        }
        bundle.putString("country", k);
        String m = tranPayConfiguration.m();
        if (m == null) {
            m = "";
        }
        bundle.putString("currency", m);
        String g = tranPayConfiguration.g();
        bundle.putString("amount", g != null ? g : "");
        bundle.putString("timestamp", String.valueOf(System.currentTimeMillis()));
    }

    private final String d() {
        try {
            Application d = TranPay.a.d();
            String str = d.getPackageManager().getPackageInfo(d.getPackageName(), 0).versionName;
            Intrinsics.g(str, "{\n            // 使用 Tran… 0).versionName\n        }");
            return str;
        } catch (Exception unused) {
            return TmcConstants.ROUTE_UNKNOWN;
        }
    }

    @Override // com.tn.tranpay.report.f
    public Bundle a(String str, Bundle bundle) {
        Intrinsics.h(str, "event");
        Intrinsics.h(bundle, "bundle");
        c(bundle);
        return bundle;
    }

    @Override // com.tn.tranpay.report.f
    public void b(String str, String str2, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "event");
        Intrinsics.h(map, "map");
    }
}
