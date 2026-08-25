package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$p0 extends b {
    AppDatabase$p0() {
        super(48, 49);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE SHORT_TV_PLAY ADD subtitleSelectId TEXT");
    }
}
