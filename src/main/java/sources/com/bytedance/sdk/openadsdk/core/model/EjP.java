package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EjP {
    private int Jcg;
    private String Sj = "";
    private String sP = "";
    private String TKC = "";
    private String EjP = "";
    private double HiB = -1.0d;
    private int vS = -1;

    public JSONObject Dq() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", sP());
            jSONObject.put("app_size", vS());
            jSONObject.put("comment_num", HiB());
            jSONObject.put("download_url", Sj());
            jSONObject.put("package_name", TKC());
            jSONObject.put("score", EjP());
            jSONObject.put("app_category", Jcg());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sU.sP(e.toString(), new Object[0]);
        }
        return jSONObject;
    }

    public double EjP() {
        return this.HiB;
    }

    public void EjP(String str) {
        this.EjP = str;
    }

    public int HiB() {
        return this.vS;
    }

    public String Jcg() {
        return this.EjP;
    }

    public String Sj() {
        return this.Sj;
    }

    public void Sj(double d) {
        if (d < 1.0d || d > 5.0d) {
            this.HiB = -1.0d;
        } else {
            this.HiB = d;
        }
    }

    public void Sj(int i) {
        if (i <= 0) {
            this.vS = -1;
        } else {
            this.vS = i;
        }
    }

    public void Sj(String str) {
        this.Sj = str;
    }

    public String TKC() {
        return this.TKC;
    }

    public void TKC(String str) {
        this.TKC = str;
    }

    public String sP() {
        return this.sP;
    }

    public void sP(int i) {
        this.Jcg = i;
    }

    public void sP(String str) {
        this.sP = str;
    }

    public int vS() {
        return this.Jcg;
    }
}
