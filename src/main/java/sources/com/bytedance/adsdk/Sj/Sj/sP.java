package com.bytedance.adsdk.Sj.Sj;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP extends RuntimeException {
    public sP(String str, Throwable th) {
        super("Unable to parse expression:".concat(String.valueOf(str)), th);
    }
}
