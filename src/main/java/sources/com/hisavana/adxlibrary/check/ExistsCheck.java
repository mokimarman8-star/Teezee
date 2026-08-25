package com.hisavana.adxlibrary.check;

import android.content.Context;
import c7.b;
import ce.a;
import com.hisavana.adxlibrary.excuter.AdxBanner;
import com.hisavana.adxlibrary.excuter.AdxInterstitia;
import com.hisavana.adxlibrary.excuter.AdxNative;
import com.hisavana.adxlibrary.excuter.AdxRewarded;
import com.hisavana.adxlibrary.excuter.AdxSplash;
import com.hisavana.adxlibrary.holder.NativeAdViewHolder;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.AdMuteStatus;
import com.hisavana.common.bean.AdSourceConfig;
import com.hisavana.common.bean.Network;
import com.hisavana.common.interfacz.IBaseAdSummary;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ExistsCheck implements IBaseAdSummary {
    public void check() {
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseBanner getBanner(Context context, Network network, int i, int i2) {
        return a.a(context, network, new AdxBanner(context, network, i));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseInterstitial getInterstitial(Context context, Network network) {
        return a.b(context, network, new AdxInterstitia(context, network));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNative getNative(Context context, Network network, int i) {
        return a.c(context, network, i, new AdxNative(context, network, i));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNativeViewHolder getNativeViewHolder() {
        return new NativeAdViewHolder();
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseQueryPrice getQueryPrice() {
        return null;
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseSplash getSplash(Context context, Network network) {
        return new AdxSplash(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseVideo getVideo(Context context, Network network) {
        return new AdxRewarded(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public void init(Context context, AdSourceConfig adSourceConfig) {
        b.b bVar = new b.b();
        bVar.i(adSourceConfig.pkgEvn).o(adSourceConfig.testDevice).m(adSourceConfig.isEnableRewardedToast).k(adSourceConfig.isEnableWebRecommendFeature).h(adSourceConfig.appId).n(adSourceConfig.shouldOptimizeImageLoading);
        long j = adSourceConfig.defaultVersion;
        if (j > 0) {
            bVar.l(j);
        }
        int i = adSourceConfig.defaultMaterialMaxSize;
        if (i > 0) {
            bVar.j(i);
        }
        b.k(context, bVar.c());
        b.q(AdMuteStatus.MUTE_ALL);
    }
}
