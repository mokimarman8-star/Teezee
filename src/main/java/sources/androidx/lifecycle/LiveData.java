package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import j.c;
import java.util.Iterator;
import java.util.Map;
import k.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class LiveData {
    static final Object k = new Object();
    final Object a;
    private k.b b;
    int c;
    private boolean d;
    private volatile Object e;
    volatile Object f;
    private int g;
    private boolean h;
    private boolean i;
    private final Runnable j;

    class b extends c implements r {
        final u e;

        b(u uVar, c0 c0Var) {
            super(LiveData.this, c0Var);
            this.e = uVar;
        }

        void b() {
            this.e.getLifecycle().d(this);
        }

        boolean c(u uVar) {
            return this.e == uVar;
        }

        boolean d() {
            return this.e.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED);
        }

        public void onStateChanged(u uVar, Lifecycle.Event event) {
            Lifecycle.State b = this.e.getLifecycle().b();
            if (b == Lifecycle.State.DESTROYED) {
                LiveData.this.o(((c) this).a);
                return;
            }
            Lifecycle.State state = null;
            while (state != b) {
                a(d());
                state = b;
                b = this.e.getLifecycle().b();
            }
        }
    }

    public LiveData() {
        this.a = new Object();
        this.b = new k.b();
        this.c = 0;
        Object obj = k;
        this.f = obj;
        this.j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.a) {
                    obj2 = LiveData.this.f;
                    LiveData.this.f = LiveData.k;
                }
                LiveData.this.q(obj2);
            }
        };
        this.e = obj;
        this.g = -1;
    }

    public LiveData(Object obj) {
        this.a = new Object();
        this.b = new k.b();
        this.c = 0;
        this.f = k;
        this.j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.a) {
                    obj2 = LiveData.this.f;
                    LiveData.this.f = LiveData.k;
                }
                LiveData.this.q(obj2);
            }
        };
        this.e = obj;
        this.g = 0;
    }

    static void b(String str) {
        if (c.h().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void d(c cVar) {
        if (cVar.b) {
            if (!cVar.d()) {
                cVar.a(false);
                return;
            }
            int i = cVar.c;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            cVar.c = i2;
            cVar.a.onChanged(this.e);
        }
    }

    void c(int i) {
        int i2 = this.c;
        this.c = i + i2;
        if (this.d) {
            return;
        }
        this.d = true;
        while (true) {
            try {
                int i3 = this.c;
                if (i2 == i3) {
                    this.d = false;
                    return;
                }
                boolean z = i2 == 0 && i3 > 0;
                boolean z2 = i2 > 0 && i3 == 0;
                if (z) {
                    l();
                } else if (z2) {
                    m();
                }
                i2 = i3;
            } catch (Throwable th) {
                this.d = false;
                throw th;
            }
        }
    }

    void e(c cVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (cVar != null) {
                d(cVar);
                cVar = null;
            } else {
                b.d c = this.b.c();
                while (c.hasNext()) {
                    d((c) ((Map.Entry) c.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public Object f() {
        Object obj = this.e;
        if (obj != k) {
            return obj;
        }
        return null;
    }

    int g() {
        return this.g;
    }

    public boolean h() {
        return this.c > 0;
    }

    public boolean i() {
        return this.e != k;
    }

    public void j(u uVar, c0 c0Var) {
        b("observe");
        if (uVar.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            return;
        }
        t bVar = new b(uVar, c0Var);
        c cVar = (c) this.b.g(c0Var, bVar);
        if (cVar != null && !cVar.c(uVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        uVar.getLifecycle().a(bVar);
    }

    public void k(c0 c0Var) {
        b("observeForever");
        a aVar = new a(this, c0Var);
        c cVar = (c) this.b.g(c0Var, aVar);
        if (cVar instanceof b) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        aVar.a(true);
    }

    protected void l() {
    }

    protected void m() {
    }

    protected void n(Object obj) {
        boolean z;
        synchronized (this.a) {
            z = this.f == k;
            this.f = obj;
        }
        if (z) {
            c.h().d(this.j);
        }
    }

    public void o(c0 c0Var) {
        b("removeObserver");
        c cVar = (c) this.b.i(c0Var);
        if (cVar == null) {
            return;
        }
        cVar.b();
        cVar.a(false);
    }

    public void p(u uVar) {
        b("removeObservers");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (((c) entry.getValue()).c(uVar)) {
                o((c0) entry.getKey());
            }
        }
    }

    protected void q(Object obj) {
        b("setValue");
        this.g++;
        this.e = obj;
        e(null);
    }
}
