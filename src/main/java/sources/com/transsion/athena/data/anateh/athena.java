package com.transsion.athena.data.anateh;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.anateh.anehat;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena extends SQLiteOpenHelper {
    private static final String a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;
    private static final String g;
    private static final String h;
    private static final String i;
    private final File j;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        anehat.athena athenaVar = anehat.athena.a;
        sb.append(athenaVar.a());
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("tid");
        sb.append(" INTEGER NOT NULL,");
        sb.append("event");
        sb.append(" TEXT NOT NULL,");
        sb.append("et");
        sb.append(" INTEGER NOT NULL,");
        sb.append("pi");
        sb.append(" INTEGER NOT NULL,");
        sb.append("created_at");
        sb.append(" INTEGER NOT NULL,");
        sb.append("uid");
        sb.append(" TEXT,");
        sb.append("ext");
        sb.append(" TEXT,");
        sb.append("er_ts");
        sb.append(" INTEGER DEFAULT 0,");
        sb.append("boot_id");
        sb.append(" TEXT)");
        a = sb.toString();
        b = "CREATE TABLE " + anehat.athena.c.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, tid INTEGER NOT NULL UNIQUE,ev TEXT,pt INTEGER DEFAULT 0,cf TEXT,ext TEXT)";
        c = "CREATE TABLE " + anehat.athena.d.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, appid INTEGER NOT NULL UNIQUE,base TEXT,cfg TEXT,uid TEXT,try INTEGER DEFAULT 0,date TEXT,cnt INTEGER DEFAULT 0,ext TEXT)";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ALTER TABLE ");
        sb2.append(athenaVar.a());
        sb2.append(" ADD COLUMN ");
        sb2.append("uid");
        sb2.append(" TEXT");
        d = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ALTER TABLE ");
        sb3.append(athenaVar.a());
        sb3.append(" ADD COLUMN ");
        sb3.append("ext");
        sb3.append(" TEXT");
        e = sb3.toString();
        f = "ALTER TABLE " + athenaVar.a() + " ADD COLUMN er_ts INTEGER";
        g = "ALTER TABLE " + athenaVar.a() + " ADD COLUMN boot_id TEXT";
        h = "CREATE INDEX IF NOT EXISTS t_idx ON " + athenaVar.a() + " (tid,created_at)";
        StringBuilder sb4 = new StringBuilder();
        sb4.append("DROP TABLE ");
        sb4.append(athenaVar.a());
        i = sb4.toString();
    }

    athena(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 6);
        this.j = context.getDatabasePath(str);
    }

    public void a() {
        close();
        if (this.j.delete()) {
            com.transsion.athena.taaneh.aethna.a("mDatabaseFile deleted");
        }
    }

    public boolean b() {
        return this.j.exists() && this.j.length() > ((long) ehanat.k());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        sQLiteDatabase.enableWriteAheadLogging();
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("PRAGMA mmap_size=0;", null);
            cursor.moveToFirst();
            cursor.close();
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        com.transsion.athena.taaneh.aethna.a("Creating a new Athena DB");
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL(a);
                sQLiteDatabase.execSQL(h);
                sQLiteDatabase.execSQL(b);
                sQLiteDatabase.execSQL(c);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                com.transsion.athena.taaneh.aethna.a(Log.getStackTraceString(e2));
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        com.transsion.athena.taaneh.aethna.a("Upgrading app, replacing Athena DB oldVersion = " + i2);
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (i2 < 4) {
                    sQLiteDatabase.execSQL(b);
                    sQLiteDatabase.execSQL(c);
                }
                if (i2 < 3) {
                    try {
                        sQLiteDatabase.execSQL(d);
                    } catch (SQLiteException e2) {
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e2));
                        sQLiteDatabase.execSQL(i);
                        sQLiteDatabase.execSQL(a);
                    }
                }
                if (i2 < 5) {
                    sQLiteDatabase.execSQL(e);
                }
                if (i2 < 6) {
                    sQLiteDatabase.execSQL(f);
                    sQLiteDatabase.execSQL(g);
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e3) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e3));
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
