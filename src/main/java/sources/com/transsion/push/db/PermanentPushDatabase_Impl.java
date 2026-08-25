package com.transsion.push.db;

import androidx.room.InvalidationTracker;
import androidx.room.f0;
import androidx.room.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PermanentPushDatabase_Impl extends PermanentPushDatabase {
    private volatile com.transsion.push.db.a r;

    class a extends f0 {
        a(int i, String str, String str2) {
            super(i, str, str2);
        }

        public void a(y3.b bVar) {
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `permanent_item` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `deeplink` TEXT, `subject_id` TEXT, `image` TEXT, `title` TEXT)");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            y3.a.a(bVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1fffbd46e501ef2aa1bccfc7df8cf2d6')");
        }

        public void b(y3.b bVar) {
            y3.a.a(bVar, "DROP TABLE IF EXISTS `permanent_item`");
        }

        public void f(y3.b bVar) {
        }

        public void g(y3.b bVar) {
            PermanentPushDatabase_Impl.this.P(bVar);
        }

        public void h(y3.b bVar) {
        }

        public void i(y3.b bVar) {
            androidx.room.util.b.a(bVar);
        }

        public f0.a j(y3.b bVar) {
            HashMap hashMap = new HashMap(5);
            hashMap.put("id", new m.a("id", "INTEGER", true, 1, (String) null, 1));
            hashMap.put("deeplink", new m.a("deeplink", "TEXT", false, 0, (String) null, 1));
            hashMap.put("subject_id", new m.a("subject_id", "TEXT", false, 0, (String) null, 1));
            hashMap.put("image", new m.a("image", "TEXT", false, 0, (String) null, 1));
            hashMap.put("title", new m.a("title", "TEXT", false, 0, (String) null, 1));
            m mVar = new m("permanent_item", hashMap, new HashSet(0), new HashSet(0));
            m a = m.a(bVar, "permanent_item");
            if (mVar.equals(a)) {
                return new f0.a(true, (String) null);
            }
            return new f0.a(false, "permanent_item(com.transsion.push.bean.PermanentItemBean).\n Expected:\n" + mVar + "\n Found:\n" + a);
        }
    }

    public Set C() {
        return new HashSet();
    }

    protected Map F() {
        HashMap hashMap = new HashMap();
        hashMap.put(com.transsion.push.db.a.class, f.i());
        return hashMap;
    }

    @Override // com.transsion.push.db.PermanentPushDatabase
    public com.transsion.push.db.a i0() {
        com.transsion.push.db.a aVar;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new f(this);
                }
                aVar = this.r;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public f0 r() {
        return new a(1, "1fffbd46e501ef2aa1bccfc7df8cf2d6", "ea621e991f9e4353c74e708cec62b4ff");
    }

    protected InvalidationTracker q() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"permanent_item"});
    }

    public List v(Map map) {
        return new ArrayList();
    }
}
