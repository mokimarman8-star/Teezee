package com.transsion.search.fragment.result;

import android.content.res.Resources;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.R;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.publish.model.PostEntity;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.HotRankItem;
import com.transsion.search.bean.Pager;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.bean.TabItem;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.BaseSearchMainFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u0004J\u0017\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\"\u0010\u0012J\u000f\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\tH\u0016¢\u0006\u0004\b$\u0010\u0004R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00101R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00101R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006R"}, d2 = {"Lcom/transsion/search/fragment/result/SearchResultTabFragment;", "Lcom/transsion/search/fragment/BaseSearchMainFragment;", "Lvp/h;", "<init>", "()V", "Lcom/transsion/search/fragment/result/ResultWrapData;", "it", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "F0", "(Lcom/transsion/search/fragment/result/ResultWrapData;I)V", "t0", "s0", "x0", BuildConfig.FLAVOR, "showTab", "G0", "(Z)V", "Landroid/view/View;", "C0", "()Landroid/view/View;", "Landroid/view/LayoutInflater;", "inflater", "q0", "(Landroid/view/LayoutInflater;)Lvp/h;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "hidden", "onHiddenChanged", "hideLoading", "lazyLoadData", "Lcom/transsion/search/fragment/result/adapter/a;", "a", "Lcom/transsion/search/fragment/result/adapter/a;", "mainAdapter", "Lcom/transsion/search/fragment/result/SearchResultViewModel;", "b", "Lkotlin/Lazy;", "r0", "()Lcom/transsion/search/fragment/result/SearchResultViewModel;", "viewModel", BuildConfig.FLAVOR, "c", "Ljava/lang/String;", "keyword", "Lcom/transsion/search/bean/TabItem;", "d", "Lcom/transsion/search/bean/TabItem;", "tabItem", "e", "searchFrom", "Lbj/b;", "f", "Lbj/b;", "exposureHelper", BuildConfig.FLAVOR, "g", "J", "lastScrollTime", "h", "currentTabId", "Lcom/transsion/search/bean/SearchResultEntity;", "i", "Lcom/transsion/search/bean/SearchResultEntity;", "extraResultData", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "j", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "requestView", "k", "Ljava/lang/Integer;", "requestMovieCount", "l", "Z", "isLoadMoreEnd", "m", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchResultTabFragment extends BaseSearchMainFragment<vp.h> {

    /* renamed from: m, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private com.transsion.search.fragment.result.adapter.a mainAdapter;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy viewModel = LazyKt.b(new Function0() { // from class: com.transsion.search.fragment.result.i
        public final Object invoke() {
            SearchResultViewModel H0;
            H0 = SearchResultTabFragment.H0(SearchResultTabFragment.this);
            return H0;
        }
    });

    /* renamed from: c, reason: from kotlin metadata */
    private String keyword;

    /* renamed from: d, reason: from kotlin metadata */
    private TabItem tabItem;

    /* renamed from: e, reason: from kotlin metadata */
    private String searchFrom;

    /* renamed from: f, reason: from kotlin metadata */
    private bj.b exposureHelper;

    /* renamed from: g, reason: from kotlin metadata */
    private long lastScrollTime;

    /* renamed from: h, reason: from kotlin metadata */
    private String currentTabId;

    /* renamed from: i, reason: from kotlin metadata */
    private SearchResultEntity extraResultData;

    /* renamed from: j, reason: from kotlin metadata */
    private ResourcesRequestView requestView;

    /* renamed from: k, reason: from kotlin metadata */
    private Integer requestMovieCount;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean isLoadMoreEnd;

    /* renamed from: com.transsion.search.fragment.result.SearchResultTabFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchResultTabFragment a(String str, TabItem tabItem, SearchResultEntity searchResultEntity, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("tabKeyword", str);
            bundle.putParcelable("tabItem", tabItem);
            if (searchResultEntity != null) {
                bundle.putParcelable("tabResult", searchResultEntity);
            }
            bundle.putString("searchFrom", str2);
            SearchResultTabFragment searchResultTabFragment = new SearchResultTabFragment();
            searchResultTabFragment.setArguments(bundle);
            return searchResultTabFragment;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ResultType.values().length];
            try {
                iArr[ResultType.SUBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResultType.STAFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ResultType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ResultType.VERTICAL_RANK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ResultType.MORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    public static final class c implements bj.a {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ResultType.values().length];
                try {
                    iArr[ResultType.SUBJECT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ResultType.STAFF.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ResultType.GROUP.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ResultType.VERTICAL_RANK.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
            }
        }

        c() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            String str;
            List data;
            List data2;
            com.transsion.search.fragment.result.adapter.a aVar = SearchResultTabFragment.this.mainAdapter;
            if (i >= ((aVar == null || (data2 = aVar.getData()) == null) ? 0 : data2.size())) {
                return;
            }
            com.transsion.search.fragment.result.adapter.a aVar2 = SearchResultTabFragment.this.mainAdapter;
            if (aVar2 == null || (str = aVar2.getTabId()) == null) {
                str = SearchResultTabFragment.this.currentTabId;
            }
            String str2 = str;
            com.transsion.search.fragment.result.adapter.a aVar3 = SearchResultTabFragment.this.mainAdapter;
            ResultWrapData resultWrapData = (aVar3 == null || (data = aVar3.getData()) == null) ? null : (ResultWrapData) data.get(i);
            ResultType type = resultWrapData != null ? resultWrapData.getType() : null;
            int i2 = type == null ? -1 : a.a[type.ordinal()];
            if (i2 == 1) {
                com.transsion.search.widget.d.a.t(resultWrapData.getSubject(), i, j, SearchResultTabFragment.this.keyword, SearchResultTabFragment.this.searchFrom, str2);
                return;
            }
            if (i2 == 2) {
                com.transsion.search.widget.d.a.r(resultWrapData.getStaff(), i, j, SearchResultTabFragment.this.keyword, SearchResultTabFragment.this.searchFrom, str2);
            } else if (i2 == 3) {
                com.transsion.search.widget.d.a.a(resultWrapData.getGroups(), i, j, SearchResultTabFragment.this.keyword, SearchResultTabFragment.this.searchFrom, str2);
            } else {
                if (i2 != 4) {
                    return;
                }
                com.transsion.search.widget.d.a.j(resultWrapData.getVerticalRank(), i, j, SearchResultTabFragment.this.keyword, SearchResultTabFragment.this.searchFrom, str2);
            }
        }
    }

    public static final class d extends RecyclerView.r {
        d() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            RecyclerView recyclerView2;
            Intrinsics.h(recyclerView, "recyclerView");
            if (i == 0) {
                SearchResultTabFragment.this.lastScrollTime = System.currentTimeMillis();
            } else {
                if (i != 1) {
                    return;
                }
                vp.h hVar = (vp.h) SearchResultTabFragment.this.getMViewBinding();
                RecyclerView.m layoutManager = (hVar == null || (recyclerView2 = hVar.b) == null) ? null : recyclerView2.getLayoutManager();
                com.transsion.search.widget.d.a.p(SearchResultTabFragment.this.currentTabId, SearchResultTabFragment.this.keyword, System.currentTimeMillis() - SearchResultTabFragment.this.lastScrollTime, layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() : -1);
            }
        }
    }

    public static final class e extends GridLayoutManager.c {
        e() {
        }

        public int f(int i) {
            ResultWrapData resultWrapData;
            com.transsion.search.fragment.result.adapter.a aVar = SearchResultTabFragment.this.mainAdapter;
            ResultType type = (aVar == null || (resultWrapData = (ResultWrapData) aVar.getItem(i)) == null) ? null : resultWrapData.getType();
            return (type == ResultType.MORE || type == ResultType.TITLE) ? 2 : 1;
        }
    }

    static final class f implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        f(Function1 function1) {
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
    public static final void A0(SearchResultTabFragment searchResultTabFragment) {
        SearchResultViewModel r0 = searchResultTabFragment.r0();
        String str = searchResultTabFragment.keyword;
        String str2 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        String str3 = searchResultTabFragment.currentTabId;
        if (str3 != null) {
            str2 = str3;
        }
        r0.o(str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(SearchResultTabFragment searchResultTabFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ResultWrapData resultWrapData;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        com.transsion.search.fragment.result.adapter.a aVar = searchResultTabFragment.mainAdapter;
        if (aVar == null || (resultWrapData = (ResultWrapData) aVar.getItem(i)) == null) {
            return;
        }
        searchResultTabFragment.F0(resultWrapData, i);
    }

    private final View C0() {
        AppCompatTextView appCompatTextView;
        if (!yg.l.a.e()) {
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
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchResultTabFragment.E0(SearchResultTabFragment.this, view);
                }
            });
            Intrinsics.e(inflate);
            return inflate;
        }
        LayoutInflater layoutInflater2 = getLayoutInflater();
        int i2 = R$layout.view_search_empty;
        vp.h hVar2 = (vp.h) getMViewBinding();
        View inflate2 = layoutInflater2.inflate(i2, (ViewGroup) (hVar2 != null ? hVar2.b : null), false);
        final ResourcesRequestView resourcesRequestView = (ResourcesRequestView) inflate2.findViewById(R$id.resources_request);
        this.requestView = resourcesRequestView;
        final String str = this.keyword;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        if (str.length() > 10) {
            String substring = str.substring(0, 10);
            Intrinsics.g(substring, "substring(...)");
            str = substring + "...";
        }
        String string = getString(R$string.search_value_no_result, new Object[]{this.keyword});
        Intrinsics.g(string, "getString(...)");
        resourcesRequestView.set(string);
        resourcesRequestView.setGray(true);
        r0().m(str, true);
        this.requestMovieCount = null;
        jj.g mViewBinding = resourcesRequestView.getMViewBinding();
        if (mViewBinding != null && (appCompatTextView = mViewBinding.e) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchResultTabFragment.D0(SearchResultTabFragment.this, str, resourcesRequestView, view);
                }
            });
        }
        Intrinsics.e(inflate2);
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(SearchResultTabFragment searchResultTabFragment, String str, ResourcesRequestView resourcesRequestView, View view) {
        vo.e.a.e(searchResultTabFragment, NoticePermissionFrom.DETAIL_NO_RES);
        SearchResultViewModel.n(searchResultTabFragment.r0(), str, false, 2, null);
        Integer num = searchResultTabFragment.requestMovieCount;
        if (num != null) {
            Intrinsics.e(num);
            Integer valueOf = Integer.valueOf(num.intValue() + 1);
            searchResultTabFragment.requestMovieCount = valueOf;
            Intrinsics.e(valueOf);
            ResourcesRequestView.setCount$default(resourcesRequestView, valueOf.intValue(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(SearchResultTabFragment searchResultTabFragment, View view) {
        searchResultTabFragment.lazyLoadData();
    }

    private final void F0(ResultWrapData it, int position) {
        String deeplink;
        int i = b.a[it.getType().ordinal()];
        if (i == 1) {
            com.transsion.search.f.c(it.getSubject(), "search_result");
            com.transsion.search.widget.d.a.u(it.getSubject(), position, this.keyword, this.searchFrom, this.currentTabId);
            return;
        }
        if (i == 2) {
            Navigator.x(TheRouter.c("/movie/staff").J("staff", it.getStaff()), requireContext(), (mf.c) null, 2, (Object) null);
            com.transsion.search.widget.d.a.s(it.getStaff(), position, this.keyword, this.searchFrom, this.currentTabId);
            return;
        }
        if (i == 3) {
            Navigator c2 = TheRouter.c("/room/detail");
            Group groups = it.getGroups();
            Navigator.x(c2.K("id", groups != null ? groups.getGroupId() : null), requireContext(), (mf.c) null, 2, (Object) null);
            com.transsion.search.widget.d.a.b(it.getGroups(), position, this.keyword, this.searchFrom, this.currentTabId);
            return;
        }
        if (i == 4) {
            VerticalRank verticalRank = it.getVerticalRank();
            if (verticalRank != null && (deeplink = verticalRank.getDeeplink()) != null) {
                ij.k.h(deeplink, null, 1, null);
            }
            com.transsion.search.widget.d.a.k(it.getVerticalRank(), position, this.keyword, this.searchFrom, this.currentTabId);
            return;
        }
        if (i == 5 && (getParentFragment() instanceof SearchResultFragment)) {
            SearchResultFragment parentFragment = getParentFragment();
            Intrinsics.f(parentFragment, "null cannot be cast to non-null type com.transsion.search.fragment.result.SearchResultFragment");
            SearchResultFragment searchResultFragment = parentFragment;
            String moreTabId = it.getMoreTabId();
            if (moreTabId == null) {
                moreTabId = BuildConfig.FLAVOR;
            }
            searchResultFragment.q0(moreTabId);
        }
    }

    private final void G0(boolean showTab) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        vp.h hVar;
        RecyclerView recyclerView3;
        ProgressBar progressBar;
        vp.h hVar2 = (vp.h) getMViewBinding();
        if (hVar2 != null && (progressBar = hVar2.d) != null) {
            progressBar.setVisibility(0);
        }
        if (!showTab && (hVar = (vp.h) getMViewBinding()) != null && (recyclerView3 = hVar.c) != null) {
            recyclerView3.setVisibility(8);
        }
        vp.h hVar3 = (vp.h) getMViewBinding();
        if (hVar3 != null && (recyclerView2 = hVar3.b) != null) {
            recyclerView2.setVisibility(4);
        }
        vp.h hVar4 = (vp.h) getMViewBinding();
        if (hVar4 == null || (recyclerView = hVar4.c) == null) {
            return;
        }
        recyclerView.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchResultViewModel H0(SearchResultTabFragment searchResultTabFragment) {
        return new v0(searchResultTabFragment).a(SearchResultViewModel.class);
    }

    private final SearchResultViewModel r0() {
        return (SearchResultViewModel) this.viewModel.getValue();
    }

    private final void s0() {
        List<TabItem> subs;
        List<TabItem> subs2;
        TabItem tabItem;
        Bundle arguments = getArguments();
        String str = null;
        this.keyword = arguments != null ? arguments.getString("tabKeyword") : null;
        Bundle arguments2 = getArguments();
        this.tabItem = arguments2 != null ? (TabItem) arguments2.getParcelable("tabItem") : null;
        Bundle arguments3 = getArguments();
        this.extraResultData = arguments3 != null ? (SearchResultEntity) arguments3.getParcelable("tabResult") : null;
        Bundle arguments4 = getArguments();
        this.searchFrom = arguments4 != null ? arguments4.getString("searchFrom") : null;
        TabItem tabItem2 = this.tabItem;
        if (tabItem2 == null || (subs = tabItem2.getSubs()) == null || !(!subs.isEmpty())) {
            TabItem tabItem3 = this.tabItem;
            if (tabItem3 != null) {
                str = tabItem3.getTabId();
            }
        } else {
            TabItem tabItem4 = this.tabItem;
            if (tabItem4 != null && (subs2 = tabItem4.getSubs()) != null && (tabItem = subs2.get(0)) != null) {
                str = tabItem.getTabId();
            }
        }
        this.currentTabId = str;
    }

    private final void t0() {
        r0().k().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.search.fragment.result.k
            public final Object invoke(Object obj) {
                Unit v0;
                v0 = SearchResultTabFragment.v0(SearchResultTabFragment.this, (SearchResultEntity) obj);
                return v0;
            }
        }));
        r0().j().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.search.fragment.result.l
            public final Object invoke(Object obj) {
                Unit w0;
                w0 = SearchResultTabFragment.w0(SearchResultTabFragment.this, (SearchResultEntity) obj);
                return w0;
            }
        }));
        r0().i().j(this, new f(new Function1() { // from class: com.transsion.search.fragment.result.m
            public final Object invoke(Object obj) {
                Unit u0;
                u0 = SearchResultTabFragment.u0(SearchResultTabFragment.this, (PostEntity) obj);
                return u0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(SearchResultTabFragment searchResultTabFragment, PostEntity postEntity) {
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
    public static final Unit v0(SearchResultTabFragment searchResultTabFragment, SearchResultEntity searchResultEntity) {
        t6.f h0;
        List<ResultWrapData> convertData;
        t6.f h02;
        Pager pager;
        List<ResultWrapData> convertData2;
        com.transsion.search.fragment.result.adapter.a aVar = searchResultTabFragment.mainAdapter;
        if (aVar != null) {
            aVar.n1((searchResultEntity == null || (convertData2 = searchResultEntity.getConvertData()) == null) ? new ArrayList() : convertData2);
        }
        com.transsion.search.fragment.result.adapter.a aVar2 = searchResultTabFragment.mainAdapter;
        if (aVar2 != null) {
            String str = searchResultTabFragment.currentTabId;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            aVar2.S1(str);
        }
        List<ResultWrapData> convertData3 = searchResultEntity != null ? searchResultEntity.getConvertData() : null;
        if (convertData3 == null || convertData3.isEmpty()) {
            searchResultTabFragment.requestMovieCount = null;
            com.transsion.search.fragment.result.adapter.a aVar3 = searchResultTabFragment.mainAdapter;
            if (aVar3 != null) {
                aVar3.Y0(searchResultTabFragment.C0());
            }
        }
        if (searchResultEntity == null || (pager = searchResultEntity.getPager()) == null || pager.getHasMore()) {
            if (((searchResultEntity == null || (convertData = searchResultEntity.getConvertData()) == null) ? 0 : convertData.size()) >= 10) {
                com.transsion.search.fragment.result.adapter.a aVar4 = searchResultTabFragment.mainAdapter;
                if (aVar4 != null && (h0 = aVar4.h0()) != null) {
                    h0.s();
                }
                searchResultTabFragment.hideLoading();
                return Unit.a;
            }
        }
        com.transsion.search.fragment.result.adapter.a aVar5 = searchResultTabFragment.mainAdapter;
        if (aVar5 != null && (h02 = aVar5.h0()) != null) {
            t6.f.u(h02, false, 1, (Object) null);
        }
        searchResultTabFragment.isLoadMoreEnd = true;
        searchResultTabFragment.hideLoading();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(SearchResultTabFragment searchResultTabFragment, SearchResultEntity searchResultEntity) {
        t6.f h0;
        List<ResultWrapData> convertData;
        t6.f h02;
        t6.f h03;
        if (Intrinsics.c(searchResultEntity != null ? searchResultEntity.getTabId() : null, searchResultTabFragment.currentTabId)) {
            if ((searchResultEntity != null ? searchResultEntity.getResults() : null) == null) {
                com.transsion.search.fragment.result.adapter.a aVar = searchResultTabFragment.mainAdapter;
                if (aVar != null && (h03 = aVar.h0()) != null) {
                    h03.v();
                }
            } else {
                com.transsion.search.fragment.result.adapter.a aVar2 = searchResultTabFragment.mainAdapter;
                if (aVar2 != null) {
                    List<ResultWrapData> convertData2 = searchResultEntity.getConvertData();
                    aVar2.q(convertData2 != null ? convertData2 : new ArrayList());
                }
                if (!searchResultEntity.getPager().getHasMore() || (convertData = searchResultEntity.getConvertData()) == null || convertData.isEmpty()) {
                    com.transsion.search.fragment.result.adapter.a aVar3 = searchResultTabFragment.mainAdapter;
                    if (aVar3 != null && (h0 = aVar3.h0()) != null) {
                        t6.f.u(h0, false, 1, (Object) null);
                    }
                } else {
                    com.transsion.search.fragment.result.adapter.a aVar4 = searchResultTabFragment.mainAdapter;
                    if (aVar4 != null && (h02 = aVar4.h0()) != null) {
                        h02.s();
                    }
                }
            }
        }
        return Unit.a;
    }

    private final void x0() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        bj.b bVar = new bj.b(0.6f, new c(), false, 4, null);
        bVar.n(2);
        vp.h hVar = (vp.h) getMViewBinding();
        if (hVar != null && (recyclerView3 = hVar.b) != null) {
            recyclerView3.addOnScrollListener(bVar);
        }
        this.exposureHelper = bVar;
        vp.h hVar2 = (vp.h) getMViewBinding();
        if (hVar2 != null && (recyclerView2 = hVar2.b) != null) {
            recyclerView2.addOnScrollListener(new d());
        }
        vp.h hVar3 = (vp.h) getMViewBinding();
        if (hVar3 == null || (recyclerView = hVar3.b) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.search.fragment.result.j
            @Override // java.lang.Runnable
            public final void run() {
                SearchResultTabFragment.y0(SearchResultTabFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(SearchResultTabFragment searchResultTabFragment) {
        if (searchResultTabFragment.lastScrollTime == 0) {
            searchResultTabFragment.lastScrollTime = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(SearchResultTabFragment searchResultTabFragment, com.transsion.search.fragment.result.adapter.b bVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        List<TabItem> subs;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        TabItem tabItem = searchResultTabFragment.tabItem;
        TabItem tabItem2 = (tabItem == null || (subs = tabItem.getSubs()) == null) ? null : subs.get(i);
        if (Intrinsics.c(searchResultTabFragment.currentTabId, tabItem2 != null ? tabItem2.getTabId() : null)) {
            return;
        }
        searchResultTabFragment.currentTabId = tabItem2 != null ? tabItem2.getTabId() : null;
        if (tabItem2 == null || (str = tabItem2.getTabId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        bVar.C1(str);
        searchResultTabFragment.G0(true);
        searchResultTabFragment.r0().r(1);
        SearchResultViewModel r0 = searchResultTabFragment.r0();
        String str2 = searchResultTabFragment.keyword;
        SearchResultViewModel.p(r0, str2 == null ? BuildConfig.FLAVOR : str2, searchResultTabFragment.currentTabId, false, 4, null);
        bj.b bVar2 = searchResultTabFragment.exposureHelper;
        if (bVar2 != null) {
            bVar2.g();
        }
        com.transsion.search.widget.d.a.x(searchResultTabFragment.keyword, searchResultTabFragment.currentTabId);
    }

    public void hideLoading() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        ProgressBar progressBar;
        vp.h hVar = (vp.h) getMViewBinding();
        if (hVar != null && (progressBar = hVar.d) != null) {
            progressBar.setVisibility(4);
        }
        vp.h hVar2 = (vp.h) getMViewBinding();
        if (hVar2 != null && (recyclerView3 = hVar2.c) != null) {
            recyclerView3.setVisibility(0);
        }
        vp.h hVar3 = (vp.h) getMViewBinding();
        if (hVar3 != null && (recyclerView2 = hVar3.b) != null) {
            recyclerView2.setVisibility(0);
        }
        vp.h hVar4 = (vp.h) getMViewBinding();
        if (hVar4 == null || (recyclerView = hVar4.c) == null) {
            return;
        }
        recyclerView.setEnabled(true);
    }

    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        t6.f h0;
        RecyclerView recyclerView2;
        List<TabItem> subs;
        Intrinsics.h(view, "view");
        s0();
        vp.h hVar = (vp.h) getMViewBinding();
        if (hVar != null && (recyclerView2 = hVar.c) != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
            final com.transsion.search.fragment.result.adapter.b bVar = new com.transsion.search.fragment.result.adapter.b(this.currentTabId);
            TabItem tabItem = this.tabItem;
            bVar.n1((tabItem == null || (subs = tabItem.getSubs()) == null) ? new ArrayList() : subs);
            recyclerView2.setAdapter(bVar);
            bVar.w1(new r6.d() { // from class: com.transsion.search.fragment.result.f
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    SearchResultTabFragment.z0(SearchResultTabFragment.this, bVar, baseQuickAdapter, view2, i);
                }
            });
        }
        vp.h hVar2 = (vp.h) getMViewBinding();
        if (hVar2 != null && (recyclerView = hVar2.b) != null) {
            Resources resources = recyclerView.getContext().getResources();
            Intrinsics.g(resources, "getResources(...)");
            if (com.transsion.search.f.e(resources)) {
                NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(recyclerView.getContext(), 2);
                npaGridLayoutManager.d0(new e());
                recyclerView.setLayoutManager(npaGridLayoutManager);
                recyclerView.addItemDecoration(new tf.b(0, a0.a(12.0f), 0, 0));
            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
                if (!Intrinsics.c(this.currentTabId, "All") && !Intrinsics.c(this.currentTabId, HotRankItem.CATE_MOVIE) && recyclerView.getItemDecorationCount() == 0) {
                    recyclerView.addItemDecoration(new tf.f(0.0f, 8.0f, 0.0f, 5, (DefaultConstructorMarker) null));
                }
            }
            com.transsion.search.fragment.result.adapter.a aVar = new com.transsion.search.fragment.result.adapter.a(this.exposureHelper, this.keyword, this.searchFrom, this.currentTabId);
            this.mainAdapter = aVar;
            recyclerView.setAdapter(aVar);
            com.transsion.search.fragment.result.adapter.a aVar2 = this.mainAdapter;
            if (aVar2 != null && (h0 = aVar2.h0()) != null) {
                h0.D(new r6.f() { // from class: com.transsion.search.fragment.result.g
                    public final void a() {
                        SearchResultTabFragment.A0(SearchResultTabFragment.this);
                    }
                });
            }
            com.transsion.search.fragment.result.adapter.a aVar3 = this.mainAdapter;
            if (aVar3 != null) {
                aVar3.w1(new r6.d() { // from class: com.transsion.search.fragment.result.h
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                        SearchResultTabFragment.B0(SearchResultTabFragment.this, baseQuickAdapter, view2, i);
                    }
                });
            }
        }
        x0();
        t0();
    }

    public void lazyLoadData() {
        Pager pager;
        t6.f h0;
        List<ResultWrapData> convertData;
        SearchResultEntity searchResultEntity = this.extraResultData;
        if (searchResultEntity == null) {
            G0(false);
            SearchResultViewModel r0 = r0();
            String str = this.keyword;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            String str2 = this.currentTabId;
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            SearchResultViewModel.p(r0, str, str2, false, 4, null);
            return;
        }
        com.transsion.search.fragment.result.adapter.a aVar = this.mainAdapter;
        if (aVar != null) {
            aVar.n1((searchResultEntity == null || (convertData = searchResultEntity.getConvertData()) == null) ? new ArrayList() : convertData);
        }
        SearchResultEntity searchResultEntity2 = this.extraResultData;
        if (searchResultEntity2 == null || (pager = searchResultEntity2.getPager()) == null || pager.getHasMore()) {
            r0().r(2);
            return;
        }
        com.transsion.search.fragment.result.adapter.a aVar2 = this.mainAdapter;
        if (aVar2 == null || (h0 = aVar2.h0()) == null) {
            return;
        }
        h0.t(true);
    }

    @Override // com.transsion.search.fragment.BaseSearchMainFragment
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
        com.transsion.search.fragment.result.adapter.a aVar;
        t6.f h0;
        super.onResume();
        if (!this.isLoadMoreEnd || (aVar = this.mainAdapter) == null || (h0 = aVar.h0()) == null) {
            return;
        }
        t6.f.u(h0, false, 1, (Object) null);
    }

    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public vp.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        vp.h c2 = vp.h.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
