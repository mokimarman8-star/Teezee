package com.transsion.rewardscenter.model;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenterapi.Banner;
import com.transsion.rewardscenterapi.Lottery;
import com.transsion.rewardscenterapi.SkuPoint;
import com.transsion.rewardscenterapi.User;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RewardsCenterModel extends androidx.lifecycle.b {
    private final Lazy b;
    private final b0 c;
    private final b0 d;
    private final b0 e;
    private final b0 f;
    private final b0 g;
    private final b0 h;
    private final b0 i;
    private String j;
    private final b0 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardsCenterModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.model.e
            public final Object invoke() {
                xo.a z;
                z = RewardsCenterModel.z();
                return z;
            }
        });
        this.c = new b0();
        this.d = new b0();
        this.e = new b0();
        this.f = new b0();
        this.g = new b0();
        this.h = new b0(Boolean.FALSE);
        this.i = new b0();
        this.k = new b0();
    }

    public static /* synthetic */ void h(RewardsCenterModel rewardsCenterModel, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        rewardsCenterModel.g(str, z);
    }

    public static /* synthetic */ void j(RewardsCenterModel rewardsCenterModel, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        rewardsCenterModel.i(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.a s() {
        return (xo.a) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.a z() {
        return (xo.a) kg.c.e.a().h(xo.a.class);
    }

    public final void A(String str) {
        this.j = str;
    }

    public final void B(String str, String str2, String str3) {
        Intrinsics.h(str, "cc");
        Intrinsics.h(str2, "number");
        Intrinsics.h(str3, "iso");
        String str4 = this.j;
        if (str4 == null || str4.length() == 0) {
            return;
        }
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RewardsCenterModel$submitAndClaim$1(this, str4, str, str2, str3, null), 3, (Object) null);
    }

    public final void C(int i) {
        User user = (User) this.d.f();
        if (user == null) {
            return;
        }
        this.d.q(User.copy$default(user, i, null, null, false, 14, null));
    }

    public final void e(String str) {
        Intrinsics.h(str, "drawResultId");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RewardsCenterModel$claim$1(str, this, null), 3, (Object) null);
    }

    public final void f(String str) {
        Intrinsics.h(str, "drawResultId");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RewardsCenterModel$claimVip$1(this, str, null), 3, (Object) null);
    }

    public final void g(String str, boolean z) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RewardsCenterModel$drawTask$1(this, str, z, null), 3, (Object) null);
    }

    public final void i(Function0 function0) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new RewardsCenterModel$fetchRewardsCenterData$1(function0, this, null), 3, (Object) null);
    }

    public final String k() {
        Lottery lottery = (Lottery) this.c.f();
        if (lottery != null) {
            return lottery.getActivityId();
        }
        return null;
    }

    public final SkuPoint l() {
        Banner banner;
        Lottery lottery = (Lottery) this.c.f();
        if (lottery == null || (banner = lottery.getBanner()) == null) {
            return null;
        }
        return banner.getSku();
    }

    public final b0 m() {
        return this.i;
    }

    public final b0 n() {
        return this.k;
    }

    public final b0 o() {
        return this.h;
    }

    public final b0 p() {
        return this.c;
    }

    public final String q() {
        return this.j;
    }

    public final b0 r() {
        return this.e;
    }

    public final b0 t() {
        return this.g;
    }

    public final String u() {
        Banner banner;
        Lottery lottery = (Lottery) this.c.f();
        if (lottery == null || (banner = lottery.getBanner()) == null) {
            return null;
        }
        return banner.getSkuId();
    }

    public final b0 v() {
        return this.f;
    }

    public final User w() {
        return (User) this.d.f();
    }

    public final b0 x() {
        return this.d;
    }

    public final void y(AppCompatActivity appCompatActivity, String str) {
        Intrinsics.h(appCompatActivity, "activity");
        Intrinsics.h(str, "phone");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("phone", str);
        linkedHashMap.put("activity", "lottery");
        com.transsion.payment.lib.f a = com.transsion.payment.lib.f.b.a();
        String u = u();
        if (u == null) {
            u = BuildConfig.FLAVOR;
        }
        a.e(appCompatActivity, u, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? false : false, (r16 & 16) != 0 ? null : linkedHashMap, new com.transsion.payment.lib.b() { // from class: com.transsion.rewardscenter.model.RewardsCenterModel$payment$1
            @Override // com.transsion.payment.lib.b
            public void a(Integer num, String str2, boolean z, String str3) {
                a.a.f(wf.a.a, "RewardsCenter", "Payment failed " + str2 + ", " + num, false, 4, (Object) null);
                if (str2 == null) {
                    str2 = "top-up failed, Please try again.";
                }
                p.a(false, str2);
            }

            @Override // com.transsion.payment.lib.b
            public void b(boolean z) {
                a.a.f(wf.a.a, "RewardsCenter", "onPendingTransition()", false, 4, (Object) null);
            }

            @Override // com.transsion.payment.lib.b
            public void c(int i, String str2, String str3) {
                Intrinsics.h(str2, "balance");
                RewardsCenterModel.h(RewardsCenterModel.this, str3, false, 2, null);
                kotlinx.coroutines.i.d(u0.a(RewardsCenterModel.this), (CoroutineContext) null, (CoroutineStart) null, new RewardsCenterModel$payment$1$success$1(RewardsCenterModel.this, null), 3, (Object) null);
            }
        });
    }
}
