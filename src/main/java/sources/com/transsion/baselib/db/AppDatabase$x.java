package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$x extends b {
    AppDatabase$x() {
        super(31, 32);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE NON_AD_PLANS ADD adPlanUpdateTime TEXT");
        dVar.E("ALTER TABLE NON_AD_PLANS ADD sort INTEGER");
    }
}
