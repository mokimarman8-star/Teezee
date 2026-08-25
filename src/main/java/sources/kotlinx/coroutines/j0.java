package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface j0 extends CoroutineContext$Element {
    public static final a l1 = a.a;

    public static final class a implements CoroutineContext$Key {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    void m(CoroutineContext coroutineContext, Throwable th);
}
