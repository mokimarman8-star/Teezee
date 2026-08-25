package xc;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b {
    private static final uc.a d = uc.a.e();
    private final String a;
    private final kc.b b;
    private t8.h c;

    b(kc.b bVar, String str) {
        this.a = str;
        this.b = bVar;
    }

    private boolean a() {
        if (this.c == null) {
            t8.i iVar = (t8.i) this.b.get();
            if (iVar != null) {
                this.c = iVar.b(this.a, com.google.firebase.perf.v1.g.class, t8.c.b("proto"), new t8.g() { // from class: xc.a
                    public final Object apply(Object obj) {
                        return ((com.google.firebase.perf.v1.g) obj).toByteArray();
                    }
                });
            } else {
                d.j("Flg TransportFactory is not available at the moment");
            }
        }
        return this.c != null;
    }

    public void b(com.google.firebase.perf.v1.g gVar) {
        if (a()) {
            this.c.a(t8.d.f(gVar));
        } else {
            d.j("Unable to dispatch event because Flg Transport is not available");
        }
    }
}
