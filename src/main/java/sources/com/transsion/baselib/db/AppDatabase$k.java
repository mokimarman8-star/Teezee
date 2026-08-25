package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$k extends b {
    AppDatabase$k() {
        super(1, 2);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN postId TEXT");
        dVar.E("ALTER TABLE AUDIO ADD COLUMN ops TEXT");
    }
}
