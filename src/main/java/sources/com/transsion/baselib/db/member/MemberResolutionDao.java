package com.transsion.baselib.db.member;

import android.database.sqlite.SQLiteConstraintException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface MemberResolutionDao {

    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:24:0x00e4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object a(MemberResolutionDao memberResolutionDao, String str, int i, int i2, boolean z, Continuation continuation) {
            MemberResolutionDao$updateIsUnlockOrCreate$1 memberResolutionDao$updateIsUnlockOrCreate$1;
            int i3;
            MemberResolutionDao memberResolutionDao2;
            String str2;
            int i4;
            int i5;
            boolean z2;
            Object e;
            if (continuation instanceof MemberResolutionDao$updateIsUnlockOrCreate$1) {
                memberResolutionDao$updateIsUnlockOrCreate$1 = (MemberResolutionDao$updateIsUnlockOrCreate$1) continuation;
                int i6 = memberResolutionDao$updateIsUnlockOrCreate$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    memberResolutionDao$updateIsUnlockOrCreate$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = memberResolutionDao$updateIsUnlockOrCreate$1.result;
                    Object f = IntrinsicsKt.f();
                    i3 = memberResolutionDao$updateIsUnlockOrCreate$1.label;
                    if (i3 != 0) {
                        ResultKt.b(obj);
                        memberResolutionDao2 = memberResolutionDao;
                        memberResolutionDao$updateIsUnlockOrCreate$1.L$0 = memberResolutionDao2;
                        str2 = str;
                        memberResolutionDao$updateIsUnlockOrCreate$1.L$1 = str2;
                        i4 = i;
                        memberResolutionDao$updateIsUnlockOrCreate$1.I$0 = i4;
                        i5 = i2;
                        memberResolutionDao$updateIsUnlockOrCreate$1.I$1 = i5;
                        z2 = z;
                        memberResolutionDao$updateIsUnlockOrCreate$1.Z$0 = z2;
                        memberResolutionDao$updateIsUnlockOrCreate$1.label = 1;
                        e = memberResolutionDao.e(str, i, i2, z, memberResolutionDao$updateIsUnlockOrCreate$1);
                        if (e == f) {
                            return f;
                        }
                    } else {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                boolean z3 = memberResolutionDao$updateIsUnlockOrCreate$1.Z$0;
                                int i7 = memberResolutionDao$updateIsUnlockOrCreate$1.I$1;
                                int i8 = memberResolutionDao$updateIsUnlockOrCreate$1.I$0;
                                String str3 = (String) memberResolutionDao$updateIsUnlockOrCreate$1.L$1;
                                MemberResolutionDao memberResolutionDao3 = (MemberResolutionDao) memberResolutionDao$updateIsUnlockOrCreate$1.L$0;
                                try {
                                    ResultKt.b(obj);
                                } catch (SQLiteConstraintException unused) {
                                    z2 = z3;
                                    i5 = i7;
                                    i4 = i8;
                                    str2 = str3;
                                    memberResolutionDao2 = memberResolutionDao3;
                                    memberResolutionDao$updateIsUnlockOrCreate$1.L$0 = null;
                                    memberResolutionDao$updateIsUnlockOrCreate$1.L$1 = null;
                                    memberResolutionDao$updateIsUnlockOrCreate$1.label = 3;
                                    if (memberResolutionDao2.e(str2, i4, i5, z2, memberResolutionDao$updateIsUnlockOrCreate$1) == f) {
                                        return f;
                                    }
                                    return Unit.a;
                                }
                            } else {
                                if (i3 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj);
                            }
                            return Unit.a;
                        }
                        boolean z4 = memberResolutionDao$updateIsUnlockOrCreate$1.Z$0;
                        int i9 = memberResolutionDao$updateIsUnlockOrCreate$1.I$1;
                        int i10 = memberResolutionDao$updateIsUnlockOrCreate$1.I$0;
                        String str4 = (String) memberResolutionDao$updateIsUnlockOrCreate$1.L$1;
                        MemberResolutionDao memberResolutionDao4 = (MemberResolutionDao) memberResolutionDao$updateIsUnlockOrCreate$1.L$0;
                        ResultKt.b(obj);
                        z2 = z4;
                        i5 = i9;
                        i4 = i10;
                        str2 = str4;
                        e = obj;
                        memberResolutionDao2 = memberResolutionDao4;
                    }
                    if (((Number) e).intValue() <= 0) {
                        return Unit.a;
                    }
                    MemberResolutionBean memberResolutionBean = new MemberResolutionBean(str2, i5, i4, Boxing.a(false), Boxing.a(z2));
                    try {
                        memberResolutionDao$updateIsUnlockOrCreate$1.L$0 = memberResolutionDao2;
                        memberResolutionDao$updateIsUnlockOrCreate$1.L$1 = str2;
                        memberResolutionDao$updateIsUnlockOrCreate$1.I$0 = i4;
                        memberResolutionDao$updateIsUnlockOrCreate$1.I$1 = i5;
                        memberResolutionDao$updateIsUnlockOrCreate$1.Z$0 = z2;
                        memberResolutionDao$updateIsUnlockOrCreate$1.label = 2;
                        if (memberResolutionDao2.d(memberResolutionBean, memberResolutionDao$updateIsUnlockOrCreate$1) == f) {
                            return f;
                        }
                    } catch (SQLiteConstraintException unused2) {
                        memberResolutionDao$updateIsUnlockOrCreate$1.L$0 = null;
                        memberResolutionDao$updateIsUnlockOrCreate$1.L$1 = null;
                        memberResolutionDao$updateIsUnlockOrCreate$1.label = 3;
                        if (memberResolutionDao2.e(str2, i4, i5, z2, memberResolutionDao$updateIsUnlockOrCreate$1) == f) {
                        }
                        return Unit.a;
                    }
                    return Unit.a;
                }
            }
            memberResolutionDao$updateIsUnlockOrCreate$1 = new MemberResolutionDao$updateIsUnlockOrCreate$1(continuation);
            Object obj2 = memberResolutionDao$updateIsUnlockOrCreate$1.result;
            Object f2 = IntrinsicsKt.f();
            i3 = memberResolutionDao$updateIsUnlockOrCreate$1.label;
            if (i3 != 0) {
            }
            if (((Number) e).intValue() <= 0) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00e4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object b(MemberResolutionDao memberResolutionDao, String str, int i, int i2, boolean z, Continuation continuation) {
            MemberResolutionDao$updateVipResolutionTipOrCreate$1 memberResolutionDao$updateVipResolutionTipOrCreate$1;
            int i3;
            MemberResolutionDao memberResolutionDao2;
            String str2;
            int i4;
            int i5;
            boolean z2;
            Object c;
            if (continuation instanceof MemberResolutionDao$updateVipResolutionTipOrCreate$1) {
                memberResolutionDao$updateVipResolutionTipOrCreate$1 = (MemberResolutionDao$updateVipResolutionTipOrCreate$1) continuation;
                int i6 = memberResolutionDao$updateVipResolutionTipOrCreate$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    memberResolutionDao$updateVipResolutionTipOrCreate$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = memberResolutionDao$updateVipResolutionTipOrCreate$1.result;
                    Object f = IntrinsicsKt.f();
                    i3 = memberResolutionDao$updateVipResolutionTipOrCreate$1.label;
                    if (i3 != 0) {
                        ResultKt.b(obj);
                        memberResolutionDao2 = memberResolutionDao;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.L$0 = memberResolutionDao2;
                        str2 = str;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.L$1 = str2;
                        i4 = i;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.I$0 = i4;
                        i5 = i2;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.I$1 = i5;
                        z2 = z;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.Z$0 = z2;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.label = 1;
                        c = memberResolutionDao.c(str, i, i2, z, memberResolutionDao$updateVipResolutionTipOrCreate$1);
                        if (c == f) {
                            return f;
                        }
                    } else {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                boolean z3 = memberResolutionDao$updateVipResolutionTipOrCreate$1.Z$0;
                                int i7 = memberResolutionDao$updateVipResolutionTipOrCreate$1.I$1;
                                int i8 = memberResolutionDao$updateVipResolutionTipOrCreate$1.I$0;
                                String str3 = (String) memberResolutionDao$updateVipResolutionTipOrCreate$1.L$1;
                                MemberResolutionDao memberResolutionDao3 = (MemberResolutionDao) memberResolutionDao$updateVipResolutionTipOrCreate$1.L$0;
                                try {
                                    ResultKt.b(obj);
                                } catch (SQLiteConstraintException unused) {
                                    z2 = z3;
                                    i5 = i7;
                                    i4 = i8;
                                    str2 = str3;
                                    memberResolutionDao2 = memberResolutionDao3;
                                    memberResolutionDao$updateVipResolutionTipOrCreate$1.L$0 = null;
                                    memberResolutionDao$updateVipResolutionTipOrCreate$1.L$1 = null;
                                    memberResolutionDao$updateVipResolutionTipOrCreate$1.label = 3;
                                    if (memberResolutionDao2.c(str2, i4, i5, z2, memberResolutionDao$updateVipResolutionTipOrCreate$1) == f) {
                                        return f;
                                    }
                                    return Unit.a;
                                }
                            } else {
                                if (i3 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj);
                            }
                            return Unit.a;
                        }
                        boolean z4 = memberResolutionDao$updateVipResolutionTipOrCreate$1.Z$0;
                        int i9 = memberResolutionDao$updateVipResolutionTipOrCreate$1.I$1;
                        int i10 = memberResolutionDao$updateVipResolutionTipOrCreate$1.I$0;
                        String str4 = (String) memberResolutionDao$updateVipResolutionTipOrCreate$1.L$1;
                        MemberResolutionDao memberResolutionDao4 = (MemberResolutionDao) memberResolutionDao$updateVipResolutionTipOrCreate$1.L$0;
                        ResultKt.b(obj);
                        z2 = z4;
                        i5 = i9;
                        i4 = i10;
                        str2 = str4;
                        c = obj;
                        memberResolutionDao2 = memberResolutionDao4;
                    }
                    if (((Number) c).intValue() <= 0) {
                        return Unit.a;
                    }
                    MemberResolutionBean memberResolutionBean = new MemberResolutionBean(str2, i5, i4, Boxing.a(z2), Boxing.a(false));
                    try {
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.L$0 = memberResolutionDao2;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.L$1 = str2;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.I$0 = i4;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.I$1 = i5;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.Z$0 = z2;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.label = 2;
                        if (memberResolutionDao2.d(memberResolutionBean, memberResolutionDao$updateVipResolutionTipOrCreate$1) == f) {
                            return f;
                        }
                    } catch (SQLiteConstraintException unused2) {
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.L$0 = null;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.L$1 = null;
                        memberResolutionDao$updateVipResolutionTipOrCreate$1.label = 3;
                        if (memberResolutionDao2.c(str2, i4, i5, z2, memberResolutionDao$updateVipResolutionTipOrCreate$1) == f) {
                        }
                        return Unit.a;
                    }
                    return Unit.a;
                }
            }
            memberResolutionDao$updateVipResolutionTipOrCreate$1 = new MemberResolutionDao$updateVipResolutionTipOrCreate$1(continuation);
            Object obj2 = memberResolutionDao$updateVipResolutionTipOrCreate$1.result;
            Object f2 = IntrinsicsKt.f();
            i3 = memberResolutionDao$updateVipResolutionTipOrCreate$1.label;
            if (i3 != 0) {
            }
            if (((Number) c).intValue() <= 0) {
            }
        }
    }

    Object a(String str, int i, int i2, boolean z, Continuation continuation);

    Object b(String str, int i, int i2, Continuation continuation);

    Object c(String str, int i, int i2, boolean z, Continuation continuation);

    Object d(MemberResolutionBean memberResolutionBean, Continuation continuation);

    Object e(String str, int i, int i2, boolean z, Continuation continuation);

    Object f(String str, int i, int i2, boolean z, Continuation continuation);
}
