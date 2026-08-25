package qo;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b {
    public static int[] a(Context context, int i, int i2, int i3, int i4) {
        return b(context, i, i2, i3, i4, 0.72f);
    }

    public static int[] b(Context context, int i, int i2, int i3, int i4, float f) {
        if (i3 == 0) {
            i3 = zg.h.a.e(context);
        }
        if (i4 == 0) {
            i4 = zg.h.a.c(context);
        }
        float f2 = ((i * 1.0f) / i2) * 1.0f;
        int i5 = (int) (f2 < 1.0f ? i3 * f : i3 * 0.92f);
        int i6 = (int) (i5 / f2);
        int i7 = (int) (i4 * f);
        if (i6 > i7) {
            i5 = (int) (i7 * f2);
            i6 = i7;
        }
        return new int[]{i5, i6};
    }
}
