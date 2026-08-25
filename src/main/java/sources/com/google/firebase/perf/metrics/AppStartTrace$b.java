package com.google.firebase.perf.metrics;

import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class AppStartTrace$b implements ViewTreeObserver.OnDrawListener {
    final /* synthetic */ AppStartTrace a;

    private AppStartTrace$b(AppStartTrace appStartTrace) {
        this.a = appStartTrace;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        AppStartTrace.h(this.a);
    }
}
