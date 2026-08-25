package com.transsion.ad.bidding.gemini;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.cloud.hisavana.sdk.common.activity.c;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xh.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class AbsBiddingBuyOutGemini implements b {
    public static final a g = new a(null);
    private oh.a a;
    private Integer c;
    private boolean e;
    private String b = TtmlNode.ANONYMOUS_REGION_ID;
    private Boolean d = Boolean.TRUE;
    private final BroadcastReceiver f = new BroadcastReceiver() { // from class: com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini$myReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.h(intent, "intent");
            AbsBiddingBuyOutGemini.this.o(context, intent);
        }
    };

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String f() {
        return "com.transsion.ad.bidding." + e() + ".click";
    }

    private final String g() {
        return "com.transsion.ad.bidding." + e() + ".close";
    }

    private final String h() {
        return "com.transsion.ad.bidding." + e() + ".display";
    }

    private final String i() {
        return "com.transsion.ad.bidding." + e() + ".display_timestamp";
    }

    private final oh.a j() {
        return this.a;
    }

    private final String k() {
        return "com.transsion.ad.bidding." + e() + ".resume";
    }

    private final String l() {
        return "com.transsion.ad.bidding." + e() + ".rewarded";
    }

    private final String m() {
        return "com.transsion.ad.bidding." + e() + ".show_error";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(Context context, Intent intent) {
        oh.a j;
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = Build.VERSION.SDK_INT >= 33 ? (BiddingIntermediateMaterialBean) c.a(intent, "ad_max_ecpm_object", BiddingIntermediateMaterialBean.class) : (BiddingIntermediateMaterialBean) intent.getParcelableExtra("ad_max_ecpm_object");
        long longExtra = intent.getLongExtra("display_timestamp", 0L);
        String action = intent.getAction();
        if (Intrinsics.c(action, k())) {
            oh.a j2 = j();
            if (j2 != null) {
                j2.f(biddingIntermediateMaterialBean);
                return;
            }
            return;
        }
        if (Intrinsics.c(action, h())) {
            oh.a j3 = j();
            if (j3 != null) {
                j3.c(biddingIntermediateMaterialBean);
                return;
            }
            return;
        }
        if (Intrinsics.c(action, f())) {
            oh.a j4 = j();
            if (j4 != null) {
                j4.a(biddingIntermediateMaterialBean);
                return;
            }
            return;
        }
        if (Intrinsics.c(action, l())) {
            oh.a j5 = j();
            if (j5 != null) {
                j5.g(biddingIntermediateMaterialBean);
                return;
            }
            return;
        }
        if (Intrinsics.c(action, i())) {
            oh.a j6 = j();
            if (j6 != null) {
                j6.d(biddingIntermediateMaterialBean, longExtra);
                return;
            }
            return;
        }
        if (Intrinsics.c(action, g())) {
            oh.a j7 = j();
            if (j7 != null) {
                j7.b(biddingIntermediateMaterialBean);
                return;
            }
            return;
        }
        if (!Intrinsics.c(action, m()) || (j = j()) == null) {
            return;
        }
        j.h(null, biddingIntermediateMaterialBean);
    }

    public final void b() {
        r1.a.b(Utils.a()).e(this.f);
        r(null);
        this.e = false;
    }

    public abstract Class c();

    public final String d() {
        return com.transsion.ad.scene.a.a.a(getSceneId());
    }

    public abstract String e();

    public String getClassTag() {
        return b.a.a(this);
    }

    public String getSceneId() {
        return this.b;
    }

    public final AbsBiddingBuyOutGemini n(Boolean bool) {
        this.d = bool;
        return this;
    }

    public void onLog(int i, String str, String str2, boolean z) {
        b.a.b(this, i, str, str2, z);
    }

    public final AbsBiddingBuyOutGemini p() {
        if (!this.e) {
            this.e = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(k());
            intentFilter.addAction(h());
            intentFilter.addAction(f());
            intentFilter.addAction(l());
            intentFilter.addAction(i());
            intentFilter.addAction(g());
            intentFilter.addAction(m());
            r1.a.b(Utils.a()).c(this.f, intentFilter);
        }
        return this;
    }

    public final AbsBiddingBuyOutGemini q(Integer num) {
        this.c = num;
        return this;
    }

    public final AbsBiddingBuyOutGemini r(oh.a aVar) {
        this.a = aVar;
        return this;
    }

    public final AbsBiddingBuyOutGemini s(String str) {
        Intrinsics.h(str, "sceneId");
        this.b = str;
        return this;
    }

    public final void t(Context context, String str, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        Object obj;
        oh.a j;
        Unit unit;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            if (context != null) {
                Intent intent = new Intent(context, (Class<?>) c());
                intent.putExtra(TrackingKey.SCENE_ID, str);
                intent.putExtra("ad_max_ecpm_object", biddingIntermediateMaterialBean);
                intent.putExtra("app_layout_id", this.c);
                intent.putExtra("is_show_member_btn", this.d);
                intent.putExtra("action_resume", k());
                intent.putExtra("action_display", h());
                intent.putExtra("action_click", f());
                intent.putExtra("action_display_timestamp", i());
                intent.putExtra("action_rewarded", l());
                intent.putExtra("action_close", g());
                intent.putExtra("show_error", m());
                context.startActivity(intent);
                unit = Unit.a;
            } else {
                unit = null;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 == null || (j = j()) == null) {
            return;
        }
        j.h(new TAdErrorCode(102, String.valueOf(th2.getMessage())), null);
    }
}
