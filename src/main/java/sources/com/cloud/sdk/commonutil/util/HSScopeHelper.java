package com.cloud.sdk.commonutil.util;

import android.os.Handler;
import android.os.Looper;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.tmc.integration.event.EventConstants;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class HSScopeHelper {
    public static boolean b;
    public static final HSScopeHelper a = new HSScopeHelper();
    private static final j0 c = new a(j0.l1);
    private static final n0 d = o0.a(y0.c());
    private static final n0 e = o0.a(y0.b());
    private static final n0 f = o0.a(y0.a());

    public static final class a extends AbstractCoroutineContextElement implements j0 {
        public a(j0.a aVar) {
            super(aVar);
        }

        public void m(CoroutineContext coroutineContext, Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("CoroutineExceptionHandler: ");
            sb.append(th.getMessage());
        }
    }

    private HSScopeHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function0 function0, Function1 function1) {
        Intrinsics.h(function0, "$runnable");
        Intrinsics.h(function1, "$callback");
        try {
            function1.invoke(new f.b(function0.invoke()));
        } catch (Throwable th) {
            function1.invoke(new f.a(th));
        }
    }

    public final n0 b() {
        return f;
    }

    public final boolean c() {
        return Intrinsics.c(Looper.myLooper(), Looper.getMainLooper());
    }

    public final void d(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        try {
            Handler a2 = j.a.a("hs_fetch_ad_thread");
            if (a2 != null) {
                a2.removeCallbacks(runnable);
            }
        } catch (Throwable unused) {
        }
    }

    public final void e(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        Looper myLooper = Looper.myLooper();
        j jVar = j.a;
        Handler a2 = jVar.a("hs_fetch_ad_thread");
        if (Intrinsics.c(myLooper, a2 != null ? a2.getLooper() : null)) {
            runnable.run();
            return;
        }
        Handler a3 = jVar.a("hs_fetch_ad_thread");
        if (a3 != null) {
            a3.post(runnable);
        }
    }

    public final void f(Runnable runnable, long j) {
        Intrinsics.h(runnable, "runnable");
        Handler a2 = j.a.a("hs_fetch_ad_thread");
        if (a2 != null) {
            a2.postDelayed(runnable, j);
        }
    }

    public final void g(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        if (b) {
            com.cloud.sdk.commonutil.pool.b.b().a(runnable);
        } else {
            kotlinx.coroutines.i.d(e, c, (CoroutineStart) null, new HSScopeHelper$runIOThread$2(runnable, null), 2, (Object) null);
        }
    }

    public final void h(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        if (c()) {
            runnable.run();
        } else {
            kotlinx.coroutines.i.d(d, (CoroutineContext) null, (CoroutineStart) null, new HSScopeHelper$runUIThread$1(runnable, null), 3, (Object) null);
        }
    }

    public final void i(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        Looper myLooper = Looper.myLooper();
        j jVar = j.a;
        Handler a2 = jVar.a("hs_work_thread");
        if (Intrinsics.c(myLooper, a2 != null ? a2.getLooper() : null)) {
            runnable.run();
            return;
        }
        Handler a3 = jVar.a("hs_work_thread");
        if (a3 != null) {
            a3.post(runnable);
        }
    }

    public final void j(Runnable runnable, long j) {
        Intrinsics.h(runnable, "runnable");
        Handler a2 = j.a.a("hs_work_thread");
        if (a2 != null) {
            a2.postDelayed(runnable, j);
        }
    }

    public final void k(final Function0 function0, final Function1 function1) {
        Intrinsics.h(function0, "runnable");
        Intrinsics.h(function1, EventConstants.ABILITY_NAME_CALLBACK);
        Looper myLooper = Looper.myLooper();
        j jVar = j.a;
        Handler a2 = jVar.a("hs_work_thread");
        if (Intrinsics.c(myLooper, a2 != null ? a2.getLooper() : null)) {
            try {
                function1.invoke(new f.b(function0.invoke()));
                return;
            } catch (Throwable th) {
                function1.invoke(new f.a(th));
                return;
            }
        }
        Handler a3 = jVar.a("hs_work_thread");
        if (a3 != null) {
            a3.post(new Runnable() { // from class: com.cloud.sdk.commonutil.util.g
                @Override // java.lang.Runnable
                public final void run() {
                    HSScopeHelper.l(function0, function1);
                }
            });
        }
    }
}
