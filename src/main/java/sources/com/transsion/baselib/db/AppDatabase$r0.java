package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$r0 extends b {
    AppDatabase$r0() {
        super(4, 5);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE AUDIO ADD COLUMN resourceId TEXT");
        dVar.E("ALTER TABLE AUDIO ADD COLUMN postId TEXT");
        dVar.E("ALTER TABLE AUDIO ADD COLUMN subjectId TEXT");
        dVar.E("ALTER TABLE AUDIO ADD COLUMN groupId TEXT");
    }
}
