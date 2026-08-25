package com.bytedance.sdk.component.Dq;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class Dq implements Comparable<Dq>, Runnable {
    private int Sj;
    private String sP;

    public Dq(String str) {
        this.Sj = 5;
        this.sP = str;
    }

    public Dq(String str, int i) {
        this.Sj = 0;
        this.Sj = i == 0 ? 5 : i;
        this.sP = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(Dq dq) {
        if (getPriority() < dq.getPriority()) {
            return 1;
        }
        return getPriority() >= dq.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.sP;
    }

    public int getPriority() {
        return this.Sj;
    }

    public void setPriority(int i) {
        this.Sj = i;
    }
}
