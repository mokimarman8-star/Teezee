package kotlinx.coroutines.sync;

import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface a {

    /* renamed from: kotlinx.coroutines.sync.a$a, reason: collision with other inner class name */
    public static final class C0075a {
        public static /* synthetic */ Object a(a aVar, Object obj, Continuation continuation, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            return aVar.f(obj, continuation);
        }

        public static /* synthetic */ boolean b(a aVar, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            return aVar.b(obj);
        }

        public static /* synthetic */ void c(a aVar, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            aVar.unlock(obj);
        }
    }

    boolean b(Object obj);

    boolean d();

    Object f(Object obj, Continuation continuation);

    void unlock(Object obj);
}
