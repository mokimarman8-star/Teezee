package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ArraysKt___ArraysJvmKt extends e {
    public static int[] A(int[] iArr, int i) {
        Intrinsics.h(iArr, "<this>");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        copyOf[length] = i;
        Intrinsics.e(copyOf);
        return copyOf;
    }

    public static int[] B(int[] iArr, int[] elements) {
        Intrinsics.h(iArr, "<this>");
        Intrinsics.h(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] copyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        Intrinsics.e(copyOf);
        return copyOf;
    }

    public static Object[] C(Object[] objArr, Object obj) {
        Intrinsics.h(objArr, "<this>");
        int length = objArr.length;
        Object[] copyOf = Arrays.copyOf(objArr, length + 1);
        copyOf[length] = obj;
        Intrinsics.e(copyOf);
        return copyOf;
    }

    public static void D(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }

    public static final void E(Object[] objArr, Comparator comparator) {
        Intrinsics.h(objArr, "<this>");
        Intrinsics.h(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }

    public static void F(Object[] objArr, Comparator comparator, int i, int i2) {
        Intrinsics.h(objArr, "<this>");
        Intrinsics.h(comparator, "comparator");
        Arrays.sort(objArr, i, i2, comparator);
    }

    public static List e(byte[] bArr) {
        Intrinsics.h(bArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$1(bArr);
    }

    public static List f(int[] iArr) {
        Intrinsics.h(iArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$3(iArr);
    }

    public static List g(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        List a = h.a(objArr);
        Intrinsics.g(a, "asList(...)");
        return a;
    }

    public static byte[] h(byte[] bArr, byte[] destination, int i, int i2, int i3) {
        Intrinsics.h(bArr, "<this>");
        Intrinsics.h(destination, "destination");
        System.arraycopy(bArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static float[] i(float[] fArr, float[] destination, int i, int i2, int i3) {
        Intrinsics.h(fArr, "<this>");
        Intrinsics.h(destination, "destination");
        System.arraycopy(fArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static int[] j(int[] iArr, int[] destination, int i, int i2, int i3) {
        Intrinsics.h(iArr, "<this>");
        Intrinsics.h(destination, "destination");
        System.arraycopy(iArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static long[] k(long[] jArr, long[] destination, int i, int i2, int i3) {
        Intrinsics.h(jArr, "<this>");
        Intrinsics.h(destination, "destination");
        System.arraycopy(jArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static Object[] l(Object[] objArr, Object[] destination, int i, int i2, int i3) {
        Intrinsics.h(objArr, "<this>");
        Intrinsics.h(destination, "destination");
        System.arraycopy(objArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static /* synthetic */ byte[] m(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return ArraysKt.h(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ float[] n(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length;
        }
        return ArraysKt.i(fArr, fArr2, i, i2, i3);
    }

    public static /* synthetic */ int[] o(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return ArraysKt.j(iArr, iArr2, i, i2, i3);
    }

    public static /* synthetic */ Object[] p(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return ArraysKt.l(objArr, objArr2, i, i2, i3);
    }

    public static byte[] q(byte[] bArr, int i, int i2) {
        Intrinsics.h(bArr, "<this>");
        d.b(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        Intrinsics.g(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static Object[] r(Object[] objArr, int i, int i2) {
        Intrinsics.h(objArr, "<this>");
        d.b(i2, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i, i2);
        Intrinsics.g(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static final void s(int[] iArr, int i, int i2, int i3) {
        Intrinsics.h(iArr, "<this>");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static final void t(long[] jArr, long j, int i, int i2) {
        Intrinsics.h(jArr, "<this>");
        Arrays.fill(jArr, i, i2, j);
    }

    public static void u(Object[] objArr, Object obj, int i, int i2) {
        Intrinsics.h(objArr, "<this>");
        Arrays.fill(objArr, i, i2, obj);
    }

    public static final void v(boolean[] zArr, boolean z, int i, int i2) {
        Intrinsics.h(zArr, "<this>");
        Arrays.fill(zArr, i, i2, z);
    }

    public static /* synthetic */ void w(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        s(iArr, i, i2, i3);
    }

    public static /* synthetic */ void x(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        t(jArr, j, i, i2);
    }

    public static /* synthetic */ void y(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        ArraysKt.u(objArr, obj, i, i2);
    }

    public static /* synthetic */ void z(boolean[] zArr, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = zArr.length;
        }
        v(zArr, z, i, i2);
    }
}
