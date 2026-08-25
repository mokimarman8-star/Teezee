package com.cloud.hisavana.sdk.common.tranmeasure;

import android.os.Handler;
import android.os.Looper;
import com.cloud.hisavana.sdk.b4;
import com.cloud.hisavana.sdk.common.tranmeasure.f;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b extends Monitor {
    private volatile Handler a = null;
    private boolean b = false;
    private final f c;
    private final f.a d;
    private final Runnable e;
    private final Runnable f;

    class a implements f.a {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.f.a
        public void a(boolean z) {
            if (z) {
                b.this.a();
            } else {
                b.this.c();
            }
        }
    }

    /* renamed from: com.cloud.hisavana.sdk.common.tranmeasure.b$b, reason: collision with other inner class name */
    class RunnableC0124b implements Runnable {
        RunnableC0124b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.b) {
                e.c().i();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.b || b.this.a == null) {
                return;
            }
            b.this.a.post(b.this.e);
            b.this.a.postDelayed(b.this.f, 200L);
        }
    }

    protected b() {
        a aVar = new a();
        this.d = aVar;
        this.e = new RunnableC0124b();
        this.f = new c();
        f fVar = new f();
        this.c = fVar;
        fVar.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (Looper.myLooper() == null) {
                return;
            }
            this.b = true;
            if (this.a == null) {
                this.a = new Handler(Looper.myLooper());
            }
            if (this.a != null) {
                this.a.post(this.e);
                this.a.postDelayed(this.f, 200L);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.b = false;
        if (this.a != null) {
            this.a.removeCallbacks(this.f);
            this.a = null;
        }
    }

    @Override // com.cloud.hisavana.sdk.common.tranmeasure.Monitor
    public void end() {
        try {
            b4.b().d("ssp_measure", "stop monitor");
            this.b = false;
            f fVar = this.c;
            if (fVar != null) {
                fVar.b();
            }
            c();
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.hisavana.sdk.common.tranmeasure.Monitor
    public void start() {
        if (this.b && this.a != null && this.a.hasMessages(0)) {
            b4.b().d("ssp_measure", "monitor is running");
            return;
        }
        b4.b().d("ssp_measure", "start monitor");
        a();
        this.c.c(this.d);
        this.c.h();
    }
}
