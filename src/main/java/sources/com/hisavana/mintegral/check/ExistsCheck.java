package com.hisavana.mintegral.check;

import android.content.Context;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.AdSourceConfig;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBaseAdSummary;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mintegral.bidding.MintegralBidding;
import com.hisavana.mintegral.check.MBridgeSDKManager;
import com.hisavana.mintegral.executer.MintegralBanner;
import com.hisavana.mintegral.executer.MintegralInterstitial;
import com.hisavana.mintegral.executer.MintegralNative;
import com.hisavana.mintegral.executer.MintegralSplash;
import com.hisavana.mintegral.executer.MintegralVideo;
import com.hisavana.mintegral.holder.NativeAdViewHolder;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ExistsCheck implements IBaseAdSummary {
    public static final String MINTEGRAL_TAG = "mintegral_log";
    public static boolean isDebug;

    public static void initAdSource(String str, String str2, MBridgeSDKManager.MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        AdLogUtil.Log().d(MINTEGRAL_TAG, "initAdSource，mintegralAppID：" + str + "，mintegralAppKey：" + str2);
        try {
            MBridgeSDKManager.getInstance().initialize(e.a(), str2, str, isDebug, (Map) null, mBridgeSDKInitializeListener);
        } catch (Exception e) {
            AdLogUtil.Log().e(ComConstants.SDK_INIT, "ExistsCheck --> Mintegral--> initialize exception");
            mBridgeSDKInitializeListener.onInitializeFailure(e.getMessage());
        }
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseBanner getBanner(Context context, Network network, int i, int i2) {
        return new MintegralBanner(context, network, i);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseInterstitial getInterstitial(Context context, Network network) {
        return new MintegralInterstitial(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNative getNative(Context context, Network network, int i) {
        return new MintegralNative(context, network, i);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNativeViewHolder getNativeViewHolder() {
        return new NativeAdViewHolder();
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseQueryPrice getQueryPrice() {
        return new MintegralBidding();
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseSplash getSplash(Context context, Network network) {
        return new MintegralSplash(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseVideo getVideo(Context context, Network network) {
        return new MintegralVideo(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public void init(Context context, AdSourceConfig adSourceConfig) {
        if (context == null || adSourceConfig == null) {
            AdLogUtil.Log().d(MINTEGRAL_TAG, "mintegral initialize exception");
        } else {
            isDebug = adSourceConfig.isDebug;
        }
    }
}
