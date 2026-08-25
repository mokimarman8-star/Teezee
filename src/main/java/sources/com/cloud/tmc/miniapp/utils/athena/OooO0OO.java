package com.cloud.tmc.miniapp.utils.athena;

import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import com.cloud.tmc.miniapp.defaultimpl.AthenaReport;
import com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooO;
import com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooO0o;
import com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooOO0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0OO {
    public static final OooO0OO OooO00o = new OooO0OO();
    public static AtomicBoolean OooO0O0 = new AtomicBoolean(false);
    public static Application OooO0OO;

    static {
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        new AtomicBoolean(false);
    }

    public static final void OooO00o(List list) {
        Intrinsics.h(list, "$dataCaches");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            OooO00o oooO00o = (OooO00o) it.next();
            TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ":mfah report -> cache, post, athenaAppId = " + oooO00o.OooO00o + ", tag = " + oooO00o.OooO0O0);
            OooO00o.OooO00o(oooO00o.OooO0O0, oooO00o.OooO00o, oooO00o.OooO0OO);
        }
    }

    public static final void OooO0O0(List list) {
        Intrinsics.h(list, "$dataCaches");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            OooO00o oooO00o = (OooO00o) it.next();
            TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ":report -> cache, post, athenaAppId = " + oooO00o.OooO00o + ", tag = " + oooO00o.OooO0O0);
            OooO00o.OooO00o(oooO00o.OooO0O0, oooO00o.OooO00o, oooO00o.OooO0OO);
        }
    }

    public final com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o OooO00o(String str, boolean z) {
        com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o oooO00o;
        if (!ProcessUtils.isMiniProcess()) {
            if (ProcessUtils.isMainProcess()) {
                return null;
            }
            return new com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o(false, false, false);
        }
        if (z) {
            Application application = OooO0OO;
            ArrayList h = CollectionsKt.h(new OooOO0[]{new com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooO00o(), new com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooO0O0(), new com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooO0OO(), new OooO(), new OooO0o()});
            Intrinsics.h(h, "steps");
            oooO00o = new com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o(false, false, false);
            Intrinsics.h(h, "steps");
            Intrinsics.h(oooO00o, "athenaReportBean");
            if (h.size() > 0) {
                ((OooOO0) h.get(0)).OooO00o(new com.cloud.tmc.miniapp.utils.athena.strategy.OooO0O0(application, str, h, 1, oooO00o));
            }
        } else {
            Application application2 = OooO0OO;
            ArrayList h2 = CollectionsKt.h(new OooOO0[]{new com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooO00o(), new com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooO0OO(), new OooO(), new OooO0o()});
            Intrinsics.h(h2, "steps");
            oooO00o = new com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o(false, false, false);
            Intrinsics.h(h2, "steps");
            Intrinsics.h(oooO00o, "athenaReportBean");
            if (h2.size() > 0) {
                ((OooOO0) h2.get(0)).OooO00o(new com.cloud.tmc.miniapp.utils.athena.strategy.OooO0O0(application2, str, h2, 1, oooO00o));
            }
        }
        return oooO00o;
    }

    public final void OooO00o() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        AtomicBoolean atomicBoolean3;
        boolean isMiniProcess = ProcessUtils.isMiniProcess();
        AthenaReport.Companion.getClass();
        atomicBoolean = AthenaReport.OooO0OO;
        boolean z = atomicBoolean.get();
        atomicBoolean2 = AthenaReport.OooO0Oo;
        boolean z2 = atomicBoolean2.get();
        atomicBoolean3 = AthenaReport.OooO0o0;
        TmcLogger.d("AthenaUtil", "miniProcessAppOrPageReady -> delay:false, isMiniProcess:" + isMiniProcess + ", mainProcessInitAthenaFlag:" + z + ", miniProcessInitAthenaFlag:" + z2 + ", zeroProcessInitAthenaFlag:" + atomicBoolean3.get());
    }

    public final void OooO00o(String str) {
        final ArrayList<OooO00o> arrayList;
        Intrinsics.h(str, "appId");
        try {
            OooO0O0 oooO0O0 = OooO0O0.OooO00o;
            try {
                arrayList = new ArrayList();
                ConcurrentLinkedQueue<OooO00o> concurrentLinkedQueue = OooO0O0.OooO0Oo.get(str);
                if (concurrentLinkedQueue != null && (!concurrentLinkedQueue.isEmpty())) {
                    arrayList.addAll(concurrentLinkedQueue);
                }
            } catch (Throwable unused) {
                arrayList = new ArrayList();
            }
            TmcLogger.d("AthenaUtil", "appId: ->" + str + ",->mfah report -> report all cache :" + arrayList.size());
            try {
                ConcurrentHashMap<String, ConcurrentLinkedQueue<OooO00o>> concurrentHashMap = OooO0O0.OooO0Oo;
                ConcurrentLinkedQueue<OooO00o> concurrentLinkedQueue2 = concurrentHashMap.get(str);
                if (concurrentLinkedQueue2 != null) {
                    concurrentLinkedQueue2.clear();
                }
                TypeIntrinsics.d(concurrentHashMap).remove(str);
            } catch (Throwable th) {
                TmcLogger.e("AthenaUtil", "clearAthenaDataForId", th);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ":mfah report -> exist cache, post all size = " + arrayList.size());
            if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
                ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.utils.athena.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0OO.OooO00o(arrayList);
                    }
                });
                return;
            }
            for (OooO00o oooO00o : arrayList) {
                TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ":report -> cache, post, athenaAppId = " + oooO00o.OooO00o + ", tag = " + oooO00o.OooO0O0);
                OooO00o.OooO00o(oooO00o.OooO0O0, oooO00o.OooO00o, oooO00o.OooO0OO);
            }
        } catch (Throwable th2) {
            TmcLogger.e("AthenaUtil", "athena cache report ", th2);
        }
    }

    public final void OooO00o(String str, int i, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new hi.a(str, i).c(bundle, (Bundle) null).b();
    }

    public final void OooO00o(String str, int i, Bundle bundle, String str2) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        try {
            com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o OooO00o2 = OooO00o(str2, true);
            if (OooO00o2 == null) {
                return;
            }
            TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ":getAthenaStrategyResult -> setCache = " + OooO00o2.OooO00o + ", clearCache = " + OooO00o2.OooO0O0 + ",isMfah = " + OooO00o2.OooO0OO);
            if (OooO00o2.OooO0OO && OooO00o2.OooO00o) {
                TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ": mfah report -> save cache, athenaAppId = " + i + ", tag = " + str);
                if (str2 != null && str2.length() != 0) {
                    OooO0O0 oooO0O0 = OooO0O0.OooO00o;
                    OooO00o oooO00o = new OooO00o(i, str, bundle);
                    Intrinsics.h(str2, "appId");
                    Intrinsics.h(oooO00o, "athenaDataBean");
                    try {
                        ConcurrentHashMap<String, ConcurrentLinkedQueue<OooO00o>> concurrentHashMap = OooO0O0.OooO0Oo;
                        ConcurrentLinkedQueue<OooO00o> concurrentLinkedQueue = concurrentHashMap.get(str2);
                        if (concurrentLinkedQueue == null) {
                            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                            concurrentHashMap.put(str2, concurrentLinkedQueue);
                        }
                        concurrentLinkedQueue.add(oooO00o);
                        return;
                    } catch (Throwable th) {
                        TmcLogger.e("AthenaUtil", "setAthenaDataForId", th);
                        return;
                    }
                }
                OooO0O0 oooO0O02 = OooO0O0.OooO00o;
                OooO00o oooO00o2 = new OooO00o(i, str, bundle);
                Intrinsics.h(oooO00o2, "athenaDataBean");
                oooO0O02.OooO00o();
                OooO0O0.OooO0OO.add(oooO00o2);
                return;
            }
            if (OooO00o2.OooO00o) {
                TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ":report -> save cache, athenaAppId = " + i + ", tag = " + str);
                OooO0O0 oooO0O03 = OooO0O0.OooO00o;
                OooO00o oooO00o3 = new OooO00o(i, str, bundle);
                Intrinsics.h(oooO00o3, "athenaDataBean");
                oooO0O03.OooO00o();
                OooO0O0.OooO0OO.add(oooO00o3);
                return;
            }
            if (!OooO00o2.OooO0O0) {
                TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ":report -> no cache, post only current, athenaAppId = " + i + ", tag = " + str);
                OooO00o(str, i, bundle);
                return;
            }
            OooO0O0 oooO0O04 = OooO0O0.OooO00o;
            final ArrayList arrayList = new ArrayList();
            ConcurrentLinkedQueue<OooO00o> concurrentLinkedQueue2 = OooO0O0.OooO0OO;
            arrayList.addAll(concurrentLinkedQueue2);
            concurrentLinkedQueue2.clear();
            if (arrayList.isEmpty()) {
                TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ":report -> no cache, post only current, athenaAppId = " + i + ", tag = " + str);
                OooO00o(str, i, bundle);
                return;
            }
            TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ":report -> exist cache, post all size = " + arrayList.size());
            arrayList.add(new OooO00o(i, str, bundle));
            if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
                ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.utils.athena.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0OO.OooO0O0(arrayList);
                    }
                });
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                OooO00o oooO00o4 = (OooO00o) it.next();
                TmcLogger.d("AthenaUtil", ProcessUtils.getProcessName() + ":report -> cache, post, athenaAppId = " + oooO00o4.OooO00o + ", tag = " + oooO00o4.OooO0O0);
                OooO00o.OooO00o(oooO00o4.OooO0O0, oooO00o4.OooO00o, oooO00o4.OooO0OO);
            }
        } catch (Throwable unused) {
        }
    }

    public final void OooO0O0(String str, int i, Bundle bundle) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(bundle, "bundle");
        try {
            OooO00o(str, i, bundle);
        } catch (Throwable th) {
            TmcLogger.e("AthenaUtil", "forceAthenaReport", th);
        }
    }
}
