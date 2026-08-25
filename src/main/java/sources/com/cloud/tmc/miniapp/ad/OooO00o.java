package com.cloud.tmc.miniapp.ad;

import com.cloud.tmc.ad.bean.AdClickBean;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.ad.interface.AdEventListener;
import com.cloud.tmc.ad.interface.AdFillingEventListener;
import com.cloud.tmc.ad.interface.AdShowEventListener;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.miniapp.ad.AdManager;
import com.cloud.tmc.miniapp.ad.interstitial.AdBaseDialog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o implements AdEventListener {
    public final /* synthetic */ AdManager OooO00o;
    public final /* synthetic */ App OooO0O0;

    public OooO00o(AdManager adManager, App app) {
        this.OooO00o = adManager;
        this.OooO0O0 = app;
    }

    public void click(String str, DownUpPointBean downUpPointBean, String str2) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap<String, AdShowEventListener> concurrentHashMap2;
        AdShowEventListener adShowEventListener;
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(downUpPointBean, "pointBean");
        concurrentHashMap = this.OooO00o.OooO00o;
        AdManager.OooO00o oooO00o = (AdManager.OooO00o) concurrentHashMap.get(this.OooO0O0.getAppId());
        if (oooO00o == null || (concurrentHashMap2 = oooO00o.OooO0o) == null || (adShowEventListener = concurrentHashMap2.get(str)) == null) {
            return;
        }
        adShowEventListener.click(str, downUpPointBean, str2);
    }

    public void clickHomePage(String str) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap<String, AdShowEventListener> concurrentHashMap2;
        AdShowEventListener adShowEventListener;
        Intrinsics.h(str, "triggerId");
        AdEventListener.DefaultImpls.clickHomePage(this, str);
        concurrentHashMap = this.OooO00o.OooO00o;
        AdManager.OooO00o oooO00o = (AdManager.OooO00o) concurrentHashMap.get(this.OooO0O0.getAppId());
        if (oooO00o == null || (concurrentHashMap2 = oooO00o.OooO0o) == null || (adShowEventListener = concurrentHashMap2.get(str)) == null) {
            return;
        }
        adShowEventListener.clickHomePage(str);
    }

    public void clickPersonalization(String str) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap<String, AdShowEventListener> concurrentHashMap2;
        AdShowEventListener adShowEventListener;
        Intrinsics.h(str, "triggerId");
        AdEventListener.DefaultImpls.clickPersonalization(this, str);
        concurrentHashMap = this.OooO00o.OooO00o;
        AdManager.OooO00o oooO00o = (AdManager.OooO00o) concurrentHashMap.get(this.OooO0O0.getAppId());
        if (oooO00o == null || (concurrentHashMap2 = oooO00o.OooO0o) == null || (adShowEventListener = concurrentHashMap2.get(str)) == null) {
            return;
        }
        adShowEventListener.clickPersonalization(str);
    }

    public void closeAd(String str, AdClickBean adClickBean) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap<String, AdShowEventListener> concurrentHashMap2;
        AdShowEventListener adShowEventListener;
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(adClickBean, "adClickBean");
        concurrentHashMap = this.OooO00o.OooO00o;
        AdManager.OooO00o oooO00o = (AdManager.OooO00o) concurrentHashMap.get(this.OooO0O0.getAppId());
        if (oooO00o == null || (concurrentHashMap2 = oooO00o.OooO0o) == null || (adShowEventListener = concurrentHashMap2.get(str)) == null) {
            return;
        }
        adShowEventListener.closeAd(str, adClickBean);
    }

    public void fillingResult(String str, boolean z) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap<String, AdFillingEventListener> concurrentHashMap3;
        ConcurrentHashMap<String, AdFillingEventListener> concurrentHashMap4;
        AdFillingEventListener adFillingEventListener;
        Intrinsics.h(str, "triggerId");
        if (!z) {
            this.OooO00o.OooO00o(str, this.OooO0O0, "");
            return;
        }
        concurrentHashMap = this.OooO00o.OooO00o;
        AdManager.OooO00o oooO00o = (AdManager.OooO00o) concurrentHashMap.get(this.OooO0O0.getAppId());
        if (oooO00o != null && (concurrentHashMap4 = oooO00o.OooO0o0) != null && (adFillingEventListener = concurrentHashMap4.get(str)) != null) {
            adFillingEventListener.fillingResult(str, true);
        }
        concurrentHashMap2 = this.OooO00o.OooO00o;
        AdManager.OooO00o oooO00o2 = (AdManager.OooO00o) concurrentHashMap2.get(this.OooO0O0.getAppId());
        if (oooO00o2 == null || (concurrentHashMap3 = oooO00o2.OooO0o0) == null) {
            return;
        }
        concurrentHashMap3.remove(str);
    }

    public void showResult(String str, boolean z, AdShowBean adShowBean) {
        ConcurrentHashMap concurrentHashMap;
        AdBaseDialog adBaseDialog;
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(adShowBean, "adShowBean");
        if (!z) {
            this.OooO00o.OooO0O0(str, this.OooO0O0, "");
            return;
        }
        concurrentHashMap = this.OooO00o.OooO00o;
        AdManager.OooO00o oooO00o = (AdManager.OooO00o) concurrentHashMap.get(this.OooO0O0.getAppId());
        if (oooO00o != null) {
            AdManager adManager = this.OooO00o;
            App app = this.OooO0O0;
            oooO00o.OooO0oO.add(str);
            AdShowEventListener adShowEventListener = oooO00o.OooO0o.get(str);
            if (adShowEventListener != null) {
                adShowEventListener.showResult(str, true, adShowBean);
            }
            AdBaseDialog adBaseDialog2 = oooO00o.OooO0O0.get(str);
            if (((adBaseDialog2 == null || !adBaseDialog2.OooO0o0) && ((adBaseDialog = oooO00o.OooO0OO.get(str)) == null || !adBaseDialog.OooO0o0)) || adShowBean.getShowReportTimeType() != 3) {
                return;
            }
            adManager.OooO00o(str, app);
        }
    }
}
