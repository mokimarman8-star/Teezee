package com.transsion.ad.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.s;
import com.transsion.ad.db.scene.AdSceneLimitDao;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/transsion/ad/db/MbAdDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Luh/a;", "y0", "()Luh/a;", "Lth/a;", "x0", "()Lth/a;", "Lvh/l;", "z0", "()Lvh/l;", "Lcom/transsion/ad/db/pslink/a;", "w0", "()Lcom/transsion/ad/db/pslink/a;", "Lvh/a;", "v0", "()Lvh/a;", "Lcom/transsion/ad/db/scene/AdSceneLimitDao;", "u0", "()Lcom/transsion/ad/db/scene/AdSceneLimitDao;", "p", "m", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class MbAdDatabase extends RoomDatabase {
    private static volatile MbAdDatabase q;

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final d r = new d();
    private static final e s = new e();
    private static final f t = new f();
    private static final g u = new g();
    private static final h v = new h();
    private static final i w = new i();
    private static final j x = new j();
    private static final k y = new k();
    private static final l z = new l();
    private static final a A = new a();
    private static final b B = new b();
    private static final c C = new c();

    public static final class a extends x3.b {
        a() {
            super(10, 11);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("ALTER TABLE mb_ad_db_plans ADD COLUMN countryCode TEXT");
        }
    }

    public static final class b extends x3.b {
        b() {
            super(11, 12);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("CREATE TABLE IF NOT EXISTS app_installed (\n    packageName TEXT PRIMARY KEY NOT NULL,\n    source TEXT,\n    appName TEXT,\n    versionName TEXT,\n    versionCode TEXT,\n    horizontalImageUrl TEXT,\n    eCPM REAL,\n    installTime INTEGER,\n    lastOpenTime INTEGER\n)");
        }
    }

    public static final class c extends x3.b {
        c() {
            super(12, 13);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("CREATE TABLE IF NOT EXISTS ad_scene_limit_table (\n    sceneId TEXT NOT NULL PRIMARY KEY,\n    lastDisplayAdDate TEXT NOT NULL,\n    lastDisplayAdTimestamp INTEGER NOT NULL DEFAULT 0,\n    displayTimes INTEGER NOT NULL DEFAULT 0\n)");
        }
    }

    public static final class d extends x3.b {
        d() {
            super(1, 2);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("ALTER TABLE MB_AD_DB_PLANS ADD COLUMN dispatchTimeStart TEXT");
            dVar.E("ALTER TABLE MB_AD_DB_PLANS ADD COLUMN dispatchTimeEnd TEXT");
        }
    }

    public static final class e extends x3.b {
        e() {
            super(2, 3);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("CREATE TABLE IF NOT EXISTS LOCAL_MCC (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Country` TEXT NOT NULL, `Mcc` TEXT NOT NULL, `Iso` TEXT NOT NULL, `CountryCode` TEXT NOT NULL)");
        }
    }

    public static final class f extends x3.b {
        f() {
            super(3, 4);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("ALTER TABLE MB_AD_DB_PLANS ADD COLUMN adSource TEXT");
            dVar.E("ALTER TABLE MB_AD_DB_PLANS ADD COLUMN extAdSlot TEXT");
            dVar.E("CREATE TABLE IF NOT EXISTS ps_link_ad (`id` INTEGER NOT NULL,`nonId` TEXT NOT NULL, `adSource` TEXT NOT NULL, `extAdSlot` TEXT NOT NULL, `rank` INTEGER NOT NULL, `psPlanId` TEXT, `psLinkAdInfoStr` TEXT, `psInfoJson` TEXT, PRIMARY KEY(`id`))");
            dVar.E("ALTER TABLE MB_AD_DB_PLANS ADD COLUMN extImage TEXT");
        }
    }

    public static final class g extends x3.b {
        g() {
            super(4, 5);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("ALTER TABLE mb_ad_db_plans ADD COLUMN bidEcpmCent REAL");
            dVar.E("ALTER TABLE mb_ad_db_plans ADD COLUMN ecpmCent INTEGER");
        }
    }

    public static final class h extends x3.b {
        h() {
            super(5, 6);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("ALTER TABLE ps_link_ad ADD COLUMN updateTimestamp INTEGER");
            dVar.E("CREATE TABLE IF NOT EXISTS `attribution_points` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `psId` TEXT NOT NULL, `failCount` INTEGER NOT NULL, `reportUrl` TEXT NOT NULL, `type` TEXT NOT NULL, `updateTimestamp` INTEGER NOT NULL)");
        }
    }

    public static final class i extends x3.b {
        i() {
            super(6, 7);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("ALTER TABLE mb_ad_db_plans ADD COLUMN isValid INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static final class j extends x3.b {
        j() {
            super(7, 8);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("ALTER TABLE ps_link_ad ADD COLUMN showMax INTEGER");
            dVar.E("ALTER TABLE ps_link_ad ADD COLUMN clickMax INTEGER");
            dVar.E("ALTER TABLE ps_link_ad ADD COLUMN showHours TEXT");
            dVar.E("ALTER TABLE ps_link_ad ADD COLUMN showedTimes INTEGER NOT NULL DEFAULT 0");
            dVar.E("ALTER TABLE ps_link_ad ADD COLUMN clickedTimes INTEGER NOT NULL DEFAULT 0");
            dVar.E("ALTER TABLE ps_link_ad ADD COLUMN showDate TEXT");
        }
    }

    public static final class k extends x3.b {
        k() {
            super(8, 9);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("ALTER TABLE mb_ad_db_plans ADD COLUMN h5LinkPreload INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static final class l extends x3.b {
        l() {
            super(9, 10);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("ALTER TABLE mb_ad_db_plans ADD COLUMN h5LinkOpenByCct INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* renamed from: com.transsion.ad.db.MbAdDatabase$m, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.transsion.ad.db.MbAdDatabase$m$a */
        public static final class a extends RoomDatabase.b {
            a() {
            }

            public void b(z3.d dVar) {
                Intrinsics.h(dVar, "db");
                super.b(dVar);
                xh.a.c(xh.a.a, Reflection.b(MbAdDatabase.class).g() + " --> getInstance() --> buildDatabase() --> onCreate() --> db.path = " + dVar.getPath(), 0, false, 6, null);
            }

            public void f(z3.d dVar) {
                Intrinsics.h(dVar, "db");
                super.f(dVar);
                xh.a.c(xh.a.a, Reflection.b(MbAdDatabase.class).g() + " --> getInstance() --> buildDatabase() --> onOpen()", 0, false, 6, null);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final MbAdDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            return (MbAdDatabase) s.a(applicationContext, MbAdDatabase.class, "mb-ad-plans-db").b(new x3.b[]{MbAdDatabase.r, MbAdDatabase.s, MbAdDatabase.t, MbAdDatabase.u, MbAdDatabase.v, MbAdDatabase.w, MbAdDatabase.x, MbAdDatabase.y, MbAdDatabase.z, MbAdDatabase.A, MbAdDatabase.B, MbAdDatabase.C}).a(new a()).d();
        }

        public final MbAdDatabase b(Context context) {
            Intrinsics.h(context, "context");
            MbAdDatabase mbAdDatabase = MbAdDatabase.q;
            if (mbAdDatabase == null) {
                synchronized (this) {
                    mbAdDatabase = MbAdDatabase.q;
                    if (mbAdDatabase == null) {
                        MbAdDatabase a2 = MbAdDatabase.INSTANCE.a(context);
                        MbAdDatabase.q = a2;
                        mbAdDatabase = a2;
                    }
                }
            }
            return mbAdDatabase;
        }
    }

    public abstract AdSceneLimitDao u0();

    public abstract vh.a v0();

    public abstract com.transsion.ad.db.pslink.a w0();

    public abstract th.a x0();

    public abstract uh.a y0();

    public abstract vh.l z0();
}
