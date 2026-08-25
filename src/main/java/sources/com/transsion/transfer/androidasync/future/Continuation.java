package com.transsion.transfer.androidasync.future;

import java.util.LinkedList;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Continuation extends n implements st.c, Runnable, com.transsion.transfer.androidasync.future.a {
    st.a callback;
    Runnable cancelCallback;
    private boolean inNext;
    LinkedList<st.c> mCallbacks;
    boolean started;
    private boolean waiting;

    class a implements st.a {
        boolean a;

        a() {
        }

        @Override // st.a
        public void g(Exception exc) {
            if (this.a) {
                return;
            }
            this.a = true;
            Continuation.this.waiting = false;
            if (exc == null) {
                Continuation.this.next();
            } else {
                Continuation.this.reportCompleted(exc);
            }
        }
    }

    class b implements st.c {
        final /* synthetic */ c a;

        b(c cVar) {
            this.a = cVar;
        }

        @Override // st.c
        public void onContinue(Continuation continuation, st.a aVar) {
            this.a.get();
            aVar.g(null);
        }
    }

    public Continuation() {
        this(null);
    }

    public Continuation(st.a aVar) {
        this(aVar, null);
    }

    public Continuation(st.a aVar, Runnable runnable) {
        this.mCallbacks = new LinkedList<>();
        this.cancelCallback = runnable;
        this.callback = aVar;
    }

    private st.c hook(st.c cVar) {
        if (cVar instanceof com.transsion.transfer.androidasync.future.b) {
            ((com.transsion.transfer.androidasync.future.b) cVar).setParent(this);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (this.inNext) {
            return;
        }
        while (this.mCallbacks.size() > 0 && !this.waiting && !isDone() && !isCancelled()) {
            st.c remove = this.mCallbacks.remove();
            try {
                try {
                    this.inNext = true;
                    this.waiting = true;
                    remove.onContinue(this, wrap());
                } catch (Exception e) {
                    reportCompleted(e);
                }
            } finally {
                this.inNext = false;
            }
        }
        if (this.waiting || isDone() || isCancelled()) {
            return;
        }
        reportCompleted(null);
    }

    private st.a wrap() {
        return new a();
    }

    public Continuation add(c cVar) {
        cVar.setParent(this);
        add(new b(cVar));
        return this;
    }

    public Continuation add(st.c cVar) {
        this.mCallbacks.add(hook(cVar));
        return this;
    }

    @Override // com.transsion.transfer.androidasync.future.n, com.transsion.transfer.androidasync.future.a
    public boolean cancel() {
        if (!super.cancel()) {
            return false;
        }
        Runnable runnable = this.cancelCallback;
        if (runnable == null) {
            return true;
        }
        runnable.run();
        return true;
    }

    public st.a getCallback() {
        return this.callback;
    }

    public Runnable getCancelCallback() {
        return this.cancelCallback;
    }

    public Continuation insert(st.c cVar) {
        this.mCallbacks.add(0, hook(cVar));
        return this;
    }

    @Override // st.c
    public void onContinue(Continuation continuation, st.a aVar) throws Exception {
        setCallback(aVar);
        start();
    }

    void reportCompleted(Exception exc) {
        st.a aVar;
        if (setComplete() && (aVar = this.callback) != null) {
            aVar.g(exc);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        start();
    }

    public void setCallback(st.a aVar) {
        this.callback = aVar;
    }

    public void setCancelCallback(final com.transsion.transfer.androidasync.future.a aVar) {
        if (aVar == null) {
            this.cancelCallback = null;
        } else {
            this.cancelCallback = new Runnable() { // from class: com.transsion.transfer.androidasync.future.Continuation.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.cancel();
                }
            };
        }
    }

    public void setCancelCallback(Runnable runnable) {
        this.cancelCallback = runnable;
    }

    public Continuation start() {
        if (this.started) {
            throw new IllegalStateException("already started");
        }
        this.started = true;
        next();
        return this;
    }
}
