package com.hisavana.pangle.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.MediationImageLoader;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class NativeAdViewHolder extends BaseNativeViewHolder {
    private PAGNativeAdData b;

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    protected View createChoicesView(Context context, TAdNativeInfo tAdNativeInfo) {
        PAGNativeAdData pAGNativeAdData = this.b;
        if (pAGNativeAdData != null) {
            return pAGNativeAdData.getAdLogoView();
        }
        return null;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    protected View createMediaView(Context context, TAdNativeInfo tAdNativeInfo, ViewGroup viewGroup) {
        PAGNativeAdData pAGNativeAdData = this.b;
        if (pAGNativeAdData != null) {
            return pAGNativeAdData.getMediaView();
        }
        return null;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View getContainer(TAdNativeInfo tAdNativeInfo, ViewGroup viewGroup) {
        if (tAdNativeInfo == null || tAdNativeInfo.getNativeAdWrapper() == null || tAdNativeInfo.getNativeAdWrapper().getNativeAd() == null || !(tAdNativeInfo.getNativeAdWrapper().getNativeAd() instanceof PAGNativeAd)) {
            return null;
        }
        this.b = ((PAGNativeAd) tAdNativeInfo.getNativeAdWrapper().getNativeAd()).getNativeAdData();
        return null;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View getIconView(Context context) {
        PAGNativeAdData pAGNativeAdData;
        if (context != null && (pAGNativeAdData = this.b) != null && pAGNativeAdData.getIcon() != null && !TextUtils.isEmpty(this.b.getIcon().getImageUrl())) {
            this.iconView = createIconView(context.getApplicationContext());
            MediationImageLoader.loadImage(this.b.getIcon().getImageUrl(), (ImageView) this.iconView);
        }
        return this.iconView;
    }
}
