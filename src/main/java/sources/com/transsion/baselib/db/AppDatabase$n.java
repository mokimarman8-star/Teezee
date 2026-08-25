package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$n extends b {
    AppDatabase$n() {
        super(22, 23);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE MSG ADD permanent_msg_status INTEGER NOT NULL DEFAULT 0");
    }
}
