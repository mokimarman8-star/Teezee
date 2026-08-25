package ij;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a0 {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: ij.z
        public final Object invoke() {
            a0 b2;
            b2 = a0.b();
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

        public final a0 a() {
            return (a0) a0.c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 b() {
        return new a0();
    }

    public final void d(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        ExecutorService executorService = this.a;
        if (executorService != null) {
            executorService.submit(runnable);
        }
    }
}
