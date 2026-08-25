package vh;

import androidx.room.RoomDatabase;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class t implements l {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `ps_link_ad` (`id`,`nonId`,`adSource`,`extAdSlot`,`rank`,`psPlanId`,`psLinkAdInfoStr`,`psInfoJson`,`updateTimestamp`,`showMax`,`clickMax`,`showHours`,`showedTimes`,`clickedTimes`,`showDate`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, PsLinkAdPlan psLinkAdPlan) {
            eVar.c(1, psLinkAdPlan.getId());
            if (psLinkAdPlan.getNonId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, psLinkAdPlan.getNonId());
            }
            if (psLinkAdPlan.getAdSource() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, psLinkAdPlan.getAdSource());
            }
            if (psLinkAdPlan.getExtAdSlot() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, psLinkAdPlan.getExtAdSlot());
            }
            eVar.c(5, psLinkAdPlan.getRank());
            if (psLinkAdPlan.getPsPlanId() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, psLinkAdPlan.getPsPlanId());
            }
            if (psLinkAdPlan.getPsLinkAdInfoStr() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, psLinkAdPlan.getPsLinkAdInfoStr());
            }
            if (psLinkAdPlan.getPsInfoJson() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, psLinkAdPlan.getPsInfoJson());
            }
            if (psLinkAdPlan.getUpdateTimestamp() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, psLinkAdPlan.getUpdateTimestamp().longValue());
            }
            if (psLinkAdPlan.getShowMax() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, psLinkAdPlan.getShowMax().intValue());
            }
            if (psLinkAdPlan.getClickMax() == null) {
                eVar.g(11);
            } else {
                eVar.c(11, psLinkAdPlan.getClickMax().intValue());
            }
            if (psLinkAdPlan.getShowHours() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, psLinkAdPlan.getShowHours());
            }
            eVar.c(13, psLinkAdPlan.getShowedTimes());
            eVar.c(14, psLinkAdPlan.getClickedTimes());
            if (psLinkAdPlan.getShowDate() == null) {
                eVar.g(15);
            } else {
                eVar.i(15, psLinkAdPlan.getShowDate());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "UPDATE OR ABORT `ps_link_ad` SET `id` = ?,`nonId` = ?,`adSource` = ?,`extAdSlot` = ?,`rank` = ?,`psPlanId` = ?,`psLinkAdInfoStr` = ?,`psInfoJson` = ?,`updateTimestamp` = ?,`showMax` = ?,`clickMax` = ?,`showHours` = ?,`showedTimes` = ?,`clickedTimes` = ?,`showDate` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, PsLinkAdPlan psLinkAdPlan) {
            eVar.c(1, psLinkAdPlan.getId());
            if (psLinkAdPlan.getNonId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, psLinkAdPlan.getNonId());
            }
            if (psLinkAdPlan.getAdSource() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, psLinkAdPlan.getAdSource());
            }
            if (psLinkAdPlan.getExtAdSlot() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, psLinkAdPlan.getExtAdSlot());
            }
            eVar.c(5, psLinkAdPlan.getRank());
            if (psLinkAdPlan.getPsPlanId() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, psLinkAdPlan.getPsPlanId());
            }
            if (psLinkAdPlan.getPsLinkAdInfoStr() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, psLinkAdPlan.getPsLinkAdInfoStr());
            }
            if (psLinkAdPlan.getPsInfoJson() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, psLinkAdPlan.getPsInfoJson());
            }
            if (psLinkAdPlan.getUpdateTimestamp() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, psLinkAdPlan.getUpdateTimestamp().longValue());
            }
            if (psLinkAdPlan.getShowMax() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, psLinkAdPlan.getShowMax().intValue());
            }
            if (psLinkAdPlan.getClickMax() == null) {
                eVar.g(11);
            } else {
                eVar.c(11, psLinkAdPlan.getClickMax().intValue());
            }
            if (psLinkAdPlan.getShowHours() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, psLinkAdPlan.getShowHours());
            }
            eVar.c(13, psLinkAdPlan.getShowedTimes());
            eVar.c(14, psLinkAdPlan.getClickedTimes());
            if (psLinkAdPlan.getShowDate() == null) {
                eVar.g(15);
            } else {
                eVar.i(15, psLinkAdPlan.getShowDate());
            }
            eVar.c(16, psLinkAdPlan.getId());
        }
    }

    public t(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List o() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit p(String str, String str2, List list, y3.b bVar) {
        y3.e F0 = bVar.F0(str);
        try {
            if (str2 == null) {
                F0.g(1);
            } else {
                F0.i(1, str2);
            }
            Iterator it = list.iterator();
            int i = 2;
            while (it.hasNext()) {
                if (((Integer) it.next()) == null) {
                    F0.g(i);
                } else {
                    F0.c(i, r5.intValue());
                }
                i++;
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List q(y3.b bVar) {
        int i;
        String q0;
        int i2;
        int i3;
        Integer valueOf;
        y3.e F0 = bVar.F0("SELECT * FROM ps_link_ad");
        try {
            int c = androidx.room.util.i.c(F0, "id");
            int c2 = androidx.room.util.i.c(F0, "nonId");
            int c3 = androidx.room.util.i.c(F0, "adSource");
            int c4 = androidx.room.util.i.c(F0, "extAdSlot");
            int c5 = androidx.room.util.i.c(F0, "rank");
            int c6 = androidx.room.util.i.c(F0, "psPlanId");
            int c7 = androidx.room.util.i.c(F0, "psLinkAdInfoStr");
            int c8 = androidx.room.util.i.c(F0, "psInfoJson");
            int c9 = androidx.room.util.i.c(F0, "updateTimestamp");
            int c10 = androidx.room.util.i.c(F0, "showMax");
            int c11 = androidx.room.util.i.c(F0, "clickMax");
            int c12 = androidx.room.util.i.c(F0, "showHours");
            int c13 = androidx.room.util.i.c(F0, "showedTimes");
            int c14 = androidx.room.util.i.c(F0, "clickedTimes");
            int c15 = androidx.room.util.i.c(F0, "showDate");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                int i4 = c14;
                ArrayList arrayList2 = arrayList;
                int i5 = (int) F0.getLong(c);
                String q02 = F0.isNull(c2) ? null : F0.q0(c2);
                String q03 = F0.isNull(c3) ? null : F0.q0(c3);
                if (F0.isNull(c4)) {
                    i2 = c2;
                    i = c3;
                    q0 = null;
                } else {
                    i = c3;
                    q0 = F0.q0(c4);
                    i2 = c2;
                }
                int i6 = (int) F0.getLong(c5);
                String q04 = F0.isNull(c6) ? null : F0.q0(c6);
                String q05 = F0.isNull(c7) ? null : F0.q0(c7);
                String q06 = F0.isNull(c8) ? null : F0.q0(c8);
                Long valueOf2 = F0.isNull(c9) ? null : Long.valueOf(F0.getLong(c9));
                if (F0.isNull(c10)) {
                    i3 = c4;
                    valueOf = null;
                } else {
                    i3 = c4;
                    valueOf = Integer.valueOf((int) F0.getLong(c10));
                }
                int i7 = c6;
                int i8 = c5;
                int i9 = c15;
                int i10 = c;
                arrayList2.add(new PsLinkAdPlan(i5, q02, q03, q0, i6, q04, q05, q06, valueOf2, valueOf, F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11)), F0.isNull(c12) ? null : F0.q0(c12), (int) F0.getLong(c13), (int) F0.getLong(i4), F0.isNull(i9) ? null : F0.q0(i9)));
                c = i10;
                c14 = i4;
                c15 = i9;
                c5 = i8;
                c3 = i;
                c4 = i3;
                c6 = i7;
                int i11 = i2;
                arrayList = arrayList2;
                c2 = i11;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer r(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT COUNT(*) FROM ps_link_ad WHERE extAdSlot = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            Integer num = null;
            if (F0.C0() && !F0.isNull(0)) {
                num = Integer.valueOf((int) F0.getLong(0));
            }
            return num;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PsLinkAdPlan s(int i, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM ps_link_ad WHERE id =?");
        try {
            F0.c(1, i);
            int c = androidx.room.util.i.c(F0, "id");
            int c2 = androidx.room.util.i.c(F0, "nonId");
            int c3 = androidx.room.util.i.c(F0, "adSource");
            int c4 = androidx.room.util.i.c(F0, "extAdSlot");
            int c5 = androidx.room.util.i.c(F0, "rank");
            int c6 = androidx.room.util.i.c(F0, "psPlanId");
            int c7 = androidx.room.util.i.c(F0, "psLinkAdInfoStr");
            int c8 = androidx.room.util.i.c(F0, "psInfoJson");
            int c9 = androidx.room.util.i.c(F0, "updateTimestamp");
            int c10 = androidx.room.util.i.c(F0, "showMax");
            int c11 = androidx.room.util.i.c(F0, "clickMax");
            int c12 = androidx.room.util.i.c(F0, "showHours");
            int c13 = androidx.room.util.i.c(F0, "showedTimes");
            int c14 = androidx.room.util.i.c(F0, "clickedTimes");
            int c15 = androidx.room.util.i.c(F0, "showDate");
            PsLinkAdPlan psLinkAdPlan = null;
            if (F0.C0()) {
                psLinkAdPlan = new PsLinkAdPlan((int) F0.getLong(c), F0.isNull(c2) ? null : F0.q0(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), (int) F0.getLong(c5), F0.isNull(c6) ? null : F0.q0(c6), F0.isNull(c7) ? null : F0.q0(c7), F0.isNull(c8) ? null : F0.q0(c8), F0.isNull(c9) ? null : Long.valueOf(F0.getLong(c9)), F0.isNull(c10) ? null : Integer.valueOf((int) F0.getLong(c10)), F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11)), F0.isNull(c12) ? null : F0.q0(c12), (int) F0.getLong(c13), (int) F0.getLong(c14), F0.isNull(c15) ? null : F0.q0(c15));
            }
            return psLinkAdPlan;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PsLinkAdPlan t(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM ps_link_ad WHERE extAdSlot = ? ORDER BY updateTimestamp ASC LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = androidx.room.util.i.c(F0, "id");
            int c2 = androidx.room.util.i.c(F0, "nonId");
            int c3 = androidx.room.util.i.c(F0, "adSource");
            int c4 = androidx.room.util.i.c(F0, "extAdSlot");
            int c5 = androidx.room.util.i.c(F0, "rank");
            int c6 = androidx.room.util.i.c(F0, "psPlanId");
            int c7 = androidx.room.util.i.c(F0, "psLinkAdInfoStr");
            int c8 = androidx.room.util.i.c(F0, "psInfoJson");
            int c9 = androidx.room.util.i.c(F0, "updateTimestamp");
            int c10 = androidx.room.util.i.c(F0, "showMax");
            int c11 = androidx.room.util.i.c(F0, "clickMax");
            int c12 = androidx.room.util.i.c(F0, "showHours");
            int c13 = androidx.room.util.i.c(F0, "showedTimes");
            int c14 = androidx.room.util.i.c(F0, "clickedTimes");
            int c15 = androidx.room.util.i.c(F0, "showDate");
            PsLinkAdPlan psLinkAdPlan = null;
            if (F0.C0()) {
                psLinkAdPlan = new PsLinkAdPlan((int) F0.getLong(c), F0.isNull(c2) ? null : F0.q0(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), (int) F0.getLong(c5), F0.isNull(c6) ? null : F0.q0(c6), F0.isNull(c7) ? null : F0.q0(c7), F0.isNull(c8) ? null : F0.q0(c8), F0.isNull(c9) ? null : Long.valueOf(F0.getLong(c9)), F0.isNull(c10) ? null : Integer.valueOf((int) F0.getLong(c10)), F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11)), F0.isNull(c12) ? null : F0.q0(c12), (int) F0.getLong(c13), (int) F0.getLong(c14), F0.isNull(c15) ? null : F0.q0(c15));
            }
            F0.close();
            return psLinkAdPlan;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit u(PsLinkAdPlan psLinkAdPlan, y3.b bVar) {
        this.b.d(bVar, psLinkAdPlan);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit v(PsLinkAdPlan psLinkAdPlan, y3.b bVar) {
        this.c.c(bVar, psLinkAdPlan);
        return Unit.a;
    }

    @Override // vh.l
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: vh.m
            public final Object invoke(Object obj) {
                List q;
                q = t.q((y3.b) obj);
                return q;
            }
        }, continuation);
    }

    @Override // vh.l
    public Object b(final PsLinkAdPlan psLinkAdPlan, Continuation continuation) {
        psLinkAdPlan.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: vh.n
            public final Object invoke(Object obj) {
                Unit u;
                u = t.this.u(psLinkAdPlan, (y3.b) obj);
                return u;
            }
        }, continuation);
    }

    @Override // vh.l
    public Object c(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: vh.r
            public final Object invoke(Object obj) {
                Integer r;
                r = t.r(str, (y3.b) obj);
                return r;
            }
        }, continuation);
    }

    @Override // vh.l
    public Object d(final String str, final List list, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("    DELETE FROM ps_link_ad ");
        sb.append("\n");
        sb.append("    WHERE extAdSlot = ");
        sb.append("?");
        sb.append(" ");
        sb.append("\n");
        sb.append("      AND id NOT IN (");
        androidx.room.util.l.a(sb, list.size());
        sb.append(")");
        sb.append("\n");
        final String sb2 = sb.toString();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: vh.s
            public final Object invoke(Object obj) {
                Unit p;
                p = t.p(sb2, str, list, (y3.b) obj);
                return p;
            }
        }, continuation);
    }

    @Override // vh.l
    public Object e(final PsLinkAdPlan psLinkAdPlan, Continuation continuation) {
        psLinkAdPlan.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: vh.q
            public final Object invoke(Object obj) {
                Unit v;
                v = t.this.v(psLinkAdPlan, (y3.b) obj);
                return v;
            }
        }, continuation);
    }

    @Override // vh.l
    public Object f(final int i, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: vh.o
            public final Object invoke(Object obj) {
                PsLinkAdPlan s;
                s = t.s(i, (y3.b) obj);
                return s;
            }
        }, continuation);
    }

    @Override // vh.l
    public Object g(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: vh.p
            public final Object invoke(Object obj) {
                PsLinkAdPlan t;
                t = t.t(str, (y3.b) obj);
                return t;
            }
        }, continuation);
    }
}
