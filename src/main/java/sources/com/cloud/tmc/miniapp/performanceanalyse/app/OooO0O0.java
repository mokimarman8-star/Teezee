package com.cloud.tmc.miniapp.performanceanalyse.app;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointConstants;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.GsonUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 {
    public static final OooO0O0 OooO00o = new OooO0O0();
    public static final Map<String, OooO00o> OooO0O0 = new LinkedHashMap();

    public final int OooO00o(int i, int i2) {
        if (i == 2) {
            return i;
        }
        if (i == 0) {
            return i2;
        }
        return 0;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:7|(5:(20:16|17|(10:20|(1:22)(1:41)|23|(1:25)(1:40)|26|(1:28)(1:39)|29|(1:(2:32|33)(2:35|36))(2:37|38)|34|18)|42|43|44|45|(1:86)(1:49)|(3:78|79|(11:81|(3:72|73|(1:75))|53|54|(1:56)|57|(1:59)|61|(1:63)(1:(1:68)(1:69))|64|66))|51|(0)|53|54|(0)|57|(0)|61|(0)(0)|64|66)|61|(0)(0)|64|66)|88|17|(1:18)|42|43|44|45|(1:47)|86|(0)|51|(0)|53|54|(0)|57|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0138, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076 A[Catch: all -> 0x0049, TryCatch #3 {all -> 0x0049, blocks: (B:3:0x002a, B:7:0x002f, B:9:0x003a, B:11:0x003e, B:13:0x0042, B:17:0x004d, B:20:0x0076, B:22:0x0084, B:23:0x008b, B:25:0x0095, B:26:0x009c, B:28:0x00a6, B:29:0x00ad, B:34:0x00c7, B:43:0x00c9, B:56:0x013f, B:59:0x014a), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013f A[Catch: all -> 0x0049, TRY_ENTER, TryCatch #3 {all -> 0x0049, blocks: (B:3:0x002a, B:7:0x002f, B:9:0x003a, B:11:0x003e, B:13:0x0042, B:17:0x004d, B:20:0x0076, B:22:0x0084, B:23:0x008b, B:25:0x0095, B:26:0x009c, B:28:0x00a6, B:29:0x00ad, B:34:0x00c7, B:43:0x00c9, B:56:0x013f, B:59:0x014a), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014a A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #3 {all -> 0x0049, blocks: (B:3:0x002a, B:7:0x002f, B:9:0x003a, B:11:0x003e, B:13:0x0042, B:17:0x004d, B:20:0x0076, B:22:0x0084, B:23:0x008b, B:25:0x0095, B:26:0x009c, B:28:0x00a6, B:29:0x00ad, B:34:0x00c7, B:43:0x00c9, B:56:0x013f, B:59:0x014a), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0151 A[Catch: all -> 0x01bc, TRY_ENTER, TryCatch #4 {all -> 0x01bc, blocks: (B:63:0x0151, B:64:0x0193, B:68:0x0169, B:69:0x017f), top: B:61:0x014f }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO00o(OooO00o oooO00o, Bundle bundle) {
        int i;
        int i2;
        long j;
        long j2;
        App findApp;
        Bundle sceneParams;
        Bundle sceneParams2;
        boolean z = false;
        Intrinsics.h(oooO00o, "appOpenPointData");
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        StringBuilder sb = new StringBuilder();
        sb.append("reportAppOpenSuccess =======> appOpenPointData:");
        sb.append(oooO00o);
        sb.append(", data:");
        sb.append(bundle);
        try {
            if (oooO00o.OooOO0o) {
                return;
            }
            bundle.putString("openMiniAppResult", "true");
            try {
                if (oooO00o.OooO0oO != 2 && oooO00o.OooO0oo != 2 && oooO00o.OooO != 2 && oooO00o.OooOO0 != 2) {
                    i = 1;
                    bundle.putInt("syncType", i);
                    bundle.putString("openMiniAppFailedReason", "");
                    bundle.putInt("maxStage", 17);
                    bundle.putString("isExitInStage", "");
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    long j3 = 0;
                    long j4 = 0;
                    for (i2 = 1; i2 < 18; i2++) {
                        String valueOf = String.valueOf(i2);
                        Long l = oooO00o.OooO0OO.get(valueOf);
                        long longValue = l != null ? l.longValue() : 0L;
                        Long l2 = oooO00o.OooO0Oo.get(valueOf);
                        long longValue2 = l2 != null ? l2.longValue() : 0L;
                        Long l3 = oooO00o.OooO0o0.get(valueOf);
                        linkedHashMap.put(valueOf, Long.valueOf(l3 != null ? l3.longValue() : 0L));
                        linkedHashMap2.put(valueOf, new long[]{longValue, longValue2});
                        if (i2 == 1) {
                            j3 = longValue;
                        } else if (i2 == 17) {
                            j4 = longValue2;
                        }
                    }
                    bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap));
                    bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap2));
                    bundle.putString(PointConstants.POINT_PAGE_PATH, String.valueOf(oooO00o.OooO0O0));
                    oooO00o.OooOOO0 = true;
                    oooO00o.OooOO0o = true;
                    bundle.remove(ChainPoint.PAGE_PATH);
                    bundle.remove(ChainPoint.PAGE_ID);
                    String str = oooO00o.OooO00o;
                    findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str);
                    j = (findApp != null || (sceneParams2 = findApp.getSceneParams()) == null) ? 0L : sceneParams2.getLong(TmcConstants.KEY_APP_START_FIRST_TIME);
                    if (findApp != null) {
                        try {
                            sceneParams = findApp.getSceneParams();
                        } catch (Throwable unused) {
                            j2 = 0;
                            if (j != 0) {
                            }
                            if (j2 != 0) {
                            }
                            if (j == 0) {
                            }
                            bundle.putString("miniapp_all_start_time", String.valueOf(j4 - j3));
                            bundle.putBoolean("is_mini_process_alive", z);
                            MiniAppLaunch.INSTANCE.trackCommonResPoint(str, bundle);
                            ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(oooO00o.OooO00o, "mini_app_open", bundle);
                            return;
                        }
                        if (sceneParams != null) {
                            j2 = sceneParams.getLong(TmcConstants.KEY_APP_START_MINI_FIRST_TIME);
                            if (findApp != null) {
                                try {
                                    Bundle sceneParams3 = findApp.getSceneParams();
                                    if (sceneParams3 != null) {
                                        z = sceneParams3.getBoolean(TmcConstants.KEY_APP_MINI_PROCESS_ALIVE);
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                            if (j != 0) {
                                bundle.putLong("mini_first_time", j);
                            }
                            if (j2 != 0) {
                                bundle.putLong("mini_second_time", j2);
                            }
                            if (j == 0) {
                                TmcLogger.d("h5PointTrack", "firstStartTime:" + j);
                                j3 = j;
                            } else if (j2 != 0) {
                                TmcLogger.d("h5PointTrack", "secondStartTime:" + j2);
                                j3 = j2;
                            } else {
                                TmcLogger.d("h5PointTrack", "reportStartTime:" + j3);
                            }
                            bundle.putString("miniapp_all_start_time", String.valueOf(j4 - j3));
                            bundle.putBoolean("is_mini_process_alive", z);
                            MiniAppLaunch.INSTANCE.trackCommonResPoint(str, bundle);
                            ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(oooO00o.OooO00o, "mini_app_open", bundle);
                            return;
                        }
                    }
                    j2 = 0;
                    if (findApp != null) {
                    }
                    if (j != 0) {
                    }
                    if (j2 != 0) {
                    }
                    if (j == 0) {
                    }
                    bundle.putString("miniapp_all_start_time", String.valueOf(j4 - j3));
                    bundle.putBoolean("is_mini_process_alive", z);
                    MiniAppLaunch.INSTANCE.trackCommonResPoint(str, bundle);
                    ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(oooO00o.OooO00o, "mini_app_open", bundle);
                    return;
                }
                if (j == 0) {
                }
                bundle.putString("miniapp_all_start_time", String.valueOf(j4 - j3));
                bundle.putBoolean("is_mini_process_alive", z);
                MiniAppLaunch.INSTANCE.trackCommonResPoint(str, bundle);
                ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(oooO00o.OooO00o, "mini_app_open", bundle);
                return;
            } catch (Throwable unused3) {
                return;
            }
            i = 2;
            bundle.putInt("syncType", i);
            bundle.putString("openMiniAppFailedReason", "");
            bundle.putInt("maxStage", 17);
            bundle.putString("isExitInStage", "");
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            LinkedHashMap linkedHashMap22 = new LinkedHashMap();
            long j32 = 0;
            long j42 = 0;
            while (i2 < 18) {
            }
            bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap3));
            bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap22));
            bundle.putString(PointConstants.POINT_PAGE_PATH, String.valueOf(oooO00o.OooO0O0));
            oooO00o.OooOOO0 = true;
            oooO00o.OooOO0o = true;
            bundle.remove(ChainPoint.PAGE_PATH);
            bundle.remove(ChainPoint.PAGE_ID);
            String str2 = oooO00o.OooO00o;
            findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str2);
            if (findApp != null) {
            }
            if (findApp != null) {
            }
            j2 = 0;
            if (findApp != null) {
            }
            if (j != 0) {
            }
            if (j2 != 0) {
            }
        } catch (Throwable th) {
            TmcLogger.e("h5PointTrack", "Exception failed!", th);
        }
    }

    public final boolean OooO00o(String str) {
        OooO00o oooO00o;
        if (str == null || (oooO00o = (OooO00o) ((LinkedHashMap) OooO0O0).get(str)) == null) {
            return false;
        }
        return oooO00o.OooOOO0;
    }

    public final boolean OooO00o(String str, Bundle bundle) {
        long j;
        OooO00o oooO00o;
        String str2 = "false";
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        StringBuilder sb = new StringBuilder();
        sb.append("recordAppStageFail =======> appId:");
        sb.append(str);
        sb.append(", data:");
        sb.append(bundle);
        try {
            j = bundle.containsKey(ChainPoint.TIME) ? bundle.getLong(ChainPoint.TIME) : System.currentTimeMillis();
        } catch (Throwable unused) {
        }
        if (str == null || (oooO00o = (OooO00o) ((LinkedHashMap) OooO0O0).get(str)) == null) {
            return true;
        }
        bundle.putString("openMiniAppResult", "false");
        Iterator<Map.Entry<String, Long>> it = oooO00o.OooO0OO.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (!oooO00o.OooO0Oo.containsKey(key)) {
                oooO00o.OooO0Oo.put(key, Long.valueOf(j));
                Map<String, Long> map = oooO00o.OooO0o0;
                Long l = oooO00o.OooO0Oo.get(key);
                Intrinsics.e(l);
                long longValue = l.longValue();
                Long l2 = oooO00o.OooO0OO.get(key);
                Intrinsics.e(l2);
                map.put(key, Long.valueOf(longValue - l2.longValue()));
                str2 = "true";
            }
        }
        bundle.putString("isExitInStage", str2);
        OooO0O0 oooO0O0 = OooO00o;
        bundle.putInt("syncType", oooO0O0.OooO00o(oooO0O0.OooO00o(oooO0O0.OooO00o(oooO0O0.OooO00o(0, oooO00o.OooO0oO), oooO00o.OooO0oo), oooO00o.OooOO0), oooO00o.OooO));
        int size = oooO00o.OooO0OO.size();
        bundle.putInt("maxStage", size);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (1 <= size) {
            int i = 1;
            while (true) {
                String valueOf = String.valueOf(i);
                Long l3 = oooO00o.OooO0OO.get(valueOf);
                long longValue2 = l3 != null ? l3.longValue() : 0L;
                Long l4 = oooO00o.OooO0Oo.get(valueOf);
                long longValue3 = l4 != null ? l4.longValue() : 0L;
                Long l5 = oooO00o.OooO0o0.get(valueOf);
                linkedHashMap.put(valueOf, Long.valueOf(l5 != null ? l5.longValue() : 0L));
                linkedHashMap2.put(valueOf, new long[]{longValue2, longValue3});
                if (i == size) {
                    break;
                }
                i++;
            }
        }
        bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap));
        bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap2));
        bundle.putString(PointConstants.POINT_PAGE_PATH, String.valueOf(oooO00o.OooO0O0));
        MiniAppLaunch.INSTANCE.trackCommonResPoint(str, bundle);
        bundle.remove(ChainPoint.PAGE_PATH);
        bundle.remove(ChainPoint.PAGE_ID);
        ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(oooO00o.OooO00o, "mini_app_open", bundle);
        oooO00o.OooOO0o = true;
        if (!oooO00o.OooOO0O) {
            com.cloud.tmc.miniapp.performanceanalyse.page.OooO0O0 oooO0O02 = com.cloud.tmc.miniapp.performanceanalyse.page.OooO0O0.OooO00o;
            Bundle bundle2 = new Bundle();
            bundle2.putString("isExitInStage", str2);
            Unit unit = Unit.a;
            oooO0O02.OooO00o(oooO00o, (com.cloud.tmc.miniapp.performanceanalyse.page.OooO00o) null, bundle2);
        }
        return true;
    }

    public final boolean OooO00o(String str, String str2, Bundle bundle) {
        Intrinsics.h(str, "stage");
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        StringBuilder sb = new StringBuilder();
        sb.append("recordAppStageEnd =======> stage:");
        sb.append(str);
        sb.append(", appId:");
        sb.append(str2);
        sb.append(", data:");
        sb.append(bundle);
        try {
            long j = bundle.containsKey(ChainPoint.TIME) ? bundle.getLong(ChainPoint.TIME) : System.currentTimeMillis();
            if (str2 != null) {
                OooO0O0 oooO0O0 = OooO00o;
                OooO00o oooO00o = (OooO00o) ((LinkedHashMap) OooO0O0).get(str2);
                if (oooO00o == null || !oooO00o.OooO0OO.containsKey(str) || oooO00o.OooO0Oo.containsKey(str)) {
                    return true;
                }
                oooO00o.OooO0Oo.put(str, Long.valueOf(j));
                Map<String, Long> map = oooO00o.OooO0o0;
                Long l = oooO00o.OooO0Oo.get(str);
                Intrinsics.e(l);
                long longValue = l.longValue();
                Long l2 = oooO00o.OooO0OO.get(str);
                Intrinsics.e(l2);
                map.put(str, Long.valueOf(longValue - l2.longValue()));
                if (Intrinsics.c(str, ChainPoint.PageDrawView)) {
                    oooO0O0.OooO00o(oooO00o, bundle);
                }
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public final boolean OooO0O0(String str, Bundle bundle) {
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        StringBuilder sb = new StringBuilder();
        sb.append("recordAppStageFinish =======> appId:");
        sb.append(str);
        sb.append(", data:");
        sb.append(bundle);
        if (str != null) {
            try {
                OooO0O0 oooO0O0 = OooO00o;
                Map<String, OooO00o> map = OooO0O0;
                OooO00o oooO00o = (OooO00o) ((LinkedHashMap) map).get(str);
                if (oooO00o == null) {
                    return true;
                }
                if (oooO00o.OooOO0o) {
                    map.remove(str);
                    return true;
                }
                bundle.putString(ChainPoint.OPEN_MINI_APP_FAILED_REASON, "小程序关闭");
                oooO0O0.OooO00o(str, bundle);
                map.remove(str);
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public final boolean OooO0O0(String str, String str2, Bundle bundle) {
        long j;
        Intrinsics.h(str, "stage");
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        StringBuilder sb = new StringBuilder();
        sb.append("recordAppStageStart =======> stage:");
        sb.append(str);
        sb.append(", appId:");
        sb.append(str2);
        sb.append(", data:");
        sb.append(bundle);
        try {
            j = bundle.containsKey(ChainPoint.TIME) ? bundle.getLong(ChainPoint.TIME) : System.currentTimeMillis();
        } catch (Throwable unused) {
        }
        if (str2 == null) {
            return true;
        }
        if (Intrinsics.c(str, ChainPoint.AppSetupStep)) {
            Map<String, OooO00o> map = OooO0O0;
            if (map.containsKey(str2)) {
                map.remove(str2);
            }
            map.put(str2, new OooO00o(str2, null, MapsKt.m(new Pair[]{TuplesKt.a(str, Long.valueOf(j))}), new LinkedHashMap(), new LinkedHashMap(), new LinkedHashMap(), 0, 0, 0, 0, false, false, false));
        } else {
            OooO00o oooO00o = (OooO00o) ((LinkedHashMap) OooO0O0).get(str2);
            if (oooO00o == null || oooO00o.OooO0OO.containsKey(str)) {
                return true;
            }
            oooO00o.OooO0OO.put(str, Long.valueOf(j));
            if (Intrinsics.c(str, ChainPoint.PageCreateContainer)) {
                oooO00o.OooOO0O = true;
                oooO00o.OooO0O0 = bundle.getString(ChainPoint.PAGE_PATH, "");
            }
        }
        return true;
    }

    public final boolean OooO0OO(String str, Bundle bundle) {
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        if (str != null) {
            try {
                OooO00o oooO00o = (OooO00o) ((LinkedHashMap) OooO0O0).get(str);
                if (oooO00o == null) {
                    return true;
                }
                int i = bundle.getInt(ChainPoint.UPDATE_FRAMEWORK_MODE, -1);
                if (i != -1) {
                    oooO00o.OooO0oo = i;
                }
                int i2 = bundle.getInt(ChainPoint.UPDATE_APP_MODE, -1);
                if (i2 != -1) {
                    oooO00o.OooO0oO = i2;
                }
                int i3 = bundle.getInt(ChainPoint.DOWNLOAD_FRAMEWORK_MODE, -1);
                if (i3 != -1) {
                    oooO00o.OooOO0 = i3;
                }
                int i4 = bundle.getInt(ChainPoint.DOWNLOAD_APP_MODE, -1);
                if (i4 != -1) {
                    oooO00o.OooO = i4;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("recordAppStageInsert ==> updateFrameworkMode:");
                sb.append(i);
                sb.append(", updateAppMode:");
                sb.append(i2);
                sb.append(", downloadFrameworkMode:");
                sb.append(i3);
                sb.append(", downloadAppMode:");
                sb.append(i4);
            } catch (Throwable unused) {
            }
        }
        return true;
    }
}
