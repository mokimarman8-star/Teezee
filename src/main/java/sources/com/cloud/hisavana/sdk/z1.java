package com.cloud.hisavana.sdk;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class z1 implements y1 {
    private final RoomDatabase a;
    private final androidx.room.h b;
    private final androidx.room.l0 c;
    private final androidx.room.l0 d;
    private final androidx.room.l0 e;
    private final androidx.room.l0 f;
    private final androidx.room.l0 g;
    private final androidx.room.l0 h;
    private final androidx.room.l0 i;

    class a extends androidx.room.h {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        protected String e() {
            return "INSERT OR REPLACE INTO `default_ad_room` (`ad_creative_id`,`codeSeatId`,`ad_type`,`price`,`ad_request_ver`,`displayed_times`,`displayed_date`,`start_date`,`end_date`,`display_max_times`,`file_path`,`default_country_white`,`default_country_black`,`default_brand_white`,`default_brand_black`,`ad_bean`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(z3.h hVar, c2 c2Var) {
            if (c2Var.b() == null) {
                hVar.g(1);
            } else {
                hVar.V(1, c2Var.b());
            }
            if (c2Var.e() == null) {
                hVar.g(2);
            } else {
                hVar.V(2, c2Var.e());
            }
            hVar.c(3, c2Var.d());
            if (c2Var.o() == null) {
                hVar.g(4);
            } else {
                hVar.a(4, c2Var.o().doubleValue());
            }
            hVar.c(5, c2Var.c());
            hVar.c(6, c2Var.l());
            if (c2Var.k() == null) {
                hVar.g(7);
            } else {
                hVar.V(7, c2Var.k());
            }
            if (c2Var.p() == null) {
                hVar.g(8);
            } else {
                hVar.V(8, c2Var.p());
            }
            if (c2Var.m() == null) {
                hVar.g(9);
            } else {
                hVar.V(9, c2Var.m());
            }
            hVar.c(10, c2Var.j());
            if (c2Var.n() == null) {
                hVar.g(11);
            } else {
                hVar.V(11, c2Var.n());
            }
            if (c2Var.i() == null) {
                hVar.g(12);
            } else {
                hVar.V(12, c2Var.i());
            }
            if (c2Var.h() == null) {
                hVar.g(13);
            } else {
                hVar.V(13, c2Var.h());
            }
            if (c2Var.g() == null) {
                hVar.g(14);
            } else {
                hVar.V(14, c2Var.g());
            }
            if (c2Var.f() == null) {
                hVar.g(15);
            } else {
                hVar.V(15, c2Var.f());
            }
            if (c2Var.a() == null) {
                hVar.g(16);
            } else {
                hVar.V(16, c2Var.a());
            }
        }
    }

    class b extends androidx.room.l0 {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE default_ad_room SET displayed_times = ?, displayed_date = ? WHERE ad_creative_id = ? AND codeSeatId = ?";
        }
    }

    class c extends androidx.room.l0 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM default_ad_room WHERE ad_creative_id = ? AND codeSeatId = ?";
        }
    }

    class d extends androidx.room.l0 {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE default_ad_room SET file_path = '' WHERE file_path LIKE '%' || ? || '.0'";
        }
    }

    class e extends androidx.room.l0 {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM default_ad_room WHERE codeSeatId = ? AND ad_request_ver < (SELECT MAX(ad_request_ver) FROM default_ad_room WHERE codeSeatId = ?)";
        }
    }

    class f extends androidx.room.l0 {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE default_ad_room SET file_path = ? WHERE ad_creative_id = ? AND codeSeatId = ?";
        }
    }

    class g extends androidx.room.l0 {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM default_ad_room WHERE ad_request_ver < ?";
        }
    }

    class h extends androidx.room.l0 {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM default_ad_room";
        }
    }

    public z1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
        this.f = new e(roomDatabase);
        this.g = new f(roomDatabase);
        this.h = new g(roomDatabase);
        this.i = new h(roomDatabase);
    }

    public static List c() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.y1
    public List a() {
        androidx.room.i0 i0Var;
        int e2;
        int e3;
        int e4;
        int e8;
        int e9;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        String string;
        int i;
        String string2;
        int i2;
        androidx.room.i0 f2 = androidx.room.i0.f("SELECT * FROM default_ad_room", 0);
        this.a.j();
        Cursor g2 = androidx.room.util.b.g(this.a, f2, false, (CancellationSignal) null);
        try {
            e2 = androidx.room.util.a.e(g2, "ad_creative_id");
            e3 = androidx.room.util.a.e(g2, "codeSeatId");
            e4 = androidx.room.util.a.e(g2, "ad_type");
            e8 = androidx.room.util.a.e(g2, "price");
            e9 = androidx.room.util.a.e(g2, "ad_request_ver");
            e10 = androidx.room.util.a.e(g2, "displayed_times");
            e11 = androidx.room.util.a.e(g2, "displayed_date");
            e12 = androidx.room.util.a.e(g2, "start_date");
            e13 = androidx.room.util.a.e(g2, "end_date");
            e14 = androidx.room.util.a.e(g2, "display_max_times");
            e15 = androidx.room.util.a.e(g2, "file_path");
            e16 = androidx.room.util.a.e(g2, "default_country_white");
            e17 = androidx.room.util.a.e(g2, "default_country_black");
            e18 = androidx.room.util.a.e(g2, "default_brand_white");
            i0Var = f2;
        } catch (Throwable th) {
            th = th;
            i0Var = f2;
        }
        try {
            int e19 = androidx.room.util.a.e(g2, "default_brand_black");
            int e20 = androidx.room.util.a.e(g2, "ad_bean");
            int i3 = e18;
            ArrayList arrayList = new ArrayList(g2.getCount());
            while (g2.moveToNext()) {
                String string3 = g2.isNull(e2) ? null : g2.getString(e2);
                String string4 = g2.isNull(e3) ? null : g2.getString(e3);
                int i4 = g2.getInt(e4);
                Double valueOf = g2.isNull(e8) ? null : Double.valueOf(g2.getDouble(e8));
                int i8 = g2.getInt(e9);
                int i9 = g2.getInt(e10);
                String string5 = g2.isNull(e11) ? null : g2.getString(e11);
                String string6 = g2.isNull(e12) ? null : g2.getString(e12);
                String string7 = g2.isNull(e13) ? null : g2.getString(e13);
                int i10 = g2.getInt(e14);
                String string8 = g2.isNull(e15) ? null : g2.getString(e15);
                String string9 = g2.isNull(e16) ? null : g2.getString(e16);
                if (g2.isNull(e17)) {
                    i = i3;
                    string = null;
                } else {
                    string = g2.getString(e17);
                    i = i3;
                }
                String string10 = g2.isNull(i) ? null : g2.getString(i);
                int i11 = e19;
                int i12 = e2;
                String string11 = g2.isNull(i11) ? null : g2.getString(i11);
                int i13 = e20;
                if (g2.isNull(i13)) {
                    i2 = i13;
                    string2 = null;
                } else {
                    string2 = g2.getString(i13);
                    i2 = i13;
                }
                arrayList.add(new c2(string3, string4, i4, valueOf, i8, i9, string5, string6, string7, i10, string8, string9, string, string10, string11, string2));
                e2 = i12;
                e19 = i11;
                e20 = i2;
                i3 = i;
            }
            g2.close();
            i0Var.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            g2.close();
            i0Var.release();
            throw th;
        }
    }

    @Override // com.cloud.hisavana.sdk.y1
    public void a(int i) {
        this.a.j();
        z3.h b2 = this.h.b();
        b2.c(1, i);
        try {
            this.a.k();
            try {
                b2.F();
                this.a.e0();
            } finally {
                this.a.t();
            }
        } finally {
            this.h.h(b2);
        }
    }

    @Override // com.cloud.hisavana.sdk.y1
    public void a(c2 c2Var) {
        this.a.j();
        this.a.k();
        try {
            this.b.l(c2Var);
            this.a.e0();
        } finally {
            this.a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.y1
    public void a(String str) {
        this.a.j();
        z3.h b2 = this.e.b();
        if (str == null) {
            b2.g(1);
        } else {
            b2.V(1, str);
        }
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

    @Override // com.cloud.hisavana.sdk.y1
    public void a(String str, String str2) {
        this.a.j();
        z3.h b2 = this.d.b();
        if (str == null) {
            b2.g(1);
        } else {
            b2.V(1, str);
        }
        if (str2 == null) {
            b2.g(2);
        } else {
            b2.V(2, str2);
        }
        try {
            this.a.k();
            try {
                b2.F();
                this.a.e0();
            } finally {
                this.a.t();
            }
        } finally {
            this.d.h(b2);
        }
    }

    @Override // com.cloud.hisavana.sdk.y1
    public void a(String str, String str2, String str3) {
        this.a.j();
        z3.h b2 = this.g.b();
        if (str3 == null) {
            b2.g(1);
        } else {
            b2.V(1, str3);
        }
        if (str == null) {
            b2.g(2);
        } else {
            b2.V(2, str);
        }
        if (str2 == null) {
            b2.g(3);
        } else {
            b2.V(3, str2);
        }
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

    @Override // com.cloud.hisavana.sdk.y1
    public void a(List list) {
        this.a.j();
        StringBuilder b2 = androidx.room.util.l.b();
        b2.append("DELETE FROM default_ad_room WHERE codeSeatId NOT IN (");
        androidx.room.util.l.a(b2, list.size());
        b2.append(")");
        z3.h m = this.a.m(b2.toString());
        Iterator it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                m.g(i);
            } else {
                m.V(i, str);
            }
            i++;
        }
        this.a.k();
        try {
            m.F();
            this.a.e0();
        } finally {
            this.a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.y1
    public void b() {
        this.a.j();
        z3.h b2 = this.i.b();
        try {
            this.a.k();
            try {
                b2.F();
                this.a.e0();
            } finally {
                this.a.t();
            }
        } finally {
            this.i.h(b2);
        }
    }

    @Override // com.cloud.hisavana.sdk.y1
    public void b(String str) {
        this.a.j();
        z3.h b2 = this.f.b();
        if (str == null) {
            b2.g(1);
        } else {
            b2.V(1, str);
        }
        if (str == null) {
            b2.g(2);
        } else {
            b2.V(2, str);
        }
        try {
            this.a.k();
            try {
                b2.F();
                this.a.e0();
            } finally {
                this.a.t();
            }
        } finally {
            this.f.h(b2);
        }
    }

    @Override // com.cloud.hisavana.sdk.y1
    public void b(String str, String str2, int i, String str3) {
        this.a.j();
        z3.h b2 = this.c.b();
        b2.c(1, i);
        if (str3 == null) {
            b2.g(2);
        } else {
            b2.V(2, str3);
        }
        if (str == null) {
            b2.g(3);
        } else {
            b2.V(3, str);
        }
        if (str2 == null) {
            b2.g(4);
        } else {
            b2.V(4, str2);
        }
        try {
            this.a.k();
            try {
                b2.F();
                this.a.e0();
            } finally {
                this.a.t();
            }
        } finally {
            this.c.h(b2);
        }
    }
}
