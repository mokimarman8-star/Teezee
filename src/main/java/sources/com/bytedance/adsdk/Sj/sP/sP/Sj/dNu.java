package com.bytedance.adsdk.Sj.sP.sP.Sj;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class dNu implements com.bytedance.adsdk.Sj.sP.sP.Sj {
    protected com.bytedance.adsdk.Sj.sP.sP.Sj Sj;
    protected com.bytedance.adsdk.Sj.sP.EjP.TKC TKC;
    protected com.bytedance.adsdk.Sj.sP.sP.Sj sP;

    protected dNu(com.bytedance.adsdk.Sj.sP.EjP.TKC tkc) {
        this.TKC = tkc;
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public com.bytedance.adsdk.Sj.sP.EjP.HiB Sj() {
        return com.bytedance.adsdk.Sj.sP.EjP.vS.OPERATOR_RESULT;
    }

    public void Sj(com.bytedance.adsdk.Sj.sP.sP.Sj sj) {
        this.Sj = sj;
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public String sP() {
        return this.Sj.sP() + this.TKC.Sj() + this.sP.sP();
    }

    public void sP(com.bytedance.adsdk.Sj.sP.sP.Sj sj) {
        this.sP = sj;
    }

    public String toString() {
        return sP();
    }
}
