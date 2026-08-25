package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$f0 extends b {
    AppDatabase$f0() {
        super(39, 40);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN dubs TEXT");
    }
}
