package com.transsion.search.fragment.result;

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
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.SearchList;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.bean.TabItem;
import com.transsion.search.fragment.BaseSearchMainFragment;
import com.transsion.search.widget.d;
import java.util.HashMap;
import java.util.Iterator;
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

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J!\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010&H\u0017¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0005H\u0016¢\u0006\u0004\b,\u0010\u0004J\u001f\u0010/\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00192\b\u0010.\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0019¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106R\u0018\u0010-\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010.\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u00108¨\u0006L"}, d2 = {"Lcom/transsion/search/fragment/result/SearchResultFragment;", "Lcom/transsion/search/fragment/BaseSearchMainFragment;", "Lvp/g;", "<init>", "()V", BuildConfig.FLAVOR, "initViewPager", "Lcom/transsion/search/bean/TabItem;", "tabItem", "Landroidx/fragment/app/Fragment;", "l0", "(Lcom/transsion/search/bean/TabItem;)Landroidx/fragment/app/Fragment;", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "magicIndicator", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "k0", "(Lnet/lucode/hackware/magicindicator/MagicIndicator;Landroidx/viewpager2/widget/ViewPager2;)V", "Landroid/view/View;", "r0", "()Landroid/view/View;", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "textStr", "Lxy/d;", "getIndicatorText", "(Landroid/content/Context;ILjava/lang/String;)Lxy/d;", "Lxy/c;", "getIndicatorView", "(Landroid/content/Context;)Lxy/c;", "Landroid/view/LayoutInflater;", "inflater", "m0", "(Landroid/view/LayoutInflater;)Lvp/g;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "startLoading", "hideLoading", "lazyLoadData", "keyword", "searchFrom", "u0", "(Ljava/lang/String;Ljava/lang/String;)V", "id", "q0", "(Ljava/lang/String;)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "a", "Ljava/lang/String;", "Lcom/transsion/search/fragment/result/SearchResultViewModel;", "b", "Lkotlin/Lazy;", "n0", "()Lcom/transsion/search/fragment/result/SearchResultViewModel;", "viewModel", "Lcom/transsion/search/bean/SearchResultEntity;", "c", "Lcom/transsion/search/bean/SearchResultEntity;", "searchResultData", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "d", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "requestView", "e", "Ljava/lang/Integer;", "requestMovieCount", "f", "g", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchResultFragment extends BaseSearchMainFragment<vp.g> {

    /* renamed from: a, reason: from kotlin metadata */
    private String keyword;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy viewModel = LazyKt.b(new Function0() { // from class: com.transsion.search.fragment.result.a
        public final Object invoke() {
            SearchResultViewModel v0;
            v0 = SearchResultFragment.v0(SearchResultFragment.this);
            return v0;
        }
    });

    /* renamed from: c, reason: from kotlin metadata */
    private SearchResultEntity searchResultData;

    /* renamed from: d, reason: from kotlin metadata */
    private ResourcesRequestView requestView;

    /* renamed from: e, reason: from kotlin metadata */
    private Integer requestMovieCount;

    /* renamed from: f, reason: from kotlin metadata */
    private String searchFrom;

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
            List<TabItem> tabs;
            TabItem tabItem;
            this.a.onPageSelected(i);
            d.a aVar = com.transsion.search.widget.d.a;
            String str = this.b.keyword;
            SearchResultEntity searchResultEntity = this.b.searchResultData;
            aVar.x(str, (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null || (tabItem = tabs.get(i)) == null) ? null : tabItem.getTabId());
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
            List<TabItem> tabs;
            SearchResultEntity searchResultEntity = SearchResultFragment.this.searchResultData;
            if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) {
                return 0;
            }
            return tabs.size();
        }

        public xy.c b(Context context) {
            Intrinsics.h(context, "context");
            return SearchResultFragment.this.getIndicatorView(context);
        }

        public xy.d c(Context context, int i) {
            List<TabItem> tabs;
            TabItem tabItem;
            Intrinsics.h(context, "context");
            SearchResultFragment searchResultFragment = SearchResultFragment.this;
            SearchResultEntity searchResultEntity = searchResultFragment.searchResultData;
            return searchResultFragment.getIndicatorText(context, i, (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null || (tabItem = tabs.get(i)) == null) ? null : tabItem.getName());
        }
    }

    public static final class e extends FragmentStateAdapter {
        e() {
            super(SearchResultFragment.this);
        }

        public Fragment createFragment(int i) {
            List<TabItem> tabs;
            SearchResultFragment searchResultFragment = SearchResultFragment.this;
            SearchResultEntity searchResultEntity = searchResultFragment.searchResultData;
            return searchResultFragment.l0((searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) ? null : tabs.get(i));
        }

        public int getItemCount() {
            List<TabItem> tabs;
            SearchResultEntity searchResultEntity = SearchResultFragment.this.searchResultData;
            if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) {
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

    private final void k0(MagicIndicator magicIndicator, ViewPager2 viewPager) {
        viewPager.registerOnPageChangeCallback(new b(magicIndicator, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment l0(TabItem tabItem) {
        String tabId = tabItem != null ? tabItem.getTabId() : null;
        SearchResultEntity searchResultEntity = this.searchResultData;
        return SearchResultTabFragment.INSTANCE.a(this.keyword, tabItem, Intrinsics.c(tabId, searchResultEntity != null ? searchResultEntity.getTabId() : null) ? this.searchResultData : null, this.searchFrom);
    }

    private final SearchResultViewModel n0() {
        return (SearchResultViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(SearchResultFragment searchResultFragment, SearchResultEntity searchResultEntity) {
        List<SearchList> results;
        FrameLayout frameLayout;
        View view;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        List<TabItem> tabs;
        List<SearchList> results2;
        ViewPager2 viewPager2;
        RecyclerView.Adapter adapter;
        MagicIndicator magicIndicator;
        vy.a navigator;
        searchResultFragment.hideLoading();
        if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null || tabs.isEmpty() || (results2 = searchResultEntity.getResults()) == null || results2.isEmpty()) {
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
            if ((searchResultEntity != null ? searchResultEntity.getPager() : null) != null && ((results = searchResultEntity.getResults()) == null || results.isEmpty())) {
                com.transsion.search.widget.d.a.i(searchResultFragment.keyword, searchResultFragment.searchFrom);
            }
        } else {
            searchResultFragment.searchResultData = searchResultEntity;
            vp.g gVar5 = (vp.g) searchResultFragment.getMViewBinding();
            if (gVar5 != null && (magicIndicator = gVar5.c) != null && (navigator = magicIndicator.getNavigator()) != null) {
                navigator.notifyDataSetChanged();
            }
            vp.g gVar6 = (vp.g) searchResultFragment.getMViewBinding();
            if (gVar6 != null && (viewPager2 = gVar6.f) != null && (adapter = viewPager2.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(SearchResultFragment searchResultFragment, PostEntity postEntity) {
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
        AppCompatTextView appCompatTextView;
        if (!yg.l.a.e()) {
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
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchResultFragment.t0(SearchResultFragment.this, view);
                }
            });
            Intrinsics.e(inflate);
            return inflate;
        }
        LayoutInflater layoutInflater2 = getLayoutInflater();
        int i2 = R$layout.view_search_empty;
        vp.g gVar2 = (vp.g) getMViewBinding();
        View inflate2 = layoutInflater2.inflate(i2, (ViewGroup) (gVar2 != null ? gVar2.b : null), false);
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
        n0().m(str, true);
        this.requestMovieCount = null;
        jj.g mViewBinding = resourcesRequestView.getMViewBinding();
        if (mViewBinding != null && (appCompatTextView = mViewBinding.e) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchResultFragment.s0(SearchResultFragment.this, str, resourcesRequestView, view);
                }
            });
        }
        Intrinsics.e(inflate2);
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(SearchResultFragment searchResultFragment, String str, ResourcesRequestView resourcesRequestView, View view) {
        vo.e.a.e(searchResultFragment, NoticePermissionFrom.DETAIL_NO_RES);
        SearchResultViewModel.n(searchResultFragment.n0(), str, false, 2, null);
        Integer num = searchResultFragment.requestMovieCount;
        if (num != null) {
            Intrinsics.e(num);
            Integer valueOf = Integer.valueOf(num.intValue() + 1);
            searchResultFragment.requestMovieCount = valueOf;
            Intrinsics.e(valueOf);
            ResourcesRequestView.setCount$default(resourcesRequestView, valueOf.intValue(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(SearchResultFragment searchResultFragment, View view) {
        String str = searchResultFragment.keyword;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        searchResultFragment.u0(str, searchResultFragment.searchFrom);
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
        n0().k().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.search.fragment.result.b
            public final Object invoke(Object obj) {
                Unit o0;
                o0 = SearchResultFragment.o0(SearchResultFragment.this, (SearchResultEntity) obj);
                return o0;
            }
        }));
        n0().i().j(this, new f(new Function1() { // from class: com.transsion.search.fragment.result.c
            public final Object invoke(Object obj) {
                Unit p0;
                p0 = SearchResultFragment.p0(SearchResultFragment.this, (PostEntity) obj);
                return p0;
            }
        }));
        vp.g gVar = (vp.g) getMViewBinding();
        if (gVar != null) {
            MagicIndicator magicIndicator = gVar.c;
            Intrinsics.g(magicIndicator, "searchResultMagicIndicator");
            ViewPager2 viewPager2 = gVar.f;
            Intrinsics.g(viewPager2, "searchResultViewPager");
            k0(magicIndicator, viewPager2);
        }
    }

    public void lazyLoadData() {
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public vp.g getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        vp.g c2 = vp.g.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public qi.b newLogViewConfig() {
        qi.b bVar = new qi.b("searchresult", false, 2, null);
        bVar.l(true);
        bVar.g().put("search_id", BaseSearchMainFragment.INSTANCE.a());
        return bVar;
    }

    public final void q0(String id) {
        Integer num;
        ViewPager2 viewPager2;
        List<TabItem> tabs;
        Intrinsics.h(id, "id");
        SearchResultEntity searchResultEntity = this.searchResultData;
        if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) {
            num = null;
        } else {
            Iterator<TabItem> it = tabs.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.c(it.next().getTabId(), id)) {
                    break;
                } else {
                    i++;
                }
            }
            num = Integer.valueOf(i);
        }
        vp.g gVar = (vp.g) getMViewBinding();
        if (gVar == null || (viewPager2 = gVar.f) == null) {
            return;
        }
        viewPager2.setCurrentItem(num != null ? num.intValue() : 0, false);
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

    public final void u0(String keyword, String searchFrom) {
        HashMap g;
        Intrinsics.h(keyword, "keyword");
        this.keyword = keyword;
        startLoading();
        this.searchResultData = null;
        initViewPager();
        this.searchFrom = searchFrom;
        n0().r(1);
        SearchResultViewModel.p(n0(), keyword, null, false, 6, null);
        com.transsion.search.widget.d.a.q(keyword, searchFrom);
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
    }
}
