package com.transsion.search_pugc.fragment.result.provider;

import android.widget.ImageView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.R;
import com.transsion.baseui.util.k;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.constant.SearchType;
import com.transsion.ugcvideodetail.api.bean.UGCVerticalRank;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ResultVerticalRankType2Provider extends BaseItemProvider implements t {
    private final /* synthetic */ t e;

    public ResultVerticalRankType2Provider(t tVar) {
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
        return SearchType.VERTICAL_RANK_TYPE2.ordinal();
    }

    public int m() {
        return R$layout.provider_result_vertical_rank_type2;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SearchResultItem searchResultItem) {
        List videos;
        UGCVideo uGCVideo;
        String str;
        String str2;
        UGCVideo uGCVideo2;
        String str3;
        String thumbnail;
        UGCVideo uGCVideo3;
        String str4;
        String str5;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchResultItem, "item");
        UGCVerticalRank verticalRank = searchResultItem.getVerticalRank();
        if (verticalRank == null || (videos = searchResultItem.getVerticalRank().getVideos()) == null || (uGCVideo = (UGCVideo) CollectionsKt.k0(videos)) == null) {
            return;
        }
        f.a aVar = ni.f.a;
        f.b m = aVar.m(k());
        Cover cover = uGCVideo.getCover();
        String str6 = BuildConfig.FLAVOR;
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g = m.g(str);
        Cover cover2 = uGCVideo.getCover();
        if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        g.l(str2).d((ImageView) baseViewHolder.getView(R$id.iv_cover));
        List videos2 = verticalRank.getVideos();
        if (videos2 == null || (uGCVideo3 = (UGCVideo) CollectionsKt.l0(videos2, 1)) == null) {
            kotlinx.coroutines.i.f((CoroutineContext) null, new ResultVerticalRankType2Provider$convert$2(baseViewHolder, null), 1, (Object) null);
        } else {
            baseViewHolder.setVisible(R$id.iv_cover1, true);
            f.b m2 = aVar.m(k());
            Cover cover3 = uGCVideo3.getCover();
            if (cover3 == null || (str4 = cover3.getUrl()) == null) {
                str4 = BuildConfig.FLAVOR;
            }
            f.b g2 = m2.g(str4);
            Cover cover4 = uGCVideo.getCover();
            if (cover4 == null || (str5 = cover4.getThumbnail()) == null) {
                str5 = BuildConfig.FLAVOR;
            }
            g2.l(str5).d((ImageView) baseViewHolder.getView(R$id.iv_cover1));
        }
        List videos3 = verticalRank.getVideos();
        if (videos3 == null || (uGCVideo2 = (UGCVideo) CollectionsKt.l0(videos3, 2)) == null) {
            kotlinx.coroutines.i.f((CoroutineContext) null, new ResultVerticalRankType2Provider$convert$4(baseViewHolder, null), 1, (Object) null);
        } else {
            baseViewHolder.setVisible(R$id.iv_cover2, true);
            f.b m3 = aVar.m(k());
            Cover cover5 = uGCVideo2.getCover();
            if (cover5 == null || (str3 = cover5.getUrl()) == null) {
                str3 = BuildConfig.FLAVOR;
            }
            f.b g3 = m3.g(str3);
            Cover cover6 = uGCVideo.getCover();
            if (cover6 != null && (thumbnail = cover6.getThumbnail()) != null) {
                str6 = thumbnail;
            }
            g3.l(str6).d((ImageView) baseViewHolder.getView(R$id.iv_cover2));
        }
        int i = R$id.tv_title;
        String title = verticalRank.getTitle();
        baseViewHolder.setText(i, title != null ? com.transsion.search_pugc.constant.a.d(title, k(), com.transsion.search_pugc.g.g.a(k()).e()) : null);
        Integer count = verticalRank.getCount();
        if (count != null) {
            int intValue = count.intValue();
            if (intValue > 1) {
                baseViewHolder.setText(R$id.tv_view_resource_tag, k().getString(R$string.videos, Integer.valueOf(intValue)));
            } else {
                baseViewHolder.setText(R$id.tv_view_resource_tag, k().getString(R$string.video, Integer.valueOf(intValue)));
            }
        }
        uf.c.g(baseViewHolder.getView(R$id.iv_view_resource_tag));
        k.a aVar2 = new k.a(R$drawable.ic_tag_collection);
        String string = k().getString(R.string.ugc_video_tv_collection);
        Intrinsics.g(string, "getString(...)");
        baseViewHolder.setText(R$id.tv_info, com.transsion.baseui.util.q.g(CollectionsKt.q(new com.transsion.baseui.util.k[]{aVar2, new k.b(string, Integer.valueOf(com.tn.lib.widget.R.color.white_80)), new k.b(com.transsion.baseui.util.j.c(uGCVideo.getWatchNum(), k()), Integer.valueOf(com.tn.lib.widget.R.color.white_60))}), k(), false, 4, null));
    }
}
