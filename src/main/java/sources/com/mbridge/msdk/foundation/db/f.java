package com.mbridge.msdk.foundation.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class f {
    private a a;

    private class a extends SQLiteOpenHelper {
        public a(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            if (MBridgeConstans.DEBUG) {
                o0.a("DatabaseOpenHelper", "数据库： name :" + str + "  " + i);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (MBridgeConstans.DEBUG) {
                o0.a("DatabaseOpenHelper", "数据库创建了");
            }
            f.this.a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            f.this.a(sQLiteDatabase, i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (MBridgeConstans.DEBUG) {
                o0.a("DatabaseOpenHelper", "数据库升级了");
            }
            f.this.b(sQLiteDatabase, i, i2);
        }
    }

    public f(Context context) {
        this.a = new a(context, a(), b());
    }

    protected abstract String a();

    protected abstract void a(SQLiteDatabase sQLiteDatabase);

    protected abstract void a(SQLiteDatabase sQLiteDatabase, int i, int i2);

    protected abstract int b();

    protected abstract void b(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteDatabase c() {
        return this.a.getReadableDatabase();
    }

    public synchronized SQLiteDatabase d() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.a.getWritableDatabase();
        } catch (Exception unused) {
            sQLiteDatabase = null;
        }
        return sQLiteDatabase;
    }
}
