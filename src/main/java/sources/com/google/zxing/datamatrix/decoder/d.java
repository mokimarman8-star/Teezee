package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d {
    private static final d[] h = a();
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final c f;
    private final int g;

    static final class b {
        private final int a;
        private final int b;

        private b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        int a() {
            return this.a;
        }

        int b() {
            return this.b;
        }
    }

    static final class c {
        private final int a;
        private final b[] b;

        private c(int i, b bVar) {
            this.a = i;
            this.b = new b[]{bVar};
        }

        private c(int i, b bVar, b bVar2) {
            this.a = i;
            this.b = new b[]{bVar, bVar2};
        }

        b[] a() {
            return this.b;
        }

        int b() {
            return this.a;
        }
    }

    private d(int i, int i2, int i3, int i4, int i5, c cVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = cVar;
        int b2 = cVar.b();
        int i6 = 0;
        for (b bVar : cVar.a()) {
            i6 += bVar.a() * (bVar.b() + b2);
        }
        this.g = i6;
    }

    private static d[] a() {
        int i = 1;
        int i2 = 5;
        d dVar = new d(1, 10, 10, 8, 8, new c(i2, new b(i, 3)));
        int i3 = 12;
        d dVar2 = new d(2, 12, 12, 10, 10, new c(7, new b(i, i2)));
        d dVar3 = new d(3, 14, 14, 12, 12, new c(10, new b(i, 8)));
        d dVar4 = new d(4, 16, 16, 14, 14, new c(i3, new b(i, i3)));
        int i4 = 18;
        d dVar5 = new d(5, 18, 18, 16, 16, new c(14, new b(i, i4)));
        d dVar6 = new d(6, 20, 20, 18, 18, new c(i4, new b(i, 22)));
        d dVar7 = new d(7, 22, 22, 20, 20, new c(20, new b(i, 30)));
        int i5 = 36;
        d dVar8 = new d(8, 24, 24, 22, 22, new c(24, new b(i, i5)));
        d dVar9 = new d(9, 26, 26, 24, 24, new c(28, new b(i, 44)));
        d dVar10 = new d(10, 32, 32, 14, 14, new c(i5, new b(i, 62)));
        int i6 = 2;
        int i7 = 4;
        int i8 = 6;
        return new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9, dVar10, new d(11, 36, 36, 16, 16, new c(42, new b(i, 86))), new d(12, 40, 40, 18, 18, new c(48, new b(i, 114))), new d(13, 44, 44, 20, 20, new c(56, new b(i, 144))), new d(14, 48, 48, 22, 22, new c(68, new b(i, 174))), new d(15, 52, 52, 24, 24, new c(42, new b(i6, 102))), new d(16, 64, 64, 14, 14, new c(56, new b(i6, 140))), new d(17, 72, 72, 16, 16, new c(36, new b(i7, 92))), new d(18, 80, 80, 18, 18, new c(48, new b(i7, 114))), new d(19, 88, 88, 20, 20, new c(56, new b(i7, 144))), new d(20, 96, 96, 22, 22, new c(68, new b(i7, 174))), new d(21, 104, 104, 24, 24, new c(56, new b(i8, 136))), new d(22, 120, 120, 18, 18, new c(68, new b(i8, 175))), new d(23, 132, 132, 20, 20, new c(62, new b(8, 163))), new d(24, 144, 144, 22, 22, new c(62, new b(8, 156), new b(2, 155))), new d(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new d(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new d(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new d(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new d(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new d(30, 16, 48, 14, 22, new c(28, new b(1, 49))), new d(31, 8, 48, 6, 22, new c(15, new b(1, 18))), new d(32, 8, 64, 6, 14, new c(18, new b(1, 24))), new d(33, 8, 80, 6, 18, new c(22, new b(1, 32))), new d(34, 8, 96, 6, 22, new c(28, new b(1, 38))), new d(35, 8, 120, 6, 18, new c(32, new b(1, 49))), new d(36, 8, 144, 6, 22, new c(36, new b(1, 63))), new d(37, 12, 64, 10, 14, new c(27, new b(1, 43))), new d(38, 12, 88, 10, 20, new c(36, new b(1, 64))), new d(39, 16, 64, 14, 14, new c(36, new b(1, 62))), new d(40, 20, 36, 18, 16, new c(28, new b(1, 44))), new d(41, 20, 44, 18, 20, new c(34, new b(1, 56))), new d(42, 20, 64, 18, 14, new c(42, new b(1, 84))), new d(43, 22, 48, 20, 22, new c(38, new b(1, 72))), new d(44, 24, 48, 22, 22, new c(41, new b(1, 80))), new d(45, 24, 64, 22, 14, new c(46, new b(1, 108))), new d(46, 26, 40, 24, 18, new c(38, new b(1, 70))), new d(47, 26, 48, 24, 22, new c(42, new b(1, 90))), new d(48, 26, 64, 24, 14, new c(50, new b(1, 118)))};
    }

    public static d h(int i, int i2) {
        if ((i & 1) != 0 || (i2 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (d dVar : h) {
            if (dVar.b == i && dVar.c == i2) {
                return dVar;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    c d() {
        return this.f;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.g;
    }

    public int i() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(this.a);
    }
}
