package com.transsion.baselib.report;

import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberInfo;
import com.transsnet.loginapi.bean.UserInfo;
import ij.o;
import ij.t;
import ij.u;
import im.b;
import java.util.HashSet;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements qi.i {
    private HashSet a;
    private final String b;
    private qx.a c;
    private b d;

    public i() {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        this.b = "ext";
        hashSet.add("app_start");
        this.a.add("app_stop");
        this.a.add("download_click");
    }

    @Override // qi.i
    public Bundle a(String str, Bundle bundle) {
        MemberDetail l;
        Integer daysLeft;
        UserInfo i;
        Intrinsics.h(str, "event");
        Intrinsics.h(bundle, "bundle");
        bundle.putString("play_mode", String.valueOf(t.a.b()));
        bundle.putString("content_mode", String.valueOf(ij.g.a.b()));
        int i2 = 1;
        bundle.putString("family_mode", String.valueOf(com.transsion.baselib.report.launch.b.a.b().getBoolean("k_is_family_mode", true)));
        o oVar = o.a;
        bundle.putString("kids_mode", String.valueOf(oVar.i()));
        String d = oVar.d();
        if (d == null) {
            d = BuildConfig.FLAVOR;
        }
        bundle.putString("kid_id", d);
        String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
        Intrinsics.g(strArr, "SUPPORTED_64_BIT_ABIS");
        bundle.putString("cpu_64", String.valueOf(!(strArr.length == 0 ? true : true)));
        u uVar = u.a;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        bundle.putString("s_a_m", String.valueOf(uVar.a(a)));
        jg.b.a.a(bundle);
        if (this.c == null) {
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.c = (qx.a) TheRouter.d(qx.a.class, new Object[1]);
                    }
                    Unit unit = Unit.a;
                } finally {
                }
            }
        }
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        this.d = (b) TheRouter.d(b.class, new Object[1]);
                    }
                    Unit unit2 = Unit.a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        qx.a aVar = this.c;
        if (aVar != null && (i = aVar.i()) != null) {
            bundle.putString("myuserid", String.valueOf(i.getUserId()));
        }
        b bVar = this.d;
        if (bVar != null && (l = bVar.l()) != null) {
            MemberInfo memberInfo = l.getMemberInfo();
            bundle.putBoolean("is_member", memberInfo != null ? memberInfo.isActive() : true);
            MemberInfo memberInfo2 = l.getMemberInfo();
            if (memberInfo2 != null && (daysLeft = memberInfo2.getDaysLeft()) != null) {
                i2 = daysLeft.intValue();
            }
            bundle.putString("trial_days", String.valueOf(i2));
            MemberInfo memberInfo3 = l.getMemberInfo();
            bundle.putString("expiry_date", memberInfo3 != null ? memberInfo3.getExpiryDate() : null);
        }
        if (this.a.contains(str)) {
            String string = bundle.getString(this.b);
            String string2 = bundle.getString("net_state");
            wf.a.a.c("report", "event " + str + " netState:" + string2 + " " + string, true);
        }
        return bundle;
    }

    @Override // qi.i
    public void b(String str, String str2, Map map) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "event");
        Intrinsics.h(map, "map");
        ej.b.a.d(str, str2, map);
    }

    @Override // qi.i
    public Pair getAccount() {
        qx.a aVar = this.c;
        UserInfo i = aVar != null ? aVar.i() : null;
        if (i != null) {
            return new Pair(Short.valueOf((short) i.getUserType()), String.valueOf(i.getUserId()));
        }
        return null;
    }
}
