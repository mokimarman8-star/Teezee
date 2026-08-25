package th;

import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.util.i;
import com.transsion.ad.db.mcc.LocalMcc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements th.a {
    private final RoomDatabase a;
    private final g b = new a();

    class a extends g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `local_mcc` (`id`,`Country`,`Mcc`,`Iso`,`CountryCode`) VALUES (nullif(?, 0),?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, LocalMcc localMcc) {
            eVar.c(1, localMcc.getId());
            if (localMcc.getCountry() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, localMcc.getCountry());
            }
            if (localMcc.getMcc() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, localMcc.getMcc());
            }
            if (localMcc.getIso() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, localMcc.getIso());
            }
            if (localMcc.getCountryCode() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, localMcc.getCountryCode());
            }
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List i() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List j(y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM local_mcc");
        try {
            int c = i.c(F0, "id");
            int c2 = i.c(F0, "Country");
            int c3 = i.c(F0, "Mcc");
            int c4 = i.c(F0, "Iso");
            int c5 = i.c(F0, "CountryCode");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                arrayList.add(new LocalMcc((int) F0.getLong(c), F0.isNull(c2) ? null : F0.q0(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), F0.isNull(c5) ? null : F0.q0(c5)));
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LocalMcc k(y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM local_mcc LIMIT 1");
        try {
            int c = i.c(F0, "id");
            int c2 = i.c(F0, "Country");
            int c3 = i.c(F0, "Mcc");
            int c4 = i.c(F0, "Iso");
            int c5 = i.c(F0, "CountryCode");
            LocalMcc localMcc = null;
            if (F0.C0()) {
                localMcc = new LocalMcc((int) F0.getLong(c), F0.isNull(c2) ? null : F0.q0(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), F0.isNull(c5) ? null : F0.q0(c5));
            }
            return localMcc;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List l(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM local_mcc WHERE Iso = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = i.c(F0, "id");
            int c2 = i.c(F0, "Country");
            int c3 = i.c(F0, "Mcc");
            int c4 = i.c(F0, "Iso");
            int c5 = i.c(F0, "CountryCode");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                arrayList.add(new LocalMcc((int) F0.getLong(c), F0.isNull(c2) ? null : F0.q0(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), F0.isNull(c5) ? null : F0.q0(c5)));
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit m(List list, y3.b bVar) {
        this.b.c(bVar, list);
        return Unit.a;
    }

    @Override // th.a
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: th.c
            public final Object invoke(Object obj) {
                List l;
                l = f.l(str, (y3.b) obj);
                return l;
            }
        }, continuation);
    }

    @Override // th.a
    public Object b(final List list, Continuation continuation) {
        list.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: th.e
            public final Object invoke(Object obj) {
                Unit m;
                m = f.this.m(list, (y3.b) obj);
                return m;
            }
        }, continuation);
    }

    @Override // th.a
    public Object c(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: th.b
            public final Object invoke(Object obj) {
                List j;
                j = f.j((y3.b) obj);
                return j;
            }
        }, continuation);
    }

    @Override // th.a
    public Object d(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: th.d
            public final Object invoke(Object obj) {
                LocalMcc k;
                k = f.k((y3.b) obj);
                return k;
            }
        }, continuation);
    }
}
