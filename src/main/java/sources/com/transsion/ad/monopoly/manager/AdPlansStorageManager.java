package com.transsion.ad.monopoly.manager;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.intercept.AdPlanIntercept;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.monopoly.plan.AdPlansTransform;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import rh.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdPlansStorageManager {
    public static final AdPlansStorageManager a = new AdPlansStorageManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.ad.monopoly.manager.b
        public final Object invoke() {
            uh.a b2;
            b2 = AdPlansStorageManager.b();
            return b2;
        }
    });

    private AdPlansStorageManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final uh.a b() {
        MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return companion.b(a2).y0();
    }

    public static /* synthetic */ Object e(AdPlansStorageManager adPlansStorageManager, String str, Map map, String str2, AdPlanSourceManager.AdPlanEnum[] adPlanEnumArr, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        return adPlansStorageManager.d(str, map, str2, adPlanEnumArr, continuation);
    }

    private final uh.a f() {
        return (uh.a) b.getValue();
    }

    public final Object c(String str, Continuation continuation) {
        Object d = f().d(str, continuation);
        return d == IntrinsicsKt.f() ? d : Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0114 -> B:11:0x004a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(String str, Map map, String str2, AdPlanSourceManager.AdPlanEnum[] adPlanEnumArr, Continuation continuation) {
        AdPlansStorageManager$getAdPlan$1 adPlansStorageManager$getAdPlan$1;
        int i;
        Set W0;
        String str3;
        Map map2;
        String str4;
        String str5;
        List list;
        Map map3;
        String str6;
        Iterator it;
        String str7;
        Collection collection;
        List U0;
        String str8;
        AdPlans adPlans;
        if (continuation instanceof AdPlansStorageManager$getAdPlan$1) {
            adPlansStorageManager$getAdPlan$1 = (AdPlansStorageManager$getAdPlan$1) continuation;
            int i2 = adPlansStorageManager$getAdPlan$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adPlansStorageManager$getAdPlan$1.label = i2 - Integer.MIN_VALUE;
                Object obj = adPlansStorageManager$getAdPlan$1.result;
                Object f = IntrinsicsKt.f();
                i = adPlansStorageManager$getAdPlan$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (adPlanEnumArr.length == 0) {
                        str3 = str;
                        W0 = null;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        int length = adPlanEnumArr.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            AdPlanSourceManager.AdPlanEnum adPlanEnum = adPlanEnumArr[i3];
                            String value = adPlanEnum != null ? adPlanEnum.getValue() : null;
                            if (value != null) {
                                arrayList.add(value);
                            }
                        }
                        W0 = CollectionsKt.W0(arrayList);
                        str3 = str;
                    }
                    adPlansStorageManager$getAdPlan$1.L$0 = str3;
                    map2 = map;
                    adPlansStorageManager$getAdPlan$1.L$1 = map2;
                    str4 = str2;
                    adPlansStorageManager$getAdPlan$1.L$2 = str4;
                    adPlansStorageManager$getAdPlan$1.L$3 = W0;
                    adPlansStorageManager$getAdPlan$1.label = 1;
                    Object g = g(adPlansStorageManager$getAdPlan$1);
                    if (g == f) {
                        return f;
                    }
                    str5 = str3;
                    obj = g;
                } else if (i == 1) {
                    W0 = (Set) adPlansStorageManager$getAdPlan$1.L$3;
                    String str9 = (String) adPlansStorageManager$getAdPlan$1.L$2;
                    Map map4 = (Map) adPlansStorageManager$getAdPlan$1.L$1;
                    str5 = (String) adPlansStorageManager$getAdPlan$1.L$0;
                    ResultKt.b(obj);
                    str4 = str9;
                    map2 = map4;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    MbAdDbPlans mbAdDbPlans = (MbAdDbPlans) adPlansStorageManager$getAdPlan$1.L$5;
                    it = (Iterator) adPlansStorageManager$getAdPlan$1.L$4;
                    collection = (Collection) adPlansStorageManager$getAdPlan$1.L$3;
                    str7 = (String) adPlansStorageManager$getAdPlan$1.L$2;
                    map3 = (Map) adPlansStorageManager$getAdPlan$1.L$1;
                    str6 = (String) adPlansStorageManager$getAdPlan$1.L$0;
                    ResultKt.b(obj);
                    String str10 = str7;
                    Map map5 = map3;
                    String str11 = str6;
                    AdPlansHitResponse adPlansHitResponse = (AdPlansHitResponse) obj;
                    if (adPlansHitResponse.isHit()) {
                        adPlans = AdPlansTransform.a.b(mbAdDbPlans);
                        str8 = str11;
                    } else {
                        if (Intrinsics.c(f.a.c(), Boxing.a(true))) {
                            str8 = str11;
                            xh.a.m(xh.a.a, str10, "AdPlansStorageManager --> sceneId = " + str11 + " --> rejectMsg = " + adPlansHitResponse.getRejectMsg() + " --> dbPlans.name = " + mbAdDbPlans.getName(), 5, false, 8, null);
                        } else {
                            str8 = str11;
                        }
                        adPlans = null;
                    }
                    if (adPlans != null) {
                        collection.add(adPlans);
                    }
                    str6 = str8;
                    str7 = str10;
                    map3 = map5;
                    if (it.hasNext()) {
                        mbAdDbPlans = (MbAdDbPlans) it.next();
                        AdPlanIntercept adPlanIntercept = AdPlanIntercept.a;
                        adPlansStorageManager$getAdPlan$1.L$0 = str6;
                        adPlansStorageManager$getAdPlan$1.L$1 = map3;
                        adPlansStorageManager$getAdPlan$1.L$2 = str7;
                        adPlansStorageManager$getAdPlan$1.L$3 = collection;
                        adPlansStorageManager$getAdPlan$1.L$4 = it;
                        adPlansStorageManager$getAdPlan$1.L$5 = mbAdDbPlans;
                        adPlansStorageManager$getAdPlan$1.label = 2;
                        obj = adPlanIntercept.a(str6, mbAdDbPlans, map3, adPlansStorageManager$getAdPlan$1);
                        if (obj == f) {
                            return f;
                        }
                        String str102 = str7;
                        Map map52 = map3;
                        String str112 = str6;
                        AdPlansHitResponse adPlansHitResponse2 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse2.isHit()) {
                        }
                        if (adPlans != null) {
                        }
                        str6 = str8;
                        str7 = str102;
                        map3 = map52;
                        if (it.hasNext()) {
                            List list2 = (List) collection;
                            if (list2 != null && (U0 = CollectionsKt.U0(list2)) != null) {
                                return U0;
                            }
                            return new ArrayList();
                        }
                    }
                }
                list = (List) obj;
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : list) {
                        MbAdDbPlans mbAdDbPlans2 = (MbAdDbPlans) obj2;
                        if (W0 == null || CollectionsKt.b0(W0, mbAdDbPlans2.getAdSource())) {
                            arrayList2.add(obj2);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = arrayList2.iterator();
                    map3 = map2;
                    str6 = str5;
                    it = it2;
                    str7 = str4;
                    collection = arrayList3;
                    if (it.hasNext()) {
                    }
                }
                return new ArrayList();
            }
        }
        adPlansStorageManager$getAdPlan$1 = new AdPlansStorageManager$getAdPlan$1(this, continuation);
        Object obj3 = adPlansStorageManager$getAdPlan$1.result;
        Object f2 = IntrinsicsKt.f();
        i = adPlansStorageManager$getAdPlan$1.label;
        if (i != 0) {
        }
        list = (List) obj3;
        if (list != null) {
        }
        return new ArrayList();
    }

    public final Object g(Continuation continuation) {
        return f().a(continuation);
    }

    public final Object h(String str, Continuation continuation) {
        return f().f(str, continuation);
    }

    public final Object i(String str, Continuation continuation) {
        return f().h(str, continuation);
    }

    public final Object j(MbAdDbPlans mbAdDbPlans, Continuation continuation) {
        Object c = f().c(mbAdDbPlans, continuation);
        return c == IntrinsicsKt.f() ? c : Unit.a;
    }

    public final Object k(List list, Continuation continuation) {
        Object b2 = f().b(list, continuation);
        return b2 == IntrinsicsKt.f() ? b2 : Unit.a;
    }

    public final Object l(boolean z, String str, Continuation continuation) {
        Object e = f().e(z, str, continuation);
        return e == IntrinsicsKt.f() ? e : Unit.a;
    }
}
