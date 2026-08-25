package ld;

import com.google.zxing.NotFoundException;
import com.google.zxing.k;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    private final kd.b a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public b(kd.b bVar) {
        this(bVar, 10, bVar.n() / 2, bVar.k() / 2);
    }

    public b(kd.b bVar, int i, int i2, int i3) {
        this.a = bVar;
        int k = bVar.k();
        this.b = k;
        int n = bVar.n();
        this.c = n;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.d = i5;
        int i6 = i2 + i4;
        this.e = i6;
        int i7 = i3 - i4;
        this.g = i7;
        int i8 = i3 + i4;
        this.f = i8;
        if (i7 < 0 || i5 < 0 || i8 >= k || i6 >= n) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private k[] a(k kVar, k kVar2, k kVar3, k kVar4) {
        float c = kVar.c();
        float d = kVar.d();
        float c2 = kVar2.c();
        float d2 = kVar2.d();
        float c3 = kVar3.c();
        float d3 = kVar3.d();
        float c4 = kVar4.c();
        float d4 = kVar4.d();
        return c < ((float) this.c) / 2.0f ? new k[]{new k(c4 - 1.0f, d4 + 1.0f), new k(c2 + 1.0f, d2 + 1.0f), new k(c3 - 1.0f, d3 - 1.0f), new k(c + 1.0f, d - 1.0f)} : new k[]{new k(c4 + 1.0f, d4 + 1.0f), new k(c2 + 1.0f, d2 - 1.0f), new k(c3 - 1.0f, d3 + 1.0f), new k(c - 1.0f, d - 1.0f)};
    }

    private boolean b(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.a.h(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.a.h(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private k d(float f, float f2, float f3, float f4) {
        int c = a.c(a.a(f, f2, f3, f4));
        float f5 = c;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < c; i++) {
            float f8 = i;
            int c2 = a.c((f8 * f6) + f);
            int c3 = a.c((f8 * f7) + f2);
            if (this.a.h(c2, c3)) {
                return new k(c2, c3);
            }
        }
        return null;
    }

    public k[] c() {
        int i = this.d;
        int i2 = this.e;
        int i3 = this.g;
        int i4 = this.f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = true;
        while (z6) {
            boolean z7 = false;
            boolean z8 = true;
            while (true) {
                if ((z8 || !z2) && i2 < this.c) {
                    z8 = b(i3, i4, i2, false);
                    if (z8) {
                        i2++;
                        z2 = true;
                        z7 = true;
                    } else if (!z2) {
                        i2++;
                    }
                }
            }
            if (i2 < this.c) {
                boolean z9 = true;
                while (true) {
                    if ((z9 || !z3) && i4 < this.b) {
                        z9 = b(i, i2, i4, true);
                        if (z9) {
                            i4++;
                            z3 = true;
                            z7 = true;
                        } else if (!z3) {
                            i4++;
                        }
                    }
                }
                if (i4 < this.b) {
                    boolean z10 = true;
                    while (true) {
                        if ((z10 || !z4) && i >= 0) {
                            z10 = b(i3, i4, i, false);
                            if (z10) {
                                i--;
                                z4 = true;
                                z7 = true;
                            } else if (!z4) {
                                i--;
                            }
                        }
                    }
                    if (i >= 0) {
                        z6 = z7;
                        boolean z11 = true;
                        while (true) {
                            if ((z11 || !z5) && i3 >= 0) {
                                z11 = b(i, i2, i3, true);
                                if (z11) {
                                    i3--;
                                    z6 = true;
                                    z5 = true;
                                } else if (!z5) {
                                    i3--;
                                }
                            }
                        }
                        if (i3 < 0) {
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        k kVar = null;
        k kVar2 = null;
        for (int i6 = 1; kVar2 == null && i6 < i5; i6++) {
            kVar2 = d(i, i4 - i6, i + i6, i4);
        }
        if (kVar2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        k kVar3 = null;
        for (int i7 = 1; kVar3 == null && i7 < i5; i7++) {
            kVar3 = d(i, i3 + i7, i + i7, i3);
        }
        if (kVar3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        k kVar4 = null;
        for (int i8 = 1; kVar4 == null && i8 < i5; i8++) {
            kVar4 = d(i2, i3 + i8, i2 - i8, i3);
        }
        if (kVar4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i9 = 1; kVar == null && i9 < i5; i9++) {
            kVar = d(i2, i4 - i9, i2 - i9, i4);
        }
        if (kVar != null) {
            return a(kVar, kVar2, kVar4, kVar3);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
