package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$p extends b {
    AppDatabase$p() {
        super(24, 25);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD reportStatus INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD downloadHeaderSize INTEGER NOT NULL DEFAULT 0");
    }
}
