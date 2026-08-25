package am;

import android.os.Looper;
import androidx.lifecycle.b0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class b {
    private final String a = getClass().getSimpleName();
    private volatile Object b;
    private volatile b0 c;
    private volatile io.reactivex.rxjava3.disposables.c d;
    private volatile t1 e;

    private final boolean e(b0 b0Var) {
        if (this.b == null) {
            this.c = b0Var;
            return true;
        }
        if (b0Var == null) {
            return false;
        }
        a.a aVar = wf.a.a;
        String str = this.a;
        Intrinsics.g(str, "TAG");
        a.a.f(aVar, str, "load data from preload", false, 4, (Object) null);
        b0Var.q(this.b);
        this.b = null;
        return false;
    }

    public static /* synthetic */ void g(b bVar, b0 b0Var, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
        }
        if ((i & 1) != 0) {
            b0Var = null;
        }
        bVar.f(b0Var);
    }

    public final synchronized Object a() {
        Object obj;
        obj = this.b;
        this.b = null;
        return obj;
    }

    public final String b() {
        return this.a;
    }

    public final void c(Object obj) {
        if (this.c == null) {
            a.a aVar = wf.a.a;
            String str = this.a;
            Intrinsics.g(str, "TAG");
            a.a.f(aVar, str, "load data handleFailureResult :", false, 4, (Object) null);
        } else {
            a.a aVar2 = wf.a.a;
            String str2 = this.a;
            Intrinsics.g(str2, "TAG");
            a.a.f(aVar2, str2, "load data handleFailureResult : return to ui", false, 4, (Object) null);
            if (Intrinsics.c(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                b0 b0Var = this.c;
                if (b0Var != null) {
                    b0Var.q(obj);
                }
            } else {
                b0 b0Var2 = this.c;
                if (b0Var2 != null) {
                    b0Var2.n(obj);
                }
            }
        }
        io.reactivex.rxjava3.disposables.c cVar = this.d;
        if (cVar != null) {
            d.a(cVar);
        }
    }

    public final void d(Object obj) {
        if (this.c == null) {
            this.b = obj;
            a.a aVar = wf.a.a;
            String str = this.a;
            Intrinsics.g(str, "TAG");
            a.a.f(aVar, str, "load data handleSuccessResult : cache data", false, 4, (Object) null);
        } else {
            a.a aVar2 = wf.a.a;
            String str2 = this.a;
            Intrinsics.g(str2, "TAG");
            a.a.f(aVar2, str2, "load data handleSuccessResult : return to ui", false, 4, (Object) null);
            if (Intrinsics.c(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                b0 b0Var = this.c;
                if (b0Var != null) {
                    b0Var.q(obj);
                }
            } else {
                b0 b0Var2 = this.c;
                if (b0Var2 != null) {
                    b0Var2.n(obj);
                }
            }
        }
        io.reactivex.rxjava3.disposables.c cVar = this.d;
        if (cVar != null) {
            d.a(cVar);
        }
    }

    public final void f(b0 b0Var) {
        t1 t1Var;
        if (e(b0Var)) {
            a.a aVar = wf.a.a;
            String str = this.a;
            Intrinsics.g(str, "TAG");
            a.a.f(aVar, str, "loadData  disposable:" + this.d + "  this:" + this, false, 4, (Object) null);
            io.reactivex.rxjava3.disposables.c cVar = this.d;
            if ((cVar != null && !cVar.isDisposed()) || ((t1Var = this.e) != null && t1Var.isActive())) {
                String str2 = this.a;
                Intrinsics.g(str2, "TAG");
                a.a.f(aVar, str2, "load data ing .. wait", false, 4, (Object) null);
            } else {
                String str3 = this.a;
                Intrinsics.g(str3, "TAG");
                a.a.f(aVar, str3, "loadDataFromService", false, 4, (Object) null);
                h(b0Var);
            }
        }
    }

    public abstract void h(b0 b0Var);

    public final void i(io.reactivex.rxjava3.disposables.c cVar) {
        this.d = cVar;
    }

    public final void j(t1 t1Var) {
        this.e = t1Var;
    }
}
