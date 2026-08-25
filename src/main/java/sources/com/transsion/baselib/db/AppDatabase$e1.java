package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$e1 extends b {
    AppDatabase$e1() {
        super(9, 10);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("CREATE TABLE IF NOT EXISTS CONSUME_BEAN (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `updateTimeStamp` INTEGER NOT NULL,`dataType` INTEGER NOT NULL,`appVersion` INTEGER NOT NULL, `consumeJson` TEXT)");
    }
}
