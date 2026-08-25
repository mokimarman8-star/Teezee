package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m implements ShortTVPlayDao {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();
    private final androidx.room.e d = new c();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `short_tv_play` (`subjectId`,`id`,`ep`,`se`,`totalEp`,`progress`,`title`,`description`,`coverUrl`,`thumbnail`,`videoId`,`videoUrl`,`timeStamp`,`subtitleSelectId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, ShortTVPlayBean shortTVPlayBean) {
            if (shortTVPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, shortTVPlayBean.getSubjectId());
            }
            if (shortTVPlayBean.getId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, shortTVPlayBean.getId());
            }
            eVar.c(3, shortTVPlayBean.getEp());
            eVar.c(4, shortTVPlayBean.getSe());
            eVar.c(5, shortTVPlayBean.getTotalEp());
            eVar.c(6, shortTVPlayBean.getProgress());
            if (shortTVPlayBean.getTitle() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, shortTVPlayBean.getTitle());
            }
            if (shortTVPlayBean.getDescription() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, shortTVPlayBean.getDescription());
            }
            if (shortTVPlayBean.getCoverUrl() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, shortTVPlayBean.getCoverUrl());
            }
            if (shortTVPlayBean.getThumbnail() == null) {
                eVar.g(10);
            } else {
                eVar.i(10, shortTVPlayBean.getThumbnail());
            }
            if (shortTVPlayBean.getVideoId() == null) {
                eVar.g(11);
            } else {
                eVar.i(11, shortTVPlayBean.getVideoId());
            }
            if (shortTVPlayBean.getVideoUrl() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, shortTVPlayBean.getVideoUrl());
            }
            eVar.c(13, shortTVPlayBean.getTimeStamp());
            if (shortTVPlayBean.getSubtitleSelectId() == null) {
                eVar.g(14);
            } else {
                eVar.i(14, shortTVPlayBean.getSubtitleSelectId());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `short_tv_play` WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, ShortTVPlayBean shortTVPlayBean) {
            if (shortTVPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, shortTVPlayBean.getSubjectId());
            }
        }
    }

    class c extends androidx.room.e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `short_tv_play` SET `subjectId` = ?,`id` = ?,`ep` = ?,`se` = ?,`totalEp` = ?,`progress` = ?,`title` = ?,`description` = ?,`coverUrl` = ?,`thumbnail` = ?,`videoId` = ?,`videoUrl` = ?,`timeStamp` = ?,`subtitleSelectId` = ? WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, ShortTVPlayBean shortTVPlayBean) {
            if (shortTVPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, shortTVPlayBean.getSubjectId());
            }
            if (shortTVPlayBean.getId() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, shortTVPlayBean.getId());
            }
            eVar.c(3, shortTVPlayBean.getEp());
            eVar.c(4, shortTVPlayBean.getSe());
            eVar.c(5, shortTVPlayBean.getTotalEp());
            eVar.c(6, shortTVPlayBean.getProgress());
            if (shortTVPlayBean.getTitle() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, shortTVPlayBean.getTitle());
            }
            if (shortTVPlayBean.getDescription() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, shortTVPlayBean.getDescription());
            }
            if (shortTVPlayBean.getCoverUrl() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, shortTVPlayBean.getCoverUrl());
            }
            if (shortTVPlayBean.getThumbnail() == null) {
                eVar.g(10);
            } else {
                eVar.i(10, shortTVPlayBean.getThumbnail());
            }
            if (shortTVPlayBean.getVideoId() == null) {
                eVar.g(11);
            } else {
                eVar.i(11, shortTVPlayBean.getVideoId());
            }
            if (shortTVPlayBean.getVideoUrl() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, shortTVPlayBean.getVideoUrl());
            }
            eVar.c(13, shortTVPlayBean.getTimeStamp());
            if (shortTVPlayBean.getSubtitleSelectId() == null) {
                eVar.g(14);
            } else {
                eVar.i(14, shortTVPlayBean.getSubtitleSelectId());
            }
            if (shortTVPlayBean.getSubjectId() == null) {
                eVar.g(15);
            } else {
                eVar.i(15, shortTVPlayBean.getSubjectId());
            }
        }
    }

    public m(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List r() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(ShortTVPlayBean shortTVPlayBean, y3.b bVar) {
        this.c.c(bVar, shortTVPlayBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit t(y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM SHORT_TV_PLAY");
        try {
            F0.C0();
            return Unit.a;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ShortTVPlayBean u(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM SHORT_TV_PLAY WHERE subjectId = ?");
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
            int c6 = androidx.room.util.i.c(F0, "totalEp");
            int c7 = androidx.room.util.i.c(F0, "progress");
            int c8 = androidx.room.util.i.c(F0, "title");
            int c9 = androidx.room.util.i.c(F0, "description");
            int c10 = androidx.room.util.i.c(F0, "coverUrl");
            int c11 = androidx.room.util.i.c(F0, "thumbnail");
            int c12 = androidx.room.util.i.c(F0, "videoId");
            int c13 = androidx.room.util.i.c(F0, "videoUrl");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            ShortTVPlayBean shortTVPlayBean = null;
            if (F0.C0()) {
                shortTVPlayBean = new ShortTVPlayBean(F0.isNull(c2) ? null : F0.q0(c2), F0.isNull(c3) ? null : F0.q0(c3), (int) F0.getLong(c4), (int) F0.getLong(c5), (int) F0.getLong(c6), F0.getLong(c7), F0.isNull(c8) ? null : F0.q0(c8), F0.isNull(c9) ? null : F0.q0(c9), F0.isNull(c10) ? null : F0.q0(c10), F0.isNull(c11) ? null : F0.q0(c11), F0.isNull(c12) ? null : F0.q0(c12), F0.isNull(c13) ? null : F0.q0(c13), F0.getLong(c14), F0.isNull(c15) ? null : F0.q0(c15));
            }
            F0.close();
            return shortTVPlayBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List v(int i, int i2, y3.b bVar) {
        int i3;
        ArrayList arrayList;
        String q0;
        y3.e F0 = bVar.F0("SELECT * FROM SHORT_TV_PLAY WHERE coverUrl IS NOT NULL AND rowid IN (SELECT rowid FROM (SELECT rowid, subjectId, MAX(timeStamp) as maxTimeStamp FROM SHORT_TV_PLAY WHERE coverUrl IS NOT NULL GROUP BY subjectId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?;");
        try {
            F0.c(1, i);
            F0.c(2, i2);
            int c2 = androidx.room.util.i.c(F0, "subjectId");
            int c3 = androidx.room.util.i.c(F0, "id");
            int c4 = androidx.room.util.i.c(F0, "ep");
            int c5 = androidx.room.util.i.c(F0, "se");
            int c6 = androidx.room.util.i.c(F0, "totalEp");
            int c7 = androidx.room.util.i.c(F0, "progress");
            int c8 = androidx.room.util.i.c(F0, "title");
            int c9 = androidx.room.util.i.c(F0, "description");
            int c10 = androidx.room.util.i.c(F0, "coverUrl");
            int c11 = androidx.room.util.i.c(F0, "thumbnail");
            int c12 = androidx.room.util.i.c(F0, "videoId");
            int c13 = androidx.room.util.i.c(F0, "videoUrl");
            int c14 = androidx.room.util.i.c(F0, "timeStamp");
            int c15 = androidx.room.util.i.c(F0, "subtitleSelectId");
            ArrayList arrayList2 = new ArrayList();
            while (F0.C0()) {
                String q02 = F0.isNull(c2) ? null : F0.q0(c2);
                if (F0.isNull(c3)) {
                    i3 = c15;
                    arrayList = arrayList2;
                    q0 = null;
                } else {
                    i3 = c15;
                    arrayList = arrayList2;
                    q0 = F0.q0(c3);
                }
                int i4 = (int) F0.getLong(c4);
                int i5 = c3;
                int i6 = c4;
                int i7 = (int) F0.getLong(c5);
                int i8 = c5;
                int i9 = i3;
                int i10 = c2;
                ShortTVPlayBean shortTVPlayBean = new ShortTVPlayBean(q02, q0, i4, i7, (int) F0.getLong(c6), F0.getLong(c7), F0.isNull(c8) ? null : F0.q0(c8), F0.isNull(c9) ? null : F0.q0(c9), F0.isNull(c10) ? null : F0.q0(c10), F0.isNull(c11) ? null : F0.q0(c11), F0.isNull(c12) ? null : F0.q0(c12), F0.isNull(c13) ? null : F0.q0(c13), F0.getLong(c14), F0.isNull(i9) ? null : F0.q0(i9));
                ArrayList arrayList3 = arrayList;
                arrayList3.add(shortTVPlayBean);
                c2 = i10;
                c15 = i9;
                c4 = i6;
                c5 = i8;
                arrayList2 = arrayList3;
                c3 = i5;
            }
            return arrayList2;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit w(ShortTVPlayBean shortTVPlayBean, y3.b bVar) {
        this.b.d(bVar, shortTVPlayBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit x(long j, int i, String str, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE SHORT_TV_PLAY SET progress = ?, ep = ? WHERE subjectId = ?");
        try {
            F0.c(1, j);
            F0.c(2, i);
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit y(ShortTVPlayBean shortTVPlayBean, y3.b bVar) {
        this.d.c(bVar, shortTVPlayBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit z(String str, String str2, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE SHORT_TV_PLAY SET subtitleSelectId = ? WHERE subjectId = ? ");
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
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.j
            public final Object invoke(Object obj) {
                Unit t;
                t = m.t((y3.b) obj);
                return t;
            }
        }, continuation);
    }

    public Object b(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.k
            public final Object invoke(Object obj) {
                Unit z;
                z = m.z(str2, str, (y3.b) obj);
                return z;
            }
        }, continuation);
    }

    public Object d(final int i, final int i2, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.e
            public final Object invoke(Object obj) {
                List v;
                v = m.v(i2, i, (y3.b) obj);
                return v;
            }
        }, continuation);
    }

    public Object e(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.g
            public final Object invoke(Object obj) {
                ShortTVPlayBean u;
                u = m.u(str, (y3.b) obj);
                return u;
            }
        }, continuation);
    }

    public Object f(final ShortTVPlayBean shortTVPlayBean, Continuation continuation) {
        shortTVPlayBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.f
            public final Object invoke(Object obj) {
                Unit w;
                w = m.this.w(shortTVPlayBean, (y3.b) obj);
                return w;
            }
        }, continuation);
    }

    public Object g(ShortTVPlayBean shortTVPlayBean, Continuation continuation) {
        return ShortTVPlayDao$DefaultImpls.a(this, shortTVPlayBean, continuation);
    }

    public Object h(final String str, final int i, final long j, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.l
            public final Object invoke(Object obj) {
                Unit x;
                x = m.x(j, i, str, (y3.b) obj);
                return x;
            }
        }, continuation);
    }

    public Object i(final ShortTVPlayBean shortTVPlayBean, Continuation continuation) {
        shortTVPlayBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.h
            public final Object invoke(Object obj) {
                Unit y;
                y = m.this.y(shortTVPlayBean, (y3.b) obj);
                return y;
            }
        }, continuation);
    }

    public Object j(final ShortTVPlayBean shortTVPlayBean, Continuation continuation) {
        shortTVPlayBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.i
            public final Object invoke(Object obj) {
                Unit s;
                s = m.this.s(shortTVPlayBean, (y3.b) obj);
                return s;
            }
        }, continuation);
    }
}
