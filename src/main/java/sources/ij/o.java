package ij;

import com.tencent.mmkv.MMKV;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import jg.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o {
    private static String b;
    public static final o a = new o();
    private static String c = "All";
    private static String d = "UN_GRADE";

    private o() {
    }

    private final boolean h() {
        String value;
        Boolean m1;
        ConfigBean c2 = cm.f.c.a().c("sa_key_kid_mode_ad_switch", false);
        if (c2 == null || (value = c2.getValue()) == null || (m1 = StringsKt.m1(value)) == null) {
            return false;
        }
        return m1.booleanValue();
    }

    private final void k(String str) {
        b = str == null ? BuildConfig.FLAVOR : str;
        MMKV b2 = com.transsion.baselib.report.launch.b.a.b();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        b2.putString("k_kids_mode_current_kid_id", str);
        n();
    }

    public final void a(String str) {
        Intrinsics.h(str, "kidId");
        if (!i()) {
            com.transsion.baselib.report.launch.b.a.b().putInt("k_kids_mode_ugc_snapshot", g.a.b() ? 1 : 0);
        }
        if (!h()) {
            rh.b.a.d(true);
        }
        g.a.e(true);
        k(str);
        n nVar = new n(str);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = n.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, nVar, 0L);
    }

    public final void b() {
        rh.b.a.d(false);
        k(null);
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        int i = bVar.b().getInt("k_kids_mode_ugc_snapshot", -1);
        if (i != -1) {
            g.a.e(i == 1);
            bVar.b().putInt("k_kids_mode_ugc_snapshot", -1);
        }
        n nVar = new n(null);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = n.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, nVar, 0L);
    }

    public final String c() {
        return String.valueOf(x.a.b());
    }

    public final String d() {
        if (b == null) {
            MMKV b2 = com.transsion.baselib.report.launch.b.a.b();
            String str = BuildConfig.FLAVOR;
            String string = b2.getString("k_kids_mode_current_kid_id", BuildConfig.FLAVOR);
            if (string != null) {
                str = string;
            }
            b = str;
        }
        String str2 = b;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return str2;
    }

    public final String e() {
        return d;
    }

    public final String f() {
        return c;
    }

    public final boolean g() {
        return !h() && i();
    }

    public final boolean i() {
        String d2 = d();
        return !(d2 == null || d2.length() == 0);
    }

    public final boolean j() {
        String value;
        Boolean m1;
        ConfigBean c2 = cm.f.c.a().c("sa_key_kid_mode_feature_enable", true);
        if (c2 == null || (value = c2.getValue()) == null || (m1 = StringsKt.m1(value)) == null) {
            return false;
        }
        return m1.booleanValue();
    }

    public final void l(String str) {
        Intrinsics.h(str, "<set-?>");
        d = str;
    }

    public final void m(String str) {
        Intrinsics.h(str, "<set-?>");
        c = str;
    }

    public final void n() {
        b.a aVar = jg.b.a;
        String d2 = d();
        if (d2 == null) {
            d2 = BuildConfig.FLAVOR;
        }
        aVar.b("X-Child-UID", d2);
    }
}
