package com.cloud.hisavana.sdk;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.f;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a1 implements z0 {
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
            return "INSERT OR REPLACE INTO `cloudList_room` (`codeSeatId`,`code_seat_bean`) VALUES (?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(z3.h hVar, c1 c1Var) {
            if (c1Var.a() == null) {
                hVar.g(1);
            } else {
                hVar.V(1, c1Var.a());
            }
            if (c1Var.b() == null) {
                hVar.g(2);
            } else {
                hVar.V(2, c1Var.b());
            }
        }
    }

    class b extends f {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        protected String e() {
            return "UPDATE OR ABORT `cloudList_room` SET `codeSeatId` = ?,`code_seat_bean` = ? WHERE `codeSeatId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void j(z3.h hVar, c1 c1Var) {
            if (c1Var.a() == null) {
                hVar.g(1);
            } else {
                hVar.V(1, c1Var.a());
            }
            if (c1Var.b() == null) {
                hVar.g(2);
            } else {
                hVar.V(2, c1Var.b());
            }
            if (c1Var.a() == null) {
                hVar.g(3);
            } else {
                hVar.V(3, c1Var.a());
            }
        }
    }

    class c extends androidx.room.l0 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM cloudList_room";
        }
    }

    class d extends androidx.room.l0 {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE cloudList_room SET code_seat_bean = ? WHERE codeSeatId = ?";
        }
    }

    public a1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
    }

    public static List d() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.z0
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

    @Override // com.cloud.hisavana.sdk.z0
    public Cursor a(z3.g gVar) {
        return this.a.V(gVar);
    }

    @Override // com.cloud.hisavana.sdk.z0
    public void a() {
        this.a.j();
        z3.h b2 = this.d.b();
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

    @Override // com.cloud.hisavana.sdk.z0
    public int b(z3.g gVar) {
        this.a.j();
        Cursor g = androidx.room.util.b.g(this.a, gVar, false, (CancellationSignal) null);
        try {
            return g.moveToFirst() ? g.getInt(0) : 0;
        } finally {
            g.close();
        }
    }

    @Override // com.cloud.hisavana.sdk.z0
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
}
