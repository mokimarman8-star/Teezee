package org.mvel2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class q implements Map {
    private final Map a;
    private final ArrayList b;

    private class a {
        private int a;
        private Object b;
        private Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        public int a() {
            return this.a;
        }

        public Object b() {
            return this.b;
        }

        public Object c() {
            return this.c;
        }

        void d(Object obj) {
            this.c = obj;
        }
    }

    public q() {
        this.a = new HashMap();
        this.b = new ArrayList();
    }

    public q(q qVar, boolean z) {
        this.b = new ArrayList(qVar.b.size());
        this.a = new HashMap();
        int i = 0;
        if (z) {
            Iterator it = qVar.b.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                a aVar2 = new a(i, aVar.b(), null);
                this.b.add(aVar2);
                this.a.put(aVar.b(), aVar2);
                i++;
            }
            return;
        }
        Iterator it2 = qVar.b.iterator();
        while (it2.hasNext()) {
            a aVar3 = (a) it2.next();
            a aVar4 = new a(i, aVar3.b(), aVar3.c());
            this.b.add(aVar4);
            this.a.put(aVar3.b(), aVar4);
            i++;
        }
    }

    public Object a(int i) {
        return ((a) this.b.get(i)).c();
    }

    public int c(Object obj) {
        return ((a) this.a.get(obj)).a();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("cannot clear map");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.a.containsValue(obj);
    }

    public void d(int i, Object obj) {
        ((a) this.b.get(i)).d(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return ((a) this.a.get(obj)).c();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        return this.a.keySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        a aVar = (a) this.a.get(obj);
        if (aVar == null) {
            throw new RuntimeException("cannot add a new entry.  you must allocate a new key with addKey() first.");
        }
        this.b.add(aVar);
        return ((a) this.a.put(obj, aVar)).c();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("cannot remove keys");
    }

    @Override // java.util.Map
    public int size() {
        return this.a.size();
    }

    @Override // java.util.Map
    public Collection values() {
        throw new UnsupportedOperationException();
    }
}
