package zh;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c;
import com.cloud.hisavana.sdk.common.bean.ImgListDTO;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.transsion.ad.db.pslink.AppInstalledBean;
import com.transsion.ad.ps.installed.AppInstallManager;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public static /* synthetic */ void b(b bVar, RecommendInfo recommendInfo, boolean z, String str, Double d, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            d = Double.valueOf(0.0d);
        }
        bVar.a(recommendInfo, z, str, d);
    }

    private final String e() {
        String simpleName = b.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final String f(RecommendInfo recommendInfo, String str) {
        return "palmplay://thirdlauncher.com/?entryType=AppDetail&packageName=" + (recommendInfo != null ? recommendInfo.getPackageName() : null) + "&_source=Moviebox&HalfScreenType=B&isHalfScreen=1&sceneCode=" + str;
    }

    private final String g(RecommendInfo recommendInfo) {
        return "palmplay://thirdlauncher.com/?entryType=AppDetail&packageName=" + (recommendInfo != null ? recommendInfo.getPackageName() : null) + "&_source=Moviebox";
    }

    private final String h(RecommendInfo recommendInfo, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", recommendInfo != null ? Long.valueOf(recommendInfo.getId()) : null);
        jSONObject.put("isOffer", recommendInfo != null ? Integer.valueOf(recommendInfo.isOffer()) : null);
        jSONObject.put("showType", recommendInfo != null ? Integer.valueOf(recommendInfo.getShowType()) : null);
        jSONObject.put("planName", recommendInfo != null ? recommendInfo.getPlanName() : null);
        jSONObject.put("media", "MovieBox");
        jSONObject.put("scene", str);
        jSONObject.put("planId", recommendInfo != null ? Long.valueOf(recommendInfo.getId()) : null);
        jSONObject.put("c_source", "PS");
        jSONObject.put("adSource", recommendInfo != null ? recommendInfo.getAdSource() : null);
        jSONObject.put("mbVc", String.valueOf(c.f()));
        jSONObject.put("key", "MovieBox");
        String jSONObject2 = jSONObject.toString();
        Intrinsics.g(jSONObject2, "toString(...)");
        return jSONObject2;
    }

    private final PslinkInfo j(RecommendInfo recommendInfo, boolean z) {
        String name;
        ItemDetail detail;
        ItemDetail detail2;
        ItemDetail detail3;
        ItemDetail detail4;
        ItemDetail detail5;
        ItemDetail detail6;
        ItemDetail detail7;
        ItemDetail detail8;
        ItemDetail detail9;
        ItemDetail detail10;
        ItemDetail detail11;
        ItemDetail detail12;
        ItemDetail detail13;
        ItemDetail detail14;
        ItemDetail detail15;
        ItemDetail detail16;
        PslinkInfo pslinkInfo = new PslinkInfo();
        pslinkInfo.setClickType(z ? 2 : 1);
        pslinkInfo.setItemID(recommendInfo != null ? recommendInfo.getItemID() : null);
        pslinkInfo.setPackageName(recommendInfo != null ? recommendInfo.getPackageName() : null);
        pslinkInfo.setAppPackageName(Utils.a().getPackageName());
        if (recommendInfo == null || (name = recommendInfo.getName()) == null) {
            name = (recommendInfo == null || (detail = recommendInfo.getDetail()) == null) ? null : detail.getName();
        }
        pslinkInfo.setName(name);
        pslinkInfo.setStar(recommendInfo != null ? recommendInfo.getStar() : null);
        pslinkInfo.setDownloadCount(recommendInfo != null ? recommendInfo.getDownloadCount() : 0);
        pslinkInfo.setSourceSize(recommendInfo != null ? Long.valueOf(recommendInfo.getSize()).toString() : null);
        pslinkInfo.setIconUrl(recommendInfo != null ? recommendInfo.getIconUrl() : null);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty((recommendInfo == null || (detail16 = recommendInfo.getDetail()) == null) ? null : detail16.getImg0())) {
            ImgListDTO imgListDTO = new ImgListDTO();
            imgListDTO.setUrl((recommendInfo == null || (detail15 = recommendInfo.getDetail()) == null) ? null : detail15.getImg0());
            arrayList.add(imgListDTO);
            imgListDTO.setHv(k((recommendInfo == null || (detail14 = recommendInfo.getDetail()) == null) ? null : detail14.getScreenshotMode(), arrayList.size() - 1));
        }
        if (!TextUtils.isEmpty((recommendInfo == null || (detail13 = recommendInfo.getDetail()) == null) ? null : detail13.getImg1())) {
            ImgListDTO imgListDTO2 = new ImgListDTO();
            imgListDTO2.setUrl((recommendInfo == null || (detail12 = recommendInfo.getDetail()) == null) ? null : detail12.getImg1());
            arrayList.add(imgListDTO2);
            imgListDTO2.setHv(k((recommendInfo == null || (detail11 = recommendInfo.getDetail()) == null) ? null : detail11.getScreenshotMode(), arrayList.size() - 1));
        }
        if (!TextUtils.isEmpty((recommendInfo == null || (detail10 = recommendInfo.getDetail()) == null) ? null : detail10.getImg2())) {
            ImgListDTO imgListDTO3 = new ImgListDTO();
            imgListDTO3.setUrl((recommendInfo == null || (detail9 = recommendInfo.getDetail()) == null) ? null : detail9.getImg2());
            arrayList.add(imgListDTO3);
            imgListDTO3.setHv(k((recommendInfo == null || (detail8 = recommendInfo.getDetail()) == null) ? null : detail8.getScreenshotMode(), arrayList.size() - 1));
        }
        if (!TextUtils.isEmpty((recommendInfo == null || (detail7 = recommendInfo.getDetail()) == null) ? null : detail7.getImg3())) {
            ImgListDTO imgListDTO4 = new ImgListDTO();
            imgListDTO4.setUrl((recommendInfo == null || (detail6 = recommendInfo.getDetail()) == null) ? null : detail6.getImg3());
            arrayList.add(imgListDTO4);
            imgListDTO4.setHv(k((recommendInfo == null || (detail5 = recommendInfo.getDetail()) == null) ? null : detail5.getScreenshotMode(), arrayList.size() - 1));
        }
        if (!TextUtils.isEmpty((recommendInfo == null || (detail4 = recommendInfo.getDetail()) == null) ? null : detail4.getImg4())) {
            ImgListDTO imgListDTO5 = new ImgListDTO();
            imgListDTO5.setUrl((recommendInfo == null || (detail3 = recommendInfo.getDetail()) == null) ? null : detail3.getImg4());
            arrayList.add(imgListDTO5);
            imgListDTO5.setHv(k((recommendInfo == null || (detail2 = recommendInfo.getDetail()) == null) ? null : detail2.getScreenshotMode(), arrayList.size() - 1));
        }
        pslinkInfo.setImgList(arrayList);
        pslinkInfo.setSimpleDescription(recommendInfo != null ? recommendInfo.getSimpleDescription() : null);
        return pslinkInfo;
    }

    private final int k(List list, int i) {
        Integer num;
        List list2 = list;
        if (list2 == null || list2.isEmpty() || i < 0 || (num = (Integer) list.get(i % list.size())) == null) {
            return 0;
        }
        return num.intValue();
    }

    private final long l(Context context, String str) {
        long j = 0;
        try {
            Result.Companion companion = Result.Companion;
            j = Build.VERSION.SDK_INT >= 28 ? f7.a.a(context.getPackageManager().getPackageInfo(str, 0)) : r4.versionCode;
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        return j;
    }

    public final void a(RecommendInfo recommendInfo, boolean z, String str, Double d) {
        Intrinsics.h(str, "scene");
        String gpLink = recommendInfo != null ? recommendInfo.getGpLink() : null;
        if (!n() && gpLink != null && StringsKt.c0(gpLink, "play.google.com", false, 2, (Object) null)) {
            com.transsion.ad.strategy.b.a.g(gpLink);
        } else if (n()) {
            p(recommendInfo, z, str, d);
        } else {
            q(recommendInfo);
        }
    }

    public final boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PackageInfo packageInfo = null;
        try {
            Result.Companion companion = Result.Companion;
            PackageManager packageManager = Utils.a().getPackageManager();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            packageInfo = packageManager.getPackageInfo(str, 0);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        return packageInfo != null;
    }

    public final boolean d() {
        if (c.k("com.transsnet.store")) {
            return true;
        }
        return c("com.transsnet.store");
    }

    public final long i() {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return l(a2, "com.transsnet.store");
    }

    public final boolean m() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public final boolean n() {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return l(a2, "com.transsnet.store") >= 8403100;
    }

    public final boolean o(String str) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = Utils.a().getPackageManager();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (Exception e) {
            xh.a.i(xh.a.a, e() + " --> it = " + Log.getStackTraceString(e), 6, false, 4, null);
        }
        if (packageInfo == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageInfo.packageName);
        List<ResolveInfo> queryIntentActivities = Utils.a().getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.g(queryIntentActivities, "queryIntentActivities(...)");
        if (queryIntentActivities.isEmpty()) {
            return false;
        }
        ResolveInfo next = queryIntentActivities.iterator().next();
        if ((next != null ? next.activityInfo : null) != null) {
            ActivityInfo activityInfo = next.activityInfo;
            String str2 = activityInfo.packageName;
            String str3 = activityInfo.name;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setFlags(268435456);
                intent2.setComponent(new ComponentName(str2, str3));
                Utils.a().startActivity(intent2);
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean p(RecommendInfo recommendInfo, boolean z, String str, Double d) {
        Object obj;
        String str2;
        ItemDetail detail;
        Intrinsics.h(str, "scene");
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            b bVar = a;
            String f = bVar.f(recommendInfo, str);
            xh.a.i(xh.a.a, bVar.e() + " --> startPsActivity() --> isAutoDownload = " + z + " --> deeplink = " + f, 0, false, 6, null);
            intent.setData(Uri.parse(f));
            intent.putExtra("PslinkInfo", (Parcelable) bVar.j(recommendInfo, z));
            intent.putExtra("versionCode", recommendInfo != null ? Integer.valueOf(recommendInfo.getVersionCode()) : null);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            intent.putExtra("psExtendFields", bVar.h(recommendInfo, str));
            Utils.a().startActivity(intent);
            AppInstallManager appInstallManager = AppInstallManager.a;
            if (recommendInfo == null || (detail = recommendInfo.getDetail()) == null || (str2 = detail.getPackageName()) == null) {
                str2 = "ps没有传递过来";
            }
            AppInstalledBean a2 = appInstallManager.a(str2);
            a2.setSource(AppInstalledBean.APP_INSTALLED_BEAN_SOURCE_MB);
            a2.setECPM(d);
            Application a3 = Utils.a();
            Intrinsics.g(a3, "getApp(...)");
            appInstallManager.e(a3, a2);
            obj = Result.constructor-impl(Boolean.TRUE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            xh.a.i(xh.a.a, a.e() + " --> startPsActivity --> it = " + Log.getStackTraceString(th3), 6, false, 4, null);
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean q(RecommendInfo recommendInfo) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(a.g(recommendInfo)));
            intent.putExtra("versionCode", c.f());
            intent.addFlags(32768);
            intent.addFlags(268435456);
            Utils.a().startActivity(intent);
            obj = Result.constructor-impl(Boolean.TRUE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            xh.a.i(xh.a.a, a.e() + " --> startPsActivity --> it = " + Log.getStackTraceString(th3), 6, false, 4, null);
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }
}
