package com.transsion.home.fragment.rank;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.u;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.q2;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.b;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.StateView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R$color;
import com.transsion.home.bean.CategoryType;
import com.transsion.home.bean.RankAllData;
import com.transsion.home.fragment.rank.RankAllFragment;
import com.transsion.home.viewmodel.RankAllViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o0.x;
import qk.s;
import yg.m;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J'\u0010'\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0$2\b\u0010&\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006@²\u0006\u0010\u0010?\u001a\u0004\u0018\u00010\f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcom/transsion/home/fragment/rank/RankAllFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lqk/s;", "<init>", "()V", BuildConfig.FLAVOR, "C0", "E0", "Landroid/view/View;", "getNoNetworkView", "()Landroid/view/View;", "v0", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "Lcom/transsion/home/bean/CategoryType;", "category", BuildConfig.FLAVOR, "position", "D0", "(Lcom/transsion/home/bean/CategoryType;I)V", "Landroid/view/LayoutInflater;", "inflater", "z0", "(Landroid/view/LayoutInflater;)Lqk/s;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "startLoading", "hideLoading", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", BuildConfig.FLAVOR, "items", "defaultCateGory", "i0", "(Ljava/util/List;Ljava/lang/String;Landroidx/compose/runtime/i;I)V", "Lcom/transsion/home/viewmodel/RankAllViewModel;", "a", "Lcom/transsion/home/viewmodel/RankAllViewModel;", "viewModel", "Lcom/transsion/home/fragment/rank/RankListFragment;", "b", "Lcom/transsion/home/fragment/rank/RankListFragment;", "listFragment", BuildConfig.FLAVOR, "c", "Z", "hasRenderFirst", "d", "Landroid/view/View;", "mErrorView", "e", "I", "tabId", "f", "Ljava/lang/String;", "rankingListId", "g", "currentCategory", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RankAllFragment extends BaseFragment<s> {

    /* renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int h = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private RankAllViewModel viewModel;

    /* renamed from: b, reason: from kotlin metadata */
    private RankListFragment listFragment;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean hasRenderFirst;

    /* renamed from: d, reason: from kotlin metadata */
    private View mErrorView;

    /* renamed from: e, reason: from kotlin metadata */
    private int tabId;

    /* renamed from: f, reason: from kotlin metadata */
    private String rankingListId;

    /* renamed from: com.transsion.home.fragment.rank.RankAllFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RankAllFragment a(String str, Integer num, String str2, String str3) {
            Bundle bundle = new Bundle();
            bundle.putString("category", str);
            bundle.putInt("tabId", num != null ? num.intValue() : 0);
            bundle.putString("defaultCategory", str2);
            bundle.putString("rankingListId", str3);
            RankAllFragment rankAllFragment = new RankAllFragment();
            rankAllFragment.setArguments(bundle);
            return rankAllFragment;
        }
    }

    static final class b implements Function3 {
        final /* synthetic */ CategoryType a;
        final /* synthetic */ RankAllFragment b;
        final /* synthetic */ int c;
        final /* synthetic */ i1 d;

        b(CategoryType categoryType, RankAllFragment rankAllFragment, int i, i1 i1Var) {
            this.a = categoryType;
            this.b = rankAllFragment;
            this.c = i;
            this.d = i1Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(CategoryType categoryType, RankAllFragment rankAllFragment, int i, i1 i1Var) {
            if (!Intrinsics.c(RankAllFragment.j0(i1Var), categoryType.getType())) {
                RankAllFragment.k0(i1Var, categoryType.getType());
                RankListFragment rankListFragment = rankAllFragment.listFragment;
                if (rankListFragment != null) {
                    rankListFragment.startLoading();
                }
                RankAllViewModel rankAllViewModel = rankAllFragment.viewModel;
                if (rankAllViewModel != null) {
                    rankAllViewModel.k(RankAllFragment.j0(i1Var), rankAllFragment.tabId, rankAllFragment.rankingListId);
                }
                rankAllFragment.D0(categoryType, i);
            }
            return Unit.a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b7, code lost:
        
            if (r10 == androidx.compose.runtime.i.a.a()) goto L26;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void b(androidx.compose.foundation.lazy.b bVar, androidx.compose.runtime.i iVar, int i) {
            Object obj;
            Intrinsics.h(bVar, "$this$item");
            if ((i & 17) == 16 && iVar.h()) {
                iVar.G();
                return;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-1073765077, i, -1, "com.transsion.home.fragment.rank.RankAllFragment.SetRankCategoryUI.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RankAllFragment.kt:282)");
            }
            boolean c = Intrinsics.c(RankAllFragment.j0(this.d), this.a.getType());
            int i2 = c ? R$color.rank_all_list_background : R$color.rank_all_category_background;
            b.c h = androidx.compose.ui.b.a.h();
            f.a aVar = androidx.compose.ui.f.a;
            androidx.compose.ui.f b = BackgroundKt.b(SizeKt.p(SizeKt.d(aVar, 0.0f, 1, (Object) null), (b.c) null, false, 3, (Object) null), i0.b.a(i2, iVar, 0), (a5) null, 2, (Object) null);
            float g = o0.i.g(0);
            FragmentActivity activity = this.b.getActivity();
            androidx.compose.ui.f f = PaddingKt.f(b, g, o0.i.g((activity == null || !com.transsion.baseui.util.b.a(activity)) ? 16 : 20));
            iVar.P(-1224400529);
            boolean A = iVar.A(this.a) | iVar.A(this.b) | iVar.c(this.c);
            final CategoryType categoryType = this.a;
            final RankAllFragment rankAllFragment = this.b;
            final int i3 = this.c;
            final i1 i1Var = this.d;
            Object y = iVar.y();
            if (!A) {
                obj = y;
            }
            Function0 function0 = new Function0() { // from class: com.transsion.home.fragment.rank.i
                public final Object invoke() {
                    Unit c2;
                    c2 = RankAllFragment.b.c(CategoryType.this, rankAllFragment, i3, i1Var);
                    return c2;
                }
            };
            iVar.p(function0);
            obj = function0;
            iVar.K();
            androidx.compose.ui.f d = ClickableKt.d(f, false, (String) null, (androidx.compose.ui.semantics.f) null, (Function0) obj, 7, (Object) null);
            CategoryType categoryType2 = this.a;
            t b2 = a0.b(androidx.compose.foundation.layout.b.a.c(), h, iVar, 48);
            int a = androidx.compose.runtime.g.a(iVar, 0);
            androidx.compose.runtime.s n = iVar.n();
            androidx.compose.ui.f e = ComposedModifierKt.e(iVar, d);
            ComposeUiNode.Companion companion = ComposeUiNode.c1;
            Function0 a2 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a2);
            } else {
                iVar.o();
            }
            androidx.compose.runtime.i a3 = f3.a(iVar);
            f3.b(a3, b2, companion.c());
            f3.b(a3, n, companion.e());
            Function2 b3 = companion.b();
            if (a3.e() || !Intrinsics.c(a3.y(), Integer.valueOf(a))) {
                a3.p(Integer.valueOf(a));
                a3.k(Integer.valueOf(a), b3);
            }
            f3.b(a3, e, companion.d());
            d0 d0Var = d0.a;
            iVar.P(1353739126);
            if (c) {
                BoxKt.a(BackgroundKt.b(SizeKt.e(SizeKt.l(aVar, o0.i.g(3)), o0.i.g(16)), i0.b.a(R.color.brand, iVar, 0), (a5) null, 2, (Object) null), iVar, 0);
            }
            iVar.K();
            int i4 = c ? R.color.brand : R$color.rank_all_category_text;
            String name = categoryType2.getName();
            if (name == null) {
                name = BuildConfig.FLAVOR;
            }
            TextKt.a(name, PaddingKt.g(aVar, o0.i.g(12), 0.0f, 2, (Object) null), i0.b.a(i4, iVar, 0), x.c(14), (androidx.compose.ui.text.font.n) null, androidx.compose.ui.text.font.p.b.c(), androidx.compose.ui.text.font.h.b.b(), 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, androidx.compose.ui.text.style.p.a.b(), true, 2, 0, (Function1) null, (androidx.compose.ui.text.d0) null, iVar, 199728, 3504, 116624);
            iVar.r();
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            b((androidx.compose.foundation.lazy.b) obj, (androidx.compose.runtime.i) obj2, ((Number) obj3).intValue());
            return Unit.a;
        }
    }

    static final class c implements Function2 {
        final /* synthetic */ RankAllData b;

        c(RankAllData rankAllData) {
            this.b = rankAllData;
        }

        public final void a(androidx.compose.runtime.i iVar, int i) {
            String currentCategoryType;
            List<CategoryType> arrayList;
            List<CategoryType> categoryList;
            if ((i & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(45154986, i, -1, "com.transsion.home.fragment.rank.RankAllFragment.initView.<anonymous>.<anonymous> (RankAllFragment.kt:134)");
            }
            Bundle arguments = RankAllFragment.this.getArguments();
            String string = arguments != null ? arguments.getString("defaultCategory") : null;
            if (string == null || string.length() == 0) {
                RankAllData rankAllData = this.b;
                currentCategoryType = rankAllData != null ? rankAllData.getCurrentCategoryType() : null;
            } else {
                currentCategoryType = string;
            }
            if (string != null && string.length() != 0) {
                RankAllData rankAllData2 = this.b;
                if (rankAllData2 != null && (categoryList = rankAllData2.getCategoryList()) != null) {
                    List<CategoryType> list = categoryList;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.c(((CategoryType) it.next()).getType(), currentCategoryType)) {
                                break;
                            }
                        }
                    }
                }
                RankAllData rankAllData3 = this.b;
                currentCategoryType = rankAllData3 != null ? rankAllData3.getCurrentCategoryType() : null;
            }
            RankAllFragment rankAllFragment = RankAllFragment.this;
            RankAllData rankAllData4 = this.b;
            if (rankAllData4 == null || (arrayList = rankAllData4.getCategoryList()) == null) {
                arrayList = new ArrayList<>();
            }
            rankAllFragment.i0(arrayList, currentCategoryType, iVar, 0);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
            return Unit.a;
        }
    }

    public static final class d implements yg.m {
        d() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            View view;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (RankAllFragment.this.isResumed() && (view = RankAllFragment.this.mErrorView) != null && uf.c.i(view)) {
                View view2 = RankAllFragment.this.mErrorView;
                if (view2 != null) {
                    uf.c.g(view2);
                }
                RankAllFragment.this.lazyLoadData();
            }
        }

        public void onDisconnected() {
        }
    }

    static final class e implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        e(Function1 function1) {
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
    public static final void A0(RankAllFragment rankAllFragment, View view) {
        FragmentActivity activity = rankAllFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(RankAllFragment rankAllFragment, RankAllData rankAllData) {
        ComposeView composeView;
        List<Subject> subjects;
        if (rankAllFragment.hasRenderFirst) {
            RankListFragment rankListFragment = rankAllFragment.listFragment;
            if (rankListFragment != null) {
                rankListFragment.hideLoading();
            }
        } else {
            rankAllFragment.hideLoading();
        }
        if (((rankAllData == null || (subjects = rankAllData.getSubjects()) == null) ? 0 : subjects.size()) <= 0) {
            rankAllFragment.E0();
            return Unit.a;
        }
        if (!rankAllFragment.hasRenderFirst) {
            s sVar = (s) rankAllFragment.getMViewBinding();
            if (sVar != null && (composeView = sVar.b) != null) {
                composeView.setContent(androidx.compose.runtime.internal.b.b(45154986, true, rankAllFragment.new c(rankAllData)));
            }
            rankAllFragment.hasRenderFirst = true;
        }
        RankListFragment rankListFragment2 = rankAllFragment.listFragment;
        if (rankListFragment2 != null) {
            rankListFragment2.k0(rankAllData);
        }
        qi.b logViewConfig = rankAllFragment.getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        return Unit.a;
    }

    private final void C0() {
        setNetListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(CategoryType category, int position) {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_type", "category_click");
        if (category == null || (str = category.getType()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("category", str);
        linkedHashMap.put("position", String.valueOf(position));
        qi.h.a.o(getPageName(), linkedHashMap);
    }

    private final void E0() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsion.home.fragment.rank.e
            @Override // java.lang.Runnable
            public final void run() {
                RankAllFragment.F0(RankAllFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(RankAllFragment rankAllFragment) {
        FrameLayout frameLayout;
        if (rankAllFragment.isDetached() || !rankAllFragment.isAdded() || rankAllFragment.getContext() == null) {
            return;
        }
        View v0 = yg.l.a.e() ? rankAllFragment.v0() : rankAllFragment.getNoNetworkView();
        if (rankAllFragment.hasRenderFirst) {
            RankListFragment rankListFragment = rankAllFragment.listFragment;
            if (rankListFragment != null) {
                rankListFragment.j0(v0);
            }
        } else {
            s sVar = (s) rankAllFragment.getMViewBinding();
            if (sVar != null && (frameLayout = sVar.c) != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(v0);
                frameLayout.setVisibility(0);
            }
        }
        rankAllFragment.mErrorView = v0;
    }

    private final View getNoNetworkView() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        final NoNetworkBigView noNetworkBigView = new NoNetworkBigView(requireContext);
        noNetworkBigView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        NoNetworkBigView.showTitle$default(noNetworkBigView, false, (String) null, 2, (Object) null);
        noNetworkBigView.retry(new Function0() { // from class: com.transsion.home.fragment.rank.f
            public final Object invoke() {
                Unit x0;
                x0 = RankAllFragment.x0(noNetworkBigView, this);
                return x0;
            }
        });
        noNetworkBigView.goToSetting(new Function0() { // from class: com.transsion.home.fragment.rank.g
            public final Object invoke() {
                Unit y0;
                y0 = RankAllFragment.y0(RankAllFragment.this);
                return y0;
            }
        });
        com.tn.lib.view.o.a(getPageName());
        return noNetworkBigView;
    }

    private final String getPageName() {
        return "rank_all_page";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j0(i1 i1Var) {
        return (String) i1Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(i1 i1Var, String str) {
        i1Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(List list, RankAllFragment rankAllFragment, i1 i1Var, u uVar) {
        Intrinsics.h(uVar, "$this$LazyColumn");
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            CategoryType categoryType = (CategoryType) obj;
            androidx.compose.foundation.lazy.t.a(uVar, categoryType.getType() + i, (Object) null, androidx.compose.runtime.internal.b.b(-1073765077, true, new b(categoryType, rankAllFragment, i, i1Var)), 2, (Object) null);
            i = i2;
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(RankAllFragment rankAllFragment, List list, String str, int i, androidx.compose.runtime.i iVar, int i2) {
        rankAllFragment.i0(list, str, iVar, v1.a(i | 1));
        return Unit.a;
    }

    private final View v0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        stateView.showData(3, 1, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        stateView.retry(new Function0() { // from class: com.transsion.home.fragment.rank.h
            public final Object invoke() {
                Unit w0;
                w0 = RankAllFragment.w0(RankAllFragment.this);
                return w0;
            }
        });
        return stateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(RankAllFragment rankAllFragment) {
        rankAllFragment.lazyLoadData();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(NoNetworkBigView noNetworkBigView, RankAllFragment rankAllFragment) {
        uf.c.g(noNetworkBigView);
        rankAllFragment.lazyLoadData();
        com.tn.lib.view.o.b(rankAllFragment.getPageName());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(RankAllFragment rankAllFragment) {
        com.tn.lib.view.o.c(rankAllFragment.getPageName());
        return Unit.a;
    }

    public void hideLoading() {
        ConstraintLayout constraintLayout;
        s sVar = (s) getMViewBinding();
        if (sVar == null || (constraintLayout = sVar.d) == null) {
            return;
        }
        uf.c.h(constraintLayout);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00af, code lost:
    
        if (r8 == r5.a()) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0(final List list, final String str, androidx.compose.runtime.i iVar, final int i) {
        int i2;
        Object obj;
        androidx.compose.runtime.i iVar2;
        Intrinsics.h(list, "items");
        androidx.compose.runtime.i g = iVar.g(-1793930920);
        if ((i & 6) == 0) {
            i2 = (g.A(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= g.O(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= g.A(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && g.h()) {
            g.G();
            iVar2 = g;
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-1793930920, i2, -1, "com.transsion.home.fragment.rank.RankAllFragment.SetRankCategoryUI (RankAllFragment.kt:276)");
            }
            g.P(1849434622);
            Object y = g.y();
            i.a aVar = androidx.compose.runtime.i.a;
            if (y == aVar.a()) {
                y = r2.f(str, (q2) null, 2, (Object) null);
                g.p(y);
            }
            final i1 i1Var = (i1) y;
            g.K();
            androidx.compose.ui.f b2 = BackgroundKt.b(androidx.compose.ui.f.a, i0.b.a(R$color.rank_all_category_background, g, 0), (a5) null, 2, (Object) null);
            g.P(-1746271574);
            boolean A = g.A(list) | g.A(this);
            Object y2 = g.y();
            if (!A) {
                obj = y2;
            }
            Function1 function1 = new Function1() { // from class: com.transsion.home.fragment.rank.c
                public final Object invoke(Object obj2) {
                    Unit l0;
                    l0 = RankAllFragment.l0(list, this, i1Var, (u) obj2);
                    return l0;
                }
            };
            g.p(function1);
            obj = function1;
            g.K();
            iVar2 = g;
            LazyDslKt.a(b2, (LazyListState) null, (androidx.compose.foundation.layout.t) null, false, (b.k) null, (b.b) null, (androidx.compose.foundation.gestures.g) null, false, (Function1) obj, g, 0, 254);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j = iVar2.j();
        if (j != null) {
            j.a(new Function2() { // from class: com.transsion.home.fragment.rank.d
                public final Object invoke(Object obj2, Object obj3) {
                    Unit m0;
                    m0 = RankAllFragment.m0(RankAllFragment.this, list, str, i, (androidx.compose.runtime.i) obj2, ((Integer) obj3).intValue());
                    return m0;
                }
            });
        }
    }

    public void initView(View view, Bundle savedInstanceState) {
        b0 j;
        TitleLayout titleLayout;
        Intrinsics.h(view, "view");
        s sVar = (s) getMViewBinding();
        if (sVar != null && (titleLayout = sVar.e) != null) {
            titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: com.transsion.home.fragment.rank.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RankAllFragment.A0(RankAllFragment.this, view2);
                }
            });
            String string = getString(com.transsion.home.R.string.str_ranking);
            Intrinsics.g(string, "getString(...)");
            titleLayout.setTitleText(string);
            zg.h hVar = zg.h.a;
            Context context = titleLayout.getContext();
            Intrinsics.g(context, "getContext(...)");
            titleLayout.setPadding(0, hVar.d(context), 0, 0);
        }
        RankAllViewModel rankAllViewModel = this.viewModel;
        if (rankAllViewModel != null && (j = rankAllViewModel.j()) != null) {
            j.j(this, new e(new Function1() { // from class: com.transsion.home.fragment.rank.b
                public final Object invoke(Object obj) {
                    Unit B0;
                    B0 = RankAllFragment.B0(RankAllFragment.this, (RankAllData) obj);
                    return B0;
                }
            }));
        }
        RankListFragment j0 = getChildFragmentManager().j0(com.transsion.home.R.id.rank_all_category_item_fragment);
        Intrinsics.f(j0, "null cannot be cast to non-null type com.transsion.home.fragment.rank.RankListFragment");
        this.listFragment = j0;
        C0();
    }

    public void lazyLoadData() {
        if (this.hasRenderFirst) {
            RankListFragment rankListFragment = this.listFragment;
            if (rankListFragment != null) {
                rankListFragment.startLoading();
            }
        } else {
            startLoading();
        }
        Bundle arguments = getArguments();
        this.tabId = arguments != null ? arguments.getInt("tabId") : 0;
        Bundle arguments2 = getArguments();
        this.rankingListId = arguments2 != null ? arguments2.getString("rankingListId") : null;
        RankAllViewModel rankAllViewModel = this.viewModel;
        if (rankAllViewModel != null) {
            Bundle arguments3 = getArguments();
            rankAllViewModel.k(arguments3 != null ? arguments3.getString("category") : null, this.tabId, this.rankingListId);
        }
    }

    public qi.b newLogViewConfig() {
        return new qi.b(getPageName(), false, 2, null);
    }

    public void startLoading() {
        FrameLayout frameLayout;
        ConstraintLayout constraintLayout;
        s sVar = (s) getMViewBinding();
        if (sVar != null && (constraintLayout = sVar.d) != null) {
            uf.c.k(constraintLayout);
        }
        s sVar2 = (s) getMViewBinding();
        if (sVar2 == null || (frameLayout = sVar2.c) == null) {
            return;
        }
        uf.c.g(frameLayout);
    }

    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public s getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.viewModel = (RankAllViewModel) new v0(activity).a(RankAllViewModel.class);
        }
        s c2 = s.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
