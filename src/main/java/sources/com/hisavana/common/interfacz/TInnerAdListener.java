package com.hisavana.common.interfacz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class TInnerAdListener {
    public void onAdActivate(@NonNull AdditionalInfo additionalInfo) {
    }

    public void onClicked(int i) {
    }

    public void onClosed(int i) {
    }

    public void onClosed(@Nullable TAdNativeInfo tAdNativeInfo) {
    }

    public void onError(@Nullable TAdErrorCode tAdErrorCode) {
    }

    public void onLoad() {
    }

    public void onNativeFeedClicked(int i, @Nullable TAdNativeInfo tAdNativeInfo, @NonNull AdditionalInfo additionalInfo) {
    }

    public void onNativeFeedShow(int i, @Nullable TAdNativeInfo tAdNativeInfo, @NonNull AdditionalInfo additionalInfo) {
    }

    public void onRewarded() {
    }

    public void onShow(int i) {
    }

    public void onShowError(@Nullable TAdErrorCode tAdErrorCode) {
    }

    public void onShowed(@NonNull AdditionalInfo additionalInfo) {
    }

    public void onSkipClick() {
    }

    public void onTimeReach() {
    }
}
