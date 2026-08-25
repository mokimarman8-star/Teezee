package com.tn.tranpay.report;

import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tn.tranpay.TranPay;
import com.transsion.ga.AthenaAnalytics;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class e {
    public static final e a = new e();
    private static String b = "";
    private static int c = 3560;
    private static f d;

    private e() {
    }

    private final void b(String str, String str2, Map map) {
        f fVar = d;
        if (fVar != null) {
            fVar.b(str, str2, map);
        }
    }

    private final String d(Map map) {
        String jSONObject = new JSONObject(map).toString();
        Intrinsics.g(jSONObject, "JSONObject(map).toString()");
        return jSONObject;
    }

    private final void h(final String str, final String str2, final String str3, final Map map) {
        ThreadSingleExecutor.b.a().b(new Runnable() { // from class: com.tn.tranpay.report.d
            @Override // java.lang.Runnable
            public final void run() {
                e.i(str, str3, str2, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String str, String str2, String str3, Map map) {
        Intrinsics.h(str, "$category");
        Intrinsics.h(str2, "$event");
        Intrinsics.h(str3, "$pageName");
        Intrinsics.h(map, "$map");
        lh.a.a.b(str + " event=" + str2 + "  pageName=" + str3 + " map=" + map, "Report");
        Bundle bundle = new Bundle();
        bundle.putString("page_name", str3);
        e eVar = a;
        bundle.putString("ext", eVar.d(map));
        eVar.j(str2, bundle);
        eVar.b(str3, str2, map);
    }

    private final void j(String str, Bundle bundle) {
        Bundle a2;
        try {
            bundle.putString("vaid", AthenaAnalytics.G(TranPay.a.d()));
            f fVar = d;
            if (fVar != null && (a2 = fVar.a(str, bundle)) != null) {
                bundle = a2;
            }
            new hi.a(str, c).c(bundle, (Bundle) null).b();
        } catch (Exception e) {
            lh.a.a.d("event " + str + " exception " + e, "Report");
        }
    }

    public final void c(Application application, String str, boolean z, boolean z2, f fVar) {
        Intrinsics.h(application, "context");
        Intrinsics.h(str, "channel");
        AthenaAnalytics.Q(application, str, c, true, z2);
        AthenaAnalytics.d0(z);
        d = fVar;
        lh.a.a.f("init athena debug " + z, "Report");
    }

    public final void e(String str, String str2, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "event");
        Intrinsics.h(map, "map");
        h("reportClick", str, str2, map);
    }

    public final void f(c cVar) {
        Intrinsics.h(cVar, "logConfig");
        HashMap g = cVar.g();
        String a2 = cVar.a();
        if (a2 == null) {
            a2 = b;
        }
        g.put("page_from", a2);
        cVar.g().put("duration", String.valueOf(SystemClock.elapsedRealtime() - cVar.h()));
        cVar.g().put("is_load_success", String.valueOf(cVar.i()));
        String e = cVar.e();
        if (e != null) {
            cVar.g().put("ops", e);
        }
        h("reportPT", cVar.f(), "pt", cVar.g());
        if (TextUtils.equals(b, cVar.f()) || !cVar.b()) {
            return;
        }
        b = cVar.f();
    }

    public final void g(c cVar) {
        Intrinsics.h(cVar, "logConfig");
        HashMap g = cVar.g();
        String a2 = cVar.a();
        if (a2 == null) {
            a2 = b;
        }
        g.put("page_from", a2);
        String e = cVar.e();
        if (e != null) {
            cVar.g().put("ops", e);
        }
        h("reportPV", cVar.f(), "pv", cVar.g());
    }
}
