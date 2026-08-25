package com.transsion.home.adapter.operateUGC.provider;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c0 extends BaseItemProvider {
    public int l() {
        return PostItemType.TRENDING_MARGIN.ordinal();
    }

    public int m() {
        return R.layout.provider_ugc_trending_margin;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        ((RecyclerView.a0) baseViewHolder).itemView.setTag("TrendingMargin");
    }
}
