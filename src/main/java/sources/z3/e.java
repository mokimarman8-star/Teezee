package z3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface e extends Closeable {

    public static abstract class a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0188a f18866b = new C0188a(null);

        /* renamed from: a, reason: collision with root package name */
        public final int f18867a;

        /* renamed from: z3.e$a$a, reason: collision with other inner class name */
        public static final class C0188a {
            private C0188a() {
            }

            public /* synthetic */ C0188a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(int i5) {
            this.f18867a = i5;
        }

        private final void a(String str) {
            if (StringsKt.H(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i5 = 0;
            boolean z5 = false;
            while (i5 <= length) {
                boolean z6 = Intrinsics.j(str.charAt(!z5 ? i5 : length), 32) <= 0;
                if (z5) {
                    if (!z6) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z6) {
                    i5++;
                } else {
                    z5 = true;
                }
            }
            if (str.subSequence(i5, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e5) {
                Log.w("SupportSQLite", "delete failed: ", e5);
            }
        }

        public void b(d dVar) {
            Intrinsics.h(dVar, "db");
        }

        public void c(d dVar) {
            Intrinsics.h(dVar, "db");
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + dVar + ".path");
            if (!dVar.isOpen()) {
                String path = dVar.getPath();
                if (path != null) {
                    a(path);
                    return;
                }
                return;
            }
            List list = null;
            try {
                try {
                    list = dVar.D();
                } catch (SQLiteException unused) {
                }
                try {
                    dVar.close();
                } catch (IOException unused2) {
                }
                if (list != null) {
                    return;
                }
            } finally {
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Object obj = ((Pair) it.next()).second;
                        Intrinsics.g(obj, "second");
                        a((String) obj);
                    }
                } else {
                    String path2 = dVar.getPath();
                    if (path2 != null) {
                        a(path2);
                    }
                }
            }
        }

        public abstract void d(d dVar);

        public void e(d dVar, int i5, int i6) {
            Intrinsics.h(dVar, "db");
            throw new SQLiteException("Can't downgrade database from version " + i5 + " to " + i6);
        }

        public void f(d dVar) {
            Intrinsics.h(dVar, "db");
        }

        public abstract void g(d dVar, int i5, int i6);
    }

    public static final class b {

        /* renamed from: f, reason: collision with root package name */
        public static final C0189b f18868f = new C0189b(null);

        /* renamed from: a, reason: collision with root package name */
        public final Context f18869a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18870b;

        /* renamed from: c, reason: collision with root package name */
        public final a f18871c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f18872d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f18873e;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private final Context f18874a;

            /* renamed from: b, reason: collision with root package name */
            private String f18875b;

            /* renamed from: c, reason: collision with root package name */
            private a f18876c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f18877d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f18878e;

            public a(Context context) {
                Intrinsics.h(context, "context");
                this.f18874a = context;
            }

            public a a(boolean z5) {
                this.f18878e = z5;
                return this;
            }

            public b b() {
                String str;
                a aVar = this.f18876c;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.f18877d && ((str = this.f18875b) == null || str.length() == 0)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.f18874a, this.f18875b, aVar, this.f18877d, this.f18878e);
            }

            public a c(a aVar) {
                Intrinsics.h(aVar, "callback");
                this.f18876c = aVar;
                return this;
            }

            public a d(String str) {
                this.f18875b = str;
                return this;
            }

            public a e(boolean z5) {
                this.f18877d = z5;
                return this;
            }
        }

        /* renamed from: z3.e$b$b, reason: collision with other inner class name */
        public static final class C0189b {
            private C0189b() {
            }

            public /* synthetic */ C0189b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a(Context context) {
                Intrinsics.h(context, "context");
                return new a(context);
            }
        }

        public b(Context context, String str, a aVar, boolean z5, boolean z6) {
            Intrinsics.h(context, "context");
            Intrinsics.h(aVar, "callback");
            this.f18869a = context;
            this.f18870b = str;
            this.f18871c = aVar;
            this.f18872d = z5;
            this.f18873e = z6;
        }

        public static final a a(Context context) {
            return f18868f.a(context);
        }
    }

    public interface c {
        e a(b bVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    d getReadableDatabase();

    d getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z5);
}
