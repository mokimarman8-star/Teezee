package com.transsion.ad.db.scene;

import androidx.room.RoomDatabase;
import androidx.room.util.i;
import com.transsion.ad.db.scene.AdSceneLimitDao;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements AdSceneLimitDao {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `ad_scene_limit_table` (`sceneId`,`lastDisplayAdDate`,`lastDisplayAdTimestamp`,`displayTimes`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AdSceneLimit adSceneLimit) {
            if (adSceneLimit.getSceneId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, adSceneLimit.getSceneId());
            }
            if (adSceneLimit.getLastDisplayAdDate() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, adSceneLimit.getLastDisplayAdDate());
            }
            eVar.c(3, adSceneLimit.getLastDisplayAdTimestamp());
            eVar.c(4, adSceneLimit.getDisplayTimes());
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "UPDATE OR ABORT `ad_scene_limit_table` SET `sceneId` = ?,`lastDisplayAdDate` = ?,`lastDisplayAdTimestamp` = ?,`displayTimes` = ? WHERE `sceneId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AdSceneLimit adSceneLimit) {
            if (adSceneLimit.getSceneId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, adSceneLimit.getSceneId());
            }
            if (adSceneLimit.getLastDisplayAdDate() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, adSceneLimit.getLastDisplayAdDate());
            }
            eVar.c(3, adSceneLimit.getLastDisplayAdTimestamp());
            eVar.c(4, adSceneLimit.getDisplayTimes());
            if (adSceneLimit.getSceneId() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, adSceneLimit.getSceneId());
            }
        }
    }

    public g(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List m() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(String str, String str2, long j, long j2, int i, Continuation continuation) {
        return AdSceneLimitDao.DefaultImpls.a(this, str, str2, j, j2, i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(String str, String str2, Continuation continuation) {
        return AdSceneLimitDao.DefaultImpls.b(this, str, str2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AdSceneLimit p(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM ad_scene_limit_table WHERE sceneId = ? LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = i.c(F0, "sceneId");
            int c2 = i.c(F0, "lastDisplayAdDate");
            int c3 = i.c(F0, "lastDisplayAdTimestamp");
            int c4 = i.c(F0, "displayTimes");
            AdSceneLimit adSceneLimit = null;
            if (F0.C0()) {
                adSceneLimit = new AdSceneLimit(F0.isNull(c) ? null : F0.q0(c), F0.isNull(c2) ? null : F0.q0(c2), F0.getLong(c3), (int) F0.getLong(c4));
            }
            F0.close();
            return adSceneLimit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit q(AdSceneLimit adSceneLimit, y3.b bVar) {
        this.b.d(bVar, adSceneLimit);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(String str, String str2, long j, Continuation continuation) {
        return AdSceneLimitDao.DefaultImpls.c(this, str, str2, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(AdSceneLimit adSceneLimit, y3.b bVar) {
        this.c.c(bVar, adSceneLimit);
        return Unit.a;
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.ad.db.scene.e
            public final Object invoke(Object obj) {
                AdSceneLimit p;
                p = g.p(str, (y3.b) obj);
                return p;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object b(final String str, final String str2, final long j, final long j2, final int i, Continuation continuation) {
        return androidx.room.util.b.e(this.a, new Function1() { // from class: com.transsion.ad.db.scene.a
            public final Object invoke(Object obj) {
                Object n;
                n = g.this.n(str, str2, j, j2, i, (Continuation) obj);
                return n;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object c(final String str, final String str2, final long j, Continuation continuation) {
        return androidx.room.util.b.e(this.a, new Function1() { // from class: com.transsion.ad.db.scene.b
            public final Object invoke(Object obj) {
                Object r;
                r = g.this.r(str, str2, j, (Continuation) obj);
                return r;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object d(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.e(this.a, new Function1() { // from class: com.transsion.ad.db.scene.d
            public final Object invoke(Object obj) {
                Object o;
                o = g.this.o(str, str2, (Continuation) obj);
                return o;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object e(final AdSceneLimit adSceneLimit, Continuation continuation) {
        adSceneLimit.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.ad.db.scene.f
            public final Object invoke(Object obj) {
                Unit q;
                q = g.this.q(adSceneLimit, (y3.b) obj);
                return q;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object f(final AdSceneLimit adSceneLimit, Continuation continuation) {
        adSceneLimit.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.ad.db.scene.c
            public final Object invoke(Object obj) {
                Unit s;
                s = g.this.s(adSceneLimit, (y3.b) obj);
                return s;
            }
        }, continuation);
    }
}
