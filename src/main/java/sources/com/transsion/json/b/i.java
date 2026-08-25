package com.transsion.json.b;

import com.transsion.json.q;
import com.transsion.json.u;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class i extends a {
    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        com.transsion.json.h b = b();
        q x = b.x();
        Map map = (Map) obj;
        try {
            u H = b().H();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                Object next = it.next();
                x.a(next != null ? next.toString() : null);
                if (b.o(next != null ? next.toString() : null, map.get(next))) {
                    g a = b.a(null, map.get(next));
                    if (!(a instanceof g) || !a.a().booleanValue()) {
                        if (H.e()) {
                            b().E();
                        }
                        H.d();
                        if (next != null) {
                            b().u(next.toString());
                        } else {
                            b().u(null);
                        }
                    }
                    if (next != null) {
                        H.b(next.toString());
                    } else {
                        H.b(null);
                    }
                    a.a(map.get(next));
                }
                x.d();
            }
            b().D();
        } catch (Exception e) {
            throw new com.transsion.json.k(String.format("%s: Error while trying to serialize.", x), e);
        }
    }
}
