package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$b1 extends b {
    AppDatabase$b1() {
        super(6, 7);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD pageFrom TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD lastPageFrom TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD subjectId TEXT");
    }
}
