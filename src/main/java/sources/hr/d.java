package hr;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final d a = new d();
    private static long b;
    private static int c;

    private d() {
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
