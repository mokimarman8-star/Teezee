package com.transsion.ad.strategy;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.gslb.BuildConfig;
import java.util.Map;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HotSplashManager extends oh.a {
    private static long e;
    private static boolean f;
    private static BiddingInterstitialManager g;
    public static final HotSplashManager d = new HotSplashManager();
    private static final Handler h = new Handler(Looper.getMainLooper());

    private HotSplashManager() {
    }

    private final String B() {
        JsonElement jsonElement;
        Activity b = com.blankj.utilcode.util.a.b();
        if (b == null) {
            return "topAct is null";
        }
        if (b.isDestroyed()) {
            return "topAct?.isDestroyed == true";
        }
        ci.o oVar = ci.o.a;
        if (!oVar.a(b) || oVar.b(b)) {
            return "处理App在锁屏状态下被拉活";
        }
        rh.c cVar = rh.c.a;
        if (cVar.a()) {
            cVar.b(false);
            return "全搜的时候热启动不展示热启动广告";
        }
        if (e <= 0) {
            return "inBackgroundTime <= 0";
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - e;
        JsonObject b2 = com.transsion.ad.scene.d.a.b(rh.d.a.a());
        int asInt = ((b2 == null || (jsonElement = b2.get("hotSplashInterval")) == null) ? 1 : jsonElement.getAsInt()) * 60000;
        if (elapsedRealtime >= asInt) {
            return BuildConfig.FLAVOR;
        }
        return "不满足最小间隔时间 -- background_time = " + elapsedRealtime + " --- TIME_IN_THE_BACKGROUND = " + asInt;
    }

    private final void C() {
        String B = B();
        if (TextUtils.isEmpty(B)) {
            if (g != null) {
                return;
            }
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new HotSplashManager$loadHotSplashAd$1(null), 3, (Object) null);
            return;
        }
        xh.a.a.l("ad_int", getClassTag() + " --> loadHotSplashAd() --> msg = " + B, 6, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E() {
        d.C();
    }

    private final void G() {
        BiddingInterstitialManager biddingInterstitialManager = g;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.U();
        }
        g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = HotSplashManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void D() {
        xh.a.m(xh.a.a, "ad_int", getClassTag() + " --> onStop() --> App进入前台", 0, false, 4, null);
        f = false;
        Handler handler = h;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() { // from class: com.transsion.ad.strategy.i
            @Override // java.lang.Runnable
            public final void run() {
                HotSplashManager.E();
            }
        }, 300L);
    }

    public final void F() {
        xh.a.m(xh.a.a, "ad_int", getClassTag() + " --> onStop() --> App进入后台", 0, false, 4, null);
        e = SystemClock.elapsedRealtime();
        f = true;
        h.removeCallbacksAndMessages(null);
        BiddingInterstitialManager.Companion.b(BiddingInterstitialManager.t, rh.d.a.a(), (Map) null, 2, (Object) null);
    }

    public void i(TAdErrorCode tAdErrorCode) {
        super.i(tAdErrorCode);
        G();
    }

    public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.j(biddingIntermediateMaterialBean);
        AppCompatActivity b = com.blankj.utilcode.util.a.b();
        if (b != null) {
            AppCompatActivity appCompatActivity = b instanceof AppCompatActivity ? b : null;
            if (appCompatActivity != null) {
                kotlinx.coroutines.i.d(androidx.lifecycle.v.a(appCompatActivity), (CoroutineContext) null, (CoroutineStart) null, new HotSplashManager$onBiddingLoad$1$1$1(b, biddingIntermediateMaterialBean, null), 3, (Object) null);
            }
        }
    }

    public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.m(biddingIntermediateMaterialBean);
        G();
    }

    public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.p(biddingIntermediateMaterialBean);
        G();
    }
}
