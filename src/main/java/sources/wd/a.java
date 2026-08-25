package wd;

import com.google.zxing.ChecksumException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a {
    private final b a = b.f;

    private int[] b(c cVar) {
        int d = cVar.d();
        int[] iArr = new int[d];
        int i = 0;
        for (int i2 = 1; i2 < this.a.e() && i < d; i2++) {
            if (cVar.b(i2) == 0) {
                iArr[i] = this.a.g(i2);
                i++;
            }
        }
        if (i == d) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] c(c cVar, c cVar2, int[] iArr) {
        int d = cVar2.d();
        if (d < 1) {
            return new int[0];
        }
        int[] iArr2 = new int[d];
        for (int i = 1; i <= d; i++) {
            iArr2[d - i] = this.a.i(i, cVar2.c(i));
        }
        c cVar3 = new c(this.a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int g = this.a.g(iArr[i2]);
            iArr3[i2] = this.a.i(this.a.j(0, cVar.b(g)), this.a.g(cVar3.b(g)));
        }
        return iArr3;
    }

    private c[] d(c cVar, c cVar2, int i) {
        if (cVar.d() < cVar2.d()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c f = this.a.f();
        c d = this.a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = d;
            c cVar5 = f;
            f = cVar4;
            if (cVar.d() < i / 2) {
                int c = f.c(0);
                if (c == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int g = this.a.g(c);
                return new c[]{f.f(g), cVar.f(g)};
            }
            if (cVar.e()) {
                throw ChecksumException.getChecksumInstance();
            }
            c f2 = this.a.f();
            int g2 = this.a.g(cVar.c(cVar.d()));
            while (cVar2.d() >= cVar.d() && !cVar2.e()) {
                int d2 = cVar2.d() - cVar.d();
                int i2 = this.a.i(cVar2.c(cVar2.d()), g2);
                f2 = f2.a(this.a.b(d2, i2));
                cVar2 = cVar2.j(cVar.h(d2, i2));
            }
            d = f2.g(f).j(cVar5).i();
        }
    }

    public int a(int[] iArr, int i, int[] iArr2) {
        c cVar = new c(this.a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int b = cVar.b(this.a.c(i2));
            iArr3[i - i2] = b;
            if (b != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        c d = this.a.d();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int c = this.a.c((iArr.length - 1) - i3);
                b bVar = this.a;
                d = d.g(new c(bVar, new int[]{bVar.j(0, c), 1}));
            }
        }
        c[] d2 = d(this.a.b(i, 1), new c(this.a, iArr3), i);
        c cVar2 = d2[0];
        c cVar3 = d2[1];
        int[] b2 = b(cVar2);
        int[] c2 = c(cVar3, cVar2, b2);
        for (int i4 = 0; i4 < b2.length; i4++) {
            int length = (iArr.length - 1) - this.a.h(b2[i4]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.a.j(iArr[length], c2[i4]);
        }
        return b2.length;
    }
}
