package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f implements CoroutineContext {
    private final /* synthetic */ CoroutineContext a;
    public final Throwable b;

    public f(Throwable th, CoroutineContext coroutineContext) {
        this.a = coroutineContext;
        this.b = th;
    }

    public Object fold(Object obj, Function2 function2) {
        return this.a.fold(obj, function2);
    }

    public CoroutineContext$Element get(CoroutineContext$Key coroutineContext$Key) {
        return this.a.get(coroutineContext$Key);
    }

    public CoroutineContext minusKey(CoroutineContext$Key coroutineContext$Key) {
        return this.a.minusKey(coroutineContext$Key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.a.plus(coroutineContext);
    }
}
