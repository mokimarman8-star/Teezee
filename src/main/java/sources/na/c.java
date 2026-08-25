package na;

import android.os.SystemClock;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class c implements s {
    protected final v9.w a;
    protected final int b;
    protected final int[] c;
    private final int d;
    private final p1[] e;
    private final long[] f;
    private int g;

    public c(v9.w wVar, int... iArr) {
        this(wVar, iArr, 0);
    }

    public c(v9.w wVar, int[] iArr, int i) {
        int i2 = 0;
        com.google.android.exoplayer2.util.a.g(iArr.length > 0);
        this.d = i;
        this.a = (v9.w) com.google.android.exoplayer2.util.a.e(wVar);
        int length = iArr.length;
        this.b = length;
        this.e = new p1[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.e[i3] = wVar.c(iArr[i3]);
        }
        Arrays.sort(this.e, new Comparator() { // from class: na.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i4;
                i4 = c.i((p1) obj, (p1) obj2);
                return i4;
            }
        });
        this.c = new int[this.b];
        while (true) {
            int i4 = this.b;
            if (i2 >= i4) {
                this.f = new long[i4];
                return;
            } else {
                this.c[i2] = wVar.d(this.e[i2]);
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int i(p1 p1Var, p1 p1Var2) {
        return p1Var2.h - p1Var.h;
    }

    @Override // na.s
    public /* synthetic */ void a() {
        r.a(this);
    }

    @Override // na.s
    public /* synthetic */ void b(boolean z) {
        r.b(this, z);
    }

    @Override // na.s
    public boolean blacklist(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean d = d(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.b && !d) {
            d = (i2 == i || d(i2, elapsedRealtime)) ? false : true;
            i2++;
        }
        if (!d) {
            return false;
        }
        long[] jArr = this.f;
        jArr[i] = Math.max(jArr[i], p0.b(elapsedRealtime, j, Long.MAX_VALUE));
        return true;
    }

    @Override // na.s
    public /* synthetic */ void c() {
        r.c(this);
    }

    @Override // na.s
    public boolean d(int i, long j) {
        return this.f[i] > j;
    }

    @Override // na.s
    public void disable() {
    }

    @Override // na.s
    public /* synthetic */ boolean e(long j, x9.f fVar, List list) {
        return r.d(this, j, fVar, list);
    }

    @Override // na.s
    public void enable() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && Arrays.equals(this.c, cVar.c);
    }

    @Override // na.s
    public int evaluateQueueSize(long j, List list) {
        return list.size();
    }

    @Override // na.v
    public final int g(p1 p1Var) {
        for (int i = 0; i < this.b; i++) {
            if (this.e[i] == p1Var) {
                return i;
            }
        }
        return -1;
    }

    @Override // na.v
    public final p1 getFormat(int i) {
        return this.e[i];
    }

    @Override // na.v
    public final int getIndexInTrackGroup(int i) {
        return this.c[i];
    }

    @Override // na.s
    public final p1 getSelectedFormat() {
        return this.e[getSelectedIndex()];
    }

    @Override // na.s
    public final int getSelectedIndexInTrackGroup() {
        return this.c[getSelectedIndex()];
    }

    @Override // na.v
    public final v9.w getTrackGroup() {
        return this.a;
    }

    public int hashCode() {
        if (this.g == 0) {
            this.g = (System.identityHashCode(this.a) * 31) + Arrays.hashCode(this.c);
        }
        return this.g;
    }

    @Override // na.v
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // na.v
    public final int length() {
        return this.c.length;
    }

    @Override // na.s
    public void onPlaybackSpeed(float f) {
    }
}
