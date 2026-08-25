package com.transsion.shorttv.ad.common;

import android.app.Activity;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.ad.AdLoadState;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class STCommonVideoAdHelper {
    private final String a;
    private final n0 b;
    private BiddingVideoManager c;
    private BiddingIntermediateMaterialBean d;
    private Function3 e;
    private Function0 f;
    private Function1 g;
    private String h;
    private AdLoadState i;
    private boolean j;
    private final STCommonVideoAdHelper$videoListener$1 k;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.transsion.shorttv.ad.common.STCommonVideoAdHelper$videoListener$1] */
    public STCommonVideoAdHelper(String str, n0 n0Var) {
        Intrinsics.h(str, "sceneId");
        Intrinsics.h(n0Var, "scope");
        this.a = str;
        this.b = n0Var;
        this.h = BuildConfig.FLAVOR;
        this.i = AdLoadState.IDLE;
        this.k = new oh.a() { // from class: com.transsion.shorttv.ad.common.STCommonVideoAdHelper$videoListener$1
            public void i(TAdErrorCode tAdErrorCode) {
                BiddingVideoManager biddingVideoManager;
                n0 n0Var2;
                super.i(tAdErrorCode);
                STCommonVideoAdHelper.this.i = AdLoadState.FAILED;
                yq.a aVar = yq.a.a;
                String r = STCommonVideoAdHelper.this.r();
                String str2 = "onBiddingError, error=" + tAdErrorCode;
                biddingVideoManager = STCommonVideoAdHelper.this.c;
                aVar.d(r, str2, biddingVideoManager != null ? biddingVideoManager.getSceneId() : null);
                n0Var2 = STCommonVideoAdHelper.this.b;
                i.d(n0Var2, y0.c(), (CoroutineStart) null, new STCommonVideoAdHelper$videoListener$1$onBiddingError$1(STCommonVideoAdHelper.this, tAdErrorCode, null), 2, (Object) null);
            }

            public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingVideoManager biddingVideoManager;
                n0 n0Var2;
                super.j(biddingIntermediateMaterialBean);
                STCommonVideoAdHelper.this.i = AdLoadState.SUCCEED;
                yq.a aVar = yq.a.a;
                String r = STCommonVideoAdHelper.this.r();
                biddingVideoManager = STCommonVideoAdHelper.this.c;
                aVar.b(r, "onBiddingLoad", biddingVideoManager != null ? biddingVideoManager.getSceneId() : null);
                STCommonVideoAdHelper.this.d = biddingIntermediateMaterialBean;
                n0Var2 = STCommonVideoAdHelper.this.b;
                i.d(n0Var2, y0.c(), (CoroutineStart) null, new STCommonVideoAdHelper$videoListener$1$onBiddingLoad$1(STCommonVideoAdHelper.this, null), 2, (Object) null);
            }

            public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                boolean z;
                BiddingVideoManager biddingVideoManager;
                boolean z2;
                n0 n0Var2;
                super.m(biddingIntermediateMaterialBean);
                STCommonVideoAdHelper.this.i = AdLoadState.CLOSED;
                yq.a aVar = yq.a.a;
                String r = STCommonVideoAdHelper.this.r();
                z = STCommonVideoAdHelper.this.j;
                String str2 = "onBiddingWrapperAdClose, isRewarded=" + z;
                biddingVideoManager = STCommonVideoAdHelper.this.c;
                aVar.b(r, str2, biddingVideoManager != null ? biddingVideoManager.getSceneId() : null);
                z2 = STCommonVideoAdHelper.this.j;
                n0Var2 = STCommonVideoAdHelper.this.b;
                i.d(n0Var2, y0.c(), (CoroutineStart) null, new STCommonVideoAdHelper$videoListener$1$onBiddingWrapperAdClose$1(STCommonVideoAdHelper.this, z2, null), 2, (Object) null);
            }

            public void o(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingVideoManager biddingVideoManager;
                n0 n0Var2;
                super.o(biddingIntermediateMaterialBean);
                yq.a aVar = yq.a.a;
                String r = STCommonVideoAdHelper.this.r();
                biddingVideoManager = STCommonVideoAdHelper.this.c;
                aVar.b(r, "onBiddingWrapperAdRewarded", biddingVideoManager != null ? biddingVideoManager.getSceneId() : null);
                STCommonVideoAdHelper.this.j = true;
                n0Var2 = STCommonVideoAdHelper.this.b;
                i.d(n0Var2, y0.c(), (CoroutineStart) null, new STCommonVideoAdHelper$videoListener$1$onBiddingWrapperAdRewarded$1(STCommonVideoAdHelper.this, null), 2, (Object) null);
            }
        };
    }

    public static /* synthetic */ void q(STCommonVideoAdHelper sTCommonVideoAdHelper, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        sTCommonVideoAdHelper.p(i);
    }

    public final void p(int i) {
        this.i = AdLoadState.DESTROYED;
        try {
            Result.Companion companion = Result.Companion;
            if (this.c != null) {
                if (i == 0) {
                    yq.a.a.b(this.h, "trigger destroy", this.a);
                } else if (i == 1) {
                    yq.a.a.b(this.h, "trigger destroy when load error", this.a);
                } else if (i == 3) {
                    yq.a.a.b(this.h, "trigger destroy before load", this.a);
                } else if (i != 4) {
                    yq.a.a.b(this.h, "trigger destroy", this.a);
                } else {
                    yq.a.a.b(this.h, "trigger destroy when ad closed", this.a);
                }
                BiddingVideoManager biddingVideoManager = this.c;
                if (biddingVideoManager != null) {
                    biddingVideoManager.U();
                }
                this.c = null;
            }
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public final String r() {
        return this.h;
    }

    public final String s() {
        return this.a;
    }

    public final void t(Function3 function3) {
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
            i.d(this.b, y0.c(), (CoroutineStart) null, new STCommonVideoAdHelper$loadAd$1(this, function3, null), 2, (Object) null);
        }
    }

    public final void u(Activity activity, Function0 function0, Function1 function1) {
        Intrinsics.h(activity, "activity");
        if (this.c == null || this.d == null) {
            yq.a.a.d(this.h, "trigger show ad error, videoManager or maxEcpmObject is null", this.a);
        } else {
            i.d(this.b, y0.c(), (CoroutineStart) null, new STCommonVideoAdHelper$showAd$1(this, function0, function1, activity, null), 2, (Object) null);
        }
    }
}
