package com.bytedance.sdk.openadsdk.api.factory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class SDKTypeConfig {
    private static ISDKTypeFactory Sj;

    public static ISDKTypeFactory getSdkTypeFactory() {
        return Sj;
    }

    public static void setSdkTypeFactory(ISDKTypeFactory iSDKTypeFactory) {
        Sj = iSDKTypeFactory;
    }
}
