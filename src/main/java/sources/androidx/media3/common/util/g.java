package androidx.media3.common.util;

import android.os.Looper;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final p f9057a;

    /* renamed from: b, reason: collision with root package name */
    private final p f9058b;

    /* renamed from: c, reason: collision with root package name */
    private final a f9059c;

    /* renamed from: d, reason: collision with root package name */
    private Object f9060d;

    /* renamed from: e, reason: collision with root package name */
    private Object f9061e;

    /* renamed from: f, reason: collision with root package name */
    private int f9062f;

    public interface a {
        void a(Object obj, Object obj2);
    }

    public g(Object obj, Looper looper, Looper looper2, i iVar, a aVar) {
        this.f9057a = iVar.createHandler(looper, null);
        this.f9058b = iVar.createHandler(looper2, null);
        this.f9060d = obj;
        this.f9061e = obj;
        this.f9059c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Object obj) {
        if (this.f9062f == 0) {
            k(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Object obj) {
        int i5 = this.f9062f - 1;
        this.f9062f = i5;
        if (i5 == 0) {
            k(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(com.google.common.base.f fVar) {
        final Object apply = fVar.apply(this.f9061e);
        this.f9061e = apply;
        this.f9058b.post(new Runnable() { // from class: androidx.media3.common.util.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.f(apply);
            }
        });
    }

    private void k(Object obj) {
        Object obj2 = this.f9060d;
        this.f9060d = obj;
        if (obj2.equals(obj)) {
            return;
        }
        this.f9059c.a(obj2, obj);
    }

    public Object d() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == this.f9058b.getLooper()) {
            return this.f9060d;
        }
        androidx.media3.common.util.a.g(myLooper == this.f9057a.getLooper());
        return this.f9061e;
    }

    public void h(Runnable runnable) {
        this.f9057a.post(runnable);
    }

    public void i(final Object obj) {
        this.f9061e = obj;
        this.f9058b.post(new Runnable() { // from class: androidx.media3.common.util.d
            @Override // java.lang.Runnable
            public final void run() {
                g.this.e(obj);
            }
        });
    }

    public void j(com.google.common.base.f fVar, final com.google.common.base.f fVar2) {
        androidx.media3.common.util.a.g(Looper.myLooper() == this.f9058b.getLooper());
        this.f9062f++;
        this.f9057a.post(new Runnable() { // from class: androidx.media3.common.util.e
            @Override // java.lang.Runnable
            public final void run() {
                g.this.g(fVar2);
            }
        });
        k(fVar.apply(this.f9060d));
    }
}
