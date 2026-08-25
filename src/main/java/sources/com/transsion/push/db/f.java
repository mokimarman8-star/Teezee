package com.transsion.push.db;

import androidx.room.RoomDatabase;
import androidx.room.util.i;
import com.transsion.push.bean.PermanentItemBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements com.transsion.push.db.a {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();
    private final androidx.room.e d = new c();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `permanent_item` (`id`,`deeplink`,`subject_id`,`image`,`title`) VALUES (nullif(?, 0),?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, PermanentItemBean permanentItemBean) {
            eVar.c(1, permanentItemBean.getId());
            if (permanentItemBean.getDeeplink() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, permanentItemBean.getDeeplink());
            }
            if (permanentItemBean.getSubjectId() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, permanentItemBean.getSubjectId());
            }
            if (permanentItemBean.getImage() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, permanentItemBean.getImage());
            }
            if (permanentItemBean.getTitle() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, permanentItemBean.getTitle());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `permanent_item` WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, PermanentItemBean permanentItemBean) {
            eVar.c(1, permanentItemBean.getId());
        }
    }

    class c extends androidx.room.e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `permanent_item` SET `id` = ?,`deeplink` = ?,`subject_id` = ?,`image` = ?,`title` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, PermanentItemBean permanentItemBean) {
            eVar.c(1, permanentItemBean.getId());
            if (permanentItemBean.getDeeplink() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, permanentItemBean.getDeeplink());
            }
            if (permanentItemBean.getSubjectId() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, permanentItemBean.getSubjectId());
            }
            if (permanentItemBean.getImage() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, permanentItemBean.getImage());
            }
            if (permanentItemBean.getTitle() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, permanentItemBean.getTitle());
            }
            eVar.c(6, permanentItemBean.getId());
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List i() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit j(y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM PERMANENT_ITEM");
        try {
            F0.C0();
            return Unit.a;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(PermanentItemBean permanentItemBean, y3.b bVar) {
        this.c.c(bVar, permanentItemBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List l(y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM permanent_item");
        try {
            int c2 = i.c(F0, "id");
            int c3 = i.c(F0, "deeplink");
            int c4 = i.c(F0, "subject_id");
            int c5 = i.c(F0, "image");
            int c6 = i.c(F0, "title");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                arrayList.add(new PermanentItemBean((int) F0.getLong(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), F0.isNull(c5) ? null : F0.q0(c5), F0.isNull(c6) ? null : F0.q0(c6)));
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit m(List list, y3.b bVar) {
        this.b.c(bVar, list);
        return Unit.a;
    }

    @Override // com.transsion.push.db.a
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.push.db.c
            public final Object invoke(Object obj) {
                Unit j;
                j = f.j((y3.b) obj);
                return j;
            }
        }, continuation);
    }

    @Override // com.transsion.push.db.a
    public Object b(final List list, Continuation continuation) {
        list.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.push.db.e
            public final Object invoke(Object obj) {
                Unit m;
                m = f.this.m(list, (y3.b) obj);
                return m;
            }
        }, continuation);
    }

    @Override // com.transsion.push.db.a
    public Object c(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: com.transsion.push.db.b
            public final Object invoke(Object obj) {
                List l;
                l = f.l((y3.b) obj);
                return l;
            }
        }, continuation);
    }

    @Override // com.transsion.push.db.a
    public Object d(final PermanentItemBean permanentItemBean, Continuation continuation) {
        permanentItemBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: com.transsion.push.db.d
            public final Object invoke(Object obj) {
                Unit k;
                k = f.this.k(permanentItemBean, (y3.b) obj);
                return k;
            }
        }, continuation);
    }
}
