package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$e extends b {
    AppDatabase$e() {
        super(14, 15);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD downloadErrorCount INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD subtitleStarted INTEGER NOT NULL DEFAULT 0");
    }
}
