package com.google.firebase.crashlytics.internal.common;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ x a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public /* synthetic */ t(x xVar, long j, String str) {
        this.a = xVar;
        this.b = j;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x.a(this.a, this.b, this.c);
    }
}
