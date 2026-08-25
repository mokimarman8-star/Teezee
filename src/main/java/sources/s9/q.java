package s9;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import java.util.Collections;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class q implements m {
    private final d0 a;
    private String b;
    private i9.e0 c;
    private a d;
    private boolean e;
    private long l;
    private final boolean[] f = new boolean[3];
    private final u g = new u(32, 128);
    private final u h = new u(33, 128);
    private final u i = new u(34, 128);
    private final u j = new u(39, 128);
    private final u k = new u(40, 128);
    private long m = -9223372036854775807L;
    private final com.google.android.exoplayer2.util.d0 n = new com.google.android.exoplayer2.util.d0();

    private static final class a {
        private final i9.e0 a;
        private long b;
        private boolean c;
        private int d;
        private long e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private long k;
        private long l;
        private boolean m;

        public a(i9.e0 e0Var) {
            this.a = e0Var;
        }

        private static boolean b(int i) {
            return (32 <= i && i <= 35) || i == 39;
        }

        private static boolean c(int i) {
            return i < 32 || i == 40;
        }

        private void d(int i) {
            long j = this.l;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z = this.m;
            this.a.e(j, z ? 1 : 0, (int) (this.b - this.k), i, null);
        }

        public void a(long j, int i, boolean z) {
            if (this.j && this.g) {
                this.m = this.c;
                this.j = false;
            } else if (this.h || this.g) {
                if (z && this.i) {
                    d(i + ((int) (j - this.b)));
                }
                this.k = this.b;
                this.l = this.e;
                this.m = this.c;
                this.i = true;
            }
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.f) {
                int i3 = this.d;
                int i4 = (i + 2) - i3;
                if (i4 >= i2) {
                    this.d = i3 + (i2 - i);
                } else {
                    this.g = (bArr[i4] & 128) != 0;
                    this.f = false;
                }
            }
        }

        public void f() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public void g(long j, int i, int i2, long j2, boolean z) {
            this.g = false;
            this.h = false;
            this.e = j2;
            this.d = 0;
            this.b = j;
            if (!c(i2)) {
                if (this.i && !this.j) {
                    if (z) {
                        d(i);
                    }
                    this.i = false;
                }
                if (b(i2)) {
                    this.h = !this.j;
                    this.j = true;
                }
            }
            boolean z2 = i2 >= 16 && i2 <= 21;
            this.c = z2;
            this.f = z2 || i2 <= 9;
        }
    }

    public q(d0 d0Var) {
        this.a = d0Var;
    }

    private void a() {
        com.google.android.exoplayer2.util.a.i(this.c);
        p0.j(this.d);
    }

    private void e(long j, int i, int i2, long j2) {
        this.d.a(j, i, this.e);
        if (!this.e) {
            this.g.b(i2);
            this.h.b(i2);
            this.i.b(i2);
            if (this.g.c() && this.h.c() && this.i.c()) {
                this.c.d(g(this.b, this.g, this.h, this.i));
                this.e = true;
            }
        }
        if (this.j.b(i2)) {
            u uVar = this.j;
            this.n.N(this.j.d, com.google.android.exoplayer2.util.x.q(uVar.d, uVar.e));
            this.n.Q(5);
            this.a.a(j2, this.n);
        }
        if (this.k.b(i2)) {
            u uVar2 = this.k;
            this.n.N(this.k.d, com.google.android.exoplayer2.util.x.q(uVar2.d, uVar2.e));
            this.n.Q(5);
            this.a.a(j2, this.n);
        }
    }

    private void f(byte[] bArr, int i, int i2) {
        this.d.e(bArr, i, i2);
        if (!this.e) {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    private static p1 g(String str, u uVar, u uVar2, u uVar3) {
        int i = uVar.e;
        byte[] bArr = new byte[uVar2.e + i + uVar3.e];
        int i2 = 0;
        System.arraycopy(uVar.d, 0, bArr, 0, i);
        System.arraycopy(uVar2.d, 0, bArr, uVar.e, uVar2.e);
        System.arraycopy(uVar3.d, 0, bArr, uVar.e + uVar2.e, uVar3.e);
        com.google.android.exoplayer2.util.e0 e0Var = new com.google.android.exoplayer2.util.e0(uVar2.d, 0, uVar2.e);
        e0Var.l(44);
        int e = e0Var.e(3);
        e0Var.k();
        int e2 = e0Var.e(2);
        boolean d = e0Var.d();
        int e3 = e0Var.e(5);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            if (e0Var.d()) {
                i3 |= 1 << i4;
            }
            i4++;
        }
        int[] iArr = new int[6];
        for (int i5 = 0; i5 < 6; i5++) {
            iArr[i5] = e0Var.e(8);
        }
        int e4 = e0Var.e(8);
        for (int i6 = 0; i6 < e; i6++) {
            if (e0Var.d()) {
                i2 += 89;
            }
            if (e0Var.d()) {
                i2 += 8;
            }
        }
        e0Var.l(i2);
        if (e > 0) {
            e0Var.l((8 - e) * 2);
        }
        e0Var.h();
        int h = e0Var.h();
        if (h == 3) {
            e0Var.k();
        }
        int h2 = e0Var.h();
        int h3 = e0Var.h();
        if (e0Var.d()) {
            int h4 = e0Var.h();
            int h5 = e0Var.h();
            int h6 = e0Var.h();
            int h7 = e0Var.h();
            h2 -= ((h == 1 || h == 2) ? 2 : 1) * (h4 + h5);
            h3 -= (h == 1 ? 2 : 1) * (h6 + h7);
        }
        e0Var.h();
        e0Var.h();
        int h10 = e0Var.h();
        for (int i7 = e0Var.d() ? 0 : e; i7 <= e; i7++) {
            e0Var.h();
            e0Var.h();
            e0Var.h();
        }
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        if (e0Var.d() && e0Var.d()) {
            h(e0Var);
        }
        e0Var.l(2);
        if (e0Var.d()) {
            e0Var.l(8);
            e0Var.h();
            e0Var.h();
            e0Var.k();
        }
        i(e0Var);
        if (e0Var.d()) {
            for (int i10 = 0; i10 < e0Var.h(); i10++) {
                e0Var.l(h10 + 5);
            }
        }
        e0Var.l(2);
        float f = 1.0f;
        if (e0Var.d()) {
            if (e0Var.d()) {
                int e5 = e0Var.e(8);
                if (e5 == 255) {
                    int e6 = e0Var.e(16);
                    int e7 = e0Var.e(16);
                    if (e6 != 0 && e7 != 0) {
                        f = e6 / e7;
                    }
                } else {
                    float[] fArr = com.google.android.exoplayer2.util.x.b;
                    if (e5 < fArr.length) {
                        f = fArr[e5];
                    } else {
                        com.google.android.exoplayer2.util.s.i("H265Reader", "Unexpected aspect_ratio_idc value: " + e5);
                    }
                }
            }
            if (e0Var.d()) {
                e0Var.k();
            }
            if (e0Var.d()) {
                e0Var.l(4);
                if (e0Var.d()) {
                    e0Var.l(24);
                }
            }
            if (e0Var.d()) {
                e0Var.h();
                e0Var.h();
            }
            e0Var.k();
            if (e0Var.d()) {
                h3 *= 2;
            }
        }
        return new p1.b().S(str).e0("video/hevc").I(com.google.android.exoplayer2.util.f.c(e2, d, e3, i3, iArr, e4)).j0(h2).Q(h3).a0(f).T(Collections.singletonList(bArr)).E();
    }

    private static void h(com.google.android.exoplayer2.util.e0 e0Var) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (e0Var.d()) {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        e0Var.g();
                    }
                    for (int i4 = 0; i4 < min; i4++) {
                        e0Var.g();
                    }
                } else {
                    e0Var.h();
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    private static void i(com.google.android.exoplayer2.util.e0 e0Var) {
        int h = e0Var.h();
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < h; i2++) {
            if (i2 != 0) {
                z = e0Var.d();
            }
            if (z) {
                e0Var.k();
                e0Var.h();
                for (int i3 = 0; i3 <= i; i3++) {
                    if (e0Var.d()) {
                        e0Var.k();
                    }
                }
            } else {
                int h2 = e0Var.h();
                int h3 = e0Var.h();
                int i4 = h2 + h3;
                for (int i5 = 0; i5 < h2; i5++) {
                    e0Var.h();
                    e0Var.k();
                }
                for (int i6 = 0; i6 < h3; i6++) {
                    e0Var.h();
                    e0Var.k();
                }
                i = i4;
            }
        }
    }

    private void j(long j, int i, int i2, long j2) {
        this.d.g(j, i, i2, j2, this.e);
        if (!this.e) {
            this.g.e(i2);
            this.h.e(i2);
            this.i.e(i2);
        }
        this.j.e(i2);
        this.k.e(i2);
    }

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        a();
        while (d0Var.a() > 0) {
            int e = d0Var.e();
            int f = d0Var.f();
            byte[] d = d0Var.d();
            this.l += d0Var.a();
            this.c.c(d0Var, d0Var.a());
            while (e < f) {
                int c = com.google.android.exoplayer2.util.x.c(d, e, f, this.f);
                if (c == f) {
                    f(d, e, f);
                    return;
                }
                int e2 = com.google.android.exoplayer2.util.x.e(d, c);
                int i = c - e;
                if (i > 0) {
                    f(d, e, c);
                }
                int i2 = f - c;
                long j = this.l - i2;
                e(j, i2, i < 0 ? -i : 0, this.m);
                j(j, i2, e2, this.m);
                e = c + 3;
            }
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }

    @Override // s9.m
    public void d(i9.n nVar, i0.d dVar) {
        dVar.a();
        this.b = dVar.b();
        i9.e0 track = nVar.track(dVar.c(), 2);
        this.c = track;
        this.d = new a(track);
        this.a.b(nVar, dVar);
    }

    @Override // s9.m
    public void packetFinished() {
    }

    @Override // s9.m
    public void seek() {
        this.l = 0L;
        this.m = -9223372036854775807L;
        com.google.android.exoplayer2.util.x.a(this.f);
        this.g.d();
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        a aVar = this.d;
        if (aVar != null) {
            aVar.f();
        }
    }
}
