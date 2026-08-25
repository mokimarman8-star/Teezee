package s9;

import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c0 implements i0 {
    private final b0 a;
    private final com.google.android.exoplayer2.util.d0 b = new com.google.android.exoplayer2.util.d0(32);
    private int c;
    private int d;
    private boolean e;
    private boolean f;

    public c0(b0 b0Var) {
        this.a = b0Var;
    }

    @Override // s9.i0
    public void a(l0 l0Var, i9.n nVar, i0.d dVar) {
        this.a.a(l0Var, nVar, dVar);
        this.f = true;
    }

    @Override // s9.i0
    public void b(com.google.android.exoplayer2.util.d0 d0Var, int i) {
        boolean z = (i & 1) != 0;
        int e = z ? d0Var.e() + d0Var.D() : -1;
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            d0Var.P(e);
            this.d = 0;
        }
        while (d0Var.a() > 0) {
            int i2 = this.d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int D = d0Var.D();
                    d0Var.P(d0Var.e() - 1);
                    if (D == 255) {
                        this.f = true;
                        return;
                    }
                }
                int min = Math.min(d0Var.a(), 3 - this.d);
                d0Var.j(this.b.d(), this.d, min);
                int i3 = this.d + min;
                this.d = i3;
                if (i3 == 3) {
                    this.b.P(0);
                    this.b.O(3);
                    this.b.Q(1);
                    int D2 = this.b.D();
                    int D3 = this.b.D();
                    this.e = (D2 & 128) != 0;
                    this.c = (((D2 & 15) << 8) | D3) + 3;
                    int b = this.b.b();
                    int i4 = this.c;
                    if (b < i4) {
                        this.b.c(Math.min(4098, Math.max(i4, this.b.b() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(d0Var.a(), this.c - this.d);
                d0Var.j(this.b.d(), this.d, min2);
                int i5 = this.d + min2;
                this.d = i5;
                int i6 = this.c;
                if (i5 != i6) {
                    continue;
                } else {
                    if (!this.e) {
                        this.b.O(i6);
                    } else {
                        if (p0.t(this.b.d(), 0, this.c, -1) != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.O(this.c - 4);
                    }
                    this.b.P(0);
                    this.a.b(this.b);
                    this.d = 0;
                }
            }
        }
    }

    @Override // s9.i0
    public void seek() {
        this.f = true;
    }
}
