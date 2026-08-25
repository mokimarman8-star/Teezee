package a4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import z3.a;
import z3.g;
import z3.h;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class f implements z3.d {
    public static final a b = new a((DefaultConstructorMarker) null);
    private static final String[] c = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] d = new String[0];
    private static final Lazy e;
    private static final Lazy f;
    private final SQLiteDatabase a;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        e = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: a4.d
            public final Object invoke() {
                Method q;
                q = f.q();
                return q;
            }
        });
        f = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: a4.e
            public final Object invoke() {
                Method o;
                o = f.o();
                return o;
            }
        });
    }

    public f(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.h(sQLiteDatabase, "delegate");
        this.a = sQLiteDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method o() {
        Class<?> returnType;
        try {
            Method b2 = a.b(b);
            if (b2 == null || (returnType = b2.getReturnType()) == null) {
                return null;
            }
            Class<?> cls = Integer.TYPE;
            return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method q() {
        try {
            Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private final void r(SQLiteTransactionListener sQLiteTransactionListener) {
        a aVar = b;
        if (a.a(aVar) == null || a.b(aVar) == null) {
            if (sQLiteTransactionListener != null) {
                p(sQLiteTransactionListener);
                return;
            } else {
                A();
                return;
            }
        }
        Method a = a.a(aVar);
        Intrinsics.e(a);
        Method b2 = a.b(aVar);
        Intrinsics.e(b2);
        Object invoke = b2.invoke(this.a, null);
        if (invoke == null) {
            throw new IllegalStateException("Required value was null.");
        }
        a.invoke(invoke, 0, sQLiteTransactionListener, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteCursor t(g gVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.e(sQLiteQuery);
        gVar.b(new i(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor u(Function4 function4, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return (Cursor) function4.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor v(g gVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.e(sQLiteQuery);
        gVar.b(new i(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public void A() {
        this.a.beginTransaction();
    }

    public List D() {
        return this.a.getAttachedDbs();
    }

    public void E(String str) {
        Intrinsics.h(str, "sql");
        this.a.execSQL(str);
    }

    public void I() {
        this.a.setTransactionSuccessful();
    }

    public void J(String str, Object[] objArr) {
        Intrinsics.h(str, "sql");
        Intrinsics.h(objArr, "bindArgs");
        this.a.execSQL(str, objArr);
    }

    public void K() {
        this.a.beginTransactionNonExclusive();
    }

    public void L() {
        this.a.endTransaction();
    }

    public void U(int i) {
        this.a.setVersion(i);
    }

    public h Y(String str) {
        Intrinsics.h(str, "sql");
        SQLiteStatement compileStatement = this.a.compileStatement(str);
        Intrinsics.g(compileStatement, "compileStatement(...)");
        return new j(compileStatement);
    }

    public Cursor a0(g gVar, CancellationSignal cancellationSignal) {
        Intrinsics.h(gVar, "query");
        SQLiteDatabase sQLiteDatabase = this.a;
        a aVar = new a(gVar);
        String d2 = gVar.d();
        String[] strArr = d;
        Intrinsics.e(cancellationSignal);
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(aVar, d2, strArr, null, cancellationSignal);
        Intrinsics.g(rawQueryWithFactory, "rawQueryWithFactory(...)");
        return rawQueryWithFactory;
    }

    public Cursor b0(g gVar) {
        Intrinsics.h(gVar, "query");
        Cursor rawQueryWithFactory = this.a.rawQueryWithFactory(new c(new b(gVar)), gVar.d(), d, null);
        Intrinsics.g(rawQueryWithFactory, "rawQueryWithFactory(...)");
        return rawQueryWithFactory;
    }

    public void c0() {
        r(null);
    }

    public void close() {
        this.a.close();
    }

    public String getPath() {
        return this.a.getPath();
    }

    public int getVersion() {
        return this.a.getVersion();
    }

    public int i0(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        Intrinsics.h(str, "table");
        Intrinsics.h(contentValues, "values");
        if (contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        int size = contentValues.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(c[i]);
        sb.append(str);
        sb.append(" SET ");
        int i2 = 0;
        for (String str3 : contentValues.keySet()) {
            sb.append(i2 > 0 ? "," : "");
            sb.append(str3);
            objArr2[i2] = contentValues.get(str3);
            sb.append("=?");
            i2++;
        }
        if (objArr != null) {
            for (int i3 = size; i3 < length; i3++) {
                objArr2[i3] = objArr[i3 - size];
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        h Y = Y(sb.toString());
        a.c.b(Y, objArr2);
        return Y.F();
    }

    public boolean isOpen() {
        return this.a.isOpen();
    }

    public Cursor m0(String str) {
        Intrinsics.h(str, "query");
        return b0(new a(str));
    }

    public long n0(String str, int i, ContentValues contentValues) {
        Intrinsics.h(str, "table");
        Intrinsics.h(contentValues, "values");
        return this.a.insertWithOnConflict(str, null, contentValues, i);
    }

    public void p(SQLiteTransactionListener sQLiteTransactionListener) {
        Intrinsics.h(sQLiteTransactionListener, "transactionListener");
        this.a.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public final boolean s(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.h(sQLiteDatabase, "sqLiteDatabase");
        return Intrinsics.c(this.a, sQLiteDatabase);
    }

    public boolean v0() {
        return this.a.inTransaction();
    }

    public boolean z0() {
        return this.a.isWriteAheadLoggingEnabled();
    }
}
