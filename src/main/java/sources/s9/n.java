package s9;

import android.util.Pair;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import java.util.Collections;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class n implements m {
    private static final double[] q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String a;
    private i9.e0 b;
    private final k0 c;
    private final com.google.android.exoplayer2.util.d0 d;
    private final u e;
    private final boolean[] f;
    private final a g;
    private long h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;

    private static final class a {
        private static final byte[] e = {0, 0, 1};
        private boolean a;
        public int b;
        public int c;
        public byte[] d;

        public a(int i) {
            this.d = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i4 = this.b;
                if (length < i4 + i3) {
                    this.d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.d, this.b, i3);
                this.b += i3;
            }
        }

        public boolean b(int i, int i2) {
            if (this.a) {
                int i3 = this.b - i2;
                this.b = i3;
                if (this.c != 0 || i != 181) {
                    this.a = false;
                    return true;
                }
                this.c = i3;
            } else if (i == 179) {
                this.a = true;
            }
            byte[] bArr = e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.a = false;
            this.b = 0;
            this.c = 0;
        }
    }

    public n() {
        this(null);
    }

    n(k0 k0Var) {
        this.c = k0Var;
        this.f = new boolean[4];
        this.g = new a(128);
        if (k0Var != null) {
            this.e = new u(178, 128);
            this.d = new com.google.android.exoplayer2.util.d0();
        } else {
            this.e = null;
            this.d = null;
        }
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair a(a aVar, String str) {
        float f;
        int i;
        float f2;
        int i2;
        long j;
        byte[] copyOf = Arrays.copyOf(aVar.d, aVar.b);
        int i3 = copyOf[4] & 255;
        byte b = copyOf[5];
        int i4 = (i3 << 4) | ((b & 255) >> 4);
        int i5 = ((b & 15) << 8) | (copyOf[6] & 255);
        int i6 = (copyOf[7] & 240) >> 4;
        if (i6 == 2) {
            f = i5 * 4;
            i = i4 * 3;
        } else if (i6 == 3) {
            f = i5 * 16;
            i = i4 * 9;
        } else {
            if (i6 != 4) {
                f2 = 1.0f;
                p1 E = new p1.b().S(str).e0("video/mpeg2").j0(i4).Q(i5).a0(f2).T(Collections.singletonList(copyOf)).E();
                i2 = (copyOf[7] & 15) - 1;
                if (i2 >= 0) {
                    double[] dArr = q;
                    if (i2 < dArr.length) {
                        double d = dArr[i2];
                        byte b2 = copyOf[aVar.c + 9];
                        int i7 = (b2 & 96) >> 5;
                        if (i7 != (b2 & 31)) {
                            d *= (i7 + 1.0d) / (r8 + 1);
                        }
                        j = (long) (1000000.0d / d);
                        return Pair.create(E, Long.valueOf(j));
                    }
                }
                j = 0;
                return Pair.create(E, Long.valueOf(j));
            }
            f = i5 * 121;
            i = i4 * 100;
        }
        f2 = f / i;
        p1 E2 = new p1.b().S(str).e0("video/mpeg2").j0(i4).Q(i5).a0(f2).T(Collections.singletonList(copyOf)).E();
        i2 = (copyOf[7] & 15) - 1;
        if (i2 >= 0) {
        }
        j = 0;
        return Pair.create(E2, Long.valueOf(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c  */
    @Override // s9.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        int i;
        long j;
        boolean z;
        int i2;
        com.google.android.exoplayer2.util.a.i(this.b);
        int e = d0Var.e();
        int f = d0Var.f();
        byte[] d = d0Var.d();
        this.h += d0Var.a();
        this.b.c(d0Var, d0Var.a());
        while (true) {
            int c = com.google.android.exoplayer2.util.x.c(d, e, f, this.f);
            if (c == f) {
                break;
            }
            int i3 = c + 3;
            int i4 = d0Var.d()[i3] & 255;
            int i5 = c - e;
            if (!this.j) {
                if (i5 > 0) {
                    this.g.a(d, e, c);
                }
                if (this.g.b(i4, i5 < 0 ? -i5 : 0)) {
                    Pair a2 = a(this.g, (String) com.google.android.exoplayer2.util.a.e(this.a));
                    this.b.d((p1) a2.first);
                    this.k = ((Long) a2.second).longValue();
                    this.j = true;
                }
            }
            u uVar = this.e;
            if (uVar != null) {
                if (i5 > 0) {
                    uVar.a(d, e, c);
                    i2 = 0;
                } else {
                    i2 = -i5;
                }
                if (this.e.b(i2)) {
                    u uVar2 = this.e;
                    ((com.google.android.exoplayer2.util.d0) p0.j(this.d)).N(this.e.d, com.google.android.exoplayer2.util.x.q(uVar2.d, uVar2.e));
                    ((k0) p0.j(this.c)).a(this.n, this.d);
                }
                if (i4 == 178 && d0Var.d()[c + 2] == 1) {
                    this.e.e(i4);
                }
            }
            if (i4 == 0 || i4 == 179) {
                int i6 = f - c;
                if (this.p && this.j) {
                    long j2 = this.n;
                    if (j2 != -9223372036854775807L) {
                        i = i4;
                        this.b.e(j2, this.o ? 1 : 0, ((int) (this.h - this.m)) - i6, i6, null);
                        if (this.i || this.p) {
                            this.m = this.h - i6;
                            j = this.l;
                            if (j == -9223372036854775807L) {
                                long j3 = this.n;
                                j = j3 != -9223372036854775807L ? j3 + this.k : -9223372036854775807L;
                            }
                            this.n = j;
                            this.o = false;
                            this.l = -9223372036854775807L;
                            z = true;
                            this.i = true;
                        } else {
                            z = true;
                        }
                        this.p = i == 0 ? z : false;
                    }
                }
                i = i4;
                if (this.i) {
                }
                this.m = this.h - i6;
                j = this.l;
                if (j == -9223372036854775807L) {
                }
                this.n = j;
                this.o = false;
                this.l = -9223372036854775807L;
                z = true;
                this.i = true;
                this.p = i == 0 ? z : false;
            } else if (i4 == 184) {
                this.o = true;
            }
            e = i3;
        }
        if (!this.j) {
            this.g.a(d, e, f);
        }
        u uVar3 = this.e;
        if (uVar3 != null) {
            uVar3.a(d, e, f);
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        this.l = j;
    }

    @Override // s9.m
    public void d(i9.n nVar, i0.d dVar) {
        dVar.a();
        this.a = dVar.b();
        this.b = nVar.track(dVar.c(), 2);
        k0 k0Var = this.c;
        if (k0Var != null) {
            k0Var.b(nVar, dVar);
        }
    }

    @Override // s9.m
    public void packetFinished() {
    }

    @Override // s9.m
    public void seek() {
        com.google.android.exoplayer2.util.x.a(this.f);
        this.g.c();
        u uVar = this.e;
        if (uVar != null) {
            uVar.d();
        }
        this.h = 0L;
        this.i = false;
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }
}
