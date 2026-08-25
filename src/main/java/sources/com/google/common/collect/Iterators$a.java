package com.google.common.collect;

import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class Iterators$a extends r4 {
    final /* synthetic */ Iterator a;

    Iterators$a(Iterator it) {
        this.a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.a.next();
    }
}
