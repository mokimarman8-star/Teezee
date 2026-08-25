package td;

import com.google.protobuf.h1;
import com.google.zxing.NotFoundException;
import sd.p;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a extends p {
    private final int[] b;
    private final int[] e;
    private final int[] f;
    private final int[] a = new int[4];
    private final float[] c = new float[4];
    private final float[] d = new float[4];

    protected a() {
        int[] iArr = new int[8];
        this.b = iArr;
        this.e = new int[iArr.length / 2];
        this.f = new int[iArr.length / 2];
    }

    protected static void h(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 < f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static void o(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 > f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static boolean p(int[] iArr) {
        float f = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f < 0.7916667f || f > 0.89285713f) {
            return false;
        }
        int i = h1.READ_DONE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 : iArr) {
            if (i3 > i2) {
                i2 = i3;
            }
            if (i3 < i) {
                i = i3;
            }
        }
        return i2 < i * 10;
    }

    protected static int q(int[] iArr, int[][] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            if (p.e(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected final int[] i() {
        return this.b;
    }

    protected final int[] j() {
        return this.a;
    }

    protected final int[] k() {
        return this.f;
    }

    protected final float[] l() {
        return this.d;
    }

    protected final int[] m() {
        return this.e;
    }

    protected final float[] n() {
        return this.c;
    }
}
