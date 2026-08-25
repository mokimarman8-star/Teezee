package com.transsion.home.fragment.tab;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class f1 implements Runnable {
    public final /* synthetic */ TrendingFragment a;
    public final /* synthetic */ List b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ f1(TrendingFragment trendingFragment, List list, boolean z) {
        this.a = trendingFragment;
        this.b = list;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrendingFragment.J0(this.a, this.b, this.c);
    }
}
