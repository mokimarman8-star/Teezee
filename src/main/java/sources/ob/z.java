package ob;

import kc.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class z implements kc.b, kc.a {
    private static final a.InterfaceC0189a c = new a.InterfaceC0189a() { // from class: ob.w
        @Override // kc.a.InterfaceC0189a
        public final void a(kc.b bVar) {
            z.f(bVar);
        }
    };
    private static final kc.b d = new kc.b() { // from class: ob.x
        @Override // kc.b
        public final Object get() {
            Object g;
            g = z.g();
            return g;
        }
    };
    private a.InterfaceC0189a a;
    private volatile kc.b b;

    private z(a.InterfaceC0189a interfaceC0189a, kc.b bVar) {
        this.a = interfaceC0189a;
        this.b = bVar;
    }

    static z e() {
        return new z(c, d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(kc.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(a.InterfaceC0189a interfaceC0189a, a.InterfaceC0189a interfaceC0189a2, kc.b bVar) {
        interfaceC0189a.a(bVar);
        interfaceC0189a2.a(bVar);
    }

    static z i(kc.b bVar) {
        return new z(null, bVar);
    }

    @Override // kc.a
    public void a(final a.InterfaceC0189a interfaceC0189a) {
        kc.b bVar;
        kc.b bVar2;
        kc.b bVar3 = this.b;
        kc.b bVar4 = d;
        if (bVar3 != bVar4) {
            interfaceC0189a.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                final a.InterfaceC0189a interfaceC0189a2 = this.a;
                this.a = new a.InterfaceC0189a() { // from class: ob.y
                    @Override // kc.a.InterfaceC0189a
                    public final void a(kc.b bVar5) {
                        z.h(a.InterfaceC0189a.this, interfaceC0189a, bVar5);
                    }
                };
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            interfaceC0189a.a(bVar);
        }
    }

    @Override // kc.b
    public Object get() {
        return this.b.get();
    }

    void j(kc.b bVar) {
        a.InterfaceC0189a interfaceC0189a;
        if (this.b != d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC0189a = this.a;
            this.a = null;
            this.b = bVar;
        }
        interfaceC0189a.a(bVar);
    }
}
