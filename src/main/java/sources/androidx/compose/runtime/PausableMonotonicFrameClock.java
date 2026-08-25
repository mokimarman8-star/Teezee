package androidx.compose.runtime;

import androidx.compose.runtime.u0;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class PausableMonotonicFrameClock implements u0 {

    /* renamed from: a, reason: collision with root package name */
    private final u0 f2614a;

    /* renamed from: b, reason: collision with root package name */
    private final Latch f2615b = new Latch();

    public PausableMonotonicFrameClock(u0 u0Var) {
        this.f2614a = u0Var;
    }

    public final void a() {
        this.f2615b.d();
    }

    public final void c() {
        this.f2615b.f();
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x0063 A[PHI: r7
      0x0063: PHI (r7v6 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0060, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.runtime.u0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object j(Function1 function1, Continuation continuation) {
        PausableMonotonicFrameClock$withFrameNanos$1 pausableMonotonicFrameClock$withFrameNanos$1;
        int i5;
        PausableMonotonicFrameClock pausableMonotonicFrameClock;
        if (continuation instanceof PausableMonotonicFrameClock$withFrameNanos$1) {
            pausableMonotonicFrameClock$withFrameNanos$1 = (PausableMonotonicFrameClock$withFrameNanos$1) continuation;
            int i6 = pausableMonotonicFrameClock$withFrameNanos$1.label;
            if ((i6 & EditorInfoCompat.IME_FLAG_FORCE_ASCII) != 0) {
                pausableMonotonicFrameClock$withFrameNanos$1.label = i6 - EditorInfoCompat.IME_FLAG_FORCE_ASCII;
                Object obj = pausableMonotonicFrameClock$withFrameNanos$1.result;
                Object f5 = IntrinsicsKt.f();
                i5 = pausableMonotonicFrameClock$withFrameNanos$1.label;
                if (i5 != 0) {
                    ResultKt.b(obj);
                    Latch latch = this.f2615b;
                    pausableMonotonicFrameClock$withFrameNanos$1.L$0 = this;
                    pausableMonotonicFrameClock$withFrameNanos$1.L$1 = function1;
                    pausableMonotonicFrameClock$withFrameNanos$1.label = 1;
                    if (latch.c(pausableMonotonicFrameClock$withFrameNanos$1) == f5) {
                        return f5;
                    }
                    pausableMonotonicFrameClock = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.b(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) pausableMonotonicFrameClock$withFrameNanos$1.L$1;
                    pausableMonotonicFrameClock = (PausableMonotonicFrameClock) pausableMonotonicFrameClock$withFrameNanos$1.L$0;
                    ResultKt.b(obj);
                }
                u0 u0Var = pausableMonotonicFrameClock.f2614a;
                pausableMonotonicFrameClock$withFrameNanos$1.L$0 = null;
                pausableMonotonicFrameClock$withFrameNanos$1.L$1 = null;
                pausableMonotonicFrameClock$withFrameNanos$1.label = 2;
                obj = u0Var.j(function1, pausableMonotonicFrameClock$withFrameNanos$1);
                return obj != f5 ? f5 : obj;
            }
        }
        pausableMonotonicFrameClock$withFrameNanos$1 = new PausableMonotonicFrameClock$withFrameNanos$1(this, continuation);
        Object obj2 = pausableMonotonicFrameClock$withFrameNanos$1.result;
        Object f52 = IntrinsicsKt.f();
        i5 = pausableMonotonicFrameClock$withFrameNanos$1.label;
        if (i5 != 0) {
        }
        u0 u0Var2 = pausableMonotonicFrameClock.f2614a;
        pausableMonotonicFrameClock$withFrameNanos$1.L$0 = null;
        pausableMonotonicFrameClock$withFrameNanos$1.L$1 = null;
        pausableMonotonicFrameClock$withFrameNanos$1.label = 2;
        obj2 = u0Var2.j(function1, pausableMonotonicFrameClock$withFrameNanos$1);
        if (obj2 != f52) {
        }
    }

    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return u0.a.c(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return u0.a.d(this, coroutineContext);
    }
}
