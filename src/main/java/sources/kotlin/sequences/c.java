package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class c extends SequenceScope implements Iterator, Continuation, KMappedMarker {
    private int a;
    private Object b;
    private Iterator c;
    private Continuation d;

    private final Throwable f() {
        int i = this.a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    private final Object h() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.sequences.SequenceScope
    public Object a(Object obj, Continuation continuation) {
        this.b = obj;
        this.a = 3;
        this.d = continuation;
        Object f = IntrinsicsKt.f();
        if (f == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return f == IntrinsicsKt.f() ? f : Unit.a;
    }

    @Override // kotlin.sequences.SequenceScope
    public Object c(Iterator it, Continuation continuation) {
        if (!it.hasNext()) {
            return Unit.a;
        }
        this.c = it;
        this.a = 2;
        this.d = continuation;
        Object f = IntrinsicsKt.f();
        if (f == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return f == IntrinsicsKt.f() ? f : Unit.a;
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public CoroutineContext getA() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw f();
                }
                Iterator it = this.c;
                Intrinsics.e(it);
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.c = null;
            }
            this.a = 5;
            Continuation continuation = this.d;
            Intrinsics.e(continuation);
            this.d = null;
            Result$Companion result$Companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(Unit.a));
        }
    }

    public final void i(Continuation continuation) {
        this.d = continuation;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.a;
        if (i == 0 || i == 1) {
            return h();
        }
        if (i == 2) {
            this.a = 1;
            Iterator it = this.c;
            Intrinsics.e(it);
            return it.next();
        }
        if (i != 3) {
            throw f();
        }
        this.a = 0;
        Object obj = this.b;
        this.b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        ResultKt.b(obj);
        this.a = 4;
    }
}
