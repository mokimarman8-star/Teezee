package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$b extends b {
    AppDatabase$b() {
        super(11, 12);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE AUDIO ADD subjectTitle TEXT");
        dVar.E("ALTER TABLE AUDIO ADD se INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE AUDIO ADD ep INTEGER NOT NULL DEFAULT 0");
    }
}
