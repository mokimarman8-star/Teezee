package el;

import com.transsion.http.impl.r;
import fl.h;
import il.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b {
    private hl.a a = new hl.a();
    private h b;
    private final il.e c;

    public b(il.c cVar) {
        this.c = cVar.c();
    }

    public void a(r rVar) {
        this.a.a(this, rVar);
    }

    public h b() {
        if (this.c.e() != null) {
            this.b = new fl.c(this.c.e()).a(a.b <= 0 ? 104857600L : r1 * 1048576, a.a <= 0 ? 864000000L : r3 * 3600000);
        }
        return this.b;
    }

    public il.e c() {
        return this.c;
    }

    public f d() {
        return new f(this.c);
    }
}
