package com.transsion.publish;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ PublishManager b;

    public /* synthetic */ h(String str, PublishManager publishManager) {
        this.a = str;
        this.b = publishManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PublishManager.f(this.a, this.b);
    }
}
