package com.amazonaws.util;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TimingInfo {
    private final Long a;
    private final long b;
    private Long c;

    protected TimingInfo(Long l, long j, Long l2) {
        this.a = l;
        this.b = j;
        this.c = l2;
    }

    public static double b(long j, long j2) {
        return TimeUnit.NANOSECONDS.toMicros(j2 - j) / 1000.0d;
    }

    public static TimingInfo m() {
        return new TimingInfo(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    public static TimingInfo n() {
        return new TimingInfoFullSupport(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    public static TimingInfo o(long j) {
        return new TimingInfoFullSupport(null, j, null);
    }

    public static TimingInfo p(long j, Long l) {
        return new TimingInfoUnmodifiable(null, j, l);
    }

    public void a(String str, TimingInfo timingInfo) {
    }

    public TimingInfo c() {
        this.c = Long.valueOf(System.nanoTime());
        return this;
    }

    public Map d() {
        return Collections.emptyMap();
    }

    public final long e() {
        Long l = this.c;
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public final long f() {
        return this.b;
    }

    public Map g() {
        return Collections.emptyMap();
    }

    public final double h() {
        Double i = i();
        if (i == null) {
            return -1.0d;
        }
        return i.doubleValue();
    }

    public final Double i() {
        if (k()) {
            return Double.valueOf(b(this.b, this.c.longValue()));
        }
        return null;
    }

    public void j(String str) {
    }

    public final boolean k() {
        return this.c != null;
    }

    public void l(String str, long j) {
    }

    public final String toString() {
        return String.valueOf(h());
    }
}
