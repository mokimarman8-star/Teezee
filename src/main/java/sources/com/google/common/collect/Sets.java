package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.f2;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class Sets {

    static final class UnmodifiableNavigableSet<E> extends u2 implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;
        private transient UnmodifiableNavigableSet a;
        private final NavigableSet<E> delegate;
        private final SortedSet<E> unmodifiableDelegate;

        UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) com.google.common.base.m.o(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            return this.delegate.ceiling(e);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.s2, com.google.common.collect.k2, com.google.common.collect.q2
        /* renamed from: delegate */
        public SortedSet<E> l() {
            return this.unmodifiableDelegate;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.B(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet unmodifiableNavigableSet = this.a;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet unmodifiableNavigableSet2 = new UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.a = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.a = this;
            return unmodifiableNavigableSet2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e) {
            return this.delegate.floor(e);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e, boolean z) {
            return Sets.l(this.delegate.headSet(e, z));
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            return this.delegate.higher(e);
        }

        @Override // java.util.NavigableSet
        public E lower(E e) {
            return this.delegate.lower(e);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return Sets.l(this.delegate.subSet(e, z, e2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e, boolean z) {
            return Sets.l(this.delegate.tailSet(e, z));
        }
    }

    class a extends f {
        final /* synthetic */ Set a;
        final /* synthetic */ Set b;

        /* renamed from: com.google.common.collect.Sets$a$a, reason: collision with other inner class name */
        class C0009a extends AbstractIterator {
            final Iterator c;
            final Iterator d;

            C0009a() {
                this.c = a.this.a.iterator();
                this.d = a.this.b.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            protected Object a() {
                if (this.c.hasNext()) {
                    return this.c.next();
                }
                while (this.d.hasNext()) {
                    Object next = this.d.next();
                    if (!a.this.a.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super(null);
            this.a = set;
            this.b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r4 iterator() {
            return new C0009a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.a.contains(obj) || this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.a.isEmpty() && this.b.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.a.size();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                if (!this.a.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    class b extends f {
        final /* synthetic */ Set a;
        final /* synthetic */ Set b;

        class a extends AbstractIterator {
            final Iterator c;

            a() {
                this.c = b.this.a.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            protected Object a() {
                while (this.c.hasNext()) {
                    Object next = this.c.next();
                    if (b.this.b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Set set, Set set2) {
            super(null);
            this.a = set;
            this.b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a */
        public r4 iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.a.contains(obj) && this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return this.a.containsAll(collection) && this.b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.b, this.a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator it = this.a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.b.contains(it.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    private static class c extends f2.a implements Set {
        c(Set set, com.google.common.base.n nVar) {
            super(set, nVar);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.d(this);
        }
    }

    private static class d extends c implements SortedSet {
        d(SortedSet sortedSet, com.google.common.base.n nVar) {
            super(sortedSet, nVar);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return ((SortedSet) this.a).comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return Iterators.l(this.a.iterator(), this.b);
        }

        @Override // java.util.SortedSet
        public SortedSet headSet(Object obj) {
            return new d(((SortedSet) this.a).headSet(obj), this.b);
        }

        @Override // java.util.SortedSet
        public Object last() {
            SortedSet sortedSet = (SortedSet) this.a;
            while (true) {
                Object last = sortedSet.last();
                if (this.b.apply(last)) {
                    return last;
                }
                sortedSet = sortedSet.headSet(last);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            return new d(((SortedSet) this.a).subSet(obj, obj2), this.b);
        }

        @Override // java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            return new d(((SortedSet) this.a).tailSet(obj), this.b);
        }
    }

    static abstract class e extends AbstractSet {
        e() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return Sets.i(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return super.retainAll((Collection) com.google.common.base.m.o(collection));
        }
    }

    public static abstract class f extends AbstractSet {
        private f() {
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        /* renamed from: a */
        public abstract r4 iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }
    }

    static boolean a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static Set b(Set set, com.google.common.base.n nVar) {
        if (set instanceof SortedSet) {
            return c((SortedSet) set, nVar);
        }
        if (!(set instanceof c)) {
            return new c((Set) com.google.common.base.m.o(set), (com.google.common.base.n) com.google.common.base.m.o(nVar));
        }
        c cVar = (c) set;
        return new c((Set) cVar.a, Predicates.c(cVar.b, nVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SortedSet c(SortedSet sortedSet, com.google.common.base.n nVar) {
        if (!(sortedSet instanceof c)) {
            return new d((SortedSet) com.google.common.base.m.o(sortedSet), (com.google.common.base.n) com.google.common.base.m.o(nVar));
        }
        c cVar = (c) sortedSet;
        return new d((SortedSet) cVar.a, Predicates.c(cVar.b, nVar));
    }

    static int d(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static f e(Set set, Set set2) {
        com.google.common.base.m.p(set, "set1");
        com.google.common.base.m.p(set2, "set2");
        return new b(set, set2);
    }

    public static HashSet f() {
        return new HashSet();
    }

    public static HashSet g(int i) {
        return new HashSet(Maps.d(i));
    }

    public static Set h() {
        return Collections.newSetFromMap(Maps.q());
    }

    static boolean i(Set set, Collection collection) {
        com.google.common.base.m.o(collection);
        if (collection instanceof l3) {
            collection = ((l3) collection).mo15elementSet();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? j(set, collection.iterator()) : Iterators.u(set.iterator(), collection);
    }

    static boolean j(Set set, Iterator it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static f k(Set set, Set set2) {
        com.google.common.base.m.p(set, "set1");
        com.google.common.base.m.p(set2, "set2");
        return new a(set, set2);
    }

    public static NavigableSet l(NavigableSet navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }
}
