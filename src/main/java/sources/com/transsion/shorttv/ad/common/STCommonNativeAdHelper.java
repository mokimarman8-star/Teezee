package com.transsion.shorttv.ad.common;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.ad.AdLoadState;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class STCommonNativeAdHelper {
    private final String a;
    private final n0 b;
    private BiddingNativeManager c;
    private BiddingIntermediateMaterialBean d;
    private Function1 e;
    private Function1 f;
    private WeakReference g;
    private String h;
    private AdLoadState i;
    private final STCommonNativeAdHelper$nativeAdListener$1 j;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.transsion.shorttv.ad.common.STCommonNativeAdHelper$nativeAdListener$1] */
    public STCommonNativeAdHelper(String str, n0 n0Var) {
        Intrinsics.h(str, "sceneId");
        Intrinsics.h(n0Var, "scope");
        this.a = str;
        this.b = n0Var;
        this.h = BuildConfig.FLAVOR;
        this.i = AdLoadState.IDLE;
        this.j = new oh.a() { // from class: com.transsion.shorttv.ad.common.STCommonNativeAdHelper$nativeAdListener$1
            public void i(TAdErrorCode tAdErrorCode) {
                BiddingNativeManager biddingNativeManager;
                n0 n0Var2;
                super.i(tAdErrorCode);
                STCommonNativeAdHelper.this.i = AdLoadState.FAILED;
                yq.a aVar = yq.a.a;
                String o = STCommonNativeAdHelper.this.o();
                String str2 = "onBiddingError, error=" + tAdErrorCode;
                biddingNativeManager = STCommonNativeAdHelper.this.c;
                aVar.d(o, str2, biddingNativeManager != null ? biddingNativeManager.getSceneId() : null);
                n0Var2 = STCommonNativeAdHelper.this.b;
                i.d(n0Var2, y0.c(), (CoroutineStart) null, new STCommonNativeAdHelper$nativeAdListener$1$onBiddingError$1(STCommonNativeAdHelper.this, null), 2, (Object) null);
            }

            public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingNativeManager biddingNativeManager;
                n0 n0Var2;
                super.j(biddingIntermediateMaterialBean);
                STCommonNativeAdHelper.this.i = AdLoadState.SUCCEED;
                yq.a aVar = yq.a.a;
                String o = STCommonNativeAdHelper.this.o();
                biddingNativeManager = STCommonNativeAdHelper.this.c;
                aVar.b(o, "onBiddingLoad", biddingNativeManager != null ? biddingNativeManager.getSceneId() : null);
                STCommonNativeAdHelper.this.d = biddingIntermediateMaterialBean;
                n0Var2 = STCommonNativeAdHelper.this.b;
                i.d(n0Var2, y0.c(), (CoroutineStart) null, new STCommonNativeAdHelper$nativeAdListener$1$onBiddingLoad$1(STCommonNativeAdHelper.this, null), 2, (Object) null);
            }

            public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingNativeManager biddingNativeManager;
                super.m(biddingIntermediateMaterialBean);
                STCommonNativeAdHelper.this.i = AdLoadState.CLOSED;
                yq.a aVar = yq.a.a;
                String o = STCommonNativeAdHelper.this.o();
                biddingNativeManager = STCommonNativeAdHelper.this.c;
                aVar.d(o, "onBiddingWrapperAdClose", biddingNativeManager != null ? biddingNativeManager.getSceneId() : null);
                STCommonNativeAdHelper.this.m(4);
            }

            public void n(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingNativeManager biddingNativeManager;
                n0 n0Var2;
                super.n(biddingIntermediateMaterialBean);
                yq.a aVar = yq.a.a;
                String o = STCommonNativeAdHelper.this.o();
                biddingNativeManager = STCommonNativeAdHelper.this.c;
                aVar.b(o, "onBiddingWrapperAdDisplay", biddingNativeManager != null ? biddingNativeManager.getSceneId() : null);
                n0Var2 = STCommonNativeAdHelper.this.b;
                i.d(n0Var2, y0.c(), (CoroutineStart) null, new STCommonNativeAdHelper$nativeAdListener$1$onBiddingWrapperAdDisplay$1(STCommonNativeAdHelper.this, null), 2, (Object) null);
            }

            public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingNativeManager biddingNativeManager;
                n0 n0Var2;
                super.p(biddingIntermediateMaterialBean);
                yq.a aVar = yq.a.a;
                String o = STCommonNativeAdHelper.this.o();
                biddingNativeManager = STCommonNativeAdHelper.this.c;
                aVar.d(o, "onBiddingWrapperAdShowError", biddingNativeManager != null ? biddingNativeManager.getSceneId() : null);
                n0Var2 = STCommonNativeAdHelper.this.b;
                i.d(n0Var2, y0.c(), (CoroutineStart) null, new STCommonNativeAdHelper$nativeAdListener$1$onBiddingWrapperAdShowError$1(STCommonNativeAdHelper.this, null), 2, (Object) null);
            }
        };
    }

    public static /* synthetic */ void n(STCommonNativeAdHelper sTCommonNativeAdHelper, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        sTCommonNativeAdHelper.m(i);
    }

    public final void m(int i) {
        this.i = AdLoadState.DESTROYED;
        try {
            Result.Companion companion = Result.Companion;
            if (this.c != null) {
                if (i == 0) {
                    yq.a.a.b(this.h, "trigger destroy", this.a);
                } else if (i == 1) {
                    yq.a.a.b(this.h, "trigger destroy when load error", this.a);
                } else if (i == 2) {
                    yq.a.a.b(this.h, "trigger destroy when show error", this.a);
                } else if (i == 3) {
                    yq.a.a.b(this.h, "trigger destroy before load", this.a);
                } else if (i != 4) {
                    yq.a.a.b(this.h, "trigger destroy", this.a);
                } else {
                    yq.a.a.b(this.h, "trigger destroy when ad closed", this.a);
                }
                BiddingNativeManager biddingNativeManager = this.c;
                if (biddingNativeManager != null) {
                    biddingNativeManager.U();
                }
                this.c = null;
            }
            this.d = null;
            this.e = null;
            this.f = null;
            WeakReference weakReference = this.g;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.g = null;
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public final String o() {
        return this.h;
    }

    public final String p() {
        return this.a;
    }

    public final void q(Function1 function1) {
        Intrinsics.h(function1, "callback");
        if (this.a.length() == 0) {
            yq.a.a.d(this.h, "trigger load ad error, sceneId is null", this.a);
            return;
        }
        AdLoadState adLoadState = this.i;
        if (adLoadState == AdLoadState.LOADING) {
            yq.a.a.d(this.h, "trigger load ad error, current ad is loading", this.a);
        } else if (adLoadState == AdLoadState.SUCCEED) {
            yq.a.a.d(this.h, "trigger load ad error, current ad is already loaded succeed", this.a);
        } else {
            i.d(this.b, y0.c(), (CoroutineStart) null, new STCommonNativeAdHelper$loadAd$1(this, function1, null), 2, (Object) null);
        }
    }

    public final void r(String str) {
        Intrinsics.h(str, "<set-?>");
        this.h = str;
    }

    public final void s(r rVar, NativeWrapperAdView nativeWrapperAdView, Function1 function1) {
        Intrinsics.h(rVar, "layoutProvider");
        Intrinsics.h(nativeWrapperAdView, "nativeAdView");
        if (this.c != null && this.d != null) {
            i.d(this.b, y0.c(), (CoroutineStart) null, new STCommonNativeAdHelper$showAd$1(this, function1, nativeWrapperAdView, rVar, null), 2, (Object) null);
            return;
        }
        yq.a.a.d(this.h, "trigger show ad error, nativeManager or maxEcpmObject is null", this.a);
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }
}
