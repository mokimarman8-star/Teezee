package com.cloud.tmc.integration.permission;

import com.cloud.tmc.kernel.proxy.Proxiable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface TmcNativePermissionRequestProxy extends Proxiable {
    void addPermRequestCallback(int i, IPermissionRequestCallback iPermissionRequestCallback);

    int getRequestCode();

    void onRequestPermissionResult(int i, String[] strArr, int[] iArr);
}
