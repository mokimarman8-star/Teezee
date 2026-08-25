package com.transsion.shorttv.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.s;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/transsion/shorttv/db/ShortTvDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/transsion/shorttv/db/ShortTvFavoriteDao;", "k0", "()Lcom/transsion/shorttv/db/ShortTvFavoriteDao;", "Lcom/transsion/shorttv/db/ShortTvAdUnlockDao;", "j0", "()Lcom/transsion/shorttv/db/ShortTvAdUnlockDao;", "p", "b", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class ShortTvDatabase extends RoomDatabase {

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final x3.b q = new a();
    private static volatile ShortTvDatabase r;

    public static final class a extends x3.b {
        a() {
            super(1, 2);
        }

        public void b(z3.d dVar) {
            Intrinsics.h(dVar, "db");
            dVar.E("CREATE TABLE IF NOT EXISTS `short_tv_ad_unlock_state` (`subjectId` TEXT NOT NULL, `unlockedEps` TEXT NOT NULL, PRIMARY KEY(`subjectId`))");
        }
    }

    /* renamed from: com.transsion.shorttv.db.ShortTvDatabase$b, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.transsion.shorttv.db.ShortTvDatabase$b$a */
        public static final class a extends RoomDatabase.b {
            a() {
            }

            public void b(z3.d dVar) {
                Intrinsics.h(dVar, "db");
                super.b(dVar);
            }

            public void f(z3.d dVar) {
                Intrinsics.h(dVar, "db");
                super.f(dVar);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ShortTvDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            return (ShortTvDatabase) s.a(applicationContext, ShortTvDatabase.class, "or-short-tv-db").c().b(new x3.b[]{c()}).a(new a()).d();
        }

        public final ShortTvDatabase b(Context context) {
            Intrinsics.h(context, "context");
            ShortTvDatabase shortTvDatabase = ShortTvDatabase.r;
            if (shortTvDatabase == null) {
                synchronized (this) {
                    shortTvDatabase = ShortTvDatabase.r;
                    if (shortTvDatabase == null) {
                        ShortTvDatabase a2 = ShortTvDatabase.INSTANCE.a(context);
                        ShortTvDatabase.r = a2;
                        shortTvDatabase = a2;
                    }
                }
            }
            return shortTvDatabase;
        }

        public final x3.b c() {
            return ShortTvDatabase.q;
        }
    }

    public abstract ShortTvAdUnlockDao j0();

    public abstract ShortTvFavoriteDao k0();
}
