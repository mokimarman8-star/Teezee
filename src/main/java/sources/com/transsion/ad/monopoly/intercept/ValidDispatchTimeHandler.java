package com.transsion.ad.monopoly.intercept;

import ci.p;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ValidDispatchTimeHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        ValidDispatchTimeHandler$doHandle$1 validDispatchTimeHandler$doHandle$1;
        int i;
        AdPlansHitResponse adPlansHitResponse;
        a c;
        AdPlansHitResponse adPlansHitResponse2;
        AdPlansHitResponse adPlansHitResponse3;
        String str2 = str;
        MbAdDbPlans mbAdDbPlans2 = mbAdDbPlans;
        Map map2 = map;
        if (continuation instanceof ValidDispatchTimeHandler$doHandle$1) {
            validDispatchTimeHandler$doHandle$1 = (ValidDispatchTimeHandler$doHandle$1) continuation;
            int i2 = validDispatchTimeHandler$doHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                validDispatchTimeHandler$doHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = validDispatchTimeHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = validDispatchTimeHandler$doHandle$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.b(obj);
                        adPlansHitResponse = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse != null) {
                            return adPlansHitResponse;
                        }
                        return e();
                    }
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        adPlansHitResponse3 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse3 != null) {
                            return adPlansHitResponse3;
                        }
                        return e();
                    }
                    Map map3 = (Map) validDispatchTimeHandler$doHandle$1.L$2;
                    mbAdDbPlans2 = (MbAdDbPlans) validDispatchTimeHandler$doHandle$1.L$1;
                    String str3 = (String) validDispatchTimeHandler$doHandle$1.L$0;
                    try {
                        ResultKt.b(obj);
                        adPlansHitResponse2 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse2 != null) {
                            return adPlansHitResponse2;
                        }
                        return e();
                    } catch (ParseException unused) {
                        map2 = map3;
                        str2 = str3;
                        c = c();
                        if (c != null) {
                        }
                        return e();
                    }
                }
                ResultKt.b(obj);
                long d = p.a.d();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                String dispatchTimeStart = mbAdDbPlans2 != null ? mbAdDbPlans.getDispatchTimeStart() : null;
                String dispatchTimeEnd = mbAdDbPlans2 != null ? mbAdDbPlans.getDispatchTimeEnd() : null;
                if (dispatchTimeStart == null || StringsKt.q0(dispatchTimeStart) || dispatchTimeEnd == null || StringsKt.q0(dispatchTimeEnd)) {
                    a c2 = c();
                    if (c2 != null) {
                        validDispatchTimeHandler$doHandle$1.label = 1;
                        obj = c2.b(str2, mbAdDbPlans2, map2, validDispatchTimeHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                        adPlansHitResponse = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse != null) {
                        }
                    }
                    return e();
                }
                try {
                    Calendar calendar = Calendar.getInstance();
                    Date time = calendar.getTime();
                    Calendar calendar2 = Calendar.getInstance();
                    Date parse = simpleDateFormat.parse(dispatchTimeStart);
                    if (parse == null) {
                        parse = time;
                    }
                    calendar2.setTime(parse);
                    calendar2.set(1, calendar.get(1));
                    calendar2.set(2, calendar.get(2));
                    calendar2.set(5, calendar.get(5));
                    long timeInMillis = calendar2.getTimeInMillis();
                    Calendar calendar3 = Calendar.getInstance();
                    Date parse2 = simpleDateFormat.parse(dispatchTimeEnd);
                    if (parse2 == null) {
                        parse2 = time;
                    }
                    calendar3.setTime(parse2);
                    calendar3.set(1, calendar.get(1));
                    calendar3.set(2, calendar.get(2));
                    calendar3.set(5, calendar.get(5));
                    long timeInMillis2 = calendar3.getTimeInMillis();
                    if (timeInMillis > d || d > timeInMillis2) {
                        return new AdPlansHitResponse(false, "当前不在展示时间内--时间段");
                    }
                    a c3 = c();
                    if (c3 != null) {
                        validDispatchTimeHandler$doHandle$1.L$0 = str2;
                        validDispatchTimeHandler$doHandle$1.L$1 = mbAdDbPlans2;
                        validDispatchTimeHandler$doHandle$1.L$2 = map2;
                        validDispatchTimeHandler$doHandle$1.label = 2;
                        obj = c3.b(str2, mbAdDbPlans2, map2, validDispatchTimeHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                        adPlansHitResponse2 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse2 != null) {
                        }
                    }
                    return e();
                } catch (ParseException unused2) {
                    c = c();
                    if (c != null) {
                        validDispatchTimeHandler$doHandle$1.L$0 = null;
                        validDispatchTimeHandler$doHandle$1.L$1 = null;
                        validDispatchTimeHandler$doHandle$1.L$2 = null;
                        validDispatchTimeHandler$doHandle$1.label = 3;
                        obj = c.b(str2, mbAdDbPlans2, map2, validDispatchTimeHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                        adPlansHitResponse3 = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse3 != null) {
                        }
                    }
                    return e();
                }
            }
        }
        validDispatchTimeHandler$doHandle$1 = new ValidDispatchTimeHandler$doHandle$1(this, continuation);
        Object obj2 = validDispatchTimeHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = validDispatchTimeHandler$doHandle$1.label;
        if (i == 0) {
        }
    }
}
