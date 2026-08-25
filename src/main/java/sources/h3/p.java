package h3;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class p extends androidx.media3.decoder.h implements k {

    /* renamed from: a, reason: collision with root package name */
    private k f15502a;

    /* renamed from: b, reason: collision with root package name */
    private long f15503b;

    public void a(long j5, k kVar, long j6) {
        this.timeUs = j5;
        this.f15502a = kVar;
        if (j6 != Long.MAX_VALUE) {
            j5 = j6;
        }
        this.f15503b = j5;
    }

    @Override // androidx.media3.decoder.h, androidx.media3.decoder.a
    public void clear() {
        super.clear();
        this.f15502a = null;
    }

    @Override // h3.k
    public List getCues(long j5) {
        return ((k) androidx.media3.common.util.a.e(this.f15502a)).getCues(j5 - this.f15503b);
    }

    @Override // h3.k
    public long getEventTime(int i5) {
        return ((k) androidx.media3.common.util.a.e(this.f15502a)).getEventTime(i5) + this.f15503b;
    }

    @Override // h3.k
    public int getEventTimeCount() {
        return ((k) androidx.media3.common.util.a.e(this.f15502a)).getEventTimeCount();
    }

    @Override // h3.k
    public int getNextEventTimeIndex(long j5) {
        return ((k) androidx.media3.common.util.a.e(this.f15502a)).getNextEventTimeIndex(j5 - this.f15503b);
    }
}
