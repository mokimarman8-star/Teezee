package com.bytedance.adsdk.Sj.sP.sP.Sj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class RiZ implements com.bytedance.adsdk.Sj.sP.sP.sP {
    private com.bytedance.adsdk.Sj.sP.sP.Sj Sj;
    private com.bytedance.adsdk.Sj.sP.sP.Sj TKC;
    private com.bytedance.adsdk.Sj.sP.sP.Sj sP;

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public com.bytedance.adsdk.Sj.sP.EjP.HiB Sj() {
        return com.bytedance.adsdk.Sj.sP.EjP.vS.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public Object Sj(Map<String, JSONObject> map) {
        Object Sj = this.Sj.Sj(map);
        if (Sj == null) {
            return null;
        }
        return ((Boolean) Sj).booleanValue() ? this.sP.Sj(map) : this.TKC.Sj(map);
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.sP
    public void Sj(com.bytedance.adsdk.Sj.sP.sP.Sj sj) {
        this.Sj = sj;
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.sP
    public void TKC(com.bytedance.adsdk.Sj.sP.sP.Sj sj) {
        this.TKC = sj;
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public String sP() {
        return this.Sj.sP() + "?" + this.sP.sP() + ":" + this.TKC.sP();
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.sP
    public void sP(com.bytedance.adsdk.Sj.sP.sP.Sj sj) {
        this.sP = sj;
    }

    public String toString() {
        return sP();
    }
}
