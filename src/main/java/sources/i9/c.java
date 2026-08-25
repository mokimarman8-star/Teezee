package i9;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class c {
    public static void a(long j, com.google.android.exoplayer2.util.d0 d0Var, e0[] e0VarArr) {
        while (true) {
            if (d0Var.a() <= 1) {
                return;
            }
            int c = c(d0Var);
            int c2 = c(d0Var);
            int e = d0Var.e() + c2;
            if (c2 == -1 || c2 > d0Var.a()) {
                com.google.android.exoplayer2.util.s.i("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                e = d0Var.f();
            } else if (c == 4 && c2 >= 8) {
                int D = d0Var.D();
                int J = d0Var.J();
                int n = J == 49 ? d0Var.n() : 0;
                int D2 = d0Var.D();
                if (J == 47) {
                    d0Var.Q(1);
                }
                boolean z = D == 181 && (J == 49 || J == 47) && D2 == 3;
                if (J == 49) {
                    z &= n == 1195456820;
                }
                if (z) {
                    b(j, d0Var, e0VarArr);
                }
            }
            d0Var.P(e);
        }
    }

    public static void b(long j, com.google.android.exoplayer2.util.d0 d0Var, e0[] e0VarArr) {
        int D = d0Var.D();
        if ((D & 64) != 0) {
            d0Var.Q(1);
            int i = (D & 31) * 3;
            int e = d0Var.e();
            for (e0 e0Var : e0VarArr) {
                d0Var.P(e);
                e0Var.c(d0Var, i);
                if (j != -9223372036854775807L) {
                    e0Var.e(j, 1, i, 0, null);
                }
            }
        }
    }

    private static int c(com.google.android.exoplayer2.util.d0 d0Var) {
        int i = 0;
        while (d0Var.a() != 0) {
            int D = d0Var.D();
            i += D;
            if (D != 255) {
                return i;
            }
        }
        return -1;
    }
}
