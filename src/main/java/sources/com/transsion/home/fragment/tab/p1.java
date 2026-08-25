package com.transsion.home.fragment.tab;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class p1 implements Runnable {
    public final /* synthetic */ TrendingFragment a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;

    public /* synthetic */ p1(TrendingFragment trendingFragment, boolean z, int i) {
        this.a = trendingFragment;
        this.b = z;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrendingFragment.C0(this.a, this.b, this.c);
    }
}
