package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomePreferencesShowStyle;
import com.transsion.home.bean.HomePreferencesState;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.repository.HomePreferencesRepository;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HomePreferencesViewModel extends t0 {
    public static final a q = new a(null);
    public static final int r = 8;
    private HomePreferencesState h;
    private boolean p;
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.c
        public final Object invoke() {
            yk.b n;
            n = HomePreferencesViewModel.n();
            return n;
        }
    });
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.d
        public final Object invoke() {
            HomePreferencesRepository I;
            I = HomePreferencesViewModel.I(HomePreferencesViewModel.this);
            return I;
        }
    });
    private final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.e
        public final Object invoke() {
            androidx.lifecycle.b0 G;
            G = HomePreferencesViewModel.G();
            return G;
        }
    });
    private final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.f
        public final Object invoke() {
            androidx.lifecycle.b0 z;
            z = HomePreferencesViewModel.z();
            return z;
        }
    });
    private final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.g
        public final Object invoke() {
            androidx.lifecycle.b0 F;
            F = HomePreferencesViewModel.F();
            return F;
        }
    });
    private final Lazy f = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.h
        public final Object invoke() {
            androidx.lifecycle.b0 H;
            H = HomePreferencesViewModel.H();
            return H;
        }
    });
    private final Lazy g = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.i
        public final Object invoke() {
            androidx.lifecycle.b0 q2;
            q2 = HomePreferencesViewModel.q();
            return q2;
        }
    });
    private final Map i = new LinkedHashMap();
    private final Set j = new LinkedHashSet();
    private final Set k = new LinkedHashSet();
    private final Set l = new LinkedHashSet();
    private final Set m = new LinkedHashSet();
    private final Map n = new LinkedHashMap();
    private final Map o = new LinkedHashMap();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 F() {
        return new androidx.lifecycle.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 G() {
        return new androidx.lifecycle.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 H() {
        return new androidx.lifecycle.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomePreferencesRepository I(HomePreferencesViewModel homePreferencesViewModel) {
        Application a2 = Utils.a();
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Intrinsics.e(a2);
        return new HomePreferencesRepository(homePreferencesViewModel.r(), appDatabase$f1.b(a2));
    }

    private final void K(HomePreferencesConfig homePreferencesConfig, List list, String str, boolean z) {
        String labelId = homePreferencesConfig.getLabelId();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!StringsKt.q0((String) obj)) {
                arrayList.add(obj);
            }
        }
        List H0 = CollectionsKt.H0(CollectionsKt.c0(arrayList));
        if (H0.isEmpty()) {
            a.a.f(wf.a.a, "HomePreferencesViewModel", "submitPreferences skip: empty selection, labelId=" + labelId + ", scene=" + str, false, 4, (Object) null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        List list2 = (List) this.n.get(labelId);
        Long l = (Long) this.o.get(labelId);
        long longValue = l != null ? l.longValue() : 0L;
        if (!z) {
            if (list2 != null && list2.size() == H0.size() && Intrinsics.c(CollectionsKt.W0(list2), CollectionsKt.W0(H0))) {
                a.a.f(wf.a.a, "HomePreferencesViewModel", "submitPreferences skip: same as last, labelId=" + labelId + ", scene=" + str, false, 4, (Object) null);
                return;
            }
            if (currentTimeMillis - longValue < 5000) {
                a.a.f(wf.a.a, "HomePreferencesViewModel", "submitPreferences skip: interval < 5000ms, labelId=" + labelId + ", scene=" + str, false, 4, (Object) null);
                return;
            }
        }
        this.n.put(labelId, H0);
        this.o.put(labelId, Long.valueOf(currentTimeMillis));
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new HomePreferencesViewModel$submitPreferencesInternal$1(this, labelId, H0, z, homePreferencesConfig, str, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(HomePreferencesState homePreferencesState) {
        Object obj;
        if (this.p) {
            return;
        }
        Iterator<T> it = homePreferencesState.getEnterPopConfigs().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            HomePreferencesConfig homePreferencesConfig = (HomePreferencesConfig) obj;
            if (!this.k.contains(homePreferencesConfig.getLabelId()) && !this.l.contains(homePreferencesConfig.getLabelId()) && !this.m.contains(homePreferencesConfig.getLabelId())) {
                break;
            }
        }
        HomePreferencesConfig homePreferencesConfig2 = (HomePreferencesConfig) obj;
        if (homePreferencesConfig2 == null) {
            return;
        }
        this.p = true;
        s().n(homePreferencesConfig2);
    }

    private final void O(String str) {
        HomePreferencesState homePreferencesState;
        Object obj;
        if (this.j.contains(str) || (homePreferencesState = this.h) == null) {
            return;
        }
        List<HomePreferencesConfig> allConfigs = homePreferencesState.getAllConfigs();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : allConfigs) {
            if (StringsKt.H(((HomePreferencesConfig) obj2).getTabCode(), str, true)) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            HomePreferencesConfig homePreferencesConfig = (HomePreferencesConfig) obj;
            if (Intrinsics.c(homePreferencesConfig.getShowStyle(), HomePreferencesShowStyle.POPUP.getValue()) && !this.k.contains(homePreferencesConfig.getLabelId()) && !this.l.contains(homePreferencesConfig.getLabelId()) && !this.m.contains(homePreferencesConfig.getLabelId())) {
                break;
            }
        }
        HomePreferencesConfig homePreferencesConfig2 = (HomePreferencesConfig) obj;
        if (homePreferencesConfig2 != null && Intrinsics.c(homePreferencesConfig2.getShowStyle(), HomePreferencesShowStyle.POPUP.getValue())) {
            this.j.add(str);
            v().n(TuplesKt.a(str, homePreferencesConfig2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yk.b n() {
        return (yk.b) kg.c.e.a().h(yk.b.class);
    }

    private final List o(String str, List list, HomePreferencesState homePreferencesState) {
        List<HomePreferencesConfig> allConfigs = homePreferencesState.getAllConfigs();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allConfigs) {
            if (StringsKt.H(((HomePreferencesConfig) obj).getTabCode(), str, true)) {
                arrayList.add(obj);
            }
        }
        ArrayList<HomePreferencesConfig> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            HomePreferencesConfig homePreferencesConfig = (HomePreferencesConfig) obj2;
            if (Intrinsics.c(homePreferencesConfig.getShowStyle(), HomePreferencesShowStyle.OPT_INSERT.getValue()) && !this.k.contains(homePreferencesConfig.getLabelId()) && !this.l.contains(homePreferencesConfig.getLabelId()) && !this.m.contains(homePreferencesConfig.getLabelId())) {
                arrayList2.add(obj2);
            }
        }
        if (arrayList2.isEmpty()) {
            return CollectionsKt.l();
        }
        ArrayList arrayList3 = new ArrayList();
        for (HomePreferencesConfig homePreferencesConfig2 : arrayList2) {
            Integer pos = homePreferencesConfig2.getPos();
            Integer valueOf = Integer.valueOf(pos != null ? pos.intValue() : -1);
            if (valueOf.intValue() < 0) {
                valueOf = null;
            }
            boolean z = false;
            int l = RangesKt.l(valueOf != null ? valueOf.intValue() : list.size(), 0, list.size());
            List list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    OperateItem operateItem = (OperateItem) it.next();
                    if (Intrinsics.c(operateItem.getType(), PostItemType.PREFERENCES.getValue())) {
                        HomePreferencesConfig homePreferencesConfig3 = operateItem.getHomePreferencesConfig();
                        if (Intrinsics.c(homePreferencesConfig3 != null ? homePreferencesConfig3.getLabelId() : null, homePreferencesConfig2.getLabelId())) {
                            z = true;
                            break;
                        }
                    }
                }
            }
            a.a.f(wf.a.a, "HomePreferencesViewModel", "运营位插入 有配置, tabCode:" + str + ", pos:" + homePreferencesConfig2.getPos() + "， alreadyExists：" + z, false, 4, (Object) null);
            if (!z) {
                arrayList3.add(new ok.a(l, homePreferencesConfig2));
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String str) {
        List list = (List) this.i.get(str);
        if (list == null) {
            return;
        }
        HomePreferencesState homePreferencesState = this.h;
        if (homePreferencesState == null) {
            u().n(TuplesKt.a(str, CollectionsKt.l()));
            return;
        }
        List o = o(str, list, homePreferencesState);
        a.a.f(wf.a.a, "HomePreferencesViewModel", "computeInsertForTab, tabCode:" + str + ", size:" + o.size(), false, 4, (Object) null);
        u().n(TuplesKt.a(str, o));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 q() {
        return new androidx.lifecycle.b0();
    }

    private final yk.b r() {
        return (yk.b) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomePreferencesRepository y() {
        return (HomePreferencesRepository) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 z() {
        return new androidx.lifecycle.b0();
    }

    public final void A() {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new HomePreferencesViewModel$loadHomePreferencesConfig$1(this, null), 2, (Object) null);
    }

    public final void B(HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(homePreferencesConfig, "config");
        this.m.add(homePreferencesConfig.getLabelId());
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new HomePreferencesViewModel$markChosen$1(this, homePreferencesConfig, null), 2, (Object) null);
    }

    public final void C(HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(homePreferencesConfig, "config");
        this.l.add(homePreferencesConfig.getLabelId());
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new HomePreferencesViewModel$markClosed$1(this, homePreferencesConfig, null), 2, (Object) null);
    }

    public final void D(HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(homePreferencesConfig, "config");
        String labelId = homePreferencesConfig.getLabelId();
        if (!this.k.contains(labelId)) {
            this.k.add(labelId);
            kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new HomePreferencesViewModel$markShown$1(this, homePreferencesConfig, null), 2, (Object) null);
            return;
        }
        a.a.f(wf.a.a, "HomePreferencesViewModel", "markShown skip, already marked, labelId=" + labelId, false, 4, (Object) null);
    }

    public final void E(String str, List list) {
        Intrinsics.h(str, "tabCode");
        Intrinsics.h(list, "list");
        this.i.put(str, list);
        p(str);
    }

    public final void J(String str) {
        Intrinsics.h(str, "tabCode");
        O(str);
    }

    public final void L(HomePreferencesConfig homePreferencesConfig, List list) {
        Intrinsics.h(homePreferencesConfig, "config");
        Intrinsics.h(list, "selectOptions");
        K(homePreferencesConfig, list, "popup_confirm", true);
    }

    public final void M(HomePreferencesConfig homePreferencesConfig, List list, String str) {
        Intrinsics.h(homePreferencesConfig, "config");
        Intrinsics.h(list, "selectOptions");
        Intrinsics.h(str, "scene");
        K(homePreferencesConfig, list, str, false);
    }

    public final androidx.lifecycle.b0 s() {
        return (androidx.lifecycle.b0) this.g.getValue();
    }

    public final List t(String str, List list) {
        Intrinsics.h(str, "tabCode");
        Intrinsics.h(list, "list");
        HomePreferencesState homePreferencesState = this.h;
        return homePreferencesState == null ? CollectionsKt.l() : o(str, list, homePreferencesState);
    }

    public final androidx.lifecycle.b0 u() {
        return (androidx.lifecycle.b0) this.d.getValue();
    }

    public final androidx.lifecycle.b0 v() {
        return (androidx.lifecycle.b0) this.e.getValue();
    }

    public final androidx.lifecycle.b0 w() {
        return (androidx.lifecycle.b0) this.c.getValue();
    }

    public final androidx.lifecycle.b0 x() {
        return (androidx.lifecycle.b0) this.f.getValue();
    }
}
