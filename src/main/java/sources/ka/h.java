package ka;

import com.google.android.exoplayer2.util.p0;
import da.i;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class h implements i {
    private final d a;
    private final long[] b;
    private final Map c;
    private final Map d;
    private final Map e;

    public h(d dVar, Map map, Map map2, Map map3) {
        this.a = dVar;
        this.d = map2;
        this.e = map3;
        this.c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.b = dVar.j();
    }

    @Override // da.i
    public List getCues(long j) {
        return this.a.h(j, this.c, this.d, this.e);
    }

    @Override // da.i
    public long getEventTime(int i) {
        return this.b[i];
    }

    @Override // da.i
    public int getEventTimeCount() {
        return this.b.length;
    }

    @Override // da.i
    public int getNextEventTimeIndex(long j) {
        int e = p0.e(this.b, j, false, false);
        if (e < this.b.length) {
            return e;
        }
        return -1;
    }
}
