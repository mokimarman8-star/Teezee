package com.google.common.collect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class ImmutableSet$a extends ImmutableCollection$a {
    Object[] d;
    private int e;

    public ImmutableSet$a() {
        super(4);
    }

    ImmutableSet$a(int i, boolean z) {
        super(i);
        if (z) {
            this.d = new Object[ImmutableSet.chooseTableSize(i)];
        }
    }

    private void n(Object obj) {
        Objects.requireNonNull(this.d);
        int length = this.d.length - 1;
        int hashCode = obj.hashCode();
        int c = v2.c(hashCode);
        while (true) {
            int i = c & length;
            Object[] objArr = this.d;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                objArr[i] = obj;
                this.e += hashCode;
                super.g(obj);
                return;
            } else if (obj2.equals(obj)) {
                return;
            } else {
                c = i + 1;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableCollection$b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public ImmutableSet$a a(Object obj) {
        com.google.common.base.m.o(obj);
        if (this.d != null && ImmutableSet.chooseTableSize(this.b) <= this.d.length) {
            n(obj);
            return this;
        }
        this.d = null;
        super.g(obj);
        return this;
    }

    public ImmutableSet$a k(Object... objArr) {
        if (this.d != null) {
            for (Object obj : objArr) {
                a(obj);
            }
        } else {
            super.b(objArr);
        }
        return this;
    }

    public ImmutableSet$a l(Iterable iterable) {
        com.google.common.base.m.o(iterable);
        if (this.d != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } else {
            super.c(iterable);
        }
        return this;
    }

    public ImmutableSet$a m(Iterator it) {
        com.google.common.base.m.o(it);
        while (it.hasNext()) {
            a(it.next());
        }
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection$b
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public ImmutableSet e() {
        RegularImmutableSet access$100;
        int i = this.b;
        if (i == 0) {
            return ImmutableSet.of();
        }
        if (i == 1) {
            Object obj = this.a[0];
            Objects.requireNonNull(obj);
            return ImmutableSet.of(obj);
        }
        if (this.d == null || ImmutableSet.chooseTableSize(i) != this.d.length) {
            access$100 = ImmutableSet.access$100(this.b, this.a);
            this.b = access$100.size();
        } else {
            Object[] copyOf = ImmutableSet.access$000(this.b, this.a.length) ? Arrays.copyOf(this.a, this.b) : this.a;
            access$100 = new RegularImmutableSet(copyOf, this.e, this.d, r5.length - 1, this.b);
        }
        this.c = true;
        this.d = null;
        return access$100;
    }

    ImmutableSet$a p(ImmutableSet$a immutableSet$a) {
        if (this.d != null) {
            for (int i = 0; i < immutableSet$a.b; i++) {
                Object obj = immutableSet$a.a[i];
                Objects.requireNonNull(obj);
                a(obj);
            }
        } else {
            h(immutableSet$a.a, immutableSet$a.b);
        }
        return this;
    }
}
