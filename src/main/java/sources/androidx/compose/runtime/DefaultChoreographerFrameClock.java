package androidx.compose.runtime;

import android.view.Choreographer;
import androidx.compose.runtime.u0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class DefaultChoreographerFrameClock implements u0 {

    /* renamed from: a, reason: collision with root package name */
    public static final DefaultChoreographerFrameClock f2595a = new DefaultChoreographerFrameClock();

    /* renamed from: b, reason: collision with root package name */
    private static final Choreographer f2596b = (Choreographer) kotlinx.coroutines.i.e(kotlinx.coroutines.y0.c().p(), new DefaultChoreographerFrameClock$choreographer$1(null));

    static final class a implements Choreographer.FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f2597a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f2598b;

        a(kotlinx.coroutines.n nVar, Function1 function1) {
            this.f2597a = nVar;
            this.f2598b = function1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j5) {
            Object obj;
            kotlinx.coroutines.n nVar = this.f2597a;
            DefaultChoreographerFrameClock defaultChoreographerFrameClock = DefaultChoreographerFrameClock.f2595a;
            Function1 function1 = this.f2598b;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(function1.invoke(Long.valueOf(j5)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th));
            }
            nVar.resumeWith(obj);
        }
    }

    private DefaultChoreographerFrameClock() {
    }

    public Object fold(Object obj, Function2 function2) {
        return u0.a.a(this, obj, function2);
    }

    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return u0.a.b(this, key);
    }

    public /* synthetic */ CoroutineContext.Key getKey() {
        return t0.a(this);
    }

    @Override // androidx.compose.runtime.u0
    public Object j(Function1 function1, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final a aVar = new a(cancellableContinuationImpl, function1);
        f2596b.postFrameCallback(aVar);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.DefaultChoreographerFrameClock$withFrameNanos$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.a;
            }

            public final void invoke(Throwable th) {
                DefaultChoreographerFrameClock.f2596b.removeFrameCallback(aVar);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return u0.a.c(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return u0.a.d(this, coroutineContext);
    }
}
