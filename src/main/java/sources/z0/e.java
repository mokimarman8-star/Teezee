package z0;

import android.graphics.Path;
import android.util.Log;
import androidx.core.view.MotionEventCompat;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class e {

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        int f18723a;

        /* renamed from: b, reason: collision with root package name */
        boolean f18724b;

        a() {
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private char f18725a;

        /* renamed from: b, reason: collision with root package name */
        private final float[] f18726b;

        b(char c5, float[] fArr) {
            this.f18725a = c5;
            this.f18726b = fArr;
        }

        b(b bVar) {
            this.f18725a = bVar.f18725a;
            float[] fArr = bVar.f18726b;
            this.f18726b = e.c(fArr, 0, fArr.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void e(Path path, float[] fArr, char c5, char c6, float[] fArr2) {
            int i5;
            int i6;
            int i7;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            char c7 = c6;
            boolean z5 = false;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[2];
            float f16 = fArr[3];
            float f17 = fArr[4];
            float f18 = fArr[5];
            switch (c7) {
                case 'A':
                case 'a':
                    i5 = 7;
                    i6 = i5;
                    break;
                case 'C':
                case 'c':
                    i5 = 6;
                    i6 = i5;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i6 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i6 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i6 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f17, f18);
                    f13 = f17;
                    f15 = f13;
                    f14 = f18;
                    f16 = f14;
                    i6 = 2;
                    break;
            }
            float f19 = f13;
            float f20 = f14;
            float f21 = f17;
            float f22 = f18;
            int i8 = 0;
            char c8 = c5;
            while (i8 < fArr2.length) {
                if (c7 != 'A') {
                    if (c7 == 'C') {
                        i7 = i8;
                        int i9 = i7 + 2;
                        int i10 = i7 + 3;
                        int i11 = i7 + 4;
                        int i12 = i7 + 5;
                        path.cubicTo(fArr2[i7], fArr2[i7 + 1], fArr2[i9], fArr2[i10], fArr2[i11], fArr2[i12]);
                        f19 = fArr2[i11];
                        float f23 = fArr2[i12];
                        float f24 = fArr2[i9];
                        float f25 = fArr2[i10];
                        f20 = f23;
                        f16 = f25;
                        f15 = f24;
                    } else if (c7 == 'H') {
                        i7 = i8;
                        path.lineTo(fArr2[i7], f20);
                        f19 = fArr2[i7];
                    } else if (c7 == 'Q') {
                        i7 = i8;
                        int i13 = i7 + 1;
                        int i14 = i7 + 2;
                        int i15 = i7 + 3;
                        path.quadTo(fArr2[i7], fArr2[i13], fArr2[i14], fArr2[i15]);
                        float f26 = fArr2[i7];
                        float f27 = fArr2[i13];
                        f19 = fArr2[i14];
                        f20 = fArr2[i15];
                        f15 = f26;
                        f16 = f27;
                    } else if (c7 == 'V') {
                        i7 = i8;
                        path.lineTo(f19, fArr2[i7]);
                        f20 = fArr2[i7];
                    } else if (c7 != 'a') {
                        if (c7 != 'c') {
                            if (c7 == 'h') {
                                path.rLineTo(fArr2[i8], 0.0f);
                                f19 += fArr2[i8];
                            } else if (c7 != 'q') {
                                if (c7 == 'v') {
                                    path.rLineTo(0.0f, fArr2[i8]);
                                    f8 = fArr2[i8];
                                } else if (c7 == 'L') {
                                    int i16 = i8 + 1;
                                    path.lineTo(fArr2[i8], fArr2[i16]);
                                    f19 = fArr2[i8];
                                    f20 = fArr2[i16];
                                } else if (c7 == 'M') {
                                    f19 = fArr2[i8];
                                    f20 = fArr2[i8 + 1];
                                    if (i8 > 0) {
                                        path.lineTo(f19, f20);
                                    } else {
                                        path.moveTo(f19, f20);
                                        i7 = i8;
                                        f22 = f20;
                                        f21 = f19;
                                    }
                                } else if (c7 == 'S') {
                                    if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                        f19 = (f19 * 2.0f) - f15;
                                        f20 = (f20 * 2.0f) - f16;
                                    }
                                    float f28 = f20;
                                    float f29 = f19;
                                    int i17 = i8 + 1;
                                    int i18 = i8 + 2;
                                    int i19 = i8 + 3;
                                    path.cubicTo(f29, f28, fArr2[i8], fArr2[i17], fArr2[i18], fArr2[i19]);
                                    f5 = fArr2[i8];
                                    f6 = fArr2[i17];
                                    f19 = fArr2[i18];
                                    f20 = fArr2[i19];
                                    f15 = f5;
                                    f16 = f6;
                                } else if (c7 == 'T') {
                                    if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                        f19 = (f19 * 2.0f) - f15;
                                        f20 = (f20 * 2.0f) - f16;
                                    }
                                    int i20 = i8 + 1;
                                    path.quadTo(f19, f20, fArr2[i8], fArr2[i20]);
                                    i7 = i8;
                                    f16 = f20;
                                    f15 = f19;
                                    f19 = fArr2[i8];
                                    f20 = fArr2[i20];
                                } else if (c7 == 'l') {
                                    int i21 = i8 + 1;
                                    path.rLineTo(fArr2[i8], fArr2[i21]);
                                    f19 += fArr2[i8];
                                    f8 = fArr2[i21];
                                } else if (c7 == 'm') {
                                    float f30 = fArr2[i8];
                                    f19 += f30;
                                    float f31 = fArr2[i8 + 1];
                                    f20 += f31;
                                    if (i8 > 0) {
                                        path.rLineTo(f30, f31);
                                    } else {
                                        path.rMoveTo(f30, f31);
                                        i7 = i8;
                                        f22 = f20;
                                        f21 = f19;
                                    }
                                } else if (c7 == 's') {
                                    if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                        float f32 = f19 - f15;
                                        f9 = f20 - f16;
                                        f10 = f32;
                                    } else {
                                        f10 = 0.0f;
                                        f9 = 0.0f;
                                    }
                                    int i22 = i8 + 1;
                                    int i23 = i8 + 2;
                                    int i24 = i8 + 3;
                                    path.rCubicTo(f10, f9, fArr2[i8], fArr2[i22], fArr2[i23], fArr2[i24]);
                                    f5 = fArr2[i8] + f19;
                                    f6 = fArr2[i22] + f20;
                                    f19 += fArr2[i23];
                                    f7 = fArr2[i24];
                                } else if (c7 == 't') {
                                    if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                        f11 = f19 - f15;
                                        f12 = f20 - f16;
                                    } else {
                                        f12 = 0.0f;
                                        f11 = 0.0f;
                                    }
                                    int i25 = i8 + 1;
                                    path.rQuadTo(f11, f12, fArr2[i8], fArr2[i25]);
                                    float f33 = f11 + f19;
                                    float f34 = f12 + f20;
                                    f19 += fArr2[i8];
                                    f20 += fArr2[i25];
                                    f16 = f34;
                                    f15 = f33;
                                }
                                f20 += f8;
                            } else {
                                int i26 = i8 + 1;
                                int i27 = i8 + 2;
                                int i28 = i8 + 3;
                                path.rQuadTo(fArr2[i8], fArr2[i26], fArr2[i27], fArr2[i28]);
                                f5 = fArr2[i8] + f19;
                                f6 = fArr2[i26] + f20;
                                f19 += fArr2[i27];
                                f7 = fArr2[i28];
                            }
                            i7 = i8;
                        } else {
                            int i29 = i8 + 2;
                            int i30 = i8 + 3;
                            int i31 = i8 + 4;
                            int i32 = i8 + 5;
                            path.rCubicTo(fArr2[i8], fArr2[i8 + 1], fArr2[i29], fArr2[i30], fArr2[i31], fArr2[i32]);
                            f5 = fArr2[i29] + f19;
                            f6 = fArr2[i30] + f20;
                            f19 += fArr2[i31];
                            f7 = fArr2[i32];
                        }
                        f20 += f7;
                        f15 = f5;
                        f16 = f6;
                        i7 = i8;
                    } else {
                        int i33 = i8 + 5;
                        int i34 = i8 + 6;
                        i7 = i8;
                        g(path, f19, f20, fArr2[i33] + f19, fArr2[i34] + f20, fArr2[i8], fArr2[i8 + 1], fArr2[i8 + 2], fArr2[i8 + 3] != 0.0f, fArr2[i8 + 4] != 0.0f);
                        f19 += fArr2[i33];
                        f20 += fArr2[i34];
                    }
                    i8 = i7 + i6;
                    c8 = c6;
                    c7 = c8;
                    z5 = false;
                } else {
                    i7 = i8;
                    int i35 = i7 + 5;
                    int i36 = i7 + 6;
                    g(path, f19, f20, fArr2[i35], fArr2[i36], fArr2[i7], fArr2[i7 + 1], fArr2[i7 + 2], fArr2[i7 + 3] != 0.0f, fArr2[i7 + 4] != 0.0f);
                    f19 = fArr2[i35];
                    f20 = fArr2[i36];
                }
                f16 = f20;
                f15 = f19;
                i8 = i7 + i6;
                c8 = c6;
                c7 = c8;
                z5 = false;
            }
            fArr[z5 ? 1 : 0] = f19;
            fArr[1] = f20;
            fArr[2] = f15;
            fArr[3] = f16;
            fArr[4] = f21;
            fArr[5] = f22;
        }

        private static void f(Path path, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
            double d14 = d7;
            int ceil = (int) Math.ceil(Math.abs((d13 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d11);
            double sin = Math.sin(d11);
            double cos2 = Math.cos(d12);
            double sin2 = Math.sin(d12);
            double d15 = -d14;
            double d16 = d15 * cos;
            double d17 = d8 * sin;
            double d18 = (d16 * sin2) - (d17 * cos2);
            double d19 = d15 * sin;
            double d20 = d8 * cos;
            double d21 = (sin2 * d19) + (cos2 * d20);
            double d22 = d13 / ceil;
            double d23 = d21;
            double d24 = d18;
            int i5 = 0;
            double d25 = d9;
            double d26 = d10;
            double d27 = d12;
            while (i5 < ceil) {
                double d28 = d27 + d22;
                double sin3 = Math.sin(d28);
                double cos3 = Math.cos(d28);
                double d29 = (d5 + ((d14 * cos) * cos3)) - (d17 * sin3);
                double d30 = d6 + (d14 * sin * cos3) + (d20 * sin3);
                double d31 = (d16 * sin3) - (d17 * cos3);
                double d32 = (sin3 * d19) + (cos3 * d20);
                double d33 = d28 - d27;
                double tan = Math.tan(d33 / 2.0d);
                double sin4 = (Math.sin(d33) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d34 = d25 + (d24 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d34, (float) (d26 + (d23 * sin4)), (float) (d29 - (sin4 * d31)), (float) (d30 - (sin4 * d32)), (float) d29, (float) d30);
                i5++;
                d22 = d22;
                sin = sin;
                d25 = d29;
                d19 = d19;
                cos = cos;
                d27 = d28;
                d23 = d32;
                d24 = d31;
                ceil = ceil;
                d26 = d30;
                d14 = d7;
            }
        }

        private static void g(Path path, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean z5, boolean z6) {
            double d5;
            double d6;
            double radians = Math.toRadians(f11);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d7 = f5;
            double d8 = d7 * cos;
            double d9 = f6;
            double d10 = f9;
            double d11 = (d8 + (d9 * sin)) / d10;
            double d12 = ((-f5) * sin) + (d9 * cos);
            double d13 = f10;
            double d14 = d12 / d13;
            double d15 = f8;
            double d16 = ((f7 * cos) + (d15 * sin)) / d10;
            double d17 = (((-f7) * sin) + (d15 * cos)) / d13;
            double d18 = d11 - d16;
            double d19 = d14 - d17;
            double d20 = (d11 + d16) / 2.0d;
            double d21 = (d14 + d17) / 2.0d;
            double d22 = (d18 * d18) + (d19 * d19);
            if (d22 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d23 = (1.0d / d22) - 0.25d;
            if (d23 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d22);
                float sqrt = (float) (Math.sqrt(d22) / 1.99999d);
                g(path, f5, f6, f7, f8, f9 * sqrt, f10 * sqrt, f11, z5, z6);
                return;
            }
            double sqrt2 = Math.sqrt(d23);
            double d24 = d18 * sqrt2;
            double d25 = sqrt2 * d19;
            if (z5 == z6) {
                d5 = d20 - d25;
                d6 = d21 + d24;
            } else {
                d5 = d20 + d25;
                d6 = d21 - d24;
            }
            double atan2 = Math.atan2(d14 - d6, d11 - d5);
            double atan22 = Math.atan2(d17 - d6, d16 - d5) - atan2;
            if (z6 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d26 = d5 * d10;
            double d27 = d6 * d13;
            f(path, (d26 * cos) - (d27 * sin), (d26 * sin) + (d27 * cos), d10, d13, d7, d9, radians, atan2, atan22);
        }

        public static void i(b[] bVarArr, Path path) {
            e.j(bVarArr, path);
        }

        public void h(b bVar, b bVar2, float f5) {
            this.f18725a = bVar.f18725a;
            int i5 = 0;
            while (true) {
                float[] fArr = bVar.f18726b;
                if (i5 >= fArr.length) {
                    return;
                }
                this.f18726b[i5] = (fArr[i5] * (1.0f - f5)) + (bVar2.f18726b[i5] * f5);
                i5++;
            }
        }
    }

    private static void a(ArrayList arrayList, char c5, float[] fArr) {
        arrayList.add(new b(c5, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < bVarArr.length; i5++) {
            if (bVarArr[i5].f18725a != bVarArr2[i5].f18725a || bVarArr[i5].f18726b.length != bVarArr2[i5].f18726b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i5, int i6) {
        if (i5 > i6) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i5 < 0 || i5 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i7 = i6 - i5;
        int min = Math.min(i7, length - i5);
        float[] fArr2 = new float[i7];
        System.arraycopy(fArr, i5, fArr2, 0, min);
        return fArr2;
    }

    public static b[] d(String str) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        int i6 = 1;
        while (i6 < str.length()) {
            int i7 = i(str, i6);
            String trim = str.substring(i5, i7).trim();
            if (!trim.isEmpty()) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i5 = i7;
            i6 = i7 + 1;
        }
        if (i6 - i5 == 1 && i5 < str.length()) {
            a(arrayList, str.charAt(i5), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[0]);
    }

    public static Path e(String str) {
        Path path = new Path();
        try {
            b.i(d(str), path);
            return path;
        } catch (RuntimeException e5) {
            throw new RuntimeException("Error in parsing " + str, e5);
        }
    }

    public static b[] f(b[] bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i5 = 0; i5 < bVarArr.length; i5++) {
            bVarArr2[i5] = new b(bVarArr[i5]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039 A[LOOP:0: B:2:0x0007->B:14:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void g(String str, int i5, a aVar) {
        aVar.f18724b = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (int i6 = i5; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt != ' ') {
                if (charAt != 'E' && charAt != 'e') {
                    switch (charAt) {
                        case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                            break;
                        case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                            if (i6 != i5 && !z5) {
                                aVar.f18724b = true;
                                break;
                            }
                            z5 = false;
                            break;
                        case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                            if (z6) {
                                aVar.f18724b = true;
                                break;
                            } else {
                                z5 = false;
                                z6 = true;
                                break;
                            }
                        default:
                            z5 = false;
                            break;
                    }
                } else {
                    z5 = true;
                }
                if (!z7) {
                    aVar.f18723a = i6;
                }
            }
            z5 = false;
            z7 = true;
            if (!z7) {
            }
        }
        aVar.f18723a = i6;
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i5 = 1;
            int i6 = 0;
            while (i5 < length) {
                g(str, i5, aVar);
                int i7 = aVar.f18723a;
                if (i5 < i7) {
                    fArr[i6] = Float.parseFloat(str.substring(i5, i7));
                    i6++;
                }
                i5 = aVar.f18724b ? i7 : i7 + 1;
            }
            return c(fArr, 0, i6);
        } catch (NumberFormatException e5) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e5);
        }
    }

    private static int i(String str, int i5) {
        while (i5 < str.length()) {
            char charAt = str.charAt(i5);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i5;
            }
            i5++;
        }
        return i5;
    }

    public static void j(b[] bVarArr, Path path) {
        float[] fArr = new float[6];
        char c5 = 'm';
        for (b bVar : bVarArr) {
            b.e(path, fArr, c5, bVar.f18725a, bVar.f18726b);
            c5 = bVar.f18725a;
        }
    }

    public static void k(b[] bVarArr, b[] bVarArr2) {
        for (int i5 = 0; i5 < bVarArr2.length; i5++) {
            bVarArr[i5].f18725a = bVarArr2[i5].f18725a;
            for (int i6 = 0; i6 < bVarArr2[i5].f18726b.length; i6++) {
                bVarArr[i5].f18726b[i6] = bVarArr2[i5].f18726b[i6];
            }
        }
    }
}
