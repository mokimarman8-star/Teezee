package androidx.datastore.preferences.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class e1 extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    private List f7605a;

    /* renamed from: b, reason: collision with root package name */
    private Map f7606b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7607c;

    /* renamed from: d, reason: collision with root package name */
    private volatile f f7608d;

    /* renamed from: e, reason: collision with root package name */
    private Map f7609e;

    /* renamed from: f, reason: collision with root package name */
    private volatile c f7610f;

    class a extends e1 {
        a() {
            super(null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.t((Comparable) obj, obj2);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void r() {
            if (!q()) {
                if (m() > 0) {
                    android.support.v4.media.session.c.a(l(0).getKey());
                    throw null;
                }
                Iterator it = o().iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.c.a(((Map.Entry) it.next()).getKey());
                    throw null;
                }
            }
            super.r();
        }
    }

    private class b implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private int f7611a;

        /* renamed from: b, reason: collision with root package name */
        private Iterator f7612b;

        private b() {
            this.f7611a = e1.this.f7605a.size();
        }

        /* synthetic */ b(e1 e1Var, a aVar) {
            this();
        }

        private Iterator a() {
            if (this.f7612b == null) {
                this.f7612b = e1.this.f7609e.entrySet().iterator();
            }
            return this.f7612b;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List list = e1.this.f7605a;
            int i5 = this.f7611a - 1;
            this.f7611a = i5;
            return (Map.Entry) list.get(i5);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i5 = this.f7611a;
            return (i5 > 0 && i5 <= e1.this.f7605a.size()) || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class c extends f {
        private c() {
            super(e1.this, null);
        }

        /* synthetic */ c(e1 e1Var, a aVar) {
            this();
        }

        @Override // androidx.datastore.preferences.protobuf.e1.f, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(e1.this, null);
        }
    }

    private class d implements Map.Entry, Comparable {

        /* renamed from: a, reason: collision with root package name */
        private final Comparable f7615a;

        /* renamed from: b, reason: collision with root package name */
        private Object f7616b;

        d(Comparable comparable, Object obj) {
            this.f7615a = comparable;
            this.f7616b = obj;
        }

        d(e1 e1Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        private boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return getKey().compareTo(dVar.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f7615a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.f7615a, entry.getKey()) && b(this.f7616b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f7616b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f7615a;
            int hashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f7616b;
            return hashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            e1.this.i();
            Object obj2 = this.f7616b;
            this.f7616b = obj;
            return obj2;
        }

        public String toString() {
            return this.f7615a + "=" + this.f7616b;
        }
    }

    private class e implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private int f7618a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f7619b;

        /* renamed from: c, reason: collision with root package name */
        private Iterator f7620c;

        private e() {
            this.f7618a = -1;
        }

        /* synthetic */ e(e1 e1Var, a aVar) {
            this();
        }

        private Iterator a() {
            if (this.f7620c == null) {
                this.f7620c = e1.this.f7606b.entrySet().iterator();
            }
            return this.f7620c;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f7619b = true;
            int i5 = this.f7618a + 1;
            this.f7618a = i5;
            return i5 < e1.this.f7605a.size() ? (Map.Entry) e1.this.f7605a.get(this.f7618a) : (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f7618a + 1 >= e1.this.f7605a.size()) {
                return !e1.this.f7606b.isEmpty() && a().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f7619b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f7619b = false;
            e1.this.i();
            if (this.f7618a >= e1.this.f7605a.size()) {
                a().remove();
                return;
            }
            e1 e1Var = e1.this;
            int i5 = this.f7618a;
            this.f7618a = i5 - 1;
            e1Var.u(i5);
        }
    }

    private class f extends AbstractSet {
        private f() {
        }

        /* synthetic */ f(e1 e1Var, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            e1.this.t((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            e1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = e1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new e(e1.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            e1.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return e1.this.size();
        }
    }

    private e1() {
        this.f7605a = Collections.emptyList();
        this.f7606b = Collections.emptyMap();
        this.f7609e = Collections.emptyMap();
    }

    /* synthetic */ e1(a aVar) {
        this();
    }

    private int h(Comparable comparable) {
        int i5;
        int size = this.f7605a.size();
        int i6 = size - 1;
        if (i6 >= 0) {
            int compareTo = comparable.compareTo(((d) this.f7605a.get(i6)).getKey());
            if (compareTo > 0) {
                i5 = size + 1;
                return -i5;
            }
            if (compareTo == 0) {
                return i6;
            }
        }
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) / 2;
            int compareTo2 = comparable.compareTo(((d) this.f7605a.get(i8)).getKey());
            if (compareTo2 < 0) {
                i6 = i8 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i8;
                }
                i7 = i8 + 1;
            }
        }
        i5 = i7 + 1;
        return -i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f7607c) {
            throw new UnsupportedOperationException();
        }
    }

    private void k() {
        i();
        if (!this.f7605a.isEmpty() || (this.f7605a instanceof ArrayList)) {
            return;
        }
        this.f7605a = new ArrayList(16);
    }

    private SortedMap p() {
        i();
        if (this.f7606b.isEmpty() && !(this.f7606b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f7606b = treeMap;
            this.f7609e = treeMap.descendingMap();
        }
        return (SortedMap) this.f7606b;
    }

    static e1 s() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object u(int i5) {
        i();
        Object value = ((d) this.f7605a.remove(i5)).getValue();
        if (!this.f7606b.isEmpty()) {
            Iterator it = p().entrySet().iterator();
            this.f7605a.add(new d(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        i();
        if (!this.f7605a.isEmpty()) {
            this.f7605a.clear();
        }
        if (this.f7606b.isEmpty()) {
            return;
        }
        this.f7606b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return h(comparable) >= 0 || this.f7606b.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f7608d == null) {
            this.f7608d = new f(this, null);
        }
        return this.f7608d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e1)) {
            return super.equals(obj);
        }
        e1 e1Var = (e1) obj;
        int size = size();
        if (size != e1Var.size()) {
            return false;
        }
        int m5 = m();
        if (m5 != e1Var.m()) {
            return entrySet().equals(e1Var.entrySet());
        }
        for (int i5 = 0; i5 < m5; i5++) {
            if (!l(i5).equals(e1Var.l(i5))) {
                return false;
            }
        }
        if (m5 != size) {
            return this.f7606b.equals(e1Var.f7606b);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int h5 = h(comparable);
        return h5 >= 0 ? ((d) this.f7605a.get(h5)).getValue() : this.f7606b.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int m5 = m();
        int i5 = 0;
        for (int i6 = 0; i6 < m5; i6++) {
            i5 += ((d) this.f7605a.get(i6)).hashCode();
        }
        return n() > 0 ? i5 + this.f7606b.hashCode() : i5;
    }

    Set j() {
        if (this.f7610f == null) {
            this.f7610f = new c(this, null);
        }
        return this.f7610f;
    }

    public Map.Entry l(int i5) {
        return (Map.Entry) this.f7605a.get(i5);
    }

    public int m() {
        return this.f7605a.size();
    }

    public int n() {
        return this.f7606b.size();
    }

    public Iterable o() {
        return this.f7606b.isEmpty() ? Collections.emptySet() : this.f7606b.entrySet();
    }

    public boolean q() {
        return this.f7607c;
    }

    public void r() {
        if (this.f7607c) {
            return;
        }
        this.f7606b = this.f7606b.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f7606b);
        this.f7609e = this.f7609e.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f7609e);
        this.f7607c = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        i();
        Comparable comparable = (Comparable) obj;
        int h5 = h(comparable);
        if (h5 >= 0) {
            return u(h5);
        }
        if (this.f7606b.isEmpty()) {
            return null;
        }
        return this.f7606b.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f7605a.size() + this.f7606b.size();
    }

    public Object t(Comparable comparable, Object obj) {
        i();
        int h5 = h(comparable);
        if (h5 >= 0) {
            return ((d) this.f7605a.get(h5)).setValue(obj);
        }
        k();
        int i5 = -(h5 + 1);
        if (i5 >= 16) {
            return p().put(comparable, obj);
        }
        if (this.f7605a.size() == 16) {
            d dVar = (d) this.f7605a.remove(15);
            p().put(dVar.getKey(), dVar.getValue());
        }
        this.f7605a.add(i5, new d(comparable, obj));
        return null;
    }
}
