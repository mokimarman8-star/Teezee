package androidx.collection;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b implements Collection, Set, KMutableCollection, KMutableSet {

    /* renamed from: a, reason: collision with root package name */
    private int[] f1260a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f1261b;

    /* renamed from: c, reason: collision with root package name */
    private int f1262c;

    private final class a extends k {
        public a() {
            super(b.this.i());
        }

        @Override // androidx.collection.k
        protected Object a(int i5) {
            return b.this.o(i5);
        }

        @Override // androidx.collection.k
        protected void c(int i5) {
            b.this.j(i5);
        }
    }

    @JvmOverloads
    public b() {
        this(0, 1, null);
    }

    public b(int i5) {
        this.f1260a = n.a.f16549a;
        this.f1261b = n.a.f16551c;
        if (i5 > 0) {
            d.a(this, i5);
        }
    }

    public /* synthetic */ b(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i5);
    }

    public final void a(int i5) {
        int i6 = i();
        if (e().length < i5) {
            int[] e5 = e();
            Object[] c5 = c();
            d.a(this, i5);
            if (i() > 0) {
                ArraysKt.o(e5, e(), 0, 0, i(), 6, (Object) null);
                ArraysKt.p(c5, c(), 0, 0, i(), 6, (Object) null);
            }
        }
        if (i() != i6) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i5;
        int c5;
        int i6 = i();
        if (obj == null) {
            c5 = d.d(this);
            i5 = 0;
        } else {
            int hashCode = obj.hashCode();
            i5 = hashCode;
            c5 = d.c(this, obj, hashCode);
        }
        if (c5 >= 0) {
            return false;
        }
        int i7 = ~c5;
        if (i6 >= e().length) {
            int i8 = 8;
            if (i6 >= 8) {
                i8 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i8 = 4;
            }
            int[] e5 = e();
            Object[] c6 = c();
            d.a(this, i8);
            if (i6 != i()) {
                throw new ConcurrentModificationException();
            }
            if (!(e().length == 0)) {
                ArraysKt.o(e5, e(), 0, 0, e5.length, 6, (Object) null);
                ArraysKt.p(c6, c(), 0, 0, c6.length, 6, (Object) null);
            }
        }
        if (i7 < i6) {
            int i9 = i7 + 1;
            ArraysKt.j(e(), e(), i9, i7, i6);
            ArraysKt.l(c(), c(), i9, i7, i6);
        }
        if (i6 != i() || i7 >= e().length) {
            throw new ConcurrentModificationException();
        }
        e()[i7] = i5;
        c()[i7] = obj;
        n(i() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        Intrinsics.h(collection, "elements");
        a(i() + collection.size());
        Iterator it = collection.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= add(it.next());
        }
        return z5;
    }

    public final Object[] c() {
        return this.f1261b;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (i() != 0) {
            m(n.a.f16549a);
            l(n.a.f16551c);
            n(0);
        }
        if (i() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        Intrinsics.h(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int[] e() {
        return this.f1260a;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && size() == ((Set) obj).size()) {
            try {
                int i5 = i();
                for (int i6 = 0; i6 < i5; i6++) {
                    if (((Set) obj).contains(o(i6))) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int f() {
        return this.f1262c;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] e5 = e();
        int i5 = i();
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += e5[i7];
        }
        return i6;
    }

    public final int i() {
        return this.f1262c;
    }

    public final int indexOf(Object obj) {
        return obj == null ? d.d(this) : d.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return i() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new a();
    }

    public final Object j(int i5) {
        int i6 = i();
        Object obj = c()[i5];
        if (i6 <= 1) {
            clear();
        } else {
            int i7 = i6 - 1;
            if (e().length <= 8 || i() >= e().length / 3) {
                if (i5 < i7) {
                    int i8 = i5 + 1;
                    ArraysKt.j(e(), e(), i5, i8, i6);
                    ArraysKt.l(c(), c(), i5, i8, i6);
                }
                c()[i7] = null;
            } else {
                int i9 = i() > 8 ? i() + (i() >> 1) : 8;
                int[] e5 = e();
                Object[] c5 = c();
                d.a(this, i9);
                if (i5 > 0) {
                    ArraysKt.o(e5, e(), 0, 0, i5, 6, (Object) null);
                    ArraysKt.p(c5, c(), 0, 0, i5, 6, (Object) null);
                }
                if (i5 < i7) {
                    int i10 = i5 + 1;
                    ArraysKt.j(e5, e(), i5, i10, i6);
                    ArraysKt.l(c5, c(), i5, i10, i6);
                }
            }
            if (i6 != i()) {
                throw new ConcurrentModificationException();
            }
            n(i7);
        }
        return obj;
    }

    public final void l(Object[] objArr) {
        Intrinsics.h(objArr, "<set-?>");
        this.f1261b = objArr;
    }

    public final void m(int[] iArr) {
        Intrinsics.h(iArr, "<set-?>");
        this.f1260a = iArr;
    }

    public final void n(int i5) {
        this.f1262c = i5;
    }

    public final Object o(int i5) {
        return c()[i5];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        j(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        Intrinsics.h(collection, "elements");
        Iterator it = collection.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= remove(it.next());
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        Intrinsics.h(collection, "elements");
        boolean z5 = false;
        for (int i5 = i() - 1; -1 < i5; i5--) {
            if (!CollectionsKt.b0(collection, c()[i5])) {
                j(i5);
                z5 = true;
            }
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return f();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return ArraysKt.r(this.f1261b, 0, this.f1262c);
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        Intrinsics.h(objArr, "array");
        Object[] a5 = c.a(objArr, this.f1262c);
        ArraysKt.l(this.f1261b, a5, 0, 0, this.f1262c);
        Intrinsics.g(a5, "result");
        return a5;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i() * 14);
        sb.append('{');
        int i5 = i();
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            Object o5 = o(i6);
            if (o5 != this) {
                sb.append(o5);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}
