package com.transsion.baselib.db.member;

import androidx.room.RoomDatabase;
import androidx.room.util.h;
import androidx.room.util.i;
import com.transsion.baselib.db.member.MemberResolutionDao;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements MemberResolutionDao {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR ABORT INTO `member_resolution` (`subjectId`,`ep`,`se`,`vipResolutionTip`,`isUnlock`) VALUES (?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, MemberResolutionBean memberResolutionBean) {
            if (memberResolutionBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, memberResolutionBean.getSubjectId());
            }
            eVar.c(2, memberResolutionBean.getEp());
            eVar.c(3, memberResolutionBean.getSe());
            if ((memberResolutionBean.getVipResolutionTip() == null ? null : Integer.valueOf(memberResolutionBean.getVipResolutionTip().booleanValue() ? 1 : 0)) == null) {
                eVar.g(4);
            } else {
                eVar.c(4, r0.intValue());
            }
            if ((memberResolutionBean.isUnlock() != null ? Integer.valueOf(memberResolutionBean.isUnlock().booleanValue() ? 1 : 0) : null) == null) {
                eVar.g(5);
            } else {
                eVar.c(5, r1.intValue());
            }
        }
    }

    public g(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List m() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit n(MemberResolutionBean memberResolutionBean, y3.b bVar) {
        this.b.d(bVar, memberResolutionBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MemberResolutionBean o(String str, int i, int i2, y3.b bVar) {
        Boolean valueOf;
        y3.e F0 = bVar.F0("\n        SELECT * FROM member_resolution\n        WHERE subjectId = ?\n          AND se = ?\n          AND ep = ?\n        LIMIT 1\n    ");
        boolean z = true;
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.c(2, i);
            F0.c(3, i2);
            int c = i.c(F0, "subjectId");
            int c2 = i.c(F0, "ep");
            int c3 = i.c(F0, "se");
            int c4 = i.c(F0, "vipResolutionTip");
            int c5 = i.c(F0, "isUnlock");
            MemberResolutionBean memberResolutionBean = null;
            Boolean valueOf2 = null;
            if (F0.C0()) {
                String q0 = F0.isNull(c) ? null : F0.q0(c);
                int i3 = (int) F0.getLong(c2);
                int i4 = (int) F0.getLong(c3);
                Integer valueOf3 = F0.isNull(c4) ? null : Integer.valueOf((int) F0.getLong(c4));
                if (valueOf3 == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(valueOf3.intValue() != 0);
                }
                Integer valueOf4 = F0.isNull(c5) ? null : Integer.valueOf((int) F0.getLong(c5));
                if (valueOf4 != null) {
                    if (valueOf4.intValue() == 0) {
                        z = false;
                    }
                    valueOf2 = Boolean.valueOf(z);
                }
                memberResolutionBean = new MemberResolutionBean(q0, i3, i4, valueOf, valueOf2);
            }
            F0.close();
            return memberResolutionBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer p(boolean z, String str, int i, int i2, y3.b bVar) {
        y3.e F0 = bVar.F0("\n        UPDATE member_resolution\n        SET isUnlock = ?\n        WHERE subjectId = ?\n          AND se = ?\n          AND ep = ?\n    ");
        try {
            F0.c(1, z ? 1L : 0L);
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            F0.c(3, i);
            F0.c(4, i2);
            F0.C0();
            Integer valueOf = Integer.valueOf(h.b(bVar));
            F0.close();
            return valueOf;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(String str, int i, int i2, boolean z, Continuation continuation) {
        return MemberResolutionDao.DefaultImpls.a(this, str, i, i2, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer r(boolean z, String str, int i, int i2, y3.b bVar) {
        y3.e F0 = bVar.F0("\n        UPDATE member_resolution\n        SET vipResolutionTip = ?\n        WHERE subjectId = ?\n          AND se = ?\n          AND ep = ?\n    ");
        try {
            F0.c(1, z ? 1L : 0L);
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            F0.c(3, i);
            F0.c(4, i2);
            F0.C0();
            Integer valueOf = Integer.valueOf(h.b(bVar));
            F0.close();
            return valueOf;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(String str, int i, int i2, boolean z, Continuation continuation) {
        return MemberResolutionDao.DefaultImpls.b(this, str, i, i2, z, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object a(final String str, final int i, final int i2, final boolean z, Continuation continuation) {
        return androidx.room.util.b.e(this.a, new Function1() { // from class: com.transsion.baselib.db.member.b
            public final Object invoke(Object obj) {
                Object s;
                s = g.this.s(str, i, i2, z, (Continuation) obj);
                return s;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object b(final String str, final int i, final int i2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.member.a
            public final Object invoke(Object obj) {
                MemberResolutionBean o;
                o = g.o(str, i, i2, (y3.b) obj);
                return o;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object c(final String str, final int i, final int i2, final boolean z, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.member.f
            public final Object invoke(Object obj) {
                Integer r;
                r = g.r(z, str, i, i2, (y3.b) obj);
                return r;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object d(final MemberResolutionBean memberResolutionBean, Continuation continuation) {
        memberResolutionBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.member.e
            public final Object invoke(Object obj) {
                Unit n;
                n = g.this.n(memberResolutionBean, (y3.b) obj);
                return n;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object e(final String str, final int i, final int i2, final boolean z, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.member.d
            public final Object invoke(Object obj) {
                Integer p;
                p = g.p(z, str, i, i2, (y3.b) obj);
                return p;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object f(final String str, final int i, final int i2, final boolean z, Continuation continuation) {
        return androidx.room.util.b.e(this.a, new Function1() { // from class: com.transsion.baselib.db.member.c
            public final Object invoke(Object obj) {
                Object q;
                q = g.this.q(str, i, i2, z, (Continuation) obj);
                return q;
            }
        }, continuation);
    }
}
