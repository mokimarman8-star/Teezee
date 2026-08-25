package com.google.zxing.qrcode.detector;

import com.google.zxing.k;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d extends k {
    private final float c;
    private final int d;

    d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private d(float f, float f2, float f3, int i) {
        super(f, f2);
        this.c = f3;
        this.d = i;
    }

    boolean f(float f, float f2, float f3) {
        if (Math.abs(f2 - d()) > f || Math.abs(f3 - c()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.c);
        return abs <= 1.0f || abs <= this.c;
    }

    d g(float f, float f2, float f3) {
        int i = this.d;
        int i2 = i + 1;
        float c = (i * c()) + f2;
        float f4 = i2;
        return new d(c / f4, ((this.d * d()) + f) / f4, ((this.d * this.c) + f3) / f4, i2);
    }

    public int h() {
        return this.d;
    }

    public float i() {
        return this.c;
    }
}
