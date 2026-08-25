package com.transsion.home.fragment.home;

import android.app.Application;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.BlurredSectorView;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.edcation.CourseManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.BottomTabItem;
import com.transsion.home.bean.GradeGroup;
import com.transsion.home.bean.GradeItem;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomePreferencesRefreshType;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.enum.HomeTabType;
import com.transsion.home.fragment.dialog.CategoryDiscoverDialog;
import com.transsion.home.fragment.dialog.GradeSelectDialog;
import com.transsion.home.fragment.dialog.HomePreferencesEnterPopDialog;
import com.transsion.home.fragment.home.HomeFragment;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.fragment.tab.EmptyFragment;
import com.transsion.home.fragment.tab.MovieFragment;
import com.transsion.home.fragment.tab.SubShortTvFragment;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.fragment.tab.TopRoomFragment;
import com.transsion.home.fragment.tab.TrendingFragment;
import com.transsion.home.fragment.tab.TrendingFragment$a;
import com.transsion.home.fragment.tab.TrendingUGCFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.home.p000enum.HomeTabType$a;
import com.transsion.home.viewmodel.HomePreferencesViewModel;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.home.viewmodel.preload.PreloadTrendingData$a;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.web.fragment.WebFragmentV2;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import wf.a;
import yg.m;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u0098\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001hB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0004J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u0019\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u0004J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010\u0004J\u0015\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u001a¢\u0006\u0004\b(\u0010\u001dJ\r\u0010)\u001a\u00020\t¢\u0006\u0004\b)\u0010\u0004J\u001d\u0010,\u001a\u00020\t2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\f¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u001a¢\u0006\u0004\b1\u00102J\u001d\u00105\u001a\u00020\t2\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u001a¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\t¢\u0006\u0004\b7\u0010\u0004J\u0015\u00109\u001a\b\u0012\u0004\u0012\u00020\"08H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\t2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b?\u0010>J\u000f\u0010@\u001a\u00020\tH\u0002¢\u0006\u0004\b@\u0010\u0004J\u000f\u0010A\u001a\u00020\tH\u0002¢\u0006\u0004\bA\u0010\u0004J\u000f\u0010B\u001a\u00020\tH\u0002¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010C\u001a\u00020\tH\u0002¢\u0006\u0004\bC\u0010\u0004J\u0019\u0010E\u001a\u00020\t2\b\u0010D\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\bE\u0010FJ\u0019\u0010I\u001a\u00020\t2\b\u0010H\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\tH\u0002¢\u0006\u0004\bK\u0010\u0004J\u0017\u0010N\u001a\u00020M2\u0006\u0010L\u001a\u00020\fH\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\tH\u0002¢\u0006\u0004\bP\u0010\u0004J\u001f\u0010R\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\"2\u0006\u0010+\u001a\u00020\fH\u0002¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\tH\u0002¢\u0006\u0004\bT\u0010\u0004J\u000f\u0010U\u001a\u00020\tH\u0002¢\u0006\u0004\bU\u0010\u0004J\u001f\u0010W\u001a\u00020\t2\u0006\u0010L\u001a\u00020\f2\u0006\u0010V\u001a\u00020\u001aH\u0002¢\u0006\u0004\bW\u0010XJ\u001b\u0010\\\u001a\u0004\u0018\u00010[2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\tH\u0002¢\u0006\u0004\b^\u0010\u0004J\u0017\u0010`\u001a\u00020\t2\u0006\u0010_\u001a\u00020\fH\u0002¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\tH\u0002¢\u0006\u0004\bb\u0010\u0004J\u000f\u0010c\u001a\u00020\tH\u0002¢\u0006\u0004\bc\u0010\u0004J\u0019\u0010f\u001a\u00020\t2\b\u0010e\u001a\u0004\u0018\u00010dH\u0002¢\u0006\u0004\bf\u0010gR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u001c\u0010p\u001a\b\u0012\u0002\b\u0003\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u001b\u0010v\u001a\u00020q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010}\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0017\u0010\u0080\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010kR\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010kR\u0018\u0010\u0089\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010kR\u0018\u0010\u008b\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010\u007fR\u001a\u0010\u008f\u0001\u001a\u00030\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001¨\u0006\u0099\u0001"}, d2 = {"Lcom/transsion/home/fragment/home/HomeFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lqk/p;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "I0", "()I", "Landroid/view/LayoutInflater;", "inflater", "K0", "(Landroid/view/LayoutInflater;)Lqk/p;", "b1", "initData", "lazyLoadData", "Landroid/content/Intent;", "intent", "newIntent", "(Landroid/content/Intent;)V", BuildConfig.FLAVOR, "hidden", "onHiddenChanged", "(Z)V", "logPause", "logResume", "onResume", "onPause", BuildConfig.FLAVOR, "J0", "()Ljava/lang/String;", "onDestroyView", "onDestroy", "isWhite", "D0", "u1", "tabCode", "tabId", "t1", "(Ljava/lang/String;I)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "Y0", "()Z", "pageTabName", "isRefresh", "a1", "(Ljava/lang/String;Z)V", "v1", BuildConfig.FLAVOR, "L0", "()Ljava/util/List;", "Lcom/transsion/home/bean/HomePreferencesConfig;", "config", "N0", "(Lcom/transsion/home/bean/HomePreferencesConfig;)V", "m1", "f1", "X0", "R0", "w1", "value", "r1", "(Ljava/lang/String;)V", "Lcom/transsion/home/bean/AppTab;", "appTab", "x1", "(Lcom/transsion/home/bean/AppTab;)V", "initViewPager", "position", "Landroidx/fragment/app/Fragment;", "E0", "(I)Landroidx/fragment/app/Fragment;", "B0", "code", "H0", "(Ljava/lang/String;I)I", "d1", "j1", "smoothScroll", "c1", "(IZ)V", BuildConfig.FLAVOR, "navigator", "Landroid/widget/HorizontalScrollView;", "G0", "(Ljava/lang/Object;)Landroid/widget/HorizontalScrollView;", "k1", "scrollX", "O0", "(I)V", "p1", "Z0", "Lcom/transsion/home/bean/HomeTabItem;", "tabItem", "M0", "(Lcom/transsion/home/bean/HomeTabItem;)V", "a", "Lcom/transsion/home/bean/AppTab;", "b", "I", "mSelectTabIndex", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "c", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "trendingFragment", "Lcom/transsion/home/viewmodel/HomePreferencesViewModel;", "d", "Lkotlin/Lazy;", "F0", "()Lcom/transsion/home/viewmodel/HomePreferencesViewModel;", "homePreferencesViewModel", "Lcom/transsion/home/fragment/home/HomeSearchViewManager;", "e", "Lcom/transsion/home/fragment/home/HomeSearchViewManager;", "mHomeSearchViewManager", "f", "Landroid/os/Bundle;", "mSavedInstanceState", "g", "Z", "isHandlingRedirect", "h", "lastValidPosition", "i", "Landroid/widget/HorizontalScrollView;", "cachedScrollView", "j", "lastTopTabScrollX", "k", "scrollStartSelectIndex", "l", "isTopTabScrolling", BuildConfig.FLAVOR, "m", "J", "resumeTimeStamp", "Landroid/os/Handler;", "n", "Landroid/os/Handler;", "scrollStopHandler", "Ljava/lang/Runnable;", "o", "Ljava/lang/Runnable;", "scrollStopRunnable", "p", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HomeFragment extends BaseFragment<qk.p> {
    public static final int q = 8;
    private static int r;

    /* renamed from: a, reason: from kotlin metadata */
    private AppTab appTab;

    /* renamed from: b, reason: from kotlin metadata */
    private int mSelectTabIndex = r;

    /* renamed from: c, reason: from kotlin metadata */
    private BaseHomeSubFragment trendingFragment;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy homePreferencesViewModel;

    /* renamed from: e, reason: from kotlin metadata */
    private HomeSearchViewManager mHomeSearchViewManager;

    /* renamed from: f, reason: from kotlin metadata */
    private Bundle mSavedInstanceState;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean isHandlingRedirect;

    /* renamed from: h, reason: from kotlin metadata */
    private int lastValidPosition;

    /* renamed from: i, reason: from kotlin metadata */
    private HorizontalScrollView cachedScrollView;

    /* renamed from: j, reason: from kotlin metadata */
    private int lastTopTabScrollX;

    /* renamed from: k, reason: from kotlin metadata */
    private int scrollStartSelectIndex;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean isTopTabScrolling;

    /* renamed from: m, reason: from kotlin metadata */
    private long resumeTimeStamp;

    /* renamed from: n, reason: from kotlin metadata */
    private Handler scrollStopHandler;

    /* renamed from: o, reason: from kotlin metadata */
    private Runnable scrollStopRunnable;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[HomeTabType.values().length];
            try {
                iArr[HomeTabType.SUB_OPERATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HomeTabType.SUBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HomeTabType.H5TAB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HomeTabType.TRENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HomeTabType.SHORT_TV_TAB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HomeTabType.SUB_ROOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(HomeFragment homeFragment, int i) {
            MagicIndicator magicIndicator;
            qk.p pVar = (qk.p) homeFragment.getMViewBinding();
            if (pVar != null && (magicIndicator = pVar.k) != null) {
                magicIndicator.onPageSelected(i);
            }
            homeFragment.c1(i, false);
        }

        public void onPageScrollStateChanged(int i) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i);
            qk.p pVar = (qk.p) HomeFragment.this.getMViewBinding();
            if (pVar == null || (magicIndicator = pVar.k) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i, f, i2);
            qk.p pVar = (qk.p) HomeFragment.this.getMViewBinding();
            if (pVar == null || (magicIndicator = pVar.k) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(final int i) {
            MagicIndicator magicIndicator;
            String str;
            List<HomeTabItem> homeTabs;
            List<HomeTabItem> homeTabs2;
            super.onPageSelected(i);
            if (HomeFragment.this.isHandlingRedirect || i < 0 || HomeFragment.this.mSelectTabIndex == i) {
                return;
            }
            AppTab appTab = HomeFragment.this.appTab;
            HomeTabItem homeTabItem = (appTab == null || (homeTabs2 = appTab.getHomeTabs()) == null) ? null : homeTabs2.get(i);
            if (homeTabItem == null || !homeTabItem.isOpenLandPage()) {
                HomeFragment.this.lastValidPosition = i;
                qk.p pVar = (qk.p) HomeFragment.this.getMViewBinding();
                if (pVar != null && (magicIndicator = pVar.k) != null) {
                    final HomeFragment homeFragment = HomeFragment.this;
                    magicIndicator.post(new Runnable() { // from class: com.transsion.home.fragment.home.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            HomeFragment.c.b(HomeFragment.this, i);
                        }
                    });
                }
            } else {
                HomeFragment.this.isHandlingRedirect = true;
                ij.k.h(homeTabItem.getUrl(), null, 1, null);
            }
            AppTab appTab2 = HomeFragment.this.appTab;
            HomeTabItem homeTabItem2 = (appTab2 == null || (homeTabs = appTab2.getHomeTabs()) == null) ? null : homeTabs.get(i);
            com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.a;
            String J0 = HomeFragment.this.J0();
            if (homeTabItem2 == null || (str = homeTabItem2.getName()) == null) {
                str = BuildConfig.FLAVOR;
            }
            aVar.n(J0, str);
            HomeFragment.this.mSelectTabIndex = i;
            HomeFragment homeFragment2 = HomeFragment.this;
            homeFragment2.a1(homeFragment2.J0(), false);
            if (HomeFragment.this.isAdded()) {
                BaseHomeSubFragment k0 = HomeFragment.this.getChildFragmentManager().k0("f" + HomeFragment.this.mSelectTabIndex);
                if (k0 instanceof BaseHomeSubFragment) {
                    k0.o0();
                } else {
                    HomeFragment.this.D0(false);
                }
            }
            if (Intrinsics.c(homeTabItem2 != null ? homeTabItem2.getTabCode() : null, "Education") && HomeFragment.this.isAdded() && !HomeFragment.this.isDetached() && !HomeFragment.this.isRemoving()) {
                CourseManager courseManager = CourseManager.a;
                FragmentManager supportFragmentManager = HomeFragment.this.requireActivity().getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                courseManager.g(supportFragmentManager);
            }
            HomeFragment.this.v1();
        }
    }

    public static final class d extends FragmentStateAdapter {
        d() {
            super(HomeFragment.this);
        }

        public Fragment createFragment(int i) {
            return HomeFragment.this.E0(i);
        }

        public int getItemCount() {
            List<HomeTabItem> homeTabs;
            AppTab appTab = HomeFragment.this.appTab;
            if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
                return 0;
            }
            return homeTabs.size();
        }
    }

    static final class e implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        e(Function1 function1) {
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

    public static final class f implements yg.m {
        f() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            HomeSearchViewManager homeSearchViewManager = HomeFragment.this.mHomeSearchViewManager;
            if (homeSearchViewManager != null) {
                homeSearchViewManager.I(network, networkCapabilities);
            }
        }

        public void onDisconnected() {
        }
    }

    public HomeFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.home.fragment.home.HomeFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m15invoke() {
                return this;
            }
        };
        this.homePreferencesViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(HomePreferencesViewModel.class), new Function0<x0>() { // from class: com.transsion.home.fragment.home.HomeFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m16invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.home.fragment.home.HomeFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m17invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.scrollStartSelectIndex = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
    
        if (r4 < ((r0 == null || (r0 = r0.getHomeTabs()) == null) ? 0 : r0.size())) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void B0() {
        int i;
        int i2;
        ViewPager2 viewPager2;
        MagicIndicator magicIndicator;
        ViewPager2 viewPager22;
        List<HomeTabItem> homeTabs;
        BottomTabItem homeBottomTab;
        ViewPager2 viewPager23;
        qk.p pVar = (qk.p) getMViewBinding();
        if (pVar != null && (viewPager23 = pVar.s) != null) {
            viewPager23.registerOnPageChangeCallback(new c());
        }
        AppTab appTab = this.appTab;
        String defaultSubTabCode = (appTab == null || (homeBottomTab = appTab.getHomeBottomTab()) == null) ? null : homeBottomTab.getDefaultSubTabCode();
        AppTab appTab2 = this.appTab;
        if (appTab2 == null || (homeTabs = appTab2.getHomeTabs()) == null) {
            i = -1;
            i2 = -1;
        } else {
            int i3 = 0;
            i = -1;
            i2 = -1;
            for (Object obj : homeTabs) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.u();
                }
                HomeTabItem homeTabItem = (HomeTabItem) obj;
                if (defaultSubTabCode != null) {
                    if (Intrinsics.c(defaultSubTabCode, homeTabItem != null ? homeTabItem.getTabCode() : null)) {
                        i2 = i3;
                    }
                }
                if (Intrinsics.c(homeTabItem != null ? homeTabItem.getType() : null, HomeTabType.TRENDING.getValue())) {
                    i = i3;
                }
                if (homeTabItem != null ? Intrinsics.c(homeTabItem.isEducationTab(), Boolean.TRUE) : false) {
                    HomeTabId.INSTANCE.a(homeTabItem.getTabId());
                }
                i3 = i4;
            }
        }
        if (i2 >= 0) {
            i = i2;
        }
        r = i;
        Bundle bundle = this.mSavedInstanceState;
        int i5 = bundle != null ? bundle.getInt("current_tab", -1) : -1;
        if (i5 >= 0) {
            AppTab appTab3 = this.appTab;
        }
        i5 = r;
        this.mSelectTabIndex = i5;
        qk.p pVar2 = (qk.p) getMViewBinding();
        if (pVar2 != null && (viewPager22 = pVar2.s) != null) {
            viewPager22.setCurrentItem(this.mSelectTabIndex, false);
        }
        qk.p pVar3 = (qk.p) getMViewBinding();
        if (pVar3 != null && (magicIndicator = pVar3.k) != null) {
            magicIndicator.post(new Runnable() { // from class: com.transsion.home.fragment.home.g
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.C0(HomeFragment.this);
                }
            });
        }
        qk.p pVar4 = (qk.p) getMViewBinding();
        if (pVar4 != null && (viewPager2 = pVar4.s) != null) {
            viewPager2.setOffscreenPageLimit(1);
        }
        v1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(HomeFragment homeFragment) {
        MagicIndicator magicIndicator;
        qk.p pVar = (qk.p) homeFragment.getMViewBinding();
        if (pVar != null && (magicIndicator = pVar.k) != null) {
            magicIndicator.onPageSelected(homeFragment.mSelectTabIndex);
        }
        homeFragment.a1(homeFragment.J0(), true);
        homeFragment.k1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment E0(int position) {
        Integer tabId;
        Integer tabId2;
        Integer tabId3;
        Integer tabId4;
        Integer tabId5;
        Integer tabId6;
        List<HomeTabItem> homeTabs;
        int i = 1;
        AppTab appTab = this.appTab;
        HomeTabItem homeTabItem = (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) ? null : homeTabs.get(position);
        a.a aVar = wf.a.a;
        aVar.c("HomeFragment", "getFragment: " + (homeTabItem != null ? homeTabItem.getType() : null) + "&position:" + position + "&tabCode:" + (homeTabItem != null ? homeTabItem.getTabCode() : null) + "&displayType:" + (homeTabItem != null ? homeTabItem.getDisplayType() : null), true);
        HomeTabType$a homeTabType$a = HomeTabType.Companion;
        if (homeTabType$a.a(homeTabItem != null ? homeTabItem.getType() : null) == HomeTabType.SUB_NOVEL) {
            dj.a aVar2 = dj.a.a;
            Application a = Utils.a();
            Intrinsics.g(a, "getApp(...)");
            aVar2.d(a);
        }
        if (homeTabItem != null && homeTabItem.isOpenLandPage()) {
            a.a.f(aVar, "HomeFragment", "getFragment isOpenLandPage", false, 4, (Object) null);
            return new EmptyFragment();
        }
        HomeTabType a2 = homeTabType$a.a(homeTabItem != null ? homeTabItem.getType() : null);
        switch (a2 == null ? -1 : b.a[a2.ordinal()]) {
            case 1:
                SubTabFragment.Companion companion = SubTabFragment.INSTANCE;
                if (homeTabItem != null && (tabId = homeTabItem.getTabId()) != null) {
                    i = tabId.intValue();
                }
                return companion.b(i, homeTabItem != null ? homeTabItem.getTabCode() : null);
            case 2:
                MovieFragment.Companion companion2 = MovieFragment.INSTANCE;
                if (homeTabItem != null && (tabId2 = homeTabItem.getTabId()) != null) {
                    i = tabId2.intValue();
                }
                return MovieFragment.Companion.b(companion2, i, false, null, homeTabItem != null ? homeTabItem.getTabCode() : null, 6, null);
            case 3:
                WebFragmentV2 b2 = WebFragmentV2.w.b();
                Pair a3 = TuplesKt.a("url", homeTabItem != null ? homeTabItem.getUrl() : null);
                Boolean bool = Boolean.TRUE;
                b2.setArguments(androidx.core.os.d.b(new Pair[]{a3, TuplesKt.a("tool_bar_hidden", bool), TuplesKt.a("tab_code", homeTabItem != null ? homeTabItem.getTabCode() : null), TuplesKt.a("need_header", bool), TuplesKt.a("nested_scroll_intercept", bool), TuplesKt.a("header_GB", Integer.valueOf(R$drawable.home_title_gradient_bg))}));
                return b2;
            case 4:
                ij.g gVar = ij.g.a;
                if ((gVar.b() && (this.trendingFragment instanceof TrendingFragment)) || (!gVar.b() && (this.trendingFragment instanceof TrendingUGCFragment))) {
                    this.trendingFragment = null;
                }
                BaseHomeSubFragment baseHomeSubFragment = this.trendingFragment;
                if (baseHomeSubFragment != null) {
                    return baseHomeSubFragment;
                }
                if (gVar.b()) {
                    TrendingUGCFragment.Companion companion3 = TrendingUGCFragment.INSTANCE;
                    if (homeTabItem != null && (tabId4 = homeTabItem.getTabId()) != null) {
                        i = tabId4.intValue();
                    }
                    TrendingUGCFragment a4 = companion3.a(i, homeTabItem != null ? homeTabItem.getTabCode() : null);
                    this.trendingFragment = a4;
                    return a4;
                }
                TrendingFragment$a trendingFragment$a = TrendingFragment.B;
                if (homeTabItem != null && (tabId3 = homeTabItem.getTabId()) != null) {
                    i = tabId3.intValue();
                }
                TrendingFragment a5 = trendingFragment$a.a(i, homeTabItem != null ? homeTabItem.getTabCode() : null);
                this.trendingFragment = a5;
                return a5;
            case 5:
                return SubShortTvFragment.INSTANCE.a((homeTabItem == null || (tabId5 = homeTabItem.getTabId()) == null) ? 13 : tabId5.intValue());
            case 6:
                return new TopRoomFragment();
            default:
                MovieFragment.Companion companion4 = MovieFragment.INSTANCE;
                if (homeTabItem != null && (tabId6 = homeTabItem.getTabId()) != null) {
                    i = tabId6.intValue();
                }
                return MovieFragment.Companion.b(companion4, i, false, null, homeTabItem != null ? homeTabItem.getTabCode() : null, 6, null);
        }
    }

    private final HomePreferencesViewModel F0() {
        return (HomePreferencesViewModel) this.homePreferencesViewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r11v8, types: [android.view.ViewParent] */
    private final HorizontalScrollView G0(Object navigator) {
        HorizontalScrollView horizontalScrollView;
        boolean z = navigator instanceof CommonNavigator;
        if (z) {
            try {
                Field declaredField = CommonNavigator.class.getDeclaredField("a");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(navigator);
                if (obj instanceof HorizontalScrollView) {
                    horizontalScrollView = (HorizontalScrollView) obj;
                }
            } catch (Exception e2) {
                a.a.f(wf.a.a, "HomeFragment", "setupTopTabScrollListener: failed to get scrollView from CommonNavigator, " + e2.getMessage(), false, 4, (Object) null);
            }
            horizontalScrollView = null;
        } else {
            if (navigator instanceof ORCommonNavigator) {
                try {
                    Field declaredField2 = ORCommonNavigator.class.getDeclaredField("a");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(navigator);
                    if (obj2 instanceof HorizontalScrollView) {
                        horizontalScrollView = (HorizontalScrollView) obj2;
                    }
                } catch (Exception e3) {
                    a.a.f(wf.a.a, "HomeFragment", "setupTopTabScrollListener: failed to get scrollView from ORCommonNavigator, " + e3.getMessage(), false, 4, (Object) null);
                }
            }
            horizontalScrollView = null;
        }
        if (horizontalScrollView != null) {
            return horizontalScrollView;
        }
        LinearLayout titleContainer = z ? ((CommonNavigator) navigator).getTitleContainer() : navigator instanceof ORCommonNavigator ? ((ORCommonNavigator) navigator).getTitleContainer() : null;
        HorizontalScrollView parent = titleContainer != null ? titleContainer.getParent() : 0;
        while (parent != 0 && !(parent instanceof HorizontalScrollView)) {
            parent = parent.getParent();
        }
        return parent instanceof HorizontalScrollView ? parent : null;
    }

    private final int H0(String code, int tabId) {
        List<HomeTabItem> homeTabs;
        AppTab appTab;
        List<HomeTabItem> homeTabs2;
        Integer tabId2;
        int i = 0;
        if (tabId >= 0 && (appTab = this.appTab) != null && (homeTabs2 = appTab.getHomeTabs()) != null) {
            int i2 = 0;
            for (Object obj : homeTabs2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                HomeTabItem homeTabItem = (HomeTabItem) obj;
                if (homeTabItem != null && (tabId2 = homeTabItem.getTabId()) != null && tabId2.intValue() == tabId) {
                    return i2;
                }
                i2 = i3;
            }
        }
        AppTab appTab2 = this.appTab;
        if (appTab2 != null && (homeTabs = appTab2.getHomeTabs()) != null) {
            for (Object obj2 : homeTabs) {
                int i4 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                HomeTabItem homeTabItem2 = (HomeTabItem) obj2;
                if (Intrinsics.c(homeTabItem2 != null ? homeTabItem2.getTabCode() : null, code)) {
                    return i;
                }
                i = i4;
            }
        }
        return r;
    }

    private final List L0() {
        String name;
        List<HomeTabItem> homeTabs;
        ArrayList arrayList = new ArrayList();
        qk.p pVar = (qk.p) getMViewBinding();
        MagicIndicator magicIndicator = pVar != null ? pVar.k : null;
        vy.a navigator = magicIndicator != null ? magicIndicator.getNavigator() : null;
        if (this.appTab != null && navigator != null) {
            LinearLayout titleContainer = navigator instanceof CommonNavigator ? ((CommonNavigator) navigator).getTitleContainer() : navigator instanceof ORCommonNavigator ? ((ORCommonNavigator) navigator).getTitleContainer() : null;
            if (titleContainer == null) {
                return arrayList;
            }
            HorizontalScrollView horizontalScrollView = this.cachedScrollView;
            if (horizontalScrollView == null) {
                horizontalScrollView = G0(navigator);
            }
            int scrollX = horizontalScrollView != null ? horizontalScrollView.getScrollX() : 0;
            int width = horizontalScrollView != null ? horizontalScrollView.getWidth() : titleContainer.getMeasuredWidth();
            int childCount = titleContainer.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = titleContainer.getChildAt(i);
                AppTab appTab = this.appTab;
                HomeTabItem homeTabItem = (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) ? null : (HomeTabItem) CollectionsKt.l0(homeTabs, i);
                int left = childAt.getLeft() - scrollX;
                int right = childAt.getRight() - scrollX;
                if (left < width && right > 0 && homeTabItem != null && (name = homeTabItem.getName()) != null) {
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void M0(HomeTabItem tabItem) {
        Object obj;
        Throwable th2;
        Unit unit;
        Integer num;
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        RecyclerView.Adapter adapter;
        List<HomeTabItem> homeTabs;
        if (tabItem == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            AppTab appTab = this.appTab;
            unit = null;
            if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
                num = null;
            } else {
                Iterator<HomeTabItem> it = homeTabs.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    }
                    HomeTabItem next = it.next();
                    if (Intrinsics.c(next != null ? next.getTabId() : null, tabItem.getTabId())) {
                        break;
                    } else {
                        i++;
                    }
                }
                num = Integer.valueOf(i);
            }
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th3));
        }
        if (num != null && num.intValue() >= 0) {
            int intValue = num.intValue();
            qk.p pVar = (qk.p) getMViewBinding();
            if (intValue < ((pVar == null || (viewPager22 = pVar.s) == null || (adapter = viewPager22.getAdapter()) == null) ? 0 : adapter.getItemCount())) {
                HashMap hashMap = new HashMap();
                hashMap.put("dialog_name", "home_switch_tab");
                String name = tabItem.getName();
                if (name == null) {
                    name = BuildConfig.FLAVOR;
                }
                hashMap.put("module_name", name);
                qi.h.a.o(J0(), hashMap);
                qk.p pVar2 = (qk.p) getMViewBinding();
                if (pVar2 != null && (viewPager2 = pVar2.s) != null) {
                    viewPager2.setCurrentItem(num.intValue(), false);
                    unit = Unit.a;
                }
                obj = Result.constructor-impl(unit);
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 == null) {
                    a.a.f(wf.a.a, "HomeFragment", "handleCategorySelection: failed to find tab, " + th2.getMessage(), false, 4, (Object) null);
                    return;
                }
                return;
            }
        }
        a.a.f(wf.a.a, "HomeFragment", "Category not found in current tabs: " + tabItem, false, 4, (Object) null);
        unit = Unit.a;
        obj = Result.constructor-impl(unit);
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void N0(HomePreferencesConfig config) {
        HomeTabItem homeTabItem;
        boolean H;
        ViewPager2 viewPager2;
        String refreshType = config.getRefreshType();
        if (Intrinsics.c(refreshType, HomePreferencesRefreshType.ALL_TOP_TAB.getValue())) {
            String tabCode = config.getTabCode();
            Integer tabId = config.getTabId();
            if (H0(tabCode, tabId != null ? tabId.intValue() : -1) < 0) {
                return;
            }
            a.a.f(wf.a.a, "HomePreferences", "refresh all tab----2", false, 4, (Object) null);
            b1();
            dl.a aVar = new dl.a();
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = dl.a.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, aVar, 0L);
            return;
        }
        if (!Intrinsics.c(refreshType, HomePreferencesRefreshType.CUR_PAGE.getValue())) {
            Intrinsics.c(refreshType, HomePreferencesRefreshType.NO_REFRESH.getValue());
            return;
        }
        AppTab appTab = this.appTab;
        List<HomeTabItem> homeTabs = appTab != null ? appTab.getHomeTabs() : null;
        int i = this.mSelectTabIndex;
        if (i >= 0) {
            if (i < (homeTabs != null ? homeTabs.size() : 0) && homeTabs != null) {
                homeTabItem = homeTabs.get(i);
                H = StringsKt.H(homeTabItem != null ? homeTabItem.getTabCode() : null, config.getTabCode(), true);
                if (!H) {
                    String tabCode2 = config.getTabCode();
                    Integer tabId2 = config.getTabId();
                    i = H0(tabCode2, tabId2 != null ? tabId2.intValue() : -1);
                }
                if (i >= 0) {
                    return;
                }
                a.a.f(wf.a.a, "HomePreferences", "refresh cur page----2", false, 4, (Object) null);
                if (!H) {
                    qk.p pVar = (qk.p) getMViewBinding();
                    if (pVar != null && (viewPager2 = pVar.s) != null) {
                        viewPager2.setCurrentItem(i, false);
                    }
                    this.mSelectTabIndex = i;
                }
                b1();
                BaseHomeSubFragment k0 = getChildFragmentManager().k0("f" + i);
                if (k0 instanceof BaseHomeSubFragment) {
                    k0.c0();
                    return;
                }
                return;
            }
        }
        homeTabItem = null;
        H = StringsKt.H(homeTabItem != null ? homeTabItem.getTabCode() : null, config.getTabCode(), true);
        if (!H) {
        }
        if (i >= 0) {
        }
    }

    private final void O0(int scrollX) {
        Handler handler;
        if (scrollX != this.lastTopTabScrollX) {
            if (!this.isTopTabScrolling) {
                this.scrollStartSelectIndex = this.mSelectTabIndex;
                this.isTopTabScrolling = true;
            }
            Runnable runnable = this.scrollStopRunnable;
            if (runnable != null && (handler = this.scrollStopHandler) != null) {
                handler.removeCallbacks(runnable);
            }
            this.scrollStopRunnable = new Runnable() { // from class: com.transsion.home.fragment.home.i
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.P0(HomeFragment.this);
                }
            };
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.scrollStopHandler = handler2;
            Runnable runnable2 = this.scrollStopRunnable;
            if (runnable2 != null) {
                handler2.postDelayed(runnable2, 100L);
            }
        } else if (this.isTopTabScrolling) {
            this.isTopTabScrolling = false;
            this.scrollStartSelectIndex = this.mSelectTabIndex;
        }
        this.lastTopTabScrollX = scrollX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(HomeFragment homeFragment) {
        homeFragment.isTopTabScrolling = false;
        String J0 = homeFragment.J0();
        if (J0.length() > 0) {
            homeFragment.a1(J0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(HomeFragment homeFragment, ij.n nVar) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        ViewPager2 viewPager2;
        Intrinsics.h(nVar, "value");
        String a = nVar.a();
        boolean z = a == null || a.length() == 0;
        qk.p pVar = (qk.p) homeFragment.getMViewBinding();
        if (pVar != null && (viewPager2 = pVar.s) != null) {
            viewPager2.setUserInputEnabled(z);
        }
        if (z) {
            HomeSearchViewManager homeSearchViewManager = homeFragment.mHomeSearchViewManager;
            if (homeSearchViewManager != null) {
                homeSearchViewManager.C(homeFragment.appTab);
            }
        } else {
            HomeSearchViewManager homeSearchViewManager2 = homeFragment.mHomeSearchViewManager;
            if (homeSearchViewManager2 != null) {
                homeSearchViewManager2.n();
            }
            HomeSearchViewManager homeSearchViewManager3 = homeFragment.mHomeSearchViewManager;
            if (homeSearchViewManager3 != null) {
                homeSearchViewManager3.C(homeFragment.appTab);
            }
            qk.p pVar2 = (qk.p) homeFragment.getMViewBinding();
            if (pVar2 != null && (appCompatImageView2 = pVar2.i) != null) {
                uf.c.g(appCompatImageView2);
            }
            qk.p pVar3 = (qk.p) homeFragment.getMViewBinding();
            if (pVar3 != null && (appCompatImageView = pVar3.h) != null) {
                uf.c.g(appCompatImageView);
            }
        }
        return Unit.a;
    }

    private final void R0() {
        List<HomeTabItem> homeTabs;
        PreloadTrendingData$a preloadTrendingData$a = PreloadTrendingData.n;
        AppTab appTab = (AppTab) preloadTrendingData$a.a().C().f();
        this.appTab = appTab;
        a.a.f(wf.a.a, "HomeFragment", "homeTabFromCache = " + appTab, false, 4, (Object) null);
        if (this.appTab == null) {
            preloadTrendingData$a.a().C().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.home.fragment.home.p
                public final Object invoke(Object obj) {
                    Unit S0;
                    S0 = HomeFragment.S0(HomeFragment.this, (AppTab) obj);
                    return S0;
                }
            }));
        }
        preloadTrendingData$a.a().D().p(this);
        preloadTrendingData$a.a().D().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.home.fragment.home.q
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = HomeFragment.T0(HomeFragment.this, (AppTab) obj);
                return T0;
            }
        }));
        AppTab appTab2 = this.appTab;
        if (appTab2 != null && (homeTabs = appTab2.getHomeTabs()) != null && (!homeTabs.isEmpty())) {
            initViewPager();
        }
        w1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(HomeFragment homeFragment, AppTab appTab) {
        a.a.f(wf.a.a, "HomeFragment", "homeTabFromCache2 = " + appTab, false, 4, (Object) null);
        if (homeFragment.isAdded()) {
            homeFragment.x1(appTab);
        }
        PreloadTrendingData.n.a().C().p(homeFragment);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(final HomeFragment homeFragment, final AppTab appTab) {
        a.a.f(wf.a.a, "HomeFragment", "LanguageRestart homeTabFromNet2 = " + appTab, false, 4, (Object) null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsion.home.fragment.home.e
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.U0(HomeFragment.this, appTab);
            }
        }, 100L);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(HomeFragment homeFragment, AppTab appTab) {
        if (homeFragment.isAdded()) {
            homeFragment.x1(appTab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(HomeFragment homeFragment, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.e(homePreferencesConfig);
        homeFragment.N0(homePreferencesConfig);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(HomeFragment homeFragment, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.e(homePreferencesConfig);
        homeFragment.m1(homePreferencesConfig);
        return Unit.a;
    }

    private final void X0() {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("mRecyclerView");
            Intrinsics.g(declaredField, "getDeclaredField(...)");
            declaredField.setAccessible(true);
            qk.p pVar = (qk.p) getMViewBinding();
            Object obj = declaredField.get(pVar != null ? pVar.s : null);
            Intrinsics.f(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) obj;
            Field declaredField2 = RecyclerView.class.getDeclaredField("mTouchSlop");
            Intrinsics.g(declaredField2, "getDeclaredField(...)");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(recyclerView);
            Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Int");
            declaredField2.set(recyclerView, Integer.valueOf(((Integer) obj2).intValue() * 2));
            a.a.f(wf.a.a, "invoke", "testOver", false, 4, (Object) null);
        } catch (Exception e2) {
            a.a.f(wf.a.a, "invoke", "Exception " + e2.getMessage(), false, 4, (Object) null);
        }
    }

    private final void Z0() {
        List<HomeTabItem> homeTabs;
        AppTab appTab = this.appTab;
        if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
            return;
        }
        Iterator<HomeTabItem> it = homeTabs.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            HomeTabItem next = it.next();
            if (next != null) {
                Integer tabId = next.getTabId();
                int value = HomeTabId.UGC_Kids_Education.getValue();
                if (tabId != null && tabId.intValue() == value) {
                    break;
                }
            }
            i++;
        }
        if (i < 0) {
            return;
        }
        BaseHomeSubFragment k0 = getChildFragmentManager().k0("f" + i);
        if (k0 instanceof BaseHomeSubFragment) {
            k0.c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(int position, boolean smoothScroll) {
        Object obj;
        ConfigBean c2;
        qk.p pVar;
        MagicIndicator magicIndicator;
        CommonNavigator navigator;
        String value;
        Boolean m1;
        try {
            Result.Companion companion = Result.Companion;
            c2 = cm.f.c.a().c("home_tab_menu_show", true);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (!((c2 == null || (value = c2.getValue()) == null || (m1 = StringsKt.m1(value)) == null) ? false : m1.booleanValue()) || (pVar = (qk.p) getMViewBinding()) == null || (magicIndicator = pVar.k) == null || (navigator = magicIndicator.getNavigator()) == null) {
            return;
        }
        LinearLayout titleContainer = navigator instanceof CommonNavigator ? navigator.getTitleContainer() : navigator instanceof ORCommonNavigator ? ((ORCommonNavigator) navigator).getTitleContainer() : null;
        if (titleContainer != null && position >= 0 && position < titleContainer.getChildCount()) {
            HorizontalScrollView horizontalScrollView = this.cachedScrollView;
            if (horizontalScrollView == null) {
                horizontalScrollView = G0(navigator);
                this.cachedScrollView = horizontalScrollView;
                if (horizontalScrollView == null) {
                    return;
                }
            }
            View childAt = titleContainer.getChildAt(position);
            int left = (childAt.getLeft() + (childAt.getWidth() / 2)) - (horizontalScrollView.getWidth() / 2);
            int e2 = RangesKt.e(titleContainer.getWidth() - horizontalScrollView.getWidth(), 0);
            if (left < 0) {
                left = 0;
            } else if (left > e2) {
                left = e2;
            }
            if (smoothScroll) {
                horizontalScrollView.smoothScrollTo(left, 0);
            } else {
                horizontalScrollView.scrollTo(left, 0);
            }
            obj = Result.constructor-impl(Unit.a);
            Throwable th3 = Result.exceptionOrNull-impl(obj);
            if (th3 != null) {
                a.a.f(wf.a.a, "HomeFragment", "scrollTopTabToPosition: failed to scroll top tab, " + th3.getMessage(), false, 4, (Object) null);
            }
        }
    }

    private final void d1() {
        ConstraintLayout root;
        final int i = this.lastValidPosition;
        qk.p pVar = (qk.p) getMViewBinding();
        if (pVar == null || (root = pVar.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.home.r
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.e1(HomeFragment.this, i);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(HomeFragment homeFragment, int i) {
        ViewPager2 viewPager2;
        MagicIndicator magicIndicator;
        if (homeFragment.isAdded()) {
            qk.p pVar = (qk.p) homeFragment.getMViewBinding();
            if (pVar != null && (magicIndicator = pVar.k) != null) {
                magicIndicator.onPageSelected(i);
            }
            qk.p pVar2 = (qk.p) homeFragment.getMViewBinding();
            if (pVar2 != null && (viewPager2 = pVar2.s) != null) {
                viewPager2.setCurrentItem(i, false);
            }
            homeFragment.isHandlingRedirect = false;
            homeFragment.mSelectTabIndex = i;
            homeFragment.D0(false);
        }
    }

    private final void f1() {
        AppCompatImageButton appCompatImageButton;
        ConstraintLayout constraintLayout;
        X0();
        j1();
        qk.p pVar = (qk.p) getMViewBinding();
        if (pVar != null && (constraintLayout = pVar.e) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.i1(HomeFragment.this, view);
                }
            });
        }
        qk.p pVar2 = (qk.p) getMViewBinding();
        if (pVar2 == null || (appCompatImageButton = pVar2.b) == null) {
            return;
        }
        appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.g1(HomeFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(final HomeFragment homeFragment, View view) {
        Object obj;
        ViewPager2 viewPager2;
        com.transsion.baselib.helper.a.a.n(homeFragment.J0(), "home_top_tab_more_menu");
        a.a.f(wf.a.a, "HomeFragment", "Menu button clicked, showing category discover dialog", false, 4, (Object) null);
        try {
            Result.Companion companion = Result.Companion;
            CategoryDiscoverDialog a = CategoryDiscoverDialog.INSTANCE.a();
            AppTab appTab = homeFragment.appTab;
            a.s0(appTab != null ? appTab.getHomeTabs() : null);
            qk.p pVar = (qk.p) homeFragment.getMViewBinding();
            a.r0((pVar == null || (viewPager2 = pVar.s) == null) ? 0 : viewPager2.getCurrentItem());
            a.q0(new Function1() { // from class: com.transsion.home.fragment.home.f
                public final Object invoke(Object obj2) {
                    Unit h1;
                    h1 = HomeFragment.h1(HomeFragment.this, (HomeTabItem) obj2);
                    return h1;
                }
            });
            a.l0(homeFragment, "category_discover");
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_name", "home_switch_tab");
            qi.h.a.q(homeFragment.J0(), "dialog_show", hashMap);
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            a.a.f(wf.a.a, "HomeFragment", "Failed to show category discover dialog: " + th3.getMessage(), false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(HomeFragment homeFragment, HomeTabItem homeTabItem) {
        a.a.f(wf.a.a, "HomeFragment", "Selected category: " + homeTabItem, false, 4, (Object) null);
        homeFragment.M0(homeTabItem);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(HomeFragment homeFragment, View view) {
        homeFragment.p1();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "grade_select");
        com.transsion.baselib.helper.a.a.i(homeFragment.J0(), linkedHashMap);
    }

    private final void initViewPager() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        if (isAdded()) {
            qk.p pVar = (qk.p) getMViewBinding();
            if (pVar != null && (viewPager22 = pVar.s) != null) {
                viewPager22.setUserInputEnabled(!ij.o.a.i());
            }
            a.a.f(wf.a.a, "HomeFragment", "fragment count " + getChildFragmentManager().y0().size(), false, 4, (Object) null);
            qk.p pVar2 = (qk.p) getMViewBinding();
            if (pVar2 != null && (viewPager2 = pVar2.s) != null) {
                viewPager2.setAdapter(new d());
            }
            B0();
        }
    }

    private final void j1() {
        setNetListener(new f());
    }

    private final void k1() {
        MagicIndicator magicIndicator;
        vy.a navigator;
        qk.p pVar = (qk.p) getMViewBinding();
        if (pVar == null || (magicIndicator = pVar.k) == null || (navigator = magicIndicator.getNavigator()) == null) {
            return;
        }
        final HorizontalScrollView G0 = G0(navigator);
        this.cachedScrollView = G0;
        if (G0 == null) {
            a.a.f(wf.a.a, "HomeFragment", "setupTopTabScrollListener: scrollView is null, cannot setup scroll listener", false, 4, (Object) null);
            return;
        }
        this.lastTopTabScrollX = G0.getScrollX();
        this.scrollStartSelectIndex = this.mSelectTabIndex;
        G0.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.transsion.home.fragment.home.h
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                HomeFragment.l1(G0, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(HorizontalScrollView horizontalScrollView, HomeFragment homeFragment) {
        homeFragment.O0(horizontalScrollView.getScrollX());
    }

    private final void m1(final HomePreferencesConfig config) {
        Object obj;
        FragmentActivity activity = getActivity();
        if (activity == null || !activity.isDestroyed()) {
            FragmentActivity activity2 = getActivity();
            if (activity2 == null || !activity2.isFinishing()) {
                try {
                    Result.Companion companion = Result.Companion;
                    HomePreferencesEnterPopDialog a = HomePreferencesEnterPopDialog.INSTANCE.a();
                    a.t0(config);
                    zk.c.a.n(config);
                    F0().D(config);
                    a.u0(new Function1() { // from class: com.transsion.home.fragment.home.n
                        public final Object invoke(Object obj2) {
                            Unit n1;
                            n1 = HomeFragment.n1(HomeFragment.this, config, (List) obj2);
                            return n1;
                        }
                    });
                    a.v0(new Function0() { // from class: com.transsion.home.fragment.home.o
                        public final Object invoke() {
                            Unit o1;
                            o1 = HomeFragment.o1(HomeFragment.this, config);
                            return o1;
                        }
                    });
                    a.l0(this, "HomePreferencesEnterPopDialog");
                    obj = Result.constructor-impl(Unit.a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.a(th2));
                }
                Throwable th3 = Result.exceptionOrNull-impl(obj);
                if (th3 != null) {
                    a.a.l(wf.a.a, "HomeFragment", "showEnterPopDialog error: " + th3.getMessage(), false, 4, (Object) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(HomeFragment homeFragment, HomePreferencesConfig homePreferencesConfig, List list) {
        Intrinsics.h(list, "selected");
        homeFragment.F0().B(homePreferencesConfig);
        homeFragment.F0().L(homePreferencesConfig, list);
        zk.c.a.m(homePreferencesConfig, list);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(HomeFragment homeFragment, HomePreferencesConfig homePreferencesConfig) {
        homeFragment.F0().C(homePreferencesConfig);
        zk.c.a.o(homePreferencesConfig);
        return Unit.a;
    }

    private final void p1() {
        List<GradeGroup> arrayList;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity.isDestroyed() || activity.isFinishing()) {
                activity = null;
            }
            if (activity == null) {
                return;
            }
            GradeSelectDialog gradeSelectDialog = new GradeSelectDialog();
            AppTab appTab = this.appTab;
            if (appTab == null || (arrayList = appTab.getHomeGradeList()) == null) {
                arrayList = new ArrayList<>();
            }
            gradeSelectDialog.x0(arrayList, J0());
            gradeSelectDialog.z0(ij.o.a.e());
            gradeSelectDialog.y0(new Function1() { // from class: com.transsion.home.fragment.home.c
                public final Object invoke(Object obj) {
                    Unit q1;
                    q1 = HomeFragment.q1(HomeFragment.this, (GradeItem) obj);
                    return q1;
                }
            });
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
            gradeSelectDialog.show(supportFragmentManager, "GradeSelectDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(HomeFragment homeFragment, GradeItem gradeItem) {
        String str;
        String str2;
        TnTextView tnTextView;
        String name;
        String str3 = BuildConfig.FLAVOR;
        if (gradeItem == null || (str = gradeItem.getName()) == null) {
            str = BuildConfig.FLAVOR;
        }
        if (gradeItem == null || (str2 = gradeItem.getGrade()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        ij.o oVar = ij.o.a;
        oVar.m(str);
        oVar.l(str2);
        zk.e eVar = zk.e.a;
        eVar.b().putString("selected_grade_name", str);
        eVar.b().putString("selected_grade", str2);
        qk.p pVar = (qk.p) homeFragment.getMViewBinding();
        if (pVar != null && (tnTextView = pVar.o) != null) {
            if (gradeItem != null && (name = gradeItem.getName()) != null) {
                str3 = name;
            }
            tnTextView.setText(str3);
        }
        a.a.f(wf.a.a, "HomeFragment", "Grade selected: " + (gradeItem != null ? gradeItem.getName() : null) + ", saved: " + str, false, 4, (Object) null);
        homeFragment.Z0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(String value) {
        qk.p pVar;
        AppCompatImageButton appCompatImageButton;
        AppCompatImageButton appCompatImageButton2;
        Boolean m1;
        boolean booleanValue = (value == null || (m1 = StringsKt.m1(value)) == null) ? false : m1.booleanValue();
        qk.p pVar2 = (qk.p) getMViewBinding();
        if (pVar2 != null && (appCompatImageButton2 = pVar2.b) != null) {
            appCompatImageButton2.setVisibility(booleanValue ? 0 : 8);
        }
        a.a.f(wf.a.a, "HomeFragment", "Menu button visibility: " + booleanValue, false, 4, (Object) null);
        if (!booleanValue || (pVar = (qk.p) getMViewBinding()) == null || (appCompatImageButton = pVar.b) == null) {
            return;
        }
        appCompatImageButton.post(new Runnable() { // from class: com.transsion.home.fragment.home.d
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.s1(HomeFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(HomeFragment homeFragment) {
        com.transsion.baselib.helper.a.a.m(homeFragment.J0(), CollectionsKt.e("home_top_tab_more_menu"), false);
    }

    private final void w1() {
        ConfigBean c2 = cm.f.c.a().c("home_tab_menu_show", true);
        String value = c2 != null ? c2.getValue() : null;
        r1(value);
        if (value == null || value.length() == 0) {
            kotlinx.coroutines.i.d(androidx.lifecycle.v.a(this), (CoroutineContext) null, (CoroutineStart) null, new HomeFragment$updateMenuButtonVisibility$1(this, null), 3, (Object) null);
        }
    }

    private final void x1(AppTab appTab) {
        List<HomeTabItem> homeTabs;
        List<HomeTabItem> homeTabs2;
        HomeTabItem homeTabItem;
        HomeTabItem homeTabItem2;
        if (appTab != null) {
            List<HomeTabItem> homeTabs3 = appTab.getHomeTabs();
            if ((homeTabs3 != null ? homeTabs3.size() : 0) > 0) {
                String version = appTab.getVersion();
                AppTab appTab2 = this.appTab;
                if (Intrinsics.c(version, appTab2 != null ? appTab2.getVersion() : null)) {
                    List<HomeTabItem> homeTabs4 = appTab.getHomeTabs();
                    String name = (homeTabs4 == null || (homeTabItem2 = homeTabs4.get(0)) == null) ? null : homeTabItem2.getName();
                    AppTab appTab3 = this.appTab;
                    if (Intrinsics.c(name, (appTab3 == null || (homeTabs2 = appTab3.getHomeTabs()) == null || (homeTabItem = homeTabs2.get(0)) == null) ? null : homeTabItem.getName())) {
                        List<HomeTabItem> homeTabs5 = appTab.getHomeTabs();
                        Integer valueOf = homeTabs5 != null ? Integer.valueOf(homeTabs5.size()) : null;
                        AppTab appTab4 = this.appTab;
                        if (Intrinsics.c(valueOf, (appTab4 == null || (homeTabs = appTab4.getHomeTabs()) == null) ? null : Integer.valueOf(homeTabs.size()))) {
                            return;
                        }
                    }
                }
                this.appTab = appTab;
                this.trendingFragment = null;
                initViewPager();
                HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
                if (homeSearchViewManager != null) {
                    homeSearchViewManager.O(appTab);
                }
            }
        }
    }

    public final void D0(boolean isWhite) {
        BaseActivity activity = getActivity();
        BaseActivity baseActivity = activity instanceof BaseActivity ? activity : null;
        if (baseActivity != null) {
            baseActivity.changeStatusFontColor(isWhite, true);
        }
        HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.l(isWhite);
        }
    }

    /* renamed from: I0, reason: from getter */
    public final int getMSelectTabIndex() {
        return this.mSelectTabIndex;
    }

    public final String J0() {
        HomeTabItem homeTabItem;
        String tabCode;
        AppTab appTab = this.appTab;
        List<HomeTabItem> homeTabs = appTab != null ? appTab.getHomeTabs() : null;
        int i = this.mSelectTabIndex;
        if (i >= 0) {
            return (i >= (homeTabs != null ? homeTabs.size() : 0) || homeTabs == null || (homeTabItem = homeTabs.get(this.mSelectTabIndex)) == null || (tabCode = homeTabItem.getTabCode()) == null) ? BuildConfig.FLAVOR : tabCode;
        }
        return BuildConfig.FLAVOR;
    }

    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public qk.p getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        qk.p c2 = qk.p.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public final boolean Y0() {
        WebFragmentV2 k0 = getChildFragmentManager().k0("f" + this.mSelectTabIndex);
        return (k0 instanceof WebFragmentV2) && k0.h1();
    }

    public final void a1(String pageTabName, boolean isRefresh) {
        Intrinsics.h(pageTabName, "pageTabName");
        com.transsion.baselib.helper.a.a.m(pageTabName, L0(), isRefresh);
    }

    public final void b1() {
        BaseHomeSubFragment k0 = getChildFragmentManager().k0("f" + this.mSelectTabIndex);
        if (k0 instanceof BaseHomeSubFragment) {
            k0.p0();
        }
    }

    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        DownloadSDCardUtil.a.c();
        cw.b.a.c().d();
        Function1 function1 = new Function1() { // from class: com.transsion.home.fragment.home.b
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = HomeFragment.Q0(HomeFragment.this, (ij.n) obj);
                return Q0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = ij.n.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    public void initView(View view, Bundle savedInstanceState) {
        qk.p pVar;
        BlurredSectorView blurredSectorView;
        Intrinsics.h(view, "view");
        androidx.lifecycle.v.a(this);
        this.mSavedInstanceState = savedInstanceState;
        R0();
        f1();
        qk.p pVar2 = (qk.p) getMViewBinding();
        if (pVar2 != null) {
            HomeSearchViewManager homeSearchViewManager = new HomeSearchViewManager(pVar2, this);
            this.mHomeSearchViewManager = homeSearchViewManager;
            homeSearchViewManager.C(this.appTab);
        }
        zk.e eVar = zk.e.a;
        String string = eVar.b().getString("selected_grade_name", "All");
        if (string != null && string.length() != 0) {
            ij.o.a.m(string);
        }
        String string2 = eVar.b().getString("selected_grade", "UN_GRADE");
        if (string2 != null && string2.length() != 0) {
            ij.o.a.l(string2);
        }
        v1();
        if (Build.VERSION.SDK_INT <= 23 && (pVar = (qk.p) getMViewBinding()) != null && (blurredSectorView = pVar.n) != null) {
            blurredSectorView.setVisibility(8);
        }
        if (ij.o.a.i()) {
            return;
        }
        F0().A();
        F0().x().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.home.fragment.home.j
            public final Object invoke(Object obj) {
                Unit V0;
                V0 = HomeFragment.V0(HomeFragment.this, (HomePreferencesConfig) obj);
                return V0;
            }
        }));
        F0().s().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.home.fragment.home.k
            public final Object invoke(Object obj) {
                Unit W0;
                W0 = HomeFragment.W0(HomeFragment.this, (HomePreferencesConfig) obj);
                return W0;
            }
        }));
    }

    public void lazyLoadData() {
    }

    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            com.transsion.baselib.report.e.a.n("home", Long.valueOf(SystemClock.elapsedRealtime() - this.resumeTimeStamp), getContext());
        }
    }

    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:3:0x0003, B:6:0x000b, B:11:0x001b, B:12:0x0021, B:14:0x002f, B:16:0x0033, B:23:0x003b, B:24:0x0041), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void newIntent(Intent intent) {
        String str;
        qk.p pVar;
        ViewPager2 viewPager2;
        super.newIntent(intent);
        try {
            if (!isAdded()) {
                setArguments(intent != null ? intent.getExtras() : null);
                return;
            }
            if (intent != null) {
                str = intent.getStringExtra("topTab");
                if (str == null) {
                }
                this.mSelectTabIndex = H0(str, intent != null ? intent.getIntExtra("secondTabIndex", -1) : -1);
                pVar = (qk.p) getMViewBinding();
                if (pVar != null || (viewPager2 = pVar.s) == null) {
                }
                viewPager2.setCurrentItem(this.mSelectTabIndex);
                return;
            }
            str = "Trending";
            this.mSelectTabIndex = H0(str, intent != null ? intent.getIntExtra("secondTabIndex", -1) : -1);
            pVar = (qk.p) getMViewBinding();
            if (pVar != null) {
            }
        } catch (Exception e2) {
            a.a.f(wf.a.a, "HomeFragment", "error= " + e2.getMessage(), false, 4, (Object) null);
        }
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        DownloadSDCardUtil.a.e();
        PreloadTrendingData.n.a().D().p(this);
        HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.L();
        }
        HomeSearchViewManager homeSearchViewManager2 = this.mHomeSearchViewManager;
        if (homeSearchViewManager2 != null) {
            homeSearchViewManager2.n();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.trendingFragment = null;
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
                HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
                if (homeSearchViewManager != null) {
                    homeSearchViewManager.L();
                }
            } else {
                logResume();
                HomeSearchViewManager homeSearchViewManager2 = this.mHomeSearchViewManager;
                if (homeSearchViewManager2 != null) {
                    homeSearchViewManager2.M(true);
                }
                HomeSearchViewManager homeSearchViewManager3 = this.mHomeSearchViewManager;
                if (homeSearchViewManager3 != null) {
                    homeSearchViewManager3.G();
                }
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.k.l(null, this, null, 5, null);
        wf.a.a.d("onPause fragment count " + getChildFragmentManager().y0().size(), true);
        HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.L();
        }
        if (this.isHandlingRedirect) {
            d1();
        }
    }

    public void onResume() {
        super.onResume();
        com.transsion.baseui.activity.k.p(null, this, "visible=" + isVisible() + " fragment:" + this, 1, null);
        HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.M(true);
        }
        Bundle bundle = this.mSavedInstanceState;
        Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt("saved_search_color", 2)) : null;
        if ((valueOf != null && valueOf.intValue() == 0) || (valueOf != null && valueOf.intValue() == 1)) {
            BaseHomeSubFragment k0 = getChildFragmentManager().k0("f" + this.mSelectTabIndex);
            if (k0 instanceof BaseHomeSubFragment) {
                k0.b0(valueOf != null && valueOf.intValue() == 1);
            } else {
                D0(valueOf != null && valueOf.intValue() == 1);
            }
            this.mSavedInstanceState = null;
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(outState);
        outState.putInt("current_tab", this.mSelectTabIndex);
        HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
        int i = 0;
        if (homeSearchViewManager != null && homeSearchViewManager.D()) {
            i = 1;
        }
        outState.putInt("saved_search_color", i);
    }

    public final void t1(String tabCode, int tabId) {
        ViewPager2 viewPager2;
        Intrinsics.h(tabCode, "tabCode");
        int H0 = H0(tabCode, tabId);
        qk.p pVar = (qk.p) getMViewBinding();
        if (pVar == null || (viewPager2 = pVar.s) == null) {
            return;
        }
        viewPager2.setCurrentItem(H0, false);
    }

    public final void u1() {
        ViewPager2 viewPager2;
        TrendingFragment trendingFragment = this.trendingFragment;
        if (trendingFragment instanceof TrendingFragment) {
            Intrinsics.f(trendingFragment, "null cannot be cast to non-null type com.transsion.home.fragment.tab.TrendingFragment");
            trendingFragment.f2();
        } else if (trendingFragment instanceof TrendingUGCFragment) {
            Intrinsics.f(trendingFragment, "null cannot be cast to non-null type com.transsion.home.fragment.tab.TrendingUGCFragment");
            ((TrendingUGCFragment) trendingFragment).t1();
        }
        qk.p pVar = (qk.p) getMViewBinding();
        if (pVar == null || (viewPager2 = pVar.s) == null) {
            return;
        }
        viewPager2.setCurrentItem(r, false);
    }

    public final void v1() {
        qk.p pVar;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView;
        ConstraintLayout constraintLayout;
        List<HomeTabItem> homeTabs;
        AppTab appTab = this.appTab;
        HomeTabItem homeTabItem = (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) ? null : (HomeTabItem) CollectionsKt.l0(homeTabs, this.mSelectTabIndex);
        boolean h = HomeTabId.INSTANCE.h(homeTabItem != null ? homeTabItem.getTabId() : null, false);
        ij.o oVar = ij.o.a;
        boolean z = oVar.i() && h;
        qk.p pVar2 = (qk.p) getMViewBinding();
        if (pVar2 != null && (constraintLayout = pVar2.e) != null) {
            constraintLayout.setVisibility(z ? 0 : 8);
        }
        qk.p pVar3 = (qk.p) getMViewBinding();
        if (pVar3 != null && (appCompatImageView = pVar3.g) != null) {
            appCompatImageView.setVisibility(z ? 8 : 0);
        }
        if (!z || (pVar = (qk.p) getMViewBinding()) == null || (tnTextView = pVar.o) == null) {
            return;
        }
        tnTextView.setText(oVar.f());
    }
}
