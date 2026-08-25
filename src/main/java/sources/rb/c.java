package rb;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import qb.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c implements b, a {
    private final e a;
    private final int b;
    private final TimeUnit c;
    private CountDownLatch e;
    private final Object d = new Object();
    private boolean f = false;

    public c(e eVar, int i, TimeUnit timeUnit) {
        this.a = eVar;
        this.b = i;
        this.c = timeUnit;
    }

    @Override // rb.a
    public void a(String str, Bundle bundle) {
        synchronized (this.d) {
            try {
                g.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.e = new CountDownLatch(1);
                this.f = false;
                this.a.a(str, bundle);
                g.f().i("Awaiting app exception callback from Analytics...");
                try {
                    if (this.e.await(this.b, this.c)) {
                        this.f = true;
                        g.f().i("App exception callback received from Analytics listener.");
                    } else {
                        g.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    g.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.e = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // rb.b
    public void c(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
