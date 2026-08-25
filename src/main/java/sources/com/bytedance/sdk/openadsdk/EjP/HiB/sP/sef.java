package com.bytedance.sdk.openadsdk.EjP.HiB.sP;

import a6.a;
import com.bytedance.sdk.component.utils.sU;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sef implements TKC {
    private final int EjP;
    private final String HiB;
    private long Sj;
    private final int TKC;
    private long sP;

    public sef(a aVar) {
        this.TKC = aVar.a();
        this.EjP = aVar.d();
        this.HiB = aVar.c();
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
            jSONObject.put("error_code", this.TKC);
            jSONObject.put("extra_error_code", this.EjP);
            jSONObject.put("error_message", this.HiB);
        } catch (Throwable th) {
            sU.sP("PlayErrorModel", th.getMessage());
        }
    }

    public void sP(long j) {
        this.sP = j;
    }
}
