package com.bytedance.sdk.component.HiB.sP;

import com.bytedance.sdk.component.HiB.HiB;
import com.bytedance.sdk.component.HiB.sef;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP implements HiB {
    private sef EjP;
    private String Sj;
    private boolean TKC;
    private boolean sP;

    public sP(String str, boolean z, boolean z2, sef sefVar) {
        this.Sj = str;
        this.sP = z;
        this.TKC = z2;
        this.EjP = sefVar;
    }

    @Override // com.bytedance.sdk.component.HiB.HiB
    public String Sj() {
        return this.Sj;
    }

    @Override // com.bytedance.sdk.component.HiB.HiB
    public boolean TKC() {
        return this.TKC;
    }

    @Override // com.bytedance.sdk.component.HiB.HiB
    public boolean sP() {
        return this.sP;
    }
}
