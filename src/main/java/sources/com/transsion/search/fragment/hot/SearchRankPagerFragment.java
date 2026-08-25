package com.transsion.search.fragment.hot;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.R$drawable;
import com.transsion.search.bean.GroupInfo;
import com.transsion.search.bean.HotRankItem;
import com.transsion.search.bean.HotSubject;
import com.transsion.search.fragment.hot.adapter.c;
import com.transsion.search.widget.d;
import ij.h;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import vp.f;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/transsion/search/fragment/hot/SearchRankPagerFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lvp/f;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "a0", "(Landroid/view/LayoutInflater;)Lvp/f;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "b0", "lazyLoadData", BuildConfig.FLAVOR, "a", "Z", "hasReported", "b", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchRankPagerFragment extends BaseFragment<f> {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private boolean hasReported;

    /* renamed from: com.transsion.search.fragment.hot.SearchRankPagerFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchRankPagerFragment a(HotRankItem hotRankItem) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("hotRankItem", hotRankItem);
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
        List<GroupInfo> groups;
        List<HotSubject> items;
        if (this.hasReported) {
            return;
        }
        boolean a = h.a.a();
        Bundle arguments = getArguments();
        HotRankItem hotRankItem = arguments != null ? (HotRankItem) arguments.getParcelable("hotRankItem") : null;
        HotRankItem hotRankItem2 = hotRankItem instanceof HotRankItem ? hotRankItem : null;
        int i = 0;
        if (hotRankItem2 != null && (items = hotRankItem2.getItems()) != null) {
            int i2 = 0;
            for (Object obj : items) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                d.a.n((HotSubject) obj, i2, hotRankItem2.getCategory(), hotRankItem2.getIndex(), a);
                i2 = i3;
            }
        }
        if (hotRankItem2 != null && (groups = hotRankItem2.getGroups()) != null) {
            Iterator<T> it = groups.iterator();
            while (true) {
                int i4 = i;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                i = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.u();
                }
                d.a.l((GroupInfo) next, i4, hotRankItem2.getCategory(), hotRankItem2.getIndex(), a);
            }
        }
        this.hasReported = true;
    }

    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        RecyclerView.Adapter hVar;
        ImageView imageView;
        int i;
        List<GroupInfo> groups;
        List<HotSubject> items;
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        HotRankItem hotRankItem = arguments != null ? (HotRankItem) arguments.getParcelable("hotRankItem") : null;
        HotRankItem hotRankItem2 = hotRankItem instanceof HotRankItem ? hotRankItem : null;
        if (hotRankItem2 == null) {
            return;
        }
        boolean c = Intrinsics.c(hotRankItem2.getCategory(), HotRankItem.CATE_GROUP);
        if (c || !((items = hotRankItem2.getItems()) == null || items.isEmpty())) {
            if (c && ((groups = hotRankItem2.getGroups()) == null || groups.isEmpty())) {
                return;
            }
            f fVar = (f) getMViewBinding();
            if (fVar != null && (imageView = fVar.c) != null) {
                String category = hotRankItem2.getCategory();
                int hashCode = category.hashCode();
                if (hashCode == 2690) {
                    if (category.equals(HotRankItem.CATE_TV)) {
                        i = R$drawable.rank_type_tv;
                        imageView.setImageResource(i);
                    }
                    i = R$drawable.rank_type_community;
                    imageView.setImageResource(i);
                } else if (hashCode != 74534672) {
                    if (hashCode == 74710533 && category.equals(HotRankItem.CATE_MUSIC)) {
                        i = R$drawable.rank_type_music;
                        imageView.setImageResource(i);
                    }
                    i = R$drawable.rank_type_community;
                    imageView.setImageResource(i);
                } else {
                    if (category.equals(HotRankItem.CATE_MOVIE)) {
                        i = R$drawable.rank_type_movie;
                        imageView.setImageResource(i);
                    }
                    i = R$drawable.rank_type_community;
                    imageView.setImageResource(i);
                }
            }
            f fVar2 = (f) getMViewBinding();
            if (fVar2 == null || (recyclerView = fVar2.b) == null) {
                return;
            }
            Resources resources = recyclerView.getResources();
            Intrinsics.g(resources, "getResources(...)");
            boolean e = com.transsion.search.f.e(resources);
            recyclerView.setLayoutManager(e ? new NpaGridLayoutManager(recyclerView.getContext(), 2) : new LinearLayoutManager(recyclerView.getContext()));
            if (!Intrinsics.c(hotRankItem2.getCategory(), HotRankItem.CATE_TV) && !Intrinsics.c(hotRankItem2.getCategory(), HotRankItem.CATE_MOVIE) && recyclerView.getItemDecorationCount() == 0) {
                recyclerView.addItemDecoration(new tf.f(0.0f, 8.0f, 0.0f, 5, (DefaultConstructorMarker) null));
            }
            if (c) {
                hVar = new c(hotRankItem2.getCategory(), hotRankItem2.getIndex());
                hVar.n1(hotRankItem2.getGroups());
            } else {
                hVar = new com.transsion.search.fragment.hot.adapter.h(hotRankItem2.getCategory(), hotRankItem2.getIndex(), e);
                hVar.n1(hotRankItem2.getItems());
            }
            recyclerView.setAdapter(hVar);
        }
    }

    public void lazyLoadData() {
    }
}
