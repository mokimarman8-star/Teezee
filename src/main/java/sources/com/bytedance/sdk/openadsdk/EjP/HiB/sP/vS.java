package com.bytedance.sdk.openadsdk.EjP.HiB.sP;

import com.bytedance.sdk.component.utils.sU;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class vS implements TKC {
    private long Sj;
    private int TKC = 0;
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
            jSONObject.put("total_duration", this.Sj);
            jSONObject.put("buffers_time", this.sP);
            jSONObject.put("video_backup", this.TKC);
        } catch (Throwable th) {
            sU.sP("FeedOverModel", th.getMessage());
        }
    }

    public void sP(long j) {
        this.sP = j;
    }
}
