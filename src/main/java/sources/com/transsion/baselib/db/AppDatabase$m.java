package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$m extends b {
    AppDatabase$m() {
        super(21, 22);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD urlCreateAt INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD subtitleSelectId TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD subtitleName TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD type INTEGER NOT NULL DEFAULT 1");
        dVar.E("CREATE TABLE IF NOT EXISTS SUBTITLE_LANGUAGE_MAP_TABLE (`lan` TEXT NOT NULL, `lanName` TEXT NOT NULL, `inSearch` INTEGER NOT NULL, PRIMARY KEY(`lan`))");
    }
}
