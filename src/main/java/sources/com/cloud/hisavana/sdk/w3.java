package com.cloud.hisavana.sdk;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class w3 implements v3 {
    private final RoomDatabase a;
    private final androidx.room.h b;
    private final androidx.room.f c;
    private final androidx.room.l0 d;
    private final androidx.room.l0 e;
    private final androidx.room.l0 f;
    private final androidx.room.l0 g;

    class a extends androidx.room.h {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        protected String e() {
            return "INSERT OR REPLACE INTO `adList_room` (`_id`,`ad_creative_id`,`codeSeatId`,`file_path`,`price`,`is_offline_ad`,`ad_request_ver`,`ad_bean`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(z3.h hVar, y3 y3Var) {
            hVar.c(1, y3Var.o());
            if (y3Var.f() == null) {
                hVar.g(2);
            } else {
                hVar.V(2, y3Var.f());
            }
            if (y3Var.k() == null) {
                hVar.g(3);
            } else {
                hVar.V(3, y3Var.k());
            }
            if (y3Var.m() == null) {
                hVar.g(4);
            } else {
                hVar.V(4, y3Var.m());
            }
            if (y3Var.n() == null) {
                hVar.g(5);
            } else {
                hVar.a(5, y3Var.n().doubleValue());
            }
            if (y3Var.p() == null) {
                hVar.g(6);
            } else {
                hVar.c(6, y3Var.p().intValue());
            }
            if (y3Var.i() == null) {
                hVar.g(7);
            } else {
                hVar.c(7, y3Var.i().intValue());
            }
            if (y3Var.a() == null) {
                hVar.g(8);
            } else {
                hVar.V(8, y3Var.a());
            }
        }
    }

    class b extends androidx.room.f {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        protected String e() {
            return "UPDATE OR ABORT `adList_room` SET `_id` = ?,`ad_creative_id` = ?,`codeSeatId` = ?,`file_path` = ?,`price` = ?,`is_offline_ad` = ?,`ad_request_ver` = ?,`ad_bean` = ? WHERE `_id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void j(z3.h hVar, y3 y3Var) {
            hVar.c(1, y3Var.o());
            if (y3Var.f() == null) {
                hVar.g(2);
            } else {
                hVar.V(2, y3Var.f());
            }
            if (y3Var.k() == null) {
                hVar.g(3);
            } else {
                hVar.V(3, y3Var.k());
            }
            if (y3Var.m() == null) {
                hVar.g(4);
            } else {
                hVar.V(4, y3Var.m());
            }
            if (y3Var.n() == null) {
                hVar.g(5);
            } else {
                hVar.a(5, y3Var.n().doubleValue());
            }
            if (y3Var.p() == null) {
                hVar.g(6);
            } else {
                hVar.c(6, y3Var.p().intValue());
            }
            if (y3Var.i() == null) {
                hVar.g(7);
            } else {
                hVar.c(7, y3Var.i().intValue());
            }
            if (y3Var.a() == null) {
                hVar.g(8);
            } else {
                hVar.V(8, y3Var.a());
            }
            hVar.c(9, y3Var.o());
        }
    }

    class c extends androidx.room.l0 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM adList_room WHERE codeSeatId = ? AND ad_creative_id = ?";
        }
    }

    class d extends androidx.room.l0 {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM adList_room WHERE codeSeatId = ? AND ad_request_ver < ? AND is_offline_ad = 1";
        }
    }

    class e extends androidx.room.l0 {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM adList_room WHERE codeSeatId = ? AND is_offline_ad = 0";
        }
    }

    class f extends androidx.room.l0 {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM adList_room";
        }
    }

    public w3(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
        this.g = new f(roomDatabase);
    }

    public static List e() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.v3
    public int a(List list) {
        this.a.j();
        this.a.k();
        try {
            int l = this.c.l(list);
            this.a.e0();
            return l;
        } finally {
            this.a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.v3
    public Cursor a(z3.g gVar) {
        return this.a.V(gVar);
    }

    @Override // com.cloud.hisavana.sdk.v3
    public void a() {
        this.a.j();
        z3.h b2 = this.g.b();
        try {
            this.a.k();
            try {
                b2.F();
                this.a.e0();
            } finally {
                this.a.t();
            }
        } finally {
            this.g.h(b2);
        }
    }

    @Override // com.cloud.hisavana.sdk.v3
    public int b(z3.g gVar) {
        this.a.j();
        Cursor g = androidx.room.util.b.g(this.a, gVar, false, (CancellationSignal) null);
        try {
            return g.moveToFirst() ? g.getInt(0) : 0;
        } finally {
            g.close();
        }
    }

    @Override // com.cloud.hisavana.sdk.v3
    public void c(List list) {
        this.a.j();
        this.a.k();
        try {
            this.b.k(list);
            this.a.e0();
        } finally {
            this.a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.v3
    public List d(List list) {
        StringBuilder b2 = androidx.room.util.l.b();
        b2.append("SELECT * FROM adList_room WHERE ad_creative_id IN (");
        int i = 1;
        int size = list == null ? 1 : list.size();
        androidx.room.util.l.a(b2, size);
        b2.append(")");
        androidx.room.i0 f2 = androidx.room.i0.f(b2.toString(), size);
        if (list == null) {
            f2.g(1);
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null) {
                    f2.g(i);
                } else {
                    f2.V(i, str);
                }
                i++;
            }
        }
        this.a.j();
        Cursor g = androidx.room.util.b.g(this.a, f2, false, (CancellationSignal) null);
        try {
            int e2 = androidx.room.util.a.e(g, "_id");
            int e3 = androidx.room.util.a.e(g, "ad_creative_id");
            int e4 = androidx.room.util.a.e(g, "codeSeatId");
            int e8 = androidx.room.util.a.e(g, "file_path");
            int e9 = androidx.room.util.a.e(g, "price");
            int e10 = androidx.room.util.a.e(g, "is_offline_ad");
            int e11 = androidx.room.util.a.e(g, "ad_request_ver");
            int e12 = androidx.room.util.a.e(g, "ad_bean");
            ArrayList arrayList = new ArrayList(g.getCount());
            while (g.moveToNext()) {
                arrayList.add(new y3(g.getInt(e2), g.isNull(e3) ? null : g.getString(e3), g.isNull(e4) ? null : g.getString(e4), g.isNull(e8) ? null : g.getString(e8), g.isNull(e9) ? null : Double.valueOf(g.getDouble(e9)), g.isNull(e10) ? null : Integer.valueOf(g.getInt(e10)), g.isNull(e11) ? null : Integer.valueOf(g.getInt(e11)), g.isNull(e12) ? null : g.getString(e12)));
            }
            return arrayList;
        } finally {
            g.close();
            f2.release();
        }
    }
}
