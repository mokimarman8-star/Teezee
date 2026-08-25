package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final Object g = new Object();
    private transient Object a;
    private transient int b;
    private transient int c;
    private transient Set d;
    private transient Set e;
    transient int[] entries;
    private transient Collection f;
    transient Object[] keys;
    transient Object[] values;

    class a extends e {
        a() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        Object b(int i) {
            return CompactHashMap.this.e(i);
        }
    }

    class b extends e {
        b() {
            super(CompactHashMap.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.CompactHashMap.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry b(int i) {
            return new g(i);
        }
    }

    class c extends e {
        c() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        Object b(int i) {
            return CompactHashMap.this.r(i);
        }
    }

    class d extends AbstractSet {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int d = CompactHashMap.this.d(entry.getKey());
            return d != -1 && com.google.common.base.j.a(CompactHashMap.this.r(d), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int c = CompactHashMap.this.c();
            int f = g2.f(entry.getKey(), entry.getValue(), c, CompactHashMap.this.j(), CompactHashMap.this.h(), CompactHashMap.this.i(), CompactHashMap.this.k());
            if (f == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(f, c);
            CompactHashMap.access$1210(CompactHashMap.this);
            CompactHashMap.this.incrementModCount();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    private abstract class e implements Iterator {
        int a;
        int b;
        int c;

        private e() {
            this.a = CompactHashMap.this.b;
            this.b = CompactHashMap.this.firstEntryIndex();
            this.c = -1;
        }

        /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this();
        }

        private void a() {
            if (CompactHashMap.this.b != this.a) {
                throw new ConcurrentModificationException();
            }
        }

        abstract Object b(int i);

        void c() {
            this.a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.b;
            this.c = i;
            Object b = b(i);
            this.b = CompactHashMap.this.getSuccessor(this.b);
            return b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            e2.e(this.c >= 0);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.e(this.c));
            this.b = CompactHashMap.this.adjustAfterRemove(this.b, this.c);
            this.c = -1;
        }
    }

    class f extends AbstractSet {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            return delegateOrNull != null ? delegateOrNull.keySet().remove(obj) : CompactHashMap.this.f(obj) != CompactHashMap.g;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    final class g extends com.google.common.collect.b {
        private final Object a;
        private int b;

        g(int i) {
            this.a = CompactHashMap.this.e(i);
            this.b = i;
        }

        private void a() {
            int i = this.b;
            if (i == -1 || i >= CompactHashMap.this.size() || !com.google.common.base.j.a(this.a, CompactHashMap.this.e(this.b))) {
                this.b = CompactHashMap.this.d(this.a);
            }
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getValue() {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return m3.a(delegateOrNull.get(this.a));
            }
            a();
            int i = this.b;
            return i == -1 ? m3.b() : CompactHashMap.this.r(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object setValue(Object obj) {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != 0) {
                return m3.a(delegateOrNull.put(this.a, obj));
            }
            a();
            int i = this.b;
            if (i == -1) {
                CompactHashMap.this.put(this.a, obj);
                return m3.b();
            }
            Object r = CompactHashMap.this.r(i);
            CompactHashMap.this.q(this.b, obj);
            return r;
        }
    }

    class h extends AbstractCollection {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    CompactHashMap() {
        init(3);
    }

    CompactHashMap(int i) {
        init(i);
    }

    private int a(int i) {
        return h()[i];
    }

    static /* synthetic */ int access$1210(CompactHashMap compactHashMap) {
        int i = compactHashMap.c;
        compactHashMap.c = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        return (1 << (this.b & 31)) - 1;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactHashMap<>(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int d2 = v2.d(obj);
        int c2 = c();
        int h2 = g2.h(j(), d2 & c2);
        if (h2 == 0) {
            return -1;
        }
        int b2 = g2.b(d2, c2);
        do {
            int i = h2 - 1;
            int a2 = a(i);
            if (g2.b(a2, c2) == b2 && com.google.common.base.j.a(obj, e(i))) {
                return i;
            }
            h2 = g2.c(a2, c2);
        } while (h2 != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object e(int i) {
        return i()[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object f(Object obj) {
        if (needsAllocArrays()) {
            return g;
        }
        int c2 = c();
        int f2 = g2.f(obj, null, c2, j(), h(), i(), null);
        if (f2 == -1) {
            return g;
        }
        Object r = r(f2);
        moveLastEntry(f2, c2);
        this.c--;
        incrementModCount();
        return r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] h() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] i() {
        Object[] objArr = this.keys;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object j() {
        Object obj = this.a;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] k() {
        Object[] objArr = this.values;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private void l(int i) {
        int min;
        int length = h().length;
        if (i <= length || (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(min);
    }

    private int m(int i, int i2, int i3, int i4) {
        Object a2 = g2.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            g2.i(a2, i3 & i5, i4 + 1);
        }
        Object j = j();
        int[] h2 = h();
        for (int i6 = 0; i6 <= i; i6++) {
            int h3 = g2.h(j, i6);
            while (h3 != 0) {
                int i7 = h3 - 1;
                int i8 = h2[i7];
                int b2 = g2.b(i8, i) | i6;
                int i9 = b2 & i5;
                int h4 = g2.h(a2, i9);
                g2.i(a2, i9, h3);
                h2[i7] = g2.d(b2, h4, i5);
                h3 = g2.c(i8, i);
            }
        }
        this.a = a2;
        o(i5);
        return i5;
    }

    private void n(int i, int i2) {
        h()[i] = i2;
    }

    private void o(int i) {
        this.b = g2.d(this.b, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    private void p(int i, Object obj) {
        i()[i] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, Object obj) {
        k()[i] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object r(int i) {
        return k()[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid size: " + readInt);
        }
        init(readInt);
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> entrySetIterator = entrySetIterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry<K, V> next = entrySetIterator.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    void accessEntry(int i) {
    }

    int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    int allocArrays() {
        com.google.common.base.m.v(needsAllocArrays(), "Arrays already allocated");
        int i = this.b;
        int j = g2.j(i);
        this.a = g2.a(j);
        o(j - 1);
        this.entries = new int[i];
        this.keys = new Object[i];
        this.values = new Object[i];
        return i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.b = Ints.f(size(), 3, 1073741823);
            delegateOrNull.clear();
            this.a = null;
            this.c = 0;
            return;
        }
        Arrays.fill(i(), 0, this.c, (Object) null);
        Arrays.fill(k(), 0, this.c, (Object) null);
        g2.g(j());
        Arrays.fill(h(), 0, this.c, 0);
        this.c = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.containsKey(obj) : d(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsValue(obj);
        }
        for (int i = 0; i < this.c; i++) {
            if (com.google.common.base.j.a(obj, r(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(c() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.put(e(firstEntryIndex), r(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.a = createHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    Set<Map.Entry<K, V>> createEntrySet() {
        return new d();
    }

    Map<K, V> createHashFloodingResistantDelegate(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    Set<K> createKeySet() {
        return new f();
    }

    Collection<V> createValues() {
        return new h();
    }

    Map<K, V> delegateOrNull() {
        Object obj = this.a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.e;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.e = createEntrySet;
        return createEntrySet;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.entrySet().iterator() : new b();
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.get(obj);
        }
        int d2 = d(obj);
        if (d2 == -1) {
            return null;
        }
        accessEntry(d2);
        return (V) r(d2);
    }

    int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.c) {
            return i2;
        }
        return -1;
    }

    void incrementModCount() {
        this.b += 32;
    }

    void init(int i) {
        com.google.common.base.m.e(i >= 0, "Expected size must be >= 0");
        this.b = Ints.f(i, 1, 1073741823);
    }

    void insertEntry(int i, K k, V v, int i2, int i3) {
        n(i, g2.d(i2, 0, i3));
        p(i, k);
        q(i, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.d;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.d = createKeySet;
        return createKeySet;
    }

    Iterator<K> keySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.keySet().iterator() : new a();
    }

    void moveLastEntry(int i, int i2) {
        Object j = j();
        int[] h2 = h();
        Object[] i3 = i();
        Object[] k = k();
        int size = size();
        int i4 = size - 1;
        if (i >= i4) {
            i3[i] = null;
            k[i] = null;
            h2[i] = 0;
            return;
        }
        Object obj = i3[i4];
        i3[i] = obj;
        k[i] = k[i4];
        i3[i4] = null;
        k[i4] = null;
        h2[i] = h2[i4];
        h2[i4] = 0;
        int d2 = v2.d(obj) & i2;
        int h3 = g2.h(j, d2);
        if (h3 == size) {
            g2.i(j, d2, i + 1);
            return;
        }
        while (true) {
            int i5 = h3 - 1;
            int i6 = h2[i5];
            int c2 = g2.c(i6, i2);
            if (c2 == size) {
                h2[i5] = g2.d(i6, i + 1, i2);
                return;
            }
            h3 = c2;
        }
    }

    boolean needsAllocArrays() {
        return this.a == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        int m;
        int i;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.put(k, v);
        }
        int[] h2 = h();
        Object[] i2 = i();
        Object[] k2 = k();
        int i3 = this.c;
        int i4 = i3 + 1;
        int d2 = v2.d(k);
        int c2 = c();
        int i5 = d2 & c2;
        int h3 = g2.h(j(), i5);
        if (h3 != 0) {
            int b2 = g2.b(d2, c2);
            int i6 = 0;
            while (true) {
                int i7 = h3 - 1;
                int i8 = h2[i7];
                if (g2.b(i8, c2) == b2 && com.google.common.base.j.a(k, i2[i7])) {
                    V v2 = (V) k2[i7];
                    k2[i7] = v;
                    accessEntry(i7);
                    return v2;
                }
                int c3 = g2.c(i8, c2);
                i6++;
                if (c3 != 0) {
                    h3 = c3;
                } else {
                    if (i6 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k, v);
                    }
                    if (i4 > c2) {
                        m = m(c2, g2.e(c2), d2, i3);
                    } else {
                        h2[i7] = g2.d(i8, i4, c2);
                    }
                }
            }
        } else if (i4 > c2) {
            m = m(c2, g2.e(c2), d2, i3);
            i = m;
        } else {
            g2.i(j(), i5, i4);
            i = c2;
        }
        l(i4);
        insertEntry(i3, k, v, d2, i);
        this.c = i4;
        incrementModCount();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        V v = (V) f(obj);
        if (v == g) {
            return null;
        }
        return v;
    }

    void resizeEntries(int i) {
        this.entries = Arrays.copyOf(h(), i);
        this.keys = Arrays.copyOf(i(), i);
        this.values = Arrays.copyOf(k(), i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.c;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            createHashFloodingResistantDelegate.putAll(delegateOrNull);
            this.a = createHashFloodingResistantDelegate;
            return;
        }
        int i = this.c;
        if (i < h().length) {
            resizeEntries(i);
        }
        int j = g2.j(i);
        int c2 = c();
        if (j < c2) {
            m(c2, j, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.f = createValues;
        return createValues;
    }

    Iterator<V> valuesIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.values().iterator() : new c();
    }
}
