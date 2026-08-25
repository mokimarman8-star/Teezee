package nz;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b implements c {
    private c a;

    public b() {
    }

    public b(c cVar) {
        a(cVar);
    }

    public void a(c cVar) {
        if (this.a != null) {
            throw new IllegalStateException("The Not ResourceSelector accepts a single nested ResourceSelector");
        }
        this.a = cVar;
    }
}
