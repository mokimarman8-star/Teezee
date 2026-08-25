package com.transsion.search_pugc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.search_pugc.i
        public final Object invoke() {
            j b2;
            b2 = j.b();
            return b2;
        }
    });
    private ExecutorService a = Executors.newFixedThreadPool(3);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j a() {
            return (j) j.c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j b() {
        return new j();
    }

    public final void d(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        ExecutorService executorService = this.a;
        if (executorService != null) {
            executorService.submit(runnable);
        }
    }
}
