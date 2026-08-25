package com.bytedance.adsdk.sP.TKC;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class vS {
    public final float Sj;
    private final String TKC;
    public final float sP;

    public vS(String str, float f, float f2) {
        this.TKC = str;
        this.sP = f2;
        this.Sj = f;
    }

    public boolean Sj(String str) {
        if (this.TKC.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.TKC.endsWith("\r")) {
            String str2 = this.TKC;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
