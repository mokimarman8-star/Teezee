package com.transsion.push.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class ServiceUtils$1 implements Runnable {
    final /* synthetic */ Bundle val$bundle;
    final /* synthetic */ Context val$context;

    ServiceUtils$1(Bundle bundle, Context context) {
        this.val$bundle = bundle;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent = new Intent();
        intent.putExtras(this.val$bundle);
        ServiceUtils.a(this.val$context, intent);
    }
}
