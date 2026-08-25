package androidx.compose.ui.text;

import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c0 {
    public static final long a(int i5) {
        return b(i5, i5);
    }

    public static final long b(int i5, int i6) {
        return b0.c(d(i5, i6));
    }

    public static final long c(long j5, int i5, int i6) {
        int l5 = RangesKt.l(b0.k(j5), i5, i6);
        int l6 = RangesKt.l(b0.g(j5), i5, i6);
        return (l5 == b0.k(j5) && l6 == b0.g(j5)) ? j5 : b(l5, l6);
    }

    private static final long d(int i5, int i6) {
        if (i5 < 0) {
            throw new IllegalArgumentException(("start cannot be negative. [start: " + i5 + ", end: " + i6 + ']').toString());
        }
        if (i6 >= 0) {
            return (i6 & 4294967295L) | (i5 << 32);
        }
        throw new IllegalArgumentException(("end cannot be negative. [start: " + i5 + ", end: " + i6 + ']').toString());
    }
}
