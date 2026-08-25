package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$d1 extends b {
    AppDatabase$d1() {
        super(8, 9);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE MSG ADD `has_screen_on` INTEGER NOT NULL DEFAULT 0");
    }
}
