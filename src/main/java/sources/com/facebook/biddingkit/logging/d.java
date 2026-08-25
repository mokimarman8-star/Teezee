package com.facebook.biddingkit.logging;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class d extends SQLiteOpenHelper {
    public d(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table EVENT_LOGS( ID integer primary key autoincrement,auction_id  text,exception  text,bidder_data  text); ");
        } catch (Exception e) {
            b.d("DataBaseHelper", "Failed database create", e);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS EVENT_LOGS");
        onCreate(sQLiteDatabase);
    }
}
