package com.transsion.sdk.oneid;

import android.os.Handler;
import android.os.Message;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class d$a extends Handler {
    final /* synthetic */ d a;

    d$a(d dVar) {
        this.a = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        b.i("ReplyMessenger msg.what = " + message.what);
        if (d.a(this.a) != null) {
            d.a(this.a).handleMessage(message);
        }
        d.c(this.a);
    }
}
