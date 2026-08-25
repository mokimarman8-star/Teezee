package com.transsion.home.fragment.tab;

import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrendingFragment$i implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ TrendingFragment a;

    TrendingFragment$i(TrendingFragment trendingFragment) {
        this.a = trendingFragment;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        RecyclerView recyclerView;
        ViewTreeObserver viewTreeObserver;
        Unit unit;
        TrendingFragment trendingFragment = this.a;
        try {
            Result.Companion companion = Result.Companion;
            FragmentActivity activity = trendingFragment.getActivity();
            if (activity != null) {
                activity.reportFullyDrawn();
                unit = Unit.a;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        qk.x xVar = (qk.x) this.a.getMViewBinding();
        if (xVar == null || (recyclerView = xVar.d) == null || (viewTreeObserver = recyclerView.getViewTreeObserver()) == null) {
            return true;
        }
        viewTreeObserver.removeOnPreDrawListener(this);
        return true;
    }
}
