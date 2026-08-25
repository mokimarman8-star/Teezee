package androidx.collection;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1316a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1317b;

    /* renamed from: c, reason: collision with root package name */
    public int f1318c;

    /* renamed from: d, reason: collision with root package name */
    public int f1319d;

    private q() {
        this.f1316a = v0.f1350a;
        this.f1317b = r.a();
    }

    public /* synthetic */ q(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ String e(q qVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
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
        return qVar.d(charSequence, charSequence5, charSequence6, i7, charSequence4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(int i5) {
        int i6;
        int i7 = (-862048943) * i5;
        int i8 = i7 ^ (i7 << 16);
        int i9 = i8 & 127;
        int i10 = this.f1318c;
        int i11 = (i8 >>> 7) & i10;
        int i12 = 0;
        loop0: while (true) {
            long[] jArr = this.f1316a;
            int i13 = i11 >> 3;
            int i14 = (i11 & 7) << 3;
            long j5 = ((jArr[i13 + 1] << (64 - i14)) & ((-i14) >> 63)) | (jArr[i13] >>> i14);
            long j6 = (i9 * 72340172838076673L) ^ j5;
            long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L);
            while (true) {
                if (j7 == 0) {
                    break;
                }
                i6 = ((Long.numberOfTrailingZeros(j7) >> 3) + i11) & i10;
                if (this.f1317b[i6] == i5) {
                    break loop0;
                }
                j7 &= j7 - 1;
            }
            i12 += 8;
            i11 = (i11 + i12) & i10;
        }
        return i6 >= 0;
    }

    public final int b() {
        return this.f1318c;
    }

    public final boolean c() {
        return this.f1319d != 0;
    }

    public final String d(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4) {
        Intrinsics.h(charSequence, "separator");
        Intrinsics.h(charSequence2, "prefix");
        Intrinsics.h(charSequence3, "postfix");
        Intrinsics.h(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        int[] iArr = this.f1317b;
        long[] jArr = this.f1316a;
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
                            int i11 = iArr[(i6 << 3) + i10];
                            if (i7 == i5) {
                                sb.append(charSequence4);
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(charSequence);
                            }
                            sb.append(i11);
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
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (qVar.f1319d != this.f1319d) {
            return false;
        }
        int[] iArr = this.f1317b;
        long[] jArr = this.f1316a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128 && !qVar.a(iArr[(i5 << 3) + i7])) {
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
        int[] iArr = this.f1317b;
        long[] jArr = this.f1316a;
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
                            i7 += iArr[(i6 << 3) + i9];
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
        return e(this, null, "[", "]", 0, null, 25, null);
    }
}
