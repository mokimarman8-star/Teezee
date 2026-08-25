package com.google.common.collect;

import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class ImmutableCollection$b {
    ImmutableCollection$b() {
    }

    static int f(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
        }
        if (i2 <= i) {
            return i;
        }
        int i3 = i + (i >> 1) + 1;
        if (i3 < i2) {
            i3 = Integer.highestOneBit(i2 - 1) << 1;
        }
        return i3 < 0 ? com.google.protobuf.h1.READ_DONE : i3;
    }

    public abstract ImmutableCollection$b a(Object obj);

    public ImmutableCollection$b b(Object... objArr) {
        for (Object obj : objArr) {
            a(obj);
        }
        return this;
    }

    public ImmutableCollection$b c(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        return this;
    }

    public ImmutableCollection$b d(Iterator it) {
        while (it.hasNext()) {
            a(it.next());
        }
        return this;
    }

    public abstract ImmutableCollection e();
}
