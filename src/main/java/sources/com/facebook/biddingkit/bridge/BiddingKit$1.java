package com.facebook.biddingkit.bridge;

import android.content.Context;
import com.facebook.biddingkit.logging.h;
import q8.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class BiddingKit$1 implements Runnable {
    final /* synthetic */ String val$configuration;
    final /* synthetic */ Context val$context;

    BiddingKit$1(Context context, String str) {
        this.val$context = context;
        this.val$configuration = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context = this.val$context;
        h.a(context, b.c(context), "0.5.1", this.val$configuration);
    }
}
