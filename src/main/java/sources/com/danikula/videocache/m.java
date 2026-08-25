package com.danikula.videocache;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class m {
    private final a a;
    protected volatile boolean e;
    private volatile boolean f;
    private volatile boolean h;
    private final Object b = new Object();
    private final Object c = new Object();
    private volatile int d = -1;
    private volatile long g = -1;

    public m(a aVar) {
        this.a = (a) l.c(aVar);
        aVar.F(this);
    }

    private void h() {
        synchronized (this.b) {
            try {
                this.f = true;
                this.b.wait(1000L);
                this.f = false;
            } finally {
            }
        }
    }

    public void a(long j) {
        this.a.E(j);
        this.a.C(j);
    }

    public boolean b() {
        return this.f;
    }

    public void c() {
        synchronized (this.b) {
            q.c("-------get new data, notify wait~");
            this.f = false;
            this.b.notifyAll();
        }
    }

    public int d(byte[] bArr, long j, int i, String str) {
        n.a(bArr, j, i);
        while (!this.a.isCompleted() && !this.a.H(j, i, str) && !this.e) {
            this.h = true;
            h();
        }
        if (this.h) {
            q.e("isWaited， isAvailable = " + this.a.H(j, i, str) + " ,offset = " + j);
        }
        this.h = false;
        int D = this.a.D(bArr, j, i, str);
        if (D > 0) {
            com.transsnet.downloader.util.h.a.b("4");
        }
        if (this.g < 0 || (j - this.g > 512000 && D > 0)) {
            this.g = j;
            q.f("ProxyCache read， isCompleted = " + this.a.isCompleted() + " ,offset = " + j);
        }
        return D;
    }

    public void e() {
        synchronized (this.c) {
            q.a("Shutdown proxy");
            try {
                this.e = true;
                this.a.close();
            } catch (Throwable th) {
                q.a("Shutdown proxy, error = " + th);
            }
        }
    }

    public void f() {
        q.e("----start");
        this.e = false;
    }

    public void g() {
        q.e("--stop");
        this.e = true;
        c();
    }
}
