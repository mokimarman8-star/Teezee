package com.mbridge.msdk.tracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class c {
    private final b a;
    private final String b;
    private final Object c = new Object();

    public c(b bVar, String str) {
        this.a = bVar;
        this.b = str;
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        if (y.b(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "beginTransaction: ", e);
            }
        }
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        if (y.b(sQLiteDatabase) || !sQLiteDatabase.inTransaction()) {
            return;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "endTransaction: ", e);
            }
        }
    }

    private static boolean c(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase == null || !sQLiteDatabase.isOpen() || sQLiteDatabase.isReadOnly();
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        if (y.b(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "transactionSuccess: ", e);
            }
        }
    }

    public int a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            int i = -1;
            if (y.b(this.a)) {
                return -1;
            }
            try {
                sQLiteDatabase = this.a.getWritableDatabase();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "deleteInvalidEvents getWritableDatabase: " + e.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return -1;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    i = sQLiteDatabase.delete(this.b, "state = ? OR state = ?", new String[]{String.valueOf(-1), String.valueOf(2)});
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e2) {
                    if (a.a) {
                        Log.e("TrackManager", "deleteInvalidEvents: " + e2.getMessage());
                    }
                }
                return i;
            } finally {
                b(sQLiteDatabase);
            }
        }
    }

    public long a(i iVar) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            long j = -1;
            if (y.b(this.a)) {
                return -1L;
            }
            try {
                sQLiteDatabase = this.a.getWritableDatabase();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "insert getWritableDatabase: " + e.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return -1L;
            }
            try {
                a(sQLiteDatabase);
                ContentValues contentValues = new ContentValues(16);
                e a = iVar.a();
                contentValues.put(RewardPlus.NAME, a.b());
                contentValues.put("type", Integer.valueOf(a.h()));
                contentValues.put("time_stamp", Long.valueOf(a.g()));
                contentValues.put("properties", a.d().toString());
                contentValues.put(TrackingKey.PRIORITY, Integer.valueOf(a.c()));
                contentValues.put("state", Integer.valueOf(iVar.e()));
                contentValues.put("report_count", Integer.valueOf(iVar.c()));
                contentValues.put("uuid", a.i());
                contentValues.put("ignore_max_timeout", Integer.valueOf(!a.k() ? 1 : 0));
                contentValues.put("ignore_max_retry_times", Integer.valueOf(!a.j() ? 1 : 0));
                contentValues.put("invalid_time", Long.valueOf(iVar.b()));
                j = sQLiteDatabase.insert(this.b, null, contentValues);
                d(sQLiteDatabase);
            } catch (Exception e2) {
                if (a.a) {
                    Log.e("TrackManager", "insert: " + e2.getMessage());
                }
            } finally {
                b(sQLiteDatabase);
            }
            return j;
        }
    }

    public List<i> a(int i) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        Cursor cursor;
        List<i> list;
        synchronized (this.c) {
            Cursor cursor2 = null;
            List<i> list2 = null;
            cursor2 = null;
            if (y.b(this.a)) {
                return null;
            }
            try {
                sQLiteDatabase = this.a.getWritableDatabase();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "getAvailable getWritableDatabase: " + e.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return null;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    cursor = sQLiteDatabase.query(this.b, null, "state = ? OR state = ?", new String[]{String.valueOf(0), String.valueOf(3)}, null, null, "priority DESC", String.valueOf(i));
                } catch (Exception e2) {
                    e = e2;
                    list = null;
                }
            } catch (Throwable th2) {
                Cursor cursor3 = cursor2;
                th = th2;
                cursor = cursor3;
            }
            try {
                list2 = y.b(cursor);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                y.a(cursor);
            } catch (Exception e3) {
                e = e3;
                List<i> list3 = list2;
                cursor2 = cursor;
                list = list3;
                if (a.a) {
                    Log.e("TrackManager", "getAvailable: " + e.getMessage());
                }
                b(sQLiteDatabase);
                y.a(cursor2);
                list2 = list;
                return list2;
            } catch (Throwable th3) {
                th = th3;
                b(sQLiteDatabase);
                y.a(cursor);
                throw th;
            }
            return list2;
        }
    }

    public void a(List<i> list) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            if (y.b(this.a) || y.b((List<?>) list)) {
                return;
            }
            try {
                sQLiteDatabase = this.a.getWritableDatabase();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "updateReportStateFailed getWritableDatabase: " + e.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", Integer.valueOf(iVar.e()));
                        contentValues.put("report_count", Integer.valueOf(iVar.c()));
                        String d = iVar.d();
                        if (!TextUtils.isEmpty(d)) {
                            contentValues.put("report_error_message", d);
                        }
                        sQLiteDatabase.update(this.b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e2) {
                    if (a.a) {
                        Log.e("TrackManager", "updateReportStateFailed: " + e2.getMessage());
                    }
                    b(sQLiteDatabase);
                }
            } catch (Throwable th) {
                b(sQLiteDatabase);
                throw th;
            }
        }
    }

    public int b() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            int i = 0;
            if (y.b(this.a)) {
                return 0;
            }
            Cursor cursor = null;
            try {
                sQLiteDatabase = this.a.getWritableDatabase();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "getAvailableCount getWritableDatabase: " + e.getMessage());
                }
                sQLiteDatabase = null;
            }
            try {
                if (c(sQLiteDatabase)) {
                    return 0;
                }
                try {
                    a(sQLiteDatabase);
                    cursor = sQLiteDatabase.query(this.b, null, "state = ? OR state = ?", new String[]{String.valueOf(3), String.valueOf(0)}, null, null, null, null);
                    if (cursor != null && cursor.moveToNext()) {
                        i = Math.max(cursor.getCount(), 0);
                    }
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                    y.a(cursor);
                } catch (Exception e2) {
                    if (a.a) {
                        Log.e("TrackManager", "getAvailableCount: " + e2.getMessage());
                    }
                    b(sQLiteDatabase);
                    y.a(cursor);
                }
                return i;
            } catch (Throwable th) {
                b(sQLiteDatabase);
                y.a(cursor);
                throw th;
            }
        }
    }

    public void b(List<i> list) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            if (y.b(this.a) || y.b((List<?>) list)) {
                return;
            }
            try {
                sQLiteDatabase = this.a.getWritableDatabase();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "updateReportStateReporting getWritableDatabase: " + e.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", (Integer) 1);
                        sQLiteDatabase.update(this.b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e2) {
                    if (a.a) {
                        Log.e("TrackManager", "updateReportStateReporting: " + e2.getMessage());
                    }
                    b(sQLiteDatabase);
                }
            } catch (Throwable th) {
                b(sQLiteDatabase);
                throw th;
            }
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            if (y.b(this.a)) {
                return;
            }
            try {
                sQLiteDatabase = this.a.getWritableDatabase();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "updateReportStateForReporting getWritableDatabase: " + e.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", (Integer) 3);
                    contentValues.put("report_error_message", "update from reporting");
                    sQLiteDatabase.update(this.b, contentValues, "state = ?", new String[]{String.valueOf(1)});
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e2) {
                    if (a.a) {
                        Log.e("TrackManager", "updateReportStateForReporting: " + e2.getMessage());
                    }
                }
            } finally {
                b(sQLiteDatabase);
            }
        }
    }

    public void c(List<i> list) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            if (y.b(this.a) || y.b((List<?>) list)) {
                return;
            }
            try {
                sQLiteDatabase = this.a.getWritableDatabase();
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "updateReportStateSuccess getWritableDatabase: " + e.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", (Integer) 2);
                        sQLiteDatabase.update(this.b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e2) {
                    if (a.a) {
                        Log.e("TrackManager", "updateReportStateSuccess: " + e2.getMessage());
                    }
                    b(sQLiteDatabase);
                }
            } catch (Throwable th) {
                b(sQLiteDatabase);
                throw th;
            }
        }
    }
}
