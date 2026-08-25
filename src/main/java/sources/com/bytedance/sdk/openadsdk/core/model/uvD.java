package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uvD {
    private double EjP;
    private boolean HiB;
    private String Sj;
    private int TKC;
    private int sP;
    private String vS;

    public double EjP() {
        return this.EjP;
    }

    public boolean HiB() {
        return !TextUtils.isEmpty(this.Sj) && this.sP > 0 && this.TKC > 0;
    }

    public String Jcg() {
        return this.vS;
    }

    public String Sj() {
        return this.Sj;
    }

    public void Sj(int i) {
        this.sP = i;
    }

    public void Sj(String str) {
        this.Sj = str;
    }

    public void Sj(boolean z) {
        this.HiB = z;
    }

    public int TKC() {
        return this.TKC;
    }

    public int sP() {
        return this.sP;
    }

    public void sP(int i) {
        this.TKC = i;
    }

    public void sP(String str) {
        this.vS = str;
    }

    public boolean vS() {
        return this.HiB;
    }
}
