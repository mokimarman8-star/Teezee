package com.transsion.athena.hatnea;

import android.text.TextUtils;
import androidx.core.util.j;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena {
    private static volatile athena a;
    private final Deque<anateh> b = new ArrayDeque();
    private ThreadPoolExecutor c;

    private static class aethna implements ThreadFactory {
        private aethna() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Athena Dispatcher");
            thread.setDaemon(false);
            return thread;
        }
    }

    private athena() {
    }

    public static athena a() {
        if (a == null) {
            synchronized (athena.class) {
                try {
                    if (a == null) {
                        a = new athena();
                    }
                } finally {
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(String str, anateh anatehVar) {
        return TextUtils.equals(anatehVar.b(), str);
    }

    private synchronized boolean c() {
        return com.transsion.athena.config.data.model.anehat.a(this.b, new j() { // from class: com.transsion.athena.hatnea.c
            public final boolean a(Object obj) {
                boolean c;
                c = athena.c((anateh) obj);
                return c;
            }
        }) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(anateh anatehVar) {
        return anatehVar instanceof atenha;
    }

    public synchronized int a(final String str) {
        return com.transsion.athena.config.data.model.anehat.a(this.b, new j() { // from class: com.transsion.athena.hatnea.b
            public final boolean a(Object obj) {
                boolean a2;
                a2 = athena.a(str, (anateh) obj);
                return a2;
            }
        });
    }

    public synchronized void a(anateh anatehVar) {
        if (a(anatehVar.b()) <= 0 && !c()) {
            this.b.add(anatehVar);
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.c = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new aethna());
                    }
                    this.c.execute(anatehVar);
                } finally {
                }
            }
        }
    }

    public void b() {
        enatha enathaVar;
        Thread thread;
        for (anateh anatehVar : this.b) {
            if ((anatehVar instanceof enatha) && (thread = (enathaVar = (enatha) anatehVar).b) != null && !thread.isInterrupted()) {
                enathaVar.b.interrupt();
            }
        }
    }

    public synchronized void b(anateh anatehVar) {
        this.b.remove(anatehVar);
    }
}
