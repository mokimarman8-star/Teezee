package c9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.i;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import d9.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import x8.a;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class m0 implements c9.d, d9.a, c9.c {
    private static final t8.c f = t8.c.b("proto");
    private final v0 a;
    private final e9.a b;
    private final e9.a c;
    private final e d;
    private final iy.a e;

    interface b {
        Object apply(Object obj);
    }

    private static class c {
        final String a;
        final String b;

        private c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    interface d {
        Object a();
    }

    m0(e9.a aVar, e9.a aVar2, e eVar, v0 v0Var, iy.a aVar3) {
        this.a = v0Var;
        this.b = aVar;
        this.c = aVar2;
        this.d = eVar;
        this.e = aVar3;
    }

    private boolean B0() {
        return t0() * u0() >= this.d.f();
    }

    private List D0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            k kVar = (k) listIterator.next();
            if (map.containsKey(Long.valueOf(kVar.c()))) {
                i.a p = kVar.b().p();
                for (c cVar : (Set) map.get(Long.valueOf(kVar.c()))) {
                    p.c(cVar.a, cVar.b);
                }
                listIterator.set(k.a(kVar.c(), kVar.d(), p.d()));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object E0(Cursor cursor) {
        while (cursor.moveToNext()) {
            j(cursor.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer G0(long j, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j)};
        m1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: c9.s
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Object E0;
                E0 = m0.this.E0((Cursor) obj);
                return E0;
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object H0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object I0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase J0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long K0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ x8.e L0(long j, Cursor cursor) {
        cursor.moveToNext();
        return x8.e.c().c(cursor.getLong(0)).b(j).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ x8.e M0(final long j, SQLiteDatabase sQLiteDatabase) {
        return (x8.e) m1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: c9.d0
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                x8.e L0;
                L0 = m0.L0(j, (Cursor) obj);
                return L0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long N0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean O0(com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        Long y0 = y0(sQLiteDatabase, oVar);
        return y0 == null ? Boolean.FALSE : (Boolean) m1(r0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{y0.toString()}), new b() { // from class: c9.u
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List P0(SQLiteDatabase sQLiteDatabase) {
        return (List) m1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: c9.k0
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                List Q0;
                Q0 = m0.Q0((Cursor) obj);
                return Q0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List Q0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(com.google.android.datatransport.runtime.o.a().b(cursor.getString(1)).d(f9.a.b(cursor.getInt(2))).c(g1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List R0(com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        List e1 = e1(sQLiteDatabase, oVar, this.d.d());
        for (Priority priority : Priority.values()) {
            if (priority != oVar.d()) {
                int d2 = this.d.d() - e1.size();
                if (d2 <= 0) {
                    break;
                }
                e1.addAll(e1(sQLiteDatabase, oVar.f(priority), d2));
            }
        }
        return D0(e1, f1(sQLiteDatabase, e1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ x8.a S0(Map map, a.C0070a c0070a, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            LogEventDropped.Reason j0 = j0(cursor.getInt(1));
            long j = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(LogEventDropped.c().c(j0).b(j).a());
        }
        h1(c0070a, map);
        return c0070a.e(x0()).d(s0()).c((String) this.e.get()).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ x8.a T0(String str, final Map map, final a.C0070a c0070a, SQLiteDatabase sQLiteDatabase) {
        return (x8.a) m1(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: c9.a0
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                x8.a S0;
                S0 = m0.this.S0(map, c0070a, (Cursor) obj);
                return S0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object U0(List list, com.google.android.datatransport.runtime.o oVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            i.a o = com.google.android.datatransport.runtime.i.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            if (z) {
                o.h(new com.google.android.datatransport.runtime.h(k1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                o.h(new com.google.android.datatransport.runtime.h(k1(cursor.getString(4)), i1(j)));
            }
            if (!cursor.isNull(6)) {
                o.g(Integer.valueOf(cursor.getInt(6)));
            }
            if (!cursor.isNull(8)) {
                o.l(Integer.valueOf(cursor.getInt(8)));
            }
            if (!cursor.isNull(9)) {
                o.m(cursor.getString(9));
            }
            if (!cursor.isNull(10)) {
                o.j(cursor.getBlob(10));
            }
            if (!cursor.isNull(11)) {
                o.k(cursor.getBlob(11));
            }
            list.add(k.a(j, oVar, o.d()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object V0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long W0(com.google.android.datatransport.runtime.i iVar, com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        if (B0()) {
            j(1L, LogEventDropped.Reason.CACHE_FULL, iVar.n());
            return -1L;
        }
        long o0 = o0(sQLiteDatabase, oVar);
        int e = this.d.e();
        byte[] a2 = iVar.e().a();
        boolean z = a2.length <= e;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(o0));
        contentValues.put("transport_name", iVar.n());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.o()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put(TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY, iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put("payload", z ? a2 : new byte[0]);
        contentValues.put("product_id", iVar.l());
        contentValues.put("pseudonymous_id", iVar.m());
        contentValues.put("experiment_ids_clear_blob", iVar.g());
        contentValues.put("experiment_ids_encrypted_blob", iVar.h());
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z) {
            int ceil = (int) Math.ceil(a2.length / e);
            for (int i = 1; i <= ceil; i++) {
                byte[] copyOfRange = Arrays.copyOfRange(a2, (i - 1) * e, Math.min(i * e, a2.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry entry : iVar.k().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] X0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i += blob.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Y0(Cursor cursor) {
        while (cursor.moveToNext()) {
            j(cursor.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Z0(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        m1(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: c9.v
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Object Y0;
                Y0 = m0.this.Y0((Cursor) obj);
                return Y0;
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean a1(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object b1(String str, LogEventDropped.Reason reason, long j, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) m1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())}), new b() { // from class: c9.y
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Boolean a1;
                a1 = m0.a1((Cursor) obj);
                return a1;
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(reason.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object c1(long j, com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(f9.a.a(oVar.d()))}) < 1) {
            contentValues.put("backend_name", oVar.b());
            contentValues.put("priority", Integer.valueOf(f9.a.a(oVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.b.getTime()).execute();
        return null;
    }

    private List e1(SQLiteDatabase sQLiteDatabase, final com.google.android.datatransport.runtime.o oVar, int i) {
        final ArrayList arrayList = new ArrayList();
        Long y0 = y0(sQLiteDatabase, oVar);
        if (y0 == null) {
            return arrayList;
        }
        m1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY, "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{y0.toString()}, null, null, null, String.valueOf(i)), new b() { // from class: c9.x
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Object U0;
                U0 = m0.this.U0(arrayList, oVar, (Cursor) obj);
                return U0;
            }
        });
        return arrayList;
    }

    private Map f1(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(((k) list.get(i)).c());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        m1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new b() { // from class: c9.z
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Object V0;
                V0 = m0.V0(hashMap, (Cursor) obj);
                return V0;
            }
        });
        return hashMap;
    }

    private static byte[] g1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void h1(a.C0070a c0070a, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            c0070a.a(x8.c.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    private byte[] i1(long j) {
        return (byte[]) m1(r0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), new b() { // from class: c9.b0
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                byte[] X0;
                X0 = m0.X0((Cursor) obj);
                return X0;
            }
        });
    }

    private LogEventDropped.Reason j0(int i) {
        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
        if (i == reason.getNumber()) {
            return reason;
        }
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (i == reason2.getNumber()) {
            return reason2;
        }
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        if (i == reason3.getNumber()) {
            return reason3;
        }
        LogEventDropped.Reason reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (i == reason4.getNumber()) {
            return reason4;
        }
        LogEventDropped.Reason reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (i == reason5.getNumber()) {
            return reason5;
        }
        LogEventDropped.Reason reason6 = LogEventDropped.Reason.INVALID_PAYLOD;
        if (i == reason6.getNumber()) {
            return reason6;
        }
        LogEventDropped.Reason reason7 = LogEventDropped.Reason.SERVER_ERROR;
        if (i == reason7.getNumber()) {
            return reason7;
        }
        y8.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i));
        return reason;
    }

    private Object j1(d dVar, b bVar) {
        long time = this.c.getTime();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.c.getTime() >= this.d.b() + time) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static t8.c k1(String str) {
        return str == null ? f : t8.c.b(str);
    }

    private void l0(final SQLiteDatabase sQLiteDatabase) {
        j1(new d() { // from class: c9.l
            @Override // c9.m0.d
            public final Object a() {
                Object H0;
                H0 = m0.H0(sQLiteDatabase);
                return H0;
            }
        }, new b() { // from class: c9.w
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Object I0;
                I0 = m0.I0((Throwable) obj);
                return I0;
            }
        });
    }

    private static String l1(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((k) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    static Object m1(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    private long o0(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.o oVar) {
        Long y0 = y0(sQLiteDatabase, oVar);
        if (y0 != null) {
            return y0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", oVar.b());
        contentValues.put("priority", Integer.valueOf(f9.a.a(oVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (oVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(oVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private x8.b s0() {
        return x8.b.b().b(x8.d.c().b(p0()).c(e.a.f()).a()).a();
    }

    private long t0() {
        return r0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long u0() {
        return r0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private x8.e x0() {
        final long time = this.b.getTime();
        return (x8.e) A0(new b() { // from class: c9.c0
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                x8.e M0;
                M0 = m0.M0(time, (SQLiteDatabase) obj);
                return M0;
            }
        });
    }

    private Long y0(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.o oVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(oVar.b(), String.valueOf(f9.a.a(oVar.d()))));
        if (oVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(oVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) m1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: c9.n
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Long N0;
                N0 = m0.N0((Cursor) obj);
                return N0;
            }
        });
    }

    Object A0(b bVar) {
        SQLiteDatabase r0 = r0();
        r0.beginTransaction();
        try {
            Object apply = bVar.apply(r0);
            r0.setTransactionSuccessful();
            return apply;
        } finally {
            r0.endTransaction();
        }
    }

    @Override // c9.d
    public int B() {
        final long time = this.b.getTime() - this.d.c();
        return ((Integer) A0(new b() { // from class: c9.j0
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Integer G0;
                G0 = m0.this.G0(time, (SQLiteDatabase) obj);
                return G0;
            }
        })).intValue();
    }

    @Override // c9.d
    public void C(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            r0().compileStatement("DELETE FROM events WHERE _id in " + l1(iterable)).execute();
        }
    }

    @Override // c9.d
    public void G(final com.google.android.datatransport.runtime.o oVar, final long j) {
        A0(new b() { // from class: c9.p
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Object c1;
                c1 = m0.c1(j, oVar, (SQLiteDatabase) obj);
                return c1;
            }
        });
    }

    @Override // c9.d
    public Iterable H() {
        return (Iterable) A0(new b() { // from class: c9.g0
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                List P0;
                P0 = m0.P0((SQLiteDatabase) obj);
                return P0;
            }
        });
    }

    @Override // c9.d
    public long O(com.google.android.datatransport.runtime.o oVar) {
        return ((Long) m1(r0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(f9.a.a(oVar.d()))}), new b() { // from class: c9.h0
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Long K0;
                K0 = m0.K0((Cursor) obj);
                return K0;
            }
        })).longValue();
    }

    @Override // c9.d
    public boolean P(final com.google.android.datatransport.runtime.o oVar) {
        return ((Boolean) A0(new b() { // from class: c9.o
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Boolean O0;
                O0 = m0.this.O0(oVar, (SQLiteDatabase) obj);
                return O0;
            }
        })).booleanValue();
    }

    @Override // c9.d
    public void Q(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + l1(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            A0(new b() { // from class: c9.l0
                @Override // c9.m0.b
                public final Object apply(Object obj) {
                    Object Z0;
                    Z0 = m0.this.Z0(str, str2, (SQLiteDatabase) obj);
                    return Z0;
                }
            });
        }
    }

    @Override // c9.d
    public Iterable Z(final com.google.android.datatransport.runtime.o oVar) {
        return (Iterable) A0(new b() { // from class: c9.m
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                List R0;
                R0 = m0.this.R0(oVar, (SQLiteDatabase) obj);
                return R0;
            }
        });
    }

    @Override // d9.a
    public Object b(a.InterfaceC0041a interfaceC0041a) {
        SQLiteDatabase r0 = r0();
        l0(r0);
        try {
            Object execute = interfaceC0041a.execute();
            r0.setTransactionSuccessful();
            return execute;
        } finally {
            r0.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // c9.c
    public void d() {
        A0(new b() { // from class: c9.q
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Object d1;
                d1 = m0.this.d1((SQLiteDatabase) obj);
                return d1;
            }
        });
    }

    @Override // c9.c
    public x8.a h() {
        final a.C0070a e = x8.a.e();
        final HashMap hashMap = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (x8.a) A0(new b() { // from class: c9.t
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                x8.a T0;
                T0 = m0.this.T0(str, hashMap, e, (SQLiteDatabase) obj);
                return T0;
            }
        });
    }

    @Override // c9.c
    public void j(final long j, final LogEventDropped.Reason reason, final String str) {
        A0(new b() { // from class: c9.r
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Object b1;
                b1 = m0.b1(str, reason, j, (SQLiteDatabase) obj);
                return b1;
            }
        });
    }

    long p0() {
        return t0() * u0();
    }

    SQLiteDatabase r0() {
        final v0 v0Var = this.a;
        Objects.requireNonNull(v0Var);
        return (SQLiteDatabase) j1(new d() { // from class: c9.e0
            @Override // c9.m0.d
            public final Object a() {
                return v0.this.getWritableDatabase();
            }
        }, new b() { // from class: c9.f0
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                SQLiteDatabase J0;
                J0 = m0.J0((Throwable) obj);
                return J0;
            }
        });
    }

    @Override // c9.d
    public k w0(final com.google.android.datatransport.runtime.o oVar, final com.google.android.datatransport.runtime.i iVar) {
        y8.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", oVar.d(), iVar.n(), oVar.b());
        long longValue = ((Long) A0(new b() { // from class: c9.i0
            @Override // c9.m0.b
            public final Object apply(Object obj) {
                Long W0;
                W0 = m0.this.W0(iVar, oVar, (SQLiteDatabase) obj);
                return W0;
            }
        })).longValue();
        if (longValue < 1) {
            return null;
        }
        return k.a(longValue, oVar, iVar);
    }
}
