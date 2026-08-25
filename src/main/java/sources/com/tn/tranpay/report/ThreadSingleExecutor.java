package com.tn.tranpay.report;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ThreadSingleExecutor {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<ThreadSingleExecutor>() { // from class: com.tn.tranpay.report.ThreadSingleExecutor$Companion$INSTANCE$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ThreadSingleExecutor m142invoke() {
            return new ThreadSingleExecutor();
        }
    });
    private ExecutorService a = Executors.newSingleThreadExecutor(new com.tn.tranpay.report.a("tran_single"));

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ThreadSingleExecutor a() {
            return (ThreadSingleExecutor) ThreadSingleExecutor.c.getValue();
        }
    }

    public final void b(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        ExecutorService executorService = this.a;
        if (executorService != null) {
            executorService.submit(runnable);
        }
    }
}
