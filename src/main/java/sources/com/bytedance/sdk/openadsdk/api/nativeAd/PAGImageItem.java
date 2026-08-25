package com.bytedance.sdk.openadsdk.api.nativeAd;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class PAGImageItem {
    private float EjP;
    private final int Sj;
    private final String TKC;
    private final int sP;

    public PAGImageItem(int i, int i2, String str) {
        this(i, i2, str, 0.0f);
    }

    public PAGImageItem(int i, int i2, String str, float f) {
        this.Sj = i;
        this.sP = i2;
        this.TKC = str;
        this.EjP = f;
    }

    public float getDuration() {
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
}
