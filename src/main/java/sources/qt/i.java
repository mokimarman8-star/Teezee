package qt;

import androidx.room.RoomDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.web.api.WebConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i implements qt.a {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();
    private final androidx.room.e d = new c();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `st_download_table` (`id`,`resourceStreamType`,`resourceId`,`lan`,`lanName`,`url`,`size`,`delay`,`downloads`,`type`,`postId`,`subtitleName`,`subjectId`,`ep`,`se`,`resolution`,`subjectName`,`status`,`fileCharsetName`,`path`,`zipPath`,`taskId`,`failCount`,`ugcVideoId`,`ugcVideoCollectionId`,`ops`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, SubtitleDownloadTable subtitleDownloadTable) {
            if (subtitleDownloadTable.getId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, subtitleDownloadTable.getId());
            }
            eVar.c(2, subtitleDownloadTable.getResourceStreamType());
            if (subtitleDownloadTable.getResourceId() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, subtitleDownloadTable.getResourceId());
            }
            if (subtitleDownloadTable.getLan() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, subtitleDownloadTable.getLan());
            }
            if (subtitleDownloadTable.getLanName() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, subtitleDownloadTable.getLanName());
            }
            if (subtitleDownloadTable.getUrl() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, subtitleDownloadTable.getUrl());
            }
            if (subtitleDownloadTable.getSize() == null) {
                eVar.g(7);
            } else {
                eVar.c(7, subtitleDownloadTable.getSize().longValue());
            }
            if (subtitleDownloadTable.getDelay() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, subtitleDownloadTable.getDelay().longValue());
            }
            if (subtitleDownloadTable.getDownloads() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, subtitleDownloadTable.getDownloads().intValue());
            }
            eVar.c(10, subtitleDownloadTable.getType());
            if (subtitleDownloadTable.getPostId() == null) {
                eVar.g(11);
            } else {
                eVar.i(11, subtitleDownloadTable.getPostId());
            }
            if (subtitleDownloadTable.getSubtitleName() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, subtitleDownloadTable.getSubtitleName());
            }
            if (subtitleDownloadTable.getSubjectId() == null) {
                eVar.g(13);
            } else {
                eVar.i(13, subtitleDownloadTable.getSubjectId());
            }
            eVar.c(14, subtitleDownloadTable.getEp());
            eVar.c(15, subtitleDownloadTable.getSe());
            eVar.c(16, subtitleDownloadTable.getResolution());
            if (subtitleDownloadTable.getSubjectName() == null) {
                eVar.g(17);
            } else {
                eVar.i(17, subtitleDownloadTable.getSubjectName());
            }
            eVar.c(18, subtitleDownloadTable.getStatus());
            if (subtitleDownloadTable.getFileCharsetName() == null) {
                eVar.g(19);
            } else {
                eVar.i(19, subtitleDownloadTable.getFileCharsetName());
            }
            if (subtitleDownloadTable.getPath() == null) {
                eVar.g(20);
            } else {
                eVar.i(20, subtitleDownloadTable.getPath());
            }
            if (subtitleDownloadTable.getZipPath() == null) {
                eVar.g(21);
            } else {
                eVar.i(21, subtitleDownloadTable.getZipPath());
            }
            if (subtitleDownloadTable.getTaskId() == null) {
                eVar.g(22);
            } else {
                eVar.i(22, subtitleDownloadTable.getTaskId());
            }
            eVar.c(23, subtitleDownloadTable.getFailCount());
            if (subtitleDownloadTable.getUgcVideoId() == null) {
                eVar.g(24);
            } else {
                eVar.i(24, subtitleDownloadTable.getUgcVideoId());
            }
            if (subtitleDownloadTable.getUgcVideoCollectionId() == null) {
                eVar.g(25);
            } else {
                eVar.i(25, subtitleDownloadTable.getUgcVideoCollectionId());
            }
            if (subtitleDownloadTable.getOps() == null) {
                eVar.g(26);
            } else {
                eVar.i(26, subtitleDownloadTable.getOps());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `st_download_table` WHERE `id` = ? AND `resourceStreamType` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, SubtitleDownloadTable subtitleDownloadTable) {
            if (subtitleDownloadTable.getId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, subtitleDownloadTable.getId());
            }
            eVar.c(2, subtitleDownloadTable.getResourceStreamType());
        }
    }

    class c extends androidx.room.e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `st_download_table` SET `id` = ?,`resourceStreamType` = ?,`resourceId` = ?,`lan` = ?,`lanName` = ?,`url` = ?,`size` = ?,`delay` = ?,`downloads` = ?,`type` = ?,`postId` = ?,`subtitleName` = ?,`subjectId` = ?,`ep` = ?,`se` = ?,`resolution` = ?,`subjectName` = ?,`status` = ?,`fileCharsetName` = ?,`path` = ?,`zipPath` = ?,`taskId` = ?,`failCount` = ?,`ugcVideoId` = ?,`ugcVideoCollectionId` = ?,`ops` = ? WHERE `id` = ? AND `resourceStreamType` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, SubtitleDownloadTable subtitleDownloadTable) {
            if (subtitleDownloadTable.getId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, subtitleDownloadTable.getId());
            }
            eVar.c(2, subtitleDownloadTable.getResourceStreamType());
            if (subtitleDownloadTable.getResourceId() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, subtitleDownloadTable.getResourceId());
            }
            if (subtitleDownloadTable.getLan() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, subtitleDownloadTable.getLan());
            }
            if (subtitleDownloadTable.getLanName() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, subtitleDownloadTable.getLanName());
            }
            if (subtitleDownloadTable.getUrl() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, subtitleDownloadTable.getUrl());
            }
            if (subtitleDownloadTable.getSize() == null) {
                eVar.g(7);
            } else {
                eVar.c(7, subtitleDownloadTable.getSize().longValue());
            }
            if (subtitleDownloadTable.getDelay() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, subtitleDownloadTable.getDelay().longValue());
            }
            if (subtitleDownloadTable.getDownloads() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, subtitleDownloadTable.getDownloads().intValue());
            }
            eVar.c(10, subtitleDownloadTable.getType());
            if (subtitleDownloadTable.getPostId() == null) {
                eVar.g(11);
            } else {
                eVar.i(11, subtitleDownloadTable.getPostId());
            }
            if (subtitleDownloadTable.getSubtitleName() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, subtitleDownloadTable.getSubtitleName());
            }
            if (subtitleDownloadTable.getSubjectId() == null) {
                eVar.g(13);
            } else {
                eVar.i(13, subtitleDownloadTable.getSubjectId());
            }
            eVar.c(14, subtitleDownloadTable.getEp());
            eVar.c(15, subtitleDownloadTable.getSe());
            eVar.c(16, subtitleDownloadTable.getResolution());
            if (subtitleDownloadTable.getSubjectName() == null) {
                eVar.g(17);
            } else {
                eVar.i(17, subtitleDownloadTable.getSubjectName());
            }
            eVar.c(18, subtitleDownloadTable.getStatus());
            if (subtitleDownloadTable.getFileCharsetName() == null) {
                eVar.g(19);
            } else {
                eVar.i(19, subtitleDownloadTable.getFileCharsetName());
            }
            if (subtitleDownloadTable.getPath() == null) {
                eVar.g(20);
            } else {
                eVar.i(20, subtitleDownloadTable.getPath());
            }
            if (subtitleDownloadTable.getZipPath() == null) {
                eVar.g(21);
            } else {
                eVar.i(21, subtitleDownloadTable.getZipPath());
            }
            if (subtitleDownloadTable.getTaskId() == null) {
                eVar.g(22);
            } else {
                eVar.i(22, subtitleDownloadTable.getTaskId());
            }
            eVar.c(23, subtitleDownloadTable.getFailCount());
            if (subtitleDownloadTable.getUgcVideoId() == null) {
                eVar.g(24);
            } else {
                eVar.i(24, subtitleDownloadTable.getUgcVideoId());
            }
            if (subtitleDownloadTable.getUgcVideoCollectionId() == null) {
                eVar.g(25);
            } else {
                eVar.i(25, subtitleDownloadTable.getUgcVideoCollectionId());
            }
            if (subtitleDownloadTable.getOps() == null) {
                eVar.g(26);
            } else {
                eVar.i(26, subtitleDownloadTable.getOps());
            }
            if (subtitleDownloadTable.getId() == null) {
                eVar.g(27);
            } else {
                eVar.i(27, subtitleDownloadTable.getId());
            }
            eVar.c(28, subtitleDownloadTable.getResourceStreamType());
        }
    }

    public i(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List o() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p(SubtitleDownloadTable subtitleDownloadTable, y3.b bVar) {
        this.c.c(bVar, subtitleDownloadTable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit q(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM st_download_table WHERE resourceId =?");
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
        } catch (Throwable th) {
            F0.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List r(int i, y3.b bVar) {
        ArrayList arrayList;
        String q0;
        int i2;
        int i3;
        int i4;
        Integer valueOf;
        String q02;
        int i5;
        int i6;
        int i7;
        String q03;
        int i8;
        int i9;
        String q04;
        int i10;
        int i11;
        String q05;
        int i12;
        String q06;
        int i13;
        int i14;
        String q07;
        int i15;
        String q08;
        int i16;
        int i17;
        String q09;
        int i18;
        y3.e F0 = bVar.F0("SELECT * FROM st_download_table WHERE status = ?");
        try {
            F0.c(1, i);
            int c2 = androidx.room.util.i.c(F0, "id");
            int c3 = androidx.room.util.i.c(F0, "resourceStreamType");
            int c4 = androidx.room.util.i.c(F0, "resourceId");
            int c5 = androidx.room.util.i.c(F0, "lan");
            int c6 = androidx.room.util.i.c(F0, "lanName");
            int c7 = androidx.room.util.i.c(F0, WebConstants.FIELD_URL);
            int c8 = androidx.room.util.i.c(F0, "size");
            int c9 = androidx.room.util.i.c(F0, "delay");
            int c10 = androidx.room.util.i.c(F0, "downloads");
            int c11 = androidx.room.util.i.c(F0, "type");
            int c12 = androidx.room.util.i.c(F0, "postId");
            int c13 = androidx.room.util.i.c(F0, "subtitleName");
            int c14 = androidx.room.util.i.c(F0, "subjectId");
            int c15 = androidx.room.util.i.c(F0, "ep");
            int c16 = androidx.room.util.i.c(F0, "se");
            int c17 = androidx.room.util.i.c(F0, "resolution");
            int c18 = androidx.room.util.i.c(F0, "subjectName");
            int c19 = androidx.room.util.i.c(F0, "status");
            int c20 = androidx.room.util.i.c(F0, "fileCharsetName");
            int c21 = androidx.room.util.i.c(F0, "path");
            int c22 = androidx.room.util.i.c(F0, "zipPath");
            int c23 = androidx.room.util.i.c(F0, "taskId");
            int c24 = androidx.room.util.i.c(F0, "failCount");
            int c25 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c26 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c27 = androidx.room.util.i.c(F0, "ops");
            ArrayList arrayList2 = new ArrayList();
            while (F0.C0()) {
                if (F0.isNull(c2)) {
                    i2 = c15;
                    arrayList = arrayList2;
                    q0 = null;
                } else {
                    arrayList = arrayList2;
                    q0 = F0.q0(c2);
                    i2 = c15;
                }
                int i19 = (int) F0.getLong(c3);
                String q010 = F0.isNull(c4) ? null : F0.q0(c4);
                String q011 = F0.isNull(c5) ? null : F0.q0(c5);
                String q012 = F0.isNull(c6) ? null : F0.q0(c6);
                String q013 = F0.isNull(c7) ? null : F0.q0(c7);
                Long valueOf2 = F0.isNull(c8) ? null : Long.valueOf(F0.getLong(c8));
                Long valueOf3 = F0.isNull(c9) ? null : Long.valueOf(F0.getLong(c9));
                if (F0.isNull(c10)) {
                    i3 = c3;
                    i4 = c4;
                    valueOf = null;
                } else {
                    i3 = c3;
                    i4 = c4;
                    valueOf = Integer.valueOf((int) F0.getLong(c10));
                }
                int i20 = (int) F0.getLong(c11);
                String q014 = F0.isNull(c12) ? null : F0.q0(c12);
                String q015 = F0.isNull(c13) ? null : F0.q0(c13);
                if (F0.isNull(c14)) {
                    i5 = c6;
                    i6 = i2;
                    q02 = null;
                } else {
                    q02 = F0.q0(c14);
                    i5 = c6;
                    i6 = i2;
                }
                int i21 = c5;
                int i22 = (int) F0.getLong(i6);
                int i23 = c16;
                int i24 = c7;
                int i25 = c8;
                int i26 = (int) F0.getLong(i23);
                int i27 = c17;
                int i28 = c9;
                int i29 = c10;
                int i30 = (int) F0.getLong(i27);
                int i31 = c18;
                if (F0.isNull(i31)) {
                    i8 = c2;
                    i7 = i31;
                    i9 = c19;
                    q03 = null;
                } else {
                    i7 = i31;
                    q03 = F0.q0(i31);
                    i8 = c2;
                    i9 = c19;
                }
                int i32 = c11;
                int i33 = (int) F0.getLong(i9);
                int i34 = c20;
                if (F0.isNull(i34)) {
                    i10 = i9;
                    i11 = c21;
                    q04 = null;
                } else {
                    q04 = F0.q0(i34);
                    i10 = i9;
                    i11 = c21;
                }
                if (F0.isNull(i11)) {
                    c21 = i11;
                    i12 = c22;
                    q05 = null;
                } else {
                    q05 = F0.q0(i11);
                    c21 = i11;
                    i12 = c22;
                }
                if (F0.isNull(i12)) {
                    c22 = i12;
                    i13 = c23;
                    q06 = null;
                } else {
                    q06 = F0.q0(i12);
                    c22 = i12;
                    i13 = c23;
                }
                if (F0.isNull(i13)) {
                    c23 = i13;
                    i14 = i34;
                    i15 = c24;
                    q07 = null;
                } else {
                    i14 = i34;
                    q07 = F0.q0(i13);
                    c23 = i13;
                    i15 = c24;
                }
                int i35 = c12;
                int i36 = (int) F0.getLong(i15);
                int i37 = c25;
                if (F0.isNull(i37)) {
                    i16 = i15;
                    i17 = c26;
                    q08 = null;
                } else {
                    q08 = F0.q0(i37);
                    i16 = i15;
                    i17 = c26;
                }
                if (F0.isNull(i17)) {
                    c26 = i17;
                    i18 = c27;
                    q09 = null;
                } else {
                    q09 = F0.q0(i17);
                    c26 = i17;
                    i18 = c27;
                }
                c27 = i18;
                SubtitleDownloadTable subtitleDownloadTable = new SubtitleDownloadTable(q0, i19, q010, q011, q012, q013, valueOf2, valueOf3, valueOf, i20, q014, q015, q02, i22, i26, i30, q03, i33, q04, q05, q06, q07, i36, q08, q09, F0.isNull(i18) ? null : F0.q0(i18));
                ArrayList arrayList3 = arrayList;
                arrayList3.add(subtitleDownloadTable);
                c7 = i24;
                c9 = i28;
                c15 = i6;
                c16 = i23;
                c17 = i27;
                c2 = i8;
                c11 = i32;
                c19 = i10;
                c5 = i21;
                c4 = i4;
                c6 = i5;
                c8 = i25;
                c10 = i29;
                c18 = i7;
                c20 = i14;
                int i38 = i3;
                arrayList2 = arrayList3;
                c3 = i38;
                int i39 = i16;
                c25 = i37;
                c12 = i35;
                c24 = i39;
            }
            return arrayList2;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List s(String str, y3.b bVar) {
        ArrayList arrayList;
        String q0;
        int i;
        int i2;
        int i3;
        Integer valueOf;
        String q02;
        int i4;
        int i5;
        int i6;
        String q03;
        int i7;
        int i8;
        String q04;
        int i9;
        int i10;
        String q05;
        int i11;
        String q06;
        int i12;
        int i13;
        String q07;
        int i14;
        String q08;
        int i15;
        int i16;
        String q09;
        int i17;
        y3.e F0 = bVar.F0("SELECT * FROM st_download_table WHERE resourceId = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "id");
            int c3 = androidx.room.util.i.c(F0, "resourceStreamType");
            int c4 = androidx.room.util.i.c(F0, "resourceId");
            int c5 = androidx.room.util.i.c(F0, "lan");
            int c6 = androidx.room.util.i.c(F0, "lanName");
            int c7 = androidx.room.util.i.c(F0, WebConstants.FIELD_URL);
            int c8 = androidx.room.util.i.c(F0, "size");
            int c9 = androidx.room.util.i.c(F0, "delay");
            int c10 = androidx.room.util.i.c(F0, "downloads");
            int c11 = androidx.room.util.i.c(F0, "type");
            int c12 = androidx.room.util.i.c(F0, "postId");
            int c13 = androidx.room.util.i.c(F0, "subtitleName");
            int c14 = androidx.room.util.i.c(F0, "subjectId");
            int c15 = androidx.room.util.i.c(F0, "ep");
            int c16 = androidx.room.util.i.c(F0, "se");
            int c17 = androidx.room.util.i.c(F0, "resolution");
            int c18 = androidx.room.util.i.c(F0, "subjectName");
            int c19 = androidx.room.util.i.c(F0, "status");
            int c20 = androidx.room.util.i.c(F0, "fileCharsetName");
            int c21 = androidx.room.util.i.c(F0, "path");
            int c22 = androidx.room.util.i.c(F0, "zipPath");
            int c23 = androidx.room.util.i.c(F0, "taskId");
            int c24 = androidx.room.util.i.c(F0, "failCount");
            int c25 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c26 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c27 = androidx.room.util.i.c(F0, "ops");
            ArrayList arrayList2 = new ArrayList();
            while (F0.C0()) {
                if (F0.isNull(c2)) {
                    i = c15;
                    arrayList = arrayList2;
                    q0 = null;
                } else {
                    arrayList = arrayList2;
                    q0 = F0.q0(c2);
                    i = c15;
                }
                int i18 = (int) F0.getLong(c3);
                String q010 = F0.isNull(c4) ? null : F0.q0(c4);
                String q011 = F0.isNull(c5) ? null : F0.q0(c5);
                String q012 = F0.isNull(c6) ? null : F0.q0(c6);
                String q013 = F0.isNull(c7) ? null : F0.q0(c7);
                Long valueOf2 = F0.isNull(c8) ? null : Long.valueOf(F0.getLong(c8));
                Long valueOf3 = F0.isNull(c9) ? null : Long.valueOf(F0.getLong(c9));
                if (F0.isNull(c10)) {
                    i2 = c3;
                    i3 = c4;
                    valueOf = null;
                } else {
                    i2 = c3;
                    i3 = c4;
                    valueOf = Integer.valueOf((int) F0.getLong(c10));
                }
                int i19 = (int) F0.getLong(c11);
                String q014 = F0.isNull(c12) ? null : F0.q0(c12);
                String q015 = F0.isNull(c13) ? null : F0.q0(c13);
                if (F0.isNull(c14)) {
                    i4 = c6;
                    i5 = i;
                    q02 = null;
                } else {
                    q02 = F0.q0(c14);
                    i4 = c6;
                    i5 = i;
                }
                int i20 = c5;
                int i21 = (int) F0.getLong(i5);
                int i22 = c16;
                int i23 = c7;
                int i24 = c8;
                int i25 = (int) F0.getLong(i22);
                int i26 = c17;
                int i27 = c9;
                int i28 = c10;
                int i29 = (int) F0.getLong(i26);
                int i30 = c18;
                if (F0.isNull(i30)) {
                    i7 = c2;
                    i6 = i30;
                    i8 = c19;
                    q03 = null;
                } else {
                    i6 = i30;
                    q03 = F0.q0(i30);
                    i7 = c2;
                    i8 = c19;
                }
                int i31 = c11;
                int i32 = (int) F0.getLong(i8);
                int i33 = c20;
                if (F0.isNull(i33)) {
                    i9 = i8;
                    i10 = c21;
                    q04 = null;
                } else {
                    q04 = F0.q0(i33);
                    i9 = i8;
                    i10 = c21;
                }
                if (F0.isNull(i10)) {
                    c21 = i10;
                    i11 = c22;
                    q05 = null;
                } else {
                    q05 = F0.q0(i10);
                    c21 = i10;
                    i11 = c22;
                }
                if (F0.isNull(i11)) {
                    c22 = i11;
                    i12 = c23;
                    q06 = null;
                } else {
                    q06 = F0.q0(i11);
                    c22 = i11;
                    i12 = c23;
                }
                if (F0.isNull(i12)) {
                    c23 = i12;
                    i13 = i33;
                    i14 = c24;
                    q07 = null;
                } else {
                    i13 = i33;
                    q07 = F0.q0(i12);
                    c23 = i12;
                    i14 = c24;
                }
                int i34 = c12;
                int i35 = (int) F0.getLong(i14);
                int i36 = c25;
                if (F0.isNull(i36)) {
                    i15 = i14;
                    i16 = c26;
                    q08 = null;
                } else {
                    q08 = F0.q0(i36);
                    i15 = i14;
                    i16 = c26;
                }
                if (F0.isNull(i16)) {
                    c26 = i16;
                    i17 = c27;
                    q09 = null;
                } else {
                    q09 = F0.q0(i16);
                    c26 = i16;
                    i17 = c27;
                }
                c27 = i17;
                SubtitleDownloadTable subtitleDownloadTable = new SubtitleDownloadTable(q0, i18, q010, q011, q012, q013, valueOf2, valueOf3, valueOf, i19, q014, q015, q02, i21, i25, i29, q03, i32, q04, q05, q06, q07, i35, q08, q09, F0.isNull(i17) ? null : F0.q0(i17));
                ArrayList arrayList3 = arrayList;
                arrayList3.add(subtitleDownloadTable);
                c7 = i23;
                c9 = i27;
                c15 = i5;
                c16 = i22;
                c17 = i26;
                c2 = i7;
                c11 = i31;
                c19 = i9;
                c5 = i20;
                c4 = i3;
                c6 = i4;
                c8 = i24;
                c10 = i28;
                c18 = i6;
                c20 = i13;
                int i37 = i2;
                arrayList2 = arrayList3;
                c3 = i37;
                int i38 = i15;
                c25 = i36;
                c12 = i34;
                c24 = i38;
            }
            ArrayList arrayList4 = arrayList2;
            F0.close();
            return arrayList4;
        } catch (Throwable th) {
            F0.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SubtitleDownloadTable t(String str, int i, y3.b bVar) {
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
        String q06;
        int i8;
        String q07;
        int i9;
        String q08;
        int i10;
        y3.e F0 = bVar.F0("SELECT * FROM st_download_table WHERE id = ? AND resourceStreamType = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.c(2, i);
            int c2 = androidx.room.util.i.c(F0, "id");
            int c3 = androidx.room.util.i.c(F0, "resourceStreamType");
            int c4 = androidx.room.util.i.c(F0, "resourceId");
            int c5 = androidx.room.util.i.c(F0, "lan");
            int c6 = androidx.room.util.i.c(F0, "lanName");
            int c7 = androidx.room.util.i.c(F0, WebConstants.FIELD_URL);
            int c8 = androidx.room.util.i.c(F0, "size");
            int c9 = androidx.room.util.i.c(F0, "delay");
            int c10 = androidx.room.util.i.c(F0, "downloads");
            int c11 = androidx.room.util.i.c(F0, "type");
            int c12 = androidx.room.util.i.c(F0, "postId");
            int c13 = androidx.room.util.i.c(F0, "subtitleName");
            int c14 = androidx.room.util.i.c(F0, "subjectId");
            int c15 = androidx.room.util.i.c(F0, "ep");
            int c16 = androidx.room.util.i.c(F0, "se");
            int c17 = androidx.room.util.i.c(F0, "resolution");
            int c18 = androidx.room.util.i.c(F0, "subjectName");
            int c19 = androidx.room.util.i.c(F0, "status");
            int c20 = androidx.room.util.i.c(F0, "fileCharsetName");
            int c21 = androidx.room.util.i.c(F0, "path");
            int c22 = androidx.room.util.i.c(F0, "zipPath");
            int c23 = androidx.room.util.i.c(F0, "taskId");
            int c24 = androidx.room.util.i.c(F0, "failCount");
            int c25 = androidx.room.util.i.c(F0, "ugcVideoId");
            int c26 = androidx.room.util.i.c(F0, "ugcVideoCollectionId");
            int c27 = androidx.room.util.i.c(F0, "ops");
            SubtitleDownloadTable subtitleDownloadTable = null;
            if (F0.C0()) {
                if (F0.isNull(c2)) {
                    i2 = c15;
                    i3 = c27;
                    q0 = null;
                } else {
                    q0 = F0.q0(c2);
                    i2 = c15;
                    i3 = c27;
                }
                int i11 = (int) F0.getLong(c3);
                String q09 = F0.isNull(c4) ? null : F0.q0(c4);
                String q010 = F0.isNull(c5) ? null : F0.q0(c5);
                String q011 = F0.isNull(c6) ? null : F0.q0(c6);
                String q012 = F0.isNull(c7) ? null : F0.q0(c7);
                Long valueOf = F0.isNull(c8) ? null : Long.valueOf(F0.getLong(c8));
                Long valueOf2 = F0.isNull(c9) ? null : Long.valueOf(F0.getLong(c9));
                Integer valueOf3 = F0.isNull(c10) ? null : Integer.valueOf((int) F0.getLong(c10));
                int i12 = (int) F0.getLong(c11);
                String q013 = F0.isNull(c12) ? null : F0.q0(c12);
                String q014 = F0.isNull(c13) ? null : F0.q0(c13);
                String q015 = F0.isNull(c14) ? null : F0.q0(c14);
                int i13 = (int) F0.getLong(i2);
                int i14 = (int) F0.getLong(c16);
                int i15 = (int) F0.getLong(c17);
                if (F0.isNull(c18)) {
                    i4 = c19;
                    q02 = null;
                } else {
                    q02 = F0.q0(c18);
                    i4 = c19;
                }
                int i16 = (int) F0.getLong(i4);
                if (F0.isNull(c20)) {
                    i5 = c21;
                    q03 = null;
                } else {
                    q03 = F0.q0(c20);
                    i5 = c21;
                }
                if (F0.isNull(i5)) {
                    i6 = c22;
                    q04 = null;
                } else {
                    q04 = F0.q0(i5);
                    i6 = c22;
                }
                if (F0.isNull(i6)) {
                    i7 = c23;
                    q05 = null;
                } else {
                    q05 = F0.q0(i6);
                    i7 = c23;
                }
                if (F0.isNull(i7)) {
                    i8 = c24;
                    q06 = null;
                } else {
                    q06 = F0.q0(i7);
                    i8 = c24;
                }
                int i17 = (int) F0.getLong(i8);
                if (F0.isNull(c25)) {
                    i9 = c26;
                    q07 = null;
                } else {
                    q07 = F0.q0(c25);
                    i9 = c26;
                }
                if (F0.isNull(i9)) {
                    i10 = i3;
                    q08 = null;
                } else {
                    q08 = F0.q0(i9);
                    i10 = i3;
                }
                subtitleDownloadTable = new SubtitleDownloadTable(q0, i11, q09, q010, q011, q012, valueOf, valueOf2, valueOf3, i12, q013, q014, q015, i13, i14, i15, q02, i16, q03, q04, q05, q06, i17, q07, q08, F0.isNull(i10) ? null : F0.q0(i10));
            }
            F0.close();
            return subtitleDownloadTable;
        } catch (Throwable th) {
            F0.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit u(SubtitleDownloadTable subtitleDownloadTable, y3.b bVar) {
        this.b.d(bVar, subtitleDownloadTable);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object v(SubtitleDownloadTable subtitleDownloadTable, y3.b bVar) {
        this.d.c(bVar, subtitleDownloadTable);
        return null;
    }

    @Override // qt.a
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: qt.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List s;
                s = i.s(str, (y3.b) obj);
                return s;
            }
        }, continuation);
    }

    @Override // qt.a
    public Object b(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: qt.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q;
                q = i.q(str, (y3.b) obj);
                return q;
            }
        }, continuation);
    }

    @Override // qt.a
    public SubtitleDownloadTable c(final String str, final int i) {
        return (SubtitleDownloadTable) androidx.room.util.b.d(this.a, true, false, new Function1() { // from class: qt.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SubtitleDownloadTable t;
                t = i.t(str, i, (y3.b) obj);
                return t;
            }
        });
    }

    @Override // qt.a
    public Object d(final int i, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: qt.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List r;
                r = i.r(i, (y3.b) obj);
                return r;
            }
        }, continuation);
    }

    @Override // qt.a
    public Object e(final SubtitleDownloadTable subtitleDownloadTable, Continuation continuation) {
        subtitleDownloadTable.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: qt.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u;
                u = i.this.u(subtitleDownloadTable, (y3.b) obj);
                return u;
            }
        }, continuation);
    }

    @Override // qt.a
    public void f(final SubtitleDownloadTable subtitleDownloadTable) {
        subtitleDownloadTable.getClass();
        androidx.room.util.b.d(this.a, false, true, new Function1() { // from class: qt.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object v;
                v = i.this.v(subtitleDownloadTable, (y3.b) obj);
                return v;
            }
        });
    }

    @Override // qt.a
    public void g(final SubtitleDownloadTable subtitleDownloadTable) {
        subtitleDownloadTable.getClass();
        androidx.room.util.b.d(this.a, false, true, new Function1() { // from class: qt.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object p;
                p = i.this.p(subtitleDownloadTable, (y3.b) obj);
                return p;
            }
        });
    }
}
