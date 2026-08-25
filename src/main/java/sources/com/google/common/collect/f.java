package com.google.common.collect;

import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class f implements u3 {
    f() {
    }

    public abstract void add(Range range);

    public void addAll(u3 u3Var) {
        addAll(u3Var.mo21asRanges());
    }

    public void addAll(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            add((Range) it.next());
        }
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean contains(Comparable comparable) {
        return rangeContaining(comparable) != null;
    }

    @Override // com.google.common.collect.u3
    public abstract boolean encloses(Range range);

    public boolean enclosesAll(u3 u3Var) {
        return enclosesAll(u3Var.mo21asRanges());
    }

    public boolean enclosesAll(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (!encloses((Range) it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u3) {
            return mo21asRanges().equals(((u3) obj).mo21asRanges());
        }
        return false;
    }

    public final int hashCode() {
        return mo21asRanges().hashCode();
    }

    @Override // com.google.common.collect.u3
    public boolean isEmpty() {
        return mo21asRanges().isEmpty();
    }

    public abstract Range rangeContaining(Comparable comparable);

    public abstract void remove(Range range);

    @Override // com.google.common.collect.u3
    public void removeAll(u3 u3Var) {
        removeAll(u3Var.mo21asRanges());
    }

    public void removeAll(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            remove((Range) it.next());
        }
    }

    public final String toString() {
        return mo21asRanges().toString();
    }
}
