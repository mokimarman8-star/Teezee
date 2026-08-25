package k2;

import k2.m0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final m0 f16145a;

    public d0(m0 m0Var) {
        this.f16145a = m0Var;
    }

    @Override // k2.m0
    public long getDurationUs() {
        return this.f16145a.getDurationUs();
    }

    @Override // k2.m0
    public m0.a getSeekPoints(long j5) {
        return this.f16145a.getSeekPoints(j5);
    }

    @Override // k2.m0
    public boolean isSeekable() {
        return this.f16145a.isSeekable();
    }
}
