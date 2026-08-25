package com.cloud.tmc.kernel.datastructure.immutable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class ImmutableList<E> extends ImmutableCollection<E> implements Immutable<List<E>> {
    private List<E> immutableList;

    public ImmutableList(E e) {
        ArrayList arrayList = new ArrayList();
        this.immutableList = arrayList;
        arrayList.add(e);
        this.immutableCollection = this.immutableList;
    }

    public ImmutableList(List<E> list) {
        super(list);
        this.immutableList = list;
    }

    @Override // com.cloud.tmc.kernel.datastructure.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.cloud.tmc.kernel.datastructure.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
        return super.containsAll(collection);
    }

    public E get(int i) {
        List<E> list = this.immutableList;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public int indexOf(E e) {
        List<E> list = this.immutableList;
        if (list != null) {
            return list.indexOf(e);
        }
        return -1;
    }

    @Override // com.cloud.tmc.kernel.datastructure.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.cloud.tmc.kernel.datastructure.immutable.ImmutableCollection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public int lastIndexOf(Object obj) {
        List<E> list = this.immutableList;
        if (list != null) {
            return list.lastIndexOf(obj);
        }
        return -1;
    }

    @Override // com.cloud.tmc.kernel.datastructure.immutable.Immutable
    public List<E> mutable() {
        return new ArrayList(this.immutableList);
    }

    @Override // com.cloud.tmc.kernel.datastructure.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.cloud.tmc.kernel.datastructure.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ Object[] toArray() {
        return super.toArray();
    }

    public String toString() {
        return this.immutableList.toString();
    }
}
