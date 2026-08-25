package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.QueueOverflowException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class BlockingFlowableIterable$BlockingFlowableIterator<T> extends AtomicReference<i00.d> implements io.reactivex.rxjava3.core.f, Iterator<T>, Runnable, io.reactivex.rxjava3.disposables.c {
    private static final long serialVersionUID = 6695226475494099826L;
    final long batchSize;
    final Condition condition;
    volatile boolean done;
    volatile Throwable error;
    final long limit;
    final Lock lock;
    long produced;
    final SpscArrayQueue<T> queue;

    BlockingFlowableIterable$BlockingFlowableIterator(int i) {
        this.queue = new SpscArrayQueue<>(i);
        this.batchSize = i;
        this.limit = i - (i >> 2);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        SubscriptionHelper.cancel(this);
        signalConsumer();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (!isDisposed()) {
            boolean z = this.done;
            boolean isEmpty = this.queue.isEmpty();
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    throw ExceptionHelper.g(th);
                }
                if (isEmpty) {
                    return false;
                }
            }
            if (!isEmpty) {
                return true;
            }
            io.reactivex.rxjava3.internal.util.b.a();
            this.lock.lock();
            while (!this.done && this.queue.isEmpty() && !isDisposed()) {
                try {
                    try {
                        this.condition.await();
                    } catch (InterruptedException e) {
                        run();
                        throw ExceptionHelper.g(e);
                    }
                } finally {
                    this.lock.unlock();
                }
            }
        }
        Throwable th2 = this.error;
        if (th2 == null) {
            return false;
        }
        throw ExceptionHelper.g(th2);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T poll = this.queue.poll();
        long j = this.produced + 1;
        if (j == this.limit) {
            this.produced = 0L;
            get().request(j);
        } else {
            this.produced = j;
        }
        return poll;
    }

    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        signalConsumer();
    }

    public void onNext(T t) {
        if (this.queue.offer(t)) {
            signalConsumer();
        } else {
            SubscriptionHelper.cancel(this);
            onError(new QueueOverflowException());
        }
    }

    public void onSubscribe(i00.d dVar) {
        SubscriptionHelper.setOnce(this, dVar, this.batchSize);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override // java.lang.Runnable
    public void run() {
        SubscriptionHelper.cancel(this);
        signalConsumer();
    }

    void signalConsumer() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }
}
