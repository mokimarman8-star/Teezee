package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import ri.a;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$x0 extends b {
    AppDatabase$x0() {
        super(55, 56);
    }

    public void b(d dVar) {
        boolean b;
        boolean b2;
        boolean b3;
        boolean b4;
        boolean b5;
        boolean b6;
        boolean b7;
        Intrinsics.h(dVar, "db");
        b = a.b(dVar, "DOWNLOAD_TABLE", "ugcVideoIsVertical");
        if (!b) {
            dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoIsVertical INTEGER NOT NULL DEFAULT 0");
        }
        b2 = a.b(dVar, "DOWNLOAD_TABLE", "originData");
        if (!b2) {
            dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN originData TEXT");
        }
        b3 = a.b(dVar, "ugc_video_detail_play", "uid");
        if (!b3) {
            dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN uid TEXT");
        }
        b4 = a.b(dVar, "ugc_video_detail_play", "userName");
        if (!b4) {
            dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userName TEXT");
        }
        b5 = a.b(dVar, "ugc_video_detail_play", "userAvatar");
        if (!b5) {
            dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userAvatar TEXT");
        }
        b6 = a.b(dVar, "ugc_video_detail_play", "description");
        if (!b6) {
            dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN description TEXT");
        }
        b7 = a.b(dVar, "ugc_video_detail_play", "videoStyle");
        if (!b7) {
            dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN videoStyle TEXT");
        }
        dVar.E("CREATE TABLE IF NOT EXISTS home_preferences_interval_time (\n    id TEXT NOT NULL,\n    showTime INTEGER NOT NULL,\n    closeTime INTEGER NOT NULL,\n    chooseTime INTEGER NOT NULL,\n    showIntervalSeconds INTEGER NOT NULL,\n    closeIntervalSeconds INTEGER NOT NULL,\n    chooseIntervalSeconds INTEGER NOT NULL,\n    PRIMARY KEY(id)\n)");
    }
}
