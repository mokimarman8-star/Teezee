package com.google.firebase.crashlytics.internal.common;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ x a;
    public final /* synthetic */ Throwable b;

    public /* synthetic */ p(x xVar, Throwable th) {
        this.a = xVar;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x.g(this.a, this.b);
    }
}
