package com.transsion.home.fragment.tab;

import androidx.recyclerview.widget.GridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrendingFragment$g extends GridLayoutManager.c {
    final /* synthetic */ TrendingFragment e;
    final /* synthetic */ int f;

    TrendingFragment$g(TrendingFragment trendingFragment, int i) {
        this.e = trendingFragment;
        this.f = i;
    }

    public int f(int i) {
        com.transsion.home.adapter.trending.b V0 = TrendingFragment.V0(this.e);
        BaseQuickAdapter baseQuickAdapter = null;
        if (V0 == null) {
            Intrinsics.y("mAdapter");
            V0 = null;
        }
        if (!V0.getIsGridTrendingAdapter()) {
            return this.f;
        }
        BaseQuickAdapter V02 = TrendingFragment.V0(this.e);
        if (V02 == null) {
            Intrinsics.y("mAdapter");
        } else {
            baseQuickAdapter = V02;
        }
        if (Intrinsics.c(((OperateItem) baseQuickAdapter.getItem(i)).getType(), PostItemType.SUBJECT.getValue())) {
            return 1;
        }
        return this.f;
    }
}
