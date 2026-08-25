package com.google.common.collect;

import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class g extends r4 {
    private Object a;

    protected g(Object obj) {
        this.a = obj;
    }

    protected abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object obj = this.a;
        if (obj == null) {
            throw new NoSuchElementException();
        }
        this.a = a(obj);
        return obj;
    }
}
