package com.google.common.collect;

import com.google.common.collect.Sets;
import com.google.common.collect.l3;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class Multisets {

    private static final class DecreasingCount implements Comparator<l3.a> {
        static final Comparator<l3.a> INSTANCE = new DecreasingCount();

        private DecreasingCount() {
        }

        @Override // java.util.Comparator
        public int compare(l3.a aVar, l3.a aVar2) {
            return aVar2.getCount() - aVar.getCount();
        }
    }

    static class ImmutableEntry<E> extends b implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        private final E element;

        ImmutableEntry(E e, int i) {
            this.element = e;
            this.count = i;
            e2.b(i, "count");
        }

        @Override // com.google.common.collect.l3.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.l3.a
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    class a extends o4 {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.o4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(l3.a aVar) {
            return aVar.getElement();
        }
    }

    static abstract class b implements l3.a {
        b() {
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof l3.a)) {
                return false;
            }
            l3.a aVar = (l3.a) obj;
            return getCount() == aVar.getCount() && com.google.common.base.j.a(getElement(), aVar.getElement());
        }

        public int hashCode() {
            Object element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.l3.a
        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    static abstract class c extends Sets.e {
        c() {
        }

        abstract l3 a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return a().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return a().remove(obj, com.google.protobuf.h1.READ_DONE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().mo17entrySet().size();
        }
    }

    static abstract class d extends Sets.e {
        d() {
        }

        abstract l3 a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof l3.a)) {
                return false;
            }
            l3.a aVar = (l3.a) obj;
            return aVar.getCount() > 0 && a().count(aVar.getElement()) == aVar.getCount();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof l3.a) {
                l3.a aVar = (l3.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return a().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    static final class e implements Iterator {
        private final l3 a;
        private final Iterator b;
        private l3.a c;
        private int d;
        private int e;
        private boolean f;

        e(l3 l3Var, Iterator it) {
            this.a = l3Var;
            this.b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.d == 0) {
                l3.a aVar = (l3.a) this.b.next();
                this.c = aVar;
                int count = aVar.getCount();
                this.d = count;
                this.e = count;
            }
            this.d--;
            this.f = true;
            l3.a aVar2 = this.c;
            Objects.requireNonNull(aVar2);
            return aVar2.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            e2.e(this.f);
            if (this.e == 1) {
                this.b.remove();
            } else {
                l3 l3Var = this.a;
                l3.a aVar = this.c;
                Objects.requireNonNull(aVar);
                l3Var.remove(aVar.getElement());
            }
            this.e--;
            this.f = false;
        }
    }

    private static boolean a(l3 l3Var, AbstractMapBasedMultiset abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(l3Var);
        return true;
    }

    private static boolean b(l3 l3Var, l3 l3Var2) {
        if (l3Var2 instanceof AbstractMapBasedMultiset) {
            return a(l3Var, (AbstractMapBasedMultiset) l3Var2);
        }
        if (l3Var2.isEmpty()) {
            return false;
        }
        for (l3.a aVar : l3Var2.mo17entrySet()) {
            l3Var.add(aVar.getElement(), aVar.getCount());
        }
        return true;
    }

    static boolean c(l3 l3Var, Collection collection) {
        com.google.common.base.m.o(l3Var);
        com.google.common.base.m.o(collection);
        if (collection instanceof l3) {
            return b(l3Var, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(l3Var, collection.iterator());
    }

    static l3 d(Iterable iterable) {
        return (l3) iterable;
    }

    static Iterator e(Iterator it) {
        return new a(it);
    }

    static boolean f(l3 l3Var, Object obj) {
        if (obj == l3Var) {
            return true;
        }
        if (obj instanceof l3) {
            l3 l3Var2 = (l3) obj;
            if (l3Var.size() == l3Var2.size() && l3Var.mo17entrySet().size() == l3Var2.mo17entrySet().size()) {
                for (l3.a aVar : l3Var2.mo17entrySet()) {
                    if (l3Var.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static l3.a g(Object obj, int i) {
        return new ImmutableEntry(obj, i);
    }

    static int h(Iterable iterable) {
        if (iterable instanceof l3) {
            return ((l3) iterable).mo15elementSet().size();
        }
        return 11;
    }

    static Iterator i(l3 l3Var) {
        return new e(l3Var, l3Var.mo17entrySet().iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean j(l3 l3Var, Collection collection) {
        if (collection instanceof l3) {
            collection = ((l3) collection).mo15elementSet();
        }
        return l3Var.mo15elementSet().removeAll(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean k(l3 l3Var, Collection collection) {
        com.google.common.base.m.o(collection);
        if (collection instanceof l3) {
            collection = ((l3) collection).mo15elementSet();
        }
        return l3Var.mo15elementSet().retainAll(collection);
    }

    static int l(l3 l3Var, Object obj, int i) {
        e2.b(i, "count");
        int count = l3Var.count(obj);
        int i2 = i - count;
        if (i2 > 0) {
            l3Var.add(obj, i2);
        } else if (i2 < 0) {
            l3Var.remove(obj, -i2);
        }
        return count;
    }

    static boolean m(l3 l3Var, Object obj, int i, int i2) {
        e2.b(i, "oldCount");
        e2.b(i2, "newCount");
        if (l3Var.count(obj) != i) {
            return false;
        }
        l3Var.setCount(obj, i2);
        return true;
    }
}
