package com.transsion.baselib.config;

import android.app.Application;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.Thread;
import java.util.concurrent.ExecutionException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final a c = new a((DefaultConstructorMarker) null);
    private static final Lazy d = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.baselib.config.a
        public final Object invoke() {
            CrashHandler b;
            b = CrashHandler.b();
            return b;
        }
    });
    private Thread.UncaughtExceptionHandler a;
    private Application b;

    private CrashHandler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CrashHandler b() {
        return new CrashHandler();
    }

    private final void e(Throwable th) {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new dumpExceptionsToSDCard.1(this, th, (Continuation) null), 3, (Object) null);
    }

    private final boolean g(Throwable th) {
        String message;
        while (th != null) {
            if (Intrinsics.c(th.getClass().getName(), "android.database.CursorWindowAllocationException") && (message = th.getMessage()) != null && StringsKt.c0(message, "-12", false, 2, (Object) null)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public final void f(Application application) {
        this.b = application;
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String message;
        String message2;
        Intrinsics.h(thread, "thread");
        Intrinsics.h(th, "ex");
        e(th);
        if (((th instanceof IOException) || (th instanceof ExecutionException)) && (message = th.getMessage()) != null && StringsKt.c0(message, "Exception in CronetUrlRequest", false, 2, (Object) null)) {
            Log.e("CrashHandler", "error uncaughtException --- " + th.getMessage());
            return;
        }
        if (th instanceof RuntimeException) {
            Throwable cause = th.getCause();
            if (Intrinsics.c(cause != null ? cause.getClass().getName() : null, "android.os.DeadSystemException")) {
                Log.e("CrashHandler", "Ignored system dead: DeadSystemException in Service creation");
                return;
            }
        }
        if (Intrinsics.c(th.getClass().getName(), "android.os.DeadSystemException")) {
            Log.e("CrashHandler", "Ignored system dead: DeadSystemException");
            return;
        }
        if (StringsKt.c0(th.toString(), "CannotDeliverBroadcastException", false, 2, (Object) null)) {
            Log.e("CrashHandler", "error uncaughtException --- " + th);
            return;
        }
        if (Build.VERSION.SDK_INT <= 27 && (th instanceof IllegalArgumentException) && (message2 = th.getMessage()) != null && StringsKt.W(message2, "reportSizeConfigurations", false, 2, (Object) null)) {
            Log.w("CrashHandler", "Ignored system bug: reportSizeConfigurations on Android 7/8");
            return;
        }
        if (!g(th)) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            return;
        }
        e(th);
        Log.e("CrashHandler", "CursorWindowAllocationException (ENOMEM) swallowed, thread=" + thread.getName(), th);
    }
}
