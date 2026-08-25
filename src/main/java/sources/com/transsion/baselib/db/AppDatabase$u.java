package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$u extends b {
    AppDatabase$u() {
        super(29, 30);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("CREATE TABLE IF NOT EXISTS SHORT_TV_PLAY (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `totalEp` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `description` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoId` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, PRIMARY KEY(`subjectId`))");
    }
}
