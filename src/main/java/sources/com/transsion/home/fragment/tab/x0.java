package com.transsion.home.fragment.tab;

import com.transsion.home.bean.OperateItem;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class x0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ TrendingFragment c;
    public final /* synthetic */ OperateItem d;

    public /* synthetic */ x0(int i, int i2, TrendingFragment trendingFragment, OperateItem operateItem) {
        this.a = i;
        this.b = i2;
        this.c = trendingFragment;
        this.d = operateItem;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrendingFragment.M0(this.a, this.b, this.c, this.d);
    }
}
