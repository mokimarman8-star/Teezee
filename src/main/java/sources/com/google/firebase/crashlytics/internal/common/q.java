package com.google.firebase.crashlytics.internal.common;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ x a;
    public final /* synthetic */ String b;

    public /* synthetic */ q(x xVar, String str) {
        this.a = xVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x.c(this.a, this.b);
    }
}
