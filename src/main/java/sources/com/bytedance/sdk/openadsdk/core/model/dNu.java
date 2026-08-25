package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class dNu {
    public static int Sj = 1;
    public static int sP = 2;
    private int TKC = 5;
    private int EjP = 30;
    private int HiB = 70;
    private int vS = 1;
    private int Jcg = Sj;
    private int Dq = 0;
    private int uA = 0;
    private int TEQ = 3;

    public int Dq() {
        return this.Jcg;
    }

    public void Dq(int i) {
        this.Jcg = i;
    }

    public int EjP() {
        return this.TKC;
    }

    public void EjP(int i) {
        this.TKC = i;
    }

    public int HiB() {
        return this.EjP;
    }

    public void HiB(int i) {
        this.EjP = i;
    }

    public int Jcg() {
        return this.vS;
    }

    public void Jcg(int i) {
        this.vS = i;
    }

    public int Sj() {
        return this.TEQ;
    }

    public JSONObject Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("ceiling_time", this.TKC);
            jSONObject.put("ceiling_ratio", this.EjP);
            jSONObject.put("expand_ratio", this.HiB);
            jSONObject.put("back_type", this.vS);
            jSONObject.put("boc_return_type", this.Jcg);
            jSONObject.put("pre_render_status", this.Dq);
            jSONObject.put("pre_render_use_gecko", this.uA);
            jSONObject.put("pre_render_add_type", this.TEQ);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sU.sP("InteractionParams", th.getMessage());
        }
        return jSONObject;
    }

    public void Sj(int i) {
        this.TEQ = i;
    }

    public boolean Sj(boolean z) {
        if (z) {
            int i = this.Dq;
            return i == 1 || i == 3;
        }
        int i2 = this.Dq;
        return i2 == 3 || i2 == 2;
    }

    public int TKC() {
        return this.Dq;
    }

    public void TKC(int i) {
        this.Dq = i;
    }

    public int sP() {
        return this.uA;
    }

    public void sP(int i) {
        this.uA = i;
    }

    public int vS() {
        return this.HiB;
    }

    public void vS(int i) {
        this.HiB = i;
    }
}
