package com.transsion.push;

import com.transsion.push.bean.PushConfig;
import com.transsion.push.utils.PushUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushManager$5 implements Runnable {
    final /* synthetic */ PushManager this$0;
    final /* synthetic */ PushConfig val$config;

    PushManager$5(PushManager pushManager, PushConfig pushConfig) {
        this.this$0 = pushManager;
        this.val$config = pushConfig;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushUtils.v(this.val$config);
    }
}
