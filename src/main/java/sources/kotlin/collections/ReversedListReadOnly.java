package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class ReversedListReadOnly extends AbstractList {
    private final List a;

    public ReversedListReadOnly(List delegate) {
        Intrinsics.h(delegate, "delegate");
        this.a = delegate;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i) {
        int V;
        List list = this.a;
        V = o.V(this, i);
        return list.get(V);
    }

    public int getSize() {
        return this.a.size();
    }

    @Override // kotlin.collections.AbstractList, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        return new ReversedListReadOnly$listIterator$1(this, i);
    }
}
