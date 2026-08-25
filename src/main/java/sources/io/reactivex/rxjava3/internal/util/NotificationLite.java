package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.o;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public enum NotificationLite {
    COMPLETE;

    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final io.reactivex.rxjava3.disposables.c upstream;

        DisposableNotification(io.reactivex.rxjava3.disposables.c cVar) {
            this.upstream = cVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;

        ErrorNotification(Throwable th) {
            this.e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return Objects.equals(this.e, ((ErrorNotification) obj).e);
            }
            return false;
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.e + "]";
        }
    }

    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final i00.d upstream;

        SubscriptionNotification(i00.d dVar) {
            this.upstream = dVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    public static <T> boolean accept(Object obj, i00.c cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).e);
            return true;
        }
        cVar.onNext(obj);
        return false;
    }

    public static <T> boolean accept(Object obj, o oVar) {
        if (obj == COMPLETE) {
            oVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            oVar.onError(((ErrorNotification) obj).e);
            return true;
        }
        oVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, i00.c cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).e);
            return true;
        }
        if (obj instanceof SubscriptionNotification) {
            cVar.onSubscribe(((SubscriptionNotification) obj).upstream);
            return false;
        }
        cVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, o oVar) {
        if (obj == COMPLETE) {
            oVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            oVar.onError(((ErrorNotification) obj).e);
            return true;
        }
        if (obj instanceof DisposableNotification) {
            oVar.onSubscribe(((DisposableNotification) obj).upstream);
            return false;
        }
        oVar.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(io.reactivex.rxjava3.disposables.c cVar) {
        return new DisposableNotification(cVar);
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static io.reactivex.rxjava3.disposables.c getDisposable(Object obj) {
        return ((DisposableNotification) obj).upstream;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).e;
    }

    public static i00.d getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).upstream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(i00.d dVar) {
        return new SubscriptionNotification(dVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
