package com.transsion.subroom.activity;

import com.transsion.ad.hi.b;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SplashActivity$b implements b {
    final /* synthetic */ SplashActivity a;
    final /* synthetic */ Runnable b;

    SplashActivity$b(SplashActivity splashActivity, Runnable runnable) {
        this.a = splashActivity;
        this.b = runnable;
    }

    public void onInitSuccess() {
        a.a.f(wf.a.a, "SplashActivity", "HiSavana init success, cost " + (System.currentTimeMillis() - SplashActivity.U(this.a)) + ", --> start load ad", false, 4, (Object) null);
        SplashActivity.R(this.a).removeCallbacks(this.b);
        SplashActivity.X(this.a);
    }
}
