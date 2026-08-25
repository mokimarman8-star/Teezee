package com.google.common.util.concurrent;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class AbstractScheduledService {
    private static final q a = new q(AbstractScheduledService.class);

    private final class ServiceDelegate extends b {

        class Task implements Runnable {
            final /* synthetic */ ServiceDelegate this$1;

            Task(ServiceDelegate serviceDelegate) {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.c(null).lock();
                try {
                    ServiceDelegate.d(null);
                    throw null;
                } catch (Throwable th) {
                    try {
                        w.b(th);
                        try {
                            throw null;
                        } catch (Exception e) {
                            w.b(e);
                            AbstractScheduledService.a.a().log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e);
                            throw null;
                        }
                    } catch (Throwable th2) {
                        ServiceDelegate.c(null).unlock();
                        throw th2;
                    }
                }
            }
        }

        static /* synthetic */ ReentrantLock c(ServiceDelegate serviceDelegate) {
            throw null;
        }

        static /* synthetic */ a d(ServiceDelegate serviceDelegate) {
            throw null;
        }
    }

    interface a {
    }
}
