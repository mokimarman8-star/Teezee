package uz;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class k {
    int a = 0;
    int b = 200;
    int c = 0;
    public int[] d = new int[94];
    public int[] e = new int[94];
    public float[] f = new float[94];
    public float[] g = new float[94];

    public k() {
        f();
    }

    void a() {
        for (int i = 0; i < 94; i++) {
            float[] fArr = this.f;
            float f = this.d[i];
            int i2 = this.a;
            fArr[i] = f / i2;
            this.g[i] = this.e[i] / i2;
        }
    }

    boolean b() {
        return this.a > this.b;
    }

    float c(float[] fArr, float f, float[] fArr2, float f2) {
        return (f * d(fArr, this.f)) + (f2 * d(fArr2, this.g));
    }

    float d(float[] fArr, float[] fArr2) {
        float f = 0.0f;
        for (int i = 0; i < 94; i++) {
            float f2 = fArr[i] - fArr2[i];
            f += f2 * f2;
        }
        return ((float) Math.sqrt(f)) / 94.0f;
    }

    boolean e() {
        return this.a > 1;
    }

    public void f() {
        this.a = 0;
        this.c = 0;
        for (int i = 0; i < 94; i++) {
            int[] iArr = this.d;
            this.e[i] = 0;
            iArr[i] = 0;
        }
    }

    boolean g(byte[] bArr, int i) {
        if (this.c == 1) {
            return false;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = this.c;
            if (1 == i4) {
                break;
            }
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        byte b = bArr[i3];
                        if ((b & 128) != 0 && 255 != (b & 255) && 161 <= (b & 255)) {
                            this.a++;
                            int[] iArr = this.e;
                            int i5 = (b & 255) - 161;
                            iArr[i5] = iArr[i5] + 1;
                            this.c = 0;
                        }
                    }
                    this.c = 1;
                }
                i2++;
                i3++;
            } else {
                byte b2 = bArr[i3];
                if ((b2 & 128) != 0) {
                    if (255 != (b2 & 255) && 161 <= (b2 & 255)) {
                        this.a++;
                        int[] iArr2 = this.d;
                        int i6 = (b2 & 255) - 161;
                        iArr2[i6] = iArr2[i6] + 1;
                        this.c = 2;
                    }
                    this.c = 1;
                }
                i2++;
                i3++;
            }
        }
        return 1 != this.c;
    }
}
