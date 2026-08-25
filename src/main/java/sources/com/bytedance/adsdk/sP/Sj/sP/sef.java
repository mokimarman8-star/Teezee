package com.bytedance.adsdk.sP.Sj.sP;

import android.graphics.PointF;
import java.util.Collections;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sef extends Sj<PointF, PointF> {
    private final Sj<Float, Float> Dq;
    protected com.bytedance.adsdk.sP.Jcg.sP<Float> EjP;
    protected com.bytedance.adsdk.sP.Jcg.sP<Float> HiB;
    private final PointF Jcg;
    private final Sj<Float, Float> uA;
    private final PointF vS;

    public sef(Sj<Float, Float> sj, Sj<Float, Float> sj2) {
        super(Collections.emptyList());
        this.vS = new PointF();
        this.Jcg = new PointF();
        this.Dq = sj;
        this.uA = sj2;
        Sj(Dq());
    }

    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj
    public void Sj(float f) {
        this.Dq.Sj(f);
        this.uA.Sj(f);
        this.vS.set(this.Dq.Jcg().floatValue(), this.uA.Jcg().floatValue());
        for (int i = 0; i < this.Sj.size(); i++) {
            this.Sj.get(i).Sj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj
    /* renamed from: sP, reason: merged with bridge method [inline-methods] */
    public PointF Sj(com.bytedance.adsdk.sP.Jcg.Sj<PointF> sj, float f) {
        if (this.EjP != null && this.Dq.TKC() != null) {
            this.Dq.HiB();
            throw null;
        }
        if (this.HiB != null && this.uA.TKC() != null) {
            this.uA.HiB();
            throw null;
        }
        this.Jcg.set(this.vS.x, 0.0f);
        PointF pointF = this.Jcg;
        pointF.set(pointF.x, this.vS.y);
        return this.Jcg;
    }

    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj
    /* renamed from: uA, reason: merged with bridge method [inline-methods] */
    public PointF Jcg() {
        return Sj(null, 0.0f);
    }
}
