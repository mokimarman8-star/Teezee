package com.bytedance.sdk.openadsdk.EjP.HiB.sP;

import com.bytedance.sdk.component.utils.sU;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Dq implements TKC {
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
            jSONObject.put("video_start_duration", this.Sj);
            jSONObject.put("video_cache_size", this.sP);
            jSONObject.put("is_auto_play", this.TKC);
        } catch (Throwable th) {
            sU.sP("FeedPlayModel", th.getMessage());
        }
    }

    public void sP(long j) {
        this.sP = j;
    }
}
