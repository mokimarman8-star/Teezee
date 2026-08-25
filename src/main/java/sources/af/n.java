package af;

import android.graphics.Rect;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class n {
    private byte[] a;
    private int b;
    private int c;

    public n(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
    }

    public static byte[] e(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i4] = bArr[i5];
            i4--;
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = i2 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i) + i5];
                i4--;
            }
        }
        return bArr2;
    }

    public static byte[] g(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i * i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                bArr2[i3] = bArr[(i5 * i) + i4];
                i3++;
            }
        }
        return bArr2;
    }

    public n a(Rect rect, int i) {
        int width = rect.width() / i;
        int height = rect.height() / i;
        int i2 = rect.top;
        byte[] bArr = new byte[width * height];
        if (i == 1) {
            int i3 = (i2 * this.b) + rect.left;
            for (int i4 = 0; i4 < height; i4++) {
                System.arraycopy(this.a, i3, bArr, i4 * width, width);
                i3 += this.b;
            }
        } else {
            int i5 = (i2 * this.b) + rect.left;
            for (int i6 = 0; i6 < height; i6++) {
                int i7 = i6 * width;
                int i8 = i5;
                for (int i9 = 0; i9 < width; i9++) {
                    bArr[i7] = this.a[i8];
                    i8 += i;
                    i7++;
                }
                i5 += this.b * i;
            }
        }
        return new n(bArr, width, height);
    }

    public byte[] b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public n h(int i) {
        return i != 90 ? i != 180 ? i != 270 ? this : new n(f(this.a, this.b, this.c), this.c, this.b) : new n(e(this.a, this.b, this.c), this.b, this.c) : new n(g(this.a, this.b, this.c), this.c, this.b);
    }
}
