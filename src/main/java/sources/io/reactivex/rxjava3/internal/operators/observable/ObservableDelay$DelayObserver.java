package io.reactivex.rxjava3.internal.operators.observable;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class ObservableDelay$DelayObserver implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {

    final class OnComplete implements Runnable {
        final /* synthetic */ ObservableDelay$DelayObserver this$0;

        OnComplete(ObservableDelay$DelayObserver observableDelay$DelayObserver) {
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
        final /* synthetic */ ObservableDelay$DelayObserver this$0;
        private final Throwable throwable;

        OnError(ObservableDelay$DelayObserver observableDelay$DelayObserver, Throwable th) {
            this.throwable = th;
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
        final /* synthetic */ ObservableDelay$DelayObserver this$0;

        OnNext(ObservableDelay$DelayObserver observableDelay$DelayObserver, Object obj) {
            this.t = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
