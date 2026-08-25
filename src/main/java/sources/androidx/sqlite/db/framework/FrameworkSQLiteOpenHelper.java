package androidx.sqlite.db.framework;

import a4.f;
import a4.g;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import c4.a;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import z3.b;
import z3.d;
import z3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class FrameworkSQLiteOpenHelper implements e {
    public static final a h = new a((DefaultConstructorMarker) null);
    private final Context a;
    private final String b;
    private final e.a c;
    private final boolean d;
    private final boolean e;
    private final Lazy f;
    private boolean g;

    private static final class OpenHelper extends SQLiteOpenHelper {
        public static final a h = new a((DefaultConstructorMarker) null);
        private final Context a;
        private final b b;
        private final e.a c;
        private final boolean d;
        private boolean e;
        private final a f;
        private boolean g;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "callbackName", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "cause", "", "<init>", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;Ljava/lang/Throwable;)V", "getCallbackName", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "getCause", "()Ljava/lang/Throwable;", "sqlite-framework_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName, Throwable th) {
                super(th);
                Intrinsics.h(callbackName, "callbackName");
                Intrinsics.h(th, "cause");
                this.callbackName = callbackName;
                this.cause = th;
            }

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.cause;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, b bVar, e.a aVar, boolean z) {
            super(context, str, null, aVar.a, new a(aVar, bVar));
            Intrinsics.h(context, "context");
            Intrinsics.h(bVar, "dbRef");
            Intrinsics.h(aVar, "callback");
            this.a = context;
            this.b = bVar;
            this.c = aVar;
            this.d = z;
            if (str == null) {
                str = UUID.randomUUID().toString();
                Intrinsics.g(str, "toString(...)");
            }
            this.f = new a(str, context.getCacheDir(), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(e.a aVar, b bVar, SQLiteDatabase sQLiteDatabase) {
            a aVar2 = h;
            Intrinsics.e(sQLiteDatabase);
            aVar.c(aVar2.a(bVar, sQLiteDatabase));
        }

        private final SQLiteDatabase j(boolean z) {
            if (z) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                Intrinsics.e(writableDatabase);
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            Intrinsics.e(readableDatabase);
            return readableDatabase;
        }

        private final SQLiteDatabase k(boolean z) {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z2 = this.g;
            if (databaseName != null && !z2 && (parentFile = this.a.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return j(z);
            } catch (Throwable unused) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return j(z);
                } catch (Throwable th) {
                    th = th;
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = (CallbackException) th;
                        Throwable cause = callbackException.getCause();
                        int i = b.a[callbackException.getCallbackName().ordinal()];
                        if (i == 1) {
                            throw cause;
                        }
                        if (i == 2) {
                            throw cause;
                        }
                        if (i == 3) {
                            throw cause;
                        }
                        if (i == 4) {
                            throw cause;
                        }
                        if (i != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (!(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                        th = cause;
                    }
                    if (!(th instanceof SQLiteException) || databaseName == null || !this.d) {
                        throw th;
                    }
                    this.a.deleteDatabase(databaseName);
                    try {
                        return j(z);
                    } catch (CallbackException e) {
                        throw e.getCause();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                a.c(this.f, false, 1, (Object) null);
                super.close();
                this.b.b((f) null);
                this.g = false;
            } finally {
                this.f.d();
            }
        }

        public final d f(boolean z) {
            try {
                this.f.b((this.g || getDatabaseName() == null) ? false : true);
                this.e = false;
                SQLiteDatabase k = k(z);
                if (!this.e) {
                    f h2 = h(k);
                    this.f.d();
                    return h2;
                }
                close();
                d f = f(z);
                this.f.d();
                return f;
            } catch (Throwable th) {
                this.f.d();
                throw th;
            }
        }

        public final f h(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.h(sQLiteDatabase, "sqLiteDatabase");
            return h.a(this.b, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.h(sQLiteDatabase, "db");
            if (!this.e && this.c.a != sQLiteDatabase.getVersion()) {
                sQLiteDatabase.setMaxSqlCacheSize(1);
            }
            try {
                this.c.b(h(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.h(sQLiteDatabase, "sqLiteDatabase");
            try {
                this.c.d(h(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Intrinsics.h(sQLiteDatabase, "db");
            this.e = true;
            try {
                this.c.e(h(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.h(sQLiteDatabase, "db");
            if (!this.e) {
                try {
                    this.c.f(h(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.g = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Intrinsics.h(sQLiteDatabase, "sqLiteDatabase");
            this.e = true;
            try {
                this.c.g(h(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, e.a aVar, boolean z, boolean z2) {
        Intrinsics.h(context, "context");
        Intrinsics.h(aVar, "callback");
        this.a = context;
        this.b = str;
        this.c = aVar;
        this.d = z;
        this.e = z2;
        this.f = LazyKt.b(new g(this));
    }

    private final OpenHelper d() {
        return (OpenHelper) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OpenHelper f(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        OpenHelper openHelper;
        if (frameworkSQLiteOpenHelper.b == null || !frameworkSQLiteOpenHelper.d) {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.a, frameworkSQLiteOpenHelper.b, new b((f) null), frameworkSQLiteOpenHelper.c, frameworkSQLiteOpenHelper.e);
        } else {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.a, new File(b.a(frameworkSQLiteOpenHelper.a), frameworkSQLiteOpenHelper.b).getAbsolutePath(), new b((f) null), frameworkSQLiteOpenHelper.c, frameworkSQLiteOpenHelper.e);
        }
        openHelper.setWriteAheadLoggingEnabled(frameworkSQLiteOpenHelper.g);
        return openHelper;
    }

    public void close() {
        if (this.f.isInitialized()) {
            d().close();
        }
    }

    public String getDatabaseName() {
        return this.b;
    }

    public d getReadableDatabase() {
        return d().f(false);
    }

    public d getWritableDatabase() {
        return d().f(true);
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        if (this.f.isInitialized()) {
            d().setWriteAheadLoggingEnabled(z);
        }
        this.g = z;
    }
}
