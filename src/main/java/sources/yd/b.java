package yd;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b {
    private final byte[] a;
    private int b = 0;

    b(int i) {
        this.a = new byte[i];
    }

    private void c(int i, boolean z) {
        this.a[i] = z ? (byte) 1 : (byte) 0;
    }

    void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.b;
            this.b = i3 + 1;
            c(i3, z);
        }
    }

    byte[] b(int i) {
        int length = this.a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.a[i2 / i];
        }
        return bArr;
    }
}
