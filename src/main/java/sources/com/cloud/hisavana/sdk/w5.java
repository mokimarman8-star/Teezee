package com.cloud.hisavana.sdk;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class w5 implements v5 {
    private final RoomDatabase a;
    private final androidx.room.h b;
    private final androidx.room.l0 c;
    private final androidx.room.l0 d;

    class a extends androidx.room.h {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        protected String e() {
            return "INSERT OR REPLACE INTO `attr_impression_room` (`_id`,`pkg`,`imp_ts`,`ad_creative_id`) VALUES (nullif(?, 0),?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(z3.h hVar, com.cloud.hisavana.sdk.b bVar) {
            hVar.c(1, bVar.d());
            if (bVar.c() == null) {
                hVar.g(2);
            } else {
                hVar.V(2, bVar.c());
            }
            hVar.c(3, bVar.b());
            if (bVar.a() == null) {
                hVar.g(4);
            } else {
                hVar.V(4, bVar.a());
            }
        }
    }

    class b extends androidx.room.l0 {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM attr_impression_room WHERE _id IN (SELECT _id FROM attr_impression_room ORDER BY _id ASC LIMIT ?)";
        }
    }

    class c extends androidx.room.l0 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM attr_impression_room";
        }
    }

    public w5(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    public static List c() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.v5
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

    @Override // com.cloud.hisavana.sdk.v5
    public int a(int i) {
        this.a.j();
        z3.h b2 = this.c.b();
        b2.c(1, i);
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
            this.c.h(b2);
        }
    }

    @Override // com.cloud.hisavana.sdk.v5
    public void a(com.cloud.hisavana.sdk.b bVar) {
        this.a.j();
        this.a.k();
        try {
            this.b.l(bVar);
            this.a.e0();
        } finally {
            this.a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.v5
    public List b() {
        androidx.room.i0 f = androidx.room.i0.f("SELECT * FROM attr_impression_room", 0);
        this.a.j();
        Cursor g = androidx.room.util.b.g(this.a, f, false, (CancellationSignal) null);
        try {
            int e = androidx.room.util.a.e(g, "_id");
            int e2 = androidx.room.util.a.e(g, "pkg");
            int e3 = androidx.room.util.a.e(g, "imp_ts");
            int e4 = androidx.room.util.a.e(g, "ad_creative_id");
            ArrayList arrayList = new ArrayList(g.getCount());
            while (g.moveToNext()) {
                arrayList.add(new com.cloud.hisavana.sdk.b(g.getInt(e), g.isNull(e2) ? null : g.getString(e2), g.getLong(e3), g.isNull(e4) ? null : g.getString(e4)));
            }
            return arrayList;
        } finally {
            g.close();
            f.release();
        }
    }
}
