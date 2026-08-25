package androidx.collection;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1305a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1306b;

    /* renamed from: c, reason: collision with root package name */
    public float[] f1307c;

    /* renamed from: d, reason: collision with root package name */
    public int f1308d;

    /* renamed from: e, reason: collision with root package name */
    public int f1309e;

    private o0() {
        this.f1305a = v0.f1350a;
        this.f1306b = n.a.f16551c;
        this.f1307c = j.a();
    }

    public /* synthetic */ o0(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean a(Object obj) {
        return b(obj) >= 0;
    }

    public final int b(Object obj) {
        int i5 = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i6 = hashCode ^ (hashCode << 16);
        int i7 = i6 & 127;
        int i8 = this.f1308d;
        int i9 = i6 >>> 7;
        while (true) {
            int i10 = i9 & i8;
            long[] jArr = this.f1305a;
            int i11 = i10 >> 3;
            int i12 = (i10 & 7) << 3;
            long j5 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j6 = (i7 * 72340172838076673L) ^ j5;
            for (long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L); j7 != 0; j7 &= j7 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j7) >> 3) + i10) & i8;
                if (Intrinsics.c(this.f1306b[numberOfTrailingZeros], obj)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j5 & ((~j5) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i5 += 8;
            i9 = i10 + i5;
        }
    }

    public final float c(Object obj) {
        int b5 = b(obj);
        if (b5 >= 0) {
            return this.f1307c[b5];
        }
        throw new NoSuchElementException("There is no key " + obj + " in the map");
    }

    public final int d() {
        return this.f1308d;
    }

    public final float e(Object obj, float f5) {
        int b5 = b(obj);
        return b5 >= 0 ? this.f1307c[b5] : f5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        if (o0Var.f() != f()) {
            return false;
        }
        Object[] objArr = this.f1306b;
        float[] fArr = this.f1307c;
        long[] jArr = this.f1305a;
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
                            if (fArr[i8] != o0Var.c(objArr[i8])) {
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
        return this.f1309e;
    }

    public final boolean g() {
        return this.f1309e == 0;
    }

    public int hashCode() {
        Object[] objArr = this.f1306b;
        float[] fArr = this.f1307c;
        long[] jArr = this.f1305a;
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
                            Object obj = objArr[i10];
                            i7 += Float.floatToIntBits(fArr[i10]) ^ (obj != null ? obj.hashCode() : 0);
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
        Object[] objArr = this.f1306b;
        float[] fArr = this.f1307c;
        long[] jArr = this.f1305a;
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
                            Object obj = objArr[i9];
                            float f5 = fArr[i9];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append("=");
                            sb.append(f5);
                            i6++;
                            if (i6 < this.f1309e) {
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
