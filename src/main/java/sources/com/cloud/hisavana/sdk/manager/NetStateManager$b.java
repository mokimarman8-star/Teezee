package com.cloud.hisavana.sdk.manager;

import com.cloud.sdk.commonutil.util.MitNetUtil;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class NetStateManager$b implements Runnable {
    NetStateManager$b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        NetStateManager.access$100().set(MitNetUtil.c(com.cloud.sdk.commonutil.util.e.a()));
    }
}
