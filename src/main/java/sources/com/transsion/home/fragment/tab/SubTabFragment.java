package com.transsion.home.fragment.tab;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.activity.OperateActivity;
import com.transsion.home.adapter.suboperate.SubTabAdapter;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.SubOperateData;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.home.fragment.bottom.BottomOpFragment;
import com.transsion.home.fragment.home.HomeFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.home.viewmodel.HomePreferencesViewModel;
import com.transsion.home.viewmodel.SubTabViewModel;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import wf.a;
import yg.m;

@Metadata(d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\b\u0007*\u0001e\b\u0007\u0018\u0000 i2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\u0004J!\u0010%\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b%\u0010#J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\r\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020-H\u0016¢\u0006\u0004\b0\u0010/J\u000f\u00101\u001a\u00020\u0005H\u0016¢\u0006\u0004\b1\u0010\u0004J\u0011\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b3\u00104J\u001f\u00108\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR$\u0010R\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u0005\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR$\u0010W\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0T\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010JR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010b\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010JR,\u0010d\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00050O\u0012\u0004\u0012\u00020\u00050O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010QR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006k"}, d2 = {"Lcom/transsion/home/fragment/tab/SubTabFragment;", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "Lqk/w;", "<init>", "()V", BuildConfig.FLAVOR, "m0", BuildConfig.FLAVOR, "U0", "()I", "n1", "f1", "Q0", BuildConfig.FLAVOR, "alpha", "q1", "(F)V", "T0", "()F", "l1", "r1", "Landroid/view/View;", "getNoNetworkView", "()Landroid/view/View;", "R0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Y0", "(Landroid/view/LayoutInflater;)Lqk/w;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "p0", "initData", "onResume", "startLoading", "hideLoading", "lazyLoadData", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "g0", "c0", "Landroidx/recyclerview/widget/RecyclerView;", "f0", "()Landroidx/recyclerview/widget/RecyclerView;", "lastAdPosition", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "wrapperNativeManager", "l0", "(ILcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "Lcom/transsion/home/viewmodel/SubTabViewModel;", "g", "Lcom/transsion/home/viewmodel/SubTabViewModel;", "mViewModel", "Lcom/transsion/home/adapter/suboperate/SubTabAdapter;", "h", "Lcom/transsion/home/adapter/suboperate/SubTabAdapter;", "mMainAdapter", "Lcom/transsion/home/viewmodel/HomePreferencesViewModel;", "i", "Lkotlin/Lazy;", "V0", "()Lcom/transsion/home/viewmodel/HomePreferencesViewModel;", "homePreferencesViewModel", BuildConfig.FLAVOR, "j", "Z", "mHasTranslateWindow", "k", "I", "mHeaderBgHeight", "Lkotlin/Function1;", "l", "Lkotlin/jvm/functions/Function1;", "mPermissionCallback", "Landroidx/activity/result/b;", BuildConfig.FLAVOR, "m", "Landroidx/activity/result/b;", "mLauncher", "n", "mIsFirstRender", BuildConfig.FLAVOR, "o", "J", "loadStartTime", "p", "Landroid/view/View;", "mNoNetworkView", "q", "isUGCMode", "r", "mOnAppointmentClick", "com/transsion/home/fragment/tab/SubTabFragment$d", "s", "Lcom/transsion/home/fragment/tab/SubTabFragment$d;", "mRecycleScrollListener", "t", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubTabFragment extends BaseHomeSubFragment<qk.w> {

    /* renamed from: t, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int u = 8;
    private static final Map v;

    /* renamed from: g, reason: from kotlin metadata */
    private SubTabViewModel mViewModel;

    /* renamed from: h, reason: from kotlin metadata */
    private SubTabAdapter mMainAdapter;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean mHasTranslateWindow;

    /* renamed from: k, reason: from kotlin metadata */
    private int mHeaderBgHeight;

    /* renamed from: l, reason: from kotlin metadata */
    private Function1 mPermissionCallback;

    /* renamed from: m, reason: from kotlin metadata */
    private androidx.activity.result.b mLauncher;

    /* renamed from: p, reason: from kotlin metadata */
    private View mNoNetworkView;

    /* renamed from: i, reason: from kotlin metadata */
    private final Lazy homePreferencesViewModel = LazyKt.b(new Function0() { // from class: com.transsion.home.fragment.tab.l0
        public final Object invoke() {
            HomePreferencesViewModel Z0;
            Z0 = SubTabFragment.Z0(SubTabFragment.this);
            return Z0;
        }
    });

    /* renamed from: n, reason: from kotlin metadata */
    private boolean mIsFirstRender = true;

    /* renamed from: o, reason: from kotlin metadata */
    private long loadStartTime = -1;

    /* renamed from: q, reason: from kotlin metadata */
    private final boolean isUGCMode = ij.g.a.b();

    /* renamed from: r, reason: from kotlin metadata */
    private final Function1 mOnAppointmentClick = new Function1() { // from class: com.transsion.home.fragment.tab.m0
        public final Object invoke(Object obj) {
            Unit m1;
            m1 = SubTabFragment.m1(SubTabFragment.this, (Function1) obj);
            return m1;
        }
    };

    /* renamed from: s, reason: from kotlin metadata */
    private final d mRecycleScrollListener = new d();

    /* renamed from: com.transsion.home.fragment.tab.SubTabFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int i) {
            String str = (String) SubTabFragment.v.get(Integer.valueOf(i));
            return str == null ? "home_sub_operate" : str;
        }

        public final SubTabFragment b(int i, String str) {
            if (!SubTabFragment.v.containsKey(Integer.valueOf(i)) && str != null) {
                SubTabFragment.v.put(Integer.valueOf(i), str);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i);
            bundle.putString("tab_code", str);
            SubTabFragment subTabFragment = new SubTabFragment();
            subTabFragment.setArguments(bundle);
            return subTabFragment;
        }
    }

    public static final class b extends DiffUtil.e {
        b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(OperateItem operateItem, OperateItem operateItem2) {
            Intrinsics.h(operateItem, "oldItem");
            Intrinsics.h(operateItem2, "newItem");
            Subject feedsSubject = operateItem.getFeedsSubject();
            String subjectId = feedsSubject != null ? feedsSubject.getSubjectId() : null;
            Subject feedsSubject2 = operateItem2.getFeedsSubject();
            return Intrinsics.c(subjectId, feedsSubject2 != null ? feedsSubject2.getSubjectId() : null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(OperateItem operateItem, OperateItem operateItem2) {
            Intrinsics.h(operateItem, "oldItem");
            Intrinsics.h(operateItem2, "newItem");
            Subject feedsSubject = operateItem.getFeedsSubject();
            Integer subjectType = feedsSubject != null ? feedsSubject.getSubjectType() : null;
            Subject feedsSubject2 = operateItem2.getFeedsSubject();
            return Intrinsics.c(subjectType, feedsSubject2 != null ? feedsSubject2.getSubjectType() : null);
        }
    }

    public static final class c extends GridLayoutManager.c {
        final /* synthetic */ int f;

        c(int i) {
            this.f = i;
        }

        public int f(int i) {
            SubTabAdapter subTabAdapter = SubTabFragment.this.mMainAdapter;
            Integer valueOf = subTabAdapter != null ? Integer.valueOf(subTabAdapter.getItemViewType(i)) : null;
            int ordinal = PostItemType.PREFERENCES.ordinal();
            if (valueOf != null && valueOf.intValue() == ordinal) {
                return this.f;
            }
            int ordinal2 = PostItemType.SUBJECT.ordinal();
            if (valueOf == null || valueOf.intValue() != ordinal2) {
                int ordinal3 = PostItemType.SINGLE_SUBJECT.ordinal();
                if (valueOf == null || valueOf.intValue() != ordinal3) {
                    int ordinal4 = PostItemType.TRENDING_FEES_GRID.ordinal();
                    if (valueOf == null || valueOf.intValue() != ordinal4) {
                        return this.f;
                    }
                }
            }
            return 1;
        }
    }

    public static final class d extends RecyclerView.r {
        d() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.h(recyclerView, "recyclerView");
            if (SubTabFragment.this.mHasTranslateWindow) {
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                SubTabFragment.this.q1(RangesKt.g((computeVerticalScrollOffset * 1.0f) / r3.mHeaderBgHeight, 1.0f));
                if (!SubTabFragment.this.getMIsWhite() && SubTabFragment.this.T0() < 0.7f) {
                    SubTabFragment.this.b0(true);
                } else {
                    if (!SubTabFragment.this.getMIsWhite() || SubTabFragment.this.T0() < 0.7f) {
                        return;
                    }
                    SubTabFragment.this.b0(false);
                }
            }
        }
    }

    public static final class e implements yg.m {
        e() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            SubTabAdapter subTabAdapter;
            List data;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (SubTabFragment.this.isResumed() && (subTabAdapter = SubTabFragment.this.mMainAdapter) != null && (data = subTabAdapter.getData()) != null && data.isEmpty()) {
                SubTabFragment.this.l1();
            }
        }

        public void onDisconnected() {
        }
    }

    static final class f implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        f(Function1 function1) {
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

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(HomeTabId.Trending.getValue()), "Trending");
        linkedHashMap.put(Integer.valueOf(HomeTabId.UGC_Trending.getValue()), "UgcTrending");
        v = linkedHashMap;
    }

    private final void Q0() {
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout2;
        Guideline guideline;
        View view;
        SwipeRefreshLayout swipeRefreshLayout3;
        RecyclerView recyclerView2;
        SwipeRefreshLayout swipeRefreshLayout4;
        Guideline guideline2;
        Guideline guideline3;
        qk.w wVar = (qk.w) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (wVar == null || (guideline3 = wVar.d) == null) ? null : guideline3.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
        if (this.mHasTranslateWindow) {
            ((ConstraintLayout.b) layoutParams2).a = 0;
            qk.w wVar2 = (qk.w) getMViewBinding();
            if (wVar2 != null && (guideline2 = wVar2.d) != null) {
                guideline2.setLayoutParams(layoutParams2);
            }
            qk.w wVar3 = (qk.w) getMViewBinding();
            if (wVar3 != null && (swipeRefreshLayout4 = wVar3.f) != null) {
                swipeRefreshLayout4.invalidate();
            }
            q1(0.0f);
            b0(true);
            qk.w wVar4 = (qk.w) getMViewBinding();
            if (wVar4 != null && (recyclerView2 = wVar4.e) != null) {
                recyclerView2.addOnScrollListener(this.mRecycleScrollListener);
            }
            qk.w wVar5 = (qk.w) getMViewBinding();
            if (wVar5 == null || (swipeRefreshLayout3 = wVar5.f) == null) {
                return;
            }
            int i = this.mHeaderBgHeight;
            swipeRefreshLayout3.setProgressViewOffset(false, i, com.blankj.utilcode.util.a0.a(50.0f) + i);
            return;
        }
        qk.w wVar6 = (qk.w) getMViewBinding();
        int height = (wVar6 == null || (view = wVar6.b) == null) ? 0 : view.getHeight();
        if (height <= 0) {
            height = this.mHeaderBgHeight;
        }
        ((ConstraintLayout.b) layoutParams2).a = height;
        qk.w wVar7 = (qk.w) getMViewBinding();
        if (wVar7 != null && (guideline = wVar7.d) != null) {
            guideline.setLayoutParams(layoutParams2);
        }
        qk.w wVar8 = (qk.w) getMViewBinding();
        if (wVar8 != null && (swipeRefreshLayout2 = wVar8.f) != null) {
            swipeRefreshLayout2.invalidate();
        }
        q1(1.0f);
        b0(false);
        qk.w wVar9 = (qk.w) getMViewBinding();
        if (wVar9 != null && (recyclerView = wVar9.e) != null) {
            recyclerView.removeOnScrollListener(this.mRecycleScrollListener);
        }
        qk.w wVar10 = (qk.w) getMViewBinding();
        if (wVar10 == null || (swipeRefreshLayout = wVar10.f) == null) {
            return;
        }
        swipeRefreshLayout.setProgressViewOffset(false, 0, com.blankj.utilcode.util.a0.a(50.0f));
    }

    private final View R0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        stateView.showData(3, 1, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        stateView.retry(new Function0() { // from class: com.transsion.home.fragment.tab.e0
            public final Object invoke() {
                Unit S0;
                S0 = SubTabFragment.S0(SubTabFragment.this);
                return S0;
            }
        });
        return stateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(SubTabFragment subTabFragment) {
        subTabFragment.l1();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float T0() {
        View view;
        qk.w wVar = (qk.w) getMViewBinding();
        if (wVar == null || (view = wVar.b) == null) {
            return 0.0f;
        }
        return view.getAlpha();
    }

    private final int U0() {
        View view;
        View view2;
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof HomeFragment) {
            return h0();
        }
        if (parentFragment instanceof BottomOpFragment) {
            BottomOpFragment parentFragment2 = getParentFragment();
            Intrinsics.f(parentFragment2, "null cannot be cast to non-null type com.transsion.home.fragment.bottom.BottomOpFragment");
            return parentFragment2.c0();
        }
        if (!(getActivity() instanceof OperateActivity)) {
            qk.w wVar = (qk.w) getMViewBinding();
            if (wVar != null && (view = wVar.b) != null) {
                uf.c.h(view);
            }
            return 1;
        }
        int color = androidx.core.content.b.getColor(requireContext(), R.color.bg_02);
        qk.w wVar2 = (qk.w) getMViewBinding();
        if (wVar2 != null && (view2 = wVar2.b) != null) {
            view2.setBackgroundColor(color);
        }
        OperateActivity activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type com.transsion.home.activity.OperateActivity");
        return activity.b0();
    }

    private final HomePreferencesViewModel V0() {
        return (HomePreferencesViewModel) this.homePreferencesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(NoNetworkBigView noNetworkBigView, SubTabFragment subTabFragment) {
        uf.c.g(noNetworkBigView);
        subTabFragment.l1();
        com.tn.lib.view.o.b(subTabFragment.getPageName());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(SubTabFragment subTabFragment) {
        com.tn.lib.view.o.c(subTabFragment.getPageName());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomePreferencesViewModel Z0(SubTabFragment subTabFragment) {
        Fragment requireParentFragment = subTabFragment.requireParentFragment();
        Intrinsics.g(requireParentFragment, "requireParentFragment(...)");
        return (HomePreferencesViewModel) new androidx.lifecycle.v0(requireParentFragment).a(HomePreferencesViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(SubTabFragment subTabFragment, SubOperateData subOperateData) {
        List arrayList;
        List<OperateItem> items;
        t6.f h0;
        SwipeRefreshLayout swipeRefreshLayout;
        qk.w wVar = (qk.w) subTabFragment.getMViewBinding();
        if (wVar != null && (swipeRefreshLayout = wVar.f) != null) {
            swipeRefreshLayout.setEnabled(true);
        }
        SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
        if (subTabAdapter != null && (h0 = subTabAdapter.h0()) != null) {
            h0.z(true);
        }
        if (subOperateData == null || (items = subOperateData.getItems()) == null || (arrayList = CollectionsKt.U0(items)) == null) {
            arrayList = new ArrayList();
        }
        zk.h.c(arrayList, subOperateData != null ? subOperateData.getOps() : null);
        HomePreferencesUiHelperKt.f(subTabFragment.getMTabCode(), subTabFragment.V0(), arrayList);
        SubTabAdapter subTabAdapter2 = subTabFragment.mMainAdapter;
        if (subTabAdapter2 != null) {
            subTabAdapter2.n1(arrayList);
        }
        String value = PostItemType.BANNER.getValue();
        OperateItem operateItem = (OperateItem) CollectionsKt.l0(arrayList, 0);
        subTabFragment.mHasTranslateWindow = Intrinsics.c(value, operateItem != null ? operateItem.getType() : null);
        if (subTabFragment.mIsFirstRender) {
            subTabFragment.Q0();
            subTabFragment.mIsFirstRender = false;
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(SubTabFragment subTabFragment, Function1 function1, SubOperateData subOperateData) {
        HashMap g;
        List<OperateItem> items;
        subTabFragment.hideLoading();
        boolean z = false;
        if (((subOperateData == null || (items = subOperateData.getItems()) == null) ? 0 : items.size()) <= 0) {
            subTabFragment.r1();
            return Unit.a;
        }
        qi.b logViewConfig = subTabFragment.getLogViewConfig();
        if (logViewConfig != null && !logViewConfig.i()) {
            z = true;
        }
        if (z) {
            qi.b logViewConfig2 = subTabFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.k(true);
            }
            qi.b logViewConfig3 = subTabFragment.getLogViewConfig();
            if (logViewConfig3 != null && (g = logViewConfig3.g()) != null) {
            }
        }
        function1.invoke(subOperateData);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(SubTabFragment subTabFragment, Function1 function1, SubOperateData subOperateData) {
        List<OperateItem> items;
        subTabFragment.hideLoading();
        if (((subOperateData == null || (items = subOperateData.getItems()) == null) ? 0 : items.size()) > 0) {
            subTabFragment.n0();
            function1.invoke(subOperateData);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(final SubTabFragment subTabFragment, TrendingRespData trendingRespData) {
        t6.f h0;
        t6.f h02;
        Pager pager;
        ConstraintLayout root;
        List<OperateItem> transferData;
        List<TrendingRespItem> items;
        if (((trendingRespData == null || (items = trendingRespData.getItems()) == null) ? 0 : items.size()) > 0) {
            SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
            if (subTabAdapter != null) {
                subTabAdapter.q((trendingRespData == null || (transferData = trendingRespData.getTransferData()) == null) ? new ArrayList() : transferData);
            }
            qk.w wVar = (qk.w) subTabFragment.getMViewBinding();
            if (wVar != null && (root = wVar.getRoot()) != null) {
                root.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SubTabFragment.e1(SubTabFragment.this);
                    }
                }, 300L);
            }
        } else {
            if ((trendingRespData == null || (pager = trendingRespData.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.FALSE)) {
                SubTabAdapter subTabAdapter2 = subTabFragment.mMainAdapter;
                if (subTabAdapter2 != null && (h02 = subTabAdapter2.h0()) != null) {
                    t6.f.u(h02, false, 1, (Object) null);
                }
            } else {
                SubTabAdapter subTabAdapter3 = subTabFragment.mMainAdapter;
                if (subTabAdapter3 != null && (h0 = subTabAdapter3.h0()) != null) {
                    h0.v();
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(SubTabFragment subTabFragment) {
        t6.f h0;
        SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
        if (subTabAdapter == null || (h0 = subTabAdapter.h0()) == null) {
            return;
        }
        h0.s();
    }

    private final void f1() {
        NpaLinearLayoutManager npaGridLayoutManager;
        RecyclerView recyclerView;
        com.transsion.home.adapter.trending.provider.e preferencesProvider;
        RecyclerView recyclerView2;
        FragmentActivity activity;
        Function1 function1 = new Function1() { // from class: com.transsion.home.fragment.tab.p0
            public final Object invoke(Object obj) {
                Unit j1;
                j1 = SubTabFragment.j1(SubTabFragment.this, ((Integer) obj).intValue());
                return j1;
            }
        };
        FragmentActivity activity2 = getActivity();
        int i = (activity2 == null || !com.transsion.baseui.util.b.a(activity2)) ? 2 : com.blankj.utilcode.util.y.e() > com.blankj.utilcode.util.y.c() ? 4 : 3;
        ArrayList arrayList = new ArrayList();
        Function1 function12 = this.mOnAppointmentClick;
        int mTabId = getMTabId();
        com.transsion.home.preload.a activity3 = getActivity();
        Intrinsics.f(activity3, "null cannot be cast to non-null type com.transsion.home.preload.MainXMLPreload");
        com.transsion.home.preload.b d2 = activity3.d();
        FragmentActivity activity4 = getActivity();
        this.mMainAdapter = new SubTabAdapter(arrayList, function12, this, mTabId, d2, function1, activity4 != null && com.transsion.baseui.util.b.a(activity4), i, this.isUGCMode);
        if (this.isUGCMode || ((activity = getActivity()) != null && com.transsion.baseui.util.b.a(activity))) {
            npaGridLayoutManager = new NpaGridLayoutManager(requireContext(), i);
            c cVar = new c(i);
            cVar.i(true);
            npaGridLayoutManager.d0(cVar);
        } else {
            npaGridLayoutManager = new NpaLinearLayoutManager(requireContext(), 1, false);
        }
        qk.w wVar = (qk.w) getMViewBinding();
        if (wVar != null && (recyclerView2 = wVar.e) != null) {
            recyclerView2.setAdapter(this.mMainAdapter);
            recyclerView2.setLayoutManager(npaGridLayoutManager);
            npaGridLayoutManager.setInitialPrefetchItemCount(6);
            recyclerView2.setItemAnimator((RecyclerView.j) null);
            if (this.isUGCMode) {
                tf.h hVar = new tf.h(com.blankj.utilcode.util.a0.a(16.0f), i);
                hVar.d(com.blankj.utilcode.util.a0.a(8.0f));
                recyclerView2.addItemDecoration(hVar);
            } else {
                tf.h hVar2 = new tf.h(com.blankj.utilcode.util.a0.a(12.0f), 1);
                hVar2.d(com.blankj.utilcode.util.a0.a(6.0f));
                recyclerView2.addItemDecoration(hVar2);
            }
        }
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        if (subTabAdapter != null && (preferencesProvider = subTabAdapter.getPreferencesProvider()) != null) {
            HomePreferencesViewModel V0 = V0();
            SubTabAdapter subTabAdapter2 = this.mMainAdapter;
            Intrinsics.e(subTabAdapter2);
            int mTabId2 = getMTabId();
            String mTabCode = getMTabCode();
            if (mTabCode == null) {
                mTabCode = BuildConfig.FLAVOR;
            }
            HomePreferencesUiHelperKt.j(preferencesProvider, V0, subTabAdapter2, mTabId2, mTabCode);
        }
        qk.w wVar2 = (qk.w) getMViewBinding();
        if (wVar2 != null && (recyclerView = wVar2.e) != null) {
            HomePreferencesUiHelperKt.h(this, recyclerView, npaGridLayoutManager, V0(), new Function0() { // from class: com.transsion.home.fragment.tab.z
                public final Object invoke() {
                    int g1;
                    g1 = SubTabFragment.g1(SubTabFragment.this);
                    return Integer.valueOf(g1);
                }
            });
        }
        SubTabAdapter subTabAdapter3 = this.mMainAdapter;
        if (subTabAdapter3 != null) {
            subTabAdapter3.h0().z(true);
            subTabAdapter3.h0().z(true);
            subTabAdapter3.h0().y(true);
            subTabAdapter3.h0().D(new r6.f() { // from class: com.transsion.home.fragment.tab.a0
                public final void a() {
                    SubTabFragment.h1(SubTabFragment.this);
                }
            });
            subTabAdapter3.R0(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g1(SubTabFragment subTabFragment) {
        List data;
        SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
        if (subTabAdapter == null || (data = subTabAdapter.getData()) == null) {
            return 0;
        }
        return data.size();
    }

    private final View getNoNetworkView() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        final NoNetworkBigView noNetworkBigView = new NoNetworkBigView(requireContext);
        noNetworkBigView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        NoNetworkBigView.showTitle$default(noNetworkBigView, false, (String) null, 2, (Object) null);
        noNetworkBigView.retry(new Function0() { // from class: com.transsion.home.fragment.tab.f0
            public final Object invoke() {
                Unit W0;
                W0 = SubTabFragment.W0(noNetworkBigView, this);
                return W0;
            }
        });
        noNetworkBigView.goToSetting(new Function0() { // from class: com.transsion.home.fragment.tab.g0
            public final Object invoke() {
                Unit X0;
                X0 = SubTabFragment.X0(SubTabFragment.this);
                return X0;
            }
        });
        com.tn.lib.view.o.a(getPageName());
        this.mNoNetworkView = noNetworkBigView;
        Intrinsics.e(noNetworkBigView);
        return noNetworkBigView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(final SubTabFragment subTabFragment) {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            SubTabViewModel subTabViewModel = subTabFragment.mViewModel;
            if (subTabViewModel != null) {
                subTabViewModel.t(subTabFragment.getMTabId(), subTabFragment.getMTabCode(), false);
                return;
            }
            return;
        }
        fh.b.a.d(R.string.no_network_toast);
        qk.w wVar = (qk.w) subTabFragment.getMViewBinding();
        if (wVar == null || (recyclerView = wVar.e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.d0
            @Override // java.lang.Runnable
            public final void run() {
                SubTabFragment.i1(SubTabFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(SubTabFragment subTabFragment) {
        t6.f h0;
        SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
        if (subTabAdapter == null || (h0 = subTabAdapter.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(SubTabFragment subTabFragment, int i) {
        HashMap g;
        HashMap g2;
        String str;
        Integer v2;
        qi.b logViewConfig = subTabFragment.getLogViewConfig();
        int intValue = (logViewConfig == null || (g2 = logViewConfig.g()) == null || (str = (String) g2.get("scrollPosition")) == null || (v2 = StringsKt.v(str)) == null) ? 0 : v2.intValue();
        qi.b logViewConfig2 = subTabFragment.getLogViewConfig();
        if (logViewConfig2 != null && (g = logViewConfig2.g()) != null) {
            g.put("scrollPosition", String.valueOf(RangesKt.e(intValue, i)));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(SubTabFragment subTabFragment) {
        subTabFragment.c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        startLoading();
        String e2 = ij.o.a.e();
        SubTabViewModel subTabViewModel = this.mViewModel;
        if (subTabViewModel != null) {
            subTabViewModel.n(getMTabId(), false, e2);
        }
    }

    private final void m0() {
        String mTabCode;
        HomeFragment parentFragment = getParentFragment();
        HomeFragment homeFragment = parentFragment instanceof HomeFragment ? parentFragment : null;
        if ((homeFragment == null || (mTabCode = homeFragment.J0()) == null) && (mTabCode = getMTabCode()) == null) {
            mTabCode = BuildConfig.FLAVOR;
        }
        if (homeFragment != null) {
            homeFragment.a1(mTabCode, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(SubTabFragment subTabFragment, Function1 function1) {
        Intrinsics.h(function1, "callback");
        subTabFragment.mPermissionCallback = function1;
        androidx.activity.result.b bVar = subTabFragment.mLauncher;
        if (bVar != null) {
            bVar.a(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"});
        }
        return Unit.a;
    }

    private final void n1() {
        setNetListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(final SubTabFragment subTabFragment, Map map) {
        RecyclerView recyclerView;
        Intrinsics.h(map, "permissions");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                booleanRef.element = false;
            }
        }
        qk.w wVar = (qk.w) subTabFragment.getMViewBinding();
        if (wVar == null || (recyclerView = wVar.e) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.home.fragment.tab.c0
            @Override // java.lang.Runnable
            public final void run() {
                SubTabFragment.p1(SubTabFragment.this, booleanRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(SubTabFragment subTabFragment, Ref.BooleanRef booleanRef) {
        Function1 function1 = subTabFragment.mPermissionCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(booleanRef.element));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(float alpha) {
        View view;
        qk.w wVar = (qk.w) getMViewBinding();
        if (wVar == null || (view = wVar.b) == null) {
            return;
        }
        view.setAlpha(alpha);
    }

    private final void r1() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.o0
            @Override // java.lang.Runnable
            public final void run() {
                SubTabFragment.s1(SubTabFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(SubTabFragment subTabFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        if (subTabFragment.isDetached() || !subTabFragment.isAdded() || subTabFragment.getContext() == null) {
            return;
        }
        View R0 = yg.l.a.e() ? subTabFragment.R0() : subTabFragment.getNoNetworkView();
        SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
        if (subTabAdapter != null) {
            subTabAdapter.Y0(R0);
        }
        subTabFragment.Q0();
        qk.w wVar = (qk.w) subTabFragment.getMViewBinding();
        if (wVar == null || (swipeRefreshLayout = wVar.f) == null) {
            return;
        }
        swipeRefreshLayout.setEnabled(false);
    }

    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public qk.w getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        qk.w c2 = qk.w.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void c0() {
        String e2 = ij.o.a.e();
        SubTabViewModel subTabViewModel = this.mViewModel;
        if (subTabViewModel != null) {
            subTabViewModel.n(getMTabId(), true, e2);
        }
        m0();
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView f0() {
        qk.w wVar = (qk.w) getMViewBinding();
        if (wVar != null) {
            return wVar.e;
        }
        return null;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public String g0() {
        return this.isUGCMode ? "HomeFragmentListGrid2TemplateAd" : "HomeFragmentListLinearTemplateAd";
    }

    public final String getPageName() {
        return INSTANCE.a(getMTabId());
    }

    public void hideLoading() {
        qk.h0 h0Var;
        ConstraintLayout constraintLayout;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        qk.w wVar = (qk.w) getMViewBinding();
        if (wVar != null && (swipeRefreshLayout = wVar.f) != null && swipeRefreshLayout.isRefreshing()) {
            qk.w wVar2 = (qk.w) getMViewBinding();
            if (wVar2 == null || (swipeRefreshLayout2 = wVar2.f) == null) {
                return;
            }
            swipeRefreshLayout2.setRefreshing(false);
            return;
        }
        qk.w wVar3 = (qk.w) getMViewBinding();
        if (wVar3 == null || (h0Var = wVar3.c) == null || (constraintLayout = h0Var.h) == null) {
            return;
        }
        uf.c.g(constraintLayout);
    }

    public void initData(View view, Bundle savedInstanceState) {
        androidx.lifecycle.b0 s;
        androidx.lifecycle.b0 q;
        androidx.lifecycle.b0 p;
        Intrinsics.h(view, "view");
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        if (subTabAdapter != null) {
            HomePreferencesUiHelperKt.o(this, V0(), subTabAdapter);
        }
        final Function1 function1 = new Function1() { // from class: com.transsion.home.fragment.tab.y
            public final Object invoke(Object obj) {
                Unit a1;
                a1 = SubTabFragment.a1(SubTabFragment.this, (SubOperateData) obj);
                return a1;
            }
        };
        SubTabViewModel subTabViewModel = this.mViewModel;
        if (subTabViewModel != null && (p = subTabViewModel.p()) != null) {
            p.j(this, new f(new Function1() { // from class: com.transsion.home.fragment.tab.h0
                public final Object invoke(Object obj) {
                    Unit b1;
                    b1 = SubTabFragment.b1(SubTabFragment.this, function1, (SubOperateData) obj);
                    return b1;
                }
            }));
        }
        SubTabViewModel subTabViewModel2 = this.mViewModel;
        if (subTabViewModel2 != null && (q = subTabViewModel2.q()) != null) {
            q.j(this, new f(new Function1() { // from class: com.transsion.home.fragment.tab.i0
                public final Object invoke(Object obj) {
                    Unit c1;
                    c1 = SubTabFragment.c1(SubTabFragment.this, function1, (SubOperateData) obj);
                    return c1;
                }
            }));
        }
        SubTabViewModel subTabViewModel3 = this.mViewModel;
        if (subTabViewModel3 == null || (s = subTabViewModel3.s()) == null) {
            return;
        }
        s.j(this, new f(new Function1() { // from class: com.transsion.home.fragment.tab.j0
            public final Object invoke(Object obj) {
                Unit d1;
                d1 = SubTabFragment.d1(SubTabFragment.this, (TrendingRespData) obj);
                return d1;
            }
        }));
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void initView(View view, Bundle savedInstanceState) {
        SwipeRefreshLayout swipeRefreshLayout;
        View view2;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.h(view, "view");
        super.initView(view, savedInstanceState);
        SubTabViewModel a = new androidx.lifecycle.v0(this).a(SubTabViewModel.class);
        this.mViewModel = a;
        if (a != null) {
            a.w(this.isUGCMode);
        }
        f1();
        this.mHeaderBgHeight = U0();
        qk.w wVar = (qk.w) getMViewBinding();
        if (wVar != null && (view2 = wVar.b) != null && (layoutParams = view2.getLayoutParams()) != null) {
            layoutParams.height = this.mHeaderBgHeight;
        }
        qk.w wVar2 = (qk.w) getMViewBinding();
        if (wVar2 != null && (swipeRefreshLayout = wVar2.f) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.home.fragment.tab.k0
                public final void a() {
                    SubTabFragment.k1(SubTabFragment.this);
                }
            });
        }
        n1();
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void l0(int lastAdPosition, BiddingNativeManager wrapperNativeManager) {
        List data;
        Intrinsics.h(wrapperNativeManager, "wrapperNativeManager");
        if (wrapperNativeManager == null || lastAdPosition < 0) {
            return;
        }
        OperateItem operateItem = new OperateItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870911, null);
        operateItem.setNonAdDelegate(wrapperNativeManager);
        operateItem.setType(PostItemType.TRENDING_NATIVE_AD.getValue());
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        int size = (subTabAdapter == null || (data = subTabAdapter.getData()) == null) ? 0 : data.size();
        if (lastAdPosition < 0 || lastAdPosition > size) {
            SubTabAdapter subTabAdapter2 = this.mMainAdapter;
            if (subTabAdapter2 != null) {
                subTabAdapter2.p(operateItem);
                return;
            }
            return;
        }
        SubTabAdapter subTabAdapter3 = this.mMainAdapter;
        if (subTabAdapter3 != null) {
            subTabAdapter3.n(lastAdPosition, operateItem);
        }
    }

    public void lazyLoadData() {
        List data;
        this.loadStartTime = System.currentTimeMillis();
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        if (((subTabAdapter == null || (data = subTabAdapter.getData()) == null) ? 0 : data.size()) <= 0) {
            l1();
        }
    }

    public qi.b newLogViewConfig() {
        return new qi.b(getPageName(), false, 2, null);
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void onCreate(Bundle savedInstanceState) {
        this.mLauncher = registerForActivityResult(new f.h(), new androidx.activity.result.a() { // from class: com.transsion.home.fragment.tab.n0
            public final void a(Object obj) {
                SubTabFragment.o1(SubTabFragment.this, (Map) obj);
            }
        });
        super.onCreate(savedInstanceState);
    }

    public void onResume() {
        HashMap g;
        List data;
        super.onResume();
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        boolean z = false;
        if (((subTabAdapter == null || (data = subTabAdapter.getData()) == null) ? 0 : data.size()) <= 0) {
            View view = this.mNoNetworkView;
            if (view != null && view.getVisibility() == 0) {
                z = true;
            }
            if (z && yg.l.a.e()) {
                a.a aVar = wf.a.a;
                View view2 = this.mNoNetworkView;
                a.a.f(aVar, "SubTabFragment", "loaddata on resume = " + (view2 != null ? Integer.valueOf(view2.getVisibility()) : null) + "  " + this, false, 4, (Object) null);
                l1();
            }
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
        g.put("scrollPosition", "0");
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void p0() {
        RecyclerView recyclerView;
        qk.w wVar = (qk.w) getMViewBinding();
        if (wVar == null || (recyclerView = wVar.e) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(0);
    }

    public void startLoading() {
        qk.h0 h0Var;
        ConstraintLayout constraintLayout;
        qk.w wVar = (qk.w) getMViewBinding();
        if (wVar == null || (h0Var = wVar.c) == null || (constraintLayout = h0Var.h) == null) {
            return;
        }
        uf.c.k(constraintLayout);
    }
}
