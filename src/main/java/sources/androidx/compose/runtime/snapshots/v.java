package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.h3;
import kotlin.collections.ArraysKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private int f3023a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f3024b = new int[16];

    /* renamed from: c, reason: collision with root package name */
    private h3[] f3025c = new h3[16];

    private final int b(Object obj, int i5) {
        int i6 = this.f3023a - 1;
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) >>> 1;
            int i9 = this.f3024b[i8];
            if (i9 < i5) {
                i7 = i8 + 1;
            } else {
                if (i9 <= i5) {
                    h3 h3Var = this.f3025c[i8];
                    return obj == (h3Var != null ? h3Var.get() : null) ? i8 : c(i8, obj, i5);
                }
                i6 = i8 - 1;
            }
        }
        return -(i7 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:
    
        return -(r4 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int c(int i5, Object obj, int i6) {
        int i7 = i5 - 1;
        while (true) {
            if (-1 >= i7 || this.f3024b[i7] != i6) {
                break;
            }
            h3 h3Var = this.f3025c[i7];
            if ((h3Var != null ? h3Var.get() : null) == obj) {
                return i7;
            }
            i7--;
        }
        int i8 = i5 + 1;
        int i9 = this.f3023a;
        while (true) {
            if (i8 >= i9) {
                i8 = this.f3023a;
                break;
            }
            if (this.f3024b[i8] != i6) {
                break;
            }
            h3 h3Var2 = this.f3025c[i8];
            if ((h3Var2 != null ? h3Var2.get() : null) == obj) {
                return i8;
            }
            i8++;
        }
    }

    public final boolean a(Object obj) {
        int i5;
        int i6 = this.f3023a;
        int c5 = androidx.compose.runtime.b.c(obj);
        if (i6 > 0) {
            i5 = b(obj, c5);
            if (i5 >= 0) {
                return false;
            }
        } else {
            i5 = -1;
        }
        int i7 = -(i5 + 1);
        h3[] h3VarArr = this.f3025c;
        int length = h3VarArr.length;
        if (i6 == length) {
            int i8 = length * 2;
            h3[] h3VarArr2 = new h3[i8];
            int[] iArr = new int[i8];
            int i9 = i7 + 1;
            ArraysKt.l(h3VarArr, h3VarArr2, i9, i7, i6);
            ArraysKt.p(this.f3025c, h3VarArr2, 0, 0, i7, 6, (Object) null);
            ArraysKt.j(this.f3024b, iArr, i9, i7, i6);
            ArraysKt.o(this.f3024b, iArr, 0, 0, i7, 6, (Object) null);
            this.f3025c = h3VarArr2;
            this.f3024b = iArr;
        } else {
            int i10 = i7 + 1;
            ArraysKt.l(h3VarArr, h3VarArr, i10, i7, i6);
            int[] iArr2 = this.f3024b;
            ArraysKt.j(iArr2, iArr2, i10, i7, i6);
        }
        this.f3025c[i7] = new h3(obj);
        this.f3024b[i7] = c5;
        this.f3023a++;
        return true;
    }

    public final int[] d() {
        return this.f3024b;
    }

    public final int e() {
        return this.f3023a;
    }

    public final h3[] f() {
        return this.f3025c;
    }

    public final void g(int i5) {
        this.f3023a = i5;
    }
}
