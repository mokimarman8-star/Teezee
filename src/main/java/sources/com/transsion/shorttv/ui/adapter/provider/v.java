package com.transsion.shorttv.ui.adapter.provider;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.R;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.shorttv.bean.ShortTvItemType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class v extends BaseItemProvider {
    public int l() {
        return ShortTvItemType.TRENDING_TITLE.ordinal();
    }

    public int m() {
        return R.layout.short_tv_item_trending_title;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, OperateItem data) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(data, "data");
        ((RecyclerView.a0) holder).itemView.setTag("TrendingTitle");
        holder.setText(R.id.sub_operation_title_text, data.getTitle());
    }
}
