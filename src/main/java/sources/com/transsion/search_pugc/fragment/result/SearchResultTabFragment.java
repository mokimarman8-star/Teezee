package com.transsion.search_pugc.fragment.result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.baseui.R;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.model.PostEntity;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.bean.SearchTab;
import com.transsion.search_pugc.bean.SecondTab;
import com.transsion.search_pugc.bean.UGCPager;
import com.transsion.search_pugc.bean.UGCSearchResultData;
import com.transsion.search_pugc.fragment.BaseSearchMainFragment;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVerticalRank;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u0004R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u0005048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010(\u001a\u0004\bT\u0010U¨\u0006X"}, d2 = {"Lcom/transsion/search_pugc/fragment/result/SearchResultTabFragment;", "Lcom/transsion/search_pugc/fragment/BaseSearchMainFragment;", "Lvp/h;", "<init>", "()V", "Lcom/transsion/search_pugc/bean/SearchResultItem;", "it", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "z0", "(Lcom/transsion/search_pugc/bean/SearchResultItem;I)V", "q0", "Landroid/view/View;", "x0", "()Landroid/view/View;", "Landroid/view/LayoutInflater;", "inflater", "o0", "(Landroid/view/LayoutInflater;)Lvp/h;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", BuildConfig.FLAVOR, "hidden", "onHiddenChanged", "(Z)V", "startLoading", "hideLoading", "lazyLoadData", "Lcom/transsion/search_pugc/fragment/result/adapter/b;", "a", "Lcom/transsion/search_pugc/fragment/result/adapter/b;", "mainAdapter", "Lcom/transsion/search_pugc/fragment/result/SearchResultViewModel;", "b", "Lkotlin/Lazy;", "p0", "()Lcom/transsion/search_pugc/fragment/result/SearchResultViewModel;", "viewModel", BuildConfig.FLAVOR, "c", "Ljava/lang/String;", "keyword", "Lcom/transsion/search_pugc/bean/SearchTab;", "d", "Lcom/transsion/search_pugc/bean/SearchTab;", "tabItem", BuildConfig.FLAVOR, "e", "Ljava/util/List;", "items", "Lbj/b;", "f", "Lbj/b;", "exposureHelper", "Lcom/transsion/search_pugc/bean/SecondTab;", "g", "Lcom/transsion/search_pugc/bean/SecondTab;", "curSecondTab", "Lcom/transsion/search_pugc/bean/UGCSearchResultData;", "h", "Lcom/transsion/search_pugc/bean/UGCSearchResultData;", "searchResultData", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "i", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "requestView", "j", "Ljava/lang/Integer;", "requestMovieCount", "k", "Z", "isLoadMoreEnd", "Leq/a;", "l", "Leq/a;", "secondTabRef", "Lcom/transsion/search_pugc/g;", "m", "getSearchReporter", "()Lcom/transsion/search_pugc/g;", "searchReporter", "n", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchResultTabFragment extends BaseSearchMainFragment<vp.h> {

    /* renamed from: n, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private com.transsion.search_pugc.fragment.result.adapter.b mainAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    private String keyword;

    /* renamed from: d, reason: from kotlin metadata */
    private SearchTab tabItem;

    /* renamed from: f, reason: from kotlin metadata */
    private bj.b exposureHelper;

    /* renamed from: g, reason: from kotlin metadata */
    private SecondTab curSecondTab;

    /* renamed from: h, reason: from kotlin metadata */
    private UGCSearchResultData searchResultData;

    /* renamed from: i, reason: from kotlin metadata */
    private ResourcesRequestView requestView;

    /* renamed from: j, reason: from kotlin metadata */
    private Integer requestMovieCount;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean isLoadMoreEnd;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy viewModel = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.l
        public final Object invoke() {
            SearchResultViewModel B0;
            B0 = SearchResultTabFragment.B0(SearchResultTabFragment.this);
            return B0;
        }
    });

    /* renamed from: e, reason: from kotlin metadata */
    private List items = CollectionsKt.l();

    /* renamed from: l, reason: from kotlin metadata */
    private final eq.a secondTabRef = new eq.a(null, 1, null);

    /* renamed from: m, reason: from kotlin metadata */
    private final Lazy searchReporter = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.m
        public final Object invoke() {
            com.transsion.search_pugc.g A0;
            A0 = SearchResultTabFragment.A0(SearchResultTabFragment.this);
            return A0;
        }
    });

    /* renamed from: com.transsion.search_pugc.fragment.result.SearchResultTabFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchResultTabFragment a(String str, UGCSearchResultData uGCSearchResultData, SearchTab searchTab, String str2, String str3) {
            SearchResultTabFragment searchResultTabFragment = new SearchResultTabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("keyword", str);
            bundle.putParcelable("tabItem", searchTab);
            bundle.putParcelable("searchData", uGCSearchResultData);
            bundle.putString("searchFrom", str2);
            bundle.putString("form_ugc_video_id", str3);
            searchResultTabFragment.setArguments(bundle);
            return searchResultTabFragment;
        }
    }

    public static final class b implements bj.a {
        b() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            com.transsion.search_pugc.fragment.result.adapter.b bVar;
            List data;
            SearchResultItem searchResultItem;
            List data2;
            com.transsion.search_pugc.fragment.result.adapter.b bVar2 = SearchResultTabFragment.this.mainAdapter;
            if (i >= ((bVar2 == null || (data2 = bVar2.getData()) == null) ? 0 : data2.size()) || (bVar = SearchResultTabFragment.this.mainAdapter) == null || (data = bVar.getData()) == null || (searchResultItem = (SearchResultItem) data.get(i)) == null) {
                return;
            }
            SearchResultTabFragment.this.getSearchReporter().v(searchResultItem, i, j, SearchResultTabFragment.this.keyword, SearchResultTabFragment.this.tabItem, SearchResultTabFragment.this.secondTabRef.a());
        }
    }

    static final class c implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.search_pugc.g A0(SearchResultTabFragment searchResultTabFragment) {
        return com.transsion.search_pugc.g.g.a(searchResultTabFragment.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchResultViewModel B0(SearchResultTabFragment searchResultTabFragment) {
        return new v0(searchResultTabFragment).a(SearchResultViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.search_pugc.g getSearchReporter() {
        return (com.transsion.search_pugc.g) this.searchReporter.getValue();
    }

    private final SearchResultViewModel p0() {
        return (SearchResultViewModel) this.viewModel.getValue();
    }

    private final void q0() {
        RecyclerView recyclerView;
        bj.b bVar = new bj.b(0.6f, new b(), false, 4, null);
        bVar.n(2);
        vp.h hVar = (vp.h) getMViewBinding();
        if (hVar != null && (recyclerView = hVar.b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.exposureHelper = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(SearchResultTabFragment searchResultTabFragment, PostEntity postEntity) {
        a.a.g(wf.a.a, "Post request succeed " + postEntity + ", " + (postEntity != null ? postEntity.getCount() : null), false, 2, (Object) null);
        if (postEntity != null && searchResultTabFragment.requestMovieCount == null) {
            int count = postEntity.getCount();
            if (count == null) {
                count = 0;
            }
            searchResultTabFragment.requestMovieCount = count;
            ResourcesRequestView resourcesRequestView = searchResultTabFragment.requestView;
            if (resourcesRequestView != null) {
                Integer count2 = postEntity.getCount();
                resourcesRequestView.setCount(count2 != null ? count2.intValue() : 0, false);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(SearchResultTabFragment searchResultTabFragment, com.transsion.search_pugc.fragment.result.adapter.c cVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List<SecondTab> secondTabs;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        UGCSearchResultData uGCSearchResultData = searchResultTabFragment.searchResultData;
        SecondTab secondTab = (uGCSearchResultData == null || (secondTabs = uGCSearchResultData.getSecondTabs()) == null) ? null : secondTabs.get(i);
        if (Intrinsics.c(searchResultTabFragment.curSecondTab, secondTab)) {
            searchResultTabFragment.curSecondTab = null;
            searchResultTabFragment.secondTabRef.b(null);
            cVar.E1(null);
            searchResultTabFragment.startLoading();
            searchResultTabFragment.p0().q(1);
            SearchResultViewModel p0 = searchResultTabFragment.p0();
            String str = searchResultTabFragment.keyword;
            String str2 = str == null ? BuildConfig.FLAVOR : str;
            SearchTab searchTab = searchResultTabFragment.tabItem;
            p0.m(str2, searchTab != null ? searchTab.getTabId() : null, searchResultTabFragment.getSearchReporter().f(), false, null);
        } else {
            searchResultTabFragment.curSecondTab = secondTab;
            searchResultTabFragment.secondTabRef.b(secondTab);
            cVar.E1(secondTab);
            searchResultTabFragment.startLoading();
            searchResultTabFragment.p0().q(1);
            SearchResultViewModel p02 = searchResultTabFragment.p0();
            String str3 = searchResultTabFragment.keyword;
            String str4 = str3 == null ? BuildConfig.FLAVOR : str3;
            SearchTab searchTab2 = searchResultTabFragment.tabItem;
            p02.m(str4, searchTab2 != null ? searchTab2.getTabId() : null, searchResultTabFragment.getSearchReporter().f(), false, secondTab);
        }
        bj.b bVar = searchResultTabFragment.exposureHelper;
        if (bVar != null) {
            bVar.g();
        }
        com.transsion.search_pugc.g searchReporter = searchResultTabFragment.getSearchReporter();
        String str5 = searchResultTabFragment.keyword;
        SearchTab searchTab3 = searchResultTabFragment.tabItem;
        UGCSearchResultData uGCSearchResultData2 = searchResultTabFragment.searchResultData;
        searchReporter.z(str5, searchTab3, secondTab, uGCSearchResultData2 != null ? uGCSearchResultData2.getOps() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(SearchResultTabFragment searchResultTabFragment) {
        SearchResultViewModel p0 = searchResultTabFragment.p0();
        String str = searchResultTabFragment.keyword;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        SearchTab searchTab = searchResultTabFragment.tabItem;
        p0.m(str, searchTab != null ? searchTab.getTabId() : null, searchResultTabFragment.getSearchReporter().f(), true, searchResultTabFragment.curSecondTab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(SearchResultTabFragment searchResultTabFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        SearchResultItem searchResultItem;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        com.transsion.search_pugc.fragment.result.adapter.b bVar = searchResultTabFragment.mainAdapter;
        if (bVar == null || (searchResultItem = (SearchResultItem) bVar.getItem(i)) == null) {
            return;
        }
        searchResultTabFragment.z0(searchResultItem, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(SearchResultTabFragment searchResultTabFragment, UGCSearchResultData uGCSearchResultData) {
        t6.f h0;
        t6.f h02;
        List data;
        String tabId = uGCSearchResultData != null ? uGCSearchResultData.getTabId() : null;
        SearchTab searchTab = searchResultTabFragment.tabItem;
        if (Intrinsics.c(tabId, searchTab != null ? searchTab.getTabId() : null)) {
            Intrinsics.e(uGCSearchResultData);
            if (uGCSearchResultData.getItems().isEmpty()) {
                com.transsion.search_pugc.fragment.result.adapter.b bVar = searchResultTabFragment.mainAdapter;
                if (bVar != null && (data = bVar.getData()) != null) {
                    data.clear();
                }
                com.transsion.search_pugc.fragment.result.adapter.b bVar2 = searchResultTabFragment.mainAdapter;
                if (bVar2 != null) {
                    bVar2.notifyDataSetChanged();
                }
                com.transsion.search_pugc.fragment.result.adapter.b bVar3 = searchResultTabFragment.mainAdapter;
                if (bVar3 != null) {
                    bVar3.Y0(searchResultTabFragment.x0());
                }
            } else {
                com.transsion.search_pugc.fragment.result.adapter.b bVar4 = searchResultTabFragment.mainAdapter;
                if (bVar4 != null) {
                    bVar4.n1(uGCSearchResultData.getItems());
                }
                UGCPager pager = uGCSearchResultData.getPager();
                if (pager == null || pager.getHasMore()) {
                    com.transsion.search_pugc.fragment.result.adapter.b bVar5 = searchResultTabFragment.mainAdapter;
                    if (bVar5 != null && (h0 = bVar5.h0()) != null) {
                        h0.s();
                    }
                } else {
                    com.transsion.search_pugc.fragment.result.adapter.b bVar6 = searchResultTabFragment.mainAdapter;
                    if (bVar6 != null && (h02 = bVar6.h0()) != null) {
                        t6.f.u(h02, false, 1, (Object) null);
                    }
                    searchResultTabFragment.isLoadMoreEnd = true;
                }
            }
            searchResultTabFragment.hideLoading();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(SearchResultTabFragment searchResultTabFragment, UGCSearchResultData uGCSearchResultData) {
        t6.f h0;
        t6.f h02;
        t6.f h03;
        String tabId = uGCSearchResultData != null ? uGCSearchResultData.getTabId() : null;
        SearchTab searchTab = searchResultTabFragment.tabItem;
        if (Intrinsics.c(tabId, searchTab != null ? searchTab.getTabId() : null)) {
            Intrinsics.e(uGCSearchResultData);
            if (uGCSearchResultData.getItems().isEmpty()) {
                com.transsion.search_pugc.fragment.result.adapter.b bVar = searchResultTabFragment.mainAdapter;
                if (bVar != null && (h03 = bVar.h0()) != null) {
                    t6.f.u(h03, false, 1, (Object) null);
                }
            } else {
                com.transsion.search_pugc.fragment.result.adapter.b bVar2 = searchResultTabFragment.mainAdapter;
                if (bVar2 != null) {
                    bVar2.q(uGCSearchResultData.getItems());
                }
                UGCPager pager = uGCSearchResultData.getPager();
                if (pager == null || pager.getHasMore()) {
                    com.transsion.search_pugc.fragment.result.adapter.b bVar3 = searchResultTabFragment.mainAdapter;
                    if (bVar3 != null && (h0 = bVar3.h0()) != null) {
                        h0.s();
                    }
                } else {
                    com.transsion.search_pugc.fragment.result.adapter.b bVar4 = searchResultTabFragment.mainAdapter;
                    if (bVar4 != null && (h02 = bVar4.h0()) != null) {
                        t6.f.u(h02, false, 1, (Object) null);
                    }
                }
            }
        }
        searchResultTabFragment.hideLoading();
        return Unit.a;
    }

    private final View x0() {
        LayoutInflater layoutInflater = getLayoutInflater();
        int i = R$layout.view_search_no_network;
        vp.h hVar = (vp.h) getMViewBinding();
        View inflate = layoutInflater.inflate(i, (ViewGroup) (hVar != null ? hVar.b : null), false);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_empty_tips);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_tips);
        AppCompatTextView findViewById = inflate.findViewById(R$id.tv_retry);
        textView.setText(R.string.base_net_err);
        imageView.setImageResource(com.tn.lib.widget.R.mipmap.ic_no_network);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.fragment.result.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchResultTabFragment.y0(SearchResultTabFragment.this, view);
            }
        });
        Intrinsics.e(inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(SearchResultTabFragment searchResultTabFragment, View view) {
        searchResultTabFragment.lazyLoadData();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void z0(SearchResultItem it, int position) {
        List videos;
        UGCVideo uGCVideo;
        String topicType = it.getTopicType();
        if (topicType != null) {
            switch (topicType.hashCode()) {
                case -1989652851:
                    if (topicType.equals("UGC_VIDEO")) {
                        UGCVideo video = it.getVideo();
                        if (video != null) {
                            com.transsion.search_pugc.constant.a.h(video, false, 1, null);
                        }
                        com.transsion.search_pugc.fragment.result.adapter.b bVar = this.mainAdapter;
                        if (bVar != null) {
                            bVar.d(it, position);
                            break;
                        }
                    }
                    break;
                case 511113132:
                    if (topicType.equals("UGC_COLLECTION")) {
                        UGCCollection collection = it.getCollection();
                        if (collection != null && (videos = collection.getVideos()) != null && (uGCVideo = (UGCVideo) CollectionsKt.k0(videos)) != null) {
                            com.transsion.search_pugc.constant.a.h(uGCVideo, false, 1, null);
                        }
                        com.transsion.search_pugc.fragment.result.adapter.b bVar2 = this.mainAdapter;
                        if (bVar2 != null) {
                            bVar2.d(it, position);
                            break;
                        }
                    }
                    break;
                case 932115657:
                    topicType.equals("HASH_TAG");
                    break;
                case 2033770325:
                    if (topicType.equals("VERTICAL_RANK")) {
                        UGCVerticalRank verticalRank = it.getVerticalRank();
                        if (verticalRank != null) {
                            UGCSearchResultData uGCSearchResultData = this.searchResultData;
                            com.transsion.search_pugc.constant.a.f(verticalRank, uGCSearchResultData != null ? uGCSearchResultData.getOps() : null);
                        }
                        com.transsion.search_pugc.fragment.result.adapter.b bVar3 = this.mainAdapter;
                        if (bVar3 != null) {
                            bVar3.d(it, position);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    public void hideLoading() {
        RecyclerView recyclerView;
        ProgressBar progressBar;
        vp.h hVar = (vp.h) getMViewBinding();
        if (hVar != null && (progressBar = hVar.d) != null) {
            progressBar.setVisibility(4);
        }
        vp.h hVar2 = (vp.h) getMViewBinding();
        if (hVar2 == null || (recyclerView = hVar2.b) == null) {
            return;
        }
        recyclerView.setVisibility(0);
    }

    public void initView(View view, Bundle savedInstanceState) {
        List<SearchResultItem> l;
        RecyclerView recyclerView;
        t6.f h0;
        com.transsion.search_pugc.fragment.result.adapter.b bVar;
        vp.h hVar;
        RecyclerView recyclerView2;
        List<SecondTab> secondTabs;
        UGCSearchResultData uGCSearchResultData;
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        this.keyword = arguments != null ? arguments.getString("keyword") : null;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("form_ugc_video_id") : null;
        Bundle arguments3 = getArguments();
        this.tabItem = arguments3 != null ? (SearchTab) arguments3.getParcelable("tabItem") : null;
        Bundle arguments4 = getArguments();
        UGCSearchResultData uGCSearchResultData2 = arguments4 != null ? (UGCSearchResultData) arguments4.getParcelable("searchData") : null;
        this.searchResultData = uGCSearchResultData2;
        if (uGCSearchResultData2 == null) {
            SearchResultFragment parentFragment = getParentFragment();
            SearchResultFragment searchResultFragment = parentFragment instanceof SearchResultFragment ? parentFragment : null;
            if (searchResultFragment != null) {
                SearchTab searchTab = this.tabItem;
                uGCSearchResultData = searchResultFragment.m0(searchTab != null ? searchTab.getTabId() : null);
            } else {
                uGCSearchResultData = null;
            }
            this.searchResultData = uGCSearchResultData;
        }
        UGCSearchResultData uGCSearchResultData3 = this.searchResultData;
        if (uGCSearchResultData3 == null || (l = uGCSearchResultData3.getItems()) == null) {
            l = CollectionsKt.l();
        }
        this.items = l;
        p0().p(string);
        UGCSearchResultData uGCSearchResultData4 = this.searchResultData;
        List<SecondTab> secondTabs2 = uGCSearchResultData4 != null ? uGCSearchResultData4.getSecondTabs() : null;
        if (secondTabs2 != null && !secondTabs2.isEmpty() && (hVar = (vp.h) getMViewBinding()) != null && (recyclerView2 = hVar.c) != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
            final com.transsion.search_pugc.fragment.result.adapter.c cVar = new com.transsion.search_pugc.fragment.result.adapter.c(this.curSecondTab);
            UGCSearchResultData uGCSearchResultData5 = this.searchResultData;
            cVar.n1((uGCSearchResultData5 == null || (secondTabs = uGCSearchResultData5.getSecondTabs()) == null) ? new ArrayList() : secondTabs);
            recyclerView2.setAdapter(cVar);
            cVar.w1(new r6.d() { // from class: com.transsion.search_pugc.fragment.result.f
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    SearchResultTabFragment.s0(SearchResultTabFragment.this, cVar, baseQuickAdapter, view2, i);
                }
            });
        }
        vp.h hVar2 = (vp.h) getMViewBinding();
        if (hVar2 != null && (recyclerView = hVar2.b) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            UGCSearchResultData uGCSearchResultData6 = this.searchResultData;
            List<SecondTab> secondTabs3 = uGCSearchResultData6 != null ? uGCSearchResultData6.getSecondTabs() : null;
            if (secondTabs3 == null || secondTabs3.isEmpty()) {
                recyclerView.addItemDecoration(new tf.f(0.0f, 1.0f, 6.0f, 1, (DefaultConstructorMarker) null));
            }
            com.transsion.search_pugc.fragment.result.adapter.b bVar2 = new com.transsion.search_pugc.fragment.result.adapter.b(null, this.keyword, this.tabItem, this.secondTabRef);
            this.mainAdapter = bVar2;
            recyclerView.setAdapter(bVar2);
            if (!this.items.isEmpty() && (bVar = this.mainAdapter) != null) {
                bVar.n1(this.items);
            }
            com.transsion.search_pugc.fragment.result.adapter.b bVar3 = this.mainAdapter;
            if (bVar3 != null && (h0 = bVar3.h0()) != null) {
                h0.D(new r6.f() { // from class: com.transsion.search_pugc.fragment.result.g
                    public final void a() {
                        SearchResultTabFragment.t0(SearchResultTabFragment.this);
                    }
                });
            }
        }
        com.transsion.search_pugc.fragment.result.adapter.b bVar4 = this.mainAdapter;
        if (bVar4 != null) {
            bVar4.w1(new r6.d() { // from class: com.transsion.search_pugc.fragment.result.h
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    SearchResultTabFragment.u0(SearchResultTabFragment.this, baseQuickAdapter, view2, i);
                }
            });
        }
        p0().l().j(getViewLifecycleOwner(), new c(new Function1() { // from class: com.transsion.search_pugc.fragment.result.i
            public final Object invoke(Object obj) {
                Unit v0;
                v0 = SearchResultTabFragment.v0(SearchResultTabFragment.this, (UGCSearchResultData) obj);
                return v0;
            }
        }));
        p0().k().j(getViewLifecycleOwner(), new c(new Function1() { // from class: com.transsion.search_pugc.fragment.result.j
            public final Object invoke(Object obj) {
                Unit w0;
                w0 = SearchResultTabFragment.w0(SearchResultTabFragment.this, (UGCSearchResultData) obj);
                return w0;
            }
        }));
        p0().h().j(this, new c(new Function1() { // from class: com.transsion.search_pugc.fragment.result.k
            public final Object invoke(Object obj) {
                Unit r0;
                r0 = SearchResultTabFragment.r0(SearchResultTabFragment.this, (PostEntity) obj);
                return r0;
            }
        }));
        q0();
    }

    public void lazyLoadData() {
        t6.f h0;
        UGCPager pager;
        t6.f h02;
        RecyclerView recyclerView;
        int size = this.items.size();
        StringBuilder sb = new StringBuilder();
        sb.append("lazyLoadData size: ");
        sb.append(size);
        UGCSearchResultData uGCSearchResultData = this.searchResultData;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("lazyLoadData searchResultData: ");
        sb2.append(uGCSearchResultData);
        vp.h hVar = (vp.h) getMViewBinding();
        if (hVar != null && (recyclerView = hVar.c) != null) {
            UGCSearchResultData uGCSearchResultData2 = this.searchResultData;
            List<SecondTab> secondTabs = uGCSearchResultData2 != null ? uGCSearchResultData2.getSecondTabs() : null;
            recyclerView.setVisibility((secondTabs == null || secondTabs.isEmpty()) ? 8 : 0);
        }
        if (this.items.isEmpty()) {
            startLoading();
            SearchResultViewModel p0 = p0();
            String str = this.keyword;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            String str2 = str;
            SearchTab searchTab = this.tabItem;
            SearchResultViewModel.n(p0, str2, searchTab != null ? searchTab.getTabId() : null, getSearchReporter().f(), false, this.curSecondTab, 8, null);
            return;
        }
        com.transsion.search_pugc.fragment.result.adapter.b bVar = this.mainAdapter;
        if (bVar != null) {
            bVar.n1(this.items);
        }
        UGCSearchResultData uGCSearchResultData3 = this.searchResultData;
        if (uGCSearchResultData3 == null || (pager = uGCSearchResultData3.getPager()) == null || pager.getHasMore()) {
            com.transsion.search_pugc.fragment.result.adapter.b bVar2 = this.mainAdapter;
            if (bVar2 != null && (h0 = bVar2.h0()) != null) {
                h0.s();
            }
            p0().q(2);
            return;
        }
        com.transsion.search_pugc.fragment.result.adapter.b bVar3 = this.mainAdapter;
        if (bVar3 == null || (h02 = bVar3.h0()) == null) {
            return;
        }
        h02.t(true);
    }

    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public vp.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        vp.h c2 = vp.h.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    @Override // com.transsion.search_pugc.fragment.BaseSearchMainFragment
    public void onHiddenChanged(boolean hidden) {
        bj.b bVar;
        super.onHiddenChanged(hidden);
        if (!hidden || (bVar = this.exposureHelper) == null) {
            return;
        }
        bVar.f();
    }

    public void onPause() {
        super.onPause();
        bj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    public void onResume() {
        com.transsion.search_pugc.fragment.result.adapter.b bVar;
        t6.f h0;
        super.onResume();
        if (!this.isLoadMoreEnd || (bVar = this.mainAdapter) == null || (h0 = bVar.h0()) == null) {
            return;
        }
        t6.f.u(h0, false, 1, (Object) null);
    }

    public void startLoading() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ProgressBar progressBar;
        vp.h hVar = (vp.h) getMViewBinding();
        if (hVar != null && (progressBar = hVar.d) != null) {
            progressBar.setVisibility(0);
        }
        vp.h hVar2 = (vp.h) getMViewBinding();
        if (hVar2 != null && (recyclerView2 = hVar2.b) != null) {
            recyclerView2.setVisibility(4);
        }
        vp.h hVar3 = (vp.h) getMViewBinding();
        if (hVar3 == null || (recyclerView = hVar3.c) == null) {
            return;
        }
        recyclerView.setEnabled(false);
    }
}
