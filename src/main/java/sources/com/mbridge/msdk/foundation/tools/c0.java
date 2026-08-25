package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c0 implements Executor {
    private Runnable a;
    private Runnable b;

    class a implements Runnable {
        final /* synthetic */ Runnable a;

        a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("LimitExecutor", e.getMessage());
                }
            } finally {
                c0.this.a();
            }
        }
    }

    private Runnable a(Runnable runnable) {
        return new a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.b;
        this.a = runnable;
        this.b = null;
        if (runnable != null) {
            a0.a().execute(this.a);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        try {
            if (this.a == null) {
                this.a = a(runnable);
                a0.a().execute(this.a);
            } else if (this.b == null) {
                this.b = a(runnable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
