package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.q;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class SingleDelay$Delay implements q {

    final class OnError implements Runnable {
        private final Throwable e;
        final /* synthetic */ SingleDelay$Delay this$1;

        OnError(SingleDelay$Delay singleDelay$Delay, Throwable th) {
            this.e = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    final class OnSuccess implements Runnable {
        final /* synthetic */ SingleDelay$Delay this$1;
        private final Object value;

        OnSuccess(SingleDelay$Delay singleDelay$Delay, Object obj) {
            this.value = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
