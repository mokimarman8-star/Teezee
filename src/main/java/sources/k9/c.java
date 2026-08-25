package k9;

import com.google.android.exoplayer2.util.d0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class c implements a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    private c(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static c b(d0 d0Var) {
        int q = d0Var.q();
        d0Var.Q(8);
        int q2 = d0Var.q();
        int q3 = d0Var.q();
        d0Var.Q(4);
        int q4 = d0Var.q();
        d0Var.Q(12);
        return new c(q, q2, q3, q4);
    }

    public boolean a() {
        return (this.b & 16) == 16;
    }

    @Override // k9.a
    public int getType() {
        return 1751742049;
    }
}
