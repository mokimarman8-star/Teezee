package k;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class b implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    c f15982a;

    /* renamed from: b, reason: collision with root package name */
    private c f15983b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakHashMap f15984c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    private int f15985d = 0;

    static class a extends e {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // k.b.e
        c b(c cVar) {
            return cVar.f15989d;
        }

        @Override // k.b.e
        c c(c cVar) {
            return cVar.f15988c;
        }
    }

    /* renamed from: k.b$b, reason: collision with other inner class name */
    private static class C0150b extends e {
        C0150b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // k.b.e
        c b(c cVar) {
            return cVar.f15988c;
        }

        @Override // k.b.e
        c c(c cVar) {
            return cVar.f15989d;
        }
    }

    static class c implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        final Object f15986a;

        /* renamed from: b, reason: collision with root package name */
        final Object f15987b;

        /* renamed from: c, reason: collision with root package name */
        c f15988c;

        /* renamed from: d, reason: collision with root package name */
        c f15989d;

        c(Object obj, Object obj2) {
            this.f15986a = obj;
            this.f15987b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f15986a.equals(cVar.f15986a) && this.f15987b.equals(cVar.f15987b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f15986a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f15987b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f15986a.hashCode() ^ this.f15987b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f15986a + "=" + this.f15987b;
        }
    }

    public class d extends f implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private c f15990a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f15991b = true;

        d() {
        }

        @Override // k.b.f
        void a(c cVar) {
            c cVar2 = this.f15990a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f15989d;
                this.f15990a = cVar3;
                this.f15991b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f15991b) {
                this.f15991b = false;
                this.f15990a = b.this.f15982a;
            } else {
                c cVar = this.f15990a;
                this.f15990a = cVar != null ? cVar.f15988c : null;
            }
            return this.f15990a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f15991b) {
                return b.this.f15982a != null;
            }
            c cVar = this.f15990a;
            return (cVar == null || cVar.f15988c == null) ? false : true;
        }
    }

    private static abstract class e extends f implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        c f15993a;

        /* renamed from: b, reason: collision with root package name */
        c f15994b;

        e(c cVar, c cVar2) {
            this.f15993a = cVar2;
            this.f15994b = cVar;
        }

        private c e() {
            c cVar = this.f15994b;
            c cVar2 = this.f15993a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // k.b.f
        public void a(c cVar) {
            if (this.f15993a == cVar && cVar == this.f15994b) {
                this.f15994b = null;
                this.f15993a = null;
            }
            c cVar2 = this.f15993a;
            if (cVar2 == cVar) {
                this.f15993a = b(cVar2);
            }
            if (this.f15994b == cVar) {
                this.f15994b = e();
            }
        }

        abstract c b(c cVar);

        abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f15994b;
            this.f15994b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15994b != null;
        }
    }

    public static abstract class f {
        abstract void a(c cVar);
    }

    public Map.Entry a() {
        return this.f15982a;
    }

    protected c b(Object obj) {
        c cVar = this.f15982a;
        while (cVar != null && !cVar.f15986a.equals(obj)) {
            cVar = cVar.f15988c;
        }
        return cVar;
    }

    public d c() {
        d dVar = new d();
        this.f15984c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Iterator descendingIterator() {
        C0150b c0150b = new C0150b(this.f15983b, this.f15982a);
        this.f15984c.put(c0150b, Boolean.FALSE);
        return c0150b;
    }

    public Map.Entry e() {
        return this.f15983b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    c f(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f15985d++;
        c cVar2 = this.f15983b;
        if (cVar2 == null) {
            this.f15982a = cVar;
            this.f15983b = cVar;
            return cVar;
        }
        cVar2.f15988c = cVar;
        cVar.f15989d = cVar2;
        this.f15983b = cVar;
        return cVar;
    }

    public Object g(Object obj, Object obj2) {
        c b5 = b(obj);
        if (b5 != null) {
            return b5.f15987b;
        }
        f(obj, obj2);
        return null;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i5 += ((Map.Entry) it.next()).hashCode();
        }
        return i5;
    }

    public Object i(Object obj) {
        c b5 = b(obj);
        if (b5 == null) {
            return null;
        }
        this.f15985d--;
        if (!this.f15984c.isEmpty()) {
            Iterator it = this.f15984c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(b5);
            }
        }
        c cVar = b5.f15989d;
        if (cVar != null) {
            cVar.f15988c = b5.f15988c;
        } else {
            this.f15982a = b5.f15988c;
        }
        c cVar2 = b5.f15988c;
        if (cVar2 != null) {
            cVar2.f15989d = cVar;
        } else {
            this.f15983b = cVar;
        }
        b5.f15988c = null;
        b5.f15989d = null;
        return b5.f15987b;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f15982a, this.f15983b);
        this.f15984c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f15985d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
