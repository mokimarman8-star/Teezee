package g7;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class e {
    private final long a;
    private final long b;
    private long c;
    private boolean d = false;
    private final Handler e = new a();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j;
            synchronized (e.this) {
                try {
                    if (e.this.d) {
                        return;
                    }
                    long elapsedRealtime = e.this.c - SystemClock.elapsedRealtime();
                    long j2 = 0;
                    if (elapsedRealtime <= 0) {
                        e.this.e();
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        e.this.f(elapsedRealtime);
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        if (elapsedRealtime < e.this.b) {
                            j = elapsedRealtime - elapsedRealtime3;
                            if (j < 0) {
                                sendMessageDelayed(obtainMessage(1), j2);
                            }
                        } else {
                            j = e.this.b - elapsedRealtime3;
                            while (j < 0) {
                                j += e.this.b;
                            }
                        }
                        j2 = j;
                        sendMessageDelayed(obtainMessage(1), j2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public e(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final synchronized void d() {
        this.d = true;
        this.e.removeMessages(1);
    }

    public abstract void e();

    public abstract void f(long j);

    public final synchronized e g() {
        this.d = false;
        if (this.a <= 0) {
            e();
            return this;
        }
        this.c = SystemClock.elapsedRealtime() + this.a;
        Handler handler = this.e;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
