package x4;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g implements ThreadFactory {

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f18494d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f18495a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f18496b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    private final String f18497c;

    public g() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f18495a = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
        this.f18497c = "lottie-" + f18494d.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f18495a, runnable, this.f18497c + this.f18496b.getAndIncrement(), 0L);
        thread.setDaemon(false);
        thread.setPriority(10);
        return thread;
    }
}
