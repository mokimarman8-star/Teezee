package com.transsion.json.b;

import com.transsion.json.q;
import com.transsion.json.u;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class l extends a {
    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        com.transsion.json.h b = b();
        q x = b.x();
        com.transsion.json.f z = b.z();
        try {
            if (z.contains(obj)) {
                u A = b().A();
                if (A != null) {
                    A.a();
                    return;
                }
                return;
            }
            b.f(new com.transsion.json.f(z));
            b.z().add(obj);
            com.transsion.json.c a = com.transsion.json.c.a(c(obj));
            u H = b.H();
            for (com.transsion.json.d dVar : a != null ? a.c() : null) {
                x.a(dVar.e());
                if (b.n(dVar) && dVar.n().booleanValue()) {
                    Object a2 = dVar.a(obj);
                    if (!b.z().contains(a2)) {
                        g a3 = b.a(dVar, a2);
                        if (!(a3 instanceof g) || !a3.a().booleanValue()) {
                            if (H.e()) {
                                b.E();
                            }
                            H.d();
                            b.u(dVar.b());
                        }
                        H.b(dVar.b());
                        a3.a(a2);
                    }
                }
                x.d();
            }
            b.D();
            b.f((com.transsion.json.f) b.z().a());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }

    protected Class c(Object obj) {
        return obj.getClass();
    }
}
