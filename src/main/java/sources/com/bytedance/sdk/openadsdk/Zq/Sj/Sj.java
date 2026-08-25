package com.bytedance.sdk.openadsdk.Zq.Sj;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    float Dq;
    float EjP;
    float Fmk;
    float HiB;
    float Jcg;
    String Sj;
    int TEQ;
    float TKC;
    float Ym;
    String Zq;
    float aa;
    int dNu;
    int sP;
    int sef;
    float uA;
    float uvD;
    int vS;
    int TzV = -1;
    String RiZ = "";

    /* renamed from: com.bytedance.sdk.openadsdk.Zq.Sj.Sj$Sj, reason: collision with other inner class name */
    public static class C0071Sj {
        Sj Sj = new Sj();

        public C0071Sj Dq(float f) {
            this.Sj.Dq(f);
            return this;
        }

        public C0071Sj EjP(float f) {
            this.Sj.EjP(f);
            return this;
        }

        public C0071Sj HiB(float f) {
            this.Sj.HiB(f);
            return this;
        }

        public C0071Sj Jcg(float f) {
            this.Sj.Jcg(f);
            return this;
        }

        public C0071Sj Sj(float f) {
            this.Sj.Sj(f);
            return this;
        }

        public C0071Sj Sj(int i) {
            this.Sj.sP(i);
            return this;
        }

        public C0071Sj Sj(String str) {
            this.Sj.sP(str);
            return this;
        }

        public Sj Sj() {
            return this.Sj;
        }

        public C0071Sj TEQ(float f) {
            this.Sj.TEQ(f);
            return this;
        }

        public C0071Sj TKC(float f) {
            this.Sj.TKC(f);
            return this;
        }

        public C0071Sj TKC(int i) {
            this.Sj.vS(i);
            return this;
        }

        public C0071Sj sP(float f) {
            this.Sj.sP(f);
            return this;
        }

        public C0071Sj sP(int i) {
            this.Sj.HiB(i);
            return this;
        }

        public C0071Sj sP(String str) {
            this.Sj.TKC(str);
            return this;
        }

        public C0071Sj uA(float f) {
            this.Sj.uA(f);
            return this;
        }

        public C0071Sj vS(float f) {
            this.Sj.vS(f);
            return this;
        }
    }

    public int Dq() {
        return this.vS;
    }

    public void Dq(float f) {
        this.aa = f;
    }

    public int EjP() {
        return this.sP;
    }

    public void EjP(float f) {
        this.Jcg = f;
    }

    public void EjP(int i) {
        this.TEQ = i;
    }

    public float Fmk() {
        return this.Ym;
    }

    public float HiB() {
        return this.TKC;
    }

    public void HiB(float f) {
        this.Dq = f;
    }

    public void HiB(int i) {
        this.sef = i;
    }

    public float Jcg() {
        return this.HiB;
    }

    public void Jcg(float f) {
        this.Ym = f;
    }

    public int RiZ() {
        return this.dNu;
    }

    public int Sj() {
        return this.TzV;
    }

    public void Sj(float f) {
        this.TKC = f;
    }

    public void Sj(int i) {
        this.TzV = i;
    }

    public void Sj(String str) {
        this.RiZ = str;
    }

    public float TEQ() {
        return this.Dq;
    }

    public void TEQ(float f) {
        this.uvD = f;
    }

    public String TKC() {
        return this.Sj;
    }

    public void TKC(float f) {
        this.HiB = f;
    }

    public void TKC(int i) {
        this.vS = i;
    }

    public void TKC(String str) {
        this.Zq = str;
    }

    public float TzV() {
        return this.uvD;
    }

    public float Ym() {
        return this.uA;
    }

    public BigDecimal Zq() {
        return new BigDecimal(this.Fmk).setScale(3, RoundingMode.HALF_UP);
    }

    public int aa() {
        return this.TEQ;
    }

    public String dNu() {
        return this.Zq;
    }

    public String sP() {
        return this.RiZ;
    }

    public void sP(float f) {
        this.EjP = f;
    }

    public void sP(int i) {
        this.sP = i;
    }

    public void sP(String str) {
        this.Sj = str;
    }

    public float sef() {
        return this.aa;
    }

    public float uA() {
        return this.Jcg;
    }

    public void uA(float f) {
        this.Fmk = f;
    }

    public int uvD() {
        return this.sef;
    }

    public float vS() {
        return this.EjP;
    }

    public void vS(float f) {
        this.uA = f;
    }

    public void vS(int i) {
        this.dNu = i;
    }
}
