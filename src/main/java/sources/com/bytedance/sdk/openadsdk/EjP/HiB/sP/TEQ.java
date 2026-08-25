package com.bytedance.sdk.openadsdk.EjP.HiB.sP;

import com.bytedance.sdk.component.utils.sU;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TEQ implements TKC {
    private int EjP;
    private String HiB;
    private String Sj;
    private long TKC;
    private long sP;
    private String vS;

    public void Sj(int i) {
        this.EjP = i;
    }

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
            jSONObject.put("error_code", this.EjP);
            jSONObject.put("error_message", this.HiB);
            jSONObject.put("error_message_server", this.vS);
        } catch (Throwable th) {
            sU.sP("LoadVideoErrorModel", th.getMessage());
        }
    }

    public void TKC(String str) {
        this.vS = str;
    }

    public void sP(long j) {
        this.TKC = j;
    }

    public void sP(String str) {
        this.HiB = str;
    }
}
