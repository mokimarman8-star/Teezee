package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.selects.b;
import kotlinx.coroutines.selects.c;
import kotlinx.coroutines.selects.d;
import kotlinx.coroutines.selects.e;
import kotlinx.coroutines.selects.f;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class JobSupport implements t1, v, f2 {
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/JobSupport;", "job", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "Lkotlinx/coroutines/t1;", "parent", "", "getContinuationCancellationCause", "(Lkotlinx/coroutines/t1;)Ljava/lang/Throwable;", "", "nameString", "()Ljava/lang/String;", "Lkotlinx/coroutines/JobSupport;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension
    private static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        public AwaitContinuation(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable getContinuationCancellationCause(t1 parent) {
            Throwable e;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            return (!(state$kotlinx_coroutines_core instanceof b) || (e = ((b) state$kotlinx_coroutines_core).e()) == null) ? state$kotlinx_coroutines_core instanceof b0 ? ((b0) state$kotlinx_coroutines_core).a : parent.getCancellationException() : e;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String nameString() {
            return "AwaitContinuation";
        }
    }

    public JobSupport(boolean z) {
        this._state$volatile = z ? x1.c() : x1.d();
    }

    private final boolean C() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof p1)) {
                return false;
            }
        } while (N(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object D(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        q.a(cancellableContinuationImpl, v1.m(this, false, new h2(cancellableContinuationImpl), 1, (Object) null));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.a;
    }

    private final Object E(Object obj) {
        Throwable th = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof b) {
                synchronized (state$kotlinx_coroutines_core) {
                    if (((b) state$kotlinx_coroutines_core).k()) {
                        return x1.f();
                    }
                    boolean i = ((b) state$kotlinx_coroutines_core).i();
                    if (obj != null || !i) {
                        if (th == null) {
                            th = v(obj);
                        }
                        ((b) state$kotlinx_coroutines_core).a(th);
                    }
                    Throwable e = i ? null : ((b) state$kotlinx_coroutines_core).e();
                    if (e != null) {
                        G(((b) state$kotlinx_coroutines_core).b(), e);
                    }
                    return x1.a();
                }
            }
            if (!(state$kotlinx_coroutines_core instanceof p1)) {
                return x1.f();
            }
            if (th == null) {
                th = v(obj);
            }
            p1 p1Var = (p1) state$kotlinx_coroutines_core;
            if (!p1Var.isActive()) {
                Object R = R(state$kotlinx_coroutines_core, new b0(th, false, 2, (DefaultConstructorMarker) null));
                if (R == x1.a()) {
                    throw new IllegalStateException(("Cannot happen in " + state$kotlinx_coroutines_core).toString());
                }
                if (R != x1.b()) {
                    return R;
                }
            } else if (Q(p1Var, th)) {
                return x1.a();
            }
        }
    }

    private final u F(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.p()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.l();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.k();
            if (!lockFreeLinkedListNode.p()) {
                if (lockFreeLinkedListNode instanceof u) {
                    return (u) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof b2) {
                    return null;
                }
            }
        }
    }

    private final void G(b2 b2Var, Throwable th) {
        onCancelling(th);
        b2Var.f(4);
        Object j = b2Var.j();
        Intrinsics.f(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (w1 w1Var = (LockFreeLinkedListNode) j; !Intrinsics.c(w1Var, b2Var); w1Var = w1Var.k()) {
            if ((w1Var instanceof w1) && w1Var.u()) {
                try {
                    w1Var.v(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + w1Var + " for " + this, th2);
                        Unit unit = Unit.a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        s(th);
    }

    private final void H(b2 b2Var, Throwable th) {
        b2Var.f(1);
        Object j = b2Var.j();
        Intrinsics.f(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (w1 w1Var = (LockFreeLinkedListNode) j; !Intrinsics.c(w1Var, b2Var); w1Var = w1Var.k()) {
            if (w1Var instanceof w1) {
                try {
                    w1Var.v(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + w1Var + " for " + this, th2);
                        Unit unit = Unit.a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I(Object obj, Object obj2) {
        if (obj2 instanceof b0) {
            throw ((b0) obj2).a;
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(f fVar, Object obj) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof p1)) {
                if (!(state$kotlinx_coroutines_core instanceof b0)) {
                    state$kotlinx_coroutines_core = x1.h(state$kotlinx_coroutines_core);
                }
                fVar.a(state$kotlinx_coroutines_core);
                return;
            }
        } while (N(state$kotlinx_coroutines_core) < 0);
        fVar.b(v1.m(this, false, new c(this, fVar), 1, (Object) null));
    }

    private final void K(d1 d1Var) {
        b2 b2Var = new b2();
        if (!d1Var.isActive()) {
            b2Var = new o1(b2Var);
        }
        a.a(_state$volatile$FU, this, d1Var, b2Var);
    }

    private final void L(w1 w1Var) {
        w1Var.e(new b2());
        a.a(_state$volatile$FU, this, w1Var, w1Var.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(f fVar, Object obj) {
        if (C()) {
            fVar.b(v1.m(this, false, new d(this, fVar), 1, (Object) null));
        } else {
            fVar.a(Unit.a);
        }
    }

    private final int N(Object obj) {
        if (obj instanceof d1) {
            if (((d1) obj).isActive()) {
                return 0;
            }
            if (!a.a(_state$volatile$FU, this, obj, x1.c())) {
                return -1;
            }
            onStart();
            return 1;
        }
        if (!(obj instanceof o1)) {
            return 0;
        }
        if (!a.a(_state$volatile$FU, this, obj, ((o1) obj).b())) {
            return -1;
        }
        onStart();
        return 1;
    }

    private final String O(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof p1 ? ((p1) obj).isActive() ? "Active" : "New" : obj instanceof b0 ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.i() ? "Cancelling" : bVar.j() ? "Completing" : "Active";
    }

    private final boolean P(p1 p1Var, Object obj) {
        if (!a.a(_state$volatile$FU, this, p1Var, x1.g(obj))) {
            return false;
        }
        onCancelling(null);
        onCompletionInternal(obj);
        t(p1Var, obj);
        return true;
    }

    private final boolean Q(p1 p1Var, Throwable th) {
        b2 z = z(p1Var);
        if (z == null) {
            return false;
        }
        if (!a.a(_state$volatile$FU, this, p1Var, new b(z, false, th))) {
            return false;
        }
        G(z, th);
        return true;
    }

    private final Object R(Object obj, Object obj2) {
        return !(obj instanceof p1) ? x1.a() : ((!(obj instanceof d1) && !(obj instanceof w1)) || (obj instanceof u) || (obj2 instanceof b0)) ? S((p1) obj, obj2) : P((p1) obj, obj2) ? obj2 : x1.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object S(p1 p1Var, Object obj) {
        b2 z = z(p1Var);
        if (z == null) {
            return x1.b();
        }
        b bVar = p1Var instanceof b ? (b) p1Var : null;
        if (bVar == null) {
            bVar = new b(z, false, (Throwable) null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (bVar) {
            if (bVar.j()) {
                return x1.a();
            }
            bVar.m(true);
            if (bVar != p1Var && !a.a(_state$volatile$FU, this, p1Var, bVar)) {
                return x1.b();
            }
            boolean i = bVar.i();
            b0 b0Var = obj instanceof b0 ? (b0) obj : null;
            if (b0Var != null) {
                bVar.a(b0Var.a);
            }
            ?? e = i ? 0 : bVar.e();
            ref$ObjectRef.element = e;
            Unit unit = Unit.a;
            if (e != 0) {
                G(z, e);
            }
            u F = F(z);
            if (F != null && T(bVar, F, obj)) {
                return x1.b;
            }
            z.f(2);
            u F2 = F(z);
            return (F2 == null || !T(bVar, F2, obj)) ? w(bVar, obj) : x1.b;
        }
    }

    private final boolean T(b bVar, u uVar, Object obj) {
        while (v1.l(uVar.e, false, new a(this, bVar, uVar, obj)) == d2.a) {
            uVar = F(uVar);
            if (uVar == null) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            th = null;
        }
        if (str == null) {
            str = jobSupport.cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th, jobSupport);
    }

    protected static /* synthetic */ void getOnAwaitInternal$annotations() {
    }

    public static /* synthetic */ void getOnJoin$annotations() {
    }

    private final void p(Throwable th, List list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                ExceptionsKt.a(th, th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(Continuation continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.c(continuation), this);
        awaitContinuation.initCancellability();
        q.a(awaitContinuation, v1.m(this, false, new g2(awaitContinuation), 1, (Object) null));
        Object result = awaitContinuation.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    private final Object r(Object obj) {
        Object R;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof p1) || ((state$kotlinx_coroutines_core instanceof b) && ((b) state$kotlinx_coroutines_core).j())) {
                return x1.a();
            }
            R = R(state$kotlinx_coroutines_core, new b0(v(obj), false, 2, (DefaultConstructorMarker) null));
        } while (R == x1.b());
        return R;
    }

    private final boolean s(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        d2 parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        return (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == d2.a) ? z : parentHandle$kotlinx_coroutines_core.a(th) || z;
    }

    private final void t(p1 p1Var, Object obj) {
        t parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(d2.a);
        }
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        Throwable th = b0Var != null ? b0Var.a : null;
        if (!(p1Var instanceof w1)) {
            b2 b = p1Var.b();
            if (b != null) {
                H(b, th);
                return;
            }
            return;
        }
        try {
            ((w1) p1Var).v(th);
        } catch (Throwable th2) {
            handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + p1Var + " for " + this, th2));
        }
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return jobSupport.toCancellationException(th, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(b bVar, u uVar, Object obj) {
        u F = F(uVar);
        if (F == null || !T(bVar, F, obj)) {
            bVar.b().f(2);
            u F2 = F(uVar);
            if (F2 == null || !T(bVar, F2, obj)) {
                afterCompletion(w(bVar, obj));
            }
        }
    }

    private final Throwable v(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(cancellationExceptionMessage(), null, this) : th;
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((f2) obj).getChildJobCancellationCause();
    }

    private final Object w(b bVar, Object obj) {
        boolean i;
        Throwable y;
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        Throwable th = b0Var != null ? b0Var.a : null;
        synchronized (bVar) {
            i = bVar.i();
            List l = bVar.l(th);
            y = y(bVar, l);
            if (y != null) {
                p(y, l);
            }
        }
        if (y != null && y != th) {
            obj = new b0(y, false, 2, (DefaultConstructorMarker) null);
        }
        if (y != null && (s(y) || handleJobException(y))) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((b0) obj).c();
        }
        if (!i) {
            onCancelling(y);
        }
        onCompletionInternal(obj);
        a.a(_state$volatile$FU, this, bVar, x1.g(obj));
        t(bVar, obj);
        return obj;
    }

    private final Throwable x(Object obj) {
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        if (b0Var != null) {
            return b0Var.a;
        }
        return null;
    }

    private final Throwable y(b bVar, List list) {
        Object obj;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (bVar.i()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final b2 z(p1 p1Var) {
        b2 b = p1Var.b();
        if (b != null) {
            return b;
        }
        if (p1Var instanceof d1) {
            return new b2();
        }
        if (p1Var instanceof w1) {
            L((w1) p1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + p1Var).toString());
    }

    protected void afterCompletion(Object obj) {
    }

    public final t attachChild(v vVar) {
        LockFreeLinkedListNode uVar = new u(vVar);
        uVar.w(this);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof d1) {
                d1 d1Var = (d1) state$kotlinx_coroutines_core;
                if (!d1Var.isActive()) {
                    K(d1Var);
                } else if (a.a(_state$volatile$FU, this, state$kotlinx_coroutines_core, uVar)) {
                    break;
                }
            } else {
                if (!(state$kotlinx_coroutines_core instanceof p1)) {
                    Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
                    b0 b0Var = state$kotlinx_coroutines_core2 instanceof b0 ? (b0) state$kotlinx_coroutines_core2 : null;
                    uVar.v(b0Var != null ? b0Var.a : null);
                    return d2.a;
                }
                b2 b = ((p1) state$kotlinx_coroutines_core).b();
                if (b == null) {
                    Intrinsics.f(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    L((w1) state$kotlinx_coroutines_core);
                } else if (!b.c(uVar, 7)) {
                    boolean c = b.c(uVar, 3);
                    Object state$kotlinx_coroutines_core3 = getState$kotlinx_coroutines_core();
                    if (state$kotlinx_coroutines_core3 instanceof b) {
                        r2 = ((b) state$kotlinx_coroutines_core3).e();
                    } else {
                        b0 b0Var2 = state$kotlinx_coroutines_core3 instanceof b0 ? (b0) state$kotlinx_coroutines_core3 : null;
                        if (b0Var2 != null) {
                            r2 = b0Var2.a;
                        }
                    }
                    uVar.v(r2);
                    if (!c) {
                        return d2.a;
                    }
                }
            }
        }
        return uVar;
    }

    protected final Object awaitInternal(Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof p1)) {
                if (state$kotlinx_coroutines_core instanceof b0) {
                    throw ((b0) state$kotlinx_coroutines_core).a;
                }
                return x1.h(state$kotlinx_coroutines_core);
            }
        } while (N(state$kotlinx_coroutines_core) < 0);
        return q(continuation);
    }

    @Deprecated
    public /* synthetic */ void cancel() {
        t1.a.a(this);
    }

    public void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Deprecated
    public /* synthetic */ boolean cancel(Throwable th) {
        Throwable jobCancellationException;
        if (th == null || (jobCancellationException = toCancellationException$default(this, th, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(jobCancellationException);
        return true;
    }

    public final boolean cancelCoroutine(Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object obj) {
        Object a = x1.a();
        if (getOnCancelComplete$kotlinx_coroutines_core() && (a = r(obj)) == x1.b) {
            return true;
        }
        if (a == x1.a()) {
            a = E(obj);
        }
        if (a == x1.a() || a == x1.b) {
            return true;
        }
        if (a == x1.f()) {
            return false;
        }
        afterCompletion(a);
        return true;
    }

    public void cancelInternal(Throwable th) {
        cancelImpl$kotlinx_coroutines_core(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th) && getHandlesException$kotlinx_coroutines_core();
    }

    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(String str, Throwable th) {
        if (str == null) {
            str = cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th, this);
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) t1.a.c(this, r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) t1.a.d(this, key);
    }

    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof b)) {
            if (state$kotlinx_coroutines_core instanceof p1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (state$kotlinx_coroutines_core instanceof b0) {
                return toCancellationException$default(this, ((b0) state$kotlinx_coroutines_core).a, null, 1, null);
            }
            return new JobCancellationException(p0.a(this) + " has completed normally", null, this);
        }
        Throwable e = ((b) state$kotlinx_coroutines_core).e();
        if (e != null) {
            CancellationException cancellationException = toCancellationException(e, p0.a(this) + " is cancelling");
            if (cancellationException != null) {
                return cancellationException;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    public CancellationException getChildJobCancellationCause() {
        CancellationException cancellationException;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            cancellationException = ((b) state$kotlinx_coroutines_core).e();
        } else if (state$kotlinx_coroutines_core instanceof b0) {
            cancellationException = ((b0) state$kotlinx_coroutines_core).a;
        } else {
            if (state$kotlinx_coroutines_core instanceof p1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new JobCancellationException("Parent job is " + O(state$kotlinx_coroutines_core), cancellationException, this);
    }

    public final Sequence<t1> getChildren() {
        return SequencesKt.b(new children.1(this, (Continuation) null));
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof p1) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (state$kotlinx_coroutines_core instanceof b0) {
            throw ((b0) state$kotlinx_coroutines_core).a;
        }
        return x1.h(state$kotlinx_coroutines_core);
    }

    protected final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            Throwable e = ((b) state$kotlinx_coroutines_core).e();
            if (e != null) {
                return e;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(state$kotlinx_coroutines_core instanceof p1)) {
            if (state$kotlinx_coroutines_core instanceof b0) {
                return ((b0) state$kotlinx_coroutines_core).a;
            }
            return null;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    protected final boolean getCompletionCauseHandled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof b0) && ((b0) state$kotlinx_coroutines_core).a();
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof p1) {
            throw new IllegalStateException("This job has not completed yet");
        }
        return x(state$kotlinx_coroutines_core);
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    public final CoroutineContext.Key<?> getKey() {
        return t1.m1;
    }

    protected final d getOnAwaitInternal() {
        onAwaitInternal.1 r0 = onAwaitInternal.1.INSTANCE;
        Intrinsics.f(r0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.e(r0, 3);
        onAwaitInternal.2 r02 = onAwaitInternal.2.INSTANCE;
        Intrinsics.f(r02, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new e(this, function3, (Function3) TypeIntrinsics.e(r02, 3), (Function3) null, 8, (DefaultConstructorMarker) null);
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    public final b getOnJoin() {
        onJoin.1 r0 = onJoin.1.INSTANCE;
        Intrinsics.f(r0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new c(this, (Function3) TypeIntrinsics.e(r0, 3), (Function3) null, 4, (DefaultConstructorMarker) null);
    }

    public t1 getParent() {
        t parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            return parentHandle$kotlinx_coroutines_core.getParent();
        }
        return null;
    }

    public final t getParentHandle$kotlinx_coroutines_core() {
        return (t) _parentHandle$volatile$FU.get(this);
    }

    public final Object getState$kotlinx_coroutines_core() {
        return _state$volatile$FU.get(this);
    }

    protected boolean handleJobException(Throwable th) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable th) {
        throw th;
    }

    protected final void initParentJob(t1 t1Var) {
        if (t1Var == null) {
            setParentHandle$kotlinx_coroutines_core(d2.a);
            return;
        }
        t1Var.start();
        t attachChild = t1Var.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(d2.a);
        }
    }

    public final a1 invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        return invokeOnCompletionInternal$kotlinx_coroutines_core(true, new s1(function1));
    }

    public final a1 invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        return invokeOnCompletionInternal$kotlinx_coroutines_core(z2, z ? new r1(function1) : new s1(function1));
    }

    public final a1 invokeOnCompletionInternal$kotlinx_coroutines_core(boolean z, w1 w1Var) {
        boolean z2;
        boolean c;
        w1Var.w(this);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            z2 = true;
            if (!(state$kotlinx_coroutines_core instanceof d1)) {
                if (!(state$kotlinx_coroutines_core instanceof p1)) {
                    z2 = false;
                    break;
                }
                b bVar = (p1) state$kotlinx_coroutines_core;
                b2 b = bVar.b();
                if (b == null) {
                    Intrinsics.f(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    L((w1) state$kotlinx_coroutines_core);
                } else {
                    if (w1Var.u()) {
                        b bVar2 = bVar instanceof b ? bVar : null;
                        Throwable e = bVar2 != null ? bVar2.e() : null;
                        if (e != null) {
                            if (z) {
                                w1Var.v(e);
                            }
                            return d2.a;
                        }
                        c = b.c(w1Var, 5);
                    } else {
                        c = b.c(w1Var, 1);
                    }
                    if (c) {
                        break;
                    }
                }
            } else {
                d1 d1Var = (d1) state$kotlinx_coroutines_core;
                if (!d1Var.isActive()) {
                    K(d1Var);
                } else if (a.a(_state$volatile$FU, this, state$kotlinx_coroutines_core, w1Var)) {
                    break;
                }
            }
        }
        if (z2) {
            return w1Var;
        }
        if (z) {
            Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
            b0 b0Var = state$kotlinx_coroutines_core2 instanceof b0 ? (b0) state$kotlinx_coroutines_core2 : null;
            w1Var.v(b0Var != null ? b0Var.a : null);
        }
        return d2.a;
    }

    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof p1) && ((p1) state$kotlinx_coroutines_core).isActive();
    }

    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof b0) || ((state$kotlinx_coroutines_core instanceof b) && ((b) state$kotlinx_coroutines_core).i());
    }

    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof p1);
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof b0;
    }

    protected boolean isScopedCoroutine() {
        return false;
    }

    public final Object join(Continuation<? super Unit> continuation) {
        if (C()) {
            Object D = D(continuation);
            return D == IntrinsicsKt.f() ? D : Unit.a;
        }
        v1.i(continuation.getContext());
        return Unit.a;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object obj) {
        Object R;
        do {
            R = R(getState$kotlinx_coroutines_core(), obj);
            if (R == x1.a()) {
                return false;
            }
            if (R == x1.b) {
                return true;
            }
        } while (R == x1.b());
        afterCompletion(R);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) {
        Object R;
        do {
            R = R(getState$kotlinx_coroutines_core(), obj);
            if (R == x1.a()) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, x(obj));
            }
        } while (R == x1.b());
        return R;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return t1.a.e(this, key);
    }

    public String nameString$kotlinx_coroutines_core() {
        return p0.a(this);
    }

    protected void onCancelling(Throwable th) {
    }

    protected void onCompletionInternal(Object obj) {
    }

    protected void onStart() {
    }

    public final void parentCancelled(f2 f2Var) {
        cancelImpl$kotlinx_coroutines_core(f2Var);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return t1.a.f(this, coroutineContext);
    }

    @Deprecated
    public t1 plus(t1 t1Var) {
        return t1.a.g(this, t1Var);
    }

    public final void removeNode$kotlinx_coroutines_core(w1 w1Var) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof w1)) {
                if (!(state$kotlinx_coroutines_core instanceof p1) || ((p1) state$kotlinx_coroutines_core).b() == null) {
                    return;
                }
                w1Var.q();
                return;
            }
            if (state$kotlinx_coroutines_core != w1Var) {
                return;
            }
        } while (!a.a(_state$volatile$FU, this, state$kotlinx_coroutines_core, x1.c()));
    }

    public final void setParentHandle$kotlinx_coroutines_core(t tVar) {
        _parentHandle$volatile$FU.set(this, tVar);
    }

    public final boolean start() {
        int N;
        do {
            N = N(getState$kotlinx_coroutines_core());
            if (N == 0) {
                return false;
            }
        } while (N != 1);
        return true;
    }

    protected final CancellationException toCancellationException(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + O(getState$kotlinx_coroutines_core()) + '}';
    }

    public String toString() {
        return toDebugString() + '@' + p0.b(this);
    }
}
