package com.transsion.shorttv.base.image.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();
    private static final HashMap b = new HashMap();
    private static final HashMap c = new HashMap();
    private static final Map d;

    static {
        List o = CollectionsKt.o(new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '#', '$', '%', '*', '+', ',', '-', '.', ':', ';', '=', '?', '@', '[', ']', '^', '_', '{', '|', '}', '~'});
        ArrayList arrayList = new ArrayList(CollectionsKt.v(o, 10));
        int i = 0;
        for (Object obj : o) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            Character ch = (Character) obj;
            ch.charValue();
            arrayList.add(TuplesKt.a(ch, Integer.valueOf(i)));
            i = i2;
        }
        d = MapsKt.s(arrayList);
    }

    private a() {
    }

    private final Bitmap a(int i, int i2, int i3, int i4, float[][] fArr, boolean z) {
        int[] iArr = new int[i * i2];
        boolean z2 = (z && b.containsKey(Integer.valueOf(i * i3))) ? false : true;
        double[] f = f(z2, i, i3);
        boolean z3 = (z && c.containsKey(Integer.valueOf(i2 * i4))) ? false : true;
        double[] g = g(z3, i2, i4);
        int i5 = 0;
        while (i5 < i2) {
            int i6 = 0;
            while (i6 < i) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                int i7 = 0;
                while (i7 < i4) {
                    float f5 = f2;
                    float f6 = f3;
                    float f7 = f4;
                    int i8 = 0;
                    while (i8 < i3) {
                        int i9 = i8;
                        int i10 = i7;
                        int i11 = i6;
                        boolean z4 = z3;
                        i5 = i5;
                        float h = (float) (h(g, z4, i10, i4, i5, i2) * h(f, z2, i9, i3, i11, i));
                        float[] fArr2 = fArr[(i10 * i3) + i9];
                        f5 += fArr2[0] * h;
                        f6 += fArr2[1] * h;
                        f7 += fArr2[2] * h;
                        i8 = i9 + 1;
                        i7 = i10;
                        i6 = i11;
                        z3 = z4;
                    }
                    i7++;
                    f2 = f5;
                    f3 = f6;
                    f4 = f7;
                }
                int i12 = i6;
                iArr[i12 + (i * i5)] = Color.rgb(i(f2), i(f3), i(f4));
                i6 = i12 + 1;
            }
            i5++;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
        Intrinsics.g(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    private final int c(String str, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            Integer num = (Integer) d.get(Character.valueOf(str.charAt(i)));
            int intValue = num != null ? num.intValue() : -1;
            if (intValue != -1) {
                i3 = (i3 * 83) + intValue;
            }
            i++;
        }
        return i3;
    }

    private final float[] d(int i, float f) {
        return new float[]{j(((i / 361) - 9) / 9.0f) * f, j((((i / 19) % 19) - 9) / 9.0f) * f, j(((i % 19) - 9) / 9.0f) * f};
    }

    private final float[] e(int i) {
        return new float[]{k(i >> 16), k((i >> 8) & 255), k(i & 255)};
    }

    private final double[] f(boolean z, int i, int i2) {
        if (!z) {
            Object obj = b.get(Integer.valueOf(i * i2));
            Intrinsics.e(obj);
            return (double[]) obj;
        }
        int i3 = i * i2;
        double[] dArr = new double[i3];
        b.put(Integer.valueOf(i3), dArr);
        return dArr;
    }

    private final double[] g(boolean z, int i, int i2) {
        if (!z) {
            Object obj = c.get(Integer.valueOf(i * i2));
            Intrinsics.e(obj);
            return (double[]) obj;
        }
        int i3 = i * i2;
        double[] dArr = new double[i3];
        c.put(Integer.valueOf(i3), dArr);
        return dArr;
    }

    private final double h(double[] dArr, boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            dArr[(i2 * i3) + i] = Math.cos(((i3 * 3.141592653589793d) * i) / i4);
        }
        return dArr[i + (i2 * i3)];
    }

    private final int i(float f) {
        float pow;
        float f2;
        float k = RangesKt.k(f, 0.0f, 1.0f);
        if (k <= 0.0031308f) {
            pow = k * 12.92f;
            f2 = 255.0f;
        } else {
            pow = (((float) Math.pow(k, 0.41666666f)) * 1.055f) - 0.055f;
            f2 = 255;
        }
        return (int) ((pow * f2) + 0.5f);
    }

    private final float j(float f) {
        return Math.copySign((float) Math.pow(f, 2.0f), f);
    }

    private final float k(int i) {
        float f = i / 255.0f;
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4f);
    }

    public final Bitmap b(String str, int i, int i2, float f, boolean z) {
        float[] d2;
        if (str == null || str.length() < 6) {
            return null;
        }
        int c2 = c(str, 0, 1);
        int i3 = (c2 % 9) + 1;
        int i4 = (c2 / 9) + 1;
        if (str.length() != (i3 * 2 * i4) + 4) {
            return null;
        }
        float c3 = (c(str, 1, 2) + 1) / 166.0f;
        int i5 = i3 * i4;
        float[][] fArr = new float[i5][];
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 == 0) {
                a aVar = a;
                d2 = aVar.e(aVar.c(str, 2, 6));
            } else {
                int i7 = i6 * 2;
                a aVar2 = a;
                d2 = aVar2.d(aVar2.c(str, i7 + 4, i7 + 6), c3 * f);
            }
            fArr[i6] = d2;
        }
        return a(i, i2, i3, i4, fArr, z);
    }
}
