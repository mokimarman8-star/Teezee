package com.hisavana.common.interfacz;

import androidx.annotation.Nullable;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class TAdListener {
    public abstract void onClicked(int i);

    public abstract void onClosed(int i);

    public void onClosed(@Nullable TAdNativeInfo tAdNativeInfo) {
    }

    public abstract void onError(@Nullable TAdErrorCode tAdErrorCode);

    public void onLoad() {
    }

    public void onNativeFeedClicked(int i, @Nullable TAdNativeInfo tAdNativeInfo) {
    }

    public void onNativeFeedShow(int i, @Nullable TAdNativeInfo tAdNativeInfo) {
    }

    public void onRewarded() {
    }

    public abstract void onShow(int i);

    public void onShowError(@Nullable TAdErrorCode tAdErrorCode) {
    }
}
