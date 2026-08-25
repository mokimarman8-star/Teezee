package ai;

import android.os.Build;
import android.text.TextUtils;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.ad.report.BiddingStateEnum;
import com.transsion.al.BuildConfig;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.PushMessageKey;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    private final void e(Map map, RecommendInfo recommendInfo) {
        Object obj;
        if (recommendInfo == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            tg.b bVar = tg.b.a;
            linkedHashMap.put("gaid", bVar.i());
            linkedHashMap.put("country_code", bVar.f());
            linkedHashMap.put("media", com.blankj.utilcode.util.c.c());
            ItemDetail detail = recommendInfo.getDetail();
            linkedHashMap.put(PushMessageKey.KEY_APP_NAME, String.valueOf(detail != null ? detail.getName() : null));
            linkedHashMap.put("packageName", String.valueOf(recommendInfo.getPackageName()));
            linkedHashMap.put("ps_dialog_style", "B");
            linkedHashMap.put("plan_Name", String.valueOf(recommendInfo.getPlanName()));
            linkedHashMap.put("plan_id", String.valueOf(recommendInfo.getId()));
            linkedHashMap.put("is_offer", String.valueOf(recommendInfo.isOffer()));
            linkedHashMap.put("show_type", String.valueOf(recommendInfo.getShowType()));
            linkedHashMap.put("ua", Build.MODEL);
            linkedHashMap.put("brand", Build.BRAND);
            linkedHashMap.put("source", BuildConfig.FLAVOR);
            linkedHashMap.put("adSource", String.valueOf(recommendInfo.getAdSource()));
            map.put("ps_map_json", new JSONObject(linkedHashMap));
            map.put("ps_id", String.valueOf(recommendInfo.getId()));
            map.put("ps_package_name", String.valueOf(recommendInfo.getPackageName()));
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 == null) {
            return;
        }
        xh.a.e(xh.a.a, "Report_ad", "AdReportProvider --> commonParams() --> " + th3.getMessage(), 0, false, 12, null);
    }

    public final void a(String str, String str2, String str3, Integer num, String str4, int i, boolean z, Map map, RecommendInfo recommendInfo, Double d, Long l, String str5) {
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(map, "extMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adSource", String.valueOf(num));
        linkedHashMap.put("adType", String.valueOf(i));
        linkedHashMap.put("action", PushConstants.PUSH_SERVICE_TYPE_CLICK);
        String str6 = com.transsion.gslb.BuildConfig.FLAVOR;
        if (str4 == null) {
            str4 = com.transsion.gslb.BuildConfig.FLAVOR;
        }
        linkedHashMap.put("ad_id", str4);
        if (str3 == null) {
            str3 = com.transsion.gslb.BuildConfig.FLAVOR;
        }
        linkedHashMap.put("ad_plan_id", str3);
        if (str2 != null) {
            str6 = str2;
        }
        linkedHashMap.put("scene_id", str6);
        linkedHashMap.put("is_ad_show_final", String.valueOf(z));
        linkedHashMap.put("trigger_id", str);
        e(linkedHashMap, recommendInfo);
        linkedHashMap.put("bid_ecpm_cent", String.valueOf(d));
        linkedHashMap.put("ecpm_cent", String.valueOf(l));
        if (!TextUtils.isEmpty(str5)) {
            linkedHashMap.put("scene_sub_id", str5);
        }
        if (!map.isEmpty()) {
            linkedHashMap.putAll(map);
        }
        b.a.a("ad_click", linkedHashMap, str2);
    }

    public final void c(String str, String str2, String str3, long j, String str4, int i, boolean z, String str5) {
        Intrinsics.h(str, "triggerId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adSource", MsgStyle.STYLE_VERTICAL_TYPE);
        linkedHashMap.put("adType", String.valueOf(i));
        linkedHashMap.put("action", "show_time");
        String str6 = com.transsion.gslb.BuildConfig.FLAVOR;
        if (str4 == null) {
            str4 = com.transsion.gslb.BuildConfig.FLAVOR;
        }
        linkedHashMap.put("ad_id", str4);
        if (str3 == null) {
            str3 = com.transsion.gslb.BuildConfig.FLAVOR;
        }
        linkedHashMap.put("ad_plan_id", str3);
        if (str2 != null) {
            str6 = str2;
        }
        linkedHashMap.put("scene_id", str6);
        linkedHashMap.put("is_ad_show_final", String.valueOf(z));
        linkedHashMap.put("trigger_id", str);
        linkedHashMap.put("duration", String.valueOf(j));
        if (!TextUtils.isEmpty(str5)) {
            linkedHashMap.put("scene_sub_id", str5);
        }
        b.a.a("ad_show_time", linkedHashMap, str2);
    }

    public final void d(String str, String str2, Integer num, int i, BiddingStateEnum biddingStateEnum, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(str2, "sceneId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "bidding");
        linkedHashMap.put("trigger_id", str);
        linkedHashMap.put("adType", String.valueOf(i));
        linkedHashMap.put("scene_id", str2);
        linkedHashMap.put("result", biddingStateEnum != null ? biddingStateEnum.getValue() : null);
        linkedHashMap.put("msg", str3);
        linkedHashMap.put("ecpm_list", str4);
        linkedHashMap.put("ecpm", str5);
        linkedHashMap.put("plan_id", str6);
        linkedHashMap.put("plan_name", str7);
        linkedHashMap.put("adSource", num != null ? num.toString() : null);
        if (!TextUtils.isEmpty(str8)) {
            linkedHashMap.put("scene_sub_id", str8);
        }
        b.a.a("ad_bidding", linkedHashMap, str2);
    }

    public final void f(String str, String str2, String str3, Integer num, String str4, int i, boolean z, Map map, RecommendInfo recommendInfo, Double d, Long l, String str5) {
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(map, "extMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adSource", String.valueOf(num));
        linkedHashMap.put("adType", String.valueOf(i));
        linkedHashMap.put("action", "display");
        String str6 = com.transsion.gslb.BuildConfig.FLAVOR;
        if (str4 == null) {
            str4 = com.transsion.gslb.BuildConfig.FLAVOR;
        }
        linkedHashMap.put("ad_id", str4);
        if (str3 == null) {
            str3 = com.transsion.gslb.BuildConfig.FLAVOR;
        }
        linkedHashMap.put("ad_plan_id", str3);
        if (str2 != null) {
            str6 = str2;
        }
        linkedHashMap.put("scene_id", str6);
        linkedHashMap.put("is_ad_show_final", String.valueOf(z));
        linkedHashMap.put("trigger_id", str);
        e(linkedHashMap, recommendInfo);
        linkedHashMap.put("bid_ecpm_cent", String.valueOf(d));
        linkedHashMap.put("ecpm_cent", String.valueOf(l));
        if (!TextUtils.isEmpty(str5)) {
            linkedHashMap.put("scene_sub_id", str5);
        }
        if (!map.isEmpty()) {
            linkedHashMap.putAll(map);
        }
        b.a.a("ad_display", linkedHashMap, str2);
    }

    public final void h(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("last_version", String.valueOf(str));
        linkedHashMap.put("new_version", String.valueOf(str2));
        linkedHashMap.put("action", "plan_receive");
        b.a.a("ad_config", linkedHashMap, "ad_config");
    }

    public final void i(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("last_version", String.valueOf(str));
        linkedHashMap.put("new _version", String.valueOf(str2));
        linkedHashMap.put("action", "plan_success");
        b.a.a("ad_config", linkedHashMap, "ad_config");
    }

    public final void j(String str, String str2, int i, int i2, String str3, String str4) {
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(str2, "sceneId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "reject");
        linkedHashMap.put("trigger_id", str);
        linkedHashMap.put("adType", String.valueOf(i));
        linkedHashMap.put("scene_id", str2);
        linkedHashMap.put("reject_msg", str3);
        linkedHashMap.put("adSource", String.valueOf(i2));
        if (!TextUtils.isEmpty(str4)) {
            linkedHashMap.put("scene_sub_id", str4);
        }
        if (!com.transsion.ad.scene.b.a.j()) {
            b.a.a("ad_reject", linkedHashMap, str2);
            return;
        }
        xh.a.m(xh.a.a, "Report_ad", "AdReportProvider --> reject() --> 广告数据上报链路已关闭，不上报 -- map = " + linkedHashMap, 0, false, 12, null);
    }

    public final void k(String str, String str2, int i, int i2, String str3, String str4) {
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(str2, "sceneId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "trigger");
        linkedHashMap.put("adType", String.valueOf(i));
        linkedHashMap.put("scene_id", str2);
        linkedHashMap.put("plan_id", str3);
        linkedHashMap.put("adSource", String.valueOf(i2));
        linkedHashMap.put("trigger_id", str);
        if (!TextUtils.isEmpty(str4)) {
            linkedHashMap.put("scene_sub_id", str4);
        }
        if (!com.transsion.ad.scene.b.a.i()) {
            b.a.a("ad_trigger", linkedHashMap, str2);
            return;
        }
        xh.a.m(xh.a.a, "Report_ad", "AdReportProvider --> trigger() --> 广告数据上报链路已关闭，不上报 -- map = " + linkedHashMap, 0, false, 12, null);
    }
}
