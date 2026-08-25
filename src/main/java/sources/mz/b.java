package mz;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class b implements Iterator {
    private static final WeakHashMap c = new WeakHashMap();
    private Object a;
    private Iterator b;

    b(Object obj, Iterator it) {
        if (obj == null) {
            throw new IllegalArgumentException("parent object is null");
        }
        if (it == null) {
            throw new IllegalArgumentException("cannot wrap null iterator");
        }
        this.a = obj;
        if (it.hasNext()) {
            this.b = it;
            a(this);
        }
    }

    private static synchronized void a(b bVar) {
        synchronized (b.class) {
            try {
                WeakHashMap weakHashMap = c;
                Set set = (Set) weakHashMap.get(bVar.a);
                if (set == null) {
                    set = new HashSet();
                    weakHashMap.put(bVar.a, set);
                }
                set.add(bVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static synchronized void b(b bVar) {
        synchronized (b.class) {
            if (!((Set) c.get(bVar.a)).contains(bVar)) {
                throw new ConcurrentModificationException();
            }
        }
    }

    static synchronized void c(Object obj) {
        synchronized (b.class) {
            Set set = (Set) c.get(obj);
            if (set != null) {
                set.clear();
            }
        }
    }

    private static synchronized void d(b bVar) {
        synchronized (b.class) {
            Set set = (Set) c.get(bVar.a);
            if (set != null) {
                set.remove(bVar);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.b == null) {
            return false;
        }
        b(this);
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Iterator it = this.b;
        if (it == null || !it.hasNext()) {
            throw new NoSuchElementException();
        }
        b(this);
        try {
            return this.b.next();
        } finally {
            if (!this.b.hasNext()) {
                this.b = null;
                d(this);
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
