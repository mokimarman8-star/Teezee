package com.transsion.home.fragment.tab;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrendingFragment$c implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ TrendingFragment a;

    TrendingFragment$c(TrendingFragment trendingFragment) {
        this.a = trendingFragment;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        RecyclerView recyclerView;
        ViewTreeObserver viewTreeObserver;
        qk.x xVar = (qk.x) this.a.getMViewBinding();
        if (xVar != null && (recyclerView = xVar.d) != null && (viewTreeObserver = recyclerView.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
        com.transsion.startup.pref.consume.c.a.o(this.a.getActivity());
        return true;
    }
}
