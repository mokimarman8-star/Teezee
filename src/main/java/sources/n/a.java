package n;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f16549a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f16550b = new long[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Object[] f16551c = new Object[0];

    public static final int a(int[] iArr, int i5, int i6) {
        Intrinsics.h(iArr, "array");
        int i7 = i5 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            int i10 = iArr[i9];
            if (i10 < i6) {
                i8 = i9 + 1;
            } else {
                if (i10 <= i6) {
                    return i9;
                }
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }

    public static final int b(long[] jArr, int i5, long j5) {
        Intrinsics.h(jArr, "array");
        int i6 = i5 - 1;
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) >>> 1;
            long j6 = jArr[i8];
            if (j6 < j5) {
                i7 = i8 + 1;
            } else {
                if (j6 <= j5) {
                    return i8;
                }
                i6 = i8 - 1;
            }
        }
        return ~i7;
    }

    public static final boolean c(Object obj, Object obj2) {
        return Intrinsics.c(obj, obj2);
    }

    public static final int d(int i5) {
        for (int i6 = 4; i6 < 32; i6++) {
            int i7 = (1 << i6) - 12;
            if (i5 <= i7) {
                return i7;
            }
        }
        return i5;
    }

    public static final int e(int i5) {
        return d(i5 * 4) / 4;
    }

    public static final int f(int i5) {
        return d(i5 * 8) / 8;
    }
}
