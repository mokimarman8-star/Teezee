package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MutatorMutex {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f1383a = new AtomicReference(null);

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.sync.a f1384b = kotlinx.coroutines.sync.g.b(false, 1, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final MutatePriority f1385a;

        /* renamed from: b, reason: collision with root package name */
        private final t1 f1386b;

        public a(MutatePriority mutatePriority, t1 t1Var) {
            this.f1385a = mutatePriority;
            this.f1386b = t1Var;
        }

        public final boolean a(a aVar) {
            return this.f1385a.compareTo(aVar.f1385a) >= 0;
        }

        public final void b() {
            this.f1386b.cancel(new MutationInterruptedException());
        }
    }

    public static /* synthetic */ Object e(MutatorMutex mutatorMutex, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.d(mutatePriority, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(a aVar) {
        a aVar2;
        do {
            aVar2 = (a) this.f1383a.get();
            if (aVar2 != null && !aVar.a(aVar2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!j0.a(this.f1383a, aVar2, aVar));
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    public final Object d(MutatePriority mutatePriority, Function1 function1, Continuation continuation) {
        return kotlinx.coroutines.o0.e(new MutatorMutex$mutate$2(mutatePriority, this, function1, null), continuation);
    }
}
