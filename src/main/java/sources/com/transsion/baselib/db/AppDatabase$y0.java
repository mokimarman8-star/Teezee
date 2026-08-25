package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import ri.a;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$y0 extends b {
    AppDatabase$y0() {
        super(56, 57);
    }

    public void b(d dVar) {
        boolean b;
        boolean b2;
        boolean b3;
        boolean b4;
        boolean b5;
        boolean b6;
        Intrinsics.h(dVar, "db");
        b = a.b(dVar, "DOWNLOAD_TABLE", "ugcVideoIsVertical");
        if (!b) {
            dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoIsVertical INTEGER NOT NULL DEFAULT 0");
        }
        b2 = a.b(dVar, "ugc_video_detail_play", "uid");
        if (!b2) {
            dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN uid TEXT");
        }
        b3 = a.b(dVar, "ugc_video_detail_play", "userName");
        if (!b3) {
            dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userName TEXT");
        }
        b4 = a.b(dVar, "ugc_video_detail_play", "userAvatar");
        if (!b4) {
            dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userAvatar TEXT");
        }
        b5 = a.b(dVar, "ugc_video_detail_play", "description");
        if (!b5) {
            dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN description TEXT");
        }
        b6 = a.b(dVar, "ugc_video_detail_play", "videoStyle");
        if (!b6) {
            dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN videoStyle TEXT");
        }
        dVar.E("ALTER TABLE download_table ADD COLUMN ugcCateLev1Id INTEGER");
        dVar.E("ALTER TABLE download_table ADD COLUMN ugcCateLev2Id INTEGER");
        dVar.E("ALTER TABLE download_table ADD COLUMN ugcCateLev3Id INTEGER");
        dVar.E("ALTER TABLE download_table ADD COLUMN ugcCateLev4Id INTEGER");
        dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN cateLev1Id INTEGER");
        dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN cateLev2Id INTEGER");
        dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN cateLev3Id INTEGER");
        dVar.E("ALTER TABLE ugc_video_detail_play ADD COLUMN cateLev4Id INTEGER");
    }
}
