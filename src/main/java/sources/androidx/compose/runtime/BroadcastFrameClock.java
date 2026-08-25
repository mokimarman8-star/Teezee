package androidx.compose.runtime;

import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.u0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class BroadcastFrameClock implements u0 {

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f2548a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f2549b;

    /* renamed from: c, reason: collision with root package name */
    private Throwable f2550c;

    /* renamed from: d, reason: collision with root package name */
    private List f2551d;

    /* renamed from: e, reason: collision with root package name */
    private List f2552e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInt f2553f;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Function1 f2554a;

        /* renamed from: b, reason: collision with root package name */
        private final Continuation f2555b;

        public a(Function1 function1, Continuation continuation) {
            this.f2554a = function1;
            this.f2555b = continuation;
        }

        public final Continuation a() {
            return this.f2555b;
        }

        public final void b(long j5) {
            Object obj;
            Continuation continuation = this.f2555b;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(this.f2554a.invoke(Long.valueOf(j5)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th));
            }
            continuation.resumeWith(obj);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BroadcastFrameClock() {
        this(r0, 1, r0);
        Function0 function0 = null;
    }

    public BroadcastFrameClock(Function0 function0) {
        this.f2548a = function0;
        this.f2549b = new Object();
        this.f2551d = new ArrayList();
        this.f2552e = new ArrayList();
        this.f2553f = new AtomicInt(0);
    }

    public /* synthetic */ BroadcastFrameClock(Function0 function0, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Throwable th) {
        synchronized (this.f2549b) {
            try {
                if (this.f2550c != null) {
                    return;
                }
                this.f2550c = th;
                List list = this.f2551d;
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Continuation a5 = ((a) list.get(i5)).a();
                    Result.Companion companion = Result.Companion;
                    a5.resumeWith(Result.constructor-impl(ResultKt.a(th)));
                }
                this.f2551d.clear();
                this.f2553f.set(0);
                Unit unit = Unit.a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
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
        final a aVar = new a(function1, cancellableContinuationImpl);
        synchronized (this.f2549b) {
            Throwable th = this.f2550c;
            if (th != null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.constructor-impl(ResultKt.a(th)));
            } else {
                boolean isEmpty = this.f2551d.isEmpty();
                this.f2551d.add(aVar);
                if (isEmpty) {
                    this.f2553f.set(1);
                }
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return Unit.a;
                    }

                    public final void invoke(Throwable th2) {
                        Object obj = BroadcastFrameClock.this.f2549b;
                        BroadcastFrameClock broadcastFrameClock = BroadcastFrameClock.this;
                        BroadcastFrameClock.a aVar2 = aVar;
                        synchronized (obj) {
                            try {
                                broadcastFrameClock.f2551d.remove(aVar2);
                                if (broadcastFrameClock.f2551d.isEmpty()) {
                                    broadcastFrameClock.f2553f.set(0);
                                }
                                Unit unit = Unit.a;
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                });
                if (isEmpty && this.f2548a != null) {
                    try {
                        this.f2548a.invoke();
                    } catch (Throwable th2) {
                        p(th2);
                    }
                }
            }
        }
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

    public final boolean q() {
        return this.f2553f.get() != 0;
    }

    public final void r(long j5) {
        synchronized (this.f2549b) {
            try {
                List list = this.f2551d;
                this.f2551d = this.f2552e;
                this.f2552e = list;
                this.f2553f.set(0);
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((a) list.get(i5)).b(j5);
                }
                list.clear();
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
