package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$c0 extends b {
    AppDatabase$c0() {
        super(36, 37);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE NON_AD_PLANS ADD adShowLevel TEXT");
        dVar.E("ALTER TABLE NON_AD_PLANS ADD filterClientVersion TEXT");
        dVar.E("ALTER TABLE NON_AD_PLANS ADD adPlanCreateTime TEXT");
        dVar.E("ALTER TABLE NON_AD_PLANS ADD appStarDesc TEXT");
        dVar.E("ALTER TABLE NON_AD_PLANS ADD appSizeDesc TEXT");
    }
}
