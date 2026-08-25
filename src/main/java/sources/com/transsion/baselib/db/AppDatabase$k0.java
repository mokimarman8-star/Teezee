package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$k0 extends b {
    AppDatabase$k0() {
        super(43, 44);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("CREATE TABLE IF NOT EXISTS MUSIC_LIKED (`subjectId` TEXT NOT NULL, `title` TEXT, `coverUrl` TEXT, `countryName` TEXT, `genre` TEXT, `releaseDate` TEXT, `durationSeconds` INTEGER NOT NULL DEFAULT 0, `singerName` TEXT, `singerAvatar` TEXT, `path` TEXT, `timeStamp` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`subjectId`))");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD ops TEXT");
    }
}
