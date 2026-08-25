package na;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.media3.exoplayer.audio.w0;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.l3;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.z2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.h2;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import na.a;
import na.m;
import na.s;
import na.u;
import na.z;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class m extends u {
    private static final Ordering k = Ordering.from(new Comparator() { // from class: na.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int P;
            P = m.P((Integer) obj, (Integer) obj2);
            return P;
        }
    });
    private static final Ordering l = Ordering.from(new Comparator() { // from class: na.e
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int Q;
            Q = m.Q((Integer) obj, (Integer) obj2);
            return Q;
        }
    });
    private final Object d;
    public final Context e;
    private final s.b f;
    private final boolean g;
    private d h;
    private f i;
    private com.google.android.exoplayer2.audio.e j;

    /* JADX INFO: Access modifiers changed from: private */
    static final class b extends h implements Comparable {
        private final int e;
        private final boolean f;
        private final String g;
        private final d h;
        private final boolean i;
        private final int j;
        private final int k;
        private final int l;
        private final boolean m;
        private final int n;
        private final int o;
        private final boolean p;
        private final int q;
        private final int r;
        private final int s;
        private final int t;
        private final boolean u;
        private final boolean v;

        public b(int i, v9.w wVar, int i2, d dVar, int i3, boolean z, com.google.common.base.n nVar) {
            super(i, wVar, i2);
            int i4;
            int i5;
            int i6;
            this.h = dVar;
            this.g = m.T(this.d.c);
            this.i = m.L(i3, false);
            int i7 = 0;
            while (true) {
                i4 = Integer.MAX_VALUE;
                if (i7 >= dVar.n.size()) {
                    i5 = 0;
                    i7 = Integer.MAX_VALUE;
                    break;
                } else {
                    i5 = m.D(this.d, (String) dVar.n.get(i7), false);
                    if (i5 > 0) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            this.k = i7;
            this.j = i5;
            this.l = m.H(this.d.e, dVar.o);
            p1 p1Var = this.d;
            int i10 = p1Var.e;
            this.m = i10 == 0 || (i10 & 1) != 0;
            this.p = (p1Var.d & 1) != 0;
            int i11 = p1Var.y;
            this.q = i11;
            this.r = p1Var.z;
            int i12 = p1Var.h;
            this.s = i12;
            this.f = (i12 == -1 || i12 <= dVar.q) && (i11 == -1 || i11 <= dVar.p) && nVar.apply(p1Var);
            String[] i0 = p0.i0();
            int i13 = 0;
            while (true) {
                if (i13 >= i0.length) {
                    i6 = 0;
                    i13 = Integer.MAX_VALUE;
                    break;
                } else {
                    i6 = m.D(this.d, i0[i13], false);
                    if (i6 > 0) {
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            this.n = i13;
            this.o = i6;
            int i14 = 0;
            while (true) {
                if (i14 < dVar.r.size()) {
                    String str = this.d.l;
                    if (str != null && str.equals(dVar.r.get(i14))) {
                        i4 = i14;
                        break;
                    }
                    i14++;
                } else {
                    break;
                }
            }
            this.t = i4;
            this.u = z2.e(i3) == 128;
            this.v = z2.g(i3) == 64;
            this.e = g(i3, z);
        }

        public static int d(List list, List list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static ImmutableList f(int i, v9.w wVar, d dVar, int[] iArr, boolean z, com.google.common.base.n nVar) {
            ImmutableList.a builder = ImmutableList.builder();
            for (int i2 = 0; i2 < wVar.a; i2++) {
                builder.j(new b(i, wVar, i2, dVar, iArr[i2], z, nVar));
            }
            return builder.n();
        }

        private int g(int i, boolean z) {
            if (!m.L(i, this.h.N)) {
                return 0;
            }
            if (!this.f && !this.h.H) {
                return 0;
            }
            if (m.L(i, false) && this.f && this.d.h != -1) {
                d dVar = this.h;
                if (!dVar.x && !dVar.w && (dVar.P || !z)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // na.m.h
        public int a() {
            return this.e;
        }

        @Override // java.lang.Comparable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            Ordering reverse = (this.f && this.i) ? m.k : m.k.reverse();
            h2 g = h2.k().h(this.i, bVar.i).g(Integer.valueOf(this.k), Integer.valueOf(bVar.k), Ordering.natural().reverse()).d(this.j, bVar.j).d(this.l, bVar.l).h(this.p, bVar.p).h(this.m, bVar.m).g(Integer.valueOf(this.n), Integer.valueOf(bVar.n), Ordering.natural().reverse()).d(this.o, bVar.o).h(this.f, bVar.f).g(Integer.valueOf(this.t), Integer.valueOf(bVar.t), Ordering.natural().reverse()).g(Integer.valueOf(this.s), Integer.valueOf(bVar.s), this.h.w ? m.k.reverse() : m.l).h(this.u, bVar.u).h(this.v, bVar.v).g(Integer.valueOf(this.q), Integer.valueOf(bVar.q), reverse).g(Integer.valueOf(this.r), Integer.valueOf(bVar.r), reverse);
            Integer valueOf = Integer.valueOf(this.s);
            Integer valueOf2 = Integer.valueOf(bVar.s);
            if (!p0.c(this.g, bVar.g)) {
                reverse = m.l;
            }
            return g.g(valueOf, valueOf2, reverse).j();
        }

        @Override // na.m.h
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean b(b bVar) {
            int i;
            String str;
            int i2;
            d dVar = this.h;
            if ((dVar.K || ((i2 = this.d.y) != -1 && i2 == bVar.d.y)) && (dVar.I || ((str = this.d.l) != null && TextUtils.equals(str, bVar.d.l)))) {
                d dVar2 = this.h;
                if ((dVar2.J || ((i = this.d.z) != -1 && i == bVar.d.z)) && (dVar2.L || (this.u == bVar.u && this.v == bVar.v))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class c implements Comparable {
        private final boolean a;
        private final boolean b;

        public c(p1 p1Var, int i) {
            this.a = (p1Var.d & 1) != 0;
            this.b = m.L(i, false);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return h2.k().h(this.b, cVar.b).h(this.a, cVar.a).j();
        }
    }

    public static final class d extends z implements com.google.android.exoplayer2.k {
        public static final d S;
        public static final d T;
        public static final k.a U;
        public final boolean D;
        public final boolean E;
        public final boolean F;
        public final boolean G;
        public final boolean H;
        public final boolean I;
        public final boolean J;
        public final boolean K;
        public final boolean L;
        public final boolean M;
        public final boolean N;
        public final boolean O;
        public final boolean P;
        private final SparseArray Q;
        private final SparseBooleanArray R;

        public static final class a extends z.a {
            private boolean A;
            private boolean B;
            private boolean C;
            private boolean D;
            private boolean E;
            private boolean F;
            private boolean G;
            private boolean H;
            private boolean I;
            private boolean J;
            private boolean K;
            private boolean L;
            private boolean M;
            private final SparseArray N;
            private final SparseBooleanArray O;

            @Deprecated
            public a() {
                this.N = new SparseArray();
                this.O = new SparseBooleanArray();
                e0();
            }

            public a(Context context) {
                super(context);
                this.N = new SparseArray();
                this.O = new SparseBooleanArray();
                e0();
            }

            private a(Bundle bundle) {
                super(bundle);
                e0();
                d dVar = d.S;
                s0(bundle.getBoolean(z.c(1000), dVar.D));
                n0(bundle.getBoolean(z.c(1001), dVar.E));
                o0(bundle.getBoolean(z.c(1002), dVar.F));
                m0(bundle.getBoolean(z.c(1014), dVar.G));
                q0(bundle.getBoolean(z.c(1003), dVar.H));
                j0(bundle.getBoolean(z.c(1004), dVar.I));
                k0(bundle.getBoolean(z.c(1005), dVar.J));
                h0(bundle.getBoolean(z.c(1006), dVar.K));
                i0(bundle.getBoolean(z.c(1015), dVar.L));
                p0(bundle.getBoolean(z.c(1016), dVar.M));
                r0(bundle.getBoolean(z.c(1007), dVar.N));
                z0(bundle.getBoolean(z.c(1008), dVar.O));
                l0(bundle.getBoolean(z.c(1009), dVar.P));
                this.N = new SparseArray();
                x0(bundle);
                this.O = f0(bundle.getIntArray(z.c(1013)));
            }

            private a(d dVar) {
                super(dVar);
                this.A = dVar.D;
                this.B = dVar.E;
                this.C = dVar.F;
                this.D = dVar.G;
                this.E = dVar.H;
                this.F = dVar.I;
                this.G = dVar.J;
                this.H = dVar.K;
                this.I = dVar.L;
                this.J = dVar.M;
                this.K = dVar.N;
                this.L = dVar.O;
                this.M = dVar.P;
                this.N = d0(dVar.Q);
                this.O = dVar.R.clone();
            }

            private static SparseArray d0(SparseArray sparseArray) {
                SparseArray sparseArray2 = new SparseArray();
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
                }
                return sparseArray2;
            }

            private void e0() {
                this.A = true;
                this.B = false;
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.H = false;
                this.I = false;
                this.J = true;
                this.K = true;
                this.L = false;
                this.M = true;
            }

            private SparseBooleanArray f0(int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int i : iArr) {
                    sparseBooleanArray.append(i, true);
                }
                return sparseBooleanArray;
            }

            private void x0(Bundle bundle) {
                int[] intArray = bundle.getIntArray(z.c(1010));
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(z.c(1011));
                ImmutableList of = parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(v9.y.e, parcelableArrayList);
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(z.c(1012));
                SparseArray sparseArray = sparseParcelableArray == null ? new SparseArray() : com.google.android.exoplayer2.util.d.c(e.e, sparseParcelableArray);
                if (intArray == null || intArray.length != of.size()) {
                    return;
                }
                for (int i = 0; i < intArray.length; i++) {
                    w0(intArray[i], (v9.y) of.get(i), (e) sparseArray.get(i));
                }
            }

            @Override // na.z.a
            /* renamed from: A0, reason: merged with bridge method [inline-methods] */
            public a K(int i, int i2, boolean z) {
                super.K(i, i2, z);
                return this;
            }

            @Override // na.z.a
            /* renamed from: B0, reason: merged with bridge method [inline-methods] */
            public a L(Context context, boolean z) {
                super.L(context, z);
                return this;
            }

            @Override // na.z.a
            /* renamed from: b0, reason: merged with bridge method [inline-methods] */
            public d A() {
                return new d(this);
            }

            @Override // na.z.a
            /* renamed from: c0, reason: merged with bridge method [inline-methods] */
            public a B(int i) {
                super.B(i);
                return this;
            }

            protected a g0(z zVar) {
                super.E(zVar);
                return this;
            }

            public a h0(boolean z) {
                this.H = z;
                return this;
            }

            public a i0(boolean z) {
                this.I = z;
                return this;
            }

            public a j0(boolean z) {
                this.F = z;
                return this;
            }

            public a k0(boolean z) {
                this.G = z;
                return this;
            }

            public a l0(boolean z) {
                this.M = z;
                return this;
            }

            public a m0(boolean z) {
                this.D = z;
                return this;
            }

            public a n0(boolean z) {
                this.B = z;
                return this;
            }

            public a o0(boolean z) {
                this.C = z;
                return this;
            }

            public a p0(boolean z) {
                this.J = z;
                return this;
            }

            public a q0(boolean z) {
                this.E = z;
                return this;
            }

            public a r0(boolean z) {
                this.K = z;
                return this;
            }

            public a s0(boolean z) {
                this.A = z;
                return this;
            }

            @Override // na.z.a
            /* renamed from: t0, reason: merged with bridge method [inline-methods] */
            public a F(int i) {
                super.F(i);
                return this;
            }

            @Override // na.z.a
            /* renamed from: u0, reason: merged with bridge method [inline-methods] */
            public a G(x xVar) {
                super.G(xVar);
                return this;
            }

            @Override // na.z.a
            /* renamed from: v0, reason: merged with bridge method [inline-methods] */
            public a H(Context context) {
                super.H(context);
                return this;
            }

            public a w0(int i, v9.y yVar, e eVar) {
                Map map = (Map) this.N.get(i);
                if (map == null) {
                    map = new HashMap();
                    this.N.put(i, map);
                }
                if (map.containsKey(yVar) && p0.c(map.get(yVar), eVar)) {
                    return this;
                }
                map.put(yVar, eVar);
                return this;
            }

            @Override // na.z.a
            /* renamed from: y0, reason: merged with bridge method [inline-methods] */
            public a J(int i, boolean z) {
                super.J(i, z);
                return this;
            }

            public a z0(boolean z) {
                this.L = z;
                return this;
            }
        }

        static {
            d A = new a().A();
            S = A;
            T = A;
            U = new k.a() { // from class: na.n
                public final com.google.android.exoplayer2.k a(Bundle bundle) {
                    m.d p;
                    p = m.d.p(bundle);
                    return p;
                }
            };
        }

        private d(a aVar) {
            super(aVar);
            this.D = aVar.A;
            this.E = aVar.B;
            this.F = aVar.C;
            this.G = aVar.D;
            this.H = aVar.E;
            this.I = aVar.F;
            this.J = aVar.G;
            this.K = aVar.H;
            this.L = aVar.I;
            this.M = aVar.J;
            this.N = aVar.K;
            this.O = aVar.L;
            this.P = aVar.M;
            this.Q = aVar.N;
            this.R = aVar.O;
        }

        private static boolean g(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean h(SparseArray sparseArray, SparseArray sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (indexOfKey < 0 || !i((Map) sparseArray.valueAt(i), (Map) sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean i(Map map, Map map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                v9.y yVar = (v9.y) entry.getKey();
                if (!map2.containsKey(yVar) || !p0.c(entry.getValue(), map2.get(yVar))) {
                    return false;
                }
            }
            return true;
        }

        public static d k(Context context) {
            return new a(context).A();
        }

        private static int[] l(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i = 0; i < sparseBooleanArray.size(); i++) {
                iArr[i] = sparseBooleanArray.keyAt(i);
            }
            return iArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ d p(Bundle bundle) {
            return new a(bundle).A();
        }

        private static void q(Bundle bundle, SparseArray sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                int keyAt = sparseArray.keyAt(i);
                for (Map.Entry entry : ((Map) sparseArray.valueAt(i)).entrySet()) {
                    e eVar = (e) entry.getValue();
                    if (eVar != null) {
                        sparseArray2.put(arrayList2.size(), eVar);
                    }
                    arrayList2.add((v9.y) entry.getKey());
                    arrayList.add(Integer.valueOf(keyAt));
                }
                bundle.putIntArray(z.c(1010), Ints.o(arrayList));
                bundle.putParcelableArrayList(z.c(1011), com.google.android.exoplayer2.util.d.d(arrayList2));
                bundle.putSparseParcelableArray(z.c(1012), com.google.android.exoplayer2.util.d.e(sparseArray2));
            }
        }

        @Override // na.z
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return super.equals(dVar) && this.D == dVar.D && this.E == dVar.E && this.F == dVar.F && this.G == dVar.G && this.H == dVar.H && this.I == dVar.I && this.J == dVar.J && this.K == dVar.K && this.L == dVar.L && this.M == dVar.M && this.N == dVar.N && this.O == dVar.O && this.P == dVar.P && g(this.R, dVar.R) && h(this.Q, dVar.Q);
        }

        @Override // na.z
        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + (this.G ? 1 : 0)) * 31) + (this.H ? 1 : 0)) * 31) + (this.I ? 1 : 0)) * 31) + (this.J ? 1 : 0)) * 31) + (this.K ? 1 : 0)) * 31) + (this.L ? 1 : 0)) * 31) + (this.M ? 1 : 0)) * 31) + (this.N ? 1 : 0)) * 31) + (this.O ? 1 : 0)) * 31) + (this.P ? 1 : 0);
        }

        @Override // na.z
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a();
        }

        public boolean m(int i) {
            return this.R.get(i);
        }

        public e n(int i, v9.y yVar) {
            Map map = (Map) this.Q.get(i);
            if (map != null) {
                return (e) map.get(yVar);
            }
            return null;
        }

        public boolean o(int i, v9.y yVar) {
            Map map = (Map) this.Q.get(i);
            return map != null && map.containsKey(yVar);
        }

        @Override // na.z
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(z.c(1000), this.D);
            bundle.putBoolean(z.c(1001), this.E);
            bundle.putBoolean(z.c(1002), this.F);
            bundle.putBoolean(z.c(1014), this.G);
            bundle.putBoolean(z.c(1003), this.H);
            bundle.putBoolean(z.c(1004), this.I);
            bundle.putBoolean(z.c(1005), this.J);
            bundle.putBoolean(z.c(1006), this.K);
            bundle.putBoolean(z.c(1015), this.L);
            bundle.putBoolean(z.c(1016), this.M);
            bundle.putBoolean(z.c(1007), this.N);
            bundle.putBoolean(z.c(1008), this.O);
            bundle.putBoolean(z.c(1009), this.P);
            q(bundle, this.Q);
            bundle.putIntArray(z.c(1013), l(this.R));
            return bundle;
        }
    }

    public static final class e implements com.google.android.exoplayer2.k {
        public static final k.a e = new k.a() { // from class: na.o
            public final com.google.android.exoplayer2.k a(Bundle bundle) {
                m.e c;
                c = m.e.c(bundle);
                return c;
            }
        };
        public final int a;
        public final int[] b;
        public final int c;
        public final int d;

        public e(int i, int[] iArr, int i2) {
            this.a = i;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.b = copyOf;
            this.c = iArr.length;
            this.d = i2;
            Arrays.sort(copyOf);
        }

        private static String b(int i) {
            return Integer.toString(i, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e c(Bundle bundle) {
            boolean z = false;
            int i = bundle.getInt(b(0), -1);
            int[] intArray = bundle.getIntArray(b(1));
            int i2 = bundle.getInt(b(2), -1);
            if (i >= 0 && i2 >= 0) {
                z = true;
            }
            com.google.android.exoplayer2.util.a.a(z);
            com.google.android.exoplayer2.util.a.e(intArray);
            return new e(i, intArray, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.a == eVar.a && Arrays.equals(this.b, eVar.b) && this.d == eVar.d;
        }

        public int hashCode() {
            return (((this.a * 31) + Arrays.hashCode(this.b)) * 31) + this.d;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(b(0), this.a);
            bundle.putIntArray(b(1), this.b);
            bundle.putInt(b(2), this.d);
            return bundle;
        }
    }

    private static class f {
        private final Spatializer a;
        private final boolean b;
        private Handler c;
        private Spatializer.OnSpatializerStateChangedListener d;

        class a implements Spatializer.OnSpatializerStateChangedListener {
            final /* synthetic */ m a;

            a(f fVar, m mVar) {
                this.a = mVar;
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
                this.a.S();
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
                this.a.S();
            }
        }

        private f(Spatializer spatializer) {
            this.a = spatializer;
            this.b = i2.p.a(spatializer) != 0;
        }

        public static f g(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return null;
            }
            return new f(i2.o.a(audioManager));
        }

        public boolean a(com.google.android.exoplayer2.audio.e eVar, p1 p1Var) {
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(p0.G(("audio/eac3-joc".equals(p1Var.l) && p1Var.y == 16) ? 12 : p1Var.y));
            int i = p1Var.z;
            if (i != -1) {
                channelMask.setSampleRate(i);
            }
            return i2.v.a(this.a, eVar.b().a, channelMask.build());
        }

        public void b(m mVar, Looper looper) {
            if (this.d == null && this.c == null) {
                this.d = new a(this, mVar);
                Handler handler = new Handler(looper);
                this.c = handler;
                Spatializer spatializer = this.a;
                Objects.requireNonNull(handler);
                i2.q.a(spatializer, new w0(handler), this.d);
            }
        }

        public boolean c() {
            return i2.t.a(this.a);
        }

        public boolean d() {
            return i2.u.a(this.a);
        }

        public boolean e() {
            return this.b;
        }

        public void f() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.d;
            if (onSpatializerStateChangedListener == null || this.c == null) {
                return;
            }
            i2.r.a(this.a, onSpatializerStateChangedListener);
            ((Handler) p0.j(this.c)).removeCallbacksAndMessages(null);
            this.c = null;
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class g extends h implements Comparable {
        private final int e;
        private final boolean f;
        private final boolean g;
        private final boolean h;
        private final int i;
        private final int j;
        private final int k;
        private final int l;
        private final boolean m;

        public g(int i, v9.w wVar, int i2, d dVar, int i3, String str) {
            super(i, wVar, i2);
            int i4;
            int i5 = 0;
            this.f = m.L(i3, false);
            int i6 = this.d.d & (~dVar.u);
            this.g = (i6 & 1) != 0;
            this.h = (i6 & 2) != 0;
            ImmutableList of = dVar.s.isEmpty() ? ImmutableList.of("") : dVar.s;
            int i7 = 0;
            while (true) {
                if (i7 >= of.size()) {
                    i7 = Integer.MAX_VALUE;
                    i4 = 0;
                    break;
                } else {
                    i4 = m.D(this.d, (String) of.get(i7), dVar.v);
                    if (i4 > 0) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            this.i = i7;
            this.j = i4;
            int H = m.H(this.d.e, dVar.t);
            this.k = H;
            this.m = (this.d.e & 1088) != 0;
            int D = m.D(this.d, str, m.T(str) == null);
            this.l = D;
            boolean z = i4 > 0 || (dVar.s.isEmpty() && H > 0) || this.g || (this.h && D > 0);
            if (m.L(i3, dVar.N) && z) {
                i5 = 1;
            }
            this.e = i5;
        }

        public static int d(List list, List list2) {
            return ((g) list.get(0)).compareTo((g) list2.get(0));
        }

        public static ImmutableList f(int i, v9.w wVar, d dVar, int[] iArr, String str) {
            ImmutableList.a builder = ImmutableList.builder();
            for (int i2 = 0; i2 < wVar.a; i2++) {
                builder.j(new g(i, wVar, i2, dVar, iArr[i2], str));
            }
            return builder.n();
        }

        @Override // na.m.h
        public int a() {
            return this.e;
        }

        @Override // java.lang.Comparable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            h2 d = h2.k().h(this.f, gVar.f).g(Integer.valueOf(this.i), Integer.valueOf(gVar.i), Ordering.natural().reverse()).d(this.j, gVar.j).d(this.k, gVar.k).h(this.g, gVar.g).g(Boolean.valueOf(this.h), Boolean.valueOf(gVar.h), this.j == 0 ? Ordering.natural() : Ordering.natural().reverse()).d(this.l, gVar.l);
            if (this.k == 0) {
                d = d.i(this.m, gVar.m);
            }
            return d.j();
        }

        @Override // na.m.h
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean b(g gVar) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class h {
        public final int a;
        public final v9.w b;
        public final int c;
        public final p1 d;

        public interface a {
            List a(int i, v9.w wVar, int[] iArr);
        }

        public h(int i, v9.w wVar, int i2) {
            this.a = i;
            this.b = wVar;
            this.c = i2;
            this.d = wVar.c(i2);
        }

        public abstract int a();

        public abstract boolean b(h hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class i extends h {
        private final boolean e;
        private final d f;
        private final boolean g;
        private final boolean h;
        private final int i;
        private final int j;
        private final int k;
        private final int l;
        private final boolean m;
        private final boolean n;
        private final int o;
        private final boolean p;
        private final boolean q;
        private final int r;

        /* JADX WARN: Removed duplicated region for block: B:49:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x00c8 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public i(int i, v9.w wVar, int i2, d dVar, int i3, int i4, boolean z) {
            super(i, wVar, i2);
            boolean z2;
            boolean z3;
            int i5;
            p1 p1Var;
            int i6;
            int i7;
            float f;
            int i10;
            p1 p1Var2;
            int i11;
            int i12;
            int i13;
            this.f = dVar;
            int i14 = dVar.F ? 24 : 16;
            this.n = dVar.E && (i4 & i14) != 0;
            if (z && (((i11 = (p1Var2 = this.d).q) == -1 || i11 <= dVar.a) && ((i12 = p1Var2.r) == -1 || i12 <= dVar.b))) {
                float f2 = p1Var2.s;
                if ((f2 == -1.0f || f2 <= dVar.c) && ((i13 = p1Var2.h) == -1 || i13 <= dVar.d)) {
                    z2 = true;
                    this.e = z2;
                    if (z && (((i6 = (p1Var = this.d).q) == -1 || i6 >= dVar.e) && ((i7 = p1Var.r) == -1 || i7 >= dVar.f))) {
                        f = p1Var.s;
                        if ((f != -1.0f || f >= dVar.g) && ((i10 = p1Var.h) == -1 || i10 >= dVar.h)) {
                            z3 = true;
                            this.g = z3;
                            this.h = m.L(i3, false);
                            p1 p1Var3 = this.d;
                            this.i = p1Var3.h;
                            this.j = p1Var3.f();
                            this.l = m.H(this.d.e, dVar.m);
                            int i15 = this.d.e;
                            this.m = (i15 == 0 && (i15 & 1) == 0) ? false : true;
                            i5 = 0;
                            while (true) {
                                if (i5 < dVar.l.size()) {
                                    i5 = Integer.MAX_VALUE;
                                    break;
                                }
                                String str = this.d.l;
                                if (str != null && str.equals(dVar.l.get(i5))) {
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                            this.k = i5;
                            this.p = z2.e(i3) != 128;
                            this.q = z2.g(i3) == 64;
                            this.r = m.I(this.d.l);
                            this.o = j(i3, i14);
                        }
                    }
                    z3 = false;
                    this.g = z3;
                    this.h = m.L(i3, false);
                    p1 p1Var32 = this.d;
                    this.i = p1Var32.h;
                    this.j = p1Var32.f();
                    this.l = m.H(this.d.e, dVar.m);
                    int i152 = this.d.e;
                    this.m = (i152 == 0 && (i152 & 1) == 0) ? false : true;
                    i5 = 0;
                    while (true) {
                        if (i5 < dVar.l.size()) {
                        }
                        i5++;
                    }
                    this.k = i5;
                    this.p = z2.e(i3) != 128;
                    this.q = z2.g(i3) == 64;
                    this.r = m.I(this.d.l);
                    this.o = j(i3, i14);
                }
            }
            z2 = false;
            this.e = z2;
            if (z) {
                f = p1Var.s;
                if (f != -1.0f) {
                }
                z3 = true;
                this.g = z3;
                this.h = m.L(i3, false);
                p1 p1Var322 = this.d;
                this.i = p1Var322.h;
                this.j = p1Var322.f();
                this.l = m.H(this.d.e, dVar.m);
                int i1522 = this.d.e;
                this.m = (i1522 == 0 && (i1522 & 1) == 0) ? false : true;
                i5 = 0;
                while (true) {
                    if (i5 < dVar.l.size()) {
                    }
                    i5++;
                }
                this.k = i5;
                this.p = z2.e(i3) != 128;
                this.q = z2.g(i3) == 64;
                this.r = m.I(this.d.l);
                this.o = j(i3, i14);
            }
            z3 = false;
            this.g = z3;
            this.h = m.L(i3, false);
            p1 p1Var3222 = this.d;
            this.i = p1Var3222.h;
            this.j = p1Var3222.f();
            this.l = m.H(this.d.e, dVar.m);
            int i15222 = this.d.e;
            this.m = (i15222 == 0 && (i15222 & 1) == 0) ? false : true;
            i5 = 0;
            while (true) {
                if (i5 < dVar.l.size()) {
                }
                i5++;
            }
            this.k = i5;
            this.p = z2.e(i3) != 128;
            this.q = z2.g(i3) == 64;
            this.r = m.I(this.d.l);
            this.o = j(i3, i14);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int f(i iVar, i iVar2) {
            h2 h = h2.k().h(iVar.h, iVar2.h).d(iVar.l, iVar2.l).h(iVar.m, iVar2.m).h(iVar.e, iVar2.e).h(iVar.g, iVar2.g).g(Integer.valueOf(iVar.k), Integer.valueOf(iVar2.k), Ordering.natural().reverse()).h(iVar.p, iVar2.p).h(iVar.q, iVar2.q);
            if (iVar.p && iVar.q) {
                h = h.d(iVar.r, iVar2.r);
            }
            return h.j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int g(i iVar, i iVar2) {
            Ordering reverse = (iVar.e && iVar.h) ? m.k : m.k.reverse();
            return h2.k().g(Integer.valueOf(iVar.i), Integer.valueOf(iVar2.i), iVar.f.w ? m.k.reverse() : m.l).g(Integer.valueOf(iVar.j), Integer.valueOf(iVar2.j), reverse).g(Integer.valueOf(iVar.i), Integer.valueOf(iVar2.i), reverse).j();
        }

        public static int h(List list, List list2) {
            return h2.k().g((i) Collections.max(list, new Comparator() { // from class: na.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f;
                    f = m.i.f((m.i) obj, (m.i) obj2);
                    return f;
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: na.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f;
                    f = m.i.f((m.i) obj, (m.i) obj2);
                    return f;
                }
            }), new Comparator() { // from class: na.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f;
                    f = m.i.f((m.i) obj, (m.i) obj2);
                    return f;
                }
            }).d(list.size(), list2.size()).g((i) Collections.max(list, new Comparator() { // from class: na.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int g;
                    g = m.i.g((m.i) obj, (m.i) obj2);
                    return g;
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: na.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int g;
                    g = m.i.g((m.i) obj, (m.i) obj2);
                    return g;
                }
            }), new Comparator() { // from class: na.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int g;
                    g = m.i.g((m.i) obj, (m.i) obj2);
                    return g;
                }
            }).j();
        }

        public static ImmutableList i(int i, v9.w wVar, d dVar, int[] iArr, int i2) {
            int E = m.E(wVar, dVar.i, dVar.j, dVar.k);
            ImmutableList.a builder = ImmutableList.builder();
            for (int i3 = 0; i3 < wVar.a; i3++) {
                int f = wVar.c(i3).f();
                builder.j(new i(i, wVar, i3, dVar, iArr[i3], i2, E == Integer.MAX_VALUE || (f != -1 && f <= E)));
            }
            return builder.n();
        }

        private int j(int i, int i2) {
            if ((this.d.e & 16384) != 0 || !m.L(i, this.f.N)) {
                return 0;
            }
            if (!this.e && !this.f.D) {
                return 0;
            }
            if (m.L(i, false) && this.g && this.e && this.d.h != -1) {
                d dVar = this.f;
                if (!dVar.x && !dVar.w && (i & i2) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // na.m.h
        public int a() {
            return this.o;
        }

        @Override // na.m.h
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean b(i iVar) {
            return (this.n || p0.c(this.d.l, iVar.d.l)) && (this.f.G || (this.p == iVar.p && this.q == iVar.q));
        }
    }

    @Deprecated
    public m() {
        this(d.S, new a.b());
    }

    public m(Context context) {
        this(context, new a.b());
    }

    public m(Context context, s.b bVar) {
        this(context, d.k(context), bVar);
    }

    public m(Context context, z zVar, s.b bVar) {
        this(zVar, bVar, context);
    }

    public m(z zVar, s.b bVar) {
        this(zVar, bVar, (Context) null);
    }

    private m(z zVar, s.b bVar, Context context) {
        this.d = new Object();
        this.e = context != null ? context.getApplicationContext() : null;
        this.f = bVar;
        if (zVar instanceof d) {
            this.h = (d) zVar;
        } else {
            this.h = (context == null ? d.S : d.k(context)).a().g0(zVar).A();
        }
        this.j = com.google.android.exoplayer2.audio.e.g;
        boolean z = context != null && p0.x0(context);
        this.g = z;
        if (!z && context != null && p0.a >= 32) {
            this.i = f.g(context);
        }
        if (this.h.M && context == null) {
            com.google.android.exoplayer2.util.s.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    private static void A(u.a aVar, d dVar, s.a[] aVarArr) {
        int d2 = aVar.d();
        for (int i2 = 0; i2 < d2; i2++) {
            v9.y f2 = aVar.f(i2);
            if (dVar.o(i2, f2)) {
                e n = dVar.n(i2, f2);
                aVarArr[i2] = (n == null || n.b.length == 0) ? null : new s.a(f2.b(n.a), n.b, n.d);
            }
        }
    }

    private static void B(u.a aVar, z zVar, s.a[] aVarArr) {
        int d2 = aVar.d();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < d2; i2++) {
            C(aVar.f(i2), zVar, hashMap);
        }
        C(aVar.h(), zVar, hashMap);
        for (int i3 = 0; i3 < d2; i3++) {
            x xVar = (x) hashMap.get(Integer.valueOf(aVar.e(i3)));
            if (xVar != null) {
                aVarArr[i3] = (xVar.b.isEmpty() || aVar.f(i3).c(xVar.a) == -1) ? null : new s.a(xVar.a, Ints.o(xVar.b));
            }
        }
    }

    private static void C(v9.y yVar, z zVar, Map map) {
        x xVar;
        for (int i2 = 0; i2 < yVar.a; i2++) {
            x xVar2 = (x) zVar.y.get(yVar.b(i2));
            if (xVar2 != null && ((xVar = (x) map.get(Integer.valueOf(xVar2.b()))) == null || (xVar.b.isEmpty() && !xVar2.b.isEmpty()))) {
                map.put(Integer.valueOf(xVar2.b()), xVar2);
            }
        }
    }

    protected static int D(p1 p1Var, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(p1Var.c)) {
            return 4;
        }
        String T = T(str);
        String T2 = T(p1Var.c);
        if (T2 == null || T == null) {
            return (z && T2 == null) ? 1 : 0;
        }
        if (T2.startsWith(T) || T.startsWith(T2)) {
            return 3;
        }
        return p0.T0(T2, "-")[0].equals(p0.T0(T, "-")[0]) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int E(v9.w wVar, int i2, int i3, boolean z) {
        int i4;
        int i5 = Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            for (int i6 = 0; i6 < wVar.a; i6++) {
                p1 c2 = wVar.c(i6);
                int i7 = c2.q;
                if (i7 > 0 && (i4 = c2.r) > 0) {
                    Point F = F(z, i2, i3, i7, i4);
                    int i10 = c2.q;
                    int i11 = c2.r;
                    int i12 = i10 * i11;
                    if (i10 >= ((int) (F.x * 0.98f)) && i11 >= ((int) (F.y * 0.98f)) && i12 < i5) {
                        i5 = i12;
                    }
                }
            }
        }
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
    
        if ((r6 > r7) != (r4 > r5)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Point F(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
        }
        i3 = i2;
        i2 = i3;
        int i6 = i4 * i2;
        int i7 = i5 * i3;
        return i6 >= i7 ? new Point(i3, p0.l(i7, i4)) : new Point(p0.l(i6, i5), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int H(int i2, int i3) {
        if (i2 == 0 || i2 != i3) {
            return Integer.bitCount(i2 & i3);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(p1 p1Var) {
        boolean z;
        f fVar;
        f fVar2;
        synchronized (this.d) {
            try {
                if (this.h.M) {
                    if (!this.g) {
                        if (p1Var.y > 2) {
                            if (K(p1Var)) {
                                if (p0.a >= 32 && (fVar2 = this.i) != null && fVar2.e()) {
                                }
                            }
                            if (p0.a < 32 || (fVar = this.i) == null || !fVar.e() || !this.i.c() || !this.i.d() || !this.i.a(this.j, p1Var)) {
                                z = false;
                            }
                        }
                    }
                }
                z = true;
            } finally {
            }
        }
        return z;
    }

    private static boolean K(p1 p1Var) {
        String str = p1Var.l;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
        }
        return false;
    }

    protected static boolean L(int i2, boolean z) {
        int f2 = z2.f(i2);
        return f2 == 4 || (z && f2 == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List M(d dVar, boolean z, int i2, v9.w wVar, int[] iArr) {
        return b.f(i2, wVar, dVar, iArr, z, new com.google.common.base.n() { // from class: na.l
            public final boolean apply(Object obj) {
                boolean J;
                J = m.this.J((p1) obj);
                return J;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List N(d dVar, String str, int i2, v9.w wVar, int[] iArr) {
        return g.f(i2, wVar, dVar, iArr, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List O(d dVar, int[] iArr, int i2, v9.w wVar, int[] iArr2) {
        return i.i(i2, wVar, dVar, iArr2, iArr[i2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int P(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Q(Integer num, Integer num2) {
        return 0;
    }

    private static void R(u.a aVar, int[][][] iArr, b3[] b3VarArr, s[] sVarArr) {
        boolean z;
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < aVar.d(); i4++) {
            int e2 = aVar.e(i4);
            s sVar = sVarArr[i4];
            if ((e2 == 1 || e2 == 2) && sVar != null && U(iArr[i4], aVar.f(i4), sVar)) {
                if (e2 == 1) {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i4;
                } else {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i4;
                }
            }
        }
        z = true;
        if (i3 != -1 && i2 != -1) {
            z2 = true;
        }
        if (z && z2) {
            b3 b3Var = new b3(true);
            b3VarArr[i3] = b3Var;
            b3VarArr[i2] = b3Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        boolean z;
        f fVar;
        synchronized (this.d) {
            try {
                z = this.h.M && !this.g && p0.a >= 32 && (fVar = this.i) != null && fVar.e();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            d();
        }
    }

    protected static String T(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    private static boolean U(int[][] iArr, v9.y yVar, s sVar) {
        if (sVar == null) {
            return false;
        }
        int c2 = yVar.c(sVar.getTrackGroup());
        for (int i2 = 0; i2 < sVar.length(); i2++) {
            if (z2.h(iArr[c2][sVar.getIndexInTrackGroup(i2)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private Pair Z(int i2, u.a aVar, int[][][] iArr, h.a aVar2, Comparator comparator) {
        int i3;
        ImmutableList immutableList;
        u.a aVar3 = aVar;
        ArrayList arrayList = new ArrayList();
        int d2 = aVar.d();
        int i4 = 0;
        while (i4 < d2) {
            if (i2 == aVar3.e(i4)) {
                v9.y f2 = aVar3.f(i4);
                for (int i5 = 0; i5 < f2.a; i5++) {
                    v9.w b2 = f2.b(i5);
                    List a2 = aVar2.a(i4, b2, iArr[i4][i5]);
                    boolean[] zArr = new boolean[b2.a];
                    int i6 = 0;
                    while (i6 < b2.a) {
                        h hVar = (h) a2.get(i6);
                        int a3 = hVar.a();
                        if (zArr[i6] || a3 == 0) {
                            i3 = d2;
                        } else {
                            if (a3 == 1) {
                                immutableList = ImmutableList.of(hVar);
                                i3 = d2;
                            } else {
                                ImmutableList arrayList2 = new ArrayList();
                                arrayList2.add(hVar);
                                int i7 = i6 + 1;
                                while (i7 < b2.a) {
                                    h hVar2 = (h) a2.get(i7);
                                    int i10 = d2;
                                    if (hVar2.a() == 2 && hVar.b(hVar2)) {
                                        arrayList2.add(hVar2);
                                        zArr[i7] = true;
                                    }
                                    i7++;
                                    d2 = i10;
                                }
                                i3 = d2;
                                immutableList = arrayList2;
                            }
                            arrayList.add(immutableList);
                        }
                        i6++;
                        d2 = i3;
                    }
                }
            }
            i4++;
            aVar3 = aVar;
            d2 = d2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            iArr2[i11] = ((h) list.get(i11)).c;
        }
        h hVar3 = (h) list.get(0);
        return Pair.create(new s.a(hVar3.b, iArr2), Integer.valueOf(hVar3.a));
    }

    private void b0(d dVar) {
        boolean equals;
        com.google.android.exoplayer2.util.a.e(dVar);
        synchronized (this.d) {
            equals = this.h.equals(dVar);
            this.h = dVar;
        }
        if (equals) {
            return;
        }
        if (dVar.M && this.e == null) {
            com.google.android.exoplayer2.util.s.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        d();
    }

    @Override // na.b0
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public d b() {
        d dVar;
        synchronized (this.d) {
            dVar = this.h;
        }
        return dVar;
    }

    protected s.a[] V(u.a aVar, int[][][] iArr, int[] iArr2, d dVar) {
        String str;
        int d2 = aVar.d();
        s.a[] aVarArr = new s.a[d2];
        Pair a0 = a0(aVar, iArr, iArr2, dVar);
        if (a0 != null) {
            aVarArr[((Integer) a0.second).intValue()] = (s.a) a0.first;
        }
        Pair W = W(aVar, iArr, iArr2, dVar);
        if (W != null) {
            aVarArr[((Integer) W.second).intValue()] = (s.a) W.first;
        }
        if (W == null) {
            str = null;
        } else {
            Object obj = W.first;
            str = ((s.a) obj).a.c(((s.a) obj).b[0]).c;
        }
        Pair Y = Y(aVar, iArr, dVar, str);
        if (Y != null) {
            aVarArr[((Integer) Y.second).intValue()] = (s.a) Y.first;
        }
        for (int i2 = 0; i2 < d2; i2++) {
            int e2 = aVar.e(i2);
            if (e2 != 2 && e2 != 1 && e2 != 3) {
                aVarArr[i2] = X(e2, aVar.f(i2), iArr[i2], dVar);
            }
        }
        return aVarArr;
    }

    protected Pair W(u.a aVar, int[][][] iArr, int[] iArr2, final d dVar) {
        final boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < aVar.d()) {
                if (2 == aVar.e(i2) && aVar.f(i2).a > 0) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return Z(1, aVar, iArr, new h.a() { // from class: na.h
            @Override // na.m.h.a
            public final List a(int i3, v9.w wVar, int[] iArr3) {
                List M;
                M = m.this.M(dVar, z, i3, wVar, iArr3);
                return M;
            }
        }, new Comparator() { // from class: na.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.b.d((List) obj, (List) obj2);
            }
        });
    }

    protected s.a X(int i2, v9.y yVar, int[][] iArr, d dVar) {
        v9.w wVar = null;
        c cVar = null;
        int i3 = 0;
        for (int i4 = 0; i4 < yVar.a; i4++) {
            v9.w b2 = yVar.b(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < b2.a; i5++) {
                if (L(iArr2[i5], dVar.N)) {
                    c cVar2 = new c(b2.c(i5), iArr2[i5]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        wVar = b2;
                        i3 = i5;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (wVar == null) {
            return null;
        }
        return new s.a(wVar, i3);
    }

    protected Pair Y(u.a aVar, int[][][] iArr, final d dVar, final String str) {
        return Z(3, aVar, iArr, new h.a() { // from class: na.j
            @Override // na.m.h.a
            public final List a(int i2, v9.w wVar, int[] iArr2) {
                List N;
                N = m.N(m.d.this, str, i2, wVar, iArr2);
                return N;
            }
        }, new Comparator() { // from class: na.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.g.d((List) obj, (List) obj2);
            }
        });
    }

    protected Pair a0(u.a aVar, int[][][] iArr, final int[] iArr2, final d dVar) {
        return Z(2, aVar, iArr, new h.a() { // from class: na.f
            @Override // na.m.h.a
            public final List a(int i2, v9.w wVar, int[] iArr3) {
                List O;
                O = m.O(m.d.this, iArr2, i2, wVar, iArr3);
                return O;
            }
        }, new Comparator() { // from class: na.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.i.h((List) obj, (List) obj2);
            }
        });
    }

    @Override // na.b0
    public boolean e() {
        return true;
    }

    @Override // na.b0
    public void g() {
        f fVar;
        synchronized (this.d) {
            try {
                if (p0.a >= 32 && (fVar = this.i) != null) {
                    fVar.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.g();
    }

    @Override // na.b0
    public void i(com.google.android.exoplayer2.audio.e eVar) {
        boolean equals;
        synchronized (this.d) {
            equals = this.j.equals(eVar);
            this.j = eVar;
        }
        if (equals) {
            return;
        }
        S();
    }

    @Override // na.b0
    public void j(z zVar) {
        if (zVar instanceof d) {
            b0((d) zVar);
        }
        b0(new d.a().g0(zVar).A());
    }

    @Override // na.u
    protected final Pair n(u.a aVar, int[][][] iArr, int[] iArr2, o.b bVar, l3 l3Var) {
        d dVar;
        f fVar;
        synchronized (this.d) {
            try {
                dVar = this.h;
                if (dVar.M && p0.a >= 32 && (fVar = this.i) != null) {
                    fVar.b(this, (Looper) com.google.android.exoplayer2.util.a.i(Looper.myLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int d2 = aVar.d();
        s.a[] V = V(aVar, iArr, iArr2, dVar);
        B(aVar, dVar, V);
        A(aVar, dVar, V);
        for (int i2 = 0; i2 < d2; i2++) {
            int e2 = aVar.e(i2);
            if (dVar.m(i2) || dVar.z.contains(Integer.valueOf(e2))) {
                V[i2] = null;
            }
        }
        s[] a2 = this.f.a(V, a(), bVar, l3Var);
        b3[] b3VarArr = new b3[d2];
        for (int i3 = 0; i3 < d2; i3++) {
            b3VarArr[i3] = (dVar.m(i3) || dVar.z.contains(Integer.valueOf(aVar.e(i3))) || (aVar.e(i3) != -2 && a2[i3] == null)) ? null : b3.b;
        }
        if (dVar.O) {
            R(aVar, iArr, b3VarArr, a2);
        }
        return Pair.create(b3VarArr, a2);
    }
}
