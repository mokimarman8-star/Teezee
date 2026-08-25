package com.transsion.home.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.bean.HotSearchKeyWord;
import com.transsion.home.bean.HotSubjectEntity;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.home.view.CustomTabAdView;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.usercenterapi.UpdateResultEvent;
import com.transsion.version.update.UpdateManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HomeSearchViewManager {
    private final qk.p a;
    private final HomeFragment b;
    private t c;
    private Context d;
    private final ArrayList e;
    private int f;
    private String g;
    private CommonNavigator h;
    private a i;
    private boolean j;
    private ConstraintLayout.b k;
    private n0 l;
    private final Handler m;

    private final class a extends xy.a {
        private AppTab b;

        /* renamed from: com.transsion.home.fragment.home.HomeSearchViewManager$a$a, reason: collision with other inner class name */
        public static final class C0033a extends com.transsion.baseui.util.f {
            final /* synthetic */ HomeSearchViewManager e;
            final /* synthetic */ int f;

            C0033a(HomeSearchViewManager homeSearchViewManager, int i) {
                this.e = homeSearchViewManager;
                this.f = i;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                this.e.a.s.setCurrentItem(this.f, false);
                this.e.a.k.onPageScrolled(this.f, 0.0f, 0);
            }
        }

        public static final class b extends com.transsion.baseui.util.f {
            final /* synthetic */ HomeSearchViewManager e;
            final /* synthetic */ int f;

            b(HomeSearchViewManager homeSearchViewManager, int i) {
                this.e = homeSearchViewManager;
                this.f = i;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                this.e.a.s.setCurrentItem(this.f, false);
                this.e.a.k.onPageScrolled(this.f, 0.0f, 0);
            }
        }

        public a(AppTab appTab) {
            this.b = appTab;
        }

        public int a() {
            List<HomeTabItem> homeTabs;
            AppTab appTab = this.b;
            if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
                return 1;
            }
            return homeTabs.size();
        }

        public xy.c b(Context context) {
            Intrinsics.h(context, "context");
            Context context2 = HomeSearchViewManager.this.d;
            if (context2 == null) {
                Intrinsics.y("context");
                context2 = null;
            }
            GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context2);
            gradientLinePagerIndicator.setMode(2);
            gradientLinePagerIndicator.setLineHeight(com.blankj.utilcode.util.i.e(3.0f));
            gradientLinePagerIndicator.setLineWidth(com.blankj.utilcode.util.i.e(24.0f));
            gradientLinePagerIndicator.setRoundRadius(com.blankj.utilcode.util.i.e(1.5f));
            gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            int color = androidx.core.content.b.getColor(context, R.color.transparent);
            gradientLinePagerIndicator.setColors(color, color, color);
            return gradientLinePagerIndicator;
        }

        public xy.d c(Context context, int i) {
            List<HomeTabItem> homeTabs;
            HomeTabItem homeTabItem;
            List<HomeTabItem> homeTabs2;
            List<HomeTabItem> homeTabs3;
            HomeTabItem homeTabItem2;
            AppTab appTab = this.b;
            HomeTabItem homeTabItem3 = null;
            if (((appTab == null || (homeTabs3 = appTab.getHomeTabs()) == null || (homeTabItem2 = homeTabs3.get(i)) == null) ? null : homeTabItem2.getNameImage()) != null) {
                Context context2 = HomeSearchViewManager.this.d;
                if (context2 == null) {
                    Intrinsics.y("context");
                    context2 = null;
                }
                CustomTabAdView customTabAdView = new CustomTabAdView(context2);
                customTabAdView.setOnClickListener(new C0033a(HomeSearchViewManager.this, i));
                AppTab appTab2 = this.b;
                if (appTab2 != null && (homeTabs2 = appTab2.getHomeTabs()) != null) {
                    homeTabItem3 = homeTabs2.get(i);
                }
                customTabAdView.showData(homeTabItem3);
                return customTabAdView;
            }
            int a = com.blankj.utilcode.util.a0.a(10.0f);
            Context context3 = HomeSearchViewManager.this.d;
            if (context3 == null) {
                Intrinsics.y("context");
                context3 = null;
            }
            CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context3, 17, a);
            HomeSearchViewManager homeSearchViewManager = HomeSearchViewManager.this;
            AppTab appTab3 = this.b;
            if (appTab3 != null && (homeTabs = appTab3.getHomeTabs()) != null && (homeTabItem = homeTabs.get(i)) != null) {
                homeTabItem3 = homeTabItem.getName();
            }
            customPagerTitleView.setText(homeTabItem3);
            customPagerTitleView.setTextSize(16.0f);
            customPagerTitleView.setOnClickListener(new b(homeSearchViewManager, i));
            return customPagerTitleView;
        }

        public final void h(AppTab appTab) {
            this.b = appTab;
            e();
        }
    }

    static final class b implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
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

    public HomeSearchViewManager(qk.p pVar, HomeFragment homeFragment) {
        Intrinsics.h(pVar, "mViewBinding");
        Intrinsics.h(homeFragment, "mFragment");
        this.a = pVar;
        this.b = homeFragment;
        this.e = new ArrayList();
        this.l = o0.a(y0.b());
        this.m = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.transsion.home.fragment.home.w
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean H;
                H = HomeSearchViewManager.H(HomeSearchViewManager.this, message);
                return H;
            }
        });
    }

    private final void A(List list) {
        this.a.p.setTextWithString(BuildConfig.FLAVOR);
        this.e.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HotSearchKeyWord hotSearchKeyWord = (HotSearchKeyWord) it.next();
            ArrayList arrayList = this.e;
            String title = hotSearchKeyWord.getTitle();
            if (title == null) {
                title = BuildConfig.FLAVOR;
            }
            arrayList.add(title);
        }
        TextSwitcher textSwitcher = this.a.m;
        if (textSwitcher.getChildCount() == 0) {
            textSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.transsion.home.fragment.home.d0
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    View B;
                    B = HomeSearchViewManager.B(HomeSearchViewManager.this);
                    return B;
                }
            });
        }
        int i = this.f;
        if (i >= 0 && i < this.e.size()) {
            String str = (String) this.e.get(this.f);
            this.g = str;
            textSwitcher.setText(str);
        }
        textSwitcher.setInAnimation(q());
        textSwitcher.setOutAnimation(J());
        N(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View B(HomeSearchViewManager homeSearchViewManager) {
        return LayoutInflater.from(homeSearchViewManager.b.requireContext()).inflate(com.transsion.home.R.layout.view_text, (ViewGroup) null);
    }

    private final void E(boolean z) {
        com.transsion.home.view.g.a.b(false);
        gj.b bVar = (gj.b) gj.a.a.a(gj.b.class);
        String str = BuildConfig.FLAVOR;
        if (z) {
            if (bVar != null) {
                String str2 = this.g;
                String str3 = str2 == null ? BuildConfig.FLAVOR : str2;
                if (str2 != null) {
                    str = str2;
                }
                ArrayList arrayList = this.e;
                Context requireContext = this.b.requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                bVar.a(str3, str, arrayList, requireContext);
            }
        } else if (bVar != null) {
            String str4 = this.g;
            if (str4 != null) {
                str = str4;
            }
            ArrayList arrayList2 = this.e;
            Context requireContext2 = this.b.requireContext();
            Intrinsics.g(requireContext2, "requireContext(...)");
            bVar.b(str, arrayList2, requireContext2);
        }
        K(z);
    }

    static /* synthetic */ void F(HomeSearchViewManager homeSearchViewManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        homeSearchViewManager.E(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H(HomeSearchViewManager homeSearchViewManager, Message message) {
        String str;
        Intrinsics.h(message, "it");
        if (message.what == 100) {
            homeSearchViewManager.f++;
            if (homeSearchViewManager.e.isEmpty()) {
                str = BuildConfig.FLAVOR;
            } else {
                ArrayList arrayList = homeSearchViewManager.e;
                str = (String) arrayList.get(homeSearchViewManager.f % arrayList.size());
            }
            homeSearchViewManager.g = str;
            homeSearchViewManager.a.m.setText(str);
            N(homeSearchViewManager, false, 1, null);
        }
        return true;
    }

    private final AnimationSet J() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(1000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private final void K(boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", z ? "search_button" : "search");
        String str = this.g;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("hot_search_word", str);
        com.transsion.baselib.helper.a.a.i(SubTabFragment.INSTANCE.a(HomeTabId.INSTANCE.g()), linkedHashMap);
    }

    public static /* synthetic */ void N(HomeSearchViewManager homeSearchViewManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        homeSearchViewManager.M(z);
    }

    private final void m(boolean z) {
        LinearLayout linearLayout;
        CommonNavigator commonNavigator = this.h;
        if (commonNavigator != null) {
            int color = androidx.core.content.b.getColor(commonNavigator.getContext(), R.color.common_white);
            int color2 = androidx.core.content.b.getColor(commonNavigator.getContext(), R.color.transparent);
            LinearLayout linearLayout2 = (LinearLayout) commonNavigator.findViewById(net.lucode.hackware.magicindicator.R.id.title_container);
            int childCount = linearLayout2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                CustomPagerTitleView childAt = linearLayout2.getChildAt(i);
                if (childAt instanceof CustomPagerTitleView) {
                    CustomPagerTitleView customPagerTitleView = childAt;
                    customPagerTitleView.setNormalColor(androidx.core.content.b.getColor(linearLayout2.getContext(), R.color.white_60));
                    customPagerTitleView.setSelectedColor(color);
                    if (i == this.b.getMSelectTabIndex()) {
                        customPagerTitleView.setTextColor(color);
                    } else {
                        customPagerTitleView.setTextColor(androidx.core.content.b.getColor(linearLayout2.getContext(), R.color.white_60));
                    }
                    ViewGroup.LayoutParams layoutParams = customPagerTitleView.getLayoutParams();
                    Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.width = -2;
                    layoutParams2.height = -1;
                    customPagerTitleView.setLayoutParams(layoutParams2);
                } else if (childAt instanceof CustomTabAdView) {
                    CustomTabAdView customTabAdView = (CustomTabAdView) childAt;
                    customTabAdView.changeTextColor(androidx.core.content.b.getColor(linearLayout2.getContext(), R.color.white_60), androidx.core.content.b.getColor(linearLayout2.getContext(), R.color.common_white));
                    if (i == this.b.getMSelectTabIndex()) {
                        customTabAdView.setTextColor(color);
                    } else {
                        customTabAdView.setTextColor(androidx.core.content.b.getColor(linearLayout2.getContext(), R.color.white_60));
                    }
                }
            }
            CommonNavigator commonNavigator2 = this.h;
            if (commonNavigator2 == null || (linearLayout = (LinearLayout) commonNavigator2.findViewById(net.lucode.hackware.magicindicator.R.id.indicator_container)) == null) {
                return;
            }
            int childCount2 = linearLayout.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                GradientLinePagerIndicator childAt2 = linearLayout.getChildAt(i2);
                if (childAt2 instanceof GradientLinePagerIndicator) {
                    childAt2.setColors(color2, color2, color2);
                }
            }
        }
    }

    private final void o() {
        if (!UpdateManager.f.a().g()) {
            this.a.i.setVisibility(8);
        } else {
            this.a.i.setVisibility(0);
            this.a.i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeSearchViewManager.p(HomeSearchViewManager.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(HomeSearchViewManager homeSearchViewManager, View view) {
        kotlinx.coroutines.i.d(homeSearchViewManager.l, (CoroutineContext) null, (CoroutineStart) null, new HomeSearchViewManager$handleUpdateIcon$1$1(homeSearchViewManager, null), 3, (Object) null);
    }

    private final AnimationSet q() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(1000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private final void r() {
        Intent intent;
        this.a.p.setLocalChangeListener(new Function0() { // from class: com.transsion.home.fragment.home.e0
            public final Object invoke() {
                Unit s;
                s = HomeSearchViewManager.s();
                return s;
            }
        });
        FragmentActivity activity = this.b.getActivity();
        boolean z = false;
        if (activity != null && (intent = activity.getIntent()) != null) {
            z = intent.getBooleanExtra("extra_language_activity_restart", false);
        }
        if (z) {
            PreloadTrendingData.n.a().z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s() {
        PreloadTrendingData.n.a().z();
        return Unit.a;
    }

    private final void t() {
        this.a.r.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeSearchViewManager.u(HomeSearchViewManager.this, view);
            }
        });
        this.a.q.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeSearchViewManager.v(HomeSearchViewManager.this, view);
            }
        });
        this.a.g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeSearchViewManager.w(view);
            }
        });
        r();
        PreloadTrendingData.n.a().H().j(this.b, new b(new Function1() { // from class: com.transsion.home.fragment.home.a0
            public final Object invoke(Object obj) {
                Unit x;
                x = HomeSearchViewManager.x(HomeSearchViewManager.this, (HotSubjectEntity) obj);
                return x;
            }
        }));
        HomeFragment homeFragment = this.b;
        Function1 function1 = new Function1() { // from class: com.transsion.home.fragment.home.b0
            public final Object invoke(Object obj) {
                Unit y;
                y = HomeSearchViewManager.y(HomeSearchViewManager.this, (UpdateResultEvent) obj);
                return y;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = UpdateResultEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(homeFragment, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(HomeSearchViewManager homeSearchViewManager, View view) {
        F(homeSearchViewManager, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(HomeSearchViewManager homeSearchViewManager, View view) {
        homeSearchViewManager.E(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(HomeSearchViewManager homeSearchViewManager, HotSubjectEntity hotSubjectEntity) {
        List everyoneSearch;
        if (hotSubjectEntity != null && (everyoneSearch = hotSubjectEntity.getEveryoneSearch()) != null) {
            homeSearchViewManager.A(everyoneSearch);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(HomeSearchViewManager homeSearchViewManager, UpdateResultEvent updateResultEvent) {
        Intrinsics.h(updateResultEvent, "it");
        homeSearchViewManager.o();
        return Unit.a;
    }

    private final void z(AppTab appTab) {
        Context context = this.d;
        if (context == null) {
            Intrinsics.y("context");
            context = null;
        }
        this.h = new CommonNavigator(context);
        a aVar = new a(appTab);
        this.i = aVar;
        CommonNavigator commonNavigator = this.h;
        if (commonNavigator != null) {
            commonNavigator.setAdapter(aVar);
        }
        this.a.k.setNavigator(this.h);
    }

    public final void C(AppTab appTab) {
        Object obj;
        this.d = this.b.requireContext();
        ConstraintLayout.b layoutParams = this.a.r.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).topMargin = com.blankj.utilcode.util.a0.a(4.0f) + com.blankj.utilcode.util.d.c();
        this.a.r.setLayoutParams(bVar);
        this.k = bVar;
        o();
        z(appTab);
        t();
        try {
            Result.Companion companion = Result.Companion;
            t tVar = new t();
            this.c = tVar;
            FrameLayout frameLayout = this.a.c;
            Intrinsics.g(frameLayout, "flGameCenter");
            FrameLayout frameLayout2 = this.a.d;
            Intrinsics.g(frameLayout2, "flPhoneCenter");
            AppCompatImageView appCompatImageView = this.a.g;
            Intrinsics.g(appCompatImageView, "ivMbLogo");
            tVar.b(frameLayout, frameLayout2, appCompatImageView, androidx.lifecycle.v.a(this.b));
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            a.a.l(wf.a.a, "zxb_icon", "HomeSearchViewManager --> initGameCenter() --> it --> " + th3, false, 4, (Object) null);
        }
        AppCompatImageView appCompatImageView2 = this.a.h;
        Intrinsics.g(appCompatImageView2, "ivNovelEnter");
        new v(appCompatImageView2);
    }

    public final boolean D() {
        return this.j;
    }

    public final void G() {
        t tVar = this.c;
        if (tVar != null) {
            tVar.c();
        }
    }

    public final void I(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        if (this.e.isEmpty()) {
            PreloadTrendingData.n.a().G();
        }
    }

    public final void L() {
        this.m.removeCallbacksAndMessages(null);
    }

    public final void M(boolean z) {
        if (this.e.size() <= 0) {
            return;
        }
        if (this.f >= this.e.size()) {
            this.f %= this.e.size();
        }
        if (z) {
            L();
            this.m.sendEmptyMessageDelayed(100, 500L);
        } else {
            L();
            this.m.sendEmptyMessageDelayed(100, 5000L);
        }
    }

    public final void O(AppTab appTab) {
        Intrinsics.h(appTab, "appTab");
        a aVar = this.i;
        if (aVar != null) {
            aVar.h(appTab);
        }
        if (this.j) {
            m(true);
        }
    }

    public final void l(boolean z) {
        this.j = z;
        m(z);
    }

    public final void n() {
        t tVar = this.c;
        if (tVar != null) {
            tVar.a();
        }
    }
}
