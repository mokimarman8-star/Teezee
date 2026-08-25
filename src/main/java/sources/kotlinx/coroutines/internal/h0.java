package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h0 implements m2 {
    private final Object a;
    private final ThreadLocal b;
    private final CoroutineContext$Key c;

    public h0(Object obj, ThreadLocal threadLocal) {
        this.a = obj;
        this.b = threadLocal;
        this.c = new i0(threadLocal);
    }

    public Object fold(Object obj, Function2 function2) {
        return m2.a.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public CoroutineContext$Element get(CoroutineContext$Key coroutineContext$Key) {
        if (!Intrinsics.c(getKey(), coroutineContext$Key)) {
            return null;
        }
        Intrinsics.f(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public CoroutineContext$Key getKey() {
        return this.c;
    }

    @Override // kotlinx.coroutines.m2
    public void k(CoroutineContext coroutineContext, Object obj) {
        this.b.set(obj);
    }

    public CoroutineContext minusKey(CoroutineContext$Key coroutineContext$Key) {
        return Intrinsics.c(getKey(), coroutineContext$Key) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @Override // kotlinx.coroutines.m2
    public Object o(CoroutineContext coroutineContext) {
        Object obj = this.b.get();
        this.b.set(this.a);
        return obj;
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return m2.a.b(this, coroutineContext);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.a + ", threadLocal = " + this.b + ')';
    }
}
