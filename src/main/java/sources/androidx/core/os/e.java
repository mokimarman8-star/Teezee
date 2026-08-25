package androidx.core.os;

import android.os.CancellationSignal;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7016a;

    /* renamed from: b, reason: collision with root package name */
    private a f7017b;

    /* renamed from: c, reason: collision with root package name */
    private Object f7018c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7019d;

    public interface a {
        void onCancel();
    }

    private void c() {
        while (this.f7019d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f7016a) {
                    return;
                }
                this.f7016a = true;
                this.f7019d = true;
                a aVar = this.f7017b;
                Object obj = this.f7018c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f7019d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f7019d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public void b(a aVar) {
        synchronized (this) {
            try {
                c();
                if (this.f7017b == aVar) {
                    return;
                }
                this.f7017b = aVar;
                if (this.f7016a && aVar != null) {
                    aVar.onCancel();
                }
            } finally {
            }
        }
    }
}
