package com.google.zxing;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class e {
    private final int a;
    private final int b;

    protected e(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i, byte[] bArr);

    public final int d() {
        return this.a;
    }

    public e e() {
        return new d(this);
    }

    public boolean f() {
        return false;
    }

    public e g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.a;
        byte[] bArr = new byte[i];
        StringBuilder sb2 = new StringBuilder(this.b * (i + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            bArr = c(i2, bArr);
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = bArr[i3] & 255;
                sb2.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
