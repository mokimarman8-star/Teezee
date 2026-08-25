package com.bytedance.sdk.openadsdk.EjP.HiB.sP;

import com.bytedance.sdk.component.utils.sU;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP implements TKC {
    private int EjP;
    private long Sj;
    private int TKC;
    private long sP;

    public void Sj(int i) {
        this.TKC = i;
    }

    public void Sj(long j) {
        this.Sj = j;
    }

    @Override // com.bytedance.sdk.openadsdk.EjP.HiB.sP.TKC
    public void Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.Sj);
            jSONObject.put("total_duration", this.sP);
            jSONObject.put("vbtt_skip_type", this.TKC);
            jSONObject.put("skip_reason", this.EjP);
        } catch (Throwable th) {
            sU.sP("EndcardSkipModel", th.getMessage());
        }
    }

    public void sP(int i) {
        this.EjP = i;
    }

    public void sP(long j) {
        this.sP = j;
    }
}
