package q1;

import kotlin.NotImplementedError;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {
    public static final a a() {
        a2 a2Var;
        try {
            a2Var = y0.c().p();
        } catch (NotImplementedError unused) {
            a2Var = EmptyCoroutineContext.INSTANCE;
        } catch (IllegalStateException unused2) {
            a2Var = EmptyCoroutineContext.INSTANCE;
        }
        return new a(a2Var.plus(l2.b((t1) null, 1, (Object) null)));
    }
}
