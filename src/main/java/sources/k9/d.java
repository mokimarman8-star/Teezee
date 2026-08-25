package k9;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class d implements a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    private d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public static d c(d0 d0Var) {
        int q = d0Var.q();
        d0Var.Q(12);
        int q2 = d0Var.q();
        int q3 = d0Var.q();
        int q4 = d0Var.q();
        d0Var.Q(4);
        int q5 = d0Var.q();
        int q6 = d0Var.q();
        d0Var.Q(8);
        return new d(q, q2, q3, q4, q5, q6);
    }

    public long a() {
        return p0.N0(this.e, this.c * 1000000, this.d);
    }

    public int b() {
        int i = this.a;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        s.i("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.a));
        return -1;
    }

    @Override // k9.a
    public int getType() {
        return 1752331379;
    }
}
