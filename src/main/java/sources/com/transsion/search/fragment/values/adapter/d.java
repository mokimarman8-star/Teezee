package com.transsion.search.fragment.values.adapter;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SearchValuesRelatedCollectionEntity;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseItemProvider {
    public int l() {
        return 0;
    }

    public int m() {
        return R$layout.item_search_values_title_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SearchValuesRelatedCollectionEntity searchValuesRelatedCollectionEntity) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchValuesRelatedCollectionEntity, "item");
        baseViewHolder.setText(R$id.tvTopTitle, searchValuesRelatedCollectionEntity.getTitle());
    }
}
