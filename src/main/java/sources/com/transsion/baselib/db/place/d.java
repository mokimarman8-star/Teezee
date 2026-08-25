package com.transsion.baselib.db.place;

import androidx.room.RoomDatabase;
import androidx.room.e;
import androidx.room.g;
import androidx.room.util.i;
import com.transsion.baselib.db.place.PlaceDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements PlaceDao {
    private final RoomDatabase a;
    private final g b = new a();
    private final e c = new b();

    class a extends g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `place_list` (`latitude`,`longitude`,`name`,`address`,`distance`) VALUES (?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, PlaceDBBean placeDBBean) {
            eVar.a(1, placeDBBean.getLatitude());
            eVar.a(2, placeDBBean.getLongitude());
            if (placeDBBean.getName() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, placeDBBean.getName());
            }
            if (placeDBBean.getAddress() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, placeDBBean.getAddress());
            }
            if (placeDBBean.getDistance() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, placeDBBean.getDistance());
            }
        }
    }

    class b extends e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `place_list` WHERE `latitude` = ? AND `longitude` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, PlaceDBBean placeDBBean) {
            eVar.a(1, placeDBBean.getLatitude());
            eVar.a(2, placeDBBean.getLongitude());
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List h() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit i(y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM place_list");
        try {
            F0.C0();
            return Unit.a;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List j(y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM place_list");
        try {
            int c = i.c(F0, "latitude");
            int c2 = i.c(F0, "longitude");
            int c3 = i.c(F0, "name");
            int c4 = i.c(F0, "address");
            int c5 = i.c(F0, "distance");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                arrayList.add(new PlaceDBBean(F0.getDouble(c), F0.getDouble(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), F0.isNull(c5) ? null : F0.q0(c5)));
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(List list, y3.b bVar) {
        this.b.c(bVar, list);
        return Unit.a;
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.place.a
            public final Object invoke(Object obj) {
                Unit i;
                i = d.i((y3.b) obj);
                return i;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object b(final List list, Continuation continuation) {
        list.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.baselib.db.place.c
            public final Object invoke(Object obj) {
                Unit k;
                k = d.this.k(list, (y3.b) obj);
                return k;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object c(List list, Continuation continuation) {
        return PlaceDao.DefaultImpls.a(this, list, continuation);
    }

    @Override // com.transsion.baselib.db.place.PlaceDao
    public Object d(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.baselib.db.place.b
            public final Object invoke(Object obj) {
                List j;
                j = d.j((y3.b) obj);
                return j;
            }
        }, continuation);
    }
}
