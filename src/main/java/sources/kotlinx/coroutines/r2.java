package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class r2 implements CoroutineContext$Element, CoroutineContext$Key {
    public static final r2 a = new r2();

    private r2() {
    }

    public Object fold(Object obj, Function2 function2) {
        return CoroutineContext$Element.DefaultImpls.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public CoroutineContext$Element get(CoroutineContext$Key coroutineContext$Key) {
        return CoroutineContext$Element.DefaultImpls.b(this, coroutineContext$Key);
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public CoroutineContext$Key getKey() {
        return this;
    }

    public CoroutineContext minusKey(CoroutineContext$Key coroutineContext$Key) {
        return CoroutineContext$Element.DefaultImpls.c(this, coroutineContext$Key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext$Element.DefaultImpls.d(this, coroutineContext);
    }
}
