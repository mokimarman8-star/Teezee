package com.transsion.ad.monopoly.intercept;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.transsion.ad.db.mcc.LocalMcc;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import com.transsion.ad.strategy.NationalInformationManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CountryInWhitelistHandler extends a {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007a -> B:10:0x0080). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(String[] strArr, String str, Continuation continuation) {
        CountryInWhitelistHandler$isCountryInWhitelist$1 countryInWhitelistHandler$isCountryInWhitelist$1;
        int i;
        ArrayList arrayList;
        int i2;
        String[] strArr2;
        int length;
        CountryInWhitelistHandler$isCountryInWhitelist$1 countryInWhitelistHandler$isCountryInWhitelist$12;
        String str2;
        String str3;
        if (continuation instanceof CountryInWhitelistHandler$isCountryInWhitelist$1) {
            countryInWhitelistHandler$isCountryInWhitelist$1 = (CountryInWhitelistHandler$isCountryInWhitelist$1) continuation;
            int i3 = countryInWhitelistHandler$isCountryInWhitelist$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                countryInWhitelistHandler$isCountryInWhitelist$1.label = i3 - Integer.MIN_VALUE;
                Object obj = countryInWhitelistHandler$isCountryInWhitelist$1.result;
                Object f = IntrinsicsKt.f();
                i = countryInWhitelistHandler$isCountryInWhitelist$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    arrayList = new ArrayList();
                    i2 = 0;
                    strArr2 = strArr;
                    length = strArr.length;
                    countryInWhitelistHandler$isCountryInWhitelist$12 = countryInWhitelistHandler$isCountryInWhitelist$1;
                    str2 = str;
                    if (i2 < length) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    length = countryInWhitelistHandler$isCountryInWhitelist$1.I$1;
                    int i4 = countryInWhitelistHandler$isCountryInWhitelist$1.I$0;
                    String[] strArr3 = (String[]) countryInWhitelistHandler$isCountryInWhitelist$1.L$2;
                    ?? r5 = (List) countryInWhitelistHandler$isCountryInWhitelist$1.L$1;
                    String str4 = (String) countryInWhitelistHandler$isCountryInWhitelist$1.L$0;
                    ResultKt.b(obj);
                    CountryInWhitelistHandler$isCountryInWhitelist$1 countryInWhitelistHandler$isCountryInWhitelist$13 = countryInWhitelistHandler$isCountryInWhitelist$1;
                    str2 = str4;
                    ArrayList arrayList2 = r5;
                    List list = (List) obj;
                    if (list != null) {
                        arrayList2.addAll(list);
                    }
                    i2 = i4 + 1;
                    strArr2 = strArr3;
                    countryInWhitelistHandler$isCountryInWhitelist$12 = countryInWhitelistHandler$isCountryInWhitelist$13;
                    arrayList = arrayList2;
                    if (i2 < length) {
                        String str5 = strArr2[i2];
                        NationalInformationManager nationalInformationManager = NationalInformationManager.a;
                        String lowerCase = str5.toLowerCase(Locale.ROOT);
                        Intrinsics.g(lowerCase, "toLowerCase(...)");
                        countryInWhitelistHandler$isCountryInWhitelist$12.L$0 = str2;
                        countryInWhitelistHandler$isCountryInWhitelist$12.L$1 = arrayList;
                        countryInWhitelistHandler$isCountryInWhitelist$12.L$2 = strArr2;
                        countryInWhitelistHandler$isCountryInWhitelist$12.I$0 = i2;
                        countryInWhitelistHandler$isCountryInWhitelist$12.I$1 = length;
                        countryInWhitelistHandler$isCountryInWhitelist$12.label = 1;
                        Object e = nationalInformationManager.e(lowerCase, countryInWhitelistHandler$isCountryInWhitelist$12);
                        if (e == f) {
                            return f;
                        }
                        CountryInWhitelistHandler$isCountryInWhitelist$1 countryInWhitelistHandler$isCountryInWhitelist$14 = countryInWhitelistHandler$isCountryInWhitelist$12;
                        strArr3 = strArr2;
                        i4 = i2;
                        obj = e;
                        arrayList2 = arrayList;
                        countryInWhitelistHandler$isCountryInWhitelist$13 = countryInWhitelistHandler$isCountryInWhitelist$14;
                        List list2 = (List) obj;
                        if (list2 != null) {
                        }
                        i2 = i4 + 1;
                        strArr2 = strArr3;
                        countryInWhitelistHandler$isCountryInWhitelist$12 = countryInWhitelistHandler$isCountryInWhitelist$13;
                        arrayList = arrayList2;
                        if (i2 < length) {
                            String d = NationalInformationManager.a.d();
                            if (TextUtils.isEmpty(d)) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    String iso = ((LocalMcc) it.next()).getIso();
                                    Locale locale = Locale.ROOT;
                                    String upperCase = iso.toUpperCase(locale);
                                    Intrinsics.g(upperCase, "toUpperCase(...)");
                                    if (str2 != null) {
                                        str3 = str2.toUpperCase(locale);
                                        Intrinsics.g(str3, "toUpperCase(...)");
                                    } else {
                                        str3 = null;
                                    }
                                    if (TextUtils.equals(upperCase, str3)) {
                                        return Boxing.a(true);
                                    }
                                }
                            } else {
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    String mcc = ((LocalMcc) it2.next()).getMcc();
                                    Locale locale2 = Locale.ROOT;
                                    String upperCase2 = mcc.toUpperCase(locale2);
                                    Intrinsics.g(upperCase2, "toUpperCase(...)");
                                    String upperCase3 = d.toUpperCase(locale2);
                                    Intrinsics.g(upperCase3, "toUpperCase(...)");
                                    if (TextUtils.equals(upperCase2, upperCase3)) {
                                        return Boxing.a(true);
                                    }
                                }
                            }
                            return Boxing.a(false);
                        }
                    }
                }
            }
        }
        countryInWhitelistHandler$isCountryInWhitelist$1 = new CountryInWhitelistHandler$isCountryInWhitelist$1(this, continuation);
        Object obj2 = countryInWhitelistHandler$isCountryInWhitelist$1.result;
        Object f2 = IntrinsicsKt.f();
        i = countryInWhitelistHandler$isCountryInWhitelist$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        CountryInWhitelistHandler$doHandle$1 countryInWhitelistHandler$doHandle$1;
        int i;
        boolean z;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof CountryInWhitelistHandler$doHandle$1) {
            countryInWhitelistHandler$doHandle$1 = (CountryInWhitelistHandler$doHandle$1) continuation;
            int i2 = countryInWhitelistHandler$doHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                countryInWhitelistHandler$doHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = countryInWhitelistHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = countryInWhitelistHandler$doHandle$1.label;
                z = true;
                if (i != 0) {
                    ResultKt.b(obj);
                    String[] strArr = (String[]) o.d(mbAdDbPlans != null ? mbAdDbPlans.getCountry() : null, String[].class);
                    if (strArr != null && strArr.length != 0) {
                        String countryCode = mbAdDbPlans != null ? mbAdDbPlans.getCountryCode() : null;
                        countryInWhitelistHandler$doHandle$1.L$0 = str;
                        countryInWhitelistHandler$doHandle$1.L$1 = mbAdDbPlans;
                        countryInWhitelistHandler$doHandle$1.L$2 = map;
                        countryInWhitelistHandler$doHandle$1.label = 1;
                        obj = h(strArr, countryCode, countryInWhitelistHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                    }
                    if (!z) {
                        return new AdPlansHitResponse(false, "当前国家不在白名单中");
                    }
                    a c = c();
                    if (c != null) {
                        countryInWhitelistHandler$doHandle$1.L$0 = null;
                        countryInWhitelistHandler$doHandle$1.L$1 = null;
                        countryInWhitelistHandler$doHandle$1.L$2 = null;
                        countryInWhitelistHandler$doHandle$1.label = 2;
                        obj = c.b(str, mbAdDbPlans, map, countryInWhitelistHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                        adPlansHitResponse = (AdPlansHitResponse) obj;
                        if (adPlansHitResponse != null) {
                        }
                    }
                    return e();
                }
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
                map = (Map) countryInWhitelistHandler$doHandle$1.L$2;
                mbAdDbPlans = (MbAdDbPlans) countryInWhitelistHandler$doHandle$1.L$1;
                str = (String) countryInWhitelistHandler$doHandle$1.L$0;
                ResultKt.b(obj);
                z = ((Boolean) obj).booleanValue();
                if (!z) {
                }
            }
        }
        countryInWhitelistHandler$doHandle$1 = new CountryInWhitelistHandler$doHandle$1(this, continuation);
        Object obj2 = countryInWhitelistHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = countryInWhitelistHandler$doHandle$1.label;
        z = true;
        if (i != 0) {
        }
        z = ((Boolean) obj2).booleanValue();
        if (!z) {
        }
    }
}
