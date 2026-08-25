package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface m2 extends CoroutineContext$Element {

    public static final class a {
        public static Object a(m2 m2Var, Object obj, Function2 function2) {
            return CoroutineContext$Element.DefaultImpls.a(m2Var, obj, function2);
        }

        public static CoroutineContext b(m2 m2Var, CoroutineContext coroutineContext) {
            return CoroutineContext$Element.DefaultImpls.d(m2Var, coroutineContext);
        }
    }

    void k(CoroutineContext coroutineContext, Object obj);

    Object o(CoroutineContext coroutineContext);
}
