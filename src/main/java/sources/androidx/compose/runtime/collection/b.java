package androidx.compose.runtime.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final int f2677d = 8;

    /* renamed from: a, reason: collision with root package name */
    private Object[] f2678a;

    /* renamed from: b, reason: collision with root package name */
    private List f2679b;

    /* renamed from: c, reason: collision with root package name */
    private int f2680c;

    private static final class a implements List, KMutableList {

        /* renamed from: a, reason: collision with root package name */
        private final b f2681a;

        public a(b bVar) {
            this.f2681a = bVar;
        }

        public int a() {
            return this.f2681a.n();
        }

        @Override // java.util.List
        public void add(int i5, Object obj) {
            this.f2681a.a(i5, obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            return this.f2681a.b(obj);
        }

        @Override // java.util.List
        public boolean addAll(int i5, Collection collection) {
            return this.f2681a.d(i5, collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            return this.f2681a.f(collection);
        }

        public Object c(int i5) {
            androidx.compose.runtime.collection.c.c(this, i5);
            return this.f2681a.v(i5);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.f2681a.h();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.f2681a.i(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            return this.f2681a.j(collection);
        }

        @Override // java.util.List
        public Object get(int i5) {
            androidx.compose.runtime.collection.c.c(this, i5);
            return this.f2681a.m()[i5];
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.f2681a.o(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.f2681a.p();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.f2681a.s(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i5) {
            return new c(this, i5);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i5) {
            return c(i5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.f2681a.t(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            return this.f2681a.u(collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            return this.f2681a.x(collection);
        }

        @Override // java.util.List
        public Object set(int i5, Object obj) {
            androidx.compose.runtime.collection.c.c(this, i5);
            return this.f2681a.y(i5, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.List
        public List subList(int i5, int i6) {
            androidx.compose.runtime.collection.c.d(this, i5, i6);
            return new C0021b(this, i5, i6);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return CollectionToArray.b(this, objArr);
        }
    }

    /* renamed from: androidx.compose.runtime.collection.b$b, reason: collision with other inner class name */
    private static final class C0021b implements List, KMutableList {

        /* renamed from: a, reason: collision with root package name */
        private final List f2682a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2683b;

        /* renamed from: c, reason: collision with root package name */
        private int f2684c;

        public C0021b(List list, int i5, int i6) {
            this.f2682a = list;
            this.f2683b = i5;
            this.f2684c = i6;
        }

        public int a() {
            return this.f2684c - this.f2683b;
        }

        @Override // java.util.List
        public void add(int i5, Object obj) {
            this.f2682a.add(i5 + this.f2683b, obj);
            this.f2684c++;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            List list = this.f2682a;
            int i5 = this.f2684c;
            this.f2684c = i5 + 1;
            list.add(i5, obj);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i5, Collection collection) {
            this.f2682a.addAll(i5 + this.f2683b, collection);
            this.f2684c += collection.size();
            return collection.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            this.f2682a.addAll(this.f2684c, collection);
            this.f2684c += collection.size();
            return collection.size() > 0;
        }

        public Object c(int i5) {
            androidx.compose.runtime.collection.c.c(this, i5);
            this.f2684c--;
            return this.f2682a.remove(i5 + this.f2683b);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i5 = this.f2684c - 1;
            int i6 = this.f2683b;
            if (i6 <= i5) {
                while (true) {
                    this.f2682a.remove(i5);
                    if (i5 == i6) {
                        break;
                    } else {
                        i5--;
                    }
                }
            }
            this.f2684c = this.f2683b;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i5 = this.f2684c;
            for (int i6 = this.f2683b; i6 < i5; i6++) {
                if (Intrinsics.c(this.f2682a.get(i6), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public Object get(int i5) {
            androidx.compose.runtime.collection.c.c(this, i5);
            return this.f2682a.get(i5 + this.f2683b);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i5 = this.f2684c;
            for (int i6 = this.f2683b; i6 < i5; i6++) {
                if (Intrinsics.c(this.f2682a.get(i6), obj)) {
                    return i6 - this.f2683b;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.f2684c == this.f2683b;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i5 = this.f2684c - 1;
            int i6 = this.f2683b;
            if (i6 > i5) {
                return -1;
            }
            while (!Intrinsics.c(this.f2682a.get(i5), obj)) {
                if (i5 == i6) {
                    return -1;
                }
                i5--;
            }
            return i5 - this.f2683b;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i5) {
            return new c(this, i5);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i5) {
            return c(i5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i5 = this.f2684c;
            for (int i6 = this.f2683b; i6 < i5; i6++) {
                if (Intrinsics.c(this.f2682a.get(i6), obj)) {
                    this.f2682a.remove(i6);
                    this.f2684c--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            int i5 = this.f2684c;
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i5 != this.f2684c;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            int i5 = this.f2684c;
            int i6 = i5 - 1;
            int i7 = this.f2683b;
            if (i7 <= i6) {
                while (true) {
                    if (!collection.contains(this.f2682a.get(i6))) {
                        this.f2682a.remove(i6);
                        this.f2684c--;
                    }
                    if (i6 == i7) {
                        break;
                    }
                    i6--;
                }
            }
            return i5 != this.f2684c;
        }

        @Override // java.util.List
        public Object set(int i5, Object obj) {
            androidx.compose.runtime.collection.c.c(this, i5);
            return this.f2682a.set(i5 + this.f2683b, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.List
        public List subList(int i5, int i6) {
            androidx.compose.runtime.collection.c.d(this, i5, i6);
            return new C0021b(this, i5, i6);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return CollectionToArray.b(this, objArr);
        }
    }

    private static final class c implements ListIterator, KMutableListIterator {

        /* renamed from: a, reason: collision with root package name */
        private final List f2685a;

        /* renamed from: b, reason: collision with root package name */
        private int f2686b;

        public c(List list, int i5) {
            this.f2685a = list;
            this.f2686b = i5;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.f2685a.add(this.f2686b, obj);
            this.f2686b++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f2686b < this.f2685a.size();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f2686b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            List list = this.f2685a;
            int i5 = this.f2686b;
            this.f2686b = i5 + 1;
            return list.get(i5);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2686b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            int i5 = this.f2686b - 1;
            this.f2686b = i5;
            return this.f2685a.get(i5);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2686b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i5 = this.f2686b - 1;
            this.f2686b = i5;
            this.f2685a.remove(i5);
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            this.f2685a.set(this.f2686b, obj);
        }
    }

    public b(Object[] objArr, int i5) {
        this.f2678a = objArr;
        this.f2680c = i5;
    }

    public final void A(Comparator comparator) {
        ArraysKt.F(this.f2678a, comparator, 0, this.f2680c);
    }

    public final void a(int i5, Object obj) {
        k(this.f2680c + 1);
        Object[] objArr = this.f2678a;
        int i6 = this.f2680c;
        if (i5 != i6) {
            ArraysKt.l(objArr, objArr, i5 + 1, i5, i6);
        }
        objArr[i5] = obj;
        this.f2680c++;
    }

    public final boolean b(Object obj) {
        k(this.f2680c + 1);
        Object[] objArr = this.f2678a;
        int i5 = this.f2680c;
        objArr[i5] = obj;
        this.f2680c = i5 + 1;
        return true;
    }

    public final boolean c(int i5, b bVar) {
        if (bVar.p()) {
            return false;
        }
        k(this.f2680c + bVar.f2680c);
        Object[] objArr = this.f2678a;
        int i6 = this.f2680c;
        if (i5 != i6) {
            ArraysKt.l(objArr, objArr, bVar.f2680c + i5, i5, i6);
        }
        ArraysKt.l(bVar.f2678a, objArr, i5, 0, bVar.f2680c);
        this.f2680c += bVar.f2680c;
        return true;
    }

    public final boolean d(int i5, Collection collection) {
        int i6 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        k(this.f2680c + collection.size());
        Object[] objArr = this.f2678a;
        if (i5 != this.f2680c) {
            ArraysKt.l(objArr, objArr, collection.size() + i5, i5, this.f2680c);
        }
        for (Object obj : collection) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt.u();
            }
            objArr[i6 + i5] = obj;
            i6 = i7;
        }
        this.f2680c += collection.size();
        return true;
    }

    public final boolean e(int i5, List list) {
        if (list.isEmpty()) {
            return false;
        }
        k(this.f2680c + list.size());
        Object[] objArr = this.f2678a;
        if (i5 != this.f2680c) {
            ArraysKt.l(objArr, objArr, list.size() + i5, i5, this.f2680c);
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            objArr[i5 + i6] = list.get(i6);
        }
        this.f2680c += list.size();
        return true;
    }

    public final boolean f(Collection collection) {
        return d(this.f2680c, collection);
    }

    public final List g() {
        List list = this.f2679b;
        if (list != null) {
            return list;
        }
        a aVar = new a(this);
        this.f2679b = aVar;
        return aVar;
    }

    public final void h() {
        Object[] objArr = this.f2678a;
        int n5 = n();
        while (true) {
            n5--;
            if (-1 >= n5) {
                this.f2680c = 0;
                return;
            }
            objArr[n5] = null;
        }
    }

    public final boolean i(Object obj) {
        int n5 = n() - 1;
        if (n5 >= 0) {
            for (int i5 = 0; !Intrinsics.c(m()[i5], obj); i5++) {
                if (i5 != n5) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean j(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!i(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void k(int i5) {
        Object[] objArr = this.f2678a;
        if (objArr.length < i5) {
            Object[] copyOf = Arrays.copyOf(objArr, Math.max(i5, objArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f2678a = copyOf;
        }
    }

    public final Object l() {
        if (p()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return m()[0];
    }

    public final Object[] m() {
        return this.f2678a;
    }

    public final int n() {
        return this.f2680c;
    }

    public final int o(Object obj) {
        int i5 = this.f2680c;
        if (i5 <= 0) {
            return -1;
        }
        Object[] objArr = this.f2678a;
        int i6 = 0;
        while (!Intrinsics.c(obj, objArr[i6])) {
            i6++;
            if (i6 >= i5) {
                return -1;
            }
        }
        return i6;
    }

    public final boolean p() {
        return this.f2680c == 0;
    }

    public final boolean q() {
        return this.f2680c != 0;
    }

    public final Object r() {
        if (p()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return m()[n() - 1];
    }

    public final int s(Object obj) {
        int i5 = this.f2680c;
        if (i5 <= 0) {
            return -1;
        }
        int i6 = i5 - 1;
        Object[] objArr = this.f2678a;
        while (!Intrinsics.c(obj, objArr[i6])) {
            i6--;
            if (i6 < 0) {
                return -1;
            }
        }
        return i6;
    }

    public final boolean t(Object obj) {
        int o5 = o(obj);
        if (o5 < 0) {
            return false;
        }
        v(o5);
        return true;
    }

    public final boolean u(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int i5 = this.f2680c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            t(it.next());
        }
        return i5 != this.f2680c;
    }

    public final Object v(int i5) {
        Object[] objArr = this.f2678a;
        Object obj = objArr[i5];
        if (i5 != n() - 1) {
            ArraysKt.l(objArr, objArr, i5, i5 + 1, this.f2680c);
        }
        int i6 = this.f2680c - 1;
        this.f2680c = i6;
        objArr[i6] = null;
        return obj;
    }

    public final void w(int i5, int i6) {
        if (i6 > i5) {
            int i7 = this.f2680c;
            if (i6 < i7) {
                Object[] objArr = this.f2678a;
                ArraysKt.l(objArr, objArr, i5, i6, i7);
            }
            int i8 = this.f2680c - (i6 - i5);
            int n5 = n() - 1;
            if (i8 <= n5) {
                int i9 = i8;
                while (true) {
                    this.f2678a[i9] = null;
                    if (i9 == n5) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            this.f2680c = i8;
        }
    }

    public final boolean x(Collection collection) {
        int i5 = this.f2680c;
        for (int n5 = n() - 1; -1 < n5; n5--) {
            if (!collection.contains(m()[n5])) {
                v(n5);
            }
        }
        return i5 != this.f2680c;
    }

    public final Object y(int i5, Object obj) {
        Object[] objArr = this.f2678a;
        Object obj2 = objArr[i5];
        objArr[i5] = obj;
        return obj2;
    }

    public final void z(int i5) {
        this.f2680c = i5;
    }
}
