package com.transsion.athena.data.anateh;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.SparseArray;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.athena.config.data.model.aatnhe;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.Track;
import com.transsion.athena.data.anehat;
import com.transsion.ga.anateh;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class anehat {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile anehat a;
    private com.transsion.athena.data.anateh.athena b;
    private Context c;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class athena {
        public static final athena a = new athena("EVENTS", 0, "events");
        public static final athena b = new athena("COUNTER", 1, "counter");
        public static final athena c = new athena("TID_CONFIG", 2, "tidconfig");
        public static final athena d = new athena("APPID_CONFIG", 3, "appidconfig");
        private final String e;

        private athena(String str, int i, String str2) {
            this.e = str2;
        }

        public String a() {
            return this.e;
        }
    }

    private anehat(Context context) {
        try {
            this.c = context;
            this.b = new com.transsion.athena.data.anateh.athena(context, "athena.db");
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(e.getMessage());
        }
    }

    public static synchronized anehat a(Context context) {
        anehat anehatVar;
        synchronized (anehat.class) {
            try {
                if (a == null) {
                    synchronized (anehat.class) {
                        try {
                            if (a == null) {
                                a = new anehat(context);
                            }
                        } finally {
                        }
                    }
                }
                anehatVar = a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return anehatVar;
    }

    private void a(SQLiteException sQLiteException) {
        try {
            if (sQLiteException instanceof SQLiteFullException) {
                this.b.close();
            } else {
                this.b.close();
                this.b.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SQLiteDatabase b() {
        try {
            if (!this.c.getDatabasePath("athena.db").exists()) {
                this.b.close();
            }
            return this.b.getWritableDatabase();
        } catch (SQLiteException e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return null;
        }
    }

    public int a(athena athenaVar, int i, enatha<String> enathaVar) throws anateh {
        String a2 = athenaVar.a();
        LongSparseArray longSparseArray = new LongSparseArray();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase b = b();
                if (b == null) {
                    return 0;
                }
                Cursor rawQuery = b.rawQuery("SELECT _id,tid FROM " + a2 + " ORDER BY _id LIMIT " + i, null);
                long j = 0;
                while (rawQuery != null && rawQuery.moveToNext()) {
                    long j2 = rawQuery.getLong(rawQuery.getColumnIndex("tid"));
                    longSparseArray.put(j2, Integer.valueOf(((Integer) longSparseArray.get(j2, 0)).intValue() + 1));
                    j = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                int delete = b.delete(a2, "_id<=" + j + " AND CAST(tid AS TEXT) NOT LIKE ?", new String[]{"9999%"});
                if (enathaVar != null && longSparseArray.size() > 0) {
                    enathaVar.a(longSparseArray.toString());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return delete;
            } catch (SQLiteException e) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                if (0 != 0) {
                    cursor.close();
                }
                a(e);
                throw new anateh("cleanupEvents_oom_sql", e);
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x027f A[Catch: all -> 0x0108, Exception -> 0x01c6, SQLiteException -> 0x01cc, TRY_LEAVE, TryCatch #22 {all -> 0x0108, blocks: (B:95:0x00f2, B:98:0x00f9, B:101:0x0123, B:106:0x0133, B:109:0x013f, B:112:0x0145, B:115:0x014e, B:118:0x0154, B:121:0x0175, B:130:0x0196, B:133:0x01aa, B:135:0x01af, B:140:0x01bd, B:142:0x01d8, B:145:0x027f, B:148:0x01d2, B:151:0x01f9), top: B:94:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0366 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x03ba A[Catch: all -> 0x03aa, TryCatch #4 {all -> 0x03aa, blocks: (B:40:0x039b, B:41:0x03a9, B:33:0x03b1, B:35:0x03ba, B:36:0x03bd, B:37:0x03c7), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(athena athenaVar, Track track, int i) throws anateh {
        String str;
        Cursor cursor;
        String str2;
        long j;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject;
        int i2;
        boolean z;
        Cursor cursor2;
        boolean z2;
        byte[] bArr;
        List<byte[]> list;
        String str6;
        String str7;
        boolean contains;
        boolean z3;
        String str8;
        byte[] bArr2;
        String str9;
        int i3;
        anehat anehatVar = this;
        String str10 = "There is not enough space left";
        String a2 = athenaVar.a();
        long tid = track.getTid();
        JSONObject jsonData = track.getJsonData();
        List<byte[]> d = com.transsion.athena.aethna.athena.c().d();
        try {
            try {
                SQLiteDatabase b = b();
                if (b == null) {
                    if (anehatVar.b.b()) {
                        com.transsion.athena.taaneh.aethna.b("There is not enough space left");
                    }
                    return -1;
                }
                String str11 = "pi";
                String str12 = " WHERE ";
                String str13 = "=";
                String str14 = "tid";
                String str15 = "_eid";
                if (i == 1) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        JSONObject jSONObject2 = jsonData;
                        sb.append("SELECT * FROM ");
                        sb.append(a2);
                        sb.append(" WHERE ");
                        sb.append("tid");
                        sb.append("=");
                        sb.append(tid);
                        sb.append(" AND ");
                        sb.append("et");
                        sb.append("=");
                        sb.append(i);
                        Cursor rawQuery = b.rawQuery(sb.toString(), null);
                        byte[] bArr3 = null;
                        String str16 = null;
                        String str17 = null;
                        while (rawQuery != null) {
                            try {
                                if (!rawQuery.moveToNext()) {
                                    break;
                                }
                                int i4 = rawQuery.getInt(rawQuery.getColumnIndex(str11));
                                byte[] bArr4 = bArr3;
                                String string = rawQuery.getString(rawQuery.getColumnIndex("event"));
                                str4 = str13;
                                if (i4 != -1) {
                                    if (i4 != 0) {
                                        try {
                                            if (!com.transsion.athena.config.data.model.anehat.b(d)) {
                                                str8 = string;
                                                bArr2 = bArr4;
                                                if (bArr2 != null || str8 == null) {
                                                    rawQuery.close();
                                                    if (anehatVar.b.b()) {
                                                        return -1;
                                                    }
                                                    com.transsion.athena.taaneh.aethna.b(str10);
                                                    return -1;
                                                }
                                                list = d;
                                                String str18 = str8;
                                                bArr = bArr2;
                                                string = str18;
                                            }
                                        } catch (SQLiteException e) {
                                            e = e;
                                            cursor = rawQuery;
                                            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            anehatVar.a(e);
                                            throw new anateh("addJSON_sql", e);
                                        } catch (Exception e2) {
                                            e = e2;
                                            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                            throw new anateh("addJSON", e);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor = rawQuery;
                                            str = str10;
                                            if (cursor != null) {
                                            }
                                            if (anehatVar.b.b()) {
                                            }
                                            throw th;
                                        }
                                    }
                                    byte[] bArr5 = i4 == 0 ? ehanat.n : d.get(i4);
                                    byte[] bArr6 = bArr5;
                                    str8 = com.transsion.athena.anateh.anehat.a(string, bArr5, i4);
                                    bArr2 = bArr6;
                                    if (bArr2 != null) {
                                    }
                                    rawQuery.close();
                                    if (anehatVar.b.b()) {
                                    }
                                } else {
                                    bArr = bArr4;
                                    list = d;
                                }
                                if (str16 == null) {
                                    str = str10;
                                    jSONObject = jSONObject2;
                                    try {
                                        try {
                                            str2 = str12;
                                            try {
                                                str16 = String.format("\"%s\":\"%s\"", "event", jSONObject.getString("event"));
                                            } catch (Exception unused) {
                                                j = tid;
                                                str5 = str11;
                                                str6 = str15;
                                                str3 = str14;
                                                anehatVar = this;
                                                jSONObject2 = jSONObject;
                                                bArr3 = bArr;
                                                str14 = str3;
                                                d = list;
                                                str13 = str4;
                                                str10 = str;
                                                str12 = str2;
                                                tid = j;
                                                str15 = str6;
                                                str11 = str5;
                                            }
                                        } catch (Exception unused2) {
                                            str2 = str12;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        anehatVar = this;
                                        cursor = rawQuery;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (anehatVar.b.b()) {
                                            com.transsion.athena.taaneh.aethna.b(str);
                                        }
                                        throw th;
                                    }
                                } else {
                                    str2 = str12;
                                    str = str10;
                                    jSONObject = jSONObject2;
                                }
                                String str19 = str16;
                                try {
                                    contains = string.contains(str19);
                                    str7 = str19;
                                } catch (Exception unused3) {
                                    str7 = str19;
                                    j = tid;
                                    str5 = str11;
                                    str6 = str15;
                                    str3 = str14;
                                }
                                if (contains) {
                                    str5 = str11;
                                    try {
                                    } catch (Exception unused4) {
                                        j = tid;
                                        str6 = str15;
                                    }
                                    if ("ev_athena".equals(track.getEventName())) {
                                        if (str17 == null) {
                                            str6 = str15;
                                            try {
                                                String optString = jSONObject.getJSONObject("_eparam").optString(str6);
                                                j = tid;
                                                str3 = str14;
                                                try {
                                                    Object[] objArr = new Object[2];
                                                    objArr[0] = str6;
                                                    try {
                                                        objArr[1] = optString;
                                                        str17 = String.format("\"%s\":\"%s\"", objArr);
                                                    } catch (Exception unused5) {
                                                        str16 = str7;
                                                        anehatVar = this;
                                                        jSONObject2 = jSONObject;
                                                        bArr3 = bArr;
                                                        str14 = str3;
                                                        d = list;
                                                        str13 = str4;
                                                        str10 = str;
                                                        str12 = str2;
                                                        tid = j;
                                                        str15 = str6;
                                                        str11 = str5;
                                                    }
                                                } catch (Exception unused6) {
                                                }
                                            } catch (Exception unused7) {
                                                j = tid;
                                                str3 = str14;
                                                str16 = str7;
                                                anehatVar = this;
                                                jSONObject2 = jSONObject;
                                                bArr3 = bArr;
                                                str14 = str3;
                                                d = list;
                                                str13 = str4;
                                                str10 = str;
                                                str12 = str2;
                                                tid = j;
                                                str15 = str6;
                                                str11 = str5;
                                            }
                                        } else {
                                            j = tid;
                                            str6 = str15;
                                            str3 = str14;
                                        }
                                        String str20 = str17;
                                        try {
                                            str17 = str20;
                                            z3 = string.contains(str20);
                                            if (z3) {
                                                try {
                                                    long j2 = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                                                    if (string.length() >= 131072) {
                                                        i2 = -1;
                                                        ContentValues contentValues = new ContentValues();
                                                        contentValues.put("et", (Integer) 2);
                                                        b.update(a2, contentValues, "_id=" + j2, null);
                                                        break;
                                                    }
                                                    JSONObject jSONObject3 = new JSONObject(string);
                                                    try {
                                                        com.transsion.athena.config.data.model.anehat.a(jSONObject.getJSONObject("_eparam"), jSONObject3.getJSONObject("_eparam"));
                                                        i2 = -1;
                                                        String a3 = i4 != -1 ? com.transsion.athena.anateh.anehat.a(jSONObject3.toString(), bArr) : jSONObject3.toString();
                                                        if (a3 != null) {
                                                            ContentValues contentValues2 = new ContentValues();
                                                            contentValues2.put("event", a3);
                                                            b.update(a2, contentValues2, "_id=" + j2, null);
                                                        }
                                                        z = false;
                                                        if (rawQuery != null) {
                                                            rawQuery.close();
                                                        }
                                                        cursor2 = rawQuery;
                                                        z2 = z;
                                                    } catch (JSONException unused8) {
                                                    }
                                                } catch (SQLiteException e3) {
                                                    e = e3;
                                                    anehatVar = this;
                                                    cursor = rawQuery;
                                                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                                    if (cursor != null) {
                                                    }
                                                    anehatVar.a(e);
                                                    throw new anateh("addJSON_sql", e);
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                                    throw new anateh("addJSON", e);
                                                }
                                            }
                                            anehatVar = this;
                                            bArr3 = bArr;
                                            str14 = str3;
                                            str16 = str7;
                                            d = list;
                                            str13 = str4;
                                            str12 = str2;
                                            tid = j;
                                            jSONObject2 = jSONObject;
                                            str15 = str6;
                                            str10 = str;
                                        } catch (Exception unused9) {
                                            str17 = str20;
                                            str16 = str7;
                                            anehatVar = this;
                                            jSONObject2 = jSONObject;
                                            bArr3 = bArr;
                                            str14 = str3;
                                            d = list;
                                            str13 = str4;
                                            str10 = str;
                                            str12 = str2;
                                            tid = j;
                                            str15 = str6;
                                            str11 = str5;
                                        }
                                        str11 = str5;
                                    } else {
                                        j = tid;
                                    }
                                } else {
                                    j = tid;
                                    str5 = str11;
                                }
                                str6 = str15;
                                str3 = str14;
                                z3 = contains;
                                if (z3) {
                                }
                                anehatVar = this;
                                bArr3 = bArr;
                                str14 = str3;
                                str16 = str7;
                                d = list;
                                str13 = str4;
                                str12 = str2;
                                tid = j;
                                jSONObject2 = jSONObject;
                                str15 = str6;
                                str10 = str;
                                str11 = str5;
                            } catch (SQLiteException e5) {
                                e = e5;
                                anehatVar = this;
                                cursor = rawQuery;
                                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                if (cursor != null) {
                                }
                                anehatVar.a(e);
                                throw new anateh("addJSON_sql", e);
                            } catch (Exception e6) {
                                e = e6;
                                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                throw new anateh("addJSON", e);
                            } catch (Throwable th4) {
                                th = th4;
                                str = str10;
                                anehatVar = this;
                                cursor = rawQuery;
                                if (cursor != null) {
                                }
                                if (anehatVar.b.b()) {
                                }
                                throw th;
                            }
                        }
                        str2 = str12;
                        str = str10;
                        j = tid;
                        str3 = str14;
                        str4 = str13;
                        str5 = str11;
                        jSONObject = jSONObject2;
                        i2 = -1;
                        z = true;
                        if (rawQuery != null) {
                        }
                        cursor2 = rawQuery;
                        z2 = z;
                    } catch (SQLiteException e7) {
                        e = e7;
                        cursor = null;
                        anehatVar = this;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (cursor != null) {
                        }
                        anehatVar.a(e);
                        throw new anateh("addJSON_sql", e);
                    } catch (Exception e8) {
                        e = e8;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        throw new anateh("addJSON", e);
                    } catch (Throwable th5) {
                        th = th5;
                        str = "There is not enough space left";
                        cursor = null;
                        anehatVar = this;
                        if (cursor != null) {
                        }
                        if (anehatVar.b.b()) {
                        }
                        throw th;
                    }
                } else {
                    str2 = " WHERE ";
                    str = "There is not enough space left";
                    j = tid;
                    jSONObject = jsonData;
                    str3 = "tid";
                    str4 = "=";
                    str5 = "pi";
                    i2 = -1;
                    z2 = true;
                    cursor2 = null;
                }
                if (z2) {
                    try {
                        Pair<Integer, byte[]> i5 = com.transsion.athena.aethna.athena.c().i();
                        Integer num = (Integer) i5.first;
                        num.intValue();
                        String a4 = com.transsion.athena.anateh.anehat.a(jSONObject.toString(), (byte[]) i5.second);
                        if (a4 != null) {
                            ContentValues contentValues3 = new ContentValues();
                            str9 = str3;
                            contentValues3.put(str9, Long.valueOf(j));
                            contentValues3.put("event", a4);
                            contentValues3.put("et", Integer.valueOf(i));
                            contentValues3.put(str5, num);
                            contentValues3.put("created_at", Long.valueOf(track.getTrackTs()));
                            if (com.transsion.athena.taaneh.anehat.b(j)) {
                                contentValues3.put("ext", track.getEventName());
                            }
                            if (track.getBootId() != null) {
                                contentValues3.put("er_ts", Long.valueOf(track.getTrackErTs()));
                                contentValues3.put("boot_id", track.getBootId());
                            }
                            b.insert(a2, null, contentValues3);
                            cursor = b.rawQuery("SELECT COUNT(*) FROM " + a2 + str2 + str9 + str4 + j, null);
                            if (cursor != null) {
                                try {
                                    if (cursor.moveToNext()) {
                                        i3 = cursor.getInt(0);
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (!this.b.b()) {
                                            return i3;
                                        }
                                        com.transsion.athena.taaneh.aethna.b(str);
                                        return -2;
                                    }
                                } catch (SQLiteException e9) {
                                    e = e9;
                                    anehatVar = this;
                                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                    if (cursor != null) {
                                    }
                                    anehatVar.a(e);
                                    throw new anateh("addJSON_sql", e);
                                } catch (Exception e10) {
                                    e = e10;
                                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                    throw new anateh("addJSON", e);
                                } catch (Throwable th6) {
                                    th = th6;
                                    anehatVar = this;
                                    if (cursor != null) {
                                    }
                                    if (anehatVar.b.b()) {
                                    }
                                    throw th;
                                }
                            }
                            i3 = i2;
                            if (cursor != null) {
                            }
                            if (!this.b.b()) {
                            }
                        }
                    } catch (SQLiteException e11) {
                        e = e11;
                        anehatVar = this;
                        cursor = cursor2;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (cursor != null) {
                        }
                        anehatVar.a(e);
                        throw new anateh("addJSON_sql", e);
                    } catch (Exception e12) {
                        e = e12;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        throw new anateh("addJSON", e);
                    } catch (Throwable th7) {
                        th = th7;
                        anehatVar = this;
                        cursor = cursor2;
                        if (cursor != null) {
                        }
                        if (anehatVar.b.b()) {
                        }
                        throw th;
                    }
                }
                str9 = str3;
                cursor = b.rawQuery("SELECT COUNT(*) FROM " + a2 + str2 + str9 + str4 + j, null);
                if (cursor != null) {
                }
                i3 = i2;
                if (cursor != null) {
                }
                if (!this.b.b()) {
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (SQLiteException e13) {
            e = e13;
            cursor = null;
        } catch (Exception e14) {
            e = e14;
        } catch (Throwable th9) {
            th = th9;
            str = "There is not enough space left";
            cursor = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02b4 A[Catch: all -> 0x02a8, TRY_LEAVE, TryCatch #4 {all -> 0x02a8, blocks: (B:154:0x0299, B:155:0x02a7, B:143:0x02ab, B:145:0x02b4), top: B:6:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.transsion.athena.data.anehat a(athena athenaVar, long j, long j2, String str, int i, int i2) throws anateh {
        String str2;
        long j3;
        int i3;
        int i4;
        String str3;
        boolean z;
        String str4;
        String str5;
        String str6;
        String str7;
        int intValue;
        int length;
        String str8 = "net";
        String str9 = "event";
        List<byte[]> d = com.transsion.athena.aethna.athena.c().d();
        Cursor cursor = null;
        if (com.transsion.athena.config.data.model.anehat.a(d)) {
            return null;
        }
        String a2 = athenaVar.a();
        try {
            try {
                SQLiteDatabase b = b();
                if (b == null) {
                    return null;
                }
                String str10 = "_eparam";
                if (TextUtils.isEmpty(str)) {
                    try {
                        str2 = "SELECT * FROM " + a2 + " WHERE tid=" + j + " AND created_at<=" + j2 + " ORDER BY _id LIMIT " + i2;
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = null;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (cursor != null) {
                        }
                        try {
                            a(e);
                            throw new anateh("queryEventList_sql", e);
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        throw new anateh("queryEventList", e);
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = null;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                } else {
                    try {
                        str2 = "SELECT * FROM " + a2 + " WHERE tid=" + j + " AND uid='" + str + "' ORDER BY _id";
                    } catch (SQLiteException e3) {
                        e = e3;
                        cursor = null;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (cursor != null) {
                            cursor.close();
                        }
                        a(e);
                        throw new anateh("queryEventList_sql", e);
                    } catch (Exception e4) {
                        e = e4;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        throw new anateh("queryEventList", e);
                    } catch (Throwable th4) {
                        th = th4;
                        cursor = null;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
                cursor = null;
                Cursor rawQuery = b.rawQuery(str2, null);
                if (rawQuery != null) {
                    try {
                        try {
                            if (rawQuery.getCount() != 0) {
                                int count = rawQuery.getCount();
                                ArrayList arrayList = new ArrayList();
                                String str11 = BuildConfig.FLAVOR;
                                long j4 = 0;
                                int i5 = 0;
                                int i6 = 0;
                                int i7 = 0;
                                long j5 = 0;
                                while (true) {
                                    if (!rawQuery.moveToNext()) {
                                        j3 = j4;
                                        i3 = i6;
                                        i4 = i7;
                                        str3 = str11;
                                        break;
                                    }
                                    String string = rawQuery.getString(rawQuery.getColumnIndex(str9));
                                    long j6 = rawQuery.getLong(rawQuery.getColumnIndex("created_at"));
                                    int i8 = rawQuery.getInt(rawQuery.getColumnIndex("pi"));
                                    int i9 = rawQuery.getInt(rawQuery.getColumnIndex("et"));
                                    if (i8 != -1) {
                                        string = com.transsion.athena.anateh.anehat.a(string, d.get(i8), i8);
                                    }
                                    if (j4 == 0) {
                                        j4 = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                                    }
                                    if (string != null) {
                                        if (i9 != 0) {
                                            string = string.replace("&add", BuildConfig.FLAVOR).replace("&append", BuildConfig.FLAVOR);
                                        }
                                        try {
                                            JSONObject jSONObject = new JSONObject(string);
                                            str7 = (String) jSONObject.remove(str9);
                                            try {
                                                if (jSONObject.has(str8)) {
                                                    try {
                                                        intValue = ((Integer) jSONObject.remove(str8)).intValue();
                                                        str5 = str10;
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        str4 = str9;
                                                        str11 = str7;
                                                        str5 = str10;
                                                        str6 = str8;
                                                        e.printStackTrace();
                                                        i5++;
                                                        j5 = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                                                        str8 = str6;
                                                        str9 = str4;
                                                        str10 = str5;
                                                    }
                                                } else {
                                                    str5 = str10;
                                                    intValue = 0;
                                                }
                                                try {
                                                    Object remove = jSONObject.has(str5) ? jSONObject.remove(str5) : new JSONObject();
                                                    if (remove instanceof JSONObject) {
                                                        try {
                                                            if (jSONObject.length() > 0) {
                                                                Iterator<String> keys = jSONObject.keys();
                                                                while (keys.hasNext()) {
                                                                    Iterator<String> it = keys;
                                                                    String next = keys.next();
                                                                    str6 = str8;
                                                                    try {
                                                                        if (next.startsWith("_")) {
                                                                            str4 = str9;
                                                                            try {
                                                                                ((JSONObject) remove).put(next, jSONObject.get(next));
                                                                                keys = it;
                                                                                str8 = str6;
                                                                                str9 = str4;
                                                                            } catch (Exception e6) {
                                                                                e = e6;
                                                                                str11 = str7;
                                                                                e.printStackTrace();
                                                                                i5++;
                                                                                j5 = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                                                                                str8 = str6;
                                                                                str9 = str4;
                                                                                str10 = str5;
                                                                            }
                                                                        } else {
                                                                            keys = it;
                                                                            str8 = str6;
                                                                        }
                                                                    } catch (Exception e7) {
                                                                        e = e7;
                                                                        str4 = str9;
                                                                        str11 = str7;
                                                                        e.printStackTrace();
                                                                        i5++;
                                                                        j5 = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                                                                        str8 = str6;
                                                                        str9 = str4;
                                                                        str10 = str5;
                                                                    }
                                                                }
                                                            }
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                            str6 = str8;
                                                        }
                                                    }
                                                    str6 = str8;
                                                    str4 = str9;
                                                    arrayList.add(new anehat.athena(str7, j6, intValue, remove.toString()));
                                                    i6++;
                                                    length = i7 + string.length();
                                                } catch (Exception e9) {
                                                    e = e9;
                                                    str6 = str8;
                                                    str4 = str9;
                                                }
                                            } catch (Exception e10) {
                                                e = e10;
                                                str4 = str9;
                                                str5 = str10;
                                                str6 = str8;
                                            }
                                        } catch (Exception e11) {
                                            e = e11;
                                            str4 = str9;
                                        }
                                        if (length >= i) {
                                            try {
                                                i4 = length;
                                                j5 = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                                                str3 = str7;
                                                j3 = j4;
                                                i3 = i6;
                                                break;
                                            } catch (Exception e12) {
                                                e = e12;
                                                i7 = length;
                                                str11 = str7;
                                                e.printStackTrace();
                                                i5++;
                                                j5 = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                                                str8 = str6;
                                                str9 = str4;
                                                str10 = str5;
                                            }
                                        } else {
                                            i7 = length;
                                            str11 = str7;
                                            j5 = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                                            str8 = str6;
                                            str9 = str4;
                                            str10 = str5;
                                        }
                                    } else {
                                        str4 = str9;
                                        str5 = str10;
                                        str6 = str8;
                                    }
                                    i5++;
                                    j5 = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                                    str8 = str6;
                                    str9 = str4;
                                    str10 = str5;
                                }
                                rawQuery.close();
                                if (i3 <= 0) {
                                    rawQuery.close();
                                    return null;
                                }
                                int i10 = i3 + i5;
                                if (count <= i10 && (count != i2 || count != i10)) {
                                    z = true;
                                    com.transsion.athena.data.anehat anehatVar = new com.transsion.athena.data.anehat(j, str3, arrayList, j3, j5, i3, i4, z);
                                    rawQuery.close();
                                    return anehatVar;
                                }
                                z = false;
                                com.transsion.athena.data.anehat anehatVar2 = new com.transsion.athena.data.anehat(j, str3, arrayList, j3, j5, i3, i4, z);
                                rawQuery.close();
                                return anehatVar2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            cursor = rawQuery;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    } catch (SQLiteException e13) {
                        e = e13;
                        cursor = rawQuery;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (cursor != null) {
                        }
                        a(e);
                        throw new anateh("queryEventList_sql", e);
                    } catch (Exception e14) {
                        e = e14;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        throw new anateh("queryEventList", e);
                    }
                }
                if (rawQuery == null) {
                    return null;
                }
                rawQuery.close();
                return null;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (SQLiteException e15) {
            e = e15;
        } catch (Exception e16) {
            e = e16;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public List<AppIdData> a(athena athenaVar) throws anateh {
        String a2 = athenaVar.a();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase b = b();
                if (b == null) {
                    return arrayList;
                }
                cursor = b.rawQuery("SELECT * FROM " + a2, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    AppIdData appIdData = new AppIdData();
                    appIdData.a = cursor.getInt(cursor.getColumnIndex("appid"));
                    appIdData.b = cursor.getString(cursor.getColumnIndex("base"));
                    appIdData.c = cursor.getString(cursor.getColumnIndex("uid"));
                    appIdData.d = cursor.getInt(cursor.getColumnIndex("try"));
                    arrayList.add(appIdData);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                if (cursor != null) {
                    cursor.close();
                }
                a(e);
                throw new anateh("getAppIdList_sql", e);
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public void a() {
        com.transsion.athena.taaneh.aethna.a("deleteDB");
        try {
            this.b.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(athena athenaVar, com.transsion.athena.config.data.model.athena athenaVar2, boolean z) throws anateh {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Cursor cursor2;
        String a2 = athenaVar.a();
        Cursor cursor3 = null;
        try {
            sQLiteDatabase = b();
            if (sQLiteDatabase == null) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                    return;
                }
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("cfg", athenaVar2.m());
                sQLiteDatabase.update(a2, contentValues, "appid=" + athenaVar2.b(), null);
                if (z) {
                    sQLiteDatabase.delete(athena.c.a(), "CAST(tid AS TEXT) LIKE ?", new String[]{athenaVar2.b() + "%"});
                    List<TidConfigBean> j = athenaVar2.j();
                    HashMap hashMap = new HashMap();
                    for (TidConfigBean tidConfigBean : j) {
                        aatnhe tidConfig = tidConfigBean.getTidConfig();
                        contentValues.clear();
                        contentValues.put("tid", Long.valueOf(tidConfigBean.getTid()));
                        contentValues.put("ev", tidConfigBean.getEvent());
                        contentValues.put("pt", Long.valueOf(tidConfig.j()));
                        contentValues.put("cf", tidConfig.o());
                        sQLiteDatabase.insert(athena.c.a(), null, contentValues);
                        if (tidConfigBean.getEvent() != null) {
                            hashMap.put(tidConfigBean.getEvent(), Long.valueOf(tidConfigBean.getTid()));
                        }
                    }
                    cursor2 = sQLiteDatabase.rawQuery("SELECT DISTINCT ext FROM " + athena.a.a() + " WHERE tid=" + athenaVar2.b(), null);
                    while (cursor2 != null) {
                        try {
                            if (!cursor2.moveToNext()) {
                                break;
                            }
                            String string = cursor2.getString(cursor2.getColumnIndex("ext"));
                            if (hashMap.containsKey(string)) {
                                contentValues.clear();
                                contentValues.put("tid", (Long) hashMap.get(string));
                                sQLiteDatabase.update(athena.a.a(), contentValues, "tid=" + athenaVar2.b() + " AND ext=?", new String[]{string});
                            }
                        } catch (SQLiteException e) {
                            cursor = cursor2;
                            e = e;
                            try {
                                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                } else {
                                    cursor3 = sQLiteDatabase;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                a(e);
                                throw new anateh("updateAppConfig_sql", e);
                            } catch (Throwable th3) {
                                th = th3;
                                sQLiteDatabase = cursor3;
                                cursor3 = cursor;
                                if (cursor3 != null) {
                                    cursor3.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            cursor3 = cursor2;
                            th = th4;
                            if (cursor3 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } else {
                    cursor2 = null;
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor2 != null) {
                    cursor2.close();
                }
                sQLiteDatabase.endTransaction();
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            sQLiteDatabase = null;
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabase = null;
        }
    }

    public void a(athena athenaVar, AppIdData appIdData) throws anateh {
        String a2 = athenaVar.a();
        try {
            SQLiteDatabase b = b();
            if (b == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("appid", Integer.valueOf(appIdData.a));
            contentValues.put("base", appIdData.b);
            if (b.update(a2, contentValues, "appid=" + appIdData.a, null) != 1) {
                b.insert(a2, null, contentValues);
            }
        } catch (SQLiteException e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            a(e);
            throw new anateh("addAppId_sql", e);
        }
    }

    public void a(athena athenaVar, String str, long j) throws anateh {
        String a2 = athenaVar.a();
        try {
            SQLiteDatabase b = b();
            if (b == null) {
                return;
            }
            b.execSQL("UPDATE " + a2 + " SET created_at = er_ts + " + j + ", boot_id = '' WHERE boot_id = '" + str + "'");
        } catch (SQLiteException e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            a(e);
            throw new anateh("updateEvents_sql", e);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0064: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:40:0x0064 */
    public void a(athena athenaVar, List<AppIdData> list) throws anateh {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        String a2 = athenaVar.a();
        StringBuilder sb = new StringBuilder();
        SQLiteDatabase sQLiteDatabase3 = null;
        try {
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase3 = sQLiteDatabase;
        }
        try {
            try {
                sQLiteDatabase2 = b();
                if (sQLiteDatabase2 == null) {
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                        return;
                    }
                    return;
                }
                try {
                    sQLiteDatabase2.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("uid", BuildConfig.FLAVOR);
                    for (AppIdData appIdData : list) {
                        sQLiteDatabase2.update(athena.a.a(), contentValues, "CAST(tid AS TEXT) LIKE ? AND uid=?", new String[]{appIdData.a + "%", appIdData.c});
                        com.transsion.athena.config.data.model.anehat.a(sb, Integer.valueOf(appIdData.a));
                    }
                    contentValues.put("try", (Integer) 0);
                    sQLiteDatabase2.update(a2, contentValues, "appid IN (" + sb.toString() + ")", null);
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                } catch (SQLiteException e) {
                    e = e;
                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    } else {
                        sQLiteDatabase3 = sQLiteDatabase2;
                    }
                    a(e);
                    throw new anateh("updateAppIdList_sql", e);
                }
            } catch (SQLiteException e2) {
                e = e2;
                sQLiteDatabase2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            if (sQLiteDatabase3 != null) {
                sQLiteDatabase3.endTransaction();
            }
            throw th;
        }
    }

    public void a(athena athenaVar, List<AppIdData> list, int i) throws anateh {
        String a2 = athenaVar.a();
        StringBuilder sb = new StringBuilder();
        try {
            for (AppIdData appIdData : list) {
                com.transsion.athena.config.data.model.anehat.a(sb, Integer.valueOf(appIdData.a));
                appIdData.d = i;
            }
            SQLiteDatabase b = b();
            if (b == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("try", Integer.valueOf(i));
            b.update(a2, contentValues, "appid IN (" + sb.toString() + ")", null);
        } catch (SQLiteException e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            a(e);
            throw new anateh("updateEvents_sql", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0276 A[Catch: all -> 0x00c6, TryCatch #2 {all -> 0x00c6, blocks: (B:46:0x0088, B:48:0x008e, B:57:0x00a3, B:64:0x00c1, B:60:0x00d7, B:68:0x00ce, B:76:0x00e2, B:12:0x026d, B:14:0x0276, B:16:0x027b), top: B:2:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x027b A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #2 {all -> 0x00c6, blocks: (B:46:0x0088, B:48:0x008e, B:57:0x00a3, B:64:0x00c1, B:60:0x00d7, B:68:0x00ce, B:76:0x00e2, B:12:0x026d, B:14:0x0276, B:16:0x027b), top: B:2:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(athena athenaVar, List<AppIdData> list, long j, String str, enatha<SparseArray<com.transsion.athena.data.enatha>> enathaVar) throws anateh {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor2;
        anehat anehatVar;
        SQLiteDatabase sQLiteDatabase2;
        String str2;
        Cursor cursor3;
        ContentValues contentValues;
        String str3;
        String str4;
        String str5;
        int parseInt;
        String str6 = "_id";
        String str7 = " AND ";
        String a2 = athenaVar.a();
        StringBuilder sb = new StringBuilder();
        SparseArray<com.transsion.athena.data.enatha> sparseArray = new SparseArray<>();
        Cursor cursor4 = null;
        try {
            try {
                Iterator<AppIdData> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        com.transsion.athena.config.data.model.anehat.a(sb, Integer.valueOf(it.next().a));
                    } catch (SQLiteException e) {
                        e = e;
                        sQLiteDatabase = null;
                        cursor2 = null;
                        cursor = null;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        try {
                            anehatVar.a(e);
                            throw new anateh("cleanupEvents_sql", e);
                        } catch (Throwable th2) {
                            th = th2;
                            sQLiteDatabase = sQLiteDatabase2;
                            cursor4 = cursor2;
                            if (cursor4 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        sQLiteDatabase = null;
                        if (cursor4 != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                }
                sQLiteDatabase = b();
                if (sQLiteDatabase == null) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                        return;
                    }
                    return;
                }
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor2 = sQLiteDatabase.rawQuery("SELECT * FROM " + athena.d.a() + " WHERE appid IN (" + ((Object) sb) + ")", null);
                    while (true) {
                        str2 = "ext";
                        if (cursor2 == null) {
                            break;
                        }
                        try {
                            if (!cursor2.moveToNext()) {
                                break;
                            }
                            int i = cursor2.getInt(cursor2.getColumnIndex("appid"));
                            if (i != 9999 && i != 1031 && i != 1041) {
                                int i2 = cursor2.getInt(cursor2.getColumnIndex("cnt"));
                                String string = cursor2.getString(cursor2.getColumnIndex("date"));
                                String string2 = cursor2.getString(cursor2.getColumnIndex("ext"));
                                if (!TextUtils.isEmpty(string2)) {
                                    try {
                                        parseInt = Integer.parseInt(string2);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                    sparseArray.put(i, new com.transsion.athena.data.enatha(i, string, i2, parseInt));
                                }
                                parseInt = 0;
                                sparseArray.put(i, new com.transsion.athena.data.enatha(i, string, i2, parseInt));
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            cursor = null;
                            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            anehatVar.a(e);
                            throw new anateh("cleanupEvents_sql", e);
                        }
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    try {
                        try {
                            Iterator<AppIdData> it2 = list.iterator();
                            while (it2.hasNext()) {
                                AppIdData next = it2.next();
                                int i3 = 0;
                                for (com.transsion.athena.data.anehat anehatVar2 : next.e) {
                                    try {
                                        Iterator<AppIdData> it3 = it2;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("tid=");
                                        cursor3 = cursor2;
                                        String str8 = str2;
                                        try {
                                            try {
                                                sb2.append(anehatVar2.a);
                                                sb2.append(str7);
                                                sb2.append(str6);
                                                sb2.append(">=");
                                                sb2.append(anehatVar2.d);
                                                sb2.append(str7);
                                                sb2.append(str6);
                                                sb2.append("<=");
                                                sb2.append(anehatVar2.e);
                                                sQLiteDatabase.delete(a2, sb2.toString(), null);
                                                if (anehatVar2.h) {
                                                    ContentValues contentValues2 = new ContentValues();
                                                    contentValues2.put("pt", Long.valueOf(j));
                                                    String a3 = athena.c.a();
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append("tid=");
                                                    str4 = str6;
                                                    str5 = str7;
                                                    sb3.append(anehatVar2.a);
                                                    sQLiteDatabase.update(a3, contentValues2, sb3.toString(), null);
                                                } else {
                                                    str4 = str6;
                                                    str5 = str7;
                                                }
                                                i3 += anehatVar2.f;
                                                it2 = it3;
                                                cursor2 = cursor3;
                                                str2 = str8;
                                                str6 = str4;
                                                str7 = str5;
                                            } catch (SQLiteException e4) {
                                                e = e4;
                                                cursor2 = cursor3;
                                                cursor = null;
                                                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase != null) {
                                                }
                                                anehatVar.a(e);
                                                throw new anateh("cleanupEvents_sql", e);
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            cursor4 = cursor3;
                                            if (cursor4 != null) {
                                            }
                                            if (sQLiteDatabase != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e5) {
                                        e = e5;
                                    }
                                }
                                String str9 = str6;
                                String str10 = str7;
                                Iterator<AppIdData> it4 = it2;
                                cursor3 = cursor2;
                                String str11 = str2;
                                try {
                                    contentValues = new ContentValues();
                                    com.transsion.athena.data.enatha enathaVar2 = sparseArray.get(next.a);
                                    if (enathaVar2 != null) {
                                        String str12 = enathaVar2.b;
                                        if (str12 == null || str12.equals(str)) {
                                            sparseArray.remove(next.a);
                                        }
                                        String str13 = enathaVar2.b;
                                        if (str13 == null || !str13.equals(str)) {
                                            str3 = str11;
                                            contentValues.put("date", str);
                                            contentValues.put("cnt", Integer.valueOf(i3));
                                            contentValues.put(str3, MsgStyle.CUSTOM_LEFT_PIC);
                                        } else {
                                            contentValues.put("cnt", Integer.valueOf(enathaVar2.c + i3));
                                            str3 = str11;
                                            contentValues.put(str3, String.valueOf(enathaVar2.d + 1));
                                        }
                                    } else {
                                        str3 = str11;
                                    }
                                    contentValues.put("uid", BuildConfig.FLAVOR);
                                    contentValues.put("try", (Integer) 0);
                                    cursor = null;
                                } catch (SQLiteException e6) {
                                    e = e6;
                                    cursor = null;
                                    cursor2 = cursor3;
                                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.endTransaction();
                                        anehatVar = this;
                                        sQLiteDatabase2 = cursor;
                                    } else {
                                        anehatVar = this;
                                        sQLiteDatabase2 = sQLiteDatabase;
                                    }
                                    anehatVar.a(e);
                                    throw new anateh("cleanupEvents_sql", e);
                                }
                                try {
                                    sQLiteDatabase.update(athena.d.a(), contentValues, "appid=" + next.a, null);
                                    cursor4 = null;
                                    cursor2 = cursor3;
                                    str6 = str9;
                                    str7 = str10;
                                    str2 = str3;
                                    it2 = it4;
                                } catch (SQLiteException e7) {
                                    e = e7;
                                    cursor2 = cursor3;
                                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    anehatVar.a(e);
                                    throw new anateh("cleanupEvents_sql", e);
                                }
                            }
                            cursor = cursor4;
                            cursor3 = cursor2;
                            sQLiteDatabase.setTransactionSuccessful();
                            if (enathaVar != null) {
                                enathaVar.a(sparseArray);
                            }
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            sQLiteDatabase.endTransaction();
                        } catch (SQLiteException e8) {
                            e = e8;
                            cursor = cursor4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor3 = cursor2;
                    }
                } catch (SQLiteException e9) {
                    e = e9;
                    cursor = null;
                    cursor2 = null;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                cursor4 = cursor2;
                if (cursor4 != null) {
                    cursor4.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                throw th;
            }
        } catch (SQLiteException e10) {
            e = e10;
            cursor = null;
            sQLiteDatabase = null;
            cursor2 = null;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public void a(athena athenaVar, List<Long> list, enatha<String> enathaVar) throws anateh {
        String a2 = athenaVar.a();
        String a3 = com.transsion.athena.config.data.model.anehat.a(list, ",");
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase b = b();
                if (b == null) {
                    return;
                }
                LongSparseArray longSparseArray = new LongSparseArray();
                Cursor rawQuery = b.rawQuery("SELECT tid FROM " + a2 + " WHERE tid IN (" + a3 + ")", null);
                while (rawQuery != null) {
                    try {
                        if (!rawQuery.moveToNext()) {
                            break;
                        }
                        long j = rawQuery.getLong(0);
                        longSparseArray.put(j, Integer.valueOf(((Integer) longSparseArray.get(j, 0)).intValue() + 1));
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = rawQuery;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (cursor != null) {
                            cursor.close();
                        }
                        a(e);
                        throw new anateh("cleanupEvents_off_sql", e);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                b.delete(a2, "tid IN (" + a3 + ")", null);
                if (enathaVar != null && longSparseArray.size() > 0) {
                    enathaVar.a(longSparseArray.toString());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0081: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:37:0x0081 */
    public void a(athena athenaVar, List<AppIdData> list, String str) throws anateh {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        String a2 = athenaVar.a();
        StringBuilder sb = new StringBuilder();
        SQLiteDatabase sQLiteDatabase3 = null;
        try {
            try {
                try {
                    sQLiteDatabase = b();
                    if (sQLiteDatabase == null) {
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                            return;
                        }
                        return;
                    }
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", str);
                        sQLiteDatabase.beginTransaction();
                        for (AppIdData appIdData : list) {
                            for (com.transsion.athena.data.anehat anehatVar : appIdData.e) {
                                sQLiteDatabase.update(a2, contentValues, "tid=" + anehatVar.a + " AND _id>=" + anehatVar.d + " AND _id<=" + anehatVar.e, null);
                            }
                            com.transsion.athena.config.data.model.anehat.a(sb, Integer.valueOf(appIdData.a));
                        }
                        contentValues.put("try", (Integer) 0);
                        sQLiteDatabase.update(athena.d.a(), contentValues, "appid IN (" + sb.toString() + ")", null);
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                    } catch (SQLiteException e) {
                        e = e;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        a(e);
                        throw new anateh("updateEvents_sql", e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase3 = sQLiteDatabase2;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.endTransaction();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                sQLiteDatabase = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void a(enatha<SparseArray<com.transsion.athena.config.data.model.athena>> enathaVar) throws anateh {
        com.transsion.athena.config.data.model.athena a2;
        SparseArray<com.transsion.athena.config.data.model.athena> sparseArray = new SparseArray<>();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase b = b();
                if (b == null) {
                    return;
                }
                Cursor rawQuery = b.rawQuery("SELECT * FROM " + athena.d.a(), null);
                while (rawQuery != null) {
                    try {
                        if (!rawQuery.moveToNext()) {
                            break;
                        }
                        String string = rawQuery.getString(rawQuery.getColumnIndex("cfg"));
                        if (!TextUtils.isEmpty(string) && (a2 = com.transsion.athena.config.data.model.athena.a(string)) != null) {
                            a2.a(rawQuery.getInt(rawQuery.getColumnIndex("appid")));
                            sparseArray.put(a2.b(), a2);
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = rawQuery;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (cursor != null) {
                            cursor.close();
                        }
                        a(e);
                        throw new anateh("getAPPIDApp_sql", e);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                cursor = b.rawQuery("SELECT * FROM " + athena.c.a(), null);
                while (cursor != null && cursor.moveToNext()) {
                    long j = cursor.getLong(cursor.getColumnIndex("tid"));
                    String string2 = cursor.getString(cursor.getColumnIndex("ev"));
                    aatnhe aatnheVar = new aatnhe();
                    aatnheVar.c(cursor.getLong(cursor.getColumnIndex("pt")));
                    aatnheVar.a(cursor.getString(cursor.getColumnIndex("cf")));
                    com.transsion.athena.config.data.model.athena athenaVar = sparseArray.get(com.transsion.athena.taaneh.anehat.a(j));
                    if (athenaVar != null) {
                        athenaVar.a(new TidConfigBean(j, string2, aatnheVar));
                    }
                }
                if (enathaVar != null) {
                    enathaVar.a(sparseArray);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SQLiteException e2) {
            e = e2;
        }
    }

    public void a(boolean z) {
        if (z) {
            try {
                this.b.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean a(athena athenaVar, int i) throws anateh {
        String a2 = athenaVar.a();
        try {
            SQLiteDatabase b = b();
            if (b == null) {
                return false;
            }
            b.delete(a2, "CAST(tid AS TEXT) LIKE ?", new String[]{i + "%"});
            return true;
        } catch (SQLiteException e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            a(e);
            throw new anateh("cleanupEvents_del_sql", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a2  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b(athena athenaVar, List<Track> list, enatha<LongSparseArray<Integer>> enathaVar) throws anateh {
        ?? r6;
        ?? r62;
        Cursor cursor;
        ?? a2 = athenaVar.a();
        HashSet hashSet = new HashSet();
        Cursor cursor2 = null;
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                ?? b = b();
                int i = 0;
                if (b == 0) {
                    if (b != 0) {
                        b.endTransaction();
                    }
                    if (this.b.b()) {
                        com.transsion.athena.taaneh.aethna.b("There is not enough space left");
                    }
                    return 0;
                }
                try {
                    b.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (Track track : list) {
                        JSONObject jsonData = track.getJsonData();
                        Pair<Integer, byte[]> i2 = com.transsion.athena.aethna.athena.c().i();
                        Integer num = (Integer) i2.first;
                        num.intValue();
                        String a3 = com.transsion.athena.anateh.anehat.a(jsonData.toString(), (byte[]) i2.second);
                        if (a3 != null) {
                            contentValues.clear();
                            contentValues.put("tid", Long.valueOf(track.getTid()));
                            contentValues.put("event", a3);
                            contentValues.put("et", (Integer) 0);
                            contentValues.put("pi", num);
                            contentValues.put("created_at", Long.valueOf(track.getTrackTs()));
                            if (track.getBootId() != null) {
                                contentValues.put("er_ts", Long.valueOf(track.getTrackErTs()));
                                contentValues.put("boot_id", track.getBootId());
                            }
                            if (b.insert(a2, null, contentValues) > 0) {
                                hashSet.add(Long.valueOf(track.getTid()));
                            }
                        }
                    }
                    if (hashSet.size() > 0) {
                        LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
                        cursor = b.rawQuery("SELECT tid,COUNT(*) FROM " + a2 + " WHERE tid IN (" + com.transsion.athena.config.data.model.anehat.a(hashSet, ",") + ") GROUP BY tid", null);
                        int i3 = 0;
                        while (cursor != null) {
                            try {
                                if (!cursor.moveToNext()) {
                                    break;
                                }
                                longSparseArray.put(cursor.getLong(0), Integer.valueOf(cursor.getInt(1)));
                                i3++;
                            } catch (SQLiteException e) {
                                e = e;
                                a2 = cursor;
                                r62 = b;
                                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                if (a2 != 0) {
                                    a2.close();
                                }
                                if (r62 != 0) {
                                    r62.endTransaction();
                                } else {
                                    cursor2 = r62;
                                }
                                try {
                                    a(e);
                                    throw new anateh("addJSON_sql", e);
                                } catch (Throwable th3) {
                                    th = th3;
                                    r6 = cursor2;
                                    cursor2 = a2;
                                    if (cursor2 != null) {
                                    }
                                    if (r6 != 0) {
                                    }
                                    if (this.b.b()) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                throw new anateh("addJSON", e);
                            }
                        }
                        if (enathaVar != null && longSparseArray.size() > 0) {
                            enathaVar.a(longSparseArray);
                        }
                        i = i3;
                        cursor = cursor;
                    } else {
                        cursor = null;
                    }
                    b.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                    b.endTransaction();
                    if (!this.b.b()) {
                        return i;
                    }
                    com.transsion.athena.taaneh.aethna.b("There is not enough space left");
                    return -2;
                } catch (SQLiteException e3) {
                    e = e3;
                    a2 = 0;
                    r62 = b;
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Throwable th4) {
                th = th4;
                cursor2 = a2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (r6 != 0) {
                    r6.endTransaction();
                }
                if (this.b.b()) {
                    com.transsion.athena.taaneh.aethna.b("There is not enough space left");
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            a2 = 0;
            r62 = 0;
        } catch (Exception e6) {
            e = e6;
        } catch (Throwable th5) {
            th = th5;
            r6 = 0;
            if (cursor2 != null) {
            }
            if (r6 != 0) {
            }
            if (this.b.b()) {
            }
            throw th;
        }
    }
}
