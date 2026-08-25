package com.cloud.tmc.miniapp.performanceanalyse.page;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointConstants;
import com.cloud.tmc.miniapp.base.ShowPageData;
import com.cloud.tmc.miniapp.base.ShowPageStore;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniutils.util.GsonUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 {
    public static final OooO0O0 OooO00o = new OooO0O0();

    /* JADX WARN: Removed duplicated region for block: B:100:0x021e A[Catch: all -> 0x0267, LOOP:3: B:83:0x019f->B:100:0x021e, LOOP_END, TryCatch #0 {all -> 0x0267, blocks: (B:3:0x0036, B:5:0x003e, B:6:0x0049, B:8:0x005a, B:11:0x0063, B:13:0x0071, B:14:0x0078, B:16:0x0082, B:17:0x0089, B:19:0x0093, B:20:0x009a, B:22:0x00ac, B:27:0x0222, B:29:0x023d, B:30:0x0241, B:33:0x024e, B:37:0x024b, B:39:0x00ae, B:40:0x00c0, B:42:0x00c6, B:44:0x00da, B:49:0x0110, B:52:0x011a, B:54:0x0122, B:56:0x012c, B:57:0x0133, B:59:0x013d, B:60:0x0144, B:62:0x014e, B:63:0x0155, B:65:0x018b, B:69:0x015f, B:71:0x0169, B:72:0x0170, B:74:0x017a, B:76:0x0184, B:83:0x019f, B:85:0x01a7, B:87:0x01af, B:89:0x01b7, B:91:0x01c1, B:92:0x01c8, B:94:0x01d2, B:95:0x01f9, B:97:0x0203, B:98:0x020a, B:100:0x021e, B:105:0x01d7, B:107:0x01e1, B:108:0x01e8, B:110:0x01f2, B:113:0x0045), top: B:2:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0221 A[EDGE_INSN: B:101:0x0221->B:112:0x0221 BREAK  A[LOOP:3: B:83:0x019f->B:100:0x021e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0203 A[Catch: all -> 0x0267, TryCatch #0 {all -> 0x0267, blocks: (B:3:0x0036, B:5:0x003e, B:6:0x0049, B:8:0x005a, B:11:0x0063, B:13:0x0071, B:14:0x0078, B:16:0x0082, B:17:0x0089, B:19:0x0093, B:20:0x009a, B:22:0x00ac, B:27:0x0222, B:29:0x023d, B:30:0x0241, B:33:0x024e, B:37:0x024b, B:39:0x00ae, B:40:0x00c0, B:42:0x00c6, B:44:0x00da, B:49:0x0110, B:52:0x011a, B:54:0x0122, B:56:0x012c, B:57:0x0133, B:59:0x013d, B:60:0x0144, B:62:0x014e, B:63:0x0155, B:65:0x018b, B:69:0x015f, B:71:0x0169, B:72:0x0170, B:74:0x017a, B:76:0x0184, B:83:0x019f, B:85:0x01a7, B:87:0x01af, B:89:0x01b7, B:91:0x01c1, B:92:0x01c8, B:94:0x01d2, B:95:0x01f9, B:97:0x0203, B:98:0x020a, B:100:0x021e, B:105:0x01d7, B:107:0x01e1, B:108:0x01e8, B:110:0x01f2, B:113:0x0045), top: B:2:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO00o(com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o, OooO00o oooO00o2, Bundle bundle) {
        int i;
        int i2;
        long longValue;
        long longValue2;
        long longValue3;
        long longValue4;
        String str = "false";
        Intrinsics.h(oooO00o, "appOpenPointData");
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        StringBuilder sb = new StringBuilder();
        sb.append("reportPageOpenFail #########> appOpenPointData:");
        sb.append(oooO00o);
        sb.append(", pageOpenPointData:");
        sb.append(oooO00o2);
        sb.append(", data");
        sb.append(bundle);
        try {
            long j = bundle.containsKey(ChainPoint.TIME) ? bundle.getLong(ChainPoint.TIME) : System.currentTimeMillis();
            bundle.putString("openPageResult", "false");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (oooO00o2 == null) {
                i2 = oooO00o.OooO0OO.size();
                if (1 <= i2) {
                    int i3 = 1;
                    while (true) {
                        String valueOf = String.valueOf(i3);
                        Long l = oooO00o.OooO0OO.get(valueOf);
                        long longValue5 = l != null ? l.longValue() : 0L;
                        Long l2 = oooO00o.OooO0Oo.get(valueOf);
                        long longValue6 = l2 != null ? l2.longValue() : 0L;
                        Long l3 = oooO00o.OooO0o0.get(valueOf);
                        linkedHashMap.put(valueOf, Long.valueOf(l3 != null ? l3.longValue() : 0L));
                        linkedHashMap2.put(valueOf, new long[]{longValue5, longValue6});
                        if (i3 == i2) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            } else {
                int size = oooO00o2.OooO0OO.size() + 11;
                Iterator<Map.Entry<String, Long>> it = oooO00o2.OooO0OO.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (!oooO00o2.OooO0Oo.containsKey(key)) {
                        oooO00o2.OooO0Oo.put(key, Long.valueOf(j));
                        Map<String, Long> map = oooO00o2.OooO0o0;
                        Long l4 = oooO00o2.OooO0Oo.get(key);
                        Intrinsics.e(l4);
                        long longValue7 = l4.longValue();
                        Long l5 = oooO00o2.OooO0OO.get(key);
                        Intrinsics.e(l5);
                        map.put(key, Long.valueOf(longValue7 - l5.longValue()));
                        str = "true";
                    }
                }
                bundle.putString("isExitInStage", str);
                int i4 = 1;
                while (true) {
                    i = 12;
                    if (i4 >= 12) {
                        break;
                    }
                    String valueOf2 = String.valueOf(i4);
                    if (oooO00o2.OooO0o) {
                        Long l6 = oooO00o.OooO0OO.get(valueOf2);
                        longValue3 = l6 != null ? l6.longValue() : 0L;
                        Long l7 = oooO00o.OooO0Oo.get(valueOf2);
                        longValue4 = l7 != null ? l7.longValue() : 0L;
                        Long l10 = oooO00o.OooO0o0.get(valueOf2);
                        linkedHashMap.put(valueOf2, Long.valueOf(l10 != null ? l10.longValue() : 0L));
                    } else {
                        Long l11 = oooO00o2.OooO0OO.get("12");
                        longValue3 = l11 != null ? l11.longValue() : 0L;
                        Long l12 = oooO00o2.OooO0OO.get("12");
                        longValue4 = l12 != null ? l12.longValue() : 0L;
                        linkedHashMap.put(valueOf2, 0L);
                    }
                    linkedHashMap2.put(valueOf2, new long[]{longValue3, longValue4});
                    i4++;
                }
                if (12 <= size) {
                    while (true) {
                        String valueOf3 = String.valueOf(i);
                        if (oooO00o2.OooO0o || !(Intrinsics.c(valueOf3, PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION) || Intrinsics.c(valueOf3, "16"))) {
                            Long l13 = oooO00o2.OooO0OO.get(valueOf3);
                            longValue = l13 != null ? l13.longValue() : 0L;
                            Long l14 = oooO00o2.OooO0Oo.get(valueOf3);
                            if (l14 != null) {
                                longValue2 = l14.longValue();
                                Long l15 = oooO00o2.OooO0o0.get(valueOf3);
                                linkedHashMap.put(valueOf3, Long.valueOf(l15 == null ? l15.longValue() : 0L));
                                linkedHashMap2.put(valueOf3, new long[]{longValue, longValue2});
                                if (i != size) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            longValue2 = 0;
                            Long l152 = oooO00o2.OooO0o0.get(valueOf3);
                            linkedHashMap.put(valueOf3, Long.valueOf(l152 == null ? l152.longValue() : 0L));
                            linkedHashMap2.put(valueOf3, new long[]{longValue, longValue2});
                            if (i != size) {
                            }
                        } else {
                            Long l16 = oooO00o2.OooO0Oo.get("14");
                            longValue = l16 != null ? l16.longValue() : 0L;
                            Long l17 = oooO00o2.OooO0Oo.get("14");
                            if (l17 != null) {
                                longValue2 = l17.longValue();
                                Long l1522 = oooO00o2.OooO0o0.get(valueOf3);
                                linkedHashMap.put(valueOf3, Long.valueOf(l1522 == null ? l1522.longValue() : 0L));
                                linkedHashMap2.put(valueOf3, new long[]{longValue, longValue2});
                                if (i != size) {
                                }
                            }
                            longValue2 = 0;
                            Long l15222 = oooO00o2.OooO0o0.get(valueOf3);
                            linkedHashMap.put(valueOf3, Long.valueOf(l15222 == null ? l15222.longValue() : 0L));
                            linkedHashMap2.put(valueOf3, new long[]{longValue, longValue2});
                            if (i != size) {
                            }
                        }
                    }
                }
                i2 = size;
            }
            bundle.putInt("maxStage", i2);
            bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap));
            bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap2));
            bundle.putString(PointConstants.POINT_PAGE_PATH, String.valueOf(oooO00o2 != null ? oooO00o2.OooO00o : null));
            if (oooO00o2 != null) {
                oooO00o2.OooO0oO = true;
            }
            bundle.remove(ChainPoint.PAGE_PATH);
            bundle.remove(ChainPoint.PAGE_ID);
            ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(oooO00o.OooO00o, "mini_page_open", bundle);
        } catch (Throwable unused) {
        }
    }

    public final void OooO00o(com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o, OooO00o oooO00o2, Bundle bundle, boolean z) {
        int i;
        App findApp;
        ShowPageStore showPageStore;
        Stack<ShowPageData> findShowPages;
        long longValue;
        long longValue2;
        long longValue3;
        long longValue4;
        StringBuilder sb = new StringBuilder();
        sb.append("reportPageOpenSuccess #########> appOpenPointData:");
        sb.append(oooO00o);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reportPageOpenSuccess #########> pageOpenPointData:");
        sb2.append(oooO00o2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("reportPageOpenSuccess #########> data:");
        sb3.append(bundle);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("reportPageOpenSuccess #########> isHomePage:");
        sb4.append(z);
        try {
            if (oooO00o2.OooO0oo) {
                return;
            }
            bundle.putString("openPageResult", "true");
            bundle.putString(ChainPoint.OPEN_PAGE_FAILED_REASON, "");
            bundle.putInt("maxStage", 17);
            bundle.putString("isExitInStage", "");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            int i2 = 1;
            while (true) {
                if (i2 >= 12) {
                    break;
                }
                String valueOf = String.valueOf(i2);
                if (z) {
                    Long l = oooO00o.OooO0OO.get(valueOf);
                    longValue3 = l != null ? l.longValue() : 0L;
                    Long l2 = oooO00o.OooO0Oo.get(valueOf);
                    longValue4 = l2 != null ? l2.longValue() : 0L;
                    Long l3 = oooO00o.OooO0o0.get(valueOf);
                    linkedHashMap.put(valueOf, Long.valueOf(l3 != null ? l3.longValue() : 0L));
                } else {
                    Long l4 = oooO00o2.OooO0OO.get("12");
                    longValue3 = l4 != null ? l4.longValue() : 0L;
                    Long l5 = oooO00o2.OooO0OO.get("12");
                    longValue4 = l5 != null ? l5.longValue() : 0L;
                    linkedHashMap.put(valueOf, 0L);
                }
                linkedHashMap2.put(valueOf, new long[]{longValue3, longValue4});
                i2++;
            }
            for (i = 12; i < 18; i++) {
                String valueOf2 = String.valueOf(i);
                if (z || !(Intrinsics.c(valueOf2, PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION) || Intrinsics.c(valueOf2, "16"))) {
                    Long l6 = oooO00o2.OooO0OO.get(valueOf2);
                    longValue = l6 != null ? l6.longValue() : 0L;
                    Long l7 = oooO00o2.OooO0Oo.get(valueOf2);
                    if (l7 != null) {
                        longValue2 = l7.longValue();
                    }
                    longValue2 = 0;
                } else {
                    Long l10 = oooO00o2.OooO0Oo.get("14");
                    longValue = l10 != null ? l10.longValue() : 0L;
                    Long l11 = oooO00o2.OooO0Oo.get("14");
                    if (l11 != null) {
                        longValue2 = l11.longValue();
                    }
                    longValue2 = 0;
                }
                Long l12 = oooO00o2.OooO0o0.get(valueOf2);
                linkedHashMap.put(valueOf2, Long.valueOf(l12 != null ? l12.longValue() : 0L));
                linkedHashMap2.put(valueOf2, new long[]{longValue, longValue2});
            }
            bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap));
            bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap2));
            bundle.putString(PointConstants.POINT_PAGE_PATH, String.valueOf(oooO00o2.OooO00o));
            oooO00o2.OooO0oo = true;
            bundle.remove(ChainPoint.PAGE_PATH);
            bundle.remove(ChainPoint.PAGE_ID);
            if (Intrinsics.c(bundle.getString(ChainPoint.PAGE_CATEGOR_TYPE), "2") && (findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(oooO00o.OooO00o)) != null && (showPageStore = (ShowPageStore) findApp.getData(ShowPageStore.class)) != null && (findShowPages = showPageStore.findShowPages()) != null) {
                for (ShowPageData showPageData : findShowPages) {
                    if (Intrinsics.c(showPageData.getUrl(), oooO00o2.OooO00o)) {
                        bundle.putString(PointConstants.POINT_PAGE_PATH, String.valueOf(showPageData.getRequestUrl()));
                    }
                }
            }
            ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(oooO00o.OooO00o, "mini_page_open", bundle);
        } catch (Throwable unused) {
        }
    }

    public final boolean OooO00o(String str, Bundle bundle) {
        OooO00o oooO00o;
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        StringBuilder sb = new StringBuilder();
        sb.append("recordPageStageFail #########> appId:");
        sb.append(str);
        sb.append(", data:");
        sb.append(bundle);
        if (str != null) {
            try {
                com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o2 = (com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o) ((LinkedHashMap) com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO0O0).get(str);
                if (oooO00o2 == null) {
                    return true;
                }
                String string = bundle.getString(ChainPoint.PAGE_ID, "");
                if (TextUtils.isEmpty(string) || (oooO00o = oooO00o2.OooO0o.get(string)) == null || !Intrinsics.c(oooO00o.OooO0O0, string)) {
                    return true;
                }
                if (!Intrinsics.c(oooO00o.OooO00o, bundle.getString(ChainPoint.PAGE_PATH, ""))) {
                    return true;
                }
                OooO00o.OooO00o(oooO00o2, oooO00o, bundle);
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public final boolean OooO00o(String str, String str2, Bundle bundle) {
        long j;
        com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o;
        OooO00o oooO00o2;
        Intrinsics.h(str, "stage");
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        StringBuilder sb = new StringBuilder();
        sb.append("recordPageStageEnd #########> stage:");
        sb.append(str);
        sb.append(", appId:");
        sb.append(str2);
        sb.append(", data:");
        sb.append(bundle);
        try {
            j = bundle.containsKey(ChainPoint.TIME) ? bundle.getLong(ChainPoint.TIME) : System.currentTimeMillis();
            oooO00o = (com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o) ((LinkedHashMap) com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO0O0).get(str2);
        } catch (Throwable unused) {
        }
        if (oooO00o == null) {
            return true;
        }
        String string = bundle.getString(ChainPoint.PAGE_ID, "");
        if (TextUtils.isEmpty(string) || (oooO00o2 = oooO00o.OooO0o.get(string)) == null || !Intrinsics.c(oooO00o2.OooO0O0, string)) {
            return true;
        }
        if (!Intrinsics.c(oooO00o2.OooO00o, bundle.getString(ChainPoint.PAGE_PATH, "")) || !oooO00o2.OooO0OO.containsKey(str)) {
            return true;
        }
        oooO00o2.OooO0Oo.put(str, Long.valueOf(j));
        Map<String, Long> map = oooO00o2.OooO0o0;
        Long l = oooO00o2.OooO0Oo.get(str);
        Intrinsics.e(l);
        long longValue = l.longValue();
        Long l2 = oooO00o2.OooO0OO.get(str);
        Intrinsics.e(l2);
        map.put(str, Long.valueOf(longValue - l2.longValue()));
        if (Intrinsics.c(str, ChainPoint.PageDrawView)) {
            OooO00o(oooO00o, oooO00o2, bundle, oooO00o2.OooO0o);
        }
        return true;
    }

    public final boolean OooO0O0(String str, Bundle bundle) {
        OooO00o oooO00o;
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        StringBuilder sb = new StringBuilder();
        sb.append("reportPageOpenFinish #########> appId:");
        sb.append(str);
        sb.append(", data:");
        sb.append(bundle);
        if (str != null) {
            try {
                com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o2 = (com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o) ((LinkedHashMap) com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO0O0).get(str);
                if (oooO00o2 == null) {
                    return true;
                }
                String string = bundle.getString(ChainPoint.PAGE_ID, "");
                if (TextUtils.isEmpty(string) || (oooO00o = oooO00o2.OooO0o.get(string)) == null || !Intrinsics.c(oooO00o.OooO0O0, string)) {
                    return true;
                }
                if (!Intrinsics.c(oooO00o.OooO00o, bundle.getString(ChainPoint.PAGE_PATH, ""))) {
                    return true;
                }
                if (oooO00o.OooO0oo) {
                    oooO00o2.OooO0o.remove(string);
                    return true;
                }
                if (oooO00o.OooO0oO) {
                    oooO00o2.OooO0o.remove(string);
                    return true;
                }
                OooO00o.OooO00o(oooO00o2, oooO00o, bundle);
                oooO00o2.OooO0o.remove(string);
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public final boolean OooO0O0(String str, String str2, Bundle bundle) {
        long j;
        com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o;
        Intrinsics.h(str, "stage");
        Intrinsics.h(bundle, TmcConstants.KEY_BRIDGE_RESULT_DATA);
        StringBuilder sb = new StringBuilder();
        sb.append("recordPageStageStart #########> stage:");
        sb.append(str);
        sb.append(", appId:");
        sb.append(str2);
        sb.append(", data:");
        sb.append(bundle);
        try {
            j = bundle.containsKey(ChainPoint.TIME) ? bundle.getLong(ChainPoint.TIME) : System.currentTimeMillis();
            oooO00o = (com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o) ((LinkedHashMap) com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO0O0).get(str2);
        } catch (Throwable unused) {
        }
        if (oooO00o == null) {
            return true;
        }
        String string = bundle.getString(ChainPoint.PAGE_ID, "");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        String string2 = bundle.getString(ChainPoint.PAGE_PATH, "");
        if (Intrinsics.c(str, ChainPoint.PageCreateContainer)) {
            if (oooO00o.OooO0o.containsKey(string)) {
                oooO00o.OooO0o.remove(string);
            }
            Map m = MapsKt.m(new Pair[]{TuplesKt.a(str, Long.valueOf(j))});
            boolean isEmpty = oooO00o.OooO0o.isEmpty();
            Map<String, OooO00o> map = oooO00o.OooO0o;
            Intrinsics.g(string, "pageId");
            Intrinsics.g(string2, FrameworkConstants.GLOBAL_DATA_KEY_PAGE_PATH);
            map.put(string, new OooO00o(string2, string, m, new LinkedHashMap(), new LinkedHashMap(), isEmpty, false, false));
        } else {
            OooO00o oooO00o2 = oooO00o.OooO0o.get(string);
            if (oooO00o2 == null) {
                return true;
            }
            oooO00o2.OooO0OO.put(str, Long.valueOf(j));
        }
        return true;
    }
}
