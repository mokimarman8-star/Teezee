package com.bytedance.adsdk.sP.TKC.sP;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EjP {
    private final float[] Sj;
    private final int[] sP;

    public EjP(float[] fArr, int[] iArr) {
        this.Sj = fArr;
        this.sP = iArr;
    }

    private int Sj(float f) {
        int binarySearch = Arrays.binarySearch(this.Sj, f);
        if (binarySearch >= 0) {
            return this.sP[binarySearch];
        }
        int i = -(binarySearch + 1);
        if (i == 0) {
            return this.sP[0];
        }
        int[] iArr = this.sP;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.Sj;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.bytedance.adsdk.sP.vS.sP.Sj((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }

    public EjP Sj(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = Sj(fArr[i]);
        }
        return new EjP(fArr, iArr);
    }

    public void Sj(EjP ejP, EjP ejP2, float f) {
        if (ejP.sP.length == ejP2.sP.length) {
            for (int i = 0; i < ejP.sP.length; i++) {
                this.Sj[i] = com.bytedance.adsdk.sP.vS.HiB.Sj(ejP.Sj[i], ejP2.Sj[i], f);
                this.sP[i] = com.bytedance.adsdk.sP.vS.sP.Sj(f, ejP.sP[i], ejP2.sP[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + ejP.sP.length + " vs " + ejP2.sP.length + ")");
    }

    public float[] Sj() {
        return this.Sj;
    }

    public int TKC() {
        return this.sP.length;
    }

    public int[] sP() {
        return this.sP;
    }
}
