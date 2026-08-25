package i3;

import h3.k;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class f implements k {

    /* renamed from: a, reason: collision with root package name */
    private final List f15775a;

    public f(List list) {
        this.f15775a = list;
    }

    @Override // h3.k
    public List getCues(long j5) {
        return j5 >= 0 ? this.f15775a : Collections.emptyList();
    }

    @Override // h3.k
    public long getEventTime(int i5) {
        androidx.media3.common.util.a.a(i5 == 0);
        return 0L;
    }

    @Override // h3.k
    public int getEventTimeCount() {
        return 1;
    }

    @Override // h3.k
    public int getNextEventTimeIndex(long j5) {
        return j5 < 0 ? 0 : -1;
    }
}
