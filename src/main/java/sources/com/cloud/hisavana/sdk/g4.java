package com.cloud.hisavana.sdk;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
abstract class g4 {
    b a;
    c b;
    e c;

    final class a implements Iterator {
        final int a;
        int b;
        int c;
        boolean d = false;

        a(int i) {
            this.a = i;
            this.b = g4.this.n();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c < this.b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object b = g4.this.b(this.c, this.a);
            this.c++;
            this.d = true;
            return b;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            int i = this.c - 1;
            this.c = i;
            this.b--;
            this.d = false;
            g4.this.e(i);
        }
    }

    final class b implements Set {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            int n = g4.this.n();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                g4.this.f(entry.getKey(), entry.getValue());
            }
            return n != g4.this.n();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            g4.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a = g4.this.a(entry.getKey());
            if (a < 0) {
                return false;
            }
            return Objects.equals(g4.this.b(a, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return g4.h(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int n = g4.this.n() - 1; n >= 0; n--) {
                Object b = g4.this.b(n, 0);
                Object b2 = g4.this.b(n, 1);
                i += (b == null ? 0 : b.hashCode()) ^ (b2 == null ? 0 : b2.hashCode());
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return g4.this.n() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return g4.this.new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return g4.this.n();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            g4.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return g4.this.a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return g4.g(g4.this.k(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return g4.h(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int n = g4.this.n() - 1; n >= 0; n--) {
                Object b = g4.this.b(n, 0);
                i += b == null ? 0 : b.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return g4.this.n() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return g4.this.new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int a = g4.this.a(obj);
            if (a < 0) {
                return false;
            }
            g4.this.e(a);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return g4.l(g4.this.k(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return g4.o(g4.this.k(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return g4.this.n();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return g4.this.m(0);
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return g4.this.i(objArr, 0);
        }
    }

    final class d implements Iterator, Map.Entry {
        int a;
        boolean c = false;
        int b = -1;

        d() {
            this.a = g4.this.n() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.b++;
            this.c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Objects.equals(entry.getKey(), g4.this.b(this.b, 0)) && Objects.equals(entry.getValue(), g4.this.b(this.b, 1));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.c) {
                return g4.this.b(this.b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.c) {
                return g4.this.b(this.b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object b = g4.this.b(this.b, 0);
            Object b2 = g4.this.b(this.b, 1);
            return (b == null ? 0 : b.hashCode()) ^ (b2 != null ? b2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.c) {
                throw new IllegalStateException();
            }
            g4.this.e(this.b);
            this.b--;
            this.a--;
            this.c = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.c) {
                return g4.this.c(this.b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            g4.this.d();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return g4.this.j(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return g4.this.n() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return g4.this.new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int j = g4.this.j(obj);
            if (j < 0) {
                return false;
            }
            g4.this.e(j);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int n = g4.this.n();
            int i = 0;
            boolean z = false;
            while (i < n) {
                if (collection.contains(g4.this.b(i, 1))) {
                    g4.this.e(i);
                    i--;
                    n--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int n = g4.this.n();
            int i = 0;
            boolean z = false;
            while (i < n) {
                if (!collection.contains(g4.this.b(i, 1))) {
                    g4.this.e(i);
                    i--;
                    n--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return g4.this.n();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return g4.this.m(1);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return g4.this.i(objArr, 1);
        }
    }

    g4() {
    }

    public static boolean g(Map map, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean l(Map map, Collection collection) {
        int size = map.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int a(Object obj);

    protected abstract Object b(int i, int i2);

    protected abstract Object c(int i, Object obj);

    protected abstract void d();

    protected abstract void e(int i);

    protected abstract void f(Object obj, Object obj2);

    public Object[] i(Object[] objArr, int i) {
        int n = n();
        if (objArr.length < n) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), n);
        }
        for (int i2 = 0; i2 < n; i2++) {
            objArr[i2] = b(i2, i);
        }
        if (objArr.length > n) {
            objArr[n] = null;
        }
        return objArr;
    }

    protected abstract int j(Object obj);

    protected abstract Map k();

    public Object[] m(int i) {
        int n = n();
        Object[] objArr = new Object[n];
        for (int i2 = 0; i2 < n; i2++) {
            objArr[i2] = b(i2, i);
        }
        return objArr;
    }

    protected abstract int n();

    public Set p() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a;
    }

    public Set q() {
        if (this.b == null) {
            this.b = new c();
        }
        return this.b;
    }

    public Collection r() {
        if (this.c == null) {
            this.c = new e();
        }
        return this.c;
    }
}
