package com.transsion.home.fragment.tab;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrendingFragment$b extends RecyclerView.r {
    final /* synthetic */ TrendingFragment a;

    TrendingFragment$b(TrendingFragment trendingFragment) {
        this.a = trendingFragment;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.h(recyclerView, "recyclerView");
        if (TrendingFragment.Y0(this.a)) {
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            TrendingFragment.e1(this.a, RangesKt.g((computeVerticalScrollOffset * 1.0f) / TrendingFragment.W0(r3), 1.0f));
            if (!this.a.getMIsWhite() && TrendingFragment.U0(this.a) < 0.7f) {
                this.a.b0(true);
            } else {
                if (!this.a.getMIsWhite() || TrendingFragment.U0(this.a) < 0.7f) {
                    return;
                }
                this.a.b0(false);
            }
        }
    }
}
