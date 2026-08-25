package ga;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import da.b;
import da.h;
import da.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a extends h {
    private final d0 o;
    private final d0 p;
    private final C0047a q;
    private Inflater r;

    /* renamed from: ga.a$a, reason: collision with other inner class name */
    private static final class C0047a {
        private final d0 a = new d0();
        private final int[] b = new int[256];
        private boolean c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;

        /* JADX INFO: Access modifiers changed from: private */
        public void e(d0 d0Var, int i) {
            int G;
            if (i < 4) {
                return;
            }
            d0Var.Q(3);
            int i2 = i - 4;
            if ((d0Var.D() & 128) != 0) {
                if (i2 < 7 || (G = d0Var.G()) < 4) {
                    return;
                }
                this.h = d0Var.J();
                this.i = d0Var.J();
                this.a.L(G - 4);
                i2 = i - 11;
            }
            int e = this.a.e();
            int f = this.a.f();
            if (e >= f || i2 <= 0) {
                return;
            }
            int min = Math.min(i2, f - e);
            d0Var.j(this.a.d(), e, min);
            this.a.P(e + min);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(d0 d0Var, int i) {
            if (i < 19) {
                return;
            }
            this.d = d0Var.J();
            this.e = d0Var.J();
            d0Var.Q(11);
            this.f = d0Var.J();
            this.g = d0Var.J();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(d0 d0Var, int i) {
            if (i % 5 != 2) {
                return;
            }
            d0Var.Q(2);
            Arrays.fill(this.b, 0);
            int i2 = i / 5;
            for (int i3 = 0; i3 < i2; i3++) {
                int D = d0Var.D();
                int D2 = d0Var.D();
                int D3 = d0Var.D();
                int D4 = d0Var.D();
                double d = D2;
                double d2 = D3 - 128;
                double d3 = D4 - 128;
                this.b[D] = (p0.q((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255) << 8) | (d0Var.D() << 24) | (p0.q((int) ((1.402d * d2) + d), 0, 255) << 16) | p0.q((int) (d + (d3 * 1.772d)), 0, 255);
            }
            this.c = true;
        }

        public da.b d() {
            int i;
            if (this.d == 0 || this.e == 0 || this.h == 0 || this.i == 0 || this.a.f() == 0 || this.a.e() != this.a.f() || !this.c) {
                return null;
            }
            this.a.P(0);
            int i2 = this.h * this.i;
            int[] iArr = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                int D = this.a.D();
                if (D != 0) {
                    i = i3 + 1;
                    iArr[i3] = this.b[D];
                } else {
                    int D2 = this.a.D();
                    if (D2 != 0) {
                        i = ((D2 & 64) == 0 ? D2 & 63 : ((D2 & 63) << 8) | this.a.D()) + i3;
                        Arrays.fill(iArr, i3, i, (D2 & 128) == 0 ? 0 : this.b[this.a.D()]);
                    }
                }
                i3 = i;
            }
            return new b.C0042b().f(Bitmap.createBitmap(iArr, this.h, this.i, Bitmap.Config.ARGB_8888)).k(this.f / this.d).l(0).h(this.g / this.e, 0).i(0).n(this.h / this.d).g(this.i / this.e).a();
        }

        public void h() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.a.L(0);
            this.c = false;
        }
    }

    public a() {
        super("PgsDecoder");
        this.o = new d0();
        this.p = new d0();
        this.q = new C0047a();
    }

    private void x(d0 d0Var) {
        if (d0Var.a() <= 0 || d0Var.h() != 120) {
            return;
        }
        if (this.r == null) {
            this.r = new Inflater();
        }
        if (p0.r0(d0Var, this.p, this.r)) {
            d0Var.N(this.p.d(), this.p.f());
        }
    }

    private static da.b y(d0 d0Var, C0047a c0047a) {
        int f = d0Var.f();
        int D = d0Var.D();
        int J = d0Var.J();
        int e = d0Var.e() + J;
        da.b bVar = null;
        if (e > f) {
            d0Var.P(f);
            return null;
        }
        if (D != 128) {
            switch (D) {
                case 20:
                    c0047a.g(d0Var, J);
                    break;
                case 21:
                    c0047a.e(d0Var, J);
                    break;
                case 22:
                    c0047a.f(d0Var, J);
                    break;
            }
        } else {
            bVar = c0047a.d();
            c0047a.h();
        }
        d0Var.P(e);
        return bVar;
    }

    @Override // da.h
    protected i w(byte[] bArr, int i, boolean z) {
        this.o.N(bArr, i);
        x(this.o);
        this.q.h();
        ArrayList arrayList = new ArrayList();
        while (this.o.a() >= 3) {
            da.b y = y(this.o, this.q);
            if (y != null) {
                arrayList.add(y);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
