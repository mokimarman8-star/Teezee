package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$b0 extends b {
    AppDatabase$b0() {
        super(35, 36);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD subtitleSelectId TEXT");
    }
}
