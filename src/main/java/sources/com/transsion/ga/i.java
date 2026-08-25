package com.transsion.ga;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.os.Process;
import android.util.Log;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.taaneh.aethna;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class i {
    private static volatile i b;
    private final Context a;

    private i(Context context) {
        this.a = context;
    }

    public static i a() {
        return b;
    }

    public static void b(Context context) {
        if (b == null) {
            synchronized (i.class) {
                try {
                    if (b == null) {
                        b = new i(context);
                    }
                } finally {
                }
            }
        }
    }

    public void c(anateh anatehVar) {
        String str;
        long j;
        int b2 = com.transsion.athena.data.athena.b();
        if (b2 == 0 || anatehVar == null) {
            aethna.a("trackException tid not configure or e is null");
            return;
        }
        String a = anatehVar.a();
        if (a.contains("addJSON") || a.contains("updateEvents") || a.contains("cleanupEvents")) {
            return;
        }
        TrackData add = new TrackData().add("count", 1, 1).add("eid", a).add("pid", Process.myPid(), 2).add("extra", anatehVar.b(), 2);
        Throwable cause = anatehVar.getCause();
        if (cause == null) {
            str = null;
        } else if (cause instanceof SQLiteFullException) {
            str = cause.getClass().getName();
        } else {
            str = cause.getCause() != null ? Log.getStackTraceString(cause.getCause()) : Log.getStackTraceString(cause);
            if (str.length() > 2048) {
                str = str.substring(0, 2048);
            }
        }
        TrackData add2 = add.add("stackTrace", str);
        if (a.contains("sql")) {
            try {
                j = this.a.getFilesDir().getUsableSpace();
            } catch (Exception e) {
                e.printStackTrace();
                j = 0;
            }
            add2.add("usableSpace", j);
        }
        AthenaAnalytics.K(b2).g0("ev_athena", add2, b2);
    }
}
