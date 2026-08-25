package com.google.common.util.concurrent;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class AbstractFuture$c {
    static final AbstractFuture$c c;
    static final AbstractFuture$c d;
    final boolean a;
    final Throwable b;

    static {
        if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
            d = null;
            c = null;
        } else {
            d = new AbstractFuture$c(false, null);
            c = new AbstractFuture$c(true, null);
        }
    }

    AbstractFuture$c(boolean z, Throwable th) {
        this.a = z;
        this.b = th;
    }
}
