package com.transsion.baselib.db.video;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVPlayDao$DefaultImpls {
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(ShortTVPlayDao shortTVPlayDao, ShortTVPlayBean shortTVPlayBean, Continuation continuation) {
        ShortTVPlayDao$insertOrUpdate$1 shortTVPlayDao$insertOrUpdate$1;
        Object obj;
        int i;
        if (continuation instanceof ShortTVPlayDao$insertOrUpdate$1) {
            shortTVPlayDao$insertOrUpdate$1 = (ShortTVPlayDao$insertOrUpdate$1) continuation;
            int i2 = shortTVPlayDao$insertOrUpdate$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                shortTVPlayDao$insertOrUpdate$1.label = i2 - Integer.MIN_VALUE;
                obj = shortTVPlayDao$insertOrUpdate$1.result;
                Object f = IntrinsicsKt.f();
                i = shortTVPlayDao$insertOrUpdate$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    String subjectId = shortTVPlayBean.getSubjectId();
                    shortTVPlayDao$insertOrUpdate$1.L$0 = shortTVPlayDao;
                    shortTVPlayDao$insertOrUpdate$1.L$1 = shortTVPlayBean;
                    shortTVPlayDao$insertOrUpdate$1.label = 1;
                    obj = shortTVPlayDao.e(subjectId, shortTVPlayDao$insertOrUpdate$1);
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
                    shortTVPlayBean = (ShortTVPlayBean) shortTVPlayDao$insertOrUpdate$1.L$1;
                    shortTVPlayDao = (ShortTVPlayDao) shortTVPlayDao$insertOrUpdate$1.L$0;
                    ResultKt.b(obj);
                }
                if (obj != null) {
                    shortTVPlayDao$insertOrUpdate$1.L$0 = null;
                    shortTVPlayDao$insertOrUpdate$1.L$1 = null;
                    shortTVPlayDao$insertOrUpdate$1.label = 2;
                    if (shortTVPlayDao.f(shortTVPlayBean, shortTVPlayDao$insertOrUpdate$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
                shortTVPlayDao$insertOrUpdate$1.L$0 = null;
                shortTVPlayDao$insertOrUpdate$1.L$1 = null;
                shortTVPlayDao$insertOrUpdate$1.label = 3;
                if (shortTVPlayDao.i(shortTVPlayBean, shortTVPlayDao$insertOrUpdate$1) == f) {
                    return f;
                }
                return Unit.a;
            }
        }
        shortTVPlayDao$insertOrUpdate$1 = new ShortTVPlayDao$insertOrUpdate$1(continuation);
        obj = shortTVPlayDao$insertOrUpdate$1.result;
        Object f2 = IntrinsicsKt.f();
        i = shortTVPlayDao$insertOrUpdate$1.label;
        if (i != 0) {
        }
        if (obj != null) {
        }
    }
}
