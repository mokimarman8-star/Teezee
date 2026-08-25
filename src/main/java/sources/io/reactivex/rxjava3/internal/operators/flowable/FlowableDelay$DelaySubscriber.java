package io.reactivex.rxjava3.internal.operators.flowable;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class FlowableDelay$DelaySubscriber implements io.reactivex.rxjava3.core.f, i00.d {

    final class OnComplete implements Runnable {
        final /* synthetic */ FlowableDelay$DelaySubscriber this$0;

        OnComplete(FlowableDelay$DelaySubscriber flowableDelay$DelaySubscriber) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            throw null;
        }
    }

    final class OnError implements Runnable {
        private final Throwable t;
        final /* synthetic */ FlowableDelay$DelaySubscriber this$0;

        OnError(FlowableDelay$DelaySubscriber flowableDelay$DelaySubscriber, Throwable th) {
            this.t = th;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            throw null;
        }
    }

    final class OnNext implements Runnable {
        private final Object t;
        final /* synthetic */ FlowableDelay$DelaySubscriber this$0;

        OnNext(FlowableDelay$DelaySubscriber flowableDelay$DelaySubscriber, Object obj) {
            this.t = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
