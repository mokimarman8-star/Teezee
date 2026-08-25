package aq;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.suggest.d;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseItemProvider {
    public int l() {
        return 2;
    }

    public int m() {
        return R$layout.fragment_search_suggest_list_cover_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SuggestEntity suggestEntity) {
        String str;
        String mKeyWord;
        Cover cover;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(suggestEntity, "item");
        f.b m = f.a.m(k());
        VerticalRank verticalRank = suggestEntity.getVerticalRank();
        String str2 = BuildConfig.FLAVOR;
        if (verticalRank == null || (cover = verticalRank.getCover()) == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        m.g(str).i(R$drawable.ic_list_cover).d((ImageView) baseViewHolder.getView(R$id.ivCover));
        int i = R$id.tvTitle;
        d.Companion companion = com.transsion.search.fragment.suggest.d.INSTANCE;
        BaseProviderMultiAdapter g = g();
        com.transsion.search.fragment.suggest.d dVar = g instanceof com.transsion.search.fragment.suggest.d ? (com.transsion.search.fragment.suggest.d) g : null;
        if (dVar != null && (mKeyWord = dVar.getMKeyWord()) != null) {
            str2 = mKeyWord;
        }
        VerticalRank verticalRank2 = suggestEntity.getVerticalRank();
        baseViewHolder.setText(i, companion.a(str2, verticalRank2 != null ? verticalRank2.getTitle() : null));
        int i2 = R$id.tvDes;
        VerticalRank verticalRank3 = suggestEntity.getVerticalRank();
        baseViewHolder.setText(i2, verticalRank3 != null ? verticalRank3.getDescription() : null);
    }
}
