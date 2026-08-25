package com.transsion.push.tracker;

import com.transsion.push.db.h;
import com.transsion.push.utils.PushLogUtils;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushTracker$2 implements Runnable {
    final /* synthetic */ PushTracker this$0;

    PushTracker$2(PushTracker pushTracker) {
        this.this$0 = pushTracker;
    }

    @Override // java.lang.Runnable
    public void run() {
        List d = h.b().d();
        if (d == null || d.size() <= 0) {
            PushLogUtils.LOG.g("No tracker content reporting");
        } else {
            PushTracker.d(this.this$0, PushTracker.b(this.this$0), d);
        }
    }
}
