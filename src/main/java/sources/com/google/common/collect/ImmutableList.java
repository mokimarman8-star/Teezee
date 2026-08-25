package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.stream.Collector;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final s4 EMPTY_ITR = new b(RegularImmutableList.EMPTY, 0);
    private static final long serialVersionUID = -889275714;

    private static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList a;

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.a = immutableList;
        }

        private int a(int i) {
            return (size() - 1) - i;
        }

        private int b(int i) {
            return size() - i;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.a.contains(obj);
        }

        @Override // java.util.List
        public E get(int i) {
            com.google.common.base.m.m(i, size());
            return this.a.get(a(i));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            int lastIndexOf = this.a.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return a(lastIndexOf);
            }
            return -1;
        }

        boolean isPartialView() {
            return this.a.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            int indexOf = this.a.indexOf(obj);
            if (indexOf >= 0) {
                return a(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.a;
        }

        @Override // java.util.List, java.util.Collection
        public int size() {
            return this.a.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i, int i2) {
            com.google.common.base.m.t(i, i2, size());
            return this.a.subList(b(i2), b(i)).reverse();
        }

        @Override // com.google.common.collect.ImmutableList
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;

        SubList(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        @Override // java.util.List
        public E get(int i) {
            com.google.common.base.m.m(i, this.length);
            return ImmutableList.this.get(i + this.offset);
        }

        Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.offset;
        }

        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }

        @Override // java.util.List, java.util.Collection
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i, int i2) {
            com.google.common.base.m.t(i, i2, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i3 = this.offset;
            return immutableList.subList(i + i3, i2 + i3);
        }

        @Override // com.google.common.collect.ImmutableList
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    public static final class a extends ImmutableCollection$a {
        public a() {
            this(4);
        }

        a(int i) {
            super(i);
        }

        @Override // com.google.common.collect.ImmutableCollection$b
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            super.g(obj);
            return this;
        }

        public a k(Object... objArr) {
            super.b(objArr);
            return this;
        }

        public a l(Iterable iterable) {
            super.c(iterable);
            return this;
        }

        public a m(Iterator it) {
            super.d(it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection$b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public ImmutableList e() {
            this.c = true;
            return ImmutableList.asImmutableList(this.a, this.b);
        }

        ImmutableList o(Comparator comparator) {
            this.c = true;
            Arrays.sort(this.a, 0, this.b, comparator);
            return ImmutableList.asImmutableList(this.a, this.b);
        }

        a p(a aVar) {
            h(aVar.a, aVar.b);
            return this;
        }
    }

    static class b extends com.google.common.collect.a {
        private final ImmutableList c;

        /* JADX WARN: Multi-variable type inference failed */
        b(ImmutableList immutableList, int i) {
            super(immutableList.size(), i);
            this.c = immutableList;
        }

        @Override // com.google.common.collect.a
        protected Object a(int i) {
            return this.c.get(i);
        }
    }

    ImmutableList() {
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i) {
        return i == 0 ? of() : new RegularImmutableList(objArr, i);
    }

    public static <E> a builder() {
        return new a();
    }

    public static <E> a builderWithExpectedSize(int i) {
        e2.b(i, "expectedSize");
        return new a(i);
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(n3.b(objArr));
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        com.google.common.base.m.o(iterable);
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return construct(collection.toArray());
        }
        ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
        return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        return !it.hasNext() ? of((Object) next) : new a().a(next).m(it).e();
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        return eArr.length == 0 ? of() : construct((Object[]) eArr.clone());
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    public static <E> ImmutableList<E> of(E e) {
        return construct(e);
    }

    public static <E> ImmutableList<E> of(E e, E e2) {
        return construct(e, e2);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3) {
        return construct(e, e2, e3);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4) {
        return construct(e, e2, e3, e4);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6) {
        return construct(e, e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7) {
        return construct(e, e2, e3, e4, e5, e6, e7);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E... eArr) {
        com.google.common.base.m.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        objArr[6] = e7;
        objArr[7] = e8;
        objArr[8] = e9;
        objArr[9] = e10;
        objArr[10] = e11;
        objArr[11] = e12;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return construct(objArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) g3.q(iterable, new Comparable[0]);
        n3.b(comparableArr);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.m.o(comparator);
        Object[] p = g3.p(iterable);
        n3.b(p);
        Arrays.sort(p, comparator);
        return asImmutableList(p);
    }

    public static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return d2.O();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final ImmutableList<E> asList() {
        return this;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    int copyIntoArray(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return Lists.d(this, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.e(this, obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public r4 iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.g(this, obj);
    }

    @Override // java.util.List
    public s4 listIterator() {
        return listIterator(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public s4 listIterator(int i) {
        com.google.common.base.m.r(i, size());
        return isEmpty() ? EMPTY_ITR : new b(this, i);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public ImmutableList<E> subList(int i, int i2) {
        com.google.common.base.m.t(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? of() : subListUnchecked(i, i2);
    }

    ImmutableList<E> subListUnchecked(int i, int i2) {
        return new SubList(i, i2 - i);
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
