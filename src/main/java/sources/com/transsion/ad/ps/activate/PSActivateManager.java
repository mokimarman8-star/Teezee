package com.transsion.ad.ps.activate;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.pslink.AppInstalledBean;
import com.transsion.ad.ps.installed.AppInstallManager;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PSActivateManager {
    public static final PSActivateManager a = new PSActivateManager();
    private static final PriorityBlockingQueue b = new PriorityBlockingQueue(11, new Comparator() { // from class: com.transsion.ad.ps.activate.PSActivateManager$special$$inlined$compareByDescending$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Double ecpm = ((PsActivateBean) t2).getECPM();
            Double valueOf = Double.valueOf(0.0d);
            if (ecpm == null) {
                ecpm = valueOf;
            }
            Double ecpm2 = ((PsActivateBean) t).getECPM();
            if (ecpm2 != null) {
                valueOf = ecpm2;
            }
            return ComparisonsKt.d(ecpm, valueOf);
        }
    });

    private PSActivateManager() {
    }

    public final void a(PsActivateBean psActivateBean) {
        Intrinsics.h(psActivateBean, "bean");
        b.offer(psActivateBean);
    }

    public final PsActivateBean b() {
        return (PsActivateBean) b.poll();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0066 A[LOOP:0: B:12:0x0060->B:14:0x0066, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(Continuation continuation) {
        PSActivateManager$getRecentTwoHoursOpenAdList$1 pSActivateManager$getRecentTwoHoursOpenAdList$1;
        int i;
        Iterator it;
        if (continuation instanceof PSActivateManager$getRecentTwoHoursOpenAdList$1) {
            pSActivateManager$getRecentTwoHoursOpenAdList$1 = (PSActivateManager$getRecentTwoHoursOpenAdList$1) continuation;
            int i2 = pSActivateManager$getRecentTwoHoursOpenAdList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pSActivateManager$getRecentTwoHoursOpenAdList$1.label = i2 - Integer.MIN_VALUE;
                PSActivateManager$getRecentTwoHoursOpenAdList$1 pSActivateManager$getRecentTwoHoursOpenAdList$12 = pSActivateManager$getRecentTwoHoursOpenAdList$1;
                Object obj = pSActivateManager$getRecentTwoHoursOpenAdList$12.result;
                Object f = IntrinsicsKt.f();
                i = pSActivateManager$getRecentTwoHoursOpenAdList$12.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    AppInstallManager appInstallManager = AppInstallManager.a;
                    Application a2 = Utils.a();
                    Intrinsics.g(a2, "getApp(...)");
                    pSActivateManager$getRecentTwoHoursOpenAdList$12.label = 1;
                    obj = AppInstallManager.c(appInstallManager, a2, 0L, pSActivateManager$getRecentTwoHoursOpenAdList$12, 2, null);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                Iterable iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(CollectionsKt.v(iterable, 10));
                it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AppInstalledBean) it.next()).getPackageName());
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (!StringsKt.q0((String) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                return CollectionsKt.s0(arrayList2, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            }
        }
        pSActivateManager$getRecentTwoHoursOpenAdList$1 = new PSActivateManager$getRecentTwoHoursOpenAdList$1(this, continuation);
        PSActivateManager$getRecentTwoHoursOpenAdList$1 pSActivateManager$getRecentTwoHoursOpenAdList$122 = pSActivateManager$getRecentTwoHoursOpenAdList$1;
        Object obj3 = pSActivateManager$getRecentTwoHoursOpenAdList$122.result;
        Object f2 = IntrinsicsKt.f();
        i = pSActivateManager$getRecentTwoHoursOpenAdList$122.label;
        if (i != 0) {
        }
        Iterable iterable2 = (Iterable) obj3;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.v(iterable2, 10));
        it = iterable2.iterator();
        while (it.hasNext()) {
        }
        ArrayList arrayList22 = new ArrayList();
        while (r12.hasNext()) {
        }
        return CollectionsKt.s0(arrayList22, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final boolean d() {
        return !b.isEmpty();
    }

    public final void e() {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PSActivateManager$requestActivateAd$1(null), 3, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007b -> B:10:0x007e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(List list, Continuation continuation) {
        PSActivateManager$saveAdCache$1 pSActivateManager$saveAdCache$1;
        int i;
        Iterator it;
        if (continuation instanceof PSActivateManager$saveAdCache$1) {
            pSActivateManager$saveAdCache$1 = (PSActivateManager$saveAdCache$1) continuation;
            int i2 = pSActivateManager$saveAdCache$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pSActivateManager$saveAdCache$1.label = i2 - Integer.MIN_VALUE;
                Object obj = pSActivateManager$saveAdCache$1.result;
                Object f = IntrinsicsKt.f();
                i = pSActivateManager$saveAdCache$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    b.clear();
                    if (list != null) {
                        it = list.iterator();
                        if (it.hasNext()) {
                        }
                    }
                    return Unit.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                PsActivateBean psActivateBean = (PsActivateBean) pSActivateManager$saveAdCache$1.L$1;
                it = (Iterator) pSActivateManager$saveAdCache$1.L$0;
                ResultKt.b(obj);
                AppInstalledBean appInstalledBean = (AppInstalledBean) obj;
                psActivateBean.setECPM(appInstalledBean == null ? appInstalledBean.getECPM() : null);
                b.add(psActivateBean);
                if (it.hasNext()) {
                    psActivateBean = (PsActivateBean) it.next();
                    MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
                    Application a2 = Utils.a();
                    Intrinsics.g(a2, "getApp(...)");
                    vh.a v0 = companion.b(a2).v0();
                    String packageName = psActivateBean.getPackageName();
                    if (packageName == null) {
                        packageName = BuildConfig.FLAVOR;
                    }
                    pSActivateManager$saveAdCache$1.L$0 = it;
                    pSActivateManager$saveAdCache$1.L$1 = psActivateBean;
                    pSActivateManager$saveAdCache$1.label = 1;
                    obj = v0.b(packageName, pSActivateManager$saveAdCache$1);
                    if (obj == f) {
                        return f;
                    }
                    AppInstalledBean appInstalledBean2 = (AppInstalledBean) obj;
                    psActivateBean.setECPM(appInstalledBean2 == null ? appInstalledBean2.getECPM() : null);
                    b.add(psActivateBean);
                    if (it.hasNext()) {
                    }
                }
                return Unit.a;
            }
        }
        pSActivateManager$saveAdCache$1 = new PSActivateManager$saveAdCache$1(this, continuation);
        Object obj2 = pSActivateManager$saveAdCache$1.result;
        Object f2 = IntrinsicsKt.f();
        i = pSActivateManager$saveAdCache$1.label;
        if (i != 0) {
        }
    }
}
