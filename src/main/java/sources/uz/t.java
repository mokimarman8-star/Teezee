package uz;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class t {
    y[] a;
    l[] b;
    k c;
    byte[] d;
    int[] e;
    int f;
    int g;
    boolean h;
    boolean i;
    boolean j;

    public t() {
        this.c = new k();
        this.d = new byte[16];
        this.e = new int[16];
        h(0);
        d();
    }

    public t(int i) {
        this.c = new k();
        this.d = new byte[16];
        this.e = new int[16];
        h(i);
        d();
    }

    public void a() {
        y yVar;
        if (this.h) {
            return;
        }
        if (this.f == 2) {
            if (this.a[this.e[0]].b().equals("GB18030")) {
                yVar = this.a[this.e[1]];
            } else if (this.a[this.e[1]].b().equals("GB18030")) {
                yVar = this.a[this.e[0]];
            }
            c(yVar.b());
            this.h = true;
        }
        if (this.i) {
            f(null, 0, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0016, code lost:
    
        if (r4 > 1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002c, code lost:
    
        r2 = 0;
        r3 = 0;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0031, code lost:
    
        if (r2 < r8.f) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r8.a[r8.e[r2]].d() != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
    
        if (r8.a[r8.e[r2]].d() != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
    
        r3 = r3 + 1;
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0033, code lost:
    
        if (1 != r3) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0047, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0035, code lost:
    
        r9 = r8.a[r8.e[r4]];
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0018, code lost:
    
        if (1 != r4) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x001a, code lost:
    
        c(r8.a[r8.e[0]].b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0029, code lost:
    
        r8.h = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x002b, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(byte[] bArr, int i) {
        y yVar;
        int i2 = 0;
        loop0: while (i2 < i) {
            byte b = bArr[i2];
            int i3 = 0;
            while (true) {
                int i4 = this.f;
                if (i3 >= i4) {
                    break;
                }
                byte c = y.c(this.a[this.e[i3]], b, this.d[i3]);
                if (c == 2) {
                    yVar = this.a[this.e[i3]];
                    break loop0;
                }
                if (c == 1) {
                    int i5 = this.f - 1;
                    this.f = i5;
                    if (i3 < i5) {
                        int[] iArr = this.e;
                        iArr[i3] = iArr[i5];
                        byte[] bArr2 = this.d;
                        bArr2[i3] = bArr2[i5];
                    }
                } else {
                    this.d[i3] = c;
                    i3++;
                }
            }
            c(yVar.b());
            this.h = true;
            return true;
        }
        if (this.i) {
            e(bArr, i);
        }
        return this.h;
    }

    public abstract void c(String str);

    public void d() {
        this.i = this.j;
        this.h = false;
        this.f = this.g;
        for (int i = 0; i < this.f; i++) {
            this.d[i] = 0;
            this.e[i] = i;
        }
        this.c.f();
    }

    public void e(byte[] bArr, int i) {
        f(bArr, i, false);
    }

    public void f(byte[] bArr, int i, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f; i4++) {
            l[] lVarArr = this.b;
            int i5 = this.e[i4];
            if (lVarArr[i5] != null) {
                i2++;
            }
            if (!this.a[i5].d() && !this.a[this.e[i4]].b().equals("GB18030")) {
                i3++;
            }
        }
        boolean z2 = i2 > 1;
        this.i = z2;
        if (z2) {
            this.i = this.c.g(bArr, i);
            if (((z && this.c.e()) || this.c.b()) && i2 == i3) {
                this.c.a();
                int i6 = -1;
                float f = 0.0f;
                int i7 = 0;
                for (int i10 = 0; i10 < this.f; i10++) {
                    l[] lVarArr2 = this.b;
                    int i11 = this.e[i10];
                    if (lVarArr2[i11] != null && !this.a[i11].b().equals("Big5")) {
                        float c = this.c.c(this.b[this.e[i10]].a(), this.b[this.e[i10]].b(), this.b[this.e[i10]].c(), this.b[this.e[i10]].d());
                        int i12 = i7 + 1;
                        if (i7 == 0 || f > c) {
                            i6 = i10;
                            f = c;
                        }
                        i7 = i12;
                    }
                }
                if (i6 >= 0) {
                    c(this.a[this.e[i6]].b());
                    this.h = true;
                }
            }
        }
    }

    public String[] g() {
        int i = this.f;
        if (i <= 0) {
            return new String[]{"nomatch"};
        }
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < this.f; i2++) {
            strArr[i2] = this.a[this.e[i2]].b();
        }
        return strArr;
    }

    protected void h(int i) {
        int i2 = i;
        if (i2 < 0 || i2 >= 6) {
            i2 = 0;
        }
        this.a = null;
        this.b = null;
        if (i2 == 4) {
            this.a = new y[]{new x(), new f(), new q(), new m(), new g(), new v(), new w()};
            this.b = new l[]{null, new a(), null, new d(), null, null, null};
        } else if (i2 == 5) {
            this.a = new y[]{new x(), new j(), new s(), new g(), new v(), new w()};
        } else if (i2 == 3) {
            this.a = new y[]{new x(), new o(), new n(), new q(), new p(), new g(), new v(), new w()};
        } else if (i2 == 1) {
            this.a = new y[]{new x(), new u(), new i(), new r(), new g(), new v(), new w()};
        } else if (i2 == 2) {
            this.a = new y[]{new x(), new o(), new n(), new f(), new q(), new p(), new m(), new g(), new v(), new w()};
            this.b = new l[]{null, new e(), null, new a(), null, null, new d(), null, null, null};
        } else if (i2 == 0) {
            this.a = new y[]{new x(), new u(), new i(), new r(), new j(), new s(), new f(), new m(), new o(), new n(), new q(), new p(), new g(), new v(), new w()};
            this.b = new l[]{null, null, new b(), null, new c(), null, new a(), new d(), new e(), null, null, null, null, null, null};
        }
        this.j = this.b != null;
        this.g = this.a.length;
    }
}
