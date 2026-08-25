package ij;

import android.content.Context;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u {
    public static final u a = new u();
    private static Boolean b;

    private u() {
    }

    private final int b() {
        int[][] iArr = {new int[]{96, 254, 214, 116}, new int[]{248, 205, 47, 126}, new int[]{209, 73, 255, 72}, new int[]{23, 82, 81, 99}};
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 : iArr[i2]) {
                i = (i << 1) ^ i3;
            }
        }
        return i;
    }

    private final int c(String str) {
        int i = 0;
        int c = ProgressionUtilKt.c(0, str.length() - 1, 2);
        if (c < 0) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i + 2;
            String substring = str.substring(i, i3);
            Intrinsics.g(substring, "substring(...)");
            i2 = (i2 << 1) ^ Integer.parseInt(substring, CharsKt.a(16));
            if (i == c) {
                return i2;
            }
            i = i3;
        }
    }

    public final boolean a(Context context) {
        Intrinsics.h(context, "context");
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = c(r.a.a(context)) == b();
        b = Boolean.valueOf(z);
        return z;
    }
}
