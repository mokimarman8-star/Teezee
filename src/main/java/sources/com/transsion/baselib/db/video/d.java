package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements IShortTvFavoriteStateDao {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `ShortTvFavoriteState` (`subjectId`,`favoriteNum`,`hasFavorite`,`favoriteTime`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, ShortTvFavoriteState shortTvFavoriteState) {
            if (shortTvFavoriteState.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, shortTvFavoriteState.getSubjectId());
            }
            if (shortTvFavoriteState.getFavoriteNum() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, shortTvFavoriteState.getFavoriteNum());
            }
            eVar.c(3, shortTvFavoriteState.getHasFavorite() ? 1L : 0L);
            if (shortTvFavoriteState.getFavoriteTime() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, shortTvFavoriteState.getFavoriteTime());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "UPDATE OR ABORT `ShortTvFavoriteState` SET `subjectId` = ?,`favoriteNum` = ?,`hasFavorite` = ?,`favoriteTime` = ? WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, ShortTvFavoriteState shortTvFavoriteState) {
            if (shortTvFavoriteState.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, shortTvFavoriteState.getSubjectId());
            }
            if (shortTvFavoriteState.getFavoriteNum() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, shortTvFavoriteState.getFavoriteNum());
            }
            eVar.c(3, shortTvFavoriteState.getHasFavorite() ? 1L : 0L);
            if (shortTvFavoriteState.getFavoriteTime() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, shortTvFavoriteState.getFavoriteTime());
            }
            if (shortTvFavoriteState.getSubjectId() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, shortTvFavoriteState.getSubjectId());
            }
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List h() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(ShortTvFavoriteState shortTvFavoriteState, y3.b bVar) {
        this.b.d(bVar, shortTvFavoriteState);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ShortTvFavoriteState j(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM ShortTvFavoriteState WHERE subjectId=?");
        boolean z = true;
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = androidx.room.util.i.c(F0, "subjectId");
            int c2 = androidx.room.util.i.c(F0, "favoriteNum");
            int c3 = androidx.room.util.i.c(F0, "hasFavorite");
            int c4 = androidx.room.util.i.c(F0, "favoriteTime");
            ShortTvFavoriteState shortTvFavoriteState = null;
            String q0 = null;
            if (F0.C0()) {
                ShortTvFavoriteState shortTvFavoriteState2 = new ShortTvFavoriteState();
                shortTvFavoriteState2.setSubjectId(F0.isNull(c) ? null : F0.q0(c));
                shortTvFavoriteState2.setFavoriteNum(F0.isNull(c2) ? null : F0.q0(c2));
                if (((int) F0.getLong(c3)) == 0) {
                    z = false;
                }
                shortTvFavoriteState2.setHasFavorite(z);
                if (!F0.isNull(c4)) {
                    q0 = F0.q0(c4);
                }
                shortTvFavoriteState2.setFavoriteTime(q0);
                shortTvFavoriteState = shortTvFavoriteState2;
            }
            F0.close();
            return shortTvFavoriteState;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(ShortTvFavoriteState shortTvFavoriteState, y3.b bVar) {
        this.c.c(bVar, shortTvFavoriteState);
        return Unit.a;
    }

    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.b
            public final Object invoke(Object obj) {
                ShortTvFavoriteState j;
                j = d.j(str, (y3.b) obj);
                return j;
            }
        }, continuation);
    }

    public Object b(final ShortTvFavoriteState shortTvFavoriteState, Continuation continuation) {
        shortTvFavoriteState.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.a
            public final Object invoke(Object obj) {
                Unit k;
                k = d.this.k(shortTvFavoriteState, (y3.b) obj);
                return k;
            }
        }, continuation);
    }

    public Object c(final ShortTvFavoriteState shortTvFavoriteState, Continuation continuation) {
        shortTvFavoriteState.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.c
            public final Object invoke(Object obj) {
                Unit i;
                i = d.this.i(shortTvFavoriteState, (y3.b) obj);
                return i;
            }
        }, continuation);
    }

    public Object d(ShortTvFavoriteState shortTvFavoriteState, Continuation continuation) {
        return IShortTvFavoriteStateDao$DefaultImpls.a(this, shortTvFavoriteState, continuation);
    }
}
