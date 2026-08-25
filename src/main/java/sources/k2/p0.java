package k2;

import k2.m0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class p0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final long f16282a;

    /* renamed from: b, reason: collision with root package name */
    private final long f16283b;

    public p0(long j5) {
        this(j5, 0L);
    }

    public p0(long j5, long j6) {
        this.f16282a = j5;
        this.f16283b = j6;
    }

    @Override // k2.m0
    public long getDurationUs() {
        return this.f16282a;
    }

    @Override // k2.m0
    public m0.a getSeekPoints(long j5) {
        return new m0.a(new n0(j5, this.f16283b));
    }

    @Override // k2.m0
    public boolean isSeekable() {
        return true;
    }
}
