package androidx.collection;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1278a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f1279b;

    /* renamed from: c, reason: collision with root package name */
    public int f1280c;

    /* renamed from: d, reason: collision with root package name */
    public int f1281d;

    private i() {
        this.f1278a = v0.f1350a;
        this.f1279b = j.a();
    }

    public /* synthetic */ i(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ String d(i iVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i6 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i6 & 4) == 0 ? charSequence3 : "";
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        int i7 = i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        return iVar.c(charSequence, charSequence5, charSequence6, i7, charSequence4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(float f5) {
        int i5;
        int floatToIntBits = Float.floatToIntBits(f5) * (-862048943);
        int i6 = floatToIntBits ^ (floatToIntBits << 16);
        int i7 = i6 & 127;
        int i8 = this.f1280c;
        int i9 = (i6 >>> 7) & i8;
        int i10 = 0;
        loop0: while (true) {
            long[] jArr = this.f1278a;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j5 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j6 = (i7 * 72340172838076673L) ^ j5;
            long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L);
            while (true) {
                if (j7 == 0) {
                    break;
                }
                i5 = ((Long.numberOfTrailingZeros(j7) >> 3) + i9) & i8;
                if (this.f1279b[i5] == f5) {
                    break loop0;
                }
                j7 &= j7 - 1;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
        }
        return i5 >= 0;
    }

    public final int b() {
        return this.f1280c;
    }

    public final String c(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4) {
        Intrinsics.h(charSequence, "separator");
        Intrinsics.h(charSequence2, "prefix");
        Intrinsics.h(charSequence3, "postfix");
        Intrinsics.h(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr = this.f1279b;
        long[] jArr = this.f1278a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0: while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i6 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            float f5 = fArr[(i6 << 3) + i10];
                            if (i7 == i5) {
                                sb.append(charSequence4);
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence);
                            }
                            sb.append(f5);
                            i7++;
                        }
                        j5 >>= 8;
                        i10++;
                        i8 = 8;
                    }
                    if (i9 != i8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
            String sb2 = sb.toString();
            Intrinsics.g(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append(charSequence3);
        String sb22 = sb.toString();
        Intrinsics.g(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (iVar.f1281d != this.f1281d) {
            return false;
        }
        float[] fArr = this.f1279b;
        long[] jArr = this.f1278a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128 && !iVar.a(fArr[(i5 << 3) + i7])) {
                            return false;
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

    public int hashCode() {
        float[] fArr = this.f1279b;
        long[] jArr = this.f1278a;
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
                            i7 += Float.floatToIntBits(fArr[(i6 << 3) + i9]);
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
        return d(this, null, "[", "]", 0, null, 25, null);
    }
}
