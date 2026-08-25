package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$n0 extends b {
    AppDatabase$n0() {
        super(46, 47);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN lastAdStartTimeStamp INTEGER");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN lastAdEndTimeStamp INTEGER");
    }
}
