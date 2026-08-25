package com.transsion.ad.monopoly.intercept;

import ci.p;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ValidTimeHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        ValidTimeHandler$doHandle$1 validTimeHandler$doHandle$1;
        int i;
        String endTime;
        String startTime;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof ValidTimeHandler$doHandle$1) {
            validTimeHandler$doHandle$1 = (ValidTimeHandler$doHandle$1) continuation;
            int i2 = validTimeHandler$doHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                validTimeHandler$doHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = validTimeHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = validTimeHandler$doHandle$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    long d = p.a.d();
                    long j = 0;
                    long parseLong = (mbAdDbPlans == null || (startTime = mbAdDbPlans.getStartTime()) == null) ? 0L : Long.parseLong(startTime);
                    if (mbAdDbPlans != null && (endTime = mbAdDbPlans.getEndTime()) != null) {
                        j = Long.parseLong(endTime);
                    }
                    if (parseLong > d || d > j) {
                        return new AdPlansHitResponse(false, "当前不在展示时间内--有效期");
                    }
                    a c = c();
                    if (c != null) {
                        validTimeHandler$doHandle$1.label = 1;
                        obj = c.b(str, mbAdDbPlans, map, validTimeHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                    }
                    return e();
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                adPlansHitResponse = (AdPlansHitResponse) obj;
                if (adPlansHitResponse != null) {
                    return adPlansHitResponse;
                }
                return e();
            }
        }
        validTimeHandler$doHandle$1 = new ValidTimeHandler$doHandle$1(this, continuation);
        Object obj2 = validTimeHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = validTimeHandler$doHandle$1.label;
        if (i != 0) {
        }
        adPlansHitResponse = (AdPlansHitResponse) obj2;
        if (adPlansHitResponse != null) {
        }
        return e();
    }
}
