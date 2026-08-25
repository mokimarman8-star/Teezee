package xd;

import com.google.zxing.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a {
    private static final int[] a = {0, 4, 1, 5};
    private static final int[] b = {6, 2, 7, 3};
    private static final int[] c = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] d = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    private static final int[] e = {0, 180, 270, 90};

    private static kd.b a(kd.b bVar, int i) {
        if (i % 360 == 0) {
            return bVar;
        }
        kd.b clone = bVar.clone();
        clone.o(i);
        return clone;
    }

    private static void b(k[] kVarArr, k[] kVarArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            kVarArr[iArr[i]] = kVarArr2[i];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        r3 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (r3.hasNext() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        r4 = (com.google.zxing.k[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r7 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r7.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        r4 = r4[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (r4 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r4.d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List c(boolean z, kd.b bVar) {
        int c2;
        float d2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        loop0: while (true) {
            int i3 = i2;
            while (true) {
                if (i >= bVar.k()) {
                    break loop0;
                }
                k[] g = g(bVar, i, i2);
                if (g[0] == null && g[3] == null) {
                    break;
                }
                arrayList.add(g);
                if (!z) {
                    break loop0;
                }
                k kVar = g[2];
                if (kVar != null) {
                    c2 = (int) kVar.c();
                    d2 = g[2].d();
                } else {
                    c2 = (int) g[4].c();
                    d2 = g[4].d();
                }
                i = (int) d2;
                i2 = c2;
                i3 = 1;
            }
            i += 5;
            i2 = 0;
        }
        return arrayList;
    }

    public static b d(com.google.zxing.b bVar, Map map, boolean z) {
        kd.b a2 = bVar.a();
        for (int i : e) {
            kd.b a3 = a(a2, i);
            List c2 = c(z, a3);
            if (!c2.isEmpty()) {
                return new b(a3, c2, i);
            }
        }
        return new b(a2, new ArrayList(), 0);
    }

    private static int[] e(kd.b bVar, int i, int i2, int i3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bVar.h(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = 0;
        boolean z = false;
        while (i < i3) {
            if (bVar.h(i, i2) != z) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (h(iArr2, iArr) < 0.42f) {
                        return new int[]{i6, i};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i8 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z = !z;
            }
            i++;
        }
        if (i7 != length - 1 || h(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    private static k[] f(kd.b bVar, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        boolean z;
        int i6;
        k[] kVarArr = new k[4];
        int[] iArr2 = new int[iArr.length];
        int i7 = i3;
        while (true) {
            if (i7 >= i) {
                z = false;
                break;
            }
            int[] e2 = e(bVar, i4, i7, i2, iArr, iArr2);
            if (e2 != null) {
                int i8 = i7;
                int[] iArr3 = e2;
                while (i8 > 0) {
                    int i9 = i8 - 1;
                    int[] e3 = e(bVar, i4, i9, i2, iArr, iArr2);
                    if (e3 == null) {
                        break;
                    }
                    iArr3 = e3;
                    i8 = i9;
                }
                float f = i8;
                kVarArr[0] = new k(iArr3[0], f);
                kVarArr[1] = new k(iArr3[1], f);
                z = true;
                i7 = i8;
            } else {
                i7 += 5;
            }
        }
        int i10 = i7 + 1;
        if (z) {
            int[] iArr4 = {(int) kVarArr[0].c(), (int) kVarArr[1].c()};
            int i11 = i10;
            int i12 = 0;
            while (true) {
                if (i11 >= i) {
                    i6 = i12;
                    break;
                }
                i6 = i12;
                int[] e4 = e(bVar, iArr4[0], i11, i2, iArr, iArr2);
                if (e4 != null && Math.abs(iArr4[0] - e4[0]) < 5 && Math.abs(iArr4[1] - e4[1]) < 5) {
                    iArr4 = e4;
                    i12 = 0;
                } else {
                    if (i6 > 25) {
                        break;
                    }
                    i12 = i6 + 1;
                }
                i11++;
            }
            i10 = i11 - (i6 + 1);
            float f2 = i10;
            kVarArr[2] = new k(iArr4[0], f2);
            kVarArr[3] = new k(iArr4[1], f2);
        }
        if (i10 - i7 < i5) {
            Arrays.fill(kVarArr, (Object) null);
        }
        return kVarArr;
    }

    private static k[] g(kd.b bVar, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int k = bVar.k();
        int n = bVar.n();
        k[] kVarArr = new k[8];
        b(kVarArr, f(bVar, k, n, i, i2, 10, c), a);
        k kVar = kVarArr[4];
        if (kVar != null) {
            i2 = (int) kVar.c();
            i = (int) kVarArr[4].d();
            if (kVarArr[5] != null) {
                i3 = i;
                i4 = i2;
                i5 = (int) Math.max((((int) r0.d()) - i) * 0.5f, 10.0f);
                b(kVarArr, f(bVar, k, n, i3, i4, i5, d), b);
                return kVarArr;
            }
        }
        i3 = i;
        i4 = i2;
        i5 = 10;
        b(kVarArr, f(bVar, k, n, i3, i4, i5, d), b);
        return kVarArr;
    }

    private static float h(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f = i;
        float f2 = f / i2;
        float f3 = 0.8f * f2;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f5 = iArr2[i4] * f2;
            float f6 = iArr[i4];
            float f7 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f7 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f7;
        }
        return f4 / f;
    }
}
