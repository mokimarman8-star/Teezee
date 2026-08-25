package com.amazonaws.internal;

import com.amazonaws.async.Callback;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class ReturningRunnable<R> {
    private final String a = null;

    /* renamed from: com.amazonaws.internal.ReturningRunnable$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Callback val$callback;

        AnonymousClass1(Callback callback) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ReturningRunnable.this.b();
                throw null;
            } catch (Exception e) {
                ReturningRunnable.this.a.getClass();
                new Exception(ReturningRunnable.this.a, e);
                throw null;
            }
        }
    }

    public abstract Object b();
}
