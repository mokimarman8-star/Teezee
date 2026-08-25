package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$c extends b {
    AppDatabase$c() {
        super(12, 13);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD ep INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD se INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD videoWidth INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD videoHeight INTEGER NOT NULL DEFAULT 0");
    }
}
