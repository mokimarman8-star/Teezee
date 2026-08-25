package com.bytedance.sdk.component.Dq.TKC;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class sP implements Comparable<sP>, Runnable {
    private long EjP;
    private long HiB;
    private int Sj;
    private Runnable TKC;
    private String sP;
    private long vS;

    public sP(int i, String str) {
        this.Sj = i;
        this.sP = str;
    }

    public sP(String str) {
        this.Sj = 5;
        this.sP = str;
    }

    public sP(String str, Runnable runnable) {
        this.Sj = 5;
        this.sP = str;
        this.TKC = runnable;
    }

    public Runnable Dq() {
        return this.TKC;
    }

    public long EjP() {
        return this.HiB;
    }

    public long HiB() {
        return this.vS;
    }

    public long Jcg() {
        return this.vS - this.HiB;
    }

    public int Sj() {
        return this.Sj;
    }

    @Override // java.lang.Comparable
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public int compareTo(sP sPVar) {
        if (Sj() < sPVar.Sj()) {
            return 1;
        }
        return Sj() >= sPVar.Sj() ? -1 : 0;
    }

    public void Sj(int i) {
        this.Sj = i;
    }

    public void Sj(long j) {
        this.EjP = j;
    }

    public long TKC() {
        return this.EjP;
    }

    public void TKC(long j) {
        this.vS = j;
    }

    public String sP() {
        return this.sP;
    }

    public void sP(long j) {
        this.HiB = j;
    }

    public long vS() {
        return this.HiB - this.EjP;
    }
}
