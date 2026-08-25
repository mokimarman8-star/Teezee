package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.video.UGCCollectionVideoGroupDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q implements UGCCollectionVideoGroupDao {
    private final RoomDatabase a;
    private final ri.b c = new ri.b();
    private final androidx.room.g b = new a();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `ugc_collection_video_group` (`collectionId`,`ugcVideoIds`) VALUES (?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, UGCCollectionVideoGroup uGCCollectionVideoGroup) {
            if (uGCCollectionVideoGroup.getCollectionId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, uGCCollectionVideoGroup.getCollectionId());
            }
            String a = q.this.c.a(uGCCollectionVideoGroup.getUgcVideoIds());
            if (a == null) {
                eVar.g(2);
            } else {
                eVar.i(2, a);
            }
        }
    }

    public q(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List j() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List k(y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM ugc_collection_video_group");
        try {
            int c = androidx.room.util.i.c(F0, "collectionId");
            int c2 = androidx.room.util.i.c(F0, "ugcVideoIds");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String str = null;
                String q0 = F0.isNull(c) ? null : F0.q0(c);
                if (!F0.isNull(c2)) {
                    str = F0.q0(c2);
                }
                arrayList.add(new UGCCollectionVideoGroup(q0, this.c.b(str)));
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ UGCCollectionVideoGroup l(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM ugc_collection_video_group WHERE collectionId = ? LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = androidx.room.util.i.c(F0, "collectionId");
            int c2 = androidx.room.util.i.c(F0, "ugcVideoIds");
            UGCCollectionVideoGroup uGCCollectionVideoGroup = null;
            String q0 = null;
            if (F0.C0()) {
                String q02 = F0.isNull(c) ? null : F0.q0(c);
                if (!F0.isNull(c2)) {
                    q0 = F0.q0(c2);
                }
                uGCCollectionVideoGroup = new UGCCollectionVideoGroup(q02, this.c.b(q0));
            }
            F0.close();
            return uGCCollectionVideoGroup;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit m(UGCCollectionVideoGroup uGCCollectionVideoGroup, y3.b bVar) {
        this.b.d(bVar, uGCCollectionVideoGroup);
        return Unit.a;
    }

    @Override // com.transsion.baselib.db.video.UGCCollectionVideoGroupDao
    public Object a(String str, List list, Continuation continuation) {
        return UGCCollectionVideoGroupDao.DefaultImpls.a(this, str, list, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCCollectionVideoGroupDao
    public Object b(final UGCCollectionVideoGroup uGCCollectionVideoGroup, Continuation continuation) {
        uGCCollectionVideoGroup.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.p
            public final Object invoke(Object obj) {
                Unit m;
                m = q.this.m(uGCCollectionVideoGroup, (y3.b) obj);
                return m;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCCollectionVideoGroupDao
    public Object c(String str, Continuation continuation) {
        return UGCCollectionVideoGroupDao.DefaultImpls.b(this, str, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCCollectionVideoGroupDao
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.o
            public final Object invoke(Object obj) {
                UGCCollectionVideoGroup l;
                l = q.this.l(str, (y3.b) obj);
                return l;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCCollectionVideoGroupDao
    public Object e(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.n
            public final Object invoke(Object obj) {
                List k;
                k = q.this.k((y3.b) obj);
                return k;
            }
        }, continuation);
    }
}
