package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.v1.ApplicationProcessState;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ GaugeManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ApplicationProcessState c;

    public /* synthetic */ e(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        this.a = gaugeManager;
        this.b = str;
        this.c = applicationProcessState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GaugeManager.a(this.a, this.b, this.c);
    }
}
