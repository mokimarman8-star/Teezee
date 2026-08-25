package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.callback.PrivacyCallback;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PermissionDialogPointImp implements PermissionDialogPoint {
    public PrivacyCallback OooO00o;

    public void onFinalized() {
    }

    public void onInitialized() {
    }

    public void privacyDialogDismiss(String str, long j) {
        Intrinsics.h(str, "appId");
        PrivacyCallback privacyCallback = this.OooO00o;
        if (privacyCallback != null) {
            privacyCallback.privacyDismiss(str, j);
        }
    }

    public void registerCallback(PrivacyCallback privacyCallback) {
        Intrinsics.h(privacyCallback, "privacyCallback");
        this.OooO00o = privacyCallback;
    }
}
