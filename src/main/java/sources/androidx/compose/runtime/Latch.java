package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class Latch {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2610a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private List f2611b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List f2612c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private boolean f2613d = true;

    public final Object c(Continuation continuation) {
        if (e()) {
            return Unit.a;
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this.f2610a) {
            this.f2611b.add(cancellableContinuationImpl);
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Latch$await$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.a;
            }

            public final void invoke(Throwable th) {
                Object obj = Latch.this.f2610a;
                Latch latch = Latch.this;
                kotlinx.coroutines.n nVar = cancellableContinuationImpl;
                synchronized (obj) {
                    latch.f2611b.remove(nVar);
                    Unit unit = Unit.a;
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.a;
    }

    public final void d() {
        synchronized (this.f2610a) {
            this.f2613d = false;
            Unit unit = Unit.a;
        }
    }

    public final boolean e() {
        boolean z5;
        synchronized (this.f2610a) {
            z5 = this.f2613d;
        }
        return z5;
    }

    public final void f() {
        synchronized (this.f2610a) {
            try {
                if (e()) {
                    return;
                }
                List list = this.f2611b;
                this.f2611b = this.f2612c;
                this.f2612c = list;
                this.f2613d = true;
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Continuation continuation = (Continuation) list.get(i5);
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.constructor-impl(Unit.a));
                }
                list.clear();
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
