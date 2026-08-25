package ij;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class x {
    public static final x a = new x();
    private static long b = -1;
    private static long c;

    private x() {
    }

    private final long a() {
        return System.currentTimeMillis();
    }

    private final long c(long j) {
        long a2 = a();
        while (a2 <= j) {
            a2 = a();
        }
        return a2;
    }

    public final synchronized long b() {
        long a2;
        try {
            a2 = a();
            long j = b;
            if (a2 < j) {
                throw new IllegalStateException(("系统时钟回拨，拒绝生成 ID（lastTimestamp=" + j + ", now=" + a2 + "）").toString());
            }
            if (a2 == j) {
                long j2 = (c + 1) & 4095;
                c = j2;
                if (j2 == 0) {
                    a2 = c(j);
                }
            } else {
                c = 0L;
            }
            b = a2;
        } catch (Throwable th2) {
            throw th2;
        }
        return ((a2 - 1704067200000L) << 22) | 4096 | c;
    }
}
