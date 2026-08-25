package com.transsion.baselib.db.video;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface UGCVideoDetailPlayDao {

    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object a(UGCVideoDetailPlayDao uGCVideoDetailPlayDao, String str, Continuation continuation) {
            UGCVideoDetailPlayDao$getDataByUGCVideoId$1 uGCVideoDetailPlayDao$getDataByUGCVideoId$1;
            int i;
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean;
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean2;
            if (continuation instanceof UGCVideoDetailPlayDao$getDataByUGCVideoId$1) {
                uGCVideoDetailPlayDao$getDataByUGCVideoId$1 = (UGCVideoDetailPlayDao$getDataByUGCVideoId$1) continuation;
                int i2 = uGCVideoDetailPlayDao$getDataByUGCVideoId$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    uGCVideoDetailPlayDao$getDataByUGCVideoId$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = uGCVideoDetailPlayDao$getDataByUGCVideoId$1.result;
                    Object f = IntrinsicsKt.f();
                    i = uGCVideoDetailPlayDao$getDataByUGCVideoId$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        String str2 = UGCVideoDetailPlayBean.SINGLE_VIDEO_PREFIX + str;
                        uGCVideoDetailPlayDao$getDataByUGCVideoId$1.L$0 = uGCVideoDetailPlayDao;
                        uGCVideoDetailPlayDao$getDataByUGCVideoId$1.L$1 = str;
                        uGCVideoDetailPlayDao$getDataByUGCVideoId$1.label = 1;
                        obj = uGCVideoDetailPlayDao.g(str2, uGCVideoDetailPlayDao$getDataByUGCVideoId$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            uGCVideoDetailPlayBean2 = (UGCVideoDetailPlayBean) obj;
                            if (uGCVideoDetailPlayBean2 == null) {
                                return uGCVideoDetailPlayBean2.toBusinessBean();
                            }
                            return null;
                        }
                        str = (String) uGCVideoDetailPlayDao$getDataByUGCVideoId$1.L$1;
                        uGCVideoDetailPlayDao = (UGCVideoDetailPlayDao) uGCVideoDetailPlayDao$getDataByUGCVideoId$1.L$0;
                        ResultKt.b(obj);
                    }
                    uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj;
                    if (uGCVideoDetailPlayBean == null) {
                        return uGCVideoDetailPlayBean.toBusinessBean();
                    }
                    uGCVideoDetailPlayDao$getDataByUGCVideoId$1.L$0 = null;
                    uGCVideoDetailPlayDao$getDataByUGCVideoId$1.L$1 = null;
                    uGCVideoDetailPlayDao$getDataByUGCVideoId$1.label = 2;
                    obj = uGCVideoDetailPlayDao.m(str, uGCVideoDetailPlayDao$getDataByUGCVideoId$1);
                    if (obj == f) {
                        return f;
                    }
                    uGCVideoDetailPlayBean2 = (UGCVideoDetailPlayBean) obj;
                    if (uGCVideoDetailPlayBean2 == null) {
                    }
                }
            }
            uGCVideoDetailPlayDao$getDataByUGCVideoId$1 = new UGCVideoDetailPlayDao$getDataByUGCVideoId$1(continuation);
            Object obj2 = uGCVideoDetailPlayDao$getDataByUGCVideoId$1.result;
            Object f2 = IntrinsicsKt.f();
            i = uGCVideoDetailPlayDao$getDataByUGCVideoId$1.label;
            if (i != 0) {
            }
            uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj2;
            if (uGCVideoDetailPlayBean == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object b(UGCVideoDetailPlayDao uGCVideoDetailPlayDao, String str, Continuation continuation) {
            UGCVideoDetailPlayDao$getHistory$1 uGCVideoDetailPlayDao$getHistory$1;
            UGCVideoDetailPlayDao uGCVideoDetailPlayDao2;
            String str2;
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean;
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean2;
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean3;
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean4;
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean5;
            if (continuation instanceof UGCVideoDetailPlayDao$getHistory$1) {
                uGCVideoDetailPlayDao$getHistory$1 = (UGCVideoDetailPlayDao$getHistory$1) continuation;
                int i = uGCVideoDetailPlayDao$getHistory$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    uGCVideoDetailPlayDao$getHistory$1.label = i - Integer.MIN_VALUE;
                    Object obj = uGCVideoDetailPlayDao$getHistory$1.result;
                    Object f = IntrinsicsKt.f();
                    switch (uGCVideoDetailPlayDao$getHistory$1.label) {
                        case 0:
                            ResultKt.b(obj);
                            String d = ij.o.a.d();
                            if (d != null) {
                                uGCVideoDetailPlayDao$getHistory$1.L$0 = uGCVideoDetailPlayDao;
                                uGCVideoDetailPlayDao$getHistory$1.L$1 = str;
                                uGCVideoDetailPlayDao$getHistory$1.L$2 = d;
                                uGCVideoDetailPlayDao$getHistory$1.label = 1;
                                Object l = uGCVideoDetailPlayDao.l(str, d, uGCVideoDetailPlayDao$getHistory$1);
                                if (l == f) {
                                    return f;
                                }
                                uGCVideoDetailPlayDao2 = uGCVideoDetailPlayDao;
                                str2 = d;
                                obj = l;
                                uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj;
                                String str3 = str;
                                String str4 = str2;
                                uGCVideoDetailPlayBean2 = uGCVideoDetailPlayBean;
                                if (uGCVideoDetailPlayBean2 != null) {
                                    if (str4 != null) {
                                        uGCVideoDetailPlayDao$getHistory$1.L$0 = null;
                                        uGCVideoDetailPlayDao$getHistory$1.L$1 = null;
                                        uGCVideoDetailPlayDao$getHistory$1.L$2 = null;
                                        uGCVideoDetailPlayDao$getHistory$1.label = 5;
                                        obj = uGCVideoDetailPlayDao2.l(str3, str4, uGCVideoDetailPlayDao$getHistory$1);
                                        if (obj == f) {
                                            return f;
                                        }
                                        uGCVideoDetailPlayBean4 = (UGCVideoDetailPlayBean) obj;
                                        if (uGCVideoDetailPlayBean4 == null) {
                                            return uGCVideoDetailPlayBean4.toBusinessBean();
                                        }
                                        return null;
                                    }
                                    uGCVideoDetailPlayDao$getHistory$1.L$0 = null;
                                    uGCVideoDetailPlayDao$getHistory$1.L$1 = null;
                                    uGCVideoDetailPlayDao$getHistory$1.L$2 = null;
                                    uGCVideoDetailPlayDao$getHistory$1.label = 6;
                                    obj = uGCVideoDetailPlayDao2.u(str3, uGCVideoDetailPlayDao$getHistory$1);
                                    if (obj == f) {
                                        return f;
                                    }
                                    uGCVideoDetailPlayBean5 = (UGCVideoDetailPlayBean) obj;
                                    if (uGCVideoDetailPlayBean5 == null) {
                                        return uGCVideoDetailPlayBean5.toBusinessBean();
                                    }
                                    return null;
                                }
                                if (Intrinsics.c(uGCVideoDetailPlayBean2.getCollectionId(), str3)) {
                                    return uGCVideoDetailPlayBean2.toBusinessBean();
                                }
                                if (str4 != null) {
                                    uGCVideoDetailPlayDao$getHistory$1.L$0 = uGCVideoDetailPlayBean2;
                                    uGCVideoDetailPlayDao$getHistory$1.L$1 = null;
                                    uGCVideoDetailPlayDao$getHistory$1.L$2 = null;
                                    uGCVideoDetailPlayDao$getHistory$1.label = 3;
                                    obj = uGCVideoDetailPlayDao2.l(str3, str4, uGCVideoDetailPlayDao$getHistory$1);
                                    if (obj == f) {
                                        return f;
                                    }
                                    uGCVideoDetailPlayBean3 = (UGCVideoDetailPlayBean) obj;
                                    if (uGCVideoDetailPlayBean3 != null) {
                                        return null;
                                    }
                                    uGCVideoDetailPlayBean3.setProgress(uGCVideoDetailPlayBean2.getProgress());
                                    return uGCVideoDetailPlayBean3.toBusinessBean();
                                }
                                uGCVideoDetailPlayDao$getHistory$1.L$0 = uGCVideoDetailPlayBean2;
                                uGCVideoDetailPlayDao$getHistory$1.L$1 = null;
                                uGCVideoDetailPlayDao$getHistory$1.L$2 = null;
                                uGCVideoDetailPlayDao$getHistory$1.label = 4;
                                obj = uGCVideoDetailPlayDao2.u(str3, uGCVideoDetailPlayDao$getHistory$1);
                                if (obj == f) {
                                    return f;
                                }
                                uGCVideoDetailPlayBean3 = (UGCVideoDetailPlayBean) obj;
                                if (uGCVideoDetailPlayBean3 != null) {
                                }
                            } else {
                                uGCVideoDetailPlayDao$getHistory$1.L$0 = uGCVideoDetailPlayDao;
                                uGCVideoDetailPlayDao$getHistory$1.L$1 = str;
                                uGCVideoDetailPlayDao$getHistory$1.L$2 = d;
                                uGCVideoDetailPlayDao$getHistory$1.label = 2;
                                Object u = uGCVideoDetailPlayDao.u(str, uGCVideoDetailPlayDao$getHistory$1);
                                if (u == f) {
                                    return f;
                                }
                                uGCVideoDetailPlayDao2 = uGCVideoDetailPlayDao;
                                str2 = d;
                                obj = u;
                                uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj;
                                String str32 = str;
                                String str42 = str2;
                                uGCVideoDetailPlayBean2 = uGCVideoDetailPlayBean;
                                if (uGCVideoDetailPlayBean2 != null) {
                                }
                            }
                        case 1:
                            str2 = (String) uGCVideoDetailPlayDao$getHistory$1.L$2;
                            str = (String) uGCVideoDetailPlayDao$getHistory$1.L$1;
                            uGCVideoDetailPlayDao2 = (UGCVideoDetailPlayDao) uGCVideoDetailPlayDao$getHistory$1.L$0;
                            ResultKt.b(obj);
                            uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj;
                            String str322 = str;
                            String str422 = str2;
                            uGCVideoDetailPlayBean2 = uGCVideoDetailPlayBean;
                            if (uGCVideoDetailPlayBean2 != null) {
                            }
                            break;
                        case 2:
                            str2 = (String) uGCVideoDetailPlayDao$getHistory$1.L$2;
                            str = (String) uGCVideoDetailPlayDao$getHistory$1.L$1;
                            uGCVideoDetailPlayDao2 = (UGCVideoDetailPlayDao) uGCVideoDetailPlayDao$getHistory$1.L$0;
                            ResultKt.b(obj);
                            uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj;
                            String str3222 = str;
                            String str4222 = str2;
                            uGCVideoDetailPlayBean2 = uGCVideoDetailPlayBean;
                            if (uGCVideoDetailPlayBean2 != null) {
                            }
                            break;
                        case 3:
                            uGCVideoDetailPlayBean2 = (UGCVideoDetailPlayBean) uGCVideoDetailPlayDao$getHistory$1.L$0;
                            ResultKt.b(obj);
                            uGCVideoDetailPlayBean3 = (UGCVideoDetailPlayBean) obj;
                            if (uGCVideoDetailPlayBean3 != null) {
                            }
                            break;
                        case 4:
                            uGCVideoDetailPlayBean2 = (UGCVideoDetailPlayBean) uGCVideoDetailPlayDao$getHistory$1.L$0;
                            ResultKt.b(obj);
                            uGCVideoDetailPlayBean3 = (UGCVideoDetailPlayBean) obj;
                            if (uGCVideoDetailPlayBean3 != null) {
                            }
                            break;
                        case 5:
                            ResultKt.b(obj);
                            uGCVideoDetailPlayBean4 = (UGCVideoDetailPlayBean) obj;
                            if (uGCVideoDetailPlayBean4 == null) {
                            }
                            break;
                        case 6:
                            ResultKt.b(obj);
                            uGCVideoDetailPlayBean5 = (UGCVideoDetailPlayBean) obj;
                            if (uGCVideoDetailPlayBean5 == null) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            uGCVideoDetailPlayDao$getHistory$1 = new UGCVideoDetailPlayDao$getHistory$1(continuation);
            Object obj2 = uGCVideoDetailPlayDao$getHistory$1.result;
            Object f2 = IntrinsicsKt.f();
            switch (uGCVideoDetailPlayDao$getHistory$1.label) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0101 A[LOOP:0: B:20:0x00fb->B:22:0x0101, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00bb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0098 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object c(UGCVideoDetailPlayDao uGCVideoDetailPlayDao, int i, int i2, Continuation continuation) {
            UGCVideoDetailPlayDao$getHistoryDataOffset$1 uGCVideoDetailPlayDao$getHistoryDataOffset$1;
            int i3;
            String d;
            Object w;
            int i4;
            List list;
            List list2;
            Object o;
            Iterator it;
            if (continuation instanceof UGCVideoDetailPlayDao$getHistoryDataOffset$1) {
                uGCVideoDetailPlayDao$getHistoryDataOffset$1 = (UGCVideoDetailPlayDao$getHistoryDataOffset$1) continuation;
                int i5 = uGCVideoDetailPlayDao$getHistoryDataOffset$1.label;
                if ((i5 & Integer.MIN_VALUE) != 0) {
                    uGCVideoDetailPlayDao$getHistoryDataOffset$1.label = i5 - Integer.MIN_VALUE;
                    Object obj = uGCVideoDetailPlayDao$getHistoryDataOffset$1.result;
                    Object f = IntrinsicsKt.f();
                    i3 = uGCVideoDetailPlayDao$getHistoryDataOffset$1.label;
                    if (i3 != 0) {
                        ResultKt.b(obj);
                        d = ij.o.a.d();
                        if (d != null) {
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$0 = uGCVideoDetailPlayDao;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$1 = d;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$0 = i;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$1 = i2;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.label = 1;
                            w = uGCVideoDetailPlayDao.w(i, i2, d, uGCVideoDetailPlayDao$getHistoryDataOffset$1);
                            if (w == f) {
                                return f;
                            }
                            List list3 = (List) w;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$0 = list3;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$1 = null;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$0 = i2;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.label = 2;
                            obj = uGCVideoDetailPlayDao.i(i, i2, d, uGCVideoDetailPlayDao$getHistoryDataOffset$1);
                            if (obj != f) {
                            }
                        } else {
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$0 = uGCVideoDetailPlayDao;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$0 = i;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$1 = i2;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.label = 3;
                            obj = uGCVideoDetailPlayDao.f(i, i2, uGCVideoDetailPlayDao$getHistoryDataOffset$1);
                            if (obj == f) {
                                return f;
                            }
                            List list4 = (List) obj;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$0 = list4;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$0 = i2;
                            uGCVideoDetailPlayDao$getHistoryDataOffset$1.label = 4;
                            o = uGCVideoDetailPlayDao.o(i, i2, uGCVideoDetailPlayDao$getHistoryDataOffset$1);
                            if (o != f) {
                            }
                        }
                    } else if (i3 == 1) {
                        i2 = uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$1;
                        i = uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$0;
                        String str = (String) uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$1;
                        UGCVideoDetailPlayDao uGCVideoDetailPlayDao2 = (UGCVideoDetailPlayDao) uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$0;
                        ResultKt.b(obj);
                        d = str;
                        uGCVideoDetailPlayDao = uGCVideoDetailPlayDao2;
                        w = obj;
                        List list32 = (List) w;
                        uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$0 = list32;
                        uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$1 = null;
                        uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$0 = i2;
                        uGCVideoDetailPlayDao$getHistoryDataOffset$1.label = 2;
                        obj = uGCVideoDetailPlayDao.i(i, i2, d, uGCVideoDetailPlayDao$getHistoryDataOffset$1);
                        if (obj != f) {
                            return f;
                        }
                        i4 = i2;
                        list = list32;
                        list2 = (List) obj;
                    } else if (i3 == 2) {
                        i4 = uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$0;
                        list = (List) uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$0;
                        ResultKt.b(obj);
                        list2 = (List) obj;
                    } else if (i3 == 3) {
                        i2 = uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$1;
                        i = uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$0;
                        uGCVideoDetailPlayDao = (UGCVideoDetailPlayDao) uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$0;
                        ResultKt.b(obj);
                        List list42 = (List) obj;
                        uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$0 = list42;
                        uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$0 = i2;
                        uGCVideoDetailPlayDao$getHistoryDataOffset$1.label = 4;
                        o = uGCVideoDetailPlayDao.o(i, i2, uGCVideoDetailPlayDao$getHistoryDataOffset$1);
                        if (o != f) {
                            return f;
                        }
                        list = list42;
                        obj = o;
                        i4 = i2;
                        list2 = (List) obj;
                    } else {
                        if (i3 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i4 = uGCVideoDetailPlayDao$getHistoryDataOffset$1.I$0;
                        list = (List) uGCVideoDetailPlayDao$getHistoryDataOffset$1.L$0;
                        ResultKt.b(obj);
                        list2 = (List) obj;
                    }
                    if (list == null) {
                        list = CollectionsKt.l();
                    }
                    List K0 = CollectionsKt.K0(CollectionsKt.I0(CollectionsKt.B0(list, list2 == null ? list2 : CollectionsKt.l()), new Comparator() { // from class: com.transsion.baselib.db.video.UGCVideoDetailPlayDao$DefaultImpls$getHistoryDataOffset$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.d(Long.valueOf(((UGCVideoDetailPlayBean) t2).getTimeStamp()), Long.valueOf(((UGCVideoDetailPlayBean) t).getTimeStamp()));
                        }
                    }), i4);
                    ArrayList arrayList = new ArrayList(CollectionsKt.v(K0, 10));
                    it = K0.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((UGCVideoDetailPlayBean) it.next()).toBusinessBean());
                    }
                    return arrayList;
                }
            }
            uGCVideoDetailPlayDao$getHistoryDataOffset$1 = new UGCVideoDetailPlayDao$getHistoryDataOffset$1(continuation);
            Object obj2 = uGCVideoDetailPlayDao$getHistoryDataOffset$1.result;
            Object f2 = IntrinsicsKt.f();
            i3 = uGCVideoDetailPlayDao$getHistoryDataOffset$1.label;
            if (i3 != 0) {
            }
            if (list == null) {
            }
            List K02 = CollectionsKt.K0(CollectionsKt.I0(CollectionsKt.B0(list, list2 == null ? list2 : CollectionsKt.l()), new Comparator() { // from class: com.transsion.baselib.db.video.UGCVideoDetailPlayDao$DefaultImpls$getHistoryDataOffset$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.d(Long.valueOf(((UGCVideoDetailPlayBean) t2).getTimeStamp()), Long.valueOf(((UGCVideoDetailPlayBean) t).getTimeStamp()));
                }
            }), i4);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.v(K02, 10));
            it = K02.iterator();
            while (it.hasNext()) {
            }
            return arrayList2;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object d(UGCVideoDetailPlayDao uGCVideoDetailPlayDao, UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation) {
            UGCVideoDetailPlayDao$insertOrUpdate$1 uGCVideoDetailPlayDao$insertOrUpdate$1;
            Object obj;
            int i;
            if (continuation instanceof UGCVideoDetailPlayDao$insertOrUpdate$1) {
                uGCVideoDetailPlayDao$insertOrUpdate$1 = (UGCVideoDetailPlayDao$insertOrUpdate$1) continuation;
                int i2 = uGCVideoDetailPlayDao$insertOrUpdate$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    uGCVideoDetailPlayDao$insertOrUpdate$1.label = i2 - Integer.MIN_VALUE;
                    obj = uGCVideoDetailPlayDao$insertOrUpdate$1.result;
                    Object f = IntrinsicsKt.f();
                    i = uGCVideoDetailPlayDao$insertOrUpdate$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        String collectionId = uGCVideoDetailPlayBean.getCollectionId();
                        String ugcVideoId = uGCVideoDetailPlayBean.getUgcVideoId();
                        uGCVideoDetailPlayDao$insertOrUpdate$1.L$0 = uGCVideoDetailPlayDao;
                        uGCVideoDetailPlayDao$insertOrUpdate$1.L$1 = uGCVideoDetailPlayBean;
                        uGCVideoDetailPlayDao$insertOrUpdate$1.label = 1;
                        obj = uGCVideoDetailPlayDao.s(collectionId, ugcVideoId, uGCVideoDetailPlayDao$insertOrUpdate$1);
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
                        uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) uGCVideoDetailPlayDao$insertOrUpdate$1.L$1;
                        uGCVideoDetailPlayDao = (UGCVideoDetailPlayDao) uGCVideoDetailPlayDao$insertOrUpdate$1.L$0;
                        ResultKt.b(obj);
                    }
                    if (obj != null) {
                        uGCVideoDetailPlayDao$insertOrUpdate$1.L$0 = null;
                        uGCVideoDetailPlayDao$insertOrUpdate$1.L$1 = null;
                        uGCVideoDetailPlayDao$insertOrUpdate$1.label = 2;
                        if (uGCVideoDetailPlayDao.p(uGCVideoDetailPlayBean, uGCVideoDetailPlayDao$insertOrUpdate$1) == f) {
                            return f;
                        }
                        return Unit.a;
                    }
                    uGCVideoDetailPlayDao$insertOrUpdate$1.L$0 = null;
                    uGCVideoDetailPlayDao$insertOrUpdate$1.L$1 = null;
                    uGCVideoDetailPlayDao$insertOrUpdate$1.label = 3;
                    if (uGCVideoDetailPlayDao.v(uGCVideoDetailPlayBean, uGCVideoDetailPlayDao$insertOrUpdate$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
            }
            uGCVideoDetailPlayDao$insertOrUpdate$1 = new UGCVideoDetailPlayDao$insertOrUpdate$1(continuation);
            obj = uGCVideoDetailPlayDao$insertOrUpdate$1.result;
            Object f2 = IntrinsicsKt.f();
            i = uGCVideoDetailPlayDao$insertOrUpdate$1.label;
            if (i != 0) {
            }
            if (obj != null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object e(UGCVideoDetailPlayDao uGCVideoDetailPlayDao, String str, String str2, long j, long j2, Continuation continuation) {
            UGCVideoDetailPlayDao$insertOrUpdateProgress$1 uGCVideoDetailPlayDao$insertOrUpdateProgress$1;
            int i;
            String d;
            Object obj;
            UGCVideoDetailPlayDao uGCVideoDetailPlayDao2;
            Object obj2;
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean;
            String str3 = str;
            String str4 = str2;
            long j3 = j;
            long j4 = j2;
            if (continuation instanceof UGCVideoDetailPlayDao$insertOrUpdateProgress$1) {
                uGCVideoDetailPlayDao$insertOrUpdateProgress$1 = (UGCVideoDetailPlayDao$insertOrUpdateProgress$1) continuation;
                int i2 = uGCVideoDetailPlayDao$insertOrUpdateProgress$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    uGCVideoDetailPlayDao$insertOrUpdateProgress$1.label = i2 - Integer.MIN_VALUE;
                    Object obj3 = uGCVideoDetailPlayDao$insertOrUpdateProgress$1.result;
                    Object f = IntrinsicsKt.f();
                    i = uGCVideoDetailPlayDao$insertOrUpdateProgress$1.label;
                    if (i != 0) {
                        ResultKt.b(obj3);
                        d = ij.o.a.d();
                        if (d != null) {
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$0 = uGCVideoDetailPlayDao;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$1 = str3;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$2 = str4;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$3 = d;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.J$0 = j3;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.J$1 = j4;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.label = 1;
                            Object t = uGCVideoDetailPlayDao.t(str3, str4, d, uGCVideoDetailPlayDao$insertOrUpdateProgress$1);
                            if (t == f) {
                                return f;
                            }
                            obj2 = t;
                            uGCVideoDetailPlayDao2 = uGCVideoDetailPlayDao;
                            uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj2;
                        } else {
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$0 = uGCVideoDetailPlayDao;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$1 = str3;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$2 = str4;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$3 = d;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.J$0 = j3;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.J$1 = j4;
                            uGCVideoDetailPlayDao$insertOrUpdateProgress$1.label = 2;
                            Object q = uGCVideoDetailPlayDao.q(str3, str4, uGCVideoDetailPlayDao$insertOrUpdateProgress$1);
                            if (q == f) {
                                return f;
                            }
                            obj = q;
                            uGCVideoDetailPlayDao2 = uGCVideoDetailPlayDao;
                            uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj;
                        }
                    } else if (i == 1) {
                        long j5 = uGCVideoDetailPlayDao$insertOrUpdateProgress$1.J$1;
                        long j6 = uGCVideoDetailPlayDao$insertOrUpdateProgress$1.J$0;
                        String str5 = (String) uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$3;
                        String str6 = (String) uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$2;
                        String str7 = (String) uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$1;
                        uGCVideoDetailPlayDao2 = (UGCVideoDetailPlayDao) uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$0;
                        ResultKt.b(obj3);
                        obj2 = obj3;
                        d = str5;
                        j3 = j6;
                        str4 = str6;
                        str3 = str7;
                        j4 = j5;
                        uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj2;
                    } else {
                        if (i != 2) {
                            if (i == 3) {
                                ResultKt.b(obj3);
                                return Unit.a;
                            }
                            if (i != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj3);
                            return Unit.a;
                        }
                        long j7 = uGCVideoDetailPlayDao$insertOrUpdateProgress$1.J$1;
                        long j8 = uGCVideoDetailPlayDao$insertOrUpdateProgress$1.J$0;
                        String str8 = (String) uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$3;
                        String str9 = (String) uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$2;
                        String str10 = (String) uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$1;
                        uGCVideoDetailPlayDao2 = (UGCVideoDetailPlayDao) uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$0;
                        ResultKt.b(obj3);
                        obj = obj3;
                        d = str8;
                        j3 = j8;
                        str4 = str9;
                        str3 = str10;
                        j4 = j7;
                        uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) obj;
                    }
                    String str11 = str3;
                    String str12 = str4;
                    long j9 = j3;
                    String str13 = d;
                    if (uGCVideoDetailPlayBean != null) {
                        UGCVideoDetailPlayBean uGCVideoDetailPlayBean2 = new UGCVideoDetailPlayBean(str11, str12, j4, null, null, null, 0, null, null, null, null, null, j9, null, null, null, null, null, false, null, null, null, null, 0L, null, null, false, false, false, null, null, null, null, null, null, str13, -4104, 7, null);
                        uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$0 = null;
                        uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$1 = null;
                        uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$2 = null;
                        uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$3 = null;
                        uGCVideoDetailPlayDao$insertOrUpdateProgress$1.label = 3;
                        if (uGCVideoDetailPlayDao2.p(uGCVideoDetailPlayBean2, uGCVideoDetailPlayDao$insertOrUpdateProgress$1) == f) {
                            return f;
                        }
                        return Unit.a;
                    }
                    uGCVideoDetailPlayBean.setProgress(j4);
                    uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$0 = null;
                    uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$1 = null;
                    uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$2 = null;
                    uGCVideoDetailPlayDao$insertOrUpdateProgress$1.L$3 = null;
                    uGCVideoDetailPlayDao$insertOrUpdateProgress$1.label = 4;
                    if (uGCVideoDetailPlayDao2.v(uGCVideoDetailPlayBean, uGCVideoDetailPlayDao$insertOrUpdateProgress$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
            }
            uGCVideoDetailPlayDao$insertOrUpdateProgress$1 = new UGCVideoDetailPlayDao$insertOrUpdateProgress$1(continuation);
            Object obj32 = uGCVideoDetailPlayDao$insertOrUpdateProgress$1.result;
            Object f2 = IntrinsicsKt.f();
            i = uGCVideoDetailPlayDao$insertOrUpdateProgress$1.label;
            if (i != 0) {
            }
            String str112 = str3;
            String str122 = str4;
            long j92 = j3;
            String str132 = d;
            if (uGCVideoDetailPlayBean != null) {
            }
        }
    }

    Object a(Continuation continuation);

    Object b(String str, String str2, Continuation continuation);

    Object c(String str, Continuation continuation);

    Object d(int i, int i2, Continuation continuation);

    Object e(String str, String str2, long j, long j2, int i, Continuation continuation);

    Object f(int i, int i2, Continuation continuation);

    Object g(String str, Continuation continuation);

    Object h(String str, String str2, long j, Continuation continuation);

    Object i(int i, int i2, String str, Continuation continuation);

    Object j(String str, Continuation continuation);

    Object k(String str, String str2, long j, long j2, Continuation continuation);

    Object l(String str, String str2, Continuation continuation);

    Object m(String str, Continuation continuation);

    Object n(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation);

    Object o(int i, int i2, Continuation continuation);

    Object p(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation);

    Object q(String str, String str2, Continuation continuation);

    Object r(String str, Continuation continuation);

    Object s(String str, String str2, Continuation continuation);

    Object t(String str, String str2, String str3, Continuation continuation);

    Object u(String str, Continuation continuation);

    Object v(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation);

    Object w(int i, int i2, String str, Continuation continuation);
}
