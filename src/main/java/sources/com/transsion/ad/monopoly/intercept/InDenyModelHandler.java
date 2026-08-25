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
public final class InDenyModelHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        InDenyModelHandler$doHandle$1 inDenyModelHandler$doHandle$1;
        int i;
        int i2;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof InDenyModelHandler$doHandle$1) {
            inDenyModelHandler$doHandle$1 = (InDenyModelHandler$doHandle$1) continuation;
            int i3 = inDenyModelHandler$doHandle$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                inDenyModelHandler$doHandle$1.label = i3 - Integer.MIN_VALUE;
                Object obj = inDenyModelHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = inDenyModelHandler$doHandle$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    String l = tg.b.a.l();
                    String[] strArr = (String[]) o.d(mbAdDbPlans != null ? mbAdDbPlans.getDenyModel() : null, String[].class);
                    if (strArr == null || strArr.length == 0) {
                        booleanRef.element = false;
                    } else {
                        for (String str2 : strArr) {
                            Locale locale = Locale.ROOT;
                            String lowerCase = str2.toLowerCase(locale);
                            Intrinsics.g(lowerCase, "toLowerCase(...)");
                            String lowerCase2 = l.toLowerCase(locale);
                            Intrinsics.g(lowerCase2, "toLowerCase(...)");
                            if (!StringsKt.c0(lowerCase, lowerCase2, false, 2, (Object) null)) {
                                String lowerCase3 = l.toLowerCase(locale);
                                Intrinsics.g(lowerCase3, "toLowerCase(...)");
                                String lowerCase4 = str2.toLowerCase(locale);
                                Intrinsics.g(lowerCase4, "toLowerCase(...)");
                                i2 = StringsKt.c0(lowerCase3, lowerCase4, false, 2, (Object) null) ? 0 : i2 + 1;
                            }
                            booleanRef.element = true;
                        }
                    }
                    if (booleanRef.element) {
                        return new AdPlansHitResponse(false, "当前手机机型在黑名单中");
                    }
                    a c = c();
                    if (c != null) {
                        inDenyModelHandler$doHandle$1.label = 1;
                        obj = c.b(str, mbAdDbPlans, map, inDenyModelHandler$doHandle$1);
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
        inDenyModelHandler$doHandle$1 = new InDenyModelHandler$doHandle$1(this, continuation);
        Object obj2 = inDenyModelHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = inDenyModelHandler$doHandle$1.label;
        if (i != 0) {
        }
        adPlansHitResponse = (AdPlansHitResponse) obj2;
        if (adPlansHitResponse != null) {
        }
        return e();
    }
}
