package androidx.media3.common.util;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class k0 {
    public static int a(int i5, int i6) {
        for (int i7 = 1; i7 <= 2; i7++) {
            int i8 = (i5 + i7) % 3;
            if (b(i8, i6)) {
                return i8;
            }
        }
        return i5;
    }

    public static boolean b(int i5, int i6) {
        if (i5 != 0) {
            return i5 != 1 ? i5 == 2 && (i6 & 2) != 0 : (i6 & 1) != 0;
        }
        return true;
    }
}
