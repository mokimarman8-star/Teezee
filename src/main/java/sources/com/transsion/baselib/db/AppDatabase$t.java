package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$t extends b {
    AppDatabase$t() {
        super(28, 29);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE SUBTITLE_LANGUAGE_MAP_TABLE ADD lanIOS3 TEXT");
    }
}
