package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class CollectionsKt___CollectionsKt extends p {
    public static List A0(Iterable iterable, Iterable iterable2) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(iterable2, "elements");
        if (iterable instanceof Collection) {
            return CollectionsKt.B0((Collection) iterable, iterable2);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.B(arrayList, iterable);
        CollectionsKt.B(arrayList, iterable2);
        return arrayList;
    }

    public static List B0(Collection collection, Iterable iterable) {
        Intrinsics.h(collection, "<this>");
        Intrinsics.h(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            CollectionsKt.B(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List C0(Collection collection, Object obj) {
        Intrinsics.h(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static List D0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return CollectionsKt.R0(iterable);
        }
        List T0 = T0(iterable);
        CollectionsKt.Y(T0);
        return T0;
    }

    public static Object E0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        if (iterable instanceof List) {
            return F0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final Object F0(List list) {
        Intrinsics.h(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static Object G0(List list) {
        Intrinsics.h(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List H0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List T0 = T0(iterable);
            CollectionsKt.z(T0);
            return T0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return CollectionsKt.R0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        ArraysKt.D((Comparable[]) array);
        return ArraysKt.g(array);
    }

    public static List I0(Iterable iterable, Comparator comparator) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List T0 = T0(iterable);
            CollectionsKt.A(T0, comparator);
            return T0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return CollectionsKt.R0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        ArraysKt___ArraysJvmKt.E(array, comparator);
        return ArraysKt.g(array);
    }

    public static Set J0(Iterable iterable, Iterable iterable2) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(iterable2, "other");
        Set V0 = CollectionsKt.V0(iterable);
        n.H(V0, iterable2);
        return V0;
    }

    public static List K0(Iterable iterable, int i) {
        Intrinsics.h(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.l();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return CollectionsKt.R0(iterable);
            }
            if (i == 1) {
                return CollectionsKt.e(CollectionsKt.h0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return j.r(arrayList);
    }

    public static List L0(List list, int i) {
        Intrinsics.h(list, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.l();
        }
        int size = list.size();
        if (i >= size) {
            return CollectionsKt.R0(list);
        }
        if (i == 1) {
            return CollectionsKt.e(CollectionsKt.u0(list));
        }
        ArrayList arrayList = new ArrayList(i);
        if (list instanceof RandomAccess) {
            for (int i2 = size - i; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
        } else {
            ListIterator listIterator = list.listIterator(size - i);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static boolean[] M0(Collection collection) {
        Intrinsics.h(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr[i] = ((Boolean) it.next()).booleanValue();
            i++;
        }
        return zArr;
    }

    public static byte[] N0(Collection collection) {
        Intrinsics.h(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr[i] = ((Number) it.next()).byteValue();
            i++;
        }
        return bArr;
    }

    public static final Collection O0(Iterable iterable, Collection collection) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(collection, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static HashSet P0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        return (HashSet) O0(iterable, new HashSet(MapsKt.e(CollectionsKt.v(iterable, 12))));
    }

    public static int[] Q0(Collection collection) {
        Intrinsics.h(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List R0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return j.r(T0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return CollectionsKt.l();
        }
        if (size != 1) {
            return CollectionsKt.U0(collection);
        }
        return CollectionsKt.e(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static long[] S0(Collection collection) {
        Intrinsics.h(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = ((Number) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public static final List T0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        return iterable instanceof Collection ? CollectionsKt.U0((Collection) iterable) : (List) O0(iterable, new ArrayList());
    }

    public static List U0(Collection collection) {
        Intrinsics.h(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set V0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) O0(iterable, new LinkedHashSet());
    }

    public static Set W0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return z.i((Set) O0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return SetsKt.f();
        }
        if (size != 1) {
            return (Set) O0(iterable, new LinkedHashSet(MapsKt.e(collection.size())));
        }
        return SetsKt.d(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static Set X0(Iterable iterable, Iterable iterable2) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(iterable2, "other");
        Set V0 = CollectionsKt.V0(iterable);
        CollectionsKt.B(V0, iterable2);
        return V0;
    }

    public static final List Y0(Iterable iterable, int i, int i2, boolean z) {
        Intrinsics.h(iterable, "<this>");
        SlidingWindowKt.a(i, i2);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator b = SlidingWindowKt.b(iterable.iterator(), i, i2, z, false);
            while (b.hasNext()) {
                arrayList.add((List) b.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i2) + (size % i2 == 0 ? 0 : 1));
        int i3 = 0;
        while (i3 >= 0 && i3 < size) {
            int h = RangesKt.h(i, size - i3);
            if (h < i && !z) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(h);
            for (int i4 = 0; i4 < h; i4++) {
                arrayList3.add(list.get(i4 + i3));
            }
            arrayList2.add(arrayList3);
            i3 += i2;
        }
        return arrayList2;
    }

    public static Sequence Z(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        return new CollectionsKt___CollectionsKt$asSequence$.inlined.Sequence.1(iterable);
    }

    public static List Z0(Iterable iterable, Iterable iterable2) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.v(iterable, 10), CollectionsKt.v(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(TuplesKt.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static List a0(Iterable iterable, int i) {
        Intrinsics.h(iterable, "<this>");
        return Y0(iterable, i, i, true);
    }

    public static boolean b0(Iterable iterable, Object obj) {
        Intrinsics.h(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : m0(iterable, obj) >= 0;
    }

    public static List c0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        return CollectionsKt.R0(CollectionsKt.V0(iterable));
    }

    public static List d0(Iterable iterable, int i) {
        ArrayList arrayList;
        Intrinsics.h(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.R0(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i;
            if (size <= 0) {
                return CollectionsKt.l();
            }
            if (size == 1) {
                return CollectionsKt.e(CollectionsKt.t0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i < size2) {
                        arrayList.add(list.get(i));
                        i++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= i) {
                arrayList.add(obj);
            } else {
                i2++;
            }
        }
        return j.r(arrayList);
    }

    public static List e0(List list, int i) {
        Intrinsics.h(list, "<this>");
        if (i >= 0) {
            return CollectionsKt.K0(list, RangesKt.e(list.size() - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static List f0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        return (List) g0(iterable, new ArrayList());
    }

    public static final Collection g0(Iterable iterable, Collection collection) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(collection, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static Object h0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        if (iterable instanceof List) {
            return CollectionsKt.i0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object i0(List list) {
        Intrinsics.h(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object j0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object k0(List list) {
        Intrinsics.h(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object l0(List list, int i) {
        Intrinsics.h(list, "<this>");
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static final int m0(Iterable iterable, Object obj) {
        Intrinsics.h(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i = 0;
        for (Object obj2 : iterable) {
            if (i < 0) {
                CollectionsKt.u();
            }
            if (Intrinsics.c(obj, obj2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int n0(List list, Object obj) {
        Intrinsics.h(list, "<this>");
        return list.indexOf(obj);
    }

    public static Set o0(Iterable iterable, Iterable iterable2) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(iterable2, "other");
        Set V0 = CollectionsKt.V0(iterable);
        n.O(V0, iterable2);
        return V0;
    }

    public static final Appendable p0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(appendable, "buffer");
        Intrinsics.h(charSequence, "separator");
        Intrinsics.h(charSequence2, "prefix");
        Intrinsics.h(charSequence3, "postfix");
        Intrinsics.h(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            StringsKt.a(appendable, obj, function1);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String r0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(charSequence, "separator");
        Intrinsics.h(charSequence2, "prefix");
        Intrinsics.h(charSequence3, "postfix");
        Intrinsics.h(charSequence4, "truncated");
        return ((StringBuilder) p0(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
    }

    public static /* synthetic */ String s0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return r0(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    public static Object t0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        if (iterable instanceof List) {
            return CollectionsKt.u0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Object u0(List list) {
        Intrinsics.h(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(CollectionsKt.n(list));
    }

    public static Object v0(List list) {
        Intrinsics.h(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable w0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static Object x0(Iterable iterable, Comparator comparator) {
        Intrinsics.h(iterable, "<this>");
        Intrinsics.h(comparator, "comparator");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static Comparable y0(Iterable iterable) {
        Intrinsics.h(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static List z0(Iterable iterable, Object obj) {
        Intrinsics.h(iterable, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.v(iterable, 10));
        boolean z = false;
        for (Object obj2 : iterable) {
            boolean z2 = true;
            if (!z && Intrinsics.c(obj2, obj)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }
}
