package com.google.common.util.concurrent;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class ClosingFuture {
    private static final q a = new q(ClosingFuture.class);

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$10, reason: invalid class name */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ ClosingFuture this$0;
        final /* synthetic */ b val$consumer;

        AnonymousClass10(ClosingFuture closingFuture, b bVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture.d(null, null);
        }
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$9, reason: invalid class name */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ ClosingFuture this$0;

        AnonymousClass9(ClosingFuture closingFuture) {
        }

        @Override // java.lang.Runnable
        public void run() {
            State state = State.WILL_CLOSE;
            State state2 = State.CLOSING;
            ClosingFuture.b(null, state, state2);
            ClosingFuture.a(null);
            ClosingFuture.b(null, state2, State.CLOSED);
        }
    }

    enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    public static final class a {
        a(ClosingFuture closingFuture) {
            android.support.v4.media.session.c.a(com.google.common.base.m.o(closingFuture));
        }
    }

    public interface b {
        void a(a aVar);
    }

    static /* synthetic */ void a(ClosingFuture closingFuture) {
        throw null;
    }

    static /* synthetic */ void b(ClosingFuture closingFuture, State state, State state2) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(b bVar, ClosingFuture closingFuture) {
        bVar.a(new a(closingFuture));
    }
}
