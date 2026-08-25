package kl;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class h extends g {
    private final Object c;

    public h(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // kl.g, kl.f
    public Object acquire() {
        Object acquire;
        synchronized (this.c) {
            acquire = super.acquire();
        }
        return acquire;
    }

    @Override // kl.g, kl.f
    public boolean release(Object obj) {
        boolean release;
        synchronized (this.c) {
            release = super.release(obj);
        }
        return release;
    }
}
