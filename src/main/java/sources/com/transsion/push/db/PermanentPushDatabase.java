package com.transsion.push.db;

import android.content.Context;
import android.util.Log;
import androidx.room.RoomDatabase;
import androidx.room.s;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/transsion/push/db/PermanentPushDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/transsion/push/db/a;", "i0", "()Lcom/transsion/push/db/a;", "p", "a", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class PermanentPushDatabase extends RoomDatabase {

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile PermanentPushDatabase q;

    /* renamed from: com.transsion.push.db.PermanentPushDatabase$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.transsion.push.db.PermanentPushDatabase$a$a, reason: collision with other inner class name */
        public static final class C0053a extends RoomDatabase.b {
            C0053a() {
            }

            public void b(z3.d dVar) {
                Intrinsics.h(dVar, "db");
                super.b(dVar);
                Log.e("PUSH_SHOW", "PermanentPushDatabase --> getInstance() --> buildDatabase() --> onCreate() --> db_name is = " + dVar.getPath());
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final PermanentPushDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            return (PermanentPushDatabase) s.a(applicationContext, PermanentPushDatabase.class, "permanent_database").a(new C0053a()).d();
        }

        public final PermanentPushDatabase b(Context context) {
            Intrinsics.h(context, "context");
            PermanentPushDatabase permanentPushDatabase = PermanentPushDatabase.q;
            if (permanentPushDatabase == null) {
                synchronized (this) {
                    permanentPushDatabase = PermanentPushDatabase.q;
                    if (permanentPushDatabase == null) {
                        PermanentPushDatabase a = PermanentPushDatabase.INSTANCE.a(context);
                        PermanentPushDatabase.q = a;
                        permanentPushDatabase = a;
                    }
                }
            }
            return permanentPushDatabase;
        }
    }

    public abstract a i0();
}
