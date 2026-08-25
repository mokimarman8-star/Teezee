package fl;

import fl.f;
import fl.h;
import java.io.File;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b implements h {
    private f a;
    private final e b = new e();
    private final i c = new i();
    private File d;
    private final long e;
    private final long f;

    protected b(File file, long j, long j2) {
        this.d = file;
        this.e = j;
        this.f = j2;
    }

    private f d() {
        if (this.a == null) {
            synchronized (b.class) {
                try {
                    if (this.a == null) {
                        File file = this.d;
                        if (file == null) {
                            file = kl.i.a(yj.a.a());
                        }
                        File file2 = file;
                        this.d = file2;
                        this.a = f.h(file2, 1, 1, this.e, this.f);
                    }
                } finally {
                }
            }
        }
        return this.a;
    }

    public File a(el.e eVar) {
        try {
            f.e p = d().p(this.c.a(eVar));
            if (p != null) {
                return p.a(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void b() {
        try {
            d().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void c(el.e eVar, h.a aVar) {
        this.b.a(eVar);
        String a = this.c.a(eVar);
        try {
            if (d().p(a) != null) {
                return;
            }
            f.c d = this.a.d(a);
            if (d == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Had two simultaneous puts for: ");
                sb.append(a);
                throw new IllegalStateException(sb.toString());
            }
            try {
                if (((j) aVar).a(d.b(0))) {
                    d.f();
                }
            } finally {
                d.d();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.b.b(eVar);
        }
    }
}
