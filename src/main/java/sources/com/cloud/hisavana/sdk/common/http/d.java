package com.cloud.hisavana.sdk.common.http;

import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener;
import com.cloud.hisavana.sdk.manager.NetStateManager;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class d {
    protected final int a = 15000;
    protected ResponseBaseListener b = null;

    protected abstract void a();

    public void b() {
        if (NetStateManager.checkNetworkState(true)) {
            a();
            return;
        }
        ResponseBaseListener responseBaseListener = this.b;
        if (responseBaseListener != null) {
            responseBaseListener.e(TaErrorCode.ERROR_NETWORK_NOT_CONNECTED);
        }
    }
}
