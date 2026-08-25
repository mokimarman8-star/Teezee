package androidx.collection;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class v0 {

    /* renamed from: a, reason: collision with root package name */
    public static final long[] f1350a = {-9187201950435737345L, -1};

    /* renamed from: b, reason: collision with root package name */
    private static final n0 f1351b = new n0(0);

    public static final void a(long[] jArr, int i5) {
        Intrinsics.h(jArr, "metadata");
        int i6 = (i5 + 7) >> 3;
        for (int i7 = 0; i7 < i6; i7++) {
            long j5 = jArr[i7] & (-9187201950435737472L);
            jArr[i7] = (-72340172838076674L) & ((~j5) + (j5 >>> 7));
        }
        int X = ArraysKt.X(jArr);
        int i8 = X - 1;
        jArr[i8] = (jArr[i8] & 72057594037927935L) | (-72057594037927936L);
        jArr[X] = jArr[0];
    }

    public static final int b(long[] jArr, int i5, int i6) {
        Intrinsics.h(jArr, "metadata");
        while (i5 < i6) {
            if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) == 128) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final int c(int i5) {
        if (i5 == 7) {
            return 6;
        }
        return i5 - (i5 / 8);
    }

    public static final n0 d() {
        return new n0(0, 1, null);
    }

    public static final int e(int i5) {
        if (i5 == 0) {
            return 6;
        }
        return (i5 * 2) + 1;
    }

    public static final int f(int i5) {
        if (i5 > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i5);
        }
        return 0;
    }

    public static final int g(int i5) {
        if (i5 == 7) {
            return 8;
        }
        return i5 + ((i5 - 1) / 7);
    }
}
