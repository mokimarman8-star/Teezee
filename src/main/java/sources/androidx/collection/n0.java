package androidx.collection;

import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class n0 extends u0 {

    /* renamed from: f, reason: collision with root package name */
    private int f1299f;

    public n0() {
        this(0, 1, null);
    }

    public n0(int i5) {
        super(null);
        if (!(i5 >= 0)) {
            n.d.a("Capacity must be a positive value.");
        }
        n(v0.g(i5));
    }

    public /* synthetic */ n0(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 6 : i5);
    }

    private final void g() {
        int compare;
        if (this.f1344d > 8) {
            compare = Long.compare(ULong.b(ULong.b(this.f1345e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f1344d) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                i();
                return;
            }
        }
        q(v0.e(this.f1344d));
    }

    private final void i() {
        Object[] objArr;
        int i5;
        int i6;
        long[] jArr = this.f1341a;
        int i7 = this.f1344d;
        Object[] objArr2 = this.f1342b;
        Object[] objArr3 = this.f1343c;
        v0.a(jArr, i7);
        int i8 = 0;
        int i9 = 0;
        int i10 = -1;
        while (i9 != i7) {
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j5 = (jArr[i11] >> i12) & 255;
            if (j5 == 128) {
                i10 = i9;
                i9++;
            } else {
                if (j5 == 254) {
                    Object obj = objArr2[i9];
                    int hashCode = (obj != null ? obj.hashCode() : i8) * (-862048943);
                    int i13 = (hashCode ^ (hashCode << 16)) >>> 7;
                    int j6 = j(i13);
                    int i14 = i13 & i7;
                    if (((j6 - i14) & i7) / 8 == ((i9 - i14) & i7) / 8) {
                        jArr[i11] = ((r10 & 127) << i12) | ((~(255 << i12)) & jArr[i11]);
                        jArr[ArraysKt.X(jArr)] = jArr[i8];
                    } else {
                        int i15 = j6 >> 3;
                        long j7 = jArr[i15];
                        int i16 = (j6 & 7) << 3;
                        if (((j7 >> i16) & 255) == 128) {
                            int i17 = i9;
                            objArr = objArr2;
                            jArr[i15] = (j7 & (~(255 << i16))) | ((r10 & 127) << i16);
                            jArr[i11] = (jArr[i11] & (~(255 << i12))) | (128 << i12);
                            objArr[j6] = objArr[i17];
                            objArr[i17] = null;
                            objArr3[j6] = objArr3[i17];
                            objArr3[i17] = null;
                            i6 = i17;
                            i10 = i6;
                            i5 = i7;
                        } else {
                            int i18 = i7;
                            objArr = objArr2;
                            int i19 = i9;
                            jArr[i15] = ((r10 & 127) << i16) | (j7 & (~(255 << i16)));
                            if (i10 == -1) {
                                i5 = i18;
                                i10 = v0.b(jArr, i19 + 1, i5);
                            } else {
                                i5 = i18;
                            }
                            objArr[i10] = objArr[j6];
                            objArr[j6] = objArr[i19];
                            objArr[i19] = objArr[i10];
                            objArr3[i10] = objArr3[j6];
                            objArr3[j6] = objArr3[i19];
                            objArr3[i19] = objArr3[i10];
                            i6 = i19 - 1;
                        }
                        i8 = 0;
                        jArr[ArraysKt.X(jArr)] = jArr[0];
                        i9 = i6 + 1;
                        i7 = i5;
                        objArr2 = objArr;
                    }
                }
                i9++;
            }
        }
        l();
    }

    private final int j(int i5) {
        int i6 = this.f1344d;
        int i7 = i5 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.f1341a;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j5 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j6 = j5 & ((~j5) << 7) & (-9187201950435737472L);
            if (j6 != 0) {
                return (i7 + (Long.numberOfTrailingZeros(j6) >> 3)) & i6;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
        }
    }

    private final void l() {
        this.f1299f = v0.c(c()) - this.f1345e;
    }

    private final void m(int i5) {
        long[] jArr;
        if (i5 == 0) {
            jArr = v0.f1350a;
        } else {
            jArr = new long[((i5 + 15) & (-8)) >> 3];
            ArraysKt.x(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
        }
        this.f1341a = jArr;
        int i6 = i5 >> 3;
        long j5 = 255 << ((i5 & 7) << 3);
        jArr[i6] = (jArr[i6] & (~j5)) | j5;
        l();
    }

    private final void n(int i5) {
        int max = i5 > 0 ? Math.max(7, v0.f(i5)) : 0;
        this.f1344d = max;
        m(max);
        this.f1342b = new Object[max];
        this.f1343c = new Object[max];
    }

    private final void q(int i5) {
        int i6;
        long[] jArr = this.f1341a;
        Object[] objArr = this.f1342b;
        Object[] objArr2 = this.f1343c;
        int i7 = this.f1344d;
        n(i5);
        long[] jArr2 = this.f1341a;
        Object[] objArr3 = this.f1342b;
        Object[] objArr4 = this.f1343c;
        int i8 = this.f1344d;
        int i9 = 0;
        while (i9 < i7) {
            if (((jArr[i9 >> 3] >> ((i9 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i9];
                int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i10 = hashCode ^ (hashCode << 16);
                int j5 = j(i10 >>> 7);
                i6 = i9;
                long j6 = i10 & 127;
                int i11 = j5 >> 3;
                int i12 = (j5 & 7) << 3;
                long j7 = (j6 << i12) | (jArr2[i11] & (~(255 << i12)));
                jArr2[i11] = j7;
                jArr2[(((j5 - 7) & i8) + (i8 & 7)) >> 3] = j7;
                objArr3[j5] = obj;
                objArr4[j5] = objArr2[i6];
            } else {
                i6 = i9;
            }
            i9 = i6 + 1;
        }
    }

    public final void h() {
        this.f1345e = 0;
        long[] jArr = this.f1341a;
        if (jArr != v0.f1350a) {
            ArraysKt.x(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.f1341a;
            int i5 = this.f1344d;
            int i6 = i5 >> 3;
            long j5 = 255 << ((i5 & 7) << 3);
            jArr2[i6] = (jArr2[i6] & (~j5)) | j5;
        }
        ArraysKt.u(this.f1343c, (Object) null, 0, this.f1344d);
        ArraysKt.u(this.f1342b, (Object) null, 0, this.f1344d);
        l();
    }

    public final int k(Object obj) {
        int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i5 = hashCode ^ (hashCode << 16);
        int i6 = i5 >>> 7;
        int i7 = i5 & 127;
        int i8 = this.f1344d;
        int i9 = i6 & i8;
        int i10 = 0;
        while (true) {
            long[] jArr = this.f1341a;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j5 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j6 = i7;
            int i13 = i7;
            long j7 = j5 ^ (j6 * 72340172838076673L);
            for (long j8 = (~j7) & (j7 - 72340172838076673L) & (-9187201950435737472L); j8 != 0; j8 &= j8 - 1) {
                int numberOfTrailingZeros = (i9 + (Long.numberOfTrailingZeros(j8) >> 3)) & i8;
                if (Intrinsics.c(this.f1342b[numberOfTrailingZeros], obj)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j5) << 6) & j5 & (-9187201950435737472L)) != 0) {
                int j9 = j(i6);
                if (this.f1299f == 0 && ((this.f1341a[j9 >> 3] >> ((j9 & 7) << 3)) & 255) != 254) {
                    g();
                    j9 = j(i6);
                }
                this.f1345e++;
                int i14 = this.f1299f;
                long[] jArr2 = this.f1341a;
                int i15 = j9 >> 3;
                long j10 = jArr2[i15];
                int i16 = (j9 & 7) << 3;
                this.f1299f = i14 - (((j10 >> i16) & 255) == 128 ? 1 : 0);
                int i17 = this.f1344d;
                long j11 = ((~(255 << i16)) & j10) | (j6 << i16);
                jArr2[i15] = j11;
                jArr2[(((j9 - 7) & i17) + (i17 & 7)) >> 3] = j11;
                return ~j9;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
            i7 = i13;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(Object obj) {
        int i5;
        int i6 = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i7 = hashCode ^ (hashCode << 16);
        int i8 = i7 & 127;
        int i9 = this.f1344d;
        int i10 = i7 >>> 7;
        loop0: while (true) {
            int i11 = i10 & i9;
            long[] jArr = this.f1341a;
            int i12 = i11 >> 3;
            int i13 = (i11 & 7) << 3;
            long j5 = ((jArr[i12 + 1] << (64 - i13)) & ((-i13) >> 63)) | (jArr[i12] >>> i13);
            long j6 = (i8 * 72340172838076673L) ^ j5;
            long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L);
            while (true) {
                if (j7 == 0) {
                    break;
                }
                i5 = ((Long.numberOfTrailingZeros(j7) >> 3) + i11) & i9;
                if (Intrinsics.c(this.f1342b[i5], obj)) {
                    break loop0;
                }
                j7 &= j7 - 1;
            }
            i6 += 8;
            i10 = i11 + i6;
        }
        if (i5 >= 0) {
            return p(i5);
        }
        return null;
    }

    public final Object p(int i5) {
        this.f1345e--;
        long[] jArr = this.f1341a;
        int i6 = this.f1344d;
        int i7 = i5 >> 3;
        int i8 = (i5 & 7) << 3;
        long j5 = (jArr[i7] & (~(255 << i8))) | (254 << i8);
        jArr[i7] = j5;
        jArr[(((i5 - 7) & i6) + (i6 & 7)) >> 3] = j5;
        this.f1342b[i5] = null;
        Object[] objArr = this.f1343c;
        Object obj = objArr[i5];
        objArr[i5] = null;
        return obj;
    }

    public final void r(Object obj, Object obj2) {
        int k5 = k(obj);
        if (k5 < 0) {
            k5 = ~k5;
        }
        this.f1342b[k5] = obj;
        this.f1343c[k5] = obj2;
    }
}
