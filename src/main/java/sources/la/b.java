package la;

import da.i;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class b implements i {
    public static final b b = new b();
    private final List a;

    private b() {
        this.a = Collections.emptyList();
    }

    public b(da.b bVar) {
        this.a = Collections.singletonList(bVar);
    }

    @Override // da.i
    public List getCues(long j) {
        return j >= 0 ? this.a : Collections.emptyList();
    }

    @Override // da.i
    public long getEventTime(int i) {
        com.google.android.exoplayer2.util.a.a(i == 0);
        return 0L;
    }

    @Override // da.i
    public int getEventTimeCount() {
        return 1;
    }

    @Override // da.i
    public int getNextEventTimeIndex(long j) {
        return j < 0 ? 0 : -1;
    }
}
