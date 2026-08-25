package androidx.coroutines.impl;

import android.content.ContentValues;
import kotlin.jvm.internal.Intrinsics;
import x3.a;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b implements a {
    @Override // x3.a
    public void a(d dVar) {
        Intrinsics.h(dVar, "db");
        dVar.E("UPDATE workspec SET period_count = 1 WHERE last_enqueue_time <> 0 AND interval_duration <> 0");
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("last_enqueue_time", Long.valueOf(System.currentTimeMillis()));
        dVar.i0("WorkSpec", 3, contentValues, "last_enqueue_time = 0 AND interval_duration <> 0 ", new Object[0]);
    }
}
