package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$o0 extends b {
    AppDatabase$o0() {
        super(47, 48);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN rewardPlayed INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN rewardUnlock INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN rewardFree INTEGER NOT NULL DEFAULT 0");
    }
}
