package com.transsion.shorttv.db;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface ShortTvFavoriteDao {

    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object a(ShortTvFavoriteDao shortTvFavoriteDao, ShortTvFavoriteStateBean shortTvFavoriteStateBean, Continuation continuation) {
            ShortTvFavoriteDao$insertOrUpdate$1 shortTvFavoriteDao$insertOrUpdate$1;
            Object obj;
            int i;
            if (continuation instanceof ShortTvFavoriteDao$insertOrUpdate$1) {
                shortTvFavoriteDao$insertOrUpdate$1 = (ShortTvFavoriteDao$insertOrUpdate$1) continuation;
                int i2 = shortTvFavoriteDao$insertOrUpdate$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    shortTvFavoriteDao$insertOrUpdate$1.label = i2 - Integer.MIN_VALUE;
                    obj = shortTvFavoriteDao$insertOrUpdate$1.result;
                    Object f = IntrinsicsKt.f();
                    i = shortTvFavoriteDao$insertOrUpdate$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        String subjectId = shortTvFavoriteStateBean.getSubjectId();
                        shortTvFavoriteDao$insertOrUpdate$1.L$0 = shortTvFavoriteDao;
                        shortTvFavoriteDao$insertOrUpdate$1.L$1 = shortTvFavoriteStateBean;
                        shortTvFavoriteDao$insertOrUpdate$1.label = 1;
                        obj = shortTvFavoriteDao.a(subjectId, shortTvFavoriteDao$insertOrUpdate$1);
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
                        shortTvFavoriteStateBean = (ShortTvFavoriteStateBean) shortTvFavoriteDao$insertOrUpdate$1.L$1;
                        shortTvFavoriteDao = (ShortTvFavoriteDao) shortTvFavoriteDao$insertOrUpdate$1.L$0;
                        ResultKt.b(obj);
                    }
                    if (obj != null) {
                        shortTvFavoriteDao$insertOrUpdate$1.L$0 = null;
                        shortTvFavoriteDao$insertOrUpdate$1.L$1 = null;
                        shortTvFavoriteDao$insertOrUpdate$1.label = 2;
                        if (shortTvFavoriteDao.c(shortTvFavoriteStateBean, shortTvFavoriteDao$insertOrUpdate$1) == f) {
                            return f;
                        }
                        return Unit.a;
                    }
                    shortTvFavoriteDao$insertOrUpdate$1.L$0 = null;
                    shortTvFavoriteDao$insertOrUpdate$1.L$1 = null;
                    shortTvFavoriteDao$insertOrUpdate$1.label = 3;
                    if (shortTvFavoriteDao.b(shortTvFavoriteStateBean, shortTvFavoriteDao$insertOrUpdate$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
            }
            shortTvFavoriteDao$insertOrUpdate$1 = new ShortTvFavoriteDao$insertOrUpdate$1(continuation);
            obj = shortTvFavoriteDao$insertOrUpdate$1.result;
            Object f2 = IntrinsicsKt.f();
            i = shortTvFavoriteDao$insertOrUpdate$1.label;
            if (i != 0) {
            }
            if (obj != null) {
            }
        }
    }

    Object a(String str, Continuation continuation);

    Object b(ShortTvFavoriteStateBean shortTvFavoriteStateBean, Continuation continuation);

    Object c(ShortTvFavoriteStateBean shortTvFavoriteStateBean, Continuation continuation);

    Object d(ShortTvFavoriteStateBean shortTvFavoriteStateBean, Continuation continuation);
}
