package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class ImmutableCollection$a extends ImmutableCollection$b {
    Object[] a;
    int b;
    boolean c;

    ImmutableCollection$a(int i) {
        e2.b(i, "initialCapacity");
        this.a = new Object[i];
        this.b = 0;
    }

    private void i(int i) {
        Object[] objArr = this.a;
        int f = ImmutableCollection$b.f(objArr.length, this.b + i);
        if (f > objArr.length || this.c) {
            this.a = Arrays.copyOf(this.a, f);
            this.c = false;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection$b
    public ImmutableCollection$b b(Object... objArr) {
        h(objArr, objArr.length);
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection$b
    public ImmutableCollection$b c(Iterable iterable) {
        if (iterable instanceof Collection) {
            ImmutableCollection immutableCollection = (Collection) iterable;
            i(immutableCollection.size());
            if (immutableCollection instanceof ImmutableCollection) {
                this.b = immutableCollection.copyIntoArray(this.a, this.b);
                return this;
            }
        }
        super.c(iterable);
        return this;
    }

    public ImmutableCollection$a g(Object obj) {
        com.google.common.base.m.o(obj);
        i(1);
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = obj;
        return this;
    }

    final void h(Object[] objArr, int i) {
        n3.c(objArr, i);
        i(i);
        System.arraycopy(objArr, 0, this.a, this.b, i);
        this.b += i;
    }
}
