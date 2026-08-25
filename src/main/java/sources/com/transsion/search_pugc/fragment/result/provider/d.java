package com.transsion.search_pugc.fragment.result.provider;

import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.constant.SearchType;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseItemProvider implements t {
    private final /* synthetic */ t e;

    public d(t tVar) {
        Intrinsics.h(tVar, "reportable");
        this.e = tVar;
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void a(UGCVideo uGCVideo, int i) {
        Intrinsics.h(uGCVideo, "ugcVideo");
        this.e.a(uGCVideo, i);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void c(UGCVideo uGCVideo, int i) {
        Intrinsics.h(uGCVideo, "ugcVideo");
        this.e.c(uGCVideo, i);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void d(SearchResultItem searchResultItem, int i) {
        Intrinsics.h(searchResultItem, "item");
        this.e.d(searchResultItem, i);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void e(UGCVideo uGCVideo, int i) {
        Intrinsics.h(uGCVideo, "ugcVideo");
        this.e.e(uGCVideo, i);
    }

    public int l() {
        return SearchType.HASH_TAG.ordinal();
    }

    public int m() {
        return R$layout.provider_result_hashtag;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SearchResultItem searchResultItem) {
        String title;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchResultItem, "item");
        TextView textView = (TextView) baseViewHolder.getView(R$id.tv);
        UGCVideoHashTag hashTag = searchResultItem.getHashTag();
        textView.setText(String.valueOf((hashTag == null || (title = hashTag.getTitle()) == null) ? null : com.transsion.search_pugc.constant.a.d(title, k(), com.transsion.search_pugc.g.g.a(k()).e())));
    }
}
