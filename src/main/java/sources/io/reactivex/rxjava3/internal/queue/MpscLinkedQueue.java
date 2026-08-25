package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.operators.f;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class MpscLinkedQueue implements f {
    private final AtomicReference a = new AtomicReference();
    private final AtomicReference b = new AtomicReference();

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E e) {
            spValue(e);
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue(null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e) {
            this.value = e;
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        d(linkedQueueNode);
        e(linkedQueueNode);
    }

    LinkedQueueNode a() {
        return (LinkedQueueNode) this.b.get();
    }

    LinkedQueueNode b() {
        return (LinkedQueueNode) this.b.get();
    }

    LinkedQueueNode c() {
        return (LinkedQueueNode) this.a.get();
    }

    @Override // io.reactivex.rxjava3.operators.g
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    void d(LinkedQueueNode linkedQueueNode) {
        this.b.lazySet(linkedQueueNode);
    }

    LinkedQueueNode e(LinkedQueueNode linkedQueueNode) {
        return (LinkedQueueNode) this.a.getAndSet(linkedQueueNode);
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode(obj);
        e(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.f, io.reactivex.rxjava3.operators.g
    public Object poll() {
        LinkedQueueNode lvNext;
        LinkedQueueNode a = a();
        LinkedQueueNode lvNext2 = a.lvNext();
        if (lvNext2 != null) {
            Object andNullValue = lvNext2.getAndNullValue();
            d(lvNext2);
            return andNullValue;
        }
        if (a == c()) {
            return null;
        }
        do {
            lvNext = a.lvNext();
        } while (lvNext == null);
        Object andNullValue2 = lvNext.getAndNullValue();
        d(lvNext);
        return andNullValue2;
    }
}
