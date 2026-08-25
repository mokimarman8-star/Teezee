package com.bytedance.adsdk.sP.TKC;

import android.graphics.PointF;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    public int Dq;
    public Sj EjP;
    public PointF Fmk;
    public int HiB;
    public float Jcg;
    public String Sj;
    public float TEQ;
    public float TKC;
    public boolean Ym;
    public PointF aa;
    public String sP;
    public int uA;
    public float vS;

    public enum Sj {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public sP() {
    }

    public sP(String str, String str2, float f, Sj sj, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        Sj(str, str2, f, sj, i, f2, f3, i2, i3, f4, z, pointF, pointF2);
    }

    public void Sj(String str, String str2, float f, Sj sj, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.Sj = str;
        this.sP = str2;
        this.TKC = f;
        this.EjP = sj;
        this.HiB = i;
        this.vS = f2;
        this.Jcg = f3;
        this.Dq = i2;
        this.uA = i3;
        this.TEQ = f4;
        this.Ym = z;
        this.aa = pointF;
        this.Fmk = pointF2;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.Sj.hashCode() * 31) + this.sP.hashCode()) * 31) + this.TKC)) * 31) + this.EjP.ordinal()) * 31) + this.HiB;
        long floatToRawIntBits = Float.floatToRawIntBits(this.vS);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.Dq;
    }
}
