package com.mbridge.msdk.tracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class b extends SQLiteOpenHelper {
    private final String a;

    public b(Context context, String str, String str2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        this.a = str2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (y.b(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.execSQL(String.format(i.i, this.a));
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "create table error", e);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (y.b(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.execSQL(String.format(i.j, this.a));
            sQLiteDatabase.execSQL(String.format(i.i, this.a));
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "downgrade table error", e);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (y.b(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.execSQL(String.format(i.j, this.a));
            sQLiteDatabase.execSQL(String.format(i.i, this.a));
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "upgrade table error", e);
            }
        }
    }
}
