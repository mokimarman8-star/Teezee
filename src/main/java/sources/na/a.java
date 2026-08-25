package na;

import com.google.android.exoplayer2.l3;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.g3;
import com.google.common.collect.i3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import na.s;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a extends c {
    private final com.google.android.exoplayer2.upstream.e h;
    private final long i;
    private final long j;
    private final long k;
    private final int l;
    private final int m;
    private final float n;
    private final float o;
    private final ImmutableList p;
    private final com.google.android.exoplayer2.util.e q;
    private float r;
    private int s;
    private int t;
    private long u;
    private x9.n v;

    /* renamed from: na.a$a, reason: collision with other inner class name */
    public static final class C0057a {
        public final long a;
        public final long b;

        public C0057a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0057a)) {
                return false;
            }
            C0057a c0057a = (C0057a) obj;
            return this.a == c0057a.a && this.b == c0057a.b;
        }

        public int hashCode() {
            return (((int) this.a) * 31) + ((int) this.b);
        }
    }

    public static class b implements s.b {
        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final float f;
        private final float g;
        private final com.google.android.exoplayer2.util.e h;

        public b() {
            this(10000, 25000, 25000, 0.7f);
        }

        public b(int i, int i2, int i3, float f) {
            this(i, i2, i3, 1279, 719, f, 0.75f, com.google.android.exoplayer2.util.e.a);
        }

        public b(int i, int i2, int i3, int i4, int i5, float f, float f2, com.google.android.exoplayer2.util.e eVar) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = f;
            this.g = f2;
            this.h = eVar;
        }

        @Override // na.s.b
        public final s[] a(s.a[] aVarArr, com.google.android.exoplayer2.upstream.e eVar, o.b bVar, l3 l3Var) {
            ImmutableList n = a.n(aVarArr);
            s[] sVarArr = new s[aVarArr.length];
            for (int i = 0; i < aVarArr.length; i++) {
                s.a aVar = aVarArr[i];
                if (aVar != null) {
                    int[] iArr = aVar.b;
                    if (iArr.length != 0) {
                        sVarArr[i] = iArr.length == 1 ? new t(aVar.a, iArr[0], aVar.c) : b(aVar.a, iArr, aVar.c, eVar, (ImmutableList) n.get(i));
                    }
                }
            }
            return sVarArr;
        }

        protected a b(v9.w wVar, int[] iArr, int i, com.google.android.exoplayer2.upstream.e eVar, ImmutableList immutableList) {
            return new a(wVar, iArr, i, eVar, this.a, this.b, this.c, this.d, this.e, this.f, this.g, immutableList, this.h);
        }
    }

    protected a(v9.w wVar, int[] iArr, int i, com.google.android.exoplayer2.upstream.e eVar, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, com.google.android.exoplayer2.util.e eVar2) {
        super(wVar, iArr, i);
        com.google.android.exoplayer2.upstream.e eVar3;
        long j4;
        if (j3 < j) {
            com.google.android.exoplayer2.util.s.i("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            eVar3 = eVar;
            j4 = j;
        } else {
            eVar3 = eVar;
            j4 = j3;
        }
        this.h = eVar3;
        this.i = j * 1000;
        this.j = j2 * 1000;
        this.k = j4 * 1000;
        this.l = i2;
        this.m = i3;
        this.n = f;
        this.o = f2;
        this.p = ImmutableList.copyOf(list);
        this.q = eVar2;
        this.r = 1.0f;
        this.t = 0;
        this.u = -9223372036854775807L;
    }

    private static void k(List list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            ImmutableList.a aVar = (ImmutableList.a) list.get(i);
            if (aVar != null) {
                aVar.j(new C0057a(j, jArr[i]));
            }
        }
    }

    private int m(long j, long j2) {
        long o = o(j2);
        int i = 0;
        for (int i2 = 0; i2 < this.b; i2++) {
            if (j == Long.MIN_VALUE || !d(i2, j)) {
                p1 format = getFormat(i2);
                if (l(format, format.h, o)) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImmutableList n(s.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (s.a aVar : aVarArr) {
            if (aVar == null || aVar.b.length <= 1) {
                arrayList.add(null);
            } else {
                ImmutableList.a builder = ImmutableList.builder();
                builder.j(new C0057a(0L, 0L));
                arrayList.add(builder);
            }
        }
        long[][] s = s(aVarArr);
        int[] iArr = new int[s.length];
        long[] jArr = new long[s.length];
        for (int i = 0; i < s.length; i++) {
            long[] jArr2 = s[i];
            jArr[i] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        k(arrayList, jArr);
        ImmutableList t = t(s);
        for (int i2 = 0; i2 < t.size(); i2++) {
            int intValue = ((Integer) t.get(i2)).intValue();
            int i3 = iArr[intValue] + 1;
            iArr[intValue] = i3;
            jArr[intValue] = s[intValue][i3];
            k(arrayList, jArr);
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            if (arrayList.get(i4) != null) {
                jArr[i4] = jArr[i4] * 2;
            }
        }
        k(arrayList, jArr);
        ImmutableList.a builder2 = ImmutableList.builder();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ImmutableList.a aVar2 = (ImmutableList.a) arrayList.get(i5);
            builder2.j(aVar2 == null ? ImmutableList.of() : aVar2.n());
        }
        return builder2.n();
    }

    private long o(long j) {
        long u = u(j);
        if (this.p.isEmpty()) {
            return u;
        }
        int i = 1;
        while (i < this.p.size() - 1 && ((C0057a) this.p.get(i)).a < u) {
            i++;
        }
        C0057a c0057a = (C0057a) this.p.get(i - 1);
        C0057a c0057a2 = (C0057a) this.p.get(i);
        long j2 = c0057a.a;
        float f = (u - j2) / (c0057a2.a - j2);
        return c0057a.b + ((long) (f * (c0057a2.b - r2)));
    }

    private long p(List list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        x9.n nVar = (x9.n) g3.g(list);
        long j = nVar.g;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = nVar.h;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    private long r(x9.o[] oVarArr, List list) {
        int i = this.s;
        if (i < oVarArr.length && oVarArr[i].next()) {
            x9.o oVar = oVarArr[this.s];
            return oVar.b() - oVar.a();
        }
        for (x9.o oVar2 : oVarArr) {
            if (oVar2.next()) {
                return oVar2.b() - oVar2.a();
            }
        }
        return p(list);
    }

    private static long[][] s(s.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i = 0; i < aVarArr.length; i++) {
            s.a aVar = aVarArr[i];
            if (aVar == null) {
                jArr[i] = new long[0];
            } else {
                jArr[i] = new long[aVar.b.length];
                int i2 = 0;
                while (true) {
                    if (i2 >= aVar.b.length) {
                        break;
                    }
                    jArr[i][i2] = aVar.a.c(r5[i2]).h;
                    i2++;
                }
                Arrays.sort(jArr[i]);
            }
        }
        return jArr;
    }

    private static ImmutableList t(long[][] jArr) {
        i3 g = MultimapBuilder.e().a().g();
        for (int i = 0; i < jArr.length; i++) {
            long[] jArr2 = jArr[i];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i2 = 0;
                while (true) {
                    long[] jArr3 = jArr[i];
                    double d = 0.0d;
                    if (i2 >= jArr3.length) {
                        break;
                    }
                    long j = jArr3[i2];
                    if (j != -1) {
                        d = Math.log(j);
                    }
                    dArr[i2] = d;
                    i2++;
                }
                int i3 = length - 1;
                double d2 = dArr[i3] - dArr[0];
                int i4 = 0;
                while (i4 < i3) {
                    double d3 = dArr[i4];
                    i4++;
                    g.put(Double.valueOf(d2 == 0.0d ? 1.0d : (((d3 + dArr[i4]) * 0.5d) - dArr[0]) / d2), Integer.valueOf(i));
                }
            }
        }
        return ImmutableList.copyOf(g.values());
    }

    private long u(long j) {
        long bitrateEstimate = (long) (this.h.getBitrateEstimate() * this.n);
        long a = this.h.a();
        if (a == -9223372036854775807L || j == -9223372036854775807L) {
            return (long) (bitrateEstimate / this.r);
        }
        float f = j;
        return (long) ((bitrateEstimate * Math.max((f / this.r) - a, 0.0f)) / f);
    }

    private long v(long j, long j2) {
        if (j == -9223372036854775807L) {
            return this.i;
        }
        if (j2 != -9223372036854775807L) {
            j -= j2;
        }
        return Math.min((long) (j * this.o), this.i);
    }

    @Override // na.c, na.s
    public void disable() {
        this.v = null;
    }

    @Override // na.c, na.s
    public void enable() {
        this.u = -9223372036854775807L;
        this.v = null;
    }

    @Override // na.c, na.s
    public int evaluateQueueSize(long j, List list) {
        int i;
        int i2;
        long elapsedRealtime = this.q.elapsedRealtime();
        if (!w(elapsedRealtime, list)) {
            return list.size();
        }
        this.u = elapsedRealtime;
        this.v = list.isEmpty() ? null : (x9.n) g3.g(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long f0 = p0.f0(((x9.n) list.get(size - 1)).g - j, this.r);
        long q = q();
        if (f0 < q) {
            return size;
        }
        p1 format = getFormat(m(elapsedRealtime, p(list)));
        for (int i3 = 0; i3 < size; i3++) {
            x9.n nVar = (x9.n) list.get(i3);
            p1 p1Var = nVar.d;
            if (p0.f0(nVar.g - j, this.r) >= q && p1Var.h < format.h && (i = p1Var.r) != -1 && i <= this.m && (i2 = p1Var.q) != -1 && i2 <= this.l && i < format.r) {
                return i3;
            }
        }
        return size;
    }

    @Override // na.s
    public void f(long j, long j2, long j3, List list, x9.o[] oVarArr) {
        long elapsedRealtime = this.q.elapsedRealtime();
        long r = r(oVarArr, list);
        int i = this.t;
        if (i == 0) {
            this.t = 1;
            this.s = m(elapsedRealtime, r);
            return;
        }
        int i2 = this.s;
        int g = list.isEmpty() ? -1 : g(((x9.n) g3.g(list)).d);
        if (g != -1) {
            i = ((x9.n) g3.g(list)).e;
            i2 = g;
        }
        int m = m(elapsedRealtime, r);
        if (!d(i2, elapsedRealtime)) {
            p1 format = getFormat(i2);
            p1 format2 = getFormat(m);
            long v = v(j3, r);
            int i3 = format2.h;
            int i4 = format.h;
            if ((i3 > i4 && j2 < v) || (i3 < i4 && j2 >= this.j)) {
                m = i2;
            }
        }
        if (m != i2) {
            i = 3;
        }
        this.t = i;
        this.s = m;
    }

    @Override // na.s
    public int getSelectedIndex() {
        return this.s;
    }

    @Override // na.s
    public Object getSelectionData() {
        return null;
    }

    @Override // na.s
    public int getSelectionReason() {
        return this.t;
    }

    protected boolean l(p1 p1Var, int i, long j) {
        return ((long) i) <= j;
    }

    @Override // na.c, na.s
    public void onPlaybackSpeed(float f) {
        this.r = f;
    }

    protected long q() {
        return this.k;
    }

    protected boolean w(long j, List list) {
        long j2 = this.u;
        return j2 == -9223372036854775807L || j - j2 >= 1000 || !(list.isEmpty() || ((x9.n) g3.g(list)).equals(this.v));
    }
}
