package org.apache.tools.ant.types;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class s implements Iterator {
    private boolean a = false;
    private final /* synthetic */ t b;

    s(t tVar) {
        this.b = tVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.a;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (this.a) {
            throw new NoSuchElementException();
        }
        this.a = true;
        return this.b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
