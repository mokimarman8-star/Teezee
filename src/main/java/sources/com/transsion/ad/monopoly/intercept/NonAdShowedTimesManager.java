package com.transsion.ad.monopoly.intercept;

import android.app.Application;
import android.text.TextUtils;
import ci.p;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlansTransform;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NonAdShowedTimesManager {
    public static final NonAdShowedTimesManager a = new NonAdShowedTimesManager();
    private static final ConcurrentHashMap b = new ConcurrentHashMap();

    private NonAdShowedTimesManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(MbAdDbPlans mbAdDbPlans, Continuation continuation) {
        NonAdShowedTimesManager$getShowedTimes$1 nonAdShowedTimesManager$getShowedTimes$1;
        int i;
        Integer showedTimes;
        if (continuation instanceof NonAdShowedTimesManager$getShowedTimes$1) {
            nonAdShowedTimesManager$getShowedTimes$1 = (NonAdShowedTimesManager$getShowedTimes$1) continuation;
            int i2 = nonAdShowedTimesManager$getShowedTimes$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                nonAdShowedTimesManager$getShowedTimes$1.label = i2 - Integer.MIN_VALUE;
                Object obj = nonAdShowedTimesManager$getShowedTimes$1.result;
                Object f = IntrinsicsKt.f();
                i = nonAdShowedTimesManager$getShowedTimes$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
                    Application a2 = Utils.a();
                    Intrinsics.g(a2, "getApp(...)");
                    uh.a y0 = companion.b(a2).y0();
                    String id = mbAdDbPlans != null ? mbAdDbPlans.getId() : null;
                    nonAdShowedTimesManager$getShowedTimes$1.L$0 = mbAdDbPlans;
                    nonAdShowedTimesManager$getShowedTimes$1.label = 1;
                    obj = y0.f(id, nonAdShowedTimesManager$getShowedTimes$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mbAdDbPlans = (MbAdDbPlans) nonAdShowedTimesManager$getShowedTimes$1.L$0;
                    ResultKt.b(obj);
                }
                MbAdDbPlans mbAdDbPlans2 = (MbAdDbPlans) obj;
                int i3 = 0;
                if (mbAdDbPlans != null) {
                    ConcurrentHashMap concurrentHashMap = b;
                    ShowedTimesMemoryBean showedTimesMemoryBean = (ShowedTimesMemoryBean) concurrentHashMap.get(mbAdDbPlans.getId());
                    if (showedTimesMemoryBean == null) {
                        String showDate = mbAdDbPlans2 != null ? mbAdDbPlans2.getShowDate() : null;
                        p pVar = p.a;
                        if (TextUtils.equals(showDate, pVar.c())) {
                            String id2 = mbAdDbPlans.getId();
                            Integer showedTimes2 = mbAdDbPlans.getShowedTimes();
                            concurrentHashMap.put(id2, new ShowedTimesMemoryBean(showedTimes2 != null ? showedTimes2.intValue() : 0, pVar.c()));
                            if (mbAdDbPlans2 != null && (showedTimes = mbAdDbPlans2.getShowedTimes()) != null) {
                                i3 = showedTimes.intValue();
                            }
                        } else {
                            concurrentHashMap.put(mbAdDbPlans.getId(), new ShowedTimesMemoryBean(0, pVar.c()));
                        }
                    } else if (TextUtils.equals(showedTimesMemoryBean.getDate(), p.a.c())) {
                        i3 = showedTimesMemoryBean.getShowedTimes();
                    }
                }
                return Boxing.d(i3);
            }
        }
        nonAdShowedTimesManager$getShowedTimes$1 = new NonAdShowedTimesManager$getShowedTimes$1(this, continuation);
        Object obj2 = nonAdShowedTimesManager$getShowedTimes$1.result;
        Object f2 = IntrinsicsKt.f();
        i = nonAdShowedTimesManager$getShowedTimes$1.label;
        if (i != 0) {
        }
        MbAdDbPlans mbAdDbPlans22 = (MbAdDbPlans) obj2;
        int i32 = 0;
        if (mbAdDbPlans != null) {
        }
        return Boxing.d(i32);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x004f, code lost:
    
        if (r2 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(AdPlans adPlans) {
        ShowedTimesMemoryBean showedTimesMemoryBean;
        if (adPlans == null) {
            return;
        }
        MbAdDbPlans a2 = AdPlansTransform.a.a(adPlans);
        ConcurrentHashMap concurrentHashMap = b;
        ShowedTimesMemoryBean showedTimesMemoryBean2 = (ShowedTimesMemoryBean) concurrentHashMap.get(a2.getId());
        if (showedTimesMemoryBean2 != null) {
            String date = showedTimesMemoryBean2.getDate();
            p pVar = p.a;
            if (TextUtils.equals(date, pVar.c())) {
                showedTimesMemoryBean2.setShowedTimes(showedTimesMemoryBean2.getShowedTimes() + 1);
                showedTimesMemoryBean = (ShowedTimesMemoryBean) concurrentHashMap.put(a2.getId(), showedTimesMemoryBean2);
            } else {
                showedTimesMemoryBean = (ShowedTimesMemoryBean) concurrentHashMap.put(a2.getId(), new ShowedTimesMemoryBean(1, pVar.c()));
            }
        }
        String showDate = a2.getShowDate();
        p pVar2 = p.a;
        if (TextUtils.equals(showDate, pVar2.c())) {
            Integer showedTimes = a2.getShowedTimes();
            a2.setShowedTimes(showedTimes != null ? Integer.valueOf(showedTimes.intValue() + 1) : null);
            String id = a2.getId();
            Integer showedTimes2 = a2.getShowedTimes();
        }
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new NonAdShowedTimesManager$saveShowedTimes$3(a2, adPlans, null), 3, (Object) null);
    }
}
