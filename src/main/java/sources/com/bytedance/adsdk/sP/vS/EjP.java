package com.bytedance.adsdk.sP.vS;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EjP {
    private float Sj;
    private int sP;

    public void Sj(float f) {
        float f2 = this.Sj + f;
        this.Sj = f2;
        int i = this.sP + 1;
        this.sP = i;
        if (i == Integer.MAX_VALUE) {
            this.Sj = f2 / 2.0f;
            this.sP = i / 2;
        }
    }
}
