package com.bytedance.sdk.openadsdk.EjP.sP;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC implements sP {
    sP Sj;

    @Override // com.bytedance.sdk.openadsdk.EjP.sP.sP
    public void Sj(JSONObject jSONObject, long j) throws JSONException {
        sP sPVar = this.Sj;
        if (sPVar != null) {
            sPVar.Sj(jSONObject, j);
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        jSONObject.put("event_ts", j);
    }
}
