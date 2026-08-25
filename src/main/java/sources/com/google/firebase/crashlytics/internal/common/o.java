package com.google.firebase.crashlytics.internal.common;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ x a;
    public final /* synthetic */ yb.b b;

    public /* synthetic */ o(x xVar, yb.b bVar) {
        this.a = xVar;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x.h(this.a, this.b);
    }
}
