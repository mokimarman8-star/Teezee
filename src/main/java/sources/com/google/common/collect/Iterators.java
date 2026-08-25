package com.google.common.collect;

import com.google.common.base.f;
import com.google.common.base.j;
import com.google.common.base.m;
import com.google.common.base.n;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class Iterators {
    public static Iterator A(Iterator it, f fVar) {
        m.o(fVar);
        return new c(it, fVar);
    }

    public static r4 B(Iterator it) {
        m.o(it);
        return it instanceof r4 ? (r4) it : new a(it);
    }

    public static boolean a(Collection collection, Iterator it) {
        m.o(collection);
        m.o(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static int b(Iterator it, int i) {
        m.o(it);
        int i2 = 0;
        m.e(i >= 0, "numberToAdvance must be nonnegative");
        while (i2 < i && it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }

    public static boolean c(Iterator it, n nVar) {
        return q(it, nVar) != -1;
    }

    static void d(Iterator it) {
        m.o(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static Iterator e(Iterator it) {
        return new e(it);
    }

    public static boolean f(Iterator it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !j.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    static r4 h() {
        return i();
    }

    static s4 i() {
        return d.d;
    }

    static Iterator j() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static r4 k(Iterator it, n nVar) {
        m.o(it);
        m.o(nVar);
        return new b(it, nVar);
    }

    public static Object l(Iterator it, n nVar) {
        m.o(it);
        m.o(nVar);
        while (it.hasNext()) {
            Object next = it.next();
            if (nVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static Object m(Iterator it) {
        Object next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object n(Iterator it, Object obj) {
        return it.hasNext() ? m(it) : obj;
    }

    public static Object o(Iterator it, Object obj) {
        return it.hasNext() ? it.next() : obj;
    }

    public static Object p(Iterator it) {
        Object next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    public static int q(Iterator it, n nVar) {
        m.p(nVar, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (nVar.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static r4 r(Iterable iterable, Comparator comparator) {
        m.p(iterable, "iterators");
        m.p(comparator, "comparator");
        return new f(iterable, comparator);
    }

    public static q3 s(Iterator it) {
        return it instanceof g ? (g) it : new g(it);
    }

    static Object t(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        it.remove();
        return next;
    }

    public static boolean u(Iterator it, Collection collection) {
        m.o(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean v(Iterator it, n nVar) {
        m.o(nVar);
        boolean z = false;
        while (it.hasNext()) {
            if (nVar.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean w(Iterator it, Collection collection) {
        m.o(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static r4 x(Object obj) {
        return new h(obj);
    }

    public static int y(Iterator it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return Ints.n(j);
    }

    public static String z(Iterator it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(it.next());
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }
}
