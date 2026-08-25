package com.google.common.collect;

import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class Iterators$b extends AbstractIterator {
    final /* synthetic */ Iterator c;
    final /* synthetic */ com.google.common.base.n d;

    Iterators$b(Iterator it, com.google.common.base.n nVar) {
        this.c = it;
        this.d = nVar;
    }

    @Override // com.google.common.collect.AbstractIterator
    protected Object a() {
        while (this.c.hasNext()) {
            Object next = this.c.next();
            if (this.d.apply(next)) {
                return next;
            }
        }
        return b();
    }
}
