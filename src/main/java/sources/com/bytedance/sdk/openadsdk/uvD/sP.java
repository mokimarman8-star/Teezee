package com.bytedance.sdk.openadsdk.uvD;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    public static int EjP = 2;
    public static int HiB = 3;
    public static int Sj = -1;
    public static int TKC = 1;
    public static int sP;
    private int vS = Sj;
    private long Jcg = 0;
    private long Dq = 0;
    private final List<TKC> uA = new ArrayList();
    private long TEQ = 0;

    public void EjP(long j) {
        int i = this.vS;
        if (i == Sj || i != EjP) {
            return;
        }
        this.vS = TKC;
        this.uA.add(new TKC(this.TEQ, j));
        this.TEQ = 0L;
    }

    public int Sj() {
        return this.vS;
    }

    public long Sj(long j, long j2) {
        long j3;
        long j4;
        long sP2;
        long j8 = this.Dq;
        if (j8 != 0 && j > j8) {
            return 0L;
        }
        int i = 0;
        for (TKC tkc : this.uA) {
            if (tkc.sP() > j) {
                if (j < tkc.Sj()) {
                    j4 = i;
                    sP2 = tkc.sP() - tkc.Sj();
                } else {
                    j4 = i;
                    sP2 = tkc.sP() - j;
                }
                i = (int) (j4 + sP2);
            }
        }
        long j9 = this.Jcg;
        if (j9 < j) {
            long j10 = this.TEQ;
            if (j10 == 0) {
                j10 = this.Dq;
                if (j10 == 0) {
                    j3 = j2 - j;
                }
            } else if (j10 <= j) {
                return 0L;
            }
            return (j10 - j) - i;
        }
        long j11 = this.TEQ;
        if (j11 == 0) {
            j11 = this.Dq;
            if (j11 == 0) {
                j3 = j2 - j9;
            }
        } else if (j11 <= j9) {
            return 0L;
        }
        return (j11 - j9) - i;
        return j3 - i;
    }

    public void Sj(long j) {
        this.vS = sP;
        this.Jcg = j;
    }

    public void TKC(long j) {
        int i;
        int i2 = this.vS;
        if (i2 == Sj || i2 == (i = EjP) || i2 == HiB) {
            return;
        }
        this.vS = i;
        this.TEQ = j;
    }

    public void sP(long j) {
        int i;
        int i2 = this.vS;
        if (i2 == Sj || i2 == (i = HiB)) {
            return;
        }
        this.vS = i;
        this.Dq = j;
    }
}
