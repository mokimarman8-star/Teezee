package ls;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final c a = new c();
    private static long b;
    private static int c;

    private c() {
    }

    public final boolean a(int i, long j) {
        if (c != i) {
            c = i;
            b = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - b <= j) {
            return true;
        }
        c = i;
        b = System.currentTimeMillis();
        return false;
    }
}
