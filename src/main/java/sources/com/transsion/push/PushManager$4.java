package com.transsion.push;

import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.FirebaseUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushManager$4 implements Runnable {
    final /* synthetic */ PushManager this$0;

    PushManager$4(PushManager pushManager) {
        this.this$0 = pushManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Tracker.getInstance().init();
        PushUtils.n();
        yj.a.f(PushUtils.o());
        Tracker.getInstance().trackInit();
        PushLogUtils.LOG.g("start update token 2: ");
        FirebaseUtils.c();
    }
}
