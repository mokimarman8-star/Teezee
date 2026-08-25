package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$a1 extends b {
    AppDatabase$a1() {
        super(5, 6);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("CREATE TABLE IF NOT EXISTS `DOWNLOAD_SUBTITLE_TABLE` (`resourceId` TEXT NOT NULL, `postId` TEXT, `url` TEXT, `path` TEXT, `lan` TEXT, `lanName` TEXT NOT NULL, `size` INTEGER,`delayDuration` INTEGER, `status` INTEGER NOT NULL, PRIMARY KEY(`resourceId`))");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD episode INTEGER NOT NULL DEFAULT 0");
    }
}
