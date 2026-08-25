package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private transient int[] e;
    private transient int[] f;
    private transient int g;
    private transient int h;

    CompactLinkedHashSet() {
    }

    CompactLinkedHashSet(int i) {
        super(i);
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    @SafeVarargs
    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i) {
        return new CompactLinkedHashSet<>(i);
    }

    private int p(int i) {
        return q()[i] - 1;
    }

    private int[] q() {
        int[] iArr = this.e;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private int[] r() {
        int[] iArr = this.f;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private void s(int i, int i2) {
        q()[i] = i2 + 1;
    }

    private void t(int i, int i2) {
        if (i == -2) {
            this.g = i2;
        } else {
            u(i, i2);
        }
        if (i2 == -2) {
            this.h = i;
        } else {
            s(i2, i);
        }
    }

    private void u(int i, int i2) {
        r()[i] = i2 + 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    int adjustAfterRemove(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    @Override // com.google.common.collect.CompactHashSet
    int allocArrays() {
        int allocArrays = super.allocArrays();
        this.e = new int[allocArrays];
        this.f = new int[allocArrays];
        return allocArrays;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.g = -2;
        this.h = -2;
        int[] iArr = this.e;
        if (iArr != null && this.f != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.f, 0, size(), 0);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashSet
    Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> convertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.e = null;
        this.f = null;
        return convertToHashFloodingResistantImplementation;
    }

    @Override // com.google.common.collect.CompactHashSet
    int firstEntryIndex() {
        return this.g;
    }

    @Override // com.google.common.collect.CompactHashSet
    int getSuccessor(int i) {
        return r()[i] - 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    void init(int i) {
        super.init(i);
        this.g = -2;
        this.h = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    void insertEntry(int i, E e, int i2, int i3) {
        super.insertEntry(i, e, i2, i3);
        t(this.h, i);
        t(i, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    void moveLastEntry(int i, int i2) {
        int size = size() - 1;
        super.moveLastEntry(i, i2);
        t(p(i), getSuccessor(i));
        if (i < size) {
            t(p(size), i);
            t(i, getSuccessor(size));
        }
        q()[size] = 0;
        r()[size] = 0;
    }

    @Override // com.google.common.collect.CompactHashSet
    void resizeEntries(int i) {
        super.resizeEntries(i);
        this.e = Arrays.copyOf(q(), i);
        this.f = Arrays.copyOf(r(), i);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return n3.f(this);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) n3.g(this, tArr);
    }
}
