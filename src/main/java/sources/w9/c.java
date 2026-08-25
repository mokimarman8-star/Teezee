package w9;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import w9.c;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c implements k {
    public static final c g = new c(null, new a[0], 0, -9223372036854775807L, 0);
    private static final a h = new a(0).j(0);
    public static final k.a i = new k.a() { // from class: w9.a
        public final k a(Bundle bundle) {
            c b;
            b = c.b(bundle);
            return b;
        }
    };
    public final Object a;
    public final int b;
    public final long c;
    public final long d;
    public final int e;
    private final a[] f;

    public static final class a implements k {
        public static final k.a h = new k.a() { // from class: w9.b
            public final k a(Bundle bundle) {
                c.a d;
                d = c.a.d(bundle);
                return d;
            }
        };
        public final long a;
        public final int b;
        public final Uri[] c;
        public final int[] d;
        public final long[] e;
        public final long f;
        public final boolean g;

        public a(long j) {
            this(j, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        private a(long j, int i, int[] iArr, Uri[] uriArr, long[] jArr, long j2, boolean z) {
            com.google.android.exoplayer2.util.a.a(iArr.length == uriArr.length);
            this.a = j;
            this.b = i;
            this.d = iArr;
            this.c = uriArr;
            this.e = jArr;
            this.f = j2;
            this.g = z;
        }

        private static long[] b(long[] jArr, int i) {
            int length = jArr.length;
            int max = Math.max(i, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        private static int[] c(int[] iArr, int i) {
            int length = iArr.length;
            int max = Math.max(i, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a d(Bundle bundle) {
            long j = bundle.getLong(h(0));
            int i = bundle.getInt(h(1), -1);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(h(2));
            int[] intArray = bundle.getIntArray(h(3));
            long[] longArray = bundle.getLongArray(h(4));
            long j2 = bundle.getLong(h(5));
            boolean z = bundle.getBoolean(h(6));
            if (intArray == null) {
                intArray = new int[0];
            }
            return new a(j, i, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j2, z);
        }

        private static String h(int i) {
            return Integer.toString(i, 36);
        }

        public int e() {
            return f(-1);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && Arrays.equals(this.c, aVar.c) && Arrays.equals(this.d, aVar.d) && Arrays.equals(this.e, aVar.e) && this.f == aVar.f && this.g == aVar.g;
        }

        public int f(int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.d;
                if (i3 >= iArr.length || this.g || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        public boolean g() {
            if (this.b == -1) {
                return true;
            }
            for (int i = 0; i < this.b; i++) {
                int i2 = this.d[i];
                if (i2 == 0 || i2 == 1) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = this.b * 31;
            long j = this.a;
            int hashCode = (((((((i + ((int) (j ^ (j >>> 32)))) * 31) + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e)) * 31;
            long j2 = this.f;
            return ((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.g ? 1 : 0);
        }

        public boolean i() {
            return this.b == -1 || e() < this.b;
        }

        public a j(int i) {
            int[] c = c(this.d, i);
            long[] b = b(this.e, i);
            return new a(this.a, i, c, (Uri[]) Arrays.copyOf(this.c, i), b, this.f, this.g);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(h(0), this.a);
            bundle.putInt(h(1), this.b);
            bundle.putParcelableArrayList(h(2), new ArrayList<>(Arrays.asList(this.c)));
            bundle.putIntArray(h(3), this.d);
            bundle.putLongArray(h(4), this.e);
            bundle.putLong(h(5), this.f);
            bundle.putBoolean(h(6), this.g);
            return bundle;
        }
    }

    private c(Object obj, a[] aVarArr, long j, long j2, int i2) {
        this.a = obj;
        this.c = j;
        this.d = j2;
        this.b = aVarArr.length + i2;
        this.f = aVarArr;
        this.e = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c b(Bundle bundle) {
        a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(g(1));
        if (parcelableArrayList == null) {
            aVarArr = new a[0];
        } else {
            a[] aVarArr2 = new a[parcelableArrayList.size()];
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                aVarArr2[i2] = (a) a.h.a((Bundle) parcelableArrayList.get(i2));
            }
            aVarArr = aVarArr2;
        }
        return new c(null, aVarArr, bundle.getLong(g(2), 0L), bundle.getLong(g(3), -9223372036854775807L), bundle.getInt(g(4)));
    }

    private boolean f(long j, long j2, int i2) {
        if (j == Long.MIN_VALUE) {
            return false;
        }
        long j3 = c(i2).a;
        return j3 == Long.MIN_VALUE ? j2 == -9223372036854775807L || j < j2 : j < j3;
    }

    private static String g(int i2) {
        return Integer.toString(i2, 36);
    }

    public a c(int i2) {
        int i3 = this.e;
        return i2 < i3 ? h : this.f[i2 - i3];
    }

    public int d(long j, long j2) {
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        if (j2 != -9223372036854775807L && j >= j2) {
            return -1;
        }
        int i2 = this.e;
        while (i2 < this.b && ((c(i2).a != Long.MIN_VALUE && c(i2).a <= j) || !c(i2).i())) {
            i2++;
        }
        if (i2 < this.b) {
            return i2;
        }
        return -1;
    }

    public int e(long j, long j2) {
        int i2 = this.b - 1;
        while (i2 >= 0 && f(j, j2, i2)) {
            i2--;
        }
        if (i2 < 0 || !c(i2).g()) {
            return -1;
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return p0.c(this.a, cVar.a) && this.b == cVar.b && this.c == cVar.c && this.d == cVar.d && this.e == cVar.e && Arrays.equals(this.f, cVar.f);
    }

    public int hashCode() {
        int i2 = this.b * 31;
        Object obj = this.a;
        return ((((((((i2 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + this.e) * 31) + Arrays.hashCode(this.f);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (a aVar : this.f) {
            arrayList.add(aVar.toBundle());
        }
        bundle.putParcelableArrayList(g(1), arrayList);
        bundle.putLong(g(2), this.c);
        bundle.putLong(g(3), this.d);
        bundle.putInt(g(4), this.e);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.a);
        sb.append(", adResumePositionUs=");
        sb.append(this.c);
        sb.append(", adGroups=[");
        for (int i2 = 0; i2 < this.f.length; i2++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f[i2].a);
            sb.append(", ads=[");
            for (int i3 = 0; i3 < this.f[i2].d.length; i3++) {
                sb.append("ad(state=");
                int i4 = this.f[i2].d[i3];
                if (i4 == 0) {
                    sb.append('_');
                } else if (i4 == 1) {
                    sb.append('R');
                } else if (i4 == 2) {
                    sb.append('S');
                } else if (i4 == 3) {
                    sb.append('P');
                } else if (i4 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.f[i2].e[i3]);
                sb.append(')');
                if (i3 < this.f[i2].d.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < this.f.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
