package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$z0 extends b {
    AppDatabase$z0() {
        super(57, 58);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "db");
        dVar.E("ALTER TABLE download_table ADD COLUMN kidId TEXT");
        dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN kidId TEXT");
    }
}
