package com.bytedance.sdk.component.vS.Sj.Sj.Sj;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.vS.Sj.Dq;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class sP {
    private C0057sP Sj;
    private Context sP;

    private class Sj extends AbstractCursor {
        private Sj() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }
    }

    /* renamed from: com.bytedance.sdk.component.vS.Sj.Sj.Sj.sP$sP, reason: collision with other inner class name */
    public class C0057sP {
        private volatile SQLiteDatabase sP = null;

        public C0057sP() {
        }

        private void Sj() {
            try {
                if (this.sP != null && this.sP.isOpen()) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.sP != null) {
                            if (!this.sP.isOpen()) {
                            }
                        }
                        this.sP = Dq.Jcg().EjP().Sj(Dq.Jcg().vS());
                        this.sP.setLockingEnabled(false);
                    } finally {
                    }
                }
            } catch (Throwable th) {
                if (sP()) {
                    throw th;
                }
            }
        }

        private boolean sP() {
            SQLiteDatabase sQLiteDatabase = this.sP;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }

        public int Sj(String str, ContentValues contentValues, String str2, String[] strArr) {
            try {
                Sj();
                return this.sP.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                if (sP()) {
                    throw e;
                }
                return 0;
            }
        }

        public int Sj(String str, String str2, String[] strArr) {
            try {
                Sj();
                return this.sP.delete(str, str2, strArr);
            } catch (Exception e) {
                if (sP()) {
                    throw e;
                }
                return 0;
            }
        }

        public long Sj(String str, String str2, ContentValues contentValues) {
            try {
                Sj();
                return this.sP.insert(str, str2, contentValues);
            } catch (Exception e) {
                if (sP()) {
                    throw e;
                }
                return -1L;
            }
        }

        public Cursor Sj(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                Sj();
                return this.sP.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                Sj sj = new Sj();
                if (sP()) {
                    throw th;
                }
                return sj;
            }
        }

        public void Sj(String str) throws SQLException {
            try {
                Sj();
                this.sP.execSQL(str);
            } catch (Throwable th) {
                if (sP()) {
                    throw th;
                }
            }
        }

        public synchronized void Sj(String str, String str2, List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list) {
            JSONObject Jcg;
            try {
                try {
                    Sj();
                    this.sP.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (int i = 0; i < list.size(); i++) {
                        com.bytedance.sdk.component.vS.Sj.EjP.Sj sj = list.get(i);
                        if (sj != null && (Jcg = sj.Jcg()) != null) {
                            contentValues.put("id", sj.TKC());
                            String sP = Dq.Jcg().uvD().sP(Jcg.toString());
                            if (!TextUtils.isEmpty(sP)) {
                                contentValues.put("value", sP);
                                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                contentValues.put("retry", (Integer) 0);
                                contentValues.put("encrypt", (Integer) 1);
                                if (com.bytedance.sdk.component.vS.Sj.TKC.Sj.EjP()) {
                                    if (sj.TEQ() > 0) {
                                        if (sj.EjP() != 0) {
                                            if (sj.EjP() == 3) {
                                            }
                                        }
                                        contentValues.put("channel", Integer.valueOf(sj.TEQ()));
                                    }
                                }
                                this.sP.insert(str, str2, contentValues);
                            }
                            contentValues.clear();
                        }
                    }
                    this.sP.setTransactionSuccessful();
                    list.size();
                    if (this.sP != null) {
                        this.sP.endTransaction();
                    }
                } catch (Exception e) {
                    list.size();
                    if (sP()) {
                        throw e;
                    }
                    if (this.sP != null) {
                        this.sP.endTransaction();
                    }
                }
            } catch (Throwable th) {
                if (this.sP != null) {
                    this.sP.endTransaction();
                }
                throw th;
            }
        }
    }

    sP(Context context) {
        try {
            this.sP = context.getApplicationContext();
            if (this.Sj == null) {
                this.Sj = new C0057sP();
            }
        } catch (Throwable unused) {
        }
    }

    public C0057sP Sj() {
        return this.Sj;
    }
}
