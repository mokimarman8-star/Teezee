package n9;

import i9.m;
import i9.w;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class c extends w {
    private final long b;

    public c(m mVar, long j) {
        super(mVar);
        com.google.android.exoplayer2.util.a.a(mVar.getPosition() >= j);
        this.b = j;
    }

    @Override // i9.w, i9.m
    public long getLength() {
        return super.getLength() - this.b;
    }

    @Override // i9.w, i9.m
    public long getPeekPosition() {
        return super.getPeekPosition() - this.b;
    }

    @Override // i9.w, i9.m
    public long getPosition() {
        return super.getPosition() - this.b;
    }
}
