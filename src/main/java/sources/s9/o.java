package s9;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import java.util.Collections;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class o implements m {
    private static final float[] l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final k0 a;
    private final com.google.android.exoplayer2.util.d0 b;
    private final boolean[] c;
    private final a d;
    private final u e;
    private b f;
    private long g;
    private String h;
    private i9.e0 i;
    private boolean j;
    private long k;

    private static final class a {
        private static final byte[] f = {0, 0, 1};
        private boolean a;
        private int b;
        public int c;
        public int d;
        public byte[] e;

        public a(int i) {
            this.e = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.e;
                int length = bArr2.length;
                int i4 = this.c;
                if (length < i4 + i3) {
                    this.e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.e, this.c, i3);
                this.c += i3;
            }
        }

        public boolean b(int i, int i2) {
            int i3 = this.b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i == 179 || i == 181) {
                                this.c -= i2;
                                this.a = false;
                                return true;
                            }
                        } else if ((i & 240) != 32) {
                            com.google.android.exoplayer2.util.s.i("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.d = this.c;
                            this.b = 4;
                        }
                    } else if (i > 31) {
                        com.google.android.exoplayer2.util.s.i("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.b = 3;
                    }
                } else if (i != 181) {
                    com.google.android.exoplayer2.util.s.i("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.b = 2;
                }
            } else if (i == 176) {
                this.b = 1;
                this.a = true;
            }
            byte[] bArr = f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.a = false;
            this.c = 0;
            this.b = 0;
        }
    }

    private static final class b {
        private final i9.e0 a;
        private boolean b;
        private boolean c;
        private boolean d;
        private int e;
        private int f;
        private long g;
        private long h;

        public b(i9.e0 e0Var) {
            this.a = e0Var;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.c) {
                int i3 = this.f;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.f = i3 + (i2 - i);
                } else {
                    this.d = ((bArr[i4] & 192) >> 6) == 0;
                    this.c = false;
                }
            }
        }

        public void b(long j, int i, boolean z) {
            if (this.e == 182 && z && this.b) {
                long j2 = this.h;
                if (j2 != -9223372036854775807L) {
                    this.a.e(j2, this.d ? 1 : 0, (int) (j - this.g), i, null);
                }
            }
            if (this.e != 179) {
                this.g = j;
            }
        }

        public void c(int i, long j) {
            this.e = i;
            this.d = false;
            this.b = i == 182 || i == 179;
            this.c = i == 182;
            this.f = 0;
            this.h = j;
        }

        public void d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = -1;
        }
    }

    public o() {
        this(null);
    }

    o(k0 k0Var) {
        this.a = k0Var;
        this.c = new boolean[4];
        this.d = new a(128);
        this.k = -9223372036854775807L;
        if (k0Var != null) {
            this.e = new u(178, 128);
            this.b = new com.google.android.exoplayer2.util.d0();
        } else {
            this.e = null;
            this.b = null;
        }
    }

    private static p1 a(a aVar, int i, String str) {
        byte[] copyOf = Arrays.copyOf(aVar.e, aVar.c);
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(copyOf);
        c0Var.s(i);
        c0Var.s(4);
        c0Var.q();
        c0Var.r(8);
        if (c0Var.g()) {
            c0Var.r(4);
            c0Var.r(3);
        }
        int h = c0Var.h(4);
        float f = 1.0f;
        if (h == 15) {
            int h2 = c0Var.h(8);
            int h3 = c0Var.h(8);
            if (h3 == 0) {
                com.google.android.exoplayer2.util.s.i("H263Reader", "Invalid aspect ratio");
            } else {
                f = h2 / h3;
            }
        } else {
            float[] fArr = l;
            if (h < fArr.length) {
                f = fArr[h];
            } else {
                com.google.android.exoplayer2.util.s.i("H263Reader", "Invalid aspect ratio");
            }
        }
        if (c0Var.g()) {
            c0Var.r(2);
            c0Var.r(1);
            if (c0Var.g()) {
                c0Var.r(15);
                c0Var.q();
                c0Var.r(15);
                c0Var.q();
                c0Var.r(15);
                c0Var.q();
                c0Var.r(3);
                c0Var.r(11);
                c0Var.q();
                c0Var.r(15);
                c0Var.q();
            }
        }
        if (c0Var.h(2) != 0) {
            com.google.android.exoplayer2.util.s.i("H263Reader", "Unhandled video object layer shape");
        }
        c0Var.q();
        int h4 = c0Var.h(16);
        c0Var.q();
        if (c0Var.g()) {
            if (h4 == 0) {
                com.google.android.exoplayer2.util.s.i("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i2 = 0;
                for (int i3 = h4 - 1; i3 > 0; i3 >>= 1) {
                    i2++;
                }
                c0Var.r(i2);
            }
        }
        c0Var.q();
        int h5 = c0Var.h(13);
        c0Var.q();
        int h6 = c0Var.h(13);
        c0Var.q();
        c0Var.q();
        return new p1.b().S(str).e0("video/mp4v-es").j0(h5).Q(h6).a0(f).T(Collections.singletonList(copyOf)).E();
    }

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.f);
        com.google.android.exoplayer2.util.a.i(this.i);
        int e = d0Var.e();
        int f = d0Var.f();
        byte[] d = d0Var.d();
        this.g += d0Var.a();
        this.i.c(d0Var, d0Var.a());
        while (true) {
            int c = com.google.android.exoplayer2.util.x.c(d, e, f, this.c);
            if (c == f) {
                break;
            }
            int i = c + 3;
            int i2 = d0Var.d()[i] & 255;
            int i3 = c - e;
            int i4 = 0;
            if (!this.j) {
                if (i3 > 0) {
                    this.d.a(d, e, c);
                }
                if (this.d.b(i2, i3 < 0 ? -i3 : 0)) {
                    i9.e0 e0Var = this.i;
                    a aVar = this.d;
                    e0Var.d(a(aVar, aVar.d, (String) com.google.android.exoplayer2.util.a.e(this.h)));
                    this.j = true;
                }
            }
            this.f.a(d, e, c);
            u uVar = this.e;
            if (uVar != null) {
                if (i3 > 0) {
                    uVar.a(d, e, c);
                } else {
                    i4 = -i3;
                }
                if (this.e.b(i4)) {
                    u uVar2 = this.e;
                    ((com.google.android.exoplayer2.util.d0) p0.j(this.b)).N(this.e.d, com.google.android.exoplayer2.util.x.q(uVar2.d, uVar2.e));
                    ((k0) p0.j(this.a)).a(this.k, this.b);
                }
                if (i2 == 178 && d0Var.d()[c + 2] == 1) {
                    this.e.e(i2);
                }
            }
            int i5 = f - c;
            this.f.b(this.g - i5, i5, this.j);
            this.f.c(i2, this.k);
            e = i;
        }
        if (!this.j) {
            this.d.a(d, e, f);
        }
        this.f.a(d, e, f);
        u uVar3 = this.e;
        if (uVar3 != null) {
            uVar3.a(d, e, f);
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // s9.m
    public void d(i9.n nVar, i0.d dVar) {
        dVar.a();
        this.h = dVar.b();
        i9.e0 track = nVar.track(dVar.c(), 2);
        this.i = track;
        this.f = new b(track);
        k0 k0Var = this.a;
        if (k0Var != null) {
            k0Var.b(nVar, dVar);
        }
    }

    @Override // s9.m
    public void packetFinished() {
    }

    @Override // s9.m
    public void seek() {
        com.google.android.exoplayer2.util.x.a(this.c);
        this.d.c();
        b bVar = this.f;
        if (bVar != null) {
            bVar.d();
        }
        u uVar = this.e;
        if (uVar != null) {
            uVar.d();
        }
        this.g = 0L;
        this.k = -9223372036854775807L;
    }
}
