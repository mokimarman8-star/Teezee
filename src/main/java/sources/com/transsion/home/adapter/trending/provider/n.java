package com.transsion.home.adapter.trending.provider;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.view.OpRankingView;
import com.transsion.moviedetailapi.bean.PostItemType;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n extends BaseItemProvider {
    private final com.transsion.home.preload.b e;

    public n(com.transsion.home.preload.b bVar) {
        this.e = bVar;
    }

    public int l() {
        return PostItemType.OP_RANKING.ordinal();
    }

    public int m() {
        return R.layout.post_list_item_op_ranking;
    }

    public BaseViewHolder r(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        com.transsion.home.preload.b bVar = this.e;
        if (bVar == null || bVar.b() || this.e.d() == null) {
            return super.r(viewGroup, i);
        }
        a.a.f(wf.a.a, "MainXMLPreload", "ranking", false, 4, (Object) null);
        View d = this.e.d();
        if (d == null) {
            return super.r(viewGroup, i);
        }
        d.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new BaseViewHolder(d);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        OpRankingView opRankingView = (OpRankingView) baseViewHolder.getViewOrNull(R.id.ranking_view);
        if (opRankingView == null || operateItem.getRankings() == null) {
            return;
        }
        opRankingView.setDatas(operateItem);
    }
}
