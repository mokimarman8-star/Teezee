package com.bytedance.sdk.component.sP.Sj;

import java.nio.charset.Charset;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class uA {
    private String Sj;
    private String sP;

    private uA(String str) {
        this.Sj = str;
    }

    public static uA Sj(String str) {
        return new uA(str);
    }

    public String Sj() {
        return this.Sj;
    }

    public Charset Sj(Charset charset) {
        try {
            String str = this.sP;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
