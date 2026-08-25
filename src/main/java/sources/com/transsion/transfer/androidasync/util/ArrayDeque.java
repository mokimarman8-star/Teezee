package com.transsion.transfer.androidasync.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ArrayDeque<E> extends AbstractCollection<E> implements Queue, Cloneable, Serializable {
    private static final int MIN_INITIAL_CAPACITY = 8;
    private static final long serialVersionUID = 2340985798034038923L;
    private transient Object[] elements;
    private transient int head;
    private transient int tail;

    private class a implements Iterator {
        private int a;
        private int b;
        private int c;

        private a() {
            this.a = ArrayDeque.this.head;
            this.b = ArrayDeque.this.tail;
            this.c = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a != this.b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.a == this.b) {
                throw new NoSuchElementException();
            }
            Object obj = ArrayDeque.this.elements[this.a];
            if (ArrayDeque.this.tail != this.b || obj == null) {
                throw new ConcurrentModificationException();
            }
            int i = this.a;
            this.c = i;
            this.a = (i + 1) & (ArrayDeque.this.elements.length - 1);
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.c;
            if (i < 0) {
                throw new IllegalStateException();
            }
            if (ArrayDeque.this.delete(i)) {
                this.a = (this.a - 1) & (ArrayDeque.this.elements.length - 1);
                this.b = ArrayDeque.this.tail;
            }
            this.c = -1;
        }
    }

    private class b implements Iterator {
        private int a;
        private int b;
        private int c;

        private b() {
            this.a = ArrayDeque.this.tail;
            this.b = ArrayDeque.this.head;
            this.c = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a != this.b;
        }

        @Override // java.util.Iterator
        public Object next() {
            int i = this.a;
            if (i == this.b) {
                throw new NoSuchElementException();
            }
            this.a = (i - 1) & (ArrayDeque.this.elements.length - 1);
            Object obj = ArrayDeque.this.elements[this.a];
            if (ArrayDeque.this.head != this.b || obj == null) {
                throw new ConcurrentModificationException();
            }
            this.c = this.a;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.c;
            if (i < 0) {
                throw new IllegalStateException();
            }
            if (!ArrayDeque.this.delete(i)) {
                this.a = (this.a + 1) & (ArrayDeque.this.elements.length - 1);
                this.b = ArrayDeque.this.head;
            }
            this.c = -1;
        }
    }

    public ArrayDeque() {
        this.elements = new Object[16];
    }

    public ArrayDeque(int i) {
        allocateElements(i);
    }

    public ArrayDeque(Collection<? extends E> collection) {
        allocateElements(collection.size());
        addAll(collection);
    }

    private void allocateElements(int i) {
        int i2 = 8;
        if (i >= 8) {
            int i3 = i | (i >>> 1);
            int i4 = i3 | (i3 >>> 2);
            int i5 = i4 | (i4 >>> 4);
            int i6 = i5 | (i5 >>> 8);
            i2 = (i6 | (i6 >>> 16)) + 1;
            if (i2 < 0) {
                i2 >>>= 1;
            }
        }
        this.elements = new Object[i2];
    }

    private void checkInvariants() {
    }

    private <T> T[] copyElements(T[] tArr) {
        int i = this.head;
        int i2 = this.tail;
        if (i < i2) {
            System.arraycopy(this.elements, i, tArr, 0, size());
        } else if (i > i2) {
            Object[] objArr = this.elements;
            int length = objArr.length - i;
            System.arraycopy(objArr, i, tArr, 0, length);
            System.arraycopy(this.elements, 0, tArr, length, this.tail);
        }
        return tArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean delete(int i) {
        checkInvariants();
        Object[] objArr = this.elements;
        int length = objArr.length - 1;
        int i2 = this.head;
        int i3 = this.tail;
        int i4 = (i - i2) & length;
        int i5 = (i3 - i) & length;
        if (i4 >= ((i3 - i2) & length)) {
            throw new ConcurrentModificationException();
        }
        if (i4 < i5) {
            if (i2 <= i) {
                System.arraycopy(objArr, i2, objArr, i2 + 1, i4);
            } else {
                System.arraycopy(objArr, 0, objArr, 1, i);
                objArr[0] = objArr[length];
                System.arraycopy(objArr, i2, objArr, i2 + 1, length - i2);
            }
            objArr[i2] = null;
            this.head = (i2 + 1) & length;
            return false;
        }
        if (i < i3) {
            System.arraycopy(objArr, i + 1, objArr, i, i5);
            this.tail = i3 - 1;
        } else {
            System.arraycopy(objArr, i + 1, objArr, i, length - i);
            objArr[length] = objArr[0];
            System.arraycopy(objArr, 1, objArr, 0, i3);
            this.tail = (i3 - 1) & length;
        }
        return true;
    }

    private void doubleCapacity() {
        int i = this.head;
        Object[] objArr = this.elements;
        int length = objArr.length;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, i, objArr2, 0, i2);
        System.arraycopy(this.elements, 0, objArr2, i2, i);
        this.elements = objArr2;
        this.head = 0;
        this.tail = length;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        allocateElements(readInt);
        this.head = 0;
        this.tail = readInt;
        for (int i = 0; i < readInt; i++) {
            this.elements[i] = objectInputStream.readObject();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        int length = this.elements.length - 1;
        for (int i = this.head; i != this.tail; i = (i + 1) & length) {
            objectOutputStream.writeObject(this.elements[i]);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void addFirst(E e) {
        if (e == null) {
            throw new NullPointerException("e == null");
        }
        Object[] objArr = this.elements;
        int length = (this.head - 1) & (objArr.length - 1);
        this.head = length;
        objArr[length] = e;
        if (length == this.tail) {
            doubleCapacity();
        }
    }

    public void addLast(E e) {
        if (e == null) {
            throw new NullPointerException("e == null");
        }
        Object[] objArr = this.elements;
        int i = this.tail;
        objArr[i] = e;
        int length = (objArr.length - 1) & (i + 1);
        this.tail = length;
        if (length == this.head) {
            doubleCapacity();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int i = this.head;
        int i2 = this.tail;
        if (i != i2) {
            this.tail = 0;
            this.head = 0;
            int length = this.elements.length - 1;
            do {
                this.elements[i] = null;
                i = (i + 1) & length;
            } while (i != i2);
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ArrayDeque<E> m1clone() {
        try {
            ArrayDeque<E> arrayDeque = (ArrayDeque) super.clone();
            Object[] objArr = this.elements;
            System.arraycopy(objArr, 0, arrayDeque.elements, 0, objArr.length);
            return arrayDeque;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.elements.length - 1;
        int i = this.head;
        while (true) {
            Object obj2 = this.elements[i];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                return true;
            }
            i = (i + 1) & length;
        }
    }

    public Iterator<E> descendingIterator() {
        return new b();
    }

    @Override // java.util.Queue
    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E e = (E) this.elements[this.head];
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E e = (E) this.elements[(this.tail - 1) & (r0.length - 1)];
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new a();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        return offerLast(e);
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        return (E) this.elements[this.head];
    }

    public E peekLast() {
        return (E) this.elements[(this.tail - 1) & (r0.length - 1)];
    }

    @Override // java.util.Queue
    public E poll() {
        return pollFirst();
    }

    public E pollFirst() {
        int i = this.head;
        Object[] objArr = this.elements;
        E e = (E) objArr[i];
        if (e == null) {
            return null;
        }
        objArr[i] = null;
        this.head = (i + 1) & (objArr.length - 1);
        return e;
    }

    public E pollLast() {
        int i = this.tail - 1;
        Object[] objArr = this.elements;
        int length = i & (objArr.length - 1);
        E e = (E) objArr[length];
        if (e == null) {
            return null;
        }
        objArr[length] = null;
        this.tail = length;
        return e;
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e) {
        addFirst(e);
    }

    @Override // java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.elements.length - 1;
        int i = this.head;
        while (true) {
            Object obj2 = this.elements[i];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                delete(i);
                return true;
            }
            i = (i + 1) & length;
        }
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.elements.length - 1;
        int i = this.tail - 1;
        while (true) {
            int i2 = i & length;
            Object obj2 = this.elements[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                delete(i2);
                return true;
            }
            i = i2 - 1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return (this.tail - this.head) & (this.elements.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return copyElements(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        copyElements(tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }
}
