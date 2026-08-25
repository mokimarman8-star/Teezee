package com.bykv.vk.openvk.preload.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> d = new Comparator<Comparable>() { // from class: com.bykv.vk.openvk.preload.a.b.g.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    private static /* synthetic */ boolean i = true;
    int a;
    int b;
    final d<K, V> c;
    private Comparator<? super K> e;
    private d<K, V> f;
    private g<K, V>.a g;
    private g<K, V>.b h;

    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new c(this) { // from class: com.bykv.vk.openvk.preload.a.b.g.a.1
                {
                    g gVar = g.this;
                }

                @Override // java.util.Iterator
                public final /* synthetic */ Object next() {
                    return a();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            d<K, V> a;
            if (!(obj instanceof Map.Entry) || (a = g.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            g.this.a((d) a, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return g.this.a;
        }
    }

    final class b extends AbstractSet<K> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new c(this) { // from class: com.bykv.vk.openvk.preload.a.b.g.b.1
                {
                    g gVar = g.this;
                }

                @Override // java.util.Iterator
                public final K next() {
                    return a().f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            return g.this.a(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return g.this.a;
        }
    }

    abstract class c<T> implements Iterator<T> {
        private d<K, V> a;
        private d<K, V> b = null;
        private int c;

        c() {
            this.a = g.this.c.d;
            this.c = g.this.b;
        }

        final d<K, V> a() {
            d<K, V> dVar = this.a;
            g gVar = g.this;
            if (dVar == gVar.c) {
                throw new NoSuchElementException();
            }
            if (gVar.b != this.c) {
                throw new ConcurrentModificationException();
            }
            this.a = dVar.d;
            this.b = dVar;
            return dVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != g.this.c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.b;
            if (dVar == null) {
                throw new IllegalStateException();
            }
            g.this.a((d) dVar, true);
            this.b = null;
            this.c = g.this.b;
        }
    }

    static final class d<K, V> implements Map.Entry<K, V> {
        d<K, V> a;
        d<K, V> b;
        d<K, V> c;
        d<K, V> d;
        d<K, V> e;
        final K f;
        V g;
        int h;

        d() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.a = dVar;
            this.f = k;
            this.h = 1;
            this.d = dVar2;
            this.e = dVar3;
            dVar3.d = this;
            dVar2.e = this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f;
                if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                    V v = this.g;
                    if (v == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (v.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k = this.f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        public final String toString() {
            return this.f + "=" + this.g;
        }
    }

    public g() {
        this(d);
    }

    private g(Comparator<? super K> comparator) {
        this.a = 0;
        this.b = 0;
        this.c = new d<>();
        this.e = comparator == null ? d : comparator;
    }

    private d<K, V> a(K k, boolean z) {
        int i2;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.e;
        d<K, V> dVar2 = this.f;
        if (dVar2 != null) {
            Comparable comparable = comparator == d ? (Comparable) k : null;
            while (true) {
                i2 = comparable != null ? comparable.compareTo(dVar2.f) : comparator.compare(k, dVar2.f);
                if (i2 != 0) {
                    d<K, V> dVar3 = i2 < 0 ? dVar2.b : dVar2.c;
                    if (dVar3 == null) {
                        break;
                    }
                    dVar2 = dVar3;
                } else {
                    return dVar2;
                }
            }
        } else {
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        d<K, V> dVar4 = this.c;
        if (dVar2 != null) {
            dVar = new d<>(dVar2, k, dVar4, dVar4.e);
            if (i2 < 0) {
                dVar2.b = dVar;
            } else {
                dVar2.c = dVar;
            }
            b(dVar2, true);
        } else {
            if (comparator == d && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            dVar = new d<>(dVar2, k, dVar4, dVar4.e);
            this.f = dVar;
        }
        this.a++;
        this.b++;
        return dVar;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar3.b;
        d<K, V> dVar5 = dVar3.c;
        dVar.c = dVar4;
        if (dVar4 != null) {
            dVar4.a = dVar;
        }
        a(dVar, dVar3);
        dVar3.b = dVar;
        dVar.a = dVar3;
        int max = Math.max(dVar2 != null ? dVar2.h : 0, dVar4 != null ? dVar4.h : 0) + 1;
        dVar.h = max;
        dVar3.h = Math.max(max, dVar5 != null ? dVar5.h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.a;
        dVar.a = null;
        if (dVar2 != null) {
            dVar2.a = dVar3;
        }
        if (dVar3 == null) {
            this.f = dVar2;
            return;
        }
        if (dVar3.b == dVar) {
            dVar3.b = dVar2;
        } else {
            if (!i && dVar3.c != dVar) {
                throw new AssertionError();
            }
            dVar3.c = dVar2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d<K, V> b(Object obj) {
        if (obj != 0) {
            try {
                return a((g<K, V>) obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar2.b;
        d<K, V> dVar5 = dVar2.c;
        dVar.b = dVar5;
        if (dVar5 != null) {
            dVar5.a = dVar;
        }
        a(dVar, dVar2);
        dVar2.c = dVar;
        dVar.a = dVar2;
        int max = Math.max(dVar3 != null ? dVar3.h : 0, dVar5 != null ? dVar5.h : 0) + 1;
        dVar.h = max;
        dVar2.h = Math.max(max, dVar4 != null ? dVar4.h : 0) + 1;
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.b;
            d<K, V> dVar3 = dVar.c;
            int i2 = dVar2 != null ? dVar2.h : 0;
            int i3 = dVar3 != null ? dVar3.h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                d<K, V> dVar4 = dVar3.b;
                d<K, V> dVar5 = dVar3.c;
                int i8 = (dVar4 != null ? dVar4.h : 0) - (dVar5 != null ? dVar5.h : 0);
                if (i8 == -1 || (i8 == 0 && !z)) {
                    a((d) dVar);
                } else {
                    if (!i && i8 != 1) {
                        throw new AssertionError();
                    }
                    b((d) dVar3);
                    a((d) dVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                d<K, V> dVar6 = dVar2.b;
                d<K, V> dVar7 = dVar2.c;
                int i9 = (dVar6 != null ? dVar6.h : 0) - (dVar7 != null ? dVar7.h : 0);
                if (i9 == 1 || (i9 == 0 && !z)) {
                    b((d) dVar);
                } else {
                    if (!i && i9 != -1) {
                        throw new AssertionError();
                    }
                    a((d) dVar2);
                    b((d) dVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                dVar.h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                if (!i && i4 != -1 && i4 != 1) {
                    throw new AssertionError();
                }
                dVar.h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.a;
        }
    }

    final d<K, V> a(Object obj) {
        d<K, V> b2 = b(obj);
        if (b2 != null) {
            a((d) b2, true);
        }
        return b2;
    }

    final d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> b2 = b(entry.getKey());
        if (b2 == null) {
            return null;
        }
        V v = b2.g;
        Object value = entry.getValue();
        if (v == value || (v != null && v.equals(value))) {
            return b2;
        }
        return null;
    }

    final void a(d<K, V> dVar, boolean z) {
        int i2;
        if (z) {
            d<K, V> dVar2 = dVar.e;
            dVar2.d = dVar.d;
            dVar.d.e = dVar2;
        }
        d<K, V> dVar3 = dVar.b;
        d<K, V> dVar4 = dVar.c;
        d<K, V> dVar5 = dVar.a;
        int i3 = 0;
        if (dVar3 == null || dVar4 == null) {
            if (dVar3 != null) {
                a(dVar, dVar3);
                dVar.b = null;
            } else if (dVar4 != null) {
                a(dVar, dVar4);
                dVar.c = null;
            } else {
                a(dVar, (d) null);
            }
            b(dVar5, false);
            this.a--;
            this.b++;
            return;
        }
        if (dVar3.h > dVar4.h) {
            d<K, V> dVar6 = dVar3.c;
            while (true) {
                d<K, V> dVar7 = dVar6;
                dVar4 = dVar3;
                dVar3 = dVar7;
                if (dVar3 == null) {
                    break;
                } else {
                    dVar6 = dVar3.c;
                }
            }
        } else {
            while (true) {
                d<K, V> dVar8 = dVar4.b;
                if (dVar8 == null) {
                    break;
                } else {
                    dVar4 = dVar8;
                }
            }
        }
        a((d) dVar4, false);
        d<K, V> dVar9 = dVar.b;
        if (dVar9 != null) {
            i2 = dVar9.h;
            dVar4.b = dVar9;
            dVar9.a = dVar4;
            dVar.b = null;
        } else {
            i2 = 0;
        }
        d<K, V> dVar10 = dVar.c;
        if (dVar10 != null) {
            i3 = dVar10.h;
            dVar4.c = dVar10;
            dVar10.a = dVar4;
            dVar.c = null;
        }
        dVar4.h = Math.max(i2, i3) + 1;
        a(dVar, dVar4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f = null;
        this.a = 0;
        this.b++;
        d<K, V> dVar = this.c;
        dVar.e = dVar;
        dVar.d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return b(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.a aVar = this.g;
        if (aVar != null) {
            return aVar;
        }
        g<K, V>.a aVar2 = new a();
        this.g = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        d<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        g<K, V>.b bVar = this.h;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.b bVar2 = new b();
        this.h = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        d<K, V> a2 = a((g<K, V>) k, true);
        V v2 = a2.g;
        a2.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.a;
    }
}
