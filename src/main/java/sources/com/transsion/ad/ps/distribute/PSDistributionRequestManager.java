package com.transsion.ad.ps.distribute;

import android.text.TextUtils;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.ps.PSReportUtil;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mg.b;
import okhttp3.RequestBody;
import org.json.JSONObject;
import rh.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PSDistributionRequestManager {
    public static final PSDistributionRequestManager a = new PSDistributionRequestManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.ad.ps.distribute.a
        public final Object invoke() {
            zh.a f;
            f = PSDistributionRequestManager.f();
            return f;
        }
    });

    private PSDistributionRequestManager() {
    }

    private final String b() {
        String simpleName = PSDistributionRequestManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final JSONObject c(int i, int i2, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bu", "mb");
        jSONObject.put("pageIndex", i);
        jSONObject.put("pageSize", i2);
        jSONObject.put("recommendCode", "mb_apps");
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("pushModel", str);
        }
        for (Map.Entry entry : zh.a.INSTANCE.a(System.currentTimeMillis()).entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    private final zh.a e() {
        return (zh.a) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final zh.a f() {
        return (zh.a) kg.c.e.a().h(zh.a.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0116 A[Catch: all -> 0x003c, TryCatch #2 {all -> 0x003c, blocks: (B:12:0x0037, B:13:0x00d2, B:15:0x00da, B:17:0x00e0, B:18:0x00ea, B:20:0x0104, B:22:0x010a, B:23:0x0110, B:25:0x0116, B:27:0x0124, B:30:0x012f, B:39:0x0135, B:40:0x013c), top: B:11:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0135 A[Catch: all -> 0x003c, TryCatch #2 {all -> 0x003c, blocks: (B:12:0x0037, B:13:0x00d2, B:15:0x00da, B:17:0x00e0, B:18:0x00ea, B:20:0x0104, B:22:0x010a, B:23:0x0110, B:25:0x0116, B:27:0x0124, B:30:0x012f, B:39:0x0135, B:40:0x013c), top: B:11:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(int i, int i2, String str, String str2, oh.a aVar, Continuation continuation) {
        PSDistributionRequestManager$getPsLinkListV2$1 pSDistributionRequestManager$getPsLinkListV2$1;
        int i3;
        oh.a aVar2;
        oh.a aVar3;
        String str3;
        Object obj;
        Throwable th2;
        PsLinkDto psLinkDto;
        Unit unit;
        List<RecommendInfo> data;
        List<RecommendInfo> data2;
        if (continuation instanceof PSDistributionRequestManager$getPsLinkListV2$1) {
            pSDistributionRequestManager$getPsLinkListV2$1 = (PSDistributionRequestManager$getPsLinkListV2$1) continuation;
            int i4 = pSDistributionRequestManager$getPsLinkListV2$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                pSDistributionRequestManager$getPsLinkListV2$1.label = i4 - Integer.MIN_VALUE;
                PSDistributionRequestManager$getPsLinkListV2$1 pSDistributionRequestManager$getPsLinkListV2$12 = pSDistributionRequestManager$getPsLinkListV2$1;
                Object obj2 = pSDistributionRequestManager$getPsLinkListV2$12.result;
                Object f = IntrinsicsKt.f();
                i3 = pSDistributionRequestManager$getPsLinkListV2$12.label;
                if (i3 != 0) {
                    ResultKt.b(obj2);
                    JSONObject c = c(i, i2, str2);
                    f fVar = f.a;
                    String str4 = fVar.d() ? "https://feature-api.palmplaystore.com" : "https://test-feature-api.palmplaystore.com";
                    if (fVar.a()) {
                        xh.a.g(xh.a.a, b() + " --> getPsLinkListBySlot() --> scene = " + str + " --> url = " + str4 + " --> jsonObject = " + c, 0, false, 6, null);
                    }
                    PSReportUtil.a.d(PSReportUtil.PSRequestState.REQUEST_TRIGGER, null, BuildConfig.FLAVOR, BuildConfig.FLAVOR, str);
                    try {
                        Result.Companion companion = Result.Companion;
                        zh.a e = e();
                        b.a aVar4 = mg.b.a;
                        String jSONObject = c.toString();
                        Intrinsics.g(jSONObject, "toString(...)");
                        RequestBody a2 = aVar4.a(jSONObject);
                        pSDistributionRequestManager$getPsLinkListV2$12.L$0 = str;
                        aVar2 = aVar;
                        try {
                            pSDistributionRequestManager$getPsLinkListV2$12.L$1 = aVar2;
                            pSDistributionRequestManager$getPsLinkListV2$12.label = 1;
                            obj2 = e.b(a2, str4, pSDistributionRequestManager$getPsLinkListV2$12);
                            if (obj2 == f) {
                                return f;
                            }
                            aVar3 = aVar2;
                            str3 = str;
                        } catch (Throwable th3) {
                            th = th3;
                            aVar3 = aVar2;
                            str3 = str;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.a(th));
                            th2 = Result.exceptionOrNull-impl(obj);
                            if (th2 != null) {
                            }
                            return Unit.a;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        aVar2 = aVar;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar3 = (oh.a) pSDistributionRequestManager$getPsLinkListV2$12.L$1;
                    str3 = (String) pSDistributionRequestManager$getPsLinkListV2$12.L$0;
                    try {
                        ResultKt.b(obj2);
                    } catch (Throwable th5) {
                        th = th5;
                        Result.Companion companion22 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.a(th));
                        th2 = Result.exceptionOrNull-impl(obj);
                        if (th2 != null) {
                        }
                        return Unit.a;
                    }
                }
                psLinkDto = (PsLinkDto) obj2;
                PSReportUtil.a.d(PSReportUtil.PSRequestState.REQUEST_SUCCESS, (psLinkDto != null || (data2 = psLinkDto.getData()) == null) ? null : Boxing.d(data2.size()), BuildConfig.FLAVOR, BuildConfig.FLAVOR, str3);
                ArrayList arrayList = new ArrayList();
                if (psLinkDto != null && (data = psLinkDto.getData()) != null) {
                    for (RecommendInfo recommendInfo : data) {
                        if (zh.b.a.n() || !TextUtils.isEmpty(recommendInfo.getGpLink())) {
                            arrayList.add(recommendInfo);
                        }
                    }
                }
                if (aVar3 == null) {
                    aVar3.v(arrayList);
                    unit = Unit.a;
                } else {
                    unit = null;
                }
                obj = Result.constructor-impl(unit);
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    PSReportUtil.a.d(PSReportUtil.PSRequestState.REQUEST_FAIL, null, th2.getMessage(), BuildConfig.FLAVOR, str3);
                    if (aVar3 != null) {
                        aVar3.e(new TAdErrorCode(0, String.valueOf(th2.getMessage())), (BiddingIntermediateMaterialBean) null);
                    }
                }
                return Unit.a;
            }
        }
        pSDistributionRequestManager$getPsLinkListV2$1 = new PSDistributionRequestManager$getPsLinkListV2$1(this, continuation);
        PSDistributionRequestManager$getPsLinkListV2$1 pSDistributionRequestManager$getPsLinkListV2$122 = pSDistributionRequestManager$getPsLinkListV2$1;
        Object obj22 = pSDistributionRequestManager$getPsLinkListV2$122.result;
        Object f2 = IntrinsicsKt.f();
        i3 = pSDistributionRequestManager$getPsLinkListV2$122.label;
        if (i3 != 0) {
        }
        psLinkDto = (PsLinkDto) obj22;
        PSReportUtil.a.d(PSReportUtil.PSRequestState.REQUEST_SUCCESS, (psLinkDto != null || (data2 = psLinkDto.getData()) == null) ? null : Boxing.d(data2.size()), BuildConfig.FLAVOR, BuildConfig.FLAVOR, str3);
        ArrayList arrayList2 = new ArrayList();
        if (psLinkDto != null) {
            while (r2.hasNext()) {
            }
        }
        if (aVar3 == null) {
        }
        obj = Result.constructor-impl(unit);
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
