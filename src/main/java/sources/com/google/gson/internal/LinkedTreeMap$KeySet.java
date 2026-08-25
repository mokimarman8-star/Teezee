package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [K] */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class LinkedTreeMap$KeySet<K> extends AbstractSet<K> {
    final /* synthetic */ LinkedTreeMap this$0;

    LinkedTreeMap$KeySet(LinkedTreeMap linkedTreeMap) {
        this.this$0 = linkedTreeMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.this$0.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.this$0.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<K> iterator() {
        return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: com.google.gson.internal.LinkedTreeMap$KeySet.1
            {
                LinkedTreeMap linkedTreeMap = LinkedTreeMap$KeySet.this.this$0;
            }

            public K next() {
                return (K) nextNode().key;
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.this$0.removeInternalByKey(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.this$0.size;
    }
}
