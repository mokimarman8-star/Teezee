package com.mbridge.msdk.dycreator.bus;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class PendingPostQueue {
    private PendingPost a;
    private PendingPost b;

    PendingPostQueue() {
    }

    synchronized PendingPost a() {
        PendingPost pendingPost;
        pendingPost = this.a;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.c;
            this.a = pendingPost2;
            if (pendingPost2 == null) {
                this.b = null;
            }
        }
        return pendingPost;
    }

    synchronized PendingPost a(int i) throws InterruptedException {
        try {
            if (this.a == null) {
                wait(i);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a();
    }

    synchronized void a(PendingPost pendingPost) {
        try {
            if (pendingPost == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            PendingPost pendingPost2 = this.b;
            if (pendingPost2 != null) {
                pendingPost2.c = pendingPost;
                this.b = pendingPost;
            } else {
                if (this.a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.b = pendingPost;
                this.a = pendingPost;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }
}
