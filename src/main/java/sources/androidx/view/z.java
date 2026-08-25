package androidx.view;

import java.util.Iterator;
import java.util.Map;
import k.b;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class z extends b0 {

    /* renamed from: l, reason: collision with root package name */
    private b f8374l;

    private static class a implements c0 {

        /* renamed from: a, reason: collision with root package name */
        final LiveData f8375a;

        /* renamed from: b, reason: collision with root package name */
        final c0 f8376b;

        /* renamed from: c, reason: collision with root package name */
        int f8377c = -1;

        a(LiveData liveData, c0 c0Var) {
            this.f8375a = liveData;
            this.f8376b = c0Var;
        }

        void a() {
            this.f8375a.k(this);
        }

        void b() {
            this.f8375a.o(this);
        }

        @Override // androidx.view.c0
        public void onChanged(Object obj) {
            if (this.f8377c != this.f8375a.g()) {
                this.f8377c = this.f8375a.g();
                this.f8376b.onChanged(obj);
            }
        }
    }

    public z() {
        this.f8374l = new b();
    }

    public z(Object obj) {
        super(obj);
        this.f8374l = new b();
    }

    protected void l() {
        Iterator it = this.f8374l.iterator();
        while (it.hasNext()) {
            ((a) ((Map.Entry) it.next()).getValue()).a();
        }
    }

    protected void m() {
        Iterator it = this.f8374l.iterator();
        while (it.hasNext()) {
            ((a) ((Map.Entry) it.next()).getValue()).b();
        }
    }

    public void r(LiveData liveData, c0 c0Var) {
        if (liveData == null) {
            throw new NullPointerException("source cannot be null");
        }
        a aVar = new a(liveData, c0Var);
        a aVar2 = (a) this.f8374l.g(liveData, aVar);
        if (aVar2 != null && aVar2.f8376b != c0Var) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (aVar2 == null && h()) {
            aVar.a();
        }
    }
}
