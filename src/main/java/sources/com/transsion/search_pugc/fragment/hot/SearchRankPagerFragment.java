package com.transsion.search_pugc.fragment.hot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.R$drawable;
import com.transsion.search.bean.HotRankItem;
import com.transsion.search_pugc.bean.HotRank;
import com.transsion.search_pugc.g;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import vp.f;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/transsion/search_pugc/fragment/hot/SearchRankPagerFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lvp/f;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "a0", "(Landroid/view/LayoutInflater;)Lvp/f;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "b0", "lazyLoadData", BuildConfig.FLAVOR, "a", "Z", "hasReported", BuildConfig.FLAVOR, "b", "I", "rankIndex", "c", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchRankPagerFragment extends BaseFragment<f> {

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private boolean hasReported;

    /* renamed from: b, reason: from kotlin metadata */
    private int rankIndex;

    /* renamed from: com.transsion.search_pugc.fragment.hot.SearchRankPagerFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchRankPagerFragment a(HotRank hotRank, int i) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("hotRank", hotRank);
            bundle.putInt("index", i);
            SearchRankPagerFragment searchRankPagerFragment = new SearchRankPagerFragment();
            searchRankPagerFragment.setArguments(bundle);
            return searchRankPagerFragment;
        }
    }

    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public f getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        f c = f.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public final void b0() {
        if (this.hasReported) {
            return;
        }
        Bundle arguments = getArguments();
        HotRank hotRank = arguments != null ? (HotRank) arguments.getParcelable("hotRank") : null;
        HotRank hotRank2 = hotRank instanceof HotRank ? hotRank : null;
        if (hotRank2 == null) {
            return;
        }
        int i = 0;
        for (Object obj : hotRank2.getVideos()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            g.g.a(getContext()).s((UGCVideo) obj, i, hotRank2.getName(), this.rankIndex);
            i = i2;
        }
        this.hasReported = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        ImageView imageView;
        int i;
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        HotRank hotRank = arguments != null ? (HotRank) arguments.getParcelable("hotRank") : null;
        HotRank hotRank2 = hotRank instanceof HotRank ? hotRank : null;
        if (hotRank2 == null) {
            return;
        }
        Bundle arguments2 = getArguments();
        this.rankIndex = arguments2 != null ? arguments2.getInt("index") : 0;
        if (hotRank2.getVideos().isEmpty()) {
            return;
        }
        f fVar = (f) getMViewBinding();
        if (fVar != null && (imageView = fVar.c) != null) {
            String category = hotRank2.getCategory();
            switch (category.hashCode()) {
                case 74710533:
                    if (category.equals(HotRankItem.CATE_MUSIC)) {
                        i = R$drawable.rank_type_music;
                        break;
                    }
                    i = R$drawable.rank_type_movie;
                    break;
                case 82650203:
                    if (category.equals("Video")) {
                        i = R$drawable.rank_type_movie;
                        break;
                    }
                    i = R$drawable.rank_type_movie;
                    break;
                case 984938536:
                    if (category.equals("For you")) {
                        i = R$drawable.rank_type_foryou;
                        break;
                    }
                    i = R$drawable.rank_type_movie;
                    break;
                case 1215329543:
                    if (category.equals("Binge-watch")) {
                        i = R$drawable.rank_type_tv;
                        break;
                    }
                    i = R$drawable.rank_type_movie;
                    break;
                default:
                    i = R$drawable.rank_type_movie;
                    break;
            }
            imageView.setImageResource(i);
        }
        f fVar2 = (f) getMViewBinding();
        if (fVar2 == null || (recyclerView = fVar2.b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        com.transsion.search_pugc.fragment.hot.adapter.g gVar = new com.transsion.search_pugc.fragment.hot.adapter.g(hotRank2.getName(), this.rankIndex, Intrinsics.c(hotRank2.getCategory(), "For you"));
        gVar.n1(hotRank2.getVideos());
        recyclerView.setAdapter(gVar);
    }

    public void lazyLoadData() {
    }
}
