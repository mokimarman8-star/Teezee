package com.bytedance.adsdk.sP.Jcg;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC {
    private float Sj;
    private float sP;

    public TKC() {
        this(1.0f, 1.0f);
    }

    public TKC(float f, float f2) {
        this.Sj = f;
        this.sP = f2;
    }

    public float Sj() {
        return this.Sj;
    }

    public void Sj(float f, float f2) {
        this.Sj = f;
        this.sP = f2;
    }

    public float sP() {
        return this.sP;
    }

    public boolean sP(float f, float f2) {
        return this.Sj == f && this.sP == f2;
    }

    public String toString() {
        return Sj() + "x" + sP();
    }
}
