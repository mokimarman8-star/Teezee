package com.bytedance.sdk.openadsdk;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TTImage {
    private double EjP;
    private final int Sj;
    private final String TKC;
    private final int sP;

    public TTImage(int i, int i2, String str) {
        this(i, i2, str, 0.0d);
    }

    public TTImage(int i, int i2, String str, double d) {
        this.Sj = i;
        this.sP = i2;
        this.TKC = str;
        this.EjP = d;
    }

    public double getDuration() {
        return this.EjP;
    }

    public int getHeight() {
        return this.Sj;
    }

    public String getImageUrl() {
        return this.TKC;
    }

    public int getWidth() {
        return this.sP;
    }

    public boolean isValid() {
        String str;
        return this.Sj > 0 && this.sP > 0 && (str = this.TKC) != null && str.length() > 0;
    }
}
