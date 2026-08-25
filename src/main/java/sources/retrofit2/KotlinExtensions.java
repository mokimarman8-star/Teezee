package retrofit2;

import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class KotlinExtensions {

    /* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
    public static final class a implements f {
        final /* synthetic */ kotlinx.coroutines.n a;

        a(kotlinx.coroutines.n nVar) {
            this.a = nVar;
        }

        @Override // retrofit2.f
        public void a(d dVar, Throwable th) {
            Intrinsics.h(dVar, "call");
            Intrinsics.h(th, "t");
            kotlinx.coroutines.n nVar = this.a;
            Result.Companion companion = Result.Companion;
            nVar.resumeWith(Result.m34constructorimpl(ResultKt.a(th)));
        }

        @Override // retrofit2.f
        public void b(d dVar, j0 j0Var) {
            Intrinsics.h(dVar, "call");
            Intrinsics.h(j0Var, "response");
            if (!j0Var.e()) {
                kotlinx.coroutines.n nVar = this.a;
                Result.Companion companion = Result.Companion;
                nVar.resumeWith(Result.m34constructorimpl(ResultKt.a(new HttpException(j0Var))));
                return;
            }
            Object a = j0Var.a();
            if (a != null) {
                this.a.resumeWith(Result.m34constructorimpl(a));
                return;
            }
            Object tag = dVar.request().tag(v.class);
            Intrinsics.e(tag);
            v vVar = (v) tag;
            KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + vVar.b().getName() + '.' + vVar.a().getName() + " was null but response body type was declared as non-null");
            kotlinx.coroutines.n nVar2 = this.a;
            Result.Companion companion2 = Result.Companion;
            nVar2.resumeWith(Result.m34constructorimpl(ResultKt.a(kotlinNullPointerException)));
        }
    }

    /* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
    public static final class b implements f {
        final /* synthetic */ kotlinx.coroutines.n a;

        b(kotlinx.coroutines.n nVar) {
            this.a = nVar;
        }

        @Override // retrofit2.f
        public void a(d dVar, Throwable th) {
            Intrinsics.h(dVar, "call");
            Intrinsics.h(th, "t");
            kotlinx.coroutines.n nVar = this.a;
            Result.Companion companion = Result.Companion;
            nVar.resumeWith(Result.m34constructorimpl(ResultKt.a(th)));
        }

        @Override // retrofit2.f
        public void b(d dVar, j0 j0Var) {
            Intrinsics.h(dVar, "call");
            Intrinsics.h(j0Var, "response");
            if (j0Var.e()) {
                kotlinx.coroutines.n nVar = this.a;
                Result.Companion companion = Result.Companion;
                nVar.resumeWith(Result.m34constructorimpl(j0Var.a()));
            } else {
                kotlinx.coroutines.n nVar2 = this.a;
                Result.Companion companion2 = Result.Companion;
                nVar2.resumeWith(Result.m34constructorimpl(ResultKt.a(new HttpException(j0Var))));
            }
        }
    }

    /* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
    public static final class c implements f {
        final /* synthetic */ kotlinx.coroutines.n a;

        c(kotlinx.coroutines.n nVar) {
            this.a = nVar;
        }

        @Override // retrofit2.f
        public void a(d dVar, Throwable th) {
            Intrinsics.h(dVar, "call");
            Intrinsics.h(th, "t");
            kotlinx.coroutines.n nVar = this.a;
            Result.Companion companion = Result.Companion;
            nVar.resumeWith(Result.m34constructorimpl(ResultKt.a(th)));
        }

        @Override // retrofit2.f
        public void b(d dVar, j0 j0Var) {
            Intrinsics.h(dVar, "call");
            Intrinsics.h(j0Var, "response");
            this.a.resumeWith(Result.m34constructorimpl(j0Var));
        }
    }

    public static final Object a(final d dVar, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.a;
            }

            public final void invoke(Throwable th) {
                dVar.cancel();
            }
        });
        dVar.f(new a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    public static final Object b(final d dVar, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.a;
            }

            public final void invoke(Throwable th) {
                dVar.cancel();
            }
        });
        dVar.f(new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    public static final Object c(final d dVar, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.a;
            }

            public final void invoke(Throwable th) {
                dVar.cancel();
            }
        });
        dVar.f(new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    public static final Object d(d dVar, Continuation continuation) {
        Intrinsics.f(dVar, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
        return b(dVar, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(final java.lang.Throwable r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.L$0
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            kotlin.ResultKt.b(r5)
            goto L5c
        L35:
            kotlin.ResultKt.b(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.i0 r5 = kotlinx.coroutines.y0.a()
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$2$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$2$1
            r3.<init>()
            r5.dispatch(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r4 != r5) goto L59
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.e(java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
