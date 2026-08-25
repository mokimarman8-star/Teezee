package com.transsion.home.viewmodel.preload;

import android.content.Context;
import androidx.lifecycle.b0;
import com.blankj.utilcode.util.o;
import com.google.gson.Gson;
import com.therouter.TheRouter;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.BottomTabItem;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.bean.HotSubjectEntity;
import com.transsion.home.bean.MainOperateData;
import com.transsion.home.enum.BottomTabType;
import com.transsion.home.p000enum.HomeTabType;
import ep.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class PreloadTrendingData {
    public static final a n = new a((DefaultConstructorMarker) null);
    public static final int o = 8;
    private static final Lazy p = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.home.viewmodel.preload.b
        public final Object invoke() {
            PreloadTrendingData P;
            P = PreloadTrendingData.P();
            return P;
        }
    });
    private volatile boolean b;
    private volatile boolean c;
    private AppTab k;
    private List l;
    private int a = 1;
    private final yk.e d = (yk.e) kg.c.e.a().h(yk.e.class);
    private final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.c
        public final Object invoke() {
            a w;
            w = PreloadTrendingData.w();
            return w;
        }
    });
    private final Lazy f = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.d
        public final Object invoke() {
            b0 S;
            S = PreloadTrendingData.S();
            return S;
        }
    });
    private final Lazy g = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.e
        public final Object invoke() {
            b0 R;
            R = PreloadTrendingData.R();
            return R;
        }
    });
    private final Lazy h = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.f
        public final Object invoke() {
            b0 v;
            v = PreloadTrendingData.v();
            return v;
        }
    });
    private final Lazy i = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.g
        public final Object invoke() {
            b0 u;
            u = PreloadTrendingData.u();
            return u;
        }
    });
    private final Lazy j = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.h
        public final Object invoke() {
            b0 N;
            N = PreloadTrendingData.N();
            return N;
        }
    });
    private final j0 m = new b(j0.l1);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x000f, TRY_LEAVE, TryCatch #0 {all -> 0x000f, blocks: (B:3:0x0002, B:5:0x0008, B:8:0x0026, B:10:0x002c, B:15:0x0011), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.transsion.home.bean.AppTab B() {
        /*
            r6 = this;
            java.lang.String r0 = "app_tab"
            java.lang.String r1 = r6.Y(r0)     // Catch: java.lang.Throwable -> Lf
            if (r1 == 0) goto L11
            int r2 = r1.length()     // Catch: java.lang.Throwable -> Lf
            if (r2 != 0) goto L26
            goto L11
        Lf:
            r1 = move-exception
            goto L35
        L11:
            com.transsion.home.viewmodel.preload.a r1 = r6.E()     // Catch: java.lang.Throwable -> Lf
            android.app.Application r2 = com.blankj.utilcode.util.Utils.a()     // Catch: java.lang.Throwable -> Lf
            java.lang.String r3 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r2, r3)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r1 = r1.b(r2)     // Catch: java.lang.Throwable -> Lf
            if (r1 != 0) goto L26
            java.lang.String r1 = ""
        L26:
            int r2 = r1.length()     // Catch: java.lang.Throwable -> Lf
            if (r2 <= 0) goto L5e
            java.lang.Class<com.transsion.home.bean.AppTab> r2 = com.transsion.home.bean.AppTab.class
            java.lang.Object r1 = com.blankj.utilcode.util.o.d(r1, r2)     // Catch: java.lang.Throwable -> Lf
            com.transsion.home.bean.AppTab r1 = (com.transsion.home.bean.AppTab) r1     // Catch: java.lang.Throwable -> Lf
            return r1
        L35:
            wf.a$a r2 = wf.a.a
            java.lang.String r3 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getAppTabCache error: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r4 = 1
            java.lang.String r5 = "PreloadTrending"
            r2.i(r5, r3, r4)
            com.transsion.baselib.report.launch.b r2 = com.transsion.baselib.report.launch.b.a
            com.tencent.mmkv.MMKV r2 = r2.b()
            r2.M(r0)
            r1.printStackTrace()
        L5e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.viewmodel.preload.PreloadTrendingData.B():com.transsion.home.bean.AppTab");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a E() {
        return (a) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HotSubjectEntity I() {
        String string = com.transsion.baselib.report.launch.b.a.b().getString("hot_search_words", null);
        if (string != null) {
            return (HotSubjectEntity) o.d(string, HotSubjectEntity.class);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 N() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(AppTab appTab) {
        BottomTabItem bottomTabItem;
        BottomTabItem bottomTabItem2;
        List bottomTabs;
        Object obj;
        List bottomTabs2;
        Object obj2;
        Object obj3 = null;
        if (appTab == null || (bottomTabs2 = appTab.getBottomTabs()) == null) {
            bottomTabItem = null;
        } else {
            Iterator it = bottomTabs2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it.next();
                    if (Intrinsics.c(((BottomTabItem) obj2).getBtTabCode(), "COMMUNITY")) {
                        break;
                    }
                }
            }
            bottomTabItem = (BottomTabItem) obj2;
        }
        if (bottomTabItem != null) {
            a.a.f(wf.a.a, "PreloadTrending", "has bottom room tab", false, 4, (Object) null);
            k.a.l(true);
            return;
        }
        if (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) {
            bottomTabItem2 = null;
        } else {
            Iterator it2 = bottomTabs.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it2.next();
                    if (Intrinsics.c(((BottomTabItem) obj).getBtTabCode(), "HOME")) {
                        break;
                    }
                }
            }
            bottomTabItem2 = (BottomTabItem) obj;
        }
        if (bottomTabItem2 == null) {
            a.a.f(wf.a.a, "PreloadTrending", "has no room tab", false, 4, (Object) null);
            k.a.l(false);
            return;
        }
        List subTabs = bottomTabItem2.getSubTabs();
        if (subTabs != null) {
            Iterator it3 = subTabs.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                HomeTabItem homeTabItem = (HomeTabItem) next;
                if (Intrinsics.c(homeTabItem != null ? homeTabItem.getTabCode() : null, "Community")) {
                    obj3 = next;
                    break;
                }
            }
            obj3 = (HomeTabItem) obj3;
        }
        a.a.f(wf.a.a, "PreloadTrending", "has top room tab:" + (obj3 != null), false, 4, (Object) null);
        k.a.l(obj3 != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreloadTrendingData P() {
        return new PreloadTrendingData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 R() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 S() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|(2:3|(11:5|6|7|8|(1:(2:11|12)(2:40|41))(3:42|43|(1:45))|13|(1:39)(1:17)|18|(1:38)(3:22|(2:24|(1:33))|34)|35|36))|48|6|7|8|(0)(0)|13|(1:15)|39|18|(1:20)|38|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0032, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00de, code lost:
    
        wf.a.a.i("PreloadTrending", "get Operating List msg=" + r13.getMessage() + " cause=" + r13.getCause(), true);
        K().n((java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object T(java.lang.String r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.viewmodel.preload.PreloadTrendingData.T(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void V(Context context) {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PreloadTrendingData$preloadSkuDataCache$1(context, null), 3, (Object) null);
    }

    private final void W(Context context) {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PreloadTrendingData$preloadVideoCache$1(this, context, null), 3, (Object) null);
    }

    private final String Y(String str) {
        try {
            byte[] e = com.transsion.baselib.report.launch.b.a.b().e(str);
            if (e == null) {
                return null;
            }
            if (e.length == 0) {
                return null;
            }
            return new String(e, Charsets.b);
        } catch (Throwable th) {
            wf.a.a.i("PreloadTrending", "safeGetMmkvString failed for key: " + str + ", " + th.getMessage(), true);
            return null;
        }
    }

    private final void Z(MainOperateData mainOperateData) {
        if (mainOperateData.getItems() == null || !(!r0.isEmpty())) {
            return;
        }
        com.transsion.baselib.report.launch.b.a.b().putString("main_operating_data", new Gson().toJson(mainOperateData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(AppTab appTab) {
        List bottomTabs = appTab != null ? appTab.getBottomTabs() : null;
        if (bottomTabs == null || bottomTabs.isEmpty()) {
            return;
        }
        com.transsion.baselib.report.launch.b.a.b().putString("app_tab", o.j(appTab));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 u() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 v() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a w() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List x(AppTab appTab) {
        List bottomTabs;
        ArrayList arrayList = new ArrayList();
        for (BottomTabType bottomTabType : BottomTabType.values()) {
            CollectionsKt.B(arrayList, CollectionsKt.e(bottomTabType.getValue()));
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        boolean z = bVar != null ? bVar.z() : false;
        if (!z) {
            a.a.f(wf.a.a, "co_mem", "MainActivity --> getTabEntities() --> 当前没有开启会员功能 --> 不展示会员Tab", false, 4, (Object) null);
        }
        if (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : bottomTabs) {
            BottomTabItem bottomTabItem = (BottomTabItem) obj;
            if (Intrinsics.c(bottomTabItem.getBtTabType(), BottomTabType.PREMIUM.getValue()) ? CollectionsKt.b0(arrayList, bottomTabItem.getBtTabType()) && z : CollectionsKt.b0(arrayList, bottomTabItem.getBtTabType())) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.U0(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List y(List list) {
        ArrayList arrayList = new ArrayList();
        for (HomeTabType homeTabType : HomeTabType.values()) {
            CollectionsKt.B(arrayList, CollectionsKt.e(homeTabType.getValue()));
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            HomeTabItem homeTabItem = (HomeTabItem) obj;
            if (homeTabItem != null && CollectionsKt.b0(arrayList, homeTabItem.getType())) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.U0(arrayList2);
    }

    public final AppTab A(Context context) {
        Intrinsics.h(context, "context");
        try {
            String b = E().b(context);
            if (b != null && b.length() != 0) {
                return (AppTab) o.d(b, AppTab.class);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final b0 C() {
        return (b0) this.i.getValue();
    }

    public final b0 D() {
        return (b0) this.h.getValue();
    }

    public final AppTab F() {
        return this.k;
    }

    public final void G() {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PreloadTrendingData$getHotSearch$1(this, null), 3, (Object) null);
    }

    public final b0 H() {
        return (b0) this.j.getValue();
    }

    public final b0 J() {
        return (b0) this.g.getValue();
    }

    public final b0 K() {
        return (b0) this.f.getValue();
    }

    public final List L() {
        List list = this.l;
        this.l = null;
        return list;
    }

    public final boolean M() {
        return this.c;
    }

    public final boolean Q(String str) {
        Intrinsics.h(str, "version");
        if (this.b) {
            return false;
        }
        this.b = true;
        i.d(o0.a(y0.b()), this.m, (CoroutineStart) null, new loadOperatingDataFromNet.1(this, str, (Continuation) null), 2, (Object) null);
        return true;
    }

    public final void U(Context context) {
        Intrinsics.h(context, "context");
        wf.a.a.c("PreloadTrending", "preloadOperatingCache() called", true);
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new preloadOperating.1(this, context, (Continuation) null), 3, (Object) null);
        W(context);
        V(context);
    }

    public final boolean X(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "operationVersion");
        if (J().f() != null) {
            return Q(str);
        }
        U(context);
        return true;
    }

    public final void b0(List list) {
        Intrinsics.h(list, "list");
        this.l = list;
    }

    public final void z() {
        this.c = true;
        wf.a.a.c("PreloadTrending", "getAppTab() called", true);
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new getAppTab.1(this, (Continuation) null), 3, (Object) null);
    }
}
