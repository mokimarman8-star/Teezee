package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ValidTimesHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        ValidTimesHandler$doHandle$1 validTimesHandler$doHandle$1;
        Object obj;
        int i;
        String str2;
        int i2;
        Integer displayTimes;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof ValidTimesHandler$doHandle$1) {
            validTimesHandler$doHandle$1 = (ValidTimesHandler$doHandle$1) continuation;
            int i3 = validTimesHandler$doHandle$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                validTimesHandler$doHandle$1.label = i3 - Integer.MIN_VALUE;
                obj = validTimesHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = validTimesHandler$doHandle$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    int intValue = (mbAdDbPlans == null || (displayTimes = mbAdDbPlans.getDisplayTimes()) == null) ? 0 : displayTimes.intValue();
                    NonAdShowedTimesManager nonAdShowedTimesManager = NonAdShowedTimesManager.a;
                    validTimesHandler$doHandle$1.L$0 = str;
                    validTimesHandler$doHandle$1.L$1 = mbAdDbPlans;
                    validTimesHandler$doHandle$1.L$2 = map;
                    validTimesHandler$doHandle$1.I$0 = intValue;
                    validTimesHandler$doHandle$1.label = 1;
                    Object b = nonAdShowedTimesManager.b(mbAdDbPlans, validTimesHandler$doHandle$1);
                    if (b == f) {
                        return f;
                    }
                    str2 = str;
                    i2 = intValue;
                    obj = b;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        adPlansHitResponse = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse != null) {
                            return adPlansHitResponse;
                        }
                        return e();
                    }
                    i2 = validTimesHandler$doHandle$1.I$0;
                    map = (Map) validTimesHandler$doHandle$1.L$2;
                    mbAdDbPlans = (MbAdDbPlans) validTimesHandler$doHandle$1.L$1;
                    str2 = (String) validTimesHandler$doHandle$1.L$0;
                    ResultKt.b(obj);
                }
                if (((Number) obj).intValue() < i2) {
                    return new AdPlansHitResponse(false, "展示次数已经达到上限");
                }
                a c = c();
                if (c != null) {
                    validTimesHandler$doHandle$1.L$0 = null;
                    validTimesHandler$doHandle$1.L$1 = null;
                    validTimesHandler$doHandle$1.L$2 = null;
                    validTimesHandler$doHandle$1.label = 2;
                    obj = c.b(str2, mbAdDbPlans, map, validTimesHandler$doHandle$1);
                    if (obj == f) {
                        return f;
                    }
                    adPlansHitResponse = (AdPlansHitResponse) obj;
                    if (adPlansHitResponse != null) {
                    }
                }
                return e();
            }
        }
        validTimesHandler$doHandle$1 = new ValidTimesHandler$doHandle$1(this, continuation);
        obj = validTimesHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = validTimesHandler$doHandle$1.label;
        if (i != 0) {
        }
        if (((Number) obj).intValue() < i2) {
        }
    }
}
