package androidx.media3.common.util;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final i f9081a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9082b;

    public l() {
        this(i.f9063a);
    }

    public l(i iVar) {
        this.f9081a = iVar;
    }

    public synchronized void a() {
        while (!this.f9082b) {
            wait();
        }
    }

    public synchronized boolean b(long j5) {
        if (j5 <= 0) {
            return this.f9082b;
        }
        long elapsedRealtime = this.f9081a.elapsedRealtime();
        long j6 = j5 + elapsedRealtime;
        if (j6 < elapsedRealtime) {
            a();
        } else {
            while (!this.f9082b && elapsedRealtime < j6) {
                wait(j6 - elapsedRealtime);
                elapsedRealtime = this.f9081a.elapsedRealtime();
            }
        }
        return this.f9082b;
    }

    public synchronized void c() {
        boolean z5 = false;
        while (!this.f9082b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z5 = true;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean d() {
        boolean z5;
        z5 = this.f9082b;
        this.f9082b = false;
        return z5;
    }

    public synchronized boolean e() {
        return this.f9082b;
    }

    public synchronized boolean f() {
        if (this.f9082b) {
            return false;
        }
        this.f9082b = true;
        notifyAll();
        return true;
    }
}
