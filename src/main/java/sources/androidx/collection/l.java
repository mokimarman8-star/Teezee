package androidx.collection;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1290a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1291b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f1292c;

    /* renamed from: d, reason: collision with root package name */
    public int f1293d;

    /* renamed from: e, reason: collision with root package name */
    public int f1294e;

    private l() {
        this.f1290a = v0.f1350a;
        this.f1291b = r.a();
        this.f1292c = r.a();
    }

    public /* synthetic */ l(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean a(int i5) {
        return b(i5) >= 0;
    }

    public final int b(int i5) {
        int i6 = (-862048943) * i5;
        int i7 = i6 ^ (i6 << 16);
        int i8 = i7 & 127;
        int i9 = this.f1293d;
        int i10 = (i7 >>> 7) & i9;
        int i11 = 0;
        while (true) {
            long[] jArr = this.f1290a;
            int i12 = i10 >> 3;
            int i13 = (i10 & 7) << 3;
            long j5 = ((jArr[i12 + 1] << (64 - i13)) & ((-i13) >> 63)) | (jArr[i12] >>> i13);
            long j6 = (i8 * 72340172838076673L) ^ j5;
            for (long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L); j7 != 0; j7 &= j7 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j7) >> 3) + i10) & i9;
                if (this.f1291b[numberOfTrailingZeros] == i5) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j5 & ((~j5) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i11 += 8;
            i10 = (i10 + i11) & i9;
        }
    }

    public final int c(int i5) {
        int b5 = b(i5);
        if (b5 >= 0) {
            return this.f1292c[b5];
        }
        throw new NoSuchElementException("Cannot find value for key " + i5);
    }

    public final int d() {
        return this.f1293d;
    }

    public final int e(int i5, int i6) {
        int b5 = b(i5);
        return b5 >= 0 ? this.f1292c[b5] : i6;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (lVar.f() != f()) {
            return false;
        }
        int[] iArr = this.f1291b;
        int[] iArr2 = this.f1292c;
        long[] jArr = this.f1290a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            int i8 = (i5 << 3) + i7;
                            if (iArr2[i8] != lVar.c(iArr[i8])) {
                                return false;
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                }
                i5++;
            }
        }
        return true;
    }

    public final int f() {
        return this.f1294e;
    }

    public final boolean g() {
        return this.f1294e == 0;
    }

    public int hashCode() {
        int[] iArr = this.f1291b;
        int[] iArr2 = this.f1292c;
        long[] jArr = this.f1290a;
        int length = jArr.length - 2;
        int i5 = 0;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((255 & j5) < 128) {
                            int i10 = (i6 << 3) + i9;
                            i7 += iArr2[i10] ^ iArr[i10];
                        }
                        j5 >>= 8;
                    }
                    if (i8 != 8) {
                        return i7;
                    }
                }
                if (i6 == length) {
                    i5 = i7;
                    break;
                }
                i6++;
            }
        }
        return i5;
    }

    public String toString() {
        if (g()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        int[] iArr = this.f1291b;
        int[] iArr2 = this.f1292c;
        long[] jArr = this.f1290a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j5) < 128) {
                            int i9 = (i5 << 3) + i8;
                            int i10 = iArr[i9];
                            int i11 = iArr2[i9];
                            sb.append(i10);
                            sb.append("=");
                            sb.append(i11);
                            i6++;
                            if (i6 < this.f1294e) {
                                sb.append(',');
                                sb.append(' ');
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i7 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                }
                i5++;
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "s.append('}').toString()");
        return sb2;
    }
}
