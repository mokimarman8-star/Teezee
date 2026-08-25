package com.transsion.sdk.oneid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class c extends BroadcastReceiver {
    private boolean a = true;

    c() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (this.a) {
                this.a = false;
                return;
            }
            try {
                if (b.p(context)) {
                    e.a(context).l();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
