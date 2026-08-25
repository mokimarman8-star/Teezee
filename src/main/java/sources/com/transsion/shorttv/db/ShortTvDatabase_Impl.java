package com.transsion.shorttv.db;

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
public final class ShortTvDatabase_Impl extends ShortTvDatabase {
    private volatile ShortTvFavoriteDao s;
    private volatile ShortTvAdUnlockDao t;

    class a extends f0 {
        a(int i, String str, String str2) {
            super(i, str, str2);
        }

        public void a(y3.b bVar) {
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `short_tv_favorite_state` (`subjectId` TEXT NOT NULL, `favoriteNum` TEXT, `hasFavorite` INTEGER NOT NULL, `favoriteTime` TEXT, PRIMARY KEY(`subjectId`))");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `short_tv_ad_unlock_state` (`subjectId` TEXT NOT NULL, `unlockedEps` TEXT NOT NULL, PRIMARY KEY(`subjectId`))");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            y3.a.a(bVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d0cc9a2b371c1f7329d0d00d8bd31c1')");
        }

        public void b(y3.b bVar) {
            y3.a.a(bVar, "DROP TABLE IF EXISTS `short_tv_favorite_state`");
            y3.a.a(bVar, "DROP TABLE IF EXISTS `short_tv_ad_unlock_state`");
        }

        public void f(y3.b bVar) {
        }

        public void g(y3.b bVar) {
            ShortTvDatabase_Impl.this.P(bVar);
        }

        public void h(y3.b bVar) {
        }

        public void i(y3.b bVar) {
            androidx.room.util.b.a(bVar);
        }

        public f0.a j(y3.b bVar) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("subjectId", new m.a("subjectId", "TEXT", true, 1, (String) null, 1));
            hashMap.put("favoriteNum", new m.a("favoriteNum", "TEXT", false, 0, (String) null, 1));
            hashMap.put("hasFavorite", new m.a("hasFavorite", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("favoriteTime", new m.a("favoriteTime", "TEXT", false, 0, (String) null, 1));
            m mVar = new m("short_tv_favorite_state", hashMap, new HashSet(0), new HashSet(0));
            m a = m.a(bVar, "short_tv_favorite_state");
            if (!mVar.equals(a)) {
                return new f0.a(false, "short_tv_favorite_state(com.transsion.shorttv.db.ShortTvFavoriteStateBean).\n Expected:\n" + mVar + "\n Found:\n" + a);
            }
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("subjectId", new m.a("subjectId", "TEXT", true, 1, (String) null, 1));
            hashMap2.put("unlockedEps", new m.a("unlockedEps", "TEXT", true, 0, (String) null, 1));
            m mVar2 = new m("short_tv_ad_unlock_state", hashMap2, new HashSet(0), new HashSet(0));
            m a2 = m.a(bVar, "short_tv_ad_unlock_state");
            if (mVar2.equals(a2)) {
                return new f0.a(true, (String) null);
            }
            return new f0.a(false, "short_tv_ad_unlock_state(com.transsion.shorttv.db.ShortTvAdUnlockStateBean).\n Expected:\n" + mVar2 + "\n Found:\n" + a2);
        }
    }

    public Set C() {
        return new HashSet();
    }

    protected Map F() {
        HashMap hashMap = new HashMap();
        hashMap.put(ShortTvFavoriteDao.class, i.h());
        hashMap.put(ShortTvAdUnlockDao.class, d.h());
        return hashMap;
    }

    @Override // com.transsion.shorttv.db.ShortTvDatabase
    public ShortTvAdUnlockDao j0() {
        ShortTvAdUnlockDao shortTvAdUnlockDao;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            try {
                if (this.t == null) {
                    this.t = new d(this);
                }
                shortTvAdUnlockDao = this.t;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return shortTvAdUnlockDao;
    }

    @Override // com.transsion.shorttv.db.ShortTvDatabase
    public ShortTvFavoriteDao k0() {
        ShortTvFavoriteDao shortTvFavoriteDao;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            try {
                if (this.s == null) {
                    this.s = new i(this);
                }
                shortTvFavoriteDao = this.s;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return shortTvFavoriteDao;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public f0 r() {
        return new a(2, "7d0cc9a2b371c1f7329d0d00d8bd31c1", "8d7f57b404f63d2b99b6f547f57644e9");
    }

    protected InvalidationTracker q() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"short_tv_favorite_state", "short_tv_ad_unlock_state"});
    }

    public List v(Map map) {
        return new ArrayList();
    }
}
