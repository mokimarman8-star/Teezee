package com.cloud.tmc.miniapp.performanceanalyse;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.model.ForegroundTime;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.kernel.bridge.extension.BridgeResponse;
import com.cloud.tmc.kernel.constants.LauncherLifecycleType;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ICommunicationTimeProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointConstants;
import com.cloud.tmc.kernel.proxy.performanceanalyse.a;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooOO0O {
    public long OooO00o;
    public long OooO0O0;
    public boolean OooO0OO;
    public final Map<String, com.cloud.tmc.miniapp.performanceanalyse.OooO0O0> OooO0Oo = new LinkedHashMap();
    public static final OooO00o OooO0o0 = new OooO00o();
    public static final AtomicLong OooO0o = new AtomicLong(1);

    public static final class OooO00o {
    }

    public /* synthetic */ class OooO0O0 {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[PointAnalyseType.values().length];
            try {
                iArr[PointAnalyseType.POINT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointAnalyseType.POINT_JS_BRIDGE_READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointAnalyseType.POINT_RENDER_READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CREATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PointAnalyseType.POINT_RENDER_T1.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PointAnalyseType.POINT_RENDER_T2.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PointAnalyseType.POINT_WORKER_READY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PointAnalyseType.POINT_SDK_PV.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_PV.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PointAnalyseType.POINT_EXIT_CLICK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PointAnalyseType.POINT_EXIT_MINIAPP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[PointAnalyseType.POINT_NAV_HOME_PRESSED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[PointAnalyseType.POINT_MORE_ENTER.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[PointAnalyseType.POINT_MORE_EXIT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHORT_CUT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHARE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHARE_URL.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHARE_SAVE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[PointAnalyseType.POINT_REFRESH.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[PointAnalyseType.POINT_ENTER_DEVELOP.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_AUTH.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_MESSAGE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_WIDGET.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_WHATSAPP.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_TELEGRAM.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_ICON_SHARE.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_MC.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[PointAnalyseType.POINT_LAUNCH_MINIAPP_START.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[PointAnalyseType.POINT_LAUNCH_MINIAPP_HOT_OPEN.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[PointAnalyseType.POINT_DOWNLOAD_V8_START.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[PointAnalyseType.POINT_DOWNLOAD_V8_SUCCESS.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[PointAnalyseType.POINT_DOWNLOAD_V8_FAIL.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHECK_WHITESCREEN.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[PointAnalyseType.POINT_FPS.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_START.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_END.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_INSERT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_CLEAR.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[PointAnalyseType.POINT_H5_PAGE_ONFINISHED.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[PointAnalyseType.POINT_LOG_ERROR.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[PointAnalyseType.POINT_PRIVACY_AGREEMENT.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_PACKAGE_FILE.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_UPDATE_START.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_START.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_END.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_START.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_END.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_CLEAR.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_CLEAR.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_INSERT.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_FAIL.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_FAIL.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                iArr[PointAnalyseType.POINT_MINIAPP_FOREGROUND_TIME.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ODID.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                iArr[PointAnalyseType.POINT_HOT_RELOAD.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                iArr[PointAnalyseType.POINT_OPEN_PAGE_ACTION.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_EX.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_CLICK.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_BANNER_EX.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_BANNER_CLICK.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_ADD_MC_CLICK.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_ADD_MC_EX.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                iArr[PointAnalyseType.POINT_PRIVACY_EX.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                iArr[PointAnalyseType.POINT_PRIVACY_CLICK.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                iArr[PointAnalyseType.ADD_MINI_APP_TO_DESKTOP.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                iArr[PointAnalyseType.PRE_REQUEST_HTML.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                iArr[PointAnalyseType.PRE_REQUEST_HTML_RET.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                iArr[PointAnalyseType.GET_PRE_HTML.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                iArr[PointAnalyseType.GET_PRE_HTML_HIT.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                iArr[PointAnalyseType.POINT_OPEN_BROWSER.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                iArr[PointAnalyseType.PRE_STRATEGY_FAIL.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                iArr[PointAnalyseType.POINT_LATER_OFFLINE_EX.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                iArr[PointAnalyseType.POINT_LATER_OFFLINE_APP_EX.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                iArr[PointAnalyseType.POINT_LATER_OFFLINE_CLICK.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ADD_EX.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_TOAST_ADD_EX.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ADD_CLICK.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ADD_NOSHOW.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            OooO00o = iArr;
        }
    }

    public final void OooO00o() {
        try {
            com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o.OooO00o();
        } catch (Throwable th) {
            TmcLogger.e("PointTrack", "tryInitAthena failed!", th);
        }
    }

    public final void OooO00o(Bundle bundle) {
        Map<String, Long> map;
        Long l;
        String string = bundle.getString(ChainPoint.CHAIN_ID, "");
        String string2 = bundle.getString(ChainPoint.PAGE_PATH, "");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || !this.OooO0Oo.containsKey(string)) {
            return;
        }
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0 = this.OooO0Oo.get(string);
        if (oooO0O0 != null) {
            if (Intrinsics.c(oooO0O0.OooO0O0, string2)) {
                bundle.putString("openType", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
                long currentTimeMillis = System.currentTimeMillis();
                Long l2 = oooO0O0.OooO0OO.get("18");
                bundle.putLong("openAppTime", currentTimeMillis - (l2 != null ? l2.longValue() : currentTimeMillis));
                Long l3 = oooO0O0.OooO0OO.get("17");
                bundle.putLong("openPageTime", currentTimeMillis - (l3 != null ? l3.longValue() : currentTimeMillis));
            } else {
                bundle.putString("openType", "page");
                long currentTimeMillis2 = System.currentTimeMillis();
                OooOO0 oooOO0 = oooO0O0.OooO0o0.get(string2);
                bundle.putLong("openPageTime", currentTimeMillis2 - ((oooOO0 == null || (map = oooOO0.OooO0OO) == null || (l = map.get("17")) == null) ? currentTimeMillis2 : l.longValue()));
            }
        }
        bundle.remove(ChainPoint.TYPE);
        bundle.remove(ChainPoint.CHAIN_ID);
        bundle.remove(ChainPoint.PAGE_PATH);
    }

    public final void OooO00o(Bundle bundle, String str) {
        AppContext appContext;
        Context context;
        if (str != null) {
            try {
                App findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str);
                if (findApp == null || (appContext = findApp.getAppContext()) == null || (context = appContext.getContext()) == null) {
                    return;
                }
                Intrinsics.g(context, "context");
                bundle.putString("queryShortcutExist", String.valueOf(AppUtils.INSTANCE.queryShortcutExist(context, str)));
            } catch (Throwable th) {
                TmcLogger.e("PointTrack", "queryShortcutStatus failed!", th);
            }
        }
    }

    public final void OooO00o(String str) {
        App findApp;
        if (str != null) {
            try {
                App findApp2 = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str);
                if ((findApp2 != null ? (ForegroundTime) findApp2.getData(ForegroundTime.class) : null) != null || (findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str)) == null) {
                    return;
                }
                ForegroundTime foregroundTime = new ForegroundTime();
                foregroundTime.setStartTime();
                foregroundTime.resetStartCount();
                foregroundTime.addStartCount();
                Unit unit = Unit.a;
                findApp.setData(ForegroundTime.class, foregroundTime);
            } catch (Throwable th) {
                TmcLogger.e("PointTrack", "startRecordForegroundTime failed!", th);
            }
        }
    }

    public final void OooO00o(String str, Bundle bundle) {
        String str2;
        String str3;
        Map<String, Long> map;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0;
        Map<String, Long> map2;
        Map<String, Long> map3;
        Map<String, Long> map4;
        Map<String, OooOO0> map5;
        OooOO0 oooOO0;
        Map<String, OooOO0> map6;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O02;
        Map<String, Long> map7;
        Map<String, Long> map8;
        String string = bundle.getString(ChainPoint.TYPE, "");
        String string2 = bundle.getString(ChainPoint.CHAIN_ID, "");
        String string3 = bundle.getString(ChainPoint.PAGE_PATH, "");
        TmcLogger.d("oldChain", "chainStart -> msg:" + str + ", type:" + string + ", pagePath:" + string3);
        if (this.OooO0Oo.containsKey(string2)) {
            str2 = string3;
        } else {
            Map<String, com.cloud.tmc.miniapp.performanceanalyse.OooO0O0> map9 = this.OooO0Oo;
            Intrinsics.g(string2, "appId");
            str2 = string3;
            map9.put(string2, new com.cloud.tmc.miniapp.performanceanalyse.OooO0O0(string2, null, new LinkedHashMap(), new LinkedHashMap(), new LinkedHashMap(), 0, 0, 0, 0, false, "", "", "", "", false));
        }
        if (Intrinsics.c(OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP, string)) {
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O03 = this.OooO0Oo.get(string2);
            if ((oooO0O03 != null && (map8 = oooO0O03.OooO0OO) != null && map8.containsKey(str)) || (oooO0O02 = this.OooO0Oo.get(string2)) == null || (map7 = oooO0O02.OooO0OO) == null) {
                return;
            }
            map7.put(str, Long.valueOf(System.currentTimeMillis()));
            return;
        }
        if (!Intrinsics.c("page", string) || (str3 = str2) == null || str3.length() == 0) {
            return;
        }
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O04 = this.OooO0Oo.get(string2);
        Map<String, OooOO0> map10 = oooO0O04 != null ? oooO0O04.OooO0o0 : null;
        if ((map10 == null || !map10.containsKey(str3)) && map10 != null) {
            Intrinsics.g(str3, FrameworkConstants.GLOBAL_DATA_KEY_PAGE_PATH);
            map10.put(str3, new OooOO0(str3, "", new LinkedHashMap(), new LinkedHashMap(), "", "", ""));
        }
        if (Intrinsics.c(ChainPoint.CreateRender, str)) {
            String string4 = bundle.getString(ChainPoint.RENDER_ID, "");
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O05 = this.OooO0Oo.get(string2);
            OooOO0 oooOO02 = (oooO0O05 == null || (map6 = oooO0O05.OooO0o0) == null) ? null : map6.get(str3);
            if (oooOO02 != null) {
                Intrinsics.g(string4, "renderId");
                Intrinsics.h(string4, "<set-?>");
                oooOO02.OooO0O0 = string4;
            }
        }
        if (Intrinsics.c(ChainPoint.ROUTE_PAGE, str)) {
            String string5 = bundle.getString("navigationType");
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O06 = this.OooO0Oo.get(string2);
            if (oooO0O06 != null && (map5 = oooO0O06.OooO0o0) != null && (oooOO0 = map5.get(str3)) != null) {
                if (string5 == null) {
                    string5 = "";
                }
                Intrinsics.h(string5, "<set-?>");
                oooOO0.OooO0oO = string5;
            }
        }
        OooOO0 oooOO03 = map10 != null ? map10.get(str3) : null;
        if ((oooOO03 == null || (map4 = oooOO03.OooO0OO) == null || !map4.containsKey(str)) && oooOO03 != null && (map = oooOO03.OooO0OO) != null) {
            map.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O07 = this.OooO0Oo.get(string2);
        if ((oooO0O07 != null ? oooO0O07.OooO0O0 : null) == null) {
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O08 = this.OooO0Oo.get(string2);
            if (oooO0O08 != null) {
                oooO0O08.OooO0O0 = str3;
            }
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O09 = this.OooO0Oo.get(string2);
            if (oooO0O09 != null) {
                String string6 = bundle.getString(TmcConstants.KEY_PAGE_RANDOM_ID);
                if (string6 == null) {
                    string6 = "";
                }
                Intrinsics.h(string6, "<set-?>");
                oooO0O09.OooOOO = string6;
            }
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O010 = this.OooO0Oo.get(string2);
            if (oooO0O010 != null) {
                String string7 = bundle.getString("navigationType");
                String str4 = string7 != null ? string7 : "";
                Intrinsics.h(str4, "<set-?>");
                oooO0O010.OooOOO0 = str4;
            }
        }
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O011 = this.OooO0Oo.get(string2);
        if (Intrinsics.c(str3, oooO0O011 != null ? oooO0O011.OooO0O0 : null)) {
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O012 = this.OooO0Oo.get(string2);
            if ((oooO0O012 != null && (map3 = oooO0O012.OooO0OO) != null && map3.containsKey(str)) || (oooO0O0 = this.OooO0Oo.get(string2)) == null || (map2 = oooO0O0.OooO0OO) == null) {
                return;
            }
            map2.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0d75  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0d93  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03c6 A[Catch: all -> 0x061f, TryCatch #4 {all -> 0x061f, blocks: (B:143:0x0228, B:146:0x0273, B:148:0x0279, B:150:0x0283, B:151:0x028a, B:153:0x0294, B:154:0x029b, B:156:0x02a5, B:158:0x02ae, B:161:0x02b9, B:163:0x02c1, B:165:0x02d1, B:167:0x02d7, B:169:0x02df, B:170:0x02e3, B:172:0x02ef, B:175:0x0329, B:177:0x0333, B:178:0x033e, B:180:0x034b, B:181:0x0356, B:183:0x0363, B:184:0x036e, B:186:0x037b, B:187:0x037f, B:189:0x0390, B:193:0x039e, B:195:0x03ab, B:199:0x03b9, B:201:0x03c6, B:202:0x03d0, B:204:0x03db, B:206:0x03e5, B:207:0x03ec, B:209:0x03ef, B:211:0x03f9, B:212:0x03fd, B:214:0x05fc, B:228:0x040d, B:230:0x0423, B:232:0x042d, B:233:0x0434, B:235:0x043a, B:237:0x0444, B:239:0x044a, B:243:0x0452, B:245:0x045c, B:247:0x0462, B:249:0x046a, B:250:0x0471, B:252:0x047b, B:254:0x0481, B:256:0x0489, B:258:0x0492, B:261:0x04a1, B:263:0x04a9, B:265:0x04b9, B:267:0x04bf, B:269:0x04c7, B:270:0x04cb, B:272:0x04da, B:274:0x04e0, B:278:0x04ec, B:284:0x0524, B:286:0x052e, B:287:0x0535, B:289:0x0544, B:291:0x054a, B:293:0x0552, B:295:0x055a, B:297:0x0569, B:299:0x056f, B:301:0x0577, B:303:0x057f, B:305:0x058c, B:306:0x0593, B:308:0x05a0, B:309:0x05ab, B:311:0x05b8, B:312:0x05bc, B:314:0x05cd, B:316:0x05d3, B:318:0x05db, B:319:0x05df, B:321:0x05f0, B:323:0x05f6), top: B:142:0x0228 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03db A[Catch: all -> 0x061f, TryCatch #4 {all -> 0x061f, blocks: (B:143:0x0228, B:146:0x0273, B:148:0x0279, B:150:0x0283, B:151:0x028a, B:153:0x0294, B:154:0x029b, B:156:0x02a5, B:158:0x02ae, B:161:0x02b9, B:163:0x02c1, B:165:0x02d1, B:167:0x02d7, B:169:0x02df, B:170:0x02e3, B:172:0x02ef, B:175:0x0329, B:177:0x0333, B:178:0x033e, B:180:0x034b, B:181:0x0356, B:183:0x0363, B:184:0x036e, B:186:0x037b, B:187:0x037f, B:189:0x0390, B:193:0x039e, B:195:0x03ab, B:199:0x03b9, B:201:0x03c6, B:202:0x03d0, B:204:0x03db, B:206:0x03e5, B:207:0x03ec, B:209:0x03ef, B:211:0x03f9, B:212:0x03fd, B:214:0x05fc, B:228:0x040d, B:230:0x0423, B:232:0x042d, B:233:0x0434, B:235:0x043a, B:237:0x0444, B:239:0x044a, B:243:0x0452, B:245:0x045c, B:247:0x0462, B:249:0x046a, B:250:0x0471, B:252:0x047b, B:254:0x0481, B:256:0x0489, B:258:0x0492, B:261:0x04a1, B:263:0x04a9, B:265:0x04b9, B:267:0x04bf, B:269:0x04c7, B:270:0x04cb, B:272:0x04da, B:274:0x04e0, B:278:0x04ec, B:284:0x0524, B:286:0x052e, B:287:0x0535, B:289:0x0544, B:291:0x054a, B:293:0x0552, B:295:0x055a, B:297:0x0569, B:299:0x056f, B:301:0x0577, B:303:0x057f, B:305:0x058c, B:306:0x0593, B:308:0x05a0, B:309:0x05ab, B:311:0x05b8, B:312:0x05bc, B:314:0x05cd, B:316:0x05d3, B:318:0x05db, B:319:0x05df, B:321:0x05f0, B:323:0x05f6), top: B:142:0x0228 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0da9  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03f9 A[Catch: all -> 0x061f, TryCatch #4 {all -> 0x061f, blocks: (B:143:0x0228, B:146:0x0273, B:148:0x0279, B:150:0x0283, B:151:0x028a, B:153:0x0294, B:154:0x029b, B:156:0x02a5, B:158:0x02ae, B:161:0x02b9, B:163:0x02c1, B:165:0x02d1, B:167:0x02d7, B:169:0x02df, B:170:0x02e3, B:172:0x02ef, B:175:0x0329, B:177:0x0333, B:178:0x033e, B:180:0x034b, B:181:0x0356, B:183:0x0363, B:184:0x036e, B:186:0x037b, B:187:0x037f, B:189:0x0390, B:193:0x039e, B:195:0x03ab, B:199:0x03b9, B:201:0x03c6, B:202:0x03d0, B:204:0x03db, B:206:0x03e5, B:207:0x03ec, B:209:0x03ef, B:211:0x03f9, B:212:0x03fd, B:214:0x05fc, B:228:0x040d, B:230:0x0423, B:232:0x042d, B:233:0x0434, B:235:0x043a, B:237:0x0444, B:239:0x044a, B:243:0x0452, B:245:0x045c, B:247:0x0462, B:249:0x046a, B:250:0x0471, B:252:0x047b, B:254:0x0481, B:256:0x0489, B:258:0x0492, B:261:0x04a1, B:263:0x04a9, B:265:0x04b9, B:267:0x04bf, B:269:0x04c7, B:270:0x04cb, B:272:0x04da, B:274:0x04e0, B:278:0x04ec, B:284:0x0524, B:286:0x052e, B:287:0x0535, B:289:0x0544, B:291:0x054a, B:293:0x0552, B:295:0x055a, B:297:0x0569, B:299:0x056f, B:301:0x0577, B:303:0x057f, B:305:0x058c, B:306:0x0593, B:308:0x05a0, B:309:0x05ab, B:311:0x05b8, B:312:0x05bc, B:314:0x05cd, B:316:0x05d3, B:318:0x05db, B:319:0x05df, B:321:0x05f0, B:323:0x05f6), top: B:142:0x0228 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0dc4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0e1e  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0818 A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x086e A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0a25 A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0a56 A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0a93 A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0ab9 A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0adc  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0add A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0e7a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0de5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0dc0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void OooO00o(String str, PointAnalyseType pointAnalyseType, String str2, Bundle bundle) {
        String str3;
        String str4;
        String str5;
        boolean z;
        boolean z2;
        Bundle bundle2;
        long j;
        long currentTimeMillis;
        long j2;
        long currentTimeMillis2;
        long j3;
        long currentTimeMillis3;
        String str6;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0;
        Map<String, Long> OooO0O02;
        boolean z3;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O02;
        Map<String, Long> OooO00o2;
        Map<String, OooOO0> OooOO0;
        OooOO0 oooOO0;
        Map<String, Long> OooO0O03;
        Long l;
        Map<String, OooOO0> OooOO02;
        OooOO0 oooOO02;
        Map<String, Long> OooO0O04;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O03;
        Map<String, OooOO0> OooOO03;
        OooOO0 oooOO03;
        Map<String, Long> OooO00o3;
        Map<String, OooOO0> OooOO04;
        OooOO0 oooOO04;
        Map<String, Long> OooO0O05;
        Long l2;
        String str7;
        String str8;
        String str9;
        boolean z4;
        String str10;
        int i;
        String str11;
        int i2;
        String str12;
        int i3;
        String str13;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O04;
        String str14;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O05;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O06;
        Map<String, OooOO0> OooOO05;
        OooOO0 oooOO05;
        Map<String, OooOO0> OooOO06;
        OooOO0 oooOO06;
        Map<String, OooOO0> OooOO07;
        OooOO0 oooOO07;
        AppContext appContext;
        Map<String, Long> OooO00o4;
        Map<String, Long> OooO0O06;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O07;
        Map<String, Long> OooO00o5;
        Map<String, Long> OooO0O07;
        Long l3;
        String str15;
        String str16;
        boolean z5;
        String str17;
        String str18;
        String str19;
        int i4;
        Map<String, OooOO0> OooOO08;
        Map<String, OooOO0> OooOO09;
        OooOO0 oooOO08;
        Map<String, OooOO0> OooOO010;
        OooOO0 oooOO09;
        Map<String, OooOO0> OooOO011;
        OooOO0 oooOO010;
        Map<String, OooOO0> OooOO012;
        Map<String, OooOO0> OooOO013;
        OooOO0 oooOO011;
        Map<String, OooOO0> OooOO014;
        OooOO0 oooOO012;
        Map<String, OooOO0> OooOO015;
        OooOO0 oooOO013;
        Map<String, OooOO0> OooOO016;
        String str20;
        int i5;
        String str21;
        int i6;
        String str22;
        int i7;
        String str23;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O08;
        String str24;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O09;
        String str25;
        boolean z6;
        Map<String, OooOO0> OooOO017;
        OooOO0 oooOO014;
        String str26;
        String str27;
        long j4;
        PointAnalyseType pointAnalyseType2;
        String des;
        StringBuilder sb;
        HashMap<String, Object> data;
        String str28 = "chain_id_";
        Intrinsics.h(pointAnalyseType, TmcConstants.EXTRA_SHARE_TARGET);
        Bundle bundle3 = new Bundle();
        if (bundle != null) {
            bundle3.putAll(bundle);
            Unit unit = Unit.a;
        }
        String str29 = "miniapp_click";
        switch (OooO0O0.OooO00o[pointAnalyseType.ordinal()]) {
            case 1:
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                bundle2 = bundle3;
                j = 0;
                this.OooO00o = System.currentTimeMillis();
                this.OooO0O0 = 0L;
                Unit unit2 = Unit.a;
                j2 = j;
                str29 = str3;
                str26 = str29;
                j4 = j2;
                String str30 = (str5 != null || TextUtils.isEmpty(str2)) ? str3 : "-信息:" + str5;
                if (j4 > j) {
                    str30 = "-耗时:" + j4 + ((Object) str30);
                }
                if (j4 <= j) {
                    pointAnalyseType2 = pointAnalyseType;
                    if (pointAnalyseType2 == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.d(StringsKt.S(str30, "-", "", false, 4, (Object) null));
                    }
                } else {
                    pointAnalyseType2 = pointAnalyseType;
                }
                if (str4 == null) {
                    des = pointAnalyseType.getDes();
                    sb = new StringBuilder();
                    sb.append("[");
                    sb.append(str4);
                    sb.append("]:");
                } else {
                    des = pointAnalyseType.getDes();
                    sb = new StringBuilder();
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2 = sb.toString();
                ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2);
                data = pointAnalyseType.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> entrySet = data.entrySet();
                    Intrinsics.g(entrySet, "it.entries");
                    Iterator<T> it = entrySet.iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        Object value = entry.getValue();
                        if (value instanceof String) {
                            String str31 = (String) entry.getKey();
                            Object value2 = entry.getValue();
                            Intrinsics.f(value2, "null cannot be cast to non-null type kotlin.String");
                            bundle2.putString(str31, (String) value2);
                        } else if (value instanceof Long) {
                            String str32 = (String) entry.getKey();
                            Object value3 = entry.getValue();
                            Intrinsics.f(value3, "null cannot be cast to non-null type kotlin.Long");
                            bundle2.putLong(str32, ((Long) value3).longValue());
                        }
                    }
                    Unit unit3 = Unit.a;
                }
                Unit unit4 = Unit.a;
                reportProxy.report(str4, str26, bundle2);
                if (j4 != j) {
                    z = z2;
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2, z);
                a.a(pointAnalyseType2, sb2);
                break;
            case 2:
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                bundle2 = bundle3;
                j = 0;
                currentTimeMillis = System.currentTimeMillis() - this.OooO00o;
                Unit unit5 = Unit.a;
                j2 = currentTimeMillis;
                str29 = str3;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                    break;
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22 = sb.toString();
                ReportProxy reportProxy2 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42 = Unit.a;
                reportProxy2.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22, z);
                a.a(pointAnalyseType2, sb22);
                break;
            case 3:
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                bundle2 = bundle3;
                j = 0;
                currentTimeMillis = System.currentTimeMillis() - this.OooO00o;
                Unit unit6 = Unit.a;
                j2 = currentTimeMillis;
                str29 = str3;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222 = sb.toString();
                ReportProxy reportProxy22 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422 = Unit.a;
                reportProxy22.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222, z);
                a.a(pointAnalyseType2, sb222);
                break;
            case 4:
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                bundle2 = bundle3;
                j = 0;
                this.OooO0OO = true;
                this.OooO0O0 = System.currentTimeMillis();
                Unit unit7 = Unit.a;
                j2 = j;
                str29 = str3;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222 = sb.toString();
                ReportProxy reportProxy222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222 = Unit.a;
                reportProxy222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222, z);
                a.a(pointAnalyseType2, sb2222);
                break;
            case 5:
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                bundle2 = bundle3;
                j = 0;
                if (!this.OooO0OO) {
                    this.OooO0O0 = System.currentTimeMillis();
                }
                Unit unit8 = Unit.a;
                z2 = true;
                j2 = j;
                str29 = str3;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222 = sb.toString();
                ReportProxy reportProxy2222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222 = Unit.a;
                reportProxy2222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222, z);
                a.a(pointAnalyseType2, sb22222);
                break;
            case 6:
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                bundle2 = bundle3;
                this.OooO0OO = false;
                j = 0;
                if (this.OooO0O0 == 0) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    j3 = this.OooO00o;
                } else {
                    currentTimeMillis2 = System.currentTimeMillis();
                    j3 = this.OooO0O0;
                }
                long j5 = currentTimeMillis2 - j3;
                bundle2.putString("object_id", "201");
                bundle2.putString("render_time", String.valueOf(j5));
                Unit unit9 = Unit.a;
                j2 = j5;
                str29 = "miniapp_exposure";
                z2 = true;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222 = sb.toString();
                ReportProxy reportProxy22222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222 = Unit.a;
                reportProxy22222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222, z);
                a.a(pointAnalyseType2, sb222222);
                break;
            case 7:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                currentTimeMillis3 = System.currentTimeMillis() - this.OooO00o;
                Unit unit10 = Unit.a;
                j2 = currentTimeMillis3;
                str29 = str3;
                z = false;
                z2 = true;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222 = sb.toString();
                ReportProxy reportProxy222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222 = Unit.a;
                reportProxy222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222, z);
                a.a(pointAnalyseType2, sb2222222);
                break;
            case 8:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                currentTimeMillis3 = System.currentTimeMillis() - this.OooO00o;
                Unit unit11 = Unit.a;
                j2 = currentTimeMillis3;
                str29 = str3;
                z = false;
                z2 = true;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222 = sb.toString();
                ReportProxy reportProxy2222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222 = Unit.a;
                reportProxy2222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222, z);
                a.a(pointAnalyseType2, sb22222222);
                break;
            case 9:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                Unit unit12 = Unit.a;
                str6 = "miniapp_sdkInit";
                str29 = str6;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222 = sb.toString();
                ReportProxy reportProxy22222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222 = Unit.a;
                reportProxy22222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222, z);
                a.a(pointAnalyseType2, sb222222222);
                break;
            case BridgeResponse.ERROR_CODE_UNAUTHORIZED_USERINFO /* 10 */:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "200");
                Unit unit13 = Unit.a;
                str29 = "miniapp_exposure";
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222 = sb.toString();
                ReportProxy reportProxy222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222 = Unit.a;
                reportProxy222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222, z);
                a.a(pointAnalyseType2, sb2222222222);
                break;
            case 11:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", PrepareException.ERROR_MINI_APP_CLOSE);
                Unit unit14 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222 = sb.toString();
                ReportProxy reportProxy2222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222 = Unit.a;
                reportProxy2222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222, z);
                a.a(pointAnalyseType2, sb22222222222);
                break;
            case 12:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "10");
                Unit unit15 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222 = sb.toString();
                ReportProxy reportProxy22222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222 = Unit.a;
                reportProxy22222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222, z);
                a.a(pointAnalyseType2, sb222222222222);
                break;
            case 13:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY);
                Unit unit16 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222 = sb.toString();
                ReportProxy reportProxy222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222 = Unit.a;
                reportProxy222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222);
                break;
            case 14:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "12");
                Unit unit17 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222 = Unit.a;
                reportProxy2222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222);
                break;
            case 15:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION);
                Unit unit18 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222 = Unit.a;
                reportProxy22222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222);
                break;
            case 16:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "14");
                Unit unit19 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222 = Unit.a;
                reportProxy222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222);
                break;
            case LauncherLifecycleType.LAUNCHER_MINIAPP_START /* 17 */:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION);
                Unit unit20 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222 = Unit.a;
                reportProxy2222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222);
                break;
            case 18:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "16");
                Unit unit21 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222 = Unit.a;
                reportProxy22222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222);
                break;
            case 19:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "17");
                Unit unit22 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222 = Unit.a;
                reportProxy222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222);
                break;
            case 20:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "18");
                Unit unit23 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222 = Unit.a;
                reportProxy2222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222);
                break;
            case 21:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "19");
                Unit unit24 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222 = Unit.a;
                reportProxy22222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222);
                break;
            case 22:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "20");
                Unit unit25 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222 = Unit.a;
                reportProxy222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222);
                break;
            case 23:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", ChainPoint.ROUTE_PAGE);
                Unit unit26 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222);
                break;
            case 24:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "22");
                Unit unit27 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222);
                break;
            case 25:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "23");
                Unit unit28 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222);
                break;
            case 26:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "24");
                Unit unit29 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222);
                break;
            case 27:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "25");
                Unit unit30 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222);
                break;
            case 28:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "26");
                Unit unit31 = Unit.a;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222);
                break;
            case 29:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "2");
                bundle2.putString("status", "0");
                Unit unit32 = Unit.a;
                str29 = "miniapp_start";
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222);
                break;
            case 30:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "2");
                bundle2.putString("status", "3");
                Unit unit33 = Unit.a;
                str29 = "miniapp_start";
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222);
                break;
            case 31:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "100");
                bundle2.putString("status", "0");
                Unit unit34 = Unit.a;
                str29 = "miniapp_download";
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222);
                break;
            case 32:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "100");
                bundle2.putString("status", "2");
                Unit unit35 = Unit.a;
                str29 = "miniapp_download";
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222);
                break;
            case 33:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "100");
                bundle2.putString("status", "1");
                Unit unit36 = Unit.a;
                str29 = "miniapp_download";
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222);
                break;
            case 34:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "202");
                Unit unit37 = Unit.a;
                str29 = "miniapp_exposure";
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222);
                break;
            case 35:
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                bundle2.putString("object_id", "600");
                Unit unit38 = Unit.a;
                str6 = "miniapp_fps";
                str29 = str6;
                z = false;
                z2 = true;
                j = 0;
                j2 = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222);
                break;
            case 36:
                if (str2 != null) {
                    OooO00o(str2, bundle3);
                    Unit unit39 = Unit.a;
                    break;
                }
                break;
            case 37:
                if (str2 != null) {
                    try {
                        String string = bundle3.getString(ChainPoint.TYPE, "");
                        String string2 = bundle3.getString(ChainPoint.CHAIN_ID, "");
                        String string3 = bundle3.getString(ChainPoint.PAGE_PATH, "");
                        String string4 = bundle3.getString(ChainPoint.REPORT_PAGE_PATH, "");
                        TmcLogger.d("oldChain", "chainEnd -> msg:" + str2 + ", type:" + string + ", pagePath:" + string3 + ", reportPagePath:" + string4);
                        String str33 = TextUtils.isEmpty(string4) ? string3 : string4;
                        if (Intrinsics.c(OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP, string)) {
                            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O010 = this.OooO0Oo.get(string2);
                            if (oooO0O010 != null && (OooO0O06 = oooO0O010.OooO0O0()) != null && OooO0O06.containsKey(str2) && (oooO0O07 = this.OooO0Oo.get(string2)) != null && (OooO00o5 = oooO0O07.OooO00o()) != null) {
                                long currentTimeMillis4 = System.currentTimeMillis();
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O011 = this.OooO0Oo.get(string2);
                                OooO00o5.put(str2, Long.valueOf(currentTimeMillis4 - ((oooO0O011 == null || (OooO0O07 = oooO0O011.OooO0O0()) == null || (l3 = OooO0O07.get(str2)) == null) ? 0L : l3.longValue())));
                            }
                        } else if (Intrinsics.c("page", string)) {
                            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O012 = this.OooO0Oo.get(string2);
                            if (oooO0O012 != null && (OooOO02 = oooO0O012.OooOO0()) != null && (oooOO02 = OooOO02.get(string3)) != null && (OooO0O04 = oooOO02.OooO0O0()) != null && OooO0O04.containsKey(str2) && (oooO0O03 = this.OooO0Oo.get(string2)) != null && (OooOO03 = oooO0O03.OooOO0()) != null && (oooOO03 = OooOO03.get(string3)) != null && (OooO00o3 = oooOO03.OooO00o()) != null) {
                                long currentTimeMillis5 = System.currentTimeMillis();
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O013 = this.OooO0Oo.get(string2);
                                OooO00o3.put(str2, Long.valueOf(currentTimeMillis5 - ((oooO0O013 == null || (OooOO04 = oooO0O013.OooOO0()) == null || (oooOO04 = OooOO04.get(string3)) == null || (OooO0O05 = oooOO04.OooO0O0()) == null || (l2 = OooO0O05.get(str2)) == null) ? 0L : l2.longValue())));
                            }
                            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O014 = this.OooO0Oo.get(string2);
                            if (Intrinsics.c(string3, oooO0O014 != null ? oooO0O014.OooO0o() : null) && (oooO0O0 = this.OooO0Oo.get(string2)) != null && (OooO0O02 = oooO0O0.OooO0O0()) != null) {
                                z3 = true;
                                if (OooO0O02.containsKey(str2) && (oooO0O02 = this.OooO0Oo.get(string2)) != null && (OooO00o2 = oooO0O02.OooO00o()) != null) {
                                    long currentTimeMillis6 = System.currentTimeMillis();
                                    com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O015 = this.OooO0Oo.get(string2);
                                    OooO00o2.put(str2, Long.valueOf(currentTimeMillis6 - ((oooO0O015 == null || (OooOO0 = oooO0O015.OooOO0()) == null || (oooOO0 = OooOO0.get(string3)) == null || (OooO0O03 = oooOO0.OooO0O0()) == null || (l = OooO0O03.get(str2)) == null) ? 0L : l.longValue())));
                                }
                                if (Intrinsics.c(str2, ChainPoint.page)) {
                                    com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O016 = this.OooO0Oo.get(string2);
                                    if (!Intrinsics.c(string3, oooO0O016 != null ? oooO0O016.OooO0o() : null)) {
                                        Intrinsics.g(string2, "appId");
                                        Intrinsics.g(string3, FrameworkConstants.GLOBAL_DATA_KEY_PAGE_PATH);
                                        Intrinsics.g(str33, "reportPagePath");
                                        str3 = "";
                                        OooO00o(string2, string3, bundle3, str, str33);
                                        str4 = str;
                                        str5 = str2;
                                        bundle2 = bundle3;
                                        bundle2.remove(ChainPoint.TYPE);
                                        bundle2.remove(ChainPoint.CHAIN_ID);
                                        bundle2.remove(ChainPoint.PAGE_PATH);
                                        Unit unit40 = Unit.a;
                                        str6 = "miniapp_time";
                                        str29 = str6;
                                        z = false;
                                        z2 = true;
                                        j = 0;
                                        j2 = 0;
                                        str26 = str29;
                                        j4 = j2;
                                        if (str5 != null) {
                                        }
                                        if (j4 > j) {
                                        }
                                        if (j4 <= j) {
                                        }
                                        if (str4 == null) {
                                        }
                                        sb.append(des);
                                        sb.append((Object) str30);
                                        String sb222222222222222222222222222222222222 = sb.toString();
                                        ReportProxy reportProxy22222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                                        bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222);
                                        data = pointAnalyseType.getData();
                                        if (data != null) {
                                        }
                                        Unit unit422222222222222222222222222222222222 = Unit.a;
                                        reportProxy22222222222222222222222222222222222.report(str4, str26, bundle2);
                                        if (j4 != j) {
                                        }
                                        TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222, z);
                                        a.a(pointAnalyseType2, sb222222222222222222222222222222222222);
                                        break;
                                    }
                                }
                                str3 = "";
                                if (!Intrinsics.c(str2, ChainPoint.app)) {
                                    com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O017 = this.OooO0Oo.get(string2);
                                    if (Intrinsics.c(string3, oooO0O017 != null ? oooO0O017.OooO0o() : null)) {
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O018 = this.OooO0Oo.get(string2);
                                        if (oooO0O018 == null) {
                                            str7 = string3;
                                            bundle2 = bundle3;
                                            str5 = str2;
                                        } else if (oooO0O018.OooOOO()) {
                                            Intrinsics.g(string2, "appId");
                                            Intrinsics.g(string3, FrameworkConstants.GLOBAL_DATA_KEY_PAGE_PATH);
                                            Intrinsics.g(str33, "reportPagePath");
                                            bundle2 = bundle3;
                                            str5 = str2;
                                            OooO00o(string2, string3, bundle2, str, str33);
                                            str4 = str;
                                            bundle2.remove(ChainPoint.TYPE);
                                            bundle2.remove(ChainPoint.CHAIN_ID);
                                            bundle2.remove(ChainPoint.PAGE_PATH);
                                            Unit unit402 = Unit.a;
                                            str6 = "miniapp_time";
                                            str29 = str6;
                                            z = false;
                                            z2 = true;
                                            j = 0;
                                            j2 = 0;
                                            str26 = str29;
                                            j4 = j2;
                                            if (str5 != null) {
                                            }
                                            if (j4 > j) {
                                            }
                                            if (j4 <= j) {
                                            }
                                            if (str4 == null) {
                                            }
                                            sb.append(des);
                                            sb.append((Object) str30);
                                            String sb2222222222222222222222222222222222222 = sb.toString();
                                            ReportProxy reportProxy222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                                            bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222);
                                            data = pointAnalyseType.getData();
                                            if (data != null) {
                                            }
                                            Unit unit4222222222222222222222222222222222222 = Unit.a;
                                            reportProxy222222222222222222222222222222222222.report(str4, str26, bundle2);
                                            if (j4 != j) {
                                            }
                                            TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222, z);
                                            a.a(pointAnalyseType2, sb2222222222222222222222222222222222222);
                                        } else {
                                            str7 = string3;
                                            str5 = str2;
                                            bundle2 = bundle3;
                                        }
                                        TmcLogger.d("oldChain", "reportApp -> msg:" + str5 + ", type:" + string + ", pagePath:" + str7 + ", reportPagePath:" + str33);
                                        OooO00o(str);
                                        str4 = str;
                                        OooO00o(bundle2, str4);
                                        OooO00o();
                                        bundle2.putString("object_id", "300");
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O019 = this.OooO0Oo.get(string2);
                                        if (oooO0O019 == null || (OooO00o4 = oooO0O019.OooO00o()) == null) {
                                            str8 = str28;
                                        } else {
                                            for (Map.Entry<String, Long> entry2 : OooO00o4.entrySet()) {
                                                String key = entry2.getKey();
                                                StringBuilder sb3 = new StringBuilder();
                                                String str34 = str28;
                                                sb3.append(str34);
                                                sb3.append((Object) key);
                                                bundle2.putLong(sb3.toString(), entry2.getValue().longValue());
                                                str28 = str34;
                                            }
                                            str8 = str28;
                                            Unit unit41 = Unit.a;
                                        }
                                        bundle2.putString(PointConstants.POINT_PAGE_PATH, str33);
                                        if (str4 != null) {
                                            App findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str4);
                                            Object context = (findApp == null || (appContext = findApp.getAppContext()) == null) ? null : appContext.getContext();
                                            BaseActivity baseActivity = context instanceof BaseActivity ? (BaseActivity) context : null;
                                            bundle2.putString("isForeground", String.valueOf(baseActivity != null ? Boolean.valueOf(baseActivity.getMStarted()) : null));
                                            Unit unit43 = Unit.a;
                                        }
                                        bundle2.putString("app_launcher_status", "true");
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O020 = this.OooO0Oo.get(string2);
                                        if (oooO0O020 != null) {
                                            z4 = oooO0O020.OooO();
                                            str9 = LauncherMiniAppConfigHelper.KEY_OFF_SCREEN_RENDER;
                                        } else {
                                            str9 = LauncherMiniAppConfigHelper.KEY_OFF_SCREEN_RENDER;
                                            z4 = false;
                                        }
                                        bundle2.putBoolean(str9, z4);
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O021 = this.OooO0Oo.get(string2);
                                        if (oooO0O021 != null) {
                                            i = oooO0O021.OooO0Oo();
                                            str10 = "downloadFrameworkMode";
                                        } else {
                                            str10 = "downloadFrameworkMode";
                                            i = -1;
                                        }
                                        bundle2.putInt(str10, i);
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O022 = this.OooO0Oo.get(string2);
                                        if (oooO0O022 != null) {
                                            i2 = oooO0O022.OooO0OO();
                                            str11 = "downloadAppMode";
                                        } else {
                                            str11 = "downloadAppMode";
                                            i2 = -1;
                                        }
                                        bundle2.putInt(str11, i2);
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O023 = this.OooO0Oo.get(string2);
                                        if (oooO0O023 != null) {
                                            i3 = oooO0O023.OooOO0o();
                                            str12 = "zipFrameworkMode";
                                        } else {
                                            str12 = "zipFrameworkMode";
                                            i3 = -1;
                                        }
                                        bundle2.putInt(str12, i3);
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O024 = this.OooO0Oo.get(string2);
                                        bundle2.putInt("zipAppMode", oooO0O024 != null ? oooO0O024.OooOO0O() : -1);
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O025 = this.OooO0Oo.get(string2);
                                        if (oooO0O025 != null) {
                                            str13 = oooO0O025.OooO0o0();
                                            if (str13 == null) {
                                            }
                                            bundle2.putString("appH5ProgressStatus", str13);
                                            oooO0O04 = this.OooO0Oo.get(string2);
                                            if (oooO0O04 != null) {
                                                str14 = oooO0O04.OooOOO0();
                                                if (str14 != null) {
                                                }
                                                bundle2.putString("appDomContentLoadedStatus", str14);
                                                String str35 = str8 + ChainPoint.TotalCommunicationTime;
                                                ICommunicationTimeProxy iCommunicationTimeProxy = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
                                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O026 = this.OooO0Oo.get(string2);
                                                bundle2.putLong(str35, iCommunicationTimeProxy.getTotalTime((oooO0O026 != null || (OooOO07 = oooO0O026.OooOO0()) == null || (oooOO07 = OooOO07.get(str7)) == null) ? null : oooOO07.OooO0o0()));
                                                String str36 = str8 + ChainPoint.TotalCommunicationNum;
                                                ICommunicationTimeProxy iCommunicationTimeProxy2 = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
                                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O027 = this.OooO0Oo.get(string2);
                                                bundle2.putInt(str36, iCommunicationTimeProxy2.getTotalNum((oooO0O027 != null || (OooOO06 = oooO0O027.OooOO0()) == null || (oooOO06 = OooOO06.get(str7)) == null) ? null : oooOO06.OooO0o0()));
                                                oooO0O05 = this.OooO0Oo.get(string2);
                                                if (oooO0O05 != null && (OooOO05 = oooO0O05.OooOO0()) != null && (oooOO05 = OooOO05.get(str7)) != null) {
                                                    r40 = oooOO05.OooO0Oo();
                                                }
                                                bundle2.putString("navigationType", r40);
                                                oooO0O06 = this.OooO0Oo.get(string2);
                                                if (oooO0O06 != null) {
                                                    oooO0O06.OooO00o(true);
                                                }
                                                bundle2.remove(ChainPoint.TYPE);
                                                bundle2.remove(ChainPoint.CHAIN_ID);
                                                bundle2.remove(ChainPoint.PAGE_PATH);
                                                Unit unit4022 = Unit.a;
                                                str6 = "miniapp_time";
                                                str29 = str6;
                                                z = false;
                                                z2 = true;
                                                j = 0;
                                                j2 = 0;
                                                str26 = str29;
                                                j4 = j2;
                                                if (str5 != null) {
                                                }
                                                if (j4 > j) {
                                                }
                                                if (j4 <= j) {
                                                }
                                                if (str4 == null) {
                                                }
                                                sb.append(des);
                                                sb.append((Object) str30);
                                                String sb22222222222222222222222222222222222222 = sb.toString();
                                                ReportProxy reportProxy2222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                                                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222);
                                                data = pointAnalyseType.getData();
                                                if (data != null) {
                                                }
                                                Unit unit42222222222222222222222222222222222222 = Unit.a;
                                                reportProxy2222222222222222222222222222222222222.report(str4, str26, bundle2);
                                                if (j4 != j) {
                                                }
                                                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222, z);
                                                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222);
                                            }
                                            str14 = str3;
                                            bundle2.putString("appDomContentLoadedStatus", str14);
                                            String str352 = str8 + ChainPoint.TotalCommunicationTime;
                                            ICommunicationTimeProxy iCommunicationTimeProxy3 = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
                                            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0262 = this.OooO0Oo.get(string2);
                                            bundle2.putLong(str352, iCommunicationTimeProxy3.getTotalTime((oooO0O0262 != null || (OooOO07 = oooO0O0262.OooOO0()) == null || (oooOO07 = OooOO07.get(str7)) == null) ? null : oooOO07.OooO0o0()));
                                            String str362 = str8 + ChainPoint.TotalCommunicationNum;
                                            ICommunicationTimeProxy iCommunicationTimeProxy22 = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
                                            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0272 = this.OooO0Oo.get(string2);
                                            bundle2.putInt(str362, iCommunicationTimeProxy22.getTotalNum((oooO0O0272 != null || (OooOO06 = oooO0O0272.OooOO0()) == null || (oooOO06 = OooOO06.get(str7)) == null) ? null : oooOO06.OooO0o0()));
                                            oooO0O05 = this.OooO0Oo.get(string2);
                                            if (oooO0O05 != null) {
                                                r40 = oooOO05.OooO0Oo();
                                            }
                                            bundle2.putString("navigationType", r40);
                                            oooO0O06 = this.OooO0Oo.get(string2);
                                            if (oooO0O06 != null) {
                                            }
                                            bundle2.remove(ChainPoint.TYPE);
                                            bundle2.remove(ChainPoint.CHAIN_ID);
                                            bundle2.remove(ChainPoint.PAGE_PATH);
                                            Unit unit40222 = Unit.a;
                                            str6 = "miniapp_time";
                                            str29 = str6;
                                            z = false;
                                            z2 = true;
                                            j = 0;
                                            j2 = 0;
                                            str26 = str29;
                                            j4 = j2;
                                            if (str5 != null) {
                                            }
                                            if (j4 > j) {
                                            }
                                            if (j4 <= j) {
                                            }
                                            if (str4 == null) {
                                            }
                                            sb.append(des);
                                            sb.append((Object) str30);
                                            String sb222222222222222222222222222222222222222 = sb.toString();
                                            ReportProxy reportProxy22222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                                            bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222);
                                            data = pointAnalyseType.getData();
                                            if (data != null) {
                                            }
                                            Unit unit422222222222222222222222222222222222222 = Unit.a;
                                            reportProxy22222222222222222222222222222222222222.report(str4, str26, bundle2);
                                            if (j4 != j) {
                                            }
                                            TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222, z);
                                            a.a(pointAnalyseType2, sb222222222222222222222222222222222222222);
                                        }
                                        str13 = str3;
                                        bundle2.putString("appH5ProgressStatus", str13);
                                        oooO0O04 = this.OooO0Oo.get(string2);
                                        if (oooO0O04 != null) {
                                        }
                                        str14 = str3;
                                        bundle2.putString("appDomContentLoadedStatus", str14);
                                        String str3522 = str8 + ChainPoint.TotalCommunicationTime;
                                        ICommunicationTimeProxy iCommunicationTimeProxy32 = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O02622 = this.OooO0Oo.get(string2);
                                        bundle2.putLong(str3522, iCommunicationTimeProxy32.getTotalTime((oooO0O02622 != null || (OooOO07 = oooO0O02622.OooOO0()) == null || (oooOO07 = OooOO07.get(str7)) == null) ? null : oooOO07.OooO0o0()));
                                        String str3622 = str8 + ChainPoint.TotalCommunicationNum;
                                        ICommunicationTimeProxy iCommunicationTimeProxy222 = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O02722 = this.OooO0Oo.get(string2);
                                        bundle2.putInt(str3622, iCommunicationTimeProxy222.getTotalNum((oooO0O02722 != null || (OooOO06 = oooO0O02722.OooOO0()) == null || (oooOO06 = OooOO06.get(str7)) == null) ? null : oooOO06.OooO0o0()));
                                        oooO0O05 = this.OooO0Oo.get(string2);
                                        if (oooO0O05 != null) {
                                        }
                                        bundle2.putString("navigationType", r40);
                                        oooO0O06 = this.OooO0Oo.get(string2);
                                        if (oooO0O06 != null) {
                                        }
                                        bundle2.remove(ChainPoint.TYPE);
                                        bundle2.remove(ChainPoint.CHAIN_ID);
                                        bundle2.remove(ChainPoint.PAGE_PATH);
                                        Unit unit402222 = Unit.a;
                                        str6 = "miniapp_time";
                                        str29 = str6;
                                        z = false;
                                        z2 = true;
                                        j = 0;
                                        j2 = 0;
                                        str26 = str29;
                                        j4 = j2;
                                        if (str5 != null) {
                                        }
                                        if (j4 > j) {
                                        }
                                        if (j4 <= j) {
                                        }
                                        if (str4 == null) {
                                        }
                                        sb.append(des);
                                        sb.append((Object) str30);
                                        String sb2222222222222222222222222222222222222222 = sb.toString();
                                        ReportProxy reportProxy222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                                        bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222);
                                        data = pointAnalyseType.getData();
                                        if (data != null) {
                                        }
                                        Unit unit4222222222222222222222222222222222222222 = Unit.a;
                                        reportProxy222222222222222222222222222222222222222.report(str4, str26, bundle2);
                                        if (j4 != j) {
                                        }
                                        TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222, z);
                                        a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222);
                                    }
                                }
                            }
                        }
                        z3 = true;
                        if (Intrinsics.c(str2, ChainPoint.page)) {
                        }
                        str3 = "";
                        if (!Intrinsics.c(str2, ChainPoint.app)) {
                        }
                    } catch (Throwable unused) {
                        return;
                    }
                } else {
                    str4 = str;
                    str5 = str2;
                    bundle2 = bundle3;
                    str3 = "";
                    str26 = str3;
                    z = false;
                    z2 = true;
                    j = 0;
                    j4 = 0;
                    if (str5 != null) {
                    }
                    if (j4 > j) {
                    }
                    if (j4 <= j) {
                    }
                    if (str4 == null) {
                    }
                    sb.append(des);
                    sb.append((Object) str30);
                    String sb22222222222222222222222222222222222222222 = sb.toString();
                    ReportProxy reportProxy2222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                    bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222);
                    data = pointAnalyseType.getData();
                    if (data != null) {
                    }
                    Unit unit42222222222222222222222222222222222222222 = Unit.a;
                    reportProxy2222222222222222222222222222222222222222.report(str4, str26, bundle2);
                    if (j4 != j) {
                    }
                    TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222, z);
                    a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222);
                }
                break;
            case 38:
                OooO0O0(bundle3);
                Unit unit44 = Unit.a;
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                z = false;
                str3 = "";
                z2 = true;
                j = 0;
                j2 = j;
                str29 = str3;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222);
                break;
            case 39:
                if (str2 != null) {
                    try {
                        String string5 = bundle3.getString(ChainPoint.TYPE, "");
                        String string6 = bundle3.getString(ChainPoint.CHAIN_ID, "");
                        String string7 = bundle3.getString(ChainPoint.PAGE_PATH, "");
                        String string8 = bundle3.getString(ChainPoint.REPORT_PAGE_PATH, "");
                        TmcLogger.d("oldChain", "chainClear -> msg:" + str2 + ", type:" + string5 + ", pagePath:" + string7 + ", reportPagePath:" + string8);
                        if (TextUtils.isEmpty(string8)) {
                            string8 = string7;
                        }
                        if (Intrinsics.c(string5, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP)) {
                            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O028 = this.OooO0Oo.get(string6);
                            Map<String, Long> OooO0O08 = oooO0O028 != null ? oooO0O028.OooO0O0() : null;
                            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O029 = this.OooO0Oo.get(string6);
                            Map<String, Long> OooO00o6 = oooO0O029 != null ? oooO0O029.OooO00o() : null;
                            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O030 = this.OooO0Oo.get(string6);
                            String OooO0o2 = oooO0O030 != null ? oooO0O030.OooO0o() : null;
                            if (OooO0O08 != null && OooO0O08.containsKey(ChainPoint.app) && OooO00o6 != null && OooO00o6.containsKey(ChainPoint.app)) {
                                ICommunicationTimeProxy iCommunicationTimeProxy4 = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O031 = this.OooO0Oo.get(string6);
                                if (oooO0O031 != null && (OooOO017 = oooO0O031.OooOO0()) != null && (oooOO014 = OooOO017.get(OooO0o2)) != null) {
                                    r40 = oooOO014.OooO0o0();
                                }
                                iCommunicationTimeProxy4.clear(r40);
                                this.OooO0Oo.remove(string6);
                                break;
                            } else {
                                bundle3.putString("object_id", "203");
                                bundle3.putString(PointConstants.POINT_PAGE_PATH, string8);
                                bundle3.putString("app_launcher_status", "false");
                                try {
                                    bundle3.putString("app_launcher_fail_reason", new Gson().toJson(MapsKt.j(new Pair[]{TuplesKt.a("chainStartData", OooO0O08), TuplesKt.a("chainEndData", OooO00o6)})).toString());
                                } catch (Throwable unused2) {
                                }
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O032 = this.OooO0Oo.get(string6);
                                if (oooO0O032 != null) {
                                    i5 = oooO0O032.OooO0Oo();
                                    str20 = "downloadFrameworkMode";
                                } else {
                                    str20 = "downloadFrameworkMode";
                                    i5 = -1;
                                }
                                bundle3.putInt(str20, i5);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O033 = this.OooO0Oo.get(string6);
                                if (oooO0O033 != null) {
                                    i6 = oooO0O033.OooO0OO();
                                    str21 = "downloadAppMode";
                                } else {
                                    str21 = "downloadAppMode";
                                    i6 = -1;
                                }
                                bundle3.putInt(str21, i6);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O034 = this.OooO0Oo.get(string6);
                                if (oooO0O034 != null) {
                                    i7 = oooO0O034.OooOO0o();
                                    str22 = "zipFrameworkMode";
                                } else {
                                    str22 = "zipFrameworkMode";
                                    i7 = -1;
                                }
                                bundle3.putInt(str22, i7);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O035 = this.OooO0Oo.get(string6);
                                bundle3.putInt("zipAppMode", oooO0O035 != null ? oooO0O035.OooOO0O() : -1);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O036 = this.OooO0Oo.get(string6);
                                if (oooO0O036 != null && (r0 = oooO0O036.OooO0o0()) != null) {
                                    str23 = "appH5ProgressStatus";
                                    bundle3.putString(str23, r0);
                                    oooO0O08 = this.OooO0Oo.get(string6);
                                    if (oooO0O08 != null && (r0 = oooO0O08.OooOOO0()) != null) {
                                        str24 = "appDomContentLoadedStatus";
                                        bundle3.putString(str24, r0);
                                        oooO0O09 = this.OooO0Oo.get(string6);
                                        if (oooO0O09 == null) {
                                            z6 = oooO0O09.OooO();
                                            str25 = LauncherMiniAppConfigHelper.KEY_OFF_SCREEN_RENDER;
                                        } else {
                                            str25 = LauncherMiniAppConfigHelper.KEY_OFF_SCREEN_RENDER;
                                            z6 = false;
                                        }
                                        bundle3.putBoolean(str25, z6);
                                        if (!bundle3.containsKey(TmcConstants.KEY_PAGE_RANDOM_ID)) {
                                            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O037 = this.OooO0Oo.get(string6);
                                            bundle3.putString(TmcConstants.KEY_PAGE_RANDOM_ID, oooO0O037 != null ? oooO0O037.OooO0oO() : null);
                                        }
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O038 = this.OooO0Oo.get(string6);
                                        bundle3.putString("navigationType", oooO0O038 != null ? oooO0O038.OooO0oo() : null);
                                        this.OooO0Oo.remove(string6);
                                    }
                                    str24 = "appDomContentLoadedStatus";
                                    String str37 = "";
                                    bundle3.putString(str24, str37);
                                    oooO0O09 = this.OooO0Oo.get(string6);
                                    if (oooO0O09 == null) {
                                    }
                                    bundle3.putBoolean(str25, z6);
                                    if (!bundle3.containsKey(TmcConstants.KEY_PAGE_RANDOM_ID)) {
                                    }
                                    com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0382 = this.OooO0Oo.get(string6);
                                    bundle3.putString("navigationType", oooO0O0382 != null ? oooO0O0382.OooO0oo() : null);
                                    this.OooO0Oo.remove(string6);
                                }
                                str23 = "appH5ProgressStatus";
                                String str38 = "";
                                bundle3.putString(str23, str38);
                                oooO0O08 = this.OooO0Oo.get(string6);
                                if (oooO0O08 != null) {
                                    str24 = "appDomContentLoadedStatus";
                                    bundle3.putString(str24, str37);
                                    oooO0O09 = this.OooO0Oo.get(string6);
                                    if (oooO0O09 == null) {
                                    }
                                    bundle3.putBoolean(str25, z6);
                                    if (!bundle3.containsKey(TmcConstants.KEY_PAGE_RANDOM_ID)) {
                                    }
                                    com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O03822 = this.OooO0Oo.get(string6);
                                    bundle3.putString("navigationType", oooO0O03822 != null ? oooO0O03822.OooO0oo() : null);
                                    this.OooO0Oo.remove(string6);
                                }
                                str24 = "appDomContentLoadedStatus";
                                String str372 = "";
                                bundle3.putString(str24, str372);
                                oooO0O09 = this.OooO0Oo.get(string6);
                                if (oooO0O09 == null) {
                                }
                                bundle3.putBoolean(str25, z6);
                                if (!bundle3.containsKey(TmcConstants.KEY_PAGE_RANDOM_ID)) {
                                }
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O038222 = this.OooO0Oo.get(string6);
                                bundle3.putString("navigationType", oooO0O038222 != null ? oooO0O038222.OooO0oo() : null);
                                this.OooO0Oo.remove(string6);
                            }
                        } else if (Intrinsics.c(string5, "page")) {
                            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O039 = this.OooO0Oo.get(string6);
                            if (!Intrinsics.c(string7, oooO0O039 != null ? oooO0O039.OooO0o() : null)) {
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O040 = this.OooO0Oo.get(string6);
                                Map<String, Long> OooO0O09 = (oooO0O040 == null || (OooOO015 = oooO0O040.OooOO0()) == null || (oooOO013 = OooOO015.get(string7)) == null) ? null : oooOO013.OooO0O0();
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O041 = this.OooO0Oo.get(string6);
                                Map<String, Long> OooO00o7 = (oooO0O041 == null || (OooOO014 = oooO0O041.OooOO0()) == null || (oooOO012 = OooOO014.get(string7)) == null) ? null : oooOO012.OooO00o();
                                if (OooO0O09 != null) {
                                    str16 = "zipAppMode";
                                    str15 = "zipFrameworkMode";
                                    if (OooO0O09.containsKey(ChainPoint.page) && OooO00o7 != null && OooO00o7.containsKey(ChainPoint.page)) {
                                        ICommunicationTimeProxy iCommunicationTimeProxy5 = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O042 = this.OooO0Oo.get(string6);
                                        if (oooO0O042 != null && (OooOO013 = oooO0O042.OooOO0()) != null && (oooOO011 = OooOO013.get(string7)) != null) {
                                            r40 = oooOO011.OooO0o0();
                                        }
                                        iCommunicationTimeProxy5.clear(r40);
                                        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O043 = this.OooO0Oo.get(string6);
                                        if (oooO0O043 != null && (OooOO012 = oooO0O043.OooOO0()) != null) {
                                            OooOO012.remove(string7);
                                            break;
                                        }
                                    }
                                } else {
                                    str15 = "zipFrameworkMode";
                                    str16 = "zipAppMode";
                                }
                                bundle3.putString("object_id", "204");
                                bundle3.putString(PointConstants.POINT_PAGE_PATH, string8);
                                bundle3.putString("open_page_status", "false");
                                try {
                                    Gson gson = new Gson();
                                    Pair a = TuplesKt.a("chainStartData", OooO0O09);
                                    Pair a2 = TuplesKt.a("chainEndData", OooO00o7);
                                    Pair[] pairArr = new Pair[2];
                                    z5 = false;
                                    try {
                                        pairArr[0] = a;
                                        pairArr[1] = a2;
                                        bundle3.putString("open_page_fail_reason", gson.toJson(MapsKt.j(pairArr)).toString());
                                    } catch (Throwable unused3) {
                                    }
                                } catch (Throwable unused4) {
                                    z5 = false;
                                }
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O044 = this.OooO0Oo.get(string6);
                                bundle3.putInt("downloadFrameworkMode", oooO0O044 != null ? oooO0O044.OooO0Oo() : -1);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O045 = this.OooO0Oo.get(string6);
                                if (oooO0O045 == null || (OooOO011 = oooO0O045.OooOO0()) == null || (oooOO010 = OooOO011.get(string7)) == null || (str17 = oooOO010.OooO0OO()) == null) {
                                    str17 = "";
                                }
                                bundle3.putString("pageH5ProgressStatus", str17);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O046 = this.OooO0Oo.get(string6);
                                if (oooO0O046 == null || (OooOO010 = oooO0O046.OooOO0()) == null || (oooOO09 = OooOO010.get(string7)) == null || (str18 = oooOO09.OooO0o()) == null) {
                                    str18 = "";
                                }
                                bundle3.putString("pageDomContentLoadedStatus", str18);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O047 = this.OooO0Oo.get(string6);
                                bundle3.putInt("downloadAppMode", oooO0O047 != null ? oooO0O047.OooO0OO() : -1);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O048 = this.OooO0Oo.get(string6);
                                if (oooO0O048 != null) {
                                    i4 = oooO0O048.OooOO0o();
                                    str19 = str15;
                                } else {
                                    str19 = str15;
                                    i4 = -1;
                                }
                                bundle3.putInt(str19, i4);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O049 = this.OooO0Oo.get(string6);
                                bundle3.putInt(str16, oooO0O049 != null ? oooO0O049.OooOO0O() : -1);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O050 = this.OooO0Oo.get(string6);
                                if (oooO0O050 != null && (OooOO09 = oooO0O050.OooOO0()) != null && (oooOO08 = OooOO09.get(string7)) != null) {
                                    r40 = oooOO08.OooO0Oo();
                                }
                                bundle3.putString("navigationType", r40);
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O051 = this.OooO0Oo.get(string6);
                                if (oooO0O051 != null && (OooOO08 = oooO0O051.OooOO0()) != null) {
                                    OooOO08.remove(string7);
                                }
                                bundle3.remove(ChainPoint.TYPE);
                                bundle3.remove(ChainPoint.CHAIN_ID);
                                bundle3.remove(ChainPoint.PAGE_PATH);
                                Unit unit45 = Unit.a;
                                str4 = str;
                                str5 = str2;
                                bundle2 = bundle3;
                                z = z5;
                                str29 = "miniapp_exposure";
                                str3 = "";
                                z2 = true;
                                j = 0;
                                j2 = 0;
                                str26 = str29;
                                j4 = j2;
                                if (str5 != null) {
                                }
                                if (j4 > j) {
                                }
                                if (j4 <= j) {
                                }
                                if (str4 == null) {
                                }
                                sb.append(des);
                                sb.append((Object) str30);
                                String sb2222222222222222222222222222222222222222222 = sb.toString();
                                ReportProxy reportProxy222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222);
                                data = pointAnalyseType.getData();
                                if (data != null) {
                                }
                                Unit unit4222222222222222222222222222222222222222222 = Unit.a;
                                reportProxy222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                                if (j4 != j) {
                                }
                                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222, z);
                                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222);
                                break;
                            } else {
                                com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O052 = this.OooO0Oo.get(string6);
                                if (oooO0O052 != null && (OooOO016 = oooO0O052.OooOO0()) != null) {
                                    OooOO016.remove(string7);
                                    break;
                                }
                            }
                        }
                        z5 = false;
                        bundle3.remove(ChainPoint.TYPE);
                        bundle3.remove(ChainPoint.CHAIN_ID);
                        bundle3.remove(ChainPoint.PAGE_PATH);
                        Unit unit452 = Unit.a;
                        str4 = str;
                        str5 = str2;
                        bundle2 = bundle3;
                        z = z5;
                        str29 = "miniapp_exposure";
                        str3 = "";
                        z2 = true;
                        j = 0;
                        j2 = 0;
                        str26 = str29;
                        j4 = j2;
                        if (str5 != null) {
                        }
                        if (j4 > j) {
                        }
                        if (j4 <= j) {
                        }
                        if (str4 == null) {
                        }
                        sb.append(des);
                        sb.append((Object) str30);
                        String sb22222222222222222222222222222222222222222222 = sb.toString();
                        ReportProxy reportProxy2222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                        bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222);
                        data = pointAnalyseType.getData();
                        if (data != null) {
                        }
                        Unit unit42222222222222222222222222222222222222222222 = Unit.a;
                        reportProxy2222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                        if (j4 != j) {
                        }
                        TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222, z);
                        a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222);
                    } catch (Throwable unused5) {
                        return;
                    }
                } else {
                    str4 = str;
                    str5 = str2;
                    str3 = "";
                    bundle2 = bundle3;
                    str26 = "miniapp_exposure";
                    z = false;
                    z2 = true;
                    j = 0;
                    j4 = 0;
                    if (str5 != null) {
                    }
                    if (j4 > j) {
                    }
                    if (j4 <= j) {
                    }
                    if (str4 == null) {
                    }
                    sb.append(des);
                    sb.append((Object) str30);
                    String sb222222222222222222222222222222222222222222222 = sb.toString();
                    ReportProxy reportProxy22222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                    bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222);
                    data = pointAnalyseType.getData();
                    if (data != null) {
                    }
                    Unit unit422222222222222222222222222222222222222222222 = Unit.a;
                    reportProxy22222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                    if (j4 != j) {
                    }
                    TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222, z);
                    a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222);
                }
                break;
            case 40:
                OooO00o(bundle3);
                Unit unit46 = Unit.a;
                str27 = "mini_h5_onPageFinished";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222);
                break;
            case 41:
                Unit unit47 = Unit.a;
                str27 = "miniapp_log_e";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222);
                break;
            case 42:
                bundle3.putString("gaId", DeviceUtil.getGAId());
                Unit unit48 = Unit.a;
                str27 = "privacy_policy_click";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222);
                break;
            case 43:
                Unit unit49 = Unit.a;
                str27 = "miniapp_get_package_file";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222);
                break;
            case 44:
                bundle3.putString("object_id", "901");
                Unit unit50 = Unit.a;
                str3 = "";
                str4 = str;
                str5 = str2;
                str29 = "miniapp_package_update";
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222);
                break;
            case 45:
                bundle3.putString("object_id", "902");
                Unit unit51 = Unit.a;
                str3 = "";
                str4 = str;
                str5 = str2;
                str29 = "miniapp_package_update";
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222);
                break;
            case 46:
                bundle3.putString("object_id", "903");
                Unit unit52 = Unit.a;
                str3 = "";
                str4 = str;
                str5 = str2;
                str29 = "miniapp_package_update";
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222);
                break;
            case 47:
                bundle3.putString("object_id", "904");
                Unit unit53 = Unit.a;
                str3 = "";
                str4 = str;
                str5 = str2;
                str29 = "miniapp_package_update";
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222);
                break;
            case 48:
                bundle3.putString("object_id", "905");
                Unit unit54 = Unit.a;
                str3 = "";
                str4 = str;
                str5 = str2;
                str29 = "miniapp_package_update";
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222);
                break;
            case 49:
                bundle3.putString("object_id", "906");
                Unit unit55 = Unit.a;
                str3 = "";
                str4 = str;
                str5 = str2;
                str29 = "miniapp_package_update";
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222);
                break;
            case 50:
                bundle3.putString("object_id", "907");
                Unit unit56 = Unit.a;
                str3 = "";
                str4 = str;
                str5 = str2;
                str29 = "miniapp_package_update";
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222);
                break;
            case 51:
                if (str2 != null) {
                    if (!com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO00o.OooO0O0(str2, str, bundle3)) {
                        Unit unit57 = Unit.a;
                        str3 = "";
                        str4 = str;
                        str5 = str2;
                        z = false;
                        z2 = true;
                        bundle2 = bundle3;
                        j = 0;
                        j2 = j;
                        str29 = str3;
                        str26 = str29;
                        j4 = j2;
                        if (str5 != null) {
                        }
                        if (j4 > j) {
                        }
                        if (j4 <= j) {
                        }
                        if (str4 == null) {
                        }
                        sb.append(des);
                        sb.append((Object) str30);
                        String sb222222222222222222222222222222222222222222222222222222222 = sb.toString();
                        ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                        bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222);
                        data = pointAnalyseType.getData();
                        if (data != null) {
                        }
                        Unit unit422222222222222222222222222222222222222222222222222222222 = Unit.a;
                        reportProxy22222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                        if (j4 != j) {
                        }
                        TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222, z);
                        a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222);
                        break;
                    }
                }
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                str26 = str3;
                z = false;
                z2 = true;
                j = 0;
                j4 = 0;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222);
                break;
            case 52:
                if (str2 != null) {
                    if (!com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO00o.OooO00o(str2, str, bundle3)) {
                        Unit unit58 = Unit.a;
                        str3 = "";
                        str4 = str;
                        str5 = str2;
                        z = false;
                        z2 = true;
                        bundle2 = bundle3;
                        j = 0;
                        j2 = j;
                        str29 = str3;
                        str26 = str29;
                        j4 = j2;
                        if (str5 != null) {
                        }
                        if (j4 > j) {
                        }
                        if (j4 <= j) {
                        }
                        if (str4 == null) {
                        }
                        sb.append(des);
                        sb.append((Object) str30);
                        String sb22222222222222222222222222222222222222222222222222222222222 = sb.toString();
                        ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                        bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222);
                        data = pointAnalyseType.getData();
                        if (data != null) {
                        }
                        Unit unit42222222222222222222222222222222222222222222222222222222222 = Unit.a;
                        reportProxy2222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                        if (j4 != j) {
                        }
                        TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222, z);
                        a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222);
                        break;
                    }
                }
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                str26 = str3;
                z = false;
                z2 = true;
                j = 0;
                j4 = 0;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222);
                break;
            case 53:
                if (str2 != null) {
                    if (!com.cloud.tmc.miniapp.performanceanalyse.page.OooO0O0.OooO00o.OooO0O0(str2, str, bundle3)) {
                        Unit unit59 = Unit.a;
                        str3 = "";
                        str4 = str;
                        str5 = str2;
                        z = false;
                        z2 = true;
                        bundle2 = bundle3;
                        j = 0;
                        j2 = j;
                        str29 = str3;
                        str26 = str29;
                        j4 = j2;
                        if (str5 != null) {
                        }
                        if (j4 > j) {
                        }
                        if (j4 <= j) {
                        }
                        if (str4 == null) {
                        }
                        sb.append(des);
                        sb.append((Object) str30);
                        String sb2222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                        ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                        bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222);
                        data = pointAnalyseType.getData();
                        if (data != null) {
                        }
                        Unit unit4222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                        reportProxy222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                        if (j4 != j) {
                        }
                        TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222, z);
                        a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222);
                        break;
                    }
                }
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                str26 = str3;
                z = false;
                z2 = true;
                j = 0;
                j4 = 0;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222);
                break;
            case 54:
                if (str2 != null) {
                    if (!com.cloud.tmc.miniapp.performanceanalyse.page.OooO0O0.OooO00o.OooO00o(str2, str, bundle3)) {
                        Unit unit60 = Unit.a;
                        str3 = "";
                        str4 = str;
                        str5 = str2;
                        z = false;
                        z2 = true;
                        bundle2 = bundle3;
                        j = 0;
                        j2 = j;
                        str29 = str3;
                        str26 = str29;
                        j4 = j2;
                        if (str5 != null) {
                        }
                        if (j4 > j) {
                        }
                        if (j4 <= j) {
                        }
                        if (str4 == null) {
                        }
                        sb.append(des);
                        sb.append((Object) str30);
                        String sb222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                        ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                        bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222);
                        data = pointAnalyseType.getData();
                        if (data != null) {
                        }
                        Unit unit422222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                        reportProxy22222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                        if (j4 != j) {
                        }
                        TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222, z);
                        a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222);
                        break;
                    }
                }
                str3 = "";
                str4 = str;
                str5 = str2;
                bundle2 = bundle3;
                str26 = str3;
                z = false;
                z2 = true;
                j = 0;
                j4 = 0;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 55:
                if (!com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO00o.OooO0O0(str, bundle3)) {
                    Unit unit61 = Unit.a;
                    str3 = "";
                    str4 = str;
                    str5 = str2;
                    z = false;
                    z2 = true;
                    bundle2 = bundle3;
                    j = 0;
                    j2 = j;
                    str29 = str3;
                    str26 = str29;
                    j4 = j2;
                    if (str5 != null) {
                    }
                    if (j4 > j) {
                    }
                    if (j4 <= j) {
                    }
                    if (str4 == null) {
                    }
                    sb.append(des);
                    sb.append((Object) str30);
                    String sb22222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                    ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                    bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222);
                    data = pointAnalyseType.getData();
                    if (data != null) {
                    }
                    Unit unit42222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                    reportProxy2222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                    if (j4 != j) {
                    }
                    TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222, z);
                    a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222);
                    break;
                }
                break;
            case 56:
                if (!com.cloud.tmc.miniapp.performanceanalyse.page.OooO0O0.OooO00o.OooO0O0(str, bundle3)) {
                    Unit unit62 = Unit.a;
                    str3 = "";
                    str4 = str;
                    str5 = str2;
                    z = false;
                    z2 = true;
                    bundle2 = bundle3;
                    j = 0;
                    j2 = j;
                    str29 = str3;
                    str26 = str29;
                    j4 = j2;
                    if (str5 != null) {
                    }
                    if (j4 > j) {
                    }
                    if (j4 <= j) {
                    }
                    if (str4 == null) {
                    }
                    sb.append(des);
                    sb.append((Object) str30);
                    String sb222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                    ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                    bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222);
                    data = pointAnalyseType.getData();
                    if (data != null) {
                    }
                    Unit unit422222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                    reportProxy22222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                    if (j4 != j) {
                    }
                    TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222, z);
                    a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222);
                    break;
                }
                break;
            case 57:
                if (!com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO00o.OooO0OO(str, bundle3)) {
                    Unit unit63 = Unit.a;
                    str3 = "";
                    str4 = str;
                    str5 = str2;
                    z = false;
                    z2 = true;
                    bundle2 = bundle3;
                    j = 0;
                    j2 = j;
                    str29 = str3;
                    str26 = str29;
                    j4 = j2;
                    if (str5 != null) {
                    }
                    if (j4 > j) {
                    }
                    if (j4 <= j) {
                    }
                    if (str4 == null) {
                    }
                    sb.append(des);
                    sb.append((Object) str30);
                    String sb2222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                    ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                    bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222222);
                    data = pointAnalyseType.getData();
                    if (data != null) {
                    }
                    Unit unit4222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                    reportProxy222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                    if (j4 != j) {
                    }
                    TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222222, z);
                    a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222222);
                    break;
                }
                break;
            case 58:
                if (!com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO00o.OooO00o(str, bundle3)) {
                    Unit unit64 = Unit.a;
                    str3 = "";
                    str4 = str;
                    str5 = str2;
                    z = false;
                    z2 = true;
                    bundle2 = bundle3;
                    j = 0;
                    j2 = j;
                    str29 = str3;
                    str26 = str29;
                    j4 = j2;
                    if (str5 != null) {
                    }
                    if (j4 > j) {
                    }
                    if (j4 <= j) {
                    }
                    if (str4 == null) {
                    }
                    sb.append(des);
                    sb.append((Object) str30);
                    String sb22222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                    ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                    bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222222);
                    data = pointAnalyseType.getData();
                    if (data != null) {
                    }
                    Unit unit42222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                    reportProxy2222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                    if (j4 != j) {
                    }
                    TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222222, z);
                    a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222222);
                    break;
                }
                break;
            case 59:
                if (!com.cloud.tmc.miniapp.performanceanalyse.page.OooO0O0.OooO00o.OooO00o(str, bundle3)) {
                    Unit unit65 = Unit.a;
                    str3 = "";
                    str4 = str;
                    str5 = str2;
                    z = false;
                    z2 = true;
                    bundle2 = bundle3;
                    j = 0;
                    j2 = j;
                    str29 = str3;
                    str26 = str29;
                    j4 = j2;
                    if (str5 != null) {
                    }
                    if (j4 > j) {
                    }
                    if (j4 <= j) {
                    }
                    if (str4 == null) {
                    }
                    sb.append(des);
                    sb.append((Object) str30);
                    String sb222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                    ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                    bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222222);
                    data = pointAnalyseType.getData();
                    if (data != null) {
                    }
                    Unit unit422222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                    reportProxy22222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                    if (j4 != j) {
                    }
                    TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222222, z);
                    a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222222);
                    break;
                }
                break;
            case 60:
                Unit unit66 = Unit.a;
                str27 = "miniapp_foreground_time";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 61:
                Unit unit67 = Unit.a;
                str27 = "miniapp_get_odid";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 62:
                Unit unit68 = Unit.a;
                str27 = "miniapp_hot_open";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 63:
                Unit unit69 = Unit.a;
                str27 = "mini_open_page_action";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 64:
                Unit unit70 = Unit.a;
                str27 = "Pinforlater_ex";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 65:
                Unit unit71 = Unit.a;
                str27 = "Pinforlater_click";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 66:
                Unit unit72 = Unit.a;
                str27 = "later_banner_ex";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 67:
                Unit unit73 = Unit.a;
                str27 = "later_banner_click";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 68:
                Unit unit74 = Unit.a;
                str27 = "later_addmc_click";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 69:
                Unit unit75 = Unit.a;
                str27 = "later_addmc_ex";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 70:
                Unit unit76 = Unit.a;
                str27 = "privacy_ex";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 71:
                Unit unit77 = Unit.a;
                str27 = "privacy_click";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 72:
                Unit unit78 = Unit.a;
                str27 = "addMiniAppToDesktop";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 73:
                Unit unit79 = Unit.a;
                str27 = "preRequestHtml";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 74:
                Unit unit80 = Unit.a;
                str27 = "preRequestHtmlRet";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 75:
                Unit unit81 = Unit.a;
                str27 = "getPreHtml";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 76:
                Unit unit82 = Unit.a;
                str27 = "getPreHtmlHit";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 77:
                bundle3.putString("object_id", "27");
                Unit unit83 = Unit.a;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 78:
                Unit unit84 = Unit.a;
                str27 = "preStrategyFail";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 79:
                Unit unit85 = Unit.a;
                str27 = "later_offline_ex";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 80:
                Unit unit86 = Unit.a;
                str27 = "later_offline_app_ex";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case TmcConstants.NOTIFY_ADDHOME_GUIDE_TOP_SHOW /* 81 */:
                Unit unit87 = Unit.a;
                str27 = "later_offline_click";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW /* 82 */:
                Unit unit88 = Unit.a;
                str27 = "get-add-ex";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case TmcConstants.NOTIFY_ADDHOME_GUIDE_BACK_SHOW /* 83 */:
                Unit unit89 = Unit.a;
                str27 = "get-toast-add-ex";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 84:
                Unit unit90 = Unit.a;
                str27 = "get-add-click";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit4222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            case 85:
                Unit unit91 = Unit.a;
                str27 = "get-add-noshow";
                str29 = str27;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                j2 = 0;
                bundle2 = bundle3;
                j = 0;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit42222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
            default:
                Unit unit92 = Unit.a;
                str3 = "";
                str4 = str;
                str5 = str2;
                z = false;
                z2 = true;
                bundle2 = bundle3;
                j = 0;
                j2 = j;
                str29 = str3;
                str26 = str29;
                j4 = j2;
                if (str5 != null) {
                }
                if (j4 > j) {
                }
                if (j4 <= j) {
                }
                if (str4 == null) {
                }
                sb.append(des);
                sb.append((Object) str30);
                String sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = sb.toString();
                ReportProxy reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = (ReportProxy) TmcProxy.get(ReportProxy.class);
                bundle2.putString(PointAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + pointAnalyseType.name(), sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                data = pointAnalyseType.getData();
                if (data != null) {
                }
                Unit unit422222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = Unit.a;
                reportProxy22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.report(str4, str26, bundle2);
                if (j4 != j) {
                }
                TraceLog.d(TmcConstants.PERFERENCE_ANALYSE_TAG, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222, z);
                a.a(pointAnalyseType2, sb222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222);
                break;
        }
    }

    public final void OooO00o(String str, String str2, Bundle bundle, String str3, String str4) {
        String str5;
        Map<String, OooOO0> map;
        OooOO0 oooOO0;
        Map<String, OooOO0> map2;
        OooOO0 oooOO02;
        Map<String, OooOO0> map3;
        OooOO0 oooOO03;
        Map<String, OooOO0> map4;
        OooOO0 oooOO04;
        String str6;
        Map<String, OooOO0> map5;
        OooOO0 oooOO05;
        AppContext appContext;
        Map<String, OooOO0> map6;
        OooOO0 oooOO06;
        Map<String, Long> map7;
        TmcLogger.d("oldChain", "reportPage -> appId:" + str + ", pagePath:" + str2 + ", miniappId:" + str3 + ", reportPagePath:" + str4);
        try {
            OooO00o(str3);
            OooO00o(bundle, str3);
            try {
                com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o.OooO00o();
            } catch (Throwable th) {
                TmcLogger.e("PointTrack", "tryInitAthena failed!", th);
            }
            bundle.putString("object_id", "300");
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0 = this.OooO0Oo.get(str);
            if (oooO0O0 != null && (map6 = oooO0O0.OooO0o0) != null && (oooOO06 = map6.get(str2)) != null && (map7 = oooOO06.OooO0Oo) != null) {
                for (Map.Entry<String, Long> entry : map7.entrySet()) {
                    bundle.putLong("chain_id_" + ((Object) entry.getKey()), entry.getValue().longValue());
                }
            }
            bundle.putString(PointConstants.POINT_PAGE_PATH, str4);
            bundle.putString("open_page_status", "true");
            String str7 = null;
            if (str3 != null) {
                App findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str3);
                Object context = (findApp == null || (appContext = findApp.getAppContext()) == null) ? null : appContext.getContext();
                BaseActivity baseActivity = context instanceof BaseActivity ? (BaseActivity) context : null;
                bundle.putString("isForeground", String.valueOf(baseActivity != null ? Boolean.valueOf(baseActivity.getMStarted()) : null));
            }
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O02 = this.OooO0Oo.get(str);
            bundle.putInt("downloadFrameworkMode", oooO0O02 != null ? oooO0O02.OooO0o : -1);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O03 = this.OooO0Oo.get(str);
            String str8 = "";
            if (oooO0O03 == null || (map5 = oooO0O03.OooO0o0) == null || (oooOO05 = map5.get(str2)) == null || (str5 = oooOO05.OooO0o0) == null) {
                str5 = "";
            }
            bundle.putString("pageH5ProgressStatus", str5);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O04 = this.OooO0Oo.get(str);
            if (oooO0O04 != null && (map4 = oooO0O04.OooO0o0) != null && (oooOO04 = map4.get(str2)) != null && (str6 = oooOO04.OooO0o) != null) {
                str8 = str6;
            }
            bundle.putString("pageDomContentLoadedStatus", str8);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O05 = this.OooO0Oo.get(str);
            bundle.putInt("downloadAppMode", oooO0O05 != null ? oooO0O05.OooO0oO : -1);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O06 = this.OooO0Oo.get(str);
            bundle.putInt("zipFrameworkMode", oooO0O06 != null ? oooO0O06.OooO0oo : -1);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O07 = this.OooO0Oo.get(str);
            bundle.putInt("zipAppMode", oooO0O07 != null ? oooO0O07.OooO : -1);
            String str9 = "chain_id_" + ChainPoint.TotalCommunicationTime;
            ICommunicationTimeProxy iCommunicationTimeProxy = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O08 = this.OooO0Oo.get(str);
            bundle.putLong(str9, iCommunicationTimeProxy.getTotalTime((oooO0O08 == null || (map3 = oooO0O08.OooO0o0) == null || (oooOO03 = map3.get(str2)) == null) ? null : oooOO03.OooO0O0));
            String str10 = "chain_id_" + ChainPoint.TotalCommunicationNum;
            ICommunicationTimeProxy iCommunicationTimeProxy2 = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O09 = this.OooO0Oo.get(str);
            bundle.putInt(str10, iCommunicationTimeProxy2.getTotalNum((oooO0O09 == null || (map2 = oooO0O09.OooO0o0) == null || (oooOO02 = map2.get(str2)) == null) ? null : oooOO02.OooO0O0));
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O010 = this.OooO0Oo.get(str);
            if (oooO0O010 != null && (map = oooO0O010.OooO0o0) != null && (oooOO0 = map.get(str2)) != null) {
                str7 = oooOO0.OooO0oO;
            }
            bundle.putString("navigationType", str7);
        } catch (Throwable unused) {
        }
    }

    public final void OooO0O0(Bundle bundle) {
        Map<String, OooOO0> map;
        OooOO0 oooOO0;
        try {
            String string = bundle.getString(ChainPoint.TYPE, "");
            String string2 = bundle.getString(ChainPoint.CHAIN_ID, "");
            if (this.OooO0Oo.containsKey(string2)) {
                if (Intrinsics.c(OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP, string)) {
                    com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0 = this.OooO0Oo.get(string2);
                    if (oooO0O0 != null) {
                        if (bundle.containsKey(ChainPoint.DOWNLOAD_FRAMEWORK_MODE)) {
                            oooO0O0.OooO0o = bundle.getInt(ChainPoint.DOWNLOAD_FRAMEWORK_MODE, 0);
                        } else if (bundle.containsKey(ChainPoint.DOWNLOAD_APP_MODE)) {
                            oooO0O0.OooO0oO = bundle.getInt(ChainPoint.DOWNLOAD_APP_MODE, 0);
                        } else if (bundle.containsKey(ChainPoint.ZIP_FRAMEWORK_MODE)) {
                            oooO0O0.OooO0oo = bundle.getInt(ChainPoint.ZIP_FRAMEWORK_MODE, 0);
                        } else if (bundle.containsKey(ChainPoint.ZIP_APP_MODE)) {
                            oooO0O0.OooO = bundle.getInt(ChainPoint.ZIP_APP_MODE, 0);
                        } else if (bundle.containsKey(ChainPoint.APP_H5_PROGRESS_STATUS)) {
                            String string3 = bundle.getString(ChainPoint.APP_H5_PROGRESS_STATUS, "");
                            Intrinsics.g(string3, "bundle.getString(APP_H5_PROGRESS_STATUS, \"\")");
                            Intrinsics.h(string3, "<set-?>");
                            oooO0O0.OooOO0O = string3;
                        } else if (bundle.containsKey(ChainPoint.APP_DOMCONTENTLOADED_STATUS)) {
                            String string4 = bundle.getString(ChainPoint.APP_DOMCONTENTLOADED_STATUS, "");
                            Intrinsics.g(string4, "bundle.getString(APP_DOMCONTENTLOADED_STATUS, \"\")");
                            Intrinsics.h(string4, "<set-?>");
                            oooO0O0.OooOO0o = string4;
                        } else if (bundle.containsKey(ChainPoint.APP_OFF_SCREEN_RENDER)) {
                            oooO0O0.OooOOOO = bundle.getBoolean(ChainPoint.APP_OFF_SCREEN_RENDER, false);
                        }
                    }
                } else if (Intrinsics.c("page", string)) {
                    String string5 = bundle.getString(ChainPoint.PAGE_PATH, "");
                    com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O02 = this.OooO0Oo.get(string2);
                    if (oooO0O02 != null && (map = oooO0O02.OooO0o0) != null && (oooOO0 = map.get(string5)) != null) {
                        if (bundle.containsKey(ChainPoint.PAGE_H5_PROGRESS_STATUS)) {
                            String string6 = bundle.getString(ChainPoint.PAGE_H5_PROGRESS_STATUS, "");
                            Intrinsics.g(string6, "bundle.getString(PAGE_H5_PROGRESS_STATUS, \"\")");
                            Intrinsics.h(string6, "<set-?>");
                            oooOO0.OooO0o0 = string6;
                        } else if (bundle.containsKey(ChainPoint.PAGE_DOMCONTENTLOADED_STATUS)) {
                            String string7 = bundle.getString(ChainPoint.PAGE_DOMCONTENTLOADED_STATUS, "");
                            Intrinsics.g(string7, "bundle.getString(PAGE_DOMCONTENTLOADED_STATUS, \"\")");
                            Intrinsics.h(string7, "<set-?>");
                            oooOO0.OooO0o = string7;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            TmcLogger.e("chainInsert fail:" + th);
        }
    }
}
