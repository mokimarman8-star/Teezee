package qi;

import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.PushConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    private static i c;
    public static final h a = new h();
    private static String b = BuildConfig.FLAVOR;
    private static final ExecutorService d = Executors.newSingleThreadExecutor();

    public static final class a implements GslbSdk.InitListener {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map map) {
            Intrinsics.h(map, "map");
            a.a.f(wf.a.a, "Report", "gslbSdk success did 11 " + this.a + " map " + map, false, 4, (Object) null);
        }
    }

    public static final class b implements GslbSdk.InitListener {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map map) {
            Intrinsics.h(map, "map");
            a.a.f(wf.a.a, "Report", "gslbSdk success did 22 " + this.a + " map " + map, false, 4, (Object) null);
        }
    }

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(String str, Map map, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("page_name", str);
        h hVar = a;
        bundle.putString("ext", hVar.n(map));
        if (E(hVar, str2, bundle, null, null, 12, null)) {
            try {
                Result.Companion companion = Result.Companion;
                a.a.f(wf.a.a, "Report", "reportUIEvent() --> event=" + str2 + "  pageName=" + str + " map=" + map, false, 4, (Object) null);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
        a.f(str, str2, map);
    }

    private final boolean D(String str, Bundle bundle, Integer num, String str2) {
        Pair account;
        com.transsion.base.report.athena.sampler.c cVar = com.transsion.base.report.athena.sampler.c.a;
        String G = AthenaAnalytics.G(Utils.a());
        Intrinsics.g(G, "getAppVAID(...)");
        if (cVar.b(str, bundle, G)) {
            return false;
        }
        try {
            bundle.putString(PushConstants.PROVIDER_VAID, AthenaAnalytics.G(Utils.a()));
            i iVar = c;
            Bundle a2 = iVar != null ? iVar.a(str, bundle) : null;
            i iVar2 = c;
            if (iVar2 != null && (account = iVar2.getAccount()) != null) {
                AthenaAnalytics.Z(((Number) account.getFirst()).shortValue(), (String) account.getSecond());
            }
            if (num != null) {
                if (!TextUtils.isEmpty(str2)) {
                    if (a2 == null) {
                        a2 = new Bundle();
                    }
                    a2.putString("biz_line", str2);
                }
                new hi.a(str, num.intValue()).c(a2, null).b();
            } else {
                new hi.a(str).c(a2, null).b();
            }
            return true;
        } catch (Exception e) {
            wf.a.a.i("report", "event " + str + " exception " + e, true);
            return false;
        }
    }

    static /* synthetic */ boolean E(h hVar, String str, Bundle bundle, Integer num, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return hVar.D(str, bundle, num, str2);
    }

    private final void f(String str, String str2, Map map) {
        i iVar = c;
        if (iVar != null) {
            iVar.b(str, str2, map);
        }
    }

    private final String[] i() {
        return new String[]{"dsu-a.shalltry.com"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(int i, String str) {
        a.a.f(wf.a.a, "Report", "loginActive:userType" + i + ",userid:" + str, false, 4, (Object) null);
        HashMap hashMap = new HashMap();
        hashMap.put("userType", String.valueOf(i));
        if (str == null) {
            str = "0";
        }
        hashMap.put("userId", str);
        h hVar = a;
        String n = hVar.n(hashMap);
        Bundle bundle = new Bundle();
        bundle.putString("event", "login_active");
        bundle.putString("ext", n);
        E(hVar, "login_active", bundle, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Map map, String str) {
        try {
            Result.Companion companion = Result.Companion;
            a.a.f(wf.a.a, "Report", "reportEvent event=" + str + " map=" + map + ' ', false, 4, (Object) null);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        Bundle bundle = new Bundle();
        h hVar = a;
        bundle.putString("ext", hVar.n(map));
        E(hVar, str, bundle, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Map map, String str, String str2, int i, String str3) {
        Bundle bundle = new Bundle();
        String jSONObject = new JSONObject(map).toString();
        Intrinsics.g(jSONObject, "toString(...)");
        bundle.putString("ext", jSONObject);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("page_name", str);
        }
        if (a.D(str2, bundle, Integer.valueOf(i), str3)) {
            try {
                Result.Companion companion = Result.Companion;
                a.a.f(wf.a.a, "Report_ad", "reportEventAd() --> appId = " + i + " -- bizLine = " + str3 + " -- event = " + str2 + " -- pageName = " + str + " -- bundle = " + bundle, false, 4, (Object) null);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Map map, String str, String str2) {
        Bundle bundle = new Bundle();
        h hVar = a;
        bundle.putString("ext", hVar.n(map));
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("page_name", str);
        }
        if (E(hVar, str2, bundle, null, null, 12, null)) {
            try {
                Result.Companion companion = Result.Companion;
                a.a.f(wf.a.a, "Report_ad", "reportEventV2() --> event = " + str2 + " --> bundle = " + bundle, false, 4, (Object) null);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }

    public final void A(final String str, final String str2, final Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "event");
        Intrinsics.h(map, "map");
        try {
            map = MapsKt.u(map);
        } catch (Exception unused) {
        }
        d.execute(new Runnable() { // from class: qi.e
            @Override // java.lang.Runnable
            public final void run() {
                h.B(str, map, str2);
            }
        });
    }

    public final void C(String str, String str2, long j, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "event");
        Intrinsics.h(map, "map");
        map.put("duration", String.valueOf(j));
        A(str, str2, map);
    }

    public final boolean g(String str, Bundle bundle, int i) {
        Intrinsics.h(str, "event");
        Intrinsics.h(bundle, "bundle");
        return E(this, str, bundle, Integer.valueOf(i), null, 8, null);
    }

    public final String h() {
        return b;
    }

    public final void j(Application application, boolean z, i iVar, String str, int i, boolean z2, String str2, boolean z3) {
        String str3;
        String str4;
        Intrinsics.h(application, "context");
        Intrinsics.h(iVar, "api");
        Intrinsics.h(str, "channelId");
        String h = tg.b.a.h();
        if ((str2 != null ? str2.length() : 0) >= 3) {
            if (str2 != null) {
                str4 = str2.substring(0, 3);
                Intrinsics.g(str4, "substring(...)");
            } else {
                str4 = null;
            }
            str3 = String.valueOf(str4);
        } else {
            str3 = BuildConfig.FLAVOR;
        }
        if (z3) {
            GslbSdk.init(application, "404", h, i(), new a(h));
        } else if (TextUtils.equals("250", str3)) {
            GslbSdk.init(application, "621", h, i(), new b(h));
        }
        AthenaAnalytics.e0(1);
        AthenaAnalytics.Q(application, str, i, true, z2);
        AthenaAnalytics.d0(z);
        AthenaAnalytics.D(true);
        AthenaAnalytics.c0(2000);
        AthenaAnalytics.f0();
        c = iVar;
        a.a.f(wf.a.a, "Report", "initSDK debug " + z, false, 4, (Object) null);
    }

    public final void l(final int i, final String str) {
        d.execute(new Runnable() { // from class: qi.g
            @Override // java.lang.Runnable
            public final void run() {
                h.m(i, str);
            }
        });
    }

    public final String n(Map map) {
        Intrinsics.h(map, "map");
        String jSONObject = new JSONObject(map).toString();
        Intrinsics.g(jSONObject, "toString(...)");
        return jSONObject;
    }

    public final void o(String str, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(map, "map");
        A(str, PushConstants.PUSH_SERVICE_TYPE_CLICK, map);
    }

    public final void p(String str, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(map, "map");
        A(str, "dialog_show", map);
    }

    public final void q(String str, String str2, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "event");
        Intrinsics.h(map, "map");
        A(str, str2, map);
    }

    public final void r(final String str, final Map map) {
        Intrinsics.h(str, "event");
        Intrinsics.h(map, "map");
        try {
            map = MapsKt.u(map);
        } catch (Exception unused) {
        }
        d.execute(new Runnable() { // from class: qi.d
            @Override // java.lang.Runnable
            public final void run() {
                h.s(map, str);
            }
        });
    }

    public final void t(final String str, Map map, final String str2, final int i, final String str3) {
        Intrinsics.h(str, "event");
        Intrinsics.h(map, "map");
        Intrinsics.h(str2, "pageName");
        Intrinsics.h(str3, "bizLine");
        try {
            map = MapsKt.u(map);
        } catch (Exception unused) {
        }
        final Map map2 = map;
        d.execute(new Runnable() { // from class: qi.c
            @Override // java.lang.Runnable
            public final void run() {
                h.u(map2, str2, str, i, str3);
            }
        });
    }

    public final void v(final String str, final Map map, final String str2) {
        Intrinsics.h(str, "event");
        Intrinsics.h(map, "map");
        Intrinsics.h(str2, "pageName");
        try {
            map = MapsKt.u(map);
        } catch (Exception unused) {
        }
        d.execute(new Runnable() { // from class: qi.f
            @Override // java.lang.Runnable
            public final void run() {
                h.w(map, str2, str);
            }
        });
    }

    public final void x(qi.b bVar) {
        Intrinsics.h(bVar, "logConfig");
        HashMap g = bVar.g();
        String a2 = bVar.a();
        if (a2 == null) {
            a2 = b;
        }
        g.put("page_from", a2);
        bVar.g().put("duration", String.valueOf(SystemClock.elapsedRealtime() - bVar.h()));
        bVar.g().put("is_load_success", String.valueOf(bVar.i()));
        String e = bVar.e();
        if (e != null) {
            bVar.g().put("ops", e);
        }
        A(bVar.f(), "pt", bVar.g());
        if (TextUtils.equals(b, bVar.f()) || !bVar.b()) {
            return;
        }
        b = bVar.f();
    }

    public final void y(qi.b bVar) {
        Intrinsics.h(bVar, "logConfig");
        HashMap g = bVar.g();
        String a2 = bVar.a();
        if (a2 == null) {
            a2 = b;
        }
        g.put("page_from", a2);
        String e = bVar.e();
        if (e != null) {
            bVar.g().put("ops", e);
        }
        A(bVar.f(), "pv", bVar.g());
    }

    public final void z(String str, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(map, "map");
        A(str, "browse", map);
    }
}
