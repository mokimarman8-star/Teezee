package s2;

import k2.c0;
import k2.s;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class d extends c0 {

    /* renamed from: b, reason: collision with root package name */
    private final long f17733b;

    public d(s sVar, long j5) {
        super(sVar);
        androidx.media3.common.util.a.a(sVar.getPosition() >= j5);
        this.f17733b = j5;
    }

    @Override // k2.c0, k2.s
    public long getLength() {
        return super.getLength() - this.f17733b;
    }

    @Override // k2.c0, k2.s
    public long getPeekPosition() {
        return super.getPeekPosition() - this.f17733b;
    }

    @Override // k2.c0, k2.s
    public long getPosition() {
        return super.getPosition() - this.f17733b;
    }
}
