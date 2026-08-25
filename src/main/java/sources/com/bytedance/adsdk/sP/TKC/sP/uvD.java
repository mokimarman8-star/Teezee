package com.bytedance.adsdk.sP.TKC.sP;

import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uvD implements TKC {
    private final String Sj;
    private final boolean TKC;
    private final List<TKC> sP;

    public uvD(String str, List<TKC> list, boolean z) {
        this.Sj = str;
        this.sP = list;
        this.TKC = z;
    }

    @Override // com.bytedance.adsdk.sP.TKC.sP.TKC
    public com.bytedance.adsdk.sP.Sj.Sj.TKC Sj(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.Jcg jcg, com.bytedance.adsdk.sP.TKC.TKC.Sj sj) {
        return new com.bytedance.adsdk.sP.Sj.Sj.EjP(uAVar, sj, this, jcg);
    }

    public String Sj() {
        return this.Sj;
    }

    public boolean TKC() {
        return this.TKC;
    }

    public List<TKC> sP() {
        return this.sP;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.Sj + "' Shapes: " + Arrays.toString(this.sP.toArray()) + '}';
    }
}
