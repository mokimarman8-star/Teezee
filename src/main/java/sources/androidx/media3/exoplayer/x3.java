package androidx.media3.exoplayer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract /* synthetic */ class x3 {
    public static int a(int i5) {
        return c(i5, 0, 0, 0);
    }

    public static int b(int i5, int i6, int i7) {
        return e(i5, i6, i7, 0, 128, 0);
    }

    public static int c(int i5, int i6, int i7, int i8) {
        return e(i5, i6, i7, 0, 128, i8);
    }

    public static int d(int i5, int i6, int i7, int i8, int i9) {
        return e(i5, i6, i7, i8, i9, 0);
    }

    public static int e(int i5, int i6, int i7, int i8, int i9, int i10) {
        return i5 | i6 | i7 | i8 | i9 | i10;
    }

    public static int f(int i5) {
        return i5 & 24;
    }

    public static int g(int i5) {
        return i5 & 3584;
    }

    public static int h(int i5) {
        return i5 & 384;
    }

    public static int i(int i5) {
        return i5 & 7;
    }

    public static int j(int i5) {
        return i5 & 64;
    }

    public static int k(int i5) {
        return i5 & 32;
    }

    public static boolean l(int i5, boolean z5) {
        int i6 = i(i5);
        return i6 == 4 || (z5 && i6 == 3);
    }
}
