package com.bytedance.sdk.component.sP.Sj.sP;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class vS {
    static HiB Sj;
    static long sP;

    private vS() {
    }

    static HiB Sj() {
        synchronized (vS.class) {
            HiB hiB = Sj;
            if (hiB == null) {
                return new HiB();
            }
            Sj = hiB.vS;
            hiB.vS = null;
            sP -= 8192;
            return hiB;
        }
    }

    static void Sj(HiB hiB) {
        if (hiB.vS != null || hiB.Jcg != null) {
            throw new IllegalArgumentException();
        }
        if (hiB.EjP) {
            return;
        }
        synchronized (vS.class) {
            try {
                long j = sP;
                if (j + 8192 > 65536) {
                    return;
                }
                sP = j + 8192;
                hiB.vS = Sj;
                hiB.TKC = 0;
                hiB.sP = 0;
                Sj = hiB;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
