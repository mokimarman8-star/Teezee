package com.google.firebase.crashlytics.internal.common;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ n a;
    public final /* synthetic */ String b;

    public /* synthetic */ l(n nVar, String str) {
        this.a = nVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.b(this.a, this.b);
    }
}
