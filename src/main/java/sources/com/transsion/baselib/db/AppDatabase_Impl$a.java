package com.transsion.baselib.db;

import androidx.room.f0;
import androidx.room.util.m;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.push.PushConstants;
import java.util.HashMap;
import java.util.HashSet;
import y3.a;
import y3.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class AppDatabase_Impl$a extends f0 {
    final /* synthetic */ AppDatabase_Impl d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppDatabase_Impl$a(AppDatabase_Impl appDatabase_Impl, int i, String str, String str2) {
        super(i, str, str2);
        this.d = appDatabase_Impl;
    }

    public void a(b bVar) {
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `audio` (`audioId` TEXT NOT NULL, `cover` TEXT, `duration` INTEGER, `size` INTEGER, `url` TEXT, `title` TEXT, `desc` TEXT, `bitrate` INTEGER, `updateTimeStamp` INTEGER, `readProcess` INTEGER, `localPath` TEXT, `ops` TEXT, `resourceId` TEXT, `postId` TEXT, `subjectId` TEXT, `groupId` TEXT, `status` INTEGER NOT NULL, `subjectTitle` TEXT, `se` INTEGER NOT NULL, `ep` INTEGER NOT NULL, PRIMARY KEY(`audioId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `download_table` (`url` TEXT NOT NULL, `resourceId` TEXT, `name` TEXT, `cover` TEXT, `size` INTEGER, `postId` TEXT, `sizeFormat` TEXT, `path` TEXT, `duration` INTEGER, `updateTimeStamp` INTEGER, `progress` INTEGER NOT NULL, `supportRanges` INTEGER NOT NULL, `status` INTEGER NOT NULL, `type` INTEGER NOT NULL, `readProgress` INTEGER NOT NULL, `createAt` INTEGER NOT NULL, `isRead` INTEGER NOT NULL, `episode` INTEGER NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `resolution` INTEGER NOT NULL, `resourcePosition` INTEGER NOT NULL, `multiresolution` INTEGER NOT NULL, `videoWidth` INTEGER NOT NULL, `videoHeight` INTEGER NOT NULL, `downloadErrorCount` INTEGER NOT NULL, `subtitleStarted` INTEGER NOT NULL, `subjectId` TEXT, `pageFrom` TEXT, `lastPageFrom` TEXT, `subjectName` TEXT, `lastPlayTimeStamp` INTEGER NOT NULL, `fileType` INTEGER NOT NULL, `totalEpisode` INTEGER NOT NULL, `uploadBy` TEXT, `sourceUrl` TEXT, `urlCreateAt` INTEGER NOT NULL, `subtitleSelectId` TEXT, `taskId` TEXT, `sessionTime` INTEGER NOT NULL, `reportStatus` INTEGER NOT NULL, `downloadHeaderSize` INTEGER NOT NULL, `rootPath` TEXT, `rootPathType` INTEGER NOT NULL, `thumbnail` TEXT, `averageHueLight` TEXT, `isTransferFailed` INTEGER NOT NULL, `isClosedTransferFailed` INTEGER NOT NULL, `subjectType` INTEGER NOT NULL, `genre` TEXT, `subjectDurationSeconds` INTEGER, `currentDubLanName` TEXT, `currentDubLanCode` TEXT, `ops` TEXT, `restrictLevel` TEXT, `releaseDate` TEXT, `countryName` TEXT, `seNum` INTEGER, `subtitles` TEXT, `imdbRate` TEXT, `lastAdStartTimeStamp` INTEGER, `lastAdEndTimeStamp` INTEGER, `subtitleIdType` TEXT, `ugcVideoCollectionId` TEXT, `ugcVideoId` TEXT, `ugcVideoName` TEXT, `ugcVideoCollectionName` TEXT, `ugcVideoPosition` INTEGER, `ugcVideoType` TEXT, `ugcCateLev1Id` INTEGER, `ugcCateLev2Id` INTEGER, `ugcCateLev3Id` INTEGER, `ugcCateLev4Id` INTEGER, `ugcVideoTrackId` TEXT, `ugcVideoParentVideoId` TEXT, `ugcVideoParentTrackId` TEXT, `ugcVideoEpTitle` TEXT, `ugcVideoIsVertical` INTEGER NOT NULL, `originData` TEXT, `kidId` TEXT, PRIMARY KEY(`url`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `video` (`postId` TEXT NOT NULL, `playProgress` INTEGER, `url` TEXT, PRIMARY KEY(`postId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `download_thread_info` (`id` INTEGER NOT NULL, `threadId` INTEGER NOT NULL, `downloadInfoId` TEXT, `uri` TEXT, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `progress` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `room_table` (`groupId` TEXT NOT NULL, `name` TEXT, `avatar` TEXT, `hasJoin` INTEGER, `newPostCount` INTEGER, `description` TEXT, `postCount` INTEGER, `userCount` INTEGER, `level` TEXT, `updateTimeStamp` INTEGER NOT NULL, PRIMARY KEY(`groupId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `permanent_msg` (`id` INTEGER NOT NULL, `deep_link_list` TEXT, `desc` TEXT, `image_list` TEXT, `message_id` TEXT, `style` TEXT, `title` TEXT, PRIMARY KEY(`id`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `download_subtitle_table` (`resourceId` TEXT NOT NULL, `postId` TEXT, `url` TEXT, `path` TEXT, `lan` TEXT, `lanName` TEXT NOT NULL, `subtitleName` TEXT, `size` INTEGER, `delayDuration` INTEGER, `status` INTEGER NOT NULL, `type` INTEGER NOT NULL, `fileCharsetName` TEXT, `subjectId` TEXT, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `resolution` INTEGER NOT NULL, PRIMARY KEY(`resourceId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `msg` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `deep_link` TEXT, `desc` TEXT, `image_list` TEXT, `message_id` TEXT, `source` TEXT, `style` TEXT, `title` TEXT, `type` TEXT, `receive_time` INTEGER, `msg_status` INTEGER NOT NULL, `show_time` INTEGER, `force_show` INTEGER NOT NULL, `has_screen_on` INTEGER NOT NULL, `built_in` INTEGER NOT NULL, `permanent_msg_status` INTEGER NOT NULL)");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `consume_bean` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `updateTimeStamp` INTEGER NOT NULL, `dataType` INTEGER NOT NULL, `appVersion` INTEGER NOT NULL, `consumeJson` TEXT)");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `download_thread_range` (`threadId` INTEGER NOT NULL, `rangeId` INTEGER NOT NULL, `resourceId` TEXT, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `progress` INTEGER NOT NULL, PRIMARY KEY(`threadId`, `rangeId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `video_land_ad` (`resourceId` TEXT NOT NULL, `startAdDayKey` INTEGER NOT NULL, `endAdDayKey` INTEGER NOT NULL, PRIMARY KEY(`resourceId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `subtitle_language_map_table` (`lan` TEXT NOT NULL, `lanIOS3` TEXT, `lanName` TEXT NOT NULL, `inSearch` INTEGER NOT NULL, PRIMARY KEY(`lan`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `non_ad_plans` (`id` TEXT NOT NULL, `version` TEXT, `name` TEXT, `startTime` TEXT, `endTime` TEXT, `extraConfig` TEXT, `displayTimes` INTEGER, `showedTimes` INTEGER, `showDate` TEXT, `advertiserName` TEXT, `advertiserAvatar` TEXT, `advertiserAvatarPath` TEXT, `brand` TEXT, `denyBrand` TEXT, `model` TEXT, `denyModel` TEXT, `country` TEXT, `scenes` TEXT, `adMaterialList` TEXT, `adPlanUpdateTime` TEXT, `sort` INTEGER, `adShowLevel` TEXT, `filterClientVersion` TEXT, `adPlanCreateTime` TEXT, `appStarDesc` TEXT, `appSizeDesc` TEXT, PRIMARY KEY(`id`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `local_mcc` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Country` TEXT NOT NULL, `Mcc` TEXT NOT NULL, `Iso` TEXT NOT NULL, `CountryCode` TEXT NOT NULL)");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `short_tv_play` (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `totalEp` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `description` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoId` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, `subtitleSelectId` TEXT, PRIMARY KEY(`subjectId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `ShortTvFavoriteState` (`subjectId` TEXT NOT NULL, `favoriteNum` TEXT, `hasFavorite` INTEGER NOT NULL, `favoriteTime` TEXT, PRIMARY KEY(`subjectId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `video_detail_play` (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, `subtitleSelectId` TEXT, `totalDuration` INTEGER, `subjectDurationSeconds` INTEGER, `averageHueLight` TEXT, `subjectType` INTEGER, `hasDelete` INTEGER NOT NULL, `playMode` TEXT NOT NULL, `downloadUrl` TEXT, `downloadFilePath` TEXT, `downloadSize` INTEGER NOT NULL, `dubs` TEXT, `lastAdStartTimeStamp` INTEGER, `lastAdEndTimeStamp` INTEGER, `rewardPlayed` INTEGER NOT NULL, `rewardUnlock` INTEGER NOT NULL, `rewardFree` INTEGER NOT NULL, `ops` TEXT, PRIMARY KEY(`subjectId`, `ep`, `se`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `music_liked` (`subjectId` TEXT NOT NULL, `title` TEXT, `coverUrl` TEXT, `countryName` TEXT, `genre` TEXT, `releaseDate` TEXT, `durationSeconds` INTEGER NOT NULL, `singerName` TEXT, `singerAvatar` TEXT, `path` TEXT, `timeStamp` INTEGER NOT NULL, PRIMARY KEY(`subjectId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `place_list` (`latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `name` TEXT, `address` TEXT, `distance` TEXT, PRIMARY KEY(`latitude`, `longitude`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `ugc_video_detail_play` (`collectionId` TEXT NOT NULL, `ugcVideoId` TEXT NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `position` INTEGER NOT NULL, `type` TEXT, `cateLev1Id` INTEGER, `cateLev2Id` INTEGER, `cateLev3Id` INTEGER, `cateLev4Id` INTEGER, `timeStamp` INTEGER NOT NULL, `subtitleSelectId` TEXT, `totalDuration` INTEGER, `subjectDurationSeconds` INTEGER, `averageHueLight` TEXT, `subjectType` INTEGER, `hasDelete` INTEGER NOT NULL, `playMode` TEXT NOT NULL, `downloadUrl` TEXT, `downloadResid` TEXT, `downloadFilePath` TEXT, `downloadSize` INTEGER NOT NULL, `lastAdStartTimeStamp` INTEGER, `lastAdEndTimeStamp` INTEGER, `rewardPlayed` INTEGER NOT NULL, `rewardUnlock` INTEGER NOT NULL, `rewardFree` INTEGER NOT NULL, `ops` TEXT, `uid` TEXT, `userName` TEXT, `userAvatar` TEXT, `description` TEXT, `videoStyle` TEXT, `kidId` TEXT, PRIMARY KEY(`collectionId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `ugc_collection_video_group` (`collectionId` TEXT NOT NULL, `ugcVideoIds` TEXT NOT NULL, PRIMARY KEY(`collectionId`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `member_resolution` (`subjectId` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `vipResolutionTip` INTEGER, `isUnlock` INTEGER, PRIMARY KEY(`subjectId`, `ep`, `se`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS `home_preferences_interval_time` (`id` TEXT NOT NULL, `showTime` INTEGER NOT NULL, `closeTime` INTEGER NOT NULL, `chooseTime` INTEGER NOT NULL, `showIntervalSeconds` INTEGER NOT NULL, `closeIntervalSeconds` INTEGER NOT NULL, `chooseIntervalSeconds` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        a.a(bVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        a.a(bVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b0c54b19a40cfcf785b1ce6277c3b3a2')");
    }

    public void b(b bVar) {
        a.a(bVar, "DROP TABLE IF EXISTS `audio`");
        a.a(bVar, "DROP TABLE IF EXISTS `download_table`");
        a.a(bVar, "DROP TABLE IF EXISTS `video`");
        a.a(bVar, "DROP TABLE IF EXISTS `download_thread_info`");
        a.a(bVar, "DROP TABLE IF EXISTS `room_table`");
        a.a(bVar, "DROP TABLE IF EXISTS `permanent_msg`");
        a.a(bVar, "DROP TABLE IF EXISTS `download_subtitle_table`");
        a.a(bVar, "DROP TABLE IF EXISTS `msg`");
        a.a(bVar, "DROP TABLE IF EXISTS `consume_bean`");
        a.a(bVar, "DROP TABLE IF EXISTS `download_thread_range`");
        a.a(bVar, "DROP TABLE IF EXISTS `video_land_ad`");
        a.a(bVar, "DROP TABLE IF EXISTS `subtitle_language_map_table`");
        a.a(bVar, "DROP TABLE IF EXISTS `non_ad_plans`");
        a.a(bVar, "DROP TABLE IF EXISTS `local_mcc`");
        a.a(bVar, "DROP TABLE IF EXISTS `short_tv_play`");
        a.a(bVar, "DROP TABLE IF EXISTS `ShortTvFavoriteState`");
        a.a(bVar, "DROP TABLE IF EXISTS `video_detail_play`");
        a.a(bVar, "DROP TABLE IF EXISTS `music_liked`");
        a.a(bVar, "DROP TABLE IF EXISTS `place_list`");
        a.a(bVar, "DROP TABLE IF EXISTS `ugc_video_detail_play`");
        a.a(bVar, "DROP TABLE IF EXISTS `ugc_collection_video_group`");
        a.a(bVar, "DROP TABLE IF EXISTS `member_resolution`");
        a.a(bVar, "DROP TABLE IF EXISTS `home_preferences_interval_time`");
    }

    public void f(b bVar) {
    }

    public void g(b bVar) {
        AppDatabase_Impl.E1(this.d, bVar);
    }

    public void h(b bVar) {
    }

    public void i(b bVar) {
        androidx.room.util.b.a(bVar);
    }

    public f0.a j(b bVar) {
        HashMap hashMap = new HashMap(20);
        hashMap.put("audioId", new m.a("audioId", "TEXT", true, 1, (String) null, 1));
        hashMap.put("cover", new m.a("cover", "TEXT", false, 0, (String) null, 1));
        hashMap.put("duration", new m.a("duration", "INTEGER", false, 0, (String) null, 1));
        hashMap.put("size", new m.a("size", "INTEGER", false, 0, (String) null, 1));
        hashMap.put("url", new m.a("url", "TEXT", false, 0, (String) null, 1));
        hashMap.put("title", new m.a("title", "TEXT", false, 0, (String) null, 1));
        hashMap.put("desc", new m.a("desc", "TEXT", false, 0, (String) null, 1));
        hashMap.put("bitrate", new m.a("bitrate", "INTEGER", false, 0, (String) null, 1));
        hashMap.put("updateTimeStamp", new m.a("updateTimeStamp", "INTEGER", false, 0, (String) null, 1));
        hashMap.put("readProcess", new m.a("readProcess", "INTEGER", false, 0, (String) null, 1));
        hashMap.put("localPath", new m.a("localPath", "TEXT", false, 0, (String) null, 1));
        hashMap.put("ops", new m.a("ops", "TEXT", false, 0, (String) null, 1));
        hashMap.put("resourceId", new m.a("resourceId", "TEXT", false, 0, (String) null, 1));
        hashMap.put("postId", new m.a("postId", "TEXT", false, 0, (String) null, 1));
        hashMap.put("subjectId", new m.a("subjectId", "TEXT", false, 0, (String) null, 1));
        hashMap.put("groupId", new m.a("groupId", "TEXT", false, 0, (String) null, 1));
        hashMap.put("status", new m.a("status", "INTEGER", true, 0, (String) null, 1));
        hashMap.put("subjectTitle", new m.a("subjectTitle", "TEXT", false, 0, (String) null, 1));
        hashMap.put("se", new m.a("se", "INTEGER", true, 0, (String) null, 1));
        hashMap.put("ep", new m.a("ep", "INTEGER", true, 0, (String) null, 1));
        m mVar = new m("audio", hashMap, new HashSet(0), new HashSet(0));
        m a = m.a(bVar, "audio");
        if (!mVar.equals(a)) {
            return new f0.a(false, "audio(com.transsion.baselib.db.audio.AudioBean).\n Expected:\n" + mVar + "\n Found:\n" + a);
        }
        HashMap hashMap2 = new HashMap(80);
        hashMap2.put("url", new m.a("url", "TEXT", true, 1, (String) null, 1));
        hashMap2.put("resourceId", new m.a("resourceId", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("name", new m.a("name", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("cover", new m.a("cover", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("size", new m.a("size", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("postId", new m.a("postId", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("sizeFormat", new m.a("sizeFormat", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("path", new m.a("path", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("duration", new m.a("duration", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("updateTimeStamp", new m.a("updateTimeStamp", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("progress", new m.a("progress", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("supportRanges", new m.a("supportRanges", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("status", new m.a("status", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("type", new m.a("type", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("readProgress", new m.a("readProgress", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("createAt", new m.a("createAt", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("isRead", new m.a("isRead", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("episode", new m.a("episode", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("ep", new m.a("ep", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("se", new m.a("se", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("resolution", new m.a("resolution", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("resourcePosition", new m.a("resourcePosition", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("multiresolution", new m.a("multiresolution", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("videoWidth", new m.a("videoWidth", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("videoHeight", new m.a("videoHeight", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("downloadErrorCount", new m.a("downloadErrorCount", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("subtitleStarted", new m.a("subtitleStarted", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("subjectId", new m.a("subjectId", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("pageFrom", new m.a("pageFrom", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("lastPageFrom", new m.a("lastPageFrom", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("subjectName", new m.a("subjectName", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("lastPlayTimeStamp", new m.a("lastPlayTimeStamp", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("fileType", new m.a("fileType", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("totalEpisode", new m.a("totalEpisode", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("uploadBy", new m.a("uploadBy", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("sourceUrl", new m.a("sourceUrl", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("urlCreateAt", new m.a("urlCreateAt", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("subtitleSelectId", new m.a("subtitleSelectId", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("taskId", new m.a("taskId", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("sessionTime", new m.a("sessionTime", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("reportStatus", new m.a("reportStatus", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("downloadHeaderSize", new m.a("downloadHeaderSize", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("rootPath", new m.a("rootPath", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("rootPathType", new m.a("rootPathType", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("thumbnail", new m.a("thumbnail", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("averageHueLight", new m.a("averageHueLight", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("isTransferFailed", new m.a("isTransferFailed", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("isClosedTransferFailed", new m.a("isClosedTransferFailed", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("subjectType", new m.a("subjectType", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("genre", new m.a("genre", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("subjectDurationSeconds", new m.a("subjectDurationSeconds", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("currentDubLanName", new m.a("currentDubLanName", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("currentDubLanCode", new m.a("currentDubLanCode", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ops", new m.a("ops", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("restrictLevel", new m.a("restrictLevel", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("releaseDate", new m.a("releaseDate", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("countryName", new m.a("countryName", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("seNum", new m.a("seNum", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("subtitles", new m.a("subtitles", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("imdbRate", new m.a("imdbRate", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("lastAdStartTimeStamp", new m.a("lastAdStartTimeStamp", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("lastAdEndTimeStamp", new m.a("lastAdEndTimeStamp", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("subtitleIdType", new m.a("subtitleIdType", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoCollectionId", new m.a("ugcVideoCollectionId", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoId", new m.a("ugcVideoId", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoName", new m.a("ugcVideoName", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoCollectionName", new m.a("ugcVideoCollectionName", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoPosition", new m.a("ugcVideoPosition", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoType", new m.a("ugcVideoType", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ugcCateLev1Id", new m.a("ugcCateLev1Id", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("ugcCateLev2Id", new m.a("ugcCateLev2Id", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("ugcCateLev3Id", new m.a("ugcCateLev3Id", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("ugcCateLev4Id", new m.a("ugcCateLev4Id", "INTEGER", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoTrackId", new m.a("ugcVideoTrackId", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoParentVideoId", new m.a("ugcVideoParentVideoId", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoParentTrackId", new m.a("ugcVideoParentTrackId", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoEpTitle", new m.a("ugcVideoEpTitle", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("ugcVideoIsVertical", new m.a("ugcVideoIsVertical", "INTEGER", true, 0, (String) null, 1));
        hashMap2.put("originData", new m.a("originData", "TEXT", false, 0, (String) null, 1));
        hashMap2.put("kidId", new m.a("kidId", "TEXT", false, 0, (String) null, 1));
        m mVar2 = new m("download_table", hashMap2, new HashSet(0), new HashSet(0));
        m a2 = m.a(bVar, "download_table");
        if (!mVar2.equals(a2)) {
            return new f0.a(false, "download_table(com.transsion.baselib.db.download.DownloadBean).\n Expected:\n" + mVar2 + "\n Found:\n" + a2);
        }
        HashMap hashMap3 = new HashMap(3);
        hashMap3.put("postId", new m.a("postId", "TEXT", true, 1, (String) null, 1));
        hashMap3.put("playProgress", new m.a("playProgress", "INTEGER", false, 0, (String) null, 1));
        hashMap3.put("url", new m.a("url", "TEXT", false, 0, (String) null, 1));
        m mVar3 = new m("video", hashMap3, new HashSet(0), new HashSet(0));
        m a3 = m.a(bVar, "video");
        if (!mVar3.equals(a3)) {
            return new f0.a(false, "video(com.transsion.baselib.db.video.VideoBean).\n Expected:\n" + mVar3 + "\n Found:\n" + a3);
        }
        HashMap hashMap4 = new HashMap(7);
        hashMap4.put("id", new m.a("id", "INTEGER", true, 1, (String) null, 1));
        hashMap4.put("threadId", new m.a("threadId", "INTEGER", true, 0, (String) null, 1));
        hashMap4.put("downloadInfoId", new m.a("downloadInfoId", "TEXT", false, 0, (String) null, 1));
        hashMap4.put("uri", new m.a("uri", "TEXT", false, 0, (String) null, 1));
        hashMap4.put("start", new m.a("start", "INTEGER", true, 0, (String) null, 1));
        hashMap4.put("end", new m.a("end", "INTEGER", true, 0, (String) null, 1));
        hashMap4.put("progress", new m.a("progress", "INTEGER", true, 0, (String) null, 1));
        m mVar4 = new m("download_thread_info", hashMap4, new HashSet(0), new HashSet(0));
        m a4 = m.a(bVar, "download_thread_info");
        if (!mVar4.equals(a4)) {
            return new f0.a(false, "download_thread_info(com.transsion.baselib.db.download.DownloadTaskInfo).\n Expected:\n" + mVar4 + "\n Found:\n" + a4);
        }
        HashMap hashMap5 = new HashMap(10);
        hashMap5.put("groupId", new m.a("groupId", "TEXT", true, 1, (String) null, 1));
        hashMap5.put("name", new m.a("name", "TEXT", false, 0, (String) null, 1));
        hashMap5.put("avatar", new m.a("avatar", "TEXT", false, 0, (String) null, 1));
        hashMap5.put("hasJoin", new m.a("hasJoin", "INTEGER", false, 0, (String) null, 1));
        hashMap5.put("newPostCount", new m.a("newPostCount", "INTEGER", false, 0, (String) null, 1));
        hashMap5.put("description", new m.a("description", "TEXT", false, 0, (String) null, 1));
        hashMap5.put("postCount", new m.a("postCount", "INTEGER", false, 0, (String) null, 1));
        hashMap5.put("userCount", new m.a("userCount", "INTEGER", false, 0, (String) null, 1));
        hashMap5.put("level", new m.a("level", "TEXT", false, 0, (String) null, 1));
        hashMap5.put("updateTimeStamp", new m.a("updateTimeStamp", "INTEGER", true, 0, (String) null, 1));
        m mVar5 = new m("room_table", hashMap5, new HashSet(0), new HashSet(0));
        m a5 = m.a(bVar, "room_table");
        if (!mVar5.equals(a5)) {
            return new f0.a(false, "room_table(com.transsion.baselib.db.room.RoomItemBean).\n Expected:\n" + mVar5 + "\n Found:\n" + a5);
        }
        HashMap hashMap6 = new HashMap(7);
        hashMap6.put("id", new m.a("id", "INTEGER", true, 1, (String) null, 1));
        hashMap6.put("deep_link_list", new m.a("deep_link_list", "TEXT", false, 0, (String) null, 1));
        hashMap6.put("desc", new m.a("desc", "TEXT", false, 0, (String) null, 1));
        hashMap6.put(GifImagePreviewActivity.IMAGE_LIST, new m.a(GifImagePreviewActivity.IMAGE_LIST, "TEXT", false, 0, (String) null, 1));
        hashMap6.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, new m.a(PushConstants.EXTRA_PUSH_MESSAGE_ID, "TEXT", false, 0, (String) null, 1));
        hashMap6.put("style", new m.a("style", "TEXT", false, 0, (String) null, 1));
        hashMap6.put("title", new m.a("title", "TEXT", false, 0, (String) null, 1));
        m mVar6 = new m("permanent_msg", hashMap6, new HashSet(0), new HashSet(0));
        m a6 = m.a(bVar, "permanent_msg");
        if (!mVar6.equals(a6)) {
            return new f0.a(false, "permanent_msg(com.transsion.baselib.db.notification.PermanentMsgBean).\n Expected:\n" + mVar6 + "\n Found:\n" + a6);
        }
        HashMap hashMap7 = new HashMap(16);
        hashMap7.put("resourceId", new m.a("resourceId", "TEXT", true, 1, (String) null, 1));
        hashMap7.put("postId", new m.a("postId", "TEXT", false, 0, (String) null, 1));
        hashMap7.put("url", new m.a("url", "TEXT", false, 0, (String) null, 1));
        hashMap7.put("path", new m.a("path", "TEXT", false, 0, (String) null, 1));
        hashMap7.put("lan", new m.a("lan", "TEXT", false, 0, (String) null, 1));
        hashMap7.put("lanName", new m.a("lanName", "TEXT", true, 0, (String) null, 1));
        hashMap7.put("subtitleName", new m.a("subtitleName", "TEXT", false, 0, (String) null, 1));
        hashMap7.put("size", new m.a("size", "INTEGER", false, 0, (String) null, 1));
        hashMap7.put("delayDuration", new m.a("delayDuration", "INTEGER", false, 0, (String) null, 1));
        hashMap7.put("status", new m.a("status", "INTEGER", true, 0, (String) null, 1));
        hashMap7.put("type", new m.a("type", "INTEGER", true, 0, (String) null, 1));
        hashMap7.put("fileCharsetName", new m.a("fileCharsetName", "TEXT", false, 0, (String) null, 1));
        hashMap7.put("subjectId", new m.a("subjectId", "TEXT", false, 0, (String) null, 1));
        hashMap7.put("ep", new m.a("ep", "INTEGER", true, 0, (String) null, 1));
        hashMap7.put("se", new m.a("se", "INTEGER", true, 0, (String) null, 1));
        hashMap7.put("resolution", new m.a("resolution", "INTEGER", true, 0, (String) null, 1));
        m mVar7 = new m("download_subtitle_table", hashMap7, new HashSet(0), new HashSet(0));
        m a7 = m.a(bVar, "download_subtitle_table");
        if (!mVar7.equals(a7)) {
            return new f0.a(false, "download_subtitle_table(com.transsion.baselib.db.download.SubtitleBean).\n Expected:\n" + mVar7 + "\n Found:\n" + a7);
        }
        HashMap hashMap8 = new HashMap(16);
        hashMap8.put("id", new m.a("id", "INTEGER", true, 1, (String) null, 1));
        hashMap8.put("deep_link", new m.a("deep_link", "TEXT", false, 0, (String) null, 1));
        hashMap8.put("desc", new m.a("desc", "TEXT", false, 0, (String) null, 1));
        hashMap8.put(GifImagePreviewActivity.IMAGE_LIST, new m.a(GifImagePreviewActivity.IMAGE_LIST, "TEXT", false, 0, (String) null, 1));
        hashMap8.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, new m.a(PushConstants.EXTRA_PUSH_MESSAGE_ID, "TEXT", false, 0, (String) null, 1));
        hashMap8.put("source", new m.a("source", "TEXT", false, 0, (String) null, 1));
        hashMap8.put("style", new m.a("style", "TEXT", false, 0, (String) null, 1));
        hashMap8.put("title", new m.a("title", "TEXT", false, 0, (String) null, 1));
        hashMap8.put("type", new m.a("type", "TEXT", false, 0, (String) null, 1));
        hashMap8.put("receive_time", new m.a("receive_time", "INTEGER", false, 0, (String) null, 1));
        hashMap8.put("msg_status", new m.a("msg_status", "INTEGER", true, 0, (String) null, 1));
        hashMap8.put("show_time", new m.a("show_time", "INTEGER", false, 0, (String) null, 1));
        hashMap8.put("force_show", new m.a("force_show", "INTEGER", true, 0, (String) null, 1));
        hashMap8.put("has_screen_on", new m.a("has_screen_on", "INTEGER", true, 0, (String) null, 1));
        hashMap8.put("built_in", new m.a("built_in", "INTEGER", true, 0, (String) null, 1));
        hashMap8.put("permanent_msg_status", new m.a("permanent_msg_status", "INTEGER", true, 0, (String) null, 1));
        m mVar8 = new m("msg", hashMap8, new HashSet(0), new HashSet(0));
        m a8 = m.a(bVar, "msg");
        if (!mVar8.equals(a8)) {
            return new f0.a(false, "msg(com.transsion.baselib.db.notification.MsgBean).\n Expected:\n" + mVar8 + "\n Found:\n" + a8);
        }
        HashMap hashMap9 = new HashMap(5);
        hashMap9.put("id", new m.a("id", "INTEGER", true, 1, (String) null, 1));
        hashMap9.put("updateTimeStamp", new m.a("updateTimeStamp", "INTEGER", true, 0, (String) null, 1));
        hashMap9.put("dataType", new m.a("dataType", "INTEGER", true, 0, (String) null, 1));
        hashMap9.put("appVersion", new m.a("appVersion", "INTEGER", true, 0, (String) null, 1));
        hashMap9.put("consumeJson", new m.a("consumeJson", "TEXT", false, 0, (String) null, 1));
        m mVar9 = new m("consume_bean", hashMap9, new HashSet(0), new HashSet(0));
        m a9 = m.a(bVar, "consume_bean");
        if (!mVar9.equals(a9)) {
            return new f0.a(false, "consume_bean(com.transsion.baselib.db.consume.ConsumeBean).\n Expected:\n" + mVar9 + "\n Found:\n" + a9);
        }
        HashMap hashMap10 = new HashMap(6);
        hashMap10.put("threadId", new m.a("threadId", "INTEGER", true, 1, (String) null, 1));
        hashMap10.put("rangeId", new m.a("rangeId", "INTEGER", true, 2, (String) null, 1));
        hashMap10.put("resourceId", new m.a("resourceId", "TEXT", false, 0, (String) null, 1));
        hashMap10.put("start", new m.a("start", "INTEGER", true, 0, (String) null, 1));
        hashMap10.put("end", new m.a("end", "INTEGER", true, 0, (String) null, 1));
        hashMap10.put("progress", new m.a("progress", "INTEGER", true, 0, (String) null, 1));
        m mVar10 = new m("download_thread_range", hashMap10, new HashSet(0), new HashSet(0));
        m a10 = m.a(bVar, "download_thread_range");
        if (!mVar10.equals(a10)) {
            return new f0.a(false, "download_thread_range(com.transsion.baselib.db.download.DownloadRange).\n Expected:\n" + mVar10 + "\n Found:\n" + a10);
        }
        HashMap hashMap11 = new HashMap(3);
        hashMap11.put("resourceId", new m.a("resourceId", "TEXT", true, 1, (String) null, 1));
        hashMap11.put("startAdDayKey", new m.a("startAdDayKey", "INTEGER", true, 0, (String) null, 1));
        hashMap11.put("endAdDayKey", new m.a("endAdDayKey", "INTEGER", true, 0, (String) null, 1));
        m mVar11 = new m("video_land_ad", hashMap11, new HashSet(0), new HashSet(0));
        m a11 = m.a(bVar, "video_land_ad");
        if (!mVar11.equals(a11)) {
            return new f0.a(false, "video_land_ad(com.transsion.baselib.db.video.VideoLandAdBean).\n Expected:\n" + mVar11 + "\n Found:\n" + a11);
        }
        HashMap hashMap12 = new HashMap(4);
        hashMap12.put("lan", new m.a("lan", "TEXT", true, 1, (String) null, 1));
        hashMap12.put("lanIOS3", new m.a("lanIOS3", "TEXT", false, 0, (String) null, 1));
        hashMap12.put("lanName", new m.a("lanName", "TEXT", true, 0, (String) null, 1));
        hashMap12.put("inSearch", new m.a("inSearch", "INTEGER", true, 0, (String) null, 1));
        m mVar12 = new m("subtitle_language_map_table", hashMap12, new HashSet(0), new HashSet(0));
        m a12 = m.a(bVar, "subtitle_language_map_table");
        if (!mVar12.equals(a12)) {
            return new f0.a(false, "subtitle_language_map_table(com.transsion.baselib.db.download.SubtitleLanguageMapBean).\n Expected:\n" + mVar12 + "\n Found:\n" + a12);
        }
        HashMap hashMap13 = new HashMap(26);
        hashMap13.put("id", new m.a("id", "TEXT", true, 1, (String) null, 1));
        hashMap13.put("version", new m.a("version", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("name", new m.a("name", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("startTime", new m.a("startTime", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("endTime", new m.a("endTime", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("extraConfig", new m.a("extraConfig", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("displayTimes", new m.a("displayTimes", "INTEGER", false, 0, (String) null, 1));
        hashMap13.put("showedTimes", new m.a("showedTimes", "INTEGER", false, 0, (String) null, 1));
        hashMap13.put("showDate", new m.a("showDate", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("advertiserName", new m.a("advertiserName", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("advertiserAvatar", new m.a("advertiserAvatar", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("advertiserAvatarPath", new m.a("advertiserAvatarPath", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("brand", new m.a("brand", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("denyBrand", new m.a("denyBrand", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("model", new m.a("model", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("denyModel", new m.a("denyModel", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("country", new m.a("country", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("scenes", new m.a("scenes", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("adMaterialList", new m.a("adMaterialList", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("adPlanUpdateTime", new m.a("adPlanUpdateTime", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("sort", new m.a("sort", "INTEGER", false, 0, (String) null, 1));
        hashMap13.put("adShowLevel", new m.a("adShowLevel", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("filterClientVersion", new m.a("filterClientVersion", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("adPlanCreateTime", new m.a("adPlanCreateTime", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("appStarDesc", new m.a("appStarDesc", "TEXT", false, 0, (String) null, 1));
        hashMap13.put("appSizeDesc", new m.a("appSizeDesc", "TEXT", false, 0, (String) null, 1));
        m mVar13 = new m("non_ad_plans", hashMap13, new HashSet(0), new HashSet(0));
        m a13 = m.a(bVar, "non_ad_plans");
        if (!mVar13.equals(a13)) {
            return new f0.a(false, "non_ad_plans(com.transsion.baselib.db.non.NonAdPlans).\n Expected:\n" + mVar13 + "\n Found:\n" + a13);
        }
        HashMap hashMap14 = new HashMap(5);
        hashMap14.put("id", new m.a("id", "INTEGER", true, 1, (String) null, 1));
        hashMap14.put("Country", new m.a("Country", "TEXT", true, 0, (String) null, 1));
        hashMap14.put("Mcc", new m.a("Mcc", "TEXT", true, 0, (String) null, 1));
        hashMap14.put("Iso", new m.a("Iso", "TEXT", true, 0, (String) null, 1));
        hashMap14.put("CountryCode", new m.a("CountryCode", "TEXT", true, 0, (String) null, 1));
        m mVar14 = new m("local_mcc", hashMap14, new HashSet(0), new HashSet(0));
        m a14 = m.a(bVar, "local_mcc");
        if (!mVar14.equals(a14)) {
            return new f0.a(false, "local_mcc(com.transsion.baselib.db.mcc.LocalMcc).\n Expected:\n" + mVar14 + "\n Found:\n" + a14);
        }
        HashMap hashMap15 = new HashMap(14);
        hashMap15.put("subjectId", new m.a("subjectId", "TEXT", true, 1, (String) null, 1));
        hashMap15.put("id", new m.a("id", "TEXT", true, 0, (String) null, 1));
        hashMap15.put("ep", new m.a("ep", "INTEGER", true, 0, (String) null, 1));
        hashMap15.put("se", new m.a("se", "INTEGER", true, 0, (String) null, 1));
        hashMap15.put("totalEp", new m.a("totalEp", "INTEGER", true, 0, (String) null, 1));
        hashMap15.put("progress", new m.a("progress", "INTEGER", true, 0, (String) null, 1));
        hashMap15.put("title", new m.a("title", "TEXT", false, 0, (String) null, 1));
        hashMap15.put("description", new m.a("description", "TEXT", false, 0, (String) null, 1));
        hashMap15.put("coverUrl", new m.a("coverUrl", "TEXT", false, 0, (String) null, 1));
        hashMap15.put("thumbnail", new m.a("thumbnail", "TEXT", false, 0, (String) null, 1));
        hashMap15.put("videoId", new m.a("videoId", "TEXT", false, 0, (String) null, 1));
        hashMap15.put("videoUrl", new m.a("videoUrl", "TEXT", false, 0, (String) null, 1));
        hashMap15.put("timeStamp", new m.a("timeStamp", "INTEGER", true, 0, (String) null, 1));
        hashMap15.put("subtitleSelectId", new m.a("subtitleSelectId", "TEXT", false, 0, (String) null, 1));
        m mVar15 = new m("short_tv_play", hashMap15, new HashSet(0), new HashSet(0));
        m a15 = m.a(bVar, "short_tv_play");
        if (!mVar15.equals(a15)) {
            return new f0.a(false, "short_tv_play(com.transsion.baselib.db.video.ShortTVPlayBean).\n Expected:\n" + mVar15 + "\n Found:\n" + a15);
        }
        HashMap hashMap16 = new HashMap(4);
        hashMap16.put("subjectId", new m.a("subjectId", "TEXT", true, 1, (String) null, 1));
        hashMap16.put("favoriteNum", new m.a("favoriteNum", "TEXT", false, 0, (String) null, 1));
        hashMap16.put("hasFavorite", new m.a("hasFavorite", "INTEGER", true, 0, (String) null, 1));
        hashMap16.put("favoriteTime", new m.a("favoriteTime", "TEXT", false, 0, (String) null, 1));
        m mVar16 = new m("ShortTvFavoriteState", hashMap16, new HashSet(0), new HashSet(0));
        m a16 = m.a(bVar, "ShortTvFavoriteState");
        if (!mVar16.equals(a16)) {
            return new f0.a(false, "ShortTvFavoriteState(com.transsion.baselib.db.video.ShortTvFavoriteState).\n Expected:\n" + mVar16 + "\n Found:\n" + a16);
        }
        HashMap hashMap17 = new HashMap(27);
        hashMap17.put("subjectId", new m.a("subjectId", "TEXT", true, 1, (String) null, 1));
        hashMap17.put("id", new m.a("id", "TEXT", true, 0, (String) null, 1));
        hashMap17.put("ep", new m.a("ep", "INTEGER", true, 2, (String) null, 1));
        hashMap17.put("se", new m.a("se", "INTEGER", true, 3, (String) null, 1));
        hashMap17.put("progress", new m.a("progress", "INTEGER", true, 0, (String) null, 1));
        hashMap17.put("title", new m.a("title", "TEXT", false, 0, (String) null, 1));
        hashMap17.put("coverUrl", new m.a("coverUrl", "TEXT", false, 0, (String) null, 1));
        hashMap17.put("thumbnail", new m.a("thumbnail", "TEXT", false, 0, (String) null, 1));
        hashMap17.put("videoUrl", new m.a("videoUrl", "TEXT", false, 0, (String) null, 1));
        hashMap17.put("timeStamp", new m.a("timeStamp", "INTEGER", true, 0, (String) null, 1));
        hashMap17.put("subtitleSelectId", new m.a("subtitleSelectId", "TEXT", false, 0, (String) null, 1));
        hashMap17.put("totalDuration", new m.a("totalDuration", "INTEGER", false, 0, (String) null, 1));
        hashMap17.put("subjectDurationSeconds", new m.a("subjectDurationSeconds", "INTEGER", false, 0, (String) null, 1));
        hashMap17.put("averageHueLight", new m.a("averageHueLight", "TEXT", false, 0, (String) null, 1));
        hashMap17.put("subjectType", new m.a("subjectType", "INTEGER", false, 0, (String) null, 1));
        hashMap17.put("hasDelete", new m.a("hasDelete", "INTEGER", true, 0, (String) null, 1));
        hashMap17.put("playMode", new m.a("playMode", "TEXT", true, 0, (String) null, 1));
        hashMap17.put("downloadUrl", new m.a("downloadUrl", "TEXT", false, 0, (String) null, 1));
        hashMap17.put("downloadFilePath", new m.a("downloadFilePath", "TEXT", false, 0, (String) null, 1));
        hashMap17.put("downloadSize", new m.a("downloadSize", "INTEGER", true, 0, (String) null, 1));
        hashMap17.put("dubs", new m.a("dubs", "TEXT", false, 0, (String) null, 1));
        hashMap17.put("lastAdStartTimeStamp", new m.a("lastAdStartTimeStamp", "INTEGER", false, 0, (String) null, 1));
        hashMap17.put("lastAdEndTimeStamp", new m.a("lastAdEndTimeStamp", "INTEGER", false, 0, (String) null, 1));
        hashMap17.put("rewardPlayed", new m.a("rewardPlayed", "INTEGER", true, 0, (String) null, 1));
        hashMap17.put("rewardUnlock", new m.a("rewardUnlock", "INTEGER", true, 0, (String) null, 1));
        hashMap17.put("rewardFree", new m.a("rewardFree", "INTEGER", true, 0, (String) null, 1));
        hashMap17.put("ops", new m.a("ops", "TEXT", false, 0, (String) null, 1));
        m mVar17 = new m("video_detail_play", hashMap17, new HashSet(0), new HashSet(0));
        m a17 = m.a(bVar, "video_detail_play");
        if (!mVar17.equals(a17)) {
            return new f0.a(false, "video_detail_play(com.transsion.baselib.db.video.VideoDetailPlayBean).\n Expected:\n" + mVar17 + "\n Found:\n" + a17);
        }
        HashMap hashMap18 = new HashMap(11);
        hashMap18.put("subjectId", new m.a("subjectId", "TEXT", true, 1, (String) null, 1));
        hashMap18.put("title", new m.a("title", "TEXT", false, 0, (String) null, 1));
        hashMap18.put("coverUrl", new m.a("coverUrl", "TEXT", false, 0, (String) null, 1));
        hashMap18.put("countryName", new m.a("countryName", "TEXT", false, 0, (String) null, 1));
        hashMap18.put("genre", new m.a("genre", "TEXT", false, 0, (String) null, 1));
        hashMap18.put("releaseDate", new m.a("releaseDate", "TEXT", false, 0, (String) null, 1));
        hashMap18.put("durationSeconds", new m.a("durationSeconds", "INTEGER", true, 0, (String) null, 1));
        hashMap18.put("singerName", new m.a("singerName", "TEXT", false, 0, (String) null, 1));
        hashMap18.put("singerAvatar", new m.a("singerAvatar", "TEXT", false, 0, (String) null, 1));
        hashMap18.put("path", new m.a("path", "TEXT", false, 0, (String) null, 1));
        hashMap18.put("timeStamp", new m.a("timeStamp", "INTEGER", true, 0, (String) null, 1));
        m mVar18 = new m("music_liked", hashMap18, new HashSet(0), new HashSet(0));
        m a18 = m.a(bVar, "music_liked");
        if (!mVar18.equals(a18)) {
            return new f0.a(false, "music_liked(com.transsion.baselib.db.music.MusicLikedDbBean).\n Expected:\n" + mVar18 + "\n Found:\n" + a18);
        }
        HashMap hashMap19 = new HashMap(5);
        hashMap19.put("latitude", new m.a("latitude", "REAL", true, 1, (String) null, 1));
        hashMap19.put("longitude", new m.a("longitude", "REAL", true, 2, (String) null, 1));
        hashMap19.put("name", new m.a("name", "TEXT", false, 0, (String) null, 1));
        hashMap19.put("address", new m.a("address", "TEXT", false, 0, (String) null, 1));
        hashMap19.put("distance", new m.a("distance", "TEXT", false, 0, (String) null, 1));
        m mVar19 = new m("place_list", hashMap19, new HashSet(0), new HashSet(0));
        m a19 = m.a(bVar, "place_list");
        if (!mVar19.equals(a19)) {
            return new f0.a(false, "place_list(com.transsion.baselib.db.place.PlaceDBBean).\n Expected:\n" + mVar19 + "\n Found:\n" + a19);
        }
        HashMap hashMap20 = new HashMap(36);
        hashMap20.put("collectionId", new m.a("collectionId", "TEXT", true, 1, (String) null, 1));
        hashMap20.put("ugcVideoId", new m.a("ugcVideoId", "TEXT", true, 0, (String) null, 1));
        hashMap20.put("progress", new m.a("progress", "INTEGER", true, 0, (String) null, 1));
        hashMap20.put("title", new m.a("title", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("coverUrl", new m.a("coverUrl", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("thumbnail", new m.a("thumbnail", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("position", new m.a("position", "INTEGER", true, 0, (String) null, 1));
        hashMap20.put("type", new m.a("type", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("cateLev1Id", new m.a("cateLev1Id", "INTEGER", false, 0, (String) null, 1));
        hashMap20.put("cateLev2Id", new m.a("cateLev2Id", "INTEGER", false, 0, (String) null, 1));
        hashMap20.put("cateLev3Id", new m.a("cateLev3Id", "INTEGER", false, 0, (String) null, 1));
        hashMap20.put("cateLev4Id", new m.a("cateLev4Id", "INTEGER", false, 0, (String) null, 1));
        hashMap20.put("timeStamp", new m.a("timeStamp", "INTEGER", true, 0, (String) null, 1));
        hashMap20.put("subtitleSelectId", new m.a("subtitleSelectId", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("totalDuration", new m.a("totalDuration", "INTEGER", false, 0, (String) null, 1));
        hashMap20.put("subjectDurationSeconds", new m.a("subjectDurationSeconds", "INTEGER", false, 0, (String) null, 1));
        hashMap20.put("averageHueLight", new m.a("averageHueLight", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("subjectType", new m.a("subjectType", "INTEGER", false, 0, (String) null, 1));
        hashMap20.put("hasDelete", new m.a("hasDelete", "INTEGER", true, 0, (String) null, 1));
        hashMap20.put("playMode", new m.a("playMode", "TEXT", true, 0, (String) null, 1));
        hashMap20.put("downloadUrl", new m.a("downloadUrl", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("downloadResid", new m.a("downloadResid", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("downloadFilePath", new m.a("downloadFilePath", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("downloadSize", new m.a("downloadSize", "INTEGER", true, 0, (String) null, 1));
        hashMap20.put("lastAdStartTimeStamp", new m.a("lastAdStartTimeStamp", "INTEGER", false, 0, (String) null, 1));
        hashMap20.put("lastAdEndTimeStamp", new m.a("lastAdEndTimeStamp", "INTEGER", false, 0, (String) null, 1));
        hashMap20.put("rewardPlayed", new m.a("rewardPlayed", "INTEGER", true, 0, (String) null, 1));
        hashMap20.put("rewardUnlock", new m.a("rewardUnlock", "INTEGER", true, 0, (String) null, 1));
        hashMap20.put("rewardFree", new m.a("rewardFree", "INTEGER", true, 0, (String) null, 1));
        hashMap20.put("ops", new m.a("ops", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("uid", new m.a("uid", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("userName", new m.a("userName", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("userAvatar", new m.a("userAvatar", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("description", new m.a("description", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("videoStyle", new m.a("videoStyle", "TEXT", false, 0, (String) null, 1));
        hashMap20.put("kidId", new m.a("kidId", "TEXT", false, 0, (String) null, 1));
        m mVar20 = new m("ugc_video_detail_play", hashMap20, new HashSet(0), new HashSet(0));
        m a20 = m.a(bVar, "ugc_video_detail_play");
        if (!mVar20.equals(a20)) {
            return new f0.a(false, "ugc_video_detail_play(com.transsion.baselib.db.video.UGCVideoDetailPlayBean).\n Expected:\n" + mVar20 + "\n Found:\n" + a20);
        }
        HashMap hashMap21 = new HashMap(2);
        hashMap21.put("collectionId", new m.a("collectionId", "TEXT", true, 1, (String) null, 1));
        hashMap21.put("ugcVideoIds", new m.a("ugcVideoIds", "TEXT", true, 0, (String) null, 1));
        m mVar21 = new m("ugc_collection_video_group", hashMap21, new HashSet(0), new HashSet(0));
        m a21 = m.a(bVar, "ugc_collection_video_group");
        if (!mVar21.equals(a21)) {
            return new f0.a(false, "ugc_collection_video_group(com.transsion.baselib.db.video.UGCCollectionVideoGroup).\n Expected:\n" + mVar21 + "\n Found:\n" + a21);
        }
        HashMap hashMap22 = new HashMap(5);
        hashMap22.put("subjectId", new m.a("subjectId", "TEXT", true, 1, (String) null, 1));
        hashMap22.put("ep", new m.a("ep", "INTEGER", true, 2, (String) null, 1));
        hashMap22.put("se", new m.a("se", "INTEGER", true, 3, (String) null, 1));
        hashMap22.put("vipResolutionTip", new m.a("vipResolutionTip", "INTEGER", false, 0, (String) null, 1));
        hashMap22.put("isUnlock", new m.a("isUnlock", "INTEGER", false, 0, (String) null, 1));
        m mVar22 = new m("member_resolution", hashMap22, new HashSet(0), new HashSet(0));
        m a22 = m.a(bVar, "member_resolution");
        if (!mVar22.equals(a22)) {
            return new f0.a(false, "member_resolution(com.transsion.baselib.db.member.MemberResolutionBean).\n Expected:\n" + mVar22 + "\n Found:\n" + a22);
        }
        HashMap hashMap23 = new HashMap(7);
        hashMap23.put("id", new m.a("id", "TEXT", true, 1, (String) null, 1));
        hashMap23.put("showTime", new m.a("showTime", "INTEGER", true, 0, (String) null, 1));
        hashMap23.put("closeTime", new m.a("closeTime", "INTEGER", true, 0, (String) null, 1));
        hashMap23.put("chooseTime", new m.a("chooseTime", "INTEGER", true, 0, (String) null, 1));
        hashMap23.put("showIntervalSeconds", new m.a("showIntervalSeconds", "INTEGER", true, 0, (String) null, 1));
        hashMap23.put("closeIntervalSeconds", new m.a("closeIntervalSeconds", "INTEGER", true, 0, (String) null, 1));
        hashMap23.put("chooseIntervalSeconds", new m.a("chooseIntervalSeconds", "INTEGER", true, 0, (String) null, 1));
        m mVar23 = new m("home_preferences_interval_time", hashMap23, new HashSet(0), new HashSet(0));
        m a23 = m.a(bVar, "home_preferences_interval_time");
        if (mVar23.equals(a23)) {
            return new f0.a(true, (String) null);
        }
        return new f0.a(false, "home_preferences_interval_time(com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean).\n Expected:\n" + mVar23 + "\n Found:\n" + a23);
    }
}
