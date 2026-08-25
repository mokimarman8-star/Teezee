package androidx.view;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.g;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
/* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class C0191RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<n0, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: from Kotlin metadata and collision with other inner class name */
    static final class C00641 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ n0 $$this$coroutineScope;
        final /* synthetic */ Function2<n0, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00641(Lifecycle lifecycle, Lifecycle.State state, n0 n0Var, Function2<? super n0, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C00641> continuation) {
            super(2, continuation);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$$this$coroutineScope = n0Var;
            this.$block = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00641(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00d9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            Ref.ObjectRef objectRef2;
            t1 t1Var;
            r rVar;
            Object f5 = IntrinsicsKt.f();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.b(obj);
                if (this.$this_repeatOnLifecycle.b() == Lifecycle.State.DESTROYED) {
                    return Unit.a;
                }
                final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                try {
                    Lifecycle.State state = this.$state;
                    Lifecycle lifecycle = this.$this_repeatOnLifecycle;
                    final n0 n0Var = this.$$this$coroutineScope;
                    final Function2<n0, Continuation<? super Unit>, Object> function2 = this.$block;
                    this.L$0 = objectRef3;
                    this.L$1 = objectRef4;
                    this.L$2 = state;
                    this.L$3 = lifecycle;
                    this.L$4 = n0Var;
                    this.L$5 = function2;
                    this.label = 1;
                    final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(this), 1);
                    cancellableContinuationImpl.initCancellability();
                    Lifecycle$Event$a lifecycle$Event$a = Lifecycle.Event.Companion;
                    final Lifecycle.Event d5 = lifecycle$Event$a.d(state);
                    final Lifecycle.Event a5 = lifecycle$Event$a.a(state);
                    final a b5 = g.b(false, 1, (Object) null);
                    r rVar2 = new r() { // from class: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1

                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
                        @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {171, 110}, m = "invokeSuspend")
                        @SourceDebugExtension
                        /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1, reason: from Kotlin metadata */
                        static final class n0 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
                            final /* synthetic */ Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> $block;
                            final /* synthetic */ a $mutex;
                            Object L$0;
                            Object L$1;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            n0(a aVar, Function2<? super kotlinx.coroutines.n0, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super n0> continuation) {
                                super(2, continuation);
                                this.$mutex = aVar;
                                this.$block = function2;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new n0(this.$mutex, this.$block, continuation);
                            }

                            public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
                                return create(n0Var, continuation).invokeSuspend(Unit.a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                a aVar;
                                Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> function2;
                                a aVar2;
                                Throwable th;
                                Object f5 = IntrinsicsKt.f();
                                int i5 = this.label;
                                try {
                                    if (i5 == 0) {
                                        ResultKt.b(obj);
                                        aVar = this.$mutex;
                                        function2 = this.$block;
                                        this.L$0 = aVar;
                                        this.L$1 = function2;
                                        this.label = 1;
                                        if (aVar.f((Object) null, this) == f5) {
                                            return f5;
                                        }
                                    } else {
                                        if (i5 != 1) {
                                            if (i5 != 2) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            aVar2 = (a) this.L$0;
                                            try {
                                                ResultKt.b(obj);
                                                Unit unit = Unit.a;
                                                aVar2.unlock((Object) null);
                                                return Unit.a;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                aVar2.unlock((Object) null);
                                                throw th;
                                            }
                                        }
                                        function2 = (Function2) this.L$1;
                                        a aVar3 = (a) this.L$0;
                                        ResultKt.b(obj);
                                        aVar = aVar3;
                                    }
                                    C0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 c0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new C0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(function2, null);
                                    this.L$0 = aVar;
                                    this.L$1 = null;
                                    this.label = 2;
                                    if (o0.e(c0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == f5) {
                                        return f5;
                                    }
                                    aVar2 = aVar;
                                    Unit unit2 = Unit.a;
                                    aVar2.unlock((Object) null);
                                    return Unit.a;
                                } catch (Throwable th3) {
                                    aVar2 = aVar;
                                    th = th3;
                                    aVar2.unlock((Object) null);
                                    throw th;
                                }
                            }
                        }

                        @Override // androidx.view.r
                        public final void onStateChanged(u uVar, Lifecycle.Event event) {
                            Intrinsics.h(uVar, "<anonymous parameter 0>");
                            Intrinsics.h(event, NotificationCompat.CATEGORY_EVENT);
                            if (event == d5) {
                                objectRef3.element = i.d(n0Var, (CoroutineContext) null, (CoroutineStart) null, new n0(b5, function2, null), 3, (Object) null);
                                return;
                            }
                            if (event == a5) {
                                t1 t1Var2 = (t1) objectRef3.element;
                                if (t1Var2 != null) {
                                    t1.a.b(t1Var2, (CancellationException) null, 1, (Object) null);
                                }
                                objectRef3.element = null;
                            }
                            if (event == Lifecycle.Event.ON_DESTROY) {
                                n nVar = cancellableContinuationImpl;
                                Result.Companion companion = Result.Companion;
                                nVar.resumeWith(Result.constructor-impl(Unit.a));
                            }
                        }
                    };
                    objectRef4.element = rVar2;
                    Intrinsics.f(rVar2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
                    lifecycle.a(rVar2);
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.f()) {
                        DebugProbesKt.c(this);
                    }
                    if (result == f5) {
                        return f5;
                    }
                    objectRef = objectRef3;
                    objectRef2 = objectRef4;
                } catch (Throwable th) {
                    th = th;
                    objectRef = objectRef3;
                    objectRef2 = objectRef4;
                    t1Var = (t1) objectRef.element;
                    if (t1Var != null) {
                        t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
                    }
                    rVar = (r) objectRef2.element;
                    if (rVar != null) {
                        this.$this_repeatOnLifecycle.d(rVar);
                    }
                    throw th;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef2 = (Ref.ObjectRef) this.L$1;
                objectRef = (Ref.ObjectRef) this.L$0;
                try {
                    ResultKt.b(obj);
                } catch (Throwable th2) {
                    th = th2;
                    t1Var = (t1) objectRef.element;
                    if (t1Var != null) {
                    }
                    rVar = (r) objectRef2.element;
                    if (rVar != null) {
                    }
                    throw th;
                }
            }
            t1 t1Var2 = (t1) objectRef.element;
            if (t1Var2 != null) {
                t1.a.b(t1Var2, (CancellationException) null, 1, (Object) null);
            }
            r rVar3 = (r) objectRef2.element;
            if (rVar3 != null) {
                this.$this_repeatOnLifecycle.d(rVar3);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0191RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, Function2<? super n0, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C0191RepeatOnLifecycleKt$repeatOnLifecycle$3> continuation) {
        super(2, continuation);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C0191RepeatOnLifecycleKt$repeatOnLifecycle$3 c0191RepeatOnLifecycleKt$repeatOnLifecycle$3 = new C0191RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, continuation);
        c0191RepeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return c0191RepeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = IntrinsicsKt.f();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.b(obj);
            n0 n0Var = (n0) this.L$0;
            a2 p5 = y0.c().p();
            C00641 c00641 = new C00641(this.$this_repeatOnLifecycle, this.$state, n0Var, this.$block, null);
            this.label = 1;
            if (i.g(p5, c00641, this) == f5) {
                return f5;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
