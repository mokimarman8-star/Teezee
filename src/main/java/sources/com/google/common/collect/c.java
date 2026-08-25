package com.google.common.collect;

import com.google.common.collect.Multimaps;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class c implements j3 {
    private transient Map<Object, Collection<Object>> asMap;
    private transient Collection<Map.Entry<Object, Object>> entries;
    private transient Set<Object> keySet;
    private transient l3 keys;
    private transient Collection<Object> values;

    class a extends Multimaps.b {
        a() {
        }

        @Override // com.google.common.collect.Multimaps.b
        j3 a() {
            return c.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return c.this.entryIterator();
        }
    }

    class b extends a implements Set {
        b() {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.d(this);
        }
    }

    /* renamed from: com.google.common.collect.c$c, reason: collision with other inner class name */
    class C0013c extends AbstractCollection {
        C0013c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            c.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return c.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return c.this.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return c.this.size();
        }
    }

    c() {
    }

    @Override // com.google.common.collect.j3
    public Map<Object, Collection<Object>> asMap() {
        Map<Object, Collection<Object>> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<Object, Collection<Object>> createAsMap = createAsMap();
        this.asMap = createAsMap;
        return createAsMap;
    }

    @Override // com.google.common.collect.j3
    public boolean containsEntry(Object obj, Object obj2) {
        Collection<Object> collection = asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean containsValue(Object obj) {
        Iterator<Collection<Object>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Map createAsMap();

    /* renamed from: createEntries */
    abstract Collection mo6createEntries();

    abstract Set createKeySet();

    abstract l3 createKeys();

    /* renamed from: createValues */
    abstract Collection mo7createValues();

    @Override // com.google.common.collect.j3
    /* renamed from: entries */
    public Collection mo8entries() {
        Collection<Map.Entry<Object, Object>> collection = this.entries;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<Object, Object>> mo6createEntries = mo6createEntries();
        this.entries = mo6createEntries;
        return mo6createEntries;
    }

    abstract Iterator entryIterator();

    public boolean equals(Object obj) {
        return Multimaps.a(this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.j3
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.j3
    /* renamed from: keySet */
    public Set<Object> mo10keySet() {
        Set<Object> set = this.keySet;
        if (set != null) {
            return set;
        }
        Set<Object> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    public l3 keys() {
        l3 l3Var = this.keys;
        if (l3Var != null) {
            return l3Var;
        }
        l3 createKeys = createKeys();
        this.keys = createKeys;
        return createKeys;
    }

    @Override // com.google.common.collect.j3
    public abstract boolean put(Object obj, Object obj2);

    @Override // com.google.common.collect.j3
    public boolean putAll(j3 j3Var) {
        boolean z = false;
        for (Map.Entry entry : j3Var.mo8entries()) {
            z |= put(entry.getKey(), entry.getValue());
        }
        return z;
    }

    public boolean putAll(Object obj, Iterable<Object> iterable) {
        com.google.common.base.m.o(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return !collection.isEmpty() && mo9get(obj).addAll(collection);
        }
        Iterator<Object> it = iterable.iterator();
        return it.hasNext() && Iterators.a(mo9get(obj), it);
    }

    @Override // com.google.common.collect.j3
    public boolean remove(Object obj, Object obj2) {
        Collection<Object> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public String toString() {
        return asMap().toString();
    }

    Iterator<Object> valueIterator() {
        return Maps.D(mo8entries().iterator());
    }

    @Override // com.google.common.collect.j3
    /* renamed from: values */
    public Collection mo13values() {
        Collection<Object> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<Object> mo7createValues = mo7createValues();
        this.values = mo7createValues;
        return mo7createValues;
    }
}
