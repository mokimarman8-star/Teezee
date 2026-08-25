package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    class a implements Iterable {
        final /* synthetic */ Iterable a;

        /* renamed from: com.google.common.base.Optional$a$a, reason: collision with other inner class name */
        class C0002a extends AbstractIterator {
            private final Iterator c;

            C0002a() {
                this.c = (Iterator) m.o(a.this.a.iterator());
            }

            protected Object a() {
                while (this.c.hasNext()) {
                    Optional optional = (Optional) this.c.next();
                    if (optional.isPresent()) {
                        return optional.get();
                    }
                }
                return b();
            }
        }

        a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C0002a();
        }
    }

    Optional() {
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(T t) {
        return t == null ? absent() : new Present(t);
    }

    public static <T> Optional<T> of(T t) {
        return new Present(m.o(t));
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        m.o(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(q qVar);

    public abstract T or(T t);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(f fVar);
}
