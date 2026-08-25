package com.transsion.ga;

import com.transsion.athena.taaneh.aethna;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class AthenaAnalytics$athena implements Runnable {
    final /* synthetic */ boolean a;

    AthenaAnalytics$athena(boolean z) {
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        aethna.a.m().r(this.a);
    }
}
