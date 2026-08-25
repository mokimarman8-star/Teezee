package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$o extends b {
    AppDatabase$o() {
        super(23, 24);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD taskId TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD sessionTime INTEGER NOT NULL DEFAULT 0");
    }
}
