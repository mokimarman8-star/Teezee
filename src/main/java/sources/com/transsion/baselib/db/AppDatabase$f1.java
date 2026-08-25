package com.transsion.baselib.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$f1 {

    public static final class a extends RoomDatabase.b {
        a() {
        }

        public void b(d dVar) {
            Intrinsics.h(dVar, "db");
            super.b(dVar);
            a.a.f(wf.a.a, "database", "onCreate db_name is=" + dVar.getPath(), false, 4, (Object) null);
        }
    }

    private AppDatabase$f1() {
    }

    public /* synthetic */ AppDatabase$f1(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final AppDatabase a(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        return s.a(applicationContext, AppDatabase.class, "oneroom-db").c().b(new b[]{AppDatabase.r0(), AppDatabase.C0(), AppDatabase.N0(), AppDatabase.Y0(), AppDatabase.h1(), AppDatabase.i1(), AppDatabase.j1(), AppDatabase.k1(), AppDatabase.l1(), AppDatabase.h0(), AppDatabase.i0(), AppDatabase.j0(), AppDatabase.k0(), AppDatabase.l0(), AppDatabase.m0(), AppDatabase.n0(), AppDatabase.o0(), AppDatabase.p0(), AppDatabase.q0(), AppDatabase.s0(), AppDatabase.t0(), AppDatabase.u0(), AppDatabase.v0(), AppDatabase.w0(), AppDatabase.x0(), AppDatabase.y0(), AppDatabase.z0(), AppDatabase.A0(), AppDatabase.B0(), AppDatabase.D0(), AppDatabase.E0(), AppDatabase.F0(), AppDatabase.G0(), AppDatabase.H0(), AppDatabase.I0(), AppDatabase.J0(), AppDatabase.K0(), AppDatabase.L0(), AppDatabase.M0(), AppDatabase.O0(), AppDatabase.P0(), AppDatabase.Q0(), AppDatabase.R0(), AppDatabase.S0(), AppDatabase.T0(), AppDatabase.U0(), AppDatabase.V0(), AppDatabase.W0(), AppDatabase.X0(), AppDatabase.Z0(), AppDatabase.a1(), AppDatabase.b1(), AppDatabase.c1(), AppDatabase.d1(), AppDatabase.e1(), AppDatabase.f1(), AppDatabase.g1()}).a(new a()).d();
    }

    public final AppDatabase b(Context context) {
        Intrinsics.h(context, "context");
        AppDatabase g0 = AppDatabase.g0();
        if (g0 == null) {
            synchronized (this) {
                g0 = AppDatabase.g0();
                if (g0 == null) {
                    AppDatabase a2 = AppDatabase.p.a(context);
                    AppDatabase.m1(a2);
                    g0 = a2;
                }
            }
        }
        return g0;
    }
}
