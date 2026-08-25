package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class g extends ArraysKt___ArraysJvmKt {
    public static List A0(byte[] bArr, int i) {
        Intrinsics.h(bArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.l();
        }
        if (i >= bArr.length) {
            return E0(bArr);
        }
        if (i == 1) {
            return CollectionsKt.e(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf(b));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    public static final List B0(Object[] objArr, int i) {
        Intrinsics.h(objArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.l();
        }
        int length = objArr.length;
        if (i >= length) {
            return ArraysKt.G0(objArr);
        }
        if (i == 1) {
            return CollectionsKt.e(objArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(objArr[i2]);
        }
        return arrayList;
    }

    public static final Collection C0(int[] iArr, Collection destination) {
        Intrinsics.h(iArr, "<this>");
        Intrinsics.h(destination, "destination");
        for (int i : iArr) {
            destination.add(Integer.valueOf(i));
        }
        return destination;
    }

    public static final Collection D0(Object[] objArr, Collection destination) {
        Intrinsics.h(objArr, "<this>");
        Intrinsics.h(destination, "destination");
        for (Object obj : objArr) {
            destination.add(obj);
        }
        return destination;
    }

    public static final List E0(byte[] bArr) {
        Intrinsics.h(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? H0(bArr) : CollectionsKt.e(Byte.valueOf(bArr[0])) : CollectionsKt.l();
    }

    public static List F0(long[] jArr) {
        Intrinsics.h(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? I0(jArr) : CollectionsKt.e(Long.valueOf(jArr[0])) : CollectionsKt.l();
    }

    public static List G0(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? ArraysKt.J0(objArr) : CollectionsKt.e(objArr[0]) : CollectionsKt.l();
    }

    public static boolean H(byte[] bArr, byte b) {
        Intrinsics.h(bArr, "<this>");
        return ArraysKt.a0(bArr, b) >= 0;
    }

    public static final List H0(byte[] bArr) {
        Intrinsics.h(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    public static boolean I(char[] cArr, char c) {
        Intrinsics.h(cArr, "<this>");
        return b0(cArr, c) >= 0;
    }

    public static final List I0(long[] jArr) {
        Intrinsics.h(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static boolean J(int[] iArr, int i) {
        Intrinsics.h(iArr, "<this>");
        return ArraysKt.c0(iArr, i) >= 0;
    }

    public static List J0(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        return new ArrayList(j.i(objArr));
    }

    public static boolean K(long[] jArr, long j) {
        Intrinsics.h(jArr, "<this>");
        return ArraysKt.d0(jArr, j) >= 0;
    }

    public static Set K0(int[] iArr) {
        Intrinsics.h(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? (Set) C0(iArr, new LinkedHashSet(MapsKt.e(iArr.length))) : SetsKt.d(Integer.valueOf(iArr[0])) : SetsKt.f();
    }

    public static boolean L(Object[] objArr, Object obj) {
        Intrinsics.h(objArr, "<this>");
        return ArraysKt.e0(objArr, obj) >= 0;
    }

    public static final Set L0(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? (Set) D0(objArr, new LinkedHashSet(MapsKt.e(objArr.length))) : SetsKt.d(objArr[0]) : SetsKt.f();
    }

    public static boolean M(short[] sArr, short s) {
        Intrinsics.h(sArr, "<this>");
        return ArraysKt.f0(sArr, s) >= 0;
    }

    public static Iterable M0(final Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator N0;
                N0 = g.N0(objArr);
                return N0;
            }
        });
    }

    public static final boolean N(boolean[] zArr, boolean z) {
        Intrinsics.h(zArr, "<this>");
        return g0(zArr, z) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator N0(Object[] objArr) {
        return ArrayIteratorKt.a(objArr);
    }

    public static List O(Object[] objArr, int i) {
        Intrinsics.h(objArr, "<this>");
        if (i >= 0) {
            return B0(objArr, RangesKt.e(objArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static List P(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        return (List) Q(objArr, new ArrayList());
    }

    public static final Collection Q(Object[] objArr, Collection destination) {
        Intrinsics.h(objArr, "<this>");
        Intrinsics.h(destination, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static int R(int[] iArr) {
        Intrinsics.h(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object S(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Integer T(int[] iArr) {
        Intrinsics.h(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    public static Object U(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        if (objArr.length == 0) {
            return null;
        }
        return objArr[0];
    }

    public static IntRange V(int[] iArr) {
        Intrinsics.h(iArr, "<this>");
        return new IntRange(0, ArraysKt.W(iArr));
    }

    public static int W(int[] iArr) {
        Intrinsics.h(iArr, "<this>");
        return iArr.length - 1;
    }

    public static int X(long[] jArr) {
        Intrinsics.h(jArr, "<this>");
        return jArr.length - 1;
    }

    public static int Y(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Object Z(Object[] objArr, int i) {
        Intrinsics.h(objArr, "<this>");
        if (i < 0 || i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public static int a0(byte[] bArr, byte b) {
        Intrinsics.h(bArr, "<this>");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int b0(char[] cArr, char c) {
        Intrinsics.h(cArr, "<this>");
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (c == cArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int c0(int[] iArr, int i) {
        Intrinsics.h(iArr, "<this>");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static int d0(long[] jArr, long j) {
        Intrinsics.h(jArr, "<this>");
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (j == jArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int e0(Object[] objArr, Object obj) {
        Intrinsics.h(objArr, "<this>");
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (Intrinsics.c(obj, objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int f0(short[] sArr, short s) {
        Intrinsics.h(sArr, "<this>");
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (s == sArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int g0(boolean[] zArr, boolean z) {
        Intrinsics.h(zArr, "<this>");
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (z == zArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final Appendable h0(byte[] bArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1 function1) {
        Intrinsics.h(bArr, "<this>");
        Intrinsics.h(buffer, "buffer");
        Intrinsics.h(separator, "separator");
        Intrinsics.h(prefix, "prefix");
        Intrinsics.h(postfix, "postfix");
        Intrinsics.h(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                buffer.append((CharSequence) function1.invoke(Byte.valueOf(b)));
            } else {
                buffer.append(String.valueOf((int) b));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Appendable i0(Object[] objArr, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1 function1) {
        Intrinsics.h(objArr, "<this>");
        Intrinsics.h(buffer, "buffer");
        Intrinsics.h(separator, "separator");
        Intrinsics.h(prefix, "prefix");
        Intrinsics.h(postfix, "postfix");
        Intrinsics.h(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (Object obj : objArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            StringsKt.a(buffer, obj, function1);
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String j0(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1 function1) {
        Intrinsics.h(bArr, "<this>");
        Intrinsics.h(separator, "separator");
        Intrinsics.h(prefix, "prefix");
        Intrinsics.h(postfix, "postfix");
        Intrinsics.h(truncated, "truncated");
        return ((StringBuilder) h0(bArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
    }

    public static final String k0(Object[] objArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1 function1) {
        Intrinsics.h(objArr, "<this>");
        Intrinsics.h(separator, "separator");
        Intrinsics.h(prefix, "prefix");
        Intrinsics.h(postfix, "postfix");
        Intrinsics.h(truncated, "truncated");
        return ((StringBuilder) i0(objArr, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
    }

    public static /* synthetic */ String l0(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        int i3 = i2 & 2;
        CharSequence charSequence5 = HttpUrl.FRAGMENT_ENCODE_SET;
        CharSequence charSequence6 = i3 != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i4 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return j0(bArr, charSequence, charSequence6, charSequence5, i4, charSequence7, function1);
    }

    public static /* synthetic */ String m0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        int i3 = i2 & 2;
        CharSequence charSequence5 = HttpUrl.FRAGMENT_ENCODE_SET;
        CharSequence charSequence6 = i3 != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i4 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return k0(objArr, charSequence, charSequence6, charSequence5, i4, charSequence7, function1);
    }

    public static Object n0(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[ArraysKt.Y(objArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static int o0(byte[] bArr, byte b) {
        Intrinsics.h(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (b == bArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static final int p0(char[] cArr, char c) {
        Intrinsics.h(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (c == cArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static int q0(int[] iArr, int i) {
        Intrinsics.h(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (i == iArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static int r0(long[] jArr, long j) {
        Intrinsics.h(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (j == jArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static int s0(Object[] objArr, Object obj) {
        Intrinsics.h(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (objArr[length] == null) {
                        return length;
                    }
                    if (i < 0) {
                        break;
                    }
                    length = i;
                }
            }
        } else {
            int length2 = objArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i2 = length2 - 1;
                    if (Intrinsics.c(obj, objArr[length2])) {
                        return length2;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    length2 = i2;
                }
            }
        }
        return -1;
    }

    public static int t0(short[] sArr, short s) {
        Intrinsics.h(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (s == sArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static final int u0(boolean[] zArr, boolean z) {
        Intrinsics.h(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (z == zArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static Object v0(Object[] objArr, Random random) {
        Intrinsics.h(objArr, "<this>");
        Intrinsics.h(random, "random");
        if (objArr.length != 0) {
            return objArr[random.nextInt(objArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static char w0(char[] cArr) {
        Intrinsics.h(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object x0(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static List y0(Comparable[] comparableArr) {
        Intrinsics.h(comparableArr, "<this>");
        return ArraysKt.g(z0(comparableArr));
    }

    public static final Comparable[] z0(Comparable[] comparableArr) {
        Intrinsics.h(comparableArr, "<this>");
        if (comparableArr.length == 0) {
            return comparableArr;
        }
        Object[] copyOf = Arrays.copyOf(comparableArr, comparableArr.length);
        Intrinsics.g(copyOf, "copyOf(...)");
        Comparable[] comparableArr2 = (Comparable[]) copyOf;
        ArraysKt.D(comparableArr2);
        return comparableArr2;
    }
}
