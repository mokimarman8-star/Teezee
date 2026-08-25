package com.transsion.athena.ehatna;

import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena implements Serializable {
    public long a;
    public long b;
    public String c;

    public athena(long j, long j2, String str) {
        this.a = j;
        this.b = j2;
        this.c = str;
    }

    public athena(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        this.a = jSONObject.getLong("serverTime");
        this.b = jSONObject.getLong("elapsedRealtime");
        this.c = jSONObject.getString("bootId");
    }
}
