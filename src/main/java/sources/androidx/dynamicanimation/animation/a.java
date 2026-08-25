package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.x0;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class a {

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f7807g = new ThreadLocal();

    /* renamed from: d, reason: collision with root package name */
    private c f7811d;

    /* renamed from: a, reason: collision with root package name */
    private final x0 f7808a = new x0();

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f7809b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final C0058a f7810c = new C0058a();

    /* renamed from: e, reason: collision with root package name */
    long f7812e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7813f = false;

    /* renamed from: androidx.dynamicanimation.animation.a$a, reason: collision with other inner class name */
    class C0058a {
        C0058a() {
        }

        void a() {
            a.this.f7812e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f7812e);
            if (a.this.f7809b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    interface b {
        boolean a(long j5);
    }

    static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final C0058a f7815a;

        c(C0058a c0058a) {
            this.f7815a = c0058a;
        }

        abstract void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d extends c {

        /* renamed from: b, reason: collision with root package name */
        long f7816b;
    }

    private static class e extends c {

        /* renamed from: b, reason: collision with root package name */
        private final Choreographer f7817b;

        /* renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f7818c;

        /* renamed from: androidx.dynamicanimation.animation.a$e$a, reason: collision with other inner class name */
        class ChoreographerFrameCallbackC0059a implements Choreographer.FrameCallback {
            ChoreographerFrameCallbackC0059a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j5) {
                e.this.f7815a.a();
            }
        }

        e(C0058a c0058a) {
            super(c0058a);
            this.f7817b = Choreographer.getInstance();
            this.f7818c = new ChoreographerFrameCallbackC0059a();
        }

        @Override // androidx.dynamicanimation.animation.a.c
        void a() {
            this.f7817b.postFrameCallback(this.f7818c);
        }
    }

    a() {
    }

    private void b() {
        if (this.f7813f) {
            for (int size = this.f7809b.size() - 1; size >= 0; size--) {
                if (this.f7809b.get(size) == null) {
                    this.f7809b.remove(size);
                }
            }
            this.f7813f = false;
        }
    }

    public static a d() {
        ThreadLocal threadLocal = f7807g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return (a) threadLocal.get();
    }

    private boolean f(b bVar, long j5) {
        Long l5 = (Long) this.f7808a.get(bVar);
        if (l5 == null) {
            return true;
        }
        if (l5.longValue() >= j5) {
            return false;
        }
        this.f7808a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j5) {
        if (this.f7809b.size() == 0) {
            e().a();
        }
        if (!this.f7809b.contains(bVar)) {
            this.f7809b.add(bVar);
        }
        if (j5 > 0) {
            this.f7808a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j5));
        }
    }

    void c(long j5) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i5 = 0; i5 < this.f7809b.size(); i5++) {
            b bVar = (b) this.f7809b.get(i5);
            if (bVar != null && f(bVar, uptimeMillis)) {
                bVar.a(j5);
            }
        }
        b();
    }

    c e() {
        if (this.f7811d == null) {
            this.f7811d = new e(this.f7810c);
        }
        return this.f7811d;
    }

    public void g(b bVar) {
        this.f7808a.remove(bVar);
        int indexOf = this.f7809b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f7809b.set(indexOf, null);
            this.f7813f = true;
        }
    }
}
