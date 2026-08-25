package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$z extends b {
    AppDatabase$z() {
        super(33, 34);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("CREATE TABLE IF NOT EXISTS ShortTvFavoriteState (`subjectId` TEXT NOT NULL, `favoriteNum` TEXT, `hasFavorite` INTEGER not null default 0,`favoriteTime` TEXT, PRIMARY KEY(`subjectId`))");
    }
}
