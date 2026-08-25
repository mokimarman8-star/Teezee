package da;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class n extends com.google.android.exoplayer2.decoder.f implements i {
    private i d;
    private long e;

    public void b() {
        super/*com.google.android.exoplayer2.decoder.a*/.b();
        this.d = null;
    }

    @Override // da.i
    public List getCues(long j) {
        return ((i) com.google.android.exoplayer2.util.a.e(this.d)).getCues(j - this.e);
    }

    @Override // da.i
    public long getEventTime(int i) {
        return ((i) com.google.android.exoplayer2.util.a.e(this.d)).getEventTime(i) + this.e;
    }

    @Override // da.i
    public int getEventTimeCount() {
        return ((i) com.google.android.exoplayer2.util.a.e(this.d)).getEventTimeCount();
    }

    @Override // da.i
    public int getNextEventTimeIndex(long j) {
        return ((i) com.google.android.exoplayer2.util.a.e(this.d)).getNextEventTimeIndex(j - this.e);
    }

    public void m(long j, i iVar, long j2) {
        ((com.google.android.exoplayer2.decoder.f) this).b = j;
        this.d = iVar;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.e = j;
    }
}
