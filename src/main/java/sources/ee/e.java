package ee;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e implements j {
    public SQLiteDatabase a;
    public final AtomicInteger b;

    public static class b {
        public static final e a = new e();
    }

    public e() {
        this.b = new AtomicInteger();
    }

    public static e d() {
        return b.a;
    }

    @Override // ee.j
    public void a() {
        try {
            e();
            this.a.delete("cloudList", null, null);
        } catch (Exception e) {
            AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e));
        }
    }

    @Override // ee.j
    public void a(CloudControlConfig.CodeSeat codeSeat) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        try {
            try {
                e();
                sQLiteDatabase2 = this.a;
            } catch (Exception e) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", "update e " + Log.getStackTraceString(e));
                sQLiteDatabase = this.a;
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            if (sQLiteDatabase2 == null) {
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.endTransaction();
                    return;
                }
                return;
            }
            sQLiteDatabase2.beginTransaction();
            String d = GsonUtil.d(codeSeat);
            ContentValues contentValues = new ContentValues();
            contentValues.put("codeSeatId", codeSeat.getCodeSeatId());
            contentValues.put("json", d);
            this.a.update("cloudList", contentValues, "codeSeatId=?", new String[]{codeSeat.getCodeSeatId()});
            this.a.setTransactionSuccessful();
            sQLiteDatabase = this.a;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.a;
            if (sQLiteDatabase3 != null) {
                sQLiteDatabase3.endTransaction();
            }
            throw th;
        }
    }

    @Override // ee.j
    public boolean a(List list) {
        if (list != null) {
            try {
                if (list.size() >= 1) {
                    try {
                        e();
                        SQLiteDatabase sQLiteDatabase = this.a;
                        if (sQLiteDatabase == null) {
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            return false;
                        }
                        sQLiteDatabase.beginTransaction();
                        this.a.delete("cloudList", null, null);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            CloudControlConfig.CodeSeat codeSeat = (CloudControlConfig.CodeSeat) it.next();
                            if (codeSeat != null) {
                                String d = GsonUtil.d(codeSeat);
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("codeSeatId", codeSeat.getCodeSeatId());
                                contentValues.put("json", d);
                                this.a.insert("cloudList", null, contentValues);
                            }
                        }
                        this.a.setTransactionSuccessful();
                        SQLiteDatabase sQLiteDatabase2 = this.a;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.endTransaction();
                        }
                        return true;
                    } catch (Exception e) {
                        AdLogUtil.Log().e("CloudControlDatabaseManager", "insert cloud data 2 db failed in work thread " + Log.getStackTraceString(e));
                        SQLiteDatabase sQLiteDatabase3 = this.a;
                        if (sQLiteDatabase3 != null) {
                            sQLiteDatabase3.endTransaction();
                        }
                        return false;
                    }
                }
            } catch (Throwable th) {
                SQLiteDatabase sQLiteDatabase4 = this.a;
                if (sQLiteDatabase4 != null) {
                    sQLiteDatabase4.endTransaction();
                }
                throw th;
            }
        }
        return false;
    }

    @Override // ee.j
    public long b() {
        Cursor cursor = null;
        try {
            try {
                e();
                cursor = this.a.rawQuery("select count(*) from cloudList", null);
                cursor.moveToFirst();
                long j = cursor.getLong(0);
                cursor.close();
                return j;
            } catch (Exception e) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e));
                if (cursor != null) {
                    cursor.close();
                }
                return 0L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (r1 == null) goto L14;
     */
    @Override // ee.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List c() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                e();
                cursor = this.a.rawQuery("select * from cloudList", null);
                while (cursor.moveToNext()) {
                    arrayList.add((CloudControlConfig.CodeSeat) GsonUtil.a(cursor.getString(cursor.getColumnIndex("json")), CloudControlConfig.CodeSeat.class));
                }
            } catch (Exception e) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e));
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final synchronized SQLiteDatabase e() {
        if (this.b.incrementAndGet() == 1 || this.a == null) {
            try {
                this.a = new d(com.cloud.sdk.commonutil.util.e.a()).getWritableDatabase();
            } catch (Exception e) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e));
            }
        }
        return this.a;
    }
}
