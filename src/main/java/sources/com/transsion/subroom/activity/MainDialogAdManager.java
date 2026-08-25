package com.transsion.subroom.activity;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class MainDialogAdManager extends oh.a {
    private MainActivity d;
    private BiddingInterstitialManager e;

    private final void A() {
        BiddingInterstitialManager biddingInterstitialManager = this.e;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.U();
        }
        this.e = null;
    }

    public void i(TAdErrorCode tAdErrorCode) {
        super.i(tAdErrorCode);
        A();
    }

    public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.j(biddingIntermediateMaterialBean);
        BiddingInterstitialManager biddingInterstitialManager = this.e;
        if (biddingInterstitialManager != null) {
            AbsAdBidding.O0(biddingInterstitialManager, this.d, biddingIntermediateMaterialBean, false, 4, (Object) null);
        }
    }

    public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.m(biddingIntermediateMaterialBean);
        A();
    }

    public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.p(biddingIntermediateMaterialBean);
        A();
    }

    public final void z(MainActivity activity) {
        Intrinsics.h(activity, "activity");
        if (!rh.c.a.a() && this.e == null) {
            this.d = activity;
            kotlinx.coroutines.k.d(androidx.lifecycle.v.a(activity), null, null, new MainDialogAdManager$loadAd$1(this, null), 3, null);
        }
    }
}
