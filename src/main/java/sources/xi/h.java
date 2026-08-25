package xi;

import androidx.room.RoomDatabase;
import androidx.room.util.i;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements xi.a {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `music_liked` (`subjectId`,`title`,`coverUrl`,`countryName`,`genre`,`releaseDate`,`durationSeconds`,`singerName`,`singerAvatar`,`path`,`timeStamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, MusicLikedDbBean musicLikedDbBean) {
            if (musicLikedDbBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, musicLikedDbBean.getSubjectId());
            }
            if (musicLikedDbBean.getTitle() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, musicLikedDbBean.getTitle());
            }
            if (musicLikedDbBean.getCoverUrl() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, musicLikedDbBean.getCoverUrl());
            }
            if (musicLikedDbBean.getCountryName() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, musicLikedDbBean.getCountryName());
            }
            if (musicLikedDbBean.getGenre() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, musicLikedDbBean.getGenre());
            }
            if (musicLikedDbBean.getReleaseDate() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, musicLikedDbBean.getReleaseDate());
            }
            eVar.c(7, musicLikedDbBean.getDurationSeconds());
            if (musicLikedDbBean.getSingerName() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, musicLikedDbBean.getSingerName());
            }
            if (musicLikedDbBean.getSingerAvatar() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, musicLikedDbBean.getSingerAvatar());
            }
            if (musicLikedDbBean.getPath() == null) {
                eVar.g(10);
            } else {
                eVar.i(10, musicLikedDbBean.getPath());
            }
            eVar.c(11, musicLikedDbBean.getTimeStamp());
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "UPDATE OR ABORT `music_liked` SET `subjectId` = ?,`title` = ?,`coverUrl` = ?,`countryName` = ?,`genre` = ?,`releaseDate` = ?,`durationSeconds` = ?,`singerName` = ?,`singerAvatar` = ?,`path` = ?,`timeStamp` = ? WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, MusicLikedDbBean musicLikedDbBean) {
            if (musicLikedDbBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, musicLikedDbBean.getSubjectId());
            }
            if (musicLikedDbBean.getTitle() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, musicLikedDbBean.getTitle());
            }
            if (musicLikedDbBean.getCoverUrl() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, musicLikedDbBean.getCoverUrl());
            }
            if (musicLikedDbBean.getCountryName() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, musicLikedDbBean.getCountryName());
            }
            if (musicLikedDbBean.getGenre() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, musicLikedDbBean.getGenre());
            }
            if (musicLikedDbBean.getReleaseDate() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, musicLikedDbBean.getReleaseDate());
            }
            eVar.c(7, musicLikedDbBean.getDurationSeconds());
            if (musicLikedDbBean.getSingerName() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, musicLikedDbBean.getSingerName());
            }
            if (musicLikedDbBean.getSingerAvatar() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, musicLikedDbBean.getSingerAvatar());
            }
            if (musicLikedDbBean.getPath() == null) {
                eVar.g(10);
            } else {
                eVar.i(10, musicLikedDbBean.getPath());
            }
            eVar.c(11, musicLikedDbBean.getTimeStamp());
            if (musicLikedDbBean.getSubjectId() == null) {
                eVar.g(12);
            } else {
                eVar.i(12, musicLikedDbBean.getSubjectId());
            }
        }
    }

    public h(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List m() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit n(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM music_liked WHERE subjectId = ?");
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
        y3.e F0 = bVar.F0("SELECT * FROM music_liked ORDER BY timeStamp DESC");
        try {
            int c = i.c(F0, "subjectId");
            int c2 = i.c(F0, "title");
            int c3 = i.c(F0, "coverUrl");
            int c4 = i.c(F0, "countryName");
            int c5 = i.c(F0, "genre");
            int c6 = i.c(F0, "releaseDate");
            int c7 = i.c(F0, "durationSeconds");
            int c8 = i.c(F0, "singerName");
            int c9 = i.c(F0, "singerAvatar");
            int c10 = i.c(F0, "path");
            int c11 = i.c(F0, "timeStamp");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                arrayList.add(new MusicLikedDbBean(F0.isNull(c) ? null : F0.q0(c), F0.isNull(c2) ? null : F0.q0(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), F0.isNull(c5) ? null : F0.q0(c5), F0.isNull(c6) ? null : F0.q0(c6), (int) F0.getLong(c7), F0.isNull(c8) ? null : F0.q0(c8), F0.isNull(c9) ? null : F0.q0(c9), F0.isNull(c10) ? null : F0.q0(c10), F0.getLong(c11)));
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer p(y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT COUNT(*) FROM music_liked");
        try {
            Integer num = null;
            if (F0.C0() && !F0.isNull(0)) {
                num = Integer.valueOf((int) F0.getLong(0));
            }
            return num;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MusicLikedDbBean q(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM music_liked WHERE subjectId = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = i.c(F0, "subjectId");
            int c2 = i.c(F0, "title");
            int c3 = i.c(F0, "coverUrl");
            int c4 = i.c(F0, "countryName");
            int c5 = i.c(F0, "genre");
            int c6 = i.c(F0, "releaseDate");
            int c7 = i.c(F0, "durationSeconds");
            int c8 = i.c(F0, "singerName");
            int c9 = i.c(F0, "singerAvatar");
            int c10 = i.c(F0, "path");
            int c11 = i.c(F0, "timeStamp");
            MusicLikedDbBean musicLikedDbBean = null;
            if (F0.C0()) {
                musicLikedDbBean = new MusicLikedDbBean(F0.isNull(c) ? null : F0.q0(c), F0.isNull(c2) ? null : F0.q0(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), F0.isNull(c5) ? null : F0.q0(c5), F0.isNull(c6) ? null : F0.q0(c6), (int) F0.getLong(c7), F0.isNull(c8) ? null : F0.q0(c8), F0.isNull(c9) ? null : F0.q0(c9), F0.isNull(c10) ? null : F0.q0(c10), F0.getLong(c11));
            }
            F0.close();
            return musicLikedDbBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit r(MusicLikedDbBean musicLikedDbBean, y3.b bVar) {
        this.b.d(bVar, musicLikedDbBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(List list, y3.b bVar) {
        this.b.c(bVar, list);
        return Unit.a;
    }

    @Override // xi.a
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: xi.d
            public final Object invoke(Object obj) {
                Integer p;
                p = h.p((y3.b) obj);
                return p;
            }
        }, continuation);
    }

    @Override // xi.a
    public Object b(final List list, Continuation continuation) {
        list.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: xi.f
            public final Object invoke(Object obj) {
                Unit s;
                s = h.this.s(list, (y3.b) obj);
                return s;
            }
        }, continuation);
    }

    @Override // xi.a
    public Object c(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: xi.c
            public final Object invoke(Object obj) {
                List o;
                o = h.o((y3.b) obj);
                return o;
            }
        }, continuation);
    }

    @Override // xi.a
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: xi.g
            public final Object invoke(Object obj) {
                Unit n;
                n = h.n(str, (y3.b) obj);
                return n;
            }
        }, continuation);
    }

    @Override // xi.a
    public Object e(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: xi.b
            public final Object invoke(Object obj) {
                MusicLikedDbBean q;
                q = h.q(str, (y3.b) obj);
                return q;
            }
        }, continuation);
    }

    @Override // xi.a
    public Object f(final MusicLikedDbBean musicLikedDbBean, Continuation continuation) {
        musicLikedDbBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: xi.e
            public final Object invoke(Object obj) {
                Unit r;
                r = h.this.r(musicLikedDbBean, (y3.b) obj);
                return r;
            }
        }, continuation);
    }
}
