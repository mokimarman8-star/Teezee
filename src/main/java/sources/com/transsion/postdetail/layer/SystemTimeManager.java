package com.transsion.postdetail.layer;

import android.os.Handler;
import android.os.HandlerThread;
import com.transsion.postdetail.layer.SystemTimeManager;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SystemTimeManager {
    private Handler a;
    private a b;
    private boolean c;
    private final HandlerThread d;
    private final Runnable e;

    public interface a {
        long a();
    }

    public SystemTimeManager(a aVar) {
        HandlerThread handlerThread = new HandlerThread("SystemTimeManager");
        this.d = handlerThread;
        this.e = new Runnable() { // from class: com.transsion.postdetail.layer.SystemTimeManager$mTrackingRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                SystemTimeManager.a aVar2;
                SystemTimeManager.a aVar3;
                Handler handler;
                aVar2 = SystemTimeManager.this.b;
                if (aVar2 == null) {
                    SystemTimeManager.this.e();
                    return;
                }
                aVar3 = SystemTimeManager.this.b;
                Long valueOf = aVar3 != null ? Long.valueOf(aVar3.a()) : null;
                if (valueOf != null) {
                    if (valueOf.longValue() <= 0) {
                        SystemTimeManager.this.e();
                        return;
                    }
                    handler = SystemTimeManager.this.a;
                    if (handler != null) {
                        handler.postDelayed(this, valueOf.longValue());
                    }
                }
            }
        };
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper());
        this.b = aVar;
    }

    public final void c() {
        e();
        this.c = false;
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.a = null;
        this.b = null;
        this.d.quitSafely();
    }

    public final void d() {
        if (this.c) {
            return;
        }
        this.c = true;
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacks(this.e);
        }
        Handler handler2 = this.a;
        if (handler2 != null) {
            handler2.post(this.e);
        }
    }

    public final void e() {
        if (this.c) {
            this.c = false;
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacks(this.e);
            }
        }
    }
}
