package com.transsion.ad.ps.attribution;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.transsion.ad.db.pslink.AttributionPoint;
import com.transsion.ad.ps.PSReportUtil;
import com.transsion.gslb.BuildConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import okhttp3.Request;
import okhttp3.Response;
import rh.f;
import wh.b;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AttributionConsumeManager extends BaseAttributionProvider {
    public static final AttributionConsumeManager c = new AttributionConsumeManager();
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static AttributionPoint e;

    private AttributionConsumeManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(Continuation continuation) {
        AttributionConsumeManager$doNetWork$1 attributionConsumeManager$doNetWork$1;
        int i;
        String str;
        if (continuation instanceof AttributionConsumeManager$doNetWork$1) {
            attributionConsumeManager$doNetWork$1 = (AttributionConsumeManager$doNetWork$1) continuation;
            int i2 = attributionConsumeManager$doNetWork$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                attributionConsumeManager$doNetWork$1.label = i2 - Integer.MIN_VALUE;
                Object obj = attributionConsumeManager$doNetWork$1.result;
                Object f = IntrinsicsKt.f();
                i = attributionConsumeManager$doNetWork$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    f fVar = f.a;
                    if (fVar.a()) {
                        xh.a aVar = xh.a.a;
                        String e2 = e();
                        AttributionPoint attributionPoint = e;
                        AttributionPoint.AttributionType type = attributionPoint != null ? attributionPoint.getType() : null;
                        AttributionPoint attributionPoint2 = e;
                        Integer d2 = attributionPoint2 != null ? Boxing.d(attributionPoint2.getId()) : null;
                        AttributionPoint attributionPoint3 = e;
                        Integer d3 = attributionPoint3 != null ? Boxing.d(attributionPoint3.getFailCount()) : null;
                        AttributionPoint attributionPoint4 = e;
                        String psId = attributionPoint4 != null ? attributionPoint4.getPsId() : null;
                        AttributionPoint attributionPoint5 = e;
                        xh.a.i(aVar, e2 + " --> consume() --> 开始归因 --> type = " + type + " --> id = " + d2 + " --> failCount = " + d3 + " --> psId = " + psId + " --> url = " + (attributionPoint5 != null ? attributionPoint5.getReportUrl() : null), 0, false, 6, null);
                    }
                    Request.Builder builder = new Request.Builder();
                    AttributionPoint attributionPoint6 = e;
                    if (attributionPoint6 == null || (str = attributionPoint6.getReportUrl()) == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    Response execute = FirebasePerfOkHttpClient.execute(b.a.d().newCall(builder.url(str).build()));
                    if (execute.isSuccessful()) {
                        if (fVar.a()) {
                            xh.a aVar2 = xh.a.a;
                            String e3 = e();
                            AttributionPoint attributionPoint7 = e;
                            AttributionPoint.AttributionType type2 = attributionPoint7 != null ? attributionPoint7.getType() : null;
                            AttributionPoint attributionPoint8 = e;
                            Integer d4 = attributionPoint8 != null ? Boxing.d(attributionPoint8.getId()) : null;
                            AttributionPoint attributionPoint9 = e;
                            String psId2 = attributionPoint9 != null ? attributionPoint9.getPsId() : null;
                            AttributionPoint attributionPoint10 = e;
                            String reportUrl = attributionPoint10 != null ? attributionPoint10.getReportUrl() : null;
                            xh.a.i(aVar2, e3 + " --> consume() --> 归因成功 --> type = " + type2 + " --> id = " + d4 + " --> psId = " + psId2 + " --> url = " + reportUrl + " --> response = " + execute.message(), 0, false, 6, null);
                        }
                        AttributionPoint attributionPoint11 = e;
                        if (attributionPoint11 != null) {
                            AttributionConsumeManager attributionConsumeManager = c;
                            attributionConsumeManager$doNetWork$1.label = 1;
                            if (attributionConsumeManager.c(attributionPoint11, attributionConsumeManager$doNetWork$1) == f) {
                                return f;
                            }
                        }
                        PSReportUtil pSReportUtil = PSReportUtil.a;
                        AttributionPoint attributionPoint12 = e;
                        if (attributionPoint12 == null) {
                        }
                        AttributionPoint attributionPoint13 = e;
                        pSReportUtil.a(r1, attributionPoint13 == null ? attributionPoint13.getPsId() : null);
                    } else {
                        xh.a aVar3 = xh.a.a;
                        String e4 = e();
                        AttributionPoint attributionPoint14 = e;
                        AttributionPoint.AttributionType type3 = attributionPoint14 != null ? attributionPoint14.getType() : null;
                        AttributionPoint attributionPoint15 = e;
                        Integer d5 = attributionPoint15 != null ? Boxing.d(attributionPoint15.getId()) : null;
                        AttributionPoint attributionPoint16 = e;
                        String psId3 = attributionPoint16 != null ? attributionPoint16.getPsId() : null;
                        AttributionPoint attributionPoint17 = e;
                        String reportUrl2 = attributionPoint17 != null ? attributionPoint17.getReportUrl() : null;
                        xh.a.i(aVar3, e4 + " --> consume() --> 归因失败 --> type = " + type3 + " --> id = " + d5 + " --> psId = " + psId3 + "--> url = " + reportUrl2 + " --> response = " + execute.message(), 0, false, 6, null);
                        AttributionPoint attributionPoint18 = e;
                        if (attributionPoint18 != null) {
                            attributionPoint18.setFailCount(attributionPoint18.getFailCount() + 1);
                            if (attributionPoint18.getFailCount() >= 5) {
                                AttributionConsumeManager attributionConsumeManager2 = c;
                                attributionConsumeManager$doNetWork$1.label = 2;
                                if (attributionConsumeManager2.c(attributionPoint18, attributionConsumeManager$doNetWork$1) == f) {
                                    return f;
                                }
                            } else {
                                AttributionConsumeManager attributionConsumeManager3 = c;
                                attributionConsumeManager$doNetWork$1.label = 3;
                                if (attributionConsumeManager3.j(attributionPoint18, attributionConsumeManager$doNetWork$1) == f) {
                                    return f;
                                }
                            }
                        }
                    }
                } else if (i == 1) {
                    ResultKt.b(obj);
                    PSReportUtil pSReportUtil2 = PSReportUtil.a;
                    AttributionPoint attributionPoint122 = e;
                    AttributionPoint.AttributionType type4 = attributionPoint122 == null ? attributionPoint122.getType() : null;
                    AttributionPoint attributionPoint132 = e;
                    pSReportUtil2.a(type4, attributionPoint132 == null ? attributionPoint132.getPsId() : null);
                } else {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                p();
                return Unit.a;
            }
        }
        attributionConsumeManager$doNetWork$1 = new AttributionConsumeManager$doNetWork$1(this, continuation);
        Object obj2 = attributionConsumeManager$doNetWork$1.result;
        Object f2 = IntrinsicsKt.f();
        i = attributionConsumeManager$doNetWork$1.label;
        if (i != 0) {
        }
        p();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        d.set(false);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object q(Continuation continuation) {
        AttributionConsumeManager$safeCall$1 attributionConsumeManager$safeCall$1;
        int i;
        AttributionPoint attributionPoint;
        if (continuation instanceof AttributionConsumeManager$safeCall$1) {
            attributionConsumeManager$safeCall$1 = (AttributionConsumeManager$safeCall$1) continuation;
            int i2 = attributionConsumeManager$safeCall$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                attributionConsumeManager$safeCall$1.label = i2 - Integer.MIN_VALUE;
                Object obj = attributionConsumeManager$safeCall$1.result;
                Object f = IntrinsicsKt.f();
                i = attributionConsumeManager$safeCall$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (l.a.e() && !d.get()) {
                        d.set(true);
                        attributionConsumeManager$safeCall$1.label = 1;
                        obj = d(attributionConsumeManager$safeCall$1);
                        if (obj == f) {
                            return f;
                        }
                    }
                    return Unit.a;
                }
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.b(obj);
                        p();
                        return Unit.a;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                ResultKt.b(obj);
                attributionPoint = (AttributionPoint) obj;
                e = attributionPoint;
                if (attributionPoint != null) {
                    d.set(false);
                    return Unit.a;
                }
                if (!TextUtils.isEmpty(attributionPoint != null ? attributionPoint.getReportUrl() : null)) {
                    attributionConsumeManager$safeCall$1.label = 3;
                    if (o(attributionConsumeManager$safeCall$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
                AttributionPoint attributionPoint2 = e;
                if (attributionPoint2 != null) {
                    AttributionConsumeManager attributionConsumeManager = c;
                    attributionConsumeManager$safeCall$1.label = 2;
                    if (attributionConsumeManager.c(attributionPoint2, attributionConsumeManager$safeCall$1) == f) {
                        return f;
                    }
                }
                p();
                return Unit.a;
            }
        }
        attributionConsumeManager$safeCall$1 = new AttributionConsumeManager$safeCall$1(this, continuation);
        Object obj2 = attributionConsumeManager$safeCall$1.result;
        Object f2 = IntrinsicsKt.f();
        i = attributionConsumeManager$safeCall$1.label;
        if (i != 0) {
        }
        attributionPoint = (AttributionPoint) obj2;
        e = attributionPoint;
        if (attributionPoint != null) {
        }
    }

    public final void n() {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new AttributionConsumeManager$consume$1(null), 3, (Object) null);
    }
}
