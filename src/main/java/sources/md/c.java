package md;

import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class c {
    private final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    private int[] b(b bVar) {
        int f = bVar.f();
        if (f == 1) {
            return new int[]{bVar.d(1)};
        }
        int[] iArr = new int[f];
        int i = 0;
        for (int i2 = 1; i2 < this.a.f() && i < f; i2++) {
            if (bVar.c(i2) == 0) {
                iArr[i] = this.a.h(i2);
                i++;
            }
        }
        if (i == f) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int h = this.a.h(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int j = this.a.j(iArr[i3], h);
                    i2 = this.a.j(i2, (j & 1) == 0 ? j | 1 : j & (-2));
                }
            }
            iArr2[i] = this.a.j(bVar.c(h), this.a.h(i2));
            if (this.a.d() != 0) {
                iArr2[i] = this.a.j(iArr2[i], h);
            }
        }
        return iArr2;
    }

    private b[] d(b bVar, b bVar2, int i) {
        if (bVar.f() < bVar2.f()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b g = this.a.g();
        b e = this.a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = e;
            b bVar5 = g;
            g = bVar4;
            if (bVar.f() * 2 < i) {
                int d = g.d(0);
                if (d == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int h = this.a.h(d);
                return new b[]{g.h(h), bVar.h(h)};
            }
            if (bVar.g()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            b g2 = this.a.g();
            int h2 = this.a.h(bVar.d(bVar.f()));
            while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                int f = bVar2.f() - bVar.f();
                int j = this.a.j(bVar2.d(bVar2.f()), h2);
                g2 = g2.a(this.a.b(f, j));
                bVar2 = bVar2.a(bVar.j(f, j));
            }
            e = g2.i(g).a(bVar5);
        } while (bVar2.f() < bVar.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial? r: " + bVar2 + ", rLast: " + bVar);
    }

    public int a(int[] iArr, int i) {
        b bVar = new b(this.a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            a aVar = this.a;
            int c = bVar.c(aVar.c(aVar.d() + i2));
            iArr2[(i - 1) - i2] = c;
            if (c != 0) {
                z = false;
            }
        }
        if (z) {
            return 0;
        }
        b[] d = d(this.a.b(i, 1), new b(this.a, iArr2), i);
        b bVar2 = d[0];
        b bVar3 = d[1];
        int[] b = b(bVar2);
        int[] c2 = c(bVar3, b);
        for (int i3 = 0; i3 < b.length; i3++) {
            int length = (iArr.length - 1) - this.a.i(b[i3]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = a.a(iArr[length], c2[i3]);
        }
        return b.length;
    }
}
