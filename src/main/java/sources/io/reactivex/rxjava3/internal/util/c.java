package io.reactivex.rxjava3.internal.util;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.exceptions.ProtocolViolationException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class c {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class cls) {
        dy.a.r(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference atomicReference, i00.d dVar, Class cls) {
        Objects.requireNonNull(dVar, "next is null");
        if (j0.a(atomicReference, (Object) null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() == SubscriptionHelper.CANCELLED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean d(AtomicReference atomicReference, io.reactivex.rxjava3.disposables.c cVar, Class cls) {
        Objects.requireNonNull(cVar, "next is null");
        if (j0.a(atomicReference, (Object) null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }
}
