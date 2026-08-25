package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$h0 extends b {
    AppDatabase$h0() {
        super(40, 41);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD subjectDurationSeconds INTEGER DEFAULT 0");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD subjectDurationSeconds INTEGER DEFAULT 0");
    }
}
