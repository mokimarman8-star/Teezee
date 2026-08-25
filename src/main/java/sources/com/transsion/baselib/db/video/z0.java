package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class z0 implements VideoDetailPlayDao {
    private final RoomDatabase a;
    private final ri.b c = new ri.b();
    private final androidx.room.g b = new a();
    private final androidx.room.e d = new b();
    private final androidx.room.e e = new c();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `video_detail_play` (`subjectId`,`id`,`ep`,`se`,`progress`,`title`,`coverUrl`,`thumbnail`,`videoUrl`,`timeStamp`,`subtitleSelectId`,`totalDuration`,`subjectDurationSeconds`,`averageHueLight`,`subjectType`,`hasDelete`,`playMode`,`downloadUrl`,`downloadFilePath`,`downloadSize`,`dubs`,`lastAdStartTimeStamp`,`lastAdEndTimeStamp`,`rewardPlayed`,`rewardUnlock`,`rewardFree`,`ops`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, VideoDetailPlayBean videoDetailPlayBean) {
            if (videoDetailPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, videoDetailPlayBean.getSubjectId());
            }
            if (videoDetailPlayBean.getId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, videoDetailPlayBean.getId());
            }
            eVar.c(3, videoDetailPlayBean.getEp());
            eVar.c(4, videoDetailPlayBean.getSe());
            eVar.c(5, videoDetailPlayBean.getProgress());
            if (videoDetailPlayBean.getTitle() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, videoDetailPlayBean.getTitle());
            }
            if (videoDetailPlayBean.getCoverUrl() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, videoDetailPlayBean.getCoverUrl());
            }
            if (videoDetailPlayBean.getThumbnail() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, videoDetailPlayBean.getThumbnail());
            }
            if (videoDetailPlayBean.getVideoUrl() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, videoDetailPlayBean.getVideoUrl());
            }
            eVar.c(10, videoDetailPlayBean.getTimeStamp());
            if (videoDetailPlayBean.getSubtitleSelectId() == null) {
                eVar.g(11);
            } else {
                eVar.i(11, videoDetailPlayBean.getSubtitleSelectId());
            }
            if (videoDetailPlayBean.getTotalDuration() == null) {
                eVar.g(12);
            } else {
                eVar.c(12, videoDetailPlayBean.getTotalDuration().longValue());
            }
            if (videoDetailPlayBean.getSubjectDurationSeconds() == null) {
                eVar.g(13);
            } else {
                eVar.c(13, videoDetailPlayBean.getSubjectDurationSeconds().longValue());
            }
            if (videoDetailPlayBean.getAverageHueLight() == null) {
                eVar.g(14);
            } else {
                eVar.i(14, videoDetailPlayBean.getAverageHueLight());
            }
            if (videoDetailPlayBean.getSubjectType() == null) {
                eVar.g(15);
            } else {
                eVar.c(15, videoDetailPlayBean.getSubjectType().intValue());
            }
            eVar.c(16, videoDetailPlayBean.getHasDelete() ? 1L : 0L);
            if (videoDetailPlayBean.getPlayMode() == null) {
                eVar.g(17);
            } else {
                eVar.i(17, videoDetailPlayBean.getPlayMode());
            }
            if (videoDetailPlayBean.getDownloadUrl() == null) {
                eVar.g(18);
            } else {
                eVar.i(18, videoDetailPlayBean.getDownloadUrl());
            }
            if (videoDetailPlayBean.getDownloadFilePath() == null) {
                eVar.g(19);
            } else {
                eVar.i(19, videoDetailPlayBean.getDownloadFilePath());
            }
            eVar.c(20, videoDetailPlayBean.getDownloadSize());
            String a = z0.this.c.a(videoDetailPlayBean.getDubs());
            if (a == null) {
                eVar.g(21);
            } else {
                eVar.i(21, a);
            }
            if (videoDetailPlayBean.getLastAdStartTimeStamp() == null) {
                eVar.g(22);
            } else {
                eVar.c(22, videoDetailPlayBean.getLastAdStartTimeStamp().longValue());
            }
            if (videoDetailPlayBean.getLastAdEndTimeStamp() == null) {
                eVar.g(23);
            } else {
                eVar.c(23, videoDetailPlayBean.getLastAdEndTimeStamp().longValue());
            }
            eVar.c(24, videoDetailPlayBean.getRewardPlayed() ? 1L : 0L);
            eVar.c(25, videoDetailPlayBean.getRewardUnlock() ? 1L : 0L);
            eVar.c(26, videoDetailPlayBean.getRewardFree() ? 1L : 0L);
            if (videoDetailPlayBean.getOps() == null) {
                eVar.g(27);
            } else {
                eVar.i(27, videoDetailPlayBean.getOps());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `video_detail_play` WHERE `subjectId` = ? AND `ep` = ? AND `se` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, VideoDetailPlayBean videoDetailPlayBean) {
            if (videoDetailPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, videoDetailPlayBean.getSubjectId());
            }
            eVar.c(2, videoDetailPlayBean.getEp());
            eVar.c(3, videoDetailPlayBean.getSe());
        }
    }

    class c extends androidx.room.e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `video_detail_play` SET `subjectId` = ?,`id` = ?,`ep` = ?,`se` = ?,`progress` = ?,`title` = ?,`coverUrl` = ?,`thumbnail` = ?,`videoUrl` = ?,`timeStamp` = ?,`subtitleSelectId` = ?,`totalDuration` = ?,`subjectDurationSeconds` = ?,`averageHueLight` = ?,`subjectType` = ?,`hasDelete` = ?,`playMode` = ?,`downloadUrl` = ?,`downloadFilePath` = ?,`downloadSize` = ?,`dubs` = ?,`lastAdStartTimeStamp` = ?,`lastAdEndTimeStamp` = ?,`rewardPlayed` = ?,`rewardUnlock` = ?,`rewardFree` = ?,`ops` = ? WHERE `subjectId` = ? AND `ep` = ? AND `se` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, VideoDetailPlayBean videoDetailPlayBean) {
            if (videoDetailPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, videoDetailPlayBean.getSubjectId());
            }
            if (videoDetailPlayBean.getId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, videoDetailPlayBean.getId());
            }
            eVar.c(3, videoDetailPlayBean.getEp());
            eVar.c(4, videoDetailPlayBean.getSe());
            eVar.c(5, videoDetailPlayBean.getProgress());
            if (videoDetailPlayBean.getTitle() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, videoDetailPlayBean.getTitle());
            }
            if (videoDetailPlayBean.getCoverUrl() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, videoDetailPlayBean.getCoverUrl());
            }
            if (videoDetailPlayBean.getThumbnail() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, videoDetailPlayBean.getThumbnail());
            }
            if (videoDetailPlayBean.getVideoUrl() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, videoDetailPlayBean.getVideoUrl());
            }
            eVar.c(10, videoDetailPlayBean.getTimeStamp());
            if (videoDetailPlayBean.getSubtitleSelectId() == null) {
                eVar.g(11);
            } else {
                eVar.i(11, videoDetailPlayBean.getSubtitleSelectId());
            }
            if (videoDetailPlayBean.getTotalDuration() == null) {
                eVar.g(12);
            } else {
                eVar.c(12, videoDetailPlayBean.getTotalDuration().longValue());
            }
            if (videoDetailPlayBean.getSubjectDurationSeconds() == null) {
                eVar.g(13);
            } else {
                eVar.c(13, videoDetailPlayBean.getSubjectDurationSeconds().longValue());
            }
            if (videoDetailPlayBean.getAverageHueLight() == null) {
                eVar.g(14);
            } else {
                eVar.i(14, videoDetailPlayBean.getAverageHueLight());
            }
            if (videoDetailPlayBean.getSubjectType() == null) {
                eVar.g(15);
            } else {
                eVar.c(15, videoDetailPlayBean.getSubjectType().intValue());
            }
            eVar.c(16, videoDetailPlayBean.getHasDelete() ? 1L : 0L);
            if (videoDetailPlayBean.getPlayMode() == null) {
                eVar.g(17);
            } else {
                eVar.i(17, videoDetailPlayBean.getPlayMode());
            }
            if (videoDetailPlayBean.getDownloadUrl() == null) {
                eVar.g(18);
            } else {
                eVar.i(18, videoDetailPlayBean.getDownloadUrl());
            }
            if (videoDetailPlayBean.getDownloadFilePath() == null) {
                eVar.g(19);
            } else {
                eVar.i(19, videoDetailPlayBean.getDownloadFilePath());
            }
            eVar.c(20, videoDetailPlayBean.getDownloadSize());
            String a = z0.this.c.a(videoDetailPlayBean.getDubs());
            if (a == null) {
                eVar.g(21);
            } else {
                eVar.i(21, a);
            }
            if (videoDetailPlayBean.getLastAdStartTimeStamp() == null) {
                eVar.g(22);
            } else {
                eVar.c(22, videoDetailPlayBean.getLastAdStartTimeStamp().longValue());
            }
            if (videoDetailPlayBean.getLastAdEndTimeStamp() == null) {
                eVar.g(23);
            } else {
                eVar.c(23, videoDetailPlayBean.getLastAdEndTimeStamp().longValue());
            }
            eVar.c(24, videoDetailPlayBean.getRewardPlayed() ? 1L : 0L);
            eVar.c(25, videoDetailPlayBean.getRewardUnlock() ? 1L : 0L);
            eVar.c(26, videoDetailPlayBean.getRewardFree() ? 1L : 0L);
            if (videoDetailPlayBean.getOps() == null) {
                eVar.g(27);
            } else {
                eVar.i(27, videoDetailPlayBean.getOps());
            }
            if (videoDetailPlayBean.getSubjectId() == null) {
                eVar.g(28);
            } else {
                eVar.i(28, videoDetailPlayBean.getSubjectId());
            }
            eVar.c(29, videoDetailPlayBean.getEp());
            eVar.c(30, videoDetailPlayBean.getSe());
        }
    }

    public z0(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List E() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit F(VideoDetailPlayBean videoDetailPlayBean, y3.b bVar) {
        this.d.c(bVar, videoDetailPlayBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit G(y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM VIDEO_DETAIL_PLAY");
        try {
            F0.C0();
            return Unit.a;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ VideoDetailPlayBean H(String str, y3.b bVar) {
        String q0;
        int i;
        Integer valueOf;
        int i2;
        boolean z;
        int i3;
        String q02;
        int i4;
        String q03;
        int i5;
        String q04;
        int i6;
        String q05;
        z0 z0Var;
        Long valueOf2;
        int i7;
        Long valueOf3;
        int i8;
        boolean z2;
        int i9;
        boolean z3;
        int i10;
        y3.e F0 = bVar.F0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE subjectId = ? ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "subjectId");
            int c3 = androidx.room.util.i.c(F0, "id");
            int c4 = androidx.room.util.i.c(F0, "ep");
            int c5 = androidx.room.util.i.c(F0, "se");
            int c6 = androidx.room.util.i.c(F0, "progress");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "coverUrl");
            int c9 = androidx.room.util.i.c(F0, "thumbnail");
            int c10 = androidx.room.util.i.c(F0, "videoUrl");
            int c11 = androidx.room.util.i.c(F0, "timeStamp");
            int c12 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c13 = androidx.room.util.i.c(F0, "totalDuration");
            int c14 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c15 = androidx.room.util.i.c(F0, "averageHueLight");
            int c16 = androidx.room.util.i.c(F0, "subjectType");
            int c17 = androidx.room.util.i.c(F0, "hasDelete");
            int c18 = androidx.room.util.i.c(F0, "playMode");
            int c19 = androidx.room.util.i.c(F0, "downloadUrl");
            int c20 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c21 = androidx.room.util.i.c(F0, "downloadSize");
            int c22 = androidx.room.util.i.c(F0, "dubs");
            int c23 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c24 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c25 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c26 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c27 = androidx.room.util.i.c(F0, "rewardFree");
            int c28 = androidx.room.util.i.c(F0, "ops");
            VideoDetailPlayBean videoDetailPlayBean = null;
            if (F0.C0()) {
                String q06 = F0.isNull(c2) ? null : F0.q0(c2);
                String q07 = F0.isNull(c3) ? null : F0.q0(c3);
                int i11 = (int) F0.getLong(c4);
                int i12 = (int) F0.getLong(c5);
                long j = F0.getLong(c6);
                String q08 = F0.isNull(c7) ? null : F0.q0(c7);
                String q09 = F0.isNull(c8) ? null : F0.q0(c8);
                String q010 = F0.isNull(c9) ? null : F0.q0(c9);
                String q011 = F0.isNull(c10) ? null : F0.q0(c10);
                long j2 = F0.getLong(c11);
                String q012 = F0.isNull(c12) ? null : F0.q0(c12);
                Long valueOf4 = F0.isNull(c13) ? null : Long.valueOf(F0.getLong(c13));
                Long valueOf5 = F0.isNull(c14) ? null : Long.valueOf(F0.getLong(c14));
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
                    valueOf = Integer.valueOf((int) F0.getLong(i));
                    i2 = c17;
                }
                if (((int) F0.getLong(i2)) != 0) {
                    i3 = c18;
                    z = true;
                } else {
                    z = false;
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
                    q03 = null;
                } else {
                    q03 = F0.q0(i4);
                    i5 = c20;
                }
                if (F0.isNull(i5)) {
                    i6 = c21;
                    q04 = null;
                } else {
                    q04 = F0.q0(i5);
                    i6 = c21;
                }
                long j3 = F0.getLong(i6);
                if (F0.isNull(c22)) {
                    z0Var = this;
                    q05 = null;
                } else {
                    q05 = F0.q0(c22);
                    z0Var = this;
                }
                try {
                    ArrayList b2 = z0Var.c.b(q05);
                    if (F0.isNull(c23)) {
                        i7 = c24;
                        valueOf2 = null;
                    } else {
                        valueOf2 = Long.valueOf(F0.getLong(c23));
                        i7 = c24;
                    }
                    if (F0.isNull(i7)) {
                        i8 = c25;
                        valueOf3 = null;
                    } else {
                        valueOf3 = Long.valueOf(F0.getLong(i7));
                        i8 = c25;
                    }
                    if (((int) F0.getLong(i8)) != 0) {
                        i9 = c26;
                        z2 = true;
                    } else {
                        z2 = false;
                        i9 = c26;
                    }
                    if (((int) F0.getLong(i9)) != 0) {
                        i10 = c27;
                        z3 = true;
                    } else {
                        z3 = false;
                        i10 = c27;
                    }
                    videoDetailPlayBean = new VideoDetailPlayBean(q06, q07, i11, i12, j, q08, q09, q010, q011, j2, q012, valueOf4, valueOf5, q0, valueOf, z, q02, q03, q04, j3, b2, valueOf2, valueOf3, z2, z3, ((int) F0.getLong(i10)) != 0, F0.isNull(c28) ? null : F0.q0(c28));
                } catch (Throwable th2) {
                    th = th2;
                    F0.close();
                    throw th;
                }
            }
            F0.close();
            return videoDetailPlayBean;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ VideoDetailPlayBean I(int i, int i2, String str, y3.b bVar) {
        String q0;
        int i3;
        Integer valueOf;
        int i4;
        int i5;
        boolean z;
        String q02;
        int i6;
        String q03;
        int i7;
        String q04;
        int i8;
        String q05;
        z0 z0Var;
        Long valueOf2;
        int i9;
        Long valueOf3;
        int i10;
        boolean z2;
        int i11;
        boolean z3;
        int i12;
        y3.e F0 = bVar.F0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE se = ? AND ep = ? AND subjectId = ? ORDER BY timeStamp DESC LIMIT 1");
        try {
            F0.c(1, i);
            F0.c(2, i2);
            if (str == null) {
                F0.g(3);
            } else {
                F0.i(3, str);
            }
            int c2 = androidx.room.util.i.c(F0, "subjectId");
            int c3 = androidx.room.util.i.c(F0, "id");
            int c4 = androidx.room.util.i.c(F0, "ep");
            int c5 = androidx.room.util.i.c(F0, "se");
            int c6 = androidx.room.util.i.c(F0, "progress");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "coverUrl");
            int c9 = androidx.room.util.i.c(F0, "thumbnail");
            int c10 = androidx.room.util.i.c(F0, "videoUrl");
            int c11 = androidx.room.util.i.c(F0, "timeStamp");
            int c12 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c13 = androidx.room.util.i.c(F0, "totalDuration");
            int c14 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c15 = androidx.room.util.i.c(F0, "averageHueLight");
            int c16 = androidx.room.util.i.c(F0, "subjectType");
            int c17 = androidx.room.util.i.c(F0, "hasDelete");
            int c18 = androidx.room.util.i.c(F0, "playMode");
            int c19 = androidx.room.util.i.c(F0, "downloadUrl");
            int c20 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c21 = androidx.room.util.i.c(F0, "downloadSize");
            int c22 = androidx.room.util.i.c(F0, "dubs");
            int c23 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c24 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c25 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c26 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c27 = androidx.room.util.i.c(F0, "rewardFree");
            int c28 = androidx.room.util.i.c(F0, "ops");
            VideoDetailPlayBean videoDetailPlayBean = null;
            if (F0.C0()) {
                String q06 = F0.isNull(c2) ? null : F0.q0(c2);
                String q07 = F0.isNull(c3) ? null : F0.q0(c3);
                int i13 = (int) F0.getLong(c4);
                int i14 = (int) F0.getLong(c5);
                long j = F0.getLong(c6);
                String q08 = F0.isNull(c7) ? null : F0.q0(c7);
                String q09 = F0.isNull(c8) ? null : F0.q0(c8);
                String q010 = F0.isNull(c9) ? null : F0.q0(c9);
                String q011 = F0.isNull(c10) ? null : F0.q0(c10);
                long j2 = F0.getLong(c11);
                String q012 = F0.isNull(c12) ? null : F0.q0(c12);
                Long valueOf4 = F0.isNull(c13) ? null : Long.valueOf(F0.getLong(c13));
                Long valueOf5 = F0.isNull(c14) ? null : Long.valueOf(F0.getLong(c14));
                if (F0.isNull(c15)) {
                    i3 = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i3 = c16;
                }
                if (F0.isNull(i3)) {
                    i4 = c17;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf((int) F0.getLong(i3));
                    i4 = c17;
                }
                if (((int) F0.getLong(i4)) != 0) {
                    i5 = c18;
                    z = true;
                } else {
                    i5 = c18;
                    z = false;
                }
                if (F0.isNull(i5)) {
                    i6 = c19;
                    q02 = null;
                } else {
                    q02 = F0.q0(i5);
                    i6 = c19;
                }
                if (F0.isNull(i6)) {
                    i7 = c20;
                    q03 = null;
                } else {
                    q03 = F0.q0(i6);
                    i7 = c20;
                }
                if (F0.isNull(i7)) {
                    i8 = c21;
                    q04 = null;
                } else {
                    q04 = F0.q0(i7);
                    i8 = c21;
                }
                long j3 = F0.getLong(i8);
                if (F0.isNull(c22)) {
                    z0Var = this;
                    q05 = null;
                } else {
                    q05 = F0.q0(c22);
                    z0Var = this;
                }
                try {
                    ArrayList b2 = z0Var.c.b(q05);
                    if (F0.isNull(c23)) {
                        i9 = c24;
                        valueOf2 = null;
                    } else {
                        valueOf2 = Long.valueOf(F0.getLong(c23));
                        i9 = c24;
                    }
                    if (F0.isNull(i9)) {
                        i10 = c25;
                        valueOf3 = null;
                    } else {
                        valueOf3 = Long.valueOf(F0.getLong(i9));
                        i10 = c25;
                    }
                    if (((int) F0.getLong(i10)) != 0) {
                        i11 = c26;
                        z2 = true;
                    } else {
                        z2 = false;
                        i11 = c26;
                    }
                    if (((int) F0.getLong(i11)) != 0) {
                        i12 = c27;
                        z3 = true;
                    } else {
                        z3 = false;
                        i12 = c27;
                    }
                    videoDetailPlayBean = new VideoDetailPlayBean(q06, q07, i13, i14, j, q08, q09, q010, q011, j2, q012, valueOf4, valueOf5, q0, valueOf, z, q02, q03, q04, j3, b2, valueOf2, valueOf3, z2, z3, ((int) F0.getLong(i12)) != 0, F0.isNull(c28) ? null : F0.q0(c28));
                } catch (Throwable th2) {
                    th = th2;
                    F0.close();
                    throw th;
                }
            }
            F0.close();
            return videoDetailPlayBean;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ VideoDetailPlayBean J(String str, int i, int i2, y3.b bVar) {
        String q0;
        int i3;
        Integer valueOf;
        int i4;
        int i5;
        boolean z;
        String q02;
        int i6;
        String q03;
        int i7;
        String q04;
        int i8;
        String q05;
        z0 z0Var;
        Long valueOf2;
        int i9;
        Long valueOf3;
        int i10;
        boolean z2;
        int i11;
        boolean z3;
        int i12;
        y3.e F0 = bVar.F0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE subjectId = ? AND se = ? AND ep = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.c(2, i);
            F0.c(3, i2);
            int c2 = androidx.room.util.i.c(F0, "subjectId");
            int c3 = androidx.room.util.i.c(F0, "id");
            int c4 = androidx.room.util.i.c(F0, "ep");
            int c5 = androidx.room.util.i.c(F0, "se");
            int c6 = androidx.room.util.i.c(F0, "progress");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "coverUrl");
            int c9 = androidx.room.util.i.c(F0, "thumbnail");
            int c10 = androidx.room.util.i.c(F0, "videoUrl");
            int c11 = androidx.room.util.i.c(F0, "timeStamp");
            int c12 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c13 = androidx.room.util.i.c(F0, "totalDuration");
            int c14 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c15 = androidx.room.util.i.c(F0, "averageHueLight");
            int c16 = androidx.room.util.i.c(F0, "subjectType");
            int c17 = androidx.room.util.i.c(F0, "hasDelete");
            int c18 = androidx.room.util.i.c(F0, "playMode");
            int c19 = androidx.room.util.i.c(F0, "downloadUrl");
            int c20 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c21 = androidx.room.util.i.c(F0, "downloadSize");
            int c22 = androidx.room.util.i.c(F0, "dubs");
            int c23 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c24 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c25 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c26 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c27 = androidx.room.util.i.c(F0, "rewardFree");
            int c28 = androidx.room.util.i.c(F0, "ops");
            VideoDetailPlayBean videoDetailPlayBean = null;
            if (F0.C0()) {
                String q06 = F0.isNull(c2) ? null : F0.q0(c2);
                String q07 = F0.isNull(c3) ? null : F0.q0(c3);
                int i13 = (int) F0.getLong(c4);
                int i14 = (int) F0.getLong(c5);
                long j = F0.getLong(c6);
                String q08 = F0.isNull(c7) ? null : F0.q0(c7);
                String q09 = F0.isNull(c8) ? null : F0.q0(c8);
                String q010 = F0.isNull(c9) ? null : F0.q0(c9);
                String q011 = F0.isNull(c10) ? null : F0.q0(c10);
                long j2 = F0.getLong(c11);
                String q012 = F0.isNull(c12) ? null : F0.q0(c12);
                Long valueOf4 = F0.isNull(c13) ? null : Long.valueOf(F0.getLong(c13));
                Long valueOf5 = F0.isNull(c14) ? null : Long.valueOf(F0.getLong(c14));
                if (F0.isNull(c15)) {
                    i3 = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i3 = c16;
                }
                if (F0.isNull(i3)) {
                    i4 = c17;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf((int) F0.getLong(i3));
                    i4 = c17;
                }
                if (((int) F0.getLong(i4)) != 0) {
                    i5 = c18;
                    z = true;
                } else {
                    i5 = c18;
                    z = false;
                }
                if (F0.isNull(i5)) {
                    i6 = c19;
                    q02 = null;
                } else {
                    q02 = F0.q0(i5);
                    i6 = c19;
                }
                if (F0.isNull(i6)) {
                    i7 = c20;
                    q03 = null;
                } else {
                    q03 = F0.q0(i6);
                    i7 = c20;
                }
                if (F0.isNull(i7)) {
                    i8 = c21;
                    q04 = null;
                } else {
                    q04 = F0.q0(i7);
                    i8 = c21;
                }
                long j3 = F0.getLong(i8);
                if (F0.isNull(c22)) {
                    z0Var = this;
                    q05 = null;
                } else {
                    q05 = F0.q0(c22);
                    z0Var = this;
                }
                try {
                    ArrayList b2 = z0Var.c.b(q05);
                    if (F0.isNull(c23)) {
                        i9 = c24;
                        valueOf2 = null;
                    } else {
                        valueOf2 = Long.valueOf(F0.getLong(c23));
                        i9 = c24;
                    }
                    if (F0.isNull(i9)) {
                        i10 = c25;
                        valueOf3 = null;
                    } else {
                        valueOf3 = Long.valueOf(F0.getLong(i9));
                        i10 = c25;
                    }
                    if (((int) F0.getLong(i10)) != 0) {
                        i11 = c26;
                        z2 = true;
                    } else {
                        z2 = false;
                        i11 = c26;
                    }
                    if (((int) F0.getLong(i11)) != 0) {
                        i12 = c27;
                        z3 = true;
                    } else {
                        z3 = false;
                        i12 = c27;
                    }
                    videoDetailPlayBean = new VideoDetailPlayBean(q06, q07, i13, i14, j, q08, q09, q010, q011, j2, q012, valueOf4, valueOf5, q0, valueOf, z, q02, q03, q04, j3, b2, valueOf2, valueOf3, z2, z3, ((int) F0.getLong(i12)) != 0, F0.isNull(c28) ? null : F0.q0(c28));
                } catch (Throwable th2) {
                    th = th2;
                    F0.close();
                    throw th;
                }
            }
            F0.close();
            return videoDetailPlayBean;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List K(String str, y3.b bVar) {
        ArrayList arrayList;
        String q0;
        int i;
        String q02;
        int i2;
        int i3;
        int i4;
        Integer valueOf;
        int i5;
        int i6;
        boolean z;
        String q03;
        int i7;
        String q04;
        int i8;
        int i9;
        String q05;
        int i10;
        int i11;
        int i12;
        String q06;
        int i13;
        Long valueOf2;
        int i14;
        Long valueOf3;
        int i15;
        int i16;
        boolean z2;
        int i17;
        boolean z3;
        int i18;
        boolean z4;
        y3.e F0 = bVar.F0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE subjectId = ? ORDER BY timeStamp DESC");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "subjectId");
            int c3 = androidx.room.util.i.c(F0, "id");
            int c4 = androidx.room.util.i.c(F0, "ep");
            int c5 = androidx.room.util.i.c(F0, "se");
            int c6 = androidx.room.util.i.c(F0, "progress");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "coverUrl");
            int c9 = androidx.room.util.i.c(F0, "thumbnail");
            int c10 = androidx.room.util.i.c(F0, "videoUrl");
            int c11 = androidx.room.util.i.c(F0, "timeStamp");
            int c12 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c13 = androidx.room.util.i.c(F0, "totalDuration");
            int c14 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c15 = androidx.room.util.i.c(F0, "averageHueLight");
            int c16 = androidx.room.util.i.c(F0, "subjectType");
            int c17 = androidx.room.util.i.c(F0, "hasDelete");
            int c18 = androidx.room.util.i.c(F0, "playMode");
            int c19 = androidx.room.util.i.c(F0, "downloadUrl");
            int c20 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c21 = androidx.room.util.i.c(F0, "downloadSize");
            int c22 = androidx.room.util.i.c(F0, "dubs");
            int c23 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c24 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c25 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c26 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c27 = androidx.room.util.i.c(F0, "rewardFree");
            int c28 = androidx.room.util.i.c(F0, "ops");
            ArrayList arrayList2 = new ArrayList();
            while (F0.C0()) {
                String q07 = F0.isNull(c2) ? null : F0.q0(c2);
                if (F0.isNull(c3)) {
                    arrayList = arrayList2;
                    i = c3;
                    q0 = null;
                } else {
                    arrayList = arrayList2;
                    q0 = F0.q0(c3);
                    i = c3;
                }
                int i19 = (int) F0.getLong(c4);
                int i20 = c4;
                int i21 = (int) F0.getLong(c5);
                long j = F0.getLong(c6);
                String q08 = F0.isNull(c7) ? null : F0.q0(c7);
                String q09 = F0.isNull(c8) ? null : F0.q0(c8);
                String q010 = F0.isNull(c9) ? null : F0.q0(c9);
                String q011 = F0.isNull(c10) ? null : F0.q0(c10);
                long j2 = F0.getLong(c11);
                String q012 = F0.isNull(c12) ? null : F0.q0(c12);
                Long valueOf4 = F0.isNull(c13) ? null : Long.valueOf(F0.getLong(c13));
                Long valueOf5 = F0.isNull(c14) ? null : Long.valueOf(F0.getLong(c14));
                if (F0.isNull(c15)) {
                    i2 = c16;
                    q02 = null;
                } else {
                    q02 = F0.q0(c15);
                    i2 = c16;
                }
                if (F0.isNull(i2)) {
                    i3 = c5;
                    i4 = c6;
                    i5 = c17;
                    valueOf = null;
                } else {
                    i3 = c5;
                    i4 = c6;
                    valueOf = Integer.valueOf((int) F0.getLong(i2));
                    i5 = c17;
                }
                int i22 = c7;
                if (((int) F0.getLong(i5)) != 0) {
                    i6 = c18;
                    z = true;
                } else {
                    i6 = c18;
                    z = false;
                }
                if (F0.isNull(i6)) {
                    i7 = c19;
                    q03 = null;
                } else {
                    q03 = F0.q0(i6);
                    i7 = c19;
                }
                if (F0.isNull(i7)) {
                    i8 = c2;
                    i9 = c20;
                    q04 = null;
                } else {
                    q04 = F0.q0(i7);
                    i8 = c2;
                    i9 = c20;
                }
                if (F0.isNull(i9)) {
                    c20 = i9;
                    i10 = c21;
                    q05 = null;
                } else {
                    q05 = F0.q0(i9);
                    c20 = i9;
                    i10 = c21;
                }
                long j3 = F0.getLong(i10);
                c21 = i10;
                int i23 = c22;
                if (F0.isNull(i23)) {
                    i11 = i23;
                    i13 = i2;
                    i12 = i5;
                    q06 = null;
                } else {
                    i11 = i23;
                    i12 = i5;
                    q06 = F0.q0(i23);
                    i13 = i2;
                }
                ArrayList b2 = this.c.b(q06);
                int i24 = c23;
                if (F0.isNull(i24)) {
                    i14 = c24;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i24));
                    i14 = c24;
                }
                if (F0.isNull(i14)) {
                    c23 = i24;
                    c24 = i14;
                    i15 = c25;
                    valueOf3 = null;
                } else {
                    c24 = i14;
                    valueOf3 = Long.valueOf(F0.getLong(i14));
                    c23 = i24;
                    i15 = c25;
                }
                int i25 = i6;
                if (((int) F0.getLong(i15)) != 0) {
                    i16 = c26;
                    z2 = true;
                } else {
                    i16 = c26;
                    z2 = false;
                }
                int i26 = i7;
                if (((int) F0.getLong(i16)) != 0) {
                    i17 = c27;
                    z3 = true;
                } else {
                    i17 = c27;
                    z3 = false;
                }
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c28;
                    z4 = true;
                } else {
                    i18 = c28;
                    z4 = false;
                }
                VideoDetailPlayBean videoDetailPlayBean = new VideoDetailPlayBean(q07, q0, i19, i21, j, q08, q09, q010, q011, j2, q012, valueOf4, valueOf5, q02, valueOf, z, q03, q04, q05, j3, b2, valueOf2, valueOf3, z2, z3, z4, F0.isNull(i18) ? null : F0.q0(i18));
                arrayList2 = arrayList;
                arrayList2.add(videoDetailPlayBean);
                c27 = i17;
                c28 = i18;
                c7 = i22;
                c18 = i25;
                c3 = i;
                c6 = i4;
                c17 = i12;
                c5 = i3;
                c25 = i15;
                c2 = i8;
                c16 = i13;
                c19 = i26;
                c22 = i11;
                c26 = i16;
                c4 = i20;
            }
            F0.close();
            return arrayList2;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ VideoDetailPlayBean L(String str, y3.b bVar) {
        String q0;
        int i;
        Integer valueOf;
        int i2;
        boolean z;
        int i3;
        String q02;
        int i4;
        String q03;
        int i5;
        String q04;
        int i6;
        String q05;
        z0 z0Var;
        Long valueOf2;
        int i7;
        Long valueOf3;
        int i8;
        boolean z2;
        int i9;
        boolean z3;
        int i10;
        y3.e F0 = bVar.F0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE dubs LIKE '%' || ? || '%' ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "subjectId");
            int c3 = androidx.room.util.i.c(F0, "id");
            int c4 = androidx.room.util.i.c(F0, "ep");
            int c5 = androidx.room.util.i.c(F0, "se");
            int c6 = androidx.room.util.i.c(F0, "progress");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "coverUrl");
            int c9 = androidx.room.util.i.c(F0, "thumbnail");
            int c10 = androidx.room.util.i.c(F0, "videoUrl");
            int c11 = androidx.room.util.i.c(F0, "timeStamp");
            int c12 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c13 = androidx.room.util.i.c(F0, "totalDuration");
            int c14 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c15 = androidx.room.util.i.c(F0, "averageHueLight");
            int c16 = androidx.room.util.i.c(F0, "subjectType");
            int c17 = androidx.room.util.i.c(F0, "hasDelete");
            int c18 = androidx.room.util.i.c(F0, "playMode");
            int c19 = androidx.room.util.i.c(F0, "downloadUrl");
            int c20 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c21 = androidx.room.util.i.c(F0, "downloadSize");
            int c22 = androidx.room.util.i.c(F0, "dubs");
            int c23 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c24 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c25 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c26 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c27 = androidx.room.util.i.c(F0, "rewardFree");
            int c28 = androidx.room.util.i.c(F0, "ops");
            VideoDetailPlayBean videoDetailPlayBean = null;
            if (F0.C0()) {
                String q06 = F0.isNull(c2) ? null : F0.q0(c2);
                String q07 = F0.isNull(c3) ? null : F0.q0(c3);
                int i11 = (int) F0.getLong(c4);
                int i12 = (int) F0.getLong(c5);
                long j = F0.getLong(c6);
                String q08 = F0.isNull(c7) ? null : F0.q0(c7);
                String q09 = F0.isNull(c8) ? null : F0.q0(c8);
                String q010 = F0.isNull(c9) ? null : F0.q0(c9);
                String q011 = F0.isNull(c10) ? null : F0.q0(c10);
                long j2 = F0.getLong(c11);
                String q012 = F0.isNull(c12) ? null : F0.q0(c12);
                Long valueOf4 = F0.isNull(c13) ? null : Long.valueOf(F0.getLong(c13));
                Long valueOf5 = F0.isNull(c14) ? null : Long.valueOf(F0.getLong(c14));
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
                    valueOf = Integer.valueOf((int) F0.getLong(i));
                    i2 = c17;
                }
                if (((int) F0.getLong(i2)) != 0) {
                    i3 = c18;
                    z = true;
                } else {
                    z = false;
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
                    q03 = null;
                } else {
                    q03 = F0.q0(i4);
                    i5 = c20;
                }
                if (F0.isNull(i5)) {
                    i6 = c21;
                    q04 = null;
                } else {
                    q04 = F0.q0(i5);
                    i6 = c21;
                }
                long j3 = F0.getLong(i6);
                if (F0.isNull(c22)) {
                    z0Var = this;
                    q05 = null;
                } else {
                    q05 = F0.q0(c22);
                    z0Var = this;
                }
                try {
                    ArrayList b2 = z0Var.c.b(q05);
                    if (F0.isNull(c23)) {
                        i7 = c24;
                        valueOf2 = null;
                    } else {
                        valueOf2 = Long.valueOf(F0.getLong(c23));
                        i7 = c24;
                    }
                    if (F0.isNull(i7)) {
                        i8 = c25;
                        valueOf3 = null;
                    } else {
                        valueOf3 = Long.valueOf(F0.getLong(i7));
                        i8 = c25;
                    }
                    if (((int) F0.getLong(i8)) != 0) {
                        i9 = c26;
                        z2 = true;
                    } else {
                        z2 = false;
                        i9 = c26;
                    }
                    if (((int) F0.getLong(i9)) != 0) {
                        i10 = c27;
                        z3 = true;
                    } else {
                        z3 = false;
                        i10 = c27;
                    }
                    videoDetailPlayBean = new VideoDetailPlayBean(q06, q07, i11, i12, j, q08, q09, q010, q011, j2, q012, valueOf4, valueOf5, q0, valueOf, z, q02, q03, q04, j3, b2, valueOf2, valueOf3, z2, z3, ((int) F0.getLong(i10)) != 0, F0.isNull(c28) ? null : F0.q0(c28));
                } catch (Throwable th2) {
                    th = th2;
                    F0.close();
                    throw th;
                }
            }
            F0.close();
            return videoDetailPlayBean;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List M(int i, int i2, y3.b bVar) {
        int i3;
        String q0;
        int i4;
        String q02;
        int i5;
        int i6;
        int i7;
        Integer valueOf;
        int i8;
        boolean z;
        String q03;
        int i9;
        String q04;
        int i10;
        int i11;
        String q05;
        int i12;
        int i13;
        int i14;
        String q06;
        int i15;
        Long valueOf2;
        int i16;
        Long valueOf3;
        int i17;
        int i18;
        boolean z2;
        int i19;
        boolean z3;
        int i20;
        boolean z4;
        y3.e F0 = bVar.F0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL AND rowid IN (SELECT rowid FROM (SELECT rowid, subjectId, MAX(timeStamp) as maxTimeStamp FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL GROUP BY subjectId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?;");
        try {
            F0.c(1, i);
            F0.c(2, i2);
            int c2 = androidx.room.util.i.c(F0, "subjectId");
            int c3 = androidx.room.util.i.c(F0, "id");
            int c4 = androidx.room.util.i.c(F0, "ep");
            int c5 = androidx.room.util.i.c(F0, "se");
            int c6 = androidx.room.util.i.c(F0, "progress");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "coverUrl");
            int c9 = androidx.room.util.i.c(F0, "thumbnail");
            int c10 = androidx.room.util.i.c(F0, "videoUrl");
            int c11 = androidx.room.util.i.c(F0, "timeStamp");
            int c12 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c13 = androidx.room.util.i.c(F0, "totalDuration");
            int c14 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c15 = androidx.room.util.i.c(F0, "averageHueLight");
            int c16 = androidx.room.util.i.c(F0, "subjectType");
            int c17 = androidx.room.util.i.c(F0, "hasDelete");
            int c18 = androidx.room.util.i.c(F0, "playMode");
            int c19 = androidx.room.util.i.c(F0, "downloadUrl");
            int c20 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c21 = androidx.room.util.i.c(F0, "downloadSize");
            int c22 = androidx.room.util.i.c(F0, "dubs");
            int c23 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c24 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c25 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c26 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c27 = androidx.room.util.i.c(F0, "rewardFree");
            int c28 = androidx.room.util.i.c(F0, "ops");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q07 = F0.isNull(c2) ? null : F0.q0(c2);
                if (F0.isNull(c3)) {
                    i4 = c2;
                    i3 = c3;
                    q0 = null;
                } else {
                    i3 = c3;
                    q0 = F0.q0(c3);
                    i4 = c2;
                }
                int i21 = (int) F0.getLong(c4);
                int i22 = c4;
                int i23 = (int) F0.getLong(c5);
                long j = F0.getLong(c6);
                String q08 = F0.isNull(c7) ? null : F0.q0(c7);
                String q09 = F0.isNull(c8) ? null : F0.q0(c8);
                String q010 = F0.isNull(c9) ? null : F0.q0(c9);
                String q011 = F0.isNull(c10) ? null : F0.q0(c10);
                long j2 = F0.getLong(c11);
                String q012 = F0.isNull(c12) ? null : F0.q0(c12);
                Long valueOf4 = F0.isNull(c13) ? null : Long.valueOf(F0.getLong(c13));
                Long valueOf5 = F0.isNull(c14) ? null : Long.valueOf(F0.getLong(c14));
                if (F0.isNull(c15)) {
                    i5 = c16;
                    q02 = null;
                } else {
                    q02 = F0.q0(c15);
                    i5 = c16;
                }
                if (F0.isNull(i5)) {
                    i6 = c5;
                    i7 = c6;
                    valueOf = null;
                } else {
                    i6 = c5;
                    i7 = c6;
                    valueOf = Integer.valueOf((int) F0.getLong(i5));
                }
                int i24 = c17;
                int i25 = c7;
                if (((int) F0.getLong(i24)) != 0) {
                    i8 = c18;
                    z = true;
                } else {
                    i8 = c18;
                    z = false;
                }
                if (F0.isNull(i8)) {
                    i9 = c19;
                    q03 = null;
                } else {
                    q03 = F0.q0(i8);
                    i9 = c19;
                }
                if (F0.isNull(i9)) {
                    i10 = i5;
                    i11 = c20;
                    q04 = null;
                } else {
                    q04 = F0.q0(i9);
                    i10 = i5;
                    i11 = c20;
                }
                if (F0.isNull(i11)) {
                    c20 = i11;
                    i12 = c21;
                    q05 = null;
                } else {
                    q05 = F0.q0(i11);
                    c20 = i11;
                    i12 = c21;
                }
                long j3 = F0.getLong(i12);
                c21 = i12;
                int i26 = c22;
                if (F0.isNull(i26)) {
                    i13 = i26;
                    i15 = i24;
                    i14 = i8;
                    q06 = null;
                } else {
                    i13 = i26;
                    i14 = i8;
                    q06 = F0.q0(i26);
                    i15 = i24;
                }
                ArrayList b2 = this.c.b(q06);
                int i27 = c23;
                if (F0.isNull(i27)) {
                    i16 = c24;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i27));
                    i16 = c24;
                }
                if (F0.isNull(i16)) {
                    c23 = i27;
                    c24 = i16;
                    i17 = c25;
                    valueOf3 = null;
                } else {
                    c24 = i16;
                    valueOf3 = Long.valueOf(F0.getLong(i16));
                    c23 = i27;
                    i17 = c25;
                }
                int i28 = i9;
                if (((int) F0.getLong(i17)) != 0) {
                    i18 = c26;
                    z2 = true;
                } else {
                    i18 = c26;
                    z2 = false;
                }
                int i29 = i17;
                c26 = i18;
                if (((int) F0.getLong(i18)) != 0) {
                    i19 = c27;
                    z3 = true;
                } else {
                    i19 = c27;
                    z3 = false;
                }
                if (((int) F0.getLong(i19)) != 0) {
                    i20 = c28;
                    z4 = true;
                } else {
                    i20 = c28;
                    z4 = false;
                }
                arrayList.add(new VideoDetailPlayBean(q07, q0, i21, i23, j, q08, q09, q010, q011, j2, q012, valueOf4, valueOf5, q02, valueOf, z, q03, q04, q05, j3, b2, valueOf2, valueOf3, z2, z3, z4, F0.isNull(i20) ? null : F0.q0(i20)));
                c5 = i6;
                c28 = i20;
                c27 = i19;
                c16 = i10;
                c19 = i28;
                c2 = i4;
                c3 = i3;
                c4 = i22;
                c6 = i7;
                c18 = i14;
                c25 = i29;
                c7 = i25;
                c17 = i15;
                c22 = i13;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long N(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT SUM(progress) AS totalProgress FROM VIDEO_DETAIL_PLAY WHERE subjectId = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            Long l = null;
            if (F0.C0() && !F0.isNull(0)) {
                l = Long.valueOf(F0.getLong(0));
            }
            return l;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List O(int i, int i2, int i3, y3.b bVar) {
        int i4;
        String q0;
        int i5;
        String q02;
        int i6;
        int i7;
        int i8;
        Integer valueOf;
        int i9;
        boolean z;
        int i10;
        String q03;
        String q04;
        int i11;
        int i12;
        String q05;
        int i13;
        int i14;
        int i15;
        String q06;
        int i16;
        Long valueOf2;
        int i17;
        Long valueOf3;
        int i18;
        int i19;
        boolean z2;
        int i20;
        boolean z3;
        int i21;
        boolean z4;
        y3.e F0 = bVar.F0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL AND subjectType=? AND subjectDurationSeconds > 0 AND rowid IN (SELECT rowid FROM (SELECT rowid, subjectId, MAX(timeStamp) as maxTimeStamp FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL GROUP BY subjectId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?;");
        try {
            F0.c(1, i);
            F0.c(2, i2);
            F0.c(3, i3);
            int c2 = androidx.room.util.i.c(F0, "subjectId");
            int c3 = androidx.room.util.i.c(F0, "id");
            int c4 = androidx.room.util.i.c(F0, "ep");
            int c5 = androidx.room.util.i.c(F0, "se");
            int c6 = androidx.room.util.i.c(F0, "progress");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "coverUrl");
            int c9 = androidx.room.util.i.c(F0, "thumbnail");
            int c10 = androidx.room.util.i.c(F0, "videoUrl");
            int c11 = androidx.room.util.i.c(F0, "timeStamp");
            int c12 = androidx.room.util.i.c(F0, "subtitleSelectId");
            int c13 = androidx.room.util.i.c(F0, "totalDuration");
            int c14 = androidx.room.util.i.c(F0, "subjectDurationSeconds");
            int c15 = androidx.room.util.i.c(F0, "averageHueLight");
            int c16 = androidx.room.util.i.c(F0, "subjectType");
            int c17 = androidx.room.util.i.c(F0, "hasDelete");
            int c18 = androidx.room.util.i.c(F0, "playMode");
            int c19 = androidx.room.util.i.c(F0, "downloadUrl");
            int c20 = androidx.room.util.i.c(F0, "downloadFilePath");
            int c21 = androidx.room.util.i.c(F0, "downloadSize");
            int c22 = androidx.room.util.i.c(F0, "dubs");
            int c23 = androidx.room.util.i.c(F0, "lastAdStartTimeStamp");
            int c24 = androidx.room.util.i.c(F0, "lastAdEndTimeStamp");
            int c25 = androidx.room.util.i.c(F0, "rewardPlayed");
            int c26 = androidx.room.util.i.c(F0, "rewardUnlock");
            int c27 = androidx.room.util.i.c(F0, "rewardFree");
            int c28 = androidx.room.util.i.c(F0, "ops");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q07 = F0.isNull(c2) ? null : F0.q0(c2);
                if (F0.isNull(c3)) {
                    i5 = c2;
                    i4 = c3;
                    q0 = null;
                } else {
                    i4 = c3;
                    q0 = F0.q0(c3);
                    i5 = c2;
                }
                int i22 = (int) F0.getLong(c4);
                int i23 = c4;
                int i24 = (int) F0.getLong(c5);
                long j = F0.getLong(c6);
                String q08 = F0.isNull(c7) ? null : F0.q0(c7);
                String q09 = F0.isNull(c8) ? null : F0.q0(c8);
                String q010 = F0.isNull(c9) ? null : F0.q0(c9);
                String q011 = F0.isNull(c10) ? null : F0.q0(c10);
                long j2 = F0.getLong(c11);
                String q012 = F0.isNull(c12) ? null : F0.q0(c12);
                Long valueOf4 = F0.isNull(c13) ? null : Long.valueOf(F0.getLong(c13));
                Long valueOf5 = F0.isNull(c14) ? null : Long.valueOf(F0.getLong(c14));
                if (F0.isNull(c15)) {
                    i6 = c16;
                    q02 = null;
                } else {
                    q02 = F0.q0(c15);
                    i6 = c16;
                }
                if (F0.isNull(i6)) {
                    i7 = c5;
                    i8 = c6;
                    valueOf = null;
                } else {
                    i7 = c5;
                    i8 = c6;
                    valueOf = Integer.valueOf((int) F0.getLong(i6));
                }
                int i25 = c17;
                int i26 = c7;
                if (((int) F0.getLong(i25)) != 0) {
                    i9 = c18;
                    z = true;
                } else {
                    i9 = c18;
                    z = false;
                }
                if (F0.isNull(i9)) {
                    i10 = c19;
                    q03 = null;
                } else {
                    i10 = c19;
                    q03 = F0.q0(i9);
                }
                if (F0.isNull(i10)) {
                    i11 = i6;
                    i12 = c20;
                    q04 = null;
                } else {
                    q04 = F0.q0(i10);
                    i11 = i6;
                    i12 = c20;
                }
                if (F0.isNull(i12)) {
                    c20 = i12;
                    i13 = c21;
                    q05 = null;
                } else {
                    q05 = F0.q0(i12);
                    c20 = i12;
                    i13 = c21;
                }
                long j3 = F0.getLong(i13);
                c21 = i13;
                int i27 = c22;
                if (F0.isNull(i27)) {
                    i14 = i27;
                    i16 = i25;
                    i15 = i9;
                    q06 = null;
                } else {
                    i14 = i27;
                    i15 = i9;
                    q06 = F0.q0(i27);
                    i16 = i25;
                }
                ArrayList b2 = this.c.b(q06);
                int i28 = c23;
                if (F0.isNull(i28)) {
                    i17 = c24;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(i28));
                    i17 = c24;
                }
                if (F0.isNull(i17)) {
                    c23 = i28;
                    c24 = i17;
                    i18 = c25;
                    valueOf3 = null;
                } else {
                    c24 = i17;
                    valueOf3 = Long.valueOf(F0.getLong(i17));
                    c23 = i28;
                    i18 = c25;
                }
                int i29 = i10;
                if (((int) F0.getLong(i18)) != 0) {
                    i19 = c26;
                    z2 = true;
                } else {
                    i19 = c26;
                    z2 = false;
                }
                int i30 = i18;
                c26 = i19;
                if (((int) F0.getLong(i19)) != 0) {
                    i20 = c27;
                    z3 = true;
                } else {
                    i20 = c27;
                    z3 = false;
                }
                if (((int) F0.getLong(i20)) != 0) {
                    i21 = c28;
                    z4 = true;
                } else {
                    i21 = c28;
                    z4 = false;
                }
                arrayList.add(new VideoDetailPlayBean(q07, q0, i22, i24, j, q08, q09, q010, q011, j2, q012, valueOf4, valueOf5, q02, valueOf, z, q03, q04, q05, j3, b2, valueOf2, valueOf3, z2, z3, z4, F0.isNull(i21) ? null : F0.q0(i21)));
                c5 = i7;
                c28 = i21;
                c27 = i20;
                c16 = i11;
                c19 = i29;
                c2 = i5;
                c3 = i4;
                c4 = i23;
                c6 = i8;
                c18 = i15;
                c25 = i30;
                c7 = i26;
                c17 = i16;
                c22 = i14;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit P(VideoDetailPlayBean videoDetailPlayBean, y3.b bVar) {
        this.b.d(bVar, videoDetailPlayBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Q(VideoDetailPlayBean videoDetailPlayBean, y3.b bVar) {
        this.e.c(bVar, videoDetailPlayBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit R(String str, String str2, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE VIDEO_DETAIL_PLAY SET subtitleSelectId = ? WHERE subjectId = ? ");
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

    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.y0
            public final Object invoke(Object obj) {
                Unit G;
                G = z0.G((y3.b) obj);
                return G;
            }
        }, continuation);
    }

    public Object b(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.p0
            public final Object invoke(Object obj) {
                Unit R;
                R = z0.R(str2, str, (y3.b) obj);
                return R;
            }
        }, continuation);
    }

    public Object c(String str, Continuation continuation) {
        return VideoDetailPlayDao$DefaultImpls.a(this, str, continuation);
    }

    public Object d(final int i, final int i2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.s0
            public final Object invoke(Object obj) {
                List M;
                M = z0.this.M(i2, i, (y3.b) obj);
                return M;
            }
        }, continuation);
    }

    public Object e(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.w0
            public final Object invoke(Object obj) {
                VideoDetailPlayBean H;
                H = z0.this.H(str, (y3.b) obj);
                return H;
            }
        }, continuation);
    }

    public Object f(String str, int i, int i2, long j, long j2, Continuation continuation) {
        return VideoDetailPlayDao$DefaultImpls.c(this, str, i, i2, j, j2, continuation);
    }

    public Object g(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.v0
            public final Object invoke(Object obj) {
                Long N;
                N = z0.N(str, (y3.b) obj);
                return N;
            }
        }, continuation);
    }

    public Object h(final VideoDetailPlayBean videoDetailPlayBean, Continuation continuation) {
        videoDetailPlayBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.o0
            public final Object invoke(Object obj) {
                Unit F;
                F = z0.this.F(videoDetailPlayBean, (y3.b) obj);
                return F;
            }
        }, continuation);
    }

    public Object i(final int i, final int i2, final int i3, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.r0
            public final Object invoke(Object obj) {
                List O;
                O = z0.this.O(i3, i2, i, (y3.b) obj);
                return O;
            }
        }, continuation);
    }

    public Object j(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.n0
            public final Object invoke(Object obj) {
                List K;
                K = z0.this.K(str, (y3.b) obj);
                return K;
            }
        }, continuation);
    }

    public Object k(final VideoDetailPlayBean videoDetailPlayBean, Continuation continuation) {
        videoDetailPlayBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.t0
            public final Object invoke(Object obj) {
                Unit Q;
                Q = z0.this.Q(videoDetailPlayBean, (y3.b) obj);
                return Q;
            }
        }, continuation);
    }

    public Object l(final String str, final int i, final int i2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.u0
            public final Object invoke(Object obj) {
                VideoDetailPlayBean I;
                I = z0.this.I(i, i2, str, (y3.b) obj);
                return I;
            }
        }, continuation);
    }

    public Object m(final String str, final int i, final int i2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.q0
            public final Object invoke(Object obj) {
                VideoDetailPlayBean J;
                J = z0.this.J(str, i, i2, (y3.b) obj);
                return J;
            }
        }, continuation);
    }

    public Object n(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.x0
            public final Object invoke(Object obj) {
                VideoDetailPlayBean L;
                L = z0.this.L(str, (y3.b) obj);
                return L;
            }
        }, continuation);
    }

    public Object o(final VideoDetailPlayBean videoDetailPlayBean, Continuation continuation) {
        videoDetailPlayBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.m0
            public final Object invoke(Object obj) {
                Unit P;
                P = z0.this.P(videoDetailPlayBean, (y3.b) obj);
                return P;
            }
        }, continuation);
    }

    public Object p(VideoDetailPlayBean videoDetailPlayBean, Continuation continuation) {
        return VideoDetailPlayDao$DefaultImpls.b(this, videoDetailPlayBean, continuation);
    }
}
