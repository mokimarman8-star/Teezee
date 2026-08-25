package com.google.zxing.aztec.encoder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class d extends f {
    private final short c;
    private final short d;

    d(f fVar, int i, int i2) {
        super(fVar);
        this.c = (short) i;
        this.d = (short) i2;
    }

    @Override // com.google.zxing.aztec.encoder.f
    void c(kd.a aVar, byte[] bArr) {
        aVar.c(this.c, this.d);
    }

    public String toString() {
        short s = this.c;
        short s2 = this.d;
        return '<' + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.d)).substring(1) + '>';
    }
}
