package com.transsion.home.adapter.trending;

import android.widget.ImageView;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.mediation.ad.TMediaView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.wrapperad.R;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class BannerADDataHelper {
    private static BiddingNativeManager c;
    private static Function2 d;
    private static NativeWrapperAdView e;
    private static boolean f;
    private static boolean g;
    public static final BannerADDataHelper a = new BannerADDataHelper();
    private static int b = 1;
    private static final a h = new a();
    public static final int i = 8;

    public static final class a extends oh.a {
        a() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            a.a.f(wf.a.a, "BannerADDataHelper", "--> onBiddingError() --> p0 = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), false, 4, (Object) null);
            Function2 function2 = BannerADDataHelper.d;
            if (function2 != null) {
                function2.invoke((Object) null, Integer.valueOf(BannerADDataHelper.b));
            }
            BannerADDataHelper.f = false;
            BannerADDataHelper.g = true;
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            a.a.f(wf.a.a, "BannerADDataHelper", "--> onBiddingLoad() --> " + biddingIntermediateMaterialBean, false, 4, (Object) null);
            Function2 function2 = BannerADDataHelper.d;
            if (function2 != null) {
                function2.invoke(biddingIntermediateMaterialBean, Integer.valueOf(BannerADDataHelper.b));
            }
            BannerADDataHelper.f = false;
            BannerADDataHelper.g = false;
        }

        public void n(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.n(biddingIntermediateMaterialBean);
            BannerADDataHelper.g = true;
        }

        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            BannerADDataHelper.g = true;
        }
    }

    private BannerADDataHelper() {
    }

    public final void i(NativeWrapperAdView nativeWrapperAdView, r rVar, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        e = nativeWrapperAdView;
        if (nativeWrapperAdView != null) {
            nativeWrapperAdView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (nativeWrapperAdView != null) {
            nativeWrapperAdView.bindNativeView(c, rVar, biddingIntermediateMaterialBean);
        }
    }

    public final void j() {
        BiddingNativeManager biddingNativeManager = c;
        if (biddingNativeManager != null) {
            biddingNativeManager.U();
        }
        c = null;
    }

    public final void k(Function2 function2) {
        if (f) {
            return;
        }
        f = true;
        d = function2;
        j();
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new BannerADDataHelper$fetchData$1(null), 3, (Object) null);
    }

    public final void l() {
        TMediaView findViewById;
        NativeWrapperAdView nativeWrapperAdView = e;
        if (nativeWrapperAdView == null || (findViewById = nativeWrapperAdView.findViewById(R.id.ad_media)) == null) {
            return;
        }
        findViewById.performClick();
    }

    public final boolean m() {
        return g;
    }

    public final void n() {
        e = null;
    }
}
