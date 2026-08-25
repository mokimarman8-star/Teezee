package ej;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements Queue {
    private final int a;
    private LinkedList b;

    public a(int i) {
        this.a = i;
        this.b = new LinkedList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Queue queue) {
        this(queue.size());
        Intrinsics.h(queue, "newQueue");
        this.b = new LinkedList(queue);
    }

    public int a() {
        return this.b.size();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(Object obj) {
        return this.b.add(obj);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        Intrinsics.h(collection, "elements");
        return this.b.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.b.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.b.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        Intrinsics.h(collection, "elements");
        return this.b.containsAll(collection);
    }

    @Override // java.util.Queue
    public Object element() {
        return this.b.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.b.size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        Iterator it = this.b.iterator();
        Intrinsics.g(it, "iterator(...)");
        return it;
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        if (this.b.size() >= this.a) {
            this.b.poll();
        }
        return this.b.offer(obj);
    }

    @Override // java.util.Queue
    public Object peek() {
        return this.b.peek();
    }

    @Override // java.util.Queue
    public Object poll() {
        return this.b.poll();
    }

    @Override // java.util.Queue
    public Object remove() {
        return this.b.remove();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        return this.b.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        Intrinsics.h(collection, "elements");
        return this.b.removeAll(CollectionsKt.W0(collection));
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        Intrinsics.h(collection, "elements");
        return this.b.retainAll(CollectionsKt.W0(collection));
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] array = this.b.toArray();
        Intrinsics.g(array, "toArray(...)");
        return array;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] array = this.b.toArray(objArr);
        Intrinsics.g(array, "toArray(...)");
        return array;
    }
}
