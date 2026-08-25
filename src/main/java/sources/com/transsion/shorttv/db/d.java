package com.transsion.shorttv.db;

import androidx.room.RoomDatabase;
import com.transsion.shorttv.db.ShortTvAdUnlockDao;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements ShortTvAdUnlockDao {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `short_tv_ad_unlock_state` (`subjectId`,`unlockedEps`) VALUES (?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, e eVar2) {
            if (eVar2.a() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, eVar2.a());
            }
            if (eVar2.b() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, eVar2.b());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "UPDATE OR ABORT `short_tv_ad_unlock_state` SET `subjectId` = ?,`unlockedEps` = ? WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, e eVar2) {
            if (eVar2.a() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, eVar2.a());
            }
            if (eVar2.b() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, eVar2.b());
            }
            if (eVar2.a() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, eVar2.a());
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
    public /* synthetic */ Unit i(e eVar, y3.b bVar) {
        this.b.d(bVar, eVar);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e j(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM short_tv_ad_unlock_state WHERE subjectId=?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = androidx.room.util.i.c(F0, "subjectId");
            int c2 = androidx.room.util.i.c(F0, "unlockedEps");
            e eVar = null;
            String q0 = null;
            if (F0.C0()) {
                String q02 = F0.isNull(c) ? null : F0.q0(c);
                if (!F0.isNull(c2)) {
                    q0 = F0.q0(c2);
                }
                eVar = new e(q02, q0);
            }
            F0.close();
            return eVar;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(e eVar, y3.b bVar) {
        this.c.c(bVar, eVar);
        return Unit.a;
    }

    @Override // com.transsion.shorttv.db.ShortTvAdUnlockDao
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.shorttv.db.a
            public final Object invoke(Object obj) {
                e j;
                j = d.j(str, (y3.b) obj);
                return j;
            }
        }, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvAdUnlockDao
    public Object b(e eVar, Continuation continuation) {
        return ShortTvAdUnlockDao.DefaultImpls.a(this, eVar, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvAdUnlockDao
    public Object c(final e eVar, Continuation continuation) {
        eVar.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.shorttv.db.b
            public final Object invoke(Object obj) {
                Unit k;
                k = d.this.k(eVar, (y3.b) obj);
                return k;
            }
        }, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvAdUnlockDao
    public Object d(final e eVar, Continuation continuation) {
        eVar.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.shorttv.db.c
            public final Object invoke(Object obj) {
                Unit i;
                i = d.this.i(eVar, (y3.b) obj);
                return i;
            }
        }, continuation);
    }
}
