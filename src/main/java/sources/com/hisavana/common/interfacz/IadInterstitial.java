package com.hisavana.common.interfacz;

import android.app.Activity;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface IadInterstitial {
    boolean canShow();

    boolean isLoaded();

    void onResume();

    void show(Activity activity, String str, String str2);
}
