package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$r extends b {
    AppDatabase$r() {
        super(26, 27);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD rootPath TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD rootPathType INTEGER NOT NULL DEFAULT 1");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD thumbnail TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD isTransferFailed INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD isClosedTransferFailed INTEGER NOT NULL DEFAULT 0");
    }
}
