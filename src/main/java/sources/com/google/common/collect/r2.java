package com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.Queue;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class r2 extends k2 implements Queue {
    protected r2() {
    }

    @Override // com.google.common.collect.k2, com.google.common.collect.q2
    protected abstract Queue delegate();

    @Override // java.util.Queue
    public Object element() {
        return delegate().element();
    }

    @Override // java.util.Queue
    public Object peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    public Object poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    public Object remove() {
        return delegate().remove();
    }

    protected boolean standardOffer(Object obj) {
        try {
            return add(obj);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    protected Object standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    protected Object standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
