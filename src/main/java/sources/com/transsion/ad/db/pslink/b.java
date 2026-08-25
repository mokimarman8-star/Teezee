package com.transsion.ad.db.pslink;

import androidx.room.RoomDatabase;
import androidx.room.e;
import androidx.room.g;
import androidx.room.util.i;
import com.transsion.ad.db.pslink.AttributionPoint;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements com.transsion.ad.db.pslink.a {
    private final RoomDatabase a;
    private final AttributionPoint.b c = new AttributionPoint.b();
    private final g b = new a();
    private final e d = new C0003b();
    private final e e = new c();

    class a extends g {
        a() {
        }

        protected String b() {
            return "INSERT OR ABORT INTO `attribution_points` (`id`,`psId`,`failCount`,`reportUrl`,`type`,`updateTimestamp`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AttributionPoint attributionPoint) {
            eVar.c(1, attributionPoint.getId());
            if (attributionPoint.getPsId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, attributionPoint.getPsId());
            }
            eVar.c(3, attributionPoint.getFailCount());
            if (attributionPoint.getReportUrl() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, attributionPoint.getReportUrl());
            }
            String a = b.this.c.a(attributionPoint.getType());
            if (a == null) {
                eVar.g(5);
            } else {
                eVar.i(5, a);
            }
            eVar.c(6, attributionPoint.getUpdateTimestamp());
        }
    }

    /* renamed from: com.transsion.ad.db.pslink.b$b, reason: collision with other inner class name */
    class C0003b extends e {
        C0003b() {
        }

        protected String b() {
            return "DELETE FROM `attribution_points` WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AttributionPoint attributionPoint) {
            eVar.c(1, attributionPoint.getId());
        }
    }

    class c extends e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `attribution_points` SET `id` = ?,`psId` = ?,`failCount` = ?,`reportUrl` = ?,`type` = ?,`updateTimestamp` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AttributionPoint attributionPoint) {
            eVar.c(1, attributionPoint.getId());
            if (attributionPoint.getPsId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, attributionPoint.getPsId());
            }
            eVar.c(3, attributionPoint.getFailCount());
            if (attributionPoint.getReportUrl() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, attributionPoint.getReportUrl());
            }
            String a = b.this.c.a(attributionPoint.getType());
            if (a == null) {
                eVar.g(5);
            } else {
                eVar.i(5, a);
            }
            eVar.c(6, attributionPoint.getUpdateTimestamp());
            eVar.c(7, attributionPoint.getId());
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List l() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit m(AttributionPoint attributionPoint, y3.b bVar) {
        this.d.c(bVar, attributionPoint);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AttributionPoint n(long j, long j2, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM attribution_points WHERE ? - updateTimestamp >= ? ORDER BY CASE type WHEN 'CLICK' THEN 0 ELSE 1 END, failCount ASC, updateTimestamp DESC LIMIT 1");
        try {
            F0.c(1, j);
            F0.c(2, j2);
            int c2 = i.c(F0, "id");
            int c3 = i.c(F0, "psId");
            int c4 = i.c(F0, "failCount");
            int c5 = i.c(F0, "reportUrl");
            int c6 = i.c(F0, "type");
            int c7 = i.c(F0, "updateTimestamp");
            AttributionPoint attributionPoint = null;
            if (F0.C0()) {
                try {
                    attributionPoint = new AttributionPoint((int) F0.getLong(c2), F0.isNull(c3) ? null : F0.q0(c3), (int) F0.getLong(c4), F0.isNull(c5) ? null : F0.q0(c5), this.c.b(F0.isNull(c6) ? null : F0.q0(c6)), F0.getLong(c7));
                } catch (Throwable th2) {
                    th = th2;
                    F0.close();
                    throw th;
                }
            }
            F0.close();
            return attributionPoint;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit o(AttributionPoint attributionPoint, y3.b bVar) {
        this.b.d(bVar, attributionPoint);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean p(String str, AttributionPoint.AttributionType attributionType, String str2, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT EXISTS(SELECT 1 FROM attribution_points WHERE psId = ? AND type = ? AND reportUrl = ?)");
        boolean z = true;
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            String a2 = this.c.a(attributionType);
            if (a2 == null) {
                F0.g(2);
            } else {
                F0.i(2, a2);
            }
            if (str2 == null) {
                F0.g(3);
            } else {
                F0.i(3, str2);
            }
            Boolean bool = null;
            if (F0.C0()) {
                Integer valueOf = F0.isNull(0) ? null : Integer.valueOf((int) F0.getLong(0));
                if (valueOf != null) {
                    if (valueOf.intValue() == 0) {
                        z = false;
                    }
                    bool = Boolean.valueOf(z);
                }
            }
            return bool;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit q(AttributionPoint attributionPoint, y3.b bVar) {
        this.e.c(bVar, attributionPoint);
        return Unit.a;
    }

    @Override // com.transsion.ad.db.pslink.a
    public Object a(final AttributionPoint attributionPoint, Continuation continuation) {
        attributionPoint.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: vh.i
            public final Object invoke(Object obj) {
                Unit m;
                m = com.transsion.ad.db.pslink.b.this.m(attributionPoint, (y3.b) obj);
                return m;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.pslink.a
    public Object b(final AttributionPoint attributionPoint, Continuation continuation) {
        attributionPoint.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: vh.k
            public final Object invoke(Object obj) {
                Unit q;
                q = com.transsion.ad.db.pslink.b.this.q(attributionPoint, (y3.b) obj);
                return q;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.pslink.a
    public Object c(final String str, final AttributionPoint.AttributionType attributionType, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: vh.g
            public final Object invoke(Object obj) {
                Boolean p;
                p = com.transsion.ad.db.pslink.b.this.p(str, attributionType, str2, (y3.b) obj);
                return p;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.pslink.a
    public Object d(final long j, final long j2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: vh.j
            public final Object invoke(Object obj) {
                AttributionPoint n;
                n = com.transsion.ad.db.pslink.b.this.n(j, j2, (y3.b) obj);
                return n;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.pslink.a
    public Object e(final AttributionPoint attributionPoint, Continuation continuation) {
        attributionPoint.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: vh.h
            public final Object invoke(Object obj) {
                Unit o;
                o = com.transsion.ad.db.pslink.b.this.o(attributionPoint, (y3.b) obj);
                return o;
            }
        }, continuation);
    }
}
