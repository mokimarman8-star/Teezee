package com.tn.tranpay.report;

import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a implements ThreadFactory {
    public static final C0040a d = new C0040a(null);
    private static final AtomicInteger e = new AtomicInteger(1);
    private final ThreadGroup a;
    private final AtomicInteger b;
    private final String c;

    /* renamed from: com.tn.tranpay.report.a$a, reason: collision with other inner class name */
    public static final class C0040a {
        private C0040a() {
        }

        public /* synthetic */ C0040a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(String str) {
        ThreadGroup threadGroup;
        Intrinsics.h(str, OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_PRE);
        this.b = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
            Intrinsics.g(threadGroup, "s.threadGroup");
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
            Intrinsics.e(threadGroup);
        }
        this.a = threadGroup;
        this.c = str + "-pool-" + e.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Intrinsics.h(runnable, "r");
        Thread thread = new Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
