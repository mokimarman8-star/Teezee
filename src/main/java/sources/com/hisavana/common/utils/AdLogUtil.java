package com.hisavana.common.utils;

import com.cloud.sdk.commonutil.util.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class AdLogUtil extends c {
    private static final String TAG = "ADSDK_M";
    private static final AdLogUtil adLogUtil = new AdLogUtil();

    public static AdLogUtil Log() {
        return adLogUtil;
    }

    public String getGlobalTag() {
        return TAG;
    }
}
