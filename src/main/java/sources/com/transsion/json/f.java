package com.transsion.json;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class f implements Set {
    final Set a;
    final Set b = new HashSet();

    public f(Set set) {
        this.a = set;
    }

    public Set a() {
        return this.a;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        return this.b.add(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        return this.b.addAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.b.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.b.contains(obj) || this.a.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.b.containsAll(collection) || this.a.containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.b.isEmpty() && this.a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new e(new Set[]{this.b, this.a});
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.b.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.b.removeAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.b.retainAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.b.size() + this.a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        Object[] array = this.b.toArray();
        Object[] array2 = this.a.toArray();
        Object[] objArr = new Object[array.length + array2.length];
        System.arraycopy(array, 0, objArr, 0, array.length);
        System.arraycopy(array2, 0, objArr, array.length, array2.length);
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        throw new IllegalStateException("Not implemeneted");
    }
}
