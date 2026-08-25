package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private final double[] f5708a;

    /* renamed from: b, reason: collision with root package name */
    C0040a[] f5709b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5710c = true;

    /* renamed from: androidx.constraintlayout.core.motion.utils.a$a, reason: collision with other inner class name */
    private static class C0040a {

        /* renamed from: s, reason: collision with root package name */
        private static double[] f5711s = new double[91];

        /* renamed from: a, reason: collision with root package name */
        double[] f5712a;

        /* renamed from: b, reason: collision with root package name */
        double f5713b;

        /* renamed from: c, reason: collision with root package name */
        double f5714c;

        /* renamed from: d, reason: collision with root package name */
        double f5715d;

        /* renamed from: e, reason: collision with root package name */
        double f5716e;

        /* renamed from: f, reason: collision with root package name */
        double f5717f;

        /* renamed from: g, reason: collision with root package name */
        double f5718g;

        /* renamed from: h, reason: collision with root package name */
        double f5719h;

        /* renamed from: i, reason: collision with root package name */
        double f5720i;

        /* renamed from: j, reason: collision with root package name */
        double f5721j;

        /* renamed from: k, reason: collision with root package name */
        double f5722k;

        /* renamed from: l, reason: collision with root package name */
        double f5723l;

        /* renamed from: m, reason: collision with root package name */
        double f5724m;

        /* renamed from: n, reason: collision with root package name */
        double f5725n;

        /* renamed from: o, reason: collision with root package name */
        double f5726o;

        /* renamed from: p, reason: collision with root package name */
        double f5727p;

        /* renamed from: q, reason: collision with root package name */
        boolean f5728q;

        /* renamed from: r, reason: collision with root package name */
        boolean f5729r;

        C0040a(int i5, double d5, double d6, double d7, double d8, double d9, double d10) {
            this.f5729r = false;
            this.f5728q = i5 == 1;
            this.f5714c = d5;
            this.f5715d = d6;
            this.f5720i = 1.0d / (d6 - d5);
            if (3 == i5) {
                this.f5729r = true;
            }
            double d11 = d9 - d7;
            double d12 = d10 - d8;
            if (!this.f5729r && Math.abs(d11) >= 0.001d && Math.abs(d12) >= 0.001d) {
                this.f5712a = new double[101];
                boolean z5 = this.f5728q;
                this.f5721j = d11 * (z5 ? -1 : 1);
                this.f5722k = d12 * (z5 ? 1 : -1);
                this.f5723l = z5 ? d9 : d7;
                this.f5724m = z5 ? d8 : d10;
                a(d7, d8, d9, d10);
                this.f5725n = this.f5713b * this.f5720i;
                return;
            }
            this.f5729r = true;
            this.f5716e = d7;
            this.f5717f = d9;
            this.f5718g = d8;
            this.f5719h = d10;
            double hypot = Math.hypot(d12, d11);
            this.f5713b = hypot;
            this.f5725n = hypot * this.f5720i;
            double d13 = this.f5715d;
            double d14 = this.f5714c;
            this.f5723l = d11 / (d13 - d14);
            this.f5724m = d12 / (d13 - d14);
        }

        private void a(double d5, double d6, double d7, double d8) {
            double d9;
            double d10 = d7 - d5;
            double d11 = d6 - d8;
            int i5 = 0;
            double d12 = 0.0d;
            double d13 = 0.0d;
            double d14 = 0.0d;
            while (true) {
                if (i5 >= f5711s.length) {
                    break;
                }
                double d15 = d12;
                double radians = Math.toRadians((i5 * 90.0d) / (r15.length - 1));
                double sin = Math.sin(radians) * d10;
                double cos = Math.cos(radians) * d11;
                if (i5 > 0) {
                    d9 = Math.hypot(sin - d13, cos - d14) + d15;
                    f5711s[i5] = d9;
                } else {
                    d9 = d15;
                }
                i5++;
                d14 = cos;
                d12 = d9;
                d13 = sin;
            }
            double d16 = d12;
            this.f5713b = d16;
            int i6 = 0;
            while (true) {
                double[] dArr = f5711s;
                if (i6 >= dArr.length) {
                    break;
                }
                dArr[i6] = dArr[i6] / d16;
                i6++;
            }
            int i7 = 0;
            while (true) {
                if (i7 >= this.f5712a.length) {
                    return;
                }
                double length = i7 / (r1.length - 1);
                int binarySearch = Arrays.binarySearch(f5711s, length);
                if (binarySearch >= 0) {
                    this.f5712a[i7] = binarySearch / (f5711s.length - 1);
                } else if (binarySearch == -1) {
                    this.f5712a[i7] = 0.0d;
                } else {
                    int i8 = -binarySearch;
                    int i9 = i8 - 2;
                    double[] dArr2 = f5711s;
                    double d17 = dArr2[i9];
                    this.f5712a[i7] = (i9 + ((length - d17) / (dArr2[i8 - 1] - d17))) / (dArr2.length - 1);
                }
                i7++;
            }
        }

        double b() {
            double d5 = this.f5721j * this.f5727p;
            double hypot = this.f5725n / Math.hypot(d5, (-this.f5722k) * this.f5726o);
            if (this.f5728q) {
                d5 = -d5;
            }
            return d5 * hypot;
        }

        double c() {
            double d5 = this.f5721j * this.f5727p;
            double d6 = (-this.f5722k) * this.f5726o;
            double hypot = this.f5725n / Math.hypot(d5, d6);
            return this.f5728q ? (-d6) * hypot : d6 * hypot;
        }

        public double d(double d5) {
            return this.f5723l;
        }

        public double e(double d5) {
            return this.f5724m;
        }

        public double f(double d5) {
            double d6 = (d5 - this.f5714c) * this.f5720i;
            double d7 = this.f5716e;
            return d7 + (d6 * (this.f5717f - d7));
        }

        public double g(double d5) {
            double d6 = (d5 - this.f5714c) * this.f5720i;
            double d7 = this.f5718g;
            return d7 + (d6 * (this.f5719h - d7));
        }

        double h() {
            return this.f5723l + (this.f5721j * this.f5726o);
        }

        double i() {
            return this.f5724m + (this.f5722k * this.f5727p);
        }

        double j(double d5) {
            if (d5 <= 0.0d) {
                return 0.0d;
            }
            if (d5 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f5712a;
            double length = d5 * (dArr.length - 1);
            int i5 = (int) length;
            double d6 = length - i5;
            double d7 = dArr[i5];
            return d7 + (d6 * (dArr[i5 + 1] - d7));
        }

        void k(double d5) {
            double j5 = j((this.f5728q ? this.f5715d - d5 : d5 - this.f5714c) * this.f5720i) * 1.5707963267948966d;
            this.f5726o = Math.sin(j5);
            this.f5727p = Math.cos(j5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        if (r5 == 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(int[] iArr, double[] dArr, double[][] dArr2) {
        this.f5708a = dArr;
        this.f5709b = new C0040a[dArr.length - 1];
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (true) {
            C0040a[] c0040aArr = this.f5709b;
            if (i7 >= c0040aArr.length) {
                return;
            }
            int i8 = iArr[i7];
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 == 3) {
                        }
                    }
                    i5 = 2;
                    i6 = i5;
                }
                i5 = 1;
                i6 = i5;
            } else {
                i6 = 3;
            }
            double d5 = dArr[i7];
            int i9 = i7 + 1;
            double d6 = dArr[i9];
            double[] dArr3 = dArr2[i7];
            double d7 = dArr3[0];
            double d8 = dArr3[1];
            double[] dArr4 = dArr2[i9];
            c0040aArr[i7] = new C0040a(i6, d5, d6, d7, d8, dArr4[0], dArr4[1]);
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double c(double d5, int i5) {
        double g5;
        double e5;
        double i6;
        double c5;
        double g6;
        double e6;
        int i7 = 0;
        if (this.f5710c) {
            C0040a[] c0040aArr = this.f5709b;
            C0040a c0040a = c0040aArr[0];
            double d6 = c0040a.f5714c;
            if (d5 < d6) {
                double d7 = d5 - d6;
                if (c0040a.f5729r) {
                    if (i5 == 0) {
                        g6 = c0040a.f(d6);
                        e6 = this.f5709b[0].d(d6);
                    } else {
                        g6 = c0040a.g(d6);
                        e6 = this.f5709b[0].e(d6);
                    }
                    return g6 + (d7 * e6);
                }
                c0040a.k(d6);
                if (i5 == 0) {
                    i6 = this.f5709b[0].h();
                    c5 = this.f5709b[0].b();
                } else {
                    i6 = this.f5709b[0].i();
                    c5 = this.f5709b[0].c();
                }
                return i6 + (d7 * c5);
            }
            if (d5 > c0040aArr[c0040aArr.length - 1].f5715d) {
                double d8 = c0040aArr[c0040aArr.length - 1].f5715d;
                double d9 = d5 - d8;
                int length = c0040aArr.length - 1;
                if (i5 == 0) {
                    g5 = c0040aArr[length].f(d8);
                    e5 = this.f5709b[length].d(d8);
                } else {
                    g5 = c0040aArr[length].g(d8);
                    e5 = this.f5709b[length].e(d8);
                }
                return g5 + (d9 * e5);
            }
        } else {
            C0040a[] c0040aArr2 = this.f5709b;
            double d10 = c0040aArr2[0].f5714c;
            if (d5 < d10) {
                d5 = d10;
            } else if (d5 > c0040aArr2[c0040aArr2.length - 1].f5715d) {
                d5 = c0040aArr2[c0040aArr2.length - 1].f5715d;
            }
        }
        while (true) {
            C0040a[] c0040aArr3 = this.f5709b;
            if (i7 >= c0040aArr3.length) {
                return Double.NaN;
            }
            C0040a c0040a2 = c0040aArr3[i7];
            if (d5 <= c0040a2.f5715d) {
                if (c0040a2.f5729r) {
                    return i5 == 0 ? c0040a2.f(d5) : c0040a2.g(d5);
                }
                c0040a2.k(d5);
                return i5 == 0 ? this.f5709b[i7].h() : this.f5709b[i7].i();
            }
            i7++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void d(double d5, double[] dArr) {
        if (this.f5710c) {
            C0040a[] c0040aArr = this.f5709b;
            C0040a c0040a = c0040aArr[0];
            double d6 = c0040a.f5714c;
            if (d5 < d6) {
                double d7 = d5 - d6;
                if (c0040a.f5729r) {
                    dArr[0] = c0040a.f(d6) + (this.f5709b[0].d(d6) * d7);
                    dArr[1] = this.f5709b[0].g(d6) + (d7 * this.f5709b[0].e(d6));
                    return;
                } else {
                    c0040a.k(d6);
                    dArr[0] = this.f5709b[0].h() + (this.f5709b[0].b() * d7);
                    dArr[1] = this.f5709b[0].i() + (d7 * this.f5709b[0].c());
                    return;
                }
            }
            if (d5 > c0040aArr[c0040aArr.length - 1].f5715d) {
                double d8 = c0040aArr[c0040aArr.length - 1].f5715d;
                double d9 = d5 - d8;
                int length = c0040aArr.length - 1;
                C0040a c0040a2 = c0040aArr[length];
                if (c0040a2.f5729r) {
                    dArr[0] = c0040a2.f(d8) + (this.f5709b[length].d(d8) * d9);
                    dArr[1] = this.f5709b[length].g(d8) + (d9 * this.f5709b[length].e(d8));
                    return;
                } else {
                    c0040a2.k(d5);
                    dArr[0] = this.f5709b[length].h() + (this.f5709b[length].b() * d9);
                    dArr[1] = this.f5709b[length].i() + (d9 * this.f5709b[length].c());
                    return;
                }
            }
        } else {
            C0040a[] c0040aArr2 = this.f5709b;
            double d10 = c0040aArr2[0].f5714c;
            if (d5 < d10) {
                d5 = d10;
            }
            if (d5 > c0040aArr2[c0040aArr2.length - 1].f5715d) {
                d5 = c0040aArr2[c0040aArr2.length - 1].f5715d;
            }
        }
        int i5 = 0;
        while (true) {
            C0040a[] c0040aArr3 = this.f5709b;
            if (i5 >= c0040aArr3.length) {
                return;
            }
            C0040a c0040a3 = c0040aArr3[i5];
            if (d5 <= c0040a3.f5715d) {
                if (c0040a3.f5729r) {
                    dArr[0] = c0040a3.f(d5);
                    dArr[1] = this.f5709b[i5].g(d5);
                    return;
                } else {
                    c0040a3.k(d5);
                    dArr[0] = this.f5709b[i5].h();
                    dArr[1] = this.f5709b[i5].i();
                    return;
                }
            }
            i5++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void e(double d5, float[] fArr) {
        if (this.f5710c) {
            C0040a[] c0040aArr = this.f5709b;
            C0040a c0040a = c0040aArr[0];
            double d6 = c0040a.f5714c;
            if (d5 < d6) {
                double d7 = d5 - d6;
                if (c0040a.f5729r) {
                    fArr[0] = (float) (c0040a.f(d6) + (this.f5709b[0].d(d6) * d7));
                    fArr[1] = (float) (this.f5709b[0].g(d6) + (d7 * this.f5709b[0].e(d6)));
                    return;
                } else {
                    c0040a.k(d6);
                    fArr[0] = (float) (this.f5709b[0].h() + (this.f5709b[0].b() * d7));
                    fArr[1] = (float) (this.f5709b[0].i() + (d7 * this.f5709b[0].c()));
                    return;
                }
            }
            if (d5 > c0040aArr[c0040aArr.length - 1].f5715d) {
                double d8 = c0040aArr[c0040aArr.length - 1].f5715d;
                double d9 = d5 - d8;
                int length = c0040aArr.length - 1;
                C0040a c0040a2 = c0040aArr[length];
                if (c0040a2.f5729r) {
                    fArr[0] = (float) (c0040a2.f(d8) + (this.f5709b[length].d(d8) * d9));
                    fArr[1] = (float) (this.f5709b[length].g(d8) + (d9 * this.f5709b[length].e(d8)));
                    return;
                } else {
                    c0040a2.k(d5);
                    fArr[0] = (float) this.f5709b[length].h();
                    fArr[1] = (float) this.f5709b[length].i();
                    return;
                }
            }
        } else {
            C0040a[] c0040aArr2 = this.f5709b;
            double d10 = c0040aArr2[0].f5714c;
            if (d5 < d10) {
                d5 = d10;
            } else if (d5 > c0040aArr2[c0040aArr2.length - 1].f5715d) {
                d5 = c0040aArr2[c0040aArr2.length - 1].f5715d;
            }
        }
        int i5 = 0;
        while (true) {
            C0040a[] c0040aArr3 = this.f5709b;
            if (i5 >= c0040aArr3.length) {
                return;
            }
            C0040a c0040a3 = c0040aArr3[i5];
            if (d5 <= c0040a3.f5715d) {
                if (c0040a3.f5729r) {
                    fArr[0] = (float) c0040a3.f(d5);
                    fArr[1] = (float) this.f5709b[i5].g(d5);
                    return;
                } else {
                    c0040a3.k(d5);
                    fArr[0] = (float) this.f5709b[i5].h();
                    fArr[1] = (float) this.f5709b[i5].i();
                    return;
                }
            }
            i5++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double f(double d5, int i5) {
        C0040a[] c0040aArr = this.f5709b;
        int i6 = 0;
        double d6 = c0040aArr[0].f5714c;
        if (d5 < d6) {
            d5 = d6;
        }
        if (d5 > c0040aArr[c0040aArr.length - 1].f5715d) {
            d5 = c0040aArr[c0040aArr.length - 1].f5715d;
        }
        while (true) {
            C0040a[] c0040aArr2 = this.f5709b;
            if (i6 >= c0040aArr2.length) {
                return Double.NaN;
            }
            C0040a c0040a = c0040aArr2[i6];
            if (d5 <= c0040a.f5715d) {
                if (c0040a.f5729r) {
                    return i5 == 0 ? c0040a.d(d5) : c0040a.e(d5);
                }
                c0040a.k(d5);
                return i5 == 0 ? this.f5709b[i6].b() : this.f5709b[i6].c();
            }
            i6++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void g(double d5, double[] dArr) {
        C0040a[] c0040aArr = this.f5709b;
        double d6 = c0040aArr[0].f5714c;
        if (d5 < d6) {
            d5 = d6;
        } else if (d5 > c0040aArr[c0040aArr.length - 1].f5715d) {
            d5 = c0040aArr[c0040aArr.length - 1].f5715d;
        }
        int i5 = 0;
        while (true) {
            C0040a[] c0040aArr2 = this.f5709b;
            if (i5 >= c0040aArr2.length) {
                return;
            }
            C0040a c0040a = c0040aArr2[i5];
            if (d5 <= c0040a.f5715d) {
                if (c0040a.f5729r) {
                    dArr[0] = c0040a.d(d5);
                    dArr[1] = this.f5709b[i5].e(d5);
                    return;
                } else {
                    c0040a.k(d5);
                    dArr[0] = this.f5709b[i5].b();
                    dArr[1] = this.f5709b[i5].c();
                    return;
                }
            }
            i5++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double[] h() {
        return this.f5708a;
    }
}
