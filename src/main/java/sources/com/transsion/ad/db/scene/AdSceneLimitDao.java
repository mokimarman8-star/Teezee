package com.transsion.ad.db.scene;

import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface AdSceneLimitDao {

    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object a(AdSceneLimitDao adSceneLimitDao, String str, String str2, long j, long j2, int i, Continuation continuation) {
            AdSceneLimitDao$canDisplayAd$1 adSceneLimitDao$canDisplayAd$1;
            int i2;
            AdSceneLimit adSceneLimit;
            if (continuation instanceof AdSceneLimitDao$canDisplayAd$1) {
                adSceneLimitDao$canDisplayAd$1 = (AdSceneLimitDao$canDisplayAd$1) continuation;
                int i3 = adSceneLimitDao$canDisplayAd$1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    adSceneLimitDao$canDisplayAd$1.label = i3 - Integer.MIN_VALUE;
                    Object obj = adSceneLimitDao$canDisplayAd$1.result;
                    Object f = IntrinsicsKt.f();
                    i2 = adSceneLimitDao$canDisplayAd$1.label;
                    if (i2 != 0) {
                        ResultKt.b(obj);
                        adSceneLimitDao$canDisplayAd$1.L$0 = adSceneLimitDao;
                        adSceneLimitDao$canDisplayAd$1.L$1 = str2;
                        adSceneLimitDao$canDisplayAd$1.J$0 = j;
                        adSceneLimitDao$canDisplayAd$1.J$1 = j2;
                        adSceneLimitDao$canDisplayAd$1.I$0 = i;
                        adSceneLimitDao$canDisplayAd$1.label = 1;
                        obj = adSceneLimitDao.d(str, str2, adSceneLimitDao$canDisplayAd$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            return new Pair(Boxing.a(true), "满足条件展示广告");
                        }
                        i = adSceneLimitDao$canDisplayAd$1.I$0;
                        j2 = adSceneLimitDao$canDisplayAd$1.J$1;
                        j = adSceneLimitDao$canDisplayAd$1.J$0;
                        str2 = (String) adSceneLimitDao$canDisplayAd$1.L$1;
                        adSceneLimitDao = (AdSceneLimitDao) adSceneLimitDao$canDisplayAd$1.L$0;
                        ResultKt.b(obj);
                    }
                    adSceneLimit = (AdSceneLimit) obj;
                    if (Intrinsics.c(adSceneLimit.getLastDisplayAdDate(), str2)) {
                        adSceneLimit.setLastDisplayAdDate(str2);
                        adSceneLimit.setDisplayTimes(0);
                        adSceneLimit.setLastDisplayAdTimestamp(0L);
                        adSceneLimitDao$canDisplayAd$1.L$0 = null;
                        adSceneLimitDao$canDisplayAd$1.L$1 = null;
                        adSceneLimitDao$canDisplayAd$1.label = 2;
                        if (adSceneLimitDao.f(adSceneLimit, adSceneLimitDao$canDisplayAd$1) == f) {
                            return f;
                        }
                        return new Pair(Boxing.a(true), "满足条件展示广告");
                    }
                    if (i > 0 && adSceneLimit.getDisplayTimes() >= i) {
                        return new Pair(Boxing.a(false), "超过最大展示次数，今日已展示" + adSceneLimit.getDisplayTimes() + ",限制为" + i);
                    }
                    if (j2 > 0) {
                        long lastDisplayAdTimestamp = j - adSceneLimit.getLastDisplayAdTimestamp();
                        if (0 <= lastDisplayAdTimestamp && lastDisplayAdTimestamp < j2) {
                            long j3 = 1000;
                            return new Pair(Boxing.a(false), "展示间隔限制，间隔为" + (lastDisplayAdTimestamp / j3) + "秒,限制为" + (j2 / j3) + "秒");
                        }
                    }
                    return new Pair(Boxing.a(true), "满足展示条件");
                }
            }
            adSceneLimitDao$canDisplayAd$1 = new AdSceneLimitDao$canDisplayAd$1(continuation);
            Object obj2 = adSceneLimitDao$canDisplayAd$1.result;
            Object f2 = IntrinsicsKt.f();
            i2 = adSceneLimitDao$canDisplayAd$1.label;
            if (i2 != 0) {
            }
            adSceneLimit = (AdSceneLimit) obj2;
            if (Intrinsics.c(adSceneLimit.getLastDisplayAdDate(), str2)) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object b(AdSceneLimitDao adSceneLimitDao, String str, String str2, Continuation continuation) {
            AdSceneLimitDao$getOrCreateSceneLimit$1 adSceneLimitDao$getOrCreateSceneLimit$1;
            int i;
            AdSceneLimit adSceneLimit;
            AdSceneLimit adSceneLimit2;
            if (continuation instanceof AdSceneLimitDao$getOrCreateSceneLimit$1) {
                adSceneLimitDao$getOrCreateSceneLimit$1 = (AdSceneLimitDao$getOrCreateSceneLimit$1) continuation;
                int i2 = adSceneLimitDao$getOrCreateSceneLimit$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    adSceneLimitDao$getOrCreateSceneLimit$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = adSceneLimitDao$getOrCreateSceneLimit$1.result;
                    Object f = IntrinsicsKt.f();
                    i = adSceneLimitDao$getOrCreateSceneLimit$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        adSceneLimitDao$getOrCreateSceneLimit$1.L$0 = adSceneLimitDao;
                        adSceneLimitDao$getOrCreateSceneLimit$1.L$1 = str;
                        adSceneLimitDao$getOrCreateSceneLimit$1.L$2 = str2;
                        adSceneLimitDao$getOrCreateSceneLimit$1.label = 1;
                        obj = adSceneLimitDao.a(str, adSceneLimitDao$getOrCreateSceneLimit$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            adSceneLimit2 = (AdSceneLimit) adSceneLimitDao$getOrCreateSceneLimit$1.L$0;
                            ResultKt.b(obj);
                            return adSceneLimit2;
                        }
                        str2 = (String) adSceneLimitDao$getOrCreateSceneLimit$1.L$2;
                        str = (String) adSceneLimitDao$getOrCreateSceneLimit$1.L$1;
                        adSceneLimitDao = (AdSceneLimitDao) adSceneLimitDao$getOrCreateSceneLimit$1.L$0;
                        ResultKt.b(obj);
                    }
                    String str3 = str;
                    String str4 = str2;
                    adSceneLimit = (AdSceneLimit) obj;
                    if (adSceneLimit == null) {
                        return adSceneLimit;
                    }
                    AdSceneLimit adSceneLimit3 = new AdSceneLimit(str3, str4, 0L, 0);
                    adSceneLimitDao$getOrCreateSceneLimit$1.L$0 = adSceneLimit3;
                    adSceneLimitDao$getOrCreateSceneLimit$1.L$1 = null;
                    adSceneLimitDao$getOrCreateSceneLimit$1.L$2 = null;
                    adSceneLimitDao$getOrCreateSceneLimit$1.label = 2;
                    if (adSceneLimitDao.e(adSceneLimit3, adSceneLimitDao$getOrCreateSceneLimit$1) == f) {
                        return f;
                    }
                    adSceneLimit2 = adSceneLimit3;
                    return adSceneLimit2;
                }
            }
            adSceneLimitDao$getOrCreateSceneLimit$1 = new AdSceneLimitDao$getOrCreateSceneLimit$1(continuation);
            Object obj2 = adSceneLimitDao$getOrCreateSceneLimit$1.result;
            Object f2 = IntrinsicsKt.f();
            i = adSceneLimitDao$getOrCreateSceneLimit$1.label;
            if (i != 0) {
            }
            String str32 = str;
            String str42 = str2;
            adSceneLimit = (AdSceneLimit) obj2;
            if (adSceneLimit == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0080 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object c(AdSceneLimitDao adSceneLimitDao, String str, String str2, long j, Continuation continuation) {
            AdSceneLimitDao$recordAdDisplayed$1 adSceneLimitDao$recordAdDisplayed$1;
            Object f;
            int i;
            AdSceneLimit adSceneLimit;
            if (continuation instanceof AdSceneLimitDao$recordAdDisplayed$1) {
                adSceneLimitDao$recordAdDisplayed$1 = (AdSceneLimitDao$recordAdDisplayed$1) continuation;
                int i2 = adSceneLimitDao$recordAdDisplayed$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    adSceneLimitDao$recordAdDisplayed$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = adSceneLimitDao$recordAdDisplayed$1.result;
                    f = IntrinsicsKt.f();
                    i = adSceneLimitDao$recordAdDisplayed$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        adSceneLimitDao$recordAdDisplayed$1.L$0 = adSceneLimitDao;
                        adSceneLimitDao$recordAdDisplayed$1.L$1 = str2;
                        adSceneLimitDao$recordAdDisplayed$1.J$0 = j;
                        adSceneLimitDao$recordAdDisplayed$1.label = 1;
                        obj = adSceneLimitDao.d(str, str2, adSceneLimitDao$recordAdDisplayed$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            return Unit.a;
                        }
                        j = adSceneLimitDao$recordAdDisplayed$1.J$0;
                        str2 = (String) adSceneLimitDao$recordAdDisplayed$1.L$1;
                        adSceneLimitDao = (AdSceneLimitDao) adSceneLimitDao$recordAdDisplayed$1.L$0;
                        ResultKt.b(obj);
                    }
                    adSceneLimit = (AdSceneLimit) obj;
                    if (Intrinsics.c(adSceneLimit.getLastDisplayAdDate(), str2)) {
                        adSceneLimit.setDisplayTimes(1);
                    } else {
                        adSceneLimit.setDisplayTimes(adSceneLimit.getDisplayTimes() + 1);
                    }
                    adSceneLimit.setLastDisplayAdDate(str2);
                    adSceneLimit.setLastDisplayAdTimestamp(j);
                    adSceneLimitDao$recordAdDisplayed$1.L$0 = null;
                    adSceneLimitDao$recordAdDisplayed$1.L$1 = null;
                    adSceneLimitDao$recordAdDisplayed$1.label = 2;
                    if (adSceneLimitDao.f(adSceneLimit, adSceneLimitDao$recordAdDisplayed$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
            }
            adSceneLimitDao$recordAdDisplayed$1 = new AdSceneLimitDao$recordAdDisplayed$1(continuation);
            Object obj2 = adSceneLimitDao$recordAdDisplayed$1.result;
            f = IntrinsicsKt.f();
            i = adSceneLimitDao$recordAdDisplayed$1.label;
            if (i != 0) {
            }
            adSceneLimit = (AdSceneLimit) obj2;
            if (Intrinsics.c(adSceneLimit.getLastDisplayAdDate(), str2)) {
            }
            adSceneLimit.setLastDisplayAdDate(str2);
            adSceneLimit.setLastDisplayAdTimestamp(j);
            adSceneLimitDao$recordAdDisplayed$1.L$0 = null;
            adSceneLimitDao$recordAdDisplayed$1.L$1 = null;
            adSceneLimitDao$recordAdDisplayed$1.label = 2;
            if (adSceneLimitDao.f(adSceneLimit, adSceneLimitDao$recordAdDisplayed$1) == f) {
            }
            return Unit.a;
        }
    }

    Object a(String str, Continuation continuation);

    Object b(String str, String str2, long j, long j2, int i, Continuation continuation);

    Object c(String str, String str2, long j, Continuation continuation);

    Object d(String str, String str2, Continuation continuation);

    Object e(AdSceneLimit adSceneLimit, Continuation continuation);

    Object f(AdSceneLimit adSceneLimit, Continuation continuation);
}
