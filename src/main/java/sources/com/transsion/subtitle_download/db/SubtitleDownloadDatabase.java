package com.transsion.subtitle_download.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.s;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import z3.d;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/transsion/subtitle_download/db/SubtitleDownloadDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lqt/a;", "l0", "()Lqt/a;", "p", "d", "SubtitleDownload_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class SubtitleDownloadDatabase extends RoomDatabase {
    private static volatile SubtitleDownloadDatabase q;

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final a r = new a();
    private static final b s = new b();
    private static final c t = new c();

    public static final class a extends x3.b {
        a() {
            super(1, 2);
        }

        public void b(d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE ST_DOWNLOAD_TABLE ADD COLUMN failCount INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static final class b extends x3.b {
        b() {
            super(2, 3);
        }

        public void b(d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE ST_DOWNLOAD_TABLE ADD COLUMN ugcVideoId TEXT");
            database.E("ALTER TABLE ST_DOWNLOAD_TABLE ADD COLUMN ugcVideoCollectionId TEXT");
        }
    }

    public static final class c extends x3.b {
        c() {
            super(3, 4);
        }

        public void b(d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE ST_DOWNLOAD_TABLE ADD COLUMN ops TEXT");
        }
    }

    /* renamed from: com.transsion.subtitle_download.db.SubtitleDownloadDatabase$d, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.transsion.subtitle_download.db.SubtitleDownloadDatabase$d$a */
        public static final class a extends RoomDatabase.b {
            a() {
            }

            public void b(d db) {
                Intrinsics.h(db, "db");
                super.b(db);
                com.transsion.subtitle_download.utils.b.a.b("SubtitleDownloadDataBase --> getInstance() --> buildDatabase() --> onCreate() --> db_name is = " + db.getPath());
            }

            public void f(d db) {
                Intrinsics.h(db, "db");
                super.f(db);
                com.transsion.subtitle_download.utils.b.a.b("SubtitleDownloadDataBase --> getInstance() --> buildDatabase() --> onOpen()");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SubtitleDownloadDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            return (SubtitleDownloadDatabase) s.a(applicationContext, SubtitleDownloadDatabase.class, "oneroom-subtitle-db").c().b(new x3.b[]{SubtitleDownloadDatabase.r, SubtitleDownloadDatabase.s, SubtitleDownloadDatabase.t}).a(new a()).d();
        }

        public final SubtitleDownloadDatabase b(Context context) {
            Intrinsics.h(context, "context");
            SubtitleDownloadDatabase subtitleDownloadDatabase = SubtitleDownloadDatabase.q;
            if (subtitleDownloadDatabase == null) {
                synchronized (this) {
                    subtitleDownloadDatabase = SubtitleDownloadDatabase.q;
                    if (subtitleDownloadDatabase == null) {
                        SubtitleDownloadDatabase a2 = SubtitleDownloadDatabase.INSTANCE.a(context);
                        SubtitleDownloadDatabase.q = a2;
                        subtitleDownloadDatabase = a2;
                    }
                }
            }
            return subtitleDownloadDatabase;
        }
    }

    public abstract qt.a l0();
}
