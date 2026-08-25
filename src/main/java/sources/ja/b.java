package ja;

import com.google.android.exoplayer2.util.p0;
import da.i;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class b implements i {
    private final da.b[] a;
    private final long[] b;

    public b(da.b[] bVarArr, long[] jArr) {
        this.a = bVarArr;
        this.b = jArr;
    }

    @Override // da.i
    public List getCues(long j) {
        da.b bVar;
        int i = p0.i(this.b, j, true, false);
        return (i == -1 || (bVar = this.a[i]) == da.b.r) ? Collections.emptyList() : Collections.singletonList(bVar);
    }

    @Override // da.i
    public long getEventTime(int i) {
        com.google.android.exoplayer2.util.a.a(i >= 0);
        com.google.android.exoplayer2.util.a.a(i < this.b.length);
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
