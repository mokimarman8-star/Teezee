package com.bytedance.sdk.component.sP.Sj;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sef {
    public String EjP;
    public byte[] HiB;
    public uA TKC;
    public Sj vS;

    public enum Sj {
        STRING_TYPE,
        BYTE_ARRAY_TYPE
    }

    public sef() {
    }

    public sef(uA uAVar, String str, Sj sj) {
        this.TKC = uAVar;
        this.EjP = str;
        this.vS = sj;
    }

    public sef(uA uAVar, byte[] bArr, Sj sj) {
        this.TKC = uAVar;
        this.HiB = bArr;
        this.vS = sj;
    }

    public static sef Sj(uA uAVar, String str) {
        return new sef(uAVar, str, Sj.STRING_TYPE);
    }

    public static sef Sj(uA uAVar, byte[] bArr) {
        return new sef(uAVar, bArr, Sj.BYTE_ARRAY_TYPE);
    }
}
