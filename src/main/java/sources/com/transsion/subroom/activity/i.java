package com.transsion.subroom.activity;

import com.google.android.material.tabs.TabLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ MainActivity a;
    public final /* synthetic */ TabLayout.TabView b;

    public /* synthetic */ i(MainActivity mainActivity, TabLayout.TabView tabView) {
        this.a = mainActivity;
        this.b = tabView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainActivity.e0(this.a, this.b);
    }
}
