package com.cloud.tmc.miniapp.ad;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.ad.IAdManagerProxy;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.ad.bean.AdStyleBean;
import com.cloud.tmc.ad.bean.response.AdsDTO;
import com.cloud.tmc.ad.interface.AdEventListener;
import com.cloud.tmc.ad.interface.AdFillingEventListener;
import com.cloud.tmc.ad.interface.AdShowEventListener;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.AdxPreferencesHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.NewTaskManager;
import com.cloud.tmc.miniapp.ad.interstitial.AdBaseDialog;
import com.cloud.tmc.miniapp.ad.interstitial.AdInterstitialHtmlView$Builder;
import com.cloud.tmc.miniapp.ad.interstitial.AdInterstitialJsonAllStyleView$Builder;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class AdManager implements IAdManagerProxy {
    public static final OooO0O0 Companion = new OooO0O0();
    public static final String TAG = "AdManager";
    public final ConcurrentHashMap<String, OooO00o> OooO00o = new ConcurrentHashMap<>();
    public String OooO0O0;
    public Long OooO0OO;

    public static final class OooO00o {
        public String OooO00o;
        public final ConcurrentHashMap<String, AdBaseDialog> OooO0O0;
        public final ConcurrentHashMap<String, AdBaseDialog> OooO0OO;
        public final ConcurrentHashMap<String, AdEventListener> OooO0Oo;
        public final ConcurrentHashMap<String, AdShowEventListener> OooO0o;
        public final ConcurrentHashMap<String, AdFillingEventListener> OooO0o0;
        public final ConcurrentLinkedQueue<String> OooO0oO;

        public OooO00o() {
            this(null, null, null, null, null, null, null, 127);
        }

        public OooO00o(String str, ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap, ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap2, ConcurrentHashMap<String, AdEventListener> concurrentHashMap3, ConcurrentHashMap<String, AdFillingEventListener> concurrentHashMap4, ConcurrentHashMap<String, AdShowEventListener> concurrentHashMap5, ConcurrentLinkedQueue<String> concurrentLinkedQueue) {
            Intrinsics.h(concurrentHashMap, "htmlContextMap");
            Intrinsics.h(concurrentHashMap2, "allStyleContextMap");
            Intrinsics.h(concurrentHashMap3, "adEventlistenerMap");
            Intrinsics.h(concurrentHashMap4, "adFillingEventlistenerMap");
            Intrinsics.h(concurrentHashMap5, "adShowEventListenerMap");
            Intrinsics.h(concurrentLinkedQueue, "adShowList");
            this.OooO00o = str;
            this.OooO0O0 = concurrentHashMap;
            this.OooO0OO = concurrentHashMap2;
            this.OooO0Oo = concurrentHashMap3;
            this.OooO0o0 = concurrentHashMap4;
            this.OooO0o = concurrentHashMap5;
            this.OooO0oO = concurrentLinkedQueue;
        }

        public /* synthetic */ OooO00o(String str, ConcurrentHashMap concurrentHashMap, ConcurrentHashMap concurrentHashMap2, ConcurrentHashMap concurrentHashMap3, ConcurrentHashMap concurrentHashMap4, ConcurrentHashMap concurrentHashMap5, ConcurrentLinkedQueue concurrentLinkedQueue, int i) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new ConcurrentHashMap() : null, (i & 4) != 0 ? new ConcurrentHashMap() : null, (i & 8) != 0 ? new ConcurrentHashMap() : null, (i & 16) != 0 ? new ConcurrentHashMap() : null, (i & 32) != 0 ? new ConcurrentHashMap() : null, (i & 64) != 0 ? new ConcurrentLinkedQueue() : null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OooO00o)) {
                return false;
            }
            OooO00o oooO00o = (OooO00o) obj;
            return Intrinsics.c(this.OooO00o, oooO00o.OooO00o) && Intrinsics.c(this.OooO0O0, oooO00o.OooO0O0) && Intrinsics.c(this.OooO0OO, oooO00o.OooO0OO) && Intrinsics.c(this.OooO0Oo, oooO00o.OooO0Oo) && Intrinsics.c(this.OooO0o0, oooO00o.OooO0o0) && Intrinsics.c(this.OooO0o, oooO00o.OooO0o) && Intrinsics.c(this.OooO0oO, oooO00o.OooO0oO);
        }

        public int hashCode() {
            String str = this.OooO00o;
            return this.OooO0oO.hashCode() + ((this.OooO0o.hashCode() + ((this.OooO0o0.hashCode() + ((this.OooO0Oo.hashCode() + ((this.OooO0OO.hashCode() + ((this.OooO0O0.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            return "AppAdData(appId=" + this.OooO00o + ", htmlContextMap=" + this.OooO0O0 + ", allStyleContextMap=" + this.OooO0OO + ", adEventlistenerMap=" + this.OooO0Oo + ", adFillingEventlistenerMap=" + this.OooO0o0 + ", adShowEventListenerMap=" + this.OooO0o + ", adShowList=" + this.OooO0oO + ")";
        }
    }

    public static final class OooO0O0 {
    }

    public final void OooO00o(String str, AdsDTO adsDTO, String str2, String str3, App app, AdStyleBean adStyleBean, AdEventListener adEventListener) {
        Context context;
        ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap;
        ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap2;
        AdBaseDialog adBaseDialog;
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            OooO00o(str, app, "系统异常");
            return;
        }
        if (TextUtils.isEmpty(str2) || !new File(str2).exists() || (str3 != null && !TextUtils.isEmpty(str3) && !new File(str3).exists())) {
            OooO00o(str, app, "广告图片不存在");
            return;
        }
        OooO00o oooO00o = this.OooO00o.get(app.getAppId());
        if (oooO00o == null || (concurrentHashMap2 = oooO00o.OooO0OO) == null || (adBaseDialog = concurrentHashMap2.get(str)) == null || !adBaseDialog.isShowing()) {
            AdInterstitialJsonAllStyleView$Builder adInterstitialJsonAllStyleView$Builder = new AdInterstitialJsonAllStyleView$Builder(context, str, str2, str3, adsDTO.getNativeObject().getTitleTxt(), adsDTO.getNativeObject().getDescriptionTxt(), adsDTO.getNativeObject().getButtonText(), adStyleBean, adEventListener);
            OooO00o oooO00o2 = this.OooO00o.get(app.getAppId());
            if (oooO00o2 == null || (concurrentHashMap = oooO00o2.OooO0OO) == null) {
                return;
            }
            concurrentHashMap.put(str, adInterstitialJsonAllStyleView$Builder);
        }
    }

    public final void OooO00o(String str, App app) {
        ConcurrentHashMap<String, AdEventListener> concurrentHashMap;
        ConcurrentLinkedQueue<String> concurrentLinkedQueue;
        ConcurrentHashMap<String, AdShowEventListener> concurrentHashMap2;
        ConcurrentHashMap<String, AdFillingEventListener> concurrentHashMap3;
        ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap4;
        ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap5;
        OooO00o oooO00o = this.OooO00o.get(app.getAppId());
        if (oooO00o != null && (concurrentHashMap5 = oooO00o.OooO0O0) != null && concurrentHashMap5.containsKey(str)) {
            AdBaseDialog adBaseDialog = oooO00o.OooO0O0.get(str);
            AdInterstitialHtmlView$Builder adInterstitialHtmlView$Builder = adBaseDialog instanceof AdInterstitialHtmlView$Builder ? (AdInterstitialHtmlView$Builder) adBaseDialog : null;
            if (adInterstitialHtmlView$Builder != null) {
                adInterstitialHtmlView$Builder.OooO0Oo();
            }
            oooO00o.OooO0O0.remove(str);
        }
        if (oooO00o != null && (concurrentHashMap4 = oooO00o.OooO0OO) != null && concurrentHashMap4.containsKey(str)) {
            AdBaseDialog adBaseDialog2 = oooO00o.OooO0OO.get(str);
            AdInterstitialJsonAllStyleView$Builder adInterstitialJsonAllStyleView$Builder = adBaseDialog2 instanceof AdInterstitialJsonAllStyleView$Builder ? (AdInterstitialJsonAllStyleView$Builder) adBaseDialog2 : null;
            if (adInterstitialJsonAllStyleView$Builder != null) {
                adInterstitialJsonAllStyleView$Builder.OooO0oo = null;
            }
            oooO00o.OooO0OO.remove(str);
        }
        if (oooO00o != null && (concurrentHashMap3 = oooO00o.OooO0o0) != null && concurrentHashMap3.containsKey(str)) {
            oooO00o.OooO0o0.remove(str);
        }
        if (oooO00o != null && (concurrentHashMap2 = oooO00o.OooO0o) != null && concurrentHashMap2.containsKey(str)) {
            oooO00o.OooO0o.remove(str);
        }
        if (oooO00o != null && (concurrentLinkedQueue = oooO00o.OooO0oO) != null) {
            concurrentLinkedQueue.remove(str);
        }
        if (oooO00o == null || (concurrentHashMap = oooO00o.OooO0Oo) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        oooO00o.OooO0Oo.remove(str);
    }

    public final void OooO00o(String str, App app, String str2) {
        ConcurrentHashMap<String, AdFillingEventListener> concurrentHashMap;
        AdFillingEventListener adFillingEventListener;
        TmcLogger.e(TAG, "fillingInterstitialFail -> errMsg: " + str2);
        OooO00o oooO00o = this.OooO00o.get(app.getAppId());
        if (oooO00o != null && (concurrentHashMap = oooO00o.OooO0o0) != null && (adFillingEventListener = concurrentHashMap.get(str)) != null) {
            adFillingEventListener.fillingResult(str, false);
        }
        OooO00o(str, app);
    }

    public final void OooO0O0(String str, App app, String str2) {
        ConcurrentHashMap<String, AdShowEventListener> concurrentHashMap;
        AdShowEventListener adShowEventListener;
        TmcLogger.e(TAG, "showInterstitialFail -> errMsg: " + str2);
        OooO00o oooO00o = this.OooO00o.get(app.getAppId());
        if (oooO00o != null && (concurrentHashMap = oooO00o.OooO0o) != null && (adShowEventListener = concurrentHashMap.get(str)) != null) {
            adShowEventListener.showResult(str, false, new AdShowBean(0, 0, 0L, 0, 0L, (String) null, 0, 0, false, 511, (DefaultConstructorMarker) null));
        }
        OooO00o(str, app);
    }

    public void applicationDestroy() {
        Iterator<Map.Entry<String, OooO00o>> it = this.OooO00o.entrySet().iterator();
        while (it.hasNext()) {
            String str = it.next().getValue().OooO00o;
            if (str != null) {
                onDestroy(str);
            }
        }
    }

    public void close(String str, App app) {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue;
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        OooO00o oooO00o = this.OooO00o.get(app.getAppId());
        if (oooO00o == null || (concurrentLinkedQueue = oooO00o.OooO0oO) == null || !concurrentLinkedQueue.contains(str)) {
            TmcLogger.e(TAG, "广告关闭失败 -> 未曝光triggerId: " + str);
            return;
        }
        if (oooO00o.OooO0O0.containsKey(str)) {
            AdBaseDialog adBaseDialog = oooO00o.OooO0O0.get(str);
            if (adBaseDialog != null) {
                adBaseDialog.OooO0o0 = true;
                adBaseDialog.dismiss();
                return;
            } else {
                TmcLogger.e(TAG, "广告关闭失败 -> html形式实例不存在triggerId: " + str);
                return;
            }
        }
        if (oooO00o.OooO0OO.containsKey(str)) {
            AdBaseDialog adBaseDialog2 = oooO00o.OooO0OO.get(str);
            if (adBaseDialog2 != null) {
                adBaseDialog2.OooO0o0 = true;
                adBaseDialog2.dismiss();
            } else {
                TmcLogger.e(TAG, "广告关闭失败 -> json形式实例不存在triggerId: " + str);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public void fillingInterstitial(String str, AdsDTO adsDTO, String str2, String str3, App app, AdFillingEventListener adFillingEventListener) {
        OooO00o oooO00o;
        ConcurrentHashMap<String, AdFillingEventListener> concurrentHashMap;
        OooO00o oooO00o2;
        ConcurrentHashMap<String, AdEventListener> concurrentHashMap2;
        Context context;
        ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap3;
        ConcurrentHashMap<String, AdEventListener> concurrentHashMap4;
        ConcurrentHashMap<String, AdEventListener> concurrentHashMap5;
        ConcurrentHashMap<String, AdFillingEventListener> concurrentHashMap6;
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(adsDTO, "adsDTO");
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(adFillingEventListener, "listener");
        OooO00o oooO00o3 = this.OooO00o.get(app.getAppId());
        if ((oooO00o3 == null || (concurrentHashMap6 = oooO00o3.OooO0o0) == null || !concurrentHashMap6.containsKey(str)) && (oooO00o = this.OooO00o.get(app.getAppId())) != null && (concurrentHashMap = oooO00o.OooO0o0) != null) {
            concurrentHashMap.put(str, adFillingEventListener);
        }
        OooO00o oooO00o4 = this.OooO00o.get(app.getAppId());
        if ((oooO00o4 == null || (concurrentHashMap5 = oooO00o4.OooO0Oo) == null || !concurrentHashMap5.containsKey(str)) && (oooO00o2 = this.OooO00o.get(app.getAppId())) != null && (concurrentHashMap2 = oooO00o2.OooO0Oo) != null) {
            concurrentHashMap2.put(str, new com.cloud.tmc.miniapp.ad.OooO00o(this, app));
        }
        OooO00o oooO00o5 = this.OooO00o.get(app.getAppId());
        AdEventListener adEventListener = (oooO00o5 == null || (concurrentHashMap4 = oooO00o5.OooO0Oo) == null) ? null : concurrentHashMap4.get(str);
        if (!this.OooO00o.containsKey(app.getAppId())) {
            OooO00o(str, app, "请先初始化");
            return;
        }
        Integer codeSeatType = adsDTO.getCodeSeatType();
        if (codeSeatType == null || codeSeatType.intValue() != 3) {
            OooO00o(str, app, "非插屏类型");
            return;
        }
        String str4 = !TextUtils.isEmpty(adsDTO.getAdm()) ? "fromTypeHtml" : "fromTypeJson";
        AppContext appContext = app.getAppContext();
        if (appContext == null || appContext.getContext() == null) {
            return;
        }
        if (Intrinsics.c(str4, "fromTypeHtml")) {
            if (TextUtils.isEmpty(adsDTO.getAdm())) {
                OooO00o(str, app, "adm内容不能为空");
                return;
            }
            if (adsDTO.getScales() == null || adsDTO.getScales().size() == 0) {
                OooO00o(str, app, "代码为比例不能为空");
                return;
            }
            AppContext appContext2 = app.getAppContext();
            if (appContext2 == null || (context = appContext2.getContext()) == null) {
                OooO00o(str, app, "系统异常");
                return;
            }
            String adm = adsDTO.getAdm();
            Intrinsics.g(adm, "adsDTO.adm");
            Object obj = adsDTO.getScales().get(0);
            Intrinsics.g(obj, "adsDTO.scales[0]");
            AdInterstitialHtmlView$Builder adInterstitialHtmlView$Builder = new AdInterstitialHtmlView$Builder(context, str, adm, (String) obj, adEventListener);
            OooO00o oooO00o6 = this.OooO00o.get(app.getAppId());
            if (oooO00o6 == null || (concurrentHashMap3 = oooO00o6.OooO0O0) == null) {
                return;
            }
            concurrentHashMap3.put(str, adInterstitialHtmlView$Builder);
            return;
        }
        if (!Intrinsics.c(str4, "fromTypeJson")) {
            TmcLogger.e(TAG, "填充 -> triggerId: " + str + ", 不存在的广告形式");
            return;
        }
        if (str2 == null) {
            OooO00o(str, app, "广告图片不存在");
            return;
        }
        String materialStyle = adsDTO.getMaterialStyle();
        if (materialStyle != null) {
            switch (materialStyle.hashCode()) {
                case 2149406:
                    if (materialStyle.equals("FA14")) {
                        OooO00o(str, adsDTO, str2, str3, app, new AdStyleBean(true, true, true, true), adEventListener);
                        return;
                    }
                    break;
                case 68925418:
                    if (materialStyle.equals("I1101")) {
                        OooO00o(str, adsDTO, str2, str3, app, new AdStyleBean(true, true, true, true), adEventListener);
                        return;
                    }
                    break;
                case 68925419:
                    if (materialStyle.equals("I1102")) {
                        OooO00o(str, adsDTO, str2, str3, app, new AdStyleBean(true, false, true, true), adEventListener);
                        return;
                    }
                    break;
                case 68925420:
                    if (materialStyle.equals("I1103")) {
                        OooO00o(str, adsDTO, str2, str3, app, new AdStyleBean(true, true, false, true), adEventListener);
                        return;
                    }
                    break;
                case 68925423:
                    if (materialStyle.equals("I1106")) {
                        OooO00o(str, adsDTO, str2, str3, app, new AdStyleBean(true, true, false, true), adEventListener);
                        return;
                    }
                    break;
                case 68925424:
                    if (materialStyle.equals("I1107")) {
                        OooO00o(str, adsDTO, str2, str3, app, new AdStyleBean(false, false, false, false), adEventListener);
                        return;
                    }
                    break;
            }
        }
        OooO00o(str, app, "非adm materialStyle 不符合");
    }

    public String getAdSdkFrameworkVersion() {
        if (this.OooO0O0 == null) {
            this.OooO0O0 = AdxPreferencesHelper.INSTANCE.getInstance().i("ad_sdk_version");
        }
        String str = this.OooO0O0;
        return str == null ? "" : str;
    }

    public long getAdSdkFrameworkVersionInt() {
        if (this.OooO0OO == null) {
            this.OooO0OO = Long.valueOf(AdxPreferencesHelper.INSTANCE.getInstance().g("ad_sdk_version_int"));
        }
        Long l = this.OooO0OO;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public void onCreate(App app) {
        String str;
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        List<String> existAppIds = NewTaskManager.Companion.getInstance().getExistAppIds();
        for (Map.Entry<String, OooO00o> entry : this.OooO00o.entrySet()) {
            if (!existAppIds.contains(entry.getKey()) && (str = entry.getValue().OooO00o) != null) {
                onDestroy(str);
            }
        }
        if (TextUtils.isEmpty(app.getAppId()) || this.OooO00o.containsKey(app.getAppId())) {
            return;
        }
        ConcurrentHashMap<String, OooO00o> concurrentHashMap = this.OooO00o;
        String appId = app.getAppId();
        Intrinsics.g(appId, "app.appId");
        concurrentHashMap.put(appId, new OooO00o(app.getAppId(), null, null, null, null, null, null, 126));
    }

    public void onDestroy(String str) {
        OooO00o oooO00o;
        if (str == null || (oooO00o = this.OooO00o.get(str)) == null) {
            return;
        }
        Iterator<Map.Entry<String, AdBaseDialog>> it = oooO00o.OooO0O0.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdBaseDialog value = it.next().getValue();
            AdInterstitialHtmlView$Builder adInterstitialHtmlView$Builder = value instanceof AdInterstitialHtmlView$Builder ? (AdInterstitialHtmlView$Builder) value : null;
            if (adInterstitialHtmlView$Builder != null) {
                adInterstitialHtmlView$Builder.OooO0Oo();
            }
            it.remove();
        }
        Iterator<Map.Entry<String, AdBaseDialog>> it2 = oooO00o.OooO0OO.entrySet().iterator();
        while (it2.hasNext()) {
            AdBaseDialog value2 = it2.next().getValue();
            AdInterstitialJsonAllStyleView$Builder adInterstitialJsonAllStyleView$Builder = value2 instanceof AdInterstitialJsonAllStyleView$Builder ? (AdInterstitialJsonAllStyleView$Builder) value2 : null;
            if (adInterstitialJsonAllStyleView$Builder != null) {
                adInterstitialJsonAllStyleView$Builder.OooO0oo = null;
            }
            it2.remove();
        }
        oooO00o.OooO0o0.clear();
        oooO00o.OooO0o.clear();
        oooO00o.OooO0oO.clear();
        oooO00o.OooO0Oo.clear();
    }

    public void showInterstitial(String str, App app, AdsDTO adsDTO, AdShowEventListener adShowEventListener) {
        OooO00o oooO00o;
        ConcurrentHashMap<String, AdShowEventListener> concurrentHashMap;
        ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap2;
        ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap3;
        OooO00o oooO00o2;
        ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap4;
        ConcurrentHashMap<String, AdBaseDialog> concurrentHashMap5;
        ConcurrentHashMap<String, AdShowEventListener> concurrentHashMap6;
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(app, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(adsDTO, "adsDTO");
        Intrinsics.h(adShowEventListener, "listener");
        OooO00o oooO00o3 = this.OooO00o.get(app.getAppId());
        if ((oooO00o3 == null || (concurrentHashMap6 = oooO00o3.OooO0o) == null || !concurrentHashMap6.containsKey(str)) && (oooO00o = this.OooO00o.get(app.getAppId())) != null && (concurrentHashMap = oooO00o.OooO0o) != null) {
            concurrentHashMap.put(str, adShowEventListener);
        }
        AdBaseDialog adBaseDialog = null;
        if (!TextUtils.isEmpty(adsDTO.getAdm()) && (oooO00o2 = this.OooO00o.get(app.getAppId())) != null && (concurrentHashMap4 = oooO00o2.OooO0O0) != null && concurrentHashMap4.containsKey(str)) {
            OooO00o oooO00o4 = this.OooO00o.get(app.getAppId());
            if (oooO00o4 != null && (concurrentHashMap5 = oooO00o4.OooO0O0) != null) {
                adBaseDialog = concurrentHashMap5.get(str);
            }
            if (adBaseDialog != null) {
                adBaseDialog.show();
                return;
            } else {
                OooO0O0(str, app, "html广告填充实例为null");
                return;
            }
        }
        OooO00o oooO00o5 = this.OooO00o.get(app.getAppId());
        if (oooO00o5 == null || (concurrentHashMap2 = oooO00o5.OooO0OO) == null || !concurrentHashMap2.containsKey(str)) {
            OooO0O0(str, app, "不存在广告形式");
            return;
        }
        OooO00o oooO00o6 = this.OooO00o.get(app.getAppId());
        if (oooO00o6 != null && (concurrentHashMap3 = oooO00o6.OooO0OO) != null) {
            adBaseDialog = concurrentHashMap3.get(str);
        }
        if (adBaseDialog != null) {
            adBaseDialog.show();
        } else {
            OooO0O0(str, app, "json广告填充实例为null");
        }
    }
}
