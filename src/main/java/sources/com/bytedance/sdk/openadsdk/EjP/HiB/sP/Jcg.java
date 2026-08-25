package com.bytedance.sdk.openadsdk.EjP.HiB.sP;

import com.bytedance.sdk.component.utils.sU;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Jcg implements TKC {
    private long Sj;
    private long sP;

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
        } catch (Throwable th) {
            sU.sP("FeedPauseModel", th.getMessage());
        }
    }

    public void sP(long j) {
        this.sP = j;
    }
}
