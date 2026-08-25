package com.bytedance.sdk.openadsdk.Zq.TKC;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class EjP implements sP {
    private static volatile EjP Sj;

    private EjP() {
    }

    public static EjP Sj() {
        if (Sj == null) {
            synchronized (EjP.class) {
                try {
                    if (Sj == null) {
                        Sj = new EjP();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Sj;
    }

    @Override // com.bytedance.sdk.openadsdk.Zq.TKC.sP
    public void Sj(com.bytedance.sdk.openadsdk.Zq.sP sPVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.Zq.TKC.sP
    public void Sj(com.bytedance.sdk.openadsdk.Zq.sP sPVar, boolean z) {
    }
}
