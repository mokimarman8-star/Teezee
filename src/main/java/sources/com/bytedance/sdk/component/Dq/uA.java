package com.bytedance.sdk.component.Dq;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uA implements ThreadFactory {
    public static final String THREAD_GROUP_NAME_PRE = "csj_g_";
    public static final String THREAD_NAME_PRE = "csj_";
    public static volatile boolean sCrashHappened;
    private final AtomicInteger EjP;
    protected final ThreadGroup Sj;
    protected int TKC;
    protected final String sP;

    public uA(int i, String str) {
        this.EjP = new AtomicInteger(1);
        this.TKC = i;
        this.Sj = new ThreadGroup(THREAD_GROUP_NAME_PRE.concat(String.valueOf(str)));
        this.sP = THREAD_NAME_PRE.concat(String.valueOf(str));
    }

    public uA(String str) {
        this(5, str);
    }

    protected Thread Sj(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        if (sCrashHappened) {
            return null;
        }
        Thread Sj = Sj(this.Sj, runnable, this.sP + this.EjP.getAndIncrement());
        if (Sj.isDaemon()) {
            Sj.setDaemon(false);
        }
        int i = this.TKC;
        if (i > 10 || i <= 0) {
            this.TKC = 5;
        }
        Sj.setPriority(this.TKC);
        return Sj;
    }
}
