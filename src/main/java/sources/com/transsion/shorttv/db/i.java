package com.transsion.shorttv.db;

import androidx.room.RoomDatabase;
import com.transsion.shorttv.db.ShortTvFavoriteDao;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements ShortTvFavoriteDao {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `short_tv_favorite_state` (`subjectId`,`favoriteNum`,`hasFavorite`,`favoriteTime`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, ShortTvFavoriteStateBean shortTvFavoriteStateBean) {
            if (shortTvFavoriteStateBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, shortTvFavoriteStateBean.getSubjectId());
            }
            if (shortTvFavoriteStateBean.getFavoriteNum() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, shortTvFavoriteStateBean.getFavoriteNum());
            }
            eVar.c(3, shortTvFavoriteStateBean.getHasFavorite() ? 1L : 0L);
            if (shortTvFavoriteStateBean.getFavoriteTime() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, shortTvFavoriteStateBean.getFavoriteTime());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "UPDATE OR ABORT `short_tv_favorite_state` SET `subjectId` = ?,`favoriteNum` = ?,`hasFavorite` = ?,`favoriteTime` = ? WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, ShortTvFavoriteStateBean shortTvFavoriteStateBean) {
            if (shortTvFavoriteStateBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, shortTvFavoriteStateBean.getSubjectId());
            }
            if (shortTvFavoriteStateBean.getFavoriteNum() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, shortTvFavoriteStateBean.getFavoriteNum());
            }
            eVar.c(3, shortTvFavoriteStateBean.getHasFavorite() ? 1L : 0L);
            if (shortTvFavoriteStateBean.getFavoriteTime() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, shortTvFavoriteStateBean.getFavoriteTime());
            }
            if (shortTvFavoriteStateBean.getSubjectId() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, shortTvFavoriteStateBean.getSubjectId());
            }
        }
    }

    public i(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List h() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(ShortTvFavoriteStateBean shortTvFavoriteStateBean, y3.b bVar) {
        this.b.d(bVar, shortTvFavoriteStateBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ShortTvFavoriteStateBean j(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM short_tv_favorite_state WHERE subjectId=?");
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
            ShortTvFavoriteStateBean shortTvFavoriteStateBean = null;
            String q0 = null;
            if (F0.C0()) {
                String q02 = F0.isNull(c) ? null : F0.q0(c);
                String q03 = F0.isNull(c2) ? null : F0.q0(c2);
                if (((int) F0.getLong(c3)) == 0) {
                    z = false;
                }
                if (!F0.isNull(c4)) {
                    q0 = F0.q0(c4);
                }
                shortTvFavoriteStateBean = new ShortTvFavoriteStateBean(q02, q03, z, q0);
            }
            F0.close();
            return shortTvFavoriteStateBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(ShortTvFavoriteStateBean shortTvFavoriteStateBean, y3.b bVar) {
        this.c.c(bVar, shortTvFavoriteStateBean);
        return Unit.a;
    }

    @Override // com.transsion.shorttv.db.ShortTvFavoriteDao
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.shorttv.db.f
            public final Object invoke(Object obj) {
                ShortTvFavoriteStateBean j;
                j = i.j(str, (y3.b) obj);
                return j;
            }
        }, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvFavoriteDao
    public Object b(final ShortTvFavoriteStateBean shortTvFavoriteStateBean, Continuation continuation) {
        shortTvFavoriteStateBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.shorttv.db.g
            public final Object invoke(Object obj) {
                Unit k;
                k = i.this.k(shortTvFavoriteStateBean, (y3.b) obj);
                return k;
            }
        }, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvFavoriteDao
    public Object c(final ShortTvFavoriteStateBean shortTvFavoriteStateBean, Continuation continuation) {
        shortTvFavoriteStateBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.shorttv.db.h
            public final Object invoke(Object obj) {
                Unit i;
                i = i.this.i(shortTvFavoriteStateBean, (y3.b) obj);
                return i;
            }
        }, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvFavoriteDao
    public Object d(ShortTvFavoriteStateBean shortTvFavoriteStateBean, Continuation continuation) {
        return ShortTvFavoriteDao.DefaultImpls.a(this, shortTvFavoriteStateBean, continuation);
    }
}
