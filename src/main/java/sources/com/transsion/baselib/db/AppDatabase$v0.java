package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$v0 extends b {
    AppDatabase$v0() {
        super(53, 54);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "db");
        dVar.E("CREATE TABLE IF NOT EXISTS member_resolution (\n    subjectId TEXT NOT NULL,\n    ep INTEGER NOT NULL,\n    se INTEGER NOT NULL,\n    vipResolutionTip INTEGER DEFAULT 0,\n    isUnlock INTEGER DEFAULT 0,\n    PRIMARY KEY(subjectId, ep, se)\n)");
    }
}
