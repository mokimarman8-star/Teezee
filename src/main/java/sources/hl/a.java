package hl;

import com.transsion.core.pool.b;
import com.transsion.http.c;
import com.transsion.http.impl.r;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a {
    private b a = com.transsion.core.pool.a.b();
    private List b = Collections.synchronizedList(new LinkedList());

    public void a(el.b bVar, r rVar) {
        c cVar = new c(bVar, rVar);
        if (bVar.c().m() != null) {
            this.b.add(cVar);
        }
        this.a.a(cVar);
    }
}
