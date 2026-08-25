package com.transsion.push.tracker;

import android.os.Bundle;
import com.transsion.push.db.h;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.g0;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushTracker$1 implements Runnable {
    final /* synthetic */ PushTracker this$0;
    final /* synthetic */ Bundle val$bundle;
    final /* synthetic */ Tracker.KEY val$key;

    PushTracker$1(PushTracker pushTracker, Tracker.KEY key, Bundle bundle) {
        this.this$0 = pushTracker;
        this.val$key = key;
        this.val$bundle = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject a = PushTracker.a(this.this$0, this.val$key, this.val$bundle);
        if (!g0.g()) {
            h.b().c(a.toString());
        } else {
            PushTracker.c(this.this$0, PushTracker.b(this.this$0), a);
        }
    }
}
