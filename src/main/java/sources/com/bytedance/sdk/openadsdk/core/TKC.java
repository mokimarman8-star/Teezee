package com.bytedance.sdk.openadsdk.core;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC {
    private static volatile TKC Sj;

    private TKC() {
    }

    public static TKC Sj(Context context) {
        if (Sj == null) {
            synchronized (TKC.class) {
                try {
                    if (Sj == null) {
                        Sj = new TKC();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Sj;
    }

    public void Sj(String str, int i) {
        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("ttopenadsdk", str, Integer.valueOf(i));
    }

    public void Sj(String str, long j) {
        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("ttopenadsdk", str, Long.valueOf(j));
    }

    public void Sj(String str, String str2) {
        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("ttopenadsdk", str, str2);
    }

    public int sP(String str, int i) {
        return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("ttopenadsdk", str, i);
    }

    public Long sP(String str, long j) {
        return Long.valueOf(com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("ttopenadsdk", str, j));
    }

    public String sP(String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP("ttopenadsdk", str, str2);
    }
}
