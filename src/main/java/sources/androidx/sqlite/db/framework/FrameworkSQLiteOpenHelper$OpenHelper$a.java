package androidx.sqlite.db.framework;

import a4.f;
import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class FrameworkSQLiteOpenHelper$OpenHelper$a {
    private FrameworkSQLiteOpenHelper$OpenHelper$a() {
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper$OpenHelper$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final f a(FrameworkSQLiteOpenHelper$b frameworkSQLiteOpenHelper$b, SQLiteDatabase sQLiteDatabase) {
        Intrinsics.h(frameworkSQLiteOpenHelper$b, "refHolder");
        Intrinsics.h(sQLiteDatabase, "sqLiteDatabase");
        f a5 = frameworkSQLiteOpenHelper$b.a();
        if (a5 != null && a5.s(sQLiteDatabase)) {
            return a5;
        }
        f fVar = new f(sQLiteDatabase);
        frameworkSQLiteOpenHelper$b.b(fVar);
        return fVar;
    }
}
