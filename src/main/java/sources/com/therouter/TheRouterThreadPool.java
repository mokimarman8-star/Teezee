package com.therouter;

import android.os.Handler;
import android.os.Looper;
import com.google.protobuf.h1;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class TheRouterThreadPool {
    private static final int a;
    private static final int b;
    private static final int c;
    private static final int d;
    private static long e;
    private static int f;
    private static ExecutorService g;
    private static final Handler h;
    private static ThreadPoolExecutor i;

    public static final class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);
        final /* synthetic */ String b;

        a(String str) {
            this.b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Intrinsics.h(runnable, CampaignEx.JSON_KEY_AD_R);
            return new Thread(runnable, this.b + " #" + this.a.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        int max = Math.max(3, Math.min(availableProcessors - 1, 6));
        b = max;
        c = availableProcessors * 4;
        d = availableProcessors * 8;
        e = 30L;
        f = 10;
        g = new BufferExecutor();
        h = new Handler(Looper.getMainLooper());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, h1.READ_DONE, e, TimeUnit.SECONDS, new LinkedBlockingDeque(f), k("TheRouterLibThread"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        i = threadPoolExecutor;
    }

    public static final void f(Runnable runnable) {
        Intrinsics.h(runnable, "command");
        try {
            g.execute(runnable);
        } catch (Exception e2) {
            TheRouterKt.c("TheRouterThreadPool", "rejected execute runnable", new Function0<Unit>() { // from class: com.therouter.TheRouterThreadPool$execute$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m65invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m65invoke() {
                    e2.printStackTrace();
                }
            });
        }
    }

    public static final boolean g(Runnable runnable) {
        Intrinsics.h(runnable, "command");
        if (!Intrinsics.c(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            return h.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static final long h() {
        return e;
    }

    public static final int i() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb2.append(stackTraceElement);
            sb2.append('\n');
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        return sb3;
    }

    public static final ThreadFactory k(String str) {
        Intrinsics.h(str, "threadName");
        return new a(str);
    }
}
