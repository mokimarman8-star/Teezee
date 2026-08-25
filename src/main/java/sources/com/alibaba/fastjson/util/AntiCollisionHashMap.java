package com.alibaba.fastjson.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AntiCollisionHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int KEY = 16777619;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int M_MASK = -2023358765;
    static final int SEED = -2128831035;
    private static final long serialVersionUID = 362498820763181265L;
    private transient Set<Map.Entry<K, V>> entrySet;
    volatile transient Set<K> keySet;
    final float loadFactor;
    volatile transient int modCount;
    final int random;
    transient int size;
    transient b[] table;
    int threshold;
    volatile transient Collection<V> values;

    static class b implements Map.Entry {
        final Object a;
        Object b;
        b c;
        final int d;

        b(int i, Object obj, Object obj2, b bVar) {
            this.b = obj2;
            this.c = bVar;
            this.a = obj;
            this.d = i;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = getKey();
            Object key2 = entry.getKey();
            if (key != key2 && (key == null || !key.equals(key2))) {
                return false;
            }
            Object value = getValue();
            Object value2 = entry.getValue();
            return value == value2 || (value != null && value.equals(value2));
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Object obj = this.a;
            int hashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.b;
            return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            Object obj2 = this.b;
            this.b = obj;
            return obj2;
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    private final class c extends e {
        private c() {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            return a();
        }
    }

    private final class d extends AbstractSet {
        private d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            b entry2 = AntiCollisionHashMap.this.getEntry(entry.getKey());
            return entry2 != null && entry2.equals(entry);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return AntiCollisionHashMap.this.newEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeMapping(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    private abstract class e implements Iterator {
        b a;
        int b;
        int c;
        b d;

        e() {
            b bVar;
            this.b = AntiCollisionHashMap.this.modCount;
            if (AntiCollisionHashMap.this.size > 0) {
                b[] bVarArr = AntiCollisionHashMap.this.table;
                do {
                    int i = this.c;
                    if (i >= bVarArr.length) {
                        return;
                    }
                    this.c = i + 1;
                    bVar = bVarArr[i];
                    this.a = bVar;
                } while (bVar == null);
            }
        }

        final b a() {
            b bVar;
            if (AntiCollisionHashMap.this.modCount != this.b) {
                throw new ConcurrentModificationException();
            }
            b bVar2 = this.a;
            if (bVar2 == null) {
                throw new NoSuchElementException();
            }
            b bVar3 = bVar2.c;
            this.a = bVar3;
            if (bVar3 == null) {
                b[] bVarArr = AntiCollisionHashMap.this.table;
                do {
                    int i = this.c;
                    if (i >= bVarArr.length) {
                        break;
                    }
                    this.c = i + 1;
                    bVar = bVarArr[i];
                    this.a = bVar;
                } while (bVar == null);
            }
            this.d = bVar2;
            return bVar2;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.d == null) {
                throw new IllegalStateException();
            }
            if (AntiCollisionHashMap.this.modCount != this.b) {
                throw new ConcurrentModificationException();
            }
            Object obj = this.d.a;
            this.d = null;
            AntiCollisionHashMap.this.removeEntryForKey(obj);
            this.b = AntiCollisionHashMap.this.modCount;
        }
    }

    private final class f extends e {
        private f() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return a().getKey();
        }
    }

    private final class g extends AbstractSet {
        private g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return AntiCollisionHashMap.this.newKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeEntryForKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    private final class h extends e {
        private h() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return a().b;
        }
    }

    private final class i extends AbstractCollection {
        private i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AntiCollisionHashMap.this.newValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    public AntiCollisionHashMap() {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.threshold = 12;
        this.table = new b[16];
        init();
    }

    public AntiCollisionHashMap(int i2) {
        this(i2, DEFAULT_LOAD_FACTOR);
    }

    public AntiCollisionHashMap(int i2, float f2) {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        if (i2 < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + i2);
        }
        i2 = i2 > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : i2;
        if (f2 <= 0.0f || Float.isNaN(f2)) {
            throw new IllegalArgumentException("Illegal load factor: " + f2);
        }
        int i3 = 1;
        while (i3 < i2) {
            i3 <<= 1;
        }
        this.loadFactor = f2;
        this.threshold = (int) (i3 * f2);
        this.table = new b[i3];
        init();
    }

    public AntiCollisionHashMap(Map<? extends K, ? extends V> map) {
        this(Math.max(((int) (map.size() / DEFAULT_LOAD_FACTOR)) + 1, 16), DEFAULT_LOAD_FACTOR);
        putAllForCreate(map);
    }

    private boolean containsNullValue() {
        for (b bVar : this.table) {
            for (; bVar != null; bVar = bVar.c) {
                if (bVar.b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<Map.Entry<K, V>> entrySet0() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        d dVar = new d();
        this.entrySet = dVar;
        return dVar;
    }

    private V getForNullKey() {
        for (b bVar = this.table[0]; bVar != null; bVar = bVar.c) {
            if (bVar.a == null) {
                return (V) bVar.b;
            }
        }
        return null;
    }

    static int hash(int i2) {
        int i3 = i2 * i2;
        int i4 = i3 ^ ((i3 >>> 20) ^ (i3 >>> 12));
        return (i4 >>> 4) ^ ((i4 >>> 7) ^ i4);
    }

    private int hashString(String str) {
        int i2 = this.random * SEED;
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 = (i2 * KEY) ^ str.charAt(i3);
        }
        return ((i2 >> 1) ^ i2) & M_MASK;
    }

    static int indexFor(int i2, int i3) {
        return i2 & (i3 - 1);
    }

    private void putAllForCreate(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putForCreate(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void putForCreate(K k, V v) {
        Object obj;
        int hash = k == 0 ? 0 : k instanceof String ? hash(hashString((String) k)) : hash(k.hashCode());
        int indexFor = indexFor(hash, this.table.length);
        for (b bVar = this.table[indexFor]; bVar != null; bVar = bVar.c) {
            if (bVar.d == hash && ((obj = bVar.a) == k || (k != 0 && k.equals(obj)))) {
                bVar.b = v;
                return;
            }
        }
        createEntry(hash, k, v, indexFor);
    }

    private V putForNullKey(V v) {
        for (b bVar = this.table[0]; bVar != null; bVar = bVar.c) {
            if (bVar.a == null) {
                V v2 = (V) bVar.b;
                bVar.b = v;
                return v2;
            }
        }
        this.modCount++;
        addEntry(0, null, v, 0);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.table = new b[objectInputStream.readInt()];
        init();
        int readInt = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            putForCreate(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Iterator<Map.Entry<K, V>> it = this.size > 0 ? entrySet0().iterator() : null;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        objectOutputStream.writeInt(this.size);
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objectOutputStream.writeObject(next.getKey());
                objectOutputStream.writeObject(next.getValue());
            }
        }
    }

    void addEntry(int i2, K k, V v, int i3) {
        b[] bVarArr = this.table;
        bVarArr[i3] = new b(i2, k, v, bVarArr[i3]);
        int i4 = this.size;
        this.size = i4 + 1;
        if (i4 >= this.threshold) {
            resize(this.table.length * 2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        b[] bVarArr = this.table;
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr[i2] = null;
        }
        this.size = 0;
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        AntiCollisionHashMap antiCollisionHashMap;
        try {
            antiCollisionHashMap = (AntiCollisionHashMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            antiCollisionHashMap = null;
        }
        antiCollisionHashMap.table = new b[this.table.length];
        antiCollisionHashMap.entrySet = null;
        antiCollisionHashMap.modCount = 0;
        antiCollisionHashMap.size = 0;
        antiCollisionHashMap.init();
        antiCollisionHashMap.putAllForCreate(this);
        return antiCollisionHashMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return getEntry(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return containsNullValue();
        }
        for (b bVar : this.table) {
            for (; bVar != null; bVar = bVar.c) {
                if (obj.equals(bVar.b)) {
                    return true;
                }
            }
        }
        return false;
    }

    void createEntry(int i2, K k, V v, int i3) {
        b[] bVarArr = this.table;
        bVarArr[i3] = new b(i2, k, v, bVarArr[i3]);
        this.size++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet0();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Object obj2;
        if (obj == null) {
            return getForNullKey();
        }
        int hash = obj instanceof String ? hash(hashString((String) obj)) : hash(obj.hashCode());
        b[] bVarArr = this.table;
        for (b bVar = bVarArr[indexFor(hash, bVarArr.length)]; bVar != null; bVar = bVar.c) {
            if (bVar.d == hash && ((obj2 = bVar.a) == obj || obj.equals(obj2))) {
                return (V) bVar.b;
            }
        }
        return null;
    }

    final b getEntry(Object obj) {
        Object obj2;
        int hash = obj == null ? 0 : obj instanceof String ? hash(hashString((String) obj)) : hash(obj.hashCode());
        b[] bVarArr = this.table;
        for (b bVar = bVarArr[indexFor(hash, bVarArr.length)]; bVar != null; bVar = bVar.c) {
            if (bVar.d == hash && ((obj2 = bVar.a) == obj || (obj != null && obj.equals(obj2)))) {
                return bVar;
            }
        }
        return null;
    }

    void init() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.keySet = gVar;
        return gVar;
    }

    Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new c();
    }

    Iterator<K> newKeyIterator() {
        return new f();
    }

    Iterator<V> newValueIterator() {
        return new h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Object obj;
        if (k == 0) {
            return putForNullKey(v);
        }
        int hash = k instanceof String ? hash(hashString((String) k)) : hash(k.hashCode());
        int indexFor = indexFor(hash, this.table.length);
        for (b bVar = this.table[indexFor]; bVar != null; bVar = bVar.c) {
            if (bVar.d == hash && ((obj = bVar.a) == k || k.equals(obj))) {
                V v2 = (V) bVar.b;
                bVar.b = v;
                return v2;
            }
        }
        this.modCount++;
        addEntry(hash, k, v, indexFor);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return;
        }
        if (size > this.threshold) {
            int i2 = (int) ((size / this.loadFactor) + 1.0f);
            if (i2 > MAXIMUM_CAPACITY) {
                i2 = MAXIMUM_CAPACITY;
            }
            int length = this.table.length;
            while (length < i2) {
                length <<= 1;
            }
            if (length > this.table.length) {
                resize(length);
            }
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        b removeEntryForKey = removeEntryForKey(obj);
        if (removeEntryForKey == null) {
            return null;
        }
        return (V) removeEntryForKey.b;
    }

    final b removeEntryForKey(Object obj) {
        Object obj2;
        int hash = obj == null ? 0 : obj instanceof String ? hash(hashString((String) obj)) : hash(obj.hashCode());
        int indexFor = indexFor(hash, this.table.length);
        b bVar = this.table[indexFor];
        b bVar2 = bVar;
        while (bVar != null) {
            b bVar3 = bVar.c;
            if (bVar.d == hash && ((obj2 = bVar.a) == obj || (obj != null && obj.equals(obj2)))) {
                this.modCount++;
                this.size--;
                if (bVar2 == bVar) {
                    this.table[indexFor] = bVar3;
                } else {
                    bVar2.c = bVar3;
                }
                return bVar;
            }
            bVar2 = bVar;
            bVar = bVar3;
        }
        return bVar;
    }

    final b removeMapping(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return null;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int hash = key == null ? 0 : key instanceof String ? hash(hashString((String) key)) : hash(key.hashCode());
        int indexFor = indexFor(hash, this.table.length);
        b bVar = this.table[indexFor];
        b bVar2 = bVar;
        while (bVar != null) {
            b bVar3 = bVar.c;
            if (bVar.d == hash && bVar.equals(entry)) {
                this.modCount++;
                this.size--;
                if (bVar2 == bVar) {
                    this.table[indexFor] = bVar3;
                } else {
                    bVar2.c = bVar3;
                }
                return bVar;
            }
            bVar2 = bVar;
            bVar = bVar3;
        }
        return bVar;
    }

    void resize(int i2) {
        if (this.table.length == MAXIMUM_CAPACITY) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        b[] bVarArr = new b[i2];
        transfer(bVarArr);
        this.table = bVarArr;
        this.threshold = (int) (i2 * this.loadFactor);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    void transfer(b[] bVarArr) {
        b[] bVarArr2 = this.table;
        int length = bVarArr.length;
        for (int i2 = 0; i2 < bVarArr2.length; i2++) {
            b bVar = bVarArr2[i2];
            if (bVar != null) {
                bVarArr2[i2] = null;
                while (true) {
                    b bVar2 = bVar.c;
                    int indexFor = indexFor(bVar.d, length);
                    bVar.c = bVarArr[indexFor];
                    bVarArr[indexFor] = bVar;
                    if (bVar2 == null) {
                        break;
                    } else {
                        bVar = bVar2;
                    }
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        i iVar = new i();
        this.values = iVar;
        return iVar;
    }
}
