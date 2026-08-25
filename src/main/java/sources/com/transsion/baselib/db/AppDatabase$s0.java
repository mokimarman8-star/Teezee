package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$s0 extends b {
    AppDatabase$s0() {
        super(50, 51);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoCollectionId TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoId TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoPosition INTEGER");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoType TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoName TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoCollectionName TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN subtitleIdType TEXT");
        dVar.E("CREATE TABLE IF NOT EXISTS `ugc_collection_video_group` (`collectionId` TEXT NOT NULL, `ugcVideoIds` TEXT NOT NULL, PRIMARY KEY(`collectionId`))");
        dVar.E("CREATE TABLE IF NOT EXISTS `ugc_video_detail_play` (`collectionId` TEXT NOT NULL, `ugcVideoId` TEXT NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `position` INTEGER NOT NULL, `type` TEXT, `timeStamp` INTEGER NOT NULL, `subtitleSelectId` TEXT, `totalDuration` INTEGER, `subjectDurationSeconds` INTEGER, `averageHueLight` TEXT, `subjectType` INTEGER, `hasDelete` INTEGER NOT NULL, `playMode` TEXT NOT NULL, `downloadUrl` TEXT, `downloadResid` TEXT, `downloadFilePath` TEXT, `downloadSize` INTEGER NOT NULL, `lastAdStartTimeStamp` INTEGER, `lastAdEndTimeStamp` INTEGER, `rewardPlayed` INTEGER NOT NULL, `rewardUnlock` INTEGER NOT NULL, `rewardFree` INTEGER NOT NULL,`ops` TEXT,  PRIMARY KEY(`collectionId`))");
    }
}
