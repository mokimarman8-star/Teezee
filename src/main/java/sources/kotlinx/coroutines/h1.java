package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class h1 {
    private static final kotlinx.coroutines.internal.z a = new kotlinx.coroutines.internal.z("REMOVED_TASK");
    private static final kotlinx.coroutines.internal.z b = new kotlinx.coroutines.internal.z("CLOSED_EMPTY");

    public static final long c(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}
