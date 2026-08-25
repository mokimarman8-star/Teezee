package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class Iterators$g implements q3 {
    private final Iterator a;
    private boolean b;
    private Object c;

    public Iterators$g(Iterator it) {
        this.a = (Iterator) com.google.common.base.m.o(it);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b || this.a.hasNext();
    }

    @Override // com.google.common.collect.q3, java.util.Iterator
    public Object next() {
        if (!this.b) {
            return this.a.next();
        }
        Object a = m3.a(this.c);
        this.b = false;
        this.c = null;
        return a;
    }

    @Override // com.google.common.collect.q3
    public Object peek() {
        if (!this.b) {
            this.c = this.a.next();
            this.b = true;
        }
        return m3.a(this.c);
    }

    @Override // java.util.Iterator
    public void remove() {
        com.google.common.base.m.v(!this.b, "Can't remove after you've peeked at next");
        this.a.remove();
    }
}
