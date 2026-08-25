package ui;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.download.SubtitleBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c1 implements v0 {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `download_subtitle_table` (`resourceId`,`postId`,`url`,`path`,`lan`,`lanName`,`subtitleName`,`size`,`delayDuration`,`status`,`type`,`fileCharsetName`,`subjectId`,`ep`,`se`,`resolution`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, SubtitleBean subtitleBean) {
            if (subtitleBean.getResourceId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, subtitleBean.getResourceId());
            }
            if (subtitleBean.getPostId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, subtitleBean.getPostId());
            }
            if (subtitleBean.getUrl() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, subtitleBean.getUrl());
            }
            if (subtitleBean.getPath() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, subtitleBean.getPath());
            }
            if (subtitleBean.getLan() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, subtitleBean.getLan());
            }
            if (subtitleBean.getLanName() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, subtitleBean.getLanName());
            }
            if (subtitleBean.getSubtitleName() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, subtitleBean.getSubtitleName());
            }
            if (subtitleBean.getSize() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, subtitleBean.getSize().longValue());
            }
            if (subtitleBean.getDelayDuration() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, subtitleBean.getDelayDuration().longValue());
            }
            eVar.c(10, subtitleBean.getStatus());
            eVar.c(11, subtitleBean.getType());
            if (subtitleBean.getFileCharsetName() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, subtitleBean.getFileCharsetName());
            }
            if (subtitleBean.getSubjectId() == null) {
                eVar.g(13);
            } else {
                eVar.i(13, subtitleBean.getSubjectId());
            }
            eVar.c(14, subtitleBean.getEp());
            eVar.c(15, subtitleBean.getSe());
            eVar.c(16, subtitleBean.getResolution());
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "UPDATE OR ABORT `download_subtitle_table` SET `resourceId` = ?,`postId` = ?,`url` = ?,`path` = ?,`lan` = ?,`lanName` = ?,`subtitleName` = ?,`size` = ?,`delayDuration` = ?,`status` = ?,`type` = ?,`fileCharsetName` = ?,`subjectId` = ?,`ep` = ?,`se` = ?,`resolution` = ? WHERE `resourceId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, SubtitleBean subtitleBean) {
            if (subtitleBean.getResourceId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, subtitleBean.getResourceId());
            }
            if (subtitleBean.getPostId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, subtitleBean.getPostId());
            }
            if (subtitleBean.getUrl() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, subtitleBean.getUrl());
            }
            if (subtitleBean.getPath() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, subtitleBean.getPath());
            }
            if (subtitleBean.getLan() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, subtitleBean.getLan());
            }
            if (subtitleBean.getLanName() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, subtitleBean.getLanName());
            }
            if (subtitleBean.getSubtitleName() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, subtitleBean.getSubtitleName());
            }
            if (subtitleBean.getSize() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, subtitleBean.getSize().longValue());
            }
            if (subtitleBean.getDelayDuration() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, subtitleBean.getDelayDuration().longValue());
            }
            eVar.c(10, subtitleBean.getStatus());
            eVar.c(11, subtitleBean.getType());
            if (subtitleBean.getFileCharsetName() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, subtitleBean.getFileCharsetName());
            }
            if (subtitleBean.getSubjectId() == null) {
                eVar.g(13);
            } else {
                eVar.i(13, subtitleBean.getSubjectId());
            }
            eVar.c(14, subtitleBean.getEp());
            eVar.c(15, subtitleBean.getSe());
            eVar.c(16, subtitleBean.getResolution());
            if (subtitleBean.getResourceId() == null) {
                eVar.g(17);
            } else {
                eVar.i(17, subtitleBean.getResourceId());
            }
        }
    }

    public c1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List m() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit n(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM DOWNLOAD_SUBTITLE_TABLE WHERE postId=?");
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
    public static /* synthetic */ List o(y3.b bVar) {
        int i;
        Long valueOf;
        int i2;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE");
        try {
            int c = androidx.room.util.i.c(F0, "resourceId");
            int c2 = androidx.room.util.i.c(F0, "postId");
            int c3 = androidx.room.util.i.c(F0, "url");
            int c4 = androidx.room.util.i.c(F0, "path");
            int c5 = androidx.room.util.i.c(F0, "lan");
            int c6 = androidx.room.util.i.c(F0, "lanName");
            int c7 = androidx.room.util.i.c(F0, "subtitleName");
            int c8 = androidx.room.util.i.c(F0, "size");
            int c9 = androidx.room.util.i.c(F0, "delayDuration");
            int c10 = androidx.room.util.i.c(F0, "status");
            int c11 = androidx.room.util.i.c(F0, "type");
            int c12 = androidx.room.util.i.c(F0, "fileCharsetName");
            int c13 = androidx.room.util.i.c(F0, "subjectId");
            int c14 = androidx.room.util.i.c(F0, "ep");
            int c15 = androidx.room.util.i.c(F0, "se");
            int c16 = androidx.room.util.i.c(F0, "resolution");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q0 = F0.isNull(c) ? null : F0.q0(c);
                String q02 = F0.isNull(c2) ? null : F0.q0(c2);
                String q03 = F0.isNull(c3) ? null : F0.q0(c3);
                String q04 = F0.isNull(c4) ? null : F0.q0(c4);
                String q05 = F0.isNull(c5) ? null : F0.q0(c5);
                String q06 = F0.isNull(c6) ? null : F0.q0(c6);
                String q07 = F0.isNull(c7) ? null : F0.q0(c7);
                Long valueOf2 = F0.isNull(c8) ? null : Long.valueOf(F0.getLong(c8));
                if (F0.isNull(c9)) {
                    i2 = c2;
                    i = c3;
                    valueOf = null;
                } else {
                    i = c3;
                    valueOf = Long.valueOf(F0.getLong(c9));
                    i2 = c2;
                }
                int i3 = c4;
                int i4 = c5;
                int i5 = c15;
                int i6 = c6;
                int i7 = c7;
                int i8 = c9;
                int i9 = c16;
                int i10 = c8;
                arrayList.add(new SubtitleBean(q0, q02, q03, q04, q05, q06, q07, valueOf2, valueOf, (int) F0.getLong(c10), (int) F0.getLong(c11), F0.isNull(c12) ? null : F0.q0(c12), F0.isNull(c13) ? null : F0.q0(c13), (int) F0.getLong(c14), (int) F0.getLong(i5), (int) F0.getLong(i9)));
                c6 = i6;
                c15 = i5;
                c8 = i10;
                c2 = i2;
                c5 = i4;
                c3 = i;
                c4 = i3;
                c9 = i8;
                c16 = i9;
                c7 = i7;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List p(String str, y3.b bVar) {
        int i;
        Long valueOf;
        int i2;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE WHERE postId = ? ");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = androidx.room.util.i.c(F0, "resourceId");
            int c2 = androidx.room.util.i.c(F0, "postId");
            int c3 = androidx.room.util.i.c(F0, "url");
            int c4 = androidx.room.util.i.c(F0, "path");
            int c5 = androidx.room.util.i.c(F0, "lan");
            int c6 = androidx.room.util.i.c(F0, "lanName");
            int c7 = androidx.room.util.i.c(F0, "subtitleName");
            int c8 = androidx.room.util.i.c(F0, "size");
            int c9 = androidx.room.util.i.c(F0, "delayDuration");
            int c10 = androidx.room.util.i.c(F0, "status");
            int c11 = androidx.room.util.i.c(F0, "type");
            int c12 = androidx.room.util.i.c(F0, "fileCharsetName");
            int c13 = androidx.room.util.i.c(F0, "subjectId");
            int c14 = androidx.room.util.i.c(F0, "ep");
            int c15 = androidx.room.util.i.c(F0, "se");
            int c16 = androidx.room.util.i.c(F0, "resolution");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q0 = F0.isNull(c) ? null : F0.q0(c);
                String q02 = F0.isNull(c2) ? null : F0.q0(c2);
                String q03 = F0.isNull(c3) ? null : F0.q0(c3);
                String q04 = F0.isNull(c4) ? null : F0.q0(c4);
                String q05 = F0.isNull(c5) ? null : F0.q0(c5);
                String q06 = F0.isNull(c6) ? null : F0.q0(c6);
                String q07 = F0.isNull(c7) ? null : F0.q0(c7);
                Long valueOf2 = F0.isNull(c8) ? null : Long.valueOf(F0.getLong(c8));
                if (F0.isNull(c9)) {
                    i2 = c2;
                    i = c3;
                    valueOf = null;
                } else {
                    i = c3;
                    valueOf = Long.valueOf(F0.getLong(c9));
                    i2 = c2;
                }
                int i3 = c4;
                int i4 = c5;
                int i5 = c15;
                int i6 = c6;
                int i7 = c7;
                int i8 = c16;
                int i9 = c8;
                int i10 = c9;
                arrayList.add(new SubtitleBean(q0, q02, q03, q04, q05, q06, q07, valueOf2, valueOf, (int) F0.getLong(c10), (int) F0.getLong(c11), F0.isNull(c12) ? null : F0.q0(c12), F0.isNull(c13) ? null : F0.q0(c13), (int) F0.getLong(c14), (int) F0.getLong(i5), (int) F0.getLong(i8)));
                c6 = i6;
                c8 = i9;
                c15 = i5;
                c16 = i8;
                c2 = i2;
                c5 = i4;
                c3 = i;
                c4 = i3;
                c7 = i7;
                c9 = i10;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List q(String str, y3.b bVar) {
        int i;
        Long valueOf;
        int i2;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE WHERE subjectId = ? ");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = androidx.room.util.i.c(F0, "resourceId");
            int c2 = androidx.room.util.i.c(F0, "postId");
            int c3 = androidx.room.util.i.c(F0, "url");
            int c4 = androidx.room.util.i.c(F0, "path");
            int c5 = androidx.room.util.i.c(F0, "lan");
            int c6 = androidx.room.util.i.c(F0, "lanName");
            int c7 = androidx.room.util.i.c(F0, "subtitleName");
            int c8 = androidx.room.util.i.c(F0, "size");
            int c9 = androidx.room.util.i.c(F0, "delayDuration");
            int c10 = androidx.room.util.i.c(F0, "status");
            int c11 = androidx.room.util.i.c(F0, "type");
            int c12 = androidx.room.util.i.c(F0, "fileCharsetName");
            int c13 = androidx.room.util.i.c(F0, "subjectId");
            int c14 = androidx.room.util.i.c(F0, "ep");
            int c15 = androidx.room.util.i.c(F0, "se");
            int c16 = androidx.room.util.i.c(F0, "resolution");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q0 = F0.isNull(c) ? null : F0.q0(c);
                String q02 = F0.isNull(c2) ? null : F0.q0(c2);
                String q03 = F0.isNull(c3) ? null : F0.q0(c3);
                String q04 = F0.isNull(c4) ? null : F0.q0(c4);
                String q05 = F0.isNull(c5) ? null : F0.q0(c5);
                String q06 = F0.isNull(c6) ? null : F0.q0(c6);
                String q07 = F0.isNull(c7) ? null : F0.q0(c7);
                Long valueOf2 = F0.isNull(c8) ? null : Long.valueOf(F0.getLong(c8));
                if (F0.isNull(c9)) {
                    i2 = c2;
                    i = c3;
                    valueOf = null;
                } else {
                    i = c3;
                    valueOf = Long.valueOf(F0.getLong(c9));
                    i2 = c2;
                }
                int i3 = c4;
                int i4 = c5;
                int i5 = c15;
                int i6 = c6;
                int i7 = c7;
                int i8 = c16;
                int i9 = c8;
                int i10 = c9;
                arrayList.add(new SubtitleBean(q0, q02, q03, q04, q05, q06, q07, valueOf2, valueOf, (int) F0.getLong(c10), (int) F0.getLong(c11), F0.isNull(c12) ? null : F0.q0(c12), F0.isNull(c13) ? null : F0.q0(c13), (int) F0.getLong(c14), (int) F0.getLong(i5), (int) F0.getLong(i8)));
                c6 = i6;
                c8 = i9;
                c15 = i5;
                c16 = i8;
                c2 = i2;
                c5 = i4;
                c3 = i;
                c4 = i3;
                c7 = i7;
                c9 = i10;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List r(String str, int i, int i2, y3.b bVar) {
        int i3;
        int i4;
        Long valueOf;
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_SUBTITLE_TABLE WHERE subjectId = ? AND ep = ? AND se = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            F0.c(2, i);
            F0.c(3, i2);
            int c = androidx.room.util.i.c(F0, "resourceId");
            int c2 = androidx.room.util.i.c(F0, "postId");
            int c3 = androidx.room.util.i.c(F0, "url");
            int c4 = androidx.room.util.i.c(F0, "path");
            int c5 = androidx.room.util.i.c(F0, "lan");
            int c6 = androidx.room.util.i.c(F0, "lanName");
            int c7 = androidx.room.util.i.c(F0, "subtitleName");
            int c8 = androidx.room.util.i.c(F0, "size");
            int c9 = androidx.room.util.i.c(F0, "delayDuration");
            int c10 = androidx.room.util.i.c(F0, "status");
            int c11 = androidx.room.util.i.c(F0, "type");
            int c12 = androidx.room.util.i.c(F0, "fileCharsetName");
            int c13 = androidx.room.util.i.c(F0, "subjectId");
            int c14 = androidx.room.util.i.c(F0, "ep");
            int c15 = androidx.room.util.i.c(F0, "se");
            int c16 = androidx.room.util.i.c(F0, "resolution");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q0 = F0.isNull(c) ? null : F0.q0(c);
                String q02 = F0.isNull(c2) ? null : F0.q0(c2);
                String q03 = F0.isNull(c3) ? null : F0.q0(c3);
                String q04 = F0.isNull(c4) ? null : F0.q0(c4);
                String q05 = F0.isNull(c5) ? null : F0.q0(c5);
                String q06 = F0.isNull(c6) ? null : F0.q0(c6);
                String q07 = F0.isNull(c7) ? null : F0.q0(c7);
                Long valueOf2 = F0.isNull(c8) ? null : Long.valueOf(F0.getLong(c8));
                if (F0.isNull(c9)) {
                    i3 = c2;
                    i4 = c3;
                    valueOf = null;
                } else {
                    i3 = c2;
                    i4 = c3;
                    valueOf = Long.valueOf(F0.getLong(c9));
                }
                int i5 = c4;
                int i6 = c5;
                int i7 = c15;
                int i8 = c6;
                int i9 = c7;
                int i10 = c16;
                int i11 = c8;
                int i12 = c9;
                arrayList.add(new SubtitleBean(q0, q02, q03, q04, q05, q06, q07, valueOf2, valueOf, (int) F0.getLong(c10), (int) F0.getLong(c11), F0.isNull(c12) ? null : F0.q0(c12), F0.isNull(c13) ? null : F0.q0(c13), (int) F0.getLong(c14), (int) F0.getLong(i7), (int) F0.getLong(i10)));
                c6 = i8;
                c8 = i11;
                c2 = i3;
                c3 = i4;
                c15 = i7;
                c16 = i10;
                c4 = i5;
                c5 = i6;
                c7 = i9;
                c9 = i12;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(SubtitleBean subtitleBean, y3.b bVar) {
        this.c.c(bVar, subtitleBean);
        return Unit.a;
    }

    @Override // ui.v0
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.b1
            public final Object invoke(Object obj) {
                Unit n;
                n = c1.n(str, (y3.b) obj);
                return n;
            }
        }, continuation);
    }

    @Override // ui.v0
    public Object b(final SubtitleBean subtitleBean, Continuation continuation) {
        subtitleBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.z0
            public final Object invoke(Object obj) {
                Unit s;
                s = c1.this.s(subtitleBean, (y3.b) obj);
                return s;
            }
        }, continuation);
    }

    @Override // ui.v0
    public Object c(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.a1
            public final Object invoke(Object obj) {
                List o;
                o = c1.o((y3.b) obj);
                return o;
            }
        }, continuation);
    }

    @Override // ui.v0
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.y0
            public final Object invoke(Object obj) {
                List q;
                q = c1.q(str, (y3.b) obj);
                return q;
            }
        }, continuation);
    }

    @Override // ui.v0
    public Object e(final String str, final int i, final int i2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.w0
            public final Object invoke(Object obj) {
                List r;
                r = c1.r(str, i, i2, (y3.b) obj);
                return r;
            }
        }, continuation);
    }

    @Override // ui.v0
    public Object f(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.x0
            public final Object invoke(Object obj) {
                List p;
                p = c1.p(str, (y3.b) obj);
                return p;
            }
        }, continuation);
    }
}
