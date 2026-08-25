package com.bytedance.sdk.openadsdk.core.act;

import android.content.ComponentName;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.f;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ActServiceConnection extends f {
    private sP mConnectionCallback;

    public ActServiceConnection(sP sPVar) {
        this.mConnectionCallback = sPVar;
    }

    public void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient) {
        sP sPVar = this.mConnectionCallback;
        if (sPVar != null) {
            sPVar.Sj(customTabsClient);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        sP sPVar = this.mConnectionCallback;
        if (sPVar != null) {
            sPVar.Sj();
        }
    }
}
