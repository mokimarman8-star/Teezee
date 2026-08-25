package com.transsion.baselib.db.video;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface UGCCollectionVideoGroupDao {

    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object a(UGCCollectionVideoGroupDao uGCCollectionVideoGroupDao, String str, List list, Continuation continuation) {
            UGCCollectionVideoGroupDao$addUgcVideoIds$1 uGCCollectionVideoGroupDao$addUgcVideoIds$1;
            int i;
            UGCCollectionVideoGroup uGCCollectionVideoGroup;
            if (continuation instanceof UGCCollectionVideoGroupDao$addUgcVideoIds$1) {
                uGCCollectionVideoGroupDao$addUgcVideoIds$1 = (UGCCollectionVideoGroupDao$addUgcVideoIds$1) continuation;
                int i2 = uGCCollectionVideoGroupDao$addUgcVideoIds$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    uGCCollectionVideoGroupDao$addUgcVideoIds$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = uGCCollectionVideoGroupDao$addUgcVideoIds$1.result;
                    Object f = IntrinsicsKt.f();
                    i = uGCCollectionVideoGroupDao$addUgcVideoIds$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        if (list.isEmpty()) {
                            return Unit.a;
                        }
                        uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$0 = uGCCollectionVideoGroupDao;
                        uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$1 = str;
                        uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$2 = list;
                        uGCCollectionVideoGroupDao$addUgcVideoIds$1.label = 1;
                        obj = uGCCollectionVideoGroupDao.d(str, uGCCollectionVideoGroupDao$addUgcVideoIds$1);
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
                        list = (List) uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$2;
                        str = (String) uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$1;
                        uGCCollectionVideoGroupDao = (UGCCollectionVideoGroupDao) uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$0;
                        ResultKt.b(obj);
                    }
                    uGCCollectionVideoGroup = (UGCCollectionVideoGroup) obj;
                    if (uGCCollectionVideoGroup != null) {
                        UGCCollectionVideoGroup uGCCollectionVideoGroup2 = new UGCCollectionVideoGroup(str, new ArrayList(CollectionsKt.c0(list)));
                        uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$0 = null;
                        uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$1 = null;
                        uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$2 = null;
                        uGCCollectionVideoGroupDao$addUgcVideoIds$1.label = 2;
                        if (uGCCollectionVideoGroupDao.b(uGCCollectionVideoGroup2, uGCCollectionVideoGroupDao$addUgcVideoIds$1) == f) {
                            return f;
                        }
                        return Unit.a;
                    }
                    Set W0 = CollectionsKt.W0(uGCCollectionVideoGroup.getUgcVideoIds());
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        if (!W0.contains((String) obj2)) {
                            arrayList.add(obj2);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return Unit.a;
                    }
                    ArrayList arrayList2 = new ArrayList(uGCCollectionVideoGroup.getUgcVideoIds());
                    arrayList2.addAll(arrayList);
                    UGCCollectionVideoGroup copy$default = UGCCollectionVideoGroup.copy$default(uGCCollectionVideoGroup, null, arrayList2, 1, null);
                    uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$0 = null;
                    uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$1 = null;
                    uGCCollectionVideoGroupDao$addUgcVideoIds$1.L$2 = null;
                    uGCCollectionVideoGroupDao$addUgcVideoIds$1.label = 3;
                    if (uGCCollectionVideoGroupDao.b(copy$default, uGCCollectionVideoGroupDao$addUgcVideoIds$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
            }
            uGCCollectionVideoGroupDao$addUgcVideoIds$1 = new UGCCollectionVideoGroupDao$addUgcVideoIds$1(continuation);
            Object obj3 = uGCCollectionVideoGroupDao$addUgcVideoIds$1.result;
            Object f2 = IntrinsicsKt.f();
            i = uGCCollectionVideoGroupDao$addUgcVideoIds$1.label;
            if (i != 0) {
            }
            uGCCollectionVideoGroup = (UGCCollectionVideoGroup) obj3;
            if (uGCCollectionVideoGroup != null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0049 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object b(UGCCollectionVideoGroupDao uGCCollectionVideoGroupDao, String str, Continuation continuation) {
            UGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1 uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1;
            int i;
            List list;
            Object obj;
            if (continuation instanceof UGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1) {
                uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1 = (UGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1) continuation;
                int i2 = uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1.label = i2 - Integer.MIN_VALUE;
                    Object obj2 = uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1.result;
                    Object f = IntrinsicsKt.f();
                    i = uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1.label;
                    if (i != 0) {
                        ResultKt.b(obj2);
                        uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1.L$0 = str;
                        uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1.label = 1;
                        obj2 = uGCCollectionVideoGroupDao.e(uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1);
                        if (obj2 == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str = (String) uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1.L$0;
                        ResultKt.b(obj2);
                    }
                    list = (List) obj2;
                    if (list != null) {
                        return null;
                    }
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((UGCCollectionVideoGroup) obj).getUgcVideoIds().contains(str)) {
                            break;
                        }
                    }
                    UGCCollectionVideoGroup uGCCollectionVideoGroup = (UGCCollectionVideoGroup) obj;
                    if (uGCCollectionVideoGroup != null) {
                        return uGCCollectionVideoGroup.getCollectionId();
                    }
                    return null;
                }
            }
            uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1 = new UGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1(continuation);
            Object obj22 = uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1.result;
            Object f2 = IntrinsicsKt.f();
            i = uGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1.label;
            if (i != 0) {
            }
            list = (List) obj22;
            if (list != null) {
            }
        }
    }

    Object a(String str, List list, Continuation continuation);

    Object b(UGCCollectionVideoGroup uGCCollectionVideoGroup, Continuation continuation);

    Object c(String str, Continuation continuation);

    Object d(String str, Continuation continuation);

    Object e(Continuation continuation);
}
