package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    private String EjP;
    private boolean HiB;
    private String Sj;
    private String TKC;
    private String sP;

    public String EjP() {
        return this.EjP;
    }

    public boolean HiB() {
        return this.HiB;
    }

    public String Sj() {
        return this.Sj;
    }

    public void Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.Sj = jSONObject.optString("icon");
        this.sP = jSONObject.optString("text");
        this.TKC = jSONObject.optString("privacy_url");
        this.EjP = jSONObject.optString("privacy_title");
    }

    public void Sj(boolean z) {
        this.HiB = z;
    }

    public String TKC() {
        return this.TKC;
    }

    public String sP() {
        return this.sP;
    }

    public JSONObject vS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("privacy_url", this.TKC);
            jSONObject.put("privacy_title", this.EjP);
            jSONObject.put("text", this.sP);
            jSONObject.put("icon", this.Sj);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
