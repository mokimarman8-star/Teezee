package com.transsion.shorttv.db;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface ShortTvAdUnlockDao {

    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object a(ShortTvAdUnlockDao shortTvAdUnlockDao, e eVar, Continuation continuation) {
            ShortTvAdUnlockDao$insertOrUpdate$1 shortTvAdUnlockDao$insertOrUpdate$1;
            Object obj;
            int i;
            if (continuation instanceof ShortTvAdUnlockDao$insertOrUpdate$1) {
                shortTvAdUnlockDao$insertOrUpdate$1 = (ShortTvAdUnlockDao$insertOrUpdate$1) continuation;
                int i2 = shortTvAdUnlockDao$insertOrUpdate$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    shortTvAdUnlockDao$insertOrUpdate$1.label = i2 - Integer.MIN_VALUE;
                    obj = shortTvAdUnlockDao$insertOrUpdate$1.result;
                    Object f = IntrinsicsKt.f();
                    i = shortTvAdUnlockDao$insertOrUpdate$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        String a = eVar.a();
                        shortTvAdUnlockDao$insertOrUpdate$1.L$0 = shortTvAdUnlockDao;
                        shortTvAdUnlockDao$insertOrUpdate$1.L$1 = eVar;
                        shortTvAdUnlockDao$insertOrUpdate$1.label = 1;
                        obj = shortTvAdUnlockDao.a(a, shortTvAdUnlockDao$insertOrUpdate$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            if (i == 2) {
                                ResultKt.b(obj);
                                return Unit.a;
                            }
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            return Unit.a;
                        }
                        eVar = (e) shortTvAdUnlockDao$insertOrUpdate$1.L$1;
                        shortTvAdUnlockDao = (ShortTvAdUnlockDao) shortTvAdUnlockDao$insertOrUpdate$1.L$0;
                        ResultKt.b(obj);
                    }
                    if (obj != null) {
                        shortTvAdUnlockDao$insertOrUpdate$1.L$0 = null;
                        shortTvAdUnlockDao$insertOrUpdate$1.L$1 = null;
                        shortTvAdUnlockDao$insertOrUpdate$1.label = 2;
                        if (shortTvAdUnlockDao.d(eVar, shortTvAdUnlockDao$insertOrUpdate$1) == f) {
                            return f;
                        }
                        return Unit.a;
                    }
                    shortTvAdUnlockDao$insertOrUpdate$1.L$0 = null;
                    shortTvAdUnlockDao$insertOrUpdate$1.L$1 = null;
                    shortTvAdUnlockDao$insertOrUpdate$1.label = 3;
                    if (shortTvAdUnlockDao.c(eVar, shortTvAdUnlockDao$insertOrUpdate$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
            }
            shortTvAdUnlockDao$insertOrUpdate$1 = new ShortTvAdUnlockDao$insertOrUpdate$1(continuation);
            obj = shortTvAdUnlockDao$insertOrUpdate$1.result;
            Object f2 = IntrinsicsKt.f();
            i = shortTvAdUnlockDao$insertOrUpdate$1.label;
            if (i != 0) {
            }
            if (obj != null) {
            }
        }
    }

    Object a(String str, Continuation continuation);

    Object b(e eVar, Continuation continuation);

    Object c(e eVar, Continuation continuation);

    Object d(e eVar, Continuation continuation);
}
