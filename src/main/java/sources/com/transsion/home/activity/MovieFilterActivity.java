package com.transsion.home.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.therouter.TheRouter;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R;
import com.transsion.baselib.report.g;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.util.f;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.activity.MovieFilterActivity;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.bean.NameImage;
import com.transsion.home.enum.HomeTabType;
import com.transsion.home.fragment.tab.MovieFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.home.viewmodel.preload.PreloadTrendingData$a;
import ij.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import xy.d;
import zg.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u0005J\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u001a\u00104\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/transsion/home/activity/MovieFilterActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lqk/c;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", BuildConfig.FLAVOR, "g0", BuildConfig.FLAVOR, "tabId", BuildConfig.FLAVOR, "l0", "(Ljava/lang/Integer;)Z", "j0", "k0", "o0", "(I)V", "e0", "(I)I", "n0", "m0", "isTranslucent", "()Z", "isStatusDark", "f0", "()Lqk/c;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initView", "retryLoadData", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "a", "I", "b", "Z", "showViewPager", "c", "Ljava/lang/String;", "tabCode", "d", "mFilterJson", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/HomeTabItem;", "e", "Ljava/util/List;", "tabItems", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MovieFilterActivity extends BaseActivity<qk.c> implements g {

    /* renamed from: a, reason: from kotlin metadata */
    public int tabId;

    /* renamed from: d, reason: from kotlin metadata */
    public String mFilterJson;

    /* renamed from: b, reason: from kotlin metadata */
    public boolean showViewPager = true;

    /* renamed from: c, reason: from kotlin metadata */
    public String tabCode = BuildConfig.FLAVOR;

    /* renamed from: e, reason: from kotlin metadata */
    private final List tabItems = new ArrayList();

    public static final class a extends FragmentStateAdapter {
        a() {
            super(MovieFilterActivity.this);
        }

        public Fragment createFragment(int i) {
            MovieFilterActivity movieFilterActivity = MovieFilterActivity.this;
            int i2 = movieFilterActivity.tabId;
            Integer tabId = ((HomeTabItem) movieFilterActivity.tabItems.get(i)).getTabId();
            String str = (tabId != null && i2 == tabId.intValue()) ? MovieFilterActivity.this.mFilterJson : null;
            MovieFragment.Companion companion = MovieFragment.INSTANCE;
            Integer tabId2 = ((HomeTabItem) MovieFilterActivity.this.tabItems.get(i)).getTabId();
            return companion.a(tabId2 != null ? tabId2.intValue() : 2, true, str, ((HomeTabItem) MovieFilterActivity.this.tabItems.get(i)).getTabCode());
        }

        public int getItemCount() {
            return MovieFilterActivity.this.tabItems.size();
        }
    }

    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
            ((qk.c) MovieFilterActivity.this.getMViewBinding()).b.onPageScrollStateChanged(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
            ((qk.c) MovieFilterActivity.this.getMViewBinding()).b.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            ((qk.c) MovieFilterActivity.this.getMViewBinding()).b.onPageSelected(i);
        }
    }

    public static final class c extends xy.a {

        public static final class a extends f {
            final /* synthetic */ MovieFilterActivity e;
            final /* synthetic */ int f;

            a(MovieFilterActivity movieFilterActivity, int i) {
                this.e = movieFilterActivity;
                this.f = i;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                ((qk.c) this.e.getMViewBinding()).d.setCurrentItem(this.f, false);
                ((qk.c) this.e.getMViewBinding()).b.onPageScrolled(this.f, 0.0f, 0);
            }
        }

        c() {
        }

        public int a() {
            return MovieFilterActivity.this.tabItems.size();
        }

        public xy.c b(Context context) {
            GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(MovieFilterActivity.this);
            BaseActivity baseActivity = MovieFilterActivity.this;
            gradientLinePagerIndicator.setMode(2);
            gradientLinePagerIndicator.setLineHeight(com.transsion.usercenter.setting.labelsfeedback.a.b(3));
            gradientLinePagerIndicator.setLineWidth(com.transsion.usercenter.setting.labelsfeedback.a.b(24));
            gradientLinePagerIndicator.setRoundRadius(com.transsion.usercenter.setting.labelsfeedback.a.a(1.5f));
            gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            int color = androidx.core.content.b.getColor(baseActivity, R.color.white);
            gradientLinePagerIndicator.setColors(color, color, color);
            return gradientLinePagerIndicator;
        }

        public d c(Context context, int i) {
            CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(MovieFilterActivity.this, 17, com.transsion.usercenter.setting.labelsfeedback.a.b(12));
            MovieFilterActivity movieFilterActivity = MovieFilterActivity.this;
            customPagerTitleView.setText(((HomeTabItem) movieFilterActivity.tabItems.get(i)).getName());
            customPagerTitleView.setOnClickListener(new a(movieFilterActivity, i));
            return customPagerTitleView;
        }
    }

    private final int e0(int tabId) {
        int size = this.tabItems.size();
        for (int i = 0; i < size; i++) {
            Integer tabId2 = ((HomeTabItem) this.tabItems.get(i)).getTabId();
            if (tabId2 != null && tabId2.intValue() == tabId) {
                return i;
            }
        }
        return 0;
    }

    private final void g0() {
        List<HomeTabItem> homeTabs;
        PreloadTrendingData$a preloadTrendingData$a = PreloadTrendingData.n;
        AppTab appTab = (AppTab) preloadTrendingData$a.a().D().f();
        if (appTab == null) {
            appTab = (AppTab) preloadTrendingData$a.a().C().f();
        }
        this.tabItems.clear();
        if (!this.showViewPager || !l0(Integer.valueOf(this.tabId))) {
            this.tabItems.add(new HomeTabItem(BuildConfig.FLAVOR, Integer.valueOf(this.tabId), BuildConfig.FLAVOR, BuildConfig.FLAVOR, this.tabCode, (NameImage) null, (NameImage) null, (String) null, (Boolean) null, 480, (DefaultConstructorMarker) null));
            MagicIndicator magicIndicator = ((qk.c) getMViewBinding()).b;
            Intrinsics.g(magicIndicator, "magicIndicator");
            uf.c.g(magicIndicator);
            return;
        }
        if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
            return;
        }
        for (HomeTabItem homeTabItem : homeTabs) {
            if (Intrinsics.c(homeTabItem != null ? homeTabItem.getType() : null, HomeTabType.SUB_OPERATION.getValue()) && l0(homeTabItem.getTabId())) {
                this.tabItems.add(homeTabItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void h0(MovieFilterActivity movieFilterActivity, View view) {
        gj.b bVar = (gj.b) gj.a.a.a(gj.b.class);
        if (bVar != null) {
            bVar.c(BuildConfig.FLAVOR, movieFilterActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(MovieFilterActivity movieFilterActivity, View view) {
        movieFilterActivity.n0();
        movieFilterActivity.finish();
    }

    private final void j0() {
        ((qk.c) getMViewBinding()).d.setAdapter(new a());
        ((qk.c) getMViewBinding()).d.registerOnPageChangeCallback(new b());
        o0(this.tabId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k0() {
        MagicIndicator magicIndicator = ((qk.c) getMViewBinding()).b;
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new c());
        magicIndicator.setNavigator(commonNavigator);
    }

    private final boolean l0(Integer tabId) {
        HomeTabId.Companion companion = HomeTabId.INSTANCE;
        int d = companion.d();
        if (tabId == null || tabId.intValue() != d) {
            int f = companion.f();
            if (tabId == null || tabId.intValue() != f) {
                int b2 = companion.b();
                if (tabId == null || tabId.intValue() != b2) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void m0() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "back_browse");
        hashMap.put("tabId", String.valueOf(this.tabId));
        com.transsion.baselib.helper.a.a.e(getPageName(), hashMap);
    }

    private final void n0() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "back_click");
        hashMap.put("tabId", String.valueOf(this.tabId));
        com.transsion.baselib.helper.a.a.f(getPageName(), hashMap);
    }

    private final void o0(int tabId) {
        ((qk.c) getMViewBinding()).d.setCurrentItem(e0(tabId), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public qk.c getViewBinding() {
        qk.c c2 = qk.c.c(getLayoutInflater());
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public String getPageName() {
        return "movie_filter_page";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initView(Bundle savedInstanceState) {
        TitleLayout titleLayout = ((qk.c) getMViewBinding()).c;
        titleLayout.setRightView(com.transsion.home.R.mipmap.ic_search_movie, new View.OnClickListener() { // from class: lk.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieFilterActivity.h0(MovieFilterActivity.this, view);
            }
        });
        titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: lk.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieFilterActivity.i0(MovieFilterActivity.this, view);
            }
        });
        m0();
        String string = getString(com.transsion.home.R.string.filter);
        Intrinsics.g(string, "getString(...)");
        titleLayout.setTitleText(string);
        h hVar = h.a;
        Context context = titleLayout.getContext();
        Intrinsics.g(context, "getContext(...)");
        titleLayout.setPadding(0, hVar.d(context), 0, 0);
        g0();
        k0();
        j0();
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }

    public qi.b newLogViewConfig() {
        qi.b bVar = new qi.b(getPageName(), false, 2, null);
        bVar.l(true);
        return bVar;
    }

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    public void retryLoadData() {
    }
}
