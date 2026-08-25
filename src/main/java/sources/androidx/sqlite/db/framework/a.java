package androidx.sqlite.db.framework;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import z3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class a implements DatabaseErrorHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f13402a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameworkSQLiteOpenHelper$b f13403b;

    public /* synthetic */ a(e.a aVar, FrameworkSQLiteOpenHelper$b frameworkSQLiteOpenHelper$b) {
        this.f13402a = aVar;
        this.f13403b = frameworkSQLiteOpenHelper$b;
    }

    @Override // android.database.DatabaseErrorHandler
    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        FrameworkSQLiteOpenHelper.OpenHelper.b(this.f13402a, this.f13403b, sQLiteDatabase);
    }
}
