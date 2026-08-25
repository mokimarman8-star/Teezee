package com.transsion.search_pugc.fragment.result.provider;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.constant.ResultCollectItemWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseItemProvider {
    private final int e = ResultCollectItemWrapper.Type.FOOTER.ordinal();

    public int l() {
        return this.e;
    }

    public int m() {
        return R$layout.search_collection_footer;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, ResultCollectItemWrapper resultCollectItemWrapper) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(resultCollectItemWrapper, "item");
        RecyclerView.n layoutParams = ((RecyclerView.a0) baseViewHolder).itemView.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.n nVar = layoutParams;
        ((ViewGroup.MarginLayoutParams) nVar).width = com.blankj.utilcode.util.i.e(26.0f);
        ((ViewGroup.MarginLayoutParams) nVar).height = com.blankj.utilcode.util.i.e(102.0f);
        ((RecyclerView.a0) baseViewHolder).itemView.setLayoutParams(nVar);
    }
}
