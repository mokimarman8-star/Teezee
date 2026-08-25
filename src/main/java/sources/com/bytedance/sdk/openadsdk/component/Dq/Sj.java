package com.bytedance.sdk.openadsdk.component.Dq;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class Sj {
    private float Sj;
    private long sP;

    public float Sj() {
        return this.Sj;
    }

    public void Sj(float f) {
        StringBuilder sb = new StringBuilder("setTotalTime() called with: time = [");
        sb.append(f);
        sb.append("]");
        this.Sj = f;
    }

    public void Sj(long j) {
        this.sP = j;
    }

    public long sP() {
        return this.sP;
    }
}
