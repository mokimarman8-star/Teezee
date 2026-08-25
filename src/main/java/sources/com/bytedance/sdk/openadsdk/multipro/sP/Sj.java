package com.bytedance.sdk.openadsdk.multipro.sP;

import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    public boolean EjP;
    public long HiB;
    public long Jcg;
    public boolean Sj;
    public boolean TKC;
    public boolean sP;
    public long vS;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.sP.Sj$Sj, reason: collision with other inner class name */
    public interface InterfaceC0111Sj {
        Sj vS();
    }

    public static Sj Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Sj sj = new Sj();
        sj.sP(jSONObject.optBoolean("isCompleted"));
        sj.TKC(jSONObject.optBoolean("isFromVideoDetailPage"));
        sj.EjP(jSONObject.optBoolean("isFromDetailPage"));
        sj.Sj(jSONObject.optLong("duration"));
        sj.sP(jSONObject.optLong("totalPlayDuration"));
        sj.TKC(jSONObject.optLong("currentPlayPosition"));
        sj.Sj(jSONObject.optBoolean("isAutoPlay"));
        return sj;
    }

    public Sj EjP(boolean z) {
        this.TKC = z;
        return this;
    }

    public Sj Sj(long j) {
        this.HiB = j;
        return this;
    }

    public Sj Sj(boolean z) {
        this.EjP = z;
        return this;
    }

    public JSONObject Sj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.Sj);
            jSONObject.put("isFromVideoDetailPage", this.sP);
            jSONObject.put("isFromDetailPage", this.TKC);
            jSONObject.put("duration", this.HiB);
            jSONObject.put("totalPlayDuration", this.vS);
            jSONObject.put("currentPlayPosition", this.Jcg);
            jSONObject.put("isAutoPlay", this.EjP);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public Sj TKC(long j) {
        this.Jcg = j;
        return this;
    }

    public Sj TKC(boolean z) {
        this.sP = z;
        return this;
    }

    public Sj sP(long j) {
        this.vS = j;
        return this;
    }

    public Sj sP(boolean z) {
        this.Sj = z;
        return this;
    }
}
