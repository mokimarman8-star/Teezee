package com.google.zxing.aztec.encoder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class f {
    static final f b = new d(null, 0, 0);
    private final f a;

    f(f fVar) {
        this.a = fVar;
    }

    final f a(int i, int i2) {
        return new d(this, i, i2);
    }

    final f b(int i, int i2) {
        return new b(this, i, i2);
    }

    abstract void c(kd.a aVar, byte[] bArr);

    final f d() {
        return this.a;
    }
}
