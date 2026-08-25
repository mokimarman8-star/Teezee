package com.cloud.tmc.kernel.utils;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class KernelUtils {
    public static final String TAG = "TmcKernel";

    public static boolean isDebug() {
        return AppDynamicBuildConfig.isAppDebugAble();
    }
}
