package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$t0 extends b {
    AppDatabase$t0() {
        super(51, 52);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoTrackId TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoParentVideoId TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoParentTrackId TEXT");
    }
}
