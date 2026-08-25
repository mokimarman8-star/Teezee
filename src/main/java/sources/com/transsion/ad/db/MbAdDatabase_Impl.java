package com.transsion.ad.db;

import androidx.room.InvalidationTracker;
import androidx.room.f0;
import androidx.room.util.m;
import com.transsion.ad.db.scene.AdSceneLimitDao;
import com.transsion.ad.db.scene.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import th.f;
import uh.j;
import vh.l;
import vh.t;
import y3.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MbAdDatabase_Impl extends MbAdDatabase {
    private volatile uh.a D;
    private volatile th.a E;
    private volatile l F;
    private volatile com.transsion.ad.db.pslink.a G;
    private volatile vh.a H;
    private volatile AdSceneLimitDao I;

    class a extends f0 {
        a(int i, String str, String str2) {
            super(i, str, str2);
        }

        public void a(b bVar) {
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `mb_ad_db_plans` (`id` TEXT NOT NULL, `version` TEXT, `name` TEXT, `startTime` TEXT, `endTime` TEXT, `extraConfig` TEXT, `displayTimes` INTEGER, `showedTimes` INTEGER, `showDate` TEXT, `advertiserName` TEXT, `advertiserAvatar` TEXT, `advertiserAvatarPath` TEXT, `brand` TEXT, `denyBrand` TEXT, `model` TEXT, `denyModel` TEXT, `country` TEXT, `scenes` TEXT, `adSource` TEXT, `extAdSlot` TEXT, `adMaterialList` TEXT, `adPlanUpdateTime` TEXT, `sort` INTEGER, `adShowLevel` TEXT, `filterClientVersion` TEXT, `adPlanCreateTime` TEXT, `appStarDesc` TEXT, `appSizeDesc` TEXT, `ctxEnableExpr` TEXT, `ctxDisableExpr` TEXT, `ctxAttributeConfig` TEXT, `dispatchTimeStart` TEXT, `dispatchTimeEnd` TEXT, `extImage` TEXT, `bidEcpmCent` REAL, `ecpmCent` INTEGER, `isValid` INTEGER NOT NULL, `h5LinkPreload` INTEGER NOT NULL, `h5LinkOpenByCct` INTEGER NOT NULL, `countryCode` TEXT, PRIMARY KEY(`id`))");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `local_mcc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Country` TEXT NOT NULL, `Mcc` TEXT NOT NULL, `Iso` TEXT NOT NULL, `CountryCode` TEXT NOT NULL)");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `ps_link_ad` (`id` INTEGER NOT NULL, `nonId` TEXT NOT NULL, `adSource` TEXT NOT NULL, `extAdSlot` TEXT NOT NULL, `rank` INTEGER NOT NULL, `psPlanId` TEXT, `psLinkAdInfoStr` TEXT, `psInfoJson` TEXT, `updateTimestamp` INTEGER, `showMax` INTEGER, `clickMax` INTEGER, `showHours` TEXT, `showedTimes` INTEGER NOT NULL, `clickedTimes` INTEGER NOT NULL, `showDate` TEXT, PRIMARY KEY(`id`))");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `attribution_points` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `psId` TEXT NOT NULL, `failCount` INTEGER NOT NULL, `reportUrl` TEXT NOT NULL, `type` TEXT NOT NULL, `updateTimestamp` INTEGER NOT NULL)");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `app_installed` (`packageName` TEXT NOT NULL, `source` TEXT, `appName` TEXT, `versionName` TEXT, `versionCode` TEXT, `horizontalImageUrl` TEXT, `eCPM` REAL, `installTime` INTEGER, `lastOpenTime` INTEGER, PRIMARY KEY(`packageName`))");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `ad_scene_limit_table` (`sceneId` TEXT NOT NULL, `lastDisplayAdDate` TEXT NOT NULL, `lastDisplayAdTimestamp` INTEGER NOT NULL, `displayTimes` INTEGER NOT NULL, PRIMARY KEY(`sceneId`))");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            y3.a.a(bVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '58697ca485708a9a9f5014d94ad4e49f')");
        }

        public void b(b bVar) {
            y3.a.a(bVar, "DROP TABLE IF EXISTS `mb_ad_db_plans`");
            y3.a.a(bVar, "DROP TABLE IF EXISTS `local_mcc`");
            y3.a.a(bVar, "DROP TABLE IF EXISTS `ps_link_ad`");
            y3.a.a(bVar, "DROP TABLE IF EXISTS `attribution_points`");
            y3.a.a(bVar, "DROP TABLE IF EXISTS `app_installed`");
            y3.a.a(bVar, "DROP TABLE IF EXISTS `ad_scene_limit_table`");
        }

        public void f(b bVar) {
        }

        public void g(b bVar) {
            MbAdDatabase_Impl.this.P(bVar);
        }

        public void h(b bVar) {
        }

        public void i(b bVar) {
            androidx.room.util.b.a(bVar);
        }

        public f0.a j(b bVar) {
            HashMap hashMap = new HashMap(40);
            hashMap.put("id", new m.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap.put("version", new m.a("version", "TEXT", false, 0, (String) null, 1));
            hashMap.put("name", new m.a("name", "TEXT", false, 0, (String) null, 1));
            hashMap.put("startTime", new m.a("startTime", "TEXT", false, 0, (String) null, 1));
            hashMap.put("endTime", new m.a("endTime", "TEXT", false, 0, (String) null, 1));
            hashMap.put("extraConfig", new m.a("extraConfig", "TEXT", false, 0, (String) null, 1));
            hashMap.put("displayTimes", new m.a("displayTimes", "INTEGER", false, 0, (String) null, 1));
            hashMap.put("showedTimes", new m.a("showedTimes", "INTEGER", false, 0, (String) null, 1));
            hashMap.put("showDate", new m.a("showDate", "TEXT", false, 0, (String) null, 1));
            hashMap.put("advertiserName", new m.a("advertiserName", "TEXT", false, 0, (String) null, 1));
            hashMap.put("advertiserAvatar", new m.a("advertiserAvatar", "TEXT", false, 0, (String) null, 1));
            hashMap.put("advertiserAvatarPath", new m.a("advertiserAvatarPath", "TEXT", false, 0, (String) null, 1));
            hashMap.put("brand", new m.a("brand", "TEXT", false, 0, (String) null, 1));
            hashMap.put("denyBrand", new m.a("denyBrand", "TEXT", false, 0, (String) null, 1));
            hashMap.put("model", new m.a("model", "TEXT", false, 0, (String) null, 1));
            hashMap.put("denyModel", new m.a("denyModel", "TEXT", false, 0, (String) null, 1));
            hashMap.put("country", new m.a("country", "TEXT", false, 0, (String) null, 1));
            hashMap.put("scenes", new m.a("scenes", "TEXT", false, 0, (String) null, 1));
            hashMap.put("adSource", new m.a("adSource", "TEXT", false, 0, (String) null, 1));
            hashMap.put("extAdSlot", new m.a("extAdSlot", "TEXT", false, 0, (String) null, 1));
            hashMap.put("adMaterialList", new m.a("adMaterialList", "TEXT", false, 0, (String) null, 1));
            hashMap.put("adPlanUpdateTime", new m.a("adPlanUpdateTime", "TEXT", false, 0, (String) null, 1));
            hashMap.put("sort", new m.a("sort", "INTEGER", false, 0, (String) null, 1));
            hashMap.put("adShowLevel", new m.a("adShowLevel", "TEXT", false, 0, (String) null, 1));
            hashMap.put("filterClientVersion", new m.a("filterClientVersion", "TEXT", false, 0, (String) null, 1));
            hashMap.put("adPlanCreateTime", new m.a("adPlanCreateTime", "TEXT", false, 0, (String) null, 1));
            hashMap.put("appStarDesc", new m.a("appStarDesc", "TEXT", false, 0, (String) null, 1));
            hashMap.put("appSizeDesc", new m.a("appSizeDesc", "TEXT", false, 0, (String) null, 1));
            hashMap.put("ctxEnableExpr", new m.a("ctxEnableExpr", "TEXT", false, 0, (String) null, 1));
            hashMap.put("ctxDisableExpr", new m.a("ctxDisableExpr", "TEXT", false, 0, (String) null, 1));
            hashMap.put("ctxAttributeConfig", new m.a("ctxAttributeConfig", "TEXT", false, 0, (String) null, 1));
            hashMap.put("dispatchTimeStart", new m.a("dispatchTimeStart", "TEXT", false, 0, (String) null, 1));
            hashMap.put("dispatchTimeEnd", new m.a("dispatchTimeEnd", "TEXT", false, 0, (String) null, 1));
            hashMap.put("extImage", new m.a("extImage", "TEXT", false, 0, (String) null, 1));
            hashMap.put("bidEcpmCent", new m.a("bidEcpmCent", "REAL", false, 0, (String) null, 1));
            hashMap.put("ecpmCent", new m.a("ecpmCent", "INTEGER", false, 0, (String) null, 1));
            hashMap.put("isValid", new m.a("isValid", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("h5LinkPreload", new m.a("h5LinkPreload", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("h5LinkOpenByCct", new m.a("h5LinkOpenByCct", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("countryCode", new m.a("countryCode", "TEXT", false, 0, (String) null, 1));
            m mVar = new m("mb_ad_db_plans", hashMap, new HashSet(0), new HashSet(0));
            m a = m.a(bVar, "mb_ad_db_plans");
            if (!mVar.equals(a)) {
                return new f0.a(false, "mb_ad_db_plans(com.transsion.ad.db.plan.MbAdDbPlans).\n Expected:\n" + mVar + "\n Found:\n" + a);
            }
            HashMap hashMap2 = new HashMap(5);
            hashMap2.put("id", new m.a("id", "INTEGER", true, 1, (String) null, 1));
            hashMap2.put("Country", new m.a("Country", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("Mcc", new m.a("Mcc", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("Iso", new m.a("Iso", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("CountryCode", new m.a("CountryCode", "TEXT", true, 0, (String) null, 1));
            m mVar2 = new m("local_mcc", hashMap2, new HashSet(0), new HashSet(0));
            m a2 = m.a(bVar, "local_mcc");
            if (!mVar2.equals(a2)) {
                return new f0.a(false, "local_mcc(com.transsion.ad.db.mcc.LocalMcc).\n Expected:\n" + mVar2 + "\n Found:\n" + a2);
            }
            HashMap hashMap3 = new HashMap(15);
            hashMap3.put("id", new m.a("id", "INTEGER", true, 1, (String) null, 1));
            hashMap3.put("nonId", new m.a("nonId", "TEXT", true, 0, (String) null, 1));
            hashMap3.put("adSource", new m.a("adSource", "TEXT", true, 0, (String) null, 1));
            hashMap3.put("extAdSlot", new m.a("extAdSlot", "TEXT", true, 0, (String) null, 1));
            hashMap3.put("rank", new m.a("rank", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("psPlanId", new m.a("psPlanId", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("psLinkAdInfoStr", new m.a("psLinkAdInfoStr", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("psInfoJson", new m.a("psInfoJson", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("updateTimestamp", new m.a("updateTimestamp", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("showMax", new m.a("showMax", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("clickMax", new m.a("clickMax", "INTEGER", false, 0, (String) null, 1));
            hashMap3.put("showHours", new m.a("showHours", "TEXT", false, 0, (String) null, 1));
            hashMap3.put("showedTimes", new m.a("showedTimes", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("clickedTimes", new m.a("clickedTimes", "INTEGER", true, 0, (String) null, 1));
            hashMap3.put("showDate", new m.a("showDate", "TEXT", false, 0, (String) null, 1));
            m mVar3 = new m("ps_link_ad", hashMap3, new HashSet(0), new HashSet(0));
            m a3 = m.a(bVar, "ps_link_ad");
            if (!mVar3.equals(a3)) {
                return new f0.a(false, "ps_link_ad(com.transsion.ad.db.pslink.PsLinkAdPlan).\n Expected:\n" + mVar3 + "\n Found:\n" + a3);
            }
            HashMap hashMap4 = new HashMap(6);
            hashMap4.put("id", new m.a("id", "INTEGER", true, 1, (String) null, 1));
            hashMap4.put("psId", new m.a("psId", "TEXT", true, 0, (String) null, 1));
            hashMap4.put("failCount", new m.a("failCount", "INTEGER", true, 0, (String) null, 1));
            hashMap4.put("reportUrl", new m.a("reportUrl", "TEXT", true, 0, (String) null, 1));
            hashMap4.put("type", new m.a("type", "TEXT", true, 0, (String) null, 1));
            hashMap4.put("updateTimestamp", new m.a("updateTimestamp", "INTEGER", true, 0, (String) null, 1));
            m mVar4 = new m("attribution_points", hashMap4, new HashSet(0), new HashSet(0));
            m a4 = m.a(bVar, "attribution_points");
            if (!mVar4.equals(a4)) {
                return new f0.a(false, "attribution_points(com.transsion.ad.db.pslink.AttributionPoint).\n Expected:\n" + mVar4 + "\n Found:\n" + a4);
            }
            HashMap hashMap5 = new HashMap(9);
            hashMap5.put("packageName", new m.a("packageName", "TEXT", true, 1, (String) null, 1));
            hashMap5.put("source", new m.a("source", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("appName", new m.a("appName", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("versionName", new m.a("versionName", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("versionCode", new m.a("versionCode", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("horizontalImageUrl", new m.a("horizontalImageUrl", "TEXT", false, 0, (String) null, 1));
            hashMap5.put("eCPM", new m.a("eCPM", "REAL", false, 0, (String) null, 1));
            hashMap5.put("installTime", new m.a("installTime", "INTEGER", false, 0, (String) null, 1));
            hashMap5.put("lastOpenTime", new m.a("lastOpenTime", "INTEGER", false, 0, (String) null, 1));
            m mVar5 = new m("app_installed", hashMap5, new HashSet(0), new HashSet(0));
            m a5 = m.a(bVar, "app_installed");
            if (!mVar5.equals(a5)) {
                return new f0.a(false, "app_installed(com.transsion.ad.db.pslink.AppInstalledBean).\n Expected:\n" + mVar5 + "\n Found:\n" + a5);
            }
            HashMap hashMap6 = new HashMap(4);
            hashMap6.put("sceneId", new m.a("sceneId", "TEXT", true, 1, (String) null, 1));
            hashMap6.put("lastDisplayAdDate", new m.a("lastDisplayAdDate", "TEXT", true, 0, (String) null, 1));
            hashMap6.put("lastDisplayAdTimestamp", new m.a("lastDisplayAdTimestamp", "INTEGER", true, 0, (String) null, 1));
            hashMap6.put("displayTimes", new m.a("displayTimes", "INTEGER", true, 0, (String) null, 1));
            m mVar6 = new m("ad_scene_limit_table", hashMap6, new HashSet(0), new HashSet(0));
            m a6 = m.a(bVar, "ad_scene_limit_table");
            if (mVar6.equals(a6)) {
                return new f0.a(true, (String) null);
            }
            return new f0.a(false, "ad_scene_limit_table(com.transsion.ad.db.scene.AdSceneLimit).\n Expected:\n" + mVar6 + "\n Found:\n" + a6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public f0 r() {
        return new a(13, "58697ca485708a9a9f5014d94ad4e49f", "23771ee6f669098e06c09fa707e93285");
    }

    public Set C() {
        return new HashSet();
    }

    protected Map F() {
        HashMap hashMap = new HashMap();
        hashMap.put(uh.a.class, j.q());
        hashMap.put(th.a.class, f.i());
        hashMap.put(l.class, t.o());
        hashMap.put(com.transsion.ad.db.pslink.a.class, com.transsion.ad.db.pslink.b.l());
        hashMap.put(vh.a.class, vh.f.i());
        hashMap.put(AdSceneLimitDao.class, g.m());
        return hashMap;
    }

    protected InvalidationTracker q() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"mb_ad_db_plans", "local_mcc", "ps_link_ad", "attribution_points", "app_installed", "ad_scene_limit_table"});
    }

    @Override // com.transsion.ad.db.MbAdDatabase
    public AdSceneLimitDao u0() {
        AdSceneLimitDao adSceneLimitDao;
        if (this.I != null) {
            return this.I;
        }
        synchronized (this) {
            try {
                if (this.I == null) {
                    this.I = new g(this);
                }
                adSceneLimitDao = this.I;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return adSceneLimitDao;
    }

    public List v(Map map) {
        return new ArrayList();
    }

    @Override // com.transsion.ad.db.MbAdDatabase
    public vh.a v0() {
        vh.a aVar;
        if (this.H != null) {
            return this.H;
        }
        synchronized (this) {
            try {
                if (this.H == null) {
                    this.H = new vh.f(this);
                }
                aVar = this.H;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // com.transsion.ad.db.MbAdDatabase
    public com.transsion.ad.db.pslink.a w0() {
        com.transsion.ad.db.pslink.a aVar;
        if (this.G != null) {
            return this.G;
        }
        synchronized (this) {
            try {
                if (this.G == null) {
                    this.G = new com.transsion.ad.db.pslink.b(this);
                }
                aVar = this.G;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // com.transsion.ad.db.MbAdDatabase
    public th.a x0() {
        th.a aVar;
        if (this.E != null) {
            return this.E;
        }
        synchronized (this) {
            try {
                if (this.E == null) {
                    this.E = new f(this);
                }
                aVar = this.E;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // com.transsion.ad.db.MbAdDatabase
    public uh.a y0() {
        uh.a aVar;
        if (this.D != null) {
            return this.D;
        }
        synchronized (this) {
            try {
                if (this.D == null) {
                    this.D = new j(this);
                }
                aVar = this.D;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    @Override // com.transsion.ad.db.MbAdDatabase
    public l z0() {
        l lVar;
        if (this.F != null) {
            return this.F;
        }
        synchronized (this) {
            try {
                if (this.F == null) {
                    this.F = new t(this);
                }
                lVar = this.F;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return lVar;
    }
}
