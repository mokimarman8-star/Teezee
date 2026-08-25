package com.transsion.home.repository;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomePreferencesIntervalTime;
import com.transsion.home.bean.HomePreferencesList;
import com.transsion.home.bean.HomePreferencesShowStyle;
import com.transsion.home.bean.HomePreferencesState;
import com.transsion.home.bean.HomePreferencesSubmitRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;
import yk.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HomePreferencesRepository {
    public static final a c = new a(null);
    public static final int d = 8;
    private final yk.b a;
    private final vi.a b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HomePreferencesRepository(yk.b bVar, AppDatabase appDatabase) {
        Intrinsics.h(bVar, "api");
        Intrinsics.h(appDatabase, "appDatabase");
        this.a = bVar;
        this.b = appDatabase.q1();
    }

    private final boolean e(long j, HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean, HomePreferencesIntervalTime homePreferencesIntervalTime) {
        long j2;
        long j3;
        if (homePreferencesIntervalTimeDbBean == null) {
            return true;
        }
        long showInterval = homePreferencesIntervalTime.getShowInterval();
        long closeInterval = homePreferencesIntervalTime.getCloseInterval();
        long chooseInterval = homePreferencesIntervalTime.getChooseInterval();
        if (homePreferencesIntervalTimeDbBean.getShowTime() <= 0 || showInterval <= 0) {
            j2 = 0;
            j3 = 0;
        } else {
            long showTime = homePreferencesIntervalTimeDbBean.getShowTime() + (showInterval * 1000);
            j2 = 0;
            j3 = Math.max(0L, showTime);
        }
        if (homePreferencesIntervalTimeDbBean.getCloseTime() > j2 && closeInterval > j2) {
            j3 = Math.max(j3, homePreferencesIntervalTimeDbBean.getCloseTime() + (closeInterval * 1000));
        }
        if (homePreferencesIntervalTimeDbBean.getChooseTime() > 0 && chooseInterval > 0) {
            j3 = Math.max(j3, homePreferencesIntervalTimeDbBean.getChooseTime() + (chooseInterval * 1000));
        }
        a.a aVar = wf.a.a;
        boolean z = j >= j3;
        a.a.l(aVar, "HomePreferencesRepository", "----canShow:>>>> " + z + " <<<<<, id:" + homePreferencesIntervalTimeDbBean.getId() + ",now:" + j + ", showTime:" + homePreferencesIntervalTimeDbBean.getShowTime() + ", closeTime:" + homePreferencesIntervalTimeDbBean.getCloseTime() + ", chooseTime:" + homePreferencesIntervalTimeDbBean.getChooseTime(), false, 4, (Object) null);
        return j >= j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean, long j) {
        Intrinsics.h(homePreferencesIntervalTimeDbBean, "bean");
        homePreferencesIntervalTimeDbBean.setChooseTime(j);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean, long j) {
        Intrinsics.h(homePreferencesIntervalTimeDbBean, "bean");
        homePreferencesIntervalTimeDbBean.setCloseTime(j);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean, long j) {
        Intrinsics.h(homePreferencesIntervalTimeDbBean, "bean");
        homePreferencesIntervalTimeDbBean.setShowTime(j);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n(HomePreferencesConfig homePreferencesConfig, Function2 function2, Continuation continuation) {
        HomePreferencesRepository$updateIntervalRecord$1 homePreferencesRepository$updateIntervalRecord$1;
        Object f;
        int i;
        HomePreferencesConfig homePreferencesConfig2;
        String str;
        long j;
        Function2 function22;
        HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean;
        HomePreferencesIntervalTimeDbBean copy;
        vi.a aVar;
        if (continuation instanceof HomePreferencesRepository$updateIntervalRecord$1) {
            homePreferencesRepository$updateIntervalRecord$1 = (HomePreferencesRepository$updateIntervalRecord$1) continuation;
            int i2 = homePreferencesRepository$updateIntervalRecord$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                homePreferencesRepository$updateIntervalRecord$1.label = i2 - Integer.MIN_VALUE;
                Object obj = homePreferencesRepository$updateIntervalRecord$1.result;
                f = IntrinsicsKt.f();
                i = homePreferencesRepository$updateIntervalRecord$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    long currentTimeMillis = System.currentTimeMillis();
                    String labelId = homePreferencesConfig.getLabelId();
                    vi.a aVar2 = this.b;
                    homePreferencesConfig2 = homePreferencesConfig;
                    homePreferencesRepository$updateIntervalRecord$1.L$0 = homePreferencesConfig2;
                    homePreferencesRepository$updateIntervalRecord$1.L$1 = function2;
                    homePreferencesRepository$updateIntervalRecord$1.L$2 = labelId;
                    homePreferencesRepository$updateIntervalRecord$1.J$0 = currentTimeMillis;
                    homePreferencesRepository$updateIntervalRecord$1.label = 1;
                    obj = aVar2.b(labelId, homePreferencesRepository$updateIntervalRecord$1);
                    if (obj == f) {
                        return f;
                    }
                    str = labelId;
                    j = currentTimeMillis;
                    function22 = function2;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        return Unit.a;
                    }
                    j = homePreferencesRepository$updateIntervalRecord$1.J$0;
                    String str2 = (String) homePreferencesRepository$updateIntervalRecord$1.L$2;
                    function22 = (Function2) homePreferencesRepository$updateIntervalRecord$1.L$1;
                    homePreferencesConfig2 = (HomePreferencesConfig) homePreferencesRepository$updateIntervalRecord$1.L$0;
                    ResultKt.b(obj);
                    str = str2;
                }
                homePreferencesIntervalTimeDbBean = (HomePreferencesIntervalTimeDbBean) obj;
                if (homePreferencesIntervalTimeDbBean == null) {
                    homePreferencesIntervalTimeDbBean = new HomePreferencesIntervalTimeDbBean(str, 0L, 0L, 0L, homePreferencesConfig2.getIntervalTime().getShowInterval(), homePreferencesConfig2.getIntervalTime().getCloseInterval(), homePreferencesConfig2.getIntervalTime().getChooseInterval());
                }
                copy = r24.copy((r28 & 1) != 0 ? r24.id : null, (r28 & 2) != 0 ? r24.showTime : 0L, (r28 & 4) != 0 ? r24.closeTime : 0L, (r28 & 8) != 0 ? r24.chooseTime : 0L, (r28 & 16) != 0 ? r24.showIntervalSeconds : homePreferencesConfig2.getIntervalTime().getShowInterval(), (r28 & 32) != 0 ? r24.closeIntervalSeconds : homePreferencesConfig2.getIntervalTime().getCloseInterval(), (r28 & 64) != 0 ? homePreferencesIntervalTimeDbBean.chooseIntervalSeconds : homePreferencesConfig2.getIntervalTime().getChooseInterval());
                function22.invoke(copy, Boxing.e(j));
                aVar = this.b;
                homePreferencesRepository$updateIntervalRecord$1.L$0 = null;
                homePreferencesRepository$updateIntervalRecord$1.L$1 = null;
                homePreferencesRepository$updateIntervalRecord$1.L$2 = null;
                homePreferencesRepository$updateIntervalRecord$1.label = 2;
                if (aVar.a(copy, homePreferencesRepository$updateIntervalRecord$1) == f) {
                    return f;
                }
                return Unit.a;
            }
        }
        homePreferencesRepository$updateIntervalRecord$1 = new HomePreferencesRepository$updateIntervalRecord$1(this, continuation);
        Object obj2 = homePreferencesRepository$updateIntervalRecord$1.result;
        f = IntrinsicsKt.f();
        i = homePreferencesRepository$updateIntervalRecord$1.label;
        if (i != 0) {
        }
        homePreferencesIntervalTimeDbBean = (HomePreferencesIntervalTimeDbBean) obj2;
        if (homePreferencesIntervalTimeDbBean == null) {
        }
        copy = r24.copy((r28 & 1) != 0 ? r24.id : null, (r28 & 2) != 0 ? r24.showTime : 0L, (r28 & 4) != 0 ? r24.closeTime : 0L, (r28 & 8) != 0 ? r24.chooseTime : 0L, (r28 & 16) != 0 ? r24.showIntervalSeconds : homePreferencesConfig2.getIntervalTime().getShowInterval(), (r28 & 32) != 0 ? r24.closeIntervalSeconds : homePreferencesConfig2.getIntervalTime().getCloseInterval(), (r28 & 64) != 0 ? homePreferencesIntervalTimeDbBean.chooseIntervalSeconds : homePreferencesConfig2.getIntervalTime().getChooseInterval());
        function22.invoke(copy, Boxing.e(j));
        aVar = this.b;
        homePreferencesRepository$updateIntervalRecord$1.L$0 = null;
        homePreferencesRepository$updateIntervalRecord$1.L$1 = null;
        homePreferencesRepository$updateIntervalRecord$1.L$2 = null;
        homePreferencesRepository$updateIntervalRecord$1.label = 2;
        if (aVar.a(copy, homePreferencesRepository$updateIntervalRecord$1) == f) {
        }
        return Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0130 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:12:0x0041, B:13:0x0124, B:15:0x0130, B:16:0x0159, B:22:0x0108), top: B:11:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0123 -> B:13:0x0124). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(String str, Continuation continuation) {
        HomePreferencesRepository$loadPreferencesState$1 homePreferencesRepository$loadPreferencesState$1;
        int i;
        String str2;
        List<HomePreferencesConfig> preferences;
        long currentTimeMillis;
        List arrayList;
        Iterator<HomePreferencesConfig> it;
        Object obj;
        if (continuation instanceof HomePreferencesRepository$loadPreferencesState$1) {
            homePreferencesRepository$loadPreferencesState$1 = (HomePreferencesRepository$loadPreferencesState$1) continuation;
            int i2 = homePreferencesRepository$loadPreferencesState$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                homePreferencesRepository$loadPreferencesState$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = homePreferencesRepository$loadPreferencesState$1.result;
                Object f = IntrinsicsKt.f();
                i = homePreferencesRepository$loadPreferencesState$1.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    yk.b bVar = this.a;
                    str2 = str;
                    homePreferencesRepository$loadPreferencesState$1.L$0 = str2;
                    homePreferencesRepository$loadPreferencesState$1.label = 1;
                    obj2 = b.a.a(bVar, null, homePreferencesRepository$loadPreferencesState$1, 1, null);
                    if (obj2 == f) {
                        return f;
                    }
                } else if (i == 1) {
                    str2 = (String) homePreferencesRepository$loadPreferencesState$1.L$0;
                    ResultKt.b(obj2);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    currentTimeMillis = homePreferencesRepository$loadPreferencesState$1.J$0;
                    HomePreferencesRepository homePreferencesRepository = (HomePreferencesRepository) homePreferencesRepository$loadPreferencesState$1.L$3;
                    HomePreferencesConfig homePreferencesConfig = (HomePreferencesConfig) homePreferencesRepository$loadPreferencesState$1.L$2;
                    it = (Iterator) homePreferencesRepository$loadPreferencesState$1.L$1;
                    arrayList = (List) homePreferencesRepository$loadPreferencesState$1.L$0;
                    try {
                        ResultKt.b(obj2);
                    } catch (Throwable th2) {
                        Result.Companion companion = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.a(th2));
                    }
                    if (homePreferencesRepository.e(currentTimeMillis, (HomePreferencesIntervalTimeDbBean) obj2, homePreferencesConfig.getIntervalTime())) {
                        arrayList.add(homePreferencesConfig);
                        wf.a.a.c("HomePreferencesRepository", "loadPreferencesState  tabCode:" + homePreferencesConfig.getTabCode() + ", showStyle:" + homePreferencesConfig.getShowStyle(), true);
                    }
                    obj = Result.constructor-impl(Unit.a);
                    Throwable th3 = Result.exceptionOrNull-impl(obj);
                    if (th3 != null) {
                        a.a.l(wf.a.a, "HomePreferencesRepository", "loadPreferencesState canShow error: " + th3.getMessage(), false, 4, (Object) null);
                        arrayList.add(homePreferencesConfig);
                    }
                    if (it.hasNext()) {
                        homePreferencesConfig = it.next();
                        Result.Companion companion2 = Result.Companion;
                        String labelId = homePreferencesConfig.getLabelId();
                        vi.a aVar = this.b;
                        homePreferencesRepository$loadPreferencesState$1.L$0 = arrayList;
                        homePreferencesRepository$loadPreferencesState$1.L$1 = it;
                        homePreferencesRepository$loadPreferencesState$1.L$2 = homePreferencesConfig;
                        homePreferencesRepository$loadPreferencesState$1.L$3 = this;
                        homePreferencesRepository$loadPreferencesState$1.J$0 = currentTimeMillis;
                        homePreferencesRepository$loadPreferencesState$1.label = 2;
                        obj2 = aVar.b(labelId, homePreferencesRepository$loadPreferencesState$1);
                        if (obj2 == f) {
                            return f;
                        }
                        homePreferencesRepository = this;
                        if (homePreferencesRepository.e(currentTimeMillis, (HomePreferencesIntervalTimeDbBean) obj2, homePreferencesConfig.getIntervalTime())) {
                        }
                        obj = Result.constructor-impl(Unit.a);
                        Throwable th32 = Result.exceptionOrNull-impl(obj);
                        if (th32 != null) {
                        }
                        if (it.hasNext()) {
                            List list = arrayList;
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj3 : list) {
                                if (Intrinsics.c(((HomePreferencesConfig) obj3).getShowStyle(), HomePreferencesShowStyle.OPT_INSERT.getValue())) {
                                    arrayList2.add(obj3);
                                }
                            }
                            ArrayList arrayList3 = new ArrayList();
                            for (Object obj4 : list) {
                                if (Intrinsics.c(((HomePreferencesConfig) obj4).getShowStyle(), HomePreferencesShowStyle.POPUP.getValue())) {
                                    arrayList3.add(obj4);
                                }
                            }
                            ArrayList arrayList4 = new ArrayList();
                            for (Object obj5 : list) {
                                if (Intrinsics.c(((HomePreferencesConfig) obj5).getShowStyle(), HomePreferencesShowStyle.ENTER_POP.getValue())) {
                                    arrayList4.add(obj5);
                                }
                            }
                            return new HomePreferencesState(arrayList, arrayList2, arrayList3, arrayList4);
                        }
                    }
                }
                HomePreferencesList homePreferencesList = (HomePreferencesList) ((BaseDto) obj2).getData();
                preferences = homePreferencesList != null ? homePreferencesList.getPreferences() : null;
                if (preferences == null) {
                    preferences = CollectionsKt.l();
                }
                if (!preferences.isEmpty()) {
                    wf.a.a.i("HomePreferencesRepository", "loadPreferencesState config is empty ~", true);
                    return new HomePreferencesState(CollectionsKt.l(), CollectionsKt.l(), CollectionsKt.l(), CollectionsKt.l());
                }
                wf.a.a.c("HomePreferencesRepository", "loadPreferencesState success " + preferences.size(), true);
                currentTimeMillis = System.currentTimeMillis();
                if (str2 != null && str2.length() != 0) {
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj6 : preferences) {
                        if (StringsKt.H(((HomePreferencesConfig) obj6).getTabCode(), str2, true)) {
                            arrayList5.add(obj6);
                        }
                    }
                    preferences = arrayList5;
                }
                arrayList = new ArrayList();
                it = preferences.iterator();
                if (it.hasNext()) {
                }
            }
        }
        homePreferencesRepository$loadPreferencesState$1 = new HomePreferencesRepository$loadPreferencesState$1(this, continuation);
        Object obj22 = homePreferencesRepository$loadPreferencesState$1.result;
        Object f2 = IntrinsicsKt.f();
        i = homePreferencesRepository$loadPreferencesState$1.label;
        if (i != 0) {
        }
        HomePreferencesList homePreferencesList2 = (HomePreferencesList) ((BaseDto) obj22).getData();
        if (homePreferencesList2 != null) {
        }
        if (preferences == null) {
        }
        if (!preferences.isEmpty()) {
        }
    }

    public final Object g(HomePreferencesConfig homePreferencesConfig, Continuation continuation) {
        Object n = n(homePreferencesConfig, new Function2() { // from class: com.transsion.home.repository.b
            public final Object invoke(Object obj, Object obj2) {
                Unit h;
                h = HomePreferencesRepository.h((HomePreferencesIntervalTimeDbBean) obj, ((Long) obj2).longValue());
                return h;
            }
        }, continuation);
        return n == IntrinsicsKt.f() ? n : Unit.a;
    }

    public final Object i(HomePreferencesConfig homePreferencesConfig, Continuation continuation) {
        Object n = n(homePreferencesConfig, new Function2() { // from class: com.transsion.home.repository.a
            public final Object invoke(Object obj, Object obj2) {
                Unit j;
                j = HomePreferencesRepository.j((HomePreferencesIntervalTimeDbBean) obj, ((Long) obj2).longValue());
                return j;
            }
        }, continuation);
        return n == IntrinsicsKt.f() ? n : Unit.a;
    }

    public final Object k(HomePreferencesConfig homePreferencesConfig, Continuation continuation) {
        Object n = n(homePreferencesConfig, new Function2() { // from class: com.transsion.home.repository.c
            public final Object invoke(Object obj, Object obj2) {
                Unit l;
                l = HomePreferencesRepository.l((HomePreferencesIntervalTimeDbBean) obj, ((Long) obj2).longValue());
                return l;
            }
        }, continuation);
        return n == IntrinsicsKt.f() ? n : Unit.a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:24|25))(2:26|(2:28|29)(3:30|31|(1:33)))|13|14|(1:16)|17|(1:19)|20|21))|36|6|7|8|(0)(0)|13|14|(0)|17|(0)|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0034, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
    
        r0 = kotlin.Result.Companion;
        r14 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r14));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(String str, List list, Continuation continuation) {
        HomePreferencesRepository$submitPreferences$1 homePreferencesRepository$submitPreferences$1;
        int i;
        Object obj;
        Throwable th2;
        if (continuation instanceof HomePreferencesRepository$submitPreferences$1) {
            homePreferencesRepository$submitPreferences$1 = (HomePreferencesRepository$submitPreferences$1) continuation;
            int i2 = homePreferencesRepository$submitPreferences$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                homePreferencesRepository$submitPreferences$1.label = i2 - Integer.MIN_VALUE;
                HomePreferencesRepository$submitPreferences$1 homePreferencesRepository$submitPreferences$12 = homePreferencesRepository$submitPreferences$1;
                Object obj2 = homePreferencesRepository$submitPreferences$12.result;
                Object f = IntrinsicsKt.f();
                i = homePreferencesRepository$submitPreferences$12.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    if (list.isEmpty()) {
                        a.a.f(wf.a.a, "HomePreferencesRepository", "submitPreferences skip: empty options, labelId=" + str, false, 4, (Object) null);
                        return Unit.a;
                    }
                    HomePreferencesSubmitRequest homePreferencesSubmitRequest = new HomePreferencesSubmitRequest(str, list);
                    Result.Companion companion = Result.Companion;
                    yk.b bVar = this.a;
                    homePreferencesRepository$submitPreferences$12.L$0 = str;
                    homePreferencesRepository$submitPreferences$12.L$1 = list;
                    homePreferencesRepository$submitPreferences$12.label = 1;
                    obj2 = b.a.c(bVar, null, homePreferencesSubmitRequest, homePreferencesRepository$submitPreferences$12, 1, null);
                    if (obj2 == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) homePreferencesRepository$submitPreferences$12.L$1;
                    str = (String) homePreferencesRepository$submitPreferences$12.L$0;
                    ResultKt.b(obj2);
                }
                obj = Result.constructor-impl((BaseDto) obj2);
                if (Result.isSuccess-impl(obj)) {
                    a.a.r(wf.a.a, "HomePreferencesRepository", new String[]{"submitPreferences success, labelId=" + str + ", options=" + list}, false, 4, (Object) null);
                }
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    a.a.l(wf.a.a, "HomePreferencesRepository", "submitPreferences error, labelId=" + str + ", msg=" + th2.getMessage(), false, 4, (Object) null);
                }
                return Unit.a;
            }
        }
        homePreferencesRepository$submitPreferences$1 = new HomePreferencesRepository$submitPreferences$1(this, continuation);
        HomePreferencesRepository$submitPreferences$1 homePreferencesRepository$submitPreferences$122 = homePreferencesRepository$submitPreferences$1;
        Object obj22 = homePreferencesRepository$submitPreferences$122.result;
        Object f2 = IntrinsicsKt.f();
        i = homePreferencesRepository$submitPreferences$122.label;
        if (i != 0) {
        }
        obj = Result.constructor-impl((BaseDto) obj22);
        if (Result.isSuccess-impl(obj)) {
        }
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
