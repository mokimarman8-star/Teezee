package com.bytedance.sdk.openadsdk.TzV.Sj;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.EjP;
import com.bytedance.sdk.component.utils.sU;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    private Bitmap EjP;
    private List<Object> HiB;
    int Sj;
    private Bitmap TKC;
    private byte[] sP;
    private Map<String, String> vS;

    public sP(Bitmap bitmap, Bitmap bitmap2, int i) {
        this.sP = null;
        this.HiB = null;
        this.vS = null;
        this.EjP = bitmap2;
        this.TKC = bitmap;
        this.Sj = i;
    }

    public sP(byte[] bArr, int i) {
        this.TKC = null;
        this.EjP = null;
        this.HiB = null;
        this.vS = null;
        this.sP = bArr;
        this.Sj = i;
    }

    public boolean EjP() {
        if (this.TKC != null) {
            return true;
        }
        byte[] bArr = this.sP;
        return bArr != null && bArr.length > 0;
    }

    public Bitmap Sj() {
        return this.TKC;
    }

    public byte[] TKC() {
        try {
            if (this.sP == null) {
                this.sP = EjP.Sj(this.TKC);
            }
        } catch (OutOfMemoryError e) {
            sU.sP("GifRequestResult", e.getMessage());
        }
        return this.sP;
    }

    public Bitmap sP() {
        return this.EjP;
    }
}
