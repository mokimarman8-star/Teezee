package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.l3;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class d extends AbstractCollection implements l3 {
    private transient Set<Object> elementSet;
    private transient Set<l3.a> entrySet;

    class a extends Multisets.c {
        a() {
        }

        @Override // com.google.common.collect.Multisets.c
        l3 a() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return d.this.elementIterator();
        }
    }

    class b extends Multisets.d {
        b() {
        }

        @Override // com.google.common.collect.Multisets.d
        l3 a() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return d.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d.this.distinctElements();
        }
    }

    d() {
    }

    public int add(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        add(obj, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<Object> collection) {
        return Multisets.c(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.l3
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    Set<Object> createElementSet() {
        return new a();
    }

    Set<l3.a> createEntrySet() {
        return new b();
    }

    abstract int distinctElements();

    abstract Iterator elementIterator();

    /* renamed from: elementSet */
    public Set<Object> mo15elementSet() {
        Set<Object> set = this.elementSet;
        if (set != null) {
            return set;
        }
        Set<Object> createElementSet = createElementSet();
        this.elementSet = createElementSet;
        return createElementSet;
    }

    abstract Iterator entryIterator();

    /* renamed from: entrySet */
    public Set<l3.a> mo17entrySet() {
        Set<l3.a> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<l3.a> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Collection, com.google.common.collect.l3
    public final boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    @Override // java.util.Collection, com.google.common.collect.l3
    public final int hashCode() {
        return mo17entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return mo17entrySet().isEmpty();
    }

    public abstract int remove(Object obj, int i);

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.l3
    public final boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        return Multisets.j(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    public int setCount(Object obj, int i) {
        return Multisets.l(this, obj, i);
    }

    public boolean setCount(Object obj, int i, int i2) {
        return Multisets.m(this, obj, i, i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return mo17entrySet().toString();
    }
}
