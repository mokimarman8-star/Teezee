package androidx.compose.ui;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class SessionMutex {

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final t1 f3082a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f3083b;

        public a(t1 t1Var, Object obj) {
            this.f3082a = t1Var;
            this.f3083b = obj;
        }

        public final t1 a() {
            return this.f3082a;
        }

        public final Object b() {
            return this.f3083b;
        }
    }

    public static AtomicReference a() {
        return b(new AtomicReference(null));
    }

    private static AtomicReference b(AtomicReference atomicReference) {
        return atomicReference;
    }

    public static final Object c(AtomicReference atomicReference) {
        a aVar = (a) atomicReference.get();
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public static final Object d(AtomicReference atomicReference, Function1 function1, Function2 function2, Continuation continuation) {
        return o0.e(new SessionMutex$withSessionCancellingPrevious$2(function1, atomicReference, function2, null), continuation);
    }
}
