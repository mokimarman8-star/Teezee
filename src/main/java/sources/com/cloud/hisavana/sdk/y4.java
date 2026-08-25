package com.cloud.hisavana.sdk;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class y4 implements x4 {
    private final RoomDatabase a;
    private final androidx.room.h b;
    private final androidx.room.h c;
    private final androidx.room.l0 d;

    class a extends androidx.room.h {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        protected String e() {
            return "INSERT OR ABORT INTO `attr_click_room` (`_id`,`ac_type`,`pkg`,`dl_type`,`codeSeatId`,`click_ts`,`ad_creative_id`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(z3.h hVar, n5 n5Var) {
            hVar.c(1, n5Var.g());
            hVar.c(2, n5Var.a());
            if (n5Var.f() == null) {
                hVar.g(3);
            } else {
                hVar.V(3, n5Var.f());
            }
            if (n5Var.e() == null) {
                hVar.g(4);
            } else {
                hVar.V(4, n5Var.e());
            }
            if (n5Var.d() == null) {
                hVar.g(5);
            } else {
                hVar.V(5, n5Var.d());
            }
            hVar.c(6, n5Var.c());
            if (n5Var.b() == null) {
                hVar.g(7);
            } else {
                hVar.V(7, n5Var.b());
            }
        }
    }

    class b extends androidx.room.h {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        protected String e() {
            return "INSERT OR REPLACE INTO `attr_click_room` (`_id`,`ac_type`,`pkg`,`dl_type`,`codeSeatId`,`click_ts`,`ad_creative_id`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(z3.h hVar, n5 n5Var) {
            hVar.c(1, n5Var.g());
            hVar.c(2, n5Var.a());
            if (n5Var.f() == null) {
                hVar.g(3);
            } else {
                hVar.V(3, n5Var.f());
            }
            if (n5Var.e() == null) {
                hVar.g(4);
            } else {
                hVar.V(4, n5Var.e());
            }
            if (n5Var.d() == null) {
                hVar.g(5);
            } else {
                hVar.V(5, n5Var.d());
            }
            hVar.c(6, n5Var.c());
            if (n5Var.b() == null) {
                hVar.g(7);
            } else {
                hVar.V(7, n5Var.b());
            }
        }
    }

    class c extends androidx.room.l0 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM attr_click_room";
        }
    }

    public y4(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    public static List c() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.x4
    public int a() {
        this.a.j();
        z3.h b2 = this.d.b();
        try {
            this.a.k();
            try {
                int F = b2.F();
                this.a.e0();
                return F;
            } finally {
                this.a.t();
            }
        } finally {
            this.d.h(b2);
        }
    }

    @Override // com.cloud.hisavana.sdk.x4
    public int a(List list) {
        this.a.j();
        StringBuilder b2 = androidx.room.util.l.b();
        b2.append("DELETE FROM attr_click_room WHERE _id IN (");
        androidx.room.util.l.a(b2, list.size());
        b2.append(")");
        z3.h m = this.a.m(b2.toString());
        Iterator it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            if (((Integer) it.next()) == null) {
                m.g(i);
            } else {
                m.c(i, r2.intValue());
            }
            i++;
        }
        this.a.k();
        try {
            int F = m.F();
            this.a.e0();
            return F;
        } finally {
            this.a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.x4
    public void a(n5 n5Var) {
        this.a.j();
        this.a.k();
        try {
            this.b.l(n5Var);
            this.a.e0();
        } finally {
            this.a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.x4
    public List b() {
        androidx.room.i0 f = androidx.room.i0.f("SELECT * FROM attr_click_room", 0);
        this.a.j();
        Cursor g = androidx.room.util.b.g(this.a, f, false, (CancellationSignal) null);
        try {
            int e = androidx.room.util.a.e(g, "_id");
            int e2 = androidx.room.util.a.e(g, "ac_type");
            int e3 = androidx.room.util.a.e(g, "pkg");
            int e4 = androidx.room.util.a.e(g, "dl_type");
            int e8 = androidx.room.util.a.e(g, "codeSeatId");
            int e9 = androidx.room.util.a.e(g, "click_ts");
            int e10 = androidx.room.util.a.e(g, "ad_creative_id");
            ArrayList arrayList = new ArrayList(g.getCount());
            while (g.moveToNext()) {
                arrayList.add(new n5(g.getInt(e), g.getInt(e2), g.isNull(e3) ? null : g.getString(e3), g.isNull(e4) ? null : g.getString(e4), g.isNull(e8) ? null : g.getString(e8), g.getLong(e9), g.isNull(e10) ? null : g.getString(e10)));
            }
            return arrayList;
        } finally {
            g.close();
            f.release();
        }
    }
}
