package androidx.collection;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1346a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f1347b;

    /* renamed from: c, reason: collision with root package name */
    public int f1348c;

    /* renamed from: d, reason: collision with root package name */
    public int f1349d;

    private v() {
        this.f1346a = v0.f1350a;
        this.f1347b = w.a();
    }

    public /* synthetic */ v(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ String d(v vVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
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
        return vVar.c(charSequence, charSequence5, charSequence6, i7, charSequence4);
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
    public final boolean a(long j5) {
        int i5;
        int a5 = s.a(j5) * (-862048943);
        int i6 = a5 ^ (a5 << 16);
        int i7 = i6 & 127;
        int i8 = this.f1348c;
        int i9 = (i6 >>> 7) & i8;
        int i10 = 0;
        loop0: while (true) {
            long[] jArr = this.f1346a;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j6 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j7 = (i7 * 72340172838076673L) ^ j6;
            long j8 = (~j7) & (j7 - 72340172838076673L) & (-9187201950435737472L);
            while (true) {
                if (j8 == 0) {
                    break;
                }
                i5 = ((Long.numberOfTrailingZeros(j8) >> 3) + i9) & i8;
                if (this.f1347b[i5] == j5) {
                    break loop0;
                }
                j8 &= j8 - 1;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
        }
        return i5 >= 0;
    }

    public final int b() {
        return this.f1348c;
    }

    public final String c(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4) {
        int i6;
        int i7;
        Intrinsics.h(charSequence, "separator");
        Intrinsics.h(charSequence2, "prefix");
        Intrinsics.h(charSequence3, "postfix");
        Intrinsics.h(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.f1347b;
        long[] jArr2 = this.f1346a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i8 = 0;
            int i9 = 0;
            loop0: while (true) {
                long j5 = jArr2[i8];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8;
                    int i11 = 8 - ((~(i8 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((j5 & 255) < 128) {
                            i7 = i8;
                            long j6 = jArr[(i8 << 3) + i12];
                            if (i9 == i5) {
                                sb.append(charSequence4);
                                break loop0;
                            }
                            if (i9 != 0) {
                                sb.append(charSequence);
                            }
                            sb.append(j6);
                            i9++;
                        } else {
                            i7 = i8;
                        }
                        j5 >>= 8;
                        i12++;
                        i10 = 8;
                        i8 = i7;
                    }
                    int i13 = i8;
                    if (i11 != i10) {
                        break;
                    }
                    i6 = i13;
                } else {
                    i6 = i8;
                }
                if (i6 == length) {
                    break;
                }
                i8 = i6 + 1;
            }
        }
        sb.append(charSequence3);
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (vVar.f1349d != this.f1349d) {
            return false;
        }
        long[] jArr = this.f1347b;
        long[] jArr2 = this.f1346a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr2[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128 && !vVar.a(jArr[(i5 << 3) + i7])) {
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
        long[] jArr = this.f1347b;
        long[] jArr2 = this.f1346a;
        int length = jArr2.length - 2;
        int i5 = 0;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            while (true) {
                long j5 = jArr2[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((255 & j5) < 128) {
                            i7 += s.a(jArr[(i6 << 3) + i9]);
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
