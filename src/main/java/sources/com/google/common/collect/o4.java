package com.google.common.collect;

import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class o4 implements Iterator {
    final Iterator a;

    o4(Iterator it) {
        this.a = (Iterator) com.google.common.base.m.o(it);
    }

    abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}
