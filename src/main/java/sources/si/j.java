package si;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements si.a {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();
    private final androidx.room.e d = new c();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `audio` (`audioId`,`cover`,`duration`,`size`,`url`,`title`,`desc`,`bitrate`,`updateTimeStamp`,`readProcess`,`localPath`,`ops`,`resourceId`,`postId`,`subjectId`,`groupId`,`status`,`subjectTitle`,`se`,`ep`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AudioBean audioBean) {
            if (audioBean.getAudioUrl() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, audioBean.getAudioUrl());
            }
            if (audioBean.getCover() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, audioBean.getCover());
            }
            if (audioBean.getDuration() == null) {
                eVar.g(3);
            } else {
                eVar.c(3, audioBean.getDuration().longValue());
            }
            if (audioBean.getSize() == null) {
                eVar.g(4);
            } else {
                eVar.c(4, audioBean.getSize().longValue());
            }
            if (audioBean.getUrl() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, audioBean.getUrl());
            }
            if (audioBean.getTitle() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, audioBean.getTitle());
            }
            if (audioBean.getDesc() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, audioBean.getDesc());
            }
            if (audioBean.getBitrate() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, audioBean.getBitrate().intValue());
            }
            if (audioBean.getUpdateTimeStamp() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, audioBean.getUpdateTimeStamp().longValue());
            }
            if (audioBean.getReadProcess() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, audioBean.getReadProcess().longValue());
            }
            if (audioBean.getLocalPath() == null) {
                eVar.g(11);
            } else {
                eVar.i(11, audioBean.getLocalPath());
            }
            if (audioBean.getOps() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, audioBean.getOps());
            }
            if (audioBean.getResourceId() == null) {
                eVar.g(13);
            } else {
                eVar.i(13, audioBean.getResourceId());
            }
            if (audioBean.getPostId() == null) {
                eVar.g(14);
            } else {
                eVar.i(14, audioBean.getPostId());
            }
            if (audioBean.getSubjectId() == null) {
                eVar.g(15);
            } else {
                eVar.i(15, audioBean.getSubjectId());
            }
            if (audioBean.getGroupId() == null) {
                eVar.g(16);
            } else {
                eVar.i(16, audioBean.getGroupId());
            }
            eVar.c(17, audioBean.getStatus());
            if (audioBean.getSubjectTitle() == null) {
                eVar.g(18);
            } else {
                eVar.i(18, audioBean.getSubjectTitle());
            }
            eVar.c(19, audioBean.getSe());
            eVar.c(20, audioBean.getEp());
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `audio` WHERE `audioId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AudioBean audioBean) {
            if (audioBean.getAudioUrl() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, audioBean.getAudioUrl());
            }
        }
    }

    class c extends androidx.room.e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `audio` SET `audioId` = ?,`cover` = ?,`duration` = ?,`size` = ?,`url` = ?,`title` = ?,`desc` = ?,`bitrate` = ?,`updateTimeStamp` = ?,`readProcess` = ?,`localPath` = ?,`ops` = ?,`resourceId` = ?,`postId` = ?,`subjectId` = ?,`groupId` = ?,`status` = ?,`subjectTitle` = ?,`se` = ?,`ep` = ? WHERE `audioId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AudioBean audioBean) {
            if (audioBean.getAudioUrl() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, audioBean.getAudioUrl());
            }
            if (audioBean.getCover() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, audioBean.getCover());
            }
            if (audioBean.getDuration() == null) {
                eVar.g(3);
            } else {
                eVar.c(3, audioBean.getDuration().longValue());
            }
            if (audioBean.getSize() == null) {
                eVar.g(4);
            } else {
                eVar.c(4, audioBean.getSize().longValue());
            }
            if (audioBean.getUrl() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, audioBean.getUrl());
            }
            if (audioBean.getTitle() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, audioBean.getTitle());
            }
            if (audioBean.getDesc() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, audioBean.getDesc());
            }
            if (audioBean.getBitrate() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, audioBean.getBitrate().intValue());
            }
            if (audioBean.getUpdateTimeStamp() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, audioBean.getUpdateTimeStamp().longValue());
            }
            if (audioBean.getReadProcess() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, audioBean.getReadProcess().longValue());
            }
            if (audioBean.getLocalPath() == null) {
                eVar.g(11);
            } else {
                eVar.i(11, audioBean.getLocalPath());
            }
            if (audioBean.getOps() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, audioBean.getOps());
            }
            if (audioBean.getResourceId() == null) {
                eVar.g(13);
            } else {
                eVar.i(13, audioBean.getResourceId());
            }
            if (audioBean.getPostId() == null) {
                eVar.g(14);
            } else {
                eVar.i(14, audioBean.getPostId());
            }
            if (audioBean.getSubjectId() == null) {
                eVar.g(15);
            } else {
                eVar.i(15, audioBean.getSubjectId());
            }
            if (audioBean.getGroupId() == null) {
                eVar.g(16);
            } else {
                eVar.i(16, audioBean.getGroupId());
            }
            eVar.c(17, audioBean.getStatus());
            if (audioBean.getSubjectTitle() == null) {
                eVar.g(18);
            } else {
                eVar.i(18, audioBean.getSubjectTitle());
            }
            eVar.c(19, audioBean.getSe());
            eVar.c(20, audioBean.getEp());
            if (audioBean.getAudioUrl() == null) {
                eVar.g(21);
            } else {
                eVar.i(21, audioBean.getAudioUrl());
            }
        }
    }

    public j(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List q() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit r(y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM Audio");
        try {
            F0.C0();
            return Unit.a;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(AudioBean audioBean, y3.b bVar) {
        this.c.c(bVar, audioBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AudioBean t(String str, y3.b bVar) {
        String q0;
        int i;
        String q02;
        int i2;
        String q03;
        int i3;
        y3.e F0 = bVar.F0("SELECT * FROM Audio WHERE audioId = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "audioId");
            int c3 = androidx.room.util.i.c(F0, "cover");
            int c4 = androidx.room.util.i.c(F0, "duration");
            int c5 = androidx.room.util.i.c(F0, "size");
            int c6 = androidx.room.util.i.c(F0, "url");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "desc");
            int c9 = androidx.room.util.i.c(F0, "bitrate");
            int c10 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c11 = androidx.room.util.i.c(F0, "readProcess");
            int c12 = androidx.room.util.i.c(F0, "localPath");
            int c13 = androidx.room.util.i.c(F0, "ops");
            int c14 = androidx.room.util.i.c(F0, "resourceId");
            int c15 = androidx.room.util.i.c(F0, "postId");
            int c16 = androidx.room.util.i.c(F0, "subjectId");
            int c17 = androidx.room.util.i.c(F0, "groupId");
            int c18 = androidx.room.util.i.c(F0, "status");
            int c19 = androidx.room.util.i.c(F0, "subjectTitle");
            int c20 = androidx.room.util.i.c(F0, "se");
            int c21 = androidx.room.util.i.c(F0, "ep");
            if (F0.C0()) {
                String q04 = F0.isNull(c2) ? null : F0.q0(c2);
                String q05 = F0.isNull(c3) ? null : F0.q0(c3);
                Long valueOf = F0.isNull(c4) ? null : Long.valueOf(F0.getLong(c4));
                Long valueOf2 = F0.isNull(c5) ? null : Long.valueOf(F0.getLong(c5));
                String q06 = F0.isNull(c6) ? null : F0.q0(c6);
                String q07 = F0.isNull(c7) ? null : F0.q0(c7);
                String q08 = F0.isNull(c8) ? null : F0.q0(c8);
                Integer valueOf3 = F0.isNull(c9) ? null : Integer.valueOf((int) F0.getLong(c9));
                Long valueOf4 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf5 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                String q09 = F0.isNull(c12) ? null : F0.q0(c12);
                String q010 = F0.isNull(c13) ? null : F0.q0(c13);
                String q011 = F0.isNull(c14) ? null : F0.q0(c14);
                if (F0.isNull(c15)) {
                    i = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i = c16;
                }
                if (F0.isNull(i)) {
                    i2 = c17;
                    q02 = null;
                } else {
                    q02 = F0.q0(i);
                    i2 = c17;
                }
                if (F0.isNull(i2)) {
                    i3 = c18;
                    q03 = null;
                } else {
                    q03 = F0.q0(i2);
                    i3 = c18;
                }
                r20 = new AudioBean(q04, q05, valueOf, valueOf2, q06, q07, q08, valueOf3, valueOf4, valueOf5, q09, q010, q011, q0, q02, q03, (int) F0.getLong(i3), F0.isNull(c19) ? null : F0.q0(c19), (int) F0.getLong(c20), (int) F0.getLong(c21));
            }
            F0.close();
            return r20;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AudioBean u(String str, String str2, y3.b bVar) {
        String q0;
        int i;
        String q02;
        int i2;
        String q03;
        int i3;
        y3.e F0 = bVar.F0("SELECT * FROM Audio WHERE postId = ? AND subjectId =?");
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
            int c2 = androidx.room.util.i.c(F0, "audioId");
            int c3 = androidx.room.util.i.c(F0, "cover");
            int c4 = androidx.room.util.i.c(F0, "duration");
            int c5 = androidx.room.util.i.c(F0, "size");
            int c6 = androidx.room.util.i.c(F0, "url");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "desc");
            int c9 = androidx.room.util.i.c(F0, "bitrate");
            int c10 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c11 = androidx.room.util.i.c(F0, "readProcess");
            int c12 = androidx.room.util.i.c(F0, "localPath");
            int c13 = androidx.room.util.i.c(F0, "ops");
            int c14 = androidx.room.util.i.c(F0, "resourceId");
            int c15 = androidx.room.util.i.c(F0, "postId");
            int c16 = androidx.room.util.i.c(F0, "subjectId");
            int c17 = androidx.room.util.i.c(F0, "groupId");
            int c18 = androidx.room.util.i.c(F0, "status");
            int c19 = androidx.room.util.i.c(F0, "subjectTitle");
            int c20 = androidx.room.util.i.c(F0, "se");
            int c21 = androidx.room.util.i.c(F0, "ep");
            if (F0.C0()) {
                String q04 = F0.isNull(c2) ? null : F0.q0(c2);
                String q05 = F0.isNull(c3) ? null : F0.q0(c3);
                Long valueOf = F0.isNull(c4) ? null : Long.valueOf(F0.getLong(c4));
                Long valueOf2 = F0.isNull(c5) ? null : Long.valueOf(F0.getLong(c5));
                String q06 = F0.isNull(c6) ? null : F0.q0(c6);
                String q07 = F0.isNull(c7) ? null : F0.q0(c7);
                String q08 = F0.isNull(c8) ? null : F0.q0(c8);
                Integer valueOf3 = F0.isNull(c9) ? null : Integer.valueOf((int) F0.getLong(c9));
                Long valueOf4 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf5 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                String q09 = F0.isNull(c12) ? null : F0.q0(c12);
                String q010 = F0.isNull(c13) ? null : F0.q0(c13);
                String q011 = F0.isNull(c14) ? null : F0.q0(c14);
                if (F0.isNull(c15)) {
                    i = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i = c16;
                }
                if (F0.isNull(i)) {
                    i2 = c17;
                    q02 = null;
                } else {
                    q02 = F0.q0(i);
                    i2 = c17;
                }
                if (F0.isNull(i2)) {
                    i3 = c18;
                    q03 = null;
                } else {
                    q03 = F0.q0(i2);
                    i3 = c18;
                }
                r19 = new AudioBean(q04, q05, valueOf, valueOf2, q06, q07, q08, valueOf3, valueOf4, valueOf5, q09, q010, q011, q0, q02, q03, (int) F0.getLong(i3), F0.isNull(c19) ? null : F0.q0(c19), (int) F0.getLong(c20), (int) F0.getLong(c21));
            }
            F0.close();
            return r19;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AudioBean v(String str, y3.b bVar) {
        String q0;
        int i;
        String q02;
        int i2;
        String q03;
        int i3;
        y3.e F0 = bVar.F0("SELECT * FROM Audio WHERE resourceId = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "audioId");
            int c3 = androidx.room.util.i.c(F0, "cover");
            int c4 = androidx.room.util.i.c(F0, "duration");
            int c5 = androidx.room.util.i.c(F0, "size");
            int c6 = androidx.room.util.i.c(F0, "url");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "desc");
            int c9 = androidx.room.util.i.c(F0, "bitrate");
            int c10 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c11 = androidx.room.util.i.c(F0, "readProcess");
            int c12 = androidx.room.util.i.c(F0, "localPath");
            int c13 = androidx.room.util.i.c(F0, "ops");
            int c14 = androidx.room.util.i.c(F0, "resourceId");
            int c15 = androidx.room.util.i.c(F0, "postId");
            int c16 = androidx.room.util.i.c(F0, "subjectId");
            int c17 = androidx.room.util.i.c(F0, "groupId");
            int c18 = androidx.room.util.i.c(F0, "status");
            int c19 = androidx.room.util.i.c(F0, "subjectTitle");
            int c20 = androidx.room.util.i.c(F0, "se");
            int c21 = androidx.room.util.i.c(F0, "ep");
            if (F0.C0()) {
                String q04 = F0.isNull(c2) ? null : F0.q0(c2);
                String q05 = F0.isNull(c3) ? null : F0.q0(c3);
                Long valueOf = F0.isNull(c4) ? null : Long.valueOf(F0.getLong(c4));
                Long valueOf2 = F0.isNull(c5) ? null : Long.valueOf(F0.getLong(c5));
                String q06 = F0.isNull(c6) ? null : F0.q0(c6);
                String q07 = F0.isNull(c7) ? null : F0.q0(c7);
                String q08 = F0.isNull(c8) ? null : F0.q0(c8);
                Integer valueOf3 = F0.isNull(c9) ? null : Integer.valueOf((int) F0.getLong(c9));
                Long valueOf4 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf5 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                String q09 = F0.isNull(c12) ? null : F0.q0(c12);
                String q010 = F0.isNull(c13) ? null : F0.q0(c13);
                String q011 = F0.isNull(c14) ? null : F0.q0(c14);
                if (F0.isNull(c15)) {
                    i = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i = c16;
                }
                if (F0.isNull(i)) {
                    i2 = c17;
                    q02 = null;
                } else {
                    q02 = F0.q0(i);
                    i2 = c17;
                }
                if (F0.isNull(i2)) {
                    i3 = c18;
                    q03 = null;
                } else {
                    q03 = F0.q0(i2);
                    i3 = c18;
                }
                r20 = new AudioBean(q04, q05, valueOf, valueOf2, q06, q07, q08, valueOf3, valueOf4, valueOf5, q09, q010, q011, q0, q02, q03, (int) F0.getLong(i3), F0.isNull(c19) ? null : F0.q0(c19), (int) F0.getLong(c20), (int) F0.getLong(c21));
            }
            F0.close();
            return r20;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List w(y3.b bVar) {
        int i;
        int i2;
        Integer valueOf;
        String q0;
        int i3;
        String q02;
        int i4;
        int i5;
        String q03;
        int i6;
        int i7;
        y3.e F0 = bVar.F0("SELECT * FROM Audio ORDER BY updateTimeStamp DESC");
        try {
            int c2 = androidx.room.util.i.c(F0, "audioId");
            int c3 = androidx.room.util.i.c(F0, "cover");
            int c4 = androidx.room.util.i.c(F0, "duration");
            int c5 = androidx.room.util.i.c(F0, "size");
            int c6 = androidx.room.util.i.c(F0, "url");
            int c7 = androidx.room.util.i.c(F0, "title");
            int c8 = androidx.room.util.i.c(F0, "desc");
            int c9 = androidx.room.util.i.c(F0, "bitrate");
            int c10 = androidx.room.util.i.c(F0, "updateTimeStamp");
            int c11 = androidx.room.util.i.c(F0, "readProcess");
            int c12 = androidx.room.util.i.c(F0, "localPath");
            int c13 = androidx.room.util.i.c(F0, "ops");
            int c14 = androidx.room.util.i.c(F0, "resourceId");
            int c15 = androidx.room.util.i.c(F0, "postId");
            int c16 = androidx.room.util.i.c(F0, "subjectId");
            int c17 = androidx.room.util.i.c(F0, "groupId");
            int c18 = androidx.room.util.i.c(F0, "status");
            int c19 = androidx.room.util.i.c(F0, "subjectTitle");
            int c20 = androidx.room.util.i.c(F0, "se");
            int c21 = androidx.room.util.i.c(F0, "ep");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q04 = F0.isNull(c2) ? null : F0.q0(c2);
                String q05 = F0.isNull(c3) ? null : F0.q0(c3);
                Long valueOf2 = F0.isNull(c4) ? null : Long.valueOf(F0.getLong(c4));
                Long valueOf3 = F0.isNull(c5) ? null : Long.valueOf(F0.getLong(c5));
                String q06 = F0.isNull(c6) ? null : F0.q0(c6);
                String q07 = F0.isNull(c7) ? null : F0.q0(c7);
                String q08 = F0.isNull(c8) ? null : F0.q0(c8);
                if (F0.isNull(c9)) {
                    i = c3;
                    i2 = c4;
                    valueOf = null;
                } else {
                    i = c3;
                    i2 = c4;
                    valueOf = Integer.valueOf((int) F0.getLong(c9));
                }
                Long valueOf4 = F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10));
                Long valueOf5 = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                String q09 = F0.isNull(c12) ? null : F0.q0(c12);
                String q010 = F0.isNull(c13) ? null : F0.q0(c13);
                String q011 = F0.isNull(c14) ? null : F0.q0(c14);
                if (F0.isNull(c15)) {
                    i3 = c16;
                    q0 = null;
                } else {
                    q0 = F0.q0(c15);
                    i3 = c16;
                }
                if (F0.isNull(i3)) {
                    i4 = c17;
                    q02 = null;
                } else {
                    q02 = F0.q0(i3);
                    i4 = c17;
                }
                if (F0.isNull(i4)) {
                    i5 = c2;
                    i7 = i3;
                    i6 = c18;
                    q03 = null;
                } else {
                    i5 = c2;
                    q03 = F0.q0(i4);
                    i6 = c18;
                    i7 = i3;
                }
                int i8 = i4;
                int i9 = (int) F0.getLong(i6);
                int i10 = c19;
                int i11 = i6;
                int i12 = c20;
                int i13 = c5;
                int i14 = c7;
                int i15 = c21;
                int i16 = c6;
                arrayList.add(new AudioBean(q04, q05, valueOf2, valueOf3, q06, q07, q08, valueOf, valueOf4, valueOf5, q09, q010, q011, q0, q02, q03, i9, F0.isNull(i10) ? null : F0.q0(i10), (int) F0.getLong(i12), (int) F0.getLong(i15)));
                c6 = i16;
                c3 = i;
                c4 = i2;
                c7 = i14;
                c21 = i15;
                c5 = i13;
                c20 = i12;
                c2 = i5;
                c16 = i7;
                c17 = i8;
                c18 = i11;
                c19 = i10;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit x(AudioBean audioBean, y3.b bVar) {
        this.b.d(bVar, audioBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit y(AudioBean audioBean, y3.b bVar) {
        this.d.c(bVar, audioBean);
        return Unit.a;
    }

    @Override // si.a
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: si.f
            public final Object invoke(Object obj) {
                Unit r;
                r = j.r((y3.b) obj);
                return r;
            }
        }, continuation);
    }

    @Override // si.a
    public Object b(final AudioBean audioBean, Continuation continuation) {
        audioBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: si.i
            public final Object invoke(Object obj) {
                Unit s;
                s = j.this.s(audioBean, (y3.b) obj);
                return s;
            }
        }, continuation);
    }

    @Override // si.a
    public Object c(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: si.d
            public final Object invoke(Object obj) {
                AudioBean t;
                t = j.t(str, (y3.b) obj);
                return t;
            }
        }, continuation);
    }

    @Override // si.a
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: si.g
            public final Object invoke(Object obj) {
                AudioBean v;
                v = j.v(str, (y3.b) obj);
                return v;
            }
        }, continuation);
    }

    @Override // si.a
    public Object e(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: si.h
            public final Object invoke(Object obj) {
                List w;
                w = j.w((y3.b) obj);
                return w;
            }
        }, continuation);
    }

    @Override // si.a
    public Object f(final AudioBean audioBean, Continuation continuation) {
        audioBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: si.e
            public final Object invoke(Object obj) {
                Unit y;
                y = j.this.y(audioBean, (y3.b) obj);
                return y;
            }
        }, continuation);
    }

    @Override // si.a
    public Object g(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: si.b
            public final Object invoke(Object obj) {
                AudioBean u;
                u = j.u(str, str2, (y3.b) obj);
                return u;
            }
        }, continuation);
    }

    @Override // si.a
    public Object h(final AudioBean audioBean, Continuation continuation) {
        audioBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: si.c
            public final Object invoke(Object obj) {
                Unit x;
                x = j.this.x(audioBean, (y3.b) obj);
                return x;
            }
        }, continuation);
    }
}
