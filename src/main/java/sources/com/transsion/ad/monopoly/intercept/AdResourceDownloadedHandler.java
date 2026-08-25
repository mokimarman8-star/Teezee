package com.transsion.ad.monopoly.intercept;

import ci.h;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.monopoly.plan.AdPlansTransform;
import com.transsion.ad.strategy.e;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdResourceDownloadedHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        AdResourceDownloadedHandler$doHandle$1 adResourceDownloadedHandler$doHandle$1;
        int i;
        List<AdMaterialList> adMaterialList;
        String str2;
        boolean c;
        String str3;
        AdPlansHitResponse adPlansHitResponse;
        AdPlansHitResponse adPlansHitResponse2;
        AdPlansHitResponse adPlansHitResponse3;
        AdPlansHitResponse adPlansHitResponse4;
        if (continuation instanceof AdResourceDownloadedHandler$doHandle$1) {
            adResourceDownloadedHandler$doHandle$1 = (AdResourceDownloadedHandler$doHandle$1) continuation;
            int i2 = adResourceDownloadedHandler$doHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                adResourceDownloadedHandler$doHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = adResourceDownloadedHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = adResourceDownloadedHandler$doHandle$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.b(obj);
                        adPlansHitResponse = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse != null) {
                            return adPlansHitResponse;
                        }
                        return e();
                    }
                    if (i == 2) {
                        ResultKt.b(obj);
                        adPlansHitResponse2 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse2 != null) {
                            return adPlansHitResponse2;
                        }
                        return e();
                    }
                    if (i == 3) {
                        ResultKt.b(obj);
                        adPlansHitResponse3 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse3 != null) {
                            return adPlansHitResponse3;
                        }
                        return e();
                    }
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    adPlansHitResponse4 = (AdPlansHitResponse) obj;
                    if (adPlansHitResponse4 != null) {
                        return adPlansHitResponse4;
                    }
                    return e();
                }
                ResultKt.b(obj);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                AdPlanSourceManager adPlanSourceManager = AdPlanSourceManager.a;
                if (adPlanSourceManager.c(mbAdDbPlans)) {
                    a c2 = c();
                    if (c2 != null) {
                        adResourceDownloadedHandler$doHandle$1.label = 1;
                        obj = c2.b(str, mbAdDbPlans, map, adResourceDownloadedHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                        adPlansHitResponse = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse != null) {
                        }
                    }
                    return e();
                }
                if (adPlanSourceManager.h(mbAdDbPlans)) {
                    a c3 = c();
                    if (c3 != null) {
                        adResourceDownloadedHandler$doHandle$1.label = 2;
                        obj = c3.b(str, mbAdDbPlans, map, adResourceDownloadedHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                        adPlansHitResponse2 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse2 != null) {
                        }
                    }
                    return e();
                }
                if (adPlanSourceManager.e(mbAdDbPlans)) {
                    a c4 = c();
                    if (c4 != null) {
                        adResourceDownloadedHandler$doHandle$1.label = 3;
                        obj = c4.b(str, mbAdDbPlans, map, adResourceDownloadedHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                        adPlansHitResponse3 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse3 != null) {
                        }
                    }
                    return e();
                }
                AdPlans b = AdPlansTransform.a.b(mbAdDbPlans);
                if (b != null && (adMaterialList = b.getAdMaterialList()) != null) {
                    for (AdMaterialList adMaterialList2 : adMaterialList) {
                        if (Intrinsics.c(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_TEXT)) {
                            h hVar = h.a;
                            MbAdImage image = adMaterialList2.getImage();
                            if (image == null || (str3 = image.getPath()) == null) {
                                str3 = BuildConfig.FLAVOR;
                            }
                            c = hVar.c(str3);
                        } else {
                            h hVar2 = h.a;
                            MbAdVideo video = adMaterialList2.getVideo();
                            if (video == null || (str2 = video.getPath()) == null) {
                                str2 = BuildConfig.FLAVOR;
                            }
                            c = hVar2.c(str2);
                        }
                        booleanRef.element = c;
                    }
                }
                if (!booleanRef.element && AdPlanSourceManager.a.a(mbAdDbPlans)) {
                    e.a.c().putString("non_ad_plan_version", BuildConfig.FLAVOR);
                    xh.a.e(xh.a.a, null, d() + " --> hasResource() --> 用户可能手动将文件删除了，这个时候需要重新请求。 --> 包断广告版本号 重置", 0, false, 13, null);
                }
                if (!booleanRef.element) {
                    return new AdPlansHitResponse(false, "广告资源未下载完成");
                }
                a c5 = c();
                if (c5 != null) {
                    adResourceDownloadedHandler$doHandle$1.label = 4;
                    obj = c5.b(str, mbAdDbPlans, map, adResourceDownloadedHandler$doHandle$1);
                    if (obj == f) {
                        return f;
                    }
                    adPlansHitResponse4 = (AdPlansHitResponse) obj;
                    if (adPlansHitResponse4 != null) {
                    }
                }
                return e();
            }
        }
        adResourceDownloadedHandler$doHandle$1 = new AdResourceDownloadedHandler$doHandle$1(this, continuation);
        Object obj2 = adResourceDownloadedHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = adResourceDownloadedHandler$doHandle$1.label;
        if (i == 0) {
        }
    }
}
