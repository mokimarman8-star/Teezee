package com.transsion.ad.ps.distribute;

import android.text.TextUtils;
import ci.h;
import com.blankj.utilcode.util.o;
import com.cloud.hisavana.sdk.common.util.a0;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.ps.PSReportUtil;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.PsLinkAdInfo;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.ad.strategy.g;
import com.transsion.gslb.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import org.json.JSONObject;
import rh.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PsDistributeRequestManager {
    public static final PsDistributeRequestManager a = new PsDistributeRequestManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.ad.ps.distribute.c
        public final Object invoke() {
            zh.a p;
            p = PsDistributeRequestManager.p();
            return p;
        }
    });
    private static final ConcurrentHashMap c = new ConcurrentHashMap();

    private PsDistributeRequestManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0136 -> B:22:0x014b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0148 -> B:22:0x014b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(String str, String str2, PsLinkDto psLinkDto, Continuation continuation) {
        PsDistributeRequestManager$analyzeData$1 psDistributeRequestManager$analyzeData$1;
        int i;
        String str3;
        String str4;
        ArrayList arrayList;
        List<RecommendInfo> data;
        Iterator it;
        List<RecommendInfo> data2;
        String str5;
        String str6;
        String str7;
        ArrayList arrayList2;
        Iterator it2;
        PsLinkAdPlan psLinkAdPlan;
        ArrayList arrayList3;
        if (continuation instanceof PsDistributeRequestManager$analyzeData$1) {
            psDistributeRequestManager$analyzeData$1 = (PsDistributeRequestManager$analyzeData$1) continuation;
            int i2 = psDistributeRequestManager$analyzeData$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                psDistributeRequestManager$analyzeData$1.label = i2 - Integer.MIN_VALUE;
                Object obj = psDistributeRequestManager$analyzeData$1.result;
                Object f = IntrinsicsKt.f();
                i = psDistributeRequestManager$analyzeData$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (f.a.a()) {
                        xh.a aVar = xh.a.a;
                        String k = k();
                        Integer d = (psLinkDto == null || (data2 = psLinkDto.getData()) == null) ? null : Boxing.d(data2.size());
                        StringBuilder sb = new StringBuilder();
                        sb.append(k);
                        sb.append(" --> analyzeData() --> PS接口返回 --> psScene = ");
                        str3 = str;
                        sb.append(str3);
                        sb.append(" --> adPlanId = ");
                        str4 = str2;
                        sb.append(str4);
                        sb.append(" --> data.size = ");
                        sb.append(d);
                        sb.append(" --> 开始增量更新");
                        xh.a.i(aVar, sb.toString(), 0, false, 6, null);
                    } else {
                        str3 = str;
                        str4 = str2;
                    }
                    arrayList = new ArrayList();
                    if (psLinkDto != null && (data = psLinkDto.getData()) != null) {
                        it = data.iterator();
                        while (it.hasNext()) {
                        }
                    }
                    if (!arrayList.isEmpty()) {
                    }
                    if (f.a.a()) {
                    }
                    return Unit.a;
                }
                if (i == 1) {
                    it2 = (Iterator) psDistributeRequestManager$analyzeData$1.L$3;
                    ?? r9 = (List) psDistributeRequestManager$analyzeData$1.L$2;
                    str7 = (String) psDistributeRequestManager$analyzeData$1.L$1;
                    str6 = (String) psDistributeRequestManager$analyzeData$1.L$0;
                    ResultKt.b(obj);
                    arrayList2 = r9;
                    psLinkAdPlan = (PsLinkAdPlan) obj;
                    arrayList3 = arrayList2;
                    if (psLinkAdPlan != null) {
                    }
                    str4 = str7;
                    str3 = str6;
                    ArrayList arrayList4 = arrayList3;
                    it = it2;
                    arrayList = arrayList4;
                    while (it.hasNext()) {
                    }
                    if (!arrayList.isEmpty()) {
                    }
                    if (f.a.a()) {
                    }
                    return Unit.a;
                }
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str5 = (String) psDistributeRequestManager$analyzeData$1.L$0;
                    ResultKt.b(obj);
                    str3 = str5;
                    if (f.a.a()) {
                        xh.a.i(xh.a.a, k() + " --> analyzeData() --> 删除数据库无效Offer --> sceneStr = " + str3, 0, false, 6, null);
                    }
                    return Unit.a;
                }
                it2 = (Iterator) psDistributeRequestManager$analyzeData$1.L$3;
                ?? r92 = (List) psDistributeRequestManager$analyzeData$1.L$2;
                str7 = (String) psDistributeRequestManager$analyzeData$1.L$1;
                str6 = (String) psDistributeRequestManager$analyzeData$1.L$0;
                ResultKt.b(obj);
                arrayList3 = r92;
                str4 = str7;
                str3 = str6;
                ArrayList arrayList42 = arrayList3;
                it = it2;
                arrayList = arrayList42;
                while (it.hasNext()) {
                    RecommendInfo recommendInfo = (RecommendInfo) it.next();
                    if (zh.b.a.n() || !TextUtils.isEmpty(recommendInfo.getGpLink())) {
                        arrayList.add(Boxing.d((str3 + recommendInfo.getId()).hashCode()));
                        PsDistributeRequestManager psDistributeRequestManager = a;
                        psDistributeRequestManager$analyzeData$1.L$0 = str3;
                        psDistributeRequestManager$analyzeData$1.L$1 = str4;
                        psDistributeRequestManager$analyzeData$1.L$2 = arrayList;
                        psDistributeRequestManager$analyzeData$1.L$3 = it;
                        psDistributeRequestManager$analyzeData$1.label = 1;
                        Object m = psDistributeRequestManager.m(str3, str4, recommendInfo, psDistributeRequestManager$analyzeData$1);
                        if (m == f) {
                            return f;
                        }
                        str6 = str3;
                        obj = m;
                        str7 = str4;
                        Iterator it3 = it;
                        arrayList2 = arrayList;
                        it2 = it3;
                        psLinkAdPlan = (PsLinkAdPlan) obj;
                        arrayList3 = arrayList2;
                        if (psLinkAdPlan != null) {
                            PsDbManager psDbManager = PsDbManager.a;
                            psDistributeRequestManager$analyzeData$1.L$0 = str6;
                            psDistributeRequestManager$analyzeData$1.L$1 = str7;
                            psDistributeRequestManager$analyzeData$1.L$2 = arrayList2;
                            psDistributeRequestManager$analyzeData$1.L$3 = it2;
                            psDistributeRequestManager$analyzeData$1.label = 2;
                            arrayList3 = arrayList2;
                            if (psDbManager.j(psLinkAdPlan, psDistributeRequestManager$analyzeData$1) == f) {
                                return f;
                            }
                        }
                        str4 = str7;
                        str3 = str6;
                        ArrayList arrayList422 = arrayList3;
                        it = it2;
                        arrayList = arrayList422;
                        while (it.hasNext()) {
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    PsDbManager psDbManager2 = PsDbManager.a;
                    psDistributeRequestManager$analyzeData$1.L$0 = str3;
                    psDistributeRequestManager$analyzeData$1.L$1 = null;
                    psDistributeRequestManager$analyzeData$1.L$2 = null;
                    psDistributeRequestManager$analyzeData$1.L$3 = null;
                    psDistributeRequestManager$analyzeData$1.label = 3;
                    if (psDbManager2.c(str3, arrayList, psDistributeRequestManager$analyzeData$1) == f) {
                        return f;
                    }
                    str5 = str3;
                    str3 = str5;
                }
                if (f.a.a()) {
                }
                return Unit.a;
            }
        }
        psDistributeRequestManager$analyzeData$1 = new PsDistributeRequestManager$analyzeData$1(this, continuation);
        Object obj2 = psDistributeRequestManager$analyzeData$1.result;
        Object f2 = IntrinsicsKt.f();
        i = psDistributeRequestManager$analyzeData$1.label;
        if (i != 0) {
        }
    }

    private final String i(String str) {
        String c2 = a0.c(str);
        String str2 = com.transsion.ad.a.a.a() + File.separatorChar + c2 + ".mineType";
        return (h.a.c(str2) || g.a.a(str, str2)) ? str2 : BuildConfig.FLAVOR;
    }

    private final boolean j(MbAdImage mbAdImage) {
        String url = mbAdImage.getUrl();
        String c2 = a0.c(url);
        String str = com.transsion.ad.a.a.a() + File.separatorChar + c2 + ".mineType";
        File file = new File(str);
        if (file.isFile() && file.exists() && file.length() > 0) {
            mbAdImage.setPath(str);
            return true;
        }
        boolean a2 = g.a.a(url, str);
        long length = file.length();
        if (a2 && length > 0) {
            mbAdImage.setPath(str);
            return true;
        }
        xh.a.i(xh.a.a, k() + " --> downloadAdPlan() --> 图片素材下载失败 --  downloadFileSuccess = " + a2 + " -- localFileSize = " + length + " -- destination = " + str, 6, false, 4, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k() {
        String simpleName = PsDistributeRequestManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject l(int i, int i2, Integer num) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bu", "mb");
        jSONObject.put("pageIndex", i);
        jSONObject.put("pageSize", i2);
        jSONObject.put("media", 1);
        jSONObject.put("scene", num);
        for (Map.Entry entry : zh.a.INSTANCE.a(System.currentTimeMillis()).entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(String str, String str2, RecommendInfo recommendInfo, Continuation continuation) {
        PsDistributeRequestManager$getPsLinkAdPlan$1 psDistributeRequestManager$getPsLinkAdPlan$1;
        int i;
        String str3;
        String str4;
        RecommendInfo recommendInfo2;
        PsLinkAdPlan psLinkAdPlan;
        PsLinkAdPlan psLinkAdPlan2;
        if (continuation instanceof PsDistributeRequestManager$getPsLinkAdPlan$1) {
            psDistributeRequestManager$getPsLinkAdPlan$1 = (PsDistributeRequestManager$getPsLinkAdPlan$1) continuation;
            int i2 = psDistributeRequestManager$getPsLinkAdPlan$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                psDistributeRequestManager$getPsLinkAdPlan$1.label = i2 - Integer.MIN_VALUE;
                PsDistributeRequestManager$getPsLinkAdPlan$1 psDistributeRequestManager$getPsLinkAdPlan$12 = psDistributeRequestManager$getPsLinkAdPlan$1;
                Object obj = psDistributeRequestManager$getPsLinkAdPlan$12.result;
                Object f = IntrinsicsKt.f();
                i = psDistributeRequestManager$getPsLinkAdPlan$12.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    PSReportUtil pSReportUtil = PSReportUtil.a;
                    pSReportUtil.c(PSReportUtil.PSRequestState.REQUEST_TRIGGER, recommendInfo, str, str2);
                    ItemDetail detail = recommendInfo.getDetail();
                    MbAdImage mbAdImage = new MbAdImage(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
                    String showContent = recommendInfo.getShowContent();
                    if (showContent == null) {
                        showContent = detail != null ? detail.getImg0() : null;
                    }
                    mbAdImage.setUrl(showContent);
                    if (!j(mbAdImage)) {
                        pSReportUtil.c(PSReportUtil.PSRequestState.REQUEST_FAIL, recommendInfo, str, str2);
                        return null;
                    }
                    PsLinkAdInfo psLinkAdInfo = new PsLinkAdInfo(recommendInfo.getName(), recommendInfo.getIconUrl(), i(recommendInfo.getIconUrl()), detail != null ? detail.getName() : null, detail != null ? detail.getSimpleDescription() : null, recommendInfo.getButtonText(), mbAdImage.getUrl(), mbAdImage.getPath());
                    int hashCode = (str + recommendInfo.getId()).hashCode();
                    str3 = str2;
                    str4 = str;
                    PsLinkAdPlan psLinkAdPlan3 = new PsLinkAdPlan(hashCode, str3, AdPlanSourceManager.AdPlanEnum.AD_PLAN_AD_SOURCE_PS.getValue(), str, 0, String.valueOf(recommendInfo.getId()), o.j(psLinkAdInfo), o.j(recommendInfo), Boxing.e(System.currentTimeMillis()), recommendInfo.getShowMax(), recommendInfo.getClickMax(), recommendInfo.getShowHours(), 0, 0, null, 28672, null);
                    PsDbManager psDbManager = PsDbManager.a;
                    psDistributeRequestManager$getPsLinkAdPlan$12.L$0 = str4;
                    psDistributeRequestManager$getPsLinkAdPlan$12.L$1 = str3;
                    recommendInfo2 = recommendInfo;
                    psDistributeRequestManager$getPsLinkAdPlan$12.L$2 = recommendInfo2;
                    psDistributeRequestManager$getPsLinkAdPlan$12.L$3 = psLinkAdPlan3;
                    psDistributeRequestManager$getPsLinkAdPlan$12.label = 1;
                    obj = psDbManager.g(hashCode, psDistributeRequestManager$getPsLinkAdPlan$12);
                    if (obj == f) {
                        return f;
                    }
                    psLinkAdPlan = psLinkAdPlan3;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    psLinkAdPlan = (PsLinkAdPlan) psDistributeRequestManager$getPsLinkAdPlan$12.L$3;
                    RecommendInfo recommendInfo3 = (RecommendInfo) psDistributeRequestManager$getPsLinkAdPlan$12.L$2;
                    String str5 = (String) psDistributeRequestManager$getPsLinkAdPlan$12.L$1;
                    String str6 = (String) psDistributeRequestManager$getPsLinkAdPlan$12.L$0;
                    ResultKt.b(obj);
                    str4 = str6;
                    recommendInfo2 = recommendInfo3;
                    str3 = str5;
                }
                psLinkAdPlan2 = (PsLinkAdPlan) obj;
                if (psLinkAdPlan2 == null) {
                    if (f.a.a()) {
                        xh.a aVar = xh.a.a;
                        String k = k();
                        ItemDetail detail2 = recommendInfo2.getDetail();
                        String name = detail2 != null ? detail2.getName() : null;
                        xh.a.i(aVar, k + " --> getPsLinkAdPlan() --> name = " + name + " --> 数据库 存在、替换数据再保存 --> showedTimes = " + psLinkAdPlan2.getShowedTimes() + " --> clickedTimes = " + psLinkAdPlan2.getClickedTimes() + " --> showDate = " + psLinkAdPlan2.getShowDate(), 0, false, 6, null);
                    }
                    psLinkAdPlan.setShowedTimes(psLinkAdPlan2.getShowedTimes());
                    psLinkAdPlan.setClickedTimes(psLinkAdPlan2.getClickedTimes());
                    psLinkAdPlan.setShowDate(psLinkAdPlan2.getShowDate());
                } else if (f.a.a()) {
                    xh.a aVar2 = xh.a.a;
                    String k2 = k();
                    ItemDetail detail3 = recommendInfo2.getDetail();
                    xh.a.i(aVar2, k2 + " --> getPsLinkAdPlan() --> name = " + (detail3 != null ? detail3.getName() : null) + " --> 数据库 不存在 --> 直接保存", 0, false, 6, null);
                }
                PSReportUtil.a.c(PSReportUtil.PSRequestState.REQUEST_SUCCESS, recommendInfo2, str4, str3);
                return psLinkAdPlan;
            }
        }
        psDistributeRequestManager$getPsLinkAdPlan$1 = new PsDistributeRequestManager$getPsLinkAdPlan$1(this, continuation);
        PsDistributeRequestManager$getPsLinkAdPlan$1 psDistributeRequestManager$getPsLinkAdPlan$122 = psDistributeRequestManager$getPsLinkAdPlan$1;
        Object obj2 = psDistributeRequestManager$getPsLinkAdPlan$122.result;
        Object f2 = IntrinsicsKt.f();
        i = psDistributeRequestManager$getPsLinkAdPlan$122.label;
        if (i != 0) {
        }
        psLinkAdPlan2 = (PsLinkAdPlan) obj2;
        if (psLinkAdPlan2 == null) {
        }
        PSReportUtil.a.c(PSReportUtil.PSRequestState.REQUEST_SUCCESS, recommendInfo2, str4, str3);
        return psLinkAdPlan;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zh.a o() {
        return (zh.a) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final zh.a p() {
        return (zh.a) kg.c.e.a().h(zh.a.class);
    }

    public final Object n(int i, int i2, Integer num, String str, Continuation continuation) {
        if (c.putIfAbsent(num, Boxing.a(true)) == null) {
            PSReportUtil.a.d(PSReportUtil.PSRequestState.REQUEST_TRIGGER, null, null, String.valueOf(num), PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_AD_PLAN.getValue());
            Object g = i.g(y0.b(), new PsDistributeRequestManager$getPsLinkListBySlot$2(i, i2, num, str, null), continuation);
            return g == IntrinsicsKt.f() ? g : Unit.a;
        }
        if (f.a.a()) {
            xh.a.i(xh.a.a, k() + " --> getPsLinkListBySlot() --> psScene=" + num + " --> 正在请求中，已拦截", 5, false, 4, null);
        }
        return Unit.a;
    }
}
