package io.reactivex.rxjava3.internal.operators.observable;

import dy.a;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.m;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import io.reactivex.rxjava3.operators.b;
import io.reactivex.rxjava3.operators.g;
import io.reactivex.rxjava3.operators.h;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ObservableObserveOn extends a {
    final Scheduler b;
    final boolean c;
    final int d;

    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements o, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final o downstream;
        Throwable error;
        boolean outputFused;
        g queue;
        int sourceMode;
        c upstream;
        final Scheduler.Worker worker;

        ObserveOnObserver(o oVar, Scheduler.Worker worker, boolean z, int i) {
            this.downstream = oVar;
            this.worker = worker;
            this.delayError = z;
            this.bufferSize = i;
        }

        boolean checkTerminated(boolean z, boolean z2, o oVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                this.disposed = true;
                if (th != null) {
                    oVar.onError(th);
                } else {
                    oVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th != null) {
                this.disposed = true;
                this.queue.clear();
                oVar.onError(th);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.disposed = true;
            oVar.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        void drainFused() {
            int i = 1;
            while (!this.disposed) {
                boolean z = this.done;
                Throwable th = this.error;
                if (!this.delayError && z && th != null) {
                    this.disposed = true;
                    this.downstream.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                this.downstream.onNext((Object) null);
                if (z) {
                    this.disposed = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void drainNormal() {
            /*
                r7 = this;
                io.reactivex.rxjava3.operators.g r0 = r7.queue
                io.reactivex.rxjava3.core.o r1 = r7.downstream
                r2 = 1
                r3 = r2
            L6:
                boolean r4 = r7.done
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.checkTerminated(r4, r5, r1)
                if (r4 == 0) goto L13
                return
            L13:
                boolean r4 = r7.done
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L1d
                r6 = r2
                goto L1e
            L1d:
                r6 = 0
            L1e:
                boolean r4 = r7.checkTerminated(r4, r6, r1)
                if (r4 == 0) goto L25
                return
            L25:
                if (r6 == 0) goto L2f
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L6
                return
            L2f:
                r1.onNext(r5)
                goto L13
            L33:
                r3 = move-exception
                io.reactivex.rxjava3.exceptions.a.b(r3)
                r7.disposed = r2
                io.reactivex.rxjava3.disposables.c r2 = r7.upstream
                r2.dispose()
                r0.clear()
                r1.onError(r3)
                io.reactivex.rxjava3.core.Scheduler$Worker r0 = r7.worker
                r0.dispose()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableObserveOn.ObserveOnObserver.drainNormal():void");
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        public void onError(Throwable th) {
            if (this.done) {
                a.r(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            schedule();
        }

        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof b) {
                    b bVar = (b) cVar;
                    int requestFusion = bVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        schedule();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new h(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable
        public T poll() throws Throwable {
            return (T) this.queue.poll();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    public ObservableObserveOn(m mVar, Scheduler scheduler, boolean z, int i) {
        super(mVar);
        this.b = scheduler;
        this.c = z;
        this.d = i;
    }

    protected void D(o oVar) {
        Scheduler scheduler = this.b;
        if (scheduler instanceof TrampolineScheduler) {
            ((a) this).a.subscribe(oVar);
        } else {
            ((a) this).a.subscribe(new ObserveOnObserver(oVar, scheduler.c(), this.c, this.d));
        }
    }
}
