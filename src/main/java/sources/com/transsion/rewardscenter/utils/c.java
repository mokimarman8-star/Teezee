package com.transsion.rewardscenter.utils;

import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsnet.loginapi.bean.Country;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();
    private static final Regex b = new Regex("^\\d{7,15}$");
    public static final int c = 8;

    private c() {
    }

    public final Triple a() {
        b bVar = b.a;
        String c2 = bVar.c();
        String d = bVar.d();
        String e = bVar.e();
        a.a aVar = wf.a.a;
        a.a.f(aVar, "RewardsCenter", "getPhoneInfo mmkv: " + ((Object) c2) + ", " + ((Object) d) + ", " + ((Object) e), false, 4, (Object) null);
        qx.a aVar2 = (qx.a) TheRouter.d(qx.a.class, new Object[0]);
        if (aVar2 != null) {
            if (StringsKt.q0(e)) {
                UserInfo i = aVar2.i();
                String phone = i != null ? i.getPhone() : null;
                if (phone == null) {
                    phone = BuildConfig.FLAVOR;
                }
                if (StringsKt.q0(c2)) {
                    String cc = i != null ? i.getCc() : null;
                    c2 = cc == null ? BuildConfig.FLAVOR : cc;
                }
                e = phone;
            }
            a.a.f(aVar, "RewardsCenter", "getPhoneInfo userInfo: " + ((Object) c2) + ", " + ((Object) d) + ", " + ((Object) e), false, 4, (Object) null);
            if (StringsKt.q0(c2) || StringsKt.q0(d)) {
                Country f = aVar2.f();
                a.a.f(aVar, "RewardsCenter", "getPhoneInfo --> country: " + f, false, 4, (Object) null);
                if (StringsKt.q0(c2)) {
                    c2 = f != null ? f.getCode() : null;
                    if (c2 == null) {
                        c2 = BuildConfig.FLAVOR;
                    }
                }
                if (StringsKt.q0(d)) {
                    String code = f != null ? f.getCode() : null;
                    if (code == null) {
                        code = BuildConfig.FLAVOR;
                    }
                    if (Intrinsics.c(c2, code)) {
                        String country_s = f != null ? f.getCountry_s() : null;
                        d = country_s == null ? BuildConfig.FLAVOR : country_s;
                    }
                }
            }
            a.a.f(aVar, "RewardsCenter", "getPhoneInfo result: " + ((Object) c2) + ", " + ((Object) d) + ", " + ((Object) e), false, 4, (Object) null);
        }
        return new Triple(c2, d, e);
    }

    public final boolean b(String str) {
        Intrinsics.h(str, "number");
        return b.matches(str);
    }
}
