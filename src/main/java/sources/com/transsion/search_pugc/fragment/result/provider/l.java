package com.transsion.search_pugc.fragment.result.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.constant.SearchType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l extends BaseItemProvider {
    public int l() {
        return SearchType.UNKNOW.ordinal();
    }

    public int m() {
        return R$layout.provider_result_unkown;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SearchResultItem searchResultItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchResultItem, "item");
    }
}
