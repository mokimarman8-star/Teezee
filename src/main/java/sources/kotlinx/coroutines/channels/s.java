package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface s {

    public static final class a {
        public static /* synthetic */ boolean a(s sVar, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return sVar.i(th);
        }
    }

    Object a(Object obj);

    boolean i(Throwable th);

    Object n(Object obj, Continuation continuation);
}
