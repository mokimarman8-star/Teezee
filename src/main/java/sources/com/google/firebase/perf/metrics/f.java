package com.google.firebase.perf.metrics;

import com.google.firebase.perf.v1.i;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ AppStartTrace a;
    public final /* synthetic */ i.b b;

    public /* synthetic */ f(AppStartTrace appStartTrace, i.b bVar) {
        this.a = appStartTrace;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppStartTrace.a(this.a, this.b);
    }
}
