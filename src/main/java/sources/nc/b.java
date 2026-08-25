package nc;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b implements a {
    private static b a;

    private b() {
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    @Override // nc.a
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
