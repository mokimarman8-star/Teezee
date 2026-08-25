package com.transsion.transfer.androidasync.future;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class n implements com.transsion.transfer.androidasync.future.b {
    boolean cancelled;
    boolean complete;
    private com.transsion.transfer.androidasync.future.a parent;
    public static final com.transsion.transfer.androidasync.future.a COMPLETED = new a();
    public static final com.transsion.transfer.androidasync.future.a CANCELLED = new b();

    class a extends n {
        a() {
            setComplete();
        }
    }

    class b extends n {
        b() {
            cancel();
        }
    }

    @Override // com.transsion.transfer.androidasync.future.a
    public boolean cancel() {
        synchronized (this) {
            try {
                if (this.complete) {
                    return false;
                }
                if (this.cancelled) {
                    return true;
                }
                this.cancelled = true;
                com.transsion.transfer.androidasync.future.a aVar = this.parent;
                this.parent = null;
                if (aVar != null) {
                    aVar.cancel();
                }
                cancelCleanup();
                cleanup();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void cancelCleanup() {
    }

    protected void cleanup() {
    }

    protected void completeCleanup() {
    }

    @Override // com.transsion.transfer.androidasync.future.a
    public boolean isCancelled() {
        boolean z;
        com.transsion.transfer.androidasync.future.a aVar;
        synchronized (this) {
            try {
                z = this.cancelled || ((aVar = this.parent) != null && aVar.isCancelled());
            } finally {
            }
        }
        return z;
    }

    public boolean isDone() {
        return this.complete;
    }

    public com.transsion.transfer.androidasync.future.a reset() {
        cancel();
        this.complete = false;
        this.cancelled = false;
        return this;
    }

    public boolean setComplete() {
        synchronized (this) {
            try {
                if (this.cancelled) {
                    return false;
                }
                if (this.complete) {
                    return false;
                }
                this.complete = true;
                this.parent = null;
                completeCleanup();
                cleanup();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.transsion.transfer.androidasync.future.b
    public boolean setParent(com.transsion.transfer.androidasync.future.a aVar) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.parent = aVar;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
