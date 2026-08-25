package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$i extends b {
    AppDatabase$i() {
        super(18, 19);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD uploadBy TEXT ");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD sourceUrl TEXT ");
    }
}
