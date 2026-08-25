package com.transsion.ad.monopoly.intercept;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import com.transsion.gslb.BuildConfig;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class InDenyBrandHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        InDenyBrandHandler$doHandle$1 inDenyBrandHandler$doHandle$1;
        int i;
        int i2;
        String string;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof InDenyBrandHandler$doHandle$1) {
            inDenyBrandHandler$doHandle$1 = (InDenyBrandHandler$doHandle$1) continuation;
            int i3 = inDenyBrandHandler$doHandle$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                inDenyBrandHandler$doHandle$1.label = i3 - Integer.MIN_VALUE;
                Object obj = inDenyBrandHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = inDenyBrandHandler$doHandle$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    String str2 = BuildConfig.FLAVOR;
                    objectRef.element = BuildConfig.FLAVOR;
                    String[] strArr = (String[]) o.d(mbAdDbPlans != null ? mbAdDbPlans.getDenyBrand() : null, String[].class);
                    if (strArr == null || strArr.length == 0) {
                        booleanRef.element = false;
                    } else {
                        MMKV c = mg.a.a.c();
                        if (c != null && (string = c.getString("phone_brand", BuildConfig.FLAVOR)) != null) {
                            str2 = string;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            str2 = tg.b.a.d();
                        }
                        objectRef.element = str2;
                        for (String str3 : strArr) {
                            Locale locale = Locale.ROOT;
                            String lowerCase = str3.toLowerCase(locale);
                            Intrinsics.g(lowerCase, "toLowerCase(...)");
                            String lowerCase2 = ((String) objectRef.element).toLowerCase(locale);
                            Intrinsics.g(lowerCase2, "toLowerCase(...)");
                            if (!StringsKt.c0(lowerCase, lowerCase2, false, 2, (Object) null)) {
                                String lowerCase3 = ((String) objectRef.element).toLowerCase(locale);
                                Intrinsics.g(lowerCase3, "toLowerCase(...)");
                                String lowerCase4 = str3.toLowerCase(locale);
                                Intrinsics.g(lowerCase4, "toLowerCase(...)");
                                i2 = StringsKt.c0(lowerCase3, lowerCase4, false, 2, (Object) null) ? 0 : i2 + 1;
                            }
                            booleanRef.element = true;
                        }
                    }
                    if (booleanRef.element) {
                        return new AdPlansHitResponse(false, "当前手机品牌在黑名单中");
                    }
                    a c2 = c();
                    if (c2 != null) {
                        inDenyBrandHandler$doHandle$1.label = 1;
                        obj = c2.b(str, mbAdDbPlans, map, inDenyBrandHandler$doHandle$1);
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
        inDenyBrandHandler$doHandle$1 = new InDenyBrandHandler$doHandle$1(this, continuation);
        Object obj2 = inDenyBrandHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = inDenyBrandHandler$doHandle$1.label;
        if (i != 0) {
        }
        adPlansHitResponse = (AdPlansHitResponse) obj2;
        if (adPlansHitResponse != null) {
        }
        return e();
    }
}
