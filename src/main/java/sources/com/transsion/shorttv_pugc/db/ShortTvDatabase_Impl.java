package com.transsion.shorttv_pugc.db;

import androidx.room.InvalidationTracker;
import androidx.room.f0;
import androidx.room.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y3.b;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ShortTvDatabase_Impl extends ShortTvDatabase {

    class a extends f0 {
        a(int i, String str, String str2) {
            super(i, str, str2);
        }

        public void a(b bVar) {
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `short_tv_favorite_state` (`subjectId` TEXT NOT NULL, `favoriteNum` TEXT, `hasFavorite` INTEGER NOT NULL, `favoriteTime` TEXT, PRIMARY KEY(`subjectId`))");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            y3.a.a(bVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e90a38f8313cd010419e55bde1e55126')");
        }

        public void b(b bVar) {
            y3.a.a(bVar, "DROP TABLE IF EXISTS `short_tv_favorite_state`");
        }

        public void f(b bVar) {
        }

        public void g(b bVar) {
            ShortTvDatabase_Impl.this.P(bVar);
        }

        public void h(b bVar) {
        }

        public void i(b bVar) {
            androidx.room.util.b.a(bVar);
        }

        public f0.a j(b bVar) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("subjectId", new m.a("subjectId", "TEXT", true, 1, (String) null, 1));
            hashMap.put("favoriteNum", new m.a("favoriteNum", "TEXT", false, 0, (String) null, 1));
            hashMap.put("hasFavorite", new m.a("hasFavorite", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("favoriteTime", new m.a("favoriteTime", "TEXT", false, 0, (String) null, 1));
            m mVar = new m("short_tv_favorite_state", hashMap, new HashSet(0), new HashSet(0));
            m a = m.a(bVar, "short_tv_favorite_state");
            if (mVar.equals(a)) {
                return new f0.a(true, (String) null);
            }
            return new f0.a(false, "short_tv_favorite_state(com.transsion.shorttv_pugc.db.ShortTvFavoriteStateBean).\n Expected:\n" + mVar + "\n Found:\n" + a);
        }
    }

    public Set C() {
        return new HashSet();
    }

    protected Map F() {
        HashMap hashMap = new HashMap();
        hashMap.put(ss.a.class, ss.b.a());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public f0 r() {
        return new a(1, "e90a38f8313cd010419e55bde1e55126", "0c797eb7adf7787e513fa3e6ff4af75e");
    }

    protected InvalidationTracker q() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"short_tv_favorite_state"});
    }

    public List v(Map map) {
        return new ArrayList();
    }
}
