package s9;

import com.google.android.exoplayer2.util.l0;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class w implements i0 {
    private final m a;
    private final com.google.android.exoplayer2.util.c0 b = new com.google.android.exoplayer2.util.c0(new byte[10]);
    private int c = 0;
    private int d;
    private l0 e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public w(m mVar) {
        this.a = mVar;
    }

    private boolean c(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i) {
        int min = Math.min(d0Var.a(), i - this.d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            d0Var.Q(min);
        } else {
            d0Var.j(bArr, this.d, min);
        }
        int i2 = this.d + min;
        this.d = i2;
        return i2 == i;
    }

    private boolean d() {
        this.b.p(0);
        int h = this.b.h(24);
        if (h != 1) {
            com.google.android.exoplayer2.util.s.i("PesReader", "Unexpected start code prefix: " + h);
            this.j = -1;
            return false;
        }
        this.b.r(8);
        int h2 = this.b.h(16);
        this.b.r(5);
        this.k = this.b.g();
        this.b.r(2);
        this.f = this.b.g();
        this.g = this.b.g();
        this.b.r(6);
        int h3 = this.b.h(8);
        this.i = h3;
        if (h2 == 0) {
            this.j = -1;
        } else {
            int i = (h2 - 3) - h3;
            this.j = i;
            if (i < 0) {
                com.google.android.exoplayer2.util.s.i("PesReader", "Found negative packet payload size: " + this.j);
                this.j = -1;
            }
        }
        return true;
    }

    private void e() {
        this.b.p(0);
        this.l = -9223372036854775807L;
        if (this.f) {
            this.b.r(4);
            this.b.r(1);
            this.b.r(1);
            long h = (this.b.h(3) << 30) | (this.b.h(15) << 15) | this.b.h(15);
            this.b.r(1);
            if (!this.h && this.g) {
                this.b.r(4);
                this.b.r(1);
                this.b.r(1);
                this.b.r(1);
                this.e.b((this.b.h(3) << 30) | (this.b.h(15) << 15) | this.b.h(15));
                this.h = true;
            }
            this.l = this.e.b(h);
        }
    }

    private void f(int i) {
        this.c = i;
        this.d = 0;
    }

    @Override // s9.i0
    public void a(l0 l0Var, i9.n nVar, i0.d dVar) {
        this.e = l0Var;
        this.a.d(nVar, dVar);
    }

    @Override // s9.i0
    public final void b(com.google.android.exoplayer2.util.d0 d0Var, int i) {
        com.google.android.exoplayer2.util.a.i(this.e);
        if ((i & 1) != 0) {
            int i2 = this.c;
            if (i2 != 0 && i2 != 1) {
                if (i2 == 2) {
                    com.google.android.exoplayer2.util.s.i("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.j != -1) {
                        com.google.android.exoplayer2.util.s.i("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                    }
                    this.a.packetFinished();
                }
            }
            f(1);
        }
        while (d0Var.a() > 0) {
            int i3 = this.c;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (c(d0Var, this.b.a, Math.min(10, this.i)) && c(d0Var, null, this.i)) {
                            e();
                            i |= this.k ? 4 : 0;
                            this.a.c(this.l, i);
                            f(3);
                        }
                    } else {
                        if (i3 != 3) {
                            throw new IllegalStateException();
                        }
                        int a = d0Var.a();
                        int i4 = this.j;
                        int i5 = i4 != -1 ? a - i4 : 0;
                        if (i5 > 0) {
                            a -= i5;
                            d0Var.O(d0Var.e() + a);
                        }
                        this.a.b(d0Var);
                        int i6 = this.j;
                        if (i6 != -1) {
                            int i7 = i6 - a;
                            this.j = i7;
                            if (i7 == 0) {
                                this.a.packetFinished();
                                f(1);
                            }
                        }
                    }
                } else if (c(d0Var, this.b.a, 9)) {
                    f(d() ? 2 : 0);
                }
            } else {
                d0Var.Q(d0Var.a());
            }
        }
    }

    @Override // s9.i0
    public final void seek() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.seek();
    }
}
