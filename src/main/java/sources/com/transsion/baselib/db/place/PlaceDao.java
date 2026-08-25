package com.transsion.baselib.db.place;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface PlaceDao {

    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object a(PlaceDao placeDao, List list, Continuation continuation) {
            PlaceDao$insertList$1 placeDao$insertList$1;
            Object f;
            int i;
            if (continuation instanceof PlaceDao$insertList$1) {
                placeDao$insertList$1 = (PlaceDao$insertList$1) continuation;
                int i2 = placeDao$insertList$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    placeDao$insertList$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = placeDao$insertList$1.result;
                    f = IntrinsicsKt.f();
                    i = placeDao$insertList$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        placeDao$insertList$1.L$0 = placeDao;
                        placeDao$insertList$1.L$1 = list;
                        placeDao$insertList$1.label = 1;
                        if (placeDao.a(placeDao$insertList$1) == f) {
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
                        list = (List) placeDao$insertList$1.L$1;
                        placeDao = (PlaceDao) placeDao$insertList$1.L$0;
                        ResultKt.b(obj);
                    }
                    placeDao$insertList$1.L$0 = null;
                    placeDao$insertList$1.L$1 = null;
                    placeDao$insertList$1.label = 2;
                    if (placeDao.b(list, placeDao$insertList$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
            }
            placeDao$insertList$1 = new PlaceDao$insertList$1(continuation);
            Object obj2 = placeDao$insertList$1.result;
            f = IntrinsicsKt.f();
            i = placeDao$insertList$1.label;
            if (i != 0) {
            }
            placeDao$insertList$1.L$0 = null;
            placeDao$insertList$1.L$1 = null;
            placeDao$insertList$1.label = 2;
            if (placeDao.b(list, placeDao$insertList$1) == f) {
            }
            return Unit.a;
        }
    }

    Object a(Continuation continuation);

    Object b(List list, Continuation continuation);

    Object c(List list, Continuation continuation);

    Object d(Continuation continuation);
}
