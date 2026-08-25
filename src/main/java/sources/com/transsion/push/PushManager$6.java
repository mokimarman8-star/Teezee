package com.transsion.push;

import com.transsion.push.config.PushRepository;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushManager$6 implements Runnable {
    final /* synthetic */ PushManager this$0;

    PushManager$6(PushManager pushManager) {
        this.this$0 = pushManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushRepository.getInstance().syncActive();
    }
}
