package com.transsion.subroom.activity;

import com.google.android.material.tabs.TabLayout;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class MainActivity$d implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ MainActivity a;

    MainActivity$d(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onTabReselected(TabLayout.Tab tab) {
        a.a.f(wf.a.a, "MainActivity", "onTabReselected", false, 4, (Object) null);
    }

    public void onTabSelected(TabLayout.Tab tab) {
        a.a.f(wf.a.a, "MainActivity", "onTabSelected --> tag = " + (tab != null ? tab.getTag() : null), false, 4, (Object) null);
        MainActivity.x0(this.a, tab);
    }

    public void onTabUnselected(TabLayout.Tab tab) {
        a.a.f(wf.a.a, "MainActivity", "onTabUnselected", false, 4, (Object) null);
    }
}
