package com.transsion.home.fragment.tab;

import android.net.Network;
import android.net.NetworkCapabilities;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import kotlin.jvm.internal.Intrinsics;
import wf.a;
import yg.m;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrendingFragment$h implements yg.m {
    final /* synthetic */ TrendingFragment a;

    TrendingFragment$h(TrendingFragment trendingFragment) {
        this.a = trendingFragment;
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        TrendingFragment.b1(this.a);
        if (this.a.isResumed()) {
            BaseQuickAdapter V0 = TrendingFragment.V0(this.a);
            if (V0 == null) {
                Intrinsics.y("mAdapter");
                V0 = null;
            }
            if (V0.getData().isEmpty() || PreloadTrendingData.n.a().K().f() == null) {
                a.a.f(wf.a.a, "TrendingFragment", "onConnected", false, 4, (Object) null);
                TrendingFragment.a1(this.a, false);
            }
        }
    }

    public void onDisconnected() {
        TrendingFragment.Z0(this.a);
    }
}
