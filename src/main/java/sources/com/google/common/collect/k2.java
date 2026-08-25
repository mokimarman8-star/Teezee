package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class k2 extends q2 implements Collection {
    protected k2() {
    }

    public boolean add(Object obj) {
        return delegate().add(obj);
    }

    public boolean addAll(Collection<Object> collection) {
        return delegate().addAll(collection);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean contains(Object obj) {
        return delegate().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    @Override // com.google.common.collect.q2
    protected abstract Collection delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Iterator<Object> iterator() {
        return delegate().iterator();
    }

    public boolean remove(Object obj) {
        return delegate().remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    protected boolean standardAddAll(Collection<Object> collection) {
        return Iterators.a(this, collection.iterator());
    }

    protected void standardClear() {
        Iterators.d(iterator());
    }

    protected boolean standardContains(Object obj) {
        return Iterators.f(iterator(), obj);
    }

    protected boolean standardContainsAll(Collection<?> collection) {
        return f2.a(this, collection);
    }

    protected boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    protected boolean standardRemove(Object obj) {
        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            if (com.google.common.base.j.a(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    protected boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.u(iterator(), collection);
    }

    protected boolean standardRetainAll(Collection<?> collection) {
        return Iterators.w(iterator(), collection);
    }

    protected Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    protected <T> T[] standardToArray(T[] tArr) {
        return (T[]) n3.g(this, tArr);
    }

    protected String standardToString() {
        return f2.e(this);
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }
}
