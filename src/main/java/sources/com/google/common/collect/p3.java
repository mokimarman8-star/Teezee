package com.google.common.collect;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class p3 extends o3 {
    transient long[] i;
    private transient int j;
    private transient int k;

    p3(int i) {
        this(i, 1.0f);
    }

    p3(int i, float f) {
        super(i, f);
    }

    private int E(int i) {
        return (int) (this.i[i] >>> 32);
    }

    private int F(int i) {
        return (int) this.i[i];
    }

    private void G(int i, int i2) {
        long[] jArr = this.i;
        jArr[i] = (jArr[i] & 4294967295L) | (i2 << 32);
    }

    private void H(int i, int i2) {
        if (i == -2) {
            this.j = i2;
        } else {
            I(i, i2);
        }
        if (i2 == -2) {
            this.k = i;
        } else {
            G(i2, i);
        }
    }

    private void I(int i, int i2) {
        long[] jArr = this.i;
        jArr[i] = (jArr[i] & (-4294967296L)) | (i2 & 4294967295L);
    }

    @Override // com.google.common.collect.o3
    public void a() {
        super.a();
        this.j = -2;
        this.k = -2;
    }

    @Override // com.google.common.collect.o3
    int e() {
        int i = this.j;
        if (i == -2) {
            return -1;
        }
        return i;
    }

    @Override // com.google.common.collect.o3
    void n(int i, float f) {
        super.n(i, f);
        this.j = -2;
        this.k = -2;
        long[] jArr = new long[i];
        this.i = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.o3
    void o(int i, Object obj, int i2, int i3) {
        super.o(i, obj, i2, i3);
        H(this.k, i);
        H(i, -2);
    }

    @Override // com.google.common.collect.o3
    void p(int i) {
        int C = C() - 1;
        H(E(i), F(i));
        if (i < C) {
            H(E(C), i);
            H(i, F(C));
        }
        super.p(i);
    }

    @Override // com.google.common.collect.o3
    int s(int i) {
        int F = F(i);
        if (F == -2) {
            return -1;
        }
        return F;
    }

    @Override // com.google.common.collect.o3
    int t(int i, int i2) {
        return i == C() ? i2 : i;
    }

    @Override // com.google.common.collect.o3
    void y(int i) {
        super.y(i);
        long[] jArr = this.i;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        this.i = copyOf;
        Arrays.fill(copyOf, length, i, -1L);
    }
}
