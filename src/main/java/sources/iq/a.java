package iq;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.bean.SearchSuggestItem;
import com.transsion.search_pugc.fragment.suggest.e;
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
    public void b(BaseViewHolder baseViewHolder, SearchSuggestItem searchSuggestItem) {
        String str;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchSuggestItem, "item");
        int i = R$id.tvSearchSuggest;
        e.Companion companion = e.INSTANCE;
        BaseProviderMultiAdapter g = g();
        e eVar = g instanceof e ? (e) g : null;
        if (eVar == null || (str = eVar.getMKeyWord()) == null) {
            str = BuildConfig.FLAVOR;
        }
        baseViewHolder.setText(i, companion.a(str, searchSuggestItem.getWord()));
    }
}
