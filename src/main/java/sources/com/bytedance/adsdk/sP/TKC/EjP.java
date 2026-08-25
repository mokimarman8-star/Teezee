package com.bytedance.adsdk.sP.TKC;

import com.bytedance.adsdk.sP.TKC.sP.uvD;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EjP {
    private final double EjP;
    private final String HiB;
    private final List<uvD> Sj;
    private final double TKC;
    private final char sP;
    private final String vS;

    public EjP(List<uvD> list, char c, double d, double d2, String str, String str2) {
        this.Sj = list;
        this.sP = c;
        this.TKC = d;
        this.EjP = d2;
        this.HiB = str;
        this.vS = str2;
    }

    public static int Sj(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<uvD> Sj() {
        return this.Sj;
    }

    public int hashCode() {
        return Sj(this.sP, this.vS, this.HiB);
    }

    public double sP() {
        return this.EjP;
    }
}
