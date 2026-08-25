package com.transsion.ad.ps.distribute;

import android.text.TextUtils;
import ci.e;
import ci.p;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.o;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.ps.model.PSAdTypeEnum;
import com.transsion.ad.ps.model.PsLinkAdInfo;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PsOfferProvider {
    public static final PsOfferProvider a = new PsOfferProvider();

    private PsOfferProvider() {
    }

    private final void b(AdPlans adPlans, AdMaterialList adMaterialList, PsLinkAdPlan psLinkAdPlan) {
        if (psLinkAdPlan != null) {
            PsLinkAdInfo psLinkAdInfo = (PsLinkAdInfo) o.d(psLinkAdPlan.getPsLinkAdInfoStr(), PsLinkAdInfo.class);
            RecommendInfo recommendInfo = (RecommendInfo) o.d(psLinkAdPlan.getPsInfoJson(), RecommendInfo.class);
            adMaterialList.setPsLinkAdPlan(psLinkAdPlan);
            adMaterialList.setDownloadMaterialSuccess(true);
            adMaterialList.setType(AdMaterialList.NON_AD_TYPE_TEXT);
            adMaterialList.setTitle(psLinkAdInfo != null ? psLinkAdInfo.getTitle() : null);
            adMaterialList.setDesc(psLinkAdInfo != null ? psLinkAdInfo.getDesc() : null);
            adMaterialList.setPsRecommendInfo(recommendInfo);
            adMaterialList.setImage(new MbAdImage(null, psLinkAdInfo != null ? psLinkAdInfo.getUrl() : null, null, null, null, null, null, null, null, psLinkAdInfo.getPath(), null, null, 3581, null));
            adMaterialList.setButtonText(psLinkAdInfo.getButtonText());
            if (adPlans != null) {
                adPlans.setAdvertiserName(psLinkAdInfo.getAdvertiserName());
                adPlans.setAdvertiserAvatar(psLinkAdInfo.getAdvertiserAvatar());
                adPlans.setAdvertiserAvatarPath(psLinkAdInfo.getAdvertiserAvatarPath());
            }
            if (adPlans != null) {
                adPlans.setExtImage(new MbAdImage(null, adPlans.getAdvertiserAvatar(), null, null, null, null, null, null, null, adPlans.getAdvertiserAvatarPath(), null, null, 3581, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x014b -> B:13:0x0041). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(AdPlans adPlans, Continuation continuation) {
        PsOfferProvider$getAvailablePsOffer$1 psOfferProvider$getAvailablePsOffer$1;
        int i;
        String extAdSlot;
        Object f;
        int intValue;
        int i2;
        int i3;
        String str;
        PsLinkAdPlan psLinkAdPlan;
        RecommendInfo recommendInfo;
        int i4;
        int i5;
        int i6;
        String str2;
        RecommendInfo recommendInfo2;
        AdPlans adPlans2 = adPlans;
        if (continuation instanceof PsOfferProvider$getAvailablePsOffer$1) {
            psOfferProvider$getAvailablePsOffer$1 = (PsOfferProvider$getAvailablePsOffer$1) continuation;
            int i7 = psOfferProvider$getAvailablePsOffer$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                psOfferProvider$getAvailablePsOffer$1.label = i7 - Integer.MIN_VALUE;
                Object obj = psOfferProvider$getAvailablePsOffer$1.result;
                Object f2 = IntrinsicsKt.f();
                i = psOfferProvider$getAvailablePsOffer$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    extAdSlot = adPlans2 != null ? adPlans.getExtAdSlot() : null;
                    PsDbManager psDbManager = PsDbManager.a;
                    String valueOf = String.valueOf(extAdSlot);
                    psOfferProvider$getAvailablePsOffer$1.L$0 = adPlans2;
                    psOfferProvider$getAvailablePsOffer$1.L$1 = extAdSlot;
                    psOfferProvider$getAvailablePsOffer$1.label = 1;
                    f = psDbManager.f(valueOf, psOfferProvider$getAvailablePsOffer$1);
                    if (f == f2) {
                        return f2;
                    }
                } else if (i == 1) {
                    String str3 = (String) psOfferProvider$getAvailablePsOffer$1.L$1;
                    AdPlans adPlans3 = (AdPlans) psOfferProvider$getAvailablePsOffer$1.L$0;
                    ResultKt.b(obj);
                    extAdSlot = str3;
                    adPlans2 = adPlans3;
                    f = obj;
                } else if (i == 2) {
                    i5 = psOfferProvider$getAvailablePsOffer$1.I$1;
                    i4 = psOfferProvider$getAvailablePsOffer$1.I$0;
                    str2 = (String) psOfferProvider$getAvailablePsOffer$1.L$0;
                    ResultKt.b(obj);
                    psLinkAdPlan = obj;
                    if (psLinkAdPlan != null) {
                        return null;
                    }
                    psOfferProvider$getAvailablePsOffer$1.L$0 = str2;
                    psOfferProvider$getAvailablePsOffer$1.L$1 = psLinkAdPlan;
                    psOfferProvider$getAvailablePsOffer$1.L$2 = recommendInfo2;
                    psOfferProvider$getAvailablePsOffer$1.I$0 = i4;
                    psOfferProvider$getAvailablePsOffer$1.I$1 = i5;
                    psOfferProvider$getAvailablePsOffer$1.label = 3;
                    if (h(psLinkAdPlan, psOfferProvider$getAvailablePsOffer$1) != f2) {
                    }
                } else if (i == 3) {
                    i5 = psOfferProvider$getAvailablePsOffer$1.I$1;
                    i4 = psOfferProvider$getAvailablePsOffer$1.I$0;
                    recommendInfo = (RecommendInfo) psOfferProvider$getAvailablePsOffer$1.L$2;
                    psLinkAdPlan = (PsLinkAdPlan) psOfferProvider$getAvailablePsOffer$1.L$1;
                    str = (String) psOfferProvider$getAvailablePsOffer$1.L$0;
                    ResultKt.b(obj);
                    if (g(psLinkAdPlan)) {
                    }
                    i6 = i5 + 1;
                    PsDbManager psDbManager2 = PsDbManager.a;
                    String valueOf2 = String.valueOf(str);
                    psOfferProvider$getAvailablePsOffer$1.L$0 = str;
                    psOfferProvider$getAvailablePsOffer$1.L$1 = null;
                    psOfferProvider$getAvailablePsOffer$1.L$2 = null;
                    psOfferProvider$getAvailablePsOffer$1.I$0 = i4;
                    psOfferProvider$getAvailablePsOffer$1.I$1 = i6;
                    psOfferProvider$getAvailablePsOffer$1.label = 4;
                    obj = psDbManager2.f(valueOf2, psOfferProvider$getAvailablePsOffer$1);
                    if (obj == f2) {
                    }
                    i3 = i6;
                    i2 = i4;
                    intValue = ((Number) obj).intValue();
                    if (i3 > i2) {
                    }
                } else {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i6 = psOfferProvider$getAvailablePsOffer$1.I$1;
                    i4 = psOfferProvider$getAvailablePsOffer$1.I$0;
                    String str4 = (String) psOfferProvider$getAvailablePsOffer$1.L$0;
                    ResultKt.b(obj);
                    str = str4;
                    i3 = i6;
                    i2 = i4;
                    intValue = ((Number) obj).intValue();
                    if (i3 > i2) {
                        xh.a.i(xh.a.a, d() + " --> getAvailableAdPlan() --> 赶紧找开发，出现死循环了、赶紧找开发，出现死循环了、赶紧找开发，出现死循环了", 6, false, 4, null);
                        return null;
                    }
                    extAdSlot = str;
                    if (i3 < intValue) {
                        return null;
                    }
                    PsDbManager psDbManager3 = PsDbManager.a;
                    String valueOf3 = String.valueOf(extAdSlot);
                    psOfferProvider$getAvailablePsOffer$1.L$0 = extAdSlot;
                    psOfferProvider$getAvailablePsOffer$1.L$1 = null;
                    psOfferProvider$getAvailablePsOffer$1.I$0 = i2;
                    psOfferProvider$getAvailablePsOffer$1.I$1 = i3;
                    psOfferProvider$getAvailablePsOffer$1.label = 2;
                    Object h = psDbManager3.h(valueOf3, psOfferProvider$getAvailablePsOffer$1);
                    if (h == f2) {
                        return f2;
                    }
                    i4 = i2;
                    i5 = i3;
                    str2 = extAdSlot;
                    obj = h;
                    psLinkAdPlan = obj;
                    if (psLinkAdPlan != null || (recommendInfo2 = (RecommendInfo) o.d(psLinkAdPlan.getPsInfoJson(), RecommendInfo.class)) == null) {
                        return null;
                    }
                    psOfferProvider$getAvailablePsOffer$1.L$0 = str2;
                    psOfferProvider$getAvailablePsOffer$1.L$1 = psLinkAdPlan;
                    psOfferProvider$getAvailablePsOffer$1.L$2 = recommendInfo2;
                    psOfferProvider$getAvailablePsOffer$1.I$0 = i4;
                    psOfferProvider$getAvailablePsOffer$1.I$1 = i5;
                    psOfferProvider$getAvailablePsOffer$1.label = 3;
                    if (h(psLinkAdPlan, psOfferProvider$getAvailablePsOffer$1) != f2) {
                        return f2;
                    }
                    str = str2;
                    recommendInfo = recommendInfo2;
                    if (g(psLinkAdPlan)) {
                        Integer adType = recommendInfo.getAdType();
                        int value = PSAdTypeEnum.PS_AD_TYPE_USER_ACQUISITION_0.getValue();
                        if (adType != null && adType.intValue() == value) {
                            return psLinkAdPlan;
                        }
                        int value2 = PSAdTypeEnum.PS_AD_TYPE_USER_RETENTION_1.getValue();
                        if (adType == null || adType.intValue() != value2) {
                            return null;
                        }
                        if (e.a.a(Utils.a(), recommendInfo.getPackageName())) {
                            return psLinkAdPlan;
                        }
                    }
                    i6 = i5 + 1;
                    PsDbManager psDbManager22 = PsDbManager.a;
                    String valueOf22 = String.valueOf(str);
                    psOfferProvider$getAvailablePsOffer$1.L$0 = str;
                    psOfferProvider$getAvailablePsOffer$1.L$1 = null;
                    psOfferProvider$getAvailablePsOffer$1.L$2 = null;
                    psOfferProvider$getAvailablePsOffer$1.I$0 = i4;
                    psOfferProvider$getAvailablePsOffer$1.I$1 = i6;
                    psOfferProvider$getAvailablePsOffer$1.label = 4;
                    obj = psDbManager22.f(valueOf22, psOfferProvider$getAvailablePsOffer$1);
                    if (obj == f2) {
                        return f2;
                    }
                    i3 = i6;
                    i2 = i4;
                    intValue = ((Number) obj).intValue();
                    if (i3 > i2) {
                    }
                }
                intValue = ((Number) f).intValue();
                if (intValue != 0) {
                    PsAdPlanRetryManager.a.b(adPlans2);
                    return null;
                }
                i2 = 100;
                i3 = 0;
                if (i3 < intValue) {
                }
            }
        }
        psOfferProvider$getAvailablePsOffer$1 = new PsOfferProvider$getAvailablePsOffer$1(this, continuation);
        Object obj2 = psOfferProvider$getAvailablePsOffer$1.result;
        Object f22 = IntrinsicsKt.f();
        i = psOfferProvider$getAvailablePsOffer$1.label;
        if (i != 0) {
        }
        intValue = ((Number) f).intValue();
        if (intValue != 0) {
        }
    }

    private final String d() {
        String simpleName = PsOfferProvider.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final boolean f(String str) {
        try {
            Result.Companion companion = Result.Companion;
            if (str != null && !StringsKt.q0(str)) {
                List S0 = StringsKt.S0(str, new String[]{","}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList();
                Iterator it = S0.iterator();
                while (it.hasNext()) {
                    Integer v = StringsKt.v(StringsKt.n1((String) it.next()).toString());
                    if (v != null) {
                        arrayList.add(v);
                    }
                }
                return CollectionsKt.W0(arrayList).contains(Integer.valueOf(Calendar.getInstance().get(11)));
            }
            return true;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Object obj = Result.constructor-impl(ResultKt.a(th2));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = Boolean.FALSE;
            }
            return ((Boolean) obj).booleanValue();
        }
    }

    private final boolean g(PsLinkAdPlan psLinkAdPlan) {
        Integer showMax = psLinkAdPlan.getShowMax();
        if (showMax == null || showMax.intValue() != 0) {
            int showedTimes = psLinkAdPlan.getShowedTimes();
            Integer showMax2 = psLinkAdPlan.getShowMax();
            if (showedTimes >= (showMax2 != null ? showMax2.intValue() : 0)) {
                xh.a.i(xh.a.a, d() + " --> isTimesAvailable() --> 不符合展示条件 --> id = " + psLinkAdPlan.getId() + " --> showedTimes = " + psLinkAdPlan.getShowedTimes() + " --> showMax = " + psLinkAdPlan.getShowMax(), 5, false, 4, null);
                return false;
            }
        }
        Integer clickMax = psLinkAdPlan.getClickMax();
        if (clickMax == null || clickMax.intValue() != 0) {
            int clickedTimes = psLinkAdPlan.getClickedTimes();
            Integer clickMax2 = psLinkAdPlan.getClickMax();
            if (clickedTimes >= (clickMax2 != null ? clickMax2.intValue() : 0)) {
                xh.a.i(xh.a.a, d() + " --> isTimesAvailable() --> 不符合展示条件 --> id = " + psLinkAdPlan.getId() + " --> clickedTimes = " + psLinkAdPlan.getClickedTimes() + " --> clickMax = " + psLinkAdPlan.getClickMax(), 5, false, 4, null);
                return false;
            }
        }
        if (f(psLinkAdPlan.getShowHours())) {
            return true;
        }
        int i = Calendar.getInstance().get(11);
        xh.a.i(xh.a.a, d() + " --> isTimesAvailable() --> 不符合展示条件 --> id = " + psLinkAdPlan.getId() + " --> showHours = " + psLinkAdPlan.getShowHours() + " --> currentHour = " + i, 5, false, 4, null);
        return false;
    }

    private final Object h(PsLinkAdPlan psLinkAdPlan, Continuation continuation) {
        if (!TextUtils.equals(psLinkAdPlan != null ? psLinkAdPlan.getShowDate() : null, p.a.c())) {
            if (psLinkAdPlan != null) {
                psLinkAdPlan.setShowedTimes(0);
            }
            if (psLinkAdPlan != null) {
                psLinkAdPlan.setClickedTimes(0);
            }
        }
        if (psLinkAdPlan != null) {
            psLinkAdPlan.setUpdateTimestamp(Boxing.e(System.currentTimeMillis()));
        }
        Object n = PsDbManager.a.n(psLinkAdPlan, continuation);
        return n == IntrinsicsKt.f() ? n : Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(AdPlans adPlans, Continuation continuation) {
        PsOfferProvider$getPsAdPlans$1 psOfferProvider$getPsAdPlans$1;
        int i;
        PsLinkAdPlan psLinkAdPlan;
        AdPlans adPlans2 = adPlans;
        if (continuation instanceof PsOfferProvider$getPsAdPlans$1) {
            psOfferProvider$getPsAdPlans$1 = (PsOfferProvider$getPsAdPlans$1) continuation;
            int i2 = psOfferProvider$getPsAdPlans$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                psOfferProvider$getPsAdPlans$1.label = i2 - Integer.MIN_VALUE;
                Object obj = psOfferProvider$getPsAdPlans$1.result;
                Object f = IntrinsicsKt.f();
                i = psOfferProvider$getPsAdPlans$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    psOfferProvider$getPsAdPlans$1.L$0 = adPlans2;
                    psOfferProvider$getPsAdPlans$1.label = 1;
                    obj = c(adPlans2, psOfferProvider$getPsAdPlans$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    adPlans2 = (AdPlans) psOfferProvider$getPsAdPlans$1.L$0;
                    ResultKt.b(obj);
                }
                psLinkAdPlan = (PsLinkAdPlan) obj;
                if (psLinkAdPlan != null) {
                    return Boxing.a(false);
                }
                AdMaterialList adMaterialList = new AdMaterialList(null, null, null, null, null, null, null, null, null, false, null, null, null, 8191, null);
                if (adPlans2 != null) {
                    adPlans2.setAdMaterialList(CollectionsKt.e(adMaterialList));
                }
                b(adPlans2, adMaterialList, psLinkAdPlan);
                return Boxing.a(true);
            }
        }
        psOfferProvider$getPsAdPlans$1 = new PsOfferProvider$getPsAdPlans$1(this, continuation);
        Object obj2 = psOfferProvider$getPsAdPlans$1.result;
        Object f2 = IntrinsicsKt.f();
        i = psOfferProvider$getPsAdPlans$1.label;
        if (i != 0) {
        }
        psLinkAdPlan = (PsLinkAdPlan) obj2;
        if (psLinkAdPlan != null) {
        }
    }
}
