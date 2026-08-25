package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$s extends b {
    AppDatabase$s() {
        super(27, 28);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD subjectId TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD ep INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD se INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD resolution INTEGER NOT NULL DEFAULT 0");
    }
}
