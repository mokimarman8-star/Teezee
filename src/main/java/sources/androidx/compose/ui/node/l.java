package androidx.compose.ui.node;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class l {
    public static final int a(long j5, long j6) {
        boolean d5 = d(j5);
        return d5 != d(j6) ? d5 ? -1 : 1 : (int) Math.signum(c(j5) - c(j6));
    }

    public static long b(long j5) {
        return j5;
    }

    public static final float c(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    public static final boolean d(long j5) {
        return ((int) (j5 & 4294967295L)) != 0;
    }
}
