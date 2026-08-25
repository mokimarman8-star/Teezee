package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.exceptions.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import yx.h;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class g {
    public static final boolean a = b(true, "rx3.purge-enabled", true, true, new a());

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, threadFactory);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(a);
        return scheduledThreadPoolExecutor;
    }

    static boolean b(boolean z, String str, boolean z2, boolean z3, h hVar) {
        if (!z) {
            return z3;
        }
        try {
            String str2 = (String) hVar.apply(str);
            return str2 == null ? z2 : "true".equals(str2);
        } catch (Throwable th) {
            a.b(th);
            return z2;
        }
    }
}
