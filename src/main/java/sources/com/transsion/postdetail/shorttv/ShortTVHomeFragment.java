package com.transsion.postdetail.shorttv;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$color;
import com.transsion.postdetail.shorttv.widget.ShortTVTabTitleView;
import com.transsion.postdetail.ui.fragment.ShortTvVideoFragment;
import com.transsion.postdetail.ui.fragment.VideoFragment;
import com.transsion.push.bean.MsgStyle;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import ij.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import wf.a;
import wn.q;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0004J!\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010\u0004J\u0015\u0010#\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b#\u0010\u0013J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001eH\u0016¢\u0006\u0004\b%\u0010&R\u001c\u0010+\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010:R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lcom/transsion/postdetail/shorttv/ShortTVHomeFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lwn/q;", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "p0", "()Landroidx/fragment/app/Fragment;", BuildConfig.FLAVOR, "initViewPager", "k0", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "isBanner", "o0", "(IZ)V", "isWhiteFont", "n0", "(Z)V", "isWhiteBg", "l0", "s0", "()Z", "Landroid/view/LayoutInflater;", "inflater", "q0", "(Landroid/view/LayoutInflater;)Lwn/q;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "m0", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "a", "Ljava/lang/String;", "TAG", BuildConfig.FLAVOR, "b", "[Ljava/lang/Integer;", "tabs", BuildConfig.FLAVOR, "Lcom/transsion/postdetail/shorttv/widget/ShortTVTabTitleView;", "c", "Ljava/util/Map;", "tabTitleViewMap", "Lnet/lucode/hackware/magicindicator/buildins/commonnavigator/CommonNavigator;", "d", "Lnet/lucode/hackware/magicindicator/buildins/commonnavigator/CommonNavigator;", "commonNavigator", "e", "I", "defaultTabIndex", "f", "selectTabIndex", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "g", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "vpAdapter", "h", "Ljava/lang/Integer;", "selectedColor", "i", "normalColor", "j", "Z", "k", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVHomeFragment extends BaseFragment<q> {

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG = ShortTVHomeFragment.class.getSimpleName();

    /* renamed from: b, reason: from kotlin metadata */
    private final Integer[] tabs = {Integer.valueOf(R.string.discover), Integer.valueOf(R.string.title_for_you)};

    /* renamed from: c, reason: from kotlin metadata */
    private final Map tabTitleViewMap = new LinkedHashMap();

    /* renamed from: d, reason: from kotlin metadata */
    private CommonNavigator commonNavigator;

    /* renamed from: e, reason: from kotlin metadata */
    private int defaultTabIndex;

    /* renamed from: f, reason: from kotlin metadata */
    private int selectTabIndex;

    /* renamed from: g, reason: from kotlin metadata */
    private FragmentStateAdapter vpAdapter;

    /* renamed from: h, reason: from kotlin metadata */
    private Integer selectedColor;

    /* renamed from: i, reason: from kotlin metadata */
    private Integer normalColor;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean isBanner;

    public static final class b extends xy.a {

        public static final class a extends com.transsion.baseui.util.f {
            final /* synthetic */ ShortTVHomeFragment e;
            final /* synthetic */ int f;

            a(ShortTVHomeFragment shortTVHomeFragment, int i) {
                this.e = shortTVHomeFragment;
                this.f = i;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                ViewPager2 viewPager2;
                q qVar = (q) this.e.getMViewBinding();
                if (qVar != null && (viewPager2 = qVar.c) != null) {
                    viewPager2.setCurrentItem(this.f, false);
                }
                if (this.f == 0) {
                    this.e.selectTabIndex = 0;
                }
            }
        }

        b() {
        }

        public int a() {
            return ShortTVHomeFragment.this.tabs.length;
        }

        public xy.c b(Context context) {
            Intrinsics.h(context, "context");
            Context requireContext = ShortTVHomeFragment.this.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(requireContext);
            ShortTVHomeFragment shortTVHomeFragment = ShortTVHomeFragment.this;
            gradientLinePagerIndicator.setMode(2);
            gradientLinePagerIndicator.setLineHeight(com.blankj.utilcode.util.i.e(3.0f));
            gradientLinePagerIndicator.setLineWidth(com.blankj.utilcode.util.i.e(24.0f));
            gradientLinePagerIndicator.setRoundRadius(com.blankj.utilcode.util.i.e(1.5f));
            gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            gradientLinePagerIndicator.setColors(androidx.core.content.b.getColor(shortTVHomeFragment.requireContext(), com.tn.lib.widget.R.color.brand_gradient_start), androidx.core.content.b.getColor(shortTVHomeFragment.requireContext(), com.tn.lib.widget.R.color.brand_gradient_center), androidx.core.content.b.getColor(shortTVHomeFragment.requireContext(), com.tn.lib.widget.R.color.brand_gradient_end));
            return gradientLinePagerIndicator;
        }

        public xy.d c(Context context, int i) {
            Intrinsics.h(context, "context");
            xy.d shortTVTabTitleView = new ShortTVTabTitleView(context);
            ShortTVHomeFragment shortTVHomeFragment = ShortTVHomeFragment.this;
            shortTVTabTitleView.setTextById(shortTVHomeFragment.tabs[i].intValue());
            shortTVTabTitleView.setOnClickListener(new a(shortTVHomeFragment, i));
            shortTVHomeFragment.tabTitleViewMap.put(Integer.valueOf(i), shortTVTabTitleView);
            return shortTVTabTitleView;
        }
    }

    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        public void onPageScrollStateChanged(int i) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i);
            q qVar = (q) ShortTVHomeFragment.this.getMViewBinding();
            if (qVar == null || (magicIndicator = qVar.b) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i, f, i2);
            q qVar = (q) ShortTVHomeFragment.this.getMViewBinding();
            if (qVar == null || (magicIndicator = qVar.b) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            MagicIndicator magicIndicator;
            super.onPageSelected(i);
            q qVar = (q) ShortTVHomeFragment.this.getMViewBinding();
            if (qVar != null && (magicIndicator = qVar.b) != null) {
                magicIndicator.onPageSelected(i);
            }
            int unused = ShortTVHomeFragment.this.selectTabIndex;
            ShortTVHomeFragment.this.l0(true);
            ShortTVHomeFragment.this.n0(true);
            ShortTVHomeFragment.this.selectTabIndex = i;
            ShortTVHomeFragment shortTVHomeFragment = ShortTVHomeFragment.this;
            shortTVHomeFragment.m0(shortTVHomeFragment.isBanner);
        }
    }

    public static final class d extends FragmentStateAdapter {
        d() {
            super(ShortTVHomeFragment.this);
        }

        public Fragment createFragment(int i) {
            a.a aVar = wf.a.a;
            String str = ShortTVHomeFragment.this.TAG;
            Intrinsics.g(str, "access$getTAG$p(...)");
            a.a.f(aVar, str, "createFragment, position:" + i, false, 4, (Object) null);
            return ShortTVHomeFragment.this.p0();
        }

        public int getItemCount() {
            return ShortTVHomeFragment.this.tabs.length;
        }
    }

    private final void initViewPager() {
        ViewPager2 viewPager2;
        this.vpAdapter = new d();
        q qVar = (q) getMViewBinding();
        if (qVar != null && (viewPager2 = qVar.c) != null) {
            viewPager2.setAdapter(this.vpAdapter);
        }
        k0();
        new Handler().postDelayed(new Runnable() { // from class: com.transsion.postdetail.shorttv.i
            @Override // java.lang.Runnable
            public final void run() {
                ShortTVHomeFragment.r0(ShortTVHomeFragment.this);
            }
        }, 10L);
    }

    private final void k0() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        MagicIndicator magicIndicator;
        CommonNavigator commonNavigator = new CommonNavigator(requireContext());
        commonNavigator.setFollowTouch(true);
        commonNavigator.setAdapter(new b());
        this.commonNavigator = commonNavigator;
        q qVar = (q) getMViewBinding();
        if (qVar != null && (magicIndicator = qVar.b) != null) {
            magicIndicator.setNavigator(this.commonNavigator);
        }
        q qVar2 = (q) getMViewBinding();
        if (qVar2 != null && (viewPager22 = qVar2.c) != null) {
            viewPager22.registerOnPageChangeCallback(new c());
        }
        q qVar3 = (q) getMViewBinding();
        if (qVar3 == null || (viewPager2 = qVar3.c) == null) {
            return;
        }
        viewPager2.setCurrentItem(this.selectTabIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(boolean isWhiteBg) {
        if (isVisible()) {
            hx.d dVar = new hx.d(isWhiteBg);
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = hx.d.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, dVar, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(boolean isWhiteFont) {
        ImmersionBar with = ImmersionBar.with(this);
        boolean z = false;
        if (!isWhiteFont && !y.a.a()) {
            z = true;
        }
        with.statusBarDarkFont(z);
        with.init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o0(int position, boolean isBanner) {
        LinearLayout linearLayout;
        Context requireContext = requireContext();
        Integer num = this.selectedColor;
        int color = androidx.core.content.b.getColor(requireContext, num != null ? num.intValue() : com.tn.lib.widget.R.color.text_01);
        Context requireContext2 = requireContext();
        Integer num2 = this.normalColor;
        int color2 = androidx.core.content.b.getColor(requireContext2, num2 != null ? num2.intValue() : R$color.short_tv_top_title_gray_color);
        int color3 = androidx.core.content.b.getColor(requireContext(), com.tn.lib.widget.R.color.white);
        int color4 = androidx.core.content.b.getColor(requireContext(), com.tn.lib.widget.R.color.white_60);
        CommonNavigator commonNavigator = this.commonNavigator;
        if (commonNavigator != null) {
            LinearLayout linearLayout2 = (LinearLayout) commonNavigator.findViewById(net.lucode.hackware.magicindicator.R.id.title_container);
            SimplePagerTitleView childAt = linearLayout2.getChildAt(0);
            SimplePagerTitleView childAt2 = linearLayout2.getChildAt(1);
            if (position != 0) {
                if (position == 1) {
                    if (childAt instanceof ShortTVTabTitleView) {
                        SimplePagerTitleView simplePagerTitleView = (ShortTVTabTitleView) childAt;
                        simplePagerTitleView.setNormalColor(color4);
                        simplePagerTitleView.setTextColor(color4);
                    }
                    if (childAt2 instanceof ShortTVTabTitleView) {
                        SimplePagerTitleView simplePagerTitleView2 = (ShortTVTabTitleView) childAt2;
                        simplePagerTitleView2.setSelectedColor(color3);
                        simplePagerTitleView2.setTextColor(color3);
                    }
                }
            } else if (isBanner) {
                if (childAt instanceof ShortTVTabTitleView) {
                    SimplePagerTitleView simplePagerTitleView3 = (ShortTVTabTitleView) childAt;
                    simplePagerTitleView3.setSelectedColor(color3);
                    simplePagerTitleView3.setTextColor(color3);
                }
                if (childAt2 instanceof ShortTVTabTitleView) {
                    SimplePagerTitleView simplePagerTitleView4 = (ShortTVTabTitleView) childAt2;
                    simplePagerTitleView4.setNormalColor(color4);
                    simplePagerTitleView4.setTextColor(color4);
                }
            } else {
                if (childAt instanceof ShortTVTabTitleView) {
                    SimplePagerTitleView simplePagerTitleView5 = (ShortTVTabTitleView) childAt;
                    simplePagerTitleView5.setSelectedColor(color);
                    simplePagerTitleView5.setTextColor(color);
                }
                if (childAt2 instanceof ShortTVTabTitleView) {
                    SimplePagerTitleView simplePagerTitleView6 = (ShortTVTabTitleView) childAt2;
                    simplePagerTitleView6.setNormalColor(color2);
                    simplePagerTitleView6.setTextColor(color2);
                }
            }
            for (View view : CollectionsKt.o(new View[]{childAt, childAt2})) {
                ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                view.setLayoutParams(layoutParams2);
            }
        }
        CommonNavigator commonNavigator2 = this.commonNavigator;
        if (commonNavigator2 == null || (linearLayout = (LinearLayout) commonNavigator2.findViewById(net.lucode.hackware.magicindicator.R.id.indicator_container)) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                GradientLinePagerIndicator childAt3 = linearLayout.getChildAt(i);
                GradientLinePagerIndicator gradientLinePagerIndicator = childAt3 instanceof GradientLinePagerIndicator ? childAt3 : null;
                if (isBanner || this.selectTabIndex != 0) {
                    if (gradientLinePagerIndicator != null) {
                        gradientLinePagerIndicator.setColors(color3, color3, color3);
                    }
                } else if (gradientLinePagerIndicator != null) {
                    gradientLinePagerIndicator.setColors(androidx.core.content.b.getColor(requireContext(), com.tn.lib.widget.R.color.brand_gradient_start), androidx.core.content.b.getColor(requireContext(), com.tn.lib.widget.R.color.brand_gradient_center), androidx.core.content.b.getColor(requireContext(), com.tn.lib.widget.R.color.brand_gradient_end));
                }
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment p0() {
        ShortTvVideoFragment a;
        VideoFragment a2;
        ConfigBean c2 = cm.f.c.a().c("sa_for_you_mode", true);
        String value = c2 != null ? c2.getValue() : null;
        if (value != null && value.length() != 0 && !Intrinsics.c(value, MsgStyle.CUSTOM_LEFT_PIC)) {
            a2 = VideoFragment.INSTANCE.a(null, null, null, true, (r30 & 16) != 0, (r30 & 32) != 0 ? BuildConfig.FLAVOR : null, (r30 & 64) != 0 ? false : true, (r30 & 128) != 0 ? BuildConfig.FLAVOR : null, (r30 & 256) != 0 ? null : null, (r30 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? false : false, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? false : false, (r30 & 4096) != 0 ? false : false);
            return a2;
        }
        ShortTvVideoFragment.Companion companion = ShortTvVideoFragment.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        a = companion.a(requireContext, null, null, null, true, (r20 & 32) != 0, (r20 & 64) != 0 ? BuildConfig.FLAVOR : null, (r20 & 128) != 0 ? false : true);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(ShortTVHomeFragment shortTVHomeFragment) {
        try {
            Result.Companion companion = Result.Companion;
            if (shortTVHomeFragment.isAdded() && shortTVHomeFragment.getContext() != null) {
                shortTVHomeFragment.m0(shortTVHomeFragment.isBanner);
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    private final boolean s0() {
        ConfigBean c2 = cm.f.c.a().c("shorts_tab_in_for_you", true);
        String value = c2 != null ? c2.getValue() : null;
        if (value == null) {
            return false;
        }
        return Intrinsics.c(value, "true");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean, int] */
    public void initView(View view, Bundle savedInstanceState) {
        MagicIndicator magicIndicator;
        Intrinsics.h(view, "view");
        q qVar = (q) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (qVar == null || (magicIndicator = qVar.b) == null) ? null : magicIndicator.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = com.blankj.utilcode.util.d.c();
        ?? s0 = s0();
        this.defaultTabIndex = s0;
        int i = s0;
        if (savedInstanceState != 0) {
            i = savedInstanceState.getInt("CURRENT_TAB", s0);
        }
        this.selectTabIndex = i;
        this.isBanner = savedInstanceState != 0 ? savedInstanceState.getBoolean("IS_BANNER", true) : true;
        initViewPager();
    }

    public void lazyLoadData() {
    }

    public final void m0(boolean isBanner) {
        this.isBanner = isBanner;
        o0(this.selectTabIndex, isBanner);
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(outState);
        outState.putInt("CURRENT_TAB", this.selectTabIndex);
        outState.putBoolean("IS_BANNER", this.isBanner);
    }

    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public q getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        q c2 = q.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
