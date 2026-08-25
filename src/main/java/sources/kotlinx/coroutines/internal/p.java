package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.a2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class p {
    private static final q a(Throwable th, String str) {
        if (th != null) {
            throw th;
        }
        d();
        throw new KotlinNothingValueException();
    }

    static /* synthetic */ q b(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(a2 a2Var) {
        return a2Var.p() instanceof q;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final a2 e(n nVar, List list) {
        try {
            return nVar.b(list);
        } catch (Throwable th) {
            return a(th, nVar.a());
        }
    }
}
