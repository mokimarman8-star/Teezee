package com.bytedance.sdk.openadsdk.component.reward.top;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface Sj<T extends View> {
    void clickSkip();

    void clickSound(String str);

    View getCloseButton();

    void setListener(sP sPVar);

    void setShowDislike(boolean z);

    void setShowSkip(boolean z);

    void setShowSound(boolean z);

    void setSkipEnable(boolean z);

    void setSkipInvisiable();

    void setSkipText(CharSequence charSequence);

    void setSoundMute(boolean z);

    void setTime(CharSequence charSequence, CharSequence charSequence2);

    void showCloseButton();

    void showCountDownText();

    void showSkipButton();
}
