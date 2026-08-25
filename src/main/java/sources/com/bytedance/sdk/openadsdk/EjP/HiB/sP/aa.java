package com.bytedance.sdk.openadsdk.EjP.HiB.sP;

import com.bytedance.sdk.component.utils.sU;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class aa implements TKC {
    private long EjP;
    private String Sj;
    private long TKC;
    private long sP;

    public void Sj(long j) {
        this.sP = j;
    }

    public void Sj(String str) {
        this.Sj = str;
    }

    @Override // com.bytedance.sdk.openadsdk.EjP.HiB.sP.TKC
    public void Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.Sj);
            jSONObject.put("preload_size", this.sP);
            jSONObject.put("load_time", this.TKC);
            jSONObject.put("local_cache", this.EjP);
        } catch (Throwable th) {
            sU.sP("LoadVideoSuccessModel", th.getMessage());
        }
    }

    public void TKC(long j) {
        this.EjP = j;
    }

    public void sP(long j) {
        this.TKC = j;
    }
}
