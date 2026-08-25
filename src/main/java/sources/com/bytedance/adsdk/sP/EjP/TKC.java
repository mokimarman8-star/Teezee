package com.bytedance.adsdk.sP.EjP;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum TKC {
    JSON(".json"),
    ZIP(".zip");

    public final String TKC;

    TKC(String str) {
        this.TKC = str;
    }

    public String Sj() {
        return ".temp" + this.TKC;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.TKC;
    }
}
