package qu;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public final c a() {
        c cVar = c.e;
        if (cVar == null) {
            synchronized (this) {
                cVar = c.e;
                if (cVar == null) {
                    cVar = new c();
                    c.e = cVar;
                }
            }
        }
        return cVar;
    }
}
