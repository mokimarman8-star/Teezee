package com.transsion.home.fragment.ranking;

import android.content.Context;
import android.graphics.Color;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.StateView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.view.o;
import com.tn.lib.widget.R;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.Utils;
import com.transsion.home.adapter.f;
import com.transsion.home.bean.CategoryType;
import com.transsion.home.bean.UGCRankAllData;
import com.transsion.home.fragment.film.UGCFilmListFragment;
import com.transsion.home.fragment.ranking.UGCRankAllFragment;
import com.transsion.home.viewmodel.UGCRankingViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import ni.f;
import qk.y;
import r6.d;
import wf.a;
import xk.a;
import yg.l;
import yg.m;
import zg.h;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0018\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00109R\u0016\u0010F\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00109R\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00103¨\u0006N"}, d2 = {"Lcom/transsion/home/fragment/ranking/UGCRankAllFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lqk/y;", "<init>", "()V", "Lcom/transsion/moviedetailapi/bean/Cover;", "cover", BuildConfig.FLAVOR, "s0", "(Lcom/transsion/moviedetailapi/bean/Cover;)V", "o0", "t0", "v0", "Landroid/view/View;", "getNoNetworkView", "()Landroid/view/View;", "j0", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "Lcom/transsion/home/bean/CategoryType;", "category", BuildConfig.FLAVOR, "position", "u0", "(Lcom/transsion/home/bean/CategoryType;I)V", "Landroid/view/LayoutInflater;", "inflater", "n0", "(Landroid/view/LayoutInflater;)Lqk/y;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "startLoading", "hideLoading", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Lcom/transsion/home/viewmodel/UGCRankingViewModel;", "a", "Lcom/transsion/home/viewmodel/UGCRankingViewModel;", "viewModel", "Lcom/transsion/home/fragment/film/UGCFilmListFragment;", "b", "Lcom/transsion/home/fragment/film/UGCFilmListFragment;", "listFragment", BuildConfig.FLAVOR, "c", "Z", "hasRenderFirst", "d", "Landroid/view/View;", "errorView", "e", "Ljava/lang/String;", "tabId", "Lcom/transsion/home/adapter/f;", "f", "Lcom/transsion/home/adapter/f;", "categoryAdapter", "Lxk/a;", "g", "Lxk/a;", "headerMaskManager", "h", "videoType", "i", "fromOptId", BuildConfig.FLAVOR, "j", "J", "firstLoadStartTimeMillis", "k", "hasRecordedFirstLoadDuration", "l", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCRankAllFragment extends BaseFragment<y> {

    /* renamed from: l, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private UGCRankingViewModel viewModel;

    /* renamed from: b, reason: from kotlin metadata */
    private UGCFilmListFragment listFragment;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean hasRenderFirst;

    /* renamed from: d, reason: from kotlin metadata */
    private View errorView;

    /* renamed from: f, reason: from kotlin metadata */
    private f categoryAdapter;

    /* renamed from: g, reason: from kotlin metadata */
    private a headerMaskManager;

    /* renamed from: j, reason: from kotlin metadata */
    private long firstLoadStartTimeMillis;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean hasRecordedFirstLoadDuration;

    /* renamed from: e, reason: from kotlin metadata */
    private String tabId = "0";

    /* renamed from: h, reason: from kotlin metadata */
    private String videoType = BuildConfig.FLAVOR;

    /* renamed from: i, reason: from kotlin metadata */
    private String fromOptId = BuildConfig.FLAVOR;

    /* renamed from: com.transsion.home.fragment.ranking.UGCRankAllFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCRankAllFragment a(String str, String str2, String str3, String str4) {
            Bundle bundle = new Bundle();
            bundle.putString("category", str);
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            bundle.putString("tabId", str2);
            if (str3 == null) {
                str3 = BuildConfig.FLAVOR;
            }
            bundle.putString("videoType", str3);
            if (str4 == null) {
                str4 = BuildConfig.FLAVOR;
            }
            bundle.putString("fromOptId", str4);
            UGCRankAllFragment uGCRankAllFragment = new UGCRankAllFragment();
            uGCRankAllFragment.setArguments(bundle);
            return uGCRankAllFragment;
        }
    }

    public static final class b implements m {
        b() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            View view;
            y yVar;
            RecyclerView recyclerView;
            FrameLayout frameLayout;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (UGCRankAllFragment.this.isResumed() && (view = UGCRankAllFragment.this.errorView) != null && uf.c.i(view)) {
                a.a.f(wf.a.a, "UGCRankAllFragment", "noNetWorkListener: network connected, hide error and reload", false, 4, (Object) null);
                y yVar2 = (y) UGCRankAllFragment.this.getMViewBinding();
                if (yVar2 != null && (frameLayout = yVar2.e) != null) {
                    uf.c.g(frameLayout);
                }
                if (UGCRankAllFragment.this.hasRenderFirst && (yVar = (y) UGCRankAllFragment.this.getMViewBinding()) != null && (recyclerView = yVar.d) != null) {
                    uf.c.k(recyclerView);
                }
                UGCRankAllFragment.this.lazyLoadData();
            }
        }

        public void onDisconnected() {
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

    private final View getNoNetworkView() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        final NoNetworkBigView noNetworkBigView = new NoNetworkBigView(requireContext);
        noNetworkBigView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        NoNetworkBigView.showTitle$default(noNetworkBigView, false, (String) null, 2, (Object) null);
        noNetworkBigView.retry(new Function0() { // from class: vk.f
            public final Object invoke() {
                Unit l0;
                l0 = UGCRankAllFragment.l0(noNetworkBigView, this);
                return l0;
            }
        });
        noNetworkBigView.goToSetting(new Function0() { // from class: vk.g
            public final Object invoke() {
                Unit m0;
                m0 = UGCRankAllFragment.m0(UGCRankAllFragment.this);
                return m0;
            }
        });
        o.a(getPageName());
        return noNetworkBigView;
    }

    private final String getPageName() {
        return "/home/ugc_ranking";
    }

    private final View j0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        stateView.showData(3, 1, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        stateView.retry(new Function0() { // from class: vk.e
            public final Object invoke() {
                Unit k0;
                k0 = UGCRankAllFragment.k0(UGCRankAllFragment.this);
                return k0;
            }
        });
        return stateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(UGCRankAllFragment uGCRankAllFragment) {
        uGCRankAllFragment.lazyLoadData();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(NoNetworkBigView noNetworkBigView, UGCRankAllFragment uGCRankAllFragment) {
        uf.c.g(noNetworkBigView);
        uGCRankAllFragment.lazyLoadData();
        o.b(uGCRankAllFragment.getPageName());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(UGCRankAllFragment uGCRankAllFragment) {
        o.c(uGCRankAllFragment.getPageName());
        return Unit.a;
    }

    private final void o0() {
        RecyclerView recyclerView;
        a.a.f(wf.a.a, "UGCRankAllFragment", "initCategoryRecyclerView: start", false, 4, (Object) null);
        y yVar = (y) getMViewBinding();
        if (yVar == null || (recyclerView = yVar.d) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setItemAnimator((RecyclerView.j) null);
        final f fVar = new f();
        fVar.w1(new d() { // from class: vk.c
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                UGCRankAllFragment.p0(UGCRankAllFragment.this, fVar, baseQuickAdapter, view, i);
            }
        });
        this.categoryAdapter = fVar;
        recyclerView.setAdapter(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(UGCRankAllFragment uGCRankAllFragment, f fVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        a.a aVar = wf.a.a;
        a.a.f(aVar, "UGCRankAllFragment", "category clicked: position=" + i, false, 4, (Object) null);
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof CategoryType) {
            f fVar2 = baseQuickAdapter instanceof f ? (f) baseQuickAdapter : null;
            if (i == (fVar2 != null ? fVar2.getCurrentSelectedPosition() : -1)) {
                a.a.f(aVar, "UGCRankAllFragment", "category clicked same as selected: position=" + i, false, 4, (Object) null);
                uGCRankAllFragment.u0((CategoryType) item, i);
                return;
            }
            fVar.E1(i);
            UGCFilmListFragment uGCFilmListFragment = uGCRankAllFragment.listFragment;
            if (uGCFilmListFragment != null) {
                uGCFilmListFragment.startLoading();
            }
            UGCRankingViewModel uGCRankingViewModel = uGCRankAllFragment.viewModel;
            if (uGCRankingViewModel != null) {
                uGCRankingViewModel.l(((CategoryType) item).getType(), uGCRankAllFragment.tabId);
            }
            uGCRankAllFragment.u0((CategoryType) item, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(UGCRankAllFragment uGCRankAllFragment, UGCRankAllData uGCRankAllData) {
        String url;
        List<UGCContent> items;
        UGCContent uGCContent;
        UGCCollection collection;
        Cover cover;
        List<UGCContent> items2;
        UGCContent uGCContent2;
        UGCCollection collection2;
        List<UGCContent> items3;
        UGCContent uGCContent3;
        UGCVideo video;
        Cover cover2;
        HashMap g;
        CategoryType C1;
        String name;
        View view;
        ImageView imageView;
        List<UGCContent> items4;
        UGCContent uGCContent4;
        UGCVideo video2;
        Cover cover3;
        String str;
        CategoryType C12;
        List<CategoryType> categoryList;
        RecyclerView recyclerView;
        FrameLayout frameLayout;
        List<CategoryType> categoryList2;
        List<UGCContent> items5;
        HashMap g2;
        String str2;
        HashMap g3;
        if (!uGCRankAllFragment.hasRecordedFirstLoadDuration && uGCRankAllFragment.firstLoadStartTimeMillis > 0 && !uGCRankAllFragment.hasRenderFirst) {
            long currentTimeMillis = System.currentTimeMillis() - uGCRankAllFragment.firstLoadStartTimeMillis;
            qi.b logViewConfig = uGCRankAllFragment.getLogViewConfig();
            if (logViewConfig != null && (g3 = logViewConfig.g()) != null) {
                g3.put("load_duration", String.valueOf(currentTimeMillis));
            }
            uGCRankAllFragment.hasRecordedFirstLoadDuration = true;
        }
        qi.b logViewConfig2 = uGCRankAllFragment.getLogViewConfig();
        String str3 = BuildConfig.FLAVOR;
        if (logViewConfig2 != null && (g2 = logViewConfig2.g()) != null) {
            if (uGCRankAllData == null || (str2 = uGCRankAllData.getOps()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            g2.put("ops", str2);
        }
        a.a aVar = wf.a.a;
        Cover cover4 = null;
        Integer valueOf = (uGCRankAllData == null || (items5 = uGCRankAllData.getItems()) == null) ? null : Integer.valueOf(items5.size());
        a.a.f(aVar, "UGCRankAllFragment", "rankAllLiveData: data received, items size=" + valueOf + ", hasRenderFirst=" + uGCRankAllFragment.hasRenderFirst, false, 4, (Object) null);
        if (uGCRankAllFragment.hasRenderFirst) {
            UGCFilmListFragment uGCFilmListFragment = uGCRankAllFragment.listFragment;
            if (uGCFilmListFragment != null) {
                uGCFilmListFragment.hideLoading();
            }
        } else {
            uGCRankAllFragment.hideLoading();
        }
        if (((uGCRankAllData == null || (categoryList2 = uGCRankAllData.getCategoryList()) == null) ? 0 : categoryList2.size()) <= 0) {
            a.a.x(aVar, "UGCRankAllFragment", "rankAllLiveData: no items, show error", false, 4, (Object) null);
            uGCRankAllFragment.v0();
            return Unit.a;
        }
        y yVar = (y) uGCRankAllFragment.getMViewBinding();
        if (yVar != null && (frameLayout = yVar.e) != null) {
            uf.c.g(frameLayout);
        }
        y yVar2 = (y) uGCRankAllFragment.getMViewBinding();
        if (yVar2 != null && (recyclerView = yVar2.d) != null) {
            uf.c.k(recyclerView);
        }
        if (!uGCRankAllFragment.hasRenderFirst) {
            a.a.f(aVar, "UGCRankAllFragment", "rankAllLiveData: first render, setup category list", false, 4, (Object) null);
            f fVar = uGCRankAllFragment.categoryAdapter;
            if (fVar != null) {
                fVar.n1(uGCRankAllData != null ? uGCRankAllData.getCategoryList() : null);
            }
            if (uGCRankAllData != null && (categoryList = uGCRankAllData.getCategoryList()) != null) {
                int i = 0;
                for (Object obj : categoryList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.u();
                    }
                    CategoryType categoryType = (CategoryType) obj;
                    if (Intrinsics.c(categoryType.getType(), uGCRankAllData.getCurrentCategoryType())) {
                        f fVar2 = uGCRankAllFragment.categoryAdapter;
                        if (fVar2 != null) {
                            fVar2.E1(i);
                        }
                        a.a.f(wf.a.a, "UGCRankAllFragment", "rankAllLiveData: set initial selected position=" + i + ", category=" + categoryType.getType(), false, 4, (Object) null);
                    }
                    i = i2;
                }
            }
            uGCRankAllFragment.hasRenderFirst = true;
        }
        UGCFilmListFragment uGCFilmListFragment2 = uGCRankAllFragment.listFragment;
        if (uGCFilmListFragment2 != null) {
            f fVar3 = uGCRankAllFragment.categoryAdapter;
            if (fVar3 == null || (C12 = fVar3.C1()) == null || (str = C12.getName()) == null) {
                str = BuildConfig.FLAVOR;
            }
            uGCFilmListFragment2.L0(uGCRankAllData, str);
        }
        if (uGCRankAllData == null || (items4 = uGCRankAllData.getItems()) == null || (uGCContent4 = (UGCContent) CollectionsKt.k0(items4)) == null || (video2 = uGCContent4.getVideo()) == null || (cover3 = video2.getCover()) == null || (url = cover3.getUrl()) == null) {
            url = (uGCRankAllData == null || (items = uGCRankAllData.getItems()) == null || (uGCContent = (UGCContent) CollectionsKt.k0(items)) == null || (collection = uGCContent.getCollection()) == null || (cover = collection.getCover()) == null) ? null : cover.getUrl();
            if (url == null) {
                url = BuildConfig.FLAVOR;
            }
        }
        if (url.length() == 0) {
            y yVar3 = (y) uGCRankAllFragment.getMViewBinding();
            if (yVar3 != null && (imageView = yVar3.g) != null) {
                imageView.setBackgroundColor(uGCRankAllFragment.getResources().getColor(R.color.gray_dark_10));
            }
            y yVar4 = (y) uGCRankAllFragment.getMViewBinding();
            if (yVar4 != null && (view = yVar4.b) != null) {
                view.setBackgroundColor(uGCRankAllFragment.getResources().getColor(R.color.gray_dark_10));
            }
        } else {
            if (uGCRankAllData != null && (items3 = uGCRankAllData.getItems()) != null && (uGCContent3 = (UGCContent) CollectionsKt.k0(items3)) != null && (video = uGCContent3.getVideo()) != null && (cover2 = video.getCover()) != null) {
                cover4 = cover2;
            } else if (uGCRankAllData != null && (items2 = uGCRankAllData.getItems()) != null && (uGCContent2 = (UGCContent) CollectionsKt.k0(items2)) != null && (collection2 = uGCContent2.getCollection()) != null) {
                cover4 = collection2.getCover();
            }
            uGCRankAllFragment.s0(cover4);
        }
        UGCFilmListFragment uGCFilmListFragment3 = uGCRankAllFragment.listFragment;
        if (uGCFilmListFragment3 != null) {
            uGCRankAllFragment.getChildFragmentManager().p().y(uGCFilmListFragment3).l();
        }
        qi.b logViewConfig3 = uGCRankAllFragment.getLogViewConfig();
        if (logViewConfig3 != null) {
            logViewConfig3.k(true);
        }
        qi.b logViewConfig4 = uGCRankAllFragment.getLogViewConfig();
        if (logViewConfig4 != null && (g = logViewConfig4.g()) != null) {
            f fVar4 = uGCRankAllFragment.categoryAdapter;
            if (fVar4 != null && (C1 = fVar4.C1()) != null && (name = C1.getName()) != null) {
                str3 = name;
            }
            g.put("rank_category", str3);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(UGCRankAllFragment uGCRankAllFragment, View view) {
        FragmentActivity activity = uGCRankAllFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void s0(Cover cover) {
        String averageHueDark;
        Object obj;
        ImageView imageView;
        String str;
        String str2;
        Context activity = getActivity();
        if (activity == null) {
            return;
        }
        y yVar = (y) getMViewBinding();
        String str3 = BuildConfig.FLAVOR;
        if (yVar != null && (imageView = yVar.g) != null) {
            f.b m2 = ni.f.a.m(activity);
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m2.g(str);
            if (cover == null || (str2 = cover.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            g.l(str2).d(imageView);
        }
        if (cover == null || (averageHueDark = cover.getAverageHueDark()) == null) {
            return;
        }
        Unit unit = null;
        if (StringsKt.c0(averageHueDark, Utils.SEPARATOR, false, 2, (Object) null)) {
            try {
                Result.Companion companion = Result.Companion;
                String averageHueDark2 = cover.getAverageHueDark();
                if (averageHueDark2 != null) {
                    str3 = averageHueDark2;
                }
                int parseColor = Color.parseColor(str3);
                xk.a aVar = this.headerMaskManager;
                if (aVar != null) {
                    aVar.a(Integer.valueOf(parseColor));
                    unit = Unit.a;
                }
                obj = Result.constructor-impl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                a.a.l(wf.a.a, "UGCRankAllFragment", "initRecyclerView: parseColor failed, use default color", false, 4, (Object) null);
            }
        }
    }

    private final void t0() {
        setNetListener(new b());
    }

    private final void u0(CategoryType category, int position) {
        String str;
        b0 k;
        UGCRankAllData uGCRankAllData;
        List<UGCContent> items;
        UGCContent uGCContent;
        UGCVideo video;
        String ops;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "rec_list");
        String str2 = BuildConfig.FLAVOR;
        if (category == null || (str = category.getName()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("rank_category", str);
        linkedHashMap.put("belong_to_collection_id", BuildConfig.FLAVOR);
        linkedHashMap.put("content_id", BuildConfig.FLAVOR);
        linkedHashMap.put("refer_subject_id", BuildConfig.FLAVOR);
        linkedHashMap.put("content_type", "ugc_video");
        UGCRankingViewModel uGCRankingViewModel = this.viewModel;
        if (uGCRankingViewModel != null && (k = uGCRankingViewModel.k()) != null && (uGCRankAllData = (UGCRankAllData) k.f()) != null && (items = uGCRankAllData.getItems()) != null && (uGCContent = (UGCContent) CollectionsKt.k0(items)) != null && (video = uGCContent.getVideo()) != null && (ops = video.getOps()) != null) {
            str2 = ops;
        }
        linkedHashMap.put("ops", str2);
        com.transsion.baselib.helper.a.a.f(getPageName(), linkedHashMap);
    }

    private final void v0() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: vk.d
            @Override // java.lang.Runnable
            public final void run() {
                UGCRankAllFragment.w0(UGCRankAllFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(UGCRankAllFragment uGCRankAllFragment) {
        y yVar;
        RecyclerView recyclerView;
        FrameLayout frameLayout;
        if (uGCRankAllFragment.isDetached() || !uGCRankAllFragment.isAdded() || uGCRankAllFragment.getContext() == null) {
            return;
        }
        View j0 = l.a.e() ? uGCRankAllFragment.j0() : uGCRankAllFragment.getNoNetworkView();
        a.a.f(wf.a.a, "UGCRankAllFragment", "showError: show error in outer container, hasRenderFirst=" + uGCRankAllFragment.hasRenderFirst, false, 4, (Object) null);
        y yVar2 = (y) uGCRankAllFragment.getMViewBinding();
        if (yVar2 != null && (frameLayout = yVar2.e) != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(j0);
            frameLayout.setVisibility(0);
        }
        if (uGCRankAllFragment.hasRenderFirst && (yVar = (y) uGCRankAllFragment.getMViewBinding()) != null && (recyclerView = yVar.d) != null) {
            uf.c.g(recyclerView);
        }
        UGCFilmListFragment uGCFilmListFragment = uGCRankAllFragment.listFragment;
        if (uGCFilmListFragment != null) {
            uGCRankAllFragment.getChildFragmentManager().p().p(uGCFilmListFragment).l();
        }
        uGCRankAllFragment.errorView = j0;
    }

    public void hideLoading() {
        ConstraintLayout constraintLayout;
        y yVar = (y) getMViewBinding();
        if (yVar == null || (constraintLayout = yVar.h) == null) {
            return;
        }
        uf.c.h(constraintLayout);
    }

    public void initView(View view, Bundle savedInstanceState) {
        String str;
        b0 k;
        b0 k2;
        String string;
        TitleLayout titleLayout;
        Intrinsics.h(view, "view");
        y yVar = (y) getMViewBinding();
        if (yVar != null && (titleLayout = yVar.i) != null) {
            titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: vk.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UGCRankAllFragment.r0(UGCRankAllFragment.this, view2);
                }
            });
            h hVar = h.a;
            Context context = titleLayout.getContext();
            Intrinsics.g(context, "getContext(...)");
            titleLayout.setPadding(0, hVar.d(context), 0, 0);
        }
        y yVar2 = (y) getMViewBinding();
        ImageView imageView = yVar2 != null ? yVar2.g : null;
        y yVar3 = (y) getMViewBinding();
        this.headerMaskManager = new xk.a(imageView, yVar3 != null ? yVar3.b : null);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("videoType", BuildConfig.FLAVOR)) == null) {
            str = BuildConfig.FLAVOR;
        }
        this.videoType = str;
        Bundle arguments2 = getArguments();
        String str2 = (arguments2 == null || (string = arguments2.getString("fromOptId", BuildConfig.FLAVOR)) == null) ? BuildConfig.FLAVOR : string;
        this.fromOptId = str2;
        UGCFilmListFragment a = UGCFilmListFragment.INSTANCE.a(this.tabId, BuildConfig.FLAVOR, BuildConfig.FLAVOR, true, this.videoType, str2);
        this.listFragment = a;
        if (a != null) {
            getChildFragmentManager().p().c(com.transsion.home.R.id.ranking_list_container, a, "ranking_list_fragment").l();
        }
        a.a aVar = wf.a.a;
        a.a.f(aVar, "UGCRankAllFragment", "initView: listFragment dynamically added to container", false, 4, (Object) null);
        UGCRankingViewModel uGCRankingViewModel = this.viewModel;
        if (uGCRankingViewModel != null) {
            UGCFilmListFragment uGCFilmListFragment = this.listFragment;
            if (uGCFilmListFragment != null) {
                uGCFilmListFragment.H0(uGCRankingViewModel);
            }
            a.a.f(aVar, "UGCRankAllFragment", "initView: setupRankingViewModel completed", false, 4, (Object) null);
        }
        UGCRankingViewModel uGCRankingViewModel2 = this.viewModel;
        if (uGCRankingViewModel2 != null && (k2 = uGCRankingViewModel2.k()) != null) {
            k2.p(this);
        }
        UGCRankingViewModel uGCRankingViewModel3 = this.viewModel;
        if (uGCRankingViewModel3 != null && (k = uGCRankingViewModel3.k()) != null) {
            k.j(this, new c(new Function1() { // from class: vk.b
                public final Object invoke(Object obj) {
                    Unit q0;
                    q0 = UGCRankAllFragment.q0(UGCRankAllFragment.this, (UGCRankAllData) obj);
                    return q0;
                }
            }));
        }
        t0();
        o0();
    }

    public void lazyLoadData() {
        String string;
        if (this.hasRenderFirst) {
            UGCFilmListFragment uGCFilmListFragment = this.listFragment;
            if (uGCFilmListFragment != null) {
                uGCFilmListFragment.startLoading();
            }
        } else {
            startLoading();
        }
        Bundle arguments = getArguments();
        String str = "0";
        if (arguments != null && (string = arguments.getString("tabId", "0")) != null) {
            str = string;
        }
        this.tabId = str;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("category") : null;
        a.a.f(wf.a.a, "UGCRankAllFragment", "lazyLoadData: start loading, category=" + string2 + ", tabId=" + this.tabId, false, 4, (Object) null);
        if (!this.hasRecordedFirstLoadDuration && this.firstLoadStartTimeMillis == 0) {
            this.firstLoadStartTimeMillis = System.currentTimeMillis();
        }
        UGCRankingViewModel uGCRankingViewModel = this.viewModel;
        if (uGCRankingViewModel != null) {
            uGCRankingViewModel.l(string2, this.tabId);
        }
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public y getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.viewModel = (UGCRankingViewModel) new v0(activity).a(UGCRankingViewModel.class);
        }
        y c2 = y.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public qi.b newLogViewConfig() {
        return new qi.b(getPageName(), false, 2, null);
    }

    public void startLoading() {
        FrameLayout frameLayout;
        ConstraintLayout constraintLayout;
        y yVar = (y) getMViewBinding();
        if (yVar != null && (constraintLayout = yVar.h) != null) {
            uf.c.k(constraintLayout);
        }
        y yVar2 = (y) getMViewBinding();
        if (yVar2 == null || (frameLayout = yVar2.e) == null) {
            return;
        }
        uf.c.g(frameLayout);
    }
}
