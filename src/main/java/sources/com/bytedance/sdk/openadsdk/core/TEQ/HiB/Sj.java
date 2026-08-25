package com.bytedance.sdk.openadsdk.core.TEQ.HiB;

import com.bytedance.adsdk.ugeno.core.Zq;
import com.bytedance.sdk.component.adexpress.sP.Fmk;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj extends Fmk {
    private float EjP;
    private JSONObject Sj;
    private float TKC;
    private Zq sP;

    /* renamed from: com.bytedance.sdk.openadsdk.core.TEQ.HiB.Sj$Sj, reason: collision with other inner class name */
    public static class C0084Sj extends Fmk.Sj {
        private float EjP;
        private JSONObject Sj;
        private float TKC;
        private Zq sP;

        public C0084Sj Sj(float f) {
            this.TKC = f;
            return this;
        }

        public C0084Sj Sj(Zq zq) {
            this.sP = zq;
            return this;
        }

        public C0084Sj Sj(JSONObject jSONObject) {
            this.Sj = jSONObject;
            return this;
        }

        public C0084Sj sP(float f) {
            this.EjP = f;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.sP.Fmk.Sj
        /* renamed from: sP, reason: merged with bridge method [inline-methods] */
        public Sj Sj() {
            return new Sj(this);
        }
    }

    public Sj(C0084Sj c0084Sj) {
        super(c0084Sj);
        this.Sj = c0084Sj.Sj;
        this.sP = c0084Sj.sP;
        this.TKC = c0084Sj.TKC;
        this.EjP = c0084Sj.EjP;
    }

    public JSONObject LD() {
        return this.Sj;
    }

    public float LqL() {
        return this.TKC;
    }

    public float Yf() {
        return this.EjP;
    }

    public Zq fF() {
        return this.sP;
    }
}
