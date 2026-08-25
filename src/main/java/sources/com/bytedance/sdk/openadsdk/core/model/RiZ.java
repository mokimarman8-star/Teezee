package com.bytedance.sdk.openadsdk.core.model;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class RiZ {
    private long Sj = 10000;
    private long sP = 10000;
    private long TKC = 10;
    private long EjP = 20;
    private String HiB = "";

    public long EjP() {
        return this.EjP;
    }

    public void EjP(long j) {
        if (j < 0) {
            this.EjP = 20L;
        } else {
            this.EjP = j;
        }
    }

    public String HiB() {
        return this.HiB;
    }

    public long Sj() {
        return this.Sj;
    }

    public void Sj(long j) {
        if (j <= 0) {
            this.Sj = 10L;
        } else {
            this.Sj = j;
        }
    }

    public void Sj(String str) {
        this.HiB = str;
    }

    public long TKC() {
        return this.TKC;
    }

    public void TKC(long j) {
        if (j <= 0) {
            this.TKC = 10L;
        } else {
            this.TKC = j;
        }
    }

    public long sP() {
        return this.sP;
    }

    public void sP(long j) {
        if (j < 0) {
            this.sP = 20L;
        } else {
            this.sP = j;
        }
    }
}
