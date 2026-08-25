package com.cloud.hisavana.sdk;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class d1 implements b1 {
    private final RoomDatabase a;
    private final androidx.room.h b;
    private final f c;
    private final androidx.room.l0 d;
    private final androidx.room.l0 e;

    class a extends androidx.room.h {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        protected String e() {
            return "INSERT OR REPLACE INTO `retry_tracking_table_room` (`uuid`,`create_time`,`retry_times`,`tracking_data`,`md5`) VALUES (?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(z3.h hVar, i1 i1Var) {
            if (i1Var.j() == null) {
                hVar.g(1);
            } else {
                hVar.V(1, i1Var.j());
            }
            if (i1Var.a() == null) {
                hVar.g(2);
            } else {
                hVar.c(2, i1Var.a().longValue());
            }
            if (i1Var.g() == null) {
                hVar.g(3);
            } else {
                hVar.c(3, i1Var.g().intValue());
            }
            if (i1Var.i() == null) {
                hVar.g(4);
            } else {
                hVar.V(4, i1Var.i());
            }
            if (i1Var.e() == null) {
                hVar.g(5);
            } else {
                hVar.V(5, i1Var.e());
            }
        }
    }

    class b extends f {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        protected String e() {
            return "UPDATE OR ABORT `retry_tracking_table_room` SET `uuid` = ?,`create_time` = ?,`retry_times` = ?,`tracking_data` = ?,`md5` = ? WHERE `uuid` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void j(z3.h hVar, i1 i1Var) {
            if (i1Var.j() == null) {
                hVar.g(1);
            } else {
                hVar.V(1, i1Var.j());
            }
            if (i1Var.a() == null) {
                hVar.g(2);
            } else {
                hVar.c(2, i1Var.a().longValue());
            }
            if (i1Var.g() == null) {
                hVar.g(3);
            } else {
                hVar.c(3, i1Var.g().intValue());
            }
            if (i1Var.i() == null) {
                hVar.g(4);
            } else {
                hVar.V(4, i1Var.i());
            }
            if (i1Var.e() == null) {
                hVar.g(5);
            } else {
                hVar.V(5, i1Var.e());
            }
            if (i1Var.j() == null) {
                hVar.g(6);
            } else {
                hVar.V(6, i1Var.j());
            }
        }
    }

    class c extends androidx.room.l0 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM retry_tracking_table_room WHERE create_time < ?";
        }
    }

    class d extends androidx.room.l0 {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM retry_tracking_table_room";
        }
    }

    public d1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
    }

    public static List e() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.b1
    public int a(long j) {
        this.a.j();
        z3.h b2 = this.d.b();
        b2.c(1, j);
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

    @Override // com.cloud.hisavana.sdk.b1
    public Cursor a(z3.g gVar) {
        return this.a.V(gVar);
    }

    @Override // com.cloud.hisavana.sdk.b1
    public List a() {
        androidx.room.i0 f = androidx.room.i0.f("SELECT tracking_data FROM retry_tracking_table_room", 0);
        this.a.j();
        Cursor g = androidx.room.util.b.g(this.a, f, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(g.getCount());
            while (g.moveToNext()) {
                arrayList.add(g.isNull(0) ? null : g.getString(0));
            }
            return arrayList;
        } finally {
            g.close();
            f.release();
        }
    }

    @Override // com.cloud.hisavana.sdk.b1
    public int b(String[] strArr) {
        this.a.j();
        StringBuilder b2 = androidx.room.util.l.b();
        b2.append("DELETE FROM retry_tracking_table_room WHERE uuid in (");
        androidx.room.util.l.a(b2, strArr.length);
        b2.append(")");
        z3.h m = this.a.m(b2.toString());
        int i = 1;
        for (String str : strArr) {
            if (str == null) {
                m.g(i);
            } else {
                m.V(i, str);
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

    @Override // com.cloud.hisavana.sdk.b1
    public void b() {
        this.a.j();
        z3.h b2 = this.e.b();
        try {
            this.a.k();
            try {
                b2.F();
                this.a.e0();
            } finally {
                this.a.t();
            }
        } finally {
            this.e.h(b2);
        }
    }

    @Override // com.cloud.hisavana.sdk.b1
    public int c(i1 i1Var) {
        this.a.j();
        this.a.k();
        try {
            int k = this.c.k(i1Var);
            this.a.e0();
            return k;
        } finally {
            this.a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.b1
    public void d(i1 i1Var) {
        this.a.j();
        this.a.k();
        try {
            this.b.l(i1Var);
            this.a.e0();
        } finally {
            this.a.t();
        }
    }
}
