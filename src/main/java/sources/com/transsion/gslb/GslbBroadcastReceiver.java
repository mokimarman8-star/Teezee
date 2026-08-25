package com.transsion.gslb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class GslbBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            try {
                Worker worker = GslbSdk.getWorker();
                if (worker != null) {
                    worker.retry();
                }
            } catch (Exception e) {
                Utils.LOG.i(Log.getStackTraceString(e));
            }
        }
    }
}
