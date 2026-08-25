package com.transsion.home.fragment.tab;

import android.view.View;
import com.tn.lib.view.DefaultView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class h1 implements View.OnClickListener {
    public final /* synthetic */ TrendingFragment a;
    public final /* synthetic */ DefaultView b;

    public /* synthetic */ h1(TrendingFragment trendingFragment, DefaultView defaultView) {
        this.a = trendingFragment;
        this.b = defaultView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TrendingFragment.D0(this.a, this.b, view);
    }
}
