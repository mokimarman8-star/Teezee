package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class i extends a<com.mbridge.msdk.foundation.entity.f> {
    private static i a;

    private i(f fVar) {
        super(fVar);
    }

    public static synchronized i a(f fVar) {
        i iVar;
        synchronized (i.class) {
            try {
                if (a == null) {
                    a = new i(fVar);
                }
                iVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    private synchronized boolean a(String str, String str2) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("select id from fq_info where unitId= ?  and id= ? ", new String[]{str, str2});
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.close();
                return true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public synchronized void a(com.mbridge.msdk.foundation.entity.f fVar) {
        try {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getWritableDatabase() == null) {
                return;
            }
            if (fVar != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", fVar.a());
                contentValues.put("time", Long.valueOf(fVar.b()));
                contentValues.put("unitId", fVar.d());
                contentValues.put("type", Integer.valueOf(fVar.c()));
                if (a(fVar.d(), fVar.a())) {
                    getWritableDatabase().update("fq_info", contentValues, "id = ? AND unitId = ? ", new String[]{fVar.a(), fVar.d()});
                } else {
                    getWritableDatabase().insert("fq_info", null, contentValues);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(String str) {
        try {
            String[] strArr = {String.valueOf(System.currentTimeMillis() - 86400000), str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("fq_info", "time< ? and unitId=?", strArr);
            }
        } catch (Exception unused) {
        }
    }
}
