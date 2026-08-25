package androidx.compose.foundation;

import androidx.compose.animation.core.j0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MutatorMutex {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f1606a = new AtomicReference(null);

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.sync.a f1607b = kotlinx.coroutines.sync.g.b(false, 1, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final MutatePriority f1608a;

        /* renamed from: b, reason: collision with root package name */
        private final t1 f1609b;

        public a(MutatePriority mutatePriority, t1 t1Var) {
            this.f1608a = mutatePriority;
            this.f1609b = t1Var;
        }

        public final boolean a(a aVar) {
            return this.f1608a.compareTo(aVar.f1608a) >= 0;
        }

        public final void b() {
            this.f1609b.cancel(new MutationInterruptedException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(a aVar) {
        a aVar2;
        do {
            aVar2 = (a) this.f1606a.get();
            if (aVar2 != null && !aVar.a(aVar2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!j0.a(this.f1606a, aVar2, aVar));
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    public final Object d(Object obj, MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        return o0.e(new MutatorMutex$mutateWith$2(mutatePriority, this, function2, obj, null), continuation);
    }
}
