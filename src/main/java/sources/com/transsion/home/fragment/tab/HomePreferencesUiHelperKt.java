package com.transsion.home.fragment.tab;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomePreferencesRefreshType;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.dialog.HomePreferencesDialog;
import com.transsion.home.fragment.tab.HomePreferencesUiHelperKt;
import com.transsion.home.viewmodel.HomePreferencesViewModel;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Function;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class HomePreferencesUiHelperKt {

    public static final class a extends RecyclerView.r {
        final /* synthetic */ Ref.BooleanRef a;
        final /* synthetic */ RecyclerView.m b;
        final /* synthetic */ Ref.ObjectRef c;
        final /* synthetic */ BaseHomeSubFragment d;
        final /* synthetic */ HomePreferencesViewModel e;
        final /* synthetic */ Ref.IntRef f;

        a(Ref.BooleanRef booleanRef, RecyclerView.m mVar, Ref.ObjectRef objectRef, BaseHomeSubFragment baseHomeSubFragment, HomePreferencesViewModel homePreferencesViewModel, Ref.IntRef intRef) {
            this.a = booleanRef;
            this.b = mVar;
            this.c = objectRef;
            this.d = baseHomeSubFragment;
            this.e = homePreferencesViewModel;
            this.f = intRef;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(HomePreferencesViewModel homePreferencesViewModel, HomePreferencesConfig homePreferencesConfig, BaseHomeSubFragment baseHomeSubFragment, List list) {
            Intrinsics.h(list, "selected");
            homePreferencesViewModel.B(homePreferencesConfig);
            homePreferencesViewModel.L(homePreferencesConfig, list);
            zk.c cVar = zk.c.a;
            int mTabId = baseHomeSubFragment.getMTabId();
            String mTabCode = baseHomeSubFragment.getMTabCode();
            if (mTabCode == null) {
                mTabCode = BuildConfig.FLAVOR;
            }
            cVar.k(mTabId, mTabCode, homePreferencesConfig, list);
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(HomePreferencesViewModel homePreferencesViewModel, HomePreferencesConfig homePreferencesConfig, BaseHomeSubFragment baseHomeSubFragment) {
            homePreferencesViewModel.C(homePreferencesConfig);
            zk.c cVar = zk.c.a;
            int mTabId = baseHomeSubFragment.getMTabId();
            String mTabCode = baseHomeSubFragment.getMTabCode();
            if (mTabCode == null) {
                mTabCode = BuildConfig.FLAVOR;
            }
            cVar.j(mTabId, mTabCode, homePreferencesConfig);
            return Unit.a;
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            Intrinsics.h(recyclerView, "rv");
            super.onScrolled(recyclerView, i, i2);
            if (this.a.element || i2 <= 0) {
                return;
            }
            LinearLayoutManager linearLayoutManager = this.b;
            if (linearLayoutManager instanceof LinearLayoutManager) {
                i3 = linearLayoutManager.findFirstVisibleItemPosition();
            } else if (linearLayoutManager instanceof StaggeredGridLayoutManager) {
                int[] D = ((StaggeredGridLayoutManager) linearLayoutManager).D((int[]) null);
                Intrinsics.g(D, "findFirstVisibleItemPositions(...)");
                i3 = ArraysKt.R(D);
            } else {
                i3 = 0;
            }
            if (this.c.element == null) {
                String mTabCode = this.d.getMTabCode();
                if (mTabCode == null) {
                    return;
                } else {
                    this.e.J(mTabCode);
                }
            }
            final HomePreferencesConfig homePreferencesConfig = (HomePreferencesConfig) this.c.element;
            if (homePreferencesConfig != null && i3 > this.f.element) {
                this.a.element = true;
                HomePreferencesDialog a = HomePreferencesDialog.INSTANCE.a();
                a.z0(homePreferencesConfig);
                zk.c cVar = zk.c.a;
                int mTabId = this.d.getMTabId();
                String mTabCode2 = this.d.getMTabCode();
                if (mTabCode2 == null) {
                    mTabCode2 = BuildConfig.FLAVOR;
                }
                cVar.l(mTabId, mTabCode2, homePreferencesConfig);
                final HomePreferencesViewModel homePreferencesViewModel = this.e;
                final BaseHomeSubFragment baseHomeSubFragment = this.d;
                a.B0(new Function1() { // from class: com.transsion.home.fragment.tab.g
                    public final Object invoke(Object obj) {
                        Unit f;
                        f = HomePreferencesUiHelperKt.a.f(HomePreferencesViewModel.this, homePreferencesConfig, baseHomeSubFragment, (List) obj);
                        return f;
                    }
                });
                final HomePreferencesViewModel homePreferencesViewModel2 = this.e;
                final BaseHomeSubFragment baseHomeSubFragment2 = this.d;
                a.A0(new Function0() { // from class: com.transsion.home.fragment.tab.h
                    public final Object invoke() {
                        Unit g;
                        g = HomePreferencesUiHelperKt.a.g(HomePreferencesViewModel.this, homePreferencesConfig, baseHomeSubFragment2);
                        return g;
                    }
                });
                this.e.D(homePreferencesConfig);
                a.l0(this.d, "HomePreferencesDialog");
            }
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

    public static final void f(String str, HomePreferencesViewModel homePreferencesViewModel, List list) {
        Intrinsics.h(homePreferencesViewModel, "viewModel");
        Intrinsics.h(list, "baseList");
        if (str == null || list.isEmpty()) {
            return;
        }
        homePreferencesViewModel.E(str, list);
        List t = homePreferencesViewModel.t(str, list);
        if (t.isEmpty()) {
            return;
        }
        for (ok.a aVar : CollectionsKt.I0(t, new Comparator() { // from class: com.transsion.home.fragment.tab.HomePreferencesUiHelperKt$applyHomePreferencesInsertToList$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return ComparisonsKt.d(Integer.valueOf(((ok.a) t2).b()), Integer.valueOf(((ok.a) t3).b()));
            }
        })) {
            int l = RangesKt.l(aVar.b(), 0, list.size());
            OperateItem operateItem = new OperateItem(null, PostItemType.PREFERENCES.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870909, null);
            operateItem.setHomePreferencesConfig(aVar.a());
            Unit unit = Unit.a;
            list.add(l, operateItem);
        }
    }

    public static final void g(List list, List list2, List list3) {
        int indexOf;
        HomePreferencesConfig homePreferencesConfig;
        String labelId;
        Intrinsics.h(list, "data");
        Intrinsics.h(list2, "blockList");
        Intrinsics.h(list3, "instructions");
        if (list.isEmpty() || list2.isEmpty() || list3.isEmpty()) {
            return;
        }
        List U0 = CollectionsKt.U0(list);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            OperateItem operateItem = (OperateItem) it.next();
            if (Intrinsics.c(operateItem.getType(), PostItemType.PREFERENCES.getValue()) && (homePreferencesConfig = operateItem.getHomePreferencesConfig()) != null && (labelId = homePreferencesConfig.getLabelId()) != null) {
                linkedHashSet.add(labelId);
            }
        }
        for (ok.a aVar : CollectionsKt.I0(list3, new Comparator() { // from class: com.transsion.home.fragment.tab.HomePreferencesUiHelperKt$applyPreferencesInsertWithBlocksForUgc$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.d(Integer.valueOf(((ok.a) t).b()), Integer.valueOf(((ok.a) t2).b()));
            }
        })) {
            int l = RangesKt.l(aVar.b(), 2, list2.size());
            HomePreferencesConfig a2 = aVar.a();
            if (!linkedHashSet.contains(a2.getLabelId())) {
                if (l >= list2.size()) {
                    indexOf = U0.size();
                } else {
                    OperateItem operateItem2 = (OperateItem) list2.get(l);
                    if (Intrinsics.c(operateItem2.getType(), PostItemType.UGC_PORTRAIT_GRID.getValue())) {
                        Iterator it2 = U0.iterator();
                        int i = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                indexOf = -1;
                                break;
                            } else {
                                if (((OperateItem) it2.next()) == operateItem2) {
                                    indexOf = i;
                                    break;
                                }
                                i++;
                            }
                        }
                        if (indexOf < 0) {
                            indexOf = U0.size();
                        }
                    } else {
                        OperateItem originalOperateItem = operateItem2.getOriginalOperateItem();
                        if (Intrinsics.c(operateItem2.getType(), PostItemType.FEEDS_TITLE.getValue())) {
                            indexOf = U0.indexOf(operateItem2);
                        } else if (originalOperateItem != null) {
                            Iterator it3 = U0.iterator();
                            int i2 = 0;
                            while (true) {
                                if (!it3.hasNext()) {
                                    indexOf = -1;
                                    break;
                                } else {
                                    if (((OperateItem) it3.next()).getOriginalOperateItem() == originalOperateItem) {
                                        indexOf = i2;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        } else {
                            indexOf = U0.indexOf(operateItem2);
                        }
                        if (indexOf < 0) {
                            indexOf = U0.size();
                        }
                    }
                }
                int i3 = indexOf - 1;
                int i4 = i3 >= 0 ? i3 : 0;
                a.a.f(wf.a.a, "HomePreferences", "applyPreferencesInsertWithBlocksForUgc, 插入运营位 targetPos:" + i4, false, 4, (Object) null);
                OperateItem operateItem3 = new OperateItem(null, PostItemType.PREFERENCES.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870909, null);
                operateItem3.setHomePreferencesConfig(aVar.a());
                Unit unit = Unit.a;
                U0.add(i4, operateItem3);
                linkedHashSet.add(a2.getLabelId());
            }
        }
        list.clear();
        list.addAll(U0);
    }

    public static final void h(final BaseHomeSubFragment baseHomeSubFragment, RecyclerView recyclerView, RecyclerView.m mVar, HomePreferencesViewModel homePreferencesViewModel, final Function0 function0) {
        Intrinsics.h(baseHomeSubFragment, "<this>");
        Intrinsics.h(recyclerView, "recyclerView");
        Intrinsics.h(mVar, "layoutManager");
        Intrinsics.h(homePreferencesViewModel, "viewModel");
        Intrinsics.h(function0, "currentListSize");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = Integer.MAX_VALUE;
        homePreferencesViewModel.v().j(baseHomeSubFragment.getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.home.fragment.tab.f
            public final Object invoke(Object obj) {
                Unit i;
                i = HomePreferencesUiHelperKt.i(BaseHomeSubFragment.this, booleanRef, objectRef, intRef, function0, (Pair) obj);
                return i;
            }
        }));
        recyclerView.addOnScrollListener(new a(booleanRef, mVar, objectRef, baseHomeSubFragment, homePreferencesViewModel, intRef));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(BaseHomeSubFragment baseHomeSubFragment, Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, Ref.IntRef intRef, Function0 function0, Pair pair) {
        String str = (String) pair.component1();
        HomePreferencesConfig homePreferencesConfig = (HomePreferencesConfig) pair.component2();
        if (!Intrinsics.c(str, baseHomeSubFragment.getMTabCode())) {
            return Unit.a;
        }
        if (booleanRef.element || objectRef.element != null) {
            return Unit.a;
        }
        if (Intrinsics.c(homePreferencesConfig.getRefreshType(), HomePreferencesRefreshType.NO_REFRESH.getValue())) {
            objectRef.element = homePreferencesConfig;
            Integer pos = homePreferencesConfig.getPos();
            intRef.element = RangesKt.l(pos != null ? pos.intValue() : ((Number) function0.invoke()).intValue(), 0, ((Number) function0.invoke()).intValue());
            return Unit.a;
        }
        objectRef.element = homePreferencesConfig;
        Integer pos2 = homePreferencesConfig.getPos();
        intRef.element = RangesKt.l(pos2 != null ? pos2.intValue() : ((Number) function0.invoke()).intValue(), 0, ((Number) function0.invoke()).intValue());
        return Unit.a;
    }

    public static final void j(com.transsion.home.adapter.trending.provider.e eVar, final HomePreferencesViewModel homePreferencesViewModel, final BaseProviderMultiAdapter baseProviderMultiAdapter, final int i, final String str) {
        Intrinsics.h(eVar, "provider");
        Intrinsics.h(homePreferencesViewModel, "viewModel");
        Intrinsics.h(baseProviderMultiAdapter, "adapter");
        Intrinsics.h(str, "tabCode");
        eVar.L(new Function3() { // from class: com.transsion.home.fragment.tab.b
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit k;
                k = HomePreferencesUiHelperKt.k(HomePreferencesViewModel.this, i, str, (HomePreferencesConfig) obj, (List) obj2, (String) obj3);
                return k;
            }
        });
        eVar.J(new Function1() { // from class: com.transsion.home.fragment.tab.c
            public final Object invoke(Object obj) {
                Unit l;
                l = HomePreferencesUiHelperKt.l(HomePreferencesViewModel.this, i, str, baseProviderMultiAdapter, (HomePreferencesConfig) obj);
                return l;
            }
        });
        eVar.K(new Function1() { // from class: com.transsion.home.fragment.tab.d
            public final Object invoke(Object obj) {
                Unit m;
                m = HomePreferencesUiHelperKt.m(HomePreferencesViewModel.this, i, str, (HomePreferencesConfig) obj);
                return m;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(HomePreferencesViewModel homePreferencesViewModel, int i, String str, HomePreferencesConfig homePreferencesConfig, List list, String str2) {
        Intrinsics.h(homePreferencesConfig, "config");
        Intrinsics.h(list, "selectOptions");
        Intrinsics.h(str2, "scene");
        homePreferencesViewModel.M(homePreferencesConfig, list, str2);
        zk.c.a.r(i, str, homePreferencesConfig, list);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(HomePreferencesViewModel homePreferencesViewModel, int i, String str, BaseProviderMultiAdapter baseProviderMultiAdapter, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(homePreferencesConfig, "config");
        homePreferencesViewModel.C(homePreferencesConfig);
        zk.c.a.p(i, str, homePreferencesConfig);
        Iterator it = baseProviderMultiAdapter.getData().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            OperateItem operateItem = (OperateItem) it.next();
            if (Intrinsics.c(operateItem.getType(), PostItemType.PREFERENCES.getValue())) {
                HomePreferencesConfig homePreferencesConfig2 = operateItem.getHomePreferencesConfig();
                if (Intrinsics.c(homePreferencesConfig2 != null ? homePreferencesConfig2.getLabelId() : null, homePreferencesConfig.getLabelId())) {
                    break;
                }
            }
            i2++;
        }
        if (i2 >= 0) {
            baseProviderMultiAdapter.C0(i2);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(HomePreferencesViewModel homePreferencesViewModel, int i, String str, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(homePreferencesConfig, "config");
        homePreferencesViewModel.D(homePreferencesConfig);
        zk.c.a.q(i, str, homePreferencesConfig);
        return Unit.a;
    }

    public static final List n(List list) {
        Object obj;
        Intrinsics.h(list, "flatList");
        if (list.isEmpty()) {
            return CollectionsKt.l();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            OperateItem operateItem = (OperateItem) list.get(i);
            if (!Intrinsics.c(operateItem.getType(), PostItemType.TRENDING_MARGIN.getValue())) {
                if (Intrinsics.c(operateItem.getType(), PostItemType.FEEDS_TITLE.getValue())) {
                    int i2 = i + 1;
                    Iterator it = list.subList(i2, list.size()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((OperateItem) obj).getOriginalOperateItem() != null) {
                            break;
                        }
                    }
                    OperateItem operateItem2 = (OperateItem) obj;
                    OperateItem originalOperateItem = operateItem2 != null ? operateItem2.getOriginalOperateItem() : null;
                    if (originalOperateItem != null) {
                        if (linkedHashSet.add(originalOperateItem)) {
                            arrayList.add(operateItem);
                        }
                        i = i2;
                    }
                }
                OperateItem originalOperateItem2 = operateItem.getOriginalOperateItem();
                if (originalOperateItem2 == null) {
                    originalOperateItem2 = operateItem;
                }
                if (linkedHashSet.add(originalOperateItem2)) {
                    arrayList.add(operateItem);
                }
            }
            i++;
        }
        return arrayList;
    }

    public static final void o(final BaseHomeSubFragment baseHomeSubFragment, HomePreferencesViewModel homePreferencesViewModel, final BaseProviderMultiAdapter baseProviderMultiAdapter) {
        Intrinsics.h(baseHomeSubFragment, "fragment");
        Intrinsics.h(homePreferencesViewModel, "viewModel");
        Intrinsics.h(baseProviderMultiAdapter, "adapter");
        homePreferencesViewModel.u().j(baseHomeSubFragment.getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.home.fragment.tab.e
            public final Object invoke(Object obj) {
                Unit p;
                p = HomePreferencesUiHelperKt.p(BaseHomeSubFragment.this, baseProviderMultiAdapter, (Pair) obj);
                return p;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(BaseHomeSubFragment baseHomeSubFragment, BaseProviderMultiAdapter baseProviderMultiAdapter, Pair pair) {
        List list;
        String str = (String) pair.component1();
        List list2 = (List) pair.component2();
        if (!Intrinsics.c(str, baseHomeSubFragment.getMTabCode()) || (list = list2) == null || list.isEmpty()) {
            return Unit.a;
        }
        List data = baseProviderMultiAdapter.getData();
        ArrayList arrayList = new ArrayList();
        for (Object obj : data) {
            if (Intrinsics.c(((OperateItem) obj).getType(), PostItemType.PREFERENCES.getValue())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HomePreferencesConfig homePreferencesConfig = ((OperateItem) it.next()).getHomePreferencesConfig();
            String labelId = homePreferencesConfig != null ? homePreferencesConfig.getLabelId() : null;
            if (labelId != null) {
                arrayList2.add(labelId);
            }
        }
        HashSet P0 = CollectionsKt.P0(arrayList2);
        int i = 0;
        for (ok.a aVar : CollectionsKt.I0(list2, new Comparator() { // from class: com.transsion.home.fragment.tab.HomePreferencesUiHelperKt$observeHomePreferencesInsertInstructions$lambda$12$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.d(Integer.valueOf(((ok.a) t).b()), Integer.valueOf(((ok.a) t2).b()));
            }
        })) {
            String labelId2 = aVar.a().getLabelId();
            if (!P0.contains(labelId2)) {
                P0.add(labelId2);
                int l = RangesKt.l((aVar.b() - 1) + i, 4, baseProviderMultiAdapter.getData().size());
                OperateItem operateItem = new OperateItem(null, PostItemType.PREFERENCES.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870909, null);
                operateItem.setHomePreferencesConfig(aVar.a());
                Unit unit = Unit.a;
                baseProviderMultiAdapter.n(l, operateItem);
                i++;
            }
        }
        return Unit.a;
    }
}
