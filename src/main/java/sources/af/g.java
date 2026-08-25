package af;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g implements com.google.zxing.l {
    private com.google.zxing.i a;
    private List b = new ArrayList();

    public g(com.google.zxing.i iVar) {
        this.a = iVar;
    }

    @Override // com.google.zxing.l
    public void a(com.google.zxing.k kVar) {
        this.b.add(kVar);
    }

    protected com.google.zxing.j b(com.google.zxing.b bVar) {
        this.b.clear();
        try {
            com.google.zxing.i iVar = this.a;
            if (iVar instanceof com.google.zxing.f) {
                com.google.zxing.j d = ((com.google.zxing.f) iVar).d(bVar);
                this.a.reset();
                return d;
            }
            com.google.zxing.j b = iVar.b(bVar);
            this.a.reset();
            return b;
        } catch (Exception unused) {
            this.a.reset();
            return null;
        } catch (Throwable th) {
            this.a.reset();
            throw th;
        }
    }

    public com.google.zxing.j c(com.google.zxing.e eVar) {
        return b(e(eVar));
    }

    public List d() {
        return new ArrayList(this.b);
    }

    protected com.google.zxing.b e(com.google.zxing.e eVar) {
        return new com.google.zxing.b(new kd.l(eVar));
    }
}
