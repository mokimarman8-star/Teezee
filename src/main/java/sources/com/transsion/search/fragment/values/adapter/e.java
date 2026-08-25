package com.transsion.search.fragment.values.adapter;

import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SearchValuesRelatedCollectionEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.suggest.d;
import com.transsion.search.fragment.values.SearchValuesFragment;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends BaseItemProvider {
    private final int e = a0.a(72.0f);
    private final int f = a0.a(96.0f);

    private final String z() {
        String mKeyWord;
        BaseProviderMultiAdapter g = g();
        b bVar = g instanceof b ? (b) g : null;
        return (bVar == null || (mKeyWord = bVar.getMKeyWord()) == null) ? BuildConfig.FLAVOR : mKeyWord;
    }

    public int l() {
        return 1;
    }

    public int m() {
        return R$layout.item_search_values_vertical_rank_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SearchValuesRelatedCollectionEntity searchValuesRelatedCollectionEntity) {
        String str;
        Cover cover;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchValuesRelatedCollectionEntity, "item");
        int i = R$id.tvTitle;
        d.Companion companion = com.transsion.search.fragment.suggest.d.INSTANCE;
        String z = z();
        VerticalRank verticalRank = searchValuesRelatedCollectionEntity.getVerticalRank();
        baseViewHolder.setText(i, companion.a(z, verticalRank != null ? verticalRank.getTitle() : null));
        int i2 = R$id.tvSubTitle;
        VerticalRank verticalRank2 = searchValuesRelatedCollectionEntity.getVerticalRank();
        baseViewHolder.setText(i2, verticalRank2 != null ? verticalRank2.getDescription() : null);
        ShapeableImageView view = baseViewHolder.getView(R$id.ivCover);
        f.a aVar = f.a;
        VerticalRank verticalRank3 = searchValuesRelatedCollectionEntity.getVerticalRank();
        if (verticalRank3 == null || (cover = verticalRank3.getCover()) == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        aVar.m(k()).g(f.a.e(aVar, str, this.e, false, false, 12, null)).d(view);
        SearchValuesFragment.Companion companion2 = SearchValuesFragment.INSTANCE;
        Staff staff = searchValuesRelatedCollectionEntity.getStaff();
        companion2.d(BuildConfig.FLAVOR, BuildConfig.FLAVOR, staff != null ? staff.getStaffId() : null, BuildConfig.FLAVOR, baseViewHolder.getBindingAdapterPosition(), 1);
    }
}
