package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class TransferDatabaseHelper extends SQLiteOpenHelper {
    private final Context a;
    private int b;

    public TransferDatabaseHelper(Context context) {
        this(context, 6);
    }

    public TransferDatabaseHelper(Context context, int i) {
        super(context, "awss3transfertable.db", (SQLiteDatabase.CursorFactory) null, i);
        this.a = context;
        this.b = i;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        TransferTable.f(sQLiteDatabase, this.b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.deleteDatabase("awss3transfertable.db");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        TransferTable.g(sQLiteDatabase, i, i2);
    }
}
