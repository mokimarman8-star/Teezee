package com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP;

import com.bytedance.sdk.component.HiB.TzV;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP implements TzV {
    private com.bytedance.sdk.component.HiB.EjP.TKC.Sj.TKC<String, byte[]> EjP;
    private long Sj = 1048576;
    private int TKC;
    private int sP;

    public sP(int i, int i2) {
        this.TKC = i;
        this.sP = i2;
        this.EjP = new com.bytedance.sdk.component.HiB.EjP.TKC.Sj.TKC<>(i2);
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    public boolean Sj(String str, byte[] bArr) {
        if (str != null && bArr != null) {
            try {
                if (bArr.length > this.Sj) {
                    return false;
                }
                this.EjP.Sj(str, bArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    public byte[] Sj(String str) {
        try {
            return this.EjP.Sj((com.bytedance.sdk.component.HiB.EjP.TKC.Sj.TKC<String, byte[]>) str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    public boolean sP(String str) {
        return this.EjP.Sj((com.bytedance.sdk.component.HiB.EjP.TKC.Sj.TKC<String, byte[]>) str) != null;
    }
}
