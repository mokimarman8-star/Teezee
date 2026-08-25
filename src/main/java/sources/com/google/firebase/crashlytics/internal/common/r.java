package com.google.firebase.crashlytics.internal.common;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ x a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ r(x xVar, String str, String str2) {
        this.a = xVar;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x.f(this.a, this.b, this.c);
    }
}
