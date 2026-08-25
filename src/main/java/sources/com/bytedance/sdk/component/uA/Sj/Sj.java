package com.bytedance.sdk.component.uA.Sj;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    private static volatile Sj sP;
    private volatile sP Sj;

    private Sj() {
    }

    public static Sj Sj() {
        if (sP == null) {
            synchronized (Sj.class) {
                try {
                    if (sP == null) {
                        sP = new Sj();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sP;
    }

    public void Sj(sP sPVar) {
        this.Sj = sPVar;
    }

    public sP sP() {
        return this.Sj;
    }
}
