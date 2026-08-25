package com.google.zxing.aztec.encoder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b extends f {
    private final int c;
    private final int d;

    b(f fVar, int i, int i2) {
        super(fVar);
        this.c = i;
        this.d = i2;
    }

    @Override // com.google.zxing.aztec.encoder.f
    public void c(kd.a aVar, byte[] bArr) {
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0 || (i2 == 31 && i <= 62)) {
                aVar.c(31, 5);
                if (i > 62) {
                    aVar.c(i - 31, 16);
                } else if (i2 == 0) {
                    aVar.c(Math.min(i, 31), 5);
                } else {
                    aVar.c(i - 31, 5);
                }
            }
            aVar.c(bArr[this.c + i2], 8);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(this.c);
        sb2.append("::");
        sb2.append((this.c + this.d) - 1);
        sb2.append('>');
        return sb2.toString();
    }
}
