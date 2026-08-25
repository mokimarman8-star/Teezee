package com.google.zxing;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d extends e {
    private final e c;

    public d(e eVar) {
        super(eVar.d(), eVar.a());
        this.c = eVar;
    }

    @Override // com.google.zxing.e
    public byte[] b() {
        byte[] b = this.c.b();
        int d = d() * a();
        byte[] bArr = new byte[d];
        for (int i = 0; i < d; i++) {
            bArr[i] = (byte) (255 - (b[i] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.e
    public byte[] c(int i, byte[] bArr) {
        byte[] c = this.c.c(i, bArr);
        int d = d();
        for (int i2 = 0; i2 < d; i2++) {
            c[i2] = (byte) (255 - (c[i2] & 255));
        }
        return c;
    }

    @Override // com.google.zxing.e
    public e e() {
        return this.c;
    }

    @Override // com.google.zxing.e
    public boolean f() {
        return this.c.f();
    }

    @Override // com.google.zxing.e
    public e g() {
        return new d(this.c.g());
    }
}
