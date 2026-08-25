package com.bytedance.sdk.openadsdk.kF.sP;

import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    private final int Sj;
    private final float TKC;
    private final int sP;

    public Sj(int i, int i2, float f) {
        this.Sj = i;
        this.sP = i2;
        this.TKC = f;
    }

    public static JSONObject Sj(Sj sj) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", sj.Sj);
        jSONObject.put("height", sj.sP);
        jSONObject.put("alpha", sj.TKC);
        return jSONObject;
    }
}
