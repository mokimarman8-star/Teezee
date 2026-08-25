package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$g0 extends b {
    AppDatabase$g0() {
        super(3, 4);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD resourceId TEXT");
    }
}
