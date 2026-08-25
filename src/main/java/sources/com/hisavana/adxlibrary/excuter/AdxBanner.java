package com.hisavana.adxlibrary.excuter;

import android.content.Context;
import c7.b;
import com.cloud.hisavana.sdk.api.adx.TBannerView;
import com.cloud.hisavana.sdk.api.listener.d;
import com.cloud.hisavana.sdk.common.bean.AdActiveInfo;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class AdxBanner extends BaseBanner<TBannerView> {
    public TBannerView a;

    public class a extends d {
        public a() {
        }

        public void onAdActivate(AdActiveInfo adActiveInfo) {
            AdxBanner.this.adActivate(adActiveInfo);
        }

        public void onAdClicked() {
            AdLogUtil.Log().d("AdxBanner", "banner is click" + AdxBanner.this.getLogString());
            AdxBanner.this.adClicked(null);
        }

        public void onAdClosed(TBannerView tBannerView) {
            AdLogUtil.Log().d("AdxBanner", "banner onAdClosed" + AdxBanner.this.getLogString());
            AdxBanner.this.adClosed();
        }

        public void onAdLoaded() {
            AdLogUtil.Log().d("AdxBanner", "banner is Loaded" + AdxBanner.this.getLogString());
            if (AdxBanner.this.a != null) {
                double bidPrice = AdxBanner.this.a.getBidPrice();
                if (bidPrice > 0.0d) {
                    AdxBanner.this.setEcpmPrice(bidPrice);
                }
            }
            AdxBanner.this.adLoaded();
        }

        public void onAdShow() {
            AdLogUtil.Log().d("AdxBanner", "banner onAdShow" + AdxBanner.this.getLogString());
            AdxBanner.this.adImpression(null);
        }

        public void onAdShowError(TaErrorCode taErrorCode) {
            AdLogUtil.Log().d("AdxBanner", "banner onAdShowError" + AdxBanner.this.getLogString());
            AdxBanner.this.onAdShowError(taErrorCode != null ? new TAdErrorCode(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage()) : TAdErrorCode.ERROR_SHOW_EXCEPTION);
        }

        public void onError(TaErrorCode taErrorCode) {
            AdLogUtil.Log().w("AdxBanner", "banner is Load error:" + taErrorCode.getErrorCode() + " msg:" + taErrorCode.getErrorMessage() + AdxBanner.this.getLogString());
            AdxBanner.this.adFailedToLoad(new TAdErrorCode(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage()));
        }
    }

    public AdxBanner(Context context, Network network, int i) {
        super(context, network);
        AdLogUtil.Log().d("AdxBanner", "bannerSize:=" + i + getLogString());
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.interfacz.IadView
    public boolean canShow() {
        TBannerView tBannerView = this.a;
        return tBannerView != null ? tBannerView.isReady() : super.canShow();
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        AdLogUtil.Log().d("AdxBanner", "destroy" + getLogString());
    }

    @Override // com.hisavana.common.base.BaseBanner
    public TBannerView getBanner() {
        Network network;
        AdLogUtil.Log().d("AdxBanner", "getBanner " + this.requestType);
        if (this.a == null && (network = this.mNetwork) != null) {
            b.b = network.getApplicationId();
            this.a = new TBannerView(e.a(), this.mNetwork.getCodeSeatId());
            a aVar = new a();
            this.a.setRequest(d7.a.a().a());
            this.a.setListener(aVar);
            this.a.setPlacementId(this.mNetwork.getCodeSeatId());
            this.a.setHideAdCloseView(this.isHideAdCloseView);
            this.a.setCloseDirectlyWithoutJumping(this.isCloseDirectly);
        }
        return this.a;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isAdxAd() {
        TBannerView tBannerView = this.a;
        return tBannerView != null && tBannerView.getAdSource() == 2;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isEwAd() {
        TBannerView tBannerView = this.a;
        return tBannerView != null && tBannerView.getAdSource() == 1;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isExpired() {
        TBannerView tBannerView = this.a;
        return tBannerView != null ? !tBannerView.isReady() || super.isExpired() : super.isExpired();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isInternalAd() {
        TBannerView tBannerView = this.a;
        return tBannerView != null && tBannerView.isDefaultAd();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isMatchVulgarBrand() {
        TBannerView tBannerView = this.a;
        return tBannerView != null && tBannerView.isMatchVulgarBrand();
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.interfacz.ICacheAd
    public boolean isOfflineAd() {
        TBannerView tBannerView = this.a;
        return tBannerView != null && tBannerView.getFillAdType() == 1;
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerDestroy() {
        TBannerView tBannerView = this.a;
        if (tBannerView != null) {
            tBannerView.destroy();
            this.a = null;
        }
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerLoad() {
        TBannerView tBannerView = this.a;
        if (tBannerView == null || tBannerView.getRequest() == null) {
            return;
        }
        AdLogUtil.Log().d("AdxBanner", "onBannerLoad " + this.a.getRequest());
        d7.a request = this.a.getRequest();
        request.k(this.requestType);
        request.l("hisa-" + this.mTriggerId);
        request.j("hisa-" + this.mRequestId);
        request.i(getSupportHisavanaFlag() >= 2);
        this.a.setRequest(request);
        this.a.setContainVulgarContent(this.isContainVulgarContent);
        this.a.setAdLoadScenes(this.mGameName, this.mGameScene, this.mExtInfo);
        this.a.setCurrActivityFullscreen(this.mCurrActivityFullscreen);
        this.a.loadAd();
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void showBanner() {
        TBannerView tBannerView = this.a;
        if (tBannerView == null) {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e("AdxBanner", "showBanner show error");
            return;
        }
        if (this.secondPrice != 0.0d && tBannerView.getRequest() != null) {
            d7.a request = this.a.getRequest();
            request.h(this.secondPrice);
            this.a.setRequest(request);
        }
        this.a.show();
    }
}
