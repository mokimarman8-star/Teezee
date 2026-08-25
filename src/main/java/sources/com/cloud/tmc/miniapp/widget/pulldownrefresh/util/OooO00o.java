package com.cloud.tmc.miniapp.widget.pulldownrefresh.util;

import com.google.android.material.appbar.AppBarLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO00o implements AppBarLayout.g {
    public final /* synthetic */ com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO00o OooO00o;

    public OooO00o(com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO00o oooO00o) {
        this.OooO00o = oooO00o;
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO00o oooO00o = this.OooO00o;
        boolean z = i >= 0;
        boolean z2 = appBarLayout.getTotalScrollRange() + i <= 0;
        com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o oooO00o2 = (com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o) oooO00o;
        oooO00o2.OooO0oO = z;
        oooO00o2.OooO0oo = z2;
    }
}
