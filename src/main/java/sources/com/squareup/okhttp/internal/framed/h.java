package com.squareup.okhttp.internal.framed;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class h {
    private int a;
    private int b;
    private int c;
    private final int[] d = new int[10];

    void a() {
        this.c = 0;
        this.b = 0;
        this.a = 0;
        Arrays.fill(this.d, 0);
    }

    int b(int i) {
        int i2 = h(i) ? 2 : 0;
        return k(i) ? i2 | 1 : i2;
    }

    int c(int i) {
        return this.d[i];
    }

    int d() {
        if ((this.a & 2) != 0) {
            return this.d[1];
        }
        return -1;
    }

    int e(int i) {
        return (this.a & 128) != 0 ? this.d[7] : i;
    }

    int f(int i) {
        return (this.a & 16) != 0 ? this.d[4] : i;
    }

    int g(int i) {
        return (this.a & 32) != 0 ? this.d[5] : i;
    }

    boolean h(int i) {
        return ((1 << i) & this.c) != 0;
    }

    boolean i(int i) {
        return ((1 << i) & this.a) != 0;
    }

    void j(h hVar) {
        for (int i = 0; i < 10; i++) {
            if (hVar.i(i)) {
                l(i, hVar.b(i), hVar.c(i));
            }
        }
    }

    boolean k(int i) {
        return ((1 << i) & this.b) != 0;
    }

    h l(int i, int i2, int i3) {
        int[] iArr = this.d;
        if (i >= iArr.length) {
            return this;
        }
        int i4 = 1 << i;
        this.a |= i4;
        if ((i2 & 1) != 0) {
            this.b |= i4;
        } else {
            this.b &= ~i4;
        }
        if ((i2 & 2) != 0) {
            this.c |= i4;
        } else {
            this.c &= ~i4;
        }
        iArr[i] = i3;
        return this;
    }

    int m() {
        return Integer.bitCount(this.a);
    }
}
