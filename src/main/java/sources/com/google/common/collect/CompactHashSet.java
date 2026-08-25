package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    private transient Object a;
    private transient int[] b;
    private transient int c;
    private transient int d;
    transient Object[] elements;

    class a implements Iterator {
        int a;
        int b;
        int c = -1;

        a() {
            this.a = CompactHashSet.this.c;
            this.b = CompactHashSet.this.firstEntryIndex();
        }

        private void a() {
            if (CompactHashSet.this.c != this.a) {
                throw new ConcurrentModificationException();
            }
        }

        void b() {
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
            Object b = CompactHashSet.this.b(i);
            this.b = CompactHashSet.this.getSuccessor(this.b);
            return b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            e2.e(this.c >= 0);
            b();
            CompactHashSet compactHashSet = CompactHashSet.this;
            compactHashSet.remove(compactHashSet.b(this.c));
            this.b = CompactHashSet.this.adjustAfterRemove(this.b, this.c);
            this.c = -1;
        }
    }

    CompactHashSet() {
        init(3);
    }

    CompactHashSet(int i) {
        init(i);
    }

    private Set a(int i) {
        return new LinkedHashSet(i, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object b(int i) {
        return f()[i];
    }

    private int c(int i) {
        return g()[i];
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i) {
        return new CompactHashSet<>(i);
    }

    private int e() {
        return (1 << (this.c & 31)) - 1;
    }

    private Object[] f() {
        Object[] objArr = this.elements;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private int[] g() {
        int[] iArr = this.b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private Object i() {
        Object obj = this.a;
        Objects.requireNonNull(obj);
        return obj;
    }

    private void j(int i) {
        int min;
        int length = g().length;
        if (i <= length || (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(min);
    }

    private int l(int i, int i2, int i3, int i4) {
        Object a2 = g2.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            g2.i(a2, i3 & i5, i4 + 1);
        }
        Object i6 = i();
        int[] g = g();
        for (int i7 = 0; i7 <= i; i7++) {
            int h = g2.h(i6, i7);
            while (h != 0) {
                int i8 = h - 1;
                int i9 = g[i8];
                int b = g2.b(i9, i) | i7;
                int i10 = b & i5;
                int h2 = g2.h(a2, i10);
                g2.i(a2, i10, h);
                g[i8] = g2.d(b, h2, i5);
                h = g2.c(i9, i);
            }
        }
        this.a = a2;
        o(i5);
        return i5;
    }

    private void m(int i, Object obj) {
        f()[i] = obj;
    }

    private void n(int i, int i2) {
        g()[i] = i2;
    }

    private void o(int i) {
        this.c = g2.d(this.c, 32 - Integer.numberOfLeadingZeros(i), 31);
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
            add(objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.add(e);
        }
        int[] g = g();
        Object[] f = f();
        int i = this.d;
        int i2 = i + 1;
        int d = v2.d(e);
        int e2 = e();
        int i3 = d & e2;
        int h = g2.h(i(), i3);
        if (h != 0) {
            int b = g2.b(d, e2);
            int i4 = 0;
            while (true) {
                int i5 = h - 1;
                int i6 = g[i5];
                if (g2.b(i6, e2) == b && com.google.common.base.j.a(e, f[i5])) {
                    return false;
                }
                int c = g2.c(i6, e2);
                i4++;
                if (c != 0) {
                    h = c;
                } else {
                    if (i4 >= 9) {
                        return convertToHashFloodingResistantImplementation().add(e);
                    }
                    if (i2 > e2) {
                        e2 = l(e2, g2.e(e2), d, i);
                    } else {
                        g[i5] = g2.d(i6, i2, e2);
                    }
                }
            }
        } else if (i2 > e2) {
            e2 = l(e2, g2.e(e2), d, i);
        } else {
            g2.i(i(), i3, i2);
        }
        j(i2);
        insertEntry(i, e, d, e2);
        this.d = i2;
        incrementModCount();
        return true;
    }

    int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    int allocArrays() {
        com.google.common.base.m.v(needsAllocArrays(), "Arrays already allocated");
        int i = this.c;
        int j = g2.j(i);
        this.a = g2.a(j);
        o(j - 1);
        this.b = new int[i];
        this.elements = new Object[i];
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.c = Ints.f(size(), 3, 1073741823);
            delegateOrNull.clear();
            this.a = null;
            this.d = 0;
            return;
        }
        Arrays.fill(f(), 0, this.d, (Object) null);
        g2.g(i());
        Arrays.fill(g(), 0, this.d, 0);
        this.d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.contains(obj);
        }
        int d = v2.d(obj);
        int e = e();
        int h = g2.h(i(), d & e);
        if (h == 0) {
            return false;
        }
        int b = g2.b(d, e);
        do {
            int i = h - 1;
            int c = c(i);
            if (g2.b(c, e) == b && com.google.common.base.j.a(obj, b(i))) {
                return true;
            }
            h = g2.c(c, e);
        } while (h != 0);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    Set<E> convertToHashFloodingResistantImplementation() {
        AbstractMapBasedMultimap.m mVar = (Set<E>) a(e() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            mVar.add(b(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.a = mVar;
        this.b = null;
        this.elements = null;
        incrementModCount();
        return mVar;
    }

    Set<E> delegateOrNull() {
        Object obj = this.a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.d) {
            return i2;
        }
        return -1;
    }

    void incrementModCount() {
        this.c += 32;
    }

    void init(int i) {
        com.google.common.base.m.e(i >= 0, "Expected size must be >= 0");
        this.c = Ints.f(i, 1, 1073741823);
    }

    void insertEntry(int i, E e, int i2, int i3) {
        n(i, g2.d(i2, 0, i3));
        m(i, e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    boolean isUsingHashFloodingResistance() {
        return delegateOrNull() != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.iterator() : new a();
    }

    void moveLastEntry(int i, int i2) {
        Object i3 = i();
        int[] g = g();
        Object[] f = f();
        int size = size();
        int i4 = size - 1;
        if (i >= i4) {
            f[i] = null;
            g[i] = 0;
            return;
        }
        Object obj = f[i4];
        f[i] = obj;
        f[i4] = null;
        g[i] = g[i4];
        g[i4] = 0;
        int d = v2.d(obj) & i2;
        int h = g2.h(i3, d);
        if (h == size) {
            g2.i(i3, d, i + 1);
            return;
        }
        while (true) {
            int i5 = h - 1;
            int i6 = g[i5];
            int c = g2.c(i6, i2);
            if (c == size) {
                g[i5] = g2.d(i6, i + 1, i2);
                return;
            }
            h = c;
        }
    }

    boolean needsAllocArrays() {
        return this.a == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        int e = e();
        int f = g2.f(obj, null, e, i(), g(), f(), null);
        if (f == -1) {
            return false;
        }
        moveLastEntry(f, e);
        this.d--;
        incrementModCount();
        return true;
    }

    void resizeEntries(int i) {
        this.b = Arrays.copyOf(g(), i);
        this.elements = Arrays.copyOf(f(), i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.toArray() : Arrays.copyOf(f(), this.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (!needsAllocArrays()) {
            Set<E> delegateOrNull = delegateOrNull();
            return delegateOrNull != null ? (T[]) delegateOrNull.toArray(tArr) : (T[]) n3.h(f(), 0, this.d, tArr);
        }
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            Set a2 = a(size());
            a2.addAll(delegateOrNull);
            this.a = a2;
            return;
        }
        int i = this.d;
        if (i < g().length) {
            resizeEntries(i);
        }
        int j = g2.j(i);
        int e = e();
        if (j < e) {
            l(e, j, 0, 0);
        }
    }
}
