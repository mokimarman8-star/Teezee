package com.transsion.search_pugc.fragment.result.provider;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.baseui.R$plurals;
import com.transsion.baseui.util.k;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.constant.SearchType;
import com.transsion.ugcvideodetail.api.UGCVideoType;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseItemProvider implements t {
    private final /* synthetic */ t e;

    public c(t tVar) {
        Intrinsics.h(tVar, "reportable");
        this.e = tVar;
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SearchResultItem searchResultItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchResultItem, "item");
        if (Intrinsics.c(searchResultItem.getTopicType(), "UGC_COLLECTION")) {
            y(baseViewHolder, searchResultItem);
        } else {
            z(baseViewHolder, searchResultItem);
        }
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
        return SearchType.UGC_VIDEO.ordinal();
    }

    public int m() {
        return R$layout.provider_result_common;
    }

    public final void y(BaseViewHolder baseViewHolder, SearchResultItem searchResultItem) {
        List videos;
        UGCVideo uGCVideo;
        String str;
        String thumbnail;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchResultItem, "item");
        UGCCollection collection = searchResultItem.getCollection();
        if (collection == null || (videos = collection.getVideos()) == null || (uGCVideo = (UGCVideo) CollectionsKt.k0(videos)) == null) {
            return;
        }
        boolean c = Intrinsics.c(uGCVideo.getCategory(), UGCVideoType.EDUCATION.getValue());
        boolean c2 = Intrinsics.c(uGCVideo.getCategory(), UGCVideoType.SHORT_TV.getValue());
        f.b m = ni.f.a.m(k());
        Cover cover = uGCVideo.getCover();
        String str2 = BuildConfig.FLAVOR;
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g = m.g(str);
        Cover cover2 = uGCVideo.getCover();
        if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        g.l(str2).d((ImageView) baseViewHolder.getView(R$id.iv_cover));
        int i = R$id.tv_title;
        String title = collection.getTitle();
        baseViewHolder.setText(i, title != null ? com.transsion.search_pugc.constant.a.d(title, k(), com.transsion.search_pugc.g.g.a(k()).e()) : null);
        Integer videoNum = collection.getVideoNum();
        if (videoNum != null) {
            int intValue = videoNum.intValue();
            baseViewHolder.setText(R$id.tv_view_resource_tag, k().getResources().getQuantityString(c2 ? R$plurals.episodes_count_text : R$plurals.videos_count_text, intValue, Integer.valueOf(intValue)));
        }
        if (c) {
            baseViewHolder.setGone(R$id.iv_view_resource_tag, false);
        } else {
            UGCVideoTypeKt.i((ImageView) baseViewHolder.getView(R$id.iv_view_resource_tag), uGCVideo, (Integer) null, 4, (Object) null);
        }
        baseViewHolder.setVisible(R$id.v_corner, false);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String watchNum = collection.getWatchNum();
        String l = watchNum != null ? com.transsion.search_pugc.constant.a.l(watchNum) : null;
        spannableStringBuilder.append((CharSequence) (l + " " + k().getString(R$string.views)));
        String string = k().getString(UGCVideoTypeKt.g(uGCVideo.getCategory()));
        Intrinsics.g(string, "getString(...)");
        baseViewHolder.setText(R$id.tv_info, com.transsion.baseui.util.q.g(CollectionsKt.q(new k.b[]{new k.b(string, Integer.valueOf(R.color.white_80)), new k.b(com.transsion.baseui.util.j.c(uGCVideo.getWatchNum(), k()), Integer.valueOf(R.color.white_60))}), k(), false, 4, null));
        UGCVideoTypeKt.i((ImageView) baseViewHolder.getView(R$id.ivInfoIcon), uGCVideo, (Integer) null, 4, (Object) null);
    }

    public final void z(BaseViewHolder baseViewHolder, SearchResultItem searchResultItem) {
        String str;
        String watchNum;
        Long duration;
        String title;
        Cover cover;
        String thumbnail;
        Cover cover2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchResultItem, "item");
        AppCompatImageView view = baseViewHolder.getView(R$id.ivInfoIcon);
        UGCVideo video = searchResultItem.getVideo();
        if (video != null) {
            uf.c.k(view);
            UGCVideoTypeKt.i(view, video, (Integer) null, 4, (Object) null);
        } else {
            uf.c.g(view);
        }
        f.b m = ni.f.a.m(k());
        UGCVideo video2 = searchResultItem.getVideo();
        String str2 = BuildConfig.FLAVOR;
        if (video2 == null || (cover2 = video2.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g = m.g(str);
        UGCVideo video3 = searchResultItem.getVideo();
        if (video3 != null && (cover = video3.getCover()) != null && (thumbnail = cover.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        g.l(str2).d((ImageView) baseViewHolder.getView(R$id.iv_cover));
        int i = R$id.tv_title;
        UGCVideo video4 = searchResultItem.getVideo();
        baseViewHolder.setText(i, (video4 == null || (title = video4.getTitle()) == null) ? null : com.transsion.search_pugc.constant.a.d(title, k(), com.transsion.search_pugc.g.g.a(k()).e()));
        int i2 = R$id.tv_view_resource_tag;
        UGCVideo video5 = searchResultItem.getVideo();
        baseViewHolder.setText(i2, (video5 == null || (duration = video5.getDuration()) == null) ? null : com.transsion.search_pugc.constant.a.j(duration.longValue()));
        AppCompatImageView view2 = baseViewHolder.getView(R$id.iv_view_resource_tag);
        UGCVideo video6 = searchResultItem.getVideo();
        view2.setVisibility(video6 != null ? video6.isVerticalImmStyle() : false ? 0 : 8);
        view2.setImageResource(com.transsion.baseui.R.drawable.ic_tag_ugc_shorts_search);
        int i3 = R$id.v_corner;
        UGCVideo video7 = searchResultItem.getVideo();
        String corner = video7 != null ? video7.getCorner() : null;
        baseViewHolder.setVisible(i3, !(corner == null || corner.length() == 0));
        int i4 = R$id.tv_view_resource_corner;
        UGCVideo video8 = searchResultItem.getVideo();
        baseViewHolder.setText(i4, video8 != null ? video8.getCorner() : null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        UGCVideo video9 = searchResultItem.getVideo();
        String l = (video9 == null || (watchNum = video9.getWatchNum()) == null) ? null : com.transsion.search_pugc.constant.a.l(watchNum);
        spannableStringBuilder.append((CharSequence) (l + " " + k().getString(R$string.views)));
        Context k = k();
        UGCVideo video10 = searchResultItem.getVideo();
        String string = k.getString(UGCVideoTypeKt.g(video10 != null ? video10.getCategory() : null));
        Intrinsics.g(string, "getString(...)");
        k.b bVar = new k.b(string, Integer.valueOf(R.color.white_80));
        UGCVideo video11 = searchResultItem.getVideo();
        baseViewHolder.setText(R$id.tv_info, com.transsion.baseui.util.q.g(CollectionsKt.q(new k.b[]{bVar, new k.b(com.transsion.baseui.util.j.c(video11 != null ? video11.getWatchNum() : null, k()), Integer.valueOf(R.color.white_60))}), k(), false, 4, null));
    }
}
