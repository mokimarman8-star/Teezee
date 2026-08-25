package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class j extends i {
    public static ArrayList h(Object... elements) {
        Intrinsics.h(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new c(elements, true));
    }

    public static final Collection i(Object[] objArr) {
        Intrinsics.h(objArr, "<this>");
        return new c(objArr, false);
    }

    public static final int j(List list, Comparable comparable, int i, int i2) {
        Intrinsics.h(list, "<this>");
        s(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int d = ComparisonsKt.d((Comparable) list.get(i4), comparable);
            if (d < 0) {
                i = i4 + 1;
            } else {
                if (d <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int k(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return j(list, comparable, i, i2);
    }

    public static List l() {
        return EmptyList.INSTANCE;
    }

    public static IntRange m(Collection collection) {
        Intrinsics.h(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static int n(List list) {
        Intrinsics.h(list, "<this>");
        return list.size() - 1;
    }

    public static List o(Object... elements) {
        Intrinsics.h(elements, "elements");
        return elements.length > 0 ? ArraysKt.g(elements) : CollectionsKt.l();
    }

    public static List p(Object... elements) {
        Intrinsics.h(elements, "elements");
        return ArraysKt.P(elements);
    }

    public static List q(Object... elements) {
        Intrinsics.h(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new c(elements, true));
    }

    public static final List r(List list) {
        Intrinsics.h(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : CollectionsKt.e(list.get(0)) : CollectionsKt.l();
    }

    private static final void s(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }

    public static void t() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void u() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
