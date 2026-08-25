package com.bytedance.sdk.openadsdk.EjP.HiB.sP;

import com.bytedance.sdk.component.utils.sU;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Fmk implements TKC {
    public long Sj;
    public long TKC;
    public int sP;

    public void Sj(int i) {
        this.sP = i;
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
            jSONObject.put("buffers_count", this.sP);
            jSONObject.put("total_duration", this.TKC);
        } catch (Throwable th) {
            sU.sP("PlayBufferModel", th.getMessage());
        }
    }

    public void sP(long j) {
        this.TKC = j;
    }
}
