package com.google.common.collect;

import java.util.Comparator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class h2 {
    private static final h2 a = new a();
    private static final h2 b = new b(-1);
    private static final h2 c = new b(1);

    class a extends h2 {
        a() {
            super(null);
        }

        @Override // com.google.common.collect.h2
        public h2 d(int i, int i2) {
            return l(Integer.compare(i, i2));
        }

        @Override // com.google.common.collect.h2
        public h2 e(long j, long j2) {
            return l(Long.compare(j, j2));
        }

        @Override // com.google.common.collect.h2
        public h2 f(Comparable comparable, Comparable comparable2) {
            return l(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.h2
        public h2 g(Object obj, Object obj2, Comparator comparator) {
            return l(comparator.compare(obj, obj2));
        }

        @Override // com.google.common.collect.h2
        public h2 h(boolean z, boolean z2) {
            return l(Boolean.compare(z, z2));
        }

        @Override // com.google.common.collect.h2
        public h2 i(boolean z, boolean z2) {
            return l(Boolean.compare(z2, z));
        }

        @Override // com.google.common.collect.h2
        public int j() {
            return 0;
        }

        h2 l(int i) {
            return i < 0 ? h2.b : i > 0 ? h2.c : h2.a;
        }
    }

    private static final class b extends h2 {
        final int d;

        b(int i) {
            super(null);
            this.d = i;
        }

        @Override // com.google.common.collect.h2
        public h2 d(int i, int i2) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public h2 e(long j, long j2) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public h2 f(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public h2 g(Object obj, Object obj2, Comparator comparator) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public h2 h(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public h2 i(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public int j() {
            return this.d;
        }
    }

    private h2() {
    }

    /* synthetic */ h2(a aVar) {
        this();
    }

    public static h2 k() {
        return a;
    }

    public abstract h2 d(int i, int i2);

    public abstract h2 e(long j, long j2);

    public abstract h2 f(Comparable comparable, Comparable comparable2);

    public abstract h2 g(Object obj, Object obj2, Comparator comparator);

    public abstract h2 h(boolean z, boolean z2);

    public abstract h2 i(boolean z, boolean z2);

    public abstract int j();
}
