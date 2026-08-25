package com.transsion.baselib.net;

import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.NetworkUtils;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class LaunchWithErrorHandlerKt {
    public static final t1 b(t0 t0Var, Function2 function2, Function2 function22) {
        Intrinsics.h(t0Var, "<this>");
        Intrinsics.h(function2, "block");
        return i.d(u0.a(t0Var), y0.b(), (CoroutineStart) null, new LaunchWithErrorHandlerKt$launchWithCatch$1(function2, function22, Thread.currentThread().getStackTrace(), t0Var, null), 2, (Object) null);
    }

    public static final void c(n0 n0Var, Function2 function2, Function2 function22) {
        Intrinsics.h(n0Var, "<this>");
        Intrinsics.h(function2, "block");
        i.d(n0Var, y0.b(), (CoroutineStart) null, new LaunchWithErrorHandlerKt$launchWithCatch$2(function2, function22, Thread.currentThread().getStackTrace(), null), 2, (Object) null);
    }

    public static /* synthetic */ void d(n0 n0Var, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 2) != 0) {
            function22 = null;
        }
        c(n0Var, function2, function22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Throwable th2, String str) {
        if (NetworkUtils.n()) {
            wf.a.a.h("LaunchWithCatch", "exception " + th2.getMessage() + "  from: " + str, th2, true);
            return;
        }
        wf.a.a.h("LaunchWithCatch", "exception " + th2.getMessage() + "  from: " + str, th2, false);
    }
}
