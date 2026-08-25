package com.transsion.home.fragment.tab;

import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class o1 implements Runnable {
    public final /* synthetic */ TrendingFragment a;
    public final /* synthetic */ Ref.BooleanRef b;

    public /* synthetic */ o1(TrendingFragment trendingFragment, Ref.BooleanRef booleanRef) {
        this.a = trendingFragment;
        this.b = booleanRef;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrendingFragment.F0(this.a, this.b);
    }
}
