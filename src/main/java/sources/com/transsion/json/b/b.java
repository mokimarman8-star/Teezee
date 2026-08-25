package com.transsion.json.b;

import com.transsion.json.u;
import java.lang.reflect.Array;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class b extends a {
    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        u G = b().G();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            if (G.e()) {
                b().E();
            }
            G.d();
            b().j(Array.get(obj, i));
        }
        b().C();
    }
}
