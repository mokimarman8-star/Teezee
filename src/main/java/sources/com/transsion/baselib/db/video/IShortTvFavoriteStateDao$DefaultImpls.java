package com.transsion.baselib.db.video;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class IShortTvFavoriteStateDao$DefaultImpls {
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(IShortTvFavoriteStateDao iShortTvFavoriteStateDao, ShortTvFavoriteState shortTvFavoriteState, Continuation continuation) {
        IShortTvFavoriteStateDao$insertOrUpdate$1 iShortTvFavoriteStateDao$insertOrUpdate$1;
        Object obj;
        int i;
        if (continuation instanceof IShortTvFavoriteStateDao$insertOrUpdate$1) {
            iShortTvFavoriteStateDao$insertOrUpdate$1 = (IShortTvFavoriteStateDao$insertOrUpdate$1) continuation;
            int i2 = iShortTvFavoriteStateDao$insertOrUpdate$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                iShortTvFavoriteStateDao$insertOrUpdate$1.label = i2 - Integer.MIN_VALUE;
                obj = iShortTvFavoriteStateDao$insertOrUpdate$1.result;
                Object f = IntrinsicsKt.f();
                i = iShortTvFavoriteStateDao$insertOrUpdate$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    String subjectId = shortTvFavoriteState.getSubjectId();
                    iShortTvFavoriteStateDao$insertOrUpdate$1.L$0 = iShortTvFavoriteStateDao;
                    iShortTvFavoriteStateDao$insertOrUpdate$1.L$1 = shortTvFavoriteState;
                    iShortTvFavoriteStateDao$insertOrUpdate$1.label = 1;
                    obj = iShortTvFavoriteStateDao.a(subjectId, iShortTvFavoriteStateDao$insertOrUpdate$1);
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
                    shortTvFavoriteState = (ShortTvFavoriteState) iShortTvFavoriteStateDao$insertOrUpdate$1.L$1;
                    iShortTvFavoriteStateDao = (IShortTvFavoriteStateDao) iShortTvFavoriteStateDao$insertOrUpdate$1.L$0;
                    ResultKt.b(obj);
                }
                if (obj != null) {
                    iShortTvFavoriteStateDao$insertOrUpdate$1.L$0 = null;
                    iShortTvFavoriteStateDao$insertOrUpdate$1.L$1 = null;
                    iShortTvFavoriteStateDao$insertOrUpdate$1.label = 2;
                    if (iShortTvFavoriteStateDao.c(shortTvFavoriteState, iShortTvFavoriteStateDao$insertOrUpdate$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
                iShortTvFavoriteStateDao$insertOrUpdate$1.L$0 = null;
                iShortTvFavoriteStateDao$insertOrUpdate$1.L$1 = null;
                iShortTvFavoriteStateDao$insertOrUpdate$1.label = 3;
                if (iShortTvFavoriteStateDao.b(shortTvFavoriteState, iShortTvFavoriteStateDao$insertOrUpdate$1) == f) {
                    return f;
                }
                return Unit.a;
            }
        }
        iShortTvFavoriteStateDao$insertOrUpdate$1 = new IShortTvFavoriteStateDao$insertOrUpdate$1(continuation);
        obj = iShortTvFavoriteStateDao$insertOrUpdate$1.result;
        Object f2 = IntrinsicsKt.f();
        i = iShortTvFavoriteStateDao$insertOrUpdate$1.label;
        if (i != 0) {
        }
        if (obj != null) {
        }
    }
}
