package com.google.firebase.perf.util;

import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g {
    private long a;
    private long b;
    private TimeUnit c;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(long j, long j2, TimeUnit timeUnit) {
        this.a = j;
        this.b = j2;
        this.c = timeUnit;
    }

    public double a() {
        int i = a.a[this.c.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? this.a / this.c.toSeconds(this.b) : (this.a / this.b) * TimeUnit.SECONDS.toMillis(1L) : (this.a / this.b) * TimeUnit.SECONDS.toMicros(1L) : (this.a / this.b) * TimeUnit.SECONDS.toNanos(1L);
    }
}
