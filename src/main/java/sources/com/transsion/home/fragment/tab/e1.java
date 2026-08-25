package com.transsion.home.fragment.tab;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class e1 implements Runnable {
    public final /* synthetic */ TrendingFragment a;
    public final /* synthetic */ List b;

    public /* synthetic */ e1(TrendingFragment trendingFragment, List list) {
        this.a = trendingFragment;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrendingFragment.A0(this.a, this.b);
    }
}
