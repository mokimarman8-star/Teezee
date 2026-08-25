package com.bytedance.sdk.component.Jcg;

import com.bytedance.sdk.component.sP.Sj.TEQ;
import java.io.File;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    final String EjP;
    final long HiB;
    TEQ Jcg;
    final int Sj;
    final Map<String, String> TKC;
    final String sP;
    private final boolean uA;
    final long vS;
    private File Dq = null;
    private byte[] TEQ = null;

    public sP(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.uA = z;
        this.Sj = i;
        this.sP = str;
        this.TKC = map;
        this.EjP = str2;
        this.HiB = j;
        this.vS = j2;
    }

    public String EjP() {
        return this.EjP;
    }

    public File HiB() {
        return this.Dq;
    }

    public TEQ Jcg() {
        return this.Jcg;
    }

    public int Sj() {
        return this.Sj;
    }

    public void Sj(TEQ teq) {
        this.Jcg = teq;
    }

    public void Sj(File file) {
        this.Dq = file;
    }

    public void Sj(byte[] bArr) {
        this.TEQ = bArr;
    }

    public Map<String, String> TKC() {
        return this.TKC;
    }

    public String sP() {
        return this.sP;
    }

    public boolean vS() {
        return this.uA;
    }
}
