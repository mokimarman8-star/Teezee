package com.google.common.collect;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class Iterators$e implements Iterator {
    private Iterator a;
    private Iterator b = Iterators.h();
    private Iterator c;
    private Deque d;

    Iterators$e(Iterator it) {
        this.c = (Iterator) com.google.common.base.m.o(it);
    }

    private Iterator a() {
        while (true) {
            Iterator it = this.c;
            if (it != null && it.hasNext()) {
                return this.c;
            }
            Deque deque = this.d;
            if (deque == null || deque.isEmpty()) {
                return null;
            }
            this.c = (Iterator) this.d.removeFirst();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (!((Iterator) com.google.common.base.m.o(this.b)).hasNext()) {
            Iterator a = a();
            this.c = a;
            if (a == null) {
                return false;
            }
            Iterator it = (Iterator) a.next();
            this.b = it;
            if (it instanceof Iterators$e) {
                Iterators$e iterators$e = (Iterators$e) it;
                this.b = iterators$e.b;
                if (this.d == null) {
                    this.d = new ArrayDeque();
                }
                this.d.addFirst(this.c);
                if (iterators$e.d != null) {
                    while (!iterators$e.d.isEmpty()) {
                        this.d.addFirst((Iterator) iterators$e.d.removeLast());
                    }
                }
                this.c = iterators$e.c;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Iterator it = this.b;
        this.a = it;
        return it.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        Iterator it = this.a;
        if (it == null) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
        it.remove();
        this.a = null;
    }
}
