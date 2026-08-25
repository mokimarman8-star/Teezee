package com.transsion.push;

import com.transsion.push.config.PushRepository;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.FirebaseUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushManager$2 implements Runnable {
    final /* synthetic */ PushManager this$0;
    final /* synthetic */ String val$appId;
    final /* synthetic */ String val$appKey;
    final /* synthetic */ boolean val$isTest;

    PushManager$2(PushManager pushManager, String str, String str2, boolean z) {
        this.this$0 = pushManager;
        this.val$appId = str;
        this.val$appKey = str2;
        this.val$isTest = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Tracker.getInstance().init();
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_ID, this.val$appId);
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_APP_KEY, this.val$appKey);
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_IS_TEST_ENV, Boolean.valueOf(this.val$isTest));
        yj.a.f(PushUtils.o());
        Tracker.getInstance().trackInit();
        PushLogUtils.LOG.i("start update token: ");
        FirebaseUtils.c();
    }
}
