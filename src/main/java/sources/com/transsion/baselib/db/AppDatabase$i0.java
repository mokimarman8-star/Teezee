package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$i0 extends b {
    AppDatabase$i0() {
        super(41, 42);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD lastAdStartTimeStamp INTEGER");
        dVar.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD lastAdEndTimeStamp INTEGER");
    }
}
