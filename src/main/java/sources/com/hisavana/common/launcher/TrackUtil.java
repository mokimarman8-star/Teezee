package com.hisavana.common.launcher;

import android.view.View;
import com.cloud.hisavana.sdk.common.bean.SSPWebRecommendInfo;
import com.hisavana.common.bean.NativeAdWrapper;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.interfacz.AdShowListener;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class TrackUtil {
    public static void handleClick(TAdNativeInfo tAdNativeInfo) {
        NativeAdWrapper nativeAdWrapper;
        if (tAdNativeInfo == null || (nativeAdWrapper = tAdNativeInfo.getNativeAdWrapper()) == null) {
            return;
        }
        nativeAdWrapper.handleClick();
    }

    public static void registerViewForInteraction(TAdNativeInfo tAdNativeInfo, View view, AdShowListener adShowListener) {
        NativeAdWrapper nativeAdWrapper;
        if (tAdNativeInfo == null || (nativeAdWrapper = tAdNativeInfo.getNativeAdWrapper()) == null) {
            return;
        }
        nativeAdWrapper.registerViewForInteraction(view, adShowListener);
    }

    public static void trackRecommendClick(TAdNativeInfo tAdNativeInfo, String str, String str2) {
        NativeAdWrapper nativeAdWrapper;
        if (tAdNativeInfo == null || (nativeAdWrapper = tAdNativeInfo.getNativeAdWrapper()) == null) {
            return;
        }
        nativeAdWrapper.trackRecommendClick(str, str2);
    }

    public static void trackRecommendShow(TAdNativeInfo tAdNativeInfo, List<SSPWebRecommendInfo> list) {
        NativeAdWrapper nativeAdWrapper;
        if (tAdNativeInfo == null || (nativeAdWrapper = tAdNativeInfo.getNativeAdWrapper()) == null) {
            return;
        }
        nativeAdWrapper.trackRecommendShow(list);
    }
}
