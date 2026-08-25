package com.bytedance.sdk.component.vS.Sj.HiB;

import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class HiB implements Comparable<HiB>, Runnable {
    private String TKC;
    private int Sj = 5;
    private String sP = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public HiB(String str) {
        this.TKC = str;
    }

    public int Sj() {
        return this.Sj;
    }

    @Override // java.lang.Comparable
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public int compareTo(HiB hiB) {
        if (Sj() < hiB.Sj()) {
            return 1;
        }
        return Sj() >= hiB.Sj() ? -1 : 0;
    }

    public void Sj(int i) {
        this.Sj = i;
    }
}
