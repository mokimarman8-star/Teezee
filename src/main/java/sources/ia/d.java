package ia;

import com.google.android.exoplayer2.util.p0;
import da.i;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class d implements i {
    private final List a;
    private final List b;

    public d(List list, List list2) {
        this.a = list;
        this.b = list2;
    }

    @Override // da.i
    public List getCues(long j) {
        int g = p0.g(this.b, Long.valueOf(j), true, false);
        return g == -1 ? Collections.emptyList() : (List) this.a.get(g);
    }

    @Override // da.i
    public long getEventTime(int i) {
        com.google.android.exoplayer2.util.a.a(i >= 0);
        com.google.android.exoplayer2.util.a.a(i < this.b.size());
        return ((Long) this.b.get(i)).longValue();
    }

    @Override // da.i
    public int getEventTimeCount() {
        return this.b.size();
    }

    @Override // da.i
    public int getNextEventTimeIndex(long j) {
        int d = p0.d(this.b, Long.valueOf(j), false, false);
        if (d < this.b.size()) {
            return d;
        }
        return -1;
    }
}
