package com.bytedance.sdk.openadsdk.EjP;

import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Jcg {
    private long EjP;
    private long HiB;
    private long Sj;
    private long TKC;
    private long sP;

    public void EjP(long j) {
        if (this.EjP <= 0) {
            this.EjP = j;
        }
    }

    public void HiB(long j) {
        if (this.HiB <= 0) {
            this.HiB = j;
        }
    }

    public JSONObject Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        long j = this.Sj;
        if (j > 0) {
            jSONObject.put("show_start", j);
            long j2 = this.sP;
            if (j2 > 0) {
                jSONObject.put("show_firstQuartile", j2);
                long j3 = this.TKC;
                if (j3 > 0) {
                    jSONObject.put("show_mid", j3);
                    long j4 = this.EjP;
                    if (j4 > 0) {
                        jSONObject.put("show_thirdQuartile", j4);
                        long j8 = this.HiB;
                        if (j8 > 0) {
                            jSONObject.put("show_full", j8);
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    public void Sj(long j) {
        if (this.Sj <= 0) {
            this.Sj = j;
        }
    }

    public void Sj(long j, float f) {
        if (f > 0.0f) {
            Sj(j);
        }
        double d = f;
        if (d >= 0.25d) {
            Sj(j);
            sP(j);
        }
        if (d >= 0.5d) {
            Sj(j);
            sP(j);
            TKC(j);
        }
        if (d >= 0.75d) {
            Sj(j);
            sP(j);
            TKC(j);
            EjP(j);
        }
        if (f >= 1.0f) {
            Sj(j);
            sP(j);
            TKC(j);
            EjP(j);
            HiB(j);
        }
    }

    public boolean Sj() {
        return this.Sj > 0;
    }

    public void TKC(long j) {
        if (this.TKC <= 0) {
            this.TKC = j;
        }
    }

    public JSONObject sP() {
        return Sj((JSONObject) null);
    }

    public void sP(long j) {
        if (this.sP <= 0) {
            this.sP = j;
        }
    }
}
