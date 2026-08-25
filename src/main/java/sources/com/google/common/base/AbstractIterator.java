package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
abstract class AbstractIterator implements Iterator {
    private State a = State.NOT_READY;
    private Object b;

    private enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected AbstractIterator() {
    }

    private boolean c() {
        this.a = State.FAILED;
        this.b = a();
        if (this.a == State.DONE) {
            return false;
        }
        this.a = State.READY;
        return true;
    }

    protected abstract Object a();

    protected final Object b() {
        this.a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        m.u(this.a != State.FAILED);
        int ordinal = this.a.ordinal();
        if (ordinal == 0) {
            return true;
        }
        if (ordinal != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.a = State.NOT_READY;
        Object a = i.a(this.b);
        this.b = null;
        return a;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
