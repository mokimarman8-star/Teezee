package androidx.media3.common.util;

import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    private long f9112a;

    /* renamed from: b, reason: collision with root package name */
    private long f9113b;

    /* renamed from: c, reason: collision with root package name */
    private long f9114c;

    /* renamed from: d, reason: collision with root package name */
    private final ThreadLocal f9115d = new ThreadLocal();

    public p0(long j5) {
        i(j5);
    }

    public static long h(long j5) {
        return a1.e1(j5, 1000000L, 90000L);
    }

    public static long k(long j5) {
        return a1.e1(j5, 90000L, 1000000L);
    }

    public static long l(long j5) {
        return k(j5) % 8589934592L;
    }

    public synchronized long a(long j5) {
        if (j5 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (!g()) {
                long j6 = this.f9112a;
                if (j6 == 9223372036854775806L) {
                    j6 = ((Long) a.e((Long) this.f9115d.get())).longValue();
                }
                this.f9113b = j6 - j5;
                notifyAll();
            }
            this.f9114c = j5;
            return j5 + this.f9113b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long b(long j5) {
        if (j5 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j6 = this.f9114c;
            if (j6 != -9223372036854775807L) {
                long k5 = k(j6);
                long j7 = (4294967296L + k5) / 8589934592L;
                long j8 = ((j7 - 1) * 8589934592L) + j5;
                j5 += j7 * 8589934592L;
                if (Math.abs(j8 - k5) < Math.abs(j5 - k5)) {
                    j5 = j8;
                }
            }
            return a(h(j5));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long c(long j5) {
        if (j5 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j6 = this.f9114c;
        if (j6 != -9223372036854775807L) {
            long k5 = k(j6);
            long j7 = k5 / 8589934592L;
            Long.signum(j7);
            long j8 = (j7 * 8589934592L) + j5;
            j5 += (j7 + 1) * 8589934592L;
            if (j8 >= k5) {
                j5 = j8;
            }
        }
        return a(h(j5));
    }

    public synchronized long d() {
        long j5;
        j5 = this.f9112a;
        if (j5 == Long.MAX_VALUE || j5 == 9223372036854775806L) {
            j5 = -9223372036854775807L;
        }
        return j5;
    }

    public synchronized long e() {
        long j5;
        try {
            j5 = this.f9114c;
        } catch (Throwable th) {
            throw th;
        }
        return j5 != -9223372036854775807L ? j5 + this.f9113b : d();
    }

    public synchronized long f() {
        return this.f9113b;
    }

    public synchronized boolean g() {
        return this.f9113b != -9223372036854775807L;
    }

    public synchronized void i(long j5) {
        this.f9112a = j5;
        this.f9113b = j5 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f9114c = -9223372036854775807L;
    }

    public synchronized void j(boolean z5, long j5, long j6) {
        try {
            a.g(this.f9112a == 9223372036854775806L);
            if (g()) {
                return;
            }
            if (z5) {
                this.f9115d.set(Long.valueOf(j5));
            } else {
                long j7 = 0;
                long j8 = j6;
                while (!g()) {
                    if (j6 == 0) {
                        wait();
                    } else {
                        a.g(j8 > 0);
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        wait(j8);
                        j7 += SystemClock.elapsedRealtime() - elapsedRealtime;
                        if (j7 >= j6 && !g()) {
                            throw new TimeoutException("TimestampAdjuster failed to initialize in " + j6 + " milliseconds");
                        }
                        j8 = j6 - j7;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
