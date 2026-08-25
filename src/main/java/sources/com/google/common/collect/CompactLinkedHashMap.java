package com.google.common.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private final boolean accessOrder;
    private transient int h;
    private transient int i;
    transient long[] links;

    CompactLinkedHashMap() {
        this(3);
    }

    CompactLinkedHashMap(int i) {
        this(i, false);
    }

    CompactLinkedHashMap(int i, boolean z) {
        super(i);
        this.accessOrder = z;
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactLinkedHashMap<>(i);
    }

    private int s(int i) {
        return ((int) (t(i) >>> 32)) - 1;
    }

    private long t(int i) {
        return u()[i];
    }

    private long[] u() {
        long[] jArr = this.links;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    private void v(int i, long j) {
        u()[i] = j;
    }

    private void w(int i, int i2) {
        v(i, (t(i) & 4294967295L) | ((i2 + 1) << 32));
    }

    private void x(int i, int i2) {
        if (i == -2) {
            this.h = i2;
        } else {
            y(i, i2);
        }
        if (i2 == -2) {
            this.i = i;
        } else {
            w(i2, i);
        }
    }

    private void y(int i, int i2) {
        v(i, (t(i) & (-4294967296L)) | ((i2 + 1) & 4294967295L));
    }

    @Override // com.google.common.collect.CompactHashMap
    void accessEntry(int i) {
        if (this.accessOrder) {
            x(s(i), getSuccessor(i));
            x(this.i, i);
            x(i, -2);
            incrementModCount();
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    int adjustAfterRemove(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    @Override // com.google.common.collect.CompactHashMap
    int allocArrays() {
        int allocArrays = super.allocArrays();
        this.links = new long[allocArrays];
        return allocArrays;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.h = -2;
        this.i = -2;
        long[] jArr = this.links;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> convertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return convertToHashFloodingResistantImplementation;
    }

    @Override // com.google.common.collect.CompactHashMap
    Map<K, V> createHashFloodingResistantDelegate(int i) {
        return new LinkedHashMap(i, 1.0f, this.accessOrder);
    }

    @Override // com.google.common.collect.CompactHashMap
    int firstEntryIndex() {
        return this.h;
    }

    @Override // com.google.common.collect.CompactHashMap
    int getSuccessor(int i) {
        return ((int) t(i)) - 1;
    }

    @Override // com.google.common.collect.CompactHashMap
    void init(int i) {
        super.init(i);
        this.h = -2;
        this.i = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    void insertEntry(int i, K k, V v, int i2, int i3) {
        super.insertEntry(i, k, v, i2, i3);
        x(this.i, i);
        x(i, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    void moveLastEntry(int i, int i2) {
        int size = size() - 1;
        super.moveLastEntry(i, i2);
        x(s(i), getSuccessor(i));
        if (i < size) {
            x(s(size), i);
            x(i, getSuccessor(size));
        }
        v(size, 0L);
    }

    @Override // com.google.common.collect.CompactHashMap
    void resizeEntries(int i) {
        super.resizeEntries(i);
        this.links = Arrays.copyOf(u(), i);
    }
}
