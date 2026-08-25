package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class ReversedList extends AbstractMutableList {
    private final List a;

    public ReversedList(List delegate) {
        Intrinsics.h(delegate, "delegate");
        this.a = delegate;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        int X;
        List list = this.a;
        X = o.X(this, i);
        list.add(X, obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        int V;
        List list = this.a;
        V = o.V(this, i);
        return list.get(V);
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.a.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        return new ReversedList$listIterator$1(this, i);
    }

    @Override // kotlin.collections.AbstractMutableList
    public Object removeAt(int i) {
        int V;
        List list = this.a;
        V = o.V(this, i);
        return list.remove(V);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        int V;
        List list = this.a;
        V = o.V(this, i);
        return list.set(V, obj);
    }
}
