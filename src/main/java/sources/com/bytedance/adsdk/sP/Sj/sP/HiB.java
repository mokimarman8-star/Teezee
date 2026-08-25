package com.bytedance.adsdk.sP.Sj.sP;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HiB extends Jcg<com.bytedance.adsdk.sP.TKC.sP.EjP> {
    private final com.bytedance.adsdk.sP.TKC.sP.EjP EjP;

    public HiB(List<com.bytedance.adsdk.sP.Jcg.Sj<com.bytedance.adsdk.sP.TKC.sP.EjP>> list) {
        super(list);
        com.bytedance.adsdk.sP.TKC.sP.EjP ejP = list.get(0).Sj;
        int TKC = ejP != null ? ejP.TKC() : 0;
        this.EjP = new com.bytedance.adsdk.sP.TKC.sP.EjP(new float[TKC], new int[TKC]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj
    /* renamed from: sP, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.sP.TKC.sP.EjP Sj(com.bytedance.adsdk.sP.Jcg.Sj<com.bytedance.adsdk.sP.TKC.sP.EjP> sj, float f) {
        this.EjP.Sj(sj.Sj, sj.sP, f);
        return this.EjP;
    }
}
