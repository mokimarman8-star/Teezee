package com.transsion.ad.strategy;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.d;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.MBAd;
import com.transsion.ad.R;
import com.transsion.ad.db.pslink.AppInstalledBean;
import com.transsion.ad.db.pslink.AttributionPoint;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.ps.attribution.AttributionProduceManager;
import com.transsion.ad.ps.installed.AppInstallManager;
import com.transsion.ad.ps.model.PSAdTypeEnum;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.ad.strategy.AdOverridePendingTransitionManager;
import com.transsion.ad.web.AdWebActivity;
import com.transsion.ad.web.cct.CustomTabsHelper;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();
    private static final List b = new ArrayList();
    private static final String c = "{\n            \"adSource\": \"ps_candidate\",\n            \"buttonText\": \"Go\",\n            \"categoryCode\": \"1896ff1657b2408daeb264ba6d370bf2\",\n            \"categoryName\": \"Finance\",\n            \"detail\": {\n                \"downloadCount\": \"27073080\",\n                \"iconUrl\": \"https://cdn2.palmplaystore.com/static/59/42d6df6edbe84bdd926fab309aa48261-V02222_512~512.webp?blurhash=LVRpFBkB%5E%23j%5BbHjaoLfQ%7ESa%7C9Jjt\",\n                \"img0\": \"https://cdn2.palmplaystore.com/static/889/0a4a8ed888f04551bcef55e4d31187ff-V02222_288~512.webp?blurhash=LWC%5D6r0f%2BYRO*JkWXos.5q%3FGNGXn\",\n                \"img1\": \"https://cdn2.palmplaystore.com/static/881/b88eab70ee8e445a836225f7fd7c7180-V02222_288~512.webp?blurhash=LqHM4j%7EpXnRj4oI%5Bxtx%5DNeM%7BShae\",\n                \"img2\": \"https://cdn2.palmplaystore.com/static/791/41db2f5cea9549f584c0bae3a7b1b1c9-V02222_288~512.webp?blurhash=LQFj%24.WU4mS7*woHMcRll.tQR%3BR-\",\n                \"img3\": \"https://cdn2.palmplaystore.com/static/181/e99237f24ede40f4a9fd56a08a1c30a5-V02222_288~512.webp?blurhash=LE9ums%7D5Uu9b4p9IPBxZm%25kryDvd\",\n                \"img4\": \"https://cdn2.palmplaystore.com/static/574/2bddbb51c7874e7a906ceb55a75b9124-V02222_288~512.webp?blurhash=LVGTa6n301RP3ERP_3n%23PXo%7DxBW%3D\",\n                \"isOffer\": 1,\n                \"itemID\": \"s_b7801ad36c0a0e4c7fc1f1e72bb04b2d\",\n                \"lan\": \"EN\",\n                \"name\": \"Moniepoint Personal Banking\",\n                \"packageName\": \"com.moniepoint.personal\",\n                \"safeTagList\": [\n                    {\n                        \"icon\": \"https://cdn2.palmplaystore.com/static/673/fa007ff1d5c14939b7d52a5d87247b5f.webp\",\n                        \"id\": 100033,\n                        \"isDeleted\": 0,\n                        \"name\": \"Free\",\n                        \"priority\": 90,\n                        \"type\": 4\n                    }\n                ],\n                \"safetyStyle\": 1,\n                \"score\": \"4.0\",\n                \"screenshotMode\": [\n                    0,\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"simpleDescription\": \"Send money & airtime, request a debit card & manage your savings from one place\",\n                \"sourceSize\": \"71526348\",\n                \"star\": \"4\",\n                \"tagList\": [],\n                \"versionCode\": \"2068\"\n            },\n            \"downloadCount\": 27061226,\n            \"exists\": null,\n            \"gpLink\": \"https://play.google.com/store/apps/details?id=com.moniepoint.personal&hl=en\",\n            \"iconUrl\": \"https://cdn2.palmplaystore.com/static/59/42d6df6edbe84bdd926fab309aa48261-V02222_512~512.webp?blurhash=LVRpFBkB%5E%23j%5BbHjaoLfQ%7ESa%7C9Jjt\",\n            \"id\": 580,\n            \"isOffer\": 1,\n            \"itemID\": \"s_b7801ad36c0a0e4c7fc1f1e72bb04b2d\",\n            \"name\": null,\n            \"offerDesc\": \"\",\n            \"packageName\": \"com.moniepoint.personal\",\n            \"planName\": \"Moniepoint上线测试20250313-MB信息流竖屏\",\n            \"showContent\": \"https://cdn2.palmplaystore.com/static/403/f2d43eb546cb4cd9ad61fe9adec150d4.webp?blurhash=LXE%7B%5EdOtxrR401rpIVtl%7EUtRkCaK\",\n            \"showType\": 9,\n            \"simpleDescription\": \"Send money & airtime, request a debit card & manage your savings from one place\",\n            \"size\": 71526348,\n            \"star\": \"4.0\",\n            \"verifyGoogle\": \"F\",\n            \"versionCode\": 2068,\n            \"versionName\": \"1.23.0\"\n        }";

    public interface a {
        void onAdClick(AdPlans adPlans);
    }

    private b() {
    }

    public static /* synthetic */ void b(b bVar, String str, String str2, AdPlans adPlans, int i, Object obj) {
        if ((i & 4) != 0) {
            adPlans = null;
        }
        bVar.a(str, str2, adPlans);
    }

    private final String d() {
        String simpleName = b.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final boolean e(AdPlans adPlans) {
        String str;
        AdMaterialList a2 = com.transsion.ad.monopoly.plan.b.a.a(adPlans);
        if (!AdPlanSourceManager.a.g(adPlans)) {
            return false;
        }
        if (a2 == null || (str = a2.getPsLink()) == null) {
            str = BuildConfig.FLAVOR;
        }
        zh.b.a.p((RecommendInfo) com.blankj.utilcode.util.o.d(str, RecommendInfo.class), true, String.valueOf(adPlans.getExtAdSlot()), adPlans.getBidEcpmCent());
        return true;
    }

    private final boolean f(AdPlans adPlans) {
        AdMaterialList a2 = com.transsion.ad.monopoly.plan.b.a.a(adPlans);
        if (a2 != null) {
            a2.getDeeplink();
        }
        if (!AdPlanSourceManager.a.i(adPlans)) {
            return false;
        }
        RecommendInfo psRecommendInfo = a2 != null ? a2.getPsRecommendInfo() : null;
        String gpLink = psRecommendInfo != null ? psRecommendInfo.getGpLink() : null;
        String deepLink = psRecommendInfo != null ? psRecommendInfo.getDeepLink() : null;
        if (TextUtils.isEmpty(deepLink)) {
            deepLink = gpLink;
        }
        Integer adType = psRecommendInfo != null ? psRecommendInfo.getAdType() : null;
        int value = PSAdTypeEnum.PS_AD_TYPE_USER_RETENTION_1.getValue();
        if (adType == null || adType.intValue() != value) {
            int value2 = PSAdTypeEnum.PS_AD_TYPE_USER_ACQUISITION_0.getValue();
            if (adType != null && adType.intValue() == value2) {
                zh.b bVar = zh.b.a;
                if (bVar.n()) {
                    bVar.p(psRecommendInfo, true, String.valueOf(adPlans.getExtAdSlot()), adPlans.getBidEcpmCent());
                } else {
                    g(gpLink);
                    AttributionProduceManager.c.l(adPlans, AttributionPoint.AttributionType.GP_CLICK);
                    AppInstallManager appInstallManager = AppInstallManager.a;
                    String packageName = psRecommendInfo.getPackageName();
                    if (packageName == null) {
                        packageName = "PS_GP没有获取到包名";
                    }
                    AppInstalledBean a3 = appInstallManager.a(packageName);
                    a3.setSource(AppInstalledBean.APP_INSTALLED_BEAN_SOURCE_MB);
                    Application a4 = Utils.a();
                    Intrinsics.g(a4, "getApp(...)");
                    appInstallManager.e(a4, a3);
                }
            }
        } else if (g(deepLink)) {
            AttributionProduceManager.c.l(adPlans, TextUtils.isEmpty(deepLink) ? AttributionPoint.AttributionType.GP_CLICK : AttributionPoint.AttributionType.CLICK);
        } else {
            zh.b bVar2 = zh.b.a;
            if (bVar2.n()) {
                bVar2.p(psRecommendInfo, true, String.valueOf(adPlans.getExtAdSlot()), adPlans.getBidEcpmCent());
            } else {
                g(gpLink);
                AttributionProduceManager.c.l(adPlans, AttributionPoint.AttributionType.GP_CLICK);
            }
        }
        return true;
    }

    private final void h(String str, AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum adOverridePendingTransitionEnum, AdPlans adPlans, String str2) {
        rh.a d;
        yg.l lVar = yg.l.a;
        if (lVar.e()) {
            Application a2 = Utils.a();
            Intrinsics.g(a2, "getApp(...)");
            if (lVar.j(a2)) {
                AdUrlParameterManager adUrlParameterManager = AdUrlParameterManager.a;
                if (adUrlParameterManager.a(str)) {
                    Intent intent = new Intent("android.intent.action.VIEW", str != null ? Uri.parse(str) : null);
                    intent.addFlags(268435456);
                    Utils.a().startActivity(intent);
                    return;
                }
                String b2 = adUrlParameterManager.b(str == null ? BuildConfig.FLAVOR : str, str2);
                xh.a.m(xh.a.a, str2 == null ? BuildConfig.FLAVOR : str2, d() + " --> jumpH5() --> h5LinkOpenByCCT = " + (adPlans != null ? Boolean.valueOf(adPlans.getH5LinkOpenByCct()) : null) + " --> newUrl = " + b2, 6, false, 8, null);
                if (adPlans != null && adPlans.getH5LinkOpenByCct()) {
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    l(str);
                    return;
                }
                MBAd mBAd = MBAd.a;
                MBAd.a b3 = mBAd.b();
                if (b3 == null || !b3.h()) {
                    AdWebActivity.INSTANCE.a(b2, adOverridePendingTransitionEnum, str2);
                    return;
                }
                MBAd.a b4 = mBAd.b();
                if (b4 == null || (d = b4.d()) == null) {
                    return;
                }
                d.a(b2, adOverridePendingTransitionEnum);
                return;
            }
        }
        Activity b5 = com.blankj.utilcode.util.a.b();
        ToastUtils.s(b5 != null ? b5.getString(R.string.ad_no_network) : null, new Object[0]);
    }

    static /* synthetic */ void i(b bVar, String str, AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum adOverridePendingTransitionEnum, AdPlans adPlans, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            adOverridePendingTransitionEnum = null;
        }
        if ((i & 8) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        bVar.h(str, adOverridePendingTransitionEnum, adPlans, str2);
    }

    private final boolean n(AdPlans adPlans) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (!AdPlanSourceManager.a.g(adPlans)) {
            return false;
        }
        List<AdMaterialList> adMaterialList = adPlans != null ? adPlans.getAdMaterialList() : null;
        List<AdMaterialList> list = adMaterialList;
        if (list != null && !list.isEmpty()) {
            String psLink = adMaterialList.get(0).getPsLink();
            if (TextUtils.isEmpty(psLink)) {
                return false;
            }
            zh.b.a.p((RecommendInfo) com.blankj.utilcode.util.o.d(psLink, RecommendInfo.class), true, String.valueOf(adPlans.getExtAdSlot()), adPlans.getBidEcpmCent());
            obj = Result.constructor-impl(Boolean.TRUE);
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = Boolean.FALSE;
            }
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public final void a(String str, String str2, AdPlans adPlans) {
        List<AdMaterialList> adMaterialList;
        AdMaterialList adMaterialList2;
        List<AdMaterialList> adMaterialList3;
        AdMaterialList adMaterialList4;
        RecommendInfo psRecommendInfo;
        xh.a.e(xh.a.a, null, "AdClickManager --> adClick() --> deeplink = " + str + " --> h5Url = " + str2, 0, false, 13, null);
        if (n(adPlans)) {
            return;
        }
        String gpLink = (adPlans == null || (adMaterialList3 = adPlans.getAdMaterialList()) == null || (adMaterialList4 = adMaterialList3.get(0)) == null || (psRecommendInfo = adMaterialList4.getPsRecommendInfo()) == null) ? null : psRecommendInfo.getGpLink();
        if (!AdPlanSourceManager.a.i(adPlans)) {
            if (g(str)) {
                return;
            }
            i(this, str2, null, adPlans, null, 10, null);
            return;
        }
        zh.b bVar = zh.b.a;
        if (bVar.n() || gpLink == null || !StringsKt.c0(gpLink, "play.google.com", false, 2, (Object) null)) {
            bVar.p((adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null || (adMaterialList2 = adMaterialList.get(0)) == null) ? null : adMaterialList2.getPsRecommendInfo(), true, String.valueOf(adPlans != null ? adPlans.getExtAdSlot() : null), adPlans != null ? adPlans.getBidEcpmCent() : null);
        } else {
            g(gpLink);
        }
    }

    public final void c(a aVar) {
        if (aVar == null) {
            return;
        }
        List list = b;
        if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    public final boolean g(String str) {
        Object obj;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.setData(parse);
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            Utils.a().startActivity(intent);
            obj = Result.constructor-impl(Boolean.TRUE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            xh.a.e(xh.a.a, null, a.d() + " --> jumpDeeplink() --> e = " + th3, 0, false, 13, null);
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final void j(AdPlans adPlans, AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum adOverridePendingTransitionEnum, String str, String str2) {
        Intrinsics.h(str, "logTag");
        Intrinsics.h(str2, "sceneId");
        if (adPlans == null) {
            xh.a.m(xh.a.a, str, d() + " --> onBiddingAdClick() --> sceneId = " + str2 + " --> adPlan == null", 6, false, 8, null);
            return;
        }
        AdMaterialList a2 = com.transsion.ad.monopoly.plan.b.a.a(adPlans);
        if (a2 == null) {
            xh.a.m(xh.a.a, str, d() + " --> onBiddingAdClick() --> sceneId = " + str2 + " --> adMaterial == null", 6, false, 8, null);
            return;
        }
        k(adPlans);
        String deeplink = a2.getDeeplink();
        String h5Link = a2.getH5Link();
        String adSource = adPlans.getAdSource();
        xh.a.m(xh.a.a, str, d() + " --> onBiddingAdClick() --> sceneId = " + str2 + " --> name = " + adPlans.getName() + " --> adSource = " + adSource + " --> deeplink = " + deeplink + " --> h5Url = " + h5Link, 0, false, 12, null);
        if (e(adPlans) || f(adPlans) || g(deeplink)) {
            return;
        }
        h(h5Link, adOverridePendingTransitionEnum, adPlans, str);
    }

    public final void k(AdPlans adPlans) {
        Iterator it = b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onAdClick(adPlans);
        }
    }

    public final void l(String str) {
        Object obj;
        Unit unit;
        Intrinsics.h(str, "h5Url");
        try {
            Result.Companion companion = Result.Companion;
            Activity b2 = com.blankj.utilcode.util.a.b();
            if (b2 != null) {
                CustomTabsHelper.Companion companion2 = CustomTabsHelper.a;
                androidx.browser.customtabs.d a2 = new d.b().a();
                Intrinsics.g(a2, "build(...)");
                CustomTabsHelper.Companion.e(companion2, b2, a2, Uri.parse(str), new gi.b(), null, 16, null);
                unit = Unit.a;
            } else {
                unit = null;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Result.exceptionOrNull-impl(obj);
    }

    public final void m(a aVar) {
        TypeIntrinsics.a(b).remove(aVar);
    }
}
