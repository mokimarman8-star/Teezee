package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$w0 extends b {
    AppDatabase$w0() {
        super(54, 55);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD ugcVideoIsVertical INTEGER NOT NULL DEFAULT 0");
        dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN uid TEXT");
        dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userName TEXT");
        dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userAvatar TEXT");
        dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN description TEXT");
        dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN videoStyle TEXT");
    }
}
