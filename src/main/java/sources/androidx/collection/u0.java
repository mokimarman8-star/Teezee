package androidx.collection;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class u0 {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1341a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1342b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f1343c;

    /* renamed from: d, reason: collision with root package name */
    public int f1344d;

    /* renamed from: e, reason: collision with root package name */
    public int f1345e;

    private u0() {
        this.f1341a = v0.f1350a;
        Object[] objArr = n.a.f16551c;
        this.f1342b = objArr;
        this.f1343c = objArr;
    }

    public /* synthetic */ u0(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Object obj) {
        int i5;
        int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i6 = hashCode ^ (hashCode << 16);
        int i7 = i6 & 127;
        int i8 = this.f1344d;
        int i9 = (i6 >>> 7) & i8;
        int i10 = 0;
        loop0: while (true) {
            long[] jArr = this.f1341a;
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
                if (Intrinsics.c(this.f1342b[i5], obj)) {
                    break loop0;
                }
                j7 &= j7 - 1;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
        }
        return i5 >= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(Object obj) {
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
            return this.f1343c[i5];
        }
        return null;
    }

    public final int c() {
        return this.f1344d;
    }

    public final int d() {
        return this.f1345e;
    }

    public final boolean e() {
        return this.f1345e == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        if (u0Var.d() != d()) {
            return false;
        }
        Object[] objArr = this.f1342b;
        Object[] objArr2 = this.f1343c;
        long[] jArr = this.f1341a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            loop0: while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            int i8 = (i5 << 3) + i7;
                            Object obj2 = objArr[i8];
                            Object obj3 = objArr2[i8];
                            if (obj3 == null) {
                                if (u0Var.b(obj2) != null || !u0Var.a(obj2)) {
                                    break loop0;
                                }
                            } else if (!Intrinsics.c(obj3, u0Var.b(obj2))) {
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
            return false;
        }
        return true;
    }

    public final boolean f() {
        return this.f1345e != 0;
    }

    public int hashCode() {
        Object[] objArr = this.f1342b;
        Object[] objArr2 = this.f1343c;
        long[] jArr = this.f1341a;
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
                            Object obj2 = objArr2[i10];
                            i7 += (obj2 != null ? obj2.hashCode() : 0) ^ (obj != null ? obj.hashCode() : 0);
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
        if (e()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Object[] objArr = this.f1342b;
        Object[] objArr2 = this.f1343c;
        long[] jArr = this.f1341a;
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
                            Object obj2 = objArr2[i9];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append("=");
                            if (obj2 == this) {
                                obj2 = "(this)";
                            }
                            sb.append(obj2);
                            i6++;
                            if (i6 < this.f1345e) {
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
