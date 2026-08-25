package com.bytedance.sdk.component.Dq.sP;

import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    public int EjP;
    public int Sj;
    public int TKC;
    public int sP;

    public Sj(int i, int i2, int i3, int i4) {
        this.Sj = i;
        this.sP = i2;
        this.TKC = i3;
        this.EjP = i4;
    }

    public JSONObject Sj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_thread_num", this.Sj);
            jSONObject.put("sdk_max_thread_num", this.sP);
            jSONObject.put("app_thread_num", this.TKC);
            jSONObject.put("app_max_thread_num", this.EjP);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
