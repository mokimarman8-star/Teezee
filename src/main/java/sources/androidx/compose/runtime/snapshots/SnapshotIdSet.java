package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class SnapshotIdSet implements Iterable, KMappedMarker {

    /* renamed from: e, reason: collision with root package name */
    public static final a f2913e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final SnapshotIdSet f2914f = new SnapshotIdSet(0, 0, 0, null);

    /* renamed from: a, reason: collision with root package name */
    private final long f2915a;

    /* renamed from: b, reason: collision with root package name */
    private final long f2916b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2917c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f2918d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SnapshotIdSet a() {
            return SnapshotIdSet.f2914f;
        }
    }

    private SnapshotIdSet(long j5, long j6, int i5, int[] iArr) {
        this.f2915a = j5;
        this.f2916b = j6;
        this.f2917c = i5;
        this.f2918d = iArr;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return SequencesKt.b(new SnapshotIdSet$iterator$1(this, null)).iterator();
    }

    public final SnapshotIdSet j(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        SnapshotIdSet snapshotIdSet3 = f2914f;
        if (snapshotIdSet == snapshotIdSet3) {
            return this;
        }
        if (this == snapshotIdSet3) {
            return snapshotIdSet3;
        }
        int i5 = snapshotIdSet.f2917c;
        int i6 = this.f2917c;
        if (i5 == i6) {
            int[] iArr = snapshotIdSet.f2918d;
            int[] iArr2 = this.f2918d;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.f2915a & (~snapshotIdSet.f2915a), this.f2916b & (~snapshotIdSet.f2916b), i6, iArr2);
            }
        }
        int[] iArr3 = snapshotIdSet.f2918d;
        if (iArr3 != null) {
            snapshotIdSet2 = this;
            for (int i7 : iArr3) {
                snapshotIdSet2 = snapshotIdSet2.l(i7);
            }
        } else {
            snapshotIdSet2 = this;
        }
        if (snapshotIdSet.f2916b != 0) {
            for (int i8 = 0; i8 < 64; i8++) {
                if ((snapshotIdSet.f2916b & (1 << i8)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.l(snapshotIdSet.f2917c + i8);
                }
            }
        }
        if (snapshotIdSet.f2915a != 0) {
            for (int i9 = 0; i9 < 64; i9++) {
                if ((snapshotIdSet.f2915a & (1 << i9)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.l(i9 + 64 + snapshotIdSet.f2917c);
                }
            }
        }
        return snapshotIdSet2;
    }

    public final SnapshotIdSet l(int i5) {
        int[] iArr;
        int a5;
        int i6 = this.f2917c;
        int i7 = i5 - i6;
        if (i7 >= 0 && i7 < 64) {
            long j5 = 1 << i7;
            long j6 = this.f2916b;
            if ((j6 & j5) != 0) {
                return new SnapshotIdSet(this.f2915a, j6 & (~j5), i6, this.f2918d);
            }
        } else if (i7 >= 64 && i7 < 128) {
            long j7 = 1 << (i7 - 64);
            long j8 = this.f2915a;
            if ((j8 & j7) != 0) {
                return new SnapshotIdSet(j8 & (~j7), this.f2916b, i6, this.f2918d);
            }
        } else if (i7 < 0 && (iArr = this.f2918d) != null && (a5 = m.a(iArr, i5)) >= 0) {
            int length = iArr.length;
            int i8 = length - 1;
            if (i8 == 0) {
                return new SnapshotIdSet(this.f2915a, this.f2916b, this.f2917c, null);
            }
            int[] iArr2 = new int[i8];
            if (a5 > 0) {
                ArraysKt.j(iArr, iArr2, 0, 0, a5);
            }
            if (a5 < i8) {
                ArraysKt.j(iArr, iArr2, a5, a5 + 1, length);
            }
            return new SnapshotIdSet(this.f2915a, this.f2916b, this.f2917c, iArr2);
        }
        return this;
    }

    public final boolean m(int i5) {
        int[] iArr;
        int i6 = i5 - this.f2917c;
        if (i6 >= 0 && i6 < 64) {
            return ((1 << i6) & this.f2916b) != 0;
        }
        if (i6 >= 64 && i6 < 128) {
            return ((1 << (i6 - 64)) & this.f2915a) != 0;
        }
        if (i6 <= 0 && (iArr = this.f2918d) != null) {
            return m.a(iArr, i5) >= 0;
        }
        return false;
    }

    public final int n(int i5) {
        int[] iArr = this.f2918d;
        if (iArr != null) {
            return iArr[0];
        }
        long j5 = this.f2916b;
        if (j5 != 0) {
            return this.f2917c + Long.numberOfTrailingZeros(j5);
        }
        long j6 = this.f2915a;
        return j6 != 0 ? this.f2917c + 64 + Long.numberOfTrailingZeros(j6) : i5;
    }

    public final SnapshotIdSet o(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        SnapshotIdSet snapshotIdSet3 = f2914f;
        if (snapshotIdSet == snapshotIdSet3) {
            return this;
        }
        if (this == snapshotIdSet3) {
            return snapshotIdSet;
        }
        int i5 = snapshotIdSet.f2917c;
        int i6 = this.f2917c;
        if (i5 == i6) {
            int[] iArr = snapshotIdSet.f2918d;
            int[] iArr2 = this.f2918d;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.f2915a | snapshotIdSet.f2915a, this.f2916b | snapshotIdSet.f2916b, i6, iArr2);
            }
        }
        int i7 = 0;
        if (this.f2918d == null) {
            int[] iArr3 = this.f2918d;
            if (iArr3 != null) {
                for (int i8 : iArr3) {
                    snapshotIdSet = snapshotIdSet.p(i8);
                }
            }
            if (this.f2916b != 0) {
                for (int i9 = 0; i9 < 64; i9++) {
                    if ((this.f2916b & (1 << i9)) != 0) {
                        snapshotIdSet = snapshotIdSet.p(this.f2917c + i9);
                    }
                }
            }
            if (this.f2915a != 0) {
                while (i7 < 64) {
                    if ((this.f2915a & (1 << i7)) != 0) {
                        snapshotIdSet = snapshotIdSet.p(i7 + 64 + this.f2917c);
                    }
                    i7++;
                }
            }
            return snapshotIdSet;
        }
        int[] iArr4 = snapshotIdSet.f2918d;
        if (iArr4 != null) {
            snapshotIdSet2 = this;
            for (int i10 : iArr4) {
                snapshotIdSet2 = snapshotIdSet2.p(i10);
            }
        } else {
            snapshotIdSet2 = this;
        }
        if (snapshotIdSet.f2916b != 0) {
            for (int i11 = 0; i11 < 64; i11++) {
                if ((snapshotIdSet.f2916b & (1 << i11)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.p(snapshotIdSet.f2917c + i11);
                }
            }
        }
        if (snapshotIdSet.f2915a != 0) {
            while (i7 < 64) {
                if ((snapshotIdSet.f2915a & (1 << i7)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.p(i7 + 64 + snapshotIdSet.f2917c);
                }
                i7++;
            }
        }
        return snapshotIdSet2;
    }

    public final SnapshotIdSet p(int i5) {
        int i6;
        int[] iArr;
        int i7 = this.f2917c;
        int i8 = i5 - i7;
        long j5 = 0;
        if (i8 >= 0 && i8 < 64) {
            long j6 = 1 << i8;
            long j7 = this.f2916b;
            if ((j7 & j6) == 0) {
                return new SnapshotIdSet(this.f2915a, j7 | j6, i7, this.f2918d);
            }
        } else if (i8 >= 64 && i8 < 128) {
            long j8 = 1 << (i8 - 64);
            long j9 = this.f2915a;
            if ((j9 & j8) == 0) {
                return new SnapshotIdSet(j9 | j8, this.f2916b, i7, this.f2918d);
            }
        } else if (i8 < 128) {
            int[] iArr2 = this.f2918d;
            if (iArr2 == null) {
                return new SnapshotIdSet(this.f2915a, this.f2916b, i7, new int[]{i5});
            }
            int a5 = m.a(iArr2, i5);
            if (a5 < 0) {
                int i9 = -(a5 + 1);
                int length = iArr2.length;
                int[] iArr3 = new int[length + 1];
                ArraysKt.j(iArr2, iArr3, 0, 0, i9);
                ArraysKt.j(iArr2, iArr3, i9 + 1, i9, length);
                iArr3[i9] = i5;
                return new SnapshotIdSet(this.f2915a, this.f2916b, this.f2917c, iArr3);
            }
        } else if (!m(i5)) {
            long j10 = this.f2915a;
            long j11 = this.f2916b;
            int i10 = this.f2917c;
            int i11 = ((i5 + 1) / 64) * 64;
            ArrayList arrayList = null;
            long j12 = j11;
            long j13 = j10;
            while (true) {
                if (i10 >= i11) {
                    i6 = i10;
                    break;
                }
                if (j12 != j5) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        int[] iArr4 = this.f2918d;
                        if (iArr4 != null) {
                            for (int i12 : iArr4) {
                                arrayList.add(Integer.valueOf(i12));
                            }
                        }
                    }
                    for (int i13 = 0; i13 < 64; i13++) {
                        if (((1 << i13) & j12) != 0) {
                            arrayList.add(Integer.valueOf(i13 + i10));
                        }
                    }
                    j5 = 0;
                }
                if (j13 == j5) {
                    i6 = i11;
                    j12 = j5;
                    break;
                }
                i10 += 64;
                j12 = j13;
                j13 = j5;
            }
            if (arrayList == null || (iArr = CollectionsKt.Q0(arrayList)) == null) {
                iArr = this.f2918d;
            }
            return new SnapshotIdSet(j13, j12, i6, iArr).p(i5);
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(CollectionsKt.v(this, 10));
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).intValue()));
        }
        sb.append(androidx.compose.runtime.snapshots.a.d(arrayList, null, null, null, 0, null, null, 63, null));
        sb.append(']');
        return sb.toString();
    }
}
