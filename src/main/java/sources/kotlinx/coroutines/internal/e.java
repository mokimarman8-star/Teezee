package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class e {
    private static final Collection a = SequencesKt.C(SequencesKt.e(ServiceLoader.load(kotlinx.coroutines.j0.class, kotlinx.coroutines.j0.class.getClassLoader()).iterator()));

    public static final Collection a() {
        return a;
    }

    public static final void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
