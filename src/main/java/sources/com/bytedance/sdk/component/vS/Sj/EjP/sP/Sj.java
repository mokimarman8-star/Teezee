package com.bytedance.sdk.component.vS.Sj.EjP.sP;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    private int Sj;
    private int sP;

    Sj(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.Sj = i;
        this.sP = i2;
    }

    public static Sj EjP() {
        return new Sj(1, 100, -1L);
    }

    public static Sj HiB() {
        return new Sj(3, 100, 172800000L);
    }

    public static Sj TKC() {
        return new Sj(1, 100, 172800000L);
    }

    public int Sj() {
        return this.Sj;
    }

    public int sP() {
        return this.sP;
    }
}
