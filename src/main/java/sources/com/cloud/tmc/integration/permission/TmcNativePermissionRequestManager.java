package com.cloud.tmc.integration.permission;

import androidx.collection.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TmcNativePermissionRequestManager implements TmcNativePermissionRequestProxy {
    private y0 callbackArray = new y0();
    private Integer lastRequestCode = 0;

    @Override // com.cloud.tmc.integration.permission.TmcNativePermissionRequestProxy
    public void addPermRequestCallback(int i, IPermissionRequestCallback iPermissionRequestCallback) {
        y0 y0Var = this.callbackArray;
        if (y0Var != null) {
            y0Var.l(i, iPermissionRequestCallback);
        }
    }

    @Override // com.cloud.tmc.integration.permission.TmcNativePermissionRequestProxy
    public int getRequestCode() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(this.lastRequestCode.intValue() + 1);
            this.lastRequestCode = valueOf;
        }
        return valueOf.intValue();
    }

    @Override // com.cloud.tmc.integration.permission.TmcNativePermissionRequestProxy
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        IPermissionRequestCallback iPermissionRequestCallback;
        y0 y0Var = this.callbackArray;
        if (y0Var == null || (iPermissionRequestCallback = (IPermissionRequestCallback) y0Var.g(i)) == null) {
            return;
        }
        iPermissionRequestCallback.onRequestPermissionResult(i, strArr, iArr);
        this.callbackArray.m(i);
    }
}
