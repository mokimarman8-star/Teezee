package com.bytedance.adsdk.ugeno.HiB;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC {
    int Dq;
    int Fmk;
    int HiB;
    int Jcg;
    float TEQ;
    boolean TzV;
    float Ym;
    int Zq;
    int aa;
    boolean dNu;
    int uA;
    int uvD;
    int vS;
    int Sj = Integer.MAX_VALUE;
    int sP = Integer.MAX_VALUE;
    int TKC = Integer.MIN_VALUE;
    int EjP = Integer.MIN_VALUE;
    List<Integer> sef = new ArrayList();

    TKC() {
    }

    public int Sj() {
        return this.Jcg;
    }

    void Sj(View view, int i, int i2, int i3, int i4) {
        sP sPVar = (sP) view.getLayoutParams();
        this.Sj = Math.min(this.Sj, (view.getLeft() - sPVar.Fmk()) - i);
        this.sP = Math.min(this.sP, (view.getTop() - sPVar.sef()) - i2);
        this.TKC = Math.max(this.TKC, view.getRight() + sPVar.Zq() + i3);
        this.EjP = Math.max(this.EjP, view.getBottom() + sPVar.uvD() + i4);
    }

    public int sP() {
        return this.Dq - this.uA;
    }
}
