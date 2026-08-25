package com.transsion.search_pugc.fragment.result;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.a0;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.model.PostEntity;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.bean.SearchTab;
import com.transsion.search_pugc.bean.UGCSearchResultData;
import com.transsion.search_pugc.fragment.BaseSearchMainFragment;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import wf.a;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0017¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u0004\u0018\u00010&2\b\u0010%\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u0004J+\u0010/\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103R\u0018\u0010,\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010-\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00105R\u0018\u0010.\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00105R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u00108\u001a\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/transsion/search_pugc/fragment/result/SearchResultFragment;", "Lcom/transsion/search_pugc/fragment/BaseSearchMainFragment;", "Lvp/g;", "<init>", "()V", BuildConfig.FLAVOR, "initViewPager", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "magicIndicator", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "l0", "(Lnet/lucode/hackware/magicindicator/MagicIndicator;Landroidx/viewpager2/widget/ViewPager2;)V", "Landroid/view/View;", "r0", "()Landroid/view/View;", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "textStr", "Lxy/d;", "getIndicatorText", "(Landroid/content/Context;ILjava/lang/String;)Lxy/d;", "Lxy/c;", "getIndicatorView", "(Landroid/content/Context;)Lxy/c;", "Landroid/view/LayoutInflater;", "inflater", "n0", "(Landroid/view/LayoutInflater;)Lvp/g;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "tabId", "Lcom/transsion/search_pugc/bean/UGCSearchResultData;", "m0", "(Ljava/lang/String;)Lcom/transsion/search_pugc/bean/UGCSearchResultData;", "startLoading", "hideLoading", "lazyLoadData", "keyword", "searchFrom", "fromUGCVideoId", "u0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "a", "Ljava/lang/String;", "Lcom/transsion/search_pugc/fragment/result/SearchResultViewModel;", "b", "Lkotlin/Lazy;", "o0", "()Lcom/transsion/search_pugc/fragment/result/SearchResultViewModel;", "viewModel", "c", "Lcom/transsion/search_pugc/bean/UGCSearchResultData;", "searchResultData", "d", "e", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "f", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "requestView", "g", "Ljava/lang/Integer;", "requestMovieCount", "Lcom/transsion/search_pugc/g;", "h", "getSearchReporter", "()Lcom/transsion/search_pugc/g;", "searchReporter", "i", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchResultFragment extends BaseSearchMainFragment<vp.g> {

    /* renamed from: a, reason: from kotlin metadata */
    private String keyword;

    /* renamed from: c, reason: from kotlin metadata */
    private UGCSearchResultData searchResultData;

    /* renamed from: d, reason: from kotlin metadata */
    private String searchFrom;

    /* renamed from: e, reason: from kotlin metadata */
    private String fromUGCVideoId;

    /* renamed from: f, reason: from kotlin metadata */
    private ResourcesRequestView requestView;

    /* renamed from: g, reason: from kotlin metadata */
    private Integer requestMovieCount;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy viewModel = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.a
        public final Object invoke() {
            SearchResultViewModel v0;
            v0 = SearchResultFragment.v0(SearchResultFragment.this);
            return v0;
        }
    });

    /* renamed from: h, reason: from kotlin metadata */
    private final Lazy searchReporter = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.b
        public final Object invoke() {
            com.transsion.search_pugc.g t0;
            t0 = SearchResultFragment.t0(SearchResultFragment.this);
            return t0;
        }
    });

    public static final class b extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ MagicIndicator a;
        final /* synthetic */ SearchResultFragment b;

        b(MagicIndicator magicIndicator, SearchResultFragment searchResultFragment) {
            this.a = magicIndicator;
            this.b = searchResultFragment;
        }

        public void onPageScrollStateChanged(int i) {
            this.a.onPageScrollStateChanged(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            this.a.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            this.a.onPageSelected(i);
            com.transsion.search_pugc.g a = com.transsion.search_pugc.g.g.a(this.b.getContext());
            String str = this.b.keyword;
            UGCSearchResultData uGCSearchResultData = this.b.searchResultData;
            SearchTab searchTab = uGCSearchResultData != null ? uGCSearchResultData.getTabs().get(i) : null;
            UGCSearchResultData uGCSearchResultData2 = this.b.searchResultData;
            a.C(str, searchTab, uGCSearchResultData2 != null ? uGCSearchResultData2.getOps() : null);
        }
    }

    public static final class c extends com.transsion.baseui.util.f {
        final /* synthetic */ int f;

        c(int i) {
            this.f = i;
        }

        @Override // com.transsion.baseui.util.f
        public void c(View view) {
        }

        @Override // com.transsion.baseui.util.f
        public void d(View view) {
            ViewPager2 viewPager2;
            vp.g gVar = (vp.g) SearchResultFragment.this.getMViewBinding();
            if (gVar == null || (viewPager2 = gVar.f) == null) {
                return;
            }
            viewPager2.setCurrentItem(this.f, false);
        }
    }

    public static final class d extends xy.a {
        d() {
        }

        public int a() {
            List<SearchTab> tabs;
            UGCSearchResultData uGCSearchResultData = SearchResultFragment.this.searchResultData;
            if (uGCSearchResultData == null || (tabs = uGCSearchResultData.getTabs()) == null) {
                return 0;
            }
            return tabs.size();
        }

        public xy.c b(Context context) {
            Intrinsics.h(context, "context");
            return SearchResultFragment.this.getIndicatorView(context);
        }

        public xy.d c(Context context, int i) {
            List<SearchTab> tabs;
            SearchTab searchTab;
            Intrinsics.h(context, "context");
            SearchResultFragment searchResultFragment = SearchResultFragment.this;
            UGCSearchResultData uGCSearchResultData = searchResultFragment.searchResultData;
            return searchResultFragment.getIndicatorText(context, i, (uGCSearchResultData == null || (tabs = uGCSearchResultData.getTabs()) == null || (searchTab = tabs.get(i)) == null) ? null : searchTab.getName());
        }
    }

    public static final class e extends FragmentStateAdapter {
        e() {
            super(SearchResultFragment.this);
        }

        public Fragment createFragment(int i) {
            List<SearchTab> tabs;
            List<SearchTab> tabs2;
            UGCSearchResultData uGCSearchResultData = SearchResultFragment.this.searchResultData;
            if (uGCSearchResultData != null && (tabs2 = uGCSearchResultData.getTabs()) != null) {
                tabs2.get(i);
            }
            UGCSearchResultData uGCSearchResultData2 = SearchResultFragment.this.searchResultData;
            return SearchResultTabFragment.INSTANCE.a(SearchResultFragment.this.keyword, null, (uGCSearchResultData2 == null || (tabs = uGCSearchResultData2.getTabs()) == null) ? null : tabs.get(i), SearchResultFragment.this.searchFrom, SearchResultFragment.this.fromUGCVideoId);
        }

        public int getItemCount() {
            List<SearchTab> tabs;
            UGCSearchResultData uGCSearchResultData = SearchResultFragment.this.searchResultData;
            if (uGCSearchResultData == null || (tabs = uGCSearchResultData.getTabs()) == null) {
                return 0;
            }
            return tabs.size();
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
    public final xy.d getIndicatorText(Context context, int index, String textStr) {
        CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context, 17, a0.a(12.0f));
        customPagerTitleView.setSelectTextSize(16.0f);
        customPagerTitleView.setText(textStr);
        customPagerTitleView.setOnClickListener(new c(index));
        return customPagerTitleView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xy.c getIndicatorView(Context context) {
        GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context);
        gradientLinePagerIndicator.setMode(1);
        gradientLinePagerIndicator.setLineHeight(a0.a(2.0f));
        gradientLinePagerIndicator.setLineWidth(a0.a(24.0f));
        gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        int color = androidx.core.content.b.getColor(context, R.color.white);
        gradientLinePagerIndicator.setColors(color, color, color);
        return gradientLinePagerIndicator;
    }

    private final com.transsion.search_pugc.g getSearchReporter() {
        return (com.transsion.search_pugc.g) this.searchReporter.getValue();
    }

    private final void initViewPager() {
        ViewPager2 viewPager2;
        MagicIndicator magicIndicator;
        vp.g gVar = (vp.g) getMViewBinding();
        if (gVar != null && (magicIndicator = gVar.c) != null) {
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            commonNavigator.setAdapter(new d());
            magicIndicator.setNavigator(commonNavigator);
        }
        vp.g gVar2 = (vp.g) getMViewBinding();
        if (gVar2 == null || (viewPager2 = gVar2.f) == null) {
            return;
        }
        viewPager2.setAdapter(new e());
    }

    private final void l0(MagicIndicator magicIndicator, ViewPager2 viewPager) {
        viewPager.registerOnPageChangeCallback(new b(magicIndicator, this));
    }

    private final SearchResultViewModel o0() {
        return (SearchResultViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(SearchResultFragment searchResultFragment, UGCSearchResultData uGCSearchResultData) {
        ViewPager2 viewPager2;
        RecyclerView.Adapter adapter;
        MagicIndicator magicIndicator;
        vy.a navigator;
        FrameLayout frameLayout;
        View view;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        searchResultFragment.hideLoading();
        if (uGCSearchResultData == null) {
            vp.g gVar = (vp.g) searchResultFragment.getMViewBinding();
            if (gVar != null && (frameLayout3 = gVar.b) != null) {
                frameLayout3.removeAllViews();
            }
            vp.g gVar2 = (vp.g) searchResultFragment.getMViewBinding();
            if (gVar2 != null && (frameLayout2 = gVar2.b) != null) {
                frameLayout2.addView(searchResultFragment.r0());
            }
            vp.g gVar3 = (vp.g) searchResultFragment.getMViewBinding();
            if (gVar3 != null && (view = gVar3.d) != null) {
                view.setVisibility(4);
            }
            vp.g gVar4 = (vp.g) searchResultFragment.getMViewBinding();
            if (gVar4 != null && (frameLayout = gVar4.b) != null) {
                frameLayout.setVisibility(0);
            }
            searchResultFragment.getSearchReporter().x("net_error", null);
        } else if (uGCSearchResultData.getTabs().isEmpty() || uGCSearchResultData.getItems().isEmpty()) {
            searchResultFragment.getSearchReporter().x("empty", null);
            searchResultFragment.o0().i().n(Boolean.TRUE);
        } else {
            searchResultFragment.searchResultData = uGCSearchResultData;
            vp.g gVar5 = (vp.g) searchResultFragment.getMViewBinding();
            if (gVar5 != null && (magicIndicator = gVar5.c) != null && (navigator = magicIndicator.getNavigator()) != null) {
                navigator.notifyDataSetChanged();
            }
            vp.g gVar6 = (vp.g) searchResultFragment.getMViewBinding();
            if (gVar6 != null && (viewPager2 = gVar6.f) != null && (adapter = viewPager2.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
            searchResultFragment.getSearchReporter().x("success", uGCSearchResultData.getOps());
            qi.b logViewConfig = searchResultFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.g().put("ops", uGCSearchResultData.getOps());
            }
        }
        qi.b logViewConfig2 = searchResultFragment.getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.k(uGCSearchResultData != null);
        }
        searchResultFragment.getSearchReporter().i(searchResultFragment.getLogViewConfig());
        searchResultFragment.getSearchReporter().D(searchResultFragment.getLogViewConfig());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(SearchResultFragment searchResultFragment, PostEntity postEntity) {
        a.a.g(wf.a.a, "Post request succeed " + postEntity + ", " + (postEntity != null ? postEntity.getCount() : null), false, 2, (Object) null);
        if (postEntity != null && searchResultFragment.requestMovieCount == null) {
            int count = postEntity.getCount();
            if (count == null) {
                count = 0;
            }
            searchResultFragment.requestMovieCount = count;
            ResourcesRequestView resourcesRequestView = searchResultFragment.requestView;
            if (resourcesRequestView != null) {
                Integer count2 = postEntity.getCount();
                resourcesRequestView.setCount(count2 != null ? count2.intValue() : 0, false);
            }
        }
        return Unit.a;
    }

    private final View r0() {
        LayoutInflater layoutInflater = getLayoutInflater();
        int i = R$layout.view_search_no_network;
        vp.g gVar = (vp.g) getMViewBinding();
        View inflate = layoutInflater.inflate(i, (ViewGroup) (gVar != null ? gVar.b : null), false);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_empty_tips);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_tips);
        AppCompatTextView findViewById = inflate.findViewById(R$id.tv_retry);
        textView.setText(com.transsion.baseui.R.string.base_net_err);
        imageView.setImageResource(R.mipmap.ic_no_network);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.fragment.result.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchResultFragment.s0(SearchResultFragment.this, view);
            }
        });
        Intrinsics.e(inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(SearchResultFragment searchResultFragment, View view) {
        String str = searchResultFragment.keyword;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        searchResultFragment.u0(str, searchResultFragment.searchFrom, searchResultFragment.fromUGCVideoId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.search_pugc.g t0(SearchResultFragment searchResultFragment) {
        return com.transsion.search_pugc.g.g.a(searchResultFragment.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchResultViewModel v0(SearchResultFragment searchResultFragment) {
        FragmentActivity requireActivity = searchResultFragment.requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        return new v0(requireActivity).a(SearchResultViewModel.class);
    }

    public void hideLoading() {
        View view;
        MagicIndicator magicIndicator;
        ViewPager2 viewPager2;
        ProgressBar progressBar;
        vp.g gVar = (vp.g) getMViewBinding();
        if (gVar != null && (progressBar = gVar.e) != null) {
            progressBar.setVisibility(4);
        }
        vp.g gVar2 = (vp.g) getMViewBinding();
        if (gVar2 != null && (viewPager2 = gVar2.f) != null) {
            viewPager2.setVisibility(0);
        }
        vp.g gVar3 = (vp.g) getMViewBinding();
        if (gVar3 != null && (magicIndicator = gVar3.c) != null) {
            magicIndicator.setVisibility(0);
        }
        vp.g gVar4 = (vp.g) getMViewBinding();
        if (gVar4 == null || (view = gVar4.d) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        initViewPager();
        o0().l().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.search_pugc.fragment.result.c
            public final Object invoke(Object obj) {
                Unit p0;
                p0 = SearchResultFragment.p0(SearchResultFragment.this, (UGCSearchResultData) obj);
                return p0;
            }
        }));
        o0().h().j(this, new f(new Function1() { // from class: com.transsion.search_pugc.fragment.result.d
            public final Object invoke(Object obj) {
                Unit q0;
                q0 = SearchResultFragment.q0(SearchResultFragment.this, (PostEntity) obj);
                return q0;
            }
        }));
        vp.g gVar = (vp.g) getMViewBinding();
        if (gVar != null) {
            MagicIndicator magicIndicator = gVar.c;
            Intrinsics.g(magicIndicator, "searchResultMagicIndicator");
            ViewPager2 viewPager2 = gVar.f;
            Intrinsics.g(viewPager2, "searchResultViewPager");
            l0(magicIndicator, viewPager2);
        }
        getSearchReporter().j(getLogViewConfig());
    }

    public void lazyLoadData() {
    }

    public final UGCSearchResultData m0(String tabId) {
        UGCSearchResultData uGCSearchResultData = this.searchResultData;
        if (Intrinsics.c(tabId, uGCSearchResultData != null ? uGCSearchResultData.getTabId() : null)) {
            return this.searchResultData;
        }
        return null;
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public vp.g getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        vp.g c2 = vp.g.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public qi.b newLogViewConfig() {
        return getSearchReporter().g("/ugc_search/search_result");
    }

    public void startLoading() {
        FrameLayout frameLayout;
        View view;
        MagicIndicator magicIndicator;
        ViewPager2 viewPager2;
        ProgressBar progressBar;
        vp.g gVar = (vp.g) getMViewBinding();
        if (gVar != null && (progressBar = gVar.e) != null) {
            progressBar.setVisibility(0);
        }
        vp.g gVar2 = (vp.g) getMViewBinding();
        if (gVar2 != null && (viewPager2 = gVar2.f) != null) {
            viewPager2.setVisibility(4);
        }
        vp.g gVar3 = (vp.g) getMViewBinding();
        if (gVar3 != null && (magicIndicator = gVar3.c) != null) {
            magicIndicator.setVisibility(4);
        }
        vp.g gVar4 = (vp.g) getMViewBinding();
        if (gVar4 != null && (view = gVar4.d) != null) {
            view.setVisibility(4);
        }
        vp.g gVar5 = (vp.g) getMViewBinding();
        if (gVar5 == null || (frameLayout = gVar5.b) == null) {
            return;
        }
        frameLayout.setVisibility(4);
    }

    public final void u0(String keyword, String searchFrom, String fromUGCVideoId) {
        Intrinsics.h(keyword, "keyword");
        this.keyword = keyword;
        this.searchFrom = searchFrom;
        this.fromUGCVideoId = fromUGCVideoId;
        startLoading();
        this.searchResultData = null;
        initViewPager();
        o0().p(fromUGCVideoId);
        o0().q(1);
        SearchResultViewModel.n(o0(), keyword, BuildConfig.FLAVOR, getSearchReporter().f(), false, null, 24, null);
    }
}
