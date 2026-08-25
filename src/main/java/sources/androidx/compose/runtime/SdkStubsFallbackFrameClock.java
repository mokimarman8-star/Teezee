package androidx.compose.runtime;

import androidx.compose.runtime.u0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class SdkStubsFallbackFrameClock implements u0 {

    /* renamed from: a, reason: collision with root package name */
    public static final SdkStubsFallbackFrameClock f2660a = new SdkStubsFallbackFrameClock();

    private SdkStubsFallbackFrameClock() {
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
        return kotlinx.coroutines.i.g(kotlinx.coroutines.y0.c(), new SdkStubsFallbackFrameClock$withFrameNanos$2(function1, null), continuation);
    }

    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return u0.a.c(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return u0.a.d(this, coroutineContext);
    }
}
