package ui;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l0 implements ui.c {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();
    private final androidx.room.e d = new c();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `download_table` (`url`,`resourceId`,`name`,`cover`,`size`,`postId`,`sizeFormat`,`path`,`duration`,`updateTimeStamp`,`progress`,`supportRanges`,`status`,`type`,`readProgress`,`createAt`,`isRead`,`episode`,`ep`,`se`,`resolution`,`resourcePosition`,`multiresolution`,`videoWidth`,`videoHeight`,`downloadErrorCount`,`subtitleStarted`,`subjectId`,`pageFrom`,`lastPageFrom`,`subjectName`,`lastPlayTimeStamp`,`fileType`,`totalEpisode`,`uploadBy`,`sourceUrl`,`urlCreateAt`,`subtitleSelectId`,`taskId`,`sessionTime`,`reportStatus`,`downloadHeaderSize`,`rootPath`,`rootPathType`,`thumbnail`,`averageHueLight`,`isTransferFailed`,`isClosedTransferFailed`,`subjectType`,`genre`,`subjectDurationSeconds`,`currentDubLanName`,`currentDubLanCode`,`ops`,`restrictLevel`,`releaseDate`,`countryName`,`seNum`,`subtitles`,`imdbRate`,`lastAdStartTimeStamp`,`lastAdEndTimeStamp`,`subtitleIdType`,`ugcVideoCollectionId`,`ugcVideoId`,`ugcVideoName`,`ugcVideoCollectionName`,`ugcVideoPosition`,`ugcVideoType`,`ugcCateLev1Id`,`ugcCateLev2Id`,`ugcCateLev3Id`,`ugcCateLev4Id`,`ugcVideoTrackId`,`ugcVideoParentVideoId`,`ugcVideoParentTrackId`,`ugcVideoEpTitle`,`ugcVideoIsVertical`,`originData`,`kidId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, DownloadBean downloadBean) {
            if (downloadBean.getUrl() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, downloadBean.getUrl());
            }
            if (downloadBean.getResourceId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, downloadBean.getResourceId());
            }
            if (downloadBean.getName() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, downloadBean.getName());
            }
            if (downloadBean.getCover() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, downloadBean.getCover());
            }
            if (downloadBean.getSize() == null) {
                eVar.g(5);
            } else {
                eVar.c(5, downloadBean.getSize().longValue());
            }
            if (downloadBean.getPostId() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, downloadBean.getPostId());
            }
            if (downloadBean.getSizeFormat() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, downloadBean.getSizeFormat());
            }
            if (downloadBean.getPath() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, downloadBean.getPath());
            }
            if (downloadBean.getDuration() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, downloadBean.getDuration().longValue());
            }
            if (downloadBean.getUpdateTimeStamp() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, downloadBean.getUpdateTimeStamp().longValue());
            }
            eVar.c(11, downloadBean.getProgress());
            eVar.c(12, downloadBean.getSupportRanges());
            eVar.c(13, downloadBean.getStatus());
            eVar.c(14, downloadBean.getType());
            eVar.c(15, downloadBean.getReadProgress());
            eVar.c(16, downloadBean.getCreateAt());
            eVar.c(17, downloadBean.getIsRead());
            eVar.c(18, downloadBean.getEpse());
            eVar.c(19, downloadBean.getEp());
            eVar.c(20, downloadBean.getSe());
            eVar.c(21, downloadBean.getResolution());
            eVar.c(22, downloadBean.getResourcePosition());
            eVar.c(23, downloadBean.getMultiresolution());
            eVar.c(24, downloadBean.getVideoWidth());
            eVar.c(25, downloadBean.getVideoHeight());
            eVar.c(26, downloadBean.getDownloadErrorCount());
            eVar.c(27, downloadBean.getSubtitleStarted());
            if (downloadBean.getSubjectId() == null) {
                eVar.g(28);
            } else {
                eVar.i(28, downloadBean.getSubjectId());
            }
            if (downloadBean.getPageFrom() == null) {
                eVar.g(29);
            } else {
                eVar.i(29, downloadBean.getPageFrom());
            }
            if (downloadBean.getLastPageFrom() == null) {
                eVar.g(30);
            } else {
                eVar.i(30, downloadBean.getLastPageFrom());
            }
            if (downloadBean.getSubjectName() == null) {
                eVar.g(31);
            } else {
                eVar.i(31, downloadBean.getSubjectName());
            }
            eVar.c(32, downloadBean.getLastPlayTimeStamp());
            eVar.c(33, downloadBean.getFileType());
            eVar.c(34, downloadBean.getTotalEpisode());
            if (downloadBean.getUploadBy() == null) {
                eVar.g(35);
            } else {
                eVar.i(35, downloadBean.getUploadBy());
            }
            if (downloadBean.getSourceUrl() == null) {
                eVar.g(36);
            } else {
                eVar.i(36, downloadBean.getSourceUrl());
            }
            eVar.c(37, downloadBean.getUrlCreateAt());
            if (downloadBean.getSubtitleSelectId() == null) {
                eVar.g(38);
            } else {
                eVar.i(38, downloadBean.getSubtitleSelectId());
            }
            if (downloadBean.getTaskId() == null) {
                eVar.g(39);
            } else {
                eVar.i(39, downloadBean.getTaskId());
            }
            eVar.c(40, downloadBean.getSessionTime());
            eVar.c(41, downloadBean.getReportStatus());
            eVar.c(42, downloadBean.getDownloadHeaderSize());
            if (downloadBean.getRootPath() == null) {
                eVar.g(43);
            } else {
                eVar.i(43, downloadBean.getRootPath());
            }
            eVar.c(44, downloadBean.getRootPathType());
            if (downloadBean.getThumbnail() == null) {
                eVar.g(45);
            } else {
                eVar.i(45, downloadBean.getThumbnail());
            }
            if (downloadBean.getAverageHueLight() == null) {
                eVar.g(46);
            } else {
                eVar.i(46, downloadBean.getAverageHueLight());
            }
            eVar.c(47, downloadBean.getIsTransferFailed() ? 1L : 0L);
            eVar.c(48, downloadBean.getIsClosedTransferFailed() ? 1L : 0L);
            eVar.c(49, downloadBean.getSubjectType());
            if (downloadBean.getGenre() == null) {
                eVar.g(50);
            } else {
                eVar.i(50, downloadBean.getGenre());
            }
            if (downloadBean.getSubjectDurationSeconds() == null) {
                eVar.g(51);
            } else {
                eVar.c(51, downloadBean.getSubjectDurationSeconds().intValue());
            }
            if (downloadBean.getCurrentDubLanName() == null) {
                eVar.g(52);
            } else {
                eVar.i(52, downloadBean.getCurrentDubLanName());
            }
            if (downloadBean.getCurrentDubLanCode() == null) {
                eVar.g(53);
            } else {
                eVar.i(53, downloadBean.getCurrentDubLanCode());
            }
            if (downloadBean.getOps() == null) {
                eVar.g(54);
            } else {
                eVar.i(54, downloadBean.getOps());
            }
            if (downloadBean.getRestrictLevel() == null) {
                eVar.g(55);
            } else {
                eVar.i(55, downloadBean.getRestrictLevel());
            }
            if (downloadBean.getReleaseDate() == null) {
                eVar.g(56);
            } else {
                eVar.i(56, downloadBean.getReleaseDate());
            }
            if (downloadBean.getCountryName() == null) {
                eVar.g(57);
            } else {
                eVar.i(57, downloadBean.getCountryName());
            }
            if (downloadBean.getSeNum() == null) {
                eVar.g(58);
            } else {
                eVar.c(58, downloadBean.getSeNum().intValue());
            }
            if (downloadBean.getSubtitles() == null) {
                eVar.g(59);
            } else {
                eVar.i(59, downloadBean.getSubtitles());
            }
            if (downloadBean.getImdbRate() == null) {
                eVar.g(60);
            } else {
                eVar.i(60, downloadBean.getImdbRate());
            }
            if (downloadBean.getLastAdStartTimeStamp() == null) {
                eVar.g(61);
            } else {
                eVar.c(61, downloadBean.getLastAdStartTimeStamp().longValue());
            }
            if (downloadBean.getLastAdEndTimeStamp() == null) {
                eVar.g(62);
            } else {
                eVar.c(62, downloadBean.getLastAdEndTimeStamp().longValue());
            }
            if (downloadBean.getSubtitleIdType() == null) {
                eVar.g(63);
            } else {
                eVar.i(63, downloadBean.getSubtitleIdType());
            }
            if (downloadBean.getUgcVideoCollectionId() == null) {
                eVar.g(64);
            } else {
                eVar.i(64, downloadBean.getUgcVideoCollectionId());
            }
            if (downloadBean.getUgcVideoId() == null) {
                eVar.g(65);
            } else {
                eVar.i(65, downloadBean.getUgcVideoId());
            }
            if (downloadBean.getUgcVideoName() == null) {
                eVar.g(66);
            } else {
                eVar.i(66, downloadBean.getUgcVideoName());
            }
            if (downloadBean.getUgcVideoCollectionName() == null) {
                eVar.g(67);
            } else {
                eVar.i(67, downloadBean.getUgcVideoCollectionName());
            }
            if (downloadBean.getUgcVideoPosition() == null) {
                eVar.g(68);
            } else {
                eVar.c(68, downloadBean.getUgcVideoPosition().intValue());
            }
            if (downloadBean.getUgcVideoType() == null) {
                eVar.g(69);
            } else {
                eVar.i(69, downloadBean.getUgcVideoType());
            }
            if (downloadBean.getUgcCateLev1Id() == null) {
                eVar.g(70);
            } else {
                eVar.c(70, downloadBean.getUgcCateLev1Id().intValue());
            }
            if (downloadBean.getUgcCateLev2Id() == null) {
                eVar.g(71);
            } else {
                eVar.c(71, downloadBean.getUgcCateLev2Id().intValue());
            }
            if (downloadBean.getUgcCateLev3Id() == null) {
                eVar.g(72);
            } else {
                eVar.c(72, downloadBean.getUgcCateLev3Id().intValue());
            }
            if (downloadBean.getUgcCateLev4Id() == null) {
                eVar.g(73);
            } else {
                eVar.c(73, downloadBean.getUgcCateLev4Id().intValue());
            }
            if (downloadBean.getUgcVideoTrackId() == null) {
                eVar.g(74);
            } else {
                eVar.i(74, downloadBean.getUgcVideoTrackId());
            }
            if (downloadBean.getUgcVideoParentVideoId() == null) {
                eVar.g(75);
            } else {
                eVar.i(75, downloadBean.getUgcVideoParentVideoId());
            }
            if (downloadBean.getUgcVideoParentTrackId() == null) {
                eVar.g(76);
            } else {
                eVar.i(76, downloadBean.getUgcVideoParentTrackId());
            }
            if (downloadBean.getUgcVideoEpTitle() == null) {
                eVar.g(77);
            } else {
                eVar.i(77, downloadBean.getUgcVideoEpTitle());
            }
            eVar.c(78, downloadBean.getUgcVideoIsVertical() ? 1L : 0L);
            if (downloadBean.getOriginData() == null) {
                eVar.g(79);
            } else {
                eVar.i(79, downloadBean.getOriginData());
            }
            if (downloadBean.getKidId() == null) {
                eVar.g(80);
            } else {
                eVar.i(80, downloadBean.getKidId());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `download_table` WHERE `url` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, DownloadBean downloadBean) {
            if (downloadBean.getUrl() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, downloadBean.getUrl());
            }
        }
    }

    class c extends androidx.room.e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `download_table` SET `url` = ?,`resourceId` = ?,`name` = ?,`cover` = ?,`size` = ?,`postId` = ?,`sizeFormat` = ?,`path` = ?,`duration` = ?,`updateTimeStamp` = ?,`progress` = ?,`supportRanges` = ?,`status` = ?,`type` = ?,`readProgress` = ?,`createAt` = ?,`isRead` = ?,`episode` = ?,`ep` = ?,`se` = ?,`resolution` = ?,`resourcePosition` = ?,`multiresolution` = ?,`videoWidth` = ?,`videoHeight` = ?,`downloadErrorCount` = ?,`subtitleStarted` = ?,`subjectId` = ?,`pageFrom` = ?,`lastPageFrom` = ?,`subjectName` = ?,`lastPlayTimeStamp` = ?,`fileType` = ?,`totalEpisode` = ?,`uploadBy` = ?,`sourceUrl` = ?,`urlCreateAt` = ?,`subtitleSelectId` = ?,`taskId` = ?,`sessionTime` = ?,`reportStatus` = ?,`downloadHeaderSize` = ?,`rootPath` = ?,`rootPathType` = ?,`thumbnail` = ?,`averageHueLight` = ?,`isTransferFailed` = ?,`isClosedTransferFailed` = ?,`subjectType` = ?,`genre` = ?,`subjectDurationSeconds` = ?,`currentDubLanName` = ?,`currentDubLanCode` = ?,`ops` = ?,`restrictLevel` = ?,`releaseDate` = ?,`countryName` = ?,`seNum` = ?,`subtitles` = ?,`imdbRate` = ?,`lastAdStartTimeStamp` = ?,`lastAdEndTimeStamp` = ?,`subtitleIdType` = ?,`ugcVideoCollectionId` = ?,`ugcVideoId` = ?,`ugcVideoName` = ?,`ugcVideoCollectionName` = ?,`ugcVideoPosition` = ?,`ugcVideoType` = ?,`ugcCateLev1Id` = ?,`ugcCateLev2Id` = ?,`ugcCateLev3Id` = ?,`ugcCateLev4Id` = ?,`ugcVideoTrackId` = ?,`ugcVideoParentVideoId` = ?,`ugcVideoParentTrackId` = ?,`ugcVideoEpTitle` = ?,`ugcVideoIsVertical` = ?,`originData` = ?,`kidId` = ? WHERE `url` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, DownloadBean downloadBean) {
            if (downloadBean.getUrl() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, downloadBean.getUrl());
            }
            if (downloadBean.getResourceId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, downloadBean.getResourceId());
            }
            if (downloadBean.getName() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, downloadBean.getName());
            }
            if (downloadBean.getCover() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, downloadBean.getCover());
            }
            if (downloadBean.getSize() == null) {
                eVar.g(5);
            } else {
                eVar.c(5, downloadBean.getSize().longValue());
            }
            if (downloadBean.getPostId() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, downloadBean.getPostId());
            }
            if (downloadBean.getSizeFormat() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, downloadBean.getSizeFormat());
            }
            if (downloadBean.getPath() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, downloadBean.getPath());
            }
            if (downloadBean.getDuration() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, downloadBean.getDuration().longValue());
            }
            if (downloadBean.getUpdateTimeStamp() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, downloadBean.getUpdateTimeStamp().longValue());
            }
            eVar.c(11, downloadBean.getProgress());
            eVar.c(12, downloadBean.getSupportRanges());
            eVar.c(13, downloadBean.getStatus());
            eVar.c(14, downloadBean.getType());
            eVar.c(15, downloadBean.getReadProgress());
            eVar.c(16, downloadBean.getCreateAt());
            eVar.c(17, downloadBean.getIsRead());
            eVar.c(18, downloadBean.getEpse());
            eVar.c(19, downloadBean.getEp());
            eVar.c(20, downloadBean.getSe());
            eVar.c(21, downloadBean.getResolution());
            eVar.c(22, downloadBean.getResourcePosition());
            eVar.c(23, downloadBean.getMultiresolution());
            eVar.c(24, downloadBean.getVideoWidth());
            eVar.c(25, downloadBean.getVideoHeight());
            eVar.c(26, downloadBean.getDownloadErrorCount());
            eVar.c(27, downloadBean.getSubtitleStarted());
            if (downloadBean.getSubjectId() == null) {
                eVar.g(28);
            } else {
                eVar.i(28, downloadBean.getSubjectId());
            }
            if (downloadBean.getPageFrom() == null) {
                eVar.g(29);
            } else {
                eVar.i(29, downloadBean.getPageFrom());
            }
            if (downloadBean.getLastPageFrom() == null) {
                eVar.g(30);
            } else {
                eVar.i(30, downloadBean.getLastPageFrom());
            }
            if (downloadBean.getSubjectName() == null) {
                eVar.g(31);
            } else {
                eVar.i(31, downloadBean.getSubjectName());
            }
            eVar.c(32, downloadBean.getLastPlayTimeStamp());
            eVar.c(33, downloadBean.getFileType());
            eVar.c(34, downloadBean.getTotalEpisode());
            if (downloadBean.getUploadBy() == null) {
                eVar.g(35);
            } else {
                eVar.i(35, downloadBean.getUploadBy());
            }
            if (downloadBean.getSourceUrl() == null) {
                eVar.g(36);
            } else {
                eVar.i(36, downloadBean.getSourceUrl());
            }
            eVar.c(37, downloadBean.getUrlCreateAt());
            if (downloadBean.getSubtitleSelectId() == null) {
                eVar.g(38);
            } else {
                eVar.i(38, downloadBean.getSubtitleSelectId());
            }
            if (downloadBean.getTaskId() == null) {
                eVar.g(39);
            } else {
                eVar.i(39, downloadBean.getTaskId());
            }
            eVar.c(40, downloadBean.getSessionTime());
            eVar.c(41, downloadBean.getReportStatus());
            eVar.c(42, downloadBean.getDownloadHeaderSize());
            if (downloadBean.getRootPath() == null) {
                eVar.g(43);
            } else {
                eVar.i(43, downloadBean.getRootPath());
            }
            eVar.c(44, downloadBean.getRootPathType());
            if (downloadBean.getThumbnail() == null) {
                eVar.g(45);
            } else {
                eVar.i(45, downloadBean.getThumbnail());
            }
            if (downloadBean.getAverageHueLight() == null) {
                eVar.g(46);
            } else {
                eVar.i(46, downloadBean.getAverageHueLight());
            }
            eVar.c(47, downloadBean.getIsTransferFailed() ? 1L : 0L);
            eVar.c(48, downloadBean.getIsClosedTransferFailed() ? 1L : 0L);
            eVar.c(49, downloadBean.getSubjectType());
            if (downloadBean.getGenre() == null) {
                eVar.g(50);
            } else {
                eVar.i(50, downloadBean.getGenre());
            }
            if (downloadBean.getSubjectDurationSeconds() == null) {
                eVar.g(51);
            } else {
                eVar.c(51, downloadBean.getSubjectDurationSeconds().intValue());
            }
            if (downloadBean.getCurrentDubLanName() == null) {
                eVar.g(52);
            } else {
                eVar.i(52, downloadBean.getCurrentDubLanName());
            }
            if (downloadBean.getCurrentDubLanCode() == null) {
                eVar.g(53);
            } else {
                eVar.i(53, downloadBean.getCurrentDubLanCode());
            }
            if (downloadBean.getOps() == null) {
                eVar.g(54);
            } else {
                eVar.i(54, downloadBean.getOps());
            }
            if (downloadBean.getRestrictLevel() == null) {
                eVar.g(55);
            } else {
                eVar.i(55, downloadBean.getRestrictLevel());
            }
            if (downloadBean.getReleaseDate() == null) {
                eVar.g(56);
            } else {
                eVar.i(56, downloadBean.getReleaseDate());
            }
            if (downloadBean.getCountryName() == null) {
                eVar.g(57);
            } else {
                eVar.i(57, downloadBean.getCountryName());
            }
            if (downloadBean.getSeNum() == null) {
                eVar.g(58);
            } else {
                eVar.c(58, downloadBean.getSeNum().intValue());
            }
            if (downloadBean.getSubtitles() == null) {
                eVar.g(59);
            } else {
                eVar.i(59, downloadBean.getSubtitles());
            }
            if (downloadBean.getImdbRate() == null) {
                eVar.g(60);
            } else {
                eVar.i(60, downloadBean.getImdbRate());
            }
            if (downloadBean.getLastAdStartTimeStamp() == null) {
                eVar.g(61);
            } else {
                eVar.c(61, downloadBean.getLastAdStartTimeStamp().longValue());
            }
            if (downloadBean.getLastAdEndTimeStamp() == null) {
                eVar.g(62);
            } else {
                eVar.c(62, downloadBean.getLastAdEndTimeStamp().longValue());
            }
            if (downloadBean.getSubtitleIdType() == null) {
                eVar.g(63);
            } else {
                eVar.i(63, downloadBean.getSubtitleIdType());
            }
            if (downloadBean.getUgcVideoCollectionId() == null) {
                eVar.g(64);
            } else {
                eVar.i(64, downloadBean.getUgcVideoCollectionId());
            }
            if (downloadBean.getUgcVideoId() == null) {
                eVar.g(65);
            } else {
                eVar.i(65, downloadBean.getUgcVideoId());
            }
            if (downloadBean.getUgcVideoName() == null) {
                eVar.g(66);
            } else {
                eVar.i(66, downloadBean.getUgcVideoName());
            }
            if (downloadBean.getUgcVideoCollectionName() == null) {
                eVar.g(67);
            } else {
                eVar.i(67, downloadBean.getUgcVideoCollectionName());
            }
            if (downloadBean.getUgcVideoPosition() == null) {
                eVar.g(68);
            } else {
                eVar.c(68, downloadBean.getUgcVideoPosition().intValue());
            }
            if (downloadBean.getUgcVideoType() == null) {
                eVar.g(69);
            } else {
                eVar.i(69, downloadBean.getUgcVideoType());
            }
            if (downloadBean.getUgcCateLev1Id() == null) {
                eVar.g(70);
            } else {
                eVar.c(70, downloadBean.getUgcCateLev1Id().intValue());
            }
            if (downloadBean.getUgcCateLev2Id() == null) {
                eVar.g(71);
            } else {
                eVar.c(71, downloadBean.getUgcCateLev2Id().intValue());
            }
            if (downloadBean.getUgcCateLev3Id() == null) {
                eVar.g(72);
            } else {
                eVar.c(72, downloadBean.getUgcCateLev3Id().intValue());
            }
            if (downloadBean.getUgcCateLev4Id() == null) {
                eVar.g(73);
            } else {
                eVar.c(73, downloadBean.getUgcCateLev4Id().intValue());
            }
            if (downloadBean.getUgcVideoTrackId() == null) {
                eVar.g(74);
            } else {
                eVar.i(74, downloadBean.getUgcVideoTrackId());
            }
            if (downloadBean.getUgcVideoParentVideoId() == null) {
                eVar.g(75);
            } else {
                eVar.i(75, downloadBean.getUgcVideoParentVideoId());
            }
            if (downloadBean.getUgcVideoParentTrackId() == null) {
                eVar.g(76);
            } else {
                eVar.i(76, downloadBean.getUgcVideoParentTrackId());
            }
            if (downloadBean.getUgcVideoEpTitle() == null) {
                eVar.g(77);
            } else {
                eVar.i(77, downloadBean.getUgcVideoEpTitle());
            }
            eVar.c(78, downloadBean.getUgcVideoIsVertical() ? 1L : 0L);
            if (downloadBean.getOriginData() == null) {
                eVar.g(79);
            } else {
                eVar.i(79, downloadBean.getOriginData());
            }
            if (downloadBean.getKidId() == null) {
                eVar.g(80);
            } else {
                eVar.i(80, downloadBean.getKidId());
            }
            if (downloadBean.getUrl() == null) {
                eVar.g(81);
            } else {
                eVar.i(81, downloadBean.getUrl());
            }
        }
    }

    public l0(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List A0(y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        Integer valueOf8;
        int i54;
        int i55;
        Integer valueOf9;
        int i56;
        String q027;
        int i57;
        String q028;
        int i58;
        int i59;
        String q029;
        int i60;
        String q030;
        int i61;
        int i62;
        int i63;
        boolean z3;
        String q031;
        int i64;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE status = 6 OR status = 3 AND fileType == 1 ORDER BY updateTimeStamp DESC ");
        try {
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i65 = c3;
                int i66 = c4;
                int i67 = (int) F0.getLong(c13);
                int i68 = c5;
                int i69 = (int) F0.getLong(c14);
                int i70 = c6;
                int i71 = (int) F0.getLong(c15);
                int i72 = c16;
                long j2 = F0.getLong(i72);
                int i73 = c2;
                int i74 = c17;
                long j3 = F0.getLong(i74);
                c17 = i74;
                int i75 = c18;
                int i76 = c7;
                int i77 = (int) F0.getLong(i75);
                int i78 = c9;
                int i79 = c19;
                int i80 = c8;
                int i81 = (int) F0.getLong(i79);
                int i82 = c11;
                int i83 = c20;
                int i84 = c10;
                int i85 = (int) F0.getLong(i83);
                int i86 = c13;
                int i87 = c21;
                int i88 = c12;
                int i89 = (int) F0.getLong(i87);
                int i90 = c15;
                int i91 = c22;
                int i92 = c14;
                int i93 = (int) F0.getLong(i91);
                int i94 = c23;
                int i95 = (int) F0.getLong(i94);
                int i96 = c24;
                ArrayList arrayList2 = arrayList;
                int i97 = (int) F0.getLong(i96);
                int i98 = c25;
                int i99 = (int) F0.getLong(i98);
                int i100 = c26;
                int i101 = (int) F0.getLong(i100);
                int i102 = c27;
                int i103 = (int) F0.getLong(i102);
                int i104 = c28;
                int i105 = (int) F0.getLong(i104);
                int i106 = c29;
                if (F0.isNull(i106)) {
                    i = i75;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i106);
                    i = i75;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i107 = c34;
                int i108 = (int) F0.getLong(i107);
                int i109 = c35;
                int i110 = (int) F0.getLong(i109);
                int i111 = c36;
                if (F0.isNull(i111)) {
                    i6 = i107;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i111);
                    i6 = i107;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i112 = c39;
                if (F0.isNull(i112)) {
                    c39 = i112;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i112);
                    c39 = i112;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i113 = c42;
                int i114 = (int) F0.getLong(i113);
                int i115 = c43;
                long j7 = F0.getLong(i115);
                int i116 = c44;
                if (F0.isNull(i116)) {
                    c44 = i116;
                    i11 = i115;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i115;
                    q09 = F0.q0(i116);
                    c44 = i116;
                    i12 = c45;
                }
                int i117 = (int) F0.getLong(i12);
                int i118 = c46;
                if (F0.isNull(i118)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i118);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i118;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i118;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i119 = i17;
                int i120 = (int) F0.getLong(i18);
                int i121 = c51;
                if (F0.isNull(i121)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i121);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i18;
                    i21 = i120;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i18;
                    i21 = i120;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i22;
                    i31 = i23;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i22;
                    i31 = i23;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i121;
                    i48 = i19;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i121;
                    i48 = i19;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i54 = c74;
                }
                if (F0.isNull(i54)) {
                    i55 = i50;
                    i56 = c75;
                    valueOf9 = null;
                } else {
                    i55 = i50;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i54));
                    i56 = c75;
                }
                if (F0.isNull(i56)) {
                    i57 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i56);
                    i57 = c76;
                }
                if (F0.isNull(i57)) {
                    i58 = i42;
                    i59 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i57);
                    i58 = i42;
                    i59 = c77;
                }
                if (F0.isNull(i59)) {
                    c77 = i59;
                    i60 = c78;
                    q029 = null;
                } else {
                    c77 = i59;
                    q029 = F0.q0(i59);
                    i60 = c78;
                }
                if (F0.isNull(i60)) {
                    c78 = i60;
                    i62 = i52;
                    i61 = c79;
                    q030 = null;
                } else {
                    c78 = i60;
                    q030 = F0.q0(i60);
                    i61 = c79;
                    i62 = i52;
                }
                int i122 = i54;
                if (((int) F0.getLong(i61)) != 0) {
                    i63 = c80;
                    z3 = true;
                } else {
                    i63 = c80;
                    z3 = false;
                }
                if (F0.isNull(i63)) {
                    i64 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i63);
                    i64 = c81;
                }
                int i123 = i61;
                arrayList2.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i67, i69, i71, j2, j3, i77, i81, i85, i89, i93, i95, i97, i99, i101, i103, i105, q0, q02, q03, q04, j4, i108, i110, q05, q06, j5, q07, q08, j6, i114, j7, q09, i117, q010, q011, z, z2, i21, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i64) ? null : F0.q0(i64)));
                c2 = i73;
                c80 = i63;
                c81 = i64;
                c8 = i80;
                c10 = i84;
                c12 = i88;
                c14 = i92;
                c22 = i91;
                c24 = i96;
                c25 = i98;
                c27 = i102;
                c28 = i104;
                c34 = i6;
                c35 = i109;
                c42 = i113;
                c45 = i13;
                c49 = i119;
                c50 = i20;
                c48 = i24;
                c53 = i30;
                c54 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c52 = i48;
                c71 = i51;
                c72 = i53;
                c69 = i58;
                c73 = i62;
                c4 = i66;
                c5 = i68;
                c6 = i70;
                c16 = i72;
                c13 = i86;
                c23 = i94;
                c26 = i100;
                c36 = i111;
                c43 = i11;
                c46 = i15;
                c19 = i79;
                c20 = i83;
                c21 = i87;
                c75 = i56;
                c76 = i57;
                c7 = i76;
                c18 = i;
                c9 = i78;
                c11 = i82;
                c15 = i90;
                c29 = i106;
                arrayList = arrayList2;
                c3 = i65;
                c79 = i123;
                c51 = i47;
                c70 = i55;
                c74 = i122;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean B0(y3.b bVar) {
        String q0;
        int i;
        String q02;
        int i2;
        String q03;
        int i3;
        String q04;
        int i4;
        String q05;
        int i5;
        String q06;
        int i6;
        String q07;
        int i7;
        String q08;
        int i8;
        int i9;
        String q09;
        int i10;
        String q010;
        int i11;
        int i12;
        String q011;
        int i13;
        int i14;
        boolean z;
        int i15;
        boolean z2;
        String q012;
        int i16;
        Integer valueOf;
        int i17;
        String q013;
        int i18;
        String q014;
        int i19;
        String q015;
        int i20;
        String q016;
        int i21;
        String q017;
        int i22;
        String q018;
        int i23;
        Integer valueOf2;
        int i24;
        String q019;
        int i25;
        String q020;
        int i26;
        Long valueOf3;
        int i27;
        Long valueOf4;
        int i28;
        String q021;
        int i29;
        String q022;
        int i30;
        String q023;
        int i31;
        String q024;
        int i32;
        String q025;
        int i33;
        Integer valueOf5;
        int i34;
        String q026;
        int i35;
        Integer valueOf6;
        int i36;
        Integer valueOf7;
        int i37;
        Integer valueOf8;
        int i38;
        Integer valueOf9;
        int i39;
        String q027;
        int i40;
        String q028;
        int i41;
        String q029;
        int i42;
        String q030;
        int i43;
        int i44;
        boolean z3;
        String q031;
        int i45;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE status ==5 AND fileType == 1 AND type != 1 ORDER BY updateTimeStamp DESC LIMIT 1");
        try {
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            DownloadBean downloadBean = null;
            if (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i46 = (int) F0.getLong(c13);
                int i47 = (int) F0.getLong(c14);
                int i48 = (int) F0.getLong(c15);
                long j2 = F0.getLong(c16);
                long j3 = F0.getLong(c17);
                int i49 = (int) F0.getLong(c18);
                int i50 = (int) F0.getLong(c19);
                int i51 = (int) F0.getLong(c20);
                int i52 = (int) F0.getLong(c21);
                int i53 = (int) F0.getLong(c22);
                int i54 = (int) F0.getLong(c23);
                int i55 = (int) F0.getLong(c24);
                int i56 = (int) F0.getLong(c25);
                int i57 = (int) F0.getLong(c26);
                int i58 = (int) F0.getLong(c27);
                int i59 = (int) F0.getLong(c28);
                if (F0.isNull(c29)) {
                    i = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(c29);
                    i = c30;
                }
                if (F0.isNull(i)) {
                    i2 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i);
                    i2 = c31;
                }
                if (F0.isNull(i2)) {
                    i3 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i2);
                    i3 = c32;
                }
                if (F0.isNull(i3)) {
                    i4 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i3);
                    i4 = c33;
                }
                long j4 = F0.getLong(i4);
                int i60 = (int) F0.getLong(c34);
                int i61 = (int) F0.getLong(c35);
                if (F0.isNull(c36)) {
                    i5 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(c36);
                    i5 = c37;
                }
                if (F0.isNull(i5)) {
                    i6 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i5);
                    i6 = c38;
                }
                long j5 = F0.getLong(i6);
                if (F0.isNull(c39)) {
                    i7 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(c39);
                    i7 = c40;
                }
                if (F0.isNull(i7)) {
                    i8 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i7);
                    i8 = c41;
                }
                long j6 = F0.getLong(i8);
                int i62 = (int) F0.getLong(c42);
                long j7 = F0.getLong(c43);
                if (F0.isNull(c44)) {
                    i9 = i62;
                    i10 = c45;
                    q09 = null;
                } else {
                    i9 = i62;
                    q09 = F0.q0(c44);
                    i10 = c45;
                }
                int i63 = (int) F0.getLong(i10);
                if (F0.isNull(c46)) {
                    i11 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(c46);
                    i11 = c47;
                }
                if (F0.isNull(i11)) {
                    i12 = i63;
                    i13 = c48;
                    q011 = null;
                } else {
                    i12 = i63;
                    q011 = F0.q0(i11);
                    i13 = c48;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    z = true;
                    i14 = c49;
                } else {
                    i14 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    z2 = true;
                    i15 = c50;
                } else {
                    i15 = c50;
                    z2 = false;
                }
                int i64 = (int) F0.getLong(i15);
                if (F0.isNull(c51)) {
                    i16 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(c51);
                    i16 = c52;
                }
                if (F0.isNull(i16)) {
                    i17 = c53;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf((int) F0.getLong(i16));
                    i17 = c53;
                }
                if (F0.isNull(i17)) {
                    i18 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i17);
                    i18 = c54;
                }
                if (F0.isNull(i18)) {
                    i19 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i18);
                    i19 = c55;
                }
                if (F0.isNull(i19)) {
                    i20 = c56;
                    q015 = null;
                } else {
                    q015 = F0.q0(i19);
                    i20 = c56;
                }
                if (F0.isNull(i20)) {
                    i21 = c57;
                    q016 = null;
                } else {
                    q016 = F0.q0(i20);
                    i21 = c57;
                }
                if (F0.isNull(i21)) {
                    i22 = c58;
                    q017 = null;
                } else {
                    q017 = F0.q0(i21);
                    i22 = c58;
                }
                if (F0.isNull(i22)) {
                    i23 = c59;
                    q018 = null;
                } else {
                    q018 = F0.q0(i22);
                    i23 = c59;
                }
                if (F0.isNull(i23)) {
                    i24 = c60;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) F0.getLong(i23));
                    i24 = c60;
                }
                if (F0.isNull(i24)) {
                    i25 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i24);
                    i25 = c61;
                }
                if (F0.isNull(i25)) {
                    i26 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i25);
                    i26 = c62;
                }
                if (F0.isNull(i26)) {
                    i27 = c63;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(F0.getLong(i26));
                    i27 = c63;
                }
                if (F0.isNull(i27)) {
                    i28 = c64;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(i27));
                    i28 = c64;
                }
                if (F0.isNull(i28)) {
                    i29 = c65;
                    q021 = null;
                } else {
                    q021 = F0.q0(i28);
                    i29 = c65;
                }
                if (F0.isNull(i29)) {
                    i30 = c66;
                    q022 = null;
                } else {
                    q022 = F0.q0(i29);
                    i30 = c66;
                }
                if (F0.isNull(i30)) {
                    i31 = c67;
                    q023 = null;
                } else {
                    q023 = F0.q0(i30);
                    i31 = c67;
                }
                if (F0.isNull(i31)) {
                    i32 = c68;
                    q024 = null;
                } else {
                    q024 = F0.q0(i31);
                    i32 = c68;
                }
                if (F0.isNull(i32)) {
                    i33 = c69;
                    q025 = null;
                } else {
                    q025 = F0.q0(i32);
                    i33 = c69;
                }
                if (F0.isNull(i33)) {
                    i34 = c70;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) F0.getLong(i33));
                    i34 = c70;
                }
                if (F0.isNull(i34)) {
                    i35 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i34);
                    i35 = c71;
                }
                if (F0.isNull(i35)) {
                    i36 = c72;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) F0.getLong(i35));
                    i36 = c72;
                }
                if (F0.isNull(i36)) {
                    i37 = c73;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) F0.getLong(i36));
                    i37 = c73;
                }
                if (F0.isNull(i37)) {
                    i38 = c74;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) F0.getLong(i37));
                    i38 = c74;
                }
                if (F0.isNull(i38)) {
                    i39 = c75;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) F0.getLong(i38));
                    i39 = c75;
                }
                if (F0.isNull(i39)) {
                    i40 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i39);
                    i40 = c76;
                }
                if (F0.isNull(i40)) {
                    i41 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i40);
                    i41 = c77;
                }
                if (F0.isNull(i41)) {
                    i42 = c78;
                    q029 = null;
                } else {
                    q029 = F0.q0(i41);
                    i42 = c78;
                }
                if (F0.isNull(i42)) {
                    i43 = c79;
                    q030 = null;
                } else {
                    q030 = F0.q0(i42);
                    i43 = c79;
                }
                if (((int) F0.getLong(i43)) != 0) {
                    z3 = true;
                    i44 = c80;
                } else {
                    i44 = c80;
                    z3 = false;
                }
                if (F0.isNull(i44)) {
                    i45 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i44);
                    i45 = c81;
                }
                downloadBean = new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i46, i47, i48, j2, j3, i49, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, q0, q02, q03, q04, j4, i60, i61, q05, q06, j5, q07, q08, j6, i9, j7, q09, i12, q010, q011, z, z2, i64, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i45) ? null : F0.q0(i45));
            }
            return downloadBean;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List C0(String str, y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        int i54;
        Integer valueOf8;
        int i55;
        int i56;
        int i57;
        Integer valueOf9;
        int i58;
        String q027;
        int i59;
        String q028;
        int i60;
        int i61;
        String q029;
        int i62;
        String q030;
        int i63;
        int i64;
        int i65;
        boolean z3;
        String q031;
        int i66;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE kidId = ? AND status = 5 AND fileType == 1 ORDER BY updateTimeStamp DESC");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i67 = c3;
                int i68 = c4;
                int i69 = (int) F0.getLong(c13);
                int i70 = c5;
                int i71 = (int) F0.getLong(c14);
                int i72 = c6;
                int i73 = (int) F0.getLong(c15);
                int i74 = c16;
                long j2 = F0.getLong(i74);
                int i75 = c2;
                int i76 = c17;
                long j3 = F0.getLong(i76);
                c17 = i76;
                int i77 = c18;
                int i78 = c7;
                int i79 = (int) F0.getLong(i77);
                int i80 = c9;
                int i81 = c19;
                int i82 = c8;
                int i83 = (int) F0.getLong(i81);
                int i84 = c11;
                int i85 = c20;
                int i86 = c10;
                int i87 = (int) F0.getLong(i85);
                int i88 = c13;
                int i89 = c21;
                int i90 = c12;
                int i91 = (int) F0.getLong(i89);
                int i92 = c15;
                int i93 = c22;
                int i94 = c14;
                int i95 = (int) F0.getLong(i93);
                int i96 = c23;
                int i97 = (int) F0.getLong(i96);
                int i98 = c24;
                int i99 = (int) F0.getLong(i98);
                int i100 = c25;
                int i101 = (int) F0.getLong(i100);
                int i102 = c26;
                int i103 = (int) F0.getLong(i102);
                int i104 = c27;
                int i105 = (int) F0.getLong(i104);
                int i106 = c28;
                int i107 = (int) F0.getLong(i106);
                int i108 = c29;
                if (F0.isNull(i108)) {
                    i = i77;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i108);
                    i = i77;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i109 = c34;
                int i110 = (int) F0.getLong(i109);
                int i111 = c35;
                int i112 = (int) F0.getLong(i111);
                int i113 = c36;
                if (F0.isNull(i113)) {
                    i6 = i109;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i113);
                    i6 = i109;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i114 = c39;
                if (F0.isNull(i114)) {
                    c39 = i114;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i114);
                    c39 = i114;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i115 = c42;
                int i116 = (int) F0.getLong(i115);
                int i117 = c43;
                long j7 = F0.getLong(i117);
                int i118 = c44;
                if (F0.isNull(i118)) {
                    c44 = i118;
                    i11 = i117;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i117;
                    q09 = F0.q0(i118);
                    c44 = i118;
                    i12 = c45;
                }
                int i119 = (int) F0.getLong(i12);
                int i120 = c46;
                if (F0.isNull(i120)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i120);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i120;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i120;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i121 = i17;
                int i122 = (int) F0.getLong(i18);
                int i123 = c51;
                if (F0.isNull(i123)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i123);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i122;
                    i21 = i123;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i122;
                    i21 = i123;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i18;
                    i31 = i19;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i18;
                    i31 = i19;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i22;
                    i48 = i23;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i22;
                    i48 = i23;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = i50;
                    i55 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    i54 = i50;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i55 = c74;
                }
                if (F0.isNull(i55)) {
                    i56 = i52;
                    i57 = i53;
                    i58 = c75;
                    valueOf9 = null;
                } else {
                    i56 = i52;
                    i57 = i53;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i55));
                    i58 = c75;
                }
                if (F0.isNull(i58)) {
                    i59 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i58);
                    i59 = c76;
                }
                if (F0.isNull(i59)) {
                    i60 = i42;
                    i61 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i59);
                    i60 = i42;
                    i61 = c77;
                }
                if (F0.isNull(i61)) {
                    c77 = i61;
                    i62 = c78;
                    q029 = null;
                } else {
                    c77 = i61;
                    q029 = F0.q0(i61);
                    i62 = c78;
                }
                if (F0.isNull(i62)) {
                    c78 = i62;
                    i64 = i58;
                    i63 = c79;
                    q030 = null;
                } else {
                    c78 = i62;
                    q030 = F0.q0(i62);
                    i63 = c79;
                    i64 = i58;
                }
                int i124 = i59;
                if (((int) F0.getLong(i63)) != 0) {
                    i65 = c80;
                    z3 = true;
                } else {
                    i65 = c80;
                    z3 = false;
                }
                if (F0.isNull(i65)) {
                    i66 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i65);
                    i66 = c81;
                }
                int i125 = i63;
                arrayList.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i69, i71, i73, j2, j3, i79, i83, i87, i91, i95, i97, i99, i101, i103, i105, i107, q0, q02, q03, q04, j4, i110, i112, q05, q06, j5, q07, q08, j6, i116, j7, q09, i119, q010, q011, z, z2, i20, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i66) ? null : F0.q0(i66)));
                c2 = i75;
                c80 = i65;
                c81 = i66;
                c8 = i82;
                c10 = i86;
                c12 = i90;
                c21 = i89;
                c34 = i6;
                c42 = i115;
                c45 = i13;
                c49 = i121;
                c48 = i24;
                c50 = i30;
                c52 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c53 = i47;
                c54 = i48;
                c71 = i51;
                c70 = i54;
                c72 = i57;
                c69 = i60;
                c75 = i64;
                c76 = i124;
                c3 = i67;
                c4 = i68;
                c5 = i70;
                c6 = i72;
                c16 = i74;
                c11 = i84;
                c13 = i88;
                c24 = i98;
                c26 = i102;
                c27 = i104;
                c28 = i106;
                c36 = i113;
                c43 = i11;
                c46 = i15;
                c35 = i111;
                c19 = i81;
                c20 = i85;
                c74 = i55;
                c73 = i56;
                c7 = i78;
                c14 = i94;
                c22 = i93;
                c23 = i96;
                c18 = i;
                c79 = i125;
                c9 = i80;
                c15 = i92;
                c25 = i100;
                c29 = i108;
                c51 = i21;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List D0(y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        Integer valueOf8;
        int i54;
        int i55;
        Integer valueOf9;
        int i56;
        String q027;
        int i57;
        String q028;
        int i58;
        int i59;
        String q029;
        int i60;
        String q030;
        int i61;
        int i62;
        int i63;
        boolean z3;
        String q031;
        int i64;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE (kidId IS NULL OR kidId = '') AND status = 5 AND fileType == 1 ORDER BY updateTimeStamp DESC");
        try {
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i65 = c3;
                int i66 = c4;
                int i67 = (int) F0.getLong(c13);
                int i68 = c5;
                int i69 = (int) F0.getLong(c14);
                int i70 = c6;
                int i71 = (int) F0.getLong(c15);
                int i72 = c16;
                long j2 = F0.getLong(i72);
                int i73 = c2;
                int i74 = c17;
                long j3 = F0.getLong(i74);
                c17 = i74;
                int i75 = c18;
                int i76 = c7;
                int i77 = (int) F0.getLong(i75);
                int i78 = c9;
                int i79 = c19;
                int i80 = c8;
                int i81 = (int) F0.getLong(i79);
                int i82 = c11;
                int i83 = c20;
                int i84 = c10;
                int i85 = (int) F0.getLong(i83);
                int i86 = c13;
                int i87 = c21;
                int i88 = c12;
                int i89 = (int) F0.getLong(i87);
                int i90 = c15;
                int i91 = c22;
                int i92 = c14;
                int i93 = (int) F0.getLong(i91);
                int i94 = c23;
                int i95 = (int) F0.getLong(i94);
                int i96 = c24;
                ArrayList arrayList2 = arrayList;
                int i97 = (int) F0.getLong(i96);
                int i98 = c25;
                int i99 = (int) F0.getLong(i98);
                int i100 = c26;
                int i101 = (int) F0.getLong(i100);
                int i102 = c27;
                int i103 = (int) F0.getLong(i102);
                int i104 = c28;
                int i105 = (int) F0.getLong(i104);
                int i106 = c29;
                if (F0.isNull(i106)) {
                    i = i75;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i106);
                    i = i75;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i107 = c34;
                int i108 = (int) F0.getLong(i107);
                int i109 = c35;
                int i110 = (int) F0.getLong(i109);
                int i111 = c36;
                if (F0.isNull(i111)) {
                    i6 = i107;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i111);
                    i6 = i107;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i112 = c39;
                if (F0.isNull(i112)) {
                    c39 = i112;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i112);
                    c39 = i112;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i113 = c42;
                int i114 = (int) F0.getLong(i113);
                int i115 = c43;
                long j7 = F0.getLong(i115);
                int i116 = c44;
                if (F0.isNull(i116)) {
                    c44 = i116;
                    i11 = i115;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i115;
                    q09 = F0.q0(i116);
                    c44 = i116;
                    i12 = c45;
                }
                int i117 = (int) F0.getLong(i12);
                int i118 = c46;
                if (F0.isNull(i118)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i118);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i118;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i118;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i119 = i17;
                int i120 = (int) F0.getLong(i18);
                int i121 = c51;
                if (F0.isNull(i121)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i121);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i18;
                    i21 = i120;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i18;
                    i21 = i120;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i22;
                    i31 = i23;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i22;
                    i31 = i23;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i121;
                    i48 = i19;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i121;
                    i48 = i19;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i54 = c74;
                }
                if (F0.isNull(i54)) {
                    i55 = i50;
                    i56 = c75;
                    valueOf9 = null;
                } else {
                    i55 = i50;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i54));
                    i56 = c75;
                }
                if (F0.isNull(i56)) {
                    i57 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i56);
                    i57 = c76;
                }
                if (F0.isNull(i57)) {
                    i58 = i42;
                    i59 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i57);
                    i58 = i42;
                    i59 = c77;
                }
                if (F0.isNull(i59)) {
                    c77 = i59;
                    i60 = c78;
                    q029 = null;
                } else {
                    c77 = i59;
                    q029 = F0.q0(i59);
                    i60 = c78;
                }
                if (F0.isNull(i60)) {
                    c78 = i60;
                    i62 = i52;
                    i61 = c79;
                    q030 = null;
                } else {
                    c78 = i60;
                    q030 = F0.q0(i60);
                    i61 = c79;
                    i62 = i52;
                }
                int i122 = i54;
                if (((int) F0.getLong(i61)) != 0) {
                    i63 = c80;
                    z3 = true;
                } else {
                    i63 = c80;
                    z3 = false;
                }
                if (F0.isNull(i63)) {
                    i64 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i63);
                    i64 = c81;
                }
                int i123 = i61;
                arrayList2.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i67, i69, i71, j2, j3, i77, i81, i85, i89, i93, i95, i97, i99, i101, i103, i105, q0, q02, q03, q04, j4, i108, i110, q05, q06, j5, q07, q08, j6, i114, j7, q09, i117, q010, q011, z, z2, i21, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i64) ? null : F0.q0(i64)));
                c2 = i73;
                c80 = i63;
                c81 = i64;
                c8 = i80;
                c10 = i84;
                c12 = i88;
                c14 = i92;
                c22 = i91;
                c24 = i96;
                c25 = i98;
                c27 = i102;
                c28 = i104;
                c34 = i6;
                c35 = i109;
                c42 = i113;
                c45 = i13;
                c49 = i119;
                c50 = i20;
                c48 = i24;
                c53 = i30;
                c54 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c52 = i48;
                c71 = i51;
                c72 = i53;
                c69 = i58;
                c73 = i62;
                c4 = i66;
                c5 = i68;
                c6 = i70;
                c16 = i72;
                c13 = i86;
                c23 = i94;
                c26 = i100;
                c36 = i111;
                c43 = i11;
                c46 = i15;
                c19 = i79;
                c20 = i83;
                c21 = i87;
                c75 = i56;
                c76 = i57;
                c7 = i76;
                c18 = i;
                c9 = i78;
                c11 = i82;
                c15 = i90;
                c29 = i106;
                arrayList = arrayList2;
                c3 = i65;
                c79 = i123;
                c51 = i47;
                c70 = i55;
                c74 = i122;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List E0(String str, y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        int i54;
        Integer valueOf8;
        int i55;
        int i56;
        int i57;
        Integer valueOf9;
        int i58;
        String q027;
        int i59;
        String q028;
        int i60;
        int i61;
        String q029;
        int i62;
        String q030;
        int i63;
        int i64;
        int i65;
        boolean z3;
        String q031;
        int i66;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE kidId = ? AND status != 5 AND fileType == 1 ORDER BY createAt ASC");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i67 = c3;
                int i68 = c4;
                int i69 = (int) F0.getLong(c13);
                int i70 = c5;
                int i71 = (int) F0.getLong(c14);
                int i72 = c6;
                int i73 = (int) F0.getLong(c15);
                int i74 = c16;
                long j2 = F0.getLong(i74);
                int i75 = c2;
                int i76 = c17;
                long j3 = F0.getLong(i76);
                c17 = i76;
                int i77 = c18;
                int i78 = c7;
                int i79 = (int) F0.getLong(i77);
                int i80 = c9;
                int i81 = c19;
                int i82 = c8;
                int i83 = (int) F0.getLong(i81);
                int i84 = c11;
                int i85 = c20;
                int i86 = c10;
                int i87 = (int) F0.getLong(i85);
                int i88 = c13;
                int i89 = c21;
                int i90 = c12;
                int i91 = (int) F0.getLong(i89);
                int i92 = c15;
                int i93 = c22;
                int i94 = c14;
                int i95 = (int) F0.getLong(i93);
                int i96 = c23;
                int i97 = (int) F0.getLong(i96);
                int i98 = c24;
                int i99 = (int) F0.getLong(i98);
                int i100 = c25;
                int i101 = (int) F0.getLong(i100);
                int i102 = c26;
                int i103 = (int) F0.getLong(i102);
                int i104 = c27;
                int i105 = (int) F0.getLong(i104);
                int i106 = c28;
                int i107 = (int) F0.getLong(i106);
                int i108 = c29;
                if (F0.isNull(i108)) {
                    i = i77;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i108);
                    i = i77;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i109 = c34;
                int i110 = (int) F0.getLong(i109);
                int i111 = c35;
                int i112 = (int) F0.getLong(i111);
                int i113 = c36;
                if (F0.isNull(i113)) {
                    i6 = i109;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i113);
                    i6 = i109;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i114 = c39;
                if (F0.isNull(i114)) {
                    c39 = i114;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i114);
                    c39 = i114;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i115 = c42;
                int i116 = (int) F0.getLong(i115);
                int i117 = c43;
                long j7 = F0.getLong(i117);
                int i118 = c44;
                if (F0.isNull(i118)) {
                    c44 = i118;
                    i11 = i117;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i117;
                    q09 = F0.q0(i118);
                    c44 = i118;
                    i12 = c45;
                }
                int i119 = (int) F0.getLong(i12);
                int i120 = c46;
                if (F0.isNull(i120)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i120);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i120;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i120;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i121 = i17;
                int i122 = (int) F0.getLong(i18);
                int i123 = c51;
                if (F0.isNull(i123)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i123);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i122;
                    i21 = i123;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i122;
                    i21 = i123;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i18;
                    i31 = i19;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i18;
                    i31 = i19;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i22;
                    i48 = i23;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i22;
                    i48 = i23;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = i50;
                    i55 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    i54 = i50;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i55 = c74;
                }
                if (F0.isNull(i55)) {
                    i56 = i52;
                    i57 = i53;
                    i58 = c75;
                    valueOf9 = null;
                } else {
                    i56 = i52;
                    i57 = i53;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i55));
                    i58 = c75;
                }
                if (F0.isNull(i58)) {
                    i59 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i58);
                    i59 = c76;
                }
                if (F0.isNull(i59)) {
                    i60 = i42;
                    i61 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i59);
                    i60 = i42;
                    i61 = c77;
                }
                if (F0.isNull(i61)) {
                    c77 = i61;
                    i62 = c78;
                    q029 = null;
                } else {
                    c77 = i61;
                    q029 = F0.q0(i61);
                    i62 = c78;
                }
                if (F0.isNull(i62)) {
                    c78 = i62;
                    i64 = i58;
                    i63 = c79;
                    q030 = null;
                } else {
                    c78 = i62;
                    q030 = F0.q0(i62);
                    i63 = c79;
                    i64 = i58;
                }
                int i124 = i59;
                if (((int) F0.getLong(i63)) != 0) {
                    i65 = c80;
                    z3 = true;
                } else {
                    i65 = c80;
                    z3 = false;
                }
                if (F0.isNull(i65)) {
                    i66 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i65);
                    i66 = c81;
                }
                int i125 = i63;
                arrayList.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i69, i71, i73, j2, j3, i79, i83, i87, i91, i95, i97, i99, i101, i103, i105, i107, q0, q02, q03, q04, j4, i110, i112, q05, q06, j5, q07, q08, j6, i116, j7, q09, i119, q010, q011, z, z2, i20, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i66) ? null : F0.q0(i66)));
                c2 = i75;
                c80 = i65;
                c81 = i66;
                c8 = i82;
                c10 = i86;
                c12 = i90;
                c21 = i89;
                c34 = i6;
                c42 = i115;
                c45 = i13;
                c49 = i121;
                c48 = i24;
                c50 = i30;
                c52 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c53 = i47;
                c54 = i48;
                c71 = i51;
                c70 = i54;
                c72 = i57;
                c69 = i60;
                c75 = i64;
                c76 = i124;
                c3 = i67;
                c4 = i68;
                c5 = i70;
                c6 = i72;
                c16 = i74;
                c11 = i84;
                c13 = i88;
                c24 = i98;
                c26 = i102;
                c27 = i104;
                c28 = i106;
                c36 = i113;
                c43 = i11;
                c46 = i15;
                c35 = i111;
                c19 = i81;
                c20 = i85;
                c74 = i55;
                c73 = i56;
                c7 = i78;
                c14 = i94;
                c22 = i93;
                c23 = i96;
                c18 = i;
                c79 = i125;
                c9 = i80;
                c15 = i92;
                c25 = i100;
                c29 = i108;
                c51 = i21;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List F0(y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        Integer valueOf8;
        int i54;
        int i55;
        Integer valueOf9;
        int i56;
        String q027;
        int i57;
        String q028;
        int i58;
        int i59;
        String q029;
        int i60;
        String q030;
        int i61;
        int i62;
        int i63;
        boolean z3;
        String q031;
        int i64;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE (kidId IS NULL OR kidId = '') AND status != 5 AND fileType == 1 ORDER BY createAt ASC");
        try {
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i65 = c3;
                int i66 = c4;
                int i67 = (int) F0.getLong(c13);
                int i68 = c5;
                int i69 = (int) F0.getLong(c14);
                int i70 = c6;
                int i71 = (int) F0.getLong(c15);
                int i72 = c16;
                long j2 = F0.getLong(i72);
                int i73 = c2;
                int i74 = c17;
                long j3 = F0.getLong(i74);
                c17 = i74;
                int i75 = c18;
                int i76 = c7;
                int i77 = (int) F0.getLong(i75);
                int i78 = c9;
                int i79 = c19;
                int i80 = c8;
                int i81 = (int) F0.getLong(i79);
                int i82 = c11;
                int i83 = c20;
                int i84 = c10;
                int i85 = (int) F0.getLong(i83);
                int i86 = c13;
                int i87 = c21;
                int i88 = c12;
                int i89 = (int) F0.getLong(i87);
                int i90 = c15;
                int i91 = c22;
                int i92 = c14;
                int i93 = (int) F0.getLong(i91);
                int i94 = c23;
                int i95 = (int) F0.getLong(i94);
                int i96 = c24;
                ArrayList arrayList2 = arrayList;
                int i97 = (int) F0.getLong(i96);
                int i98 = c25;
                int i99 = (int) F0.getLong(i98);
                int i100 = c26;
                int i101 = (int) F0.getLong(i100);
                int i102 = c27;
                int i103 = (int) F0.getLong(i102);
                int i104 = c28;
                int i105 = (int) F0.getLong(i104);
                int i106 = c29;
                if (F0.isNull(i106)) {
                    i = i75;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i106);
                    i = i75;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i107 = c34;
                int i108 = (int) F0.getLong(i107);
                int i109 = c35;
                int i110 = (int) F0.getLong(i109);
                int i111 = c36;
                if (F0.isNull(i111)) {
                    i6 = i107;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i111);
                    i6 = i107;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i112 = c39;
                if (F0.isNull(i112)) {
                    c39 = i112;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i112);
                    c39 = i112;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i113 = c42;
                int i114 = (int) F0.getLong(i113);
                int i115 = c43;
                long j7 = F0.getLong(i115);
                int i116 = c44;
                if (F0.isNull(i116)) {
                    c44 = i116;
                    i11 = i115;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i115;
                    q09 = F0.q0(i116);
                    c44 = i116;
                    i12 = c45;
                }
                int i117 = (int) F0.getLong(i12);
                int i118 = c46;
                if (F0.isNull(i118)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i118);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i118;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i118;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i119 = i17;
                int i120 = (int) F0.getLong(i18);
                int i121 = c51;
                if (F0.isNull(i121)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i121);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i18;
                    i21 = i120;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i18;
                    i21 = i120;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i22;
                    i31 = i23;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i22;
                    i31 = i23;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i121;
                    i48 = i19;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i121;
                    i48 = i19;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i54 = c74;
                }
                if (F0.isNull(i54)) {
                    i55 = i50;
                    i56 = c75;
                    valueOf9 = null;
                } else {
                    i55 = i50;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i54));
                    i56 = c75;
                }
                if (F0.isNull(i56)) {
                    i57 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i56);
                    i57 = c76;
                }
                if (F0.isNull(i57)) {
                    i58 = i42;
                    i59 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i57);
                    i58 = i42;
                    i59 = c77;
                }
                if (F0.isNull(i59)) {
                    c77 = i59;
                    i60 = c78;
                    q029 = null;
                } else {
                    c77 = i59;
                    q029 = F0.q0(i59);
                    i60 = c78;
                }
                if (F0.isNull(i60)) {
                    c78 = i60;
                    i62 = i52;
                    i61 = c79;
                    q030 = null;
                } else {
                    c78 = i60;
                    q030 = F0.q0(i60);
                    i61 = c79;
                    i62 = i52;
                }
                int i122 = i54;
                if (((int) F0.getLong(i61)) != 0) {
                    i63 = c80;
                    z3 = true;
                } else {
                    i63 = c80;
                    z3 = false;
                }
                if (F0.isNull(i63)) {
                    i64 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i63);
                    i64 = c81;
                }
                int i123 = i61;
                arrayList2.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i67, i69, i71, j2, j3, i77, i81, i85, i89, i93, i95, i97, i99, i101, i103, i105, q0, q02, q03, q04, j4, i108, i110, q05, q06, j5, q07, q08, j6, i114, j7, q09, i117, q010, q011, z, z2, i21, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i64) ? null : F0.q0(i64)));
                c2 = i73;
                c80 = i63;
                c81 = i64;
                c8 = i80;
                c10 = i84;
                c12 = i88;
                c14 = i92;
                c22 = i91;
                c24 = i96;
                c25 = i98;
                c27 = i102;
                c28 = i104;
                c34 = i6;
                c35 = i109;
                c42 = i113;
                c45 = i13;
                c49 = i119;
                c50 = i20;
                c48 = i24;
                c53 = i30;
                c54 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c52 = i48;
                c71 = i51;
                c72 = i53;
                c69 = i58;
                c73 = i62;
                c4 = i66;
                c5 = i68;
                c6 = i70;
                c16 = i72;
                c13 = i86;
                c23 = i94;
                c26 = i100;
                c36 = i111;
                c43 = i11;
                c46 = i15;
                c19 = i79;
                c20 = i83;
                c21 = i87;
                c75 = i56;
                c76 = i57;
                c7 = i76;
                c18 = i;
                c9 = i78;
                c11 = i82;
                c15 = i90;
                c29 = i106;
                arrayList = arrayList2;
                c3 = i65;
                c79 = i123;
                c51 = i47;
                c70 = i55;
                c74 = i122;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean G0(y3.b bVar) {
        String q0;
        int i;
        String q02;
        int i2;
        String q03;
        int i3;
        String q04;
        int i4;
        String q05;
        int i5;
        String q06;
        int i6;
        String q07;
        int i7;
        String q08;
        int i8;
        int i9;
        String q09;
        int i10;
        String q010;
        int i11;
        int i12;
        String q011;
        int i13;
        int i14;
        boolean z;
        int i15;
        boolean z2;
        String q012;
        int i16;
        Integer valueOf;
        int i17;
        String q013;
        int i18;
        String q014;
        int i19;
        String q015;
        int i20;
        String q016;
        int i21;
        String q017;
        int i22;
        String q018;
        int i23;
        Integer valueOf2;
        int i24;
        String q019;
        int i25;
        String q020;
        int i26;
        Long valueOf3;
        int i27;
        Long valueOf4;
        int i28;
        String q021;
        int i29;
        String q022;
        int i30;
        String q023;
        int i31;
        String q024;
        int i32;
        String q025;
        int i33;
        Integer valueOf5;
        int i34;
        String q026;
        int i35;
        Integer valueOf6;
        int i36;
        Integer valueOf7;
        int i37;
        Integer valueOf8;
        int i38;
        Integer valueOf9;
        int i39;
        String q027;
        int i40;
        String q028;
        int i41;
        String q029;
        int i42;
        String q030;
        int i43;
        int i44;
        boolean z3;
        String q031;
        int i45;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE status = 5 AND fileType == 1 Limit 1 ");
        try {
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            DownloadBean downloadBean = null;
            if (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i46 = (int) F0.getLong(c13);
                int i47 = (int) F0.getLong(c14);
                int i48 = (int) F0.getLong(c15);
                long j2 = F0.getLong(c16);
                long j3 = F0.getLong(c17);
                int i49 = (int) F0.getLong(c18);
                int i50 = (int) F0.getLong(c19);
                int i51 = (int) F0.getLong(c20);
                int i52 = (int) F0.getLong(c21);
                int i53 = (int) F0.getLong(c22);
                int i54 = (int) F0.getLong(c23);
                int i55 = (int) F0.getLong(c24);
                int i56 = (int) F0.getLong(c25);
                int i57 = (int) F0.getLong(c26);
                int i58 = (int) F0.getLong(c27);
                int i59 = (int) F0.getLong(c28);
                if (F0.isNull(c29)) {
                    i = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(c29);
                    i = c30;
                }
                if (F0.isNull(i)) {
                    i2 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i);
                    i2 = c31;
                }
                if (F0.isNull(i2)) {
                    i3 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i2);
                    i3 = c32;
                }
                if (F0.isNull(i3)) {
                    i4 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i3);
                    i4 = c33;
                }
                long j4 = F0.getLong(i4);
                int i60 = (int) F0.getLong(c34);
                int i61 = (int) F0.getLong(c35);
                if (F0.isNull(c36)) {
                    i5 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(c36);
                    i5 = c37;
                }
                if (F0.isNull(i5)) {
                    i6 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i5);
                    i6 = c38;
                }
                long j5 = F0.getLong(i6);
                if (F0.isNull(c39)) {
                    i7 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(c39);
                    i7 = c40;
                }
                if (F0.isNull(i7)) {
                    i8 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i7);
                    i8 = c41;
                }
                long j6 = F0.getLong(i8);
                int i62 = (int) F0.getLong(c42);
                long j7 = F0.getLong(c43);
                if (F0.isNull(c44)) {
                    i9 = i62;
                    i10 = c45;
                    q09 = null;
                } else {
                    i9 = i62;
                    q09 = F0.q0(c44);
                    i10 = c45;
                }
                int i63 = (int) F0.getLong(i10);
                if (F0.isNull(c46)) {
                    i11 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(c46);
                    i11 = c47;
                }
                if (F0.isNull(i11)) {
                    i12 = i63;
                    i13 = c48;
                    q011 = null;
                } else {
                    i12 = i63;
                    q011 = F0.q0(i11);
                    i13 = c48;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    z = true;
                    i14 = c49;
                } else {
                    i14 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    z2 = true;
                    i15 = c50;
                } else {
                    i15 = c50;
                    z2 = false;
                }
                int i64 = (int) F0.getLong(i15);
                if (F0.isNull(c51)) {
                    i16 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(c51);
                    i16 = c52;
                }
                if (F0.isNull(i16)) {
                    i17 = c53;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf((int) F0.getLong(i16));
                    i17 = c53;
                }
                if (F0.isNull(i17)) {
                    i18 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i17);
                    i18 = c54;
                }
                if (F0.isNull(i18)) {
                    i19 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i18);
                    i19 = c55;
                }
                if (F0.isNull(i19)) {
                    i20 = c56;
                    q015 = null;
                } else {
                    q015 = F0.q0(i19);
                    i20 = c56;
                }
                if (F0.isNull(i20)) {
                    i21 = c57;
                    q016 = null;
                } else {
                    q016 = F0.q0(i20);
                    i21 = c57;
                }
                if (F0.isNull(i21)) {
                    i22 = c58;
                    q017 = null;
                } else {
                    q017 = F0.q0(i21);
                    i22 = c58;
                }
                if (F0.isNull(i22)) {
                    i23 = c59;
                    q018 = null;
                } else {
                    q018 = F0.q0(i22);
                    i23 = c59;
                }
                if (F0.isNull(i23)) {
                    i24 = c60;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) F0.getLong(i23));
                    i24 = c60;
                }
                if (F0.isNull(i24)) {
                    i25 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i24);
                    i25 = c61;
                }
                if (F0.isNull(i25)) {
                    i26 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i25);
                    i26 = c62;
                }
                if (F0.isNull(i26)) {
                    i27 = c63;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(F0.getLong(i26));
                    i27 = c63;
                }
                if (F0.isNull(i27)) {
                    i28 = c64;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(i27));
                    i28 = c64;
                }
                if (F0.isNull(i28)) {
                    i29 = c65;
                    q021 = null;
                } else {
                    q021 = F0.q0(i28);
                    i29 = c65;
                }
                if (F0.isNull(i29)) {
                    i30 = c66;
                    q022 = null;
                } else {
                    q022 = F0.q0(i29);
                    i30 = c66;
                }
                if (F0.isNull(i30)) {
                    i31 = c67;
                    q023 = null;
                } else {
                    q023 = F0.q0(i30);
                    i31 = c67;
                }
                if (F0.isNull(i31)) {
                    i32 = c68;
                    q024 = null;
                } else {
                    q024 = F0.q0(i31);
                    i32 = c68;
                }
                if (F0.isNull(i32)) {
                    i33 = c69;
                    q025 = null;
                } else {
                    q025 = F0.q0(i32);
                    i33 = c69;
                }
                if (F0.isNull(i33)) {
                    i34 = c70;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) F0.getLong(i33));
                    i34 = c70;
                }
                if (F0.isNull(i34)) {
                    i35 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i34);
                    i35 = c71;
                }
                if (F0.isNull(i35)) {
                    i36 = c72;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) F0.getLong(i35));
                    i36 = c72;
                }
                if (F0.isNull(i36)) {
                    i37 = c73;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) F0.getLong(i36));
                    i37 = c73;
                }
                if (F0.isNull(i37)) {
                    i38 = c74;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) F0.getLong(i37));
                    i38 = c74;
                }
                if (F0.isNull(i38)) {
                    i39 = c75;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) F0.getLong(i38));
                    i39 = c75;
                }
                if (F0.isNull(i39)) {
                    i40 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i39);
                    i40 = c76;
                }
                if (F0.isNull(i40)) {
                    i41 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i40);
                    i41 = c77;
                }
                if (F0.isNull(i41)) {
                    i42 = c78;
                    q029 = null;
                } else {
                    q029 = F0.q0(i41);
                    i42 = c78;
                }
                if (F0.isNull(i42)) {
                    i43 = c79;
                    q030 = null;
                } else {
                    q030 = F0.q0(i42);
                    i43 = c79;
                }
                if (((int) F0.getLong(i43)) != 0) {
                    z3 = true;
                    i44 = c80;
                } else {
                    i44 = c80;
                    z3 = false;
                }
                if (F0.isNull(i44)) {
                    i45 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i44);
                    i45 = c81;
                }
                downloadBean = new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i46, i47, i48, j2, j3, i49, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, q0, q02, q03, q04, j4, i60, i61, q05, q06, j5, q07, q08, j6, i9, j7, q09, i12, q010, q011, z, z2, i64, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i45) ? null : F0.q0(i45));
            }
            return downloadBean;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean H0(String str, y3.b bVar) {
        String q0;
        int i;
        String q02;
        int i2;
        String q03;
        int i3;
        String q04;
        int i4;
        String q05;
        int i5;
        String q06;
        int i6;
        String q07;
        int i7;
        String q08;
        int i8;
        int i9;
        String q09;
        int i10;
        String q010;
        int i11;
        int i12;
        String q011;
        int i13;
        int i14;
        boolean z;
        int i15;
        boolean z2;
        String q012;
        int i16;
        int i17;
        Integer valueOf;
        int i18;
        String q013;
        int i19;
        String q014;
        int i20;
        String q015;
        int i21;
        String q016;
        int i22;
        String q017;
        int i23;
        String q018;
        int i24;
        Integer valueOf2;
        int i25;
        String q019;
        int i26;
        String q020;
        int i27;
        Long valueOf3;
        int i28;
        Long valueOf4;
        int i29;
        String q021;
        int i30;
        String q022;
        int i31;
        String q023;
        int i32;
        String q024;
        int i33;
        String q025;
        int i34;
        Integer valueOf5;
        int i35;
        String q026;
        int i36;
        Integer valueOf6;
        int i37;
        Integer valueOf7;
        int i38;
        Integer valueOf8;
        int i39;
        Integer valueOf9;
        int i40;
        String q027;
        int i41;
        String q028;
        int i42;
        String q029;
        int i43;
        String q030;
        int i44;
        int i45;
        boolean z3;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE type = 2 AND fileType = 2 AND path = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            DownloadBean downloadBean = null;
            if (F0.C0()) {
                String q031 = F0.isNull(c2) ? null : F0.q0(c2);
                String q032 = F0.isNull(c3) ? null : F0.q0(c3);
                String q033 = F0.isNull(c4) ? null : F0.q0(c4);
                String q034 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q035 = F0.isNull(c7) ? null : F0.q0(c7);
                String q036 = F0.isNull(c8) ? null : F0.q0(c8);
                String q037 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i46 = (int) F0.getLong(c13);
                int i47 = (int) F0.getLong(c14);
                int i48 = (int) F0.getLong(c15);
                long j2 = F0.getLong(c16);
                long j3 = F0.getLong(c17);
                int i49 = (int) F0.getLong(c18);
                int i50 = (int) F0.getLong(c19);
                int i51 = (int) F0.getLong(c20);
                int i52 = (int) F0.getLong(c21);
                int i53 = (int) F0.getLong(c22);
                int i54 = (int) F0.getLong(c23);
                int i55 = (int) F0.getLong(c24);
                int i56 = (int) F0.getLong(c25);
                int i57 = (int) F0.getLong(c26);
                int i58 = (int) F0.getLong(c27);
                int i59 = (int) F0.getLong(c28);
                if (F0.isNull(c29)) {
                    i = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(c29);
                    i = c30;
                }
                if (F0.isNull(i)) {
                    i2 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i);
                    i2 = c31;
                }
                if (F0.isNull(i2)) {
                    i3 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i2);
                    i3 = c32;
                }
                if (F0.isNull(i3)) {
                    i4 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i3);
                    i4 = c33;
                }
                long j4 = F0.getLong(i4);
                int i60 = (int) F0.getLong(c34);
                int i61 = (int) F0.getLong(c35);
                if (F0.isNull(c36)) {
                    i5 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(c36);
                    i5 = c37;
                }
                if (F0.isNull(i5)) {
                    i6 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i5);
                    i6 = c38;
                }
                long j5 = F0.getLong(i6);
                if (F0.isNull(c39)) {
                    i7 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(c39);
                    i7 = c40;
                }
                if (F0.isNull(i7)) {
                    i8 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i7);
                    i8 = c41;
                }
                long j6 = F0.getLong(i8);
                int i62 = (int) F0.getLong(c42);
                long j7 = F0.getLong(c43);
                if (F0.isNull(c44)) {
                    i9 = i62;
                    i10 = c45;
                    q09 = null;
                } else {
                    i9 = i62;
                    q09 = F0.q0(c44);
                    i10 = c45;
                }
                int i63 = (int) F0.getLong(i10);
                if (F0.isNull(c46)) {
                    i11 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(c46);
                    i11 = c47;
                }
                if (F0.isNull(i11)) {
                    i12 = i63;
                    i13 = c48;
                    q011 = null;
                } else {
                    i12 = i63;
                    q011 = F0.q0(i11);
                    i13 = c48;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c49;
                    z = true;
                } else {
                    i14 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c50;
                    z2 = true;
                } else {
                    i15 = c50;
                    z2 = false;
                }
                int i64 = (int) F0.getLong(i15);
                if (F0.isNull(c51)) {
                    i16 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(c51);
                    i16 = c52;
                }
                if (F0.isNull(i16)) {
                    i17 = i64;
                    i18 = c53;
                    valueOf = null;
                } else {
                    i17 = i64;
                    valueOf = Integer.valueOf((int) F0.getLong(i16));
                    i18 = c53;
                }
                if (F0.isNull(i18)) {
                    i19 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i18);
                    i19 = c54;
                }
                if (F0.isNull(i19)) {
                    i20 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i19);
                    i20 = c55;
                }
                if (F0.isNull(i20)) {
                    i21 = c56;
                    q015 = null;
                } else {
                    q015 = F0.q0(i20);
                    i21 = c56;
                }
                if (F0.isNull(i21)) {
                    i22 = c57;
                    q016 = null;
                } else {
                    q016 = F0.q0(i21);
                    i22 = c57;
                }
                if (F0.isNull(i22)) {
                    i23 = c58;
                    q017 = null;
                } else {
                    q017 = F0.q0(i22);
                    i23 = c58;
                }
                if (F0.isNull(i23)) {
                    i24 = c59;
                    q018 = null;
                } else {
                    q018 = F0.q0(i23);
                    i24 = c59;
                }
                if (F0.isNull(i24)) {
                    i25 = c60;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) F0.getLong(i24));
                    i25 = c60;
                }
                if (F0.isNull(i25)) {
                    i26 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i25);
                    i26 = c61;
                }
                if (F0.isNull(i26)) {
                    i27 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i26);
                    i27 = c62;
                }
                if (F0.isNull(i27)) {
                    i28 = c63;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(F0.getLong(i27));
                    i28 = c63;
                }
                if (F0.isNull(i28)) {
                    i29 = c64;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(i28));
                    i29 = c64;
                }
                if (F0.isNull(i29)) {
                    i30 = c65;
                    q021 = null;
                } else {
                    q021 = F0.q0(i29);
                    i30 = c65;
                }
                if (F0.isNull(i30)) {
                    i31 = c66;
                    q022 = null;
                } else {
                    q022 = F0.q0(i30);
                    i31 = c66;
                }
                if (F0.isNull(i31)) {
                    i32 = c67;
                    q023 = null;
                } else {
                    q023 = F0.q0(i31);
                    i32 = c67;
                }
                if (F0.isNull(i32)) {
                    i33 = c68;
                    q024 = null;
                } else {
                    q024 = F0.q0(i32);
                    i33 = c68;
                }
                if (F0.isNull(i33)) {
                    i34 = c69;
                    q025 = null;
                } else {
                    q025 = F0.q0(i33);
                    i34 = c69;
                }
                if (F0.isNull(i34)) {
                    i35 = c70;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) F0.getLong(i34));
                    i35 = c70;
                }
                if (F0.isNull(i35)) {
                    i36 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i35);
                    i36 = c71;
                }
                if (F0.isNull(i36)) {
                    i37 = c72;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) F0.getLong(i36));
                    i37 = c72;
                }
                if (F0.isNull(i37)) {
                    i38 = c73;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) F0.getLong(i37));
                    i38 = c73;
                }
                if (F0.isNull(i38)) {
                    i39 = c74;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) F0.getLong(i38));
                    i39 = c74;
                }
                if (F0.isNull(i39)) {
                    i40 = c75;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) F0.getLong(i39));
                    i40 = c75;
                }
                if (F0.isNull(i40)) {
                    i41 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i40);
                    i41 = c76;
                }
                if (F0.isNull(i41)) {
                    i42 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i41);
                    i42 = c77;
                }
                if (F0.isNull(i42)) {
                    i43 = c78;
                    q029 = null;
                } else {
                    q029 = F0.q0(i42);
                    i43 = c78;
                }
                if (F0.isNull(i43)) {
                    i44 = c79;
                    q030 = null;
                } else {
                    q030 = F0.q0(i43);
                    i44 = c79;
                }
                if (((int) F0.getLong(i44)) != 0) {
                    i45 = c80;
                    z3 = true;
                } else {
                    i45 = c80;
                    z3 = false;
                }
                downloadBean = new DownloadBean(q031, q032, q033, q034, valueOf10, q035, q036, q037, valueOf11, valueOf12, j, i46, i47, i48, j2, j3, i49, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, q0, q02, q03, q04, j4, i60, i61, q05, q06, j5, q07, q08, j6, i9, j7, q09, i12, q010, q011, z, z2, i17, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, F0.isNull(i45) ? null : F0.q0(i45), F0.isNull(c81) ? null : F0.q0(c81));
            }
            F0.close();
            return downloadBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List I0(int i, y3.b bVar) {
        String q0;
        int i2;
        int i3;
        String q02;
        int i4;
        String q03;
        int i5;
        String q04;
        int i6;
        String q05;
        int i7;
        int i8;
        String q06;
        int i9;
        String q07;
        int i10;
        String q08;
        int i11;
        int i12;
        String q09;
        int i13;
        String q010;
        int i14;
        int i15;
        int i16;
        String q011;
        int i17;
        int i18;
        boolean z;
        int i19;
        boolean z2;
        String q012;
        int i20;
        int i21;
        int i22;
        Integer valueOf;
        int i23;
        String q013;
        int i24;
        String q014;
        int i25;
        int i26;
        String q015;
        int i27;
        String q016;
        int i28;
        String q017;
        int i29;
        String q018;
        int i30;
        int i31;
        int i32;
        Integer valueOf2;
        int i33;
        String q019;
        int i34;
        String q020;
        int i35;
        int i36;
        Long valueOf3;
        int i37;
        Long valueOf4;
        int i38;
        String q021;
        int i39;
        String q022;
        int i40;
        String q023;
        int i41;
        String q024;
        int i42;
        String q025;
        int i43;
        int i44;
        int i45;
        Integer valueOf5;
        int i46;
        String q026;
        int i47;
        int i48;
        int i49;
        Integer valueOf6;
        int i50;
        int i51;
        int i52;
        Integer valueOf7;
        int i53;
        int i54;
        int i55;
        Integer valueOf8;
        int i56;
        int i57;
        int i58;
        Integer valueOf9;
        int i59;
        String q027;
        int i60;
        String q028;
        int i61;
        int i62;
        String q029;
        int i63;
        String q030;
        int i64;
        int i65;
        int i66;
        boolean z3;
        String q031;
        int i67;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE fileType == 1 ORDER BY updateTimeStamp DESC Limit ?");
        try {
            F0.c(1, i);
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i68 = c2;
                int i69 = c3;
                int i70 = (int) F0.getLong(c13);
                int i71 = c4;
                int i72 = (int) F0.getLong(c14);
                int i73 = c5;
                int i74 = (int) F0.getLong(c15);
                long j2 = F0.getLong(c16);
                int i75 = c17;
                long j3 = F0.getLong(i75);
                c17 = i75;
                int i76 = c7;
                int i77 = c18;
                int i78 = c6;
                int i79 = (int) F0.getLong(i77);
                int i80 = c9;
                int i81 = c19;
                int i82 = c8;
                int i83 = (int) F0.getLong(i81);
                int i84 = c11;
                int i85 = c20;
                int i86 = c10;
                int i87 = (int) F0.getLong(i85);
                int i88 = c13;
                int i89 = c21;
                int i90 = c12;
                int i91 = (int) F0.getLong(i89);
                int i92 = c15;
                int i93 = c22;
                int i94 = c14;
                int i95 = (int) F0.getLong(i93);
                int i96 = c23;
                int i97 = (int) F0.getLong(i96);
                int i98 = c24;
                int i99 = (int) F0.getLong(i98);
                int i100 = c25;
                int i101 = (int) F0.getLong(i100);
                int i102 = c26;
                int i103 = (int) F0.getLong(i102);
                int i104 = c27;
                int i105 = (int) F0.getLong(i104);
                int i106 = c28;
                int i107 = (int) F0.getLong(i106);
                int i108 = c29;
                if (F0.isNull(i108)) {
                    i2 = i77;
                    i3 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i108);
                    i2 = i77;
                    i3 = c30;
                }
                if (F0.isNull(i3)) {
                    c30 = i3;
                    i4 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    c30 = i3;
                    i4 = c31;
                }
                if (F0.isNull(i4)) {
                    c31 = i4;
                    i5 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i4);
                    c31 = i4;
                    i5 = c32;
                }
                if (F0.isNull(i5)) {
                    c32 = i5;
                    i6 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i5);
                    c32 = i5;
                    i6 = c33;
                }
                long j4 = F0.getLong(i6);
                c33 = i6;
                int i109 = c34;
                int i110 = (int) F0.getLong(i109);
                int i111 = c35;
                int i112 = (int) F0.getLong(i111);
                int i113 = c36;
                if (F0.isNull(i113)) {
                    i7 = i109;
                    i8 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i113);
                    i7 = i109;
                    i8 = c37;
                }
                if (F0.isNull(i8)) {
                    c37 = i8;
                    i9 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i8);
                    c37 = i8;
                    i9 = c38;
                }
                long j5 = F0.getLong(i9);
                c38 = i9;
                int i114 = c39;
                if (F0.isNull(i114)) {
                    c39 = i114;
                    i10 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i114);
                    c39 = i114;
                    i10 = c40;
                }
                if (F0.isNull(i10)) {
                    c40 = i10;
                    i11 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i10);
                    c40 = i10;
                    i11 = c41;
                }
                long j6 = F0.getLong(i11);
                c41 = i11;
                int i115 = c42;
                int i116 = (int) F0.getLong(i115);
                int i117 = c43;
                long j7 = F0.getLong(i117);
                int i118 = c44;
                if (F0.isNull(i118)) {
                    c44 = i118;
                    i12 = i117;
                    i13 = c45;
                    q09 = null;
                } else {
                    i12 = i117;
                    q09 = F0.q0(i118);
                    c44 = i118;
                    i13 = c45;
                }
                int i119 = (int) F0.getLong(i13);
                int i120 = c46;
                if (F0.isNull(i120)) {
                    i14 = i13;
                    i15 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i120);
                    i14 = i13;
                    i15 = c47;
                }
                if (F0.isNull(i15)) {
                    c47 = i15;
                    i16 = i120;
                    i17 = c48;
                    q011 = null;
                } else {
                    i16 = i120;
                    q011 = F0.q0(i15);
                    c47 = i15;
                    i17 = c48;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c49;
                    z = true;
                } else {
                    i18 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i18)) != 0) {
                    i19 = c50;
                    z2 = true;
                } else {
                    i19 = c50;
                    z2 = false;
                }
                int i121 = i18;
                int i122 = (int) F0.getLong(i19);
                int i123 = c51;
                if (F0.isNull(i123)) {
                    i20 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i123);
                    i20 = c52;
                }
                if (F0.isNull(i20)) {
                    i21 = i122;
                    i22 = i123;
                    i23 = c53;
                    valueOf = null;
                } else {
                    i21 = i122;
                    i22 = i123;
                    valueOf = Integer.valueOf((int) F0.getLong(i20));
                    i23 = c53;
                }
                if (F0.isNull(i23)) {
                    i24 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i23);
                    i24 = c54;
                }
                if (F0.isNull(i24)) {
                    i25 = i17;
                    i26 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i24);
                    i25 = i17;
                    i26 = c55;
                }
                if (F0.isNull(i26)) {
                    c55 = i26;
                    i27 = c56;
                    q015 = null;
                } else {
                    c55 = i26;
                    q015 = F0.q0(i26);
                    i27 = c56;
                }
                if (F0.isNull(i27)) {
                    c56 = i27;
                    i28 = c57;
                    q016 = null;
                } else {
                    c56 = i27;
                    q016 = F0.q0(i27);
                    i28 = c57;
                }
                if (F0.isNull(i28)) {
                    c57 = i28;
                    i29 = c58;
                    q017 = null;
                } else {
                    c57 = i28;
                    q017 = F0.q0(i28);
                    i29 = c58;
                }
                if (F0.isNull(i29)) {
                    c58 = i29;
                    i30 = c59;
                    q018 = null;
                } else {
                    c58 = i29;
                    q018 = F0.q0(i29);
                    i30 = c59;
                }
                if (F0.isNull(i30)) {
                    i31 = i19;
                    i32 = i20;
                    i33 = c60;
                    valueOf2 = null;
                } else {
                    i31 = i19;
                    i32 = i20;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i30));
                    i33 = c60;
                }
                if (F0.isNull(i33)) {
                    i34 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i33);
                    i34 = c61;
                }
                if (F0.isNull(i34)) {
                    i35 = i30;
                    i36 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i34);
                    i35 = i30;
                    i36 = c62;
                }
                if (F0.isNull(i36)) {
                    c62 = i36;
                    i37 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i36;
                    valueOf3 = Long.valueOf(F0.getLong(i36));
                    i37 = c63;
                }
                if (F0.isNull(i37)) {
                    c63 = i37;
                    i38 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i37;
                    valueOf4 = Long.valueOf(F0.getLong(i37));
                    i38 = c64;
                }
                if (F0.isNull(i38)) {
                    c64 = i38;
                    i39 = c65;
                    q021 = null;
                } else {
                    c64 = i38;
                    q021 = F0.q0(i38);
                    i39 = c65;
                }
                if (F0.isNull(i39)) {
                    c65 = i39;
                    i40 = c66;
                    q022 = null;
                } else {
                    c65 = i39;
                    q022 = F0.q0(i39);
                    i40 = c66;
                }
                if (F0.isNull(i40)) {
                    c66 = i40;
                    i41 = c67;
                    q023 = null;
                } else {
                    c66 = i40;
                    q023 = F0.q0(i40);
                    i41 = c67;
                }
                if (F0.isNull(i41)) {
                    c67 = i41;
                    i42 = c68;
                    q024 = null;
                } else {
                    c67 = i41;
                    q024 = F0.q0(i41);
                    i42 = c68;
                }
                if (F0.isNull(i42)) {
                    c68 = i42;
                    i43 = c69;
                    q025 = null;
                } else {
                    c68 = i42;
                    q025 = F0.q0(i42);
                    i43 = c69;
                }
                if (F0.isNull(i43)) {
                    i44 = i33;
                    i45 = i34;
                    i46 = c70;
                    valueOf5 = null;
                } else {
                    i44 = i33;
                    i45 = i34;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i43));
                    i46 = c70;
                }
                if (F0.isNull(i46)) {
                    i47 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i46);
                    i47 = c71;
                }
                if (F0.isNull(i47)) {
                    i48 = i23;
                    i49 = i24;
                    i50 = c72;
                    valueOf6 = null;
                } else {
                    i48 = i23;
                    i49 = i24;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i47));
                    i50 = c72;
                }
                if (F0.isNull(i50)) {
                    i51 = i46;
                    i52 = i47;
                    i53 = c73;
                    valueOf7 = null;
                } else {
                    i51 = i46;
                    i52 = i47;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i50));
                    i53 = c73;
                }
                if (F0.isNull(i53)) {
                    i54 = i50;
                    i55 = i51;
                    i56 = c74;
                    valueOf8 = null;
                } else {
                    i54 = i50;
                    i55 = i51;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i53));
                    i56 = c74;
                }
                if (F0.isNull(i56)) {
                    i57 = i53;
                    i58 = i54;
                    i59 = c75;
                    valueOf9 = null;
                } else {
                    i57 = i53;
                    i58 = i54;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i56));
                    i59 = c75;
                }
                if (F0.isNull(i59)) {
                    i60 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i59);
                    i60 = c76;
                }
                if (F0.isNull(i60)) {
                    i61 = i43;
                    i62 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i60);
                    i61 = i43;
                    i62 = c77;
                }
                if (F0.isNull(i62)) {
                    c77 = i62;
                    i63 = c78;
                    q029 = null;
                } else {
                    c77 = i62;
                    q029 = F0.q0(i62);
                    i63 = c78;
                }
                if (F0.isNull(i63)) {
                    c78 = i63;
                    i65 = i59;
                    i64 = c79;
                    q030 = null;
                } else {
                    c78 = i63;
                    q030 = F0.q0(i63);
                    i64 = c79;
                    i65 = i59;
                }
                int i124 = i60;
                if (((int) F0.getLong(i64)) != 0) {
                    i66 = c80;
                    z3 = true;
                } else {
                    i66 = c80;
                    z3 = false;
                }
                if (F0.isNull(i66)) {
                    i67 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i66);
                    i67 = c81;
                }
                int i125 = i64;
                arrayList.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i70, i72, i74, j2, j3, i79, i83, i87, i91, i95, i97, i99, i101, i103, i105, i107, q0, q02, q03, q04, j4, i110, i112, q05, q06, j5, q07, q08, j6, i116, j7, q09, i119, q010, q011, z, z2, i21, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i67) ? null : F0.q0(i67)));
                c80 = i66;
                c81 = i67;
                c6 = i78;
                c8 = i82;
                c10 = i86;
                c12 = i90;
                c21 = i89;
                c18 = i2;
                c34 = i7;
                c42 = i115;
                c45 = i14;
                c49 = i121;
                c48 = i25;
                c50 = i31;
                c52 = i32;
                c59 = i35;
                c60 = i44;
                c61 = i45;
                c53 = i48;
                c54 = i49;
                c71 = i52;
                c70 = i55;
                c72 = i58;
                c69 = i61;
                c75 = i65;
                c76 = i124;
                c2 = i68;
                c3 = i69;
                c4 = i71;
                c5 = i73;
                c11 = i84;
                c13 = i88;
                c24 = i98;
                c26 = i102;
                c27 = i104;
                c29 = i108;
                c28 = i106;
                c36 = i113;
                c43 = i12;
                c46 = i16;
                c35 = i111;
                c19 = i81;
                c20 = i85;
                c74 = i56;
                c73 = i57;
                c14 = i94;
                c22 = i93;
                c23 = i96;
                c79 = i125;
                c7 = i76;
                c9 = i80;
                c15 = i92;
                c25 = i100;
                c51 = i22;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List J0(String str, y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        int i54;
        Integer valueOf8;
        int i55;
        int i56;
        int i57;
        Integer valueOf9;
        int i58;
        String q027;
        int i59;
        String q028;
        int i60;
        int i61;
        String q029;
        int i62;
        String q030;
        int i63;
        int i64;
        int i65;
        boolean z3;
        String q031;
        int i66;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ?  ORDER BY episode ASC ");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i67 = c3;
                int i68 = c4;
                int i69 = (int) F0.getLong(c13);
                int i70 = c5;
                int i71 = (int) F0.getLong(c14);
                int i72 = c6;
                int i73 = (int) F0.getLong(c15);
                int i74 = c16;
                long j2 = F0.getLong(i74);
                int i75 = c2;
                int i76 = c17;
                long j3 = F0.getLong(i76);
                c17 = i76;
                int i77 = c18;
                int i78 = c7;
                int i79 = (int) F0.getLong(i77);
                int i80 = c9;
                int i81 = c19;
                int i82 = c8;
                int i83 = (int) F0.getLong(i81);
                int i84 = c11;
                int i85 = c20;
                int i86 = c10;
                int i87 = (int) F0.getLong(i85);
                int i88 = c13;
                int i89 = c21;
                int i90 = c12;
                int i91 = (int) F0.getLong(i89);
                int i92 = c15;
                int i93 = c22;
                int i94 = c14;
                int i95 = (int) F0.getLong(i93);
                int i96 = c23;
                int i97 = (int) F0.getLong(i96);
                int i98 = c24;
                int i99 = (int) F0.getLong(i98);
                int i100 = c25;
                int i101 = (int) F0.getLong(i100);
                int i102 = c26;
                int i103 = (int) F0.getLong(i102);
                int i104 = c27;
                int i105 = (int) F0.getLong(i104);
                int i106 = c28;
                int i107 = (int) F0.getLong(i106);
                int i108 = c29;
                if (F0.isNull(i108)) {
                    i = i77;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i108);
                    i = i77;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i109 = c34;
                int i110 = (int) F0.getLong(i109);
                int i111 = c35;
                int i112 = (int) F0.getLong(i111);
                int i113 = c36;
                if (F0.isNull(i113)) {
                    i6 = i109;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i113);
                    i6 = i109;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i114 = c39;
                if (F0.isNull(i114)) {
                    c39 = i114;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i114);
                    c39 = i114;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i115 = c42;
                int i116 = (int) F0.getLong(i115);
                int i117 = c43;
                long j7 = F0.getLong(i117);
                int i118 = c44;
                if (F0.isNull(i118)) {
                    c44 = i118;
                    i11 = i117;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i117;
                    q09 = F0.q0(i118);
                    c44 = i118;
                    i12 = c45;
                }
                int i119 = (int) F0.getLong(i12);
                int i120 = c46;
                if (F0.isNull(i120)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i120);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i120;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i120;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i121 = i17;
                int i122 = (int) F0.getLong(i18);
                int i123 = c51;
                if (F0.isNull(i123)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i123);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i122;
                    i21 = i123;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i122;
                    i21 = i123;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i18;
                    i31 = i19;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i18;
                    i31 = i19;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i22;
                    i48 = i23;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i22;
                    i48 = i23;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = i50;
                    i55 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    i54 = i50;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i55 = c74;
                }
                if (F0.isNull(i55)) {
                    i56 = i52;
                    i57 = i53;
                    i58 = c75;
                    valueOf9 = null;
                } else {
                    i56 = i52;
                    i57 = i53;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i55));
                    i58 = c75;
                }
                if (F0.isNull(i58)) {
                    i59 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i58);
                    i59 = c76;
                }
                if (F0.isNull(i59)) {
                    i60 = i42;
                    i61 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i59);
                    i60 = i42;
                    i61 = c77;
                }
                if (F0.isNull(i61)) {
                    c77 = i61;
                    i62 = c78;
                    q029 = null;
                } else {
                    c77 = i61;
                    q029 = F0.q0(i61);
                    i62 = c78;
                }
                if (F0.isNull(i62)) {
                    c78 = i62;
                    i64 = i58;
                    i63 = c79;
                    q030 = null;
                } else {
                    c78 = i62;
                    q030 = F0.q0(i62);
                    i63 = c79;
                    i64 = i58;
                }
                int i124 = i59;
                if (((int) F0.getLong(i63)) != 0) {
                    i65 = c80;
                    z3 = true;
                } else {
                    i65 = c80;
                    z3 = false;
                }
                if (F0.isNull(i65)) {
                    i66 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i65);
                    i66 = c81;
                }
                int i125 = i63;
                arrayList.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i69, i71, i73, j2, j3, i79, i83, i87, i91, i95, i97, i99, i101, i103, i105, i107, q0, q02, q03, q04, j4, i110, i112, q05, q06, j5, q07, q08, j6, i116, j7, q09, i119, q010, q011, z, z2, i20, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i66) ? null : F0.q0(i66)));
                c2 = i75;
                c80 = i65;
                c81 = i66;
                c8 = i82;
                c10 = i86;
                c12 = i90;
                c21 = i89;
                c34 = i6;
                c42 = i115;
                c45 = i13;
                c49 = i121;
                c48 = i24;
                c50 = i30;
                c52 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c53 = i47;
                c54 = i48;
                c71 = i51;
                c70 = i54;
                c72 = i57;
                c69 = i60;
                c75 = i64;
                c76 = i124;
                c3 = i67;
                c4 = i68;
                c5 = i70;
                c6 = i72;
                c16 = i74;
                c11 = i84;
                c13 = i88;
                c24 = i98;
                c26 = i102;
                c27 = i104;
                c28 = i106;
                c36 = i113;
                c43 = i11;
                c46 = i15;
                c35 = i111;
                c19 = i81;
                c20 = i85;
                c74 = i55;
                c73 = i56;
                c7 = i78;
                c14 = i94;
                c22 = i93;
                c23 = i96;
                c18 = i;
                c79 = i125;
                c9 = i80;
                c15 = i92;
                c25 = i100;
                c29 = i108;
                c51 = i21;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List K0(String str, y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        int i54;
        Integer valueOf8;
        int i55;
        int i56;
        int i57;
        Integer valueOf9;
        int i58;
        String q027;
        int i59;
        String q028;
        int i60;
        int i61;
        String q029;
        int i62;
        String q030;
        int i63;
        int i64;
        int i65;
        boolean z3;
        String q031;
        int i66;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? AND status = 5  ORDER BY episode ASC ");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i67 = c3;
                int i68 = c4;
                int i69 = (int) F0.getLong(c13);
                int i70 = c5;
                int i71 = (int) F0.getLong(c14);
                int i72 = c6;
                int i73 = (int) F0.getLong(c15);
                int i74 = c16;
                long j2 = F0.getLong(i74);
                int i75 = c2;
                int i76 = c17;
                long j3 = F0.getLong(i76);
                c17 = i76;
                int i77 = c18;
                int i78 = c7;
                int i79 = (int) F0.getLong(i77);
                int i80 = c9;
                int i81 = c19;
                int i82 = c8;
                int i83 = (int) F0.getLong(i81);
                int i84 = c11;
                int i85 = c20;
                int i86 = c10;
                int i87 = (int) F0.getLong(i85);
                int i88 = c13;
                int i89 = c21;
                int i90 = c12;
                int i91 = (int) F0.getLong(i89);
                int i92 = c15;
                int i93 = c22;
                int i94 = c14;
                int i95 = (int) F0.getLong(i93);
                int i96 = c23;
                int i97 = (int) F0.getLong(i96);
                int i98 = c24;
                int i99 = (int) F0.getLong(i98);
                int i100 = c25;
                int i101 = (int) F0.getLong(i100);
                int i102 = c26;
                int i103 = (int) F0.getLong(i102);
                int i104 = c27;
                int i105 = (int) F0.getLong(i104);
                int i106 = c28;
                int i107 = (int) F0.getLong(i106);
                int i108 = c29;
                if (F0.isNull(i108)) {
                    i = i77;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i108);
                    i = i77;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i109 = c34;
                int i110 = (int) F0.getLong(i109);
                int i111 = c35;
                int i112 = (int) F0.getLong(i111);
                int i113 = c36;
                if (F0.isNull(i113)) {
                    i6 = i109;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i113);
                    i6 = i109;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i114 = c39;
                if (F0.isNull(i114)) {
                    c39 = i114;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i114);
                    c39 = i114;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i115 = c42;
                int i116 = (int) F0.getLong(i115);
                int i117 = c43;
                long j7 = F0.getLong(i117);
                int i118 = c44;
                if (F0.isNull(i118)) {
                    c44 = i118;
                    i11 = i117;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i117;
                    q09 = F0.q0(i118);
                    c44 = i118;
                    i12 = c45;
                }
                int i119 = (int) F0.getLong(i12);
                int i120 = c46;
                if (F0.isNull(i120)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i120);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i120;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i120;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i121 = i17;
                int i122 = (int) F0.getLong(i18);
                int i123 = c51;
                if (F0.isNull(i123)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i123);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i122;
                    i21 = i123;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i122;
                    i21 = i123;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i18;
                    i31 = i19;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i18;
                    i31 = i19;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i22;
                    i48 = i23;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i22;
                    i48 = i23;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = i50;
                    i55 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    i54 = i50;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i55 = c74;
                }
                if (F0.isNull(i55)) {
                    i56 = i52;
                    i57 = i53;
                    i58 = c75;
                    valueOf9 = null;
                } else {
                    i56 = i52;
                    i57 = i53;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i55));
                    i58 = c75;
                }
                if (F0.isNull(i58)) {
                    i59 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i58);
                    i59 = c76;
                }
                if (F0.isNull(i59)) {
                    i60 = i42;
                    i61 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i59);
                    i60 = i42;
                    i61 = c77;
                }
                if (F0.isNull(i61)) {
                    c77 = i61;
                    i62 = c78;
                    q029 = null;
                } else {
                    c77 = i61;
                    q029 = F0.q0(i61);
                    i62 = c78;
                }
                if (F0.isNull(i62)) {
                    c78 = i62;
                    i64 = i58;
                    i63 = c79;
                    q030 = null;
                } else {
                    c78 = i62;
                    q030 = F0.q0(i62);
                    i63 = c79;
                    i64 = i58;
                }
                int i124 = i59;
                if (((int) F0.getLong(i63)) != 0) {
                    i65 = c80;
                    z3 = true;
                } else {
                    i65 = c80;
                    z3 = false;
                }
                if (F0.isNull(i65)) {
                    i66 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i65);
                    i66 = c81;
                }
                int i125 = i63;
                arrayList.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i69, i71, i73, j2, j3, i79, i83, i87, i91, i95, i97, i99, i101, i103, i105, i107, q0, q02, q03, q04, j4, i110, i112, q05, q06, j5, q07, q08, j6, i116, j7, q09, i119, q010, q011, z, z2, i20, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i66) ? null : F0.q0(i66)));
                c2 = i75;
                c80 = i65;
                c81 = i66;
                c8 = i82;
                c10 = i86;
                c12 = i90;
                c21 = i89;
                c34 = i6;
                c42 = i115;
                c45 = i13;
                c49 = i121;
                c48 = i24;
                c50 = i30;
                c52 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c53 = i47;
                c54 = i48;
                c71 = i51;
                c70 = i54;
                c72 = i57;
                c69 = i60;
                c75 = i64;
                c76 = i124;
                c3 = i67;
                c4 = i68;
                c5 = i70;
                c6 = i72;
                c16 = i74;
                c11 = i84;
                c13 = i88;
                c24 = i98;
                c26 = i102;
                c27 = i104;
                c28 = i106;
                c36 = i113;
                c43 = i11;
                c46 = i15;
                c35 = i111;
                c19 = i81;
                c20 = i85;
                c74 = i55;
                c73 = i56;
                c7 = i78;
                c14 = i94;
                c22 = i93;
                c23 = i96;
                c18 = i;
                c79 = i125;
                c9 = i80;
                c15 = i92;
                c25 = i100;
                c29 = i108;
                c51 = i21;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean L0(String str, int i, int i2, y3.b bVar) {
        String q0;
        int i3;
        String q02;
        int i4;
        String q03;
        int i5;
        String q04;
        int i6;
        String q05;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        String q011;
        int i15;
        int i16;
        boolean z;
        int i17;
        boolean z2;
        String q012;
        int i18;
        int i19;
        Integer valueOf;
        int i20;
        String q013;
        int i21;
        String q014;
        int i22;
        String q015;
        int i23;
        String q016;
        int i24;
        String q017;
        int i25;
        String q018;
        int i26;
        Integer valueOf2;
        int i27;
        String q019;
        int i28;
        String q020;
        int i29;
        Long valueOf3;
        int i30;
        Long valueOf4;
        int i31;
        String q021;
        int i32;
        String q022;
        int i33;
        String q023;
        int i34;
        String q024;
        int i35;
        String q025;
        int i36;
        Integer valueOf5;
        int i37;
        String q026;
        int i38;
        Integer valueOf6;
        int i39;
        Integer valueOf7;
        int i40;
        Integer valueOf8;
        int i41;
        Integer valueOf9;
        int i42;
        String q027;
        int i43;
        String q028;
        int i44;
        String q029;
        int i45;
        String q030;
        int i46;
        int i47;
        boolean z3;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ?  AND se =? AND ep =? ORDER BY resolution DESC LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.c(2, i);
            F0.c(3, i2);
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            DownloadBean downloadBean = null;
            if (F0.C0()) {
                String q031 = F0.isNull(c2) ? null : F0.q0(c2);
                String q032 = F0.isNull(c3) ? null : F0.q0(c3);
                String q033 = F0.isNull(c4) ? null : F0.q0(c4);
                String q034 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q035 = F0.isNull(c7) ? null : F0.q0(c7);
                String q036 = F0.isNull(c8) ? null : F0.q0(c8);
                String q037 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i48 = (int) F0.getLong(c13);
                int i49 = (int) F0.getLong(c14);
                int i50 = (int) F0.getLong(c15);
                long j2 = F0.getLong(c16);
                long j3 = F0.getLong(c17);
                int i51 = (int) F0.getLong(c18);
                int i52 = (int) F0.getLong(c19);
                int i53 = (int) F0.getLong(c20);
                int i54 = (int) F0.getLong(c21);
                int i55 = (int) F0.getLong(c22);
                int i56 = (int) F0.getLong(c23);
                int i57 = (int) F0.getLong(c24);
                int i58 = (int) F0.getLong(c25);
                int i59 = (int) F0.getLong(c26);
                int i60 = (int) F0.getLong(c27);
                int i61 = (int) F0.getLong(c28);
                if (F0.isNull(c29)) {
                    i3 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(c29);
                    i3 = c30;
                }
                if (F0.isNull(i3)) {
                    i4 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c31;
                }
                if (F0.isNull(i4)) {
                    i5 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i4);
                    i5 = c32;
                }
                if (F0.isNull(i5)) {
                    i6 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i5);
                    i6 = c33;
                }
                long j4 = F0.getLong(i6);
                int i62 = (int) F0.getLong(c34);
                int i63 = (int) F0.getLong(c35);
                if (F0.isNull(c36)) {
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(c36);
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                if (F0.isNull(c39)) {
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(c39);
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                int i64 = (int) F0.getLong(c42);
                long j7 = F0.getLong(c43);
                if (F0.isNull(c44)) {
                    i11 = i64;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i64;
                    q09 = F0.q0(c44);
                    i12 = c45;
                }
                int i65 = (int) F0.getLong(i12);
                if (F0.isNull(c46)) {
                    i13 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(c46);
                    i13 = c47;
                }
                if (F0.isNull(i13)) {
                    i14 = i65;
                    i15 = c48;
                    q011 = null;
                } else {
                    i14 = i65;
                    q011 = F0.q0(i13);
                    i15 = c48;
                }
                if (((int) F0.getLong(i15)) != 0) {
                    i16 = c49;
                    z = true;
                } else {
                    i16 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c50;
                    z2 = true;
                } else {
                    i17 = c50;
                    z2 = false;
                }
                int i66 = (int) F0.getLong(i17);
                if (F0.isNull(c51)) {
                    i18 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(c51);
                    i18 = c52;
                }
                if (F0.isNull(i18)) {
                    i19 = i66;
                    i20 = c53;
                    valueOf = null;
                } else {
                    i19 = i66;
                    valueOf = Integer.valueOf((int) F0.getLong(i18));
                    i20 = c53;
                }
                if (F0.isNull(i20)) {
                    i21 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i20);
                    i21 = c54;
                }
                if (F0.isNull(i21)) {
                    i22 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i21);
                    i22 = c55;
                }
                if (F0.isNull(i22)) {
                    i23 = c56;
                    q015 = null;
                } else {
                    q015 = F0.q0(i22);
                    i23 = c56;
                }
                if (F0.isNull(i23)) {
                    i24 = c57;
                    q016 = null;
                } else {
                    q016 = F0.q0(i23);
                    i24 = c57;
                }
                if (F0.isNull(i24)) {
                    i25 = c58;
                    q017 = null;
                } else {
                    q017 = F0.q0(i24);
                    i25 = c58;
                }
                if (F0.isNull(i25)) {
                    i26 = c59;
                    q018 = null;
                } else {
                    q018 = F0.q0(i25);
                    i26 = c59;
                }
                if (F0.isNull(i26)) {
                    i27 = c60;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) F0.getLong(i26));
                    i27 = c60;
                }
                if (F0.isNull(i27)) {
                    i28 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i27);
                    i28 = c61;
                }
                if (F0.isNull(i28)) {
                    i29 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i28);
                    i29 = c62;
                }
                if (F0.isNull(i29)) {
                    i30 = c63;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(F0.getLong(i29));
                    i30 = c63;
                }
                if (F0.isNull(i30)) {
                    i31 = c64;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(i30));
                    i31 = c64;
                }
                if (F0.isNull(i31)) {
                    i32 = c65;
                    q021 = null;
                } else {
                    q021 = F0.q0(i31);
                    i32 = c65;
                }
                if (F0.isNull(i32)) {
                    i33 = c66;
                    q022 = null;
                } else {
                    q022 = F0.q0(i32);
                    i33 = c66;
                }
                if (F0.isNull(i33)) {
                    i34 = c67;
                    q023 = null;
                } else {
                    q023 = F0.q0(i33);
                    i34 = c67;
                }
                if (F0.isNull(i34)) {
                    i35 = c68;
                    q024 = null;
                } else {
                    q024 = F0.q0(i34);
                    i35 = c68;
                }
                if (F0.isNull(i35)) {
                    i36 = c69;
                    q025 = null;
                } else {
                    q025 = F0.q0(i35);
                    i36 = c69;
                }
                if (F0.isNull(i36)) {
                    i37 = c70;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) F0.getLong(i36));
                    i37 = c70;
                }
                if (F0.isNull(i37)) {
                    i38 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i37);
                    i38 = c71;
                }
                if (F0.isNull(i38)) {
                    i39 = c72;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) F0.getLong(i38));
                    i39 = c72;
                }
                if (F0.isNull(i39)) {
                    i40 = c73;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) F0.getLong(i39));
                    i40 = c73;
                }
                if (F0.isNull(i40)) {
                    i41 = c74;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) F0.getLong(i40));
                    i41 = c74;
                }
                if (F0.isNull(i41)) {
                    i42 = c75;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) F0.getLong(i41));
                    i42 = c75;
                }
                if (F0.isNull(i42)) {
                    i43 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i42);
                    i43 = c76;
                }
                if (F0.isNull(i43)) {
                    i44 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i43);
                    i44 = c77;
                }
                if (F0.isNull(i44)) {
                    i45 = c78;
                    q029 = null;
                } else {
                    q029 = F0.q0(i44);
                    i45 = c78;
                }
                if (F0.isNull(i45)) {
                    i46 = c79;
                    q030 = null;
                } else {
                    q030 = F0.q0(i45);
                    i46 = c79;
                }
                if (((int) F0.getLong(i46)) != 0) {
                    i47 = c80;
                    z3 = true;
                } else {
                    i47 = c80;
                    z3 = false;
                }
                downloadBean = new DownloadBean(q031, q032, q033, q034, valueOf10, q035, q036, q037, valueOf11, valueOf12, j, i48, i49, i50, j2, j3, i51, i52, i53, i54, i55, i56, i57, i58, i59, i60, i61, q0, q02, q03, q04, j4, i62, i63, q05, q06, j5, q07, q08, j6, i11, j7, q09, i14, q010, q011, z, z2, i19, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, F0.isNull(i47) ? null : F0.q0(i47), F0.isNull(c81) ? null : F0.q0(c81));
            }
            F0.close();
            return downloadBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List M0(y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        Integer valueOf8;
        int i54;
        int i55;
        Integer valueOf9;
        int i56;
        String q027;
        int i57;
        String q028;
        int i58;
        int i59;
        String q029;
        int i60;
        String q030;
        int i61;
        int i62;
        int i63;
        boolean z3;
        String q031;
        int i64;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE fileType == 1");
        try {
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i65 = c3;
                int i66 = c4;
                int i67 = (int) F0.getLong(c13);
                int i68 = c5;
                int i69 = (int) F0.getLong(c14);
                int i70 = c6;
                int i71 = (int) F0.getLong(c15);
                int i72 = c16;
                long j2 = F0.getLong(i72);
                int i73 = c2;
                int i74 = c17;
                long j3 = F0.getLong(i74);
                c17 = i74;
                int i75 = c18;
                int i76 = c7;
                int i77 = (int) F0.getLong(i75);
                int i78 = c9;
                int i79 = c19;
                int i80 = c8;
                int i81 = (int) F0.getLong(i79);
                int i82 = c11;
                int i83 = c20;
                int i84 = c10;
                int i85 = (int) F0.getLong(i83);
                int i86 = c13;
                int i87 = c21;
                int i88 = c12;
                int i89 = (int) F0.getLong(i87);
                int i90 = c15;
                int i91 = c22;
                int i92 = c14;
                int i93 = (int) F0.getLong(i91);
                int i94 = c23;
                int i95 = (int) F0.getLong(i94);
                int i96 = c24;
                ArrayList arrayList2 = arrayList;
                int i97 = (int) F0.getLong(i96);
                int i98 = c25;
                int i99 = (int) F0.getLong(i98);
                int i100 = c26;
                int i101 = (int) F0.getLong(i100);
                int i102 = c27;
                int i103 = (int) F0.getLong(i102);
                int i104 = c28;
                int i105 = (int) F0.getLong(i104);
                int i106 = c29;
                if (F0.isNull(i106)) {
                    i = i75;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i106);
                    i = i75;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i107 = c34;
                int i108 = (int) F0.getLong(i107);
                int i109 = c35;
                int i110 = (int) F0.getLong(i109);
                int i111 = c36;
                if (F0.isNull(i111)) {
                    i6 = i107;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i111);
                    i6 = i107;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i112 = c39;
                if (F0.isNull(i112)) {
                    c39 = i112;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i112);
                    c39 = i112;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i113 = c42;
                int i114 = (int) F0.getLong(i113);
                int i115 = c43;
                long j7 = F0.getLong(i115);
                int i116 = c44;
                if (F0.isNull(i116)) {
                    c44 = i116;
                    i11 = i115;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i115;
                    q09 = F0.q0(i116);
                    c44 = i116;
                    i12 = c45;
                }
                int i117 = (int) F0.getLong(i12);
                int i118 = c46;
                if (F0.isNull(i118)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i118);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i118;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i118;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i119 = i17;
                int i120 = (int) F0.getLong(i18);
                int i121 = c51;
                if (F0.isNull(i121)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i121);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i18;
                    i21 = i120;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i18;
                    i21 = i120;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i22;
                    i31 = i23;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i22;
                    i31 = i23;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i121;
                    i48 = i19;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i121;
                    i48 = i19;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i54 = c74;
                }
                if (F0.isNull(i54)) {
                    i55 = i50;
                    i56 = c75;
                    valueOf9 = null;
                } else {
                    i55 = i50;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i54));
                    i56 = c75;
                }
                if (F0.isNull(i56)) {
                    i57 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i56);
                    i57 = c76;
                }
                if (F0.isNull(i57)) {
                    i58 = i42;
                    i59 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i57);
                    i58 = i42;
                    i59 = c77;
                }
                if (F0.isNull(i59)) {
                    c77 = i59;
                    i60 = c78;
                    q029 = null;
                } else {
                    c77 = i59;
                    q029 = F0.q0(i59);
                    i60 = c78;
                }
                if (F0.isNull(i60)) {
                    c78 = i60;
                    i62 = i52;
                    i61 = c79;
                    q030 = null;
                } else {
                    c78 = i60;
                    q030 = F0.q0(i60);
                    i61 = c79;
                    i62 = i52;
                }
                int i122 = i54;
                if (((int) F0.getLong(i61)) != 0) {
                    i63 = c80;
                    z3 = true;
                } else {
                    i63 = c80;
                    z3 = false;
                }
                if (F0.isNull(i63)) {
                    i64 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i63);
                    i64 = c81;
                }
                int i123 = i61;
                arrayList2.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i67, i69, i71, j2, j3, i77, i81, i85, i89, i93, i95, i97, i99, i101, i103, i105, q0, q02, q03, q04, j4, i108, i110, q05, q06, j5, q07, q08, j6, i114, j7, q09, i117, q010, q011, z, z2, i21, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i64) ? null : F0.q0(i64)));
                c2 = i73;
                c80 = i63;
                c81 = i64;
                c8 = i80;
                c10 = i84;
                c12 = i88;
                c14 = i92;
                c22 = i91;
                c24 = i96;
                c25 = i98;
                c27 = i102;
                c28 = i104;
                c34 = i6;
                c35 = i109;
                c42 = i113;
                c45 = i13;
                c49 = i119;
                c50 = i20;
                c48 = i24;
                c53 = i30;
                c54 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c52 = i48;
                c71 = i51;
                c72 = i53;
                c69 = i58;
                c73 = i62;
                c4 = i66;
                c5 = i68;
                c6 = i70;
                c16 = i72;
                c13 = i86;
                c23 = i94;
                c26 = i100;
                c36 = i111;
                c43 = i11;
                c46 = i15;
                c19 = i79;
                c20 = i83;
                c21 = i87;
                c75 = i56;
                c76 = i57;
                c7 = i76;
                c18 = i;
                c9 = i78;
                c11 = i82;
                c15 = i90;
                c29 = i106;
                arrayList = arrayList2;
                c3 = i65;
                c79 = i123;
                c51 = i47;
                c70 = i55;
                c74 = i122;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List N0(y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        Integer valueOf8;
        int i54;
        int i55;
        Integer valueOf9;
        int i56;
        String q027;
        int i57;
        String q028;
        int i58;
        int i59;
        String q029;
        int i60;
        String q030;
        int i61;
        int i62;
        int i63;
        boolean z3;
        String q031;
        int i64;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE fileType = 3 ORDER BY updateTimeStamp DESC ");
        try {
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i65 = c3;
                int i66 = c4;
                int i67 = (int) F0.getLong(c13);
                int i68 = c5;
                int i69 = (int) F0.getLong(c14);
                int i70 = c6;
                int i71 = (int) F0.getLong(c15);
                int i72 = c16;
                long j2 = F0.getLong(i72);
                int i73 = c2;
                int i74 = c17;
                long j3 = F0.getLong(i74);
                c17 = i74;
                int i75 = c18;
                int i76 = c7;
                int i77 = (int) F0.getLong(i75);
                int i78 = c9;
                int i79 = c19;
                int i80 = c8;
                int i81 = (int) F0.getLong(i79);
                int i82 = c11;
                int i83 = c20;
                int i84 = c10;
                int i85 = (int) F0.getLong(i83);
                int i86 = c13;
                int i87 = c21;
                int i88 = c12;
                int i89 = (int) F0.getLong(i87);
                int i90 = c15;
                int i91 = c22;
                int i92 = c14;
                int i93 = (int) F0.getLong(i91);
                int i94 = c23;
                int i95 = (int) F0.getLong(i94);
                int i96 = c24;
                ArrayList arrayList2 = arrayList;
                int i97 = (int) F0.getLong(i96);
                int i98 = c25;
                int i99 = (int) F0.getLong(i98);
                int i100 = c26;
                int i101 = (int) F0.getLong(i100);
                int i102 = c27;
                int i103 = (int) F0.getLong(i102);
                int i104 = c28;
                int i105 = (int) F0.getLong(i104);
                int i106 = c29;
                if (F0.isNull(i106)) {
                    i = i75;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i106);
                    i = i75;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i107 = c34;
                int i108 = (int) F0.getLong(i107);
                int i109 = c35;
                int i110 = (int) F0.getLong(i109);
                int i111 = c36;
                if (F0.isNull(i111)) {
                    i6 = i107;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i111);
                    i6 = i107;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i112 = c39;
                if (F0.isNull(i112)) {
                    c39 = i112;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i112);
                    c39 = i112;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i113 = c42;
                int i114 = (int) F0.getLong(i113);
                int i115 = c43;
                long j7 = F0.getLong(i115);
                int i116 = c44;
                if (F0.isNull(i116)) {
                    c44 = i116;
                    i11 = i115;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i115;
                    q09 = F0.q0(i116);
                    c44 = i116;
                    i12 = c45;
                }
                int i117 = (int) F0.getLong(i12);
                int i118 = c46;
                if (F0.isNull(i118)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i118);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i118;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i118;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i119 = i17;
                int i120 = (int) F0.getLong(i18);
                int i121 = c51;
                if (F0.isNull(i121)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i121);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i18;
                    i21 = i120;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i18;
                    i21 = i120;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i22;
                    i31 = i23;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i22;
                    i31 = i23;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i121;
                    i48 = i19;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i121;
                    i48 = i19;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i54 = c74;
                }
                if (F0.isNull(i54)) {
                    i55 = i50;
                    i56 = c75;
                    valueOf9 = null;
                } else {
                    i55 = i50;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i54));
                    i56 = c75;
                }
                if (F0.isNull(i56)) {
                    i57 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i56);
                    i57 = c76;
                }
                if (F0.isNull(i57)) {
                    i58 = i42;
                    i59 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i57);
                    i58 = i42;
                    i59 = c77;
                }
                if (F0.isNull(i59)) {
                    c77 = i59;
                    i60 = c78;
                    q029 = null;
                } else {
                    c77 = i59;
                    q029 = F0.q0(i59);
                    i60 = c78;
                }
                if (F0.isNull(i60)) {
                    c78 = i60;
                    i62 = i52;
                    i61 = c79;
                    q030 = null;
                } else {
                    c78 = i60;
                    q030 = F0.q0(i60);
                    i61 = c79;
                    i62 = i52;
                }
                int i122 = i54;
                if (((int) F0.getLong(i61)) != 0) {
                    i63 = c80;
                    z3 = true;
                } else {
                    i63 = c80;
                    z3 = false;
                }
                if (F0.isNull(i63)) {
                    i64 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i63);
                    i64 = c81;
                }
                int i123 = i61;
                arrayList2.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i67, i69, i71, j2, j3, i77, i81, i85, i89, i93, i95, i97, i99, i101, i103, i105, q0, q02, q03, q04, j4, i108, i110, q05, q06, j5, q07, q08, j6, i114, j7, q09, i117, q010, q011, z, z2, i21, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i64) ? null : F0.q0(i64)));
                c2 = i73;
                c80 = i63;
                c81 = i64;
                c8 = i80;
                c10 = i84;
                c12 = i88;
                c14 = i92;
                c22 = i91;
                c24 = i96;
                c25 = i98;
                c27 = i102;
                c28 = i104;
                c34 = i6;
                c35 = i109;
                c42 = i113;
                c45 = i13;
                c49 = i119;
                c50 = i20;
                c48 = i24;
                c53 = i30;
                c54 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c52 = i48;
                c71 = i51;
                c72 = i53;
                c69 = i58;
                c73 = i62;
                c4 = i66;
                c5 = i68;
                c6 = i70;
                c16 = i72;
                c13 = i86;
                c23 = i94;
                c26 = i100;
                c36 = i111;
                c43 = i11;
                c46 = i15;
                c19 = i79;
                c20 = i83;
                c21 = i87;
                c75 = i56;
                c76 = i57;
                c7 = i76;
                c18 = i;
                c9 = i78;
                c11 = i82;
                c15 = i90;
                c29 = i106;
                arrayList = arrayList2;
                c3 = i65;
                c79 = i123;
                c51 = i47;
                c70 = i55;
                c74 = i122;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List O0(String str, y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        int i54;
        Integer valueOf8;
        int i55;
        int i56;
        int i57;
        Integer valueOf9;
        int i58;
        String q027;
        int i59;
        String q028;
        int i60;
        int i61;
        String q029;
        int i62;
        String q030;
        int i63;
        int i64;
        int i65;
        boolean z3;
        String q031;
        int i66;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE ugcVideoCollectionId = ? ORDER BY ugcVideoPosition ASC");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i67 = c3;
                int i68 = c4;
                int i69 = (int) F0.getLong(c13);
                int i70 = c5;
                int i71 = (int) F0.getLong(c14);
                int i72 = c6;
                int i73 = (int) F0.getLong(c15);
                int i74 = c16;
                long j2 = F0.getLong(i74);
                int i75 = c2;
                int i76 = c17;
                long j3 = F0.getLong(i76);
                c17 = i76;
                int i77 = c18;
                int i78 = c7;
                int i79 = (int) F0.getLong(i77);
                int i80 = c9;
                int i81 = c19;
                int i82 = c8;
                int i83 = (int) F0.getLong(i81);
                int i84 = c11;
                int i85 = c20;
                int i86 = c10;
                int i87 = (int) F0.getLong(i85);
                int i88 = c13;
                int i89 = c21;
                int i90 = c12;
                int i91 = (int) F0.getLong(i89);
                int i92 = c15;
                int i93 = c22;
                int i94 = c14;
                int i95 = (int) F0.getLong(i93);
                int i96 = c23;
                int i97 = (int) F0.getLong(i96);
                int i98 = c24;
                int i99 = (int) F0.getLong(i98);
                int i100 = c25;
                int i101 = (int) F0.getLong(i100);
                int i102 = c26;
                int i103 = (int) F0.getLong(i102);
                int i104 = c27;
                int i105 = (int) F0.getLong(i104);
                int i106 = c28;
                int i107 = (int) F0.getLong(i106);
                int i108 = c29;
                if (F0.isNull(i108)) {
                    i = i77;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i108);
                    i = i77;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i109 = c34;
                int i110 = (int) F0.getLong(i109);
                int i111 = c35;
                int i112 = (int) F0.getLong(i111);
                int i113 = c36;
                if (F0.isNull(i113)) {
                    i6 = i109;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i113);
                    i6 = i109;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i114 = c39;
                if (F0.isNull(i114)) {
                    c39 = i114;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i114);
                    c39 = i114;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i115 = c42;
                int i116 = (int) F0.getLong(i115);
                int i117 = c43;
                long j7 = F0.getLong(i117);
                int i118 = c44;
                if (F0.isNull(i118)) {
                    c44 = i118;
                    i11 = i117;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i117;
                    q09 = F0.q0(i118);
                    c44 = i118;
                    i12 = c45;
                }
                int i119 = (int) F0.getLong(i12);
                int i120 = c46;
                if (F0.isNull(i120)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i120);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i120;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i120;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i121 = i17;
                int i122 = (int) F0.getLong(i18);
                int i123 = c51;
                if (F0.isNull(i123)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i123);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i122;
                    i21 = i123;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i122;
                    i21 = i123;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i18;
                    i31 = i19;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i18;
                    i31 = i19;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i22;
                    i48 = i23;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i22;
                    i48 = i23;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = i50;
                    i55 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    i54 = i50;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i55 = c74;
                }
                if (F0.isNull(i55)) {
                    i56 = i52;
                    i57 = i53;
                    i58 = c75;
                    valueOf9 = null;
                } else {
                    i56 = i52;
                    i57 = i53;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i55));
                    i58 = c75;
                }
                if (F0.isNull(i58)) {
                    i59 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i58);
                    i59 = c76;
                }
                if (F0.isNull(i59)) {
                    i60 = i42;
                    i61 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i59);
                    i60 = i42;
                    i61 = c77;
                }
                if (F0.isNull(i61)) {
                    c77 = i61;
                    i62 = c78;
                    q029 = null;
                } else {
                    c77 = i61;
                    q029 = F0.q0(i61);
                    i62 = c78;
                }
                if (F0.isNull(i62)) {
                    c78 = i62;
                    i64 = i58;
                    i63 = c79;
                    q030 = null;
                } else {
                    c78 = i62;
                    q030 = F0.q0(i62);
                    i63 = c79;
                    i64 = i58;
                }
                int i124 = i59;
                if (((int) F0.getLong(i63)) != 0) {
                    i65 = c80;
                    z3 = true;
                } else {
                    i65 = c80;
                    z3 = false;
                }
                if (F0.isNull(i65)) {
                    i66 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i65);
                    i66 = c81;
                }
                int i125 = i63;
                arrayList.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i69, i71, i73, j2, j3, i79, i83, i87, i91, i95, i97, i99, i101, i103, i105, i107, q0, q02, q03, q04, j4, i110, i112, q05, q06, j5, q07, q08, j6, i116, j7, q09, i119, q010, q011, z, z2, i20, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i66) ? null : F0.q0(i66)));
                c2 = i75;
                c80 = i65;
                c81 = i66;
                c8 = i82;
                c10 = i86;
                c12 = i90;
                c21 = i89;
                c34 = i6;
                c42 = i115;
                c45 = i13;
                c49 = i121;
                c48 = i24;
                c50 = i30;
                c52 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c53 = i47;
                c54 = i48;
                c71 = i51;
                c70 = i54;
                c72 = i57;
                c69 = i60;
                c75 = i64;
                c76 = i124;
                c3 = i67;
                c4 = i68;
                c5 = i70;
                c6 = i72;
                c16 = i74;
                c11 = i84;
                c13 = i88;
                c24 = i98;
                c26 = i102;
                c27 = i104;
                c28 = i106;
                c36 = i113;
                c43 = i11;
                c46 = i15;
                c35 = i111;
                c19 = i81;
                c20 = i85;
                c74 = i55;
                c73 = i56;
                c7 = i78;
                c14 = i94;
                c22 = i93;
                c23 = i96;
                c18 = i;
                c79 = i125;
                c9 = i80;
                c15 = i92;
                c25 = i100;
                c29 = i108;
                c51 = i21;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean P0(String str, y3.b bVar) {
        String q0;
        int i;
        String q02;
        int i2;
        String q03;
        int i3;
        String q04;
        int i4;
        String q05;
        int i5;
        String q06;
        int i6;
        String q07;
        int i7;
        String q08;
        int i8;
        int i9;
        String q09;
        int i10;
        String q010;
        int i11;
        int i12;
        String q011;
        int i13;
        int i14;
        boolean z;
        int i15;
        boolean z2;
        String q012;
        int i16;
        int i17;
        Integer valueOf;
        int i18;
        String q013;
        int i19;
        String q014;
        int i20;
        String q015;
        int i21;
        String q016;
        int i22;
        String q017;
        int i23;
        String q018;
        int i24;
        Integer valueOf2;
        int i25;
        String q019;
        int i26;
        String q020;
        int i27;
        Long valueOf3;
        int i28;
        Long valueOf4;
        int i29;
        String q021;
        int i30;
        String q022;
        int i31;
        String q023;
        int i32;
        String q024;
        int i33;
        String q025;
        int i34;
        Integer valueOf5;
        int i35;
        String q026;
        int i36;
        Integer valueOf6;
        int i37;
        Integer valueOf7;
        int i38;
        Integer valueOf8;
        int i39;
        Integer valueOf9;
        int i40;
        String q027;
        int i41;
        String q028;
        int i42;
        String q029;
        int i43;
        String q030;
        int i44;
        int i45;
        boolean z3;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE ugcVideoId = ?  ORDER BY resolution DESC LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            DownloadBean downloadBean = null;
            if (F0.C0()) {
                String q031 = F0.isNull(c2) ? null : F0.q0(c2);
                String q032 = F0.isNull(c3) ? null : F0.q0(c3);
                String q033 = F0.isNull(c4) ? null : F0.q0(c4);
                String q034 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q035 = F0.isNull(c7) ? null : F0.q0(c7);
                String q036 = F0.isNull(c8) ? null : F0.q0(c8);
                String q037 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i46 = (int) F0.getLong(c13);
                int i47 = (int) F0.getLong(c14);
                int i48 = (int) F0.getLong(c15);
                long j2 = F0.getLong(c16);
                long j3 = F0.getLong(c17);
                int i49 = (int) F0.getLong(c18);
                int i50 = (int) F0.getLong(c19);
                int i51 = (int) F0.getLong(c20);
                int i52 = (int) F0.getLong(c21);
                int i53 = (int) F0.getLong(c22);
                int i54 = (int) F0.getLong(c23);
                int i55 = (int) F0.getLong(c24);
                int i56 = (int) F0.getLong(c25);
                int i57 = (int) F0.getLong(c26);
                int i58 = (int) F0.getLong(c27);
                int i59 = (int) F0.getLong(c28);
                if (F0.isNull(c29)) {
                    i = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(c29);
                    i = c30;
                }
                if (F0.isNull(i)) {
                    i2 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i);
                    i2 = c31;
                }
                if (F0.isNull(i2)) {
                    i3 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i2);
                    i3 = c32;
                }
                if (F0.isNull(i3)) {
                    i4 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i3);
                    i4 = c33;
                }
                long j4 = F0.getLong(i4);
                int i60 = (int) F0.getLong(c34);
                int i61 = (int) F0.getLong(c35);
                if (F0.isNull(c36)) {
                    i5 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(c36);
                    i5 = c37;
                }
                if (F0.isNull(i5)) {
                    i6 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i5);
                    i6 = c38;
                }
                long j5 = F0.getLong(i6);
                if (F0.isNull(c39)) {
                    i7 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(c39);
                    i7 = c40;
                }
                if (F0.isNull(i7)) {
                    i8 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i7);
                    i8 = c41;
                }
                long j6 = F0.getLong(i8);
                int i62 = (int) F0.getLong(c42);
                long j7 = F0.getLong(c43);
                if (F0.isNull(c44)) {
                    i9 = i62;
                    i10 = c45;
                    q09 = null;
                } else {
                    i9 = i62;
                    q09 = F0.q0(c44);
                    i10 = c45;
                }
                int i63 = (int) F0.getLong(i10);
                if (F0.isNull(c46)) {
                    i11 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(c46);
                    i11 = c47;
                }
                if (F0.isNull(i11)) {
                    i12 = i63;
                    i13 = c48;
                    q011 = null;
                } else {
                    i12 = i63;
                    q011 = F0.q0(i11);
                    i13 = c48;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c49;
                    z = true;
                } else {
                    i14 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c50;
                    z2 = true;
                } else {
                    i15 = c50;
                    z2 = false;
                }
                int i64 = (int) F0.getLong(i15);
                if (F0.isNull(c51)) {
                    i16 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(c51);
                    i16 = c52;
                }
                if (F0.isNull(i16)) {
                    i17 = i64;
                    i18 = c53;
                    valueOf = null;
                } else {
                    i17 = i64;
                    valueOf = Integer.valueOf((int) F0.getLong(i16));
                    i18 = c53;
                }
                if (F0.isNull(i18)) {
                    i19 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i18);
                    i19 = c54;
                }
                if (F0.isNull(i19)) {
                    i20 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i19);
                    i20 = c55;
                }
                if (F0.isNull(i20)) {
                    i21 = c56;
                    q015 = null;
                } else {
                    q015 = F0.q0(i20);
                    i21 = c56;
                }
                if (F0.isNull(i21)) {
                    i22 = c57;
                    q016 = null;
                } else {
                    q016 = F0.q0(i21);
                    i22 = c57;
                }
                if (F0.isNull(i22)) {
                    i23 = c58;
                    q017 = null;
                } else {
                    q017 = F0.q0(i22);
                    i23 = c58;
                }
                if (F0.isNull(i23)) {
                    i24 = c59;
                    q018 = null;
                } else {
                    q018 = F0.q0(i23);
                    i24 = c59;
                }
                if (F0.isNull(i24)) {
                    i25 = c60;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) F0.getLong(i24));
                    i25 = c60;
                }
                if (F0.isNull(i25)) {
                    i26 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i25);
                    i26 = c61;
                }
                if (F0.isNull(i26)) {
                    i27 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i26);
                    i27 = c62;
                }
                if (F0.isNull(i27)) {
                    i28 = c63;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(F0.getLong(i27));
                    i28 = c63;
                }
                if (F0.isNull(i28)) {
                    i29 = c64;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(i28));
                    i29 = c64;
                }
                if (F0.isNull(i29)) {
                    i30 = c65;
                    q021 = null;
                } else {
                    q021 = F0.q0(i29);
                    i30 = c65;
                }
                if (F0.isNull(i30)) {
                    i31 = c66;
                    q022 = null;
                } else {
                    q022 = F0.q0(i30);
                    i31 = c66;
                }
                if (F0.isNull(i31)) {
                    i32 = c67;
                    q023 = null;
                } else {
                    q023 = F0.q0(i31);
                    i32 = c67;
                }
                if (F0.isNull(i32)) {
                    i33 = c68;
                    q024 = null;
                } else {
                    q024 = F0.q0(i32);
                    i33 = c68;
                }
                if (F0.isNull(i33)) {
                    i34 = c69;
                    q025 = null;
                } else {
                    q025 = F0.q0(i33);
                    i34 = c69;
                }
                if (F0.isNull(i34)) {
                    i35 = c70;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) F0.getLong(i34));
                    i35 = c70;
                }
                if (F0.isNull(i35)) {
                    i36 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i35);
                    i36 = c71;
                }
                if (F0.isNull(i36)) {
                    i37 = c72;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) F0.getLong(i36));
                    i37 = c72;
                }
                if (F0.isNull(i37)) {
                    i38 = c73;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) F0.getLong(i37));
                    i38 = c73;
                }
                if (F0.isNull(i38)) {
                    i39 = c74;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) F0.getLong(i38));
                    i39 = c74;
                }
                if (F0.isNull(i39)) {
                    i40 = c75;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) F0.getLong(i39));
                    i40 = c75;
                }
                if (F0.isNull(i40)) {
                    i41 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i40);
                    i41 = c76;
                }
                if (F0.isNull(i41)) {
                    i42 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i41);
                    i42 = c77;
                }
                if (F0.isNull(i42)) {
                    i43 = c78;
                    q029 = null;
                } else {
                    q029 = F0.q0(i42);
                    i43 = c78;
                }
                if (F0.isNull(i43)) {
                    i44 = c79;
                    q030 = null;
                } else {
                    q030 = F0.q0(i43);
                    i44 = c79;
                }
                if (((int) F0.getLong(i44)) != 0) {
                    i45 = c80;
                    z3 = true;
                } else {
                    i45 = c80;
                    z3 = false;
                }
                downloadBean = new DownloadBean(q031, q032, q033, q034, valueOf10, q035, q036, q037, valueOf11, valueOf12, j, i46, i47, i48, j2, j3, i49, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, q0, q02, q03, q04, j4, i60, i61, q05, q06, j5, q07, q08, j6, i9, j7, q09, i12, q010, q011, z, z2, i17, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, F0.isNull(i45) ? null : F0.q0(i45), F0.isNull(c81) ? null : F0.q0(c81));
            }
            F0.close();
            return downloadBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Q0(DownloadBean downloadBean, y3.b bVar) {
        this.b.d(bVar, downloadBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit R0(DownloadBean downloadBean, y3.b bVar) {
        this.d.c(bVar, downloadBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit S0(long j, String str, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE DOWNLOAD_TABLE SET duration = ? WHERE resourceId = ? ");
        try {
            F0.c(1, j);
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit T0(long j, String str, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE DOWNLOAD_TABLE SET lastPlayTimeStamp = ? WHERE resourceId = ? ");
        try {
            F0.c(1, j);
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit U0(long j, String str, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE DOWNLOAD_TABLE SET readProgress = ? WHERE resourceId = ? ");
        try {
            F0.c(1, j);
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit V0(int i, String str, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE DOWNLOAD_TABLE SET status = ? WHERE resourceId = ? ");
        try {
            F0.c(1, i);
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit W0(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE DOWNLOAD_TABLE SET restrictLevel = ?, releaseDate = ?, countryName = ?, subtitles = ?, seNum = ?, genre = ?, imdbRate = ? WHERE resourceId = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            if (str2 == null) {
                F0.g(2);
            } else {
                F0.i(2, str2);
            }
            if (str3 == null) {
                F0.g(3);
            } else {
                F0.i(3, str3);
            }
            if (str4 == null) {
                F0.g(4);
            } else {
                F0.i(4, str4);
            }
            if (num == null) {
                F0.g(5);
            } else {
                F0.c(5, num.intValue());
            }
            if (str5 == null) {
                F0.g(6);
            } else {
                F0.i(6, str5);
            }
            if (str6 == null) {
                F0.g(7);
            } else {
                F0.i(7, str6);
            }
            if (str7 == null) {
                F0.g(8);
            } else {
                F0.i(8, str7);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit X0(String str, String str2, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE DOWNLOAD_TABLE SET subtitleSelectId = ? WHERE resourceId = ? ");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            if (str2 == null) {
                F0.g(2);
            } else {
                F0.i(2, str2);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Y0(int i, int i2, String str, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE DOWNLOAD_TABLE SET videoWidth = ?, videoHeight = ? WHERE resourceId = ? ");
        try {
            F0.c(1, i);
            F0.c(2, i2);
            if (str == null) {
                F0.g(3);
            } else {
                F0.i(3, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    public static List q0() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit r0(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM DOWNLOAD_TABLE WHERE url=?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit s0(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM DOWNLOAD_TABLE WHERE resourceId=?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit t0(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM DOWNLOAD_TABLE WHERE resourceId=? AND fileType =  3 ");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List u0(String str, y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        int i54;
        Integer valueOf8;
        int i55;
        int i56;
        int i57;
        Integer valueOf9;
        int i58;
        String q027;
        int i59;
        String q028;
        int i60;
        int i61;
        String q029;
        int i62;
        String q030;
        int i63;
        int i64;
        int i65;
        boolean z3;
        String q031;
        int i66;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? ORDER BY createAt DESC");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i67 = c3;
                int i68 = c4;
                int i69 = (int) F0.getLong(c13);
                int i70 = c5;
                int i71 = (int) F0.getLong(c14);
                int i72 = c6;
                int i73 = (int) F0.getLong(c15);
                int i74 = c16;
                long j2 = F0.getLong(i74);
                int i75 = c2;
                int i76 = c17;
                long j3 = F0.getLong(i76);
                c17 = i76;
                int i77 = c18;
                int i78 = c7;
                int i79 = (int) F0.getLong(i77);
                int i80 = c9;
                int i81 = c19;
                int i82 = c8;
                int i83 = (int) F0.getLong(i81);
                int i84 = c11;
                int i85 = c20;
                int i86 = c10;
                int i87 = (int) F0.getLong(i85);
                int i88 = c13;
                int i89 = c21;
                int i90 = c12;
                int i91 = (int) F0.getLong(i89);
                int i92 = c15;
                int i93 = c22;
                int i94 = c14;
                int i95 = (int) F0.getLong(i93);
                int i96 = c23;
                int i97 = (int) F0.getLong(i96);
                int i98 = c24;
                int i99 = (int) F0.getLong(i98);
                int i100 = c25;
                int i101 = (int) F0.getLong(i100);
                int i102 = c26;
                int i103 = (int) F0.getLong(i102);
                int i104 = c27;
                int i105 = (int) F0.getLong(i104);
                int i106 = c28;
                int i107 = (int) F0.getLong(i106);
                int i108 = c29;
                if (F0.isNull(i108)) {
                    i = i77;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i108);
                    i = i77;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i109 = c34;
                int i110 = (int) F0.getLong(i109);
                int i111 = c35;
                int i112 = (int) F0.getLong(i111);
                int i113 = c36;
                if (F0.isNull(i113)) {
                    i6 = i109;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i113);
                    i6 = i109;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i114 = c39;
                if (F0.isNull(i114)) {
                    c39 = i114;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i114);
                    c39 = i114;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i115 = c42;
                int i116 = (int) F0.getLong(i115);
                int i117 = c43;
                long j7 = F0.getLong(i117);
                int i118 = c44;
                if (F0.isNull(i118)) {
                    c44 = i118;
                    i11 = i117;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i117;
                    q09 = F0.q0(i118);
                    c44 = i118;
                    i12 = c45;
                }
                int i119 = (int) F0.getLong(i12);
                int i120 = c46;
                if (F0.isNull(i120)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i120);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i120;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i120;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i121 = i17;
                int i122 = (int) F0.getLong(i18);
                int i123 = c51;
                if (F0.isNull(i123)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i123);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i122;
                    i21 = i123;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i122;
                    i21 = i123;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i18;
                    i31 = i19;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i18;
                    i31 = i19;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i22;
                    i48 = i23;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i22;
                    i48 = i23;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = i50;
                    i55 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    i54 = i50;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i55 = c74;
                }
                if (F0.isNull(i55)) {
                    i56 = i52;
                    i57 = i53;
                    i58 = c75;
                    valueOf9 = null;
                } else {
                    i56 = i52;
                    i57 = i53;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i55));
                    i58 = c75;
                }
                if (F0.isNull(i58)) {
                    i59 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i58);
                    i59 = c76;
                }
                if (F0.isNull(i59)) {
                    i60 = i42;
                    i61 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i59);
                    i60 = i42;
                    i61 = c77;
                }
                if (F0.isNull(i61)) {
                    c77 = i61;
                    i62 = c78;
                    q029 = null;
                } else {
                    c77 = i61;
                    q029 = F0.q0(i61);
                    i62 = c78;
                }
                if (F0.isNull(i62)) {
                    c78 = i62;
                    i64 = i58;
                    i63 = c79;
                    q030 = null;
                } else {
                    c78 = i62;
                    q030 = F0.q0(i62);
                    i63 = c79;
                    i64 = i58;
                }
                int i124 = i59;
                if (((int) F0.getLong(i63)) != 0) {
                    i65 = c80;
                    z3 = true;
                } else {
                    i65 = c80;
                    z3 = false;
                }
                if (F0.isNull(i65)) {
                    i66 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i65);
                    i66 = c81;
                }
                int i125 = i63;
                arrayList.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i69, i71, i73, j2, j3, i79, i83, i87, i91, i95, i97, i99, i101, i103, i105, i107, q0, q02, q03, q04, j4, i110, i112, q05, q06, j5, q07, q08, j6, i116, j7, q09, i119, q010, q011, z, z2, i20, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i66) ? null : F0.q0(i66)));
                c2 = i75;
                c80 = i65;
                c81 = i66;
                c8 = i82;
                c10 = i86;
                c12 = i90;
                c21 = i89;
                c34 = i6;
                c42 = i115;
                c45 = i13;
                c49 = i121;
                c48 = i24;
                c50 = i30;
                c52 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c53 = i47;
                c54 = i48;
                c71 = i51;
                c70 = i54;
                c72 = i57;
                c69 = i60;
                c75 = i64;
                c76 = i124;
                c3 = i67;
                c4 = i68;
                c5 = i70;
                c6 = i72;
                c16 = i74;
                c11 = i84;
                c13 = i88;
                c24 = i98;
                c26 = i102;
                c27 = i104;
                c28 = i106;
                c36 = i113;
                c43 = i11;
                c46 = i15;
                c35 = i111;
                c19 = i81;
                c20 = i85;
                c74 = i55;
                c73 = i56;
                c7 = i78;
                c14 = i94;
                c22 = i93;
                c23 = i96;
                c18 = i;
                c79 = i125;
                c9 = i80;
                c15 = i92;
                c25 = i100;
                c29 = i108;
                c51 = i21;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean v0(String str, y3.b bVar) {
        String q0;
        int i;
        String q02;
        int i2;
        String q03;
        int i3;
        String q04;
        int i4;
        String q05;
        int i5;
        String q06;
        int i6;
        String q07;
        int i7;
        String q08;
        int i8;
        int i9;
        String q09;
        int i10;
        String q010;
        int i11;
        int i12;
        String q011;
        int i13;
        int i14;
        boolean z;
        int i15;
        boolean z2;
        String q012;
        int i16;
        int i17;
        Integer valueOf;
        int i18;
        String q013;
        int i19;
        String q014;
        int i20;
        String q015;
        int i21;
        String q016;
        int i22;
        String q017;
        int i23;
        String q018;
        int i24;
        Integer valueOf2;
        int i25;
        String q019;
        int i26;
        String q020;
        int i27;
        Long valueOf3;
        int i28;
        Long valueOf4;
        int i29;
        String q021;
        int i30;
        String q022;
        int i31;
        String q023;
        int i32;
        String q024;
        int i33;
        String q025;
        int i34;
        Integer valueOf5;
        int i35;
        String q026;
        int i36;
        Integer valueOf6;
        int i37;
        Integer valueOf7;
        int i38;
        Integer valueOf8;
        int i39;
        Integer valueOf9;
        int i40;
        String q027;
        int i41;
        String q028;
        int i42;
        String q029;
        int i43;
        String q030;
        int i44;
        int i45;
        boolean z3;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE resourceId = ? ORDER BY createAt DESC");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            DownloadBean downloadBean = null;
            if (F0.C0()) {
                String q031 = F0.isNull(c2) ? null : F0.q0(c2);
                String q032 = F0.isNull(c3) ? null : F0.q0(c3);
                String q033 = F0.isNull(c4) ? null : F0.q0(c4);
                String q034 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q035 = F0.isNull(c7) ? null : F0.q0(c7);
                String q036 = F0.isNull(c8) ? null : F0.q0(c8);
                String q037 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i46 = (int) F0.getLong(c13);
                int i47 = (int) F0.getLong(c14);
                int i48 = (int) F0.getLong(c15);
                long j2 = F0.getLong(c16);
                long j3 = F0.getLong(c17);
                int i49 = (int) F0.getLong(c18);
                int i50 = (int) F0.getLong(c19);
                int i51 = (int) F0.getLong(c20);
                int i52 = (int) F0.getLong(c21);
                int i53 = (int) F0.getLong(c22);
                int i54 = (int) F0.getLong(c23);
                int i55 = (int) F0.getLong(c24);
                int i56 = (int) F0.getLong(c25);
                int i57 = (int) F0.getLong(c26);
                int i58 = (int) F0.getLong(c27);
                int i59 = (int) F0.getLong(c28);
                if (F0.isNull(c29)) {
                    i = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(c29);
                    i = c30;
                }
                if (F0.isNull(i)) {
                    i2 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i);
                    i2 = c31;
                }
                if (F0.isNull(i2)) {
                    i3 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i2);
                    i3 = c32;
                }
                if (F0.isNull(i3)) {
                    i4 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i3);
                    i4 = c33;
                }
                long j4 = F0.getLong(i4);
                int i60 = (int) F0.getLong(c34);
                int i61 = (int) F0.getLong(c35);
                if (F0.isNull(c36)) {
                    i5 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(c36);
                    i5 = c37;
                }
                if (F0.isNull(i5)) {
                    i6 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i5);
                    i6 = c38;
                }
                long j5 = F0.getLong(i6);
                if (F0.isNull(c39)) {
                    i7 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(c39);
                    i7 = c40;
                }
                if (F0.isNull(i7)) {
                    i8 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i7);
                    i8 = c41;
                }
                long j6 = F0.getLong(i8);
                int i62 = (int) F0.getLong(c42);
                long j7 = F0.getLong(c43);
                if (F0.isNull(c44)) {
                    i9 = i62;
                    i10 = c45;
                    q09 = null;
                } else {
                    i9 = i62;
                    q09 = F0.q0(c44);
                    i10 = c45;
                }
                int i63 = (int) F0.getLong(i10);
                if (F0.isNull(c46)) {
                    i11 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(c46);
                    i11 = c47;
                }
                if (F0.isNull(i11)) {
                    i12 = i63;
                    i13 = c48;
                    q011 = null;
                } else {
                    i12 = i63;
                    q011 = F0.q0(i11);
                    i13 = c48;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c49;
                    z = true;
                } else {
                    i14 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c50;
                    z2 = true;
                } else {
                    i15 = c50;
                    z2 = false;
                }
                int i64 = (int) F0.getLong(i15);
                if (F0.isNull(c51)) {
                    i16 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(c51);
                    i16 = c52;
                }
                if (F0.isNull(i16)) {
                    i17 = i64;
                    i18 = c53;
                    valueOf = null;
                } else {
                    i17 = i64;
                    valueOf = Integer.valueOf((int) F0.getLong(i16));
                    i18 = c53;
                }
                if (F0.isNull(i18)) {
                    i19 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i18);
                    i19 = c54;
                }
                if (F0.isNull(i19)) {
                    i20 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i19);
                    i20 = c55;
                }
                if (F0.isNull(i20)) {
                    i21 = c56;
                    q015 = null;
                } else {
                    q015 = F0.q0(i20);
                    i21 = c56;
                }
                if (F0.isNull(i21)) {
                    i22 = c57;
                    q016 = null;
                } else {
                    q016 = F0.q0(i21);
                    i22 = c57;
                }
                if (F0.isNull(i22)) {
                    i23 = c58;
                    q017 = null;
                } else {
                    q017 = F0.q0(i22);
                    i23 = c58;
                }
                if (F0.isNull(i23)) {
                    i24 = c59;
                    q018 = null;
                } else {
                    q018 = F0.q0(i23);
                    i24 = c59;
                }
                if (F0.isNull(i24)) {
                    i25 = c60;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) F0.getLong(i24));
                    i25 = c60;
                }
                if (F0.isNull(i25)) {
                    i26 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i25);
                    i26 = c61;
                }
                if (F0.isNull(i26)) {
                    i27 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i26);
                    i27 = c62;
                }
                if (F0.isNull(i27)) {
                    i28 = c63;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(F0.getLong(i27));
                    i28 = c63;
                }
                if (F0.isNull(i28)) {
                    i29 = c64;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(i28));
                    i29 = c64;
                }
                if (F0.isNull(i29)) {
                    i30 = c65;
                    q021 = null;
                } else {
                    q021 = F0.q0(i29);
                    i30 = c65;
                }
                if (F0.isNull(i30)) {
                    i31 = c66;
                    q022 = null;
                } else {
                    q022 = F0.q0(i30);
                    i31 = c66;
                }
                if (F0.isNull(i31)) {
                    i32 = c67;
                    q023 = null;
                } else {
                    q023 = F0.q0(i31);
                    i32 = c67;
                }
                if (F0.isNull(i32)) {
                    i33 = c68;
                    q024 = null;
                } else {
                    q024 = F0.q0(i32);
                    i33 = c68;
                }
                if (F0.isNull(i33)) {
                    i34 = c69;
                    q025 = null;
                } else {
                    q025 = F0.q0(i33);
                    i34 = c69;
                }
                if (F0.isNull(i34)) {
                    i35 = c70;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) F0.getLong(i34));
                    i35 = c70;
                }
                if (F0.isNull(i35)) {
                    i36 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i35);
                    i36 = c71;
                }
                if (F0.isNull(i36)) {
                    i37 = c72;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) F0.getLong(i36));
                    i37 = c72;
                }
                if (F0.isNull(i37)) {
                    i38 = c73;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) F0.getLong(i37));
                    i38 = c73;
                }
                if (F0.isNull(i38)) {
                    i39 = c74;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) F0.getLong(i38));
                    i39 = c74;
                }
                if (F0.isNull(i39)) {
                    i40 = c75;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) F0.getLong(i39));
                    i40 = c75;
                }
                if (F0.isNull(i40)) {
                    i41 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i40);
                    i41 = c76;
                }
                if (F0.isNull(i41)) {
                    i42 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i41);
                    i42 = c77;
                }
                if (F0.isNull(i42)) {
                    i43 = c78;
                    q029 = null;
                } else {
                    q029 = F0.q0(i42);
                    i43 = c78;
                }
                if (F0.isNull(i43)) {
                    i44 = c79;
                    q030 = null;
                } else {
                    q030 = F0.q0(i43);
                    i44 = c79;
                }
                if (((int) F0.getLong(i44)) != 0) {
                    i45 = c80;
                    z3 = true;
                } else {
                    i45 = c80;
                    z3 = false;
                }
                downloadBean = new DownloadBean(q031, q032, q033, q034, valueOf10, q035, q036, q037, valueOf11, valueOf12, j, i46, i47, i48, j2, j3, i49, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, q0, q02, q03, q04, j4, i60, i61, q05, q06, j5, q07, q08, j6, i9, j7, q09, i12, q010, q011, z, z2, i17, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, F0.isNull(i45) ? null : F0.q0(i45), F0.isNull(c81) ? null : F0.q0(c81));
            }
            F0.close();
            return downloadBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean w0(String str, int i, y3.b bVar) {
        String q0;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        String q06;
        int i7;
        String q07;
        int i8;
        String q08;
        int i9;
        int i10;
        String q09;
        int i11;
        String q010;
        int i12;
        int i13;
        String q011;
        int i14;
        int i15;
        boolean z;
        int i16;
        boolean z2;
        String q012;
        int i17;
        int i18;
        Integer valueOf;
        int i19;
        String q013;
        int i20;
        String q014;
        int i21;
        String q015;
        int i22;
        String q016;
        int i23;
        String q017;
        int i24;
        String q018;
        int i25;
        Integer valueOf2;
        int i26;
        String q019;
        int i27;
        String q020;
        int i28;
        Long valueOf3;
        int i29;
        Long valueOf4;
        int i30;
        String q021;
        int i31;
        String q022;
        int i32;
        String q023;
        int i33;
        String q024;
        int i34;
        String q025;
        int i35;
        Integer valueOf5;
        int i36;
        String q026;
        int i37;
        Integer valueOf6;
        int i38;
        Integer valueOf7;
        int i39;
        Integer valueOf8;
        int i40;
        Integer valueOf9;
        int i41;
        String q027;
        int i42;
        String q028;
        int i43;
        String q029;
        int i44;
        String q030;
        int i45;
        int i46;
        boolean z3;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? AND ep = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.c(2, i);
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            DownloadBean downloadBean = null;
            if (F0.C0()) {
                String q031 = F0.isNull(c2) ? null : F0.q0(c2);
                String q032 = F0.isNull(c3) ? null : F0.q0(c3);
                String q033 = F0.isNull(c4) ? null : F0.q0(c4);
                String q034 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q035 = F0.isNull(c7) ? null : F0.q0(c7);
                String q036 = F0.isNull(c8) ? null : F0.q0(c8);
                String q037 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i47 = (int) F0.getLong(c13);
                int i48 = (int) F0.getLong(c14);
                int i49 = (int) F0.getLong(c15);
                long j2 = F0.getLong(c16);
                long j3 = F0.getLong(c17);
                int i50 = (int) F0.getLong(c18);
                int i51 = (int) F0.getLong(c19);
                int i52 = (int) F0.getLong(c20);
                int i53 = (int) F0.getLong(c21);
                int i54 = (int) F0.getLong(c22);
                int i55 = (int) F0.getLong(c23);
                int i56 = (int) F0.getLong(c24);
                int i57 = (int) F0.getLong(c25);
                int i58 = (int) F0.getLong(c26);
                int i59 = (int) F0.getLong(c27);
                int i60 = (int) F0.getLong(c28);
                if (F0.isNull(c29)) {
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(c29);
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                int i61 = (int) F0.getLong(c34);
                int i62 = (int) F0.getLong(c35);
                if (F0.isNull(c36)) {
                    i6 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(c36);
                    i6 = c37;
                }
                if (F0.isNull(i6)) {
                    i7 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i6);
                    i7 = c38;
                }
                long j5 = F0.getLong(i7);
                if (F0.isNull(c39)) {
                    i8 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(c39);
                    i8 = c40;
                }
                if (F0.isNull(i8)) {
                    i9 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i8);
                    i9 = c41;
                }
                long j6 = F0.getLong(i9);
                int i63 = (int) F0.getLong(c42);
                long j7 = F0.getLong(c43);
                if (F0.isNull(c44)) {
                    i10 = i63;
                    i11 = c45;
                    q09 = null;
                } else {
                    i10 = i63;
                    q09 = F0.q0(c44);
                    i11 = c45;
                }
                int i64 = (int) F0.getLong(i11);
                if (F0.isNull(c46)) {
                    i12 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(c46);
                    i12 = c47;
                }
                if (F0.isNull(i12)) {
                    i13 = i64;
                    i14 = c48;
                    q011 = null;
                } else {
                    i13 = i64;
                    q011 = F0.q0(i12);
                    i14 = c48;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c49;
                    z = true;
                } else {
                    i15 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i15)) != 0) {
                    i16 = c50;
                    z2 = true;
                } else {
                    i16 = c50;
                    z2 = false;
                }
                int i65 = (int) F0.getLong(i16);
                if (F0.isNull(c51)) {
                    i17 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(c51);
                    i17 = c52;
                }
                if (F0.isNull(i17)) {
                    i18 = i65;
                    i19 = c53;
                    valueOf = null;
                } else {
                    i18 = i65;
                    valueOf = Integer.valueOf((int) F0.getLong(i17));
                    i19 = c53;
                }
                if (F0.isNull(i19)) {
                    i20 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i19);
                    i20 = c54;
                }
                if (F0.isNull(i20)) {
                    i21 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i20);
                    i21 = c55;
                }
                if (F0.isNull(i21)) {
                    i22 = c56;
                    q015 = null;
                } else {
                    q015 = F0.q0(i21);
                    i22 = c56;
                }
                if (F0.isNull(i22)) {
                    i23 = c57;
                    q016 = null;
                } else {
                    q016 = F0.q0(i22);
                    i23 = c57;
                }
                if (F0.isNull(i23)) {
                    i24 = c58;
                    q017 = null;
                } else {
                    q017 = F0.q0(i23);
                    i24 = c58;
                }
                if (F0.isNull(i24)) {
                    i25 = c59;
                    q018 = null;
                } else {
                    q018 = F0.q0(i24);
                    i25 = c59;
                }
                if (F0.isNull(i25)) {
                    i26 = c60;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) F0.getLong(i25));
                    i26 = c60;
                }
                if (F0.isNull(i26)) {
                    i27 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i26);
                    i27 = c61;
                }
                if (F0.isNull(i27)) {
                    i28 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i27);
                    i28 = c62;
                }
                if (F0.isNull(i28)) {
                    i29 = c63;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(F0.getLong(i28));
                    i29 = c63;
                }
                if (F0.isNull(i29)) {
                    i30 = c64;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(i29));
                    i30 = c64;
                }
                if (F0.isNull(i30)) {
                    i31 = c65;
                    q021 = null;
                } else {
                    q021 = F0.q0(i30);
                    i31 = c65;
                }
                if (F0.isNull(i31)) {
                    i32 = c66;
                    q022 = null;
                } else {
                    q022 = F0.q0(i31);
                    i32 = c66;
                }
                if (F0.isNull(i32)) {
                    i33 = c67;
                    q023 = null;
                } else {
                    q023 = F0.q0(i32);
                    i33 = c67;
                }
                if (F0.isNull(i33)) {
                    i34 = c68;
                    q024 = null;
                } else {
                    q024 = F0.q0(i33);
                    i34 = c68;
                }
                if (F0.isNull(i34)) {
                    i35 = c69;
                    q025 = null;
                } else {
                    q025 = F0.q0(i34);
                    i35 = c69;
                }
                if (F0.isNull(i35)) {
                    i36 = c70;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) F0.getLong(i35));
                    i36 = c70;
                }
                if (F0.isNull(i36)) {
                    i37 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i36);
                    i37 = c71;
                }
                if (F0.isNull(i37)) {
                    i38 = c72;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) F0.getLong(i37));
                    i38 = c72;
                }
                if (F0.isNull(i38)) {
                    i39 = c73;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) F0.getLong(i38));
                    i39 = c73;
                }
                if (F0.isNull(i39)) {
                    i40 = c74;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) F0.getLong(i39));
                    i40 = c74;
                }
                if (F0.isNull(i40)) {
                    i41 = c75;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) F0.getLong(i40));
                    i41 = c75;
                }
                if (F0.isNull(i41)) {
                    i42 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i41);
                    i42 = c76;
                }
                if (F0.isNull(i42)) {
                    i43 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i42);
                    i43 = c77;
                }
                if (F0.isNull(i43)) {
                    i44 = c78;
                    q029 = null;
                } else {
                    q029 = F0.q0(i43);
                    i44 = c78;
                }
                if (F0.isNull(i44)) {
                    i45 = c79;
                    q030 = null;
                } else {
                    q030 = F0.q0(i44);
                    i45 = c79;
                }
                if (((int) F0.getLong(i45)) != 0) {
                    i46 = c80;
                    z3 = true;
                } else {
                    i46 = c80;
                    z3 = false;
                }
                downloadBean = new DownloadBean(q031, q032, q033, q034, valueOf10, q035, q036, q037, valueOf11, valueOf12, j, i47, i48, i49, j2, j3, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, i60, q0, q02, q03, q04, j4, i61, i62, q05, q06, j5, q07, q08, j6, i10, j7, q09, i13, q010, q011, z, z2, i18, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, F0.isNull(i46) ? null : F0.q0(i46), F0.isNull(c81) ? null : F0.q0(c81));
            }
            F0.close();
            return downloadBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean x0(String str, y3.b bVar) {
        String q0;
        int i;
        String q02;
        int i2;
        String q03;
        int i3;
        String q04;
        int i4;
        String q05;
        int i5;
        String q06;
        int i6;
        String q07;
        int i7;
        String q08;
        int i8;
        int i9;
        String q09;
        int i10;
        String q010;
        int i11;
        int i12;
        String q011;
        int i13;
        int i14;
        boolean z;
        int i15;
        boolean z2;
        String q012;
        int i16;
        int i17;
        Integer valueOf;
        int i18;
        String q013;
        int i19;
        String q014;
        int i20;
        String q015;
        int i21;
        String q016;
        int i22;
        String q017;
        int i23;
        String q018;
        int i24;
        Integer valueOf2;
        int i25;
        String q019;
        int i26;
        String q020;
        int i27;
        Long valueOf3;
        int i28;
        Long valueOf4;
        int i29;
        String q021;
        int i30;
        String q022;
        int i31;
        String q023;
        int i32;
        String q024;
        int i33;
        String q025;
        int i34;
        Integer valueOf5;
        int i35;
        String q026;
        int i36;
        Integer valueOf6;
        int i37;
        Integer valueOf7;
        int i38;
        Integer valueOf8;
        int i39;
        Integer valueOf9;
        int i40;
        String q027;
        int i41;
        String q028;
        int i42;
        String q029;
        int i43;
        String q030;
        int i44;
        int i45;
        boolean z3;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            DownloadBean downloadBean = null;
            if (F0.C0()) {
                String q031 = F0.isNull(c2) ? null : F0.q0(c2);
                String q032 = F0.isNull(c3) ? null : F0.q0(c3);
                String q033 = F0.isNull(c4) ? null : F0.q0(c4);
                String q034 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q035 = F0.isNull(c7) ? null : F0.q0(c7);
                String q036 = F0.isNull(c8) ? null : F0.q0(c8);
                String q037 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i46 = (int) F0.getLong(c13);
                int i47 = (int) F0.getLong(c14);
                int i48 = (int) F0.getLong(c15);
                long j2 = F0.getLong(c16);
                long j3 = F0.getLong(c17);
                int i49 = (int) F0.getLong(c18);
                int i50 = (int) F0.getLong(c19);
                int i51 = (int) F0.getLong(c20);
                int i52 = (int) F0.getLong(c21);
                int i53 = (int) F0.getLong(c22);
                int i54 = (int) F0.getLong(c23);
                int i55 = (int) F0.getLong(c24);
                int i56 = (int) F0.getLong(c25);
                int i57 = (int) F0.getLong(c26);
                int i58 = (int) F0.getLong(c27);
                int i59 = (int) F0.getLong(c28);
                if (F0.isNull(c29)) {
                    i = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(c29);
                    i = c30;
                }
                if (F0.isNull(i)) {
                    i2 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i);
                    i2 = c31;
                }
                if (F0.isNull(i2)) {
                    i3 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i2);
                    i3 = c32;
                }
                if (F0.isNull(i3)) {
                    i4 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i3);
                    i4 = c33;
                }
                long j4 = F0.getLong(i4);
                int i60 = (int) F0.getLong(c34);
                int i61 = (int) F0.getLong(c35);
                if (F0.isNull(c36)) {
                    i5 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(c36);
                    i5 = c37;
                }
                if (F0.isNull(i5)) {
                    i6 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i5);
                    i6 = c38;
                }
                long j5 = F0.getLong(i6);
                if (F0.isNull(c39)) {
                    i7 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(c39);
                    i7 = c40;
                }
                if (F0.isNull(i7)) {
                    i8 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i7);
                    i8 = c41;
                }
                long j6 = F0.getLong(i8);
                int i62 = (int) F0.getLong(c42);
                long j7 = F0.getLong(c43);
                if (F0.isNull(c44)) {
                    i9 = i62;
                    i10 = c45;
                    q09 = null;
                } else {
                    i9 = i62;
                    q09 = F0.q0(c44);
                    i10 = c45;
                }
                int i63 = (int) F0.getLong(i10);
                if (F0.isNull(c46)) {
                    i11 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(c46);
                    i11 = c47;
                }
                if (F0.isNull(i11)) {
                    i12 = i63;
                    i13 = c48;
                    q011 = null;
                } else {
                    i12 = i63;
                    q011 = F0.q0(i11);
                    i13 = c48;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c49;
                    z = true;
                } else {
                    i14 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c50;
                    z2 = true;
                } else {
                    i15 = c50;
                    z2 = false;
                }
                int i64 = (int) F0.getLong(i15);
                if (F0.isNull(c51)) {
                    i16 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(c51);
                    i16 = c52;
                }
                if (F0.isNull(i16)) {
                    i17 = i64;
                    i18 = c53;
                    valueOf = null;
                } else {
                    i17 = i64;
                    valueOf = Integer.valueOf((int) F0.getLong(i16));
                    i18 = c53;
                }
                if (F0.isNull(i18)) {
                    i19 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i18);
                    i19 = c54;
                }
                if (F0.isNull(i19)) {
                    i20 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i19);
                    i20 = c55;
                }
                if (F0.isNull(i20)) {
                    i21 = c56;
                    q015 = null;
                } else {
                    q015 = F0.q0(i20);
                    i21 = c56;
                }
                if (F0.isNull(i21)) {
                    i22 = c57;
                    q016 = null;
                } else {
                    q016 = F0.q0(i21);
                    i22 = c57;
                }
                if (F0.isNull(i22)) {
                    i23 = c58;
                    q017 = null;
                } else {
                    q017 = F0.q0(i22);
                    i23 = c58;
                }
                if (F0.isNull(i23)) {
                    i24 = c59;
                    q018 = null;
                } else {
                    q018 = F0.q0(i23);
                    i24 = c59;
                }
                if (F0.isNull(i24)) {
                    i25 = c60;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) F0.getLong(i24));
                    i25 = c60;
                }
                if (F0.isNull(i25)) {
                    i26 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i25);
                    i26 = c61;
                }
                if (F0.isNull(i26)) {
                    i27 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i26);
                    i27 = c62;
                }
                if (F0.isNull(i27)) {
                    i28 = c63;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(F0.getLong(i27));
                    i28 = c63;
                }
                if (F0.isNull(i28)) {
                    i29 = c64;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(i28));
                    i29 = c64;
                }
                if (F0.isNull(i29)) {
                    i30 = c65;
                    q021 = null;
                } else {
                    q021 = F0.q0(i29);
                    i30 = c65;
                }
                if (F0.isNull(i30)) {
                    i31 = c66;
                    q022 = null;
                } else {
                    q022 = F0.q0(i30);
                    i31 = c66;
                }
                if (F0.isNull(i31)) {
                    i32 = c67;
                    q023 = null;
                } else {
                    q023 = F0.q0(i31);
                    i32 = c67;
                }
                if (F0.isNull(i32)) {
                    i33 = c68;
                    q024 = null;
                } else {
                    q024 = F0.q0(i32);
                    i33 = c68;
                }
                if (F0.isNull(i33)) {
                    i34 = c69;
                    q025 = null;
                } else {
                    q025 = F0.q0(i33);
                    i34 = c69;
                }
                if (F0.isNull(i34)) {
                    i35 = c70;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) F0.getLong(i34));
                    i35 = c70;
                }
                if (F0.isNull(i35)) {
                    i36 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i35);
                    i36 = c71;
                }
                if (F0.isNull(i36)) {
                    i37 = c72;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) F0.getLong(i36));
                    i37 = c72;
                }
                if (F0.isNull(i37)) {
                    i38 = c73;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) F0.getLong(i37));
                    i38 = c73;
                }
                if (F0.isNull(i38)) {
                    i39 = c74;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) F0.getLong(i38));
                    i39 = c74;
                }
                if (F0.isNull(i39)) {
                    i40 = c75;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) F0.getLong(i39));
                    i40 = c75;
                }
                if (F0.isNull(i40)) {
                    i41 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i40);
                    i41 = c76;
                }
                if (F0.isNull(i41)) {
                    i42 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i41);
                    i42 = c77;
                }
                if (F0.isNull(i42)) {
                    i43 = c78;
                    q029 = null;
                } else {
                    q029 = F0.q0(i42);
                    i43 = c78;
                }
                if (F0.isNull(i43)) {
                    i44 = c79;
                    q030 = null;
                } else {
                    q030 = F0.q0(i43);
                    i44 = c79;
                }
                if (((int) F0.getLong(i44)) != 0) {
                    i45 = c80;
                    z3 = true;
                } else {
                    i45 = c80;
                    z3 = false;
                }
                downloadBean = new DownloadBean(q031, q032, q033, q034, valueOf10, q035, q036, q037, valueOf11, valueOf12, j, i46, i47, i48, j2, j3, i49, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, q0, q02, q03, q04, j4, i60, i61, q05, q06, j5, q07, q08, j6, i9, j7, q09, i12, q010, q011, z, z2, i17, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, F0.isNull(i45) ? null : F0.q0(i45), F0.isNull(c81) ? null : F0.q0(c81));
            }
            F0.close();
            return downloadBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List y0(String str, y3.b bVar) {
        String q0;
        int i;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        int i7;
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        int i11;
        String q09;
        int i12;
        String q010;
        int i13;
        int i14;
        int i15;
        String q011;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        String q012;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22;
        String q013;
        int i23;
        String q014;
        int i24;
        int i25;
        String q015;
        int i26;
        String q016;
        int i27;
        String q017;
        int i28;
        String q018;
        int i29;
        int i30;
        int i31;
        Integer valueOf2;
        int i32;
        String q019;
        int i33;
        String q020;
        int i34;
        int i35;
        Long valueOf3;
        int i36;
        Long valueOf4;
        int i37;
        String q021;
        int i38;
        String q022;
        int i39;
        String q023;
        int i40;
        String q024;
        int i41;
        String q025;
        int i42;
        int i43;
        int i44;
        Integer valueOf5;
        int i45;
        String q026;
        int i46;
        int i47;
        int i48;
        Integer valueOf6;
        int i49;
        int i50;
        int i51;
        Integer valueOf7;
        int i52;
        int i53;
        int i54;
        Integer valueOf8;
        int i55;
        int i56;
        int i57;
        Integer valueOf9;
        int i58;
        String q027;
        int i59;
        String q028;
        int i60;
        int i61;
        String q029;
        int i62;
        String q030;
        int i63;
        int i64;
        int i65;
        boolean z3;
        String q031;
        int i66;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? ORDER BY ep ASC ");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q032 = F0.isNull(c2) ? null : F0.q0(c2);
                String q033 = F0.isNull(c3) ? null : F0.q0(c3);
                String q034 = F0.isNull(c4) ? null : F0.q0(c4);
                String q035 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q036 = F0.isNull(c7) ? null : F0.q0(c7);
                String q037 = F0.isNull(c8) ? null : F0.q0(c8);
                String q038 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i67 = c3;
                int i68 = c4;
                int i69 = (int) F0.getLong(c13);
                int i70 = c5;
                int i71 = (int) F0.getLong(c14);
                int i72 = c6;
                int i73 = (int) F0.getLong(c15);
                int i74 = c16;
                long j2 = F0.getLong(i74);
                int i75 = c2;
                int i76 = c17;
                long j3 = F0.getLong(i76);
                c17 = i76;
                int i77 = c18;
                int i78 = c7;
                int i79 = (int) F0.getLong(i77);
                int i80 = c9;
                int i81 = c19;
                int i82 = c8;
                int i83 = (int) F0.getLong(i81);
                int i84 = c11;
                int i85 = c20;
                int i86 = c10;
                int i87 = (int) F0.getLong(i85);
                int i88 = c13;
                int i89 = c21;
                int i90 = c12;
                int i91 = (int) F0.getLong(i89);
                int i92 = c15;
                int i93 = c22;
                int i94 = c14;
                int i95 = (int) F0.getLong(i93);
                int i96 = c23;
                int i97 = (int) F0.getLong(i96);
                int i98 = c24;
                int i99 = (int) F0.getLong(i98);
                int i100 = c25;
                int i101 = (int) F0.getLong(i100);
                int i102 = c26;
                int i103 = (int) F0.getLong(i102);
                int i104 = c27;
                int i105 = (int) F0.getLong(i104);
                int i106 = c28;
                int i107 = (int) F0.getLong(i106);
                int i108 = c29;
                if (F0.isNull(i108)) {
                    i = i77;
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(i108);
                    i = i77;
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    c30 = i2;
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    c30 = i2;
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    c31 = i3;
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    c31 = i3;
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    c32 = i4;
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    c32 = i4;
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                c33 = i5;
                int i109 = c34;
                int i110 = (int) F0.getLong(i109);
                int i111 = c35;
                int i112 = (int) F0.getLong(i111);
                int i113 = c36;
                if (F0.isNull(i113)) {
                    i6 = i109;
                    i7 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(i113);
                    i6 = i109;
                    i7 = c37;
                }
                if (F0.isNull(i7)) {
                    c37 = i7;
                    i8 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    c37 = i7;
                    i8 = c38;
                }
                long j5 = F0.getLong(i8);
                c38 = i8;
                int i114 = c39;
                if (F0.isNull(i114)) {
                    c39 = i114;
                    i9 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(i114);
                    c39 = i114;
                    i9 = c40;
                }
                if (F0.isNull(i9)) {
                    c40 = i9;
                    i10 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    c40 = i9;
                    i10 = c41;
                }
                long j6 = F0.getLong(i10);
                c41 = i10;
                int i115 = c42;
                int i116 = (int) F0.getLong(i115);
                int i117 = c43;
                long j7 = F0.getLong(i117);
                int i118 = c44;
                if (F0.isNull(i118)) {
                    c44 = i118;
                    i11 = i117;
                    i12 = c45;
                    q09 = null;
                } else {
                    i11 = i117;
                    q09 = F0.q0(i118);
                    c44 = i118;
                    i12 = c45;
                }
                int i119 = (int) F0.getLong(i12);
                int i120 = c46;
                if (F0.isNull(i120)) {
                    i13 = i12;
                    i14 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(i120);
                    i13 = i12;
                    i14 = c47;
                }
                if (F0.isNull(i14)) {
                    c47 = i14;
                    i15 = i120;
                    i16 = c48;
                    q011 = null;
                } else {
                    i15 = i120;
                    q011 = F0.q0(i14);
                    c47 = i14;
                    i16 = c48;
                }
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c49;
                    z = true;
                } else {
                    i17 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c50;
                    z2 = true;
                } else {
                    i18 = c50;
                    z2 = false;
                }
                int i121 = i17;
                int i122 = (int) F0.getLong(i18);
                int i123 = c51;
                if (F0.isNull(i123)) {
                    i19 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(i123);
                    i19 = c52;
                }
                if (F0.isNull(i19)) {
                    i20 = i122;
                    i21 = i123;
                    i22 = c53;
                    valueOf = null;
                } else {
                    i20 = i122;
                    i21 = i123;
                    valueOf = Integer.valueOf((int) F0.getLong(i19));
                    i22 = c53;
                }
                if (F0.isNull(i22)) {
                    i23 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i22);
                    i23 = c54;
                }
                if (F0.isNull(i23)) {
                    i24 = i16;
                    i25 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i23);
                    i24 = i16;
                    i25 = c55;
                }
                if (F0.isNull(i25)) {
                    c55 = i25;
                    i26 = c56;
                    q015 = null;
                } else {
                    c55 = i25;
                    q015 = F0.q0(i25);
                    i26 = c56;
                }
                if (F0.isNull(i26)) {
                    c56 = i26;
                    i27 = c57;
                    q016 = null;
                } else {
                    c56 = i26;
                    q016 = F0.q0(i26);
                    i27 = c57;
                }
                if (F0.isNull(i27)) {
                    c57 = i27;
                    i28 = c58;
                    q017 = null;
                } else {
                    c57 = i27;
                    q017 = F0.q0(i27);
                    i28 = c58;
                }
                if (F0.isNull(i28)) {
                    c58 = i28;
                    i29 = c59;
                    q018 = null;
                } else {
                    c58 = i28;
                    q018 = F0.q0(i28);
                    i29 = c59;
                }
                if (F0.isNull(i29)) {
                    i30 = i18;
                    i31 = i19;
                    i32 = c60;
                    valueOf2 = null;
                } else {
                    i30 = i18;
                    i31 = i19;
                    valueOf2 = Integer.valueOf((int) F0.getLong(i29));
                    i32 = c60;
                }
                if (F0.isNull(i32)) {
                    i33 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i32);
                    i33 = c61;
                }
                if (F0.isNull(i33)) {
                    i34 = i29;
                    i35 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i33);
                    i34 = i29;
                    i35 = c62;
                }
                if (F0.isNull(i35)) {
                    c62 = i35;
                    i36 = c63;
                    valueOf3 = null;
                } else {
                    c62 = i35;
                    valueOf3 = Long.valueOf(F0.getLong(i35));
                    i36 = c63;
                }
                if (F0.isNull(i36)) {
                    c63 = i36;
                    i37 = c64;
                    valueOf4 = null;
                } else {
                    c63 = i36;
                    valueOf4 = Long.valueOf(F0.getLong(i36));
                    i37 = c64;
                }
                if (F0.isNull(i37)) {
                    c64 = i37;
                    i38 = c65;
                    q021 = null;
                } else {
                    c64 = i37;
                    q021 = F0.q0(i37);
                    i38 = c65;
                }
                if (F0.isNull(i38)) {
                    c65 = i38;
                    i39 = c66;
                    q022 = null;
                } else {
                    c65 = i38;
                    q022 = F0.q0(i38);
                    i39 = c66;
                }
                if (F0.isNull(i39)) {
                    c66 = i39;
                    i40 = c67;
                    q023 = null;
                } else {
                    c66 = i39;
                    q023 = F0.q0(i39);
                    i40 = c67;
                }
                if (F0.isNull(i40)) {
                    c67 = i40;
                    i41 = c68;
                    q024 = null;
                } else {
                    c67 = i40;
                    q024 = F0.q0(i40);
                    i41 = c68;
                }
                if (F0.isNull(i41)) {
                    c68 = i41;
                    i42 = c69;
                    q025 = null;
                } else {
                    c68 = i41;
                    q025 = F0.q0(i41);
                    i42 = c69;
                }
                if (F0.isNull(i42)) {
                    i43 = i32;
                    i44 = i33;
                    i45 = c70;
                    valueOf5 = null;
                } else {
                    i43 = i32;
                    i44 = i33;
                    valueOf5 = Integer.valueOf((int) F0.getLong(i42));
                    i45 = c70;
                }
                if (F0.isNull(i45)) {
                    i46 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i45);
                    i46 = c71;
                }
                if (F0.isNull(i46)) {
                    i47 = i22;
                    i48 = i23;
                    i49 = c72;
                    valueOf6 = null;
                } else {
                    i47 = i22;
                    i48 = i23;
                    valueOf6 = Integer.valueOf((int) F0.getLong(i46));
                    i49 = c72;
                }
                if (F0.isNull(i49)) {
                    i50 = i45;
                    i51 = i46;
                    i52 = c73;
                    valueOf7 = null;
                } else {
                    i50 = i45;
                    i51 = i46;
                    valueOf7 = Integer.valueOf((int) F0.getLong(i49));
                    i52 = c73;
                }
                if (F0.isNull(i52)) {
                    i53 = i49;
                    i54 = i50;
                    i55 = c74;
                    valueOf8 = null;
                } else {
                    i53 = i49;
                    i54 = i50;
                    valueOf8 = Integer.valueOf((int) F0.getLong(i52));
                    i55 = c74;
                }
                if (F0.isNull(i55)) {
                    i56 = i52;
                    i57 = i53;
                    i58 = c75;
                    valueOf9 = null;
                } else {
                    i56 = i52;
                    i57 = i53;
                    valueOf9 = Integer.valueOf((int) F0.getLong(i55));
                    i58 = c75;
                }
                if (F0.isNull(i58)) {
                    i59 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i58);
                    i59 = c76;
                }
                if (F0.isNull(i59)) {
                    i60 = i42;
                    i61 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i59);
                    i60 = i42;
                    i61 = c77;
                }
                if (F0.isNull(i61)) {
                    c77 = i61;
                    i62 = c78;
                    q029 = null;
                } else {
                    c77 = i61;
                    q029 = F0.q0(i61);
                    i62 = c78;
                }
                if (F0.isNull(i62)) {
                    c78 = i62;
                    i64 = i58;
                    i63 = c79;
                    q030 = null;
                } else {
                    c78 = i62;
                    q030 = F0.q0(i62);
                    i63 = c79;
                    i64 = i58;
                }
                int i124 = i59;
                if (((int) F0.getLong(i63)) != 0) {
                    i65 = c80;
                    z3 = true;
                } else {
                    i65 = c80;
                    z3 = false;
                }
                if (F0.isNull(i65)) {
                    i66 = c81;
                    q031 = null;
                } else {
                    q031 = F0.q0(i65);
                    i66 = c81;
                }
                int i125 = i63;
                arrayList.add(new DownloadBean(q032, q033, q034, q035, valueOf10, q036, q037, q038, valueOf11, valueOf12, j, i69, i71, i73, j2, j3, i79, i83, i87, i91, i95, i97, i99, i101, i103, i105, i107, q0, q02, q03, q04, j4, i110, i112, q05, q06, j5, q07, q08, j6, i116, j7, q09, i119, q010, q011, z, z2, i20, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, q031, F0.isNull(i66) ? null : F0.q0(i66)));
                c2 = i75;
                c80 = i65;
                c81 = i66;
                c8 = i82;
                c10 = i86;
                c12 = i90;
                c21 = i89;
                c34 = i6;
                c42 = i115;
                c45 = i13;
                c49 = i121;
                c48 = i24;
                c50 = i30;
                c52 = i31;
                c59 = i34;
                c60 = i43;
                c61 = i44;
                c53 = i47;
                c54 = i48;
                c71 = i51;
                c70 = i54;
                c72 = i57;
                c69 = i60;
                c75 = i64;
                c76 = i124;
                c3 = i67;
                c4 = i68;
                c5 = i70;
                c6 = i72;
                c16 = i74;
                c11 = i84;
                c13 = i88;
                c24 = i98;
                c26 = i102;
                c27 = i104;
                c28 = i106;
                c36 = i113;
                c43 = i11;
                c46 = i15;
                c35 = i111;
                c19 = i81;
                c20 = i85;
                c74 = i55;
                c73 = i56;
                c7 = i78;
                c14 = i94;
                c22 = i93;
                c23 = i96;
                c18 = i;
                c79 = i125;
                c9 = i80;
                c15 = i92;
                c25 = i100;
                c29 = i108;
                c51 = i21;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadBean z0(String str, int i, y3.b bVar) {
        String q0;
        int i2;
        String q02;
        int i3;
        String q03;
        int i4;
        String q04;
        int i5;
        String q05;
        int i6;
        String q06;
        int i7;
        String q07;
        int i8;
        String q08;
        int i9;
        int i10;
        String q09;
        int i11;
        String q010;
        int i12;
        int i13;
        String q011;
        int i14;
        int i15;
        boolean z;
        int i16;
        boolean z2;
        String q012;
        int i17;
        int i18;
        Integer valueOf;
        int i19;
        String q013;
        int i20;
        String q014;
        int i21;
        String q015;
        int i22;
        String q016;
        int i23;
        String q017;
        int i24;
        String q018;
        int i25;
        Integer valueOf2;
        int i26;
        String q019;
        int i27;
        String q020;
        int i28;
        Long valueOf3;
        int i29;
        Long valueOf4;
        int i30;
        String q021;
        int i31;
        String q022;
        int i32;
        String q023;
        int i33;
        String q024;
        int i34;
        String q025;
        int i35;
        Integer valueOf5;
        int i36;
        String q026;
        int i37;
        Integer valueOf6;
        int i38;
        Integer valueOf7;
        int i39;
        Integer valueOf8;
        int i40;
        Integer valueOf9;
        int i41;
        String q027;
        int i42;
        String q028;
        int i43;
        String q029;
        int i44;
        String q030;
        int i45;
        int i46;
        boolean z3;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_TABLE WHERE subjectId = ? AND ep =? ");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.c(2, i);
            int c2 = androidx.room.util.i.c(F0, "url");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "name");
            int c5 = androidx.room.util.i.c(F0, "cover");
            int c6 = androidx.room.util.i.c(F0, "size");
            int c7 = androidx.room.util.i.c(F0, "postId");
            int c8 = androidx.room.util.i.c(F0, "sizeFormat");
            int c9 = androidx.room.util.i.c(F0, "path");
            int c10 = androidx.room.util.i.c(F0, "duration");
            int c11 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c12 = androidx.room.util.i.c(F0, "progress");
            int c13 = androidx.room.util.i.c(F0, "supportRanges");
            int c14 = androidx.room.util.i.c(F0, "status");
            int c15 = androidx.room.util.i.c(F0, "type");
            int c16 = androidx.room.util.i.c(F0, "readProgress");
            int c17 = androidx.room.util.i.c(F0, "createAt");
            int c18 = androidx.room.util.i.c(F0, "isRead");
            int c19 = androidx.room.util.i.c(F0, "episode");
            int c20 = androidx.room.util.i.c(F0, "ep");
            int c21 = androidx.room.util.i.c(F0, "se");
            int c22 = androidx.room.util.i.c(F0, "resolution");
            int c23 = androidx.room.util.i.c(F0, "resourcePosition");
            int c24 = androidx.room.util.i.c(F0, "multiresolution");
            int c25 = androidx.room.util.i.c(F0, "videoWidth");
            int c26 = androidx.room.util.i.c(F0, "videoHeight");
            int c27 = androidx.room.util.i.c(F0, "downloadErrorCount");
            int c28 = androidx.room.util.i.c(F0, "subtitleStarted");
            int c29 = androidx.room.util.i.c(F0, "subjectId");
            int c30 = androidx.room.util.i.c(F0, "pageFrom");
            int c31 = androidx.room.util.i.c(F0, "lastPageFrom");
            int c32 = androidx.room.util.i.c(F0, "subjectName");
            int c33 = androidx.room.util.i.c(F0, "lastPlayTimeStamp");
            int c34 = androidx.room.util.i.c(F0, "fileType");
            int c35 = androidx.room.util.i.c(F0, "totalEpisode");
            int c36 = androidx.room.util.i.c(F0, "uploadBy");
            int c37 = androidx.room.util.i.c(F0, "sourceUrl");
            int c38 = androidx.room.util.i.c(F0, "urlCreateAt");
            int c39 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c40 = androidx.room.util.i.c(F0, "taskId");
            int c41 = androidx.room.util.i.c(F0, "sessionTime");
            int c42 = androidx.room.util.i.c(F0, "reportStatus");
            int c43 = androidx.room.util.i.c(F0, "downloadHeaderSize");
            int c44 = androidx.room.util.i.c(F0, "rootPath");
            int c45 = androidx.room.util.i.c(F0, "rootPathType");
            int c46 = androidx.room.util.i.c(F0, "thumbnail");
            int c47 = androidx.room.util.i.c(F0, "averageHueLight");
            int c48 = androidx.room.util.i.c(F0, "isTransferFailed");
            int c49 = androidx.room.util.i.c(F0, "isClosedTransferFailed");
            int c50 = androidx.room.util.i.c(F0, "subjectType");
            int c51 = androidx.room.util.i.c(F0, "genre");
            int c52 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c53 = androidx.room.util.i.c(F0, "currentDubLanName");
            int c54 = androidx.room.util.i.c(F0, "currentDubLanCode");
            int c55 = androidx.room.util.i.c(F0, "ops");
            int c56 = androidx.room.util.i.c(F0, "restrictLevel");
            int c57 = androidx.room.util.i.c(F0, "releaseDate");
            int c58 = androidx.room.util.i.c(F0, "countryName");
            int c59 = androidx.room.util.i.c(F0, "seNum");
            int c60 = androidx.room.util.i.c(F0, "subtitles");
            int c61 = androidx.room.util.i.c(F0, "imdbRate");
            int c62 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c63 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c64 = androidx.room.util.i.c(F0, "subtitleIdType");
            int c65 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c66 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c67 = androidx.room.util.i.c(F0, "ugcVideoName");
            int c68 = androidx.room.util.i.c(F0, "ugcVideoCollectionName");
            int c69 = androidx.room.util.i.c(F0, "ugcVideoPosition");
            int c70 = androidx.room.util.i.c(F0, "ugcVideoType");
            int c71 = androidx.room.util.i.c(F0, "ugcCateLev1Id");
            int c72 = androidx.room.util.i.c(F0, "ugcCateLev2Id");
            int c73 = androidx.room.util.i.c(F0, "ugcCateLev3Id");
            int c74 = androidx.room.util.i.c(F0, "ugcCateLev4Id");
            int c75 = androidx.room.util.i.c(F0, "ugcVideoTrackId");
            int c76 = androidx.room.util.i.c(F0, "ugcVideoParentVideoId");
            int c77 = androidx.room.util.i.c(F0, "ugcVideoParentTrackId");
            int c78 = androidx.room.util.i.c(F0, "ugcVideoEpTitle");
            int c79 = androidx.room.util.i.c(F0, "ugcVideoIsVertical");
            int c80 = androidx.room.util.i.c(F0, "originData");
            int c81 = androidx.room.util.i.c(F0, "kidId");
            DownloadBean downloadBean = null;
            if (F0.C0()) {
                String q031 = F0.isNull(c2) ? null : F0.q0(c2);
                String q032 = F0.isNull(c3) ? null : F0.q0(c3);
                String q033 = F0.isNull(c4) ? null : F0.q0(c4);
                String q034 = F0.isNull(c5) ? null : F0.q0(c5);
                Long valueOf10 = F0.isNull(c6) ? null : Long.valueOf(F0.getLong(c6));
                String q035 = F0.isNull(c7) ? null : F0.q0(c7);
                String q036 = F0.isNull(c8) ? null : F0.q0(c8);
                String q037 = F0.isNull(c9) ? null : F0.q0(c9);
                Long valueOf11 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf12 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                long j = F0.getLong(c12);
                int i47 = (int) F0.getLong(c13);
                int i48 = (int) F0.getLong(c14);
                int i49 = (int) F0.getLong(c15);
                long j2 = F0.getLong(c16);
                long j3 = F0.getLong(c17);
                int i50 = (int) F0.getLong(c18);
                int i51 = (int) F0.getLong(c19);
                int i52 = (int) F0.getLong(c20);
                int i53 = (int) F0.getLong(c21);
                int i54 = (int) F0.getLong(c22);
                int i55 = (int) F0.getLong(c23);
                int i56 = (int) F0.getLong(c24);
                int i57 = (int) F0.getLong(c25);
                int i58 = (int) F0.getLong(c26);
                int i59 = (int) F0.getLong(c27);
                int i60 = (int) F0.getLong(c28);
                if (F0.isNull(c29)) {
                    i2 = c30;
                    q0 = null;
                } else {
                    q0 = F0.q0(c29);
                    i2 = c30;
                }
                if (F0.isNull(i2)) {
                    i3 = c31;
                    q02 = null;
                } else {
                    q02 = F0.q0(i2);
                    i3 = c31;
                }
                if (F0.isNull(i3)) {
                    i4 = c32;
                    q03 = null;
                } else {
                    q03 = F0.q0(i3);
                    i4 = c32;
                }
                if (F0.isNull(i4)) {
                    i5 = c33;
                    q04 = null;
                } else {
                    q04 = F0.q0(i4);
                    i5 = c33;
                }
                long j4 = F0.getLong(i5);
                int i61 = (int) F0.getLong(c34);
                int i62 = (int) F0.getLong(c35);
                if (F0.isNull(c36)) {
                    i6 = c37;
                    q05 = null;
                } else {
                    q05 = F0.q0(c36);
                    i6 = c37;
                }
                if (F0.isNull(i6)) {
                    i7 = c38;
                    q06 = null;
                } else {
                    q06 = F0.q0(i6);
                    i7 = c38;
                }
                long j5 = F0.getLong(i7);
                if (F0.isNull(c39)) {
                    i8 = c40;
                    q07 = null;
                } else {
                    q07 = F0.q0(c39);
                    i8 = c40;
                }
                if (F0.isNull(i8)) {
                    i9 = c41;
                    q08 = null;
                } else {
                    q08 = F0.q0(i8);
                    i9 = c41;
                }
                long j6 = F0.getLong(i9);
                int i63 = (int) F0.getLong(c42);
                long j7 = F0.getLong(c43);
                if (F0.isNull(c44)) {
                    i10 = i63;
                    i11 = c45;
                    q09 = null;
                } else {
                    i10 = i63;
                    q09 = F0.q0(c44);
                    i11 = c45;
                }
                int i64 = (int) F0.getLong(i11);
                if (F0.isNull(c46)) {
                    i12 = c47;
                    q010 = null;
                } else {
                    q010 = F0.q0(c46);
                    i12 = c47;
                }
                if (F0.isNull(i12)) {
                    i13 = i64;
                    i14 = c48;
                    q011 = null;
                } else {
                    i13 = i64;
                    q011 = F0.q0(i12);
                    i14 = c48;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c49;
                    z = true;
                } else {
                    i15 = c49;
                    z = false;
                }
                if (((int) F0.getLong(i15)) != 0) {
                    i16 = c50;
                    z2 = true;
                } else {
                    i16 = c50;
                    z2 = false;
                }
                int i65 = (int) F0.getLong(i16);
                if (F0.isNull(c51)) {
                    i17 = c52;
                    q012 = null;
                } else {
                    q012 = F0.q0(c51);
                    i17 = c52;
                }
                if (F0.isNull(i17)) {
                    i18 = i65;
                    i19 = c53;
                    valueOf = null;
                } else {
                    i18 = i65;
                    valueOf = Integer.valueOf((int) F0.getLong(i17));
                    i19 = c53;
                }
                if (F0.isNull(i19)) {
                    i20 = c54;
                    q013 = null;
                } else {
                    q013 = F0.q0(i19);
                    i20 = c54;
                }
                if (F0.isNull(i20)) {
                    i21 = c55;
                    q014 = null;
                } else {
                    q014 = F0.q0(i20);
                    i21 = c55;
                }
                if (F0.isNull(i21)) {
                    i22 = c56;
                    q015 = null;
                } else {
                    q015 = F0.q0(i21);
                    i22 = c56;
                }
                if (F0.isNull(i22)) {
                    i23 = c57;
                    q016 = null;
                } else {
                    q016 = F0.q0(i22);
                    i23 = c57;
                }
                if (F0.isNull(i23)) {
                    i24 = c58;
                    q017 = null;
                } else {
                    q017 = F0.q0(i23);
                    i24 = c58;
                }
                if (F0.isNull(i24)) {
                    i25 = c59;
                    q018 = null;
                } else {
                    q018 = F0.q0(i24);
                    i25 = c59;
                }
                if (F0.isNull(i25)) {
                    i26 = c60;
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf((int) F0.getLong(i25));
                    i26 = c60;
                }
                if (F0.isNull(i26)) {
                    i27 = c61;
                    q019 = null;
                } else {
                    q019 = F0.q0(i26);
                    i27 = c61;
                }
                if (F0.isNull(i27)) {
                    i28 = c62;
                    q020 = null;
                } else {
                    q020 = F0.q0(i27);
                    i28 = c62;
                }
                if (F0.isNull(i28)) {
                    i29 = c63;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(F0.getLong(i28));
                    i29 = c63;
                }
                if (F0.isNull(i29)) {
                    i30 = c64;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(i29));
                    i30 = c64;
                }
                if (F0.isNull(i30)) {
                    i31 = c65;
                    q021 = null;
                } else {
                    q021 = F0.q0(i30);
                    i31 = c65;
                }
                if (F0.isNull(i31)) {
                    i32 = c66;
                    q022 = null;
                } else {
                    q022 = F0.q0(i31);
                    i32 = c66;
                }
                if (F0.isNull(i32)) {
                    i33 = c67;
                    q023 = null;
                } else {
                    q023 = F0.q0(i32);
                    i33 = c67;
                }
                if (F0.isNull(i33)) {
                    i34 = c68;
                    q024 = null;
                } else {
                    q024 = F0.q0(i33);
                    i34 = c68;
                }
                if (F0.isNull(i34)) {
                    i35 = c69;
                    q025 = null;
                } else {
                    q025 = F0.q0(i34);
                    i35 = c69;
                }
                if (F0.isNull(i35)) {
                    i36 = c70;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf((int) F0.getLong(i35));
                    i36 = c70;
                }
                if (F0.isNull(i36)) {
                    i37 = c71;
                    q026 = null;
                } else {
                    q026 = F0.q0(i36);
                    i37 = c71;
                }
                if (F0.isNull(i37)) {
                    i38 = c72;
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf((int) F0.getLong(i37));
                    i38 = c72;
                }
                if (F0.isNull(i38)) {
                    i39 = c73;
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf((int) F0.getLong(i38));
                    i39 = c73;
                }
                if (F0.isNull(i39)) {
                    i40 = c74;
                    valueOf8 = null;
                } else {
                    valueOf8 = Integer.valueOf((int) F0.getLong(i39));
                    i40 = c74;
                }
                if (F0.isNull(i40)) {
                    i41 = c75;
                    valueOf9 = null;
                } else {
                    valueOf9 = Integer.valueOf((int) F0.getLong(i40));
                    i41 = c75;
                }
                if (F0.isNull(i41)) {
                    i42 = c76;
                    q027 = null;
                } else {
                    q027 = F0.q0(i41);
                    i42 = c76;
                }
                if (F0.isNull(i42)) {
                    i43 = c77;
                    q028 = null;
                } else {
                    q028 = F0.q0(i42);
                    i43 = c77;
                }
                if (F0.isNull(i43)) {
                    i44 = c78;
                    q029 = null;
                } else {
                    q029 = F0.q0(i43);
                    i44 = c78;
                }
                if (F0.isNull(i44)) {
                    i45 = c79;
                    q030 = null;
                } else {
                    q030 = F0.q0(i44);
                    i45 = c79;
                }
                if (((int) F0.getLong(i45)) != 0) {
                    i46 = c80;
                    z3 = true;
                } else {
                    i46 = c80;
                    z3 = false;
                }
                downloadBean = new DownloadBean(q031, q032, q033, q034, valueOf10, q035, q036, q037, valueOf11, valueOf12, j, i47, i48, i49, j2, j3, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, i60, q0, q02, q03, q04, j4, i61, i62, q05, q06, j5, q07, q08, j6, i10, j7, q09, i13, q010, q011, z, z2, i18, q012, valueOf, q013, q014, q015, q016, q017, q018, valueOf2, q019, q020, valueOf3, valueOf4, q021, q022, q023, q024, q025, valueOf5, q026, valueOf6, valueOf7, valueOf8, valueOf9, q027, q028, q029, q030, z3, F0.isNull(i46) ? null : F0.q0(i46), F0.isNull(c81) ? null : F0.q0(c81));
            }
            F0.close();
            return downloadBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    @Override // ui.c
    public Object A(final String str, final int i, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.e0
            public final Object invoke(Object obj) {
                DownloadBean w0;
                w0 = l0.w0(str, i, (y3.b) obj);
                return w0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object B(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.m
            public final Object invoke(Object obj) {
                DownloadBean G0;
                G0 = l0.G0((y3.b) obj);
                return G0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object C(final String str, final long j, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.w
            public final Object invoke(Object obj) {
                Unit S0;
                S0 = l0.S0(j, str, (y3.b) obj);
                return S0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object D(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.z
            public final Object invoke(Object obj) {
                DownloadBean x0;
                x0 = l0.x0(str, (y3.b) obj);
                return x0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object E(final String str, final int i, final int i2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.h
            public final Object invoke(Object obj) {
                DownloadBean L0;
                L0 = l0.L0(str, i, i2, (y3.b) obj);
                return L0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object F(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.j0
            public final Object invoke(Object obj) {
                DownloadBean H0;
                H0 = l0.H0(str, (y3.b) obj);
                return H0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object G(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.u
            public final Object invoke(Object obj) {
                List y0;
                y0 = l0.y0(str, (y3.b) obj);
                return y0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object H(final String str, final String str2, final String str3, final String str4, final Integer num, final String str5, final String str6, final String str7, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.n
            public final Object invoke(Object obj) {
                Unit W0;
                W0 = l0.W0(str2, str3, str4, str6, num, str5, str7, str, (y3.b) obj);
                return W0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.c0
            public final Object invoke(Object obj) {
                Unit s0;
                s0 = l0.s0(str, (y3.b) obj);
                return s0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object b(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.d0
            public final Object invoke(Object obj) {
                Unit X0;
                X0 = l0.X0(str2, str, (y3.b) obj);
                return X0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object c(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.l
            public final Object invoke(Object obj) {
                List J0;
                J0 = l0.J0(str, (y3.b) obj);
                return J0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.h0
            public final Object invoke(Object obj) {
                DownloadBean v0;
                v0 = l0.v0(str, (y3.b) obj);
                return v0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object e(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.p
            public final Object invoke(Object obj) {
                List K0;
                K0 = l0.K0(str, (y3.b) obj);
                return K0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object f(final String str, final int i, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.y
            public final Object invoke(Object obj) {
                DownloadBean z0;
                z0 = l0.z0(str, i, (y3.b) obj);
                return z0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object g(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.f0
            public final Object invoke(Object obj) {
                List D0;
                D0 = l0.D0((y3.b) obj);
                return D0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object h(final String str, final int i, final int i2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.x
            public final Object invoke(Object obj) {
                Unit Y0;
                Y0 = l0.Y0(i, i2, str, (y3.b) obj);
                return Y0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object i(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.g0
            public final Object invoke(Object obj) {
                DownloadBean P0;
                P0 = l0.P0(str, (y3.b) obj);
                return P0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object j(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.j
            public final Object invoke(Object obj) {
                List N0;
                N0 = l0.N0((y3.b) obj);
                return N0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object k(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.q
            public final Object invoke(Object obj) {
                List F0;
                F0 = l0.F0((y3.b) obj);
                return F0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object l(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.t
            public final Object invoke(Object obj) {
                Unit t0;
                t0 = l0.t0(str, (y3.b) obj);
                return t0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object m(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.b0
            public final Object invoke(Object obj) {
                Unit r0;
                r0 = l0.r0(str, (y3.b) obj);
                return r0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object n(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.i
            public final Object invoke(Object obj) {
                List M0;
                M0 = l0.M0((y3.b) obj);
                return M0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object o(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.k
            public final Object invoke(Object obj) {
                List u0;
                u0 = l0.u0(str, (y3.b) obj);
                return u0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object p(final int i, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.e
            public final Object invoke(Object obj) {
                List I0;
                I0 = l0.I0(i, (y3.b) obj);
                return I0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object q(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.a0
            public final Object invoke(Object obj) {
                List A0;
                A0 = l0.A0((y3.b) obj);
                return A0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object r(final String str, final long j, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.f
            public final Object invoke(Object obj) {
                Unit U0;
                U0 = l0.U0(j, str, (y3.b) obj);
                return U0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object s(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.d
            public final Object invoke(Object obj) {
                List C0;
                C0 = l0.C0(str, (y3.b) obj);
                return C0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object t(final DownloadBean downloadBean, Continuation continuation) {
        downloadBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.g
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = l0.this.Q0(downloadBean, (y3.b) obj);
                return Q0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object u(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.s
            public final Object invoke(Object obj) {
                List E0;
                E0 = l0.E0(str, (y3.b) obj);
                return E0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object v(final String str, final long j, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.k0
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = l0.T0(j, str, (y3.b) obj);
                return T0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object w(final String str, final int i, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.v
            public final Object invoke(Object obj) {
                Unit V0;
                V0 = l0.V0(i, str, (y3.b) obj);
                return V0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object x(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.r
            public final Object invoke(Object obj) {
                DownloadBean B0;
                B0 = l0.B0((y3.b) obj);
                return B0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object y(final DownloadBean downloadBean, Continuation continuation) {
        downloadBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.i0
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = l0.this.R0(downloadBean, (y3.b) obj);
                return R0;
            }
        }, continuation);
    }

    @Override // ui.c
    public Object z(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.o
            public final Object invoke(Object obj) {
                List O0;
                O0 = l0.O0(str, (y3.b) obj);
                return O0;
            }
        }, continuation);
    }
}
