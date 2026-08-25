package com.cloud.hisavana.abtestkit.db;

import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.c;
import androidx.room.h0;
import androidx.room.util.b;
import androidx.room.util.m;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ClientABTestDTOKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import x6.q;
import x6.s;
import x6.y;
import z3.d;
import z3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class ABRoomDatabase_Impl extends ABRoomDatabase {
    public volatile y q;
    public volatile q r;

    public class a extends h0.b {
        public a() {
            super(1);
        }

        public final void a(d dVar) {
            dVar.E("CREATE TABLE IF NOT EXISTS `hisavana_ab_room` (`layer_id` INTEGER NOT NULL, `request_time` INTEGER NOT NULL, `ab_info` TEXT, PRIMARY KEY(`layer_id`))");
            dVar.E("CREATE TABLE IF NOT EXISTS `hisavana_local_ab_room` (`local_ab_version_code` INTEGER NOT NULL, `local_ab_json` TEXT, PRIMARY KEY(`local_ab_version_code`))");
            dVar.E("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            dVar.E("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c3731bb55f7c1b83c5a17ab41e6dc2b1')");
        }

        public final void b(d dVar) {
            dVar.E("DROP TABLE IF EXISTS `hisavana_ab_room`");
            dVar.E("DROP TABLE IF EXISTS `hisavana_local_ab_room`");
            List list = ((RoomDatabase) ABRoomDatabase_Impl.this).j;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((RoomDatabase.b) it.next()).d(dVar);
                }
            }
        }

        public final void c(d dVar) {
            List list = ((RoomDatabase) ABRoomDatabase_Impl.this).j;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((RoomDatabase.b) it.next()).b(dVar);
                }
            }
        }

        public final void d(d dVar) {
            ((RoomDatabase) ABRoomDatabase_Impl.this).a = dVar;
            ABRoomDatabase_Impl.this.Q(dVar);
            List list = ((RoomDatabase) ABRoomDatabase_Impl.this).j;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((RoomDatabase.b) it.next()).f(dVar);
                }
            }
        }

        public final void e(d dVar) {
        }

        public final void f(d dVar) {
            b.b(dVar);
        }

        public final h0.c g(d dVar) {
            HashMap hashMap = new HashMap(3);
            hashMap.put(ClientABTestDTOKt.LAYER_ID, new m.a(ClientABTestDTOKt.LAYER_ID, "INTEGER", true, 1, (String) null, 1));
            hashMap.put("request_time", new m.a("request_time", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("ab_info", new m.a("ab_info", "TEXT", false, 0, (String) null, 1));
            m mVar = new m("hisavana_ab_room", hashMap, new HashSet(0), new HashSet(0));
            m b = m.b(dVar, "hisavana_ab_room");
            if (!mVar.equals(b)) {
                return new h0.c(false, "hisavana_ab_room(com.cloud.hisavana.abtestkit.db.entities.OnlineABEntity).\n Expected:\n" + mVar + "\n Found:\n" + b);
            }
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("local_ab_version_code", new m.a("local_ab_version_code", "INTEGER", true, 1, (String) null, 1));
            hashMap2.put("local_ab_json", new m.a("local_ab_json", "TEXT", false, 0, (String) null, 1));
            m mVar2 = new m("hisavana_local_ab_room", hashMap2, new HashSet(0), new HashSet(0));
            m b2 = m.b(dVar, "hisavana_local_ab_room");
            if (mVar2.equals(b2)) {
                return new h0.c(true, (String) null);
            }
            return new h0.c(false, "hisavana_local_ab_room(com.cloud.hisavana.abtestkit.db.entities.LocalABEntity).\n Expected:\n" + mVar2 + "\n Found:\n" + b2);
        }
    }

    public final Set C() {
        return new HashSet();
    }

    public final Map F() {
        HashMap hashMap = new HashMap();
        hashMap.put(s.class, Collections.emptyList());
        hashMap.put(x6.m.class, Collections.emptyList());
        return hashMap;
    }

    @Override // com.cloud.hisavana.abtestkit.db.ABRoomDatabase
    public final x6.m g0() {
        q qVar;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new q(this);
                }
                qVar = this.r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }

    @Override // com.cloud.hisavana.abtestkit.db.ABRoomDatabase
    public final s h0() {
        y yVar;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            try {
                if (this.q == null) {
                    this.q = new y(this);
                }
                yVar = this.q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return yVar;
    }

    public final InvalidationTracker q() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"hisavana_ab_room", "hisavana_local_ab_room"});
    }

    public final e s(c cVar) {
        return cVar.c.a(e.b.a(cVar.a).d(cVar.b).c(new h0(cVar, new a(), "c3731bb55f7c1b83c5a17ab41e6dc2b1", "59a3f677eceb796bf1de1bde197864ae")).b());
    }

    public final List v(Map map) {
        return new ArrayList();
    }
}
