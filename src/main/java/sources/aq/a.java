package aq;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.fragment.suggest.d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseItemProvider {
    public int l() {
        return 0;
    }

    public int m() {
        return R$layout.fragment_search_suggest_copy_writing_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SuggestEntity suggestEntity) {
        String str;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(suggestEntity, "item");
        int i = R$id.tvSearchSuggest;
        d.Companion companion = com.transsion.search.fragment.suggest.d.INSTANCE;
        BaseProviderMultiAdapter g = g();
        com.transsion.search.fragment.suggest.d dVar = g instanceof com.transsion.search.fragment.suggest.d ? (com.transsion.search.fragment.suggest.d) g : null;
        if (dVar == null || (str = dVar.getMKeyWord()) == null) {
            str = BuildConfig.FLAVOR;
        }
        baseViewHolder.setText(i, companion.a(str, suggestEntity.getWord()));
    }
}
