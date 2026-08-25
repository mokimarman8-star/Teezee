package com.transsion.ad.monopoly.intercept;

import com.blankj.utilcode.util.o;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ModelInWhitelistHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        ModelInWhitelistHandler$doHandle$1 modelInWhitelistHandler$doHandle$1;
        int i;
        AdPlansHitResponse adPlansHitResponse;
        AdPlansHitResponse adPlansHitResponse2;
        if (continuation instanceof ModelInWhitelistHandler$doHandle$1) {
            modelInWhitelistHandler$doHandle$1 = (ModelInWhitelistHandler$doHandle$1) continuation;
            int i2 = modelInWhitelistHandler$doHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                modelInWhitelistHandler$doHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = modelInWhitelistHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = modelInWhitelistHandler$doHandle$1.label;
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
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    adPlansHitResponse2 = (AdPlansHitResponse) obj;
                    if (adPlansHitResponse2 != null) {
                        return adPlansHitResponse2;
                    }
                    return e();
                }
                ResultKt.b(obj);
                String[] strArr = (String[]) o.d(mbAdDbPlans != null ? mbAdDbPlans.getModel() : null, String[].class);
                if (strArr == null || strArr.length == 0) {
                    a c = c();
                    if (c != null) {
                        modelInWhitelistHandler$doHandle$1.label = 1;
                        obj = c.b(str, mbAdDbPlans, map, modelInWhitelistHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                        adPlansHitResponse = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse != null) {
                        }
                    }
                    return e();
                }
                String l = tg.b.a.l();
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                int length = strArr.length;
                int i3 = 0;
                while (i3 < length) {
                    String str2 = strArr[i3];
                    Locale locale = Locale.ROOT;
                    String lowerCase = str2.toLowerCase(locale);
                    Intrinsics.g(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = l.toLowerCase(locale);
                    Intrinsics.g(lowerCase2, "toLowerCase(...)");
                    String[] strArr2 = strArr;
                    int i4 = length;
                    if (!StringsKt.c0(lowerCase, lowerCase2, false, 2, (Object) null)) {
                        String lowerCase3 = l.toLowerCase(locale);
                        Intrinsics.g(lowerCase3, "toLowerCase(...)");
                        String lowerCase4 = str2.toLowerCase(locale);
                        Intrinsics.g(lowerCase4, "toLowerCase(...)");
                        if (!StringsKt.c0(lowerCase3, lowerCase4, false, 2, (Object) null)) {
                            i3++;
                            length = i4;
                            strArr = strArr2;
                        }
                    }
                    booleanRef.element = true;
                    i3++;
                    length = i4;
                    strArr = strArr2;
                }
                if (!booleanRef.element) {
                    return new AdPlansHitResponse(false, "当前手机机型不在白名单中");
                }
                a c2 = c();
                if (c2 != null) {
                    modelInWhitelistHandler$doHandle$1.label = 2;
                    obj = c2.b(str, mbAdDbPlans, map, modelInWhitelistHandler$doHandle$1);
                    if (obj == f) {
                        return f;
                    }
                    adPlansHitResponse2 = (AdPlansHitResponse) obj;
                    if (adPlansHitResponse2 != null) {
                    }
                }
                return e();
            }
        }
        modelInWhitelistHandler$doHandle$1 = new ModelInWhitelistHandler$doHandle$1(this, continuation);
        Object obj2 = modelInWhitelistHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = modelInWhitelistHandler$doHandle$1.label;
        if (i == 0) {
        }
    }
}
