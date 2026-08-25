package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j0 implements UGCVideoDetailPlayDao {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();
    private final androidx.room.e d = new c();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `ugc_video_detail_play` (`collectionId`,`ugcVideoId`,`progress`,`title`,`coverUrl`,`thumbnail`,`position`,`type`,`cateLev1Id`,`cateLev2Id`,`cateLev3Id`,`cateLev4Id`,`timeStamp`,`subtitleSelectId`,`totalDuration`,`subjectDurationSeconds`,`averageHueLight`,`subjectType`,`hasDelete`,`playMode`,`downloadUrl`,`downloadResid`,`downloadFilePath`,`downloadSize`,`lastAdStartTimeStamp`,`lastAdEndTimeStamp`,`rewardPlayed`,`rewardUnlock`,`rewardFree`,`ops`,`uid`,`userName`,`userAvatar`,`description`,`videoStyle`,`kidId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, UGCVideoDetailPlayBean uGCVideoDetailPlayBean) {
            if (uGCVideoDetailPlayBean.getCollectionId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, uGCVideoDetailPlayBean.getCollectionId());
            }
            if (uGCVideoDetailPlayBean.getUgcVideoId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, uGCVideoDetailPlayBean.getUgcVideoId());
            }
            eVar.c(3, uGCVideoDetailPlayBean.getProgress());
            if (uGCVideoDetailPlayBean.getTitle() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, uGCVideoDetailPlayBean.getTitle());
            }
            if (uGCVideoDetailPlayBean.getCoverUrl() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, uGCVideoDetailPlayBean.getCoverUrl());
            }
            if (uGCVideoDetailPlayBean.getThumbnail() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, uGCVideoDetailPlayBean.getThumbnail());
            }
            eVar.c(7, uGCVideoDetailPlayBean.getPosition());
            if (uGCVideoDetailPlayBean.getType() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, uGCVideoDetailPlayBean.getType());
            }
            if (uGCVideoDetailPlayBean.getCateLev1Id() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, uGCVideoDetailPlayBean.getCateLev1Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev2Id() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, uGCVideoDetailPlayBean.getCateLev2Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev3Id() == null) {
                eVar.g(11);
            } else {
                eVar.c(11, uGCVideoDetailPlayBean.getCateLev3Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev4Id() == null) {
                eVar.g(12);
            } else {
                eVar.c(12, uGCVideoDetailPlayBean.getCateLev4Id().intValue());
            }
            eVar.c(13, uGCVideoDetailPlayBean.getTimeStamp());
            if (uGCVideoDetailPlayBean.getSubtitleSelectId() == null) {
                eVar.g(14);
            } else {
                eVar.i(14, uGCVideoDetailPlayBean.getSubtitleSelectId());
            }
            if (uGCVideoDetailPlayBean.getTotalDuration() == null) {
                eVar.g(15);
            } else {
                eVar.c(15, uGCVideoDetailPlayBean.getTotalDuration().longValue());
            }
            if (uGCVideoDetailPlayBean.getSubjectDurationSeconds() == null) {
                eVar.g(16);
            } else {
                eVar.c(16, uGCVideoDetailPlayBean.getSubjectDurationSeconds().longValue());
            }
            if (uGCVideoDetailPlayBean.getAverageHueLight() == null) {
                eVar.g(17);
            } else {
                eVar.i(17, uGCVideoDetailPlayBean.getAverageHueLight());
            }
            if (uGCVideoDetailPlayBean.getSubjectType() == null) {
                eVar.g(18);
            } else {
                eVar.c(18, uGCVideoDetailPlayBean.getSubjectType().intValue());
            }
            eVar.c(19, uGCVideoDetailPlayBean.getHasDelete() ? 1L : 0L);
            if (uGCVideoDetailPlayBean.getPlayMode() == null) {
                eVar.g(20);
            } else {
                eVar.i(20, uGCVideoDetailPlayBean.getPlayMode());
            }
            if (uGCVideoDetailPlayBean.getDownloadUrl() == null) {
                eVar.g(21);
            } else {
                eVar.i(21, uGCVideoDetailPlayBean.getDownloadUrl());
            }
            if (uGCVideoDetailPlayBean.getDownloadResid() == null) {
                eVar.g(22);
            } else {
                eVar.i(22, uGCVideoDetailPlayBean.getDownloadResid());
            }
            if (uGCVideoDetailPlayBean.getDownloadFilePath() == null) {
                eVar.g(23);
            } else {
                eVar.i(23, uGCVideoDetailPlayBean.getDownloadFilePath());
            }
            eVar.c(24, uGCVideoDetailPlayBean.getDownloadSize());
            if (uGCVideoDetailPlayBean.getLastAdStartTimeStamp() == null) {
                eVar.g(25);
            } else {
                eVar.c(25, uGCVideoDetailPlayBean.getLastAdStartTimeStamp().longValue());
            }
            if (uGCVideoDetailPlayBean.getLastAdEndTimeStamp() == null) {
                eVar.g(26);
            } else {
                eVar.c(26, uGCVideoDetailPlayBean.getLastAdEndTimeStamp().longValue());
            }
            eVar.c(27, uGCVideoDetailPlayBean.getRewardPlayed() ? 1L : 0L);
            eVar.c(28, uGCVideoDetailPlayBean.getRewardUnlock() ? 1L : 0L);
            eVar.c(29, uGCVideoDetailPlayBean.getRewardFree() ? 1L : 0L);
            if (uGCVideoDetailPlayBean.getOps() == null) {
                eVar.g(30);
            } else {
                eVar.i(30, uGCVideoDetailPlayBean.getOps());
            }
            if (uGCVideoDetailPlayBean.getUid() == null) {
                eVar.g(31);
            } else {
                eVar.i(31, uGCVideoDetailPlayBean.getUid());
            }
            if (uGCVideoDetailPlayBean.getUserName() == null) {
                eVar.g(32);
            } else {
                eVar.i(32, uGCVideoDetailPlayBean.getUserName());
            }
            if (uGCVideoDetailPlayBean.getUserAvatar() == null) {
                eVar.g(33);
            } else {
                eVar.i(33, uGCVideoDetailPlayBean.getUserAvatar());
            }
            if (uGCVideoDetailPlayBean.getDescription() == null) {
                eVar.g(34);
            } else {
                eVar.i(34, uGCVideoDetailPlayBean.getDescription());
            }
            if (uGCVideoDetailPlayBean.getVideoStyle() == null) {
                eVar.g(35);
            } else {
                eVar.i(35, uGCVideoDetailPlayBean.getVideoStyle());
            }
            if (uGCVideoDetailPlayBean.getKidId() == null) {
                eVar.g(36);
            } else {
                eVar.i(36, uGCVideoDetailPlayBean.getKidId());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `ugc_video_detail_play` WHERE `collectionId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, UGCVideoDetailPlayBean uGCVideoDetailPlayBean) {
            if (uGCVideoDetailPlayBean.getCollectionId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, uGCVideoDetailPlayBean.getCollectionId());
            }
        }
    }

    class c extends androidx.room.e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `ugc_video_detail_play` SET `collectionId` = ?,`ugcVideoId` = ?,`progress` = ?,`title` = ?,`coverUrl` = ?,`thumbnail` = ?,`position` = ?,`type` = ?,`cateLev1Id` = ?,`cateLev2Id` = ?,`cateLev3Id` = ?,`cateLev4Id` = ?,`timeStamp` = ?,`subtitleSelectId` = ?,`totalDuration` = ?,`subjectDurationSeconds` = ?,`averageHueLight` = ?,`subjectType` = ?,`hasDelete` = ?,`playMode` = ?,`downloadUrl` = ?,`downloadResid` = ?,`downloadFilePath` = ?,`downloadSize` = ?,`lastAdStartTimeStamp` = ?,`lastAdEndTimeStamp` = ?,`rewardPlayed` = ?,`rewardUnlock` = ?,`rewardFree` = ?,`ops` = ?,`uid` = ?,`userName` = ?,`userAvatar` = ?,`description` = ?,`videoStyle` = ?,`kidId` = ? WHERE `collectionId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, UGCVideoDetailPlayBean uGCVideoDetailPlayBean) {
            if (uGCVideoDetailPlayBean.getCollectionId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, uGCVideoDetailPlayBean.getCollectionId());
            }
            if (uGCVideoDetailPlayBean.getUgcVideoId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, uGCVideoDetailPlayBean.getUgcVideoId());
            }
            eVar.c(3, uGCVideoDetailPlayBean.getProgress());
            if (uGCVideoDetailPlayBean.getTitle() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, uGCVideoDetailPlayBean.getTitle());
            }
            if (uGCVideoDetailPlayBean.getCoverUrl() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, uGCVideoDetailPlayBean.getCoverUrl());
            }
            if (uGCVideoDetailPlayBean.getThumbnail() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, uGCVideoDetailPlayBean.getThumbnail());
            }
            eVar.c(7, uGCVideoDetailPlayBean.getPosition());
            if (uGCVideoDetailPlayBean.getType() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, uGCVideoDetailPlayBean.getType());
            }
            if (uGCVideoDetailPlayBean.getCateLev1Id() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, uGCVideoDetailPlayBean.getCateLev1Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev2Id() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, uGCVideoDetailPlayBean.getCateLev2Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev3Id() == null) {
                eVar.g(11);
            } else {
                eVar.c(11, uGCVideoDetailPlayBean.getCateLev3Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev4Id() == null) {
                eVar.g(12);
            } else {
                eVar.c(12, uGCVideoDetailPlayBean.getCateLev4Id().intValue());
            }
            eVar.c(13, uGCVideoDetailPlayBean.getTimeStamp());
            if (uGCVideoDetailPlayBean.getSubtitleSelectId() == null) {
                eVar.g(14);
            } else {
                eVar.i(14, uGCVideoDetailPlayBean.getSubtitleSelectId());
            }
            if (uGCVideoDetailPlayBean.getTotalDuration() == null) {
                eVar.g(15);
            } else {
                eVar.c(15, uGCVideoDetailPlayBean.getTotalDuration().longValue());
            }
            if (uGCVideoDetailPlayBean.getSubjectDurationSeconds() == null) {
                eVar.g(16);
            } else {
                eVar.c(16, uGCVideoDetailPlayBean.getSubjectDurationSeconds().longValue());
            }
            if (uGCVideoDetailPlayBean.getAverageHueLight() == null) {
                eVar.g(17);
            } else {
                eVar.i(17, uGCVideoDetailPlayBean.getAverageHueLight());
            }
            if (uGCVideoDetailPlayBean.getSubjectType() == null) {
                eVar.g(18);
            } else {
                eVar.c(18, uGCVideoDetailPlayBean.getSubjectType().intValue());
            }
            eVar.c(19, uGCVideoDetailPlayBean.getHasDelete() ? 1L : 0L);
            if (uGCVideoDetailPlayBean.getPlayMode() == null) {
                eVar.g(20);
            } else {
                eVar.i(20, uGCVideoDetailPlayBean.getPlayMode());
            }
            if (uGCVideoDetailPlayBean.getDownloadUrl() == null) {
                eVar.g(21);
            } else {
                eVar.i(21, uGCVideoDetailPlayBean.getDownloadUrl());
            }
            if (uGCVideoDetailPlayBean.getDownloadResid() == null) {
                eVar.g(22);
            } else {
                eVar.i(22, uGCVideoDetailPlayBean.getDownloadResid());
            }
            if (uGCVideoDetailPlayBean.getDownloadFilePath() == null) {
                eVar.g(23);
            } else {
                eVar.i(23, uGCVideoDetailPlayBean.getDownloadFilePath());
            }
            eVar.c(24, uGCVideoDetailPlayBean.getDownloadSize());
            if (uGCVideoDetailPlayBean.getLastAdStartTimeStamp() == null) {
                eVar.g(25);
            } else {
                eVar.c(25, uGCVideoDetailPlayBean.getLastAdStartTimeStamp().longValue());
            }
            if (uGCVideoDetailPlayBean.getLastAdEndTimeStamp() == null) {
                eVar.g(26);
            } else {
                eVar.c(26, uGCVideoDetailPlayBean.getLastAdEndTimeStamp().longValue());
            }
            eVar.c(27, uGCVideoDetailPlayBean.getRewardPlayed() ? 1L : 0L);
            eVar.c(28, uGCVideoDetailPlayBean.getRewardUnlock() ? 1L : 0L);
            eVar.c(29, uGCVideoDetailPlayBean.getRewardFree() ? 1L : 0L);
            if (uGCVideoDetailPlayBean.getOps() == null) {
                eVar.g(30);
            } else {
                eVar.i(30, uGCVideoDetailPlayBean.getOps());
            }
            if (uGCVideoDetailPlayBean.getUid() == null) {
                eVar.g(31);
            } else {
                eVar.i(31, uGCVideoDetailPlayBean.getUid());
            }
            if (uGCVideoDetailPlayBean.getUserName() == null) {
                eVar.g(32);
            } else {
                eVar.i(32, uGCVideoDetailPlayBean.getUserName());
            }
            if (uGCVideoDetailPlayBean.getUserAvatar() == null) {
                eVar.g(33);
            } else {
                eVar.i(33, uGCVideoDetailPlayBean.getUserAvatar());
            }
            if (uGCVideoDetailPlayBean.getDescription() == null) {
                eVar.g(34);
            } else {
                eVar.i(34, uGCVideoDetailPlayBean.getDescription());
            }
            if (uGCVideoDetailPlayBean.getVideoStyle() == null) {
                eVar.g(35);
            } else {
                eVar.i(35, uGCVideoDetailPlayBean.getVideoStyle());
            }
            if (uGCVideoDetailPlayBean.getKidId() == null) {
                eVar.g(36);
            } else {
                eVar.i(36, uGCVideoDetailPlayBean.getKidId());
            }
            if (uGCVideoDetailPlayBean.getCollectionId() == null) {
                eVar.g(37);
            } else {
                eVar.i(37, uGCVideoDetailPlayBean.getCollectionId());
            }
        }
    }

    public j0(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List P() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Q(y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM UGC_VIDEO_DETAIL_PLAY");
        try {
            F0.C0();
            return Unit.a;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit R(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM UGC_VIDEO_DETAIL_PLAY WHERE ugcVideoId=?");
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
    public static /* synthetic */ List S(String str, int i, int i2, y3.b bVar) {
        int i3;
        String q0;
        int i4;
        int i5;
        Integer valueOf;
        String q02;
        int i6;
        Long valueOf2;
        int i7;
        int i8;
        Long valueOf3;
        int i9;
        String str2;
        int i10;
        Integer valueOf4;
        int i11;
        int i12;
        boolean z;
        String q03;
        int i13;
        String q04;
        int i14;
        int i15;
        String q05;
        int i16;
        String q06;
        int i17;
        Long valueOf5;
        int i18;
        int i19;
        Long valueOf6;
        int i20;
        int i21;
        boolean z2;
        int i22;
        boolean z3;
        int i23;
        boolean z4;
        String q07;
        int i24;
        String q08;
        int i25;
        int i26;
        String q09;
        int i27;
        String q010;
        int i28;
        String q011;
        int i29;
        String q012;
        int i30;
        y3.e F0 = bVar.F0("SELECT * FROM ugc_video_detail_play WHERE kidId = ? AND coverUrl IS NOT NULL AND collectionId NOT LIKE 'SINGLE_%' AND rowid IN (SELECT rowid FROM (SELECT rowid, collectionId, MAX(timeStamp) as maxTimeStamp FROM ugc_video_detail_play WHERE kidId = ? AND coverUrl IS NOT NULL AND collectionId NOT LIKE 'SINGLE_%' GROUP BY collectionId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            F0.c(3, i);
            F0.c(4, i2);
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q013 = F0.isNull(c2) ? null : F0.q0(c2);
                String q014 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q015 = F0.isNull(c5) ? null : F0.q0(c5);
                String q016 = F0.isNull(c6) ? null : F0.q0(c6);
                if (F0.isNull(c7)) {
                    i4 = c3;
                    i3 = c4;
                    q0 = null;
                } else {
                    i3 = c4;
                    q0 = F0.q0(c7);
                    i4 = c3;
                }
                int i31 = (int) F0.getLong(c8);
                String q017 = F0.isNull(c9) ? null : F0.q0(c9);
                if (F0.isNull(c10)) {
                    i5 = c5;
                    valueOf = null;
                } else {
                    i5 = c5;
                    valueOf = Integer.valueOf((int) F0.getLong(c10));
                }
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i6 = c16;
                    q02 = null;
                } else {
                    q02 = F0.q0(c15);
                    i6 = c16;
                }
                if (F0.isNull(i6)) {
                    i7 = c17;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i6));
                    i7 = c17;
                }
                if (F0.isNull(i7)) {
                    i8 = c2;
                    valueOf3 = null;
                } else {
                    i8 = c2;
                    valueOf3 = Long.valueOf(F0.getLong(i7));
                }
                int i32 = c18;
                if (F0.isNull(i32)) {
                    c18 = i32;
                    i9 = c19;
                    str2 = null;
                } else {
                    String q018 = F0.q0(i32);
                    c18 = i32;
                    i9 = c19;
                    str2 = q018;
                }
                if (F0.isNull(i9)) {
                    i10 = i6;
                    c17 = i7;
                    i11 = c20;
                    valueOf4 = null;
                } else {
                    i10 = i6;
                    c17 = i7;
                    valueOf4 = Integer.valueOf((int) F0.getLong(i9));
                    i11 = c20;
                }
                int i33 = c6;
                if (((int) F0.getLong(i11)) != 0) {
                    i12 = c21;
                    z = true;
                } else {
                    i12 = c21;
                    z = false;
                }
                if (F0.isNull(i12)) {
                    i13 = c22;
                    q03 = null;
                } else {
                    q03 = F0.q0(i12);
                    i13 = c22;
                }
                if (F0.isNull(i13)) {
                    i14 = i9;
                    i15 = c23;
                    q04 = null;
                } else {
                    q04 = F0.q0(i13);
                    i14 = i9;
                    i15 = c23;
                }
                if (F0.isNull(i15)) {
                    c23 = i15;
                    i16 = c24;
                    q05 = null;
                } else {
                    q05 = F0.q0(i15);
                    c23 = i15;
                    i16 = c24;
                }
                if (F0.isNull(i16)) {
                    c24 = i16;
                    i17 = c25;
                    q06 = null;
                } else {
                    q06 = F0.q0(i16);
                    c24 = i16;
                    i17 = c25;
                }
                long j3 = F0.getLong(i17);
                c25 = i17;
                int i34 = c26;
                if (F0.isNull(i34)) {
                    c26 = i34;
                    i18 = c27;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i34));
                    c26 = i34;
                    i18 = c27;
                }
                if (F0.isNull(i18)) {
                    c27 = i18;
                    i19 = i12;
                    i20 = c28;
                    valueOf6 = null;
                } else {
                    i19 = i12;
                    valueOf6 = Long.valueOf(F0.getLong(i18));
                    c27 = i18;
                    i20 = c28;
                }
                int i35 = i11;
                if (((int) F0.getLong(i20)) != 0) {
                    i21 = c29;
                    z2 = true;
                } else {
                    i21 = c29;
                    z2 = false;
                }
                int i36 = i13;
                if (((int) F0.getLong(i21)) != 0) {
                    i22 = c30;
                    z3 = true;
                } else {
                    i22 = c30;
                    z3 = false;
                }
                int i37 = c7;
                if (((int) F0.getLong(i22)) != 0) {
                    i23 = c31;
                    z4 = true;
                } else {
                    i23 = c31;
                    z4 = false;
                }
                if (F0.isNull(i23)) {
                    i24 = c32;
                    q07 = null;
                } else {
                    q07 = F0.q0(i23);
                    i24 = c32;
                }
                if (F0.isNull(i24)) {
                    i25 = i20;
                    i26 = c33;
                    q08 = null;
                } else {
                    q08 = F0.q0(i24);
                    i25 = i20;
                    i26 = c33;
                }
                if (F0.isNull(i26)) {
                    c33 = i26;
                    i27 = c34;
                    q09 = null;
                } else {
                    c33 = i26;
                    q09 = F0.q0(i26);
                    i27 = c34;
                }
                if (F0.isNull(i27)) {
                    c34 = i27;
                    i28 = c35;
                    q010 = null;
                } else {
                    c34 = i27;
                    q010 = F0.q0(i27);
                    i28 = c35;
                }
                if (F0.isNull(i28)) {
                    c35 = i28;
                    i29 = c36;
                    q011 = null;
                } else {
                    c35 = i28;
                    q011 = F0.q0(i28);
                    i29 = c36;
                }
                if (F0.isNull(i29)) {
                    c36 = i29;
                    i30 = c37;
                    q012 = null;
                } else {
                    c36 = i29;
                    q012 = F0.q0(i29);
                    i30 = c37;
                }
                c37 = i30;
                arrayList.add(new UGCVideoDetailPlayBean(q013, q014, j, q015, q016, q0, i31, q017, valueOf, valueOf7, valueOf8, valueOf9, j2, q02, valueOf2, valueOf3, str2, valueOf4, z, q03, q04, q05, q06, j3, valueOf5, valueOf6, z2, z3, z4, q07, q08, q09, q010, q011, q012, F0.isNull(i30) ? null : F0.q0(i30)));
                c2 = i8;
                c31 = i23;
                c32 = i24;
                c16 = i10;
                c6 = i33;
                c19 = i14;
                c20 = i35;
                c22 = i36;
                c7 = i37;
                c3 = i4;
                c29 = i21;
                c30 = i22;
                c28 = i25;
                c4 = i3;
                c5 = i5;
                c21 = i19;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List T(int i, int i2, y3.b bVar) {
        int i3;
        String q0;
        int i4;
        int i5;
        Integer valueOf;
        String q02;
        int i6;
        Long valueOf2;
        int i7;
        int i8;
        Long valueOf3;
        String q03;
        int i9;
        int i10;
        int i11;
        Integer valueOf4;
        int i12;
        int i13;
        boolean z;
        String q04;
        int i14;
        String q05;
        int i15;
        int i16;
        String q06;
        int i17;
        String q07;
        int i18;
        Long valueOf5;
        int i19;
        int i20;
        Long valueOf6;
        int i21;
        int i22;
        boolean z2;
        int i23;
        boolean z3;
        int i24;
        boolean z4;
        String q08;
        int i25;
        String q09;
        int i26;
        String q010;
        int i27;
        String q011;
        int i28;
        String q012;
        int i29;
        String q013;
        int i30;
        y3.e F0 = bVar.F0("SELECT * FROM ugc_video_detail_play WHERE (kidId IS NULL OR kidId = '') AND coverUrl IS NOT NULL AND collectionId NOT LIKE 'SINGLE_%' AND rowid IN (SELECT rowid FROM (SELECT rowid, collectionId, MAX(timeStamp) as maxTimeStamp FROM ugc_video_detail_play WHERE (kidId IS NULL OR kidId = '') AND coverUrl IS NOT NULL AND collectionId NOT LIKE 'SINGLE_%' GROUP BY collectionId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?");
        try {
            F0.c(1, i);
            F0.c(2, i2);
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q014 = F0.isNull(c2) ? null : F0.q0(c2);
                String q015 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q016 = F0.isNull(c5) ? null : F0.q0(c5);
                String q017 = F0.isNull(c6) ? null : F0.q0(c6);
                if (F0.isNull(c7)) {
                    i4 = c2;
                    i3 = c3;
                    q0 = null;
                } else {
                    i3 = c3;
                    q0 = F0.q0(c7);
                    i4 = c2;
                }
                int i31 = (int) F0.getLong(c8);
                String q018 = F0.isNull(c9) ? null : F0.q0(c9);
                if (F0.isNull(c10)) {
                    i5 = c4;
                    valueOf = null;
                } else {
                    i5 = c4;
                    valueOf = Integer.valueOf((int) F0.getLong(c10));
                }
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i6 = c16;
                    q02 = null;
                } else {
                    q02 = F0.q0(c15);
                    i6 = c16;
                }
                if (F0.isNull(i6)) {
                    i7 = c17;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i6));
                    i7 = c17;
                }
                if (F0.isNull(i7)) {
                    c16 = i6;
                    i8 = c18;
                    valueOf3 = null;
                } else {
                    c16 = i6;
                    i8 = c18;
                    valueOf3 = Long.valueOf(F0.getLong(i7));
                }
                if (F0.isNull(i8)) {
                    c18 = i8;
                    i9 = c19;
                    q03 = null;
                } else {
                    q03 = F0.q0(i8);
                    c18 = i8;
                    i9 = c19;
                }
                if (F0.isNull(i9)) {
                    i10 = i7;
                    i11 = c5;
                    i12 = c20;
                    valueOf4 = null;
                } else {
                    i10 = i7;
                    i11 = c5;
                    valueOf4 = Integer.valueOf((int) F0.getLong(i9));
                    i12 = c20;
                }
                int i32 = c6;
                if (((int) F0.getLong(i12)) != 0) {
                    i13 = c21;
                    z = true;
                } else {
                    i13 = c21;
                    z = false;
                }
                if (F0.isNull(i13)) {
                    i14 = c22;
                    q04 = null;
                } else {
                    q04 = F0.q0(i13);
                    i14 = c22;
                }
                if (F0.isNull(i14)) {
                    i15 = i9;
                    i16 = c23;
                    q05 = null;
                } else {
                    q05 = F0.q0(i14);
                    i15 = i9;
                    i16 = c23;
                }
                if (F0.isNull(i16)) {
                    c23 = i16;
                    i17 = c24;
                    q06 = null;
                } else {
                    q06 = F0.q0(i16);
                    c23 = i16;
                    i17 = c24;
                }
                if (F0.isNull(i17)) {
                    c24 = i17;
                    i18 = c25;
                    q07 = null;
                } else {
                    q07 = F0.q0(i17);
                    c24 = i17;
                    i18 = c25;
                }
                long j3 = F0.getLong(i18);
                c25 = i18;
                int i33 = c26;
                if (F0.isNull(i33)) {
                    c26 = i33;
                    i19 = c27;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i33));
                    c26 = i33;
                    i19 = c27;
                }
                if (F0.isNull(i19)) {
                    c27 = i19;
                    i20 = i13;
                    i21 = c28;
                    valueOf6 = null;
                } else {
                    i20 = i13;
                    valueOf6 = Long.valueOf(F0.getLong(i19));
                    c27 = i19;
                    i21 = c28;
                }
                int i34 = i12;
                if (((int) F0.getLong(i21)) != 0) {
                    i22 = c29;
                    z2 = true;
                } else {
                    i22 = c29;
                    z2 = false;
                }
                int i35 = i14;
                int i36 = i21;
                if (((int) F0.getLong(i22)) != 0) {
                    i23 = c30;
                    z3 = true;
                } else {
                    i23 = c30;
                    z3 = false;
                }
                int i37 = i22;
                if (((int) F0.getLong(i23)) != 0) {
                    i24 = c31;
                    z4 = true;
                } else {
                    i24 = c31;
                    z4 = false;
                }
                if (F0.isNull(i24)) {
                    i25 = c32;
                    q08 = null;
                } else {
                    q08 = F0.q0(i24);
                    i25 = c32;
                }
                if (F0.isNull(i25)) {
                    c31 = i24;
                    i26 = c33;
                    q09 = null;
                } else {
                    c31 = i24;
                    q09 = F0.q0(i25);
                    i26 = c33;
                }
                if (F0.isNull(i26)) {
                    c33 = i26;
                    i27 = c34;
                    q010 = null;
                } else {
                    c33 = i26;
                    q010 = F0.q0(i26);
                    i27 = c34;
                }
                if (F0.isNull(i27)) {
                    c34 = i27;
                    i28 = c35;
                    q011 = null;
                } else {
                    c34 = i27;
                    q011 = F0.q0(i27);
                    i28 = c35;
                }
                if (F0.isNull(i28)) {
                    c35 = i28;
                    i29 = c36;
                    q012 = null;
                } else {
                    c35 = i28;
                    q012 = F0.q0(i28);
                    i29 = c36;
                }
                if (F0.isNull(i29)) {
                    c36 = i29;
                    i30 = c37;
                    q013 = null;
                } else {
                    c36 = i29;
                    q013 = F0.q0(i29);
                    i30 = c37;
                }
                c37 = i30;
                arrayList.add(new UGCVideoDetailPlayBean(q014, q015, j, q016, q017, q0, i31, q018, valueOf, valueOf7, valueOf8, valueOf9, j2, q02, valueOf2, valueOf3, q03, valueOf4, z, q04, q05, q06, q07, j3, valueOf5, valueOf6, z2, z3, z4, q08, q09, q010, q011, q012, q013, F0.isNull(i30) ? null : F0.q0(i30)));
                c32 = i25;
                c2 = i4;
                c3 = i3;
                c4 = i5;
                c21 = i20;
                int i38 = i23;
                c5 = i11;
                c17 = i10;
                c19 = i15;
                c22 = i35;
                c29 = i37;
                c30 = i38;
                c28 = i36;
                c6 = i32;
                c20 = i34;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean U(String str, y3.b bVar) {
        String q0;
        int i;
        Long valueOf;
        int i2;
        Long valueOf2;
        int i3;
        String q02;
        int i4;
        Integer valueOf3;
        int i5;
        boolean z;
        int i6;
        String q03;
        int i7;
        String q04;
        int i8;
        String q05;
        int i9;
        String q06;
        int i10;
        Long valueOf4;
        int i11;
        Long valueOf5;
        int i12;
        boolean z2;
        int i13;
        boolean z3;
        int i14;
        boolean z4;
        int i15;
        String q07;
        int i16;
        String q08;
        int i17;
        String q09;
        int i18;
        String q010;
        int i19;
        String q011;
        int i20;
        y3.e F0 = bVar.F0("SELECT * FROM UGC_VIDEO_DETAIL_PLAY WHERE ugcVideoId = ? AND collectionId NOT LIKE 'SINGLE_%' ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (F0.C0()) {
                String q012 = F0.isNull(c2) ? null : F0.q0(c2);
                String q013 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q014 = F0.isNull(c5) ? null : F0.q0(c5);
                String q015 = F0.isNull(c6) ? null : F0.q0(c6);
                String q016 = F0.isNull(c7) ? null : F0.q0(c7);
                int i21 = (int) F0.getLong(c8);
                String q017 = F0.isNull(c9) ? null : F0.q0(c9);
                Integer valueOf6 = F0.isNull(c10) ? null : Integer.valueOf((int) F0.getLong(c10));
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i = c16;
                }
                if (F0.isNull(i)) {
                    i2 = c17;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(F0.getLong(i));
                    i2 = c17;
                }
                if (F0.isNull(i2)) {
                    i3 = c18;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i2));
                    i3 = c18;
                }
                if (F0.isNull(i3)) {
                    i4 = c19;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c19;
                }
                if (F0.isNull(i4)) {
                    i5 = c20;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) F0.getLong(i4));
                    i5 = c20;
                }
                if (((int) F0.getLong(i5)) != 0) {
                    i6 = c21;
                    z = true;
                } else {
                    z = false;
                    i6 = c21;
                }
                if (F0.isNull(i6)) {
                    i7 = c22;
                    q03 = null;
                } else {
                    q03 = F0.q0(i6);
                    i7 = c22;
                }
                if (F0.isNull(i7)) {
                    i8 = c23;
                    q04 = null;
                } else {
                    q04 = F0.q0(i7);
                    i8 = c23;
                }
                if (F0.isNull(i8)) {
                    i9 = c24;
                    q05 = null;
                } else {
                    q05 = F0.q0(i8);
                    i9 = c24;
                }
                if (F0.isNull(i9)) {
                    i10 = c25;
                    q06 = null;
                } else {
                    q06 = F0.q0(i9);
                    i10 = c25;
                }
                long j3 = F0.getLong(i10);
                if (F0.isNull(c26)) {
                    i11 = c27;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(c26));
                    i11 = c27;
                }
                if (F0.isNull(i11)) {
                    i12 = c28;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i11));
                    i12 = c28;
                }
                if (((int) F0.getLong(i12)) != 0) {
                    i13 = c29;
                    z2 = true;
                } else {
                    z2 = false;
                    i13 = c29;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c30;
                    z3 = true;
                } else {
                    z3 = false;
                    i14 = c30;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c31;
                    z4 = true;
                } else {
                    z4 = false;
                    i15 = c31;
                }
                if (F0.isNull(i15)) {
                    i16 = c32;
                    q07 = null;
                } else {
                    q07 = F0.q0(i15);
                    i16 = c32;
                }
                if (F0.isNull(i16)) {
                    i17 = c33;
                    q08 = null;
                } else {
                    q08 = F0.q0(i16);
                    i17 = c33;
                }
                if (F0.isNull(i17)) {
                    i18 = c34;
                    q09 = null;
                } else {
                    q09 = F0.q0(i17);
                    i18 = c34;
                }
                if (F0.isNull(i18)) {
                    i19 = c35;
                    q010 = null;
                } else {
                    q010 = F0.q0(i18);
                    i19 = c35;
                }
                if (F0.isNull(i19)) {
                    i20 = c36;
                    q011 = null;
                } else {
                    q011 = F0.q0(i19);
                    i20 = c36;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(q012, q013, j, q014, q015, q016, i21, q017, valueOf6, valueOf7, valueOf8, valueOf9, j2, q0, valueOf, valueOf2, q02, valueOf3, z, q03, q04, q05, q06, j3, valueOf4, valueOf5, z2, z3, z4, q07, q08, q09, q010, q011, F0.isNull(i20) ? null : F0.q0(i20), F0.isNull(c37) ? null : F0.q0(c37));
            }
            F0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean V(String str, y3.b bVar) {
        String q0;
        int i;
        Long valueOf;
        int i2;
        Long valueOf2;
        int i3;
        String q02;
        int i4;
        Integer valueOf3;
        int i5;
        boolean z;
        int i6;
        String q03;
        int i7;
        String q04;
        int i8;
        String q05;
        int i9;
        String q06;
        int i10;
        Long valueOf4;
        int i11;
        Long valueOf5;
        int i12;
        boolean z2;
        int i13;
        boolean z3;
        int i14;
        boolean z4;
        int i15;
        String q07;
        int i16;
        String q08;
        int i17;
        String q09;
        int i18;
        String q010;
        int i19;
        String q011;
        int i20;
        y3.e F0 = bVar.F0("SELECT * FROM UGC_VIDEO_DETAIL_PLAY WHERE collectionId = ? ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (F0.C0()) {
                String q012 = F0.isNull(c2) ? null : F0.q0(c2);
                String q013 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q014 = F0.isNull(c5) ? null : F0.q0(c5);
                String q015 = F0.isNull(c6) ? null : F0.q0(c6);
                String q016 = F0.isNull(c7) ? null : F0.q0(c7);
                int i21 = (int) F0.getLong(c8);
                String q017 = F0.isNull(c9) ? null : F0.q0(c9);
                Integer valueOf6 = F0.isNull(c10) ? null : Integer.valueOf((int) F0.getLong(c10));
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i = c16;
                }
                if (F0.isNull(i)) {
                    i2 = c17;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(F0.getLong(i));
                    i2 = c17;
                }
                if (F0.isNull(i2)) {
                    i3 = c18;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i2));
                    i3 = c18;
                }
                if (F0.isNull(i3)) {
                    i4 = c19;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c19;
                }
                if (F0.isNull(i4)) {
                    i5 = c20;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) F0.getLong(i4));
                    i5 = c20;
                }
                if (((int) F0.getLong(i5)) != 0) {
                    i6 = c21;
                    z = true;
                } else {
                    z = false;
                    i6 = c21;
                }
                if (F0.isNull(i6)) {
                    i7 = c22;
                    q03 = null;
                } else {
                    q03 = F0.q0(i6);
                    i7 = c22;
                }
                if (F0.isNull(i7)) {
                    i8 = c23;
                    q04 = null;
                } else {
                    q04 = F0.q0(i7);
                    i8 = c23;
                }
                if (F0.isNull(i8)) {
                    i9 = c24;
                    q05 = null;
                } else {
                    q05 = F0.q0(i8);
                    i9 = c24;
                }
                if (F0.isNull(i9)) {
                    i10 = c25;
                    q06 = null;
                } else {
                    q06 = F0.q0(i9);
                    i10 = c25;
                }
                long j3 = F0.getLong(i10);
                if (F0.isNull(c26)) {
                    i11 = c27;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(c26));
                    i11 = c27;
                }
                if (F0.isNull(i11)) {
                    i12 = c28;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i11));
                    i12 = c28;
                }
                if (((int) F0.getLong(i12)) != 0) {
                    i13 = c29;
                    z2 = true;
                } else {
                    z2 = false;
                    i13 = c29;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c30;
                    z3 = true;
                } else {
                    z3 = false;
                    i14 = c30;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c31;
                    z4 = true;
                } else {
                    z4 = false;
                    i15 = c31;
                }
                if (F0.isNull(i15)) {
                    i16 = c32;
                    q07 = null;
                } else {
                    q07 = F0.q0(i15);
                    i16 = c32;
                }
                if (F0.isNull(i16)) {
                    i17 = c33;
                    q08 = null;
                } else {
                    q08 = F0.q0(i16);
                    i17 = c33;
                }
                if (F0.isNull(i17)) {
                    i18 = c34;
                    q09 = null;
                } else {
                    q09 = F0.q0(i17);
                    i18 = c34;
                }
                if (F0.isNull(i18)) {
                    i19 = c35;
                    q010 = null;
                } else {
                    q010 = F0.q0(i18);
                    i19 = c35;
                }
                if (F0.isNull(i19)) {
                    i20 = c36;
                    q011 = null;
                } else {
                    q011 = F0.q0(i19);
                    i20 = c36;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(q012, q013, j, q014, q015, q016, i21, q017, valueOf6, valueOf7, valueOf8, valueOf9, j2, q0, valueOf, valueOf2, q02, valueOf3, z, q03, q04, q05, q06, j3, valueOf4, valueOf5, z2, z3, z4, q07, q08, q09, q010, q011, F0.isNull(i20) ? null : F0.q0(i20), F0.isNull(c37) ? null : F0.q0(c37));
            }
            F0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean W(String str, String str2, y3.b bVar) {
        String q0;
        int i;
        Long valueOf;
        int i2;
        Long valueOf2;
        int i3;
        String q02;
        int i4;
        Integer valueOf3;
        int i5;
        boolean z;
        int i6;
        String q03;
        int i7;
        String q04;
        int i8;
        String q05;
        int i9;
        String q06;
        int i10;
        Long valueOf4;
        int i11;
        Long valueOf5;
        int i12;
        boolean z2;
        int i13;
        boolean z3;
        int i14;
        boolean z4;
        int i15;
        String q07;
        int i16;
        String q08;
        int i17;
        String q09;
        int i18;
        String q010;
        int i19;
        String q011;
        int i20;
        y3.e F0 = bVar.F0("SELECT * FROM UGC_VIDEO_DETAIL_PLAY WHERE ugcVideoId = ? AND collectionId = ? ORDER BY timeStamp DESC LIMIT 1");
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
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (F0.C0()) {
                String q012 = F0.isNull(c2) ? null : F0.q0(c2);
                String q013 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q014 = F0.isNull(c5) ? null : F0.q0(c5);
                String q015 = F0.isNull(c6) ? null : F0.q0(c6);
                String q016 = F0.isNull(c7) ? null : F0.q0(c7);
                int i21 = (int) F0.getLong(c8);
                String q017 = F0.isNull(c9) ? null : F0.q0(c9);
                Integer valueOf6 = F0.isNull(c10) ? null : Integer.valueOf((int) F0.getLong(c10));
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i = c16;
                }
                if (F0.isNull(i)) {
                    i2 = c17;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(F0.getLong(i));
                    i2 = c17;
                }
                if (F0.isNull(i2)) {
                    i3 = c18;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i2));
                    i3 = c18;
                }
                if (F0.isNull(i3)) {
                    i4 = c19;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c19;
                }
                if (F0.isNull(i4)) {
                    i5 = c20;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) F0.getLong(i4));
                    i5 = c20;
                }
                if (((int) F0.getLong(i5)) != 0) {
                    i6 = c21;
                    z = true;
                } else {
                    z = false;
                    i6 = c21;
                }
                if (F0.isNull(i6)) {
                    i7 = c22;
                    q03 = null;
                } else {
                    q03 = F0.q0(i6);
                    i7 = c22;
                }
                if (F0.isNull(i7)) {
                    i8 = c23;
                    q04 = null;
                } else {
                    q04 = F0.q0(i7);
                    i8 = c23;
                }
                if (F0.isNull(i8)) {
                    i9 = c24;
                    q05 = null;
                } else {
                    q05 = F0.q0(i8);
                    i9 = c24;
                }
                if (F0.isNull(i9)) {
                    i10 = c25;
                    q06 = null;
                } else {
                    q06 = F0.q0(i9);
                    i10 = c25;
                }
                long j3 = F0.getLong(i10);
                if (F0.isNull(c26)) {
                    i11 = c27;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(c26));
                    i11 = c27;
                }
                if (F0.isNull(i11)) {
                    i12 = c28;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i11));
                    i12 = c28;
                }
                if (((int) F0.getLong(i12)) != 0) {
                    i13 = c29;
                    z2 = true;
                } else {
                    z2 = false;
                    i13 = c29;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c30;
                    z3 = true;
                } else {
                    z3 = false;
                    i14 = c30;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c31;
                    z4 = true;
                } else {
                    z4 = false;
                    i15 = c31;
                }
                if (F0.isNull(i15)) {
                    i16 = c32;
                    q07 = null;
                } else {
                    q07 = F0.q0(i15);
                    i16 = c32;
                }
                if (F0.isNull(i16)) {
                    i17 = c33;
                    q08 = null;
                } else {
                    q08 = F0.q0(i16);
                    i17 = c33;
                }
                if (F0.isNull(i17)) {
                    i18 = c34;
                    q09 = null;
                } else {
                    q09 = F0.q0(i17);
                    i18 = c34;
                }
                if (F0.isNull(i18)) {
                    i19 = c35;
                    q010 = null;
                } else {
                    q010 = F0.q0(i18);
                    i19 = c35;
                }
                if (F0.isNull(i19)) {
                    i20 = c36;
                    q011 = null;
                } else {
                    q011 = F0.q0(i19);
                    i20 = c36;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(q012, q013, j, q014, q015, q016, i21, q017, valueOf6, valueOf7, valueOf8, valueOf9, j2, q0, valueOf, valueOf2, q02, valueOf3, z, q03, q04, q05, q06, j3, valueOf4, valueOf5, z2, z3, z4, q07, q08, q09, q010, q011, F0.isNull(i20) ? null : F0.q0(i20), F0.isNull(c37) ? null : F0.q0(c37));
            }
            F0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean X(String str, String str2, y3.b bVar) {
        String q0;
        int i;
        Long valueOf;
        int i2;
        Long valueOf2;
        int i3;
        String q02;
        int i4;
        Integer valueOf3;
        int i5;
        boolean z;
        int i6;
        String q03;
        int i7;
        String q04;
        int i8;
        String q05;
        int i9;
        String q06;
        int i10;
        Long valueOf4;
        int i11;
        Long valueOf5;
        int i12;
        boolean z2;
        int i13;
        boolean z3;
        int i14;
        boolean z4;
        int i15;
        String q07;
        int i16;
        String q08;
        int i17;
        String q09;
        int i18;
        String q010;
        int i19;
        String q011;
        int i20;
        y3.e F0 = bVar.F0("SELECT * FROM ugc_video_detail_play WHERE collectionId = ? AND kidId = ? ORDER BY timeStamp DESC LIMIT 1");
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
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (F0.C0()) {
                String q012 = F0.isNull(c2) ? null : F0.q0(c2);
                String q013 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q014 = F0.isNull(c5) ? null : F0.q0(c5);
                String q015 = F0.isNull(c6) ? null : F0.q0(c6);
                String q016 = F0.isNull(c7) ? null : F0.q0(c7);
                int i21 = (int) F0.getLong(c8);
                String q017 = F0.isNull(c9) ? null : F0.q0(c9);
                Integer valueOf6 = F0.isNull(c10) ? null : Integer.valueOf((int) F0.getLong(c10));
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i = c16;
                }
                if (F0.isNull(i)) {
                    i2 = c17;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(F0.getLong(i));
                    i2 = c17;
                }
                if (F0.isNull(i2)) {
                    i3 = c18;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i2));
                    i3 = c18;
                }
                if (F0.isNull(i3)) {
                    i4 = c19;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c19;
                }
                if (F0.isNull(i4)) {
                    i5 = c20;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) F0.getLong(i4));
                    i5 = c20;
                }
                if (((int) F0.getLong(i5)) != 0) {
                    i6 = c21;
                    z = true;
                } else {
                    z = false;
                    i6 = c21;
                }
                if (F0.isNull(i6)) {
                    i7 = c22;
                    q03 = null;
                } else {
                    q03 = F0.q0(i6);
                    i7 = c22;
                }
                if (F0.isNull(i7)) {
                    i8 = c23;
                    q04 = null;
                } else {
                    q04 = F0.q0(i7);
                    i8 = c23;
                }
                if (F0.isNull(i8)) {
                    i9 = c24;
                    q05 = null;
                } else {
                    q05 = F0.q0(i8);
                    i9 = c24;
                }
                if (F0.isNull(i9)) {
                    i10 = c25;
                    q06 = null;
                } else {
                    q06 = F0.q0(i9);
                    i10 = c25;
                }
                long j3 = F0.getLong(i10);
                if (F0.isNull(c26)) {
                    i11 = c27;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(c26));
                    i11 = c27;
                }
                if (F0.isNull(i11)) {
                    i12 = c28;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i11));
                    i12 = c28;
                }
                if (((int) F0.getLong(i12)) != 0) {
                    i13 = c29;
                    z2 = true;
                } else {
                    z2 = false;
                    i13 = c29;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c30;
                    z3 = true;
                } else {
                    z3 = false;
                    i14 = c30;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c31;
                    z4 = true;
                } else {
                    z4 = false;
                    i15 = c31;
                }
                if (F0.isNull(i15)) {
                    i16 = c32;
                    q07 = null;
                } else {
                    q07 = F0.q0(i15);
                    i16 = c32;
                }
                if (F0.isNull(i16)) {
                    i17 = c33;
                    q08 = null;
                } else {
                    q08 = F0.q0(i16);
                    i17 = c33;
                }
                if (F0.isNull(i17)) {
                    i18 = c34;
                    q09 = null;
                } else {
                    q09 = F0.q0(i17);
                    i18 = c34;
                }
                if (F0.isNull(i18)) {
                    i19 = c35;
                    q010 = null;
                } else {
                    q010 = F0.q0(i18);
                    i19 = c35;
                }
                if (F0.isNull(i19)) {
                    i20 = c36;
                    q011 = null;
                } else {
                    q011 = F0.q0(i19);
                    i20 = c36;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(q012, q013, j, q014, q015, q016, i21, q017, valueOf6, valueOf7, valueOf8, valueOf9, j2, q0, valueOf, valueOf2, q02, valueOf3, z, q03, q04, q05, q06, j3, valueOf4, valueOf5, z2, z3, z4, q07, q08, q09, q010, q011, F0.isNull(i20) ? null : F0.q0(i20), F0.isNull(c37) ? null : F0.q0(c37));
            }
            F0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean Y(String str, y3.b bVar) {
        String q0;
        int i;
        Long valueOf;
        int i2;
        Long valueOf2;
        int i3;
        String q02;
        int i4;
        Integer valueOf3;
        int i5;
        boolean z;
        int i6;
        String q03;
        int i7;
        String q04;
        int i8;
        String q05;
        int i9;
        String q06;
        int i10;
        Long valueOf4;
        int i11;
        Long valueOf5;
        int i12;
        boolean z2;
        int i13;
        boolean z3;
        int i14;
        boolean z4;
        int i15;
        String q07;
        int i16;
        String q08;
        int i17;
        String q09;
        int i18;
        String q010;
        int i19;
        String q011;
        int i20;
        y3.e F0 = bVar.F0("SELECT * FROM ugc_video_detail_play WHERE collectionId = ? AND (kidId IS NULL OR kidId = '') ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (F0.C0()) {
                String q012 = F0.isNull(c2) ? null : F0.q0(c2);
                String q013 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q014 = F0.isNull(c5) ? null : F0.q0(c5);
                String q015 = F0.isNull(c6) ? null : F0.q0(c6);
                String q016 = F0.isNull(c7) ? null : F0.q0(c7);
                int i21 = (int) F0.getLong(c8);
                String q017 = F0.isNull(c9) ? null : F0.q0(c9);
                Integer valueOf6 = F0.isNull(c10) ? null : Integer.valueOf((int) F0.getLong(c10));
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i = c16;
                }
                if (F0.isNull(i)) {
                    i2 = c17;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(F0.getLong(i));
                    i2 = c17;
                }
                if (F0.isNull(i2)) {
                    i3 = c18;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i2));
                    i3 = c18;
                }
                if (F0.isNull(i3)) {
                    i4 = c19;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c19;
                }
                if (F0.isNull(i4)) {
                    i5 = c20;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) F0.getLong(i4));
                    i5 = c20;
                }
                if (((int) F0.getLong(i5)) != 0) {
                    i6 = c21;
                    z = true;
                } else {
                    z = false;
                    i6 = c21;
                }
                if (F0.isNull(i6)) {
                    i7 = c22;
                    q03 = null;
                } else {
                    q03 = F0.q0(i6);
                    i7 = c22;
                }
                if (F0.isNull(i7)) {
                    i8 = c23;
                    q04 = null;
                } else {
                    q04 = F0.q0(i7);
                    i8 = c23;
                }
                if (F0.isNull(i8)) {
                    i9 = c24;
                    q05 = null;
                } else {
                    q05 = F0.q0(i8);
                    i9 = c24;
                }
                if (F0.isNull(i9)) {
                    i10 = c25;
                    q06 = null;
                } else {
                    q06 = F0.q0(i9);
                    i10 = c25;
                }
                long j3 = F0.getLong(i10);
                if (F0.isNull(c26)) {
                    i11 = c27;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(c26));
                    i11 = c27;
                }
                if (F0.isNull(i11)) {
                    i12 = c28;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i11));
                    i12 = c28;
                }
                if (((int) F0.getLong(i12)) != 0) {
                    i13 = c29;
                    z2 = true;
                } else {
                    z2 = false;
                    i13 = c29;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c30;
                    z3 = true;
                } else {
                    z3 = false;
                    i14 = c30;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c31;
                    z4 = true;
                } else {
                    z4 = false;
                    i15 = c31;
                }
                if (F0.isNull(i15)) {
                    i16 = c32;
                    q07 = null;
                } else {
                    q07 = F0.q0(i15);
                    i16 = c32;
                }
                if (F0.isNull(i16)) {
                    i17 = c33;
                    q08 = null;
                } else {
                    q08 = F0.q0(i16);
                    i17 = c33;
                }
                if (F0.isNull(i17)) {
                    i18 = c34;
                    q09 = null;
                } else {
                    q09 = F0.q0(i17);
                    i18 = c34;
                }
                if (F0.isNull(i18)) {
                    i19 = c35;
                    q010 = null;
                } else {
                    q010 = F0.q0(i18);
                    i19 = c35;
                }
                if (F0.isNull(i19)) {
                    i20 = c36;
                    q011 = null;
                } else {
                    q011 = F0.q0(i19);
                    i20 = c36;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(q012, q013, j, q014, q015, q016, i21, q017, valueOf6, valueOf7, valueOf8, valueOf9, j2, q0, valueOf, valueOf2, q02, valueOf3, z, q03, q04, q05, q06, j3, valueOf4, valueOf5, z2, z3, z4, q07, q08, q09, q010, q011, F0.isNull(i20) ? null : F0.q0(i20), F0.isNull(c37) ? null : F0.q0(c37));
            }
            F0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean Z(String str, String str2, String str3, y3.b bVar) {
        String q0;
        int i;
        Long valueOf;
        int i2;
        Long valueOf2;
        int i3;
        String q02;
        int i4;
        Integer valueOf3;
        int i5;
        boolean z;
        int i6;
        String q03;
        int i7;
        String q04;
        int i8;
        String q05;
        int i9;
        String q06;
        int i10;
        Long valueOf4;
        int i11;
        Long valueOf5;
        int i12;
        boolean z2;
        int i13;
        boolean z3;
        int i14;
        boolean z4;
        int i15;
        String q07;
        int i16;
        String q08;
        int i17;
        String q09;
        int i18;
        String q010;
        int i19;
        String q011;
        int i20;
        y3.e F0 = bVar.F0("SELECT * FROM ugc_video_detail_play WHERE collectionId = ? AND ugcVideoId = ? AND kidId = ? ORDER BY timeStamp DESC LIMIT 1");
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
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (F0.C0()) {
                String q012 = F0.isNull(c2) ? null : F0.q0(c2);
                String q013 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q014 = F0.isNull(c5) ? null : F0.q0(c5);
                String q015 = F0.isNull(c6) ? null : F0.q0(c6);
                String q016 = F0.isNull(c7) ? null : F0.q0(c7);
                int i21 = (int) F0.getLong(c8);
                String q017 = F0.isNull(c9) ? null : F0.q0(c9);
                Integer valueOf6 = F0.isNull(c10) ? null : Integer.valueOf((int) F0.getLong(c10));
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i = c16;
                }
                if (F0.isNull(i)) {
                    i2 = c17;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(F0.getLong(i));
                    i2 = c17;
                }
                if (F0.isNull(i2)) {
                    i3 = c18;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i2));
                    i3 = c18;
                }
                if (F0.isNull(i3)) {
                    i4 = c19;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c19;
                }
                if (F0.isNull(i4)) {
                    i5 = c20;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) F0.getLong(i4));
                    i5 = c20;
                }
                if (((int) F0.getLong(i5)) != 0) {
                    i6 = c21;
                    z = true;
                } else {
                    z = false;
                    i6 = c21;
                }
                if (F0.isNull(i6)) {
                    i7 = c22;
                    q03 = null;
                } else {
                    q03 = F0.q0(i6);
                    i7 = c22;
                }
                if (F0.isNull(i7)) {
                    i8 = c23;
                    q04 = null;
                } else {
                    q04 = F0.q0(i7);
                    i8 = c23;
                }
                if (F0.isNull(i8)) {
                    i9 = c24;
                    q05 = null;
                } else {
                    q05 = F0.q0(i8);
                    i9 = c24;
                }
                if (F0.isNull(i9)) {
                    i10 = c25;
                    q06 = null;
                } else {
                    q06 = F0.q0(i9);
                    i10 = c25;
                }
                long j3 = F0.getLong(i10);
                if (F0.isNull(c26)) {
                    i11 = c27;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(c26));
                    i11 = c27;
                }
                if (F0.isNull(i11)) {
                    i12 = c28;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i11));
                    i12 = c28;
                }
                if (((int) F0.getLong(i12)) != 0) {
                    i13 = c29;
                    z2 = true;
                } else {
                    z2 = false;
                    i13 = c29;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c30;
                    z3 = true;
                } else {
                    z3 = false;
                    i14 = c30;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c31;
                    z4 = true;
                } else {
                    z4 = false;
                    i15 = c31;
                }
                if (F0.isNull(i15)) {
                    i16 = c32;
                    q07 = null;
                } else {
                    q07 = F0.q0(i15);
                    i16 = c32;
                }
                if (F0.isNull(i16)) {
                    i17 = c33;
                    q08 = null;
                } else {
                    q08 = F0.q0(i16);
                    i17 = c33;
                }
                if (F0.isNull(i17)) {
                    i18 = c34;
                    q09 = null;
                } else {
                    q09 = F0.q0(i17);
                    i18 = c34;
                }
                if (F0.isNull(i18)) {
                    i19 = c35;
                    q010 = null;
                } else {
                    q010 = F0.q0(i18);
                    i19 = c35;
                }
                if (F0.isNull(i19)) {
                    i20 = c36;
                    q011 = null;
                } else {
                    q011 = F0.q0(i19);
                    i20 = c36;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(q012, q013, j, q014, q015, q016, i21, q017, valueOf6, valueOf7, valueOf8, valueOf9, j2, q0, valueOf, valueOf2, q02, valueOf3, z, q03, q04, q05, q06, j3, valueOf4, valueOf5, z2, z3, z4, q07, q08, q09, q010, q011, F0.isNull(i20) ? null : F0.q0(i20), F0.isNull(c37) ? null : F0.q0(c37));
            }
            F0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean a0(String str, String str2, y3.b bVar) {
        String q0;
        int i;
        Long valueOf;
        int i2;
        Long valueOf2;
        int i3;
        String q02;
        int i4;
        Integer valueOf3;
        int i5;
        boolean z;
        int i6;
        String q03;
        int i7;
        String q04;
        int i8;
        String q05;
        int i9;
        String q06;
        int i10;
        Long valueOf4;
        int i11;
        Long valueOf5;
        int i12;
        boolean z2;
        int i13;
        boolean z3;
        int i14;
        boolean z4;
        int i15;
        String q07;
        int i16;
        String q08;
        int i17;
        String q09;
        int i18;
        String q010;
        int i19;
        String q011;
        int i20;
        y3.e F0 = bVar.F0("SELECT * FROM ugc_video_detail_play WHERE collectionId = ? AND ugcVideoId = ? AND (kidId IS NULL OR kidId = '') ORDER BY timeStamp DESC LIMIT 1");
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
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (F0.C0()) {
                String q012 = F0.isNull(c2) ? null : F0.q0(c2);
                String q013 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q014 = F0.isNull(c5) ? null : F0.q0(c5);
                String q015 = F0.isNull(c6) ? null : F0.q0(c6);
                String q016 = F0.isNull(c7) ? null : F0.q0(c7);
                int i21 = (int) F0.getLong(c8);
                String q017 = F0.isNull(c9) ? null : F0.q0(c9);
                Integer valueOf6 = F0.isNull(c10) ? null : Integer.valueOf((int) F0.getLong(c10));
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i = c16;
                }
                if (F0.isNull(i)) {
                    i2 = c17;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(F0.getLong(i));
                    i2 = c17;
                }
                if (F0.isNull(i2)) {
                    i3 = c18;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i2));
                    i3 = c18;
                }
                if (F0.isNull(i3)) {
                    i4 = c19;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c19;
                }
                if (F0.isNull(i4)) {
                    i5 = c20;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) F0.getLong(i4));
                    i5 = c20;
                }
                if (((int) F0.getLong(i5)) != 0) {
                    i6 = c21;
                    z = true;
                } else {
                    z = false;
                    i6 = c21;
                }
                if (F0.isNull(i6)) {
                    i7 = c22;
                    q03 = null;
                } else {
                    q03 = F0.q0(i6);
                    i7 = c22;
                }
                if (F0.isNull(i7)) {
                    i8 = c23;
                    q04 = null;
                } else {
                    q04 = F0.q0(i7);
                    i8 = c23;
                }
                if (F0.isNull(i8)) {
                    i9 = c24;
                    q05 = null;
                } else {
                    q05 = F0.q0(i8);
                    i9 = c24;
                }
                if (F0.isNull(i9)) {
                    i10 = c25;
                    q06 = null;
                } else {
                    q06 = F0.q0(i9);
                    i10 = c25;
                }
                long j3 = F0.getLong(i10);
                if (F0.isNull(c26)) {
                    i11 = c27;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(F0.getLong(c26));
                    i11 = c27;
                }
                if (F0.isNull(i11)) {
                    i12 = c28;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i11));
                    i12 = c28;
                }
                if (((int) F0.getLong(i12)) != 0) {
                    i13 = c29;
                    z2 = true;
                } else {
                    z2 = false;
                    i13 = c29;
                }
                if (((int) F0.getLong(i13)) != 0) {
                    i14 = c30;
                    z3 = true;
                } else {
                    z3 = false;
                    i14 = c30;
                }
                if (((int) F0.getLong(i14)) != 0) {
                    i15 = c31;
                    z4 = true;
                } else {
                    z4 = false;
                    i15 = c31;
                }
                if (F0.isNull(i15)) {
                    i16 = c32;
                    q07 = null;
                } else {
                    q07 = F0.q0(i15);
                    i16 = c32;
                }
                if (F0.isNull(i16)) {
                    i17 = c33;
                    q08 = null;
                } else {
                    q08 = F0.q0(i16);
                    i17 = c33;
                }
                if (F0.isNull(i17)) {
                    i18 = c34;
                    q09 = null;
                } else {
                    q09 = F0.q0(i17);
                    i18 = c34;
                }
                if (F0.isNull(i18)) {
                    i19 = c35;
                    q010 = null;
                } else {
                    q010 = F0.q0(i18);
                    i19 = c35;
                }
                if (F0.isNull(i19)) {
                    i20 = c36;
                    q011 = null;
                } else {
                    q011 = F0.q0(i19);
                    i20 = c36;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(q012, q013, j, q014, q015, q016, i21, q017, valueOf6, valueOf7, valueOf8, valueOf9, j2, q0, valueOf, valueOf2, q02, valueOf3, z, q03, q04, q05, q06, j3, valueOf4, valueOf5, z2, z3, z4, q07, q08, q09, q010, q011, F0.isNull(i20) ? null : F0.q0(i20), F0.isNull(c37) ? null : F0.q0(c37));
            }
            F0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List b0(String str, int i, int i2, y3.b bVar) {
        int i3;
        String q0;
        int i4;
        int i5;
        Integer valueOf;
        String q02;
        int i6;
        Long valueOf2;
        int i7;
        int i8;
        Long valueOf3;
        int i9;
        String str2;
        int i10;
        Integer valueOf4;
        int i11;
        int i12;
        boolean z;
        String q03;
        int i13;
        String q04;
        int i14;
        int i15;
        String q05;
        int i16;
        String q06;
        int i17;
        Long valueOf5;
        int i18;
        int i19;
        Long valueOf6;
        int i20;
        int i21;
        boolean z2;
        int i22;
        boolean z3;
        int i23;
        boolean z4;
        String q07;
        int i24;
        String q08;
        int i25;
        int i26;
        String q09;
        int i27;
        String q010;
        int i28;
        String q011;
        int i29;
        String q012;
        int i30;
        y3.e F0 = bVar.F0("SELECT * FROM ugc_video_detail_play WHERE kidId = ? AND coverUrl IS NOT NULL AND collectionId LIKE 'SINGLE_%' ORDER BY timeStamp DESC LIMIT ? OFFSET ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.c(2, i);
            F0.c(3, i2);
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q013 = F0.isNull(c2) ? null : F0.q0(c2);
                String q014 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q015 = F0.isNull(c5) ? null : F0.q0(c5);
                String q016 = F0.isNull(c6) ? null : F0.q0(c6);
                if (F0.isNull(c7)) {
                    i4 = c3;
                    i3 = c4;
                    q0 = null;
                } else {
                    i3 = c4;
                    q0 = F0.q0(c7);
                    i4 = c3;
                }
                int i31 = (int) F0.getLong(c8);
                String q017 = F0.isNull(c9) ? null : F0.q0(c9);
                if (F0.isNull(c10)) {
                    i5 = c5;
                    valueOf = null;
                } else {
                    i5 = c5;
                    valueOf = Integer.valueOf((int) F0.getLong(c10));
                }
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i6 = c16;
                    q02 = null;
                } else {
                    q02 = F0.q0(c15);
                    i6 = c16;
                }
                if (F0.isNull(i6)) {
                    i7 = c17;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i6));
                    i7 = c17;
                }
                if (F0.isNull(i7)) {
                    i8 = c2;
                    valueOf3 = null;
                } else {
                    i8 = c2;
                    valueOf3 = Long.valueOf(F0.getLong(i7));
                }
                int i32 = c18;
                if (F0.isNull(i32)) {
                    c18 = i32;
                    i9 = c19;
                    str2 = null;
                } else {
                    String q018 = F0.q0(i32);
                    c18 = i32;
                    i9 = c19;
                    str2 = q018;
                }
                if (F0.isNull(i9)) {
                    i10 = i6;
                    c17 = i7;
                    i11 = c20;
                    valueOf4 = null;
                } else {
                    i10 = i6;
                    c17 = i7;
                    valueOf4 = Integer.valueOf((int) F0.getLong(i9));
                    i11 = c20;
                }
                int i33 = c6;
                if (((int) F0.getLong(i11)) != 0) {
                    i12 = c21;
                    z = true;
                } else {
                    i12 = c21;
                    z = false;
                }
                if (F0.isNull(i12)) {
                    i13 = c22;
                    q03 = null;
                } else {
                    q03 = F0.q0(i12);
                    i13 = c22;
                }
                if (F0.isNull(i13)) {
                    i14 = i9;
                    i15 = c23;
                    q04 = null;
                } else {
                    q04 = F0.q0(i13);
                    i14 = i9;
                    i15 = c23;
                }
                if (F0.isNull(i15)) {
                    c23 = i15;
                    i16 = c24;
                    q05 = null;
                } else {
                    q05 = F0.q0(i15);
                    c23 = i15;
                    i16 = c24;
                }
                if (F0.isNull(i16)) {
                    c24 = i16;
                    i17 = c25;
                    q06 = null;
                } else {
                    q06 = F0.q0(i16);
                    c24 = i16;
                    i17 = c25;
                }
                long j3 = F0.getLong(i17);
                c25 = i17;
                int i34 = c26;
                if (F0.isNull(i34)) {
                    c26 = i34;
                    i18 = c27;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i34));
                    c26 = i34;
                    i18 = c27;
                }
                if (F0.isNull(i18)) {
                    c27 = i18;
                    i19 = i12;
                    i20 = c28;
                    valueOf6 = null;
                } else {
                    i19 = i12;
                    valueOf6 = Long.valueOf(F0.getLong(i18));
                    c27 = i18;
                    i20 = c28;
                }
                int i35 = i11;
                if (((int) F0.getLong(i20)) != 0) {
                    i21 = c29;
                    z2 = true;
                } else {
                    i21 = c29;
                    z2 = false;
                }
                int i36 = i13;
                if (((int) F0.getLong(i21)) != 0) {
                    i22 = c30;
                    z3 = true;
                } else {
                    i22 = c30;
                    z3 = false;
                }
                int i37 = c7;
                if (((int) F0.getLong(i22)) != 0) {
                    i23 = c31;
                    z4 = true;
                } else {
                    i23 = c31;
                    z4 = false;
                }
                if (F0.isNull(i23)) {
                    i24 = c32;
                    q07 = null;
                } else {
                    q07 = F0.q0(i23);
                    i24 = c32;
                }
                if (F0.isNull(i24)) {
                    i25 = i20;
                    i26 = c33;
                    q08 = null;
                } else {
                    q08 = F0.q0(i24);
                    i25 = i20;
                    i26 = c33;
                }
                if (F0.isNull(i26)) {
                    c33 = i26;
                    i27 = c34;
                    q09 = null;
                } else {
                    c33 = i26;
                    q09 = F0.q0(i26);
                    i27 = c34;
                }
                if (F0.isNull(i27)) {
                    c34 = i27;
                    i28 = c35;
                    q010 = null;
                } else {
                    c34 = i27;
                    q010 = F0.q0(i27);
                    i28 = c35;
                }
                if (F0.isNull(i28)) {
                    c35 = i28;
                    i29 = c36;
                    q011 = null;
                } else {
                    c35 = i28;
                    q011 = F0.q0(i28);
                    i29 = c36;
                }
                if (F0.isNull(i29)) {
                    c36 = i29;
                    i30 = c37;
                    q012 = null;
                } else {
                    c36 = i29;
                    q012 = F0.q0(i29);
                    i30 = c37;
                }
                c37 = i30;
                arrayList.add(new UGCVideoDetailPlayBean(q013, q014, j, q015, q016, q0, i31, q017, valueOf, valueOf7, valueOf8, valueOf9, j2, q02, valueOf2, valueOf3, str2, valueOf4, z, q03, q04, q05, q06, j3, valueOf5, valueOf6, z2, z3, z4, q07, q08, q09, q010, q011, q012, F0.isNull(i30) ? null : F0.q0(i30)));
                c2 = i8;
                c31 = i23;
                c32 = i24;
                c16 = i10;
                c6 = i33;
                c19 = i14;
                c20 = i35;
                c22 = i36;
                c7 = i37;
                c3 = i4;
                c29 = i21;
                c30 = i22;
                c28 = i25;
                c4 = i3;
                c5 = i5;
                c21 = i19;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List c0(int i, int i2, y3.b bVar) {
        int i3;
        String q0;
        int i4;
        int i5;
        Integer valueOf;
        String q02;
        int i6;
        Long valueOf2;
        int i7;
        int i8;
        Long valueOf3;
        String q03;
        int i9;
        int i10;
        int i11;
        Integer valueOf4;
        int i12;
        int i13;
        boolean z;
        String q04;
        int i14;
        String q05;
        int i15;
        int i16;
        String q06;
        int i17;
        String q07;
        int i18;
        Long valueOf5;
        int i19;
        int i20;
        Long valueOf6;
        int i21;
        int i22;
        boolean z2;
        int i23;
        boolean z3;
        int i24;
        boolean z4;
        String q08;
        int i25;
        String q09;
        int i26;
        String q010;
        int i27;
        String q011;
        int i28;
        String q012;
        int i29;
        String q013;
        int i30;
        y3.e F0 = bVar.F0("SELECT * FROM ugc_video_detail_play WHERE (kidId IS NULL OR kidId = '') AND coverUrl IS NOT NULL AND collectionId LIKE 'SINGLE_%' ORDER BY timeStamp DESC LIMIT ? OFFSET ?");
        try {
            F0.c(1, i);
            F0.c(2, i2);
            int c2 = androidx.room.util.i.c(F0, "collectionId");
            int c3 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c4 = androidx.room.util.i.c(F0, "progress");
            int c5 = androidx.room.util.i.c(F0, "title");
            int c6 = androidx.room.util.i.c(F0, "coverUrl");
            int c7 = androidx.room.util.i.c(F0, "thumbnail");
            int c8 = androidx.room.util.i.c(F0, "position");
            int c9 = androidx.room.util.i.c(F0, "type");
            int c10 = androidx.room.util.i.c(F0, "cateLev1Id");
            int c11 = androidx.room.util.i.c(F0, "cateLev2Id");
            int c12 = androidx.room.util.i.c(F0, "cateLev3Id");
            int c13 = androidx.room.util.i.c(F0, "cateLev4Id");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c16 = androidx.room.util.i.c(F0, "totalDuration");
            int c17 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c18 = androidx.room.util.i.c(F0, "averageHueLight");
            int c19 = androidx.room.util.i.c(F0, "subjectType");
            int c20 = androidx.room.util.i.c(F0, "hasDelete");
            int c21 = androidx.room.util.i.c(F0, "playMode");
            int c22 = androidx.room.util.i.c(F0, "downloadUrl");
            int c23 = androidx.room.util.i.c(F0, "downloadResid");
            int c24 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c25 = androidx.room.util.i.c(F0, "downloadSize");
            int c26 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c27 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c28 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c29 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c30 = androidx.room.util.i.c(F0, "rewardFree");
            int c31 = androidx.room.util.i.c(F0, "ops");
            int c32 = androidx.room.util.i.c(F0, "uid");
            int c33 = androidx.room.util.i.c(F0, "userName");
            int c34 = androidx.room.util.i.c(F0, "userAvatar");
            int c35 = androidx.room.util.i.c(F0, "description");
            int c36 = androidx.room.util.i.c(F0, "videoStyle");
            int c37 = androidx.room.util.i.c(F0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q014 = F0.isNull(c2) ? null : F0.q0(c2);
                String q015 = F0.isNull(c3) ? null : F0.q0(c3);
                long j = F0.getLong(c4);
                String q016 = F0.isNull(c5) ? null : F0.q0(c5);
                String q017 = F0.isNull(c6) ? null : F0.q0(c6);
                if (F0.isNull(c7)) {
                    i4 = c2;
                    i3 = c3;
                    q0 = null;
                } else {
                    i3 = c3;
                    q0 = F0.q0(c7);
                    i4 = c2;
                }
                int i31 = (int) F0.getLong(c8);
                String q018 = F0.isNull(c9) ? null : F0.q0(c9);
                if (F0.isNull(c10)) {
                    i5 = c4;
                    valueOf = null;
                } else {
                    i5 = c4;
                    valueOf = Integer.valueOf((int) F0.getLong(c10));
                }
                Integer valueOf7 = F0.isNull(c11) ? null : Integer.valueOf((int) F0.getLong(c11));
                Integer valueOf8 = F0.isNull(c12) ? null : Integer.valueOf((int) F0.getLong(c12));
                Integer valueOf9 = F0.isNull(c13) ? null : Integer.valueOf((int) F0.getLong(c13));
                long j2 = F0.getLong(c14);
                if (F0.isNull(c15)) {
                    i6 = c16;
                    q02 = null;
                } else {
                    q02 = F0.q0(c15);
                    i6 = c16;
                }
                if (F0.isNull(i6)) {
                    i7 = c17;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i6));
                    i7 = c17;
                }
                if (F0.isNull(i7)) {
                    c16 = i6;
                    i8 = c18;
                    valueOf3 = null;
                } else {
                    c16 = i6;
                    i8 = c18;
                    valueOf3 = Long.valueOf(F0.getLong(i7));
                }
                if (F0.isNull(i8)) {
                    c18 = i8;
                    i9 = c19;
                    q03 = null;
                } else {
                    q03 = F0.q0(i8);
                    c18 = i8;
                    i9 = c19;
                }
                if (F0.isNull(i9)) {
                    i10 = i7;
                    i11 = c5;
                    i12 = c20;
                    valueOf4 = null;
                } else {
                    i10 = i7;
                    i11 = c5;
                    valueOf4 = Integer.valueOf((int) F0.getLong(i9));
                    i12 = c20;
                }
                int i32 = c6;
                if (((int) F0.getLong(i12)) != 0) {
                    i13 = c21;
                    z = true;
                } else {
                    i13 = c21;
                    z = false;
                }
                if (F0.isNull(i13)) {
                    i14 = c22;
                    q04 = null;
                } else {
                    q04 = F0.q0(i13);
                    i14 = c22;
                }
                if (F0.isNull(i14)) {
                    i15 = i9;
                    i16 = c23;
                    q05 = null;
                } else {
                    q05 = F0.q0(i14);
                    i15 = i9;
                    i16 = c23;
                }
                if (F0.isNull(i16)) {
                    c23 = i16;
                    i17 = c24;
                    q06 = null;
                } else {
                    q06 = F0.q0(i16);
                    c23 = i16;
                    i17 = c24;
                }
                if (F0.isNull(i17)) {
                    c24 = i17;
                    i18 = c25;
                    q07 = null;
                } else {
                    q07 = F0.q0(i17);
                    c24 = i17;
                    i18 = c25;
                }
                long j3 = F0.getLong(i18);
                c25 = i18;
                int i33 = c26;
                if (F0.isNull(i33)) {
                    c26 = i33;
                    i19 = c27;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(F0.getLong(i33));
                    c26 = i33;
                    i19 = c27;
                }
                if (F0.isNull(i19)) {
                    c27 = i19;
                    i20 = i13;
                    i21 = c28;
                    valueOf6 = null;
                } else {
                    i20 = i13;
                    valueOf6 = Long.valueOf(F0.getLong(i19));
                    c27 = i19;
                    i21 = c28;
                }
                int i34 = i12;
                if (((int) F0.getLong(i21)) != 0) {
                    i22 = c29;
                    z2 = true;
                } else {
                    i22 = c29;
                    z2 = false;
                }
                int i35 = i14;
                int i36 = i21;
                if (((int) F0.getLong(i22)) != 0) {
                    i23 = c30;
                    z3 = true;
                } else {
                    i23 = c30;
                    z3 = false;
                }
                int i37 = i22;
                if (((int) F0.getLong(i23)) != 0) {
                    i24 = c31;
                    z4 = true;
                } else {
                    i24 = c31;
                    z4 = false;
                }
                if (F0.isNull(i24)) {
                    i25 = c32;
                    q08 = null;
                } else {
                    q08 = F0.q0(i24);
                    i25 = c32;
                }
                if (F0.isNull(i25)) {
                    c31 = i24;
                    i26 = c33;
                    q09 = null;
                } else {
                    c31 = i24;
                    q09 = F0.q0(i25);
                    i26 = c33;
                }
                if (F0.isNull(i26)) {
                    c33 = i26;
                    i27 = c34;
                    q010 = null;
                } else {
                    c33 = i26;
                    q010 = F0.q0(i26);
                    i27 = c34;
                }
                if (F0.isNull(i27)) {
                    c34 = i27;
                    i28 = c35;
                    q011 = null;
                } else {
                    c34 = i27;
                    q011 = F0.q0(i27);
                    i28 = c35;
                }
                if (F0.isNull(i28)) {
                    c35 = i28;
                    i29 = c36;
                    q012 = null;
                } else {
                    c35 = i28;
                    q012 = F0.q0(i28);
                    i29 = c36;
                }
                if (F0.isNull(i29)) {
                    c36 = i29;
                    i30 = c37;
                    q013 = null;
                } else {
                    c36 = i29;
                    q013 = F0.q0(i29);
                    i30 = c37;
                }
                c37 = i30;
                arrayList.add(new UGCVideoDetailPlayBean(q014, q015, j, q016, q017, q0, i31, q018, valueOf, valueOf7, valueOf8, valueOf9, j2, q02, valueOf2, valueOf3, q03, valueOf4, z, q04, q05, q06, q07, j3, valueOf5, valueOf6, z2, z3, z4, q08, q09, q010, q011, q012, q013, F0.isNull(i30) ? null : F0.q0(i30)));
                c32 = i25;
                c2 = i4;
                c3 = i3;
                c4 = i5;
                c21 = i20;
                int i38 = i23;
                c5 = i11;
                c17 = i10;
                c19 = i15;
                c22 = i35;
                c29 = i37;
                c30 = i38;
                c28 = i36;
                c6 = i32;
                c20 = i34;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit d0(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, y3.b bVar) {
        this.b.d(bVar, uGCVideoDetailPlayBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit e0(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, y3.b bVar) {
        this.d.c(bVar, uGCVideoDetailPlayBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit f0(long j, String str, long j2, int i, String str2, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE UGC_VIDEO_DETAIL_PLAY SET progress = ?, ugcVideoId= ?, timeStamp =?, position = ? WHERE collectionId = ? ");
        try {
            F0.c(1, j);
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            F0.c(3, j2);
            F0.c(4, i);
            if (str2 == null) {
                F0.g(5);
            } else {
                F0.i(5, str2);
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
    public static /* synthetic */ Unit g0(String str, String str2, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE UGC_VIDEO_DETAIL_PLAY SET subtitleSelectId = ? WHERE collectionId = ? ");
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
    public static /* synthetic */ Unit h0(long j, String str, String str2, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE UGC_VIDEO_DETAIL_PLAY SET totalDuration = ?, ugcVideoId= ? WHERE collectionId = ? ");
        try {
            F0.c(1, j);
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            if (str2 == null) {
                F0.g(3);
            } else {
                F0.i(3, str2);
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

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.x
            public final Object invoke(Object obj) {
                Unit Q;
                Q = j0.Q((y3.b) obj);
                return Q;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object b(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.w
            public final Object invoke(Object obj) {
                Unit g0;
                g0 = j0.g0(str2, str, (y3.b) obj);
                return g0;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object c(String str, Continuation continuation) {
        return UGCVideoDetailPlayDao.DefaultImpls.b(this, str, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object d(int i, int i2, Continuation continuation) {
        return UGCVideoDetailPlayDao.DefaultImpls.c(this, i, i2, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object e(final String str, final String str2, final long j, final long j2, final int i, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.i0
            public final Object invoke(Object obj) {
                Unit f0;
                f0 = j0.f0(j2, str2, j, i, str, (y3.b) obj);
                return f0;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object f(final int i, final int i2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.a0
            public final Object invoke(Object obj) {
                List T;
                T = j0.T(i2, i, (y3.b) obj);
                return T;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object g(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.t
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean V;
                V = j0.V(str, (y3.b) obj);
                return V;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object h(final String str, final String str2, final long j, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.u
            public final Object invoke(Object obj) {
                Unit h0;
                h0 = j0.h0(j, str2, str, (y3.b) obj);
                return h0;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object i(final int i, final int i2, final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.r
            public final Object invoke(Object obj) {
                List b0;
                b0 = j0.b0(str, i2, i, (y3.b) obj);
                return b0;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object j(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.v
            public final Object invoke(Object obj) {
                Unit R;
                R = j0.R(str, (y3.b) obj);
                return R;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object k(String str, String str2, long j, long j2, Continuation continuation) {
        return UGCVideoDetailPlayDao.DefaultImpls.e(this, str, str2, j, j2, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object l(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.h0
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean X;
                X = j0.X(str, str2, (y3.b) obj);
                return X;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object m(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.s
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean U;
                U = j0.U(str, (y3.b) obj);
                return U;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object n(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation) {
        return UGCVideoDetailPlayDao.DefaultImpls.d(this, uGCVideoDetailPlayBean, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object o(final int i, final int i2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.d0
            public final Object invoke(Object obj) {
                List c0;
                c0 = j0.c0(i2, i, (y3.b) obj);
                return c0;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object p(final UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation) {
        uGCVideoDetailPlayBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.b0
            public final Object invoke(Object obj) {
                Unit d0;
                d0 = j0.this.d0(uGCVideoDetailPlayBean, (y3.b) obj);
                return d0;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object q(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.z
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean a0;
                a0 = j0.a0(str, str2, (y3.b) obj);
                return a0;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object r(String str, Continuation continuation) {
        return UGCVideoDetailPlayDao.DefaultImpls.a(this, str, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object s(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.e0
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean W;
                W = j0.W(str2, str, (y3.b) obj);
                return W;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object t(final String str, final String str2, final String str3, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.y
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean Z;
                Z = j0.Z(str, str2, str3, (y3.b) obj);
                return Z;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object u(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.f0
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean Y;
                Y = j0.Y(str, (y3.b) obj);
                return Y;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object v(final UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation) {
        uGCVideoDetailPlayBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.c0
            public final Object invoke(Object obj) {
                Unit e0;
                e0 = j0.this.e0(uGCVideoDetailPlayBean, (y3.b) obj);
                return e0;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object w(final int i, final int i2, final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.g0
            public final Object invoke(Object obj) {
                List S;
                S = j0.S(str, i2, i, (y3.b) obj);
                return S;
            }
        }, continuation);
    }
}
