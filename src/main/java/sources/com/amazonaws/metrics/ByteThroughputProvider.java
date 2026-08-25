package com.amazonaws.metrics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class ByteThroughputProvider {
    private long a;
    private int b;
    private final ThroughputMetricType c;

    protected ByteThroughputProvider(ThroughputMetricType throughputMetricType) {
        this.c = throughputMetricType;
    }

    public int a() {
        return this.b;
    }

    public long b() {
        return this.a;
    }

    public String c() {
        return super.toString();
    }

    protected void d(int i, long j) {
        this.b += i;
        this.a += System.nanoTime() - j;
    }

    protected void e() {
        this.b = 0;
        this.a = 0L;
    }

    public String toString() {
        return String.format("providerId=%s, throughputType=%s, byteCount=%d, duration=%d", c(), this.c, Integer.valueOf(this.b), Long.valueOf(this.a));
    }
}
