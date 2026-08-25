package com.bytedance.sdk.component.vS.Sj.EjP.Sj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj implements com.bytedance.sdk.component.vS.Sj.EjP.Sj {
    private String Dq;
    private byte EjP;
    private long HiB;
    private long Jcg;
    protected JSONObject Sj;
    private byte TEQ;
    private byte TKC;
    private String Ym;
    private int aa;
    private sP sP;
    private String uA;
    private long vS;

    private Sj() {
    }

    public Sj(String str, sP sPVar) {
        this.uA = str;
        this.sP = sPVar;
    }

    public Sj(String str, JSONObject jSONObject) {
        this.uA = str;
        this.Sj = jSONObject;
    }

    public static com.bytedance.sdk.component.vS.Sj.EjP.Sj TKC(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt("priority");
            Sj sj = new Sj();
            sj.Sj((byte) optInt);
            sj.sP((byte) optInt2);
            sj.Sj(jSONObject.optJSONObject("event"));
            sj.Sj(jSONObject.optString("localId"));
            sj.sP(jSONObject.optString("genTime"));
            sj.Sj(jSONObject.optInt("channel"));
            return sj;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public long Dq() {
        return this.HiB;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public byte EjP() {
        return this.TKC;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public byte HiB() {
        return this.EjP;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public synchronized JSONObject Jcg() {
        sP sPVar;
        try {
            if (this.Sj == null && (sPVar = this.sP) != null) {
                this.Sj = sPVar.Sj(Ym());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.Sj;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public sP Sj() {
        return this.sP;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public void Sj(byte b) {
        this.TKC = b;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public void Sj(int i) {
        this.aa = i;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public void Sj(long j) {
        this.HiB = j;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public void Sj(String str) {
        this.uA = str;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public void Sj(JSONObject jSONObject) {
        this.Sj = jSONObject;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public int TEQ() {
        return this.aa;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public String TKC() {
        return this.uA;
    }

    public void TKC(byte b) {
        this.TEQ = b;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public void TKC(long j) {
        this.Jcg = j;
    }

    public String Ym() {
        return this.Ym;
    }

    public String aa() {
        return this.Dq;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public byte sP() {
        return this.TEQ;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public void sP(byte b) {
        this.EjP = b;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public void sP(long j) {
        this.vS = j;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public void sP(String str) {
        this.Dq = str;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public long uA() {
        return this.vS;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj
    public String vS() {
        if (TextUtils.isEmpty(this.uA)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.uA);
            jSONObject.put("event", Jcg());
            jSONObject.put("genTime", aa());
            jSONObject.put("priority", (int) this.EjP);
            jSONObject.put("type", (int) this.TKC);
            jSONObject.put("channel", this.aa);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
