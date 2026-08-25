package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class Iterators$h extends r4 {
    private final Object a;
    private boolean b;

    Iterators$h(Object obj) {
        this.a = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.b;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (this.b) {
            throw new NoSuchElementException();
        }
        this.b = true;
        return this.a;
    }
}
