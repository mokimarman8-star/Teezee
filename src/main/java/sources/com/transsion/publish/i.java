package com.transsion.publish;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ PublishManager a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ i(PublishManager publishManager, Context context, boolean z) {
        this.a = publishManager;
        this.b = context;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PublishManager.b(this.a, this.b, this.c);
    }
}
