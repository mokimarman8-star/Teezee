package com.facebook.biddingkit.logging;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cloud.tmc.kernel.bridge.SendToNativeCallback;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class f {
    private static volatile f b;
    private final d a;

    public f(Context context) {
        this.a = new d(context, "EventLogsDatabase.db", null, 1);
    }

    public static void b(String str) {
        try {
            d().c().delete("EVENT_LOGS", "ID=?", new String[]{str});
        } catch (Throwable th) {
            b.b("EventLogDatabaseAdapter", "Failed deleting entry", th);
        }
    }

    public static f d() {
        return b;
    }

    public static List e(int i) {
        LinkedList linkedList = new LinkedList();
        try {
            Cursor query = d().c().query("EVENT_LOGS", null, null, null, null, null, null, null);
            int columnIndex = query.getColumnIndex("exception");
            int columnIndex2 = query.getColumnIndex("auction_id");
            int columnIndex3 = query.getColumnIndex("ID");
            int columnIndex4 = query.getColumnIndex("bidder_data");
            while (query.moveToNext() && i > 0) {
                e eVar = new e();
                eVar.e(query.getString(columnIndex));
                eVar.a(query.getString(columnIndex2));
                eVar.c(query.getString(columnIndex3));
                JSONObject jSONObject = new JSONObject(query.getString(columnIndex4));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    eVar.g(next, jSONObject2.optString("result"));
                    eVar.b(next, jSONObject2.optString("cpm_cents"));
                    eVar.d(next, jSONObject2.optString(SendToNativeCallback.KEY_CODE));
                    eVar.f(next, jSONObject2.optString("latency_ms"));
                }
                linkedList.add(eVar);
                i--;
            }
            query.close();
        } catch (Throwable th) {
            b.b("EventLogDatabaseAdapter", "Failed getting rows", th);
        }
        return linkedList;
    }

    public static void f(Context context) {
        if (b == null) {
            synchronized (f.class) {
                try {
                    if (b == null) {
                        b = new f(context);
                    }
                } finally {
                }
            }
        }
    }

    public static void g(e eVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("auction_id", eVar.i());
            contentValues.put("exception", eVar.l());
            contentValues.put("bidder_data", eVar.h().toString());
            SQLiteDatabase c = d().c();
            c.insert("EVENT_LOGS", null, contentValues);
            c.close();
        } catch (Exception e) {
            b.b("EventLogDatabaseAdapter", "Failed inserting an entry", e);
        }
    }

    public void a() {
        SQLiteDatabase c = c();
        if (c != null) {
            c.close();
        }
    }

    public SQLiteDatabase c() {
        try {
            return this.a.getWritableDatabase();
        } catch (Throwable th) {
            b.b("EventLogDatabaseAdapter", "Failed getting Writable Database", th);
            return null;
        }
    }

    public void finalize() {
        a();
        super.finalize();
    }
}
